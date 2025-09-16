# TRULY Synching Login Expiration Time to AD - Cool Solutions | NetIQ

## TRULY Synching Login Expiration Time to AD

### Synchronizing Novell “Login Expiration Time” with Microsoft Active Directory “accountExpires”.

On the surface this seemed simple. The attribute is mapped in the default driver and after a few minutes of configuration I had thedriver working so that when I set a Login Expiration Time in EDirectory, it immediately synchronized to AD. … More or Less.

### FIRST CAVEATS:

**No HH:MM:SS in Microsoft.**

In Novell’s E-Directory, when you set a “Login Expiration Time” it consists of Year, Month, Day, Hours, Minutes and seconds. When it makes it to the AD system, it is set as “Account Expires at End of:” Year, Month Day.

**End of Day PRIOR to what you set in E-Directory:**
That’s right, if you set a user’s account Login to expire at 12:43 p.m. on September 17, 2010, it will show up in Microsoft as “Account Expires End of September 16.

So beware of this. You can either “deal with it” or you can add 86400 to the value being sent into AD, advancing the “End of ” time by 24 hours. (86400 is the number of seconds in a day, and Novell’s time syntax is formulated in “Seconds since January 1, 1970.)

### SECOND CAVEAT: ADD, MODIFY… but Not REMOVE???

I was in hog heaven, right? No. I shortly was notified that when people were being reactivated, (i.e. their login expiration time was cleared in the vault) the expiration time was not being cleared in AD.

Removal of a Login Expiration Time in EDirectory crosses the driver like this:

<nds dtdversion="3.5" ndsversion="8.x">
  <source>
    <product version="3.5.13.20090903 ">DirXML</product>
    <contact>Novell, Inc.</contact>
  </source>
  <input>
    <modify cached-time="20091228151945.022Z" class-name="User" event-id="IDV-02-DS#20091228151945#1#1" qualified-src-dn="O=data\\OU=usr\\OU=edu\\CN=1234e8" src-dn="\\CUSTOMER\\data\\usr\\edu\\1234e8" src-entry-id="261785" timestamp="0#0">
      <association state="associated">e5b8a6ad8bdc874cbf5df5a570606780</association>
      <modify-attr attr-name="Login Expiration Time">
        <remove-value>
          <value timestamp="1262012227#2" type="time">1262224500</value>
        </remove-value>
      </modify-attr>
    </modify>
  </input>
</nds>

A Modify event, with “remove value” for the attribute. That would seem sufficient, right? Not when the AD Attribute (accountExpires) does not allow being set to null. It needs to be set to a value that will equal “Account Never Expires.” A simple LDIFDE comparison of two objects in AD showed that a user with an “accountExpires” that is set has some long string value, while one that “never expires” has a “0” (zero) value.

Great… so I modify my SUBSCRIBER Command Transform to include the following rule:

	<rule>
		<description>Expiration Being Removed: Set value to 0</description>
		<conditions>
			<and>
				<if-operation mode="case" op="equal">modify</if-operation>
				<if-class-name mode="nocase" op="equal">User</if-class-name>
				<if-op-attr name="Login Expiration Time" op="changing"/>
			</and>
		</conditions>
		<actions>
			<do-for-each>
				<arg-node-set>
					<token-removed-attr name="Login Expiration Time"/>
				</arg-node-set>
				<arg-actions>
					<do-set-dest-attr-value direct="true" name="Login Expiration Time">
						<arg-value>
							<token-text xml:space="preserve">9223372036854775807</token-text>
						</arg-value>
					</do-set-dest-attr-value>
				</arg-actions>
			</do-for-each>
		</actions>
	</rule>

	

Notice a couple of things: First, the driver can detect the Op-Attr “changing” but it would not detect this event as having an operation attribute of a specific value, so I first test for the change, and then embed for/each loop in the actions.

For each removed attribute, I set the Destination value to Zero. If you look closely, however, you’ll see that the value I set is not ZERO, but 9223372036854775807.
I tried “0” but, since Novell has an output transform rule that converts all Login Expiration Times to Microsoft AD Format, that had the effect of simply CHANGING the accountExpires date to December 31, 1969.

So I looked up what value Microsoft considered equal to “Account Never Expires” and found the above value. Great!! Sent it through, and the accouneExpires time changed to February 7, 2106. Effectively I had removed the expiration time, but this was not elegant. No matter what value I send through, it will be considered some number of seconds since January 1970, and it is converted by the Output Transform rule for “accountExpires” values.

