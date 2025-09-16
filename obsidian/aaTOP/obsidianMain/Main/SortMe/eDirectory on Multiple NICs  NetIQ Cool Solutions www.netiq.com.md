# eDirectory on Multiple NICs | NetIQ Cool Solutions [www.netiq.com]

[NetIQ](https://www.netiq.com/)

Search

* [Login](https://www.netiq.com/f/mynetiq/login.asp)

* [United States, English](https://www.netiq.com/common/util/langselect.php?referer=https%3A//www.netiq.com/communities/cool-solutions/edirectory-multiple-nics/)

* [Solutions](https://www.netiq.com/solutions-industries/)

* [Products](https://www.netiq.com/products/)
* [Industries](https://www.netiq.com/solutions-industries/#industries)
* [About Us](https://www.netiq.com/company/)
* [Services & Support](https://www.netiq.com/services/)
* [Partners](https://www.partnernetprogram.com/)
* [Communities](https://www.netiq.com/communities/)

[Close](https://www.netiq.com/communities/cool-solutions/edirectory-multiple-nics/#)

[_Let's Talk_](https://www.netiq.com/company/contact/)

[Close](https://www.netiq.com/communities/cool-solutions/edirectory-multiple-nics/#)

## [NetIQ Cool Solutions](https://www.netiq.com/communities/cool-solutions)

* [Cool Solutions](http://www.netiq.com/communities/cool-solutions/)

* [AppManager](https://www.netiq.com/communities/cool-solutions/category/appmanager/)

* [Identity Manager](https://www.netiq.com/communities/cool-solutions/category/identity-manager/)
* [Operations Center](https://www.netiq.com/communities/cool-solutions/category/operations-center/)
* [PlateSpin](https://www.netiq.com/communities/cool-solutions/category/platespin/)
* [Privileged User Manager](https://www.netiq.com/communities/cool-solutions/category/privileged-user-manager/)
* [SecureLogin](https://www.netiq.com/communities/cool-solutions/category/securelogin/)
* [Cool Tools](https://www.netiq.com/communities/cool-solutions/category/cool-tools/)
* [Products A-Z](https://www.netiq.com/communities/cool-solutions/products-a-z/)
* [Cool Tools](https://www.netiq.com/communities/cool-solutions/cool_tools)
	* [Terms and Conditions](https://www.netiq.com/communities/cool-solutions/about-us/terms-and-conditions/)
	* [Usage Guidelines](https://www.netiq.com/communities/cool-solutions/about-us/usage-guidelines/)
	* [Contact Us](https://www.netiq.com/communities/cool-solutions/about-us/contact-us/)
	* [How to Create and Submit Content](https://www.netiq.com/communities/cool-solutions/about-us/how-to-create-and-submit-content/)
	* [NetIQ Rewards Program](https://www.netiq.com/communities/cool-solutions/about-us/netiq-rewards-program/)

* [Data Center Solutions](https://www.netiq.com/communities/data-center-solutions/)

* [Security Web](https://www.netiq.com/communities/security-web)
* [Support Forums](https://forums.netiq.com/)

## eDirectory on Multiple NICs

![[./_resources/eDirectory_on_Multiple_NICs__NetIQ_Cool_Solutions_www.netiq.com.resources/3ab292432d5211685c3595b186d2121b.png]]
By: [smamatha](https://www.netiq.com/communities/cool-solutions/author/smamatha/)

April 21, 2010 5:27 pm

Reads:**425**

Comments:**3**

Score:**1**

[![[./_resources/eDirectory_on_Multiple_NICs__NetIQ_Cool_Solutions_www.netiq.com.resources/pf-print-icon.gif]]Print ![[./_resources/eDirectory_on_Multiple_NICs__NetIQ_Cool_Solutions_www.netiq.com.resources/pf-pdf-icon.gif]]PDF](http://www.printfriendly.com/print?url=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fedirectory-multiple-nics%2F)

**Problem:** How do I bind eDirectory to the new IP address on the new card added (second NIC added after the eDirectory configuration).

There might be deployments where initially eDirectory is configured on a server with a single NIC. Later, if another NIC is added to it, how do we ensure that eDirectory is bounded by this new IP address as well, along with the existing IP address. One way is to make multiple instances with custom ports and the second NIC. In such a case, the administrator has to manage multiple trees.

**Solution:** One can associate the same instance of eDirectory to multiple IP addresses using the following the steps.

1. Set the ncp port to the new ip address along with the existing.
	Example: ndsconfig set n4u.server.interfaces=164.99.156.15@524,164.99.156.14@524

* Set the http port to the new ip address along with the existing.
	Example: ndsconfig set n4u.server.interfaces=164.99.156.15@8028,164.99.156.14@8028
* Set the https port to the new ip address along with the existing.
	Example: ndsconfig set n4u.server.interfaces=164.99.156.15@8030,164.99.156.14@8030

In the above example, 164.99.156.15 is the first NIC with which eDirectory is initially configured and 164.99.156.14 is the NIC that is added later.

**Note:** There is no need to set the TCP-389/TLS-636 ports because by default it listens on all. The above can also be done by editing the values of nds.conf. One has to restart eDirectory using /etc/init.d/ndsd restart to make the above changes of associating the instance with the IP addresses take effect.

![[./_resources/eDirectory_on_Multiple_NICs__NetIQ_Cool_Solutions_www.netiq.com.resources/rating_on.gif]]![[./_resources/eDirectory_on_Multiple_NICs__NetIQ_Cool_Solutions_www.netiq.com.resources/rating_off.gif]]![[./_resources/eDirectory_on_Multiple_NICs__NetIQ_Cool_Solutions_www.netiq.com.resources/rating_off.gif]]![[./_resources/eDirectory_on_Multiple_NICs__NetIQ_Cool_Solutions_www.netiq.com.resources/rating_off.gif]]![[./_resources/eDirectory_on_Multiple_NICs__NetIQ_Cool_Solutions_www.netiq.com.resources/rating_off.gif]] (_**1** votes, average: **1.00** out of 5_)
_You need to be a registered member to rate this post._

Tags: [NIC](https://www.netiq.com/communities/cool-solutions/tag/nic/)
Categories: [eDirectory](https://www.netiq.com/communities/cool-solutions/category/edirectory/), [Technical Solutions](https://www.netiq.com/communities/cool-solutions/category/technical-solutions/)

[Share ![[./_resources/eDirectory_on_Multiple_NICs__NetIQ_Cool_Solutions_www.netiq.com.resources/unknown_filename.1.png]]](https://www.netiq.com/communities/cool-solutions/edirectory-multiple-nics/#) [Comment ![[./_resources/eDirectory_on_Multiple_NICs__NetIQ_Cool_Solutions_www.netiq.com.resources/unknown_filename.2.png]]](https://www.netiq.com/communities/cool-solutions/edirectory-multiple-nics/#comments) [3](https://www.netiq.com/communities/cool-solutions/edirectory-multiple-nics/#comments)

_**Disclaimer:** As with everything else at NetIQ Cool Solutions, this content is definitely not supported by NetIQ, so Customer Support will not be able to help you if it has any adverse effect on your environment.  It just worked for at least one person, and perhaps it will be useful for you too.  Be sure to test in a non-production environment._

#### 3 Comments

1. By:rkrishnan
	[April 21, 2010 10:15 pm](https://www.netiq.com/communities/cool-solutions/edirectory-multiple-nics/#comment-7857)
	
	Very helpful!
	
	[Log in to Reply](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fedirectory-multiple-nics%2F)
	
2. By:lhaeger
	[April 22, 2010 12:37 am](https://www.netiq.com/communities/cool-solutions/edirectory-multiple-nics/#comment-7858)
	
	Hey, you’ve got the ndsconfig parameters slightly wrong, should be three different ones instead of only n4u.server.interfaces over and over again:
	
	n4u.server.interfaces=164.99.156.15@524,164.99.156.14@524
	http.server.interfaces=164.99.156.15@8028,164.99.156.14@8028
	https.server.interfaces=164.99.156.15@8030,164.99.156.14@8030
	
	Anyway, I always change those parameters to
	
	n4u.server.interfaces=@524
	http.server.interfaces=@8028
	https.server.interfaces=@8030
	
	on my servers, so Edirectory listens on all available interfaces, even on dynamically added virtual ip addresses. Simply run “sed -i.bak ‘s/=..\*@/=@/g’ /path/to/nds.conf && rcndsd restart” as root…
	
	Some reason \*not\* to do that would be
	a) multiple edir instances on a single server (same ports, different ip addresses) or
	b) if you have to prevent Edirectory to bind to a specific interface
	
	Finally, there’s a similar parameter for the LDAP interface, check “ldapconfig get” for the current settings.
	
	[Log in to Reply](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fedirectory-multiple-nics%2F)
	
3. By:MARVHUFFAKER
	[April 7, 2014 12:15 pm](https://www.netiq.com/communities/cool-solutions/edirectory-multiple-nics/#comment-23600)
	
	You should fix the syntax in the original post. It is horribly inaccurate and worthless. Furthermore frustrating to realize it’s wrong after you’ve followed it, then have to troubleshoot and figure out the whole thing was wrong. The comments are helpful but nobody should have to rely on the comments when the original cool solutions article should suffice.
	
	[Log in to Reply](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fedirectory-multiple-nics%2F)
	

### Comment

You must be [logged in](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fedirectory-multiple-nics%2F) to post a comment.

[Top](https://www.netiq.com/communities/cool-solutions/edirectory-multiple-nics/#content)

Search for:

		### Recent Posts
	

		### Recent Comments
	
		### [![[./_resources/eDirectory_on_Multiple_NICs__NetIQ_Cool_Solutions_www.netiq.com.resources/unknown_filename.png]]](https://forums.netiq.com/external.php?type=RSS2) [Support Forums](https://forums.netiq.com/)
	
		### [![[./_resources/eDirectory_on_Multiple_NICs__NetIQ_Cool_Solutions_www.netiq.com.resources/unknown_filename.png]]](https://www.netiq.com/company/news/press/press_release_rss.php) [Press Releases](http://www.netiq.com/company/news/press/)
	
		### Categories
	

		### Popular Topics
	
	[Active Directory](https://www.netiq.com/communities/cool-solutions/tag/active_directory/) [AMD](https://www.netiq.com/communities/cool-solutions/tag/amd/) [Automation](https://www.netiq.com/communities/cool-solutions/tag/automation/) [Configuration](https://www.netiq.com/communities/cool-solutions/tag/configuration/) [Contact Management](https://www.netiq.com/communities/cool-solutions/tag/contact_management/) [Customizing](https://www.netiq.com/communities/cool-solutions/tag/customizing/) [DirXML](https://www.netiq.com/communities/cool-solutions/tag/dirxml/) [Drivers](https://www.netiq.com/communities/cool-solutions/tag/drivers/) [End User Management](https://www.netiq.com/communities/cool-solutions/tag/end-user-management/) [Identity Manager](https://www.netiq.com/communities/cool-solutions/tag/identity-manager/) [Importing-Exporting / ICE/ LDIF](https://www.netiq.com/communities/cool-solutions/tag/importing-exporting_/_ice/_ldif/) [Knowledge Depot](https://www.netiq.com/communities/cool-solutions/tag/knowledge-depot/) [LDAP](https://www.netiq.com/communities/cool-solutions/tag/ldap/) [Michele Hudnall](https://www.netiq.com/communities/cool-solutions/tag/michele-hudnall/) [Migrating from Windows XP or 2003 to SUSE Linux](https://www.netiq.com/communities/cool-solutions/tag/migrating_from_windows_xp_or_2003_to_suse_linux/) [Monitoring](https://www.netiq.com/communities/cool-solutions/tag/monitoring/) [NT](https://www.netiq.com/communities/cool-solutions/tag/nt/) [Open Enterprise Server](https://www.netiq.com/communities/cool-solutions/tag/open_enterprise_server/) [Passwords](https://www.netiq.com/communities/cool-solutions/tag/passwords/) [Reporting](https://www.netiq.com/communities/cool-solutions/tag/reporting/) [Secure Access](https://www.netiq.com/communities/cool-solutions/tag/secure_access/) [SecureLogin](https://www.netiq.com/communities/cool-solutions/tag/securelogin/) [Security](https://www.netiq.com/communities/cool-solutions/tag/security/) [Synchronization](https://www.netiq.com/communities/cool-solutions/tag/synchronization/) [Troubleshooting](https://www.netiq.com/communities/cool-solutions/tag/troubleshooting/)
	* [geoffc (23400)](https://www.netiq.com/communities/cool-solutions/author/geoffc)

* [ab (5160)](https://www.netiq.com/communities/cool-solutions/author/ab)
* [martincotter (4520)](https://www.netiq.com/communities/cool-solutions/author/martincotter)
* [tisenberg (3935)](https://www.netiq.com/communities/cool-solutions/author/tisenberg)
* [alexmchugh (2600)](https://www.netiq.com/communities/cool-solutions/author/alexmchugh)
* [cstumula (2575)](https://www.netiq.com/communities/cool-solutions/author/cstumula)
* [TSureshkumar (1425)](https://www.netiq.com/communities/cool-solutions/author/TSureshkumar)
* [pmckeith (1125)](https://www.netiq.com/communities/cool-solutions/author/pmckeith)
* [jrivard (1035)](https://www.netiq.com/communities/cool-solutions/author/jrivard)
* [ashishmrt (905)](https://www.netiq.com/communities/cool-solutions/author/ashishmrt)
		### Who's Online
	
	[17 members and 9 guests currently online](https://www.netiq.com/communities/cool-solutions/edirectory-multiple-nics/#)
	

Let's talk.

* [Request a Call](https://www.netiq.com/communities/cool-solutions/edirectory-multiple-nics/#)

* Sales: 1-888-323-6768

© 2014 NetIQ Corporation [Legal](https://www.netiq.com/company/legal/) [Privacy](https://www.netiq.com/company/legal/privacy/) [Feedback](https://www.netiq.com/common/inc/feedback_overlay.html?iframe=true)
