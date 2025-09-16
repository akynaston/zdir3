# How to Install Exchange 2007 SP1 Prerequisites on Windows Server 2008 or Windows Vista

 **How to Install Exchange 2007 SP1 Pr...**

  [Switch on low bandwidth view](http://technet.microsoft.com/en-us/library/bb691354(loband).aspx)
![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]]
![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]][Language Filter : All](http://technet.microsoft.com/en-us/library/bb691354.aspx#Mtps_DropDownFilterText)
Visual Basic
C#
C++
J#
JScript
XAML
F#
How to Install Exchange 2007 SP1 Prerequisites on Windows Server 2008 or Windows Vista

**_Applies to:_** _Exchange Server 2007 SP1_ **_Topic Last Modified:_** _2009-02-26_

This topic explains how to install the necessary prerequisites for all Microsoft Exchange Server 2007 Service Pack 1 (SP1) server roles on Windows Server 2008 or Windows Vista.

If you are deploying a new Exchange organization, and you are preparing your Active Directory schema and domain(s) by using a computer running Windows Server 2008, you must first install the Active Directory Domain Services remote management tools on Windows Server 2008 prior to preparing the schema or a domain by using the following command:

ServerManagerCmd -i RSAT-ADDS

|     |
| --- |
| **![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/Bb691354.gif]]Note:** |
| You may need to restart the computer after installing the Active Directory Domain Services remote management tools. You will be notified at the end of the installation process if a system restart is required. |

If Internet Information Services (IIS) components are missing when you install Exchange 2007 SP1, you may experience one or more of the following symptoms in your Exchange organization:

* Users cannot log on to their Exchange mailboxes by using Office Outlook Web Access. In this scenario, when a user specifies a URL such as **http://<ClientAccessServerName>/**Exchange to access a mailbox and then enters the correct credentials, the user receives the following error message:
		The user name or password that you entered is not valid. Try entering it again.
	
	In this scenario, the Exchange Client Access server does not successfully redirect the **/Exchange** request to the **/OWA** virtual directory.
	
* If you try to access the **/Exchange** virtual directory from the Windows 2008-based computer or by using Internet Explorer, you receive one of the following error messages:
		|     |
	| --- |
	| HTTP Error 401.2 - Unauthorized<br><br>You are not authorized to view this page due to invalid authentication headers. |
	| HTTP Error 500.21 - Internal Server Error<br><br>Handler "AboMapperCustom-31169" has a bad module "IsapiModule" in its module list. |
	

For more information about preparing the Active Directory schema and domains, see [How to Prepare Active Directory and Domains](http://technet.microsoft.com/en-us/library/bb125224.aspx).

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] Before You Begin

To perform these procedures, the account you use must be delegated membership in the local Administrators group. For more information about permissions, delegating roles, and the rights that are required to administer Exchange 2007, see [Permission Considerations](http://technet.microsoft.com/en-us/library/aa996881.aspx).

The full installation option of Windows Server 2008 must be used for all Exchange 2007 SP1 servers and management workstations. The Server Core installation option of Windows Server 2008 is not supported for use by Exchange 2007 SP1.

For all server roles other than the Edge Transport server role, you must first join the computer to the appropriate internal Active Directory forest and domain.

When installing the prerequisites for Client Access servers, installation of the RPC over HTTP proxy component is needed only if you plan to enable Outlook Anywhere in your environment.

In each of the procedures below, the steps must be followed in order. It is especially important that the Active Directory Domain Services remote management tools be installed prior to installing any Internet Information Services (IIS) prerequisites.

When installing any server role, the Exchange Management Tools role is also installed. To use the Exchange management tools (the Exchange Management Console or the Exchange Management Shell) to manage all internal server roles (Client Access, Mailbox, Hub Transport, and Unified Messaging) you must also install the prerequisites for the Exchange management tools. For example, on a server that has only the Hub Transport server role installed, you must also install the following IIS components that are required for a management tools installation:

ServerManagerCmd -i Web-Metabase
ServerManagerCmd -i Web-Lgcy-Mgmt-Console

Without these IIS components, you would not be able to manage the Client Access server role from the server that has only the Hub Transport server role installed.

Before you can install Exchange 2007 SP1 on Windows Server 2008 and create a clustered mailbox server, you must also install the Windows Server 2008 Failover Clustering feature. For detailed steps to install the prerequisites for the Mailbox server role and the Failover Clustering feature, see "To install the Windows Server 2008 operating system prerequisites for Mailbox servers" later in this topic.

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] Procedure
![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] To install the Windows Server 2008 operating system prerequisites for Client Access servers

