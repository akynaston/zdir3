# Support | Troubleshooting Linux User Management - Step by Step [www.novell.com]

<http://www.novell.com/>

[![[./_resources/Support__Troubleshooting_Linux_User_Management_-_Step_by_Step_www.novell.com.resources/resource.png]]](http://www.novell.com/)

* [Skip to Content](http://www.novell.com/support/kb/doc.php?id=7002981#top)

* [Products](http://www.novell.com/products/)
* [Services & Support](http://www.novell.com/services/)
* [Partners](https://www.partnernetprogram.com/)
* [Communities](http://www.novell.com/communities/)
* [About Novell](http://www.novell.com/company/)
* [How to Buy](http://www.novell.com/products/howtobuy.html)

![[./_resources/Support__Troubleshooting_Linux_User_Management_-_Step_by_Step_www.novell.com.resources/hdr_2009_srch_btn.png]]

[**Change**](http://www.novell.com/common/util/langselect.php?referer=http%3A//www.novell.com/support/kb/doc.php%3Fid%3D7002981) **_United States,_ English**

[**Login**](http://www.novell.com/common/util/secure/login.php?r=http://www.novell.com/support/kb/doc.php?id=7002981)

[Close](http://www.novell.com/support/kb/doc.php?id=7002981#)

# [Knowledgebase](http://www.novell.com/support/kb/)

* [FAQ](http://support.novell.com/additional/faq.html)

* [Register Your Product](https://secure-www.novell.com/center/regadmin/jsps/activate_app.jsp)
* [My Favorites](http://www.novell.com/support/kb/doc.php?id=7002981#)

* [Email Document](http://www.novell.com/support/kb/doc.php?id=7002981#)

* [Printer Friendly](http://www.novell.com/support/kb/doc.php?id=7002981)
* [Favorite](http://www.novell.com/support/kb/doc.php?id=7002981&add&title=Troubleshooting+Linux+User+Management+-+Step+by+Step)
* Rating:
	

# Troubleshooting Linux User Management - Step by Step

This document **(7002981)** _is provided subject to the [disclaimer](http://www.novell.com/support/kb/doc.php?id=7002981#disclaimer) at the end of this document._

### Environment

Novell Open Enterprise Server (Linux based)
Novell eDirectory

### Situation

Troubleshoot Linux User Management (LUM) installation and configuration
Linux User Management Daemon (NAMCD) does not load
Command "id <User\_Name>" does not show details of LUM Enabled users in eDirectory
OES Services like NSS, iManager, iPrint, iFolder, NetStorage do not work

### Resolution

**Note:
**Perform steps given below in the same order to make sure that LUM is installed and configured properly. If a change has been made as per any of the steps given below, stop and start (Don't just restart) Name Service Cache (NSCD) and Linux User Management (NAMCD) daemons as mentioned in Step 15. Check again whether the issue is resolved and proceed further with next step, only if required.
One of the most common reason for LUM issues is the failure of LDAP on the Preferred-LDAP-Server due to the expiration of default certificates of the Preferred-LDAP-Server after the default expiration period of two years. If LUM suddenly stopped working without any changes to the existing setup (No change at all), start directly from steps 8 to 10 and then perform step 15. Check whether the issue gets resolved or not. If the issue still persists, start from Step No: 1.**1\.** **Verify the version and patch level of the OES server**

* Verify the base SLES version and patch level by the command: cat /etc/SuSe-release

* Verify the OES server version and patch level by the command: cat /etc/novell-release
* Verify the version and patch level as mentioned above after upgrade if the issue start to happen after an upgrade.
* A SuSE Linux Enterprise Server 10 (SLES 10) just installed with LUM RPM separately, is not supported. OES Package should be installed as an Add-On Product using YaST.

**2\. Verify the OES-LDAP Configuration**

* OES-LDAP is one of the base component of  an OES server
* Folder /etc/sysconfig/novell/ldap\_servers contains separate files for each OES-LDAP servers configured for the server. These can be any eDirectory servers in the eDirectory Tree on which LDAP is working fine on both ports, 389 (Non-Secure) and 636 (Secure)
* Each configured OES-LDAP server will have one file in the folder with IP Address as the file name. For example, 192.168.100.1
* Verify the OES-LDAP configuration and add more OES-LDAP Servers by the command: yast oes-ldap

**3\. Verify that LUM RPM is installed**

* Execute the command: rpm -q novell-lum
* If the RPM is not installed, use the YaST module "Open Enterprise Server | OES Install and Configuration" (Command: yast novell-lum) to install and configure LUM.

**4\. Verify that LUM configuration file /etc/nam.conf does exist**

* /etc/nam.conf is the primary (Main) LUM configuration file
	
* Make sure that the file is present by the command: ll /etc/nam.conf
* If the file is missing, use the YaST module "Open Enterprise Server | OES Install and Configuration" (Command: yast novell-lum) to install and configure LUM
* Find out details about different settings in the file using [this link](http://www.novell.com/documentation/oes2/acc_linux_svcs_lx/data/adx9356.html)
* Get a list and syntax of all possible settings by the command: namconfig get
* Set value for a setting by the command: namconfig set <paramater>=<value> (For example: namconfig set preferred-server=192.168.100.1)
	
* If LUM RPM seems to be installed and GUI based installation fails, command Line Utility "[namconfig](http://www.novell.com/documentation/oes2/acc_linux_svcs_lx/data/adxnn04.html)" can be helpful.

**5\. Compare files /etc/nam.conf  and /etc/sysconfig/novell/lum**
File /etc/sysconfig/novell/lum is an additional configuration file for LUM, which has a few very important settings. On an OES2 SP 1 server the file name will be /etc/sysconfig/novell/lum1 and on an OES2 SP 2 server it will be lum2\_sp2.

* Following two settings in these files **SHOULD** have same values. Conflicts cause issues like command "id <User\_Name>" does not display details for LUM Enabled users.
	
* Unix Config Object Context: "base-name" in nam.conf and "CONFIG\_LUM\_PARTITION\_ROOT" in lum
* Preferred LDAP Server: "preferred-server" in nam.conf and "CONFIG\_LUM\_LDAP\_SERVER" in lum
* As mentioned earlier file "lum" can have different names like lum, lum1 and lum2\_sp2, based on the Support Pack revision installed on the server.
	
* On an OES1 Linux server file corresponding to /etc/sysconfig/novell/lum is /etc/sysconfig/linuxUserMgmt
	

**6\. Verify that Unix Config and Unix Workstation objects do exist in eDirectory under correct contexts**
6.1 Unix Config Object

* Place the Unix Config object in the highest possible context, preferably under the Organization Object.
	
* Make sure that the Unix Config Object is present under the same context to which the setting "base-name" in the /etc/nam.conf file points to.
* Make sure that setting "CONFIG\_LUM\_PARTITION\_ROOT" in the file /etc/sysconfig/novell/lum and "base-name" in the file /etc/nam.conf point to same context.
* If the LUM installation failed to create one Unix Config Object,  perform an uninstall and reinstall of LUM, if the problem OES server is the first OES server in the Tree. LUM needs a Unix Config object to work.
	
* An eDirectory Tree can have more than one Unix Config Objects, shared by multiple OES Linux servers. An Unix Config Object should be moved or deleted only if none of the OES servers are pointed towards it.
* If moving the Unix Config Object is necessary as part of restructuring the eDirectory Tree, modify the setting "base-name" in the /etc/nam.conf and "CONFIG\_LUM\_PARTITION\_ROOT" in the file /etc/sysconfig/novell/lum for each OES Linux server.
* If the GUI based installation fails to create Unix Config and/or Unix Workstation objects, command Line utility "[namconfig](http://www.novell.com/documentation/oes2/acc_linux_svcs_lx/data/adxnn04.html)" can be used for LUM uninstall and reinstall.
	

6.2 Unix Workstation Object

* The object name **SHOULD** be: Unix Workstation - <Server\_Name>. Rename the object if required.
	
* The object should be in the same context as that of the NCP Server object for the OES Linux server.
	
* Make sure that the Tree does not have a Unix Workstation object for that particular server in any other contexts. This can happen as a result of reconfiguring LUM multiple times under different contexts. Perform a search for "\*Unix\*" from Tree \[Root\] (Subcontainer Search) if LUM was reconfigured with different contexts.
	
* Make sure that the setting "CONFIG\_LUM\_WS\_CONTEXT" in the file /etc/sysconfig/novell/lum is pointing to the server context of the OES server with a corresponding Unix Workstation object.
* If the LUM installation failed to create one Unix Workstation Object,  use the Task "Create Unix Workstation Object" under the Role "Linux user Management" in iManager to create the object.
* iManager running from any servers can be used for Linux User Management. Download and install correct version of Linux user Management Plug-In from the [Download Site](http://download.novell.com/index.jsp), if required.
	

**7\. Verify configuration of Unix Config and Unix Workstation Objects**
7.1 Unix Config Object

* Use the Task "Modify Unix Config Object" available under the Role "Linux User Management" in iManager.
	
* Make sure that the Server Context of the OES server is added into the "Workstation Context" field of Unix Config object.
* Find out the Server Context (Container with NCP Server Object of the OES server) of the OES server by the command "rcndsd status".
* Find out more details about the object using [this link](http://www.novell.com/documentation/oes2/acc_linux_svcs_lx/data/bx3sbv9.html)
	

7.2 Unix Workstation Object

* Use the Task "Modify Unix Workstation Object" available under the Role "Linux User Management" in iManager.
	
* Make sure that desired Groups are associated with the Unix Workstation Object using the tab "Groups".
* Make sure that all required services are LUM Enabled using the tab "LUM Enabled Services"
* Either modify the file /etc/sysconfig/novell/lum to LUM enable required services (Might need to modify PAM modules under /etc/pam.d folder) or reconfigure LUM and enable required Services (Recommended as the wizard will configure all required PAM files and also the file /etc/sysconfig/novell/lum)
* Find out more details about the object using [this link](http://www.novell.com/documentation/oes2/acc_linux_svcs_lx/data/bx3sbv9.html)

**8\. Verify that LUM has been configured to use the correct server as Preferred-LDAP-Server**

* An OES server can also use any other eDirectory server as Preferred-LDAP-Server for LUM. It is **NOT** necessary to use the problem OES Linux server itself as the Preferred-LDAP-Server. Perform all LDAP related troubleshooting steps on the Preferred-LDAP-Server to fix issues like NAMCD daemon does not load.
	
* NAMCD daemon authenticates to the Preferred-LDAP-Server using secure LDAP port 636, by default.
* Always use a server with Master or Read/Write Replicas of Tree \[Root\] and all partitions with user objects as Preferred-LDAP-Server for better performance.
* Find out the Preferred-LDAP-Server by the command: cat /etc/nam.conf | grep pref
* Make sure that setting "CONFIG\_LUM\_LDAP\_SERVER" in the file /etc/sysconfig/novell/lum also points to the same server.
* If needed (Optional) add the same server also in to the list of OES-LDAP Servers by running the YaST module OES-LDAP, by the command: yast oes-ldap (Step 2)
	

**9\. Verify that LDAP is working fine on the Preferred-LDAP-Server**

* NAMCD daemon fails to load if it can't establish a secure LDAP connection against the Preferred-LDAP-Server.
* The setting "type-of-authentication" in the file /etc/nam.conf determines whether NAMCD daemon uses secure (2) or no-secure (1) LDAP connection for authentication. Default value is 2, which is Secure LDAP.
* Use tools like LDAP Browser or Novell ICE to verify that LDAP is working fine on both ports on.
* It is not a good practice to use a web browser to test LDAP (http://<IP>:389 and https://<IP>:636)
	
* Make sure that ports 389 and 636 are open on all firewalls in case the OES server and the Preferred-LDAP-Server are on two sides of Firewalls
* If required, stop (Command: rcSuSEfirewall2 stop) and disable (Command: yast firewall) the default SuSEfirewall on SuSE Linux servers or open ports 389 and 636
* One of the most possible causes for failure of LDAP on the Preferred-LDAP-Server is expiration of default SSL Certificates after the default expiration period of two years. Find out the certificate used by LDAP Server Object (Field "Server Certificate" on the "SSL/TLS Configuration" Properties Page) and verify that the corresponding certificate is not expired and valid (Properties page "Certificates | Public Key Certificate" of the Certificate object). If expired, recreate the certificate either using the utility PKIDIAG for a NetWare Server (Execute the command "pkidiag" and select options 4,5,6 and 0 in the order after logged in) or by the command "ndsconfig upgrade" on Linux server with eDirectory. Verify that new certificate is valid. Certificates can be also created using the iManager Task "Create Default Certificates" available under the Role "Novell certificate Server".
	
* If SSL certificates are not getting created by above mentioned tools, there is a chance for either the Organizational Certificate Authority (CA) is corrupt or the CA Server is removed from the Tree. Take properties of the Certificate Authority Object under Security Container and verify. In case the any one of the above mentioned two issues exist, fix the CA first, recreate certificates and then proceed.
* If NAMCD daemon fails to authenticate using secure LDAP, as a work around for emergency situations, set LUM to use non-secure LDAP for authentication by setting the value "type-of-authentication" to "1". Trying to load NAMCD daemon will throw out message "Failed to get LDAP handle. Make sure you have LDAP server certificate in.." for sometime.
	

**10\. Import the new certificate for LUM into the OES server**

* Re-import the renewed certificate on the OES server by the command: namconfig -k
* Make sure that folder /var/lib/novell-lum has a new certificate file of the format <.IP\_Address\_of\_Preferred-LDAP-Server.der> with new time stamp (Command: ll /var/lib/novell-lum)
* Certificate should be imported if the existing certificate of the current Preferred-LDAP-Server is expired/corrupt or LUM needs to be pointed to use a different Preferred-LDAP-server
* LUM can be configured to use any other server as Preferred-LDAP-Server by, modifying files nam.conf and /etc/sysconfig/novell/lum and by executing the command "namconfig -k". Stop NAMCD Daemon, change the Preferred-LDAP-Server, execute "namconfig -k" and then start NAMCD Daemon.
* Command "namconfig set preferred-server=<IP\_Address> can be used to change Preferred-LDAP-Server. This command does not modify the LDAP server entry in the file /etc/sysconfig/novell/lum that a manual editing is required. Stop and execute command "namconfig -k" after that.
* There are chances that the user configured as LDAP Administrator and LUM Administrator might have been deleted. If required, change the LDAP Administrator (Use a user with sufficient rights) by modifying the entry "CONFIG\_LDAP\_ADMIN\_CONTEXT" in the file /etc/sysconfig/novell/oes-ldap and LUM Administrator by modifying the entry "admin-fdn" in the file /etc/nam.conf.
* Also check the Proxy User Configuration (Optional for LUM) by verifying entries "proxy-user-fdn" and "proxy-user-pwd" in the file /etc/nam.conf  and "CONFIG\_LUM\_PROXY\_USER" in the file /etc/sysconfig/novell/lum.
* On OES1 Linux server location of certificate for LUM is /var/nam
* Find out more details using [this link](http://www.novell.com/documentation/oes2/acc_linux_svcs_lx/data/fbdecbed.html)
	

**11\. Make sure that Name Service Switch (NSS) Database file /etc/nsswitch.conf is modified for LUM**

* Name Service Switch (NSS) database file is used by a Linux system for authentication request redirection.
* Default LUM installation and configuration adds the entry "nam" in the file for entries "passwd:" and "group:"
* Modify the file using a text editor and add "nam" if the entry is missing.
* Running YaST configuration module Nework Services | LDAP Client removes the entry "nam" from the file.Add the entry back to the file in that case.
	
* Find out more details using [this link](http://www.novell.com/documentation/oes2/acc_linux_svcs_lx/data/adwstmi.html)
	

**12\. Make sure that LDAP Client configuration is not conflicting with LUM configuration**

* Configuring an OES Linux server also as an LDAP client by pointing to a different LDAP server than the one defined for LUM can cause undesired results.
* Either edit the file using a text editor and correct the the LDAP server entry (Entry "host")or run the YaST configuration module Network Services | LDAP Client and select the option "Do not use LDAP"
* As mentioned under Step number 10, add entry "nam" back into the file /etc/nsswitch.conf, if required (Must check).
	

**13\. Check log files for error messages**

* Check the file /var/log/boot.msg if NAMCD Daemon fails to load along with system restart.Command "tail /var/log/boot.msg" will give the list of failed daemons during system restart.
	
* Check the file /var/lib/novell-lum/nam.log for events during start and stop of NAMCD Daemon.
* On an OES1 Linux server the file nam.log can be find under the folder /var/nam
	
* Check the file /va/log/messages for all real-time error messages related with LUM, if LUM is still not working even though NAMCD Daemon is loaded
* Real-Time entries into above mentioned files can be monitored by opening additional shell prompts and by executing commands: tail -f </Path/File> (For example: tail -f /var/log/messages)
	

**14\. Start NAMCD and all other related daemons on the OES server**

* Make sure that eDirectory is loaded: rcndsd status
* Make sure that OpenWEBEM daemon is loaded: rcowcimomd status (Required for Administration of OES components using iManager)
	
* Make sure that Name Service Cache Daemon is loaded: rcnscd status
* Make sure that NAMCD Daemon (LUM Daemon) is loaded: rcnamcd status
* Start all these daemons if they are not loaded, by replacing "status" with "start"
* Check whether above mentioned daemons are configured to load along with system restart by the command "chkconfig <Daemon\_Name> -l". For example: chkconfig namcd -l
* Configure above mentioned daemons to load along with system restart by the command "chkconfig <Daemon\_Name> on". For example: chkconfig namcd on

**15\. Check whether LUM is working or not**

* By default, LUM installation and configuration, LUM enable the user account used for the installation (For example, admin) using the group "admingroup". Installation process creates the group by itself.
	
* Modify the user object using the Task "Modify Object" available under the Role "Directory Administration" in iManager and make a note of User ID and Primary Group ID available on the tab "Linux Profile".
* Execute the command "rcndsd status" and make a note of the Organization Object (O=..)
* Get the list of LUM Enabled user for that OES server by the command "namuserlist -x o=<Organization\_Object>" (Without "") and make sure that "admin" is present in the result.
* If the required user is not showing up in the list, LUM Enable the user using the task "Enable Users for Linux" under the Role "Linux User Management". Verify that Linux Profile Tab does show UID, GID and other details. Execute the command "namuserlist" as mentioned above and check once again. To LUM enable a user should have "uniqueID" (Other Tab on the Properties Page) and the value should be same as that of the CN attribute (Case Sensitive). Set "uniqueID" properly, LUM enable and check again.
	
* Execute the command "id admin" and make sure that you get details on the Linux Profile Tab as the result. If LUM is not working the result will be "No such user".
	
* Execute following commands in the same order and check once again
	rcnamcd stop
	rcnscd stop
	rcnscd start
	rcnamcd start
	namconfig cache\_refresh
* Execute the command "id admin" once again and verify.
* LUM enable required users on each OES Linux servers if those users need to have access to different OES services like Samba and FTP.
* LUM enable users with iManager 2.7 along with latest Linux User Management plug-in, instead of iManager 2.6

**16\. Define Proxy User for LUM**

* Define the LUM Administrator also a Proxy User for LUM.
* Get the syntax for Proxy User Configuration by the command: namconfig get | grep proxy
* Set the proxy user (namconfig set proxy-user-fdn=<User,Context>) along with password (namconfig set proxy-user-pwd=<Password>
* Verify the configuration: cat /etc/nam.conf (The password will be saved in Clear text)
* As mentioned above, the password of the Proxy User will be saved in Clear text. If required set a different user with minimal rights as LUM Administrator and Proxy User.
* The file /etc/nam.conf can be marked with Read/Write permissions only for the Super User "root" by the command: chmod 600 /etc/nam.conf (Make sure that NAMCD daemon starts after that). Make a note of default ownership and permission by the command: ll /etc/nam.conf
	
* Set the Proxy User by modifying the entry "CONFIG\_LUM\_PROXY\_USER" in the file /etc/sysconfig/novell/lum" too
* Stop and restart "nscd" and "namcd" daemons and check again.
* Check log files mentioned under Step 12 and also enable LDAP Trace (Check section "Additional Information") on the OES Server and Preferred-LDAP-Server

**17\. Restart the server and verify**

* Restart the server and make sure that all daemons related to NAMCD are loaded along with system restart and LUM is also working fine.
* Execute the command "tail /var/log/boot.msg" to get the list of failed services/daemons during system restart

### Additional Information

**1\. Enable LDAP Trace**

* If LUM is still not working enable LDAP Trace on the Preferred-LDAP-Server to find out error messages while starting NAMCD Daemon and executing the command "id <User\_Name>
	

* Prior to enable LDAP trace, enable all check boxes except "Packet Dump for Decoding" on the LDAP Server object Properties Page "Screen Options" and and then reload LDAP using the button "Refresh NLDAP Server Now" available on the LDAP Server Object Properties Page "General". Either use ConsoleOne or iManager to enable "Screen Options".
* In certain cases LDAP needs to unloaded and reloaded. Execute "unload nldap" followed by "nldap" on a NetWare server. On Linux server execute "nldap -u" followed by "nldap -l".
* Use tools like LDAP Browser or Novell ICE to verify that LDAP is working fine on both ports
	
* Enable LDAP Trace after that as follows.
A. On NetWare
load dstrace
dstrace screen on
dstrace file on
dstrace -all
dstrace +ldap
After tests turn off DSTRACE as follows.
dstrace file off
dstrace -ldap
unload dstrace
Collect the log file dstrace.log from the sys:\\system folder.
B. On Linux
ndstrace
ndstrace screen on
ndstrace file on
set ndstrace=nodebug
ndstrace +ldap
After tests turn off NDSTrace as follows.
ndstrace -ldap
ndstrace file off
exit
Collect the file ndstrace.log from the eDirectory Daatabase folder (DIB). DIB directory can be located using the command "ndsconfig get | grep dib".
**2\. Related documents**

* [Linux User Management Technology Guide](http://www.novell.com/documentation/oes2/acc_linux_svcs_lx/data/bookinfo.html)
* [Troubleshooting Linux User Management](http://www.novell.com/support/php/search.do?cmd=displayKC&docType=kc&externalId=3280667&sliceId=1&docTypeID=DT_TID_1_1&dialogID=58565852&stateId=0%200%2058567528)
* [Troubleshooting Linux User Management-A few important files and folders](http://www.novell.com/support/php/search.do?cmd=displayKC&docType=kc&externalId=7002979&sliceId=1&docTypeID=DT_TID_1_1&dialogID=58565852&stateId=0%200%2058567528)

### Disclaimer

This Support Knowledgebase provides a valuable tool for NetIQ/Novell/SUSE customers and parties interested in our products and solutions to acquire information, ideas and learn from one another. Materials are provided for informational, personal or non-commercial use within your organization and are presented "AS IS" WITHOUT WARRANTY OF ANY KIND.

* **Document ID:**_7002981_

* **Creation Date:**12-APR-09
* **Modified Date:**27-APR-12
	* **Novell**Open Enterprise Server

Did this document solve your problem? [[#|Provide Feedback]]

© 2014 Novell

* [Careers](http://www.novell.com/company/careers/index.html)

* [Legal](http://www.novell.com/company/legal/)

[close](http://www.novell.com/support/kb/doc.php?id=7002981#)

* [Feedback](http://www.novell.com/inc/feedback/feedback.html)

* [Print](http://www.novell.com/support/kb/doc.php?id=7002981#)
* [1-888-321-4272](http://www.novell.com/company/contact.html)
* [Request a Call](http://www.novell.com/common/inc/requestcall_overlay.html)
* [Follow Novell](http://www.novell.com/support/kb/doc.php?id=7002981#)
[Novell](http://www.novell.com/)
