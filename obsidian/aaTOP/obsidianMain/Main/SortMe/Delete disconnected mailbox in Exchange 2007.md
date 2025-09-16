---
tags: ["#ex2007","#powershell"]
---
# Delete disconnected mailbox in Exchange 2007

**Delete disconnected mailbox in Exchange 2007**
Nov 11th, 2008
_by [Christian](http://www.itexperience.net/)._

When you have deleted an **mail-enabled Active Directory account**, the mailbox will be moved to **Disconnected Mailbox** in your **Exchange Management Console**.
To delete (purge) the disconnect mailboxes from a database, you run the following command from your Exchange Management Shell:

Get-MailboxStatistics -database "server\\database" | where {$\_.disconnectdate -ne $null} | foreach {Remove-mailbox -database $\_.database -storemailboxidentity $\_.mailboxguid}

This command first retrieves all disconnected mailboxes from your server\\database, and then runs the **Remove-mailbox** command for every mailbox. To verify that only the disconnected mailboxes will be removed, you run the following command first:

Get-MailboxStatistics -database "server\\database" | where {$\_.disconnectdate -ne $null}

This will list all **current disconnected mailboxes**.

Get-MailboxStatistics where {$\_.disconnectdate -ne $null} | foreach {Remove-mailbox -database $\_.database -storemailboxidentity $\_.mailboxguid}
