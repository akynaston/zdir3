# Support | IP Address Changes of eDirectory Server on Linux [www.novell.com]

ip address change edir linux

[![[./_resources/Support__IP_Address_Changes_of_eDirectory_Server_on_Linux_www.novell.com.resources/unknown_filename.png]]](http://www.novell.com/)

* [Skip to Content](https://www.novell.com/support/kb/doc.php?id=3201067#top)

* [Products](http://www.novell.com/products/)
* [Services & Support](http://www.novell.com/services/)
* [Partners](https://www.partnernetprogram.com/)
* [Communities](http://www.novell.com/communities/)
* [About Novell](http://www.novell.com/company/)
* [How to Buy](http://www.novell.com/products/howtobuy.html)

![[./_resources/Support__IP_Address_Changes_of_eDirectory_Server_on_Linux_www.novell.com.resources/hdr_2009_srch_btn.png]]

[**Change**](https://www.novell.com/common/util/langselect.php?referer=https%3A//www.novell.com/support/kb/doc.php%3Fid%3D3201067) **_United States,_ English**

[**Login**](http://www.novell.com/common/util/secure/login.php?r=https://www.novell.com/support/kb/doc.php?id=3201067)

[Close](https://www.novell.com/support/kb/doc.php?id=3201067#)

# [Knowledgebase](https://www.novell.com/support/kb/)

* [FAQ](http://support.novell.com/additional/faq.html)

* [Register Your Product](https://secure-www.novell.com/center/regadmin/jsps/activate_app.jsp)
* [My Favorites](https://www.novell.com/support/kb/doc.php?id=3201067#)

* [Email Document](https://www.novell.com/support/kb/doc.php?id=3201067#)

* [Printer Friendly](https://www.novell.com/support/kb/doc.php?id=3201067)
* [Favorite](https://www.novell.com/support/kb/doc.php?id=3201067&amp;add&amp;title=IP+Address+Changes+of+eDirectory+Server+on+Linux)
* Rating:

# IP Address Changes of eDirectory Server on Linux

This document **(3201067)** _is provided subject to the [disclaimer](https://www.novell.com/support/kb/doc.php?id=3201067#disclaimer) at the end of this document._

### Environment

Novell Open Enterprise Server 1 (OES 1) Linux
Novell Open Enterprise Server 2 (OES 2) Linux
Novell eDirectory 8.8 for Linux
Novell eDirectory 8.7.3.x for Linux
Novell SUSE Linux Enterprise Server 10
Novell SUSE Linux Enterprise Server 9
Novell SUSE Linux Enterprise Server 8 Support Pack 3

### Situation

When an IP address is changed on a Linux server running eDirectory some services may be affected. The environment handles most of the IP address changes automatically but a few locations may need to be modified to allow other services to work properly.

### Resolution

/etc/hosts.nds - This file may or may not exist and when it exists it usually holds at least the tree name followed by a period/dot, then a space, then the IP address of a server holding a real copy of the root of the tree. If the IP address of the server specified in this file is changed the hosts.nds files may need to be updated which can be done with any standard text editor.
eDirectory configuration - Various parameters in eDirectory can be viewed with the following command (without backticks):
\`ndsconfig get\`
This command will show all of the runtime variables some of which may still contain the old IP address. To find those values use the following command:
\`ndsconfig get | grep oldIpAddressGoesHere\`
With the output we now need to set the variables to the new IP address (a restart of eDirectory may also take care of this):
\`ndsconfig set parameterName=newValueIncludingIPAddressAndOrPort\`
If any parameters cannot be set via the command mentioned above it is a good idea to modify them directly in the eDirectory instance's nds.conf file. For eDirectory 8.7.3.x this is /etc/nds.conf and for eDirectory 8.8 there is one for each eDirectory instance. The location of these files is visible for each instance when \`ndsmanage\` is loaded. Keep in mind that ndsmanage shows only the current user's instance's by default (which is almost always 'root') but there could be instances owned and managed by other users needing modification as well. To see these use \`ndsmanage -a\`.
After an IP address change a server's IP-based Key Material Objects (KMOs) will not be automatically updated. These can be recreated manually but a simple process is available. While deleting the old KMOs (with IP in their name) is not necessary it is a good idea for tree cleanliness. Regardless of whether or not they are deleted use the following command (which will restart your eDirectory instance) to recreate your KMOs and link them back with the NCP and LDAP Server objects:
\`ndsconfig upgrade\`
The last step is to be sure the Limber process has notified all other servers of the IP address change. This should have happened automatically (and will happen again periodically) but can be forced by entering \`ndstrace\` and running the 'set dstrace=\*L' command.
After this is done your eDirectory installation should be working properly assuming it was not before. To verify synchronization make a change to something in the tree and be sure the other replicas see the change in a timely manner (iMonitor is the best tool to do this). You can also view your Replica Synchronization times from iMonitor or \`ndsrepair -E\` to verify synchronization is still working properly.
Note that other services on a server may also have an IP address hard-coded and may need to be updated.
\- Linux User Management (LUM) on OES has a conf file (nam.conf) that may have an IP address in it.  Then you need to import the certificate from the LDAP server if the ip address changes with  "namconfig -k".   Restart LUM with "rcnamcd restart"
\- iManager (depending on the version and the installation type) may use certificates that need to be recreated or added to a keystore .
\- Apache and Tomcat (for iManager) are where these changes may be required. Changing certificates that have been exported to clients for their use can cause those other connections to fail. See your environment's changelog to find out if and when certificates have been exported for third-party use.

[![[./_resources/Support__IP_Address_Changes_of_eDirectory_Server_on_Linux_www.novell.com.resources/tids_ondemand.gif]]](http://www.youtube.com/watch?v=lKVelISwyIk)

[+ Advanced eDirectory Troubleshooting](http://www.youtube.com/watch?v=lKVelISwyIk)

### Disclaimer

This Support Knowledgebase provides a valuable tool for NetIQ/Novell/SUSE customers and parties interested in our products and solutions to acquire information, ideas and learn from one another. Materials are provided for informational, personal or non-commercial use within your organization and are presented "AS IS" WITHOUT WARRANTY OF ANY KIND.

* **Document ID:**_3201067_

* **Creation Date:**13-FEB-07
* **Modified Date:**27-APR-12

* **SUSE**SUSE Linux Enterprise Server

Did this document solve your problem? [Provide Feedback](https://www.novell.com/support/kb/doc.php?id=3201067javascript:openExternal('https://novell.qualtrics.com/SE/?SID=SV_a2USKSZ3DbcQbwp&amp;BU=1&amp;doc=3201067'))

© 2014 Novell

* [Careers](http://www.novell.com/company/careers/)

* [Legal](http://www.novell.com/company/legal/)

[close](https://www.novell.com/support/kb/doc.php?id=3201067#)

* [Feedback](http://www.novell.com/inc/feedback/feedback.html)

* [Print](https://www.novell.com/support/kb/doc.php?id=3201067#)
* [1-888-321-4272](http://www.novell.com/company/contact.html)
* [Request a Call](https://www.novell.com/common/inc/requestcall_overlay.html)
* [Follow Novell](https://www.novell.com/support/kb/doc.php?id=3201067#)
[Novell](https://www.novell.com/)
