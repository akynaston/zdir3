# How IT Works: Troubleshooting RPC Errors [technet.microsoft.com]

[TechNet Magazine](https://technet.microsoft.com/en-us/magazine/default.aspx)

![[]]

[Sign in](https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=12&ct=1426718808&rver=6.0.5276.0&wp=MCMBI&wlcxt=technet%24technet%24technet&wreply=https%3a%2f%2ftechnet.microsoft.com%2fen-us%2fmagazine%2f2007.07.howitworks.aspx&lc=1033&id=254354&mkt=en-US)

  ![[./_resources/How_IT_Works_Troubleshooting_RPC_Errors_technet.microsoft.com.resources/clear.gif]]

[Home](https://technet.microsoft.com/en-us/magazine/default.aspx)

[Current Issue](https://technet.microsoft.com/en-us/magazine/dn467882.aspx)
[Topics](https://technet.microsoft.com/en-us/magazine/ff426025.aspx)
[Issues](https://technet.microsoft.com/en-us/magazine/bb978517.aspx)
[Columns](https://technet.microsoft.com/en-us/magazine/ff426023.aspx)
[Digital Magazine Downloads](https://technet.microsoft.com/en-us/magazine/ff395842.aspx)
[Videos](https://technet.microsoft.com/en-us/magazine/cc511304.aspx)
[Tips](https://technet.microsoft.com/en-us/magazine/dd299401.aspx)

[TechNet Magazine](https://technet.microsoft.com/en-us/magazine/ee721042.aspx) > [Home](https://technet.microsoft.com/en-us/magazine/ee721042.aspx) > [Issues](https://technet.microsoft.com/en-us/magazine/bb978517.aspx) > [2007](https://technet.microsoft.com/en-us/magazine/bb978511.aspx) > [July](https://technet.microsoft.com/en-us/magazine/bb978471.aspx) >  **How IT Works: Troubleshooting RPC Errors**

How IT Works Troubleshooting RPC Errors
Zubair Alexander
If you’ve worked with Windows server platforms over the years, chances are you’ve seen remote procedure call (RPC) errors at one time or another. They tell you that the RPC server is unavailable, or that there are no more endpoints available, or provide some other cryptic warning. If you’re confused by these messages, read on. I will
look at some common errors, various techniques you can use to identify the RPC errors you see, and discuss some solutions to solve specific problems. But before I talk about the specific RPC errors and solutions, let’s get a solid grounding in RPC terminology.
What Is RPC?
RPC is an interprocess communication (IPC) method that is used by clients and servers to communicate with each other. Simply put, RPC is used by programs, typically on a client computer, to execute a program on a server computer. For example, Microsoft® Outlook® clients communicate with Microsoft Exchange Server using RPC. The client computer sends a message to the server computer with certain arguments. The server responds to the client with a message that contains the results of the executed program.
Integral to this process is the endpoint—the name, port, or group of ports on a computer that is monitored by a server for incoming client requests. More specifically, it is a network-specific address of a server process that is used for RPCs.
The Endpoint Mapper, which is part of the RPC subsystem, is responsible for responding to the clients’ requests to resolve dynamic endpoints. In some situations, Endpoint Mapper is also responsible for dynamically assigning endpoints to servers.
Another important RPC component is the Locator Service. It maintains a list of RPC services and servers on the network. A Windows® client connects to the domain controller over the Server Message Block (SMB) ports (TCP 139 and 445) and searches for RPC services or servers through the Locator Service.
Most built-in Windows services communicate with each other using RPC. For example, certificate services, DCOM, FRS, MSMQ, MAPI, and Active Directory® Replication Service use RPC for communication. Therefore, if the RPC service is not functioning properly on a network, you may experience any number of communication problems.
RPC Errors
Now let’s look at some of the errors you may encounter when the RPC service is failing. (This is by no means a complete list.)
When the File Replication Service (FRS) fails, it could be the dreaded "RPC Unavailable" error at work. If you try to map a drive, you may get the "Access denied" error. When using Active Directory Users and Computers, you may see the error that states, "The specified domain either does not exist or could not be contacted." Logging on to the domain may give you an error that claims, "The system cannot log you on to this domain because the system’s computer account in its primary domain is missing or the password on that account is incorrect."
When the Microsoft Outlook client tries to communicate with Exchange Server, RPC failures may give the client a misleading error such as, "Your logon information is incorrect," or "Outlook could not log on."
In addition to these errors, when the RPC service is not available, you may experience other problems. For instance, you may not be able to browse the domain in My Network Places, or you may not be able to open the Group Policy snap-in.
These are just some of the instances in which you may not have expected RPCs to cause problems. There are many more instances, and anytime you’re involved with remote processes, RPC issues may be the root cause of your difficulties. So how do you know for sure and, more importantly, how do you track down the precise error? Let’s find out.
Troubleshooting
If you suspect you are having problems with the RPC service, there are several tools you can use to diagnose the problems.
One choice is the Repadmin tool. This program is ordinarily used to monitor and troubleshoot Active Directory replication problems, but it can also be used to troubleshoot RPC Endpoint Mapper problems. To run it, at the command prompt, type repadmin /bind. If you are having RPC problems, you may see a message such as this: "There are no more endpoints available from the endpoint mapper." That’s your first clue that the problem is related to RPC.
Another option is using the Domain Controller diagnostic tool (DCDiag), a command-line program for diagnosing problems with domain controllers. If you see the error "Status is 1722: The RPC server is unavailable," you know you have an RPC problem that the Domain Controller diagnostic tool just happened to uncover.
There are times when you’re using Ntdsutil (a command-line tool used to manage Active Directory and perform numerous maintenance tasks) that you may experience RPC errors if you try to connect to the server. Most likely you’ll see one of the more common errors such as "There are no more endpoints available from the endpoint mapper." Again, this is a clue that there may be problems with the RPC service. The Gpotool tool, which checks the consistency of Group Policy objects on domain controllers, will also give you similar errors if RPC is to blame.
The Dcpromo.log that is generated when you promote a Windows 2000 Server or Windows Server® 2003 server to a doman controller using the Dcpromo tool can also reveal issues with RPC. For instance, if the promotion fails, take a look at the log. It’s located in the %windir%\\debug folder. The errors listed will indicate something to the effect that the directory service failed to replicate the partition, or failed to create the object. At the end of the message there will be an error code. Here’s an example of the type of error message that you might see in the Dcpromo.log:
 
08/14 10:35:04 \[INFO\] Error - The Directory Service failed to replicate
 the partition CN=Schema,CN=Configuration,DC=.. (1722) 08/14 10:35:04 \[INFO\]
  NtdsInstall for dc.contoso.com. returned 1722 08/14 10:35:04 \[INFO\]
   DsRolepInstallDs returned 1722 08/14 10:35:04 \[ERROR\] Failed to install
    the directory service (1722)

Notice the error code 1722, which occurs four times in this message and indicates that the RPC server is unavailable. **Figure 1** lists some error codes and their descriptions, but many more can be found at [msdn2.microsoft.com/ms681386](http://msdn2.microsoft.com/ms681386).
  ![[./_resources/How_IT_Works_Troubleshooting_RPC_Errors_technet.microsoft.com.resources/clear.gif]]  Figure 1 Error codes and their descriptions

|     |     |
| --- | --- |
| Error Code | Description |
| 58  | The specified server cannot perform the requested operation. |
| 1721 | Not enough resources are available to complete this operation. |
| 1722 | The RPC server is unavailable. |
| 1723 | The RPC server is too busy to complete this operation. |
| 1727 | The remote procedure call failed and did not execute. |
| 1753 | There are no more endpoints available from the endpoint mapper. |
Resolving RPC Errors
Now that you’ve seen how some of the RPC errors can be detected, let’s look at some of the solutions.
Microsoft clients connect to RPC Endpoint Mapper on port 135. Then the Endpoint Mapper tells the client which port a requested service is listening on. The port numbers are assigned dynamically and can be anywhere between 1024 and 65,535. When you see errors, such as 1753, that tell you that no more endpoints are available from the Endpoint Mapper, this means that the RPC Endpoint Mapper was unable to utilize a port greater than 1024 for a service. I’ll look at this topic more closely a little later.
The first thing you should do is check the status of the RPC service on the server. Depending on the type of server role, the RPC and the RPC Locator service should have the status listed in **Figure 2**. If either of the two services is not configured as shown in the figure, try to adjust the status, reboot your server, and then test to see if it resolves your problem.
  ![[./_resources/How_IT_Works_Troubleshooting_RPC_Errors_technet.microsoft.com.resources/clear.gif]]  Figure 2 Status of RPC service
Verify that your client can successfully ping the server that is having connectivity problems. For example, if you are having problems communicating to a server called DC1 whose IP address is 192.168.1.200, use the following command at the command prompt to verify that DNS is properly resolving the host DC1:
Ping –a 192.168.1.200

Make sure you use the –a switch with the IP address, not the host name.
If everything is working fine, you should get a response from DC1 that looks something like the ping response in **Figure 3**. Notice that instead of simply resolving the IP address 192.168.1.200, Ping also resolved the host name dc1.contoso.com. This confirms that DNS name resolution is working properly and resolving to the host dc1.contoso.com exactly as expected.
  ![[./_resources/How_IT_Works_Troubleshooting_RPC_Errors_technet.microsoft.com.resources/clear.gif]]  Figure 3 Ping response
C:\\WINDOWS>ping -a 192.168.1.200

Pinging dc1.contoso.com \[192.168.1.200\] with 32 bytes of data:

Reply from 192.168.1.200: bytes=32 time<1ms TTL=128
Reply from 192.168.1.200: bytes=32 time<1ms TTL=128
Reply from 192.168.1.200: bytes=32 time<1ms TTL=128
Reply from 192.168.1.200: bytes=32 time<1ms TTL=128

Ping statistics for 192.168.1.200:
  Packets: Sent = 4, Received = 4, Lost = 0 (0% loss),
Approximate round trip times in milli-seconds:
  Minimum = 0ms, Maximum = 0ms, Average = 0ms

You should also ensure that the registry on your Windows XP or Windows 2000 client contains at least the four ClientProtocols listed in the right-hand pane in **Figure 4**.
![[./_resources/How_IT_Works_Troubleshooting_RPC_Errors_technet.microsoft.com.resources/cc138001.gif]]
Figure 4 **RPC ClientProtocols listed in the registry** 

If any of the entries are missing, add a new string value with the name and data type shown in **Figure 4**. By default, there’s a fifth entry called ncacn\_nb\_tcp, which is used to identify NetBIOS over TCP as the protocol family for the endpoint. Depending on your configuration, you may not have that entry listed under ClientProtocols and can manually add it to see if it resolves the RPC errors.
Notice the keys listed under the Rpc folder in the left pane in the figure, namely ClientProtocols, NameService, NetBios, and SecurityService. If you happen to see a key called Internet that has no values, try removing the key and restarting your computer. That may help solve your problem. As always, though, be sure to exercise caution when you’re modifying the Windows registry.
As mentioned earlier, RPC can use ports between 1024 and 65,535, so you need to make sure that these ports are not blocked by a firewall. The simplest way to ensure that a port is open is to use the Port Query tool. This tool comes in two flavors: a command-line version (PortQry) and a GUI version (PortQueryUI).
PortQry is available for download from the [Microsoft Download Center](http://go.microsoft.com/fwlink/?LinkId=73739). For additional information, check out the article "[Description of the Portqry.exe Command-Line Utility](http://support.microsoft.com/kb/310099)". There you will find brief descriptions of PortQry status reports and examples of commands to use to resolve problems. Keep in mind that you can also use the GUI version, which is much simpler and can be downloaded at [go.microsoft.com/fwlink/?LinkId=73740](http://go.microsoft.com/fwlink/?LinkId=73740).
When using Port Query, you should be sure to run it on a computer that is not experiencing RPC errors and run it against a computer that is having problems with RPC. For example, if you want to verify that port 135—which is used by RPC Endpoint Mapper—is open, use PortQry at the command prompt as follows:
portqry -n \[servername\] -e 135

Whether you used PortQuery or PortQueryUI, you would get the results, like the following:
Starting portqry.exe -n 192.168.1.200 -e 135 -p TCP ...
Querying target system called:
 192.168.1.200
Attempting to resolve IP address to a name...
IP address resolved to dc1.contoso.com
querying...

TCP port 135 (epmap service): LISTENING

The last line shows that port 135 is open. Otherwise, the last line would have indicated NOT LISTENING.
To check for a range of ports, enter the range of port numbers separated by commas, such as "135,1024-5000".
Additional Solutions
If you’ve tried all the tricks listed so far and the problem is still unresolved, there are some additional options open to you. Depending on the specific problems in your environment, you might want to try one of the following modifications to the registry. (Wait! Before making any changes to the registry, it’s important to make sure you’ve backed up your system, especially the registry, so if things go wrong you have the ability to restore your computer to its previous state.)
One option is to adjust MaxUserPort to specify the highest port number that TCP can assign when an application requests an available user port from the system. By default, Windows Server 2003 sets the MaxUserPort value to 5000, which means it is using 5000 as the highest port number, even if the entry doesn’t exist. Depending on your configuration, you may not have this entry in the registry, in which case you can add this entry to the location shown in **Figure 5**.
![[./_resources/How_IT_Works_Troubleshooting_RPC_Errors_technet.microsoft.com.resources/cc138001.1.gif]]
Figure 5 **MaxUserPort setting in the registry** 

HKLM\\SYSTEM\\CurrentControlSet\\Services\\Tcpip\\Parameters
Data type = REG\_DWORD
Port range = 5000 – 65534
Default = 5000

When modifying the registry you need to be aware of any other potential side effects, which is not always easy. Modifying this entry may have an effect on Microsoft Exchange Server if the value is set to below 50,000. If the Exchange Server Best Practices Analyzer (BPA) finds the value of the MaxUserPort registry key to be less than 50,000, it displays a warning. Microsoft recommends that you set the value to 60,000; otherwise you may cause Name Service Provider Interface (NSPI) proxy warnings, such as Event 9040. For more information, see Microsoft’s document "[MaxUserPort Value is Too Low](http://go.microsoft.com/fwlink/?LinkId=73421)".
You can also adjust TcpMaxDataRetransmissions. TCP packets expect an acknowledgment from the receiving end. If there’s no acknowledgment before the timer expires, then the packets are retransmitted, up to the TcpMaxDataRetransmissions times. The default value for this parameter is 5 but you may want to try a value of 4, or even 3. Do not use a value below 3.
If the TcpMaxDataRetransmissions registry entry does not exist, you can add it to the registry in the following location, like so:
HKLM\\SYSTEM\\CurrentControlSet\\Services\\Tcpip\\Parameters
Data type = REG\_DWORD
Valid range = 0 - 0xFFFFFFFF (hexadecimal)
Default = 5

For more information on TcpMaxDataRetransmissions, check out Microsoft’s Knowledge Base article 170359, "[How to Modify the TCP/IP Maximum Retransmission Timeout](http://support.microsoft.com/kb/170359)".
Another registry value that you may want to experiment with is TcpTimedWaitDelay. If a client uses too many ports, it is quite possible that it may run out of ports before TCP/IP releases closed connections. This is because TCP/IP doesn’t release the connection until two maximum segment lives (MSLs) have passed (this is referred to as time-wait state). Moreover, since each MSL is defined as 120 seconds and TCP/IP doesn’t release the connection until two MSLs have passed, it takes up to 240 seconds (4 minutes) for TCP/IP to release a closed connection. Note that this was a known problem in Windows NT® that was corrected with a service pack; as a result, you are far less likely to experience this problem today. However, Microsoft recommends adjusting this setting as one of the possible solutions to resolve the RPC Endpoint Mapper errors, as explained in the Knowledge Base article "[How to Troubleshoot RPC Endpoint Mapper Errors](http://support.microsoft.com/kb/839880)".
The TcpTimedWaitDelay is added to the registry in the following location:
HKLM\\SYSTEM\\CurrentControlSet\\Services\\Tcpip\\Parameters
Data type = REG\_DWORD 
Range: 30 - 300 (decimal)
Default: 0xF0 (240 decimal)

For more information on TcpTimedWaitDelay, check out the Knowledge Base article "[Windows NT Clients Run Out of Ports](http://support.microsoft.com/kb/149532)". Although the article does not recommend any specific numbers, you might want to try reducing TcpTimedWaitDelay to 60 (seconds) in decimal, which is 3c in hexadecimal.
Conclusion
RPC errors can be the root cause of numerous communication errors on your network. Luckily, there are several creative ways you can troubleshoot these elusive problems. Some of the tools I’ve suggested here are built in, while others are available in the Windows Server Resource Kit. Many are listed in **Figure 6**. You can use these tools to detect the cause and location of the RPC errors and then use one of the techniques listed in this article to resolve the errors.
  ![[./_resources/How_IT_Works_Troubleshooting_RPC_Errors_technet.microsoft.com.resources/clear.gif]]  Figure 6 RPC troubleshooting tools

|     |     |
| --- | --- |
| Tool | Description |
| DCDiag | Analyzes the state of domain controllers. |
| Event Viewer | Displays logged events. |
| Gpotool | Determines whether the policies are valid and consistent. |
| NetDiag | Used to test network connectivity. |
| Network Monitor | Monitors and captures network traffic. |
| Ntdsutil | Provides management facilities for Active Directory. |
| PortQry, PortQueryUI | Used for TCP/IP connectivity testing. |
| Repadmin | Diagnoses replication problems between Windows DCs. |
| RPCDump | Typically used together with Network Monitor. |
| RPCPing | Used to confirm RPC connectivity. |

**Zubair Alexander**, MCSE, MCT, and Microsoft MVP, is the owner of SeattlePro Enterprises, an IT training and consulting business. His experience covers the spectrum of IT education: author, college instructor, consultant, network engineer, public speaker, security architect, systems administrator, technical editor, and trainer. Zubair may be reached at [alexander@techgalaxy.net](https://technet.microsoft.com/en-us/magazine/2007.07.howitworks.aspxmailto:alexander@techgalaxy.net).

© 2008 Microsoft Corporation and CMP Media, LLC. All rights reserved; reproduction in part or in whole without permission is prohibited.

### Resources

* [TechNet Flash Newsletter](http://technet.microsoft.com/en-us/cc543196.aspx)
	

* [TechNet Technology News feed](http://sxp.microsoft.com/feeds/technet/news)
	
* [MSDN Magazine](http://msdn.microsoft.com/en-us/magazine/default.aspx)
	
* [MSDN Flash Newsletter](http://msdn.microsoft.com/en-us/aa570311.aspx)
	

<a id="ctl00\_ctl21" href="http://ox-d.101m3.com/w/1.0/rc?cs=4f2b1529d80e0&cb=INSERT\_RANDOM\_NUMBER\_HERE" onclick="javascript:Track('ctl00\_ctl20|ctl00\_ctl21',this);"><img alt="" border="0" src="http://ox-d.101m3.com/w/1.0/ai?auid=139279&amp;cs=4f2b1529d80e0&amp;cb=INSERT\_RANDOM\_NUMBER\_HERE" /></a>

© 2015 Microsoft. All rights reserved. [Terms of Use](https://technet.microsoft.com/cc300389.aspx) | [Trademarks](http://www.microsoft.com/library/toolbar/3.0/trademarks/en-us.mspx) | [Privacy Statement](http://www.microsoft.com/info/privacy.mspx) | [Site Feedback](https://lab.msdn.microsoft.com/mailform/contactus.aspx?refurl=https://technet.microsoft.com/en-us/magazine/2007.07.howitworks.aspx&loc=en-us)
