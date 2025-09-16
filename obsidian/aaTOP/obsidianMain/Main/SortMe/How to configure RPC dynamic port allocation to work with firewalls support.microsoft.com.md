# How to configure RPC dynamic port allocation to work with firewalls [support.microsoft.com]

# How to configure RPC dynamic port allocation to work with firewalls

Article ID: 154596 - [View products that this article applies to.](http://support.microsoft.com/kb/154596#appliesto)
System TipThis article applies to a different version of Windows than the one you are using. Content in this article may not be relevant to you. [Visit the Windows 7 Solution Center](http://support.microsoft.com/ph/14019)
This article was previously published under Q154596

[[#|Expand all]] | [[#|Collapse all]]

## ![[./_resources/How_to_configure_RPC_dynamic_port_allocation_to_work_with_firewalls_support.microsoft.com.resources/unknown_filename.png]][[#|Summary]]

Remote Procedure Call (RPC) dynamic port allocation is used by remote administration applications such as Dynamic Host Configuration Protocol (DHCP) Manager, Windows Internet Name Service (WINS) Manager, and so on. RPC dynamic port allocation will instruct the RPC program to use a particular random port above 1024.
Customers using firewalls may want to control which ports RPC is using so that their firewall router can be configured to forward only these Transmission Control Protocol (TCP) ports.
Many RPC servers in Windows let you specify the server port. When you can specify a dedicated server port, you know what traffic flows between the hosts across the firewall, and you can define the that is traffic allowed much better. You can find a comprehensive list of Server ports that are used in Windows and major Microsoft products can be found in Microsoft Knowledge Base article 832017. For more information, click the following article number to view the article in the Microsoft Knowledge Base:
[832017](http://support.microsoft.com/kb/832017) Service overview and network port requirements for the Windows Server system
The article also lists the RPC servers and which RPC servers can be configured to use custom server ports beyond the facilities that RPC offers. Use the method that is described in this article only if the RPC server does not offer a way to define the server port.
The following registry entries apply to Windows NT 4.0 and above. They do not apply to previous versions of Windows NT. Even though you can configure the port used by the client to communicate with the server, the client must be able to reach the server by its actual IP address. You cannot use DCOM through firewalls that do address translation (e.g. where a client connects to virtual address 198.252.145.1, which the firewall maps transparently to the server's actual address of, say, 192.100.81.101). This is because DCOM stores raw IP addresses in the interface marshaling packets and if the client cannot connect to the address specified in the packet, it will not work.
For more information, see the Microsoft white paper _Using Distributed COM with Firewalls_. To do this, visit the following Microsoft Web site:
<http://msdn2.microsoft.com/en-us/library/ms809327.aspx>
[![[./_resources/How_to_configure_RPC_dynamic_port_allocation_to_work_with_firewalls_support.microsoft.com.resources/unknown_filename.1.gif]]Back to the top](http://support.microsoft.com/kb/154596#top) | [Give Feedback](http://support.microsoft.com/kb/154596#survey)

## ![[./_resources/How_to_configure_RPC_dynamic_port_allocation_to_work_with_firewalls_support.microsoft.com.resources/unknown_filename.png]][[#|More information]]

The values (and Internet key) discussed below do not appear in the registry; they must be added manually using the Registry Editor. Also, note that you must use Regedt32.exe instead of Regedit.exe to add the REG\_MULTI\_SZ value.
**Important** This section, method, or task contains steps that tell you how to modify the registry. However, serious problems might occur if you modify the registry incorrectly. Therefore, make sure that you follow these steps carefully. For added protection, back up the registry before you modify it. Then, you can restore the registry if a problem occurs. For more information about how to back up and restore the registry, click the following article number to view the article in the Microsoft Knowledge Base:
[322756](http://support.microsoft.com/kb/322756) How to back up and restore the registry in Windows
With Registry Editor, you can modify the following parameters for RPC. The RPC Port key values discussed below are all located in the following key in the registry:
HKEY\_LOCAL\_MACHINE\\Software\\Microsoft\\Rpc\\Internet\\ Key Data Type
**Ports REG\_MULTI\_SZ**
Specifies a set of IP port ranges consisting of either all the ports available from the Internet or all the ports not available from the Internet. Each string represents a single port or an inclusive set of ports.
For example, a single port may be represented by 5984, and a set of ports may be represented by 5000-5100. If any entries are outside the range of 0 to 65535, or if any string cannot be interpreted, the RPC runtime treats the entire configuration as invalid.
**PortsInternetAvailable REG\_SZ** Y or N (not case-sensitive)
If Y, the ports listed in the Ports key are all the Internet-available ports on that computer. If N, the ports listed in the Ports key are all those ports that are not Internet-available.
**UseInternetPorts REG\_SZ )** Y or N (not case-sensitive
Specifies the system default policy.
If Y, the processes using the default will be assigned ports from the set of Internet-available ports, as defined previously.
If N, the processes using the default will be assigned ports from the set of intranet-only ports.
Example:
In this example ports 5000 through 5100 inclusive have been arbitrarily selected to help illustrate how the new registry key can be configured. This is not a recommendation of a minimum number of ports needed for any particular system.

1. Add the Internet key under: HKEY\_LOCAL\_MACHINE\\Software\\Microsoft\\Rpc
2. Under the Internet key, add the values "Ports" (MULTI\_SZ), "PortsInternetAvailable" (REG\_SZ), and "UseInternetPorts" (REG\_SZ).
	For example, the new registry key appears as follows:
	Ports: REG\_MULTI\_SZ: 5000-5100
	PortsInternetAvailable: REG\_SZ: Y
	UseInternetPorts: REG\_SZ: Y
	
3. Restart the server. All applications that use RPC dynamic port allocation use ports 5000 through 5100, inclusive. In most environments, a minimum of 100 ports should be opened, because several system services rely on these RPC ports to communicate with each other.

You should open up a range of ports above port 5000. Port numbers below 5000 may already be in use by other applications and could cause conflicts with your DCOM application(s). Furthermore, previous experience shows that a minimum of 100 ports should be opened, because several system services rely on these RPC ports to communicate with each other.
**Note** The minimum number of ports required may differ from computer to computer. Computers with higher traffic may run into a port exhaustion situation if the RPC dynamic ports are restricted. Take this into consideration when restricting the port range.
[![[./_resources/How_to_configure_RPC_dynamic_port_allocation_to_work_with_firewalls_support.microsoft.com.resources/unknown_filename.1.gif]]Back to the top](http://support.microsoft.com/kb/154596#top) | [Give Feedback](http://support.microsoft.com/kb/154596#survey)

For more information, click the following article numbers to view the articles in the Microsoft Knowledge Base:
[167128](http://support.microsoft.com/kb/167128) Network ports used by remote helpdesk functions
[179442](http://support.microsoft.com/kb/179442) How to configure a firewall for domains and trusts
[263293](http://support.microsoft.com/kb/263293) Windows 2000 NAT does not translate Netlogon traffic
[319553](http://support.microsoft.com/kb/319553) How to restrict FRS replication traffic to a specific static port
[224196](http://support.microsoft.com/kb/224196) Restricting Active Directory replication traffic and client RPC traffic to a specific port
[![[./_resources/How_to_configure_RPC_dynamic_port_allocation_to_work_with_firewalls_support.microsoft.com.resources/unknown_filename.1.gif]]Back to the top](http://support.microsoft.com/kb/154596#top) | [Give Feedback](http://support.microsoft.com/kb/154596#survey)

## ![[./_resources/How_to_configure_RPC_dynamic_port_allocation_to_work_with_firewalls_support.microsoft.com.resources/unknown_filename.png]][[#|Properties]]

Article ID: 154596 - Last Review: September 11, 2012 - Revision: 18.0

##### Applies to

* Microsoft Windows Server 2003, Enterprise x64 Edition

* Microsoft Windows Server 2003, Enterprise Edition (32-bit x86)
* Microsoft Windows Server 2003, Datacenter x64 Edition
* Microsoft Windows Server 2003, Datacenter Edition (32-bit x86)
* Microsoft Windows Server 2003, Enterprise Edition for Itanium-based Systems
* Microsoft Windows Server 2003, Datacenter Edition for Itanium-Based Systems
* Microsoft Windows Server 2003, Standard x64 Edition
* Microsoft Windows Server 2003, Standard Edition (32-bit x86)
* Microsoft Windows 2000 Professional Edition
* Microsoft Windows 2000 Server
* Microsoft Windows 2000 Advanced Server
* Microsoft Windows NT Server 4.0 Standard Edition
* Windows Server 2008 R2 Datacenter
* Windows Server 2008 R2 Enterprise
* Windows Server 2008 R2 Foundation
* Windows Server 2008 R2 Standard
* Windows Server 2008 Datacenter
* Windows Server 2008 Enterprise
* Windows Server 2008 Standard

|     |     |
| --- | --- |
| ##### Keywords: | kbproductlink kbdcom kbhowto kbnetwork KB154596 |

[![[./_resources/How_to_configure_RPC_dynamic_port_allocation_to_work_with_firewalls_support.microsoft.com.resources/unknown_filename.1.gif]]Back to the top](http://support.microsoft.com/kb/154596#top) | [Give Feedback](http://support.microsoft.com/kb/154596#survey)
