---
tags: ["#ex2007","#powershell"]
---
# --++==== HANDY DANDY POWERSHELL COMMANDS ====++--

Remove all disconnected mailboxes:
Works in Exchange 2010 SP3:
(get-mailboxdatabase | Get-MailboxStatistics | where {$\_.Disconnectdate -ne $null}) | foreach {Remove-mailbox -Database $\_.database -StoreMailboxIdentity $\_.MailboxGuid -Confirm:$FALSE; sleep -milliseconds 1000}

Pipe to 'fl' - show all fields

note: adding
\-ea "silentlycontinue"
to the end of calls appears to suppress warning messages.  Use this to determine and print error:
if ($? -eq $False) {
        write-host "Encountered an error while disabling mailbox with alias: " $targetAlias " Error was: \[" $error\[0\] "\]"
        exit $MAILBOX\_NOT\_FOUND
    } else {
        write-host "Successfully completed, now exiting."
    }

  exch rights:
http://exchangepedia.com/blog/2008/02/how-to-delegate-recipient.html

complete a multiple response command with "| fl" to pipe it through a formatter, and get all attributes.

Get all retention information in powershell:
\[PS\] C:\\Windows\\System32>get-mailboxdatabase | fl \*retention\*
MailboxRetention            : 30.00:00:00
DeletedItemRetention        : 14.00:00:00
EventHistoryRetentionPeriod : 7.00:00:00

\[PS\] C:\\Windows\\System32>get-mailboxdatabase | fl distinguishedName, \*retention\*
DistinguishedName           : CN=Mailbox Database,CN=First Storage Group,CN=Inf
                              ormationStore,CN=WIN2K8EX2007,CN=Servers,CN=Excha
                              nge Administrative Group (FYDIBOHF23SPDLT),CN=Adm
                              inistrative Groups,CN=First Organization,CN=Micro
                              soft Exchange,CN=Services,CN=Configuration,DC=tri
                              virdev,DC=com
MailboxRetention            : 30.00:00:00
DeletedItemRetention        : 14.00:00:00
EventHistoryRetentionPeriod : 7.00:00:00
DistinguishedName           : CN=MailboxDatabase2,CN=First Storage Group,CN=Inf
                              ormationStore,CN=WIN2K8EX2007,CN=Servers,CN=Excha
                              nge Administrative Group (FYDIBOHF23SPDLT),CN=Adm
                              inistrative Groups,CN=First Organization,CN=Micro
                              soft Exchange,CN=Services,CN=Configuration,DC=tri
                              virdev,DC=com
MailboxRetention            : 30.00:00:00
DeletedItemRetention        : 14.00:00:00
EventHistoryRetentionPeriod : 7.00:00:00
DistinguishedName           : CN=MailboxDatabase3,CN=First Storage Group,CN=Inf
                              ormationStore,CN=WIN2K8EX2007,CN=Servers,CN=Excha
                              nge Administrative Group (FYDIBOHF23SPDLT),CN=Adm
                              inistrative Groups,CN=First Organization,CN=Micro
                              soft Exchange,CN=Services,CN=Configuration,DC=tri
                              virdev,DC=com
MailboxRetention            : 30.00:00:00
DeletedItemRetention        : 14.00:00:00
EventHistoryRetentionPeriod : 7.00:00:00

EX2007: powershell commands

