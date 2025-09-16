---
tags: ["#powershell"]
---
# Managing User Mailboxes

**Managing User Mailboxes**

**_Applies to:_** _Exchange Server 2007 SP1, Exchange Server 2007_ **_Topic Last Modified:_** _2007-07-09_

Mailboxes are the most common recipient type used by information workers in an Exchange organization. Each mailbox is associated with an Active Directory user account. The user can use the mailbox to send and receive messages, and to store messages, appointments, tasks, notes, and documents. It is the primary messaging and collaboration tool for the users in your Exchange organization. To learn more about mailboxes, see [Understanding Recipients](http://technet.microsoft.com/en-us/library/bb201680.aspx).

This topic lists the management tasks that you can perform for user mailboxes and includes links to topics that will help you complete the tasks. Unless otherwise noted, these tasks can be performed by using the Exchange Management Console or the Exchange Management Shell.

* [How to Create a Mailbox for a New User](http://technet.microsoft.com/en-us/library/aa998197.aspx)
	This topic explains how to use the Exchange Management Console and the Exchange Management Shell to create a new user account in the Active Directory directory service and create a mailbox for that user.
	If you use the Exchange Management Console for this task, the New Mailbox wizard will guide you through the process of creating the new mailbox. If you use the Exchange Management Shell, you will use the **New-Mailbox** cmdlet.
* [How to Create a Mailbox for an Existing User](http://technet.microsoft.com/en-us/library/aa998319.aspx)
	This topic explains how to use the Exchange Management Console and the Exchange Management Shell to create a new mailbox for an existing user in Active Directory.
	If you use the Exchange Management Console for this task, the New Mailbox wizard will guide you through the process of creating a mailbox for the existing user. If you use the Exchange Management Shell, you will use the **Enable-Mailbox** cmdlet.
* [How to Create a Linked Mailbox](http://technet.microsoft.com/en-us/library/bb123524.aspx)
	This topic explains how to use the Exchange Management Console and the Exchange Management Shell to create a linked mailbox. A linked mailbox is a mailbox that is assigned to an individual user in a separate, trusted forest.
	If you use the Exchange Management Console for this task, the New Mailbox wizard will guide you through the process of creating the new linked mailbox. If you use the Exchange Management Shell, you will use the **New-Mailbox** cmdlet.
* [How to Disable a Mailbox](http://technet.microsoft.com/en-us/library/bb123730.aspx)
	This topic explains how to use the Exchange Management Console and the Exchange Management Shell to disable the mailbox of an existing Active Directory user object. This task removes all the Exchange attributes from the user object in Active Directory, but the user object remains in Active Directory.
	If you use the Exchange Management Console for this task, you will need to select the mailbox from the **Recipient Configuration** node, and then click **Disable** in the action pane to disable the mailbox. If you use the Exchange Management Shell, you will use the **Disable-Mailbox** cmdlet.
* [How to Remove a Mailbox](http://technet.microsoft.com/en-us/library/bb125192.aspx)
	This topic explains how to use the Exchange Management Console and the Exchange Management Shell to disconnect a mailbox from its associated user account and remove the user from Active Directory.
	If you use the Exchange Management Console for this task, you will need to select the mailbox from the **Recipient Configuration** node, and then click **Remove** in the action pane to remove the mailbox. If you use the Exchange Management Shell, you will use the **Remove-Mailbox** cmdlet.
		|     |
	| --- |
	| **![[./_resources/Managing_User_Mailboxes.resources/Bb123720.gif]]Important:** |
	| When you remove a mailbox, not only are the Exchange data marked for deletion, but the associated user account in Active Directory is deleted as well. |
	
* [How to Connect a Mailbox](http://technet.microsoft.com/en-us/library/bb201701.aspx)
	This topic explains how to use the Exchange Management Console or the Exchange Management Shell to connect a disconnected mailbox. A disconnected mailbox is a mailbox object in the Microsoft Exchange store that is not associated with an Active Directory user account.
	If you use the Exchange Management Console for this task, the Connect Mailbox wizard will guide you through the process of connecting the disconnected mailbox. If you use the Exchange Management Shell, you will use the **Connect-Mailbox** cmdlet.
* [How to Convert a Mailbox](http://technet.microsoft.com/en-us/library/bb201749.aspx)
	This topic explains how to use the Exchange Management Shell to convert a mailbox to a different type of mailbox.
	You cannot use the Exchange Management Console to convert a mailbox. You must use the **Set-Mailbox** cmdlet in the Exchange Management Shell.
* [How to Convert a Mailbox to a Linked Mailbox](http://technet.microsoft.com/en-us/library/bb201694.aspx)
	This topic explains how to use the Exchange Management Console or the Exchange Management Shell to convert a user mailbox to a linked mailbox. A linked mailbox is a mailbox that is assigned to an individual user in a separate, trusted forest.
	To convert a mailbox to a linked mailbox, you must first disable the mailbox and then connect it as a linked mailbox. If you use the Exchange Management Console for this task, first you will need to select the mailbox from the **Recipient Configuration** node, and then click **Disable** in the action pane to disable the mailbox. Then, the Connect Mailbox wizard will guide you through the process of connecting the mailbox as a linked mailbox. If you use the Exchange Management Shell, you will use the **Disable-Mailbox**, **Get-Credential** and **Connect-Mailbox** cmdlets.
* [How to Export Mailbox Data](http://technet.microsoft.com/en-us/library/bb266964.aspx)
	This topic explains how to use the Exchange Management Shell to export mailbox data from one mailbox to a folder in another mailbox
	You cannot use the Exchange Management Console to export mailbox data. You must use the **Export-Mailbox** cmdlet in the Exchange Management Shell.
* [How to Enable or Disable Outlook Web Access for a Mailbox User](http://technet.microsoft.com/en-us/library/bb124124.aspx)
	This topic explains how to use the Exchange Management Console and the Exchange Management Shell to enable or disable Microsoft Outlook Web Access for an Exchange 2007 mailbox user.
	If you use the Exchange Management Console for this task, you will use the **Mailbox Features** tab of the mailbox properties. If you use the Exchange Management Shell, you will use the **Set-CASMailbox** cmdlet.
* [How to Enable or Disable Exchange ActiveSync for a Mailbox User](http://technet.microsoft.com/en-us/library/bb124809.aspx)
	This topic explains how to use the Exchange Management Console or the Exchange Management Shell to enable or disable Exchange ActiveSync for an Exchange 2007 mailbox user.
	If you use the Exchange Management Console for this task, you will use the **Mailbox Features** tab of the mailbox properties. If you use the Exchange Management Shell, you will use the **Set-CASMailbox** cmdlet.
* [How to Enable or Disable MAPI for a Mailbox User](http://technet.microsoft.com/en-us/library/bb124497.aspx)
	This topic explains how to use the Exchange Management Console or the Exchange Management Shell to enable or disable Messaging Application Programming Interface (MAPI) for an Exchange 2007 mailbox user.
	If you use the Exchange Management Console for this task, you will use the **Mailbox Features** tab of the mailbox properties. If you use the Exchange Management Shell, you will use the **Set-CASMailbox** cmdlet.
* [How to Disable MAPI for All Mailboxes on a Server](http://technet.microsoft.com/en-us/library/bb266970.aspx)
	This topic explains how to disable MAPI access for all mailboxes on a Mailbox server. To perform this procedure, you must edit the registry.
	You cannot use the Exchange Management Console or the Exchange Management Shell to disable MAPI for all mailboxes on a server. You must edit the registry on the Mailbox server to accomplish this task.
* [How to Enable or Disable POP3 for a Mailbox User](http://technet.microsoft.com/en-us/library/bb691018.aspx)
	This topic explains how to use the Exchange Management Console or the Exchange Management Shell to enable or disable Post Office Protocol version 3 (POP3) for an Exchange 2007 mailbox user.
	If you use the Exchange Management Console for this task, you will use the **Mailbox Features** tab of the mailbox properties. If you use the Exchange Management Shell, you will use the **Set-CASMailbox** cmdlet.
* [How to Enable or Disable IMAP4 for a Mailbox User](http://technet.microsoft.com/en-us/library/bb676481.aspx)
	This topic explains how to use the Exchange Management Console or the Exchange Management Shell to enable or disable Internet Message Access Protocol version 4rev1 (IMAP4) for an Exchange 2007 mailbox user.
	If you use the Exchange Management Console for this task, you will use the **Mailbox Features** tab of the mailbox properties. If you use the Exchange Management Shell, you will use the **Set-CASMailbox** cmdlet.
* [How to Add a New E-Mail Address for a Mailbox User](http://technet.microsoft.com/en-us/library/bb123794.aspx)
	This topic explains how to use the Exchange Management Console or the Exchange Management Shell to add an e-mail address for a user mailbox.
	If you use the Exchange Management Console for this task, you will use the **E-mail Addresses** tab of the mailbox properties. If you use the Exchange Management Shell, you will use the **Get-Mailbox** and **Set-Mailbox** cmdlets.
* [How to Update a Recipient's Address and Phone Information](http://technet.microsoft.com/en-us/library/bb124317.aspx)
	This topic explains how to use the Exchange Management Console or the Exchange Management Shell to update a recipient's address and phone information.
	If you use the Exchange Management Console for this task, you will use the **Address and Phone** tab of the mailbox properties. If you use the Exchange Management Shell, you will use the **Set-User** cmdlet.
* [How to Configure Anti-Spam Features on a Mailbox](http://technet.microsoft.com/en-us/library/bb123559.aspx)
	This topic explains how to use the Exchange Management Shell to configure anti-spam features for a mailbox.
	You cannot use the Exchange Management Console to configure anti-spam features for a mailbox. You must use the **Set-Mailbox** cmdlet in the Exchange Management Shell. You can also use the **Set-OrganizationConfig** cmdlet to configure the anti-spam features for all mailboxes in your organization.
* [How to Configure Storage Quotas for a Mailbox](http://technet.microsoft.com/en-us/library/aa998353.aspx)
	This topic explains how to use the Exchange Management Console or the Exchange Management Shell to configure mailbox storage quotas for a mailbox.
	If you use the Exchange Management Console for this task, you will use the **Mailbox Settings** tab of the mailbox properties. If you use the Exchange Management Shell, you will use the **Set-Mailbox** cmdlet.
* [How to Configure Message Size Limits for a Mailbox or a Mail-Enabled Public Folder](http://technet.microsoft.com/en-us/library/bb124708.aspx)
	This topic explains how to use the Exchange Management Console or the Exchange Management Shell to configure message size limits for a user mailbox.
	If you use the Exchange Management Console for this task, you will use the **Mail Flow Settings** tab of the mailbox properties. If you use the Exchange Management Shell, you will use the **Set-Mailbox** cmdlet.
* [How to Restrict the Number of Recipients per Message](http://technet.microsoft.com/en-us/library/bb310760.aspx)
	This topic explains how to use the Exchange Management Console or the Exchange Management Shell to restrict the number of recipients per message at various levels in your Exchange organization, including at the mailbox level.
	If you use the Exchange Management Console for this task, you will use the **Mail Flow Settings** tab of the mailbox properties. If you use the Exchange Management Shell, you will use the **Set-Mailbox** cmdlet.
* [How to Change the Languages for a User Mailbox](http://technet.microsoft.com/en-us/library/bb310757.aspx)
	This topic explains how to use the Exchange Management Shell to change the languages for a user mailbox.
	You cannot use the Exchange Management Console to change the languages for a user mailbox. You must use the **Set-Mailbox** cmdlet in the Exchange Management Shell.
* [How to Configure a Catch-All Mailbox](http://technet.microsoft.com/en-us/library/bb691132.aspx)
	This topic explains how to use the Exchange Management Console or the Exchange Management Shell to configure transport rules to copy or redirect messages a catch-all mailbox on a computer that has the Edge Transport server role installed.
	A _catch-all mailbox_ is typically a mailbox in your organization that is used to collect all of the e-mail messages that are sent to your organization. Depending on your preferences, the catch-all mailbox may receive all messages or only messages that are sent to mailboxes that do not exist. Transport rules on Edge Transport servers are used to copy or redirect messages that are received by your organization to the catch-all mailbox.
* [Moving Mailboxes](http://technet.microsoft.com/en-us/library/bb124797.aspx)
	This topic lists the management tasks that involve moving mailboxes and includes links to topics that will help you complete the tasks. The tasks involving moving mailboxes include moving a mailbox within a single forest, moving a mailbox across forests and merging mailboxes.

![[./_resources/Managing_User_Mailboxes.resources/clear.gif]] For More Information

* For information about managing resource mailboxes, see [Managing Resource Mailboxes](http://technet.microsoft.com/en-us/library/bb124374.aspx).
* To learn more about mail contacts and mail users, see [Understanding Recipients](http://technet.microsoft.com/en-us/library/bb201680.aspx).
* For more information about using the Exchange Management Console, see [Using the Exchange Management Console](http://technet.microsoft.com/en-us/library/bb123762.aspx).
* For more information about using the Exchange Management Shell, see [Using the Exchange Management Shell](http://technet.microsoft.com/en-us/library/bb123778.aspx).

Tags [![[./_resources/Managing_User_Mailboxes.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCTagEditor/resources/taghelp.htm):  [Add a tag](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)  [Add](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)   [Cancel](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
Flag as [ContentBug](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
![[./_resources/Managing_User_Mailboxes.resources/clear.gif]]
Community Content   [![[./_resources/Managing_User_Mailboxes.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCSection/resources/cchelp.htm)

|     |     |     |
| --- | --- | --- |
|     | [![[./_resources/Managing_User_Mailboxes.resources/clear.gif]]](http://technet.microsoft.com/en-us/library/community-edits.rss?topic=bb123720\|en-us\|80)  Annotations |     |

|     |     |     |
| --- | --- | --- |
|     |     | \|  |

Tags [![[./_resources/Managing_User_Mailboxes.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCTagEditor/resources/taghelp.htm):  [Add a tag](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)  [Add](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)   [Cancel](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
Flag as [ContentBug](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
![[./_resources/Managing_User_Mailboxes.resources/clear.gif]]

|     |     |
| --- | --- |
| © 2009 Microsoft Corporation. All rights reserved. [Terms of Use](http://www.microsoft.com/info/cpyright.mspx)  \|  [Trademarks](http://www.microsoft.com/library/toolbar/3.0/trademarks/en-us.mspx)  \|  [Privacy Statement](http://www.microsoft.com/info/privacy.mspx) | [![[./_resources/Managing_User_Mailboxes.resources/clear.gif]]](http://www.microsoft.com/) |

![[./_resources/Managing_User_Mailboxes.resources/trans_pixel.aspx]]
![[./_resources/Managing_User_Mailboxes.resources/nojavascript&WT.js=No]]
