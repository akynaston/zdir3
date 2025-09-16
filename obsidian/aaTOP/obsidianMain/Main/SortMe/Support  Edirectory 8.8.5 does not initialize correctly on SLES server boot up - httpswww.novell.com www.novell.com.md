# Support | Edirectory 8.8.5 does not initialize correctly on SLES server boot up - https://www.novell.com/ [www.novell.com]

[Home](http://www.novell.com/)

* [Skip to Content](https://www.novell.com/support/kb/doc.php?id=7006867#top)

* [Products](http://www.novell.com/products/)
* [Services & Support](http://www.novell.com/services/)
* [Partners](https://www.partnernetprogram.com/)
* [Communities](http://www.novell.com/communities/)
* [About Us](http://www.novell.com/company/)
* [How to Buy](http://www.novell.com/products/howtobuy.html)

![[]]

[**Change**](https://www.novell.com/common/util/langselect.php?referer=https%3A//www.novell.com/support/kb/doc.php%3Fid%3D7006867) **_United States,_ English**

[**Login**](https://www.novell.com/common/util/secure/login.php?r=https://www.novell.com/support/kb/doc.php?id=7006867)

[Close](https://www.novell.com/support/kb/doc.php?id=7006867#)

# [Knowledgebase](https://www.novell.com/support/kb/)

* [FAQ](http://support.novell.com/additional/faq.html)

* [Register Your Product](https://secure-www.novell.com/center/regadmin/jsps/activate_app.jsp)
* [Support Handbook](https://www.novell.com/support/handbook/)
* [My Favorites](https://www.novell.com/support/kb/doc.php?id=7006867#)

* [Email Document](https://www.novell.com/support/kb/doc.php?id=7006867#)

* [Printer Friendly](https://www.novell.com/support/kb/doc.php?id=7006867)
* [Favorite](https://www.novell.com/support/kb/doc.php?id=7006867&add&title=Edirectory+8.8.5+does+not+initialize+correctly+on+SLES+server+boot+up)
* Rating:
	

# Edirectory 8.8.5 does not initialize correctly on SLES server boot up

This document **(7006867)** _is provided subject to the [disclaimer](https://www.novell.com/support/kb/doc.php?id=7006867#disclaimer) at the end of this document._

### Environment

Novell eDirectory 8.5x for Linux
SUSE Linux Enterprise Server 10 Service Pack 3
HP BL460 with Bonded NIC

### Situation

On server boot, it is observed that eDirectory is not loading properly.  The ldap startup reports failures.  When checking the status with utils:
server1:/home/user1 # ndsstat
\[1\] Instance at /etc/opt/novell/eDirectory/conf/nds.conf:  server1.O=servers.ndstree
Failed to obtain a Novell eDirectory Server connection to server1.O=servers.ndstree or Novell eDirectory Server is not running
server1:/home/user1 # ndsrepair -N
\[1\] Instance at /etc/opt/novell/eDirectory/conf/nds.conf:  server1.O=servers.ndstree
Repair utility for Novell eDirectory 8.8 - 8.8 SP5 v20503.09
DS Version 20503.15  Tree name:
Server name: **server1**
Size of /var/opt/novell/eDirectory/log/ndsrepair.log = 217593 bytes.
This list shows each server found in the local database. Select a server to display an options menu.
Building server list
Please Wait...
The Directory Services Database is closed
Try running the local database repair
      Total errors: 0
NDSRepair process completed.
When checking for the ndsd process, ps shows ndsd is running.  The ndsd.log also shows what appears to be a normal start.  If ndsd is stopped/started at the server console, it loads normally.  We only observe this problem when the OS is restarted.

### Resolution

When using NIC Bonding, the network may be slower to initialize.  eDirectory will start loading before we have the network fully functioning.  To allow for additional time needed during boot, edit "/etc/sysconfig/boot" as follows:
find:
RUN\_PARALLEL="yes"
change to:
RUN\_PARALLEL="no"
Then save and exit the editor.
This change allows the Network to fully initialize before eDirectory starts.  This change may add a bit of time to the server boot process, but it will be minimal.

### Disclaimer

This Support Knowledgebase provides a valuable tool for NetIQ/Novell/SUSE customers and parties interested in our products and solutions to acquire information, ideas and learn from one another. Materials are provided for informational, personal or non-commercial use within your organization and are presented "AS IS" WITHOUT WARRANTY OF ANY KIND.

* **Document ID:**_7006867_

* **Creation Date:**17-SEP-10
* **Modified Date:**26-APR-12

* **NetIQ**eDirectory

Did this document solve your problem? [[#|Provide Feedback]]

© 2015 Micro Focus

* [Careers](http://www.novell.com/company/careers/)

* [Legal](http://www.novell.com/company/legal/)

[close](https://www.novell.com/support/kb/doc.php?id=7006867#)

* [Feedback](http://www.novell.com/inc/feedback/feedback.html)

* [Print](https://www.novell.com/support/kb/doc.php?id=7006867#)
* [1-888-321-4272](http://www.novell.com/company/contact.html)
* [Request a Call](https://www.novell.com/common/inc/requestcall_overlay.html)
* [Follow Us](https://www.novell.com/support/kb/doc.php?id=7006867#)
