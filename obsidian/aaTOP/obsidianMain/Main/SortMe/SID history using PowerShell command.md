# SID history using PowerShell command

[Rajisubramanian's Blog](https://rajisubramanian.wordpress.com/)
Experience in Exchange World
[![[./_resources/SID_history_using_PowerShell_command.resources/unknown_filename.png]]](https://rajisubramanian.wordpress.com/)

[Skip to content](https://rajisubramanian.wordpress.com/2014/04/10/sid-history-using-powershell-command/#content)

* [Home](https://rajisubramanian.wordpress.com/)

* [About Me](https://rajisubramanian.wordpress.com/about/)
* [Certification & Achievements](https://rajisubramanian.wordpress.com/certification-acheivements/)

[← Extracting the specific content line from huge log file using PowerShell command](https://rajisubramanian.wordpress.com/2014/04/09/extracting-the-specific-content-line-from-huge-log-file-using-powershell-command/)
[Send-MailMessage : Mailbox unavailable. The server response was: 5.7.1 Unable to relay →](https://rajisubramanian.wordpress.com/2014/04/11/send-mailmessage-mailbox-unavailable-the-server-response-was-5-7-1-unable-to-relay/)

## [SID history using PowerShell command](https://rajisubramanian.wordpress.com/2014/04/10/sid-history-using-powershell-command/)

Posted on [April 10, 2014](https://rajisubramanian.wordpress.com/2014/04/10/sid-history-using-powershell-command/) by [Raji Subramanian](https://rajisubramanian.wordpress.com/author/rajisubramanian/)

 

Rate This

[![[./_resources/SID_history_using_PowerShell_command.resources/sidhistory.png]]](https://rajisubramanian.files.wordpress.com/2014/04/sidhistory.png)This is not the SID of ice age it regards to the security identifier of an object located in Active Directory. The user account SID can be extracted using the PowerShell cmdlet and modified them easily.

[![[./_resources/SID_history_using_PowerShell_command.resources/guid.png]]](https://rajisubramanian.files.wordpress.com/2014/04/guid.png)

**To find the properties of user with SID history detail**

_Get-ADUser “Mail.COM/Region/Asia/Rajis” –properties sidhistory_

**To search user on specific OU or domain**

_Get-ADUser -fILTER {nAME -eq “Rajis”} -SearchBase “OU=Asia,OU=Region,DC=MAIL,DC=COM” –properties sidhistory_

**To remove SID history value as**

_Get-ADUser -fILTER {nAME -eq “Rajis”} -SearchBase “OU=Asia,OU=Region,DC=MAIL,DC=COM” –properties sidhistory | foreach {Set-ADUser $\_ -remove @{sidhistory=$\_.sidhistory.value}}_

[About these ads](http://wordpress.com/about-these-ads/)

### _Related_

[The trust relationship between this workstation and the primary domain failed](https://rajisubramanian.wordpress.com/2013/12/27/the-trust-relationship-between-this-workstation-and-the-primary-domain-failed/)With 3 comments

[Update Exchange 2013 Attribute after ILM or MIIS GAL synchronization](https://rajisubramanian.wordpress.com/2014/05/14/update-exchange-2013-attribute-after-ilm-or-miis-gal-synchronization/)In "Exchange 2013 SP1"

[Exchange Server 2013 - Full Access Mailbox Permission Vs Send AS Permissions](https://rajisubramanian.wordpress.com/2014/03/27/exchange-server-2013-full-access-mailbox-permission-vs-send-as-permissions/)In "Exchange Server 2013"

![[./_resources/SID_history_using_PowerShell_command.resources/7bbb2f1d5050e2a5779b1737dd4701fe.jpg]]

## About Raji Subramanian

Nothing great to say about me...Just want to share my knowledge for others that will be useful at any moment of time when they stuck in critical issue....
[View all posts by Raji Subramanian →](https://rajisubramanian.wordpress.com/author/rajisubramanian/)

This entry was posted in [Powershell Command](https://rajisubramanian.wordpress.com/category/powershell-command/) and tagged [Get-Aduser](https://rajisubramanian.wordpress.com/tag/get-aduser/), [Powershell Command](https://rajisubramanian.wordpress.com/tag/powershell-command/), [SIDHistory](https://rajisubramanian.wordpress.com/tag/sidhistory/). Bookmark the [permalink](https://rajisubramanian.wordpress.com/2014/04/10/sid-history-using-powershell-command/).

[← Extracting the specific content line from huge log file using PowerShell command](https://rajisubramanian.wordpress.com/2014/04/09/extracting-the-specific-content-line-from-huge-log-file-using-powershell-command/)
[Send-MailMessage : Mailbox unavailable. The server response was: 5.7.1 Unable to relay →](https://rajisubramanian.wordpress.com/2014/04/11/send-mailmessage-mailbox-unavailable-the-server-response-was-5-7-1-unable-to-relay/)

### Leave a Reply

* 76,815 hits

* [Exchange 2013 DAG Error: The seeding operation failed. Error: An error occurred while performing the seed operation.](https://rajisubramanian.wordpress.com/2014/02/21/exchange-2013-dag-error-the-seeding-operation-failed-error-an-error-occurred-while-performing-the-seed-operation/)

* [Cluster network name resource 'Cluster Name' failed registration of one or more associated DNS name(s) for the following reason:The handle is invalid.](https://rajisubramanian.wordpress.com/2014/01/22/cluster-network-name-resource-cluster-name-failed-registration-of-one-or-more-associated-dns-names-for-the-following-reasonthe-handle-is-invalid/)
* [Exchange Server 2013 Interview Question](https://rajisubramanian.wordpress.com/2014/03/15/exchange-server-2013-interview-question/)
* [Slow Mailbox Movement on Exchange 2013 SP1 Mailbox Migration](https://rajisubramanian.wordpress.com/2014/05/30/slow-mailbox-movement-on-exchange-2013-sp1-mailbox-migration/)
* [Exchange Server 2013 Performance Counters](https://rajisubramanian.wordpress.com/2014/07/17/exchange-server-2013-performance-counters/)
* [Exchange Server 2013 Message Size Configuration Detail](https://rajisubramanian.wordpress.com/2014/01/26/exchange-server-2013-message-size-configuration-detail/)
* [SID history using PowerShell command](https://rajisubramanian.wordpress.com/2014/04/10/sid-history-using-powershell-command/)
* [Exchange Server 2013 Mailbox database White Space](https://rajisubramanian.wordpress.com/2013/12/28/exchange-server-2013-mailbox-database-white-space/)
* [Outlook Error - The name cannot be resolved. The name cannot be matched to a name in the address list.](https://rajisubramanian.wordpress.com/2014/01/05/outlook-error-the-name-cannot-be-resolved-the-name-cannot-be-matched-to-a-name-in-the-address-list/)
* [Exchange Server 2013 - Full Access Mailbox Permission Vs Send AS Permissions](https://rajisubramanian.wordpress.com/2014/03/27/exchange-server-2013-full-access-mailbox-permission-vs-send-as-permissions/)
		### Archives
	
	* @[Factsionary](http://twitter.com/Factsionary) @[akankshayadv](http://twitter.com/akankshayadv) hope you experienced recently [1 month ago](http://twitter.com/RajiSubramanian/statuses/546225573001826307)
	* @[12Knocksinna](http://twitter.com/12Knocksinna) more informative to plan for future [1 month ago](http://twitter.com/RajiSubramanian/statuses/543606690491289600)
	* @[akankshayadv](http://twitter.com/akankshayadv) @[ChocolateMantra](http://twitter.com/ChocolateMantra) [3 months ago](http://twitter.com/RajiSubramanian/statuses/531328018896023552)
	* How to print Secure PDF File [wp.me/pNTWJ-9I](http://wp.me/pNTWJ-9I) [3 months ago](http://twitter.com/RajiSubramanian/statuses/526283522500075520)
	* Exchange 2013 – Microsoft Outlook 2013 – Connectivity Issue “The connection to Microsoft Exchange is unavailable.… [wp.me/pNTWJ-9B](http://wp.me/pNTWJ-9B) [3 months ago](http://twitter.com/RajiSubramanian/statuses/523427979297177600)

[Rajisubramanian's Blog](https://rajisubramanian.wordpress.com/)
[The Twenty Ten Theme](https://wordpress.com/themes/twentyten/). [Create a free website or blog at WordPress.com](https://wordpress.com/?ref=footer_website).

[[#|Follow]]

### Follow “Rajisubramanian's Blog”

Get every new post delivered to your Inbox.

Join 740 other followers

[Build a website with WordPress.com](https://wordpress.com/?ref=lof)

![[./_resources/SID_history_using_PowerShell_command.resources/g.gif]]
