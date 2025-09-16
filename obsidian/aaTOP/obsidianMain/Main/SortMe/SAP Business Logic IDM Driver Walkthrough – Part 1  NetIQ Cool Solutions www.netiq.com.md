# SAP Business Logic IDM Driver Walkthrough – Part 1 | NetIQ Cool Solutions [www.netiq.com]

[NetIQ](https://www.netiq.com/)

Search

* [Login](https://www.netiq.com/f/mynetiq/login.asp)

* [United States, English](https://www.netiq.com/common/util/langselect.php?referer=https%3A//www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-1/)

* [Solutions](https://www.netiq.com/solutions-industries/)

* [Products](https://www.netiq.com/products/)
* [Industries](https://www.netiq.com/solutions-industries/#industries)
* [About Us](https://www.netiq.com/company/)
* [Services & Support](https://www.netiq.com/services/)
* [Partners](https://www.partnernetprogram.com/)
* [Communities](https://www.netiq.com/communities/)

[Close](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-1/#)

[_Let's Talk_](https://www.netiq.com/company/contact/)

[Close](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-1/#)

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

## SAP Business Logic IDM Driver Walkthrough – Part 1

![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_1__NetIQ_Cool_Solutions_www.netiq.com.resources/unknown_filename.1.png]]
By: [geoffc](https://www.netiq.com/communities/cool-solutions/author/geoffc/)

June 24, 2010 9:55 am

Reads:**472**

Comments:**0**

Score:**Unrated**

[![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_1__NetIQ_Cool_Solutions_www.netiq.com.resources/pf-print-icon.gif]]Print ![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_1__NetIQ_Cool_Solutions_www.netiq.com.resources/pf-pdf-icon.gif]]PDF](http://www.printfriendly.com/print?url=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fsap-business-logic-idm-driver-walkthrough-part-1%2F)

Novell Identity Manager has a number of prebuilt drivers available. There are two parts to any particular driver. There is the driver shim, the code that executes the actual commands on the target system, and then there is the driver configuration, which defines how Identity Manager will handle the data. There is very interesting divide between these two components.

Driver shims are usually compiled code and we do not get much influence upon them, with some notable exceptions. The Omnibond drivers for Mainframes, Midrange, Linux/Unix, and Scripting actually run a shim as a series of native scripts that are modifiable. However these are the exceptions not the rule.

The driver configuration is where the data from the shim (or Identity Vault) is processed and changes made as needed.

The shim can be the same between two configurations but the driver config can totally change the behavior and approach. The SAP Human Resources (HR) driver is a great example. There are two versions of this driver currently shipping. There is the standard version that is pretty much the same since Identity Manager 3.0 and it works at a pretty basic level. Then there is the SAP HR driver that is part of the Compliance Management Platform (CMP). You would not expect too great a difference between the two right? Well you could not be more wrong! The SAP HR driver in the CMP is a total re-write with a new approach and some really interesting ideas.

I walked through the SAP HR CMP driver in this series of articles:

* [The SAP Driver Family for IDM](http://www.novell.com/communities/node/9471/sap-driver-family-idm)

* [SAP HR CMP Integration Driver](http://www.novell.com/communities/node/9512/sap-hr-cmp-integration-driver)
* [SAP HR CMP Integration Driver Walkthrough – Part 1](http://www.novell.com/communities/node/9537/sap-hr-cmp-integration-driver-walkthough-part-1)
* [SAP HR CMP Integration Driver Walkthrough – Part 2](http://www.novell.com/communities/node/9547/sap-hr-cmp-integration-driver-walkthough-part-2)
* [SAP HR CMP Integration Driver Walkthrough – Part 3](http://www.novell.com/communities/node/9556/sap-hr-cmp-integration-driver-walkthough-part-3)
* [SAP HR CMP Integration Driver Walkthrough – Part 4](http://www.novell.com/communities/node/10001/sap-hr-cmp-integration-driver-walkthrough-part-4)
* [SAP HR CMP Integration Driver Walkthrough – Part 5](http://www.novell.com/communities/node/11274/sap-hr-cmp-integration-driver-walkthrough-part-5)
* [SAP HR CMP Integration Driver Walkthrough – Part 6](http://www.novell.com/communities/node/11313/sap-hr-cmp-integration-driver-walkthrough-part-6)
* [SAP HR CMP Integration Driver Walkthrough – Part 7](http://www.novell.com/communities/node/11481/sap-hr-cmp-integration-driver-walkthrough-part-7)
* [SAP HR CMP Integration Driver Walkthrough – Part 8](http://www.novell.com/communities/node/11517/sap-hr-cmp-integration-driver-walkthrough-part-8)
* [SAP HR CMP Integration Driver Walkthrough – Part 9](http://www.novell.com/communities/node/11519/sap-hr-cmp-integration-driver-walkthrough-part-9)

Yes, it really took 11 articles to get through all the details. Like I said, it is pretty darn interesting and complex. I learned a fair number of things walking through this driver, and I highly recommend the exercise to anyone who thinks they have mastered Identity Manager or is still just learning. I almost always learn a new trick or idea reading someone else’s work.

If you are looking for a simpler task (well at least in length and scope, but still complex and interesting) I highly recommend walking through the Password Notifier Driver ( [IDM 3.5 Password Notification Service Driver](http://www.novell.com/communities/node/2277/idm-35-password-notification-service-driver) ) by Lothar Haeger (<http://www.brummelhook.com/dirxml.html> ). I personally learned three really cool tricks from this driver and I am sure you will too.

If you are interested in working through a driver, and feel like writing down your notes, please do, submit it to Cool Solutions, and edit the Wiki page I started for Detailed Driver Walkthroughs ( http://wiki.novell.com/index.php/Detailed\_driver\_walk\_through\_collection ) where I am trying to collect explanations of how the various configurations work, and the subtleties of each driver.

With the SAP HR driver there are two primary flaws in the simple configuration that the CMP version is trying to resolve. They are future dated events, and the SAP Organizational structure.

Future dated events are really a problematic thing in SAP, when it comes to synchronizing events. Every event in SAP has a begin date (BEGDA) and end date (ENDDA) and are thus date delimited. Most anything you do to a user in SAP HR could have a time range. In fact, the history of events on the user is stored for some class of changes. For example there are a series of actions that can happen to a user. Like being transferred, hired, promoted, etc. These events obviously have beginning and ending time windows. Amusingly most SAP HR sites will use your birthday as the begin date for personal information like names, etc, since at some level, you acquired your name right around your birth. What that implies when they specify an explicit end date on those attributes you should be concerned that either they have a crystal ball, or else plan in WAY too much detail, and probably base their HR department in New Jersey! (Hey! I am living in New Jersey now, so I can mock! After the last set of corrupt mayors got arrested, we hope that they caught most of them,)

Here is a simple example of the complexity. You decide to hire John Smith on Feb 1, after interviewing him, and the HR folk enter his info on March 1, since at your company that is how long it takes to get anything done. But due to previous commitments John cannot start until April 1st.

So the HR people enter an event with a BEGDA (Begin Date) of April 1, but they click submit on that action on March 1st. So when do you create the user? March 1st or April 1st? Well clearly April 1st, since he does not start until then. Or maybe you want him to start getting access two weeks early. Then lets make this fun. He decides he can start 2 weeks early, so now you want to change that future dated event for April 1st, to the ides of March, but then alas, like Caesar he does not listen, and you find out he was injured and can no longer work, so you end up having to cancel the whole process.

That works out to 1 future dated event, that changes to be 2 weeks early, then gets canceled.

How do you handle that? Well the driver shim has two approaches. The first is to create a .FUTR iDOC file where the shim is running (It can run local or Remote Loader) that contains the future dated event which will be processed on its future due date. You can see how in the simple case of a single future dated event that does not change, this is a nice and elegant solution.

But when you have two changes after the future dated event is submitted, that does not work so well. There is no facility in the driver to look for such events and clear them, via policy, which would be needed to make this really work.

The default SAP HR configuration uses this approach, though the shim allows the second mode, but the configuration assumes this approach. Thus it does not handle this so well.

The second approach is to process all events as they come in via iDOCs and then in policy do something with them. That is, handle future dated events in policy, and delay them some how. In the Identity Manager world, Work Orders are the general mechanism for time delaying events. The SAP HR CMP driver takes this latter approach.

The second major issue with the SAP HR driver is Organizational Management. SAP HR can utilize another SAP module called OM for Organizational Management that allows all sorts of fun things in terms of reporting structures, management roles, and whatnot. There are Organizations, that have Positions hung off them, but are also shaped in a tree of Organizations. Each Position can potentially be a manager for that Organization, and then there are Jobs as well, which I do not really get the purpose of. The standard SAP HR driver works on the assumption you are using a simple Organizational structure, where basically the positions are linked together to form the structure, via a simple manager to direct reports structure.

Once your SAP folk start to go crazy, since the consultants show them this gee-gaw whiz bang thing they can do with their outrageously expensive SAP implementation (and they feel the need to justify why they spent all that money) they will probably try the more complex model first. To be fair, it is kind of fun so I cannot totally blame them.

Once you move out of the fairly simple use case the standard driver is not much help. For some more ideas and notions on this topic you can read:

* [SAP HR Driver and Organizational Management – Part 1](http://www.novell.com/communities/node/6351/sap-hr-driver-and-organizational-management-part-1)

The SAP HR CMP driver takes a new approach, and tries to handle the more complex relationship cases.

Both these issues seem like they are quite relevant to the SAP HR driver itself. Why am I talking about them in an article about the SAP Business Logic driver? Well it turns out that the functionality in the SAP HR CMP driver is split into two pieces. Since the standard method to time delay an event in Identity Manager is the use of Work Order objects, the SAP HR CMP driver uses Work Order objects to hold the future dated events, and then the SAP Business Logic driver is meant to process these events.

The Organizational model used in the shipping SAP HR driver is left to be user defined via Global Configuration Variables, and in the SAP HR CMP driver are hard coded (well in Policy, so it is easy to change if you wanted too) to reside in the context of the SAP Business Logic driver.

Novell Identity Manager extends the object schema in eDirectory so that Driver set objects exist that can contain Driver objects. There are usually two container objects (Subscriber and Publisher) underneath. In the case of the SAP Business Logic driver, the SAP organizational structure objects are stored in containers inside the Driver object.

This is no better or worse than any other approach, it just needs to be known and planned for. I.e. A client I was at, had 4000 active employees, but 9000 objects in the Organizational structure container. (Did I mention the SAP people have LOTS of fun with this aspect of the product? Also they seem to never retire or delete objects in the Org structure, they just stop using them). Personally I would have preferred the location of the Org objects to be a configuration setting (GCV probably, since the shim is what uses Driver Configuration values, and in Policy it is a little awkward getting access to them, though the SAP HR CMP driver does have an example of how you might do that.) but by placing it here, you are more likely to be sure to have a replica with the objects on the same server as the driver is running on. This is a basic Identity Manager requirement and seems obvious, but I could see how it might cause issues for people not thinking it through in detail.

In the standard SAP HR as part of the driver set up you can control the location for these objects as well as their object class. (Organization objects in eDirectory map to Organization objects in SAP HR, Positions in SAP HR map to Organizational Role objects in eDirectory, and Jobs in SAP HR map to CommExec objects in eDirectory). In the SAP HR CMP driver the schema is extended with some new classes named DirXML-sapX objects, where X is a single letter representing the SAP object (P = Person, S = Position, O = Organization, C = Jobs).

The SAP HR CMP driver on startup each time, checks to see if the containers to hold all these objects under the SAP Business Logic driver exist, and if not, creates them. (Thus it does this a single time, the first time it starts up). You then need to migrate the objects from the Application via iManager with the Identity Manager plugins or the dxcmd utility. Be aware your client probably has way more Organizational objects than you ever would have imagined or predicted based on the number of users, so test this in development, and plan for enough time for the process to run. Consider turning off DStrace ( [The Many Faces of DSTRACE](http://www.novell.com/communities/node/4418/the-many-faces-dstrace) ) to boost performance, once you are sure everything is running well, as the act of converting the DOM model in memory to XML text is quite CPU intensive for the engine. It is an awesome troubleshooting tool, but a big of a CPU hog.

The dxcmd utility is a nice cross platform Java tool that can do some useful Identity Manager tasks. It is scriptable on Unix platforms as well! To use dxcmd you would need to generate a Query document as a text file, and submit it to dxcmd. This has come in handy to me very often.

Well that is some of the details you need to understand before we get started working through the SAP Business Logic driver. Stay tuned for Part 2 when we start working through the configuration values that need to be set.

![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_1__NetIQ_Cool_Solutions_www.netiq.com.resources/rating_off.gif]]![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_1__NetIQ_Cool_Solutions_www.netiq.com.resources/rating_off.gif]]![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_1__NetIQ_Cool_Solutions_www.netiq.com.resources/rating_off.gif]]![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_1__NetIQ_Cool_Solutions_www.netiq.com.resources/rating_off.gif]]![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_1__NetIQ_Cool_Solutions_www.netiq.com.resources/rating_off.gif]] (_**0** votes, average: **0.00** out of 5_)
_You need to be a registered member to rate this post._

Tags: [IDM driver](https://www.netiq.com/communities/cool-solutions/tag/idm-driver/), [SAP](https://www.netiq.com/communities/cool-solutions/tag/sap/)
Categories: [Identity Manager](https://www.netiq.com/communities/cool-solutions/category/identity-manager/), [Technical Solutions](https://www.netiq.com/communities/cool-solutions/category/technical-solutions/)

[Share ![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_1__NetIQ_Cool_Solutions_www.netiq.com.resources/unknown_filename.2.png]]](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-1/#) [Comment ![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_1__NetIQ_Cool_Solutions_www.netiq.com.resources/unknown_filename.3.png]]](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-1/#comments) [0](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-1/#comments)

_**Disclaimer:** As with everything else at NetIQ Cool Solutions, this content is definitely not supported by NetIQ, so Customer Support will not be able to help you if it has any adverse effect on your environment.  It just worked for at least one person, and perhaps it will be useful for you too.  Be sure to test in a non-production environment._

### Comment

You must be [logged in](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fsap-business-logic-idm-driver-walkthrough-part-1%2F) to post a comment.

[Top](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-1/#content)

Search for:

		### Recent Posts
	

		### Recent Comments
	
		### [![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_1__NetIQ_Cool_Solutions_www.netiq.com.resources/unknown_filename.png]]](https://forums.netiq.com/external.php?type=RSS2) [Support Forums](https://forums.netiq.com/)
	
		### [![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_1__NetIQ_Cool_Solutions_www.netiq.com.resources/unknown_filename.png]]](https://www.netiq.com/company/news/press/press_release_rss.php) [Press Releases](http://www.netiq.com/company/news/press/)
	
		### Categories
	

		### Popular Topics
	
	[Active Directory](https://www.netiq.com/communities/cool-solutions/tag/active_directory/) [AMD](https://www.netiq.com/communities/cool-solutions/tag/amd/) [Automation](https://www.netiq.com/communities/cool-solutions/tag/automation/) [Configuration](https://www.netiq.com/communities/cool-solutions/tag/configuration/) [Contact Management](https://www.netiq.com/communities/cool-solutions/tag/contact_management/) [Customizing](https://www.netiq.com/communities/cool-solutions/tag/customizing/) [DirXML](https://www.netiq.com/communities/cool-solutions/tag/dirxml/) [Drivers](https://www.netiq.com/communities/cool-solutions/tag/drivers/) [End User Management](https://www.netiq.com/communities/cool-solutions/tag/end-user-management/) [Identity Manager](https://www.netiq.com/communities/cool-solutions/tag/identity-manager/) [Importing-Exporting / ICE/ LDIF](https://www.netiq.com/communities/cool-solutions/tag/importing-exporting_/_ice/_ldif/) [Knowledge Depot](https://www.netiq.com/communities/cool-solutions/tag/knowledge-depot/) [LDAP](https://www.netiq.com/communities/cool-solutions/tag/ldap/) [Michele Hudnall](https://www.netiq.com/communities/cool-solutions/tag/michele-hudnall/) [Migrating from Windows XP or 2003 to SUSE Linux](https://www.netiq.com/communities/cool-solutions/tag/migrating_from_windows_xp_or_2003_to_suse_linux/) [Monitoring](https://www.netiq.com/communities/cool-solutions/tag/monitoring/) [NT](https://www.netiq.com/communities/cool-solutions/tag/nt/) [Open Enterprise Server](https://www.netiq.com/communities/cool-solutions/tag/open_enterprise_server/) [Passwords](https://www.netiq.com/communities/cool-solutions/tag/passwords/) [Reporting](https://www.netiq.com/communities/cool-solutions/tag/reporting/) [Secure Access](https://www.netiq.com/communities/cool-solutions/tag/secure_access/) [SecureLogin](https://www.netiq.com/communities/cool-solutions/tag/securelogin/) [Security](https://www.netiq.com/communities/cool-solutions/tag/security/) [Synchronization](https://www.netiq.com/communities/cool-solutions/tag/synchronization/) [Troubleshooting](https://www.netiq.com/communities/cool-solutions/tag/troubleshooting/)
	* [geoffc (25350)](https://www.netiq.com/communities/cool-solutions/author/geoffc)

* [ab (5160)](https://www.netiq.com/communities/cool-solutions/author/ab)
* [martincotter (4520)](https://www.netiq.com/communities/cool-solutions/author/martincotter)
* [tisenberg (3935)](https://www.netiq.com/communities/cool-solutions/author/tisenberg)
* [alexmchugh (2600)](https://www.netiq.com/communities/cool-solutions/author/alexmchugh)
* [cstumula (2575)](https://www.netiq.com/communities/cool-solutions/author/cstumula)
* [TSureshkumar (1425)](https://www.netiq.com/communities/cool-solutions/author/TSureshkumar)
* [pmckeith (1125)](https://www.netiq.com/communities/cool-solutions/author/pmckeith)
* [jrivard (1035)](https://www.netiq.com/communities/cool-solutions/author/jrivard)
* [mattehle (950)](https://www.netiq.com/communities/cool-solutions/author/mattehle)
		### Who's Online
	
	[14 members and 9 guests currently online](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-1/#)
	

Let's talk.

* [Request a Call](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-1/#)

* Sales: 1-888-323-6768

© 2014 NetIQ Corporation [Legal](https://www.netiq.com/company/legal/) [Privacy](https://www.netiq.com/company/legal/privacy/) [Feedback](https://www.netiq.com/common/inc/feedback_overlay.html?iframe=true)

[Scroll to Top](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-1/#)
