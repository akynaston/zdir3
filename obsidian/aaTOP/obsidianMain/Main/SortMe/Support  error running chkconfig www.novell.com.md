# Support | error running chkconfig [www.novell.com]

[![[./_resources/Support__error_running_chkconfig_www.novell.com.resources/unknown_filename.png]]](http://www.novell.com/)

* [Skip to Content](https://www.novell.com/support/kb/doc.php?id=7010013#top)

* [Products](http://www.novell.com/products/)
* [Services & Support](http://www.novell.com/services/)
* [Partners](https://www.partnernetprogram.com/)
* [Communities](http://www.novell.com/communities/)
* [About Novell](http://www.novell.com/company/)
* [How to Buy](http://www.novell.com/products/howtobuy.html)

![[./_resources/Support__error_running_chkconfig_www.novell.com.resources/hdr_2009_srch_btn.png]]

[**Change**](https://www.novell.com/common/util/langselect.php?referer=https%3A//www.novell.com/support/kb/doc.php%3Fid%3D7010013) **_United States,_ English**

[**Login**](http://www.novell.com/common/util/secure/login.php?r=https://www.novell.com/support/kb/doc.php?id=7010013)

[Close](https://www.novell.com/support/kb/doc.php?id=7010013#)

# [Knowledgebase](https://www.novell.com/support/kb/)

* [FAQ](http://support.novell.com/additional/faq.html)

* [Register Your Product](https://secure-www.novell.com/center/regadmin/jsps/activate_app.jsp)
* [My Favorites](https://www.novell.com/support/kb/doc.php?id=7010013#)

* [Email Document](https://www.novell.com/support/kb/doc.php?id=7010013#)

* [Printer Friendly](https://www.novell.com/support/kb/doc.php?id=7010013)
* [Favorite](https://www.novell.com/support/kb/doc.php?id=7010013&add&title=error+running+chkconfig)
* Rating:
	

# error running chkconfig

This document **(7010013)** _is provided subject to the [disclaimer](https://www.novell.com/support/kb/doc.php?id=7010013#disclaimer) at the end of this document._

### Environment

SUSE Linux
Novell ZENworks 11 Configuration Management Support Pack 1 - ZCM 11 SP1
Novell ZENworks Configuration Management 11.2

### Situation

ERROR on SLES while running chkconfig after sun java install:

insserv: Script jexec is broken: incomplete LSB comment.
insserv: missing \`Required-Stop:'  entry: please add even if empty.
insserv: Script jexec is broken: incomplete LSB comment.
insserv: missing \`Required-Stop:'  entry: please add even if empty.
insserv: Script jexec is broken: incomplete LSB comment.
insserv: missing \`Required-Stop:'  entry: please add even if empty.
insserv: Script jexec is broken: incomplete LSB comment.
insserv: missing \`Required-Stop:'  entry: please add even if empty.
insserv: Script jexec is broken: incomplete LSB comment.
insserv: missing \`Required-Stop:'  entry: please add even if empty.
insserv: Script jexec is broken: incomplete LSB comment.
insserv: missing \`Required-Stop:'  entry: please add even if empty.
insserv: Script jexec is broken: incomplete LSB comment.
insserv: missing \`Required-Stop:'  entry: please add even if empty.
insserv: Script jexec is broken: incomplete LSB comment.
insserv: missing \`Required-Stop:'  entry: please add even if empty.
insserv: Script jexec is broken: incomplete LSB comment.
insserv: missing \`Required-Stop:'  entry: please add even if empty.
insserv: Script jexec is broken: incomplete LSB comment.
insserv: missing \`Required-Stop:'  entry: please add even if empty.
insserv: warning: script 'myserv' missing LSB tags and overrides
insserv: Default-Start undefined, assuming default start runlevel(s) for script
\`myserv' dhcp on

### Resolution

The error is in the sun jexec.  Workaround:

1. Make a backup of /etc/init.d/jexec

* Add the following line:
	\# Required-Stop:
	after this existing line:  \# Required-Start: $local\_fs

### Disclaimer

This Support Knowledgebase provides a valuable tool for NetIQ/Novell/SUSE customers and parties interested in our products and solutions to acquire information, ideas and learn from one another. Materials are provided for informational, personal or non-commercial use within your organization and are presented "AS IS" WITHOUT WARRANTY OF ANY KIND.

* **Document ID:**_7010013_

* **Creation Date:**16-JAN-12
* **Modified Date:**12-MAY-12
	* **Novell**ZENworks Configuration Management

Did this document solve your problem? [Provide Feedback](https://www.novell.com/support/kb/doc.php?id=7010013javascript:openExternal('https://novell.qualtrics.com/SE/?SID=SV_a2USKSZ3DbcQbwp&BU=1&doc=7010013'))

© 2014 Novell

* [Careers](http://www.novell.com/company/careers/index.html)

* [Legal](http://www.novell.com/company/legal/)

[close](https://www.novell.com/support/kb/doc.php?id=7010013#)

* [Feedback](http://www.novell.com/inc/feedback/feedback.html)

* [Print](https://www.novell.com/support/kb/doc.php?id=7010013#)
* [1-888-321-4272](http://www.novell.com/company/contact.html)
* [Request a Call](https://www.novell.com/common/inc/requestcall_overlay.html)
* [Follow Novell](https://www.novell.com/support/kb/doc.php?id=7010013#)
[Novell](https://www.novell.com/)
