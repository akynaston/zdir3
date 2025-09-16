# Microsoft Exchange 2007 Information Store may fail to start after reboot

|     |     |     |     |
| --- | --- | --- | --- |
| United States | [Change](http://support.microsoft.com/common/international.aspx) | \|  | [All Microsoft Sites](http://www.microsoft.com/library/toolbar/3.0/sitemap/en-us.mspx) |

[![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/gsfx_brnd_ms_logo.png]]](http://www.microsoft.com/) Help and Support
![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/ss_check.png]]
Search Microsoft Support
![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/ss_check.png]]
Search Microsoft.com
![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/ss_check.png]]
Search the web
![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/bing_logo_white.png]]

* [Help and Support Home](http://support.microsoft.com/)

* [Select a Product](http://support.microsoft.com/select/?target=hub)

* [Advanced Search](http://support.microsoft.com/search/?adv=1)

Article ID: 555859 - Last Review: April 5, 2007 - Revision: 1.0

# Microsoft Exchange 2007 Information Store may fail to start after reboot

Author: Yuval Sinay MVP
![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/Comm_solutions_16.png]][Community Solutions Content Disclaimer](http://support.microsoft.com/kb/555859/en-us?spid=10926&sid=global#csDisclaimer)
[View products that this article applies to.](http://support.microsoft.com/kb/555859/en-us?spid=10926&sid=global#appliesto)
 | 

## 

## The following knowledgebase will help you to resolve Microsoft Exchange Informat...

_The following knowledgebase will help you to resolve Microsoft Exchange Information Store in Exchange 2007 fail to start after reboot problem_
[![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/555859/en-us?spid=10926&sid=global#top)

## 

## After installation of Exchange 2007 Server on Windows 2003 64 Bit / Windows 200...

 
After installation of Exchange 2007 Server on Windows 2003 64 Bit / Windows 2003 R2 64 Bit Domain Controller,
 
the Microsoft Exchange Information Store may fail to start after reboot
[![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/555859/en-us?spid=10926&sid=global#top)

## 

## The "Microsoft Exchange Information Store" try to start before "Microsoft Excha...

 
The "**Microsoft Exchange Information Store**" try to start before
 
"**Microsoft Exchange Active Directory Topology Service**" service gather
 
the required information to operate from the Domain Controller.
 
 
[![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/555859/en-us?spid=10926&sid=global#top)

## 

## Note: Before editing the registry its recommended to review: http://technet2.mi...

 
**Note**: Before editing the registry its recommended to review:
 
http://technet2.microsoft.com/WindowsServer/en/library/875762e7-a9fa-4ca5-a006-ed6eebe0d1321033.mspx?mfr=true
 
 
1\.  Click on "**Start Menu**", "Run" and Enter "**Regedt32**".
2\. Expand "**HKEY\_LOCAL\_MACHINE\\System\\CurrentControlSet\\Services\\MSExchangeIS**".
3\. On the Right Pane, Double Click "**DependOnService**".
4\. At the end of the Value Data, type "**MSExchangeADTopology**".
5\. Close Registry Editor.
6\. Reboot the Server.
 
 
![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/uparrow.gif]][Back to the top](http://support.microsoft.com/kb/555859/en-us?spid=10926&sid=global#top)

## 

## Microsoft Exchange Server Homepage http://www.microsoft.com/exchange/default.ms...

 
Microsoft Exchange Server Homepage
 
http://www.microsoft.com/exchange/default.mspx
[![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/555859/en-us?spid=10926&sid=global#top)

* * *

##### APPLIES TO

* Microsoft Exchange Server 2007
* Microsoft Exchange Server 2007 Enterprise Edition
* Microsoft Exchange Server 2007 Standard Edition

[![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/555859/en-us?spid=10926&sid=global#top)

|     |     |
| --- | --- |
| ##### Keywords: | kbpubmvp kbpubtypecca kbhowto KB555859 |

[![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/555859/en-us?spid=10926&sid=global#top)
![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/Comm_solutions_16.png]]COMMUNITY SOLUTIONS CONTENT DISCLAIMER
MICROSOFT CORPORATION AND/OR ITS RESPECTIVE SUPPLIERS MAKE NO REPRESENTATIONS ABOUT THE SUITABILITY, RELIABILITY, OR ACCURACY OF THE INFORMATION AND RELATED GRAPHICS CONTAINED HEREIN. ALL SUCH INFORMATION AND RELATED GRAPHICS ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY KIND. MICROSOFT AND/OR ITS RESPECTIVE SUPPLIERS HEREBY DISCLAIM ALL WARRANTIES AND CONDITIONS WITH REGARD TO THIS INFORMATION AND RELATED GRAPHICS, INCLUDING ALL IMPLIED WARRANTIES AND CONDITIONS OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, WORKMANLIKE EFFORT, TITLE AND NON-INFRINGEMENT. YOU SPECIFICALLY AGREE THAT IN NO EVENT SHALL MICROSOFT AND/OR ITS SUPPLIERS BE LIABLE FOR ANY DIRECT, INDIRECT, PUNITIVE, INCIDENTAL, SPECIAL, CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER INCLUDING, WITHOUT LIMITATION, DAMAGES FOR LOSS OF USE, DATA OR PROFITS, ARISING OUT OF OR IN ANY WAY CONNECTED WITH THE USE OF OR INABILITY TO USE THE INFORMATION AND RELATED GRAPHICS CONTAINED HEREIN, WHETHER BASED ON CONTRACT, TORT, NEGLIGENCE, STRICT LIABILITY OR OTHERWISE, EVEN IF MICROSOFT OR ANY OF ITS SUPPLIERS HAS BEEN ADVISED OF THE POSSIBILITY OF DAMAGES.
[![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/555859/en-us?spid=10926&sid=global#top)

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
 
Thank you! Your feedback is used to help us improve our support content. For more assistance options, please visit the [Help and Support Home Page](http://support.microsoft.com/).
 

|     |     |
| --- | --- |
| [![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/Help_support_55.gif]]](http://support.microsoft.com/gethelp/default.aspx?content=kb;en-us;555859) | ### Get Help Now<br><br>[Contact a support professional by E-mail, Online, or Phone](http://support.microsoft.com/gethelp/default.aspx?content=kb;en-us;555859) |

### Article Translations

|     |     |
| --- | --- |
|     |     |

![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/gss_sticky_panel_top.png]]
![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/gss_sticky_panel_rc.png]]

###### View related content

* [exchangeV1 Public Folder may not replicate to a new Exchange 2007 Server](http://support.microsoft.com/kb/555978/en-us)
* [How to install Microsoft Anti Spam Agents on Exchange 2007](http://support.microsoft.com/kb/555924/en-us)
* [The Microsoft Exchange System Attendant service does not start on a computer that is runn...](http://support.microsoft.com/kb/925822/en-us)
* [Exchange Server 2003 Computer Takes Longer Than You Expect to Shut Down](http://support.microsoft.com/kb/829361/en-us)
* [Faster reboot on Exchange Server 2003 servers that are also Domain Controllers](http://support.microsoft.com/kb/555526/en-us)

![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/gss_sticky_panel_rtags.png]]

###### Search related topics

* [Exchange 2003 64-bit](http://support.microsoft.com/search/default.aspx?query=Exchange%202003%2064-bit&catalog=LCID%3D1033)
* [Exchange 2007 services](http://support.microsoft.com/search/default.aspx?query=Exchange%202007%20services&catalog=LCID%3D1033)
* [Microsoft 2007 support](http://support.microsoft.com/search/default.aspx?query=Microsoft%202007%20support&catalog=LCID%3D1033)

![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/gss_sticky_panel_watermark.png]]
![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/gss_sticky_panel_footer.png]]

### Other Support Options

* [![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/Logo_FixIt_Final.png]]
	Microsoft Fix it solutions](http://support.microsoft.com/gp/cp_fixit_main)
* [Microsoft Partners: Access Unlimited Online Support](https://partner.microsoft.com/40014662)

### Technical Communities

* [Exchange Community](http://www.microsoft.com/exchange/community/default.mspx)

### Audio/Video Resources

|     |     |
| --- | --- |
| ![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/webcastinfotemplate_calendar.gif]] | [Upcoming Support WebCasts](http://support.microsoft.com/webcasts) |
| ![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/download.gif]] | [Downloadable Support WebCasts](http://support.microsoft.com/dwebcst) |
| ![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/webcastinfotemplate_view.gif]] | [Voice of Support PodCasts](http://support.microsoft.com/podcasts) |

### Related Support Centers

* [Exchange Server 2007](http://support.microsoft.com/ph/10926/en-us)

### Page Tools

* [Print this page](http://support.microsoft.com/gp/noscript)
* [E-mail this page](mailto:%3Fsubject=Microsoft%20Exchange%202007%20Information%20Store%20may%20fail%20to%20start%20after%20reboot%26body=http%3a%2f%2fsupport.microsoft.com%2fdefault.aspx%2fkb%2f555859%2fen-us%3fspid%3d10926%26sid%3dglobal)

|     |     |
| --- | --- |
| [![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/Help_support_55.gif]]](http://support.microsoft.com/gethelp/default.aspx?content=kb;en-us;555859) | ### Get Help Now<br><br>[Contact a support professional by E-mail, Online, or Phone](http://support.microsoft.com/gethelp/default.aspx?content=kb;en-us;555859) |

Help and Support

|     |     |     |
| --- | --- | --- |
|     | \|  | [Services Agreement](http://support.microsoft.com/gp/csa) |

|     |     |     |     |     |     |     |
| --- | --- | --- | --- | --- | --- | --- |
| [Contact Us](http://support.microsoft.com/contactus/?ws=support) | \|  | [Terms of Use](http://go.microsoft.com/?linkid=4412892) | \|  | [Trademarks](http://go.microsoft.com/?linkid=4412893) | \|  | [Privacy Statement](http://go.microsoft.com/?linkid=4412894) |

![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/gsfx_brnd_ms_logo_sml_wht.png]] ![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/gsfx_brnd_ms_logo_sml_blk.png]]
©2009 Microsoft
![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/trans_pixel.com%2fForums%2fen-US%2fexchangesvrgeneral%2fthread%2f624d5eff-708a-4b01-895f-659ddafb905d&prd=Exchange%20Server%202007&msid=3b8f4a6d8024fc49b9c5bc1ff3154d9e]]![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/default.0%7c&FlexID=4&FlexValue1=&FlexValue2=&FlexValue3=&FlexValue4=&FlexValue5=10926]]![[./_resources/Microsoft_Exchange_2007_Information_Store_may_fail_to_start_after_reboot.resources/default.0%7c&FlexID=4&FlexValue1=&FlexValue2=&FlexValue3=&FlexValue4=&FlexValue5=10926]]
