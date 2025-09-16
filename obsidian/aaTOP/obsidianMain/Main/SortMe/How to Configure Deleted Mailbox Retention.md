---
tags: ["#ex2007","#powershell"]
---
# How to Configure Deleted Mailbox Retention

**How to Configure Deleted Mailbox Retention**

**_Applies to:_** _Exchange Server 2007 SP1, Exchange Server 2007_ **_Topic Last Modified:_** _2007-07-23_

This topic explains how to configure the deleted mailbox retention period in Microsoft Exchange Server 2007. By default, deleted mailboxes are retained for 30 days before they are purged from the mailbox database.

![[./_resources/How_to_Configure_Deleted_Mailbox_Retention.resources/clear.gif]] Before You Begin
To perform these procedures, the account you use must be delegated the Exchange Organization Administrator role.
For more information about permissions, delegating roles, and the rights that are required to administer Exchange 2007, see [Permission Considerations](http://technet.microsoft.com/en-us/library/aa996881.aspx).
![[./_resources/How_to_Configure_Deleted_Mailbox_Retention.resources/clear.gif]] Procedure
![[./_resources/How_to_Configure_Deleted_Mailbox_Retention.resources/clear.gif]] To use the Exchange Management Console to configure the deleted mailbox retention period
Open the **Exchange Management Console**.

1. n the Console Tree, expand **Microsoft Exchange**, then expand **Server Configuration**, and then select **Mailbox**.
	
2. On the **Database Management** tab in the work pane, expand the storage group that contains the mailbox database that you want to configure.
	
3. Right-click the database that you want to configure, and then select **Properties**.
	
4. Click the **Limits** tab.
	
5. In the **Deletion settings** area, enter the number of days to retain deleted mailboxes in **Keep deleted mailboxes for (days)**.
	
6. Click **OK** to save the changes.
	

![[./_resources/How_to_Configure_Deleted_Mailbox_Retention.resources/clear.gif]] To use the Exchange Management Shell to configure the deleted mailbox retention period

1. Open the **Exchange Management Shell**.
	
2. Run the following command:
	
	Set-MailboxDatabase <database\_name> -MailboxRetention 45.00:00:00
	
	|     |
	| --- |
	| **![[./_resources/How_to_Configure_Deleted_Mailbox_Retention.resources/Bb125047.gif]]Note:** |
	| Replace <_database\_name_\> with the database name. Replace 45.00:00:00 with the number of days, hours, minutes, and seconds for the retention period. |
