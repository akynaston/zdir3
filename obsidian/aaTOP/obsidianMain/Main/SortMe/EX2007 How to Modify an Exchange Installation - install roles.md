---
tags: ["#ex2007","#c-fcps"]
---
# EX2007: How to Modify an Exchange Installation - install roles

**_This was helpful when I needed to re-install the mailbox role after it had failed:_**

setup.com /mode:install /roles:mailbox
I also had to give rights to my domain administrator to C:\\program files\\microsoft\\exchange server directory

**_I'm running setup from the same setup.exe I do to install iexchange int he first place._**

**_Applies to:_** _Exchange Server 2007 SP1, Exchange Server 2007_ **_Topic Last Modified:_** _2007-08-08_

This topic explains how to use Setup.com or the Control Panel in Windows Server to modify a Microsoft Exchange Server 2007 installation. You can modify an Exchange 2007 installation in the following ways:

* Add an Exchange 2007 server role to an existing Exchange 2007 server.
* In a clustered scenario, designate the active node in the cluster.
* Remove Exchange 2007 server roles or remove Exchange from an Exchange 2007 server. To remove server roles or to remove Exchange, you must use the **Control Panel** in Windows Server or Setup.com from a Command Prompt window.

![[./_resources/EX2007_How_to_Modify_an_Exchange_Installation_-_install_roles.resources/clear.gif]] Before You Begin

To perform the following procedure, the account you use must be delegated the following:

* Membership in the Enterprise Administrators group
* Membership in the Domain Administrators group