### THE FINAL STEP:

So, it became clear I had to bypass the “standard” Novell Output Transform as it relates to Account Expires…. Or at least as it handles values that I WANT to be sent through “as is” to Microsoft. So, I modified the standard Novell rule, which has no conditions and 1 action, to the following.

	<rule>
		<description>accountExpires: Convert to Active Directory form</description>
		<comment xml:space="preserve">This rule is modified from Novell standard rules, to function hand in hand with a Subscriber Command Transform rule that sets the "Login Expiration Time" value to a Microsoft recognized number equaling "never".  When the "Login Expiration Time" operation Attribute is set to that number, this rule (sub Output Transform) allows the value to pass through directly without time conversion.</comment>
		<conditions>
			<and>
				<if-op-attr mode="nocase" name="accountExpires" op="not-equal">9223372036854775807</if-op-attr>
			</and>
		</conditions>
		<actions>
			<do-reformat-op-attr name="accountExpires">
				<arg-value type="octet">
					<token-xpath expression="jadutil:translateEpoch2FileTime($current-value)"/>
				</arg-value>
			</do-reformat-op-attr>
		</actions>
	</rule>
	
	

With that, the system functions as expected. Adding/modifying a Login Expiration Time results in immediate synchronization to AD. Removing the value in E-Directory removes the value in AD and resets the account to “Account Never Expires.”

### RECAP:

1. Add login Expiration Time to the driver filter for users, and establish the synchronization you desire.

* If uncomfortable with the expiration date being set one day in the past in AD, Add a Command Transform to add 86400 seconds to the value Novell sends to AD.
* Add a Command Transform that detects the REMOVAL of login Expiration time, and set destination attribute to the “Microsoft Approved” default of 9223372036854775807.
* Modify the Novell provided Output Transform rule for “accountExpires” so that if/when the value above is sent through, the time conversion is circumvented and the value is set directly in Active Directory.
* COMMENT what you’re doing in your rules, so that future generations can decipher how you achieved the marvelous results.

![[./_resources/TRULY_Synching_Login_Expiration_Time_to_AD_-_Cool_Solutions__NetIQ.resources/rating_off.gif]]![[./_resources/TRULY_Synching_Login_Expiration_Time_to_AD_-_Cool_Solutions__NetIQ.resources/rating_off.gif]]![[./_resources/TRULY_Synching_Login_Expiration_Time_to_AD_-_Cool_Solutions__NetIQ.resources/rating_off.gif]]![[./_resources/TRULY_Synching_Login_Expiration_Time_to_AD_-_Cool_Solutions__NetIQ.resources/rating_off.gif]]![[./_resources/TRULY_Synching_Login_Expiration_Time_to_AD_-_Cool_Solutions__NetIQ.resources/rating_off.gif]] (_**0** votes, average: **0.00** out of 5_)
_You need to be a registered member to rate this post._

