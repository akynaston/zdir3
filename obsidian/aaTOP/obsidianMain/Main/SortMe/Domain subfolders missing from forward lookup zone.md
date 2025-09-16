# Domain subfolders missing from forward lookup zone

![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/gsfx_EIE_icon_dkBG.png]]

[![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/gsfx_corpflyoutad_go.png]]](http://clk.atdmt.com/MRT/go/207752647/direct/01/)

|     |     |     |     |
| --- | --- | --- | --- |
| United States | [Change](http://support.microsoft.com/common/international.aspx) | \|  | [All Microsoft Sites](http://www.microsoft.com/en/us/sitemap.aspx) |

<http://www.microsoft.com/>[Microsoft Support](http://support.microsoft.com/)

![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/ss_check.png]]
Search Microsoft Support

![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/ss_check.png]]
Search Microsoft.com
![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/ss_check.png]]
Search the web

![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/bing_logo_white.png]]

* [Support Home](http://support.microsoft.com/)

* [Solution Centers](http://support.microsoft.com/select/?target=hub)

* [Advanced Search](http://support.microsoft.com/search/?adv=1)

* [Buy products](http://store.microsoft.com/home.aspx?WT.mc_id=SupportSiteUS_buyproducts)

Article ID: 310568 - Last Review: May 3, 2007 - Revision: 6.2

# Domain subfolders missing from forward lookup zone

[View products that this article applies to.](http://support.microsoft.com/kb/310568#appliesto)

|     |     |     |
| --- | --- | --- |
| ![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/Information.png]] | System TipThis article applies to a different version of Windows than the one you are using. Content in this article may not be relevant to you.[Visit the Windows XP Solution Center](http://support.microsoft.com/ph/1173) | ![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/close.png]] |

This article was previously published under Q310568
 | 

## 

## When you open the forward lookup zone in the Domain Name System (DNS) Microsoft...

When you open the forward lookup zone in the Domain Name System (DNS) Microsoft Management Console (MMC) snap-in, the following subdomains may be missing:

* \_msdcs
* \_sites
* \_tcp
* \_udp

This problem may occur if the zone is either Active Directory-Integrated or Standard Primary. Additionally, the forward lookup zone is being used to store SRV records for Active Directory.
When this problem occurs, the following event is logged:

Type: Warning
Event: 5782
Source: NETLOGON
Category: None
Computer: ComputerName
Event Msg: Dynamic registration or deregistration of one or more DNS records failed with the following error: No DNS servers configured for local system
Data: 7C 26 00 00

[![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/310568#top)

## 

## On a multi-homed server, DNS dynamic update protocol registration may have been...

On a multi-homed server, DNS dynamic update protocol registration may have been turned off (disabled) on the internal network adapter. The same problem occurs on a server that has a single network adapter and DNS dynamic update protocol turned off.
[![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/310568#top)

## 

## To turn on DNS dynamic update protocol on the affected network adapter, follow...

To turn on DNS dynamic update protocol on the affected network adapter, follow these steps:

1. On the desktop, right-click **My Network Places**, and then click **Properties**.
2. Right-click the internal network adapter, and then click **Properties**.
3. Click **TCP/IP**, and then click **Properties**.
4. Click the **Advanced** button.
5. Click the **DNS** tab, and then click to select the **Register this connection's addresses in DNS** check box at the bottom of the tab.
6. Click **OK** until the **Network Properties** dialog box is closed.
7. Click **Start**, click **Run**, type cmd, and then press ENTER.
8. At a command prompt, stop and restart the Netlogon service and initiate the registration of the network adapter in DNS. To do this, use the following command-line statements:
	* net stop netlogon
	* net start netlogon
	* ipconfig /registerdns

If the previous steps do not resolve this problem, you may have to remove DNS and reinstall it. To remove DNS, follow these steps:

1. Right-click **My Network Places**, and then click **Properties**.
2. In the Network and Dial-Up Connections window on the **Advanced** menu, click **Optional Networking Components**.
3. In the Windows Optional Networking Components Wizard, click to select **Networking Services**, and then click **Details**.
4. In the Networking Services window, click to clear the box next to Domain Name System (DNS) check box, click **OK**, and then click **Next**. This removes DNS.

Before you reinstall DNS, delete the following files:

* Cache.dns-which is located in %systemroot%\\Winnt\\System32\\DNS
* Netlogon.dns-which is located in %systemroot%\\Winnt\\System32\\Config
* Netlogon.dnb-which is located in %systemroot%\\Winnt\\System32\\Config

To reinstall DNS, follow these steps:

1. Right-click **My Network Places**, and then click **Properties**.
2. In the Network and Dial-Up Connections window on the **Advanced** menu click **Optional Networking Components**.
3. In the Windows Optional Networking Components Wizard, click to select the **Networking Services** check box, and then click **Details**.
4. In the **Networking Services** dialog box, click to select the **Domain Name System (DNS)** check box, click **OK**, and then click **Next**.
5. Insert the operating system installation disc when you are prompted, click **OK**, and DNS is reinstalled.
6. Restart the computer.

To reconfigure the DNS server and re-create the Forward and Reverse Lookup Zones, see the articles listed in the "More Information" section.
[![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/310568#top)

## 

## Microsoft has confirmed that this is a problem in the Microsoft products that ar...

Microsoft has confirmed that this is a problem in the Microsoft products that are listed in the "Applies to" section.
[![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/310568#top)

## 

## Other possible causes of this problem are the following: The value for Load zon...

Other possible causes of this problem are the following:

* The value for **Load zone data on startup** on the **Advanced** tab in the DNS server properties is set to **From registry** instead of **From Active Directory and registry**. To resolve this problem, reset the value, and then restart the server.
* The value of the following registry subkey is **0**:
	HKEY\_LOCAL\_MACHINE\\CurrentControlSet\\Services\\Netlogon\\Parameters\\UseDynamicUpdates
	
* The filter display limit for the zone is smaller than the number of records in the zone. To resolve this problem, follow these steps:
	1. Click **Start**, click **Run**, type dnsmgmt.msc in the **Open** box, and then click **OK**.
	2. In the **Dnsmgmt** dialog box, expand ServerName, and then expand **Forward Lookup Zones**.
	3. Click the zone, click the **View** menu, and then click **Filter**.
	4. Click the **Display Limit** tab.
	5. Set the display limit to a number that is larger than the number of records in your zone.
* The forward lookup zone was created by using the wrong name or was accidentally deleted. To re-create the zone, follow these steps:
	
	1. Make sure that the internal network adapter (and external network adapter if there is one) point to the server IP for DNS resolution in the **TCP/IP Properties** dialog box.
	2. In the DNS MMC, right-click the server object, and then click **New Zone**. The New Zone Wizard starts. Under **Zone Type**, click **Active Directory Integrated**. On the next page, click **Forward Lookup Zone**, and then type a domain name (for example, domain.com).
	3. Expand the Forward Lookup Zones folder, right-click the zone, and then click **Properties**.
	4. On the **General** tab, make sure that **Only secure updates** is selected in the **Allow Updates?** list (this is the default setting). Click **OK**, and then close the DNS MMC.
	5. At a command prompt, restart the Netlogon service by using the following command line:
		* net stop netlogon
		* net start netlogon
		* ipconfig /registerdns
	
	Verify that the zone file now has the following subdomains:
	* \_msdcs
	* \_sites
	* \_tcp
	* \_udp

[![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/310568#top)

## 

## For more information about how to create and configure zone files in DNS on Win...

For more information about how to create and configure zone files in DNS on Windows 2000 Server, click the following article numbers to view the articles in the Microsoft Knowledge Base:
[308201](http://support.microsoft.com/kb/308201/)  (http://support.microsoft.com/kb/308201/ ) How to create a new zone on a DNS server in Windows 2000
[237675](http://support.microsoft.com/kb/237675/)  (http://support.microsoft.com/kb/237675/ ) Setting up the Domain Name System for Active Directory
[![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/310568#top)

* * *

##### APPLIES TO

* Microsoft Windows Server 2003, Standard Edition (32-bit x86)
* Microsoft Windows Server 2003, Enterprise Edition (32-bit x86)
* Microsoft Windows 2000 Server
* Microsoft Small Business Server 2000 Standard Edition

[![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/310568#top)

|     |     |
| --- | --- |
| ##### Keywords: | kbgrppolicyprob kbprb KB310568 |

[![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/310568#top)

 

##### Provide feedback on this information

Did this information solve your problem?

|     |     |
| --- | --- |
|     | Yes |

|     |     |
| --- | --- |
|     | No  |

|     |     |
| --- | --- |
|     | I don't know |

Was this information relevant?

|     |     |
| --- | --- |
|     | Yes |

|     |     |
| --- | --- |
|     | No  |

What can we do to improve this information?
To protect your privacy, do not include contact information in your feedback.

|     |     |     |
| --- | --- | --- |
|     |     |     |

Thank you! Your feedback is used to help us improve our support content. For more assistance options, please visit the [Help and Support Home Page](http://support.microsoft.com/).

|     |     |     |
| --- | --- | --- |
|     |     |     |

Other Resources

### Other Support Sites

* [Solution Centers](http://support.microsoft.com/select/?target=hub)
* [Microsoft Fix It Solutions](http://support.microsoft.com/fixit)
* [Windows Help and How-to](http://windows.microsoft.com/en-us/windows/help)
* [Office Online](http://office.microsoft.com/)
* [Microsoft Partner Network](https://partner.microsoft.com/)

### Community

* [Answers Forums](http://answers.microsoft.com/)
* [Technet Forums](http://social.technet.microsoft.com/Forums)
* [Microsoft Developer Network (MSDN)](http://social.msdn.microsoft.com/Forums)

### Get Help Now

[![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/help_icon_48x48.png]]](http://support.microsoft.com/gethelp/default.aspx?content=kb;en-us;310568)[Contact a Support Professional by Email, Online, or Phone](http://support.microsoft.com/gethelp/default.aspx?content=kb;en-us;310568)

### Article Translations

|     |     |     |
| --- | --- | --- |
|     |     |     |

![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/gss_sticky_panel_top.png]]

![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/gss_sticky_panel_rtags.png]]

###### Search related topics

* [Msdcs forward lookup zone](http://support.microsoft.com/search/default.aspx?query=Msdcs%20forward%20lookup%20zone&catalog=LCID%3D1033)
* [Msdcs records missing](http://support.microsoft.com/search/default.aspx?query=Msdcs%20records%20missing&catalog=LCID%3D1033)
* [Msdcs zone recreate](http://support.microsoft.com/search/default.aspx?query=Msdcs%20zone%20recreate&catalog=LCID%3D1033)
* [How to reinstall a dynamic dns active d...](http://support.microsoft.com/search/default.aspx?query=How%20to%20reinstall%20a%20dynamic%20dns%20active%20directory%20integrated%20zone&catalog=LCID%3D1033)
* [Recreate dns zone active directory](http://support.microsoft.com/search/default.aspx?query=Recreate%20dns%20zone%20active%20directory&catalog=LCID%3D1033)

![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/gss_sticky_panel_watermark.png]]
![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/gss_sticky_panel_footer.png]]

### Related Support Centers

* [Windows Server 2003](http://support.microsoft.com/ph/3198/en-us)
* [Windows Server](http://support.microsoft.com/ph/1163/en-us)
* [Windows 2000 Server](http://support.microsoft.com/ph/7274/en-us)
* [Windows 2000](http://support.microsoft.com/ph/1131/en-us)
* [Small Business Server 2000](http://support.microsoft.com/ph/2807/en-us)

### Page Tools

* [Print this page](http://support.microsoft.com/gp/noscript)
* [E-mail this page](mailto:%3Fsubject=Domain%20subfolders%20missing%20from%20forward%20lookup%20zone%26body=http%3a%2f%2fsupport.microsoft.com%2fdefault.aspx%2fkb%2f310568%3fp%3d1)

|     |     |
| --- | --- |
| [![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/help_icon_48x48.png]]](http://support.microsoft.com/gethelp/default.aspx?content=kb;en-us;310568) | ### Get Help Now<br><br>[Contact a support professional by E-mail, Online, or Phone](http://support.microsoft.com/gethelp/default.aspx?content=kb;en-us;310568) |

Microsoft Support

|     |     |     |
| --- | --- | --- |
|     | \|  | [Services Agreement](http://support.microsoft.com/gp/csa) |

|     |     |     |     |     |     |     |
| --- | --- | --- | --- | --- | --- | --- |
| [Contact Us](http://support.microsoft.com/contactus/?ws=support) | \|  | [Terms of Use](http://go.microsoft.com/?linkid=4412892) | \|  | [Trademarks](http://go.microsoft.com/?linkid=4412893) | \|  | [Privacy Statement](http://go.microsoft.com/?linkid=4412894) |

![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/gsfx_brnd_ms_logo_sml_blk.png]]![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/gsfx_brnd_ms_logo_sml_blk.png]]
©2010 Microsoft

![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/nojavascript&WT.js=No]]![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/trans_pixel.mozilla%3aen-US%3aofficial%26client%3dfirefox-a&msid=c75205be5b4463409d2538bc9499710d]]![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/default.1.2%7c]]![[./_resources/Domain_subfolders_missing_from_forward_lookup_zone.resources/default.2%7c&FlexID=&FlexValue1=&FlexValue2=&FlexValue3=&FlexValue4=&FlexValue5=&FlexValue6=&FlexValue7=&FlexValue8=&FlexValue9=&FlexValue10=]]
