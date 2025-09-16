# Support | What are the requirements for using Domain Migration Administrator when migrating with SID History? (NETIQKB4365) [www.netiq.com]

[NetIQ](https://www.netiq.com/)

* [**Solutions**](https://www.netiq.com/solutions-industries/) 

* [**Products**](https://www.netiq.com/products/) 
* [**Industries**](https://www.netiq.com/solutions-industries/#industries) 
* [**Support**](https://www.netiq.com/services/) 
* [**About**](https://www.netiq.com/company/) 
* [Partners](https://www.partnernetprogram.com/)
* [Communities](https://www.netiq.com/communities/)
[**Let's Talk**](https://www.netiq.com/company/contact/) 
_Search_

* [Login](https://www.netiq.com/f/mynetiq/login.asp)

* [**United States, English**](https://www.netiq.com/common/util/langselect.php?referer=https%3A//www.netiq.com/support/kb/doc.php%3Fid%3D7704365) 
	
	[Close](https://www.netiq.com/support/kb/doc.php?id=7704365#)
	
* [**Let's Talk**](https://www.netiq.com/company/contact/) 

# [Knowledgebase](https://www.netiq.com/support/kb/)

* [FAQ](http://support.novell.com/additional/faq.html)

* [Register Your Product](https://secure-www.novell.com/center/regadmin/jsps/activate_app.jsp)
* [My Favorites](https://www.netiq.com/support/kb/doc.php?id=7704365#)

* [Email Document](https://www.netiq.com/support/kb/doc.php?id=7704365#)

* [Printer Friendly](https://www.netiq.com/support/kb/doc.php?id=7704365)
* [Favorite](https://www.netiq.com/support/kb/doc.php?id=7704365&add&title=What+are+the+requirements+for+using+Domain+Migration+Administrator+when+migrating+with+SID+History%3F+%28NETIQKB4365%29)
* Rating
	

# What are the requirements for using Domain Migration Administrator when migrating with SID History? (NETIQKB4365)

This document **(7704365)** _is provided subject to the [disclaimer](https://www.netiq.com/support/kb/doc.php?id=7704365#disclaimer) at the end of this document._

### Resolution

goal
What are the requirements for using Domain Migration Administrator when migrating with SID History?
goal
What conditions must be met to successfully migrate with SID History?
fact
Domain Migration Administrator 6.x
fact
Domain Migration Administrator 7.x
fix
In order for a migration with SID History to be successful, the following conditions must be met:

* The target domain must be running Microsoft Windows 2000 or Microsoft Windows 2003  in **Native Mode**.

* **Note:** SID History is not available in mixed mode domains.

* Domain Migration Administrator (DMA) must be installed on a Microsoft Windows 2000  domain controller, Microsoft Windows 2003 server or Microsoft Windows XP machine in the target domain.
* To migrate **SID History** to a Microsoft Windows 2000  domain:

*  The logged on user must be a member of the target domain's**Domain Admins** group.

* To migrate **SID History** to a Microsoft Windows 2003  domain:
	* The logged on user must be delegated full control to the target Organizational Unit (OU).
	* The logged on user must be granted the **Migrate SID History** permission to the domain object. To do this:
		1. Open **Active Directory Users and Computers.**
		2. Right click the _domain name_.
		3. Select **Properties**.
		4. Select the _Security_ tab. (This may require enabling Advanced Featured in the Active Directory Users and Computers MMC.)
		5. Add the migration account to the _Security_ tab.
		6. Scroll down through the permissions and select **Allow for the Migrate SID History** permission.
	* If using **DMA 7.2 or higher**, the logged on account does NOT have to be a member of **Domain** Admins when migrating SID History to Microsoft Windows 2003.
		* **Note:** Support for this additional permission was first added in **DMA 7.2**. To migrate SID history in prior versions of DMA, the logged on account must be a Domain Admin in the target domain, even when migrating to Microsoft Windows 20_03_.
* Source domain may be running:
	* Microsoft Windows NT 4.0 (Service Pack 4 or later)
	* Microsoft Windows 2000 (Mixed or Native)
	* Microsoft Windows 2003
		
* For Microsoft Windows NT 4.0 source domains: The source domain's primary domain controller (PDC) must be available.
* The source domain must not be in the same forest as the destination domain (by definition, a Microsoft Windows NT 4.0 domain is not in the same forest).
* The source object must be of one of the following types:
	
	* User
	* Security enabled Group, including:
		* Global group
		* Local group
		* Shared Local Groups (Local Groups created on the PDC and shared with the Backup Domain Controllers (BDCs) in a Microsoft Windows NT 4.0  domain
		* Domain Local Group
		* Universal Group
	
	* The source object may not have a built-in SID (e.g. Administrators, Users, and Power Users Local Groups). As built-in SIDs are identical in every domain, adding them to SID History would achieve very little.
	* The SID of the source object must not already exist in the target forest, either as a primary account SID or in the SID History of an account.
	* For Microsoft Windows NT 4.0  source domains: Modify the registry on the source PDC, adding the _DWORD_value **TcpipClientSupport** to: HKLM\\SYSTEM\\CurrentControlSet\\Control\\LSA. This value must be set to **1** to enable the Security Accounts Manager (SAM) operations required for cloning to take place over remote procedure call (RPC). DMA will prompt you to allow it to set this registry key when you first enable the option for a migration wi.
		th SID History. You do not need to set this registry key under normal circumstances. The source PDC must be rebooted after this key is set and DMA will also do this automatically.
	* Create a trust so that the source domain trusts the target domain.
	* The user account logged on to the DMA console machine must have administrator privileges in the source domain.
		
		* To do this, add the **Domain** Admins group from the target domain to the **Administrators**  group in the source domain.
		
		* **Example:** If the domain is called Redmond, the group would be called **Redmond$$**.
	* Auditing of success and failure of account management operations must be enabled in both the source and target domains. DMA will prompt you to allow it to create this group when you first enable the option for a migration with SID History.
	* The Global Catalog server must be available in the target domain.
.
note
This information can also be obtained from Chapter 2 of the _DMA User Guide_.

### Additional Information

Formerly known as NETIQKB4365

### Disclaimer

This Support Knowledgebase provides a valuable tool for NetIQ/Novell/SUSE customers and parties interested in our products and solutions to acquire information, ideas and learn from one another. Materials are provided for informational, personal or non-commercial use within your organization and are presented "AS IS" WITHOUT WARRANTY OF ANY KIND.

* **Document ID:**_7704365_

* **Creation Date:**02-FEB-07
* **Modified Date:**08-OCT-07
	* **NetIQ**Domain Migration Administrator

Did this document solve your problem? [[#|Provide Feedback]]

Let's talk.

* [Request a Call ›](https://www.netiq.com/support/kb/doc.php?id=7704365#)

* Sales: 1-888-323-6768
* Support: 1-713-418-5555

© NetIQ Corporation [Legal](https://www.netiq.com/company/legal/) [Privacy](https://www.netiq.com/company/legal/privacy/) [Feedback](https://www.netiq.com/common/inc/feedback_overlay.html?iframe=true)