Tags: [Identity Manager](https://www.netiq.com/communities/cool-solutions/tag/identity-manager/), [Migrating from Windows XP or 2003 to SUSE Linux](https://www.netiq.com/communities/cool-solutions/tag/migrating_from_windows_xp_or_2003_to_suse_linux/)
Categories: [Uncategorized](https://www.netiq.com/communities/cool-solutions/category/uncategorized/)

* [____](https://www.netiq.com/communities/cool-solutions/truly-synching-login-expiration-time-ad/#)

* [____](https://www.netiq.com/communities/cool-solutions/truly-synching-login-expiration-time-ad/#)
* [____](https://www.netiq.com/communities/cool-solutions/truly-synching-login-expiration-time-ad/#)
* [____](https://www.netiq.com/communities/cool-solutions/truly-synching-login-expiration-time-ad/#)
* [____](https://www.netiq.com/communities/cool-solutions/truly-synching-login-expiration-time-ad/#)
* [0 ](https://www.netiq.com/communities/cool-solutions/truly-synching-login-expiration-time-ad/#comments)

* * *

_

_**Disclaimer:** As with everything else at NetIQ Cool Solutions, this content is definitely not supported by NetIQ, so Customer Support will not be able to help you if it has any adverse effect on your environment.  It just worked for at least one person, and perhaps it will be useful for you too.  Be sure to test in a non-production environment._

_

### Leave a Reply

You must be [logged in](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Ftruly-synching-login-expiration-time-ad%2F) to post a comment.

#### Leave a Comment

	![[./_resources/TRULY_Synching_Login_Expiration_Time_to_AD_-_Cool_Solutions__NetIQ.resources/-s=32&d=identicon&r=g.png]] ccikara says:
	[July 13, 2010 at 3:27 am](https://www.netiq.com/communities/cool-solutions/truly-synching-login-expiration-time-ad/#comment-8227)
	
	Thanks for this!!
	Should help us out at the client as they want the account to expire on the day it is set to in eDir but at 17:00
	So I guess instead of adding “86400” seconds I will add “61200”…
	Cheers!
	
	[Log in to Reply](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Ftruly-synching-login-expiration-time-ad%2F)
		![[./_resources/TRULY_Synching_Login_Expiration_Time_to_AD_-_Cool_Solutions__NetIQ.resources/-s=32&d=identicon&r=g.png]] folboteur says:
		[August 30, 2011 at 11:41 am](https://www.netiq.com/communities/cool-solutions/truly-synching-login-expiration-time-ad/#comment-9759)
		
		Hi… If something I wrote does not work, or is factually wrong, please let me know.
		
		I’m not sure exactly what you corrected. You confirm that setting accountExpires to 0 is a goal, but as I noted, if you try to do that IN THE NOVELL-AD IDM DRIVER, without bypassing the Novell transformations, the zero is converted to a value equivalent to some date in 2106.
		
		It doesn’t map directly. That’s the whole reason I wrote this doc.
		
		If you have a more elegant way of synching the changes, through a Novell IDM Driver (not an LDAP tool, or Microsoft Admin Console), I’d welcome them as much as the next guy!
		
		Thanks for the feedback,
		Rob
		
		[Log in to Reply](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Ftruly-synching-login-expiration-time-ad%2F)
		

	![[./_resources/TRULY_Synching_Login_Expiration_Time_to_AD_-_Cool_Solutions__NetIQ.resources/-s=32&d=identicon&r=g.png]] jwcombs says:
	[September 23, 2011 at 12:32 pm](https://www.netiq.com/communities/cool-solutions/truly-synching-login-expiration-time-ad/#comment-9825)
	
	The timestamp syntax is defined so that 0 = midnight Dec 31 1969/ Jan 1st 1970. What your seeing is a value of 0 in AD being allowed to flow into the vault. You need to check for a value of 0 and transform it into whatever you want in the vault.
	
	[Log in to Reply](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Ftruly-synching-login-expiration-time-ad%2F)
	

	![[./_resources/TRULY_Synching_Login_Expiration_Time_to_AD_-_Cool_Solutions__NetIQ.resources/-s=32&d=identicon&r=g.png]] ambradley says:
	[May 10, 2012 at 5:22 pm](https://www.netiq.com/communities/cool-solutions/truly-synching-login-expiration-time-ad/#comment-10365)
	
	I just ran into a situation where the value coming from AD was 159394408950000000, which was converted by IDM to 4294967294, which equals – you guessed it – December 31, 1969. I created another rule to strip out the post-conversion value of 4294967294 and placed it immediately after the existing “accountExpires: Convert to Identity Vault time format” rule.
	
	[Log in to Reply](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Ftruly-synching-login-expiration-time-ad%2F)
	

![[./_resources/TRULY_Synching_Login_Expiration_Time_to_AD_-_Cool_Solutions__NetIQ.resources/unknown_filename.jpeg]]
By: [Robert Schneider](https://www.netiq.com/communities/cool-solutions/author/folboteur/)
![[./_resources/TRULY_Synching_Login_Expiration_Time_to_AD_-_Cool_Solutions__NetIQ.resources/unknown_filename.1.png]]

January 5, 2010
11:16 am

Reads:
4,336
Score:
Unrated

[![[./_resources/TRULY_Synching_Login_Expiration_Time_to_AD_-_Cool_Solutions__NetIQ.resources/pf-print-icon.gif]]Print ![[./_resources/TRULY_Synching_Login_Expiration_Time_to_AD_-_Cool_Solutions__NetIQ.resources/pf-pdf-icon.gif]]PDF](https://www.netiq.com/communities/cool-solutions/truly-synching-login-expiration-time-ad/#)
