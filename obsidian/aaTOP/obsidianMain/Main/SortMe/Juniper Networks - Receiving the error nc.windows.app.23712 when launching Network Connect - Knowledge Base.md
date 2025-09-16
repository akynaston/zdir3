# Juniper Networks - Receiving the error "nc.windows.app.23712" when launching Network Connect - Knowledge Base

[![[./_resources/Juniper_Networks_-_Receiving_the_error_nc.windows.app.23712_when_launching_Network_Connect_-_Knowledge_Base.resources/logo-top-m.gif]]](http://www.juniper.net/us/en)
Country
![[./_resources/Juniper_Networks_-_Receiving_the_error_nc.windows.app.23712_when_launching_Network_Connect_-_Knowledge_Base.resources/btn-countryarrow-s.gif]]

* [Worldwide](http://www.juniper.net/us/en)

[Contact Us](http://www.juniper.net/us/en/contact-us)
|
Country
Worldwide
[Solutions](http://www.juniper.net/us/en/solutions)
[Products & Services](http://www.juniper.net/us/en/products-services)
[Company](http://www.juniper.net/us/en/company)
[Partners](http://www.juniper.net/us/en/partners)
[Support](http://www.juniper.net/us/en/support)
[Education](http://www.juniper.net/us/en/training)
KNOWLEDGE BASE
[Home](http://www.juniper.net/) > [Support](http://www.juniper.net/support) > [KB Home](http://kb.juniper.net/index?page=home)

|     |     |     |     |     |     |
| --- | --- | --- | --- | --- | --- |
| ![[./_resources/Juniper_Networks_-_Receiving_the_error_nc.windows.app.23712_when_launching_Network_Connect_-_Knowledge_Base.resources/home.gif]] | [KB Home](http://kb.juniper.net/index?page=home) | [![[./_resources/Juniper_Networks_-_Receiving_the_error_nc.windows.app.23712_when_launching_Network_Connect_-_Knowledge_Base.resources/binox_icon.png]]](http://kb.juniper.net/index?page=content&channel=KB) | [Browse Knowledge Base Categories](http://kb.juniper.net/index?page=content&channel=KB) | [![[./_resources/Juniper_Networks_-_Receiving_the_error_nc.windows.app.23712_when_launching_Network_Connect_-_Knowledge_Base.resources/printer3_16x16.gif]]](http://kb.juniper.net/index?page=content&id=KB11040&pmv=print) | [Printer Friendly](http://kb.juniper.net/index?page=content&id=KB11040&pmv=print) |

 
Receiving the error "nc.windows.app.23712" when launching Network Connect

|     |     |
| --- | --- |
| Knowledge Base ID: | [KB11040](http://kb.juniper.net/KB11040) |
| Version: | 4.0 |
| Published: | 27 May 2009 |
| Updated: | 27 May 2009 |
| Categories: | ![[./_resources/Juniper_Networks_-_Receiving_the_error_nc.windows.app.23712_when_launching_Network_Connect_-_Knowledge_Base.resources/li-arrow.gif]] [SA_2000](http://kb.juniper.net/index?page=content&channel=KB&cat=SA_2000)<br>![[./_resources/Juniper_Networks_-_Receiving_the_error_nc.windows.app.23712_when_launching_Network_Connect_-_Knowledge_Base.resources/li-arrow.gif]] [SA_3000](http://kb.juniper.net/index?page=content&channel=KB&cat=SA_3000)<br>![[./_resources/Juniper_Networks_-_Receiving_the_error_nc.windows.app.23712_when_launching_Network_Connect_-_Knowledge_Base.resources/li-arrow.gif]] [SA_4000](http://kb.juniper.net/index?page=content&channel=KB&cat=SA_4000)<br>![[./_resources/Juniper_Networks_-_Receiving_the_error_nc.windows.app.23712_when_launching_Network_Connect_-_Knowledge_Base.resources/li-arrow.gif]] [SA_5000](http://kb.juniper.net/index?page=content&channel=KB&cat=SA_5000)<br>![[./_resources/Juniper_Networks_-_Receiving_the_error_nc.windows.app.23712_when_launching_Network_Connect_-_Knowledge_Base.resources/li-arrow.gif]] [SA_6000](http://kb.juniper.net/index?page=content&channel=KB&cat=SA_6000)<br>![[./_resources/Juniper_Networks_-_Receiving_the_error_nc.windows.app.23712_when_launching_Network_Connect_-_Knowledge_Base.resources/li-arrow.gif]] [SA_6000_SP](http://kb.juniper.net/index?page=content&channel=KB&cat=SA_6000_SP)<br>![[./_resources/Juniper_Networks_-_Receiving_the_error_nc.windows.app.23712_when_launching_Network_Connect_-_Knowledge_Base.resources/li-arrow.gif]] [SA_700](http://kb.juniper.net/index?page=content&channel=KB&cat=SA_700)<br>![[./_resources/Juniper_Networks_-_Receiving_the_error_nc.windows.app.23712_when_launching_Network_Connect_-_Knowledge_Base.resources/li-arrow.gif]] [SA_1000](http://kb.juniper.net/index?page=content&channel=KB&cat=SA_1000)<br>![[./_resources/Juniper_Networks_-_Receiving_the_error_nc.windows.app.23712_when_launching_Network_Connect_-_Knowledge_Base.resources/li-arrow.gif]] [SSL_VPN_(IVE_OS)](http://kb.juniper.net/index?page=content&channel=KB&cat=SSL_VPN_IVE_OS) |

**Summary:**

Most often, the nc.windows.app.23712 error can be resolved by uninstalling all previous versions of Network Connect (NC) from the system, and then reinstalling Network Connect.   If the error is encountered again upon uninstalling and reinstalling Network Connect, there may be a problem with the Network Connect virtual adapter.  If this is the case, the Network Connect Virtual Adapter should manually be removed so that it can be reinstalled the next time Network Connect is launched on the system.

**Problem or Goal:**

The following error is encountered when launching Network Connect:

"nc.windows.app.23712. The Network Connect session terminated.  Do you want to reconnect?"

 When choosing "yes" you may see the same error again, or a different error that still prevents you from launching Network Connect.
**Solution:**
To manually remove the Network Connect virtual adapter on Windows XP go to the _Control Panel > System > Device Manager_ and delete the Juniper Network Connect virtual adapter from the Network Adapters.  If you do not see the Network Connect virtual adapter listed, select  _"Show hidden devices_" from the "View" drop-down menu on the toolbar in the Device Manager window.
 
Alternatively, to remove the Network Connect Virtual Adapter right-click on the adapter and choose "uninstall".
A new adapter will be reinstalled the next time a Network Connect session is launched.
**Purpose:**
Troubleshooting

|     |
| --- |
| User ID |
| Password |
|     |

* [Login assistance](https://registration.juniper.net/ent/registration/login_assistance.aspx)

ASK THE KB
**Question or KB ID:**

RELATED TOPICS

* [Install Search Engine PlugIn](http://mycroft.mozdev.org/jsreq.html)
* [Submit a Support Case](http://www.juniper.net/cm/index.jsp)
* [KB Feedback](http://kb.juniper.net/feedback.jsp)

[Site Map](http://www.juniper.net/us/en/site-map)
[RSS Feeds](http://rss.juniper.net/)
[Careers](http://www.juniper.net/us/en/company/careers)
[Accessibility](http://www.juniper.net/us/en/accessibility)
[Feedback](http://www.juniper.net/cgi-bin/feedback)
[Privacy & Policy](http://www.juniper.net/us/en/privacy-policy)
[Legal Notices](http://www.juniper.net/us/en/legal-notices)
Copyright© 1999-2009 Juniper Networks, Inc.
![[./_resources/Juniper_Networks_-_Receiving_the_error_nc.windows.app.23712_when_launching_Network_Connect_-_Knowledge_Base.resources/nojavascript&WT.0]]
