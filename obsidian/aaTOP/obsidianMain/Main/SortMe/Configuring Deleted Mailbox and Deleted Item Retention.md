---
tags: ["#ex2007","#powershell"]
---
# Configuring Deleted Mailbox and Deleted Item Retention

**Configuring Deleted Mailbox and Deleted Item Retention**

**_Applies to:_** _Exchange Server 2007 SP1, Exchange Server 2007_ **_Topic Last Modified:_** _2006-08-23_

Several situations may prompt you to consider restoring your Microsoft Exchange Server 2007 database, including the following:

* A user deletes an e-mail message that was purged from their **Deleted Items** folder or that was deleted with a hard delete. Hard deletes occur when the user holds down SHIFT while pressing DELETE.
* An administrator deletes the wrong mailbox.
* Messages from a former employee's deleted mailbox need to be recovered.

However, good retention practices can help you avoid the scenario of having to restore an Exchange 2007 database. With deleted item retention and deleted mailbox retention, there may be no need to restore your Exchange database to resolve the situations listed earlier. Configuring both deleted item retention and deleted mailbox retention are recommended best practices to help lessen the impact of restoring entire databases. In Exchange 2007, you can configure the following:

* **Deleted Item Retention**   Allows you to recover items after they have been removed from the **Deleted Items** folder or hard-deleted. You must configure the Exchange server for deleted items retention, and the item recovery must occur during the retention period. In Exchange 2007, the default retention period is 14 days. The actual recovery of the deleted items is done from the client.
* **Deleted Mailbox Retention**   Allows you to recover mailboxes after they were deleted. You must configure the Exchange server for deleted mailbox retention, and the mailbox recovery must occur during the retention period. In Exchange 2007, the default retention period is 30 days. You can perform the actual recovery of the deleted mailbox by using either the Exchange Management Shell or the Exchange Management Console.
		|     |
	| --- |
	| **![[./_resources/Configuring_Deleted_Mailbox_and_Deleted_Item_Retention.resources/Bb125266.gif]]Note:** |
	| For both deleted item and deleted mailbox retention, the longer the retention period, the more storage required on your server. The amount of needed storage will vary based on how many users there are and their messaging-related behavior. |
	

![[./_resources/Configuring_Deleted_Mailbox_and_Deleted_Item_Retention.resources/clear.gif]] For More Information

For more information about deleted items retention and deleted mailbox retention, see the following topics:

* [How to Configure Deleted Item Retention for a Mailbox Database](http://technet.microsoft.com/en-us/library/aa997206.aspx)
* [How to Configure Deleted Item Retention for a User](http://technet.microsoft.com/en-us/library/aa995946.aspx)
* [How to Configure Deleted Mailbox Retention](http://technet.microsoft.com/en-us/library/bb125047.aspx)
* [How to Recover a Deleted Item](http://technet.microsoft.com/en-us/library/aa997155.aspx)
* [How to Recover a Deleted Mailbox](http://technet.microsoft.com/en-us/library/aa997182.aspx)

Tags [![[./_resources/Configuring_Deleted_Mailbox_and_Deleted_Item_Retention.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCTagEditor/resources/taghelp.htm):  [Add a tag](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)  [Add](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)   [Cancel](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
Flag as [ContentBug](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
![[./_resources/Configuring_Deleted_Mailbox_and_Deleted_Item_Retention.resources/clear.gif]]
Community Content   [![[./_resources/Configuring_Deleted_Mailbox_and_Deleted_Item_Retention.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCSection/resources/cchelp.htm)

|     |     |     |
| --- | --- | --- |
|     | [![[./_resources/Configuring_Deleted_Mailbox_and_Deleted_Item_Retention.resources/clear.gif]]](http://technet.microsoft.com/en-us/library/community-edits.rss?topic=bb125266\|en-us\|80)  Annotations |     |

|     |     |     |
| --- | --- | --- |
|     |     | \|  |

Tags [![[./_resources/Configuring_Deleted_Mailbox_and_Deleted_Item_Retention.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCTagEditor/resources/taghelp.htm):  [Add a tag](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)  [Add](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)   [Cancel](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
Flag as [ContentBug](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
![[./_resources/Configuring_Deleted_Mailbox_and_Deleted_Item_Retention.resources/clear.gif]]

|     |     |
| --- | --- |
| © 2009 Microsoft Corporation. All rights reserved. [Terms of Use](http://www.microsoft.com/info/cpyright.mspx)  \|  [Trademarks](http://www.microsoft.com/library/toolbar/3.0/trademarks/en-us.mspx)  \|  [Privacy Statement](http://www.microsoft.com/info/privacy.mspx) | [![[./_resources/Configuring_Deleted_Mailbox_and_Deleted_Item_Retention.resources/clear.gif]]](http://www.microsoft.com/) |

![[./_resources/Configuring_Deleted_Mailbox_and_Deleted_Item_Retention.resources/trans_pixel.aspx]]
![[./_resources/Configuring_Deleted_Mailbox_and_Deleted_Item_Retention.resources/nojavascript&WT.js=No]]