Connect-Mailbox -Identity (Get-MailboxStatistics  | where { $\_.DisconnectDate -ne $null -and $\_.LastLoggedOnUserAccount -like '\*\\BRENT'}).DisplayName.ToString() -database:(Get-MailboxStatistics  | where { $\_.DisconnectDate -ne $null -and $\_.LastLoggedOnUserAccount -like '\*\\BRENT'}).Database.ToString() -Confirm:$FALSE -Alias 'Ex.Acct24' -User (Get-MailboxStatistics  | where { $\_.DisconnectDate -ne $null -and $\_.LastLoggedOnUserAccount -like '\*\\BRENT'}).LastLoggedOnUserAccount.ToString()
if running pwershell on a non-exchange server:
Connect-Mailbox -Identity (get-mailboxserver | Get-MailboxStatistics  | where { $\_.DisconnectDate -ne $null -and $\_.LastLoggedOnUserAccount -like '\*\\BRENT'}).DisplayName.ToString() -database:(get-mailboxserver | Get-MailboxStatistics  | where { $\_.DisconnectDate -ne $null -and $\_.LastLoggedOnUserAccount -like '\*\\BRENT'}).Database.ToString() -Confirm:$FALSE -Alias 'Ex.Acct24DDD' -User (get-mailboxserver | Get-MailboxStatistics  | where { $\_.DisconnectDate -ne $null -and $\_.LastLoggedOnUserAccount -like '\*\\BRENT'}).LastLoggedOnUserAccount.ToString()
\[PS\] C:\\Documents and Settings\\Administrator.TESTDEV>
\[PS\] C:\\Documents and Settings\\Administrator.TESTDEV>
\[PS\] C:\\Documents and Settings\\Administrator.TESTDEV>Connect-Mailbox -Identity
Get-MailboxStatistics  | where { $\_.DisconnectDate -ne $null -and $\_.LastLogged
nUserAccount -like '\*\\BRENT'}).DisplayName.ToString() -database:(Get-MailboxSta
istics  | where { $\_.DisconnectDate -ne $null -and $\_.LastLoggedOnUserAccount -
ike '\*\\BRENT'}).Database.ToString() -Confirm:$FALSE -Alias 'Ex.Acct24' -User (Get-MailboxStatistics  | where { $\_.DisconnectDate -ne $null -and $\_.LastLoggedOnUserAccount -like '\*\\BRENT'}).LastLoggedOnUserAccount.ToString()
Get-MailboxStatistics : The local machine is not an Exchange server. Please spe
cify the name of a Mailbox server.
At line:1 char:49
\+ Connect-Mailbox -Identity (Get-MailboxStatistics  <<<<  | where { $\_.Disconne
ctDate -ne $null -and $\_.LastLoggedOnUserAccount -like '\*\\BRENT'}).DisplayName.
ToString() -database:(Get-MailboxStatistics  | where { $\_.DisconnectDate -ne $n
ull -and $\_.LastLoggedOnUserAccount -like '\*\\BRENT'}).Database.ToString() -Conf
irm:$FALSE -Alias 'Ex.Acct24' -User (Get-MailboxStatistics  | where { $\_.Discon
nectDate -ne $null -and $\_.LastLoggedOnUserAccount -like '\*\\BRENT'}).LastLogged
OnUserAccount.ToString()
You cannot call a method on a null-valued expression.
At line:1 char:159
\+ Connect-Mailbox -Identity (Get-MailboxStatistics  | where { $\_.DisconnectDate
 -ne $null -and $\_.LastLoggedOnUserAccount -like '\*\\BRENT'}).DisplayName.ToStri
ng( <<<< ) -database:(Get-MailboxStatistics  | where { $\_.DisconnectDate -ne $n
ull -and $\_.LastLoggedOnUserAccount -like '\*\\BRENT'}).Database.ToString() -Conf
irm:$FALSE -Alias 'Ex.Acct24' -User (Get-MailboxStatistics  | where { $\_.Discon
nectDate -ne $null -and $\_.LastLoggedOnUserAccount -like '\*\\BRENT'}).LastLogged
OnUserAccount.ToString()
\[PS\] C:\\Documents and Settings\\Administrator.TESTDEV>

Show disconnected mailboxes
Get-MailboxStatistics  | where { $\_.DisconnectDate -ne $null } | fl

AssociatedItemCount     : 4
DeletedItemCount        : 0
DisconnectDate          : 7/6/2009 3:41:01 PM
DisplayName             : Aaron V. Kynaston
ItemCount               : 2
LastLoggedOnUserAccount : TRIVIRDEV\\akynaston
LastLogoffTime          : 7/6/2009 3:39:48 PM
LastLogonTime           : 7/6/2009 3:39:20 PM
LegacyDN                : /O=FIRST ORGANIZATION/OU=EXCHANGE ADMINISTRATIVE GROU
                          P (FYDIBOHF23SPDLT)/CN=RECIPIENTS/CN=AKYNASTON
MailboxGuid             : 177ecab4-a64f-4337-87ee-fccc9b39c612
ObjectClass             : Mailbox
StorageLimitStatus      :
TotalDeletedItemSize    : 0B
TotalItemSize           : 7568B
Database                : WIN2K8EX2007\\First Storage Group\\Mailbox Database
ServerName              : WIN2K8EX2007
StorageGroupName        : First Storage Group
DatabaseName            : Mailbox Database
Identity                : 177ecab4-a64f-4337-87ee-fccc9b39c612
IsValid                 : True
OriginatingServer       : win2k8ex2007.trivirdev.com