1. Open a Command Prompt window.
	
2. Install Windows PowerShell, which is included in Windows Server 2008 (but not installed by default) by running the following command:
	
	ServerManagerCmd -i PowerShell
	
3. Install the necessary IIS prerequisites by running the following commands in the order in which they are listed:
	
	ServerManagerCmd -i Web-Server
	ServerManagerCmd -i Web-ISAPI-Ext
	ServerManagerCmd -i Web-Metabase
	ServerManagerCmd -i Web-Lgcy-Mgmt-Console
	ServerManagerCmd -i Web-Basic-Auth
	ServerManagerCmd -i Web-Digest-Auth
	ServerManagerCmd -i Web-Windows-Auth
	ServerManagerCmd -i Web-Dyn-Compression
	
4. If the server will support Outlook Anywhere clients, install the RPC over HTTP proxy feature by running the following command:
	
	ServerManagerCmd -i RPC-over-HTTP-proxy
	

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] To install the Windows Server 2008 operating system prerequisites for Client Access servers by using the graphical user interface

1. Start Server Manager. To do this,click **Start**, and then click **Server Manager**.
	
2. In the navigation pane, click **Roles**, and then click **Add Roles** in the details pane.
	
3. In the Add Roles Wizard, click **Next**, and then click to select the **Web Server (IIS)** check box in the **Roles** list.
	
4. Click **Add Required Features** if you are prompted to do so, and then click **Next**.
	
5. Click **Next**, and then click to select the following check boxes in the **Role services** list:
	
	* **ASP.NET**
	* **ISAPI Extensions**
	* **ISAPI Filters**
	* **Server Side Includes**
	* **.NET Extensibility**
	* **Basic Authentication**
	* **Windows Authentication**
	* **Digest Authentication**
	* **Dynamic Content Compression**
	* **IIS 6 Management Compatibility**
	
	When you click to select the **IIS 6 Management Compatibility** check box, the following check boxes are automatically selected:
	
	* **IIS 6 Metabase Compatibility**
	* **IIS 6 WMI Compatibility**
	* **IIS 6 Scripting Tools**
	* **IIS 6 Management Console**
6. Click **Next**, and then click **Install**.
	

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] To install the Windows Server 2008 operating system prerequisites for Edge Transport servers

1. Open a Command Prompt window.
	
2. Install Windows PowerShell, which is included in Windows Server 2008 (but not installed by default) by running the following command:
	
	ServerManagerCmd -i PowerShell
	
3. Install Active Directory Lightweight Directory Services (AD LDS), which was previously known as Active Directory Application Mode (ADAM), by running the following command:
	
	ServerManagerCmd -i ADLDS
	

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] To install the Windows Server 2008 operating system prerequisites for Edge Transport servers by using the graphical user interface

1. Start Server Manager. To do this,click **Start**, and then click **Server Manager**.
	
2. In the navigation pane, click **Roles**, and then click **Add Roles** in the details pane.
	
3. In the Add Roles Wizard, click **Next**, and then click to select the **Active Directory Lightweight Directory Services** check box in the **Roles** list.
	
4. Cllick **Next** two times, and then click **Install**.
	

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] To install the Windows Server 2008 operating system prerequisites for Hub Transport servers

1. Open a Command Prompt window.
	
2. Install Windows PowerShell, which is included in Windows Server 2008 (but not installed by default) by running the following command:
	
	ServerManagerCmd -i PowerShell
	

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] To install the Windows Server 2008 operating system prerequisites for Mailbox servers

1. Open a Command Prompt window.
	
2. Install Windows PowerShell, which is included in Windows Server 2008 (but not installed by default) by running the following command:
	
	ServerManagerCmd -i PowerShell
	
3. Install the necessary IIS prerequisites by running the following commands in the order in which they are listed:
	
	ServerManagerCmd -i Web-Server
	ServerManagerCmd -i Web-ISAPI-Ext
	ServerManagerCmd -i Web-Metabase
	ServerManagerCmd -i Web-Lgcy-Mgmt-Console
	ServerManagerCmd -i Web-Basic-Auth
	ServerManagerCmd -i Web-Windows-Auth
	
4. If the Mailbox server will be clustered, you must also install the Failover Clustering feature by running the following command:
	
	ServerManagerCmd -i Failover-Clustering
	

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] To install the Windows Server 2008 operating system prerequisites for Mailbox servers by using the graphical user interface

1. Start Server Manager. To do this,click **Start**, and then click **Server Manager**.
	
2. In the navigation pane, click **Roles**, and then click **Add Roles** in the details pane.
	
