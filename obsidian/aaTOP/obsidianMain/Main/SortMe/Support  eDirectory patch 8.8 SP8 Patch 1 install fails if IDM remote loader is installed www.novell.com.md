# Support | eDirectory patch 8.8 SP8 Patch 1 install fails if IDM remote loader is installed [www.novell.com]

[![[./_resources/Support__eDirectory_patch_8.8_SP8_Patch_1_install_fails_if_IDM_remote_loader_is_installed_www.novell.com.resources/unknown_filename.png]]](http://www.novell.com/)

* [Skip to Content](https://www.novell.com/support/kb/doc.php?id=7014555#top)

* [Products](http://www.novell.com/products/)
* [Services & Support](http://www.novell.com/services/)
* [Partners](https://www.partnernetprogram.com/)
* [Communities](http://www.novell.com/communities/)
* [About Novell](http://www.novell.com/company/)
* [How to Buy](http://www.novell.com/products/howtobuy.html)

![[./_resources/Support__eDirectory_patch_8.8_SP8_Patch_1_install_fails_if_IDM_remote_loader_is_installed_www.novell.com.resources/hdr_2009_srch_btn.png]]

[**Change**](https://www.novell.com/common/util/langselect.php?referer=https%3A//www.novell.com/support/kb/doc.php%3Fid%3D7014555) **_United States,_ English**

[**Logout**](http://www.novell.com/AGLogout)**_Welcome_  [Aaron Kynaston](https://secure-www.novell.com/center/regadmin/jsps/profile_app.jsp)**

[Close](https://www.novell.com/support/kb/doc.php?id=7014555#)

# [Knowledgebase](https://www.novell.com/support/kb/)

* [FAQ](http://support.novell.com/additional/faq.html)

* [Register Your Product](https://secure-www.novell.com/center/regadmin/jsps/activate_app.jsp)
* [My Favorites](https://www.novell.com/support/kb/doc.php?id=7014555#)

* [Email Document](https://www.novell.com/support/kb/doc.php?id=7014555#)

* [Printer Friendly](https://www.novell.com/support/kb/doc.php?id=7014555)
* [Favorite](https://www.novell.com/support/kb/doc.php?id=7014555&add&title=eDirectory+patch+8.8+SP8+Patch+1+install+fails+if+IDM+remote+loader+is+installed)
* Rating:
	

# eDirectory patch 8.8 SP8 Patch 1 install fails if IDM remote loader is installed

This document **(7014555)** _is provided subject to the [disclaimer](https://www.novell.com/support/kb/doc.php?id=7014555#disclaimer) at the end of this document._

### Environment

NetIQ eDirectory 8.8 SP8
NetIQ Identity Manager 4.02

### Situation

First eDirectory 8.8 SP8 was installed prior to installing IDM.  Then an attempt to apply eDirectory 8.8 SP8 Patch 1 was made.  The installation results in the following error:

novell-edirectory-xdasinstrument                     | 8.8.8.0.1             \[
   OK      \]
| novell-edirectory-xdaslog-conf                       | 8.8.7.0.1           
\[WRONG PRODUCT\]
\============================================ ERROR===========================================
The currently installed version of "novell-edirectory-xdaslog-conf 8.8.7.0.1"
is not able to have the "novell-edirectory-xdaslog-conf 8.8.8.1.11" package
from NetIQ eDirectory 8.8.8.1 applied over it.
Please ensure you are currently running NetIQ eDirectory 8.8.8.

Final NetIQ eDirectory 8.8.8.1 Patch Installation  Status                  
\[    FAILED    \]nsure you are currently running NetIQ eDirectory 8.8.8.

### Resolution

The IDM installer is removing the 8.8.8 XDAS files and laying down older 887 files.  These files must be replaced.

Workaround:

1\. Stop eDirectory.

2\. Go to the \\Linux64 folder of patch directory.

3\. Upgrade the following 8.8.7 rpms with the rpm upgrade option, by using the -Uvh switch:
     novell-edirectory-expat-32bit-8.8.7-1.x86\_64
     novell-edirectory-expat-8.8.7-1.x86\_64
     novell-edirectory-xdaslog-conf-8.8.7-1.noarch
     novell-edirectory-xdaslog-32bit-8.8.7-1.x86\_64
     novell-edirectory-xdaslog-8.8.7-1.x86\_64

4\. Apply eDirectory 8.8 SP8 Patch 1.

5\. Start eDirectory.

### Disclaimer

This Support Knowledgebase provides a valuable tool for NetIQ/Novell/SUSE customers and parties interested in our products and solutions to acquire information, ideas and learn from one another. Materials are provided for informational, personal or non-commercial use within your organization and are presented "AS IS" WITHOUT WARRANTY OF ANY KIND.

* **Document ID:**_7014555_

* **Creation Date:**12-FEB-14
* **Modified Date:**12-FEB-14

* **NetIQ**eDirectory
	
	Identity Manager

Did this document solve your problem? [Provide Feedback](https://www.novell.com/support/kb/doc.php?id=7014555javascript:openExternal('https://novell.qualtrics.com/SE/?SID=SV_a2USKSZ3DbcQbwp&BU=1&doc=7014555'))

© 2014 Novell

* [Careers](http://www.novell.com/company/careers/)

* [Legal](http://www.novell.com/company/legal/)

[close](https://www.novell.com/support/kb/doc.php?id=7014555#)

* [Feedback](http://www.novell.com/inc/feedback/feedback.html)

* [Print](https://www.novell.com/support/kb/doc.php?id=7014555#)
* [1-888-321-4272](http://www.novell.com/company/contact.html)
* [Request a Call](https://www.novell.com/common/inc/requestcall_overlay.html)
* [Follow Novell](https://www.novell.com/support/kb/doc.php?id=7014555#)
[Novell](https://www.novell.com/)