For more information about permissions, delegating roles, and the rights that are required to administer Exchange Server 2007, see [Permission Considerations](http://technet.microsoft.com/en-us/library/aa996881.aspx).

Before you perform the procedure in this topic, confirm the following:

* You have already installed Exchange 2007 on the server on which you want to add a server role.
* For e-mail messages to flow correctly, you must install both the Mailbox server role and the Hub Transport server role in each Active Directory directory service site.
* For client access to work correctly, you must install a Client Access server in each Active Directory site that has a Mailbox server.
* You can install the Mailbox server role, the Hub Transport server role, the Client Access server role, and the Unified Messaging server role on the same computer or on separate computers.
* Confirm that your organization meets the requirements that are listed in [Exchange 2007 System Requirements](http://technet.microsoft.com/en-us/library/aa996719.aspx).

Also, before you perform this procedure, be aware of the following:

* You cannot add an Exchange 2007 Service Pack 1 (SP1) server role to a computer that is running the release to manufacturing (RTM) version of Exchange 2007. To add an Exchange 2007 SP1 server role, you must first upgrade the server to Exchange 2007 SP1. For more information about upgrading, see [How to Upgrade to Exchange 2007 SP1](http://technet.microsoft.com/en-us/library/bb629489.aspx).
* If you have Exchange 2007 SP1 installed on Windows Server 2003, you must use Exchange 2007 SP1 Setup.com or **Add or Remove Programs** from the Control Panel to add server roles. If you have Exchange 2007 SP1 installed on Windows Server 2008, you must use Exchange 2007 SP1 Setup.com or **Programs and Features** from the Control Panel to add server roles.

![[./_resources/EX2007_How_to_Modify_an_Exchange_Installation_-_install_roles.resources/clear.gif]] Procedure
![[./_resources/EX2007_How_to_Modify_an_Exchange_Installation_-_install_roles.resources/clear.gif]] To use Setup.com to modify an Exchange installation

1. Log on to the server on which you want modify the Exchange 2007 installation.
	
2. Open a Command Prompt window and navigate to the directory where you installed Exchange. By default, this is %programfiles%\\Microsoft\\Exchange Server.
	
3. Navigate to the bin directory.
	
4. If you are adding a server role to or removing a server role from an existing Exchange 2007 server, at a command prompt, type the following:
	
	**Setup.com /mode:<** _setup mode_ **\> /roles:<** _server roles to install_ **\> \[-OrganizationName:<** _name for the new Exchange organization_ **\>\] \[/TargetDir:<** _target directory_ **\>\] \[/SourceDir:** _<source directory>_ **\] \[/UpdatesDir:<** _directory from which to install updates_ **\>\] \[/DomainController:<** _domain controller_ **\>\] \[/AnswerFile:<** _filename_ **\>\] \[/DoNotStartTransport\] \[/EnableLegacyOutlook\] \[/LegacyRoutingServer\] \[/EnableErrorReporting\] \[/NoSelfSignedCertificates\] \[/AdamLdapPort\] \[/AdamSslPort\] \[.AddUmLanguagePack:<UM language pack name\] \[/RemoveUmLanguagePack:<** _UM language pack name_ **\>\] \[/?\]**
	
	The following describe the command parameters:
	
	* _/mode:_, or _/m_:_<setup mode>_
		You must use the _/mode_ parameter to specify the setup mode. If you do not specify a mode, Setup.com uses the default Install mode. Select one of the following modes:
		Install
		Upgrade
		Uninstall
		RecoverServer
			|     |
		| --- |
		| **![[./_resources/EX2007_How_to_Modify_an_Exchange_Installation_-_install_roles.resources/Bb124273.gif]]Note:** |
		| You can only use the Upgrade mode to upgrade from a previous pre-release version of Exchange 2007. You cannot perform an in-place upgrade of a previous Exchange version to Exchange 2007. |
		
		|     |
		| --- |
		| **![[./_resources/EX2007_How_to_Modify_an_Exchange_Installation_-_install_roles.resources/Bb124273.gif]]Note:** |
		| Use the RecoverServer mode to recover a server installation. For more information, see [Server Recovery](http://technet.microsoft.com/en-us/library/bb124275.aspx). |
		
	* _/roles:_, or _/r:<server roles to install>_
		You must use the _/roles_ parameter to specify which server roles to install or remove. Select from one or more of the following roles, in a comma-separated list:
		ClientAccess (or CA, or C)
		EdgeTransport (or ET, or E)
		HubTransport (or HT, or H)
			|     |
		| --- |
		| **![[./_resources/EX2007_How_to_Modify_an_Exchange_Installation_-_install_roles.resources/Bb124273.gif]]Note:** |
		| The Edge Transport server role cannot coexist on the same computer with any other server role. |
		
		|     |
		| --- |
		| **![[./_resources/EX2007_How_to_Modify_an_Exchange_Installation_-_install_roles.resources/Bb124273.gif]]Note:** |
		| You must deploy the Edge Transport server role in the perimeter network and outside the Active Directory forest. |
		
		Mailbox (or MB, or M)
		UnifiedMessaging (or UM, or U)
		ManagementTools (or MT, or T)
		
		|     |
		| --- |
		| **![[./_resources/EX2007_How_to_Modify_an_Exchange_Installation_-_install_roles.resources/Bb124273.gif]]Note:** |
		| If you specify ManagementTools, you will install the Exchange Management Console, the Exchange cmdlets for the Exchange Management Shell, the Exchange Help file, the Exchange Best Practices Analyzer Tool, and the Exchange Troubleshooting Assistant. If you install any other server role, the management tools will be installed automatically. |
		
		For example, to add the Hub Transport server role to an existing Mailbox server, type the following: **%LocalExchangeInstallationDir%\\bin\\Setup.com /role:HubTransport /Mode:Install**
		For example, to remove the Client Access server role from an existing server, type the following: **%LocalExchangeInstallationDir%\\bin\\Setup.com /role:ClientAccess /Mode:Uninstall**
		
	* \[_/OrganizationName:_, or _/on:<organization name>_\]
		Use the _/OrganizationName_ parameter to specify the name to give the new Exchange organization. This parameter is required if you are installing the first server in an organization. If you are installing a server in an existing Exchange organization, you cannot use this parameter.
	* \[_/TargetDir:, or /t:<target directory>_\]
		Use the _/TargetDir_ parameter to specify the location to install Exchange 2007 files. The default location is %programfiles%\\Microsoft\\Exchange Server.
	* \[_/SourceDir:, or /s:<source directory>_\]
		Use the _/SourceDir_ parameter to specify the location of the Exchange source files. By default, Setup uses the location of the source files when you initially installed Exchange 2007. You need to use this parameter only if you change the source location.
	* \[_/UpdatesDir:_, or _/u:<updates directory>_\]
		Use the _/UpdatesDir_ parameter to specify the directory from which updates will be installed. Files in the updates directory must be either an Updates.exe file, or one or more \*.msp files.
	* \[_/DomainController:_, or _/dc:<domain controller>_\]
		Use the _/DomainController_ parameter to specify the domain controller to use to read from and write to Active Directory during setup. You can use NetBIOS or fully qualified domain name (FQDN) format.
	* \[_/AnswerFile:_, or _/af_:_<filename>_\]
		Use the _/AnswerFile_ parameter to specify the location of a file that contains advanced parameters for setup. The advanced parameters that you can use in the answer file are EnableErrorReporting, NoSelfSignedCertificates, AdamLdapPort, and AdamSslPort.
	* \[_/DoNotStartTransport_\]
		Use the /_DoNotStartTransport_ parameter to specify that the Microsoft Exchange Transport service will not start when Setup completes. If you need to do additional configuration before the Edge Transport or Hub Transport server accepts e-mail, for example, configuring anti-spam agents, you should use this parameter.
	* \[_/EnableLegacyOutlook_\]
		Use the /_EnableLegacyOutlook_ parameter to specify that you have client computers that are running Microsoft Office Outlook 2003 or earlier. Exchange 2007 will create a public folder database on the mailbox server. If all of your client computers are running Office Outlook 2007, public folders are optional in Exchange 2007. If you do not use this parameter, Exchange 2007 will not create a public folder database on the Mailbox server. You can add a public folder database later.
		You can only use this parameter if you are installing the first Mailbox server in an organization.
	* \[_/LegacyRoutingServer_\]
		Use the /_LegacyRoutingServer_ parameter to specify the Exchange 2003 or Exchange 2000 bridgehead server on which you will create a routing group connector for coexistence between Exchange 2007 and either Exchange 2003 or Exchange 2000.
		You can only use this parameter if you are installing the first Hub Transport server in an organization.
	* \[_/EnableErrorReporting_\]
		Use the /_EnableErrorReporting_ parameter to enable error reporting during setup.
	* \[_/NoSelfSignedCertificates_\]
		Use the /_NoSelfSignedCertificates_ parameter if you do not want Setup to create self-signed certificates in the case where no other valid certificate is found for Secure Sockets Layer (SSL) or Transport Layer Security (TLS) sessions.
		You can only use this parameter if you are installing either the Client Access server role or the Unified Messaging server role.
	* \[_/AdamLdapPort_\]
		Use the /_AdamLdapPort_ parameter to specify the Lightweight Directory Access Protocol (LDAP) port to use for the Edge Transport server role Active Directory Application Mode (ADAM) instance.
		You can only use this parameter if you are installing the Edge Transport server role.
	* \[_/AdamSslPort_\]
		Use the /_AdamSslPort_ parameter to specify the SSL port to use for the Edge Transport server role ADAM instance.
		You can only use this parameter if you are installing the Edge Transport server role.
	* \[_/AddUmLanguagePack:<UM language pack name>_\]
		Use the /_AddUmLanguagePack_ parameter to specify a Unified Messaging language pack that you want to add. For a list of Unified Messaging languages, see [Understanding Unified Messaging Languages](http://technet.microsoft.com/en-us/library/bb124728.aspx).
	* \[_/RemoveUmLanguagePack:<UM language pack name>_\]
		Use the /_RemoveUmLanguagePack_ parameter to specify a Unified Messaging language pack that you want to remove. For a list of Unified Messaging languages, see [Understanding Unified Messaging Languages](http://technet.microsoft.com/en-us/library/bb124728.aspx).
	* \[_/?_\]
		Use the _/?_ parameter to display Help for the Setup.com command.
5. If you are designating the active node of a clustered mailbox server, use the following syntax for Setup.com:
	
	Setup.com \[/NewCms\] \[/CMSName:< _name_ \>\] \[/CMSIPAddress:< _IP address_ \>\] \[/CMSSharedStorage\] \[/CMSDataPath:< _CMS data path_ \>\] \[/DomainController:< _name of domain controller_ \>\]
	
	The following describe the command parameters:
	
	* \[_/NewCms_\]
		Use the _/NewCms_ parameter to create a new Exchange 2007 clustered mailbox server.
	* \[_/CMSName_, or _/cn_\]
		Use the _/CMSName_ parameter to specify the name of the Exchange clustered mailbox server.
	* \[_/CMSIPAddress_, or _/cip_\]
		Use the _/CMSIPAddress_ parameter to specify the IP address of the Exchange clustered mailbox server.
	* \[_/CMSSharedStorage_, or _/css_\]
		Use the _/CMSSharedStorage_ parameter to specify that this cluster node uses shared storage. By default, the cluster node will not use shared storage.
	* \[_/CMSDataPath_, or _/cdp_\]
		Use the _/CMSDataPath_ parameter to specify the path for shared disks.
	* \[_/DomainController_, or _/dc_\]
		Use the _/DomainController_ parameter to specify the name of the domain controller to use during setup.

![[./_resources/EX2007_How_to_Modify_an_Exchange_Installation_-_install_roles.resources/clear.gif]] How to use the Control Panel to modify an Exchange installation

1. In Control Panel, perform one of the following steps:
	
	* If you are running Windows Server 2003, double-click **Add or Remove Programs**.
	* If you are running Windows Server 2008, double-click **Programs and Features**.
2. In **Add or Remove Programs** or **Programs and Features**, select **Microsoft Exchange Server 2007**.
	
3. To remove server roles or remove Exchange, perform one of the following steps:
	
	* If you are running Windows Server 2003, click **Remove**.
	* If you are running Windows Server 2008, click **Uninstall**.
	
	To add server roles or to designate the active node in a cluster, click **Change**.
	

1. In the Exchange Server 2007 Setup wizard, on the **Exchange Maintenance Mode** page, click **Next**.
	
2. On the **Server Role Selection** page, if you are removing server roles, clear the server roles that you want to remove, and then click **Next**. If you are adding server roles or adding a Clustered Mailbox server role, click the server role that you want to add, and then click **Next**.
	
3. If you are adding the **Hub Transport Role**, and if you are installing Exchange 2007 in a forest that has an existing Exchange Server 2003 or Exchange 2000 Server organization, on the **Mail Flow Settings** page, select a bridgehead server in the existing organization that is a member of the Exchange 2003 or Exchange 2000 routing group to which you want to create a routing group connector.
	
	|     |
	| --- |
	| ![[./_resources/EX2007_How_to_Modify_an_Exchange_Installation_-_install_roles.resources/Bb124273.gif]]**Note:** |
	| The Exchange 2007 routing topology is based on Active Directory sites and does not use routing groups. However, to enable mail flow between Exchange 2007 and Exchange 2003 or Exchange 2000, there must be a routing group connector between the Exchange 2007 routing group and the routing group in the Exchange 2003 or Exchange 2000 organization. |
	
4. On the **Readiness Checks** page, view the status to determine if the organization and server role prerequisite checks completed successfully. If they completed successfully, click **Uninstall** to uninstall Exchange 2007 server roles or click **Install** to install Exchange 2007 server roles.
	
5. On the **Completion** page, click **Finish**.
	

![[./_resources/EX2007_How_to_Modify_an_Exchange_Installation_-_install_roles.resources/clear.gif]] For More Information

For information about using the Exchange Server 2007 Setup wizard to install Exchange 2007, see one of the following topics:

* [How to Perform a Typical Installation Using Exchange Server 2007 Setup](http://technet.microsoft.com/en-us/library/bb123694.aspx)
* [How to Perform a Custom Installation Using Exchange Server 2007 Setup](http://technet.microsoft.com/en-us/library/bb125143.aspx)

For detailed steps about how to install Exchange 2007 in unattended mode, see [How to Install Exchange 2007 in Unattended Mode](http://technet.microsoft.com/en-us/library/aa997281.aspx).

For more information about installing a clustered Mailbox server, see the following topics:

* [Installing Cluster Continuous Replication on Windows Server 2003](http://technet.microsoft.com/en-us/library/aa997144.aspx)
* [Installing a Single Copy Cluster on Windows Server 2003](http://technet.microsoft.com/en-us/library/bb124899.aspx)

For more information about removing Exchange, see the following topics:

* [How to Remove Exchange 2007 Server Roles](http://technet.microsoft.com/en-us/library/bb124115.aspx)
* [How to Completely Remove Exchange 2007 from a Server](http://technet.microsoft.com/en-us/library/bb123893.aspx)
* [How to Remove an Exchange 2007 Organization](http://technet.microsoft.com/en-us/library/aa998313.aspx)

For information about how to configure each of the server roles after installation, see [Post-Installation Tasks](http://technet.microsoft.com/en-us/library/bb124397.aspx).

For information about the feature changes between Windows Server 2003 and Windows Server 2008, see [Terminology Changes](http://technet.microsoft.com/en-us/library/bb123550.aspx).

Tags [![[./_resources/EX2007_How_to_Modify_an_Exchange_Installation_-_install_roles.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCTagEditor/resources/taghelp.htm):  [Add a tag](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)  [Add](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)   [Cancel](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
Flag as [ContentBug](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
![[./_resources/EX2007_How_to_Modify_an_Exchange_Installation_-_install_roles.resources/clear.gif]]
Community Content   [![[./_resources/EX2007_How_to_Modify_an_Exchange_Installation_-_install_roles.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCSection/resources/cchelp.htm)

|     |     |     |
| --- | --- | --- |
|     | [![[./_resources/EX2007_How_to_Modify_an_Exchange_Installation_-_install_roles.resources/clear.gif]]](http://technet.microsoft.com/en-us/library/community-edits.rss?topic=bb124273\|en-us\|80)  Annotations |     |

|     |     |     |
| --- | --- | --- |
| Checking Installed Roles |     | [flaphead](http://technet.microsoft.com/en-us/library/user-flaphead) ... [Thomas Lee](http://technet.microsoft.com/en-us/library/user-42770.aspx)   \|      \| |

Please Wait  ![[./_resources/EX2007_How_to_Modify_an_Exchange_Installation_-_install_roles.resources/clear.gif]]

To verify what roles have been installed on an Exchange 2007 server you can run the Get-ExchangeServer cmdlet in the Exchange Management Shell.
This will display a list of all Exchange 2007 server roles that are installed on the specified server. You can compare this against the roles you intended to install:

  c:\\ Exchange> get-exchangeserver <servername> | FL
  
ServerRole: ClientAccess, HubTransport

Particular attention should be paid to “ServerRole” In this case we have the ClientAccess and HubTramsport roles installed
