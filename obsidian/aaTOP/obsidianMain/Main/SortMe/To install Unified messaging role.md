---
tags: ["#ex2007"]
---
# To install Unified messaging role:

To install Unified messaging role:

https://wiki.trivir.com/dev/start/ex2007/troubleshooting

setup.com (from place you installed exchange 2007) /role:um /mode:install
if upgrade is needed: setup.com /upgrade

This is the output from an install I've started today, shows me two more prerequsiets:

Microsoft .NET Framework 2.0 Service Pack 1 (SP1)
Microsoft Core XML Services (MSXML) 6.0. (Please install the software from <http://go.microsoft.com/fwlink/?LinkId=70796>)
Timezone update from: [http://go.microsoft.com/fwlink/?LinkID=92858](http://go.microsoft.com/fwlink/?LinkID=92858.)

Note: as a general practice, I've found the install to run much faster if you copy all of the install files to the same drive where exchange is installed.  You 'll need to restart-the isntall a few times, and the first step it takes is to copy all of the files to the drive anyway, so you may as well make it faster.  For htis install, I"m installing from a network drive:

H:\\edrive\\EXCHANGE2007SP1\\EX2K7SP1EN32FILES>setup.com /role:um /mode:install
Welcome to Microsoft Exchange Server 2007 Unattended Setup
Preparing Exchange Setup
    Copying Setup Files              ......................... COMPLETED
The following server roles will be installed
    Unified Messaging Server Role
Performing Microsoft Exchange Server Prerequisite Check
    Organization Checks              ......................... COMPLETED
 When you run Exchange Server 2007 Service Pack 1 (SP1) on Windows Server 2003 o
r earlier versions of the operating system, we recommend that you install Micros
oft .NET Framework 2.0 Service Pack 1 (SP1). If you cannot install .NET Framewor
k 2.0 SP1, install hotfix Microsoft Knowledge Base article 942027 from http://go
.microsoft.com/fwlink/?linkid=101219.
    Unified Messaging Role Checks    ......................... FAILED
 The 32-bit version of Exchange Server 2007 is not supported for production use.
 - [ ] When you run Exchange Server 2007 Service Pack 1 (SP1) on Windows Server 2003 o
r earlier versions of the operating system, we recommend that you install Micros
oft .NET Framework 2.0 Service Pack 1 (SP1). If you cannot install .NET Framewor
k 2.0 SP1, install hotfix Microsoft Knowledge Base article 942027 from http://go
.microsoft.com/fwlink/?linkid=101219.
     This computer requires Microsoft Core XML Services (MSXML) 6.0. Please inst
all the software from http://go.microsoft.com/fwlink/?LinkId=70796.
     This computer requires the update described in <http://go.microsoft.com/fwlink/?LinkID=92858.> Without this update you might encounter incorrect time zone in
formation.
The Exchange Server Setup operation did not complete. For more information, visi
t http://support.microsoft.com and enter the Error ID.
exch   
Exchange Server setup encountered an error.
H:\\edrive\\EXCHANGE2007SP1\\EX2K7SP1EN32FILES>

After installing I tried to run the setup.com, and recieved an 'Access error' and the setup.com wouldn't start.  I rebooted, and it now starts properly.

So far, I've been at this about 45 minutes, mostly waiting for the box to reboot.

H:\\edrive\\EXCHANGE2007SP1\\EX2K7SP1EN32FILES>setup.com /role:um /mode:install
Welcome to Microsoft Exchange Server 2007 Unattended Setup
Preparing Exchange Setup
    Copying Setup Files              ......................... COMPLETED
The following server roles will be installed
    Unified Messaging Server Role
Performing Microsoft Exchange Server Prerequisite Check
    Organization Checks              ......................... COMPLETED
    Unified Messaging Role Checks    ......................... COMPLETED
 The 32-bit version of Exchange Server 2007 is not supported for production use.
Configuring Microsoft Exchange Server
    Organization Preparation         ......................... COMPLETED
     Opening package 'H:\\edrive\\EXCHANGE2007SP1\\EX2K7SP1EN32FILES\\exchangeserver
.msi' failed. Another version of this product is already installed.  Installatio n of this version cannot continue.  To configure or remove the existing version of this product, use Add/Remove Programs on the Control Panel. Error code is 1638.
The Exchange Server Setup operation did not complete. For more information, visi
t http://support.microsoft.com and enter the Error ID.
Exchange Server setup encountered an error.
H:\\edrive\\EXCHANGE2007SP1\\EX2K7SP1EN32FILES>

I've copied the files localally, re-ran the install, and still get the same error.  Some googling leads me to believe that I ahve a different version installed than the sp1 files I have, so I'm running an upgrade.

setup.com /mode:upgrade.

results:
C:\\ex2007sp1>setup.com /mode:upgrade
Welcome to Microsoft Exchange Server 2007 Unattended Setup
Preparing Exchange Setup
The following server roles will be upgraded
    Hub Transport Role
    Client Access Role
    Mailbox Role
    Management Tools
Performing Microsoft Exchange Server Prerequisite Check
    Hub Transport Role Checks        ......................... COMPLETED
 Setup cannot detect an SMTP or Send connector with an address space of '\*'. Mai
l flow to the Internet may not work properly.
    Client Access Role Checks        ......................... COMPLETED
    Mailbox Role Checks              ......................... COMPLETED
Configuring Microsoft Exchange Server
    Preparing Setup                  ......................... COMPLETED
    Removing Exchange Files          ......................... COMPLETED
    Preparing Files                  ......................... COMPLETED
    Copying Exchange files           ......................... COMPLETED
    Hub Transport Server Role        ......................... COMPLETED
    Client Access server role        ......................... COMPLETED
    Mailbox Server Role              ......................... COMPLETED
    Exchange Management Tools        ......................... COMPLETED
    Finalizing Setup                 ......................... COMPLETED
The Microsoft Exchange Server setup operation completed successfully.
C:\\ex2007sp1>

Now, running install again:

C:\\ex2007sp1>setup.com /mode:install /role:um
Welcome to Microsoft Exchange Server 2007 Unattended Setup
Preparing Exchange Setup
The following server roles will be installed
    Unified Messaging Server Role
Performing Microsoft Exchange Server Prerequisite Check
    Unified Messaging Role Checks    ......................... COMPLETED
 The 32-bit version of Exchange Server 2007 is not supported for production use.
Configuring Microsoft Exchange Server
    Copying Exchange files           ......................... COMPLETED
    Unified Messaging Server Role    ......................... FAILED
     Opening package 'C:\\ex2007sp1\\Setup\\ServerRoles\\UnifiedMessaging\\umlang-en-
US.msi' failed. This installation is forbidden by system policy.  Contact your s
ystem administrator. Error code is 1625.
The Exchange Server Setup operation did not complete. For more information, visi
t http://support.microsoft.com and enter the Error ID.
Exchange Server setup encountered an error.
C:\\ex2007sp1>
C:\\ex2007sp1>

Now:
I also had to give rights to my domain administrator to C:\\program files\\microsoft\\exchange server directory.
 - explore to C:\\program files\\Microsoft
 - propertyes of Exchange SErver
 - select security tag, click Add
 - ensure full control is selected, and press ok.

C:\\ex2007sp1>setup.com /mode:install /role:um
Welcome to Microsoft Exchange Server 2007 Unattended Setup
Preparing Exchange Setup
The following server roles will be installed
    Unified Messaging Server Role
Performing Microsoft Exchange Server Prerequisite Check
Configuring Microsoft Exchange Server
    Unified Messaging Server Role    ......................... COMPLETED
The Microsoft Exchange Server setup operation completed successfully.
C:\\ex2007sp1>

YEA YEA YEA!!

To confirm installation was successful, do this in powershell:

\[PS\] C:\\Documents and Settings\\Administrator>get-umserver
Name              DialPlans            Languages            Status
\----              ---------            ---------            ------
DOMAIN2007        {}                   {en-US}              Enabled
\[PS\] C:\\Documents and Settings\\Administrator>

Or this to dump server roles of all servers - see that 'ServerRole' now has unified messaging.

\[PS\] C:\\Documents and Settings\\Administrator>Get-ExchangeServer | fl
Name                              : MEMBERSERVER
DataPath                          : C:\\Program Files\\Exchsrvr
Domain                            : testdev.com
Edition                           : Enterprise
ExchangeLegacyDN                  : /o=First Organization/ou=First Administrati
                                    ve Group/cn=Configuration/cn=Servers/cn=MEM
                                    BERSERVER
Fqdn                              : memberserver.testdev.com
IsHubTransportServer              : False
IsClientAccessServer              : False
IsExchange2007OrLater             : False
IsEdgeServer                      : False
IsMailboxServer                   : False
IsMemberOfCluster                 : No
IsProvisionedServer               : False
IsUnifiedMessagingServer          : False
NetworkAddress                    : {ncacn\_vns\_spp:MEMBERSERVER, netbios:MEMBER
                                    SERVER, ncacn\_np:MEMBERSERVER, ncacn\_spx:ME
                                    MBERSERVER, ncacn\_ip\_tcp:memberserver.testd
                                    ev.com, ncalrpc:MEMBERSERVER}
OrganizationalUnit                : testdev.com/MEMBERSERVER
AdminDisplayVersion               : Version 6.5 (Build 7638.2: Service Pack 2)
Site                              :
ServerRole                        : None
ErrorReportingEnabled             :
StaticDomainControllers           : {}
StaticGlobalCatalogs              : {}
StaticConfigDomainController      :
StaticExcludedDomainControllers   : {}
CurrentDomainControllers          : {}
CurrentGlobalCatalogs             : {}
CurrentConfigDomainController     :
ProductID                         :
IsExchange2007TrialEdition        : False
IsExpiredExchange2007TrialEdition : False
RemainingTrialPeriod              : 00:00:00
IsValid                           : True
OriginatingServer                 : DOMAIN2007.testdev.com
ExchangeVersion                   : 0.0 (6.5.6500.0)
DistinguishedName                 : CN=MEMBERSERVER,CN=Servers,CN=First Adminis
                                    trative Group,CN=Administrative Groups,CN=F
                                    irst Organization,CN=Microsoft Exchange,CN=
                                    Services,CN=Configuration,DC=testdev,DC=com
Identity                          : MEMBERSERVER
Guid                              : 46639134-21e9-4eed-9ecd-644f070c1b69
ObjectCategory                    : testdev.com/Configuration/Schema/ms-Exch-Ex
                                    change-Server
ObjectClass                       : {top, server, msExchExchangeServer}
WhenChanged                       : 1/26/2009 2:14:47 PM
WhenCreated                       : 1/26/2009 6:25:20 AM
Name                              : DOMAIN2007
DataPath                          : C:\\Program Files\\Microsoft\\Exchange Server\\
                                    Mailbox
Domain                            : testdev.com
Edition                           : StandardEvaluation
ExchangeLegacyDN                  : /o=First Organization/ou=Exchange Administr
                                    ative Group (FYDIBOHF23SPDLT)/cn=Configurat
                                    ion/cn=Servers/cn=DOMAIN2007
Fqdn                              : DOMAIN2007.testdev.com
IsHubTransportServer              : True
IsClientAccessServer              : True
IsExchange2007OrLater             : True
IsEdgeServer                      : False
IsMailboxServer                   : True
IsMemberOfCluster                 : No
IsProvisionedServer               : False
IsUnifiedMessagingServer          : True
NetworkAddress                    : {ncacn\_vns\_spp:DOMAIN2007, netbios:DOMAIN20
                                    07, ncacn\_np:DOMAIN2007, ncacn\_spx:DOMAIN20
                                    07, ncacn\_ip\_tcp:DOMAIN2007.testdev.com, nc
                                    alrpc:DOMAIN2007}
OrganizationalUnit                : testdev.com/DOMAIN2007
AdminDisplayVersion               : Version 8.1 (Build 240.6)
Site                              : testdev.com/Configuration/Sites/Default-Fir
                                    st-Site-Name
ServerRole                        : Mailbox, ClientAccess, UnifiedMessaging, Hu
                                    bTransport
ErrorReportingEnabled             :
StaticDomainControllers           : {}
StaticGlobalCatalogs              : {}
StaticConfigDomainController      :
StaticExcludedDomainControllers   : {}
CurrentDomainControllers          : {}
CurrentGlobalCatalogs             : {}
CurrentConfigDomainController     :
ProductID                         :
IsExchange2007TrialEdition        : True
IsExpiredExchange2007TrialEdition : True
RemainingTrialPeriod              : 00:00:00
IsValid                           : True
OriginatingServer                 : DOMAIN2007.testdev.com
ExchangeVersion                   : 0.1 (8.0.535.0)
DistinguishedName                 : CN=DOMAIN2007,CN=Servers,CN=Exchange Admini
                                    strative Group (FYDIBOHF23SPDLT),CN=Adminis
                                    trative Groups,CN=First Organization,CN=Mic
                                    rosoft Exchange,CN=Services,CN=Configuratio
                                    n,DC=testdev,DC=com
Identity                          : DOMAIN2007
Guid                              : a8c19c91-42e1-4093-94b0-0fc6b47d5f0c
ObjectCategory                    : testdev.com/Configuration/Schema/ms-Exch-Ex
                                    change-Server
ObjectClass                       : {top, server, msExchExchangeServer}
WhenChanged                       : 11/23/2009 9:06:50 AM
WhenCreated                       : 1/26/2009 2:42:40 PM
\[PS\] C:\\Documents and Settings\\Administrator>
