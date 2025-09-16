---
tags: ["#AD"]
---
# Edit security settings on a Group Policy object: Security Configuration Editor

**To edit a security setting on a Group Policy object**

Choose the appropriate environment for which you want to edit a security setting:

* [For your local computer](http://technet.microsoft.com/en-us/library/cc736516(WS.10).aspx#BKMK_Local)
* [For a Group Policy object, when you are on a workstation or server that is joined to a domain.](http://technet.microsoft.com/en-us/library/cc736516(WS.10).aspx#BKMK_Domain)
* [For a Group Policy object, when you are on a domain controller or on a workstation that has the Windows Server 2003Administration Tools Pack installed.](http://technet.microsoft.com/en-us/library/cc736516(WS.10).aspx#BKMK_AdminPack)
* [For only domain controllers, when you are on a domain controller.](http://technet.microsoft.com/en-us/library/cc736516(WS.10).aspx#BKMK_DC)

#### For your local computer

1. Open Local Security Settings.
2. In the console tree, click **Security Settings**.
3. Do one of the following:
	* To edit **Password Policy** or **Account Lockout Policy**, click **Account Policies**.
	* To edit an **Audit Policy**, a **User Right Assignment**, or **Security Options**, click **Local Policies**.
4. Double-click the security setting in the details pane that you want to modify.
5. Modify the security setting, and then click **OK**.

**Notes**

* To perform this procedure, you must be a member of the Administrators group on the local computer, or you must have been delegated the appropriate authority. If the computer is joined to a domain, members of the Domain Admins group might be able to perform this procedure. As a security best practice, consider using Run as to perform this procedure.
* To open Local Security Policy, click **Start**, point to **Settings**, click **Control Panel**, double-click **Administrative Tools**, and then double-click **Local Security Policy**.

#### For a Group Policy object, when you are on a workstation or server that is joined to a domain.

1. On the taskbar, click **Start**, point to **Run**, type **mmc**, and then click **OK**.
2. In the console, on the **File** menu, click **Add/Remove snap-in**.
3. In **Add/Remove Snap-in**, click **Add**, and then, in **Add Standalone Snap-in**, double-click **Group Policy Object Editor**.
4. In **Select Group Policy Object**, click **Browse**, browse to the policy object you would like to modify, and then click **Finish**.
5. Click **Close**, and then click **OK**.
6. In the console tree, click **Security Settings**.
	**Where?**
	* GroupPolicyObject \[ComputerName\] Policy\\Computer Configuration\\Windows Settings\\Security Settings
7. Do one of the following:
	* To edit **Password Policy**, **Account Lockout Policy**, or **Kerberos Policy**, in the details pane, double-click **Account Policies**.
	* To edit **Audit Policy**, **User Rights Assignment**, or **Security Options**, in the details pane, double-click **Local Policies**.
	* To edit event log settings, on the console tree, click **Event Log**.
8. In the details pane, double-click the security setting that you want to modify.
9. (Optional) If this security setting has not yet been defined, select the **Define these policy settings** check box.
10. Modify the security setting and then click **OK**.

**Note**

* To perform this procedure, you must be a member of the Domain Admins group or the Enterprise Admins group in Active Directory, or you must have been delegated the appropriate authority. As a security best practice, consider using Run as to perform this procedure. For more information, see [Default local groups](http://technet.microsoft.com/en-us/library/cc785098(WS.10).aspx), [Default groups](http://technet.microsoft.com/en-us/library/cc756898(WS.10).aspx), and [Using Run as](http://technet.microsoft.com/en-us/library/cc780931(WS.10).aspx).

#### For a Group Policy object, when you are on a domain controller or on a workstation that has the Windows Server 2003Administration Tools Pack installed.

1. Open Active Directory Users and Computers.
2. In the console tree, right-click the Group Policy object for which you want to edit security settings.
3. Click **Properties**, and then click the **Group Policy** tab.
4. Do one of the following:
	* To edit an existing Group Policy object, click **Edit**.
	* To create a new Group Policy object, click **New**, and then click **Edit**.
5. In the console tree, click **Security Settings**.
	**Where?**
	* GroupPolicyObject \[ComputerName\] Policy\\Computer Configuration\\Windows Settings\\Security Settings
6. Do one of the following:
	* To edit **Password Policy**, **Account Lockout Policy**, or **Kerberos Policy**, click **Account Policies**.
	* To edit **Audit Policy**, **User Rights Assignment**, or **Security Options**, click **Local Policies**.
	* To edit Event log settings, click **Event Log**.
7. Double-click the security setting in the details pane that you want to modify.
8. (Optional) If this security setting has not yet been defined, select the **Define these policy settings** check box.
9. Modify the security setting and then click **OK**.

**Notes**

* To perform this procedure, you must be a member of the Domain Admins group or the Enterprise Admins group in Active Directory, or you must have been delegated the appropriate authority. As a security best practice, consider using Run as to perform this procedure. For more information, see [Default local groups](http://technet.microsoft.com/en-us/library/cc785098(WS.10).aspx), [Default groups](http://technet.microsoft.com/en-us/library/cc756898(WS.10).aspx), and [Using Run as](http://technet.microsoft.com/en-us/library/cc780931(WS.10).aspx).
* To open Active Directory Users and Computers, click **Start**, click **Control Panel**, double-click **Administrative Tools**, and then double-click **Active Directory Users and Computers**.

#### For only domain controllers, when you are on a domain controller.

1. Open Domain Controller Security Policy.
2. In the console tree, click **Security Settings**.
	**Where?**
	* GroupPolicyObject \[ComputerName\] Policy\\Computer Configuration\\Windows Settings\\Security Settings
3. Do one of the following:
	* To edit **Password Policy**, **Account Lockout Policy**, or **Kerberos Policy**, in the console tree, double-click **Account Policies**.
	* To edit **Audit Policy**, **User Rights Assignment**, or **Security Options**, in the console tree, click **Local Policies**.
	* To edit event log settings, in the console tree, click **Event Log**.
4. In the details pane, double-click the security setting that you want to modify.
5. (Optional) If this security setting has not yet been defined, select the **Define these policy settings** check box.
6. Modify the security setting, and then click **OK**.

**Notes**

* To perform this procedure, you must be a member of the Domain Admins group or the Enterprise Admins group in Active Directory, or you must have been delegated the appropriate authority. As a security best practice, consider using Run as to perform this procedure. For more information, see [Default local groups](http://technet.microsoft.com/en-us/library/cc785098(WS.10).aspx), [Default groups](http://technet.microsoft.com/en-us/library/cc756898(WS.10).aspx), and [Using Run as](http://technet.microsoft.com/en-us/library/cc780931(WS.10).aspx).
* To open Domain Controller Security Policy, click **Start**, click **Control Panel**, double-click **Administrative Tools**, and then double-click **Domain Controller Security Policy**.

**Notes**

* Always test a newly-created policy on a test organizational unit before applying it to your network.
* When you change a security setting and click **OK**, that setting will take effect in the next refresh of settings.
* The security settings are refreshed every 90 minutes on a workstation or server and every 5 minutes on a domain controller. The settings are also refreshed every 16 hours, whether or not there are any changes.

## Information about functional differences

* Your server might function differently based on the version and edition of the operating system that is installed, your account permissions, and your menu settings. For more information, see [Viewing Help on the Web](http://technet.microsoft.com/en-us/library/cc776861(WS.10).aspx).

## See Also

#### Concepts

[Working with MMC console files](http://technet.microsoft.com/en-us/library/cc772621(WS.10).aspx)
[Applying security settings](http://technet.microsoft.com/en-us/library/cc778512(WS.10).aspx)
[Best practices for Security Settings](http://technet.microsoft.com/en-us/library/cc739377(WS.10).aspx)
Tags [![[./_resources/Edit_security_settings_on_a_Group_Policy_object_Security_Configuration_Editor.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCTagEditor/resources/taghelp.htm):  [Add a tag](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)  [Add](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)   [Cancel](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
Flag as [ContentBug](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
![[./_resources/Edit_security_settings_on_a_Group_Policy_object_Security_Configuration_Editor.resources/clear.gif]]
Community Content   [![[./_resources/Edit_security_settings_on_a_Group_Policy_object_Security_Configuration_Editor.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCSection/resources/cchelp.htm)

|     |     |     |
| --- | --- | --- |
|     | [![[./_resources/Edit_security_settings_on_a_Group_Policy_object_Security_Configuration_Editor.resources/clear.gif]]](http://technet.microsoft.com/en-us/library/community-edits.rss?topic=cc736516\|en-us\|10)  Annotations |     |

|     |     |     |
| --- | --- | --- |
|     |     | \|  |

Tags [![[./_resources/Edit_security_settings_on_a_Group_Policy_object_Security_Configuration_Editor.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCTagEditor/resources/taghelp.htm):  [Add a tag](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)  [Add](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)   [Cancel](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
Flag as [ContentBug](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
![[./_resources/Edit_security_settings_on_a_Group_Policy_object_Security_Configuration_Editor.resources/clear.gif]]

|     |     |
| --- | --- |
| © 2009 Microsoft Corporation. All rights reserved. [Terms of Use](http://www.microsoft.com/info/cpyright.mspx) \| [Trademarks](http://www.microsoft.com/library/toolbar/3.0/trademarks/en-us.mspx) \| [Privacy Statement](http://www.microsoft.com/info/privacy.mspx) | [![[./_resources/Edit_security_settings_on_a_Group_Policy_object_Security_Configuration_Editor.resources/clear.gif]]](http://www.microsoft.com/en/us/default.aspx) |

![[./_resources/Edit_security_settings_on_a_Group_Policy_object_Security_Configuration_Editor.resources/trans_pixel.mozilla%3aen-US%3aofficial%26client%3dfirefox-a]]
![[./_resources/Edit_security_settings_on_a_Group_Policy_object_Security_Configuration_Editor.resources/nojavascript&WT.js=No]]
