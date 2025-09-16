# Cool Solutions: Synchronizing an Expired Password with Active Directory

[![[./_resources/Cool_Solutions_Synchronizing_an_Expired_Password_with_Active_Directory.resources/novell_logo_redonblack.png]]](http://www.novell.com/)

* [Skip to Content](http://www.novell.com/coolsolutions/tip/17065.html#top)
* [+ Menu](http://www.novell.com/menu.php)

### [Solutions](http://www.novell.com/solutions)

* [**Data Center**](http://www.novell.com/solutions/data-center)
* [Enterprise Linux Servers](http://www.novell.com/solutions/enterprise-linux-servers)
* [Virtualization & Workload Management](http://www.novell.com/solutions/virtualization-workload)
* [Business Service Management](http://www.novell.com/solutions/business-service-management)
* [**End-User Computing**](http://www.novell.com/solutions/end-user-computing)
* [Collaboration](http://www.novell.com/solutions/collaboration)
* [Enterprise Linux Desktops](http://www.novell.com/solutions/enterprise-linux-desktops)
* [Endpoint Management](http://www.novell.com/solutions/endpoint-management)
* [**Identity & Security**](http://www.novell.com/solutions/identity-and-security)
* [Compliance Management](http://www.novell.com/solutions/compliance-management)
* [Identity & Access Management](http://www.novell.com/solutions/identity-and-access)
* [Security Management](http://www.novell.com/solutions/security-management)

[Not Sure? _Try our solution finder +_](http://www.novell.com/solutions)

### [Products](http://www.novell.com/products)

* [Access Manager](http://www.novell.com/products/accessmanager)
* [Compliance Management Platform](http://www.novell.com/products/compliancemanagementplatform)
* [GroupWise](http://www.novell.com/products/groupwise)
* [Identity Manager](http://www.novell.com/products/identitymanager)
* [Open Enterprise Server](http://www.novell.com/products/openenterpriseserver)
* [PlateSpin Forge](http://www.novell.com/products/forge)
* [PlateSpin Migrate](http://www.novell.com/products/migrate)
* [PlateSpin Orchestrate](http://www.novell.com/products/orchestrate)
* [Sentinel](http://www.novell.com/products/sentinel)
* [SUSE Appliance Program](http://www.novell.com/partners/technology/isv/appliance)
* [SUSE Linux Enterprise Server](http://www.novell.com/products/server)
* [Teaming + Conferencing](http://www.novell.com/products/teaming)
* [ZENworks Configuration Management](http://www.novell.com/products/zenworks/configurationmanagement)
* [ZENworks Endpoint Security Management](http://www.novell.com/products/zenworks/endpointsecuritymanagement)

[_All Products_ +](http://www.novell.com/products)

### [Services](http://www.novell.com/services)

* [Technical Support](http://www.novell.com/support)
* [Technical Training](http://www.novell.com/training)
* [IT Consulting](http://www.novell.com/consulting)
* [Downloads](http://download.novell.com/)
* [Customer Center](http://www.novell.com/center)
* [Support Forums](http://forums.novell.com/)
* [Documentation](http://www.novell.com/documentation)

### [Partners & Community](http://www.novell.com/communities)

* [Partners](http://www.novell.com/partners)
* [Developers](http://developer.novell.com/wiki/index.php/Developer_Home)
* [Users](http://www.novell.com/communities/nui)
* [Cool Solutions](http://www.novell.com/communities/coolsolutions)
* [Blogs](http://www.novell.com/company/blogs)

#### Search

* [Login](https://www.novell.com/ICSLogin/?%22http://www.novell.com/coolsolutions/tip/17065.html%22)
	* [Create an Account](https://secure-www.novell.com/selfreg/jsp/createAccount.jsp)
	* [Change Language](http://www.novell.com/common/util/langselect.php?referer=http%3A//www.novell.com/coolsolutions/tip/17065.html)

### [About Novell](http://www.novell.com/company)

* [Contact Us](http://www.novell.com/company/contacts-offices)
* [Our Customers](http://www.novell.com/success)
* [Events Center](http://www.novell.com/events)
* [Connection Magazine](http://www.novell.com/connectionmagazine)
* [Press Room](http://www.novell.com/news/press/room)
* [Novell News Blog](http://www.novell.com/prblogs)

[- Close Menu](http://www.novell.com/coolsolutions/tip/17065.html#)

[![[./_resources/Cool_Solutions_Synchronizing_an_Expired_Password_with_Active_Directory.resources/novell_logo_redonblack.png]]](http://www.novell.com/)

 [cool solutions home](http://www.novell.com/coolsolutions)

# Synchronizing an Expired Password with Active Directory

## Novell Cool Solutions: Tip
By [Aaron Burgemeister](http://www.novell.com/coolsolutions/author/3088.html)

[Rate This Page](http://www.novell.com/inc/rater.jsp?url=http://www.novell.com/coolsolutions/tip/17065.html)

Reader Rating  ![[./_resources/Cool_Solutions_Synchronizing_an_Expired_Password_with_Active_Directory.resources/stars_5_0.gif]]  from 4 ratings

* [Printer Friendly](http://www.novell.com/inc/pf/pf.jsp)
* [tell a friend](http://www.novell.com/info/sendemail.jsp?url=http://www.novell.com/coolsolutions/tip/17065.html)

|     |     |
| --- | --- |
| - [Slashdot This](http://slashdot.org/submit.pl)<br>_Posted: 29 Mar 2006_ |     |

The following policy is designed to synchronize an expired password to the "User must change password at next logon" option in Active Directory (User > Properties > Account > Account Options). This option is basically the same as having an expired password (with grace logins remaining) in eDirectory.

The desired functionality was to expire a password in eDirectory when the checkbox was checked in Active Directory (to prevent the user from continuing with an expired password in either system). Having both passwords become valid on a valid password change was also desired and implemented.

In the event the action started in Active Directory, the password was expired in eDirectory to 2000-01-01. Using this date guaranteed an expired password but also provided an easily recognizable date should somebody forget about this functionality in the future.

The following policy should be placed as the first policy in the Event Transformation policyset on the Publisher channel:

<?xml version="1.0" encoding="UTF-8"?><policy>
    <rule>
        <description>Create Password Expiration Time if appropriate</description>
        <conditions>
            <and>
                <if-op-attr mode="numeric" name="pwdLastSet" op="changing-to">0</if-op-attr>
            </and>
        </conditions>
        <actions>
            <do-set-dest-attr-value name="Password Expiration Time">
                <arg-value type="int">
                    <token-text xml:space="preserve"
                    xmlns:xml="http://www.w3.org/XML/1998/namespace">946710000</token-text>
                </arg-value>
            </do-set-dest-attr-value>
        </actions>
    </rule>
    <rule>
        <description>Clear Password Expiration Time if Appropriate</description>
        <conditions>
            <and>
                <if-op-attr mode="numeric" name="pwdLastSet" op="changing-from">0</if-op-attr>
            </and>
            <and>
                <if-op-attr name="pwdLastSet" op="changing"/>
                <if-op-attr mode="numeric" name="pwdLastSet" op="not-changing-to">0</if-op-attr>
            </and>
        </conditions>
        <actions>
            <do-clear-dest-attr-value name="Password Expiration Time"/>
        </actions>
    </rule>
</policy>

The following policy should be placed as the first policy in the Command Transform policyset on the Subscriber channel:

<?xml version="1.0" encoding="UTF-8"?>
<policy xmlns:jcal="http://www.novell.com/nxsl/java/java.util.Calendar">
    <rule>
        <description>Store 'Password Expiration Time' in local variable</description>
        <conditions>
            <and>
                <if-class-name op="equal">User</if-class-name>
                <if-op-attr name="Password Expiration Time" op="available"/>
                <if-op-attr name="nspmDistributionPassword" op="changing"/>
            </and>
        </conditions>
        <actions>
            <do-set-local-variable name="PASS-EXP-TIME">
                <arg-string>
                    <token-op-attr name="Password Expiration Time"/>
                </arg-string>
            </do-set-local-variable>
            <do-set-local-variable name="cal-obj">
                <arg-object>
                    <token-xpath expression="jcal:getInstance()"/>
                </arg-object>
            </do-set-local-variable>
            <do-set-local-variable name="CURRENT-TIME">
                <arg-string>
                    <token-xpath
                    expression="floor((number(jcal:getTimeInMillis($cal-obj))\*0.001)+86400)"/>
                </arg-string>
            </do-set-local-variable>
        </actions>
    </rule>
    <rule>
        <description>Remove 'Password Expiration Time' if in future</description>
        <conditions>
            <and>
                <if-local-variable name="CURRENT-TIME" op="available"/>
                <if-local-variable name="PASS-EXP-TIME" op="available"/>
                <if-xpath op="true">$CURRENT-TIME>$PASS-EXP-TIME</if-xpath>
            </and>
        </conditions>
        <actions>
            <do-set-dest-attr-value name="pwdLastSet" when="after">
                <arg-value type="int">
                    <token-text xml:space="preserve"
 xmlns:xml="http://www.w3.org/XML/1998/namespace">0</token-text>
                </arg-value>
            </do-set-dest-attr-value>
        </actions>
    </rule>
</policy>

The final required changes involve adding the pwdLastSet attribute to the driver filter. Set the attribute at least to "Notify" on the Publisher Channel and "Ignore" on the Subscriber channel. The Application Name for this attribute in the filter was left blank and should not be required because it is not truly synchronizing.

As always, testing a solution before implementing it in production is highly recommended. This solution was tested only with Password Synchronization 2.0 using Universal Password.

#### Reader Comments

* Useful.
* I had just been writting something similar myself. Thanks

[Like what you see?
Sign up for our weekly newsletter. ![[./_resources/Cool_Solutions_Synchronizing_an_Expired_Password_with_Active_Directory.resources/h_link-arrow.gif]]](http://www.novell.com/coolsolutions/forms/subscribe.html) 
[Want to contribute?
It could earn you a nano! Learn more. ![[./_resources/Cool_Solutions_Synchronizing_an_Expired_Password_with_Active_Directory.resources/h_link-arrow.gif]]](http://www.novell.com/coolsolutions/forms/submit_a_tip.html) 
[Like Wikis?
Join the Cool Solutions Wiki. ![[./_resources/Cool_Solutions_Synchronizing_an_Expired_Password_with_Active_Directory.resources/h_link-arrow.gif]]](http://wiki.novell.com/index.php/Cool_Solutions_Wiki_Main_Page) 

|     |     |     |
| --- | --- | --- |
| ![[./_resources/Cool_Solutions_Synchronizing_an_Expired_Password_with_Active_Directory.resources/20060127phone.gif]] |     | [Interested?<br>Request a sales call ![[./_resources/Cool_Solutions_Synchronizing_an_Expired_Password_with_Active_Directory.resources/h_link-arrow.gif]]](http://www.novell.com/company/sales_call_request.jsp?refid=coolsolutions&unitcode=1-418V23) |

![[./_resources/Cool_Solutions_Synchronizing_an_Expired_Password_with_Active_Directory.resources/spacer.gif]]

_Novell Cool Solutions (corporate web communities) are produced by WebWise Solutions. _

[Advertising in Cool Solutions](http://www.novell.com/coolsolutions/ratecard.html)
[Talk to Us](http://www.novell.com/communities/contact)
[Submit Content](http://www.novell.com/communities/node/1394)
[Subscribe](http://www.novell.com/coolsolutions/forms/subscribe.html)
[Cool Solutions Home (New)](http://www.novell.com/communities/coolsolutions)
[Classic Cool Solutions Home](http://www.novell.com/coolsolutions/index.html)
[Authors](http://www.novell.com/coolsolutions/author)
[Cool Blogs](http://www.novell.com/communities/coolblogs)
[Cool Solutions Wiki](http://wiki.novell.com/)
[Cool Tools](http://www.novell.com/communities/coolsolutions/tools)
Get Involved  _\>_
[Open Audio (podcasts)](http://www.novell.com/company/podcasts/openaudio.html)

* **1.800.529.3400** [local numbers](http://www.novell.com/company/contact.html?sourceid=lbanner_contact)
* [Request Call](http://www.novell.com/company/sales_call_request.jsp?sourceidint=lbanner_sc)

[Novell® Making IT Work As One™](http://www.novell.com/company/strategy.html)

* [Careers](http://www.novell.com/company/careers/index.html)
* [Contact Us](http://www.novell.com/company/contacts-offices)
* [Feedback](http://www.novell.com/inc/feedback/feedback.jsp)
* [Legal](http://www.novell.com/company/legal)
* 

© 2009 Novell, Inc. All Rights Reserved.

![[./_resources/Cool_Solutions_Synchronizing_an_Expired_Password_with_Active_Directory.resources/0.gif]]
![[./_resources/Cool_Solutions_Synchronizing_an_Expired_Password_with_Active_Directory.resources/392480-setting-passwordexpirationtime-driver.html&tzo=420&ms=548]]