3. In the Add Roles Wizard, click **Next**, and then click to select the **Web Server (IIS)** check box in the **Roles** list.
	
4. Click **Add Required Features** if you are prompted to do so, and then click **Next**.
	
5. Click **Next**, and then click to select the following check boxes in the **Role services** list:
	
	* **ISAPI Extensions**
	* **Basic Authentication**
	* **Windows Authentication**
	* **IIS 6 Management Compatibility**
6. Click **Next**, and then click **Install**.
	

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] To install the Windows Server 2008 operating system prerequisites for Unified Messaging servers

1. Open a Command Prompt window.
	
2. Install Windows PowerShell, which is included in Windows Server 2008 (but not installed by default) by running the following command:
	
	ServerManagerCmd -i PowerShell
	
3. Install the Microsoft Windows Media Player audio/video codecs required by the Unified Messaging server by running the following command:
	
	ServerManagerCmd -i Desktop-Experience
	

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] To install the Windows Server 2008 operating system prerequisites for Unified Messaging servers by using the graphical user interface

1. In Server Manager, click **Features**, and then click **Add Features**.
	
2. In the **Features** list, click to select the **Desktop Experience** check box.
	
3. Click **Next**, and then click **Install**.
	

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] To install the Windows Server 2008 operating system prerequisites for a computer that will host the Hub Transport, Client Access, and Mailbox server roles

1. Open a Command Prompt window.
	
2. Install Windows PowerShell, which is included in Windows Server 2008 (but not installed by default) by running the following command:
	
	ServerManagerCmd -i PowerShell
	
3. Install the necessary IIS prerequisites by running the following commands in the order in which they are listed:
	
	ServerManagerCmd -i Web-Server
	ServerManagerCmd -i Web-ISAPI-Ext
	ServerManagerCmd -i Web-Metabase
	ServerManagerCmd -i Web-Lgcy-Mgmt-Console
	ServerManagerCmd -i Web-Basic-Auth
	ServerManagerCmd -i Web-Digest-Auth
	ServerManagerCmd -i Web-Windows-Auth
	ServerManagerCmd -i Web-Dyn-Compression
	
4. If the server will support Outlook Anywhere clients, install the RPC over HTTP proxy feature by running the following command:
	
	ServerManagerCmd -i RPC-over-HTTP-proxy
	

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] To install the Windows Server 2008 operating system prerequisites for a computer that will host the Hub Transport, Client Access, and Mailbox server roles by using the graphical user interface

1. Start Server Manager. To do this,click **Start**, and then click **Server Manager**.
	
2. In the navigation pane, click **Roles**, and then click **Add Roles** in the details pane.
	
3. In the Add Roles Wizard, click **Next**, and then click to select the **Web Server (IIS)** check box in the **Roles** list.
	
4. Click **Add Required Features** if you are prompted to do so, and then click **Next**.
	
5. Click **Next**, and then click to select the following check boxes in the **Role services** list:
	
	* **ISAPI Extensions**
	* **.NET Extensibility**
	* **Basic Authentication**
	* **Windows Authentication**
	* **Digest Authentication**
	* **Dynamic Content Compression**
	* **IIS 6 Management Compatibility**
6. Click **Next**, and then click **Install**.
	
7. If the server will support Outlook Anywhere clients, install the RPC over HTTP proxy feature. To do this, follow these steps:
	
	1. In Server Manager, click **Features**, and then click **Add Features**.
	2. In the **Features** list, click to select the **RPC over HTTP Proxy** check box. If you are prompted to do so, click **Add Required Role Services**.
	3. Click **Next** three times, and then click **Install**.

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] To install the Windows Server 2008 operating system prerequisites for the Exchange management tools

1. Open a Command Prompt window.
	
2. Install Windows PowerShell, which is included in Windows Server 2008 (but not installed by default) by running the following command:
	
	ServerManagerCmd -i PowerShell
	
3. Install the necessary IIS prerequisites by running the following commands in the order in which they are listed:
	
	ServerManagerCmd -i Web-Metabase
	ServerManagerCmd -i Web-Lgcy-Mgmt-Console
	

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] To install the Windows Server 2008 operating system prerequisites for the Exchange management tools by using the graphical user interface

1. Start Server Manager. To do this,click **Start**, and then click **Server Manager**.
	
2. In the navigation pane, click **Roles**, and then click **Add Roles** in the details pane.
	
3. In the Add Roles Wizard, click **Next**, and then click to select the **Web Server (IIS)** check box in the **Roles** list.
	
4. Click **Add Required Features** if you are prompted to do so, and then click **Next**.
	
