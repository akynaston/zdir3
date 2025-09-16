# LDAP - AD codes: Sub-Error Codes for LDAP Error 49 - Cool Solutions | NetIQ

## Sub-Error Codes for LDAP Error 49

### Problem

When using the Active Directory Driver with Novell Identity Manager, you may sometimes see an LDAP error 49 in your DSTrace. This means the account credentails could not log in correctly.

### Solution

Here are the error codes you might see along with error 49, and their definitions:

* 525 – user not found

* 52e – invalid credentials
* 530 – not permitted to logon at this time
* 531 – workstation restriction
* 532 – password expired
* 533 – account disabled
* 568 – too many contexts ids (too many group memberships)
* 701 – account expired
* 773 – user must reset password
* 775 – user is intruder locked

It’s useful to know what to do next to resolve the problem. For a 525 error, you probably have the Bind DN wrong. Remember that in AD, the default Users container on a fresh install is an odd object class, whose naming attribute is actually cn=Users(,dc=acme,dc=com) instead of what you might be expecting (such as ou=Users,dc=acme,dc=com).

If you see a 52e, it means you sent the wrong password. And so on and so forth.

You will often see a “sub-error” code that may be quite informative.

![[./_resources/LDAP_-_AD_codes_Sub-Error_Codes_for_LDAP_Error_49_-_Cool_Solutions__NetIQ.resources/rating_on.gif]]![[./_resources/LDAP_-_AD_codes_Sub-Error_Codes_for_LDAP_Error_49_-_Cool_Solutions__NetIQ.resources/rating_on.gif]]![[./_resources/LDAP_-_AD_codes_Sub-Error_Codes_for_LDAP_Error_49_-_Cool_Solutions__NetIQ.resources/rating_on.gif]]![[./_resources/LDAP_-_AD_codes_Sub-Error_Codes_for_LDAP_Error_49_-_Cool_Solutions__NetIQ.resources/rating_on.gif]]![[./_resources/LDAP_-_AD_codes_Sub-Error_Codes_for_LDAP_Error_49_-_Cool_Solutions__NetIQ.resources/rating_on.gif]] (_**1** votes, average: **5.00** out of 5_)
_You need to be a registered member to rate this post._

Tags: [Active Directory](https://www.netiq.com/communities/cool-solutions/tag/active_directory/), [Drivers](https://www.netiq.com/communities/cool-solutions/tag/drivers/), [Dstrace](https://www.netiq.com/communities/cool-solutions/tag/dstrace/), [Errors](https://www.netiq.com/communities/cool-solutions/tag/errors/), [LDAP](https://www.netiq.com/communities/cool-solutions/tag/ldap/), [Troubleshooting](https://www.netiq.com/communities/cool-solutions/tag/troubleshooting/)
Categories: [Identity Manager](https://www.netiq.com/communities/cool-solutions/category/identity-manager/), [Technical Solutions](https://www.netiq.com/communities/cool-solutions/category/technical-solutions/)

* [____](https://www.netiq.com/communities/cool-solutions/sub-error-codes-ldap-error-49/#)

* [____](https://www.netiq.com/communities/cool-solutions/sub-error-codes-ldap-error-49/#)
* [____](https://www.netiq.com/communities/cool-solutions/sub-error-codes-ldap-error-49/#)
* [____](https://www.netiq.com/communities/cool-solutions/sub-error-codes-ldap-error-49/#)
* [____](https://www.netiq.com/communities/cool-solutions/sub-error-codes-ldap-error-49/#)
* [0 ](https://www.netiq.com/communities/cool-solutions/sub-error-codes-ldap-error-49/#comments)

* * *

_

_**Disclaimer:** As with everything else at NetIQ Cool Solutions, this content is definitely not supported by NetIQ, so Customer Support will not be able to help you if it has any adverse effect on your environment.  It just worked for at least one person, and perhaps it will be useful for you too.  Be sure to test in a non-production environment._

_

### Leave a Reply

You must be [logged in](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fsub-error-codes-ldap-error-49%2F) to post a comment.

#### Leave a Comment

	![[./_resources/LDAP_-_AD_codes_Sub-Error_Codes_for_LDAP_Error_49_-_Cool_Solutions__NetIQ.resources/-s=64&d=identicon&r=g.png]] IMsyncUnit says:
	[April 29, 2010 at 9:16 am](https://www.netiq.com/communities/cool-solutions/sub-error-codes-ldap-error-49/#comment-7890)
	
	531 – workstation restriction
	
	[Log in to Reply](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fsub-error-codes-ldap-error-49%2F)
	
	![[./_resources/LDAP_-_AD_codes_Sub-Error_Codes_for_LDAP_Error_49_-_Cool_Solutions__NetIQ.resources/-s=64&d=identicon&r=g.png]] geoffc says:
	[April 29, 2010 at 11:12 am](https://www.netiq.com/communities/cool-solutions/sub-error-codes-ldap-error-49/#comment-7891)
	
	Thanks! Thats a good one! Got any more? Will update the article.
	
	[Log in to Reply](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fsub-error-codes-ldap-error-49%2F)
	

![[./_resources/LDAP_-_AD_codes_Sub-Error_Codes_for_LDAP_Error_49_-_Cool_Solutions__NetIQ.resources/unknown_filename.1.png]]
By: [geoffc](https://www.netiq.com/communities/cool-solutions/author/geoffc/)
![[./_resources/LDAP_-_AD_codes_Sub-Error_Codes_for_LDAP_Error_49_-_Cool_Solutions__NetIQ.resources/unknown_filename.png]]

January 24, 2007
3:07 am

Reads:
7,316
Score:
5

[![[./_resources/LDAP_-_AD_codes_Sub-Error_Codes_for_LDAP_Error_49_-_Cool_Solutions__NetIQ.resources/pf-print-icon.gif]]Print ![[./_resources/LDAP_-_AD_codes_Sub-Error_Codes_for_LDAP_Error_49_-_Cool_Solutions__NetIQ.resources/pf-pdf-icon.gif]]PDF](https://www.netiq.com/communities/cool-solutions/sub-error-codes-ldap-error-49/#)
