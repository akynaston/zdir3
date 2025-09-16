# Support | Installing Oracle Java on SLED/SLES 11 SP2 [www.novell.com]

I had to do this to upgrade java on the MWV server, to see if apache dir studio would work.

[![[./_resources/Support__Installing_Oracle_Java_on_SLEDSLES_11_SP2_www.novell.com.resources/unknown_filename.png]]](http://www.novell.com/)

* [Skip to Content](https://www.novell.com/support/kb/doc.php?id=7010472#top)

* [Products](http://www.novell.com/products/)
* [Services & Support](http://www.novell.com/services/)
* [Partners](https://www.partnernetprogram.com/)
* [Communities](http://www.novell.com/communities/)
* [About Novell](http://www.novell.com/company/)
* [How to Buy](http://www.novell.com/products/howtobuy.html)

[**Change**](https://www.novell.com/common/util/langselect.php?referer=https%3A//www.novell.com/support/kb/doc.php%3Fid%3D7010472) **_United States,_ English**

[**Login**](https://www.novell.com/common/util/secure/login.php?r=https://www.novell.com/support/kb/doc.php?id=7010472)

[Close](https://www.novell.com/support/kb/doc.php?id=7010472#)

# [Knowledgebase](https://www.novell.com/support/kb/)

* [FAQ](http://support.novell.com/additional/faq.html)

* [Register Your Product](https://secure-www.novell.com/center/regadmin/jsps/activate_app.jsp)
* [My Favorites](https://www.novell.com/support/kb/doc.php?id=7010472#)

* [Email Document](https://www.novell.com/support/kb/doc.php?id=7010472#)

* [Printer Friendly](https://www.novell.com/support/kb/doc.php?id=7010472)
* [Favorite](https://www.novell.com/support/kb/doc.php?id=7010472&amp;add&amp;title=Installing+Oracle+Java+on+SLED%2FSLES+11+SP2)
* Rating:

# Installing Oracle Java on SLED/SLES 11 SP2

This document **(7010472)** _is provided subject to the [disclaimer](https://www.novell.com/support/kb/doc.php?id=7010472#disclaimer) at the end of this document._

### Environment

SUSE Linux Enterprise Desktop 11 SP2
SUSE Linux Enterprise Server 11 SP2
Oracle Java
Mozilla Firefox browser

### Situation

As a result of a license change SUSE is no longer able to provide Oracle/Sun Java in the distribution or through the update channels.  As a result Java will need to be downloaded from the java.com site and manually installed.
This also means that we cannot provide support for Oracle Java.  Any support issues should be directed to Oracle.  The following information is provided as a potential solution but is not guaranteed.

### Resolution

1.  Use YaST -> Software -> Software Management and remove all previous versions of Java (e.g. java-1\_6\_0-sun, icedtea-web).  Do not remove the openjdk version of Java if you have it installed.  This is required for Java functionality in LibreOffice.
2.  Download Oracle Java
Check if you have i586 or x86\_64 version of Mozilla Firefox (this can be different from the architecture of the system). The easiest way is to open a console and type
   rpm -q --queryformat '%{arch}\\n' MozillaFirefox
If x86\_64 appears, use the version marked as "Linux x64 RPM".
Visit http://java.com/ and click on Free Java Download.  Download the "Linux RPM" (32 bit) or "Liinux x64 RPM" (64 bit) as appropriate.
3.  As the root user install the downloaded rpm from a terminal by using the command:
   rpm -Uvh <file-name>
Of course replace <file-name> with the path and name of the rpm file downloaded from java.com.
4.  Enable the plugin for Firefox.
Logged in as the user that will be running firefox open a terminal window and do the following:
   mkdir -v ~/.mozilla/plugins
(if it already exists that's okay)
   rm ~/.mozilla/plugins/libnpjp2.so
   ln -s /usr/java/jre1.7.0\_05/lib/amd64/libnpjp2.so ~/.mozilla/plugins/
(The "jre1.7.0\_05" will need to match the version just installed)
5.  Close all instances of the Firefox browser then open it up again.
Browse to http://java.com/en/download/installed.jsp to verify that java is installed properly.

### Disclaimer

This Support Knowledgebase provides a valuable tool for NetIQ/Novell/SUSE customers and parties interested in our products and solutions to acquire information, ideas and learn from one another. Materials are provided for informational, personal or non-commercial use within your organization and are presented "AS IS" WITHOUT WARRANTY OF ANY KIND.

* **Document ID:**_7010472_

* **Creation Date:**17-JUL-12
* **Modified Date:**18-JUL-12

* **SUSE**SUSE Linux Enterprise Desktop SUSE Linux Enterprise Server

Did this document solve your problem? 

© 2014 Novell

* [Careers](http://www.novell.com/company/careers/)

* [Legal](http://www.novell.com/company/legal/)

[close](https://www.novell.com/support/kb/doc.php?id=7010472#)

* [Feedback](http://www.novell.com/inc/feedback/feedback.html)

* [Print](https://www.novell.com/support/kb/doc.php?id=7010472#)
* [1-888-321-4272](http://www.novell.com/company/contact.html)
* [Request a Call](https://www.novell.com/common/inc/requestcall_overlay.html)
* [Follow Novell](https://www.novell.com/support/kb/doc.php?id=7010472#)
[Novell](https://www.novell.com/)