get-mailboxstatistics | where {$\_.Disconnectdate -ne $null}  |  fl
AssociatedItemCount     : 9
DeletedItemCount        : 0
DisconnectDate          : 7/21/2009 10:23:52 AM
DisplayName             : BlackXXX, Marty
ItemCount               : 13
LastLoggedOnUserAccount : TRIVIRDEV\\jblackxxx
LastLogoffTime          : 7/21/2009 10:23:10 AM
LastLogonTime           : 7/21/2009 10:23:09 AM
LegacyDN                : /O=FIRST ORGANIZATION/OU=EXCHANGE ADMINISTRATIVE GROU
                          P (FYDIBOHF23SPDLT)/CN=RECIPIENTS/CN=JBLACKXXX
MailboxGuid             : 78a1784b-7a5a-4c76-848c-d777dfabccb8
ObjectClass             : Mailbox
StorageLimitStatus      :
TotalDeletedItemSize    : 0B
TotalItemSize           : 23468B
Database                : WIN2K8EX2007\\First Storage Group\\MailboxDatabase3
ServerName              : WIN2K8EX2007
StorageGroupName        : First Storage Group
DatabaseName            : MailboxDatabase3
Identity                : 78a1784b-7a5a-4c76-848c-d777dfabccb8
IsValid                 : True
OriginatingServer       : win2k8ex2007.trivirdev.com
AssociatedItemCount     : 4
DeletedItemCount        : 0
DisconnectDate          : 7/8/2009 2:28:11 PM
DisplayName             : in3rd
ItemCount               : 2
LastLoggedOnUserAccount : TRIVIRDEV\\in3rd
LastLogoffTime          : 7/8/2009 2:27:58 PM
LastLogonTime           : 7/8/2009 2:27:22 PM
LegacyDN                : /O=FIRST ORGANIZATION/OU=EXCHANGE ADMINISTRATIVE GROU
                          P (FYDIBOHF23SPDLT)/CN=RECIPIENTS/CN=IN3RD
MailboxGuid             : 1865d5cc-438d-47b2-8d68-ebcf6ff00e50
ObjectClass             : Mailbox
StorageLimitStatus      :
TotalDeletedItemSize    : 0B
TotalItemSize           : 7519B
Database                : WIN2K8EX2007\\First Storage Group\\MailboxDatabase3
ServerName              : WIN2K8EX2007
StorageGroupName        : First Storage Group
DatabaseName            : MailboxDatabase3
Identity                : 1865d5cc-438d-47b2-8d68-ebcf6ff00e50
IsValid                 : True
OriginatingServer       : win2k8ex2007.trivirdev.com
\[PS\] C:\\Windows\\System32>

To ensure that a mailbox is created int he database run this: (it logs in as the user so that it forces the mailbox to exist - run this if you jujst reated it and want to disable it)
test-mapiconnectivity -id hsimpson@trivirdev.com

re-mount a mailbox database:
\[PS\] C:\\>get-mailboxdatabase
Name                 Server          StorageGroup         Recovery
\----                 ------          ------------         --------
Mailbox Database     WIN2K8EX2007    First Storage Group  False
MailboxDatabase2     WIN2K8EX2007    First Storage Group  False
\[PS\] C:\\>mount-database mailboxdatabase2
\[PS\] C:\\>

