# SAP Business Logic IDM Driver Walkthrough – Part 2 | NetIQ Cool Solutions [www.netiq.com]

[NetIQ](https://www.netiq.com/)

Search

* [Login](https://www.netiq.com/f/mynetiq/login.asp)

* [United States, English](https://www.netiq.com/common/util/langselect.php?referer=https%3A//www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-2/)

* [Solutions](https://www.netiq.com/solutions-industries/)

* [Products](https://www.netiq.com/products/)
* [Industries](https://www.netiq.com/solutions-industries/#industries)
* [About Us](https://www.netiq.com/company/)
* [Services & Support](https://www.netiq.com/services/)
* [Partners](https://www.partnernetprogram.com/)
* [Communities](https://www.netiq.com/communities/)

[Close](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-2/#)

[_Let's Talk_](https://www.netiq.com/company/contact/)

[Close](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-2/#)

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

## SAP Business Logic IDM Driver Walkthrough – Part 2

![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_2__NetIQ_Cool_Solutions_www.netiq.com.resources/unknown_filename.1.png]]
By: [geoffc](https://www.netiq.com/communities/cool-solutions/author/geoffc/)

June 30, 2010 12:33 pm

Reads:**477**

Comments:**3**

Score:**Unrated**

[![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_2__NetIQ_Cool_Solutions_www.netiq.com.resources/pf-print-icon.gif]]Print ![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_2__NetIQ_Cool_Solutions_www.netiq.com.resources/pf-pdf-icon.gif]]PDF](http://www.printfriendly.com/print?url=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fsap-business-logic-idm-driver-walkthrough-part-2%2F)

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

With the SAP HR driver there are two primary flaws in the simple configuration that the CMP version is trying to resolve. They are future dated events, and the SAP Organizational structure.

The SAP HR driver in the CMP model is really broken into two parts, the HR driver itself, and the SAP Business Logic driver.

In part one of this series ([SAP Business Logic IDM Driver Walkthrough – Part 1](http://www.novell.com/communities/node/11551/sap-business-logic-idm-driver-walkthrough-part-1)) I started discussing the two flaws, and what the purpose of the SAP Business Logic driver was.

In part two of this series, I will discuss the configuration values that control this driver.

I highly recommend that you launch your Designer, open a Scratchpad project What you do not have a Scratchpad project where you play around with driver configurations, policy ideas, and look at new drivers? Well why not? How else do you intend to learn? If you were at Brainshare 2010, the TriVir guys ( www.trivir.com ) did a session on Advanced IDM tips and tricks and they email out a set of policies so you can see it in action, and copy / paste into your production projects as needed, which I think is a great idea! I would include the driver configuration on these articles, but every instance of Designer includes them, just open it from the New Driver window.

This driver is basically a Work Order driver, but they compiled a new shim for it. To be cynical I would say, this is to enable them to license it. I ran into this issue with a Salesforce.com SOAP driver recently. I have am almost complete SOAP driver configuration that talks to Salesforce.com, using 100 percent DirXML Script (aka Policy) and zero percent XSLT or compiled code. But if I wanted to try and sell it as a driver configuration, I would have no way of enforcing licensing on it. You could read it and see all the details, and literally copy it item by item and have an unlicensed version.

The Concensus guys (<http://www.concensus.com/>) in their Banner driver compiled a portion that honestly, could have been done in Policy for basically this reason. (PS: They do a great job of writing drivers and consulting! If you are looking to hire some consultants, try the company I work for Computer Integrated Services ([http://www.ciscony.com](http://www.ciscony.com/)) first, but if we are too busy, try out Concensus! They are good folk and good friends! If they are busy try TriVir! Also really good group of people.)

There is nothing wrong with doing this, but it does mean that Novell needs to maintain two code bases, the standard Work Order driver, and then the almost identical except for licensing SAP Business Logic driver shim. As such it uses the class com.novell.nds.dirxml.driver.sap.bl.SAPBLShim which is preset in the driver configuration that you would import in Designer or iManager. Again, worth noting but not a big deal.

Like the Work Order driver there is very little in the Driver Configuration settings, that is worth talking about, as it just does what it does. The usual stuff like startup, local or remote are set here, but not much worth commenting on.

The only thing of interest is the ECMA tab, which is where you specify objects that contain ECMA functions for the engine to use in the driver. With an XPATH call to es:FunctionName(Arg1, Arg2, ArgN) you can call ECMA (which is the official name now for Javascript) functions to do things that you cannot otherwise do, but you need to tell the engine where to find the ECMA function. (I usually store all my ECMA in an ECMA object stored in a Library container object since I often link it into multiple drivers, and it makes it easier find.) This driver uses the lib-AJC ECMA object, which all the CMP drivers seem to include these days.

Back in the day when Identity Manager was a young impressionable teen, someone sold Novell Consulting their gateway drug of the Advanced Java Class which included a bunch of useful functions that you could do yourself, but through the collected experience of the Consulting group, were compiled together into one place. Then as time wore on, Novell added a lot of the functions in that library into the base Identity Manager product. For example a lot of the time functionality is completely replaced by the Convert Time() token ([Using the Time Tokens in IDM 3.5](http://www.novell.com/communities/node/2572/using-time-tokens-idm-35) ) and other examples.

However they really seem addicted to this class library and I concede there is definitely a use case for some of the times. I happen to be a firm believer that readability is a virtue, and thus using standard tokens where possible makes more sense than custom Java or ECMA. Of course there are times where one approach has a performance penalty, in which case certainly you should use the faster choice. As an example I had a Policy approach to compare two node sets, and find the values in both node sets and those NOT in both nodesets. With 10,000 nodes, it took literally eight hours to process. Turning off Dstrace helped cut the time down somewhat, but then Father Ramon suggested an ECMA approach that took literally 1 minute to do the same. Usually it not a clear cut example like that, but you get the idea.

Anyway, at some point in time, they decided to port the Advanced Java Class to ECMA (Javascript) which is actually nice, as it gives a LOT of examples of how to do things in ECMA, when using Identity Manager. Thus we have the lib-AJC ECMA object with 80 some odd functions. It is probably worth spending some time reading and understanding that library by itself! Hmm, there is an idea for an article series. In my copious spare time I guess…

Other than that ECMA library not much in the Driver Configuration tab.

On the Global Configuration Values tab, there is a fair bit more to discuss.

First off, they nicely use the Enum GCV type and the ability to group and hide a set of GCV’s together as discussed in my article series on GCV’s ( [Explaining GCVs – Part 1](http://www.novell.com/communities/node/11344/explaining-gcvs-part-1), [Explaining GCVs – Part 2](http://www.novell.com/communities/node/11471/explaining-gcvs-part-2) ) to make the GCV tab really clean, if you are not using the functionality. To see the relevant settings, the Show SAP HR Business logic settings needs to be toggled to true. There is a companion setting, which is Enable SAP HR Business logic (true / false). This one means the driver will actually process these class of Work Orders.

Next up is the DN of the SAP HR driver (DN value). There is a matching setting in the SAP HR CMP driver that needs to know where the SAP Business Logic driver resides, since the two drivers cross reference each other. The SAP HR CMP driver needs the reference because it needs to write the Work Order objects under the Business Logic driver, and this driver needs the reference for reasons we will discuss later in the series. (Ok, I have not yet read ahead to know the answer yet! Will get to it when we get to it!)

Determine Hire Date from HR Actions (true / false) is used to offer an approach to handle the seemingly complex future dated Hire case I talked about in the first article in this series. I say seemingly, since they seem to do it a fair bit in reality. What if
you hire someone and enter that info March 1st, but they do not start until April 1st, and then the person declines the position midway through that period.

Each of those events (hire, terminate, cancel, etc) have a corresponding SAP Action type, that is available in the iDOC data. But the definitions of the Actions in SAP are actually customizable. There are some standard ones that ship with the product, but your implementation might be different, so just in case here is a chance to configure if you differ.

Thus if you can identify the Action in SAP that is the Hire (and later Terminate) event, then you can infer the date at which it takes affect, by the BEGDA (Begin Date) associated with that Action. Get it? Since the Action defines a time period for it to begin on, thus the hire or terminate begins when that Action is set to happen.

The next item is HR Action Reason, which I am not certain what it is used for. Ok, I looked ahead, and it looks like one of the pieces of data in the payload of the Work Order object you will get on a future dated hire (and there is a corresponding value for termination) is this Action Reason, and the driver will then test to see if the value in SAP HR that comes through matches one of the values of the GCV and allow it through in that case.

Then next four GCV’s are basically the same thing, for each of the cases of, Termination, Deactivation, Activation. a boolean as to Determine Termination Date from HR Actions.

This is quite useful, instead of having to track down the locations in Policy where the values are used, and are one of those perfect examples of how to use a GCV.

This way you can individually consider each case of Hire, Terminate, Deactivate, Activate, and Delete based on how your SAP HR system is configured. What I need to think about is how this affects the case of inpatriation and expatriation. When someone is transferred between countries, where there is a different tax code in affect, it seems the SAP way to do things is to give them a new PERNUM, and the event of leaving the home country is Ex-patriation. And the act of entering the new country is Inpatriation. There are two events that comprise the persons move, and there is an end date, at which each ends and the person is home. There is also a transfer between countries that is much the same. I will have to keep this in mind as I work through the rest of the driver to see how this case is handled if at all.

Finally we have the CMP driver sets usual Logging options. I do not have a test system to run these through, but I would really like to see the end result of the logging event and work through it in the course of an article. (\*\*Cough\*\* Holger \*\*cough\*\*).

Stay tuned for the next couple of episodes of this series, where I will start working through some of the policies involved.

This driver is pretty much entirely Subscriber Event Transform based, with just the barest minimum of policy every where else.

![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_2__NetIQ_Cool_Solutions_www.netiq.com.resources/rating_off.gif]]![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_2__NetIQ_Cool_Solutions_www.netiq.com.resources/rating_off.gif]]![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_2__NetIQ_Cool_Solutions_www.netiq.com.resources/rating_off.gif]]![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_2__NetIQ_Cool_Solutions_www.netiq.com.resources/rating_off.gif]]![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_2__NetIQ_Cool_Solutions_www.netiq.com.resources/rating_off.gif]] (_**0** votes, average: **0.00** out of 5_)
_You need to be a registered member to rate this post._

Tags: [DirXML](https://www.netiq.com/communities/cool-solutions/tag/dirxml/), [Identity Manager](https://www.netiq.com/communities/cool-solutions/tag/identity-manager/), [zenworks](https://www.netiq.com/communities/cool-solutions/tag/zenworks/)
Categories: Uncategorized

[Share ![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_2__NetIQ_Cool_Solutions_www.netiq.com.resources/unknown_filename.2.png]]](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-2/#) [Comment ![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_2__NetIQ_Cool_Solutions_www.netiq.com.resources/unknown_filename.3.png]]](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-2/#comments) [3](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-2/#comments)

_**Disclaimer:** As with everything else at NetIQ Cool Solutions, this content is definitely not supported by NetIQ, so Customer Support will not be able to help you if it has any adverse effect on your environment.  It just worked for at least one person, and perhaps it will be useful for you too.  Be sure to test in a non-production environment._

#### 3 Comments

1. By:hdopp
	[July 3, 2010 6:09 am](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-2/#comment-8193)
	
	Hi Geoffrey,
	you asked for it, here it is.
	A sample of an operation log from a running SAP-BL driver.
	
	The purpose of the log file is to figure out, what the driver’s policy do, without using trace level 3.
	
	It always starts with the incoming data.
	
	`  20100609121016,true(SAP-HR-CMP:O_100_0000000000018020:P+00000120),\UTOPIAISM\utopia\users\merlin SAP Business Operation "add" detected ObjectClass: User DirXML-sapP-A-C 1276078213#3 - 50000331 DirXML-sapPActions 1276078213#6 - 0#BEGDA=20090603#ENDDA=99991231#MASSN=01#MASSG=01#STAT2=3 DirXML-sapP-A-S 1276078213#5 - 50000336 DirXML-sapP-A-O 1276078213#4 - 50000309  `
	
	Reading the log file further, you also can identify, which policy is used and what the outcome of the policy looks like.
	
	`  P-P-OrgManager: Lookup manager of the organization's (50000309) workforceID ... orgMgrWfID already found --> Next available manager: 00000002 Set DirXML-OrgMgrWorkforceID = 00000002 P-P-Manager: Lookup manager of the position's workforceID ... Clear ManagerWorkforceID P-P-Position: Check for added/removed position ... FORWARD: add person to position [50000336] Check for Hire Actions ... Set DirXML-HireDate = 20090603 (1244066400) Check for Termination Actions ... Clear DirXML-TerminationDate Check for Activation Actions ... Set DirXML-ActivationDate = 20090603 (1244066400) Clear DirXML-DeactivationDate Check for Deactivation Actions ... Check for Department ... Set OU = O-CONS-SRM Check for jobCode ... Set jobCode = P-SRM-ARC Check for Title ... Set Title = SRM Architect 6  `
	
	BTW: All the logging is done using the lib-AJC funtion writeLog.
	
	Just some words to the lib-AJC. We programmed the java class in the early DirXML 1.0 days, where a lot of functionality wasn’t available in the DirXML engine. The class was developed further over the years.
	Furtunately the IDM engineers understand the need of additional funtionality and built some functions into the IDM engine and finaly converted the complete class into ECMA script, so you don’t have to copy the java class jar file anymore.
	
	Best regards
	Holger Dopp
	
	[Log in to Reply](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fsap-business-logic-idm-driver-walkthrough-part-2%2F)
	
2. By:hdopp
	[July 3, 2010 6:21 am](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-2/#comment-8194)
	
	In SAP HR you do have the concept of actions and reasons.
	
	A action (e.g. hire, terminate, re-hire, etc.) defines a follow up of UI screens, which must be filled up by the HR user to guarantee that all required information (personal, organizational, payment, etc.) are filled in for the employee record.
	
	Different actions require different UI screens (information).
	
	A reason is just a subspecification for an action. For a hire for instance you can specify, why an employee is hired: company expansion, just for fun, etc.
	
	So for the SAP BL driver it might be, that you have combinations of action/reasons, which you are more or less interested in, so you have the choice to configure it in the GCVs.
	
	[Log in to Reply](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fsap-business-logic-idm-driver-walkthrough-part-2%2F)
	
3. By:hdopp
	[July 3, 2010 6:28 am](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-2/#comment-8195)
	
	Geoffrey, just to save you time, the driver version you are evaluating does not support country move, when a new employee record (new PERNR) is created.
	
	This is also known as multi-affiliation and will be supported in a future version of this driver, which I’m currently working on.
	
	Holger
	
	[Log in to Reply](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fsap-business-logic-idm-driver-walkthrough-part-2%2F)
	

### Comment

You must be [logged in](https://www.netiq.com/communities/cool-solutions/wp-login.php?redirect_to=https%3A%2F%2Fwww.netiq.com%2Fcommunities%2Fcool-solutions%2Fsap-business-logic-idm-driver-walkthrough-part-2%2F) to post a comment.

[Top](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-2/#content)

Search for:

		### Recent Posts
	

		### Recent Comments
	
		### [![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_2__NetIQ_Cool_Solutions_www.netiq.com.resources/unknown_filename.png]]](https://forums.netiq.com/external.php?type=RSS2) [Support Forums](https://forums.netiq.com/)
	
		### [![[./_resources/SAP_Business_Logic_IDM_Driver_Walkthrough_–_Part_2__NetIQ_Cool_Solutions_www.netiq.com.resources/unknown_filename.png]]](https://www.netiq.com/company/news/press/press_release_rss.php) [Press Releases](http://www.netiq.com/company/news/press/)
	
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
	
	[14 members and 7 guests currently online](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-2/#)
	

Let's talk.

* [Request a Call](https://www.netiq.com/communities/cool-solutions/sap-business-logic-idm-driver-walkthrough-part-2/#)

* Sales: 1-888-323-6768

© 2014 NetIQ Corporation [Legal](https://www.netiq.com/company/legal/) [Privacy](https://www.netiq.com/company/legal/privacy/) [Feedback](https://www.netiq.com/common/inc/feedback_overlay.html?iframe=true)
