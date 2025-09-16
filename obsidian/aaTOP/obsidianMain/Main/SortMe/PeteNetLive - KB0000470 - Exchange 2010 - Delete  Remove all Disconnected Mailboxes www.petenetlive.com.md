# PeteNetLive - KB0000470 - Exchange 2010 - Delete / Remove all Disconnected Mailboxes [www.petenetlive.com]

$mailboxes = Get-ExchangeServer | Where-Object {$\_.IsMailboxServer –eq $true} | ForEach-Object { Get-MailboxStatistics –Server $\_.Name | Where-Object {$\_.DisconnectDate –notlike ‘’}} | select displayname, mailboxguid, database

Then;

$mailboxes | ForEach { Remove-Mailbox -Database $\_.Database -StoreMailboxIdentity $\_.MailboxGuid -confirm:$false }
