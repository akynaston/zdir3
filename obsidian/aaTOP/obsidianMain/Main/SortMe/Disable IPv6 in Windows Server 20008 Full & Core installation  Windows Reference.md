# Disable IPv6 in Windows Server 20008 Full & Core installation | Windows Reference

I used thefollowing reg file:

Windows Registry Editor Version 5.00
\[HKEY\_LOCAL\_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Tcpip6\\Parameters\]
"Dhcpv6DUID"=hex:00,01,00,01,11,db,5f,1a,00,0c,29,00,c6,6d
"DisabledComponent"=dword:000000ff

"DisabledComponents"=dword:000000ff

noTE: ORIGINAL DOCUMENT SAYS dISABLEDcOMPONENT
"DisabledComponents"=dword:000000ff

[**Disable IPv6 in Windows Server 20008 Full & Core installation**](http://www.windowsreference.com/networking/disable-ipv6-in-windows-server-20008-full-core-installation)
**By [Winsockfix](http://www.windowsreference.com/author/winsockfix) | [Comments (4)](http://www.windowsreference.com/networking/disable-ipv6-in-windows-server-20008-full-core-installation/#comments) | [Trackbacks (0)](http://www.windowsreference.com/networking/disable-ipv6-in-windows-server-20008-full-core-installation/#trackbacks) | [![[./_resources/Disable_IPv6_in_Windows_Server_20008_Full_&_Core_installation__Windows_Reference.resources/email_famfamfam.png]]](http://www.windowsreference.com/networking/disable-ipv6-in-windows-server-20008-full-core-installation/emailpopup) [Email This Post](http://www.windowsreference.com/networking/disable-ipv6-in-windows-server-20008-full-core-installation/emailpopup)**

If you're new here, you may want to subscribe to [Windows](http://www.windowsreference.com/networking/disable-ipv6-in-windows-server-20008-full-core-installation/#) Reference [RSS feed](http://feeds.feedburner.com/WindowsReference) Thanks for visiting!

IPv6 is enebled by default in Windows [Server](http://www.windowsreference.com/networking/disable-ipv6-in-windows-server-20008-full-core-installation/#) 2008. If you are not using IPv6 then this can be disabled from the [Windows Registry](http://www.windowsreference.com/networking/disable-ipv6-in-windows-server-20008-full-core-installation/#) as follows:

Click Start – Search and type “regedit” and press enter. This should launch the Registry Editor.

In Windows Server 2008 Core installation, run “regedit” from an elevated [Command prompt](http://www.windowsreference.com/networking/disable-ipv6-in-windows-server-20008-full-core-installation/#) or as an Administrator. This should launch the Windows [Registry Editor](http://www.windowsreference.com/networking/disable-ipv6-in-windows-server-20008-full-core-installation/#)

![[./_resources/Disable_IPv6_in_Windows_Server_20008_Full_&_Core_installation__Windows_Reference.resources/grey_loader.gif]]
.

Navigate to the following rgeistry key

> **\[HKEY\_LOCAL\_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Tcpip6\\Parameters\]**
> 
> **HKEY\_LOCAL\_MACHINE
> \\SYSTEM
> \\CurrentControlSet
> \\Services
> \\Tcpip6
> \\Parameters**

In the right-pane, right-click, select New – DWORD Value. Enter the name as “DisabledComponent” and set its value as “FF” as shown below. Once done, restart the Server for the changes to take effect. If at a later time, you want to revert the changes simply delete the key and reboot the server.

![[./_resources/Disable_IPv6_in_Windows_Server_20008_Full_&_Core_installation__Windows_Reference.resources/ipv6.png]]

* [![[./_resources/Disable_IPv6_in_Windows_Server_20008_Full_&_Core_installation__Windows_Reference.resources/share_save_171_16.png]]](http://www.addtoany.com/share_save?linkurl=http%3A%2F%2Fwww.windowsreference.com%2Fnetworking%2Fdisable-ipv6-in-windows-server-20008-full-core-installation%2F&linkname=Disable%20IPv6%20in%20Windows%20Server%2020008%20Full%20%26%23038%3B%20Core%20installation)
* [Disable IP Source Routing in Windows Server 2008 & Windows Vista](http://www.windowsreference.com/networking/disable-ip-source-routing-in-windows-server-2008-windows-vista)
* [Disable Media Sensing on Ethernet adapters in Windows](http://www.windowsreference.com/networking/disable-media-sensing-on-ethernet-adapters-in-windows)
* [Change Default Time TO Live (TTL) in Windows Server 2008 & Windwos Vista](http://www.windowsreference.com/networking/change-default-time-to-live-ttl-in-windows-server-2008-windwos-vista)
* [Set Gratuitous ARP requests in Windows Server 2008 and Windows Vista](http://www.windowsreference.com/networking/set-gratuitous-arp-requests-in-windows-server-2008-and-windows-vista)
* [IPv4 packet encapsultation using IEEE 802.3 SNAP in ethernet subnets](http://www.windowsreference.com/networking/ipv4-packet-encapsultation-using-ieee-8023-snap-in-ethernet-subnets)
* [Enable/Disable some or all of IPv6 capabilities in Windows Vista or Windows Server 2008](http://www.windowsreference.com/networking/enabledisable-some-or-all-of-ipv6-capabilities-in-windows-vista-or-windows-server-2008)

* * *

**_Did you enjoy this post? Why not [leave a comment below](http://www.windowsreference.com/networking/disable-ipv6-in-windows-server-20008-full-core-installation/#comments) and continue the conversation, or [subscribe to my feed](http://www.windowsreference.com/feed) and get articles like this delivered automatically each day to your feed reader._**

**Tags:** [IPv6](http://www.windowsreference.com/tag/ipv6), [registry](http://www.windowsreference.com/tag/registry), [tcpip](http://www.windowsreference.com/tag/tcpip), [windows](http://www.windowsreference.com/tag/windows), [Windows Server 2008](http://www.windowsreference.com/tag/windows-server-2008)
**Topics:** [Networking](http://www.windowsreference.com/category/networking), [Windows Server 2008](http://www.windowsreference.com/category/windows-server-2008)
