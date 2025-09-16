---
tags: ["#ex2007"]
---
# WARNING: No Client Access servers were tested.

WARNING: No Client Access servers were tested.
\[PS\] C:\\Novell\\RemoteLoader\\PowerShellScripts>get-mailbox \*cas\*
Get-Mailbox : The operation could not be performed because object '\*cas\*' could
 not be found on domain controller 'trivir-au0gsloj.trivirdev.com'.
At line:1 char:12
\+ get-mailbox  <<<< \*cas\*
\[PS\] C:\\Novell\\RemoteLoader\\PowerShellScripts>& 'C:\\Program Files'\\ex
\[PS\] C:\\Novell\\RemoteLoader\\PowerShellScripts>new-TestCasConnectivityUser.ps1
Please enter a temporary secure password for creating test users.  For security
, the password will be changed regularly and automatically by the system.
Enter password: \*\*\*\*\*\*
Create test user on:  WIN2K8EX2007.trivirdev.com
Control-Break to quit or Enter to continue:
There are multiple organizational units matching the identity "Users". Please s
pecify a unique value.
At C:\\Program Files\\Microsoft\\Exchange Server\\Scripts\\new-TestCasConnectivityUs
er.ps1:46 char:4
\+       n <<<< ew-Mailbox -Name:$UserName -Alias:$UserName -UserPrincipalName:$
UserPrincipalName -SamAccountName:$SamAccountName -Password:$SecurePassword -Da
tabase:$mailboxDatabaseName  -OrganizationalUnit:Users -ErrorVariable err -Erro
rAction SilentlyContinue
Please specify the OrganizationalUnit.: testusers
Name                      Alias                ServerName       ProhibitSendQuo
                                                                ta
\----                      -----                ----------       ---------------
CAS\_{fbdd554565104f38}    CAS\_{fbdd55456510... win2k8ex2007     unlimited
UserPrincipalName:  CAS\_fbdd554565104f38@trivirdev.com
AccessRights        : {ExtendedRight}
ExtendedRights      : {User-Force-Change-Password}
ChildObjectTypes    :
InheritedObjectType :
Properties          :
IsValid             : True
Deny                : False
InheritanceType     : All
User                : TRIVIRDEV\\Exchange Servers
Identity            : trivirdev.com/testusers/CAS\_{fbdd554565104f38}
IsInherited         : False
ObjectState         : Unchanged
AccessRights        : {ExtendedRight}
ExtendedRights      : {User-Force-Change-Password}
ChildObjectTypes    :
InheritedObjectType :
Properties          :
IsValid             : True
Deny                : False
InheritanceType     : All
User                : TRIVIRDEV\\Exchange Recipient Administrators
Identity            : trivirdev.com/testusers/CAS\_{fbdd554565104f38}
IsInherited         : False
ObjectState         : Unchanged
ClientAccessServer     : WIN2K8EX2007.trivirdev.com
Scenario               : Reset Credentials
ScenarioDescription    : Reset automated credentials for the Client Access test
                          user on Mailbox server WIN2K8EX2007.trivirdev.com.
PerformanceCounterName :
Result                 : Success
MailboxServer          : WIN2K8EX2007.trivirdev.com
StartTime              : 7/22/2009 9:48:39 AM
Latency                : 00:00:19.8370432
SecureAccess           : True
Error                  :
UserName               : CAS\_fbdd554565104f38
VirtualDirectoryName   :
Url                    :
UrlType                : Unknown
EventType              : Success
Port                   : 0
ConnectionType         : Plaintext
You can um-enable the test user by running this command with the following optio
nal parameters : \[-UMDialPlan <dialplanname> -UMExtension <numDigitsInDialplan>\]
 .Either None or Both must be present.
\[PS\] C:\\Novell\\RemoteLoader\\PowerShellScripts>