5. Click **Next**, and then click to select the **IIS 6 Management Compatibility** check box in the **Role services** list**.**
	
6. Click **Next**, and then click **Install**.
	

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] To install the Windows Vista operating system prerequisites for the Exchange management tools

1. Download Windows PowerShell for Windows Vista from [How to Download Windows PowerShell 1.0](http://go.microsoft.com/fwlink/?LinkId=83537).
	
2. Run the installation package to install Windows PowerShell.
	
3. From the Start menu, open the Windows Vista **Control Panel** and then open the **Programs and Features** applet.
	
4. In the **Tasks** area, click **Turn Windows features on or off**.
	
5. Expand **Internet Information Services**, expand **Web Management Tools**, and then expand **IIS 6 Management Compatibility**.
	
6. Select the checkboxes for **IIS 6 Management Console** and **IIS 6 Metabase and IIS 6 configuration compatibility**, and then click **OK**.
	

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]] For More Information

Windows Server 2008 includes several features that have been enhanced or renamed. For information about the feature name changes between Windows Server 2003 and Windows Server 2008, see [Terminology Changes](http://technet.microsoft.com/en-us/library/bb123550.aspx).

Tags [![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCTagEditor/resources/taghelp.htm): [2008](http://technet.microsoft.com/en-us/library/bb691354.aspx#) ([x](http://technet.microsoft.com/en-us/library/bb691354.aspx#)) [exchange](http://technet.microsoft.com/en-us/library/bb691354.aspx#) ([x](http://technet.microsoft.com/en-us/library/bb691354.aspx#)) [install](http://technet.microsoft.com/en-us/library/bb691354.aspx#) ([x](http://technet.microsoft.com/en-us/library/bb691354.aspx#)) [installexchangeserver2007](http://technet.microsoft.com/en-us/library/bb691354.aspx#) ([x](http://technet.microsoft.com/en-us/library/bb691354.aspx#)) [server](http://technet.microsoft.com/en-us/library/bb691354.aspx#) ([x](http://technet.microsoft.com/en-us/library/bb691354.aspx#)) [windows](http://technet.microsoft.com/en-us/library/bb691354.aspx#) ([x](http://technet.microsoft.com/en-us/library/bb691354.aspx#)) [Add a tag](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)  [Add](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)   [Cancel](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
Flag as [ContentBug](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]]
Community Content   [![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCSection/resources/cchelp.htm)

|     |     |     |
| --- | --- | --- |
|     | [![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]]](http://technet.microsoft.com/en-us/library/community-edits.rss?topic=bb691354\|en-us\|80)  Annotations |     |

|     |     |     |
| --- | --- | --- |
| Visit the Exchange team blog and community forums |     | [Lee-Tony](http://technet.microsoft.com/en-us/library/user-223493.aspx)   \|      \| |

Please Wait  ![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]]

For detailed information about installing cluster continuous replication (CCR) on Windows Server 2008, see the Exchange Server Team Blog article [Videos: Installing Exchange 2007 SP1 CCR on Windows Server 2008](http://msexchangeteam.com/archive/2008/04/07/448637.aspx).

To review or join a discussion about deployment, see the [Exchange Deploy forum](http://forums.microsoft.com/TechNet/ShowForum.aspx?ForumID=837&SiteID=17).

Videos: Installing Exchange 2007 SP1 CCR on Windows Server 2008.

To review or join a discussion about deployment, see the [Exchange Deploy forum](http://forums.microsoft.com/TechNet/ShowForum.aspx?ForumID=837&SiteID=17).

" id="ctl00\_WikiContent\_ctl00\_Editor\_editorData" name="ctl00$WikiContent$ctl00$Editor$editorData">
Tags [![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCTagEditor/resources/taghelp.htm): [exchange](http://technet.microsoft.com/en-us/library/bb691354.aspx#) ([x](http://technet.microsoft.com/en-us/library/bb691354.aspx#)) [exchange2007](http://technet.microsoft.com/en-us/library/bb691354.aspx#) ([x](http://technet.microsoft.com/en-us/library/bb691354.aspx#)) [vista](http://technet.microsoft.com/en-us/library/bb691354.aspx#) ([x](http://technet.microsoft.com/en-us/library/bb691354.aspx#)) [windows](http://technet.microsoft.com/en-us/library/bb691354.aspx#) ([x](http://technet.microsoft.com/en-us/library/bb691354.aspx#)) [windowsserver](http://technet.microsoft.com/en-us/library/bb691354.aspx#) ([x](http://technet.microsoft.com/en-us/library/bb691354.aspx#)) [windowsserver2008](http://technet.microsoft.com/en-us/library/bb691354.aspx#) ([x](http://technet.microsoft.com/en-us/library/bb691354.aspx#)) [windowsvista](http://technet.microsoft.com/en-us/library/bb691354.aspx#) ([x](http://technet.microsoft.com/en-us/library/bb691354.aspx#)) [Add a tag](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)  [Add](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)   [Cancel](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
Flag as [ContentBug](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)

|     |     |     |
| --- | --- | --- |
| Installation of Exchange Server 2007 Hub Transport role unsuccessful on a Windows Server 2008 |     | [Taner Ultanir](http://technet.microsoft.com/en-us/library/user-226107.aspx)   \|      \| |

Please Wait  ![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]]
Consult to <http://support.microsoft.com/?kbid=952842>
http://support.microsoft.com/?kbid=952842" id="ctl00\_WikiContent\_ctl01\_Editor\_editorData" name="ctl00$WikiContent$ctl01$Editor$editorData">
Tags [![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCTagEditor/resources/taghelp.htm):  [Add a tag](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)  [Add](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)   [Cancel](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
Flag as [ContentBug](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)

|     |     |     |
| --- | --- | --- |
| Clarification request for the statement "If you are deploying a new Exchange organization..." |     | [jotrom](http://technet.microsoft.com/en-us/library/user-330942.aspx)   \|      \| |

Please Wait  ![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]]

I recommend removing the word "new" out of the statement if you are deploying a new organization or clarifying it a bit. Perhaps change it to the following

If you plan to run any Exchange 2007 Prepare switches on a Windows 2008 server then make sure to add the Active Directory Domain Services Remote Mangement tools using server manager or ServerManagerCMD -i RSAT-ADDS from the Windows 2008 server command prompt. Not installing this may result with the following error when running the Exchange 2007 SP1 with the /perpareAD parameter:

\[ERROR\] An error occurred. The error code was 3221684226. The message was The system cannot find the file specified..

Also a mention of Powershell installation would be good too since we can't assume that this server will actually be a Exchange 2007 server utlimately. Thanks!

If you plan to run any Exchange 2007 Prepare switches on a Windows 2008 server then make sure to add the Active Directory Domain Services Remote Mangement tools using server manager or ServerManagerCMD -i RSAT-ADDS from the Windows 2008 server command prompt. Not installing this may result with the following error when running the Exchange 2007 SP1 with the /perpareAD parameter:

\[ERROR\] An error occurred. The error code was 3221684226. The message was The system cannot find the file specified..

Also a mention of Powershell installation would be good too since we can't assume that this server will actually be a Exchange 2007 server utlimately. Thanks!

" id="ctl00\_WikiContent\_ctl02\_Editor\_editorData" name="ctl00$WikiContent$ctl02$Editor$editorData">
Tags [![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCTagEditor/resources/taghelp.htm): [contentbug](http://technet.microsoft.com/en-us/library/bb691354.aspx#) ([x](http://technet.microsoft.com/en-us/library/bb691354.aspx#)) [Add a tag](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)  [Add](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)   [Cancel](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
Flag as [ContentBug](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)

|     |     |     |
| --- | --- | --- |
|     |     | \|  |

Tags [![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]]](http://technet.microsoft.com/Platform/Controls/CCTagEditor/resources/taghelp.htm):  [Add a tag](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)  [Add](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)   [Cancel](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
Flag as [ContentBug](http://technet.microsoft.com/Platform/Controls/CCTagEditor/#)
![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]]

|     |     |
| --- | --- |
| © 2009 Microsoft Corporation. All rights reserved. [Terms of Use](http://www.microsoft.com/info/cpyright.mspx)  \|  [Trademarks](http://www.microsoft.com/library/toolbar/3.0/trademarks/en-us.mspx)  \|  [Privacy Statement](http://www.microsoft.com/info/privacy.mspx) | [![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/clear.gif]]](http://www.microsoft.com/) |

![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/trans_pixel.aspx%26ei%3d51JDSsLiBIj-tQPD3YHWDQ%26rct%3dj%26q%3dhow%2bto%2binstall%2bexchnage%2b2007%2bsp1%2bprerequisites%2bon%2bwindows%2bserver%2b2008%2bor%2bwindows%2bvista%26usg%3dAFQjCNHDSLHkeKUqfzoHtKQ9QSpQ2FOaMA]]
![[./_resources/How_to_Install_Exchange_2007_SP1_Prerequisites_on_Windows_Server_2008_or_Windows_Vista.resources/nojavascript&WT.js=No]]
