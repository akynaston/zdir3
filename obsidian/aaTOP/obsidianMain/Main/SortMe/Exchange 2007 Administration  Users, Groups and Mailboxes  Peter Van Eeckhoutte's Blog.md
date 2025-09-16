---
tags: ["#powershell"]
---
# Exchange 2007 Administration : Users, Groups and Mailboxes | Peter Van Eeckhoutte's Blog

# [Peter Van Eeckhoutte’s Blog](http://www.corelan.be:8800/)

**Exchange 2007 Administration : Users, Groups and Mailboxes**

**12 October, 2007 (01:14) | [MS Exchange](http://www.corelan.be:8800/index.php/category/exchange) | By: Peter Van Eeckhoutte**

If you're new here, you may want to subscribe to my [RSS feed](http://www.corelan.be:8800/index.php/feed) or subscribe [to email notifications](http://www.corelan.be:8800/index.php/post_notification_header). Thanks for visiting, and don't hesitate to leave your feedback/comments on this blog!

#### Creating mailboxes for existing AD users

Basic command : **enable-mailbox –identity "_Username (UPN)_" -database "_SERVER\\Mailbox Database_" -alias _"alias"_ -ExternalEmailAddress _email@adres.com
_**If you want to create a mailbox for all users in a specific OU, use this command (Example : Sales OU , which sits under the Departments OU, in the domain.com domain) :
**get-user | where-object {$\_.distinguishedname –like "\*ou=Sales,ou=Departments,dc=domain,dc=com"} | enable-mailbox -database "SERVER\\Mailbox Database"**

#### Bulk-creating new AD users and mailboxes

You can create AD users and mailboxes based upon an (comma separated) input file, containing the user name and other optional parameters. The following script will use a text file containing firstname, lastname and password (in csv format). The first line of the text file contains the header – the field names (which can be used in the script as objects). The script assumes that you’ve used the following field names : FirstName, LastName, Password, OU
Create a ps1 file called createusers.ps1, with the following content : (change db and upndom parameters to reflect your environment)

$db="SERVER\\Mailbox Database"
$upndom="mydomain.com"
$users=import-csv $args\[0\]
function SecurePassword(\[string\]$plainPassword)
{
$secPassword=new-object System.Security.SecureString
Foreach($char in $plainPassword.ToCharArray())
{
$secPassword.AppendChar($char)
}
$secpassword
}
foreach ($i in $users)
{
$sp = SecurePassword $i.password
$upn = $i.Firstname + "@" + $upndom
$display = $i.FirstName + " " + $i.LastName
New-Mailbox –Password $sp –Database $db -UserPrincipalName $upn –Name $i.FirstName
   –FirstName $i.FirstName –LastName $i.LastName –OrganizationalUnit $i.OU
}

Since the script uses the FirstName as upn, you need to make sure it is unique.

The input file (users.csv) looks like this : (change to reflect your own environment)

FirstName,LastName,Password,OU,Department
Test1,User1,PWtAstuZer1,mydomain.com/Departments/Sales,Sales

Test1,User2,PWtAstuZer2,mydomain.com/Departments/Sales,Sales

Test1,User3,PWtAstuZer3,mydomain.com/Departments/Marketing,Marketing

Run the script and feed the input file to the script : CreateUsers.ps1 users.csv

Of course, you can modify the script and add more commands to apply additional parameters to the newly created mailbox, such as :

set-mailbox -id $upn -PrimarySmtpAddress $upn –ProhibitSendQuota 150MB
   –IssueWarningQuota 120MB –ProhibitSendReceiveQuota unlimited
   -domaincontroller firstdc.mydomain.com
set-user -id $upn -Company "My Company" -Department $i.Department
   -domaincontroller firstdc.mydomain.com
Add-MailboxPermission -Identity $upn -AccessRights FullAccess
   -User "Peter Van Eeckhoutte" -domaincontroller firstdc.mydomain.com
Add-ADPermission -Identity $i.FirstName
   -User "Peter Van Eeckhoutte" -ExtendedRights Receive-As -domaincontroller firstdc.mydomain.com

(I added the -domaincontroller switch to indicate that for example the Add-ADPermission cmdlet might use another DC than the one used to create the AD object. So the AD object needs to be present on the DC where you want to modify the ACL, which means that you should try to connect to the same DC on every command. From that perspective, you’ll need to add the **\-domaincontroller firstdc.mydomain.com** (fqdn) switch to the New-Mailbox command as well.) Additionally, you can insert a "**start-sleep 5**" command between the creation of the AD object and the modification of the object to be sure the object is created before you attempt to change it.

In case you were wondering : you can delete the user and mailbox again using the following command (based upon the 3 Test User accounts) : **Get-Mailbox | where {$\_.Name -ilike "Test\[123\]"} | | remove-mailbox**

#### 
How to mail-enable AD objects (groups and users)

You can mail-enable an existing universal group by using the Enable-DistributionGroup cmdlet : **Enable-DistributionGroup –id "_domain\\group_" -Alias _"GroupAlias"_**

Before you can use contacts in universal groups, those contacts must be mail-enabled.Mail-enabling a contact can be done via Enable-MailContact cmdlet : **Enable-MailContact –id "_domain\\contact_" –ExternalEmailAddress _user@domain.com_ –Alias "_ContactAlias_"**

You can create and enable a mailbox for a regular user using Enable-Mailbox : **Enable-Mailbox -id "_domain\\user_" -Database "_Mailbox Database_"**. You can set additionally parameters by using the Set-Mailbox cmdlet : **Set-Mailbox -id "user"** Some possible/available options are :

\-EmailAddresses "the.user@domain.com","user.lastname@domain.com"

\-PrimarySMTPAddress "user@domain.com"

\-ForwardingAddress "otheruser@domain.com"

\-ProhibitSendQuota 100MB

\-ProhibitReceiveQuota 120MB

\-ProhibitSendReceiveQuota unlimited

\-GrantSendOnBehalfTo "user"

\-WindowsEmailAddress user@domain.com

#### Disabling and reconnecting mailboxes

If you want to disable a mailbox, without removing the AD user, you should use the Disable-Mailbox cmdlet : Disable-Mailbox -id "user". This command will prompt you to enter "Y" if you are sure to disable, so if you are running this from a script, use the -force parameter to avoid the prompt. Since the server has a mailbox retention period, you can still recover the mailbox and assign it to someone else, if required. Open the gui and go to "Disconnected Mailbox". You should see the disabled mailbox in the list. Right-click, choose "connect", specify the type of mailbox (User, Room, Equipment, Linked) and select the AD user account. (<http://technet.microsoft.com/en-us/library/aa995968.aspx>) Alternatively, you can reconnect a mailbox using the Connect-Mailbox cmdlet. To get the list of disconnected mailboxes, use **Get-MailboxStatistics -Server <server> | where { $\_.DisconnectDate -ne $null } | select DisplayName,DisconnectDate,Identity** When you have the identity string, you can use Connect-Mailbox :

Example : **Connect-Mailbox -Identity ‘15151e0a-cbee-4430-910c-edbf59cc2301′ -Database ‘apollo.corelan.be\\First Storage Group\\Mailbox Database’ -User ‘corelan\\Administrator’ -Alias ‘Administrator’**

As soon as AD replication has finished, the change will be applied (the mailbox will be connected again). If you need the change to replicate immediately, run "repadmin /syncall /force" on a DC (<http://support.microsoft.com/kb/232072>)

If you want to remove the AD user and the mailbox, you should use the "remove-mailbox" cmdlet (or choose ‘remove’ when right-clicking the recipient object in the GUI)

#### Mailbox database and mailboxes

If you want to get the list of mailbox databases on your servers : **Get-MailboxDatabase**. If you want to see the mailbox databases from a specific server : **Get-MailBoxDatabase | where {$\_.Server –eq _"SERVERNAME"_}**

If you want the list of user accounts with a mailbox, run **get-user | where {$\_.RecipientType -eq "UserMailBox"}**

List of mailboxes :

**get-mailbox | FL**

Mailbox sizes :
**get-MailboxStatistics –server "SERVERNAME" | format-table DisplayName, TotalItemSize, Database, DatabaseName**

Other interesting fields that are contained in the result set of this cmdlet are :

StorageLimitStatus

LastLoggedOnUserAccount

LastLogonTime

LastLogoffTime

ItemCount

If you want to see the size of the folders inside a mailbox, use the get-mailboxfolderstatistics cmdlet : Example : **get-mailboxfolderstatistics -id "Peter Van Eeckhoutte"| FL Folderpath,FolderSize.** If you want to see the size of the Inbox folder only (or any other folder), use a "where" filter such as : **get-mailboxfolderstatistics -id "Peter Van Eeckhoutte"| where {$\_.Name –eq "Inbox") | FL Folderpath,FolderSize**

I have found the following script at <http://knicksmith.blogspot.com/2007_06_01_archive.html>

First, set the target (enter a mailbox username when prompted) :

$alias = $(read-host alias)

Next, run the statistics :

Get-MailboxFolderStatistics $alias | FT FolderPath,ItemsInFolder,@{label="FolderSize (KB)";
   expression={$\_.FolderSize.ToKB()} }
Get-MailboxStatistics $alias | FT ItemCount,StorageLimitStatus,@{label="TotalItemSize (KB)";
  expression={$\_.TotalItemSize.Value.ToKB()} },@{label="TotalItemSize (MB)";
  expression={$\_.TotalItemSize.Value.ToMB()} },LastLogonTime

The script requires one parameter : the mailbox user name.

You can modify the script to show a list of top 10 mailboxes (size in MB, sort by size descending):

Get-Mailbox | Get-MailboxStatistics | sort-object -descending TotalItemSize |
   Select-Object -first 10| FT DisplayName,@{label="TotalItemSize (MB)";
   expression={$\_.TotalItemSize.Value.ToMB()}}

If you want to see all mailboxes that are larger than 100MB, use

Get-Mailbox | Get-MailboxStatistics | where {$\_.TotalItemSize –gt 100000000} | sort-object
  -descending TotalItemSize | FT DisplayName,@{label="TotalItemSize (MB)";
   expression={$\_.TotalItemSize.Value.ToMB()}}

#### See if you can access a database or mailbox over MAPI, test mail flow

You can use the Test-MAPIConnectivity cmdlet to test connectivity to either a database or mailbox :
**Test-MAPIConnectivity** (will connect to all of the databases)

**Test-MAPIConnectivity "Peter Van Eeckhoutte"** (will connect to that user’s mailbox)

This cmdlet will show latency and error level as wel.

If you want to test message latency, you can run a mail test by using the **Test-MailFlow** cmdlet. By default, without parameters, it will connect to the local server. If you want to use additional test parameters, you can use the following command : **Test-MailFlow _ThisServer_ –TargetMailboxServer _TargetServer_** (only works between [Exchange](http://www.corelan.be:8800/index.php/category/exchange) 2007 servers). You can also use the same cmdlet to test mailflow to an email address by using the **–TargetEmailAddress** parameter

#### Using AD groups and creating dynamic groups

You can use existing AD security groups as Exchange distribution lists by mail-enabling a group. This allows you to keep management of the group in AD and use the updated group as distribution list at the same time. The only requirement is that you use Universal groups. Since you can use Universal groups for setting permissions, it is advised to use Universal groups and add users and/or Global/Local groups to the Universal group. The **enable-DistributionGroup** cmdlet allows you to mail-enable that group : **enable-DistributionGroup -id "AD Group"** **\-DisplayName "Your Group" –Alias "Alias"** and **Set-DistributionGroup –id "Your Group" –PrimarySmtpAddress group@domain.com** to further configure the group.

If you don’t have the proper groups set up, or want to select members of a distribution list based on specific AD attributes as opposed to using an existing group, you can create a dynamic group. This basically allows you to create a group that will dynamically populate the members based upon certain criteria. Once the group is created, its contents are kept up to date automatically. You just need to make sure to keep the AD object attributes updated. Suppose you have properly filled out the "Department" field in AD, and you want to create a distribution group for all people in the Marketing department that will stay up to date, and store the group under the "Mailgroups" OU, you can use the following command : **New-DynamicDistributionGroup -Name "Marketing Users" -ConditionalDepartment "Marketing" –OrganizationalUnit "domain.com/Mailgroups" -IncludedRecipients AllRecipients** If you want to create a Dynamic DistributionGroup based on OU membership, you’ll have to use Powershell (because you cannot select that option via the GUI). Suppose you want to put all users from the Sales OU into a Group and store that group under "Mailgroups", you should use the following command : **New-DynamicDistributionGroup -Name "Sales Users" -RecipientContainer "domain.com/Sales" -IncludedRecipients AllRecipients -OrganizationalUnit "domain.com/Mailgroups**"

Keep in mind : in order to become part of a Dynamic Group, the object must be either a user with Exchange mailbox, a user with an external email-address, a resource mailbox, a contact with external e-mail address or a mail-enabled group. Regular AD objects without mailbox, but with an email address set will NOT become part of the group.

Note : Dynamic Distribution Groups will show up as "Query-based Distribution Groups" in AD. See <http://technet.microsoft.com/en-us/library/bb125256.aspx> and <http://technet.microsoft.com/en-us/library/aa996561.aspx> for more info on Dynamic Distribution Groups.

To view the members of a Dynamic Distribution Group, you’ll need to use these 2 cmdlets :

**$MarketingDepartment = Get-DynamicDistributionGroup -Identity "Marketing Department"**

**Get-Recipient -Filter $MarketingDepartment.RecipientFilter** (or Get**\-Recipient -RecipientFilter $MarketingDepartment.RecipientFilter** in 2007 SP1)

#### Set a mailbox quota for certain users :

Suppose you want to set a mailbox quota for all users in the Sales OU : **Get-Mailbox –OrganizationalUnit "domain.com/Sales" | Set-Mailbox -ProhibitSendQuota 100Mb**

If you want to set a quota for all members of the "Marketing" Active Directory group, you’ll need Quest’s [Free](http://www.corelan.be:8800/index.php/category/my-free-tools) "Quest Active Roles Management Shell for AD" Powershell cmd-lets. Download the free cmd-lets from [http://www.quest.com/powershell/](http://www.quest.com/powershell) .

Make the cmd-lets available through the **Add-PSSnapin Quest.ActiveRoles.ADManagement** powershell command and use the following command : **get-qadgroupmember -Identity "Marketing" | Set-Mailbox –Identity {$\_.Name} -ProhibitSendQuota 100Mb**

#### Access to other mailboxes

If a user tries to open the Inbox of another mailbox, he (or she) will get "Cannot display the folder. The inbox folder cannot be found"
[![[./_resources/Exchange_2007_Administration__Users,_Groups_and_Mailboxes__Peter_Van_Eeckhoutte's_Blog.resources/101207-1546-exchange2001-thumb.png]]](http://www.corelan.be:8800/wp-content/uploads/2008/09/101207-1546-exchange2001.png)

This means that the user does not have access to the Inbox. By default, nobody has access to a mailbox except the owner of that mailbox. (Not even Exchange Organization Admins have access to individual mailboxes). If you want to get/grant access to a mailbox, a folder in a mailbox, … you have multiple options :

\- Ask the user to right click the folder in Outlook and use "Change sharing permissions" to grant access.

![[./_resources/Exchange_2007_Administration__Users,_Groups_and_Mailboxes__Peter_Van_Eeckhoutte's_Blog.resources/101207-1546-exchange2002-thumb.png]]

\- Second option is to grant access to the entire mailbox via Powershell. You need to have Exchange Organization Administrator rights to be able to perform this task .

In the following example, I want try to grant "Peter Van Eeckhoutte" Full Access to the mailbox of "Administrator" : **Add-MailboxPermission -Identity "Administrator" -AccessRights FullAccess -User "Peter Van Eeckhoutte"
**(If you want to do this on all mailboxes, you need to use this command : **get-mailbox | Add-MailboxPermission -Identity {$\_.Name} -AccessRights FullAccess -User "Peter Van Eeckhoutte")
**Possible AccessRights options are : FullAccess, SendAs, ExternalAccount, DeleteItem, ReadPermission, ChangePermission, ChangeOwner. You can specify multiple permissions by separating them with a comma. Additionally, you can review the permissions using the get-MailboxPermission cmdlet. (See <http://technet.microsoft.com/en-us/library/bb124097.aspx> )

Result of the cmdlet : still no access ! Why ? Because you really need other permissions as well. Keep in mind : FullAccess does not include "SendAs" or "ReceiveAs".

By the way : Although the "SendAs" option is available under "Add-MailboxPermission", you cannot use it here to grant real SendAs access. You need to use the Add-ADPermission cmdlet instead. (See <http://technet.microsoft.com/en-us/library/aa998291.aspx>) **add-adpermission "mailbox" -user "domain\\user" -ExtendedRights "Send As".** If you want to allow a user to be able to Send emails "on behalf", use the Set-Mailbox cmdlet : **Set-Mailbox -id "Administrator" -GrantSendOnBehalfTo "Peter Van Eeckhoutte"
**Does this solve our access problem ? No. You need to have "ReceiveAs" access in order to be able to open the mailbox in the first place.

When you grant a user the Full Access permission to a mailbox, that user has full access to only the mailbox for which the permissions are applied. With the Full Access permission, the user can open and read the contents of the mailbox. However, the user cannot send as that mailbox without additional permissions. When you grant a user Receive As permission to a mailbox database, that user can log on to all mailboxes within that database, but is not able to send e-mail messages from those mailboxes. Also, if you grant Receive As permission at the storage group level, the specified user can log on to all mailboxes within all databases in the storage group. For example, you may want to grant access to the mailbox database for mobile access or for legal review. See <http://technet.microsoft.com/en-us/library/aa996343.aspx>

In short : If you need access, you need to run 2 cmdlets :

**Add-MailboxPermission "_Mailbox_" -User "_Trusted User_" -AccessRights FullAccess**    => on user/mailbox level

**Add-ADPermission -Identity "_Mailbox Store_" -User "_Trusted User_" -ExtendedRights Receive-As**     => on mailbox database level or even on Store level. Suppose you want to grant "Peter Van Eeckhoutte" access to the mailbox database that holds the mailbox of Administrator, run :

\[PS\] C:\\>Get-MailboxDatabase
Name Server StorageGroup Recover
\---- ------ ------------ -------
Mailbox Database APOLLO First Storage Group False
\[PS\] C:\\>Add-ADPermission -Identity "Mailbox Database" -User "Peter"
   -ExtendedRights Receive-As
Identity User Deny Rights
\-------- ---- ---- ------
APOLLO\\First Stor... CORELAN\\peter False Receive-As

After changing the ACL, you need to wait for the Information Store to pick up the change. If you want the change to become active immediately, you need to restart the Microsoft Exchange Information Store Service : **restart-service MSExchangeIS**

Alternatively you can run the Add-MailBoxPermission and use adsiedit to change the remaining permissions on the mailbox object (see <http://www.webservertalk.com/archive128-2007-4-1876971.html> and <http://support.microsoft.com/kb/822676>)

#### Allow users to recover items, even when items were removed from "Deleted Items" or removed using a "Hard Delete"

See : <http://support.microsoft.com/kb/246153/en-us>. Modify the registry on the client computer that is running Outlook : go to **HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\Exchange\\Client\\Options** Add a REG\_DWORD value called **DumpsterAlwaysOn** and set the value to 1

(Re)start Outlook client. Click **Deleted Item Recovery** on the Tools menu. A list of items that have been hard deleted during the retention time set on the server is displayed

#### Set deleted item and deleted mailbox retention on the server

(<http://technet.microsoft.com/en-us/library/bb125266.aspx>) By default, deleted items remain available for recovery for 14 days, mailboxes remain available for 30 days. If you want to specify how long deleted items or deleted mailboxes remain available for recovery or re-assigment (in case of mailboxes) on the server, go to the properties of the Mailbox database and go to the "limits" tabsheet. Additionally, you can use the set-mailboxDatabase cmdlet : **set-mailboxDatabase <database\_name> -ItemRetention 14.00:00:00** and **set-mailboxDatabase <database\_name> -MailboxRetention 30.00:00:00**

#### How to manually defrag an Exchange database ?

First, dismount the database. Next, run **eseutil /D drive:\\path\\to\\file** from a Dos prompt.

Other interesting parameters : /p : reserve the temp database (= do not perform an inplace defrag). /t_path\_to\_db_ : set temporary database path (if you don’t want to use the current folder)

Keep in mind, the administrative maintenance task will defrag the databases automatically, so you only need to do this when you think the database is fragmented and the maintenance tasks did not do a good job :-)

(See KB 328804)

#### Importing from and exporting to pst files

If you want to export a mailbox to a pst file, you can use the "**Get-Mailbox | Export-Mailbox –PSTFolderPath <path to folder where data will be exported>**" cmdlet (this example exports all mailboxes, but you can filter and export specific mailboxes as well). Importing a pst into a mailbox is as easy as running **Get-Mailbox | Import-Mailbox –PSTFolderPath <path to folder with <alias>.pst files to import>**

You can specify a start and end date as parameters to the Import-Mailbox cmdlet

You can still use the exmerge utility as well, but you’ll need to run it from a client that has Outlook installed.

Tags: [dynamic groups](http://www.corelan.be:8800/index.php/tag/dynamic-groups), [groups](http://www.corelan.be:8800/index.php/tag/groups), [mailboxes](http://www.corelan.be:8800/index.php/tag/mailboxes), [MS Exchange](http://www.corelan.be:8800/index.php/tag/exchange), [test MAPI](http://www.corelan.be:8800/index.php/tag/test-mapi), [users](http://www.corelan.be:8800/index.php/tag/users)

### Backlinks

[0 Blogs linking to this article](http://www.corelan.be:8800/index.php/2007/10/12/exchange-2007-administration-users-groups-and-mailboxes/#backlinks) »

Links found through [Backlinks](http://dbzer0.com/the-penguin-migration/backlinks)

### Related Posts

* January 7, 2009 -- [Exchange 2007 : Resource Room Mailboxes (0)](http://www.corelan.be:8800/index.php/2009/01/07/exchange-2007-resource-room-mailboxes)
* August 17, 2008 -- [Exchange 2007 - Multi Account Domain to Single Resource Forest replication with IIFP and custom Rules Extension (0)](http://www.corelan.be:8800/index.php/2008/08/17/exchange-2007-multi-account-domain-to-single-resource-forest-replication-with-iifp-and-custom-rules-extension)
* May 19, 2008 -- [Free Tool - Exchange 2007 Outbound SMTP gateway redundancy (8)](http://www.corelan.be:8800/index.php/2008/05/19/free-tool-exchange-2007-outbound-smtp-gateway-redundancy)
* October 14, 2007 -- [Exchange 2007 Administration : Policies and limits (0)](http://www.corelan.be:8800/index.php/2007/10/14/exchange-2007-administration-policies-and-limits)
* October 12, 2007 -- [Exchange 2007 Administration : Antispam and Content Filtering (0)](http://www.corelan.be:8800/index.php/2007/10/12/exchange-2007-administration-antispam-and-content-filtering)
* October 12, 2007 -- [Exchange 2007 Administration : Setup and Delegation (0)](http://www.corelan.be:8800/index.php/2007/10/12/exchange-2007-administration-setup-and-delegation)
* September 19, 2007 -- [Exchange 2007 : Indexing and searching mailboxes (0)](http://www.corelan.be:8800/index.php/2007/09/19/exchange-2007-indexing-and-searching-mailboxes)

* * *

« [Exchange 2007 Administration : Setup and Delegation](http://www.corelan.be:8800/index.php/2007/10/12/exchange-2007-administration-setup-and-delegation)
[Exchange 2007 Administration : Antispam and Content Filtering](http://www.corelan.be:8800/index.php/2007/10/12/exchange-2007-administration-antispam-and-content-filtering) »

* * *

## Write a comment

You need to [login](http://www.corelan.be:8800/wp-login.php?redirect_to=http://www.corelan.be:8800/index.php/2007/10/12/exchange-2007-administration-users-groups-and-mailboxes) to post comments!

Search for:

### PVE Discussion Forums

If you have questions, comments, want to report bugs on any of my free tools, please use the discussion forum at
[**http://www.corelan.be:8800/index.php/forum**](http://www.corelan.be:8800/index.php/forum)
Note : You need to be logged on in order to post

### Stay Posted

 [![[./_resources/Exchange_2007_Administration__Users,_Groups_and_Mailboxes__Peter_Van_Eeckhoutte's_Blog.resources/rss.jpg]] Subscribe to RSS](http://www.corelan.be:8800/index.php/feed)
 [![[./_resources/Exchange_2007_Administration__Users,_Groups_and_Mailboxes__Peter_Van_Eeckhoutte's_Blog.resources/email_small.png]] Subscribe via email](http://www.corelan.be:8800/index.php/post_notification_header)

### Actions

* [Register](http://www.corelan.be:8800/wp-login.php?action=register)
* [Log in](http://www.corelan.be:8800/wp-login.php)
* [Entries RSS](http://www.corelan.be:8800/index.php/feed)
* [Comments RSS](http://www.corelan.be:8800/index.php/comments/feed)
* [Discussion Forums](http://www.corelan.be:8800/index.php/forum)

### This blog and my tools are free...

... but unfortunately hosting this blog and hosting my free tools are not free for me...
So you can help me out by providing a small donation :
\* [My Amazon wish list](http://www.amazon.com/gp/registry/wishlist/2R5E6O2I2IBYF/ref=reg_hu-wl_goto-registry?ie=UTF8&sort=date-added) (books - in English)
\* [My Amazon wish list](http://www.amazon.fr/gp/registry/wishlist/QI0J8M9D9A1T/ref=reg_hu-wl_goto-registry?ie=UTF8&sort=date-added) (electronics - in French, because of EU power differences with US)
\* [Donate using paypal (send to peter.ve@telenet.be)](https://www.paypal.com/sendmoney)

###
