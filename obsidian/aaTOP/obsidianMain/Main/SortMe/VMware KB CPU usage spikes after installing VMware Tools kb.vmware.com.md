# VMware KB: CPU usage spikes after installing VMware Tools [kb.vmware.com]

# Knowledge Base

The VMware Knowledge Base provides support solutions, error messages and troubleshooting guides
[![[./_resources/VMware_KB_CPU_usage_spikes_after_installing_VMware_Tools_kb.vmware.com.resources/btn_kb-home.png]]](http://kb.vmware.com/selfservice) [![[./_resources/VMware_KB_CPU_usage_spikes_after_installing_VMware_Tools_kb.vmware.com.resources/btn_knowledge-base-help.png]]](http://kb.vmware.com/kb/878)

**Search the VMware Knowledge Base (KB)** **View by Article ID**

|     |     |
| --- | --- |
|     |     |
|     |     |

|     |     |
| --- | --- |
|     |     |

## CPU usage spikes after installing VMware Tools (1015674)

#### Symptoms

After installing or upgrading VMware Tools in a Windows virtual machine, you experience these issues on an ESX 4.x host:

* CPU usage by the `vmtoolsd.exe` process spikes every few seconds.

* Reinstalling VMware Tools does not resolve the issue.
* In the VMware Tools log, you see this error repeatedly:
	`Cannot find perfmon object in array returned by perfDLL, index=1 Nov 11 13:51:03.774: [vmsvc]: GuestInfoMonitorReadOnePerfmonCounter fails`

#### Cause

VMware Tools in ESX 4.x installs two performance objects for performance monitoring (`perfmon`):

* VM memory

* VM processor
If `perfmon` is not working properly or is corrupt, VMware Tools uses excess CPU cycles in an attempt to update `perfmon` counters.
To confirm that `perfmon` is causing this issue, enable VMware Tools logging in the guest operating system:

1. Open the `tools.conf` file in a text editor. For more information on where to find the `tools.conf` file, see [Enabling debug logging for VMware Tools within a guest operating system (1007873)](http://kb.vmware.com/selfservice/microsites/search.do?cmd=displayKC&docType=kc&docTypeID=DT_KB_1_1&externalId=1007873).

* Add this line to `tools.conf`:
	`log.file = "c:\vmware.log"`
	
* Restart the VMware Tools service (`vmtoolsd.exe`).
* Examine the VMware Tools log for the error listed in the _Symptoms_ section.

#### Resolution

To resolve this issue, rebuild the performance counters using the Windows `lodctr` utility.
To rebuild the performance counters:

1. Stop the VMware Tools service.

* Run these commands at a command prompt:
	`# cd\windows\system32 #lodctr /R`
	**Note**: For more information about on using `lodctr /R`, see Microsoft Knowledge Base article [300956](http://support.microsoft.com/kb/300956).
	_The preceding link was correct as of May 24, 2013. If you find the link is broken, provide feedback and a VMware employee will update the link._
If the `lodctr /R` command does not resolve the issue:

1. Follow the steps in Microsoft Knowledge Base article [300956](http://support.microsoft.com/?kbid=300956).

* Reinstall VMware Tools.
* Reboot the virtual machine.
To verify that `perfmon` is working correctly:

1. Launch `perfmon.msc`.

* Verify that the VMware performance objects can be loaded.
* Verify that `perfmon` shows specific object names and not numbers.

#### Additional Information

To disable VMware Tools logging, see [Enabling debug logging for VMware Tools within a guest operating system (1007873)](http://kb.vmware.com/selfservice/microsites/search.do?cmd=displayKC&docType=kc&docTypeID=DT_KB_1_1&externalId=1007873).

#### Tags

vmware-tools-corrupt vmware-tools-integrity vmware-tools-linux virtual-machine-performance-degraded

#### See Also

* [[#|Enabling debug logging for VMware Tools within a guest operating system]]
* [[#|安装 VMware Tools 后 CPU 使用率达到峰值]]

#### Update History

09/06/2012 - Changed vmwareservice.exe to vmtoolsd.exe

#### Request a Product Feature

To request a new product feature or to provide feedback on a VMware product, please visit the [Request a Product Feature](http://www.vmware.com/contact/contactus.html?department=prod_request) page.

#### Feedback

|     |
| --- |
| * [[#\|1]]<br>* [[#\|2]]<br>* [[#\|3]]<br>* [[#\|4]]<br>* [[#\|5]] |
| * 10 Ratings |     |

|     |
| --- |
| **Did this article help you?** |     |
| This article resolved my issue.<br>This article did not resolve my issue.<br>This article helped but additional information was required to resolve my issue. |     |
| **What can we do to improve this information? (4000 or fewer characters)** |     |
|     |     |
| Email/ Twitter ID |     |
|     |     |
|     |     |

Permalink to: [CPU usage spikes after installing VMware Tools](http://kb.vmware.com/kb/1015674)

* [Read our blog](http://blogs.vmware.com/kb/)
* [Watch KBTV](http://blogs.vmware.com/kbtv/)
* [Follow us](http://www.twitter.com/vmwarekb)
* [Request New Content](http://www.vmware.com/landing_pages/knowledgebase-content-request.html)

|     |
| --- |
| * [[#\|1]]<br>* [[#\|2]]<br>* [[#\|3]]<br>* [[#\|4]]<br>* [[#\|5]] |
| * 10 Ratings |     |

Actions

* [[#|Bookmark Document]]

* [[#|Email Document]]
* [[#|Print Document]]
* [Subscribe to Document](http://kb.vmware.com/selfservice/microsites/microsite.do?cmd=displayKC&docType=kc&docTypeID=DT_KB_1_1&externalId=1015674&format=rss)
* [![[./_resources/VMware_KB_CPU_usage_spikes_after_installing_VMware_Tools_kb.vmware.com.resources/lg-share-en.gif]]](http://www.addthis.com/bookmark.php?v=250&username=xa-4b5f42f36e60a29e)
	
KB: 1015674

* Updated: **May 29, 2013**

* **Categories:**
	Troubleshooting* **Languages:**
	English
* **Product(s):**
	VMware ESX
	VMware vCenter Server
* **Product Version(s):**
	VMware ESX 4.0.x
	VMware ESX 4.1.x
	VMware vCenter Server 4.0.x
	VMware vCenter Server 4.1.x
.

<http://www.vmware.com/>

* [My VMware](https://my.vmware.com/web/vmware/login)

* [Partner Central](http://www.vmware.com/go/partnercentral)
* [Training](http://www.vmware.com/training/)
* [Community](http://communities.vmware.com/welcome)
* [Store](http://www.vmware.com/vmwarestore/)

* [Products](http://www.vmware.com/products/)

* [Support](http://www.vmware.com/support/)
* [Downloads](https://my.vmware.com/web/vmware/downloads)
* [Consulting](http://www.vmware.com/consulting/)
* [Partner Programs](http://www.vmware.com/partners/)
* [Company](http://www.vmware.com/company/)

* United States  <http://www.vmware.com/worldwide.html>

![[./_resources/VMware_KB_CPU_usage_spikes_after_installing_VMware_Tools_kb.vmware.com.resources/search-b-icon.png]]

#### VMware Technology

* [Virtualization](http://www.vmware.com/virtualization/)

* [Data Center Virtualization](http://www.vmware.com/products/datacenter-virtualization.html)
* [Desktop Virtualization](http://www.vmware.com/products/desktop-virtualization.html)
* [Virtualizing Enterprise Applications](http://www.vmware.com/business-critical-apps/index.html)
* [Cloud Computing](http://www.vmware.com/cloud-computing/overview.html)
* [Hybrid Cloud](http://www.vmware.com/products/vcloud-hybrid-service/)
* [Private Cloud Computing](http://www.vmware.com/cloud-computing/private-cloud.html)
* [Software-Defined Data Center](http://www.vmware.com/software-defined-datacenter/index.html)
* [Workforce Mobility](http://www.vmware.com/workforce-mobility/)

#### Company Information

* [Leadership](http://www.vmware.com/company/leadership/)

* [Careers at VMware](http://www.vmware.com/company/careers/)
* [Acquisitions](http://www.vmware.com/company/acquisitions/)
* [Office Locations](http://www.vmware.com/company/office_locations/)
* [Contact VMware](http://www.vmware.com/company/contact/)
* [Investor Relations](http://ir.vmware.com/)
* [VMware Foundation](http://www.vmware.com/company/foundation.html)
* [Why Choose VMware?](http://www.vmware.com/why-choose-vmware/overview.html)

#### News & Events

* [Newsroom](http://www.vmware.com/company/news/)

* [Articles](http://www.vmware.com/company/news/articles/)
* [Events](http://www.vmware.com/events/)
* [Awards](http://www.vmware.com/company/news/awards.html)
* [Media Resource Center](http://www.vmware.com/company/news/mediaresource/index.html)
* [Media & Contacts](http://www.vmware.com/company/news/releases/pr_contacts/)

#### Community

* [VMTN Communities](http://communities.vmware.com/community/vmtn/)

* [VMware Blogs](http://blogs.vmware.com/)
* [VMware on Twitter](http://communities.vmware.com/community/twitter)
* [VMware on Facebook](http://communities.vmware.com/community/facebook)
* [VMware on YouTube](http://communities.vmware.com/community/youtube)
* [Community Terms of Use](http://www.vmware.com/community_terms.html)

Copyright © 2013 VMware, Inc. All rights reserved.

* [Contact Us](http://www.vmware.com/company/contact/)

* [Terms of Use](http://www.vmware.com/help/legal.html)
* [Privacy](http://www.vmware.com/help/privacy.html)
* [Accessibility](http://www.vmware.com/accessibility.html)
* [Site Index](http://www.vmware.com/site_index.html)
* [Help](http://www.vmware.com/help/)
* [[#|Feedback]]