Create a newmailbox database - note the fialure here is what happened throught eh gui . . I was able to mount-database later (I think that's the call)

new-mailboxdatabase -StorageGroup 'WIN2K8EX2007\\First Storage Group' -Name 'MailboxDatabase2' -EdbFilePath 'C:\\Program Files\\Microsoft\\Exchange Server\\Mailbox\\First Storage Group\\MailboxDatabase2.edb'
Mount MailboxDatabase2
Failed
Error:
Exchange is unable to mount the database that you specified. Specified database: WIN2K8EX2007\\First Storage Group\\MailboxDatabase2; Error code: MapiExceptionADUnavailable: Unable to mount database. (hr=0x80004005, ec=2414)
Exchange Management Shell command attempted:
mount-database -Identity 'CN=MailboxDatabase2,CN=First Storage Group,CN=InformationStore,CN=WIN2K8EX2007,CN=Servers,CN=Exchange Administrative Group (FYDIBOHF23SPDLT),CN=Administrative Groups,CN=First Organization,CN=Microsoft Exchange,CN=Services,CN=Configuration,DC=trivirdev,DC=com'
Elapsed Time: 00:03:01

.

Show all users and their recpient types, separate ex2003/2007. in this, 0.0 = ex2003, 0.1 = 2007
\[PS\] C:\\>get-user | group-object -property:RecipientType, ExchangeVersion
Count Name                      Group
\----- ----                      -----
    1 UserMailbox, 0.0 (6.5.... {Administrator}
   10 User, 0.0 (6.5.6500.0)    {Guest, SUPPORT\_388945a0, krbtgt, IUSR\_TRIVI...
    8 UserMailbox, 0.1 (8.0.... {aaaa a. aaaa, secondstragegrp i. lastn, ccc...
    1 MailUser, 0.0 (6.5.650... {lastname, aaron}
\[PS\] C:\\>

Read from edirectory:
$domainRoot = New-Object System.DirectoryServices.DirectoryEntry
$domainRoot.PSBase.Children (lists all children)

Mailstore related calls: 
Example fcpsTargetHomeMDB, full slash format of the database:
MB12\\MB12DB03\\MB12SG4
\[PS\] C:\\Windows\\system32>get-mailboxserver | select name
2/24/2014 5:01:56 PM- need to get example of retrieivng all amilbxod atabases . . .

Clean up of disconnected mailboxes on KU script: (RemovedisabledMailboxes.ps1)

Write-Host "Before disabling"
write-host (Get-MailboxDatabase)\[0\].name
Get-MailboxStatistics -Database  (Get-MailboxDatabase)\[0\].name | where {$\_.DisconnectReason -eq "Disabled"}
write-host (Get-MailboxDatabase)\[1\].name
Get-MailboxStatistics -Database  (Get-MailboxDatabase)\[1\].name | where {$\_.DisconnectReason -eq "Disabled"}
write-host  (Get-MailboxDatabase)\[2\].name
Get-MailboxStatistics -Database  (Get-MailboxDatabase)\[2\].name | where {$\_.DisconnectReason -eq "Disabled"}
#DISABLED to avoid accidental removal of disconnected mailboxes
Get-MailboxStatistics -Database  (Get-MailboxDatabase)\[0\].name | where {$\_.DisconnectReason -eq "Disabled"} | foreach {Remove-
StoreMailbox -Database $\_.database -Identity $\_.mailboxguid -MailboxState Disabled -Confirm:$false; sleep 50 }
Get-MailboxStatistics -Database  (Get-MailboxDatabase)\[1\].name | where {$\_.DisconnectReason -eq "Disabled"} | foreach {Remove-
StoreMailbox -Database $\_.database -Identity $\_.mailboxguid -MailboxState Disabled -Confirm:$false; sleep 50 }
Get-MailboxStatistics -Database  (Get-MailboxDatabase)\[2\].name | where {$\_.DisconnectReason -eq "Disabled"} | foreach {Remove-
StoreMailbox -Database $\_.database -Identity $\_.mailboxguid -MailboxState Disabled -Confirm:$false; sleep 50 }
Write-Host "Remaining disabled:"
write-host (Get-MailboxDatabase)\[0\].name
Get-MailboxStatistics -Database  (Get-MailboxDatabase)\[0\].name | where {$\_.DisconnectReason -eq "Disabled"}
write-host (Get-MailboxDatabase)\[1\].name
Get-MailboxStatistics -Database  (Get-MailboxDatabase)\[1\].name | where {$\_.DisconnectReason -eq "Disabled"}
write-host  (Get-MailboxDatabase)\[2\].name
Get-MailboxStatistics -Database  (Get-MailboxDatabase)\[2\].name | where {$\_.DisconnectReason -eq "Disabled"}

Get disk information:
GET-WMIOBJECT -query "SELECT \* from win32\_logicaldisk where DriveType = 3"
DeviceID     : C:
DriveType    : 3
ProviderName :
FreeSpace    : 65889873920
Size         : 479996145664
VolumeName   :
DeviceID     : H:
DriveType    : 3
ProviderName :
FreeSpace    : 63636398080
Size         : 500000878592
VolumeName   :
