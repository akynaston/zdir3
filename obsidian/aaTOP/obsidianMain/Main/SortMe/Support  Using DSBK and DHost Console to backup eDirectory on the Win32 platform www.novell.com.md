# Support | Using DSBK and DHost Console to backup eDirectory on the Win32 platform [www.novell.com]

[![[./_resources/Support__Using_DSBK_and_DHost_Console_to_backup_eDirectory_on_the_Win32_platform_www.novell.com.resources/unknown_filename.png]]](http://www.novell.com/)

* [Skip to Content](http://www.novell.com/support/kb/doc.php?id=3000951#top)

* [Products](http://www.novell.com/products/)
* [Services & Support](http://www.novell.com/services/)
* [Partners](https://www.partnernetprogram.com/)
* [Communities](http://www.novell.com/communities/)
* [About Novell](http://www.novell.com/company/)
* [How to Buy](http://www.novell.com/products/howtobuy.html)

![[]]

[**Change**](https://www.novell.com/common/util/langselect.php?referer=http%3A//www.novell.com/support/kb/doc.php%3Fid%3D3000951) **_United States,_ English**

[**Login**](https://www.novell.com/common/util/secure/login.php?r=http://www.novell.com/support/kb/doc.php?id=3000951)

[Close](http://www.novell.com/support/kb/doc.php?id=3000951#)

# [Knowledgebase](http://www.novell.com/support/kb/)

* [FAQ](http://support.novell.com/additional/faq.html)

* [Register Your Product](https://secure-www.novell.com/center/regadmin/jsps/activate_app.jsp)
* [My Favorites](http://www.novell.com/support/kb/doc.php?id=3000951#)

* [Email Document](http://www.novell.com/support/kb/doc.php?id=3000951#)

* [Printer Friendly](http://www.novell.com/support/kb/doc.php?id=3000951)
* [Favorite](http://www.novell.com/support/kb/doc.php?id=3000951&add&title=Using+DSBK+and+DHost+Console+to+backup+eDirectory+on+the+Win32+platform)
* Rating:
	

# Using DSBK and DHost Console to backup eDirectory on the Win32 platform

This document **(3000951)** _is provided subject to the [disclaimer](http://www.novell.com/support/kb/doc.php?id=3000951#disclaimer) at the end of this document._

### Environment

Microsoft Windows 2000 Advanced Server
Microsoft Windows Server 2003 Enterprise Edition
Novell eDirectory 8.7.3.8 for Windows 2000
Novell eDirectory 8.7.3.8 for Windows 2003
DHost Console for Novell eDirectory 8.7.3.7 (10552.675)
Novell eDirectory 8.7.3 for Windows
Microsoft Windows Server 2003 Server
Microsoft Windows 2000 Server

### Resolution

DHost Console is a new utility that adds new functionality to eDirectory 8.7.3 on the Win32 platform. It was introduced along with the DSBK backup utility. In addition to other capabilities, DHost Console provides a way to create a scheduled batch file that can run DSBK on the Win32 platform in order to backup the eDirectory database unattended. It is run from a command line. Below are examples on how to use this utility to run DSBK to backup eDirectory as well as other commands available and what tasks they perform.

NOTE: This utility must have an ip address specified on which DHOST is listening in order to perform certain tasks. Replace the examples' IP address with your own. These commands may fail if ipx is bound and DHOST is listening on that bound IPX interface. You must unbind IPX from the server and clear it from the DHOST interface list using TID 10097402 as a workaround. We hope to have this issue resolved in a future release. DHOSTCON Brings up a summary of the command syntax as well as the commands that are available. DHOSTCON 169.254.143.79 VERSION Displays the DHost Console version. DHOSTCON 169.254.143.79 MODULES Displays the currently loaded eDirectory modules.

DHOSTCON 169.254.143.79 ISMODLOADED DS.DLM Determines if the specified module is loaded.

NOTE: If the module is not loaded the command " ECHO %ERRORLEVEL% " will return a 0. If a number other than 0 is returned then the specified module is loaded. This can be useful when creating batch files.

DHOSTCON 169.254.143.79 LOAD DSREPAIR.DLM DHOSTCON 169.254.143.79 UNLOAD DSREPAIR.DLM DHOSTCON 169.254.143.79 LOAD DSREPAIR.DLM -RC DHOSTCON 169.254.143.79 LOAD DSREPAIR.DLM -U

These commands function much like a load statement on NetWare. In the above example we loaded then unloaded dsrepair, grabbed a snapshot backup of the database then performed an unattended repair of the database.

NOTE: If your batch file is to run multiple actions, such as a -RC and a -U, you would want to run the
ISMODLOADED command on DSREPAIR.DLM testing for an ERRORLEVEL other than 0 before continuing
DHOSTCON 169.254.143.79 CONN LIST This lists all connections currently present for DHOST excluding those in a NOT\_LOGGED\_IN status. (Currently this utility does not report accurately whether this is an admin equivilant connection or not.)

DHOSTCON 169.254.143.79 CONN KILL 10
DHOSTCON 169.254.143.79 CONN KILL ALL
These commands kill specific connections or all connections. If all are killed none will be displayed in the NDSConsole - Connections tab. In order for the NDSConsole connections to be re-created one must unload then reload NDSConsole.

RUNNING DSBK USING THE DHOST CONSOLE UTILITY:
DHOSTCON 192.168.13.6 LOAD dsbk backup -f c:\\edirbak\\dsbk.bak -l c:\\edirbak\\dsbk.log -t -w -b
This command will place the eDirectory backup and backup log in the c:\\edirbak directory. Unlike the DHost Console utility, DSBK is case sensitive. Ensure that all statements following the word " DSBK " are in lower case.
DSBK should only be used by an administrator who has an advanced understanding of eDirectory, understands the concepts behind eDirectory's database roll forward logs as well as the ramifications of performing a restore of that database. Please carefully read the documentation carefully. It can be found at <http://www.novell.com/documentation/edir873/index.html>. Below are sections of particular importance.
\- Administration Guide - Backup and Restore
\- Administration Guide - Troubleshooting
\- Administration Guide - Maintaining Novell eDirectory
\- Administration Guide - Managing Partitions and Replicas

DSBK troubleshooting TIDS:
10099184
10099351

### Disclaimer

This Support Knowledgebase provides a valuable tool for NetIQ/Novell/SUSE customers and parties interested in our products and solutions to acquire information, ideas and learn from one another. Materials are provided for informational, personal or non-commercial use within your organization and are presented "AS IS" WITHOUT WARRANTY OF ANY KIND.

* **Document ID:**_3000951_

* **Creation Date:**10-JUL-06
* **Modified Date:**26-APR-12

* **NetIQ**eDirectory

Did this document solve your problem? [[#|Provide Feedback]]

© 2014 Novell

* [Careers](http://www.novell.com/company/careers/)

* [Legal](http://www.novell.com/company/legal/)

[close](http://www.novell.com/support/kb/doc.php?id=3000951#)

* [Feedback](http://www.novell.com/inc/feedback/feedback.html)

* [Print](http://www.novell.com/support/kb/doc.php?id=3000951#)
* [1-888-321-4272](http://www.novell.com/company/contact.html)
* [Request a Call](http://www.novell.com/common/inc/requestcall_overlay.html)
* [Follow Novell](http://www.novell.com/support/kb/doc.php?id=3000951#)
[Novell](http://www.novell.com/)
