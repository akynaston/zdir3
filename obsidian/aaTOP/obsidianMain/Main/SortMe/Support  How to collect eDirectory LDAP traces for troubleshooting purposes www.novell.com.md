# Support | How to collect eDirectory LDAP traces for troubleshooting purposes [www.novell.com]

[![[./_resources/Support__How_to_collect_eDirectory_LDAP_traces_for_troubleshooting_purposes_www.novell.com.resources/unknown_filename.png]]](http://www.novell.com/)

* [Skip to Content](http://www.novell.com/support/kb/doc.php?id=7007106#top)

* [Products](http://www.novell.com/products/)
* [Services & Support](http://www.novell.com/services/)
* [Partners](https://www.partnernetprogram.com/)
* [Communities](http://www.novell.com/communities/)
* [About Novell](http://www.novell.com/company/)
* [How to Buy](http://www.novell.com/products/howtobuy.html)

![[]]

[**Change**](https://www.novell.com/common/util/langselect.php?referer=http%3A//www.novell.com/support/kb/doc.php%3Fid%3D7007106) **_United States,_ English**

[**Login**](https://www.novell.com/common/util/secure/login.php?r=http://www.novell.com/support/kb/doc.php?id=7007106)

[Close](http://www.novell.com/support/kb/doc.php?id=7007106#)

# [Knowledgebase](http://www.novell.com/support/kb/)

* [FAQ](http://support.novell.com/additional/faq.html)

* [Register Your Product](https://secure-www.novell.com/center/regadmin/jsps/activate_app.jsp)
* [My Favorites](http://www.novell.com/support/kb/doc.php?id=7007106#)

* [Email Document](http://www.novell.com/support/kb/doc.php?id=7007106#)

* [Printer Friendly](http://www.novell.com/support/kb/doc.php?id=7007106)
* [Favorite](http://www.novell.com/support/kb/doc.php?id=7007106&add&title=How+to+collect+eDirectory+LDAP+traces+for+troubleshooting+purposes)
* Rating:
	

# How to collect eDirectory LDAP traces for troubleshooting purposes

This document **(7007106)** _is provided subject to the [disclaimer](http://www.novell.com/support/kb/doc.php?id=7007106#disclaimer) at the end of this document._

### Environment

Novell eDirectory 8.8 for All Platforms
Novell eDirectory 8.7.3 for All Platforms

### Situation

Troubleshoot Novell LDAP configuration
Troubleshoot Linux User Management (LUM) installation and configuration
Linux User Management Daemon (NAMCD) does not load
LDAP traces are requested by a Novell Technical Services (NTS) engineer

### Resolution

Depending on eDirectory version and platform where it is installed, perform the following steps:
1\. Increase debug level of LDAP messages by setting the LDAP server object screen options, through any of the following procedures:

On NetWare, type the command below in the console:
ldap dstrace +all
On Linux and Solaris, this can be achieved using the following command:
ldapconfig set "LDAP Screen Level=all"

Through iManager which is platform independent , follow the steps below:
\- click on _Modify Object_ from _Directory Administration_ role and task;
\- locate and select the LDAP Server object related to the affected server;
\- select _Tracing_ tab and enable all the LDAP screen options, then click _Apply_.

2\. Configure (n)dstrace enabling LDAP trace, quickly reproduce the issue, and collect the generated log file.
NetWare operating system

On the NetWare console, type

load dstrace
dstrace -all
dstrace +ldap
dstrace +time
dstrace +tags
dstrace file off (to clear the trace file)
dstrace screen on
dstrace file on
Once the tests have been completed, turn off tracing as follows:
dstrace file off
unload dstrace
Log file is in SYS:\\SYSTEM\\DSTRACE.LOG

Linux and Solaris operating systems

Open a terminal and type
ndstrace
set ndstrace=nodebug
ndstrace +ldap
ndstrace +time
ndstrace +tags
set ndstrace=\*r (to clear the trace file)
ndstrace screen on
ndstrace file on
Once the tests have been completed, turn off tracing as follows:
ndstrace file off
exit
According to the eDirectory version installed, by default log files for 8.7.3.x and 8.8.x are respectively located in:
/var/nds/log/ndstrace.log
/var/opt/novell/eDirectory/log/ndstrace.log

Microsoft Windows operating systems
Launch Novell eDirectory Services Console (NDSCons.exe) and:
a. Select _dstrace.dlm_ service from the _Services_ tab and click on _Start_ button.
b. On the new _Novell eDirectory Trace_ window, click on _File_ and then _New_.
c. Choose preferred path and file name, then click on _Open_.
d. Yet from the _Trace_ window, click on _Edit_ and then _Options_.
e. Click on _Clear All_ button On the new _Trace Options_ window, and check the _LDAP_ box only.
f. Switch to the _Screen_ tab and make sure _Time Stamp_ and _Option Tag_ boxes are checked.
g. Click on _OK_ and perform your tests. Closing the _Trace_ window will unload _dstrace.dlm_ as well.

iMonitor (platform-independent)
As administrator, follow the procedure below:

a. Click on the _Trace Configuration_ button from the left menu.
b. Click on _Clear All_ box and then on the _LDAP_ radio button under the _DS Trace Options_ section.
c. Click on _Trace On_ to start capturing and logging the LDAP activity.
d. A new _Trace_ line will be available at the top of the screen. To stop tracing, click on _Trace Off_.
e. Click on _Trace History_ to access archived trace files. The most recent trace information will be shown.

### Disclaimer

This Support Knowledgebase provides a valuable tool for NetIQ/Novell/SUSE customers and parties interested in our products and solutions to acquire information, ideas and learn from one another. Materials are provided for informational, personal or non-commercial use within your organization and are presented "AS IS" WITHOUT WARRANTY OF ANY KIND.

* **Document ID:**_7007106_

* **Creation Date:**27-OCT-10
* **Modified Date:**26-APR-12

* **NetIQ**eDirectory

Did this document solve your problem? [[#|Provide Feedback]]

© 2014 Novell

* [Careers](http://www.novell.com/company/careers/)

* [Legal](http://www.novell.com/company/legal/)

[close](http://www.novell.com/support/kb/doc.php?id=7007106#)

* [Feedback](http://www.novell.com/inc/feedback/feedback.html)

* [Print](http://www.novell.com/support/kb/doc.php?id=7007106#)
* [1-888-321-4272](http://www.novell.com/company/contact.html)
* [Request a Call](http://www.novell.com/common/inc/requestcall_overlay.html)
* [Follow Novell](http://www.novell.com/support/kb/doc.php?id=7007106#)
[Novell](http://www.novell.com/)
