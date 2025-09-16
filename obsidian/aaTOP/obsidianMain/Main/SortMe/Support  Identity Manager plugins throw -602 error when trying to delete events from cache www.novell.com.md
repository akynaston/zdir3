# Support | Identity Manager plugins throw -602 error when trying to delete events from cache [www.novell.com]

[![[./_resources/Support__Identity_Manager_plugins_throw_-602_error_when_trying_to_delete_events_from_cache_www.novell.com.resources/unknown_filename.png]]](http://www.novell.com/)

* [Skip to Content](http://www.novell.com/support/kb/doc.php?id=7008366#top)

* [Products](http://www.novell.com/products/)
* [Services & Support](http://www.novell.com/services/)
* [Partners](https://www.partnernetprogram.com/)
* [Communities](http://www.novell.com/communities/)
* [About Novell](http://www.novell.com/company/)
* [How to Buy](http://www.novell.com/products/howtobuy.html)

![[./_resources/Support__Identity_Manager_plugins_throw_-602_error_when_trying_to_delete_events_from_cache_www.novell.com.resources/unknown_filename.1.png]]

[**Change**](http://www.novell.com/common/util/langselect.php?referer=http%3A//www.novell.com/support/kb/doc.php%3Fid%3D7008366) **_United States,_ English**

[**Login**](http://www.novell.com/common/util/secure/login.php?r=http://www.novell.com/support/kb/doc.php?id=7008366)

[Close](http://www.novell.com/support/kb/doc.php?id=7008366#)

# [Knowledgebase](http://www.novell.com/support/kb/)

* [FAQ](http://support.novell.com/additional/faq.html)

* [Register Your Product](https://secure-www.novell.com/center/regadmin/jsps/activate_app.jsp)
* [My Favorites](http://www.novell.com/support/kb/doc.php?id=7008366#)

* [Email Document](http://www.novell.com/support/kb/doc.php?id=7008366#)

* [Printer Friendly](http://www.novell.com/support/kb/doc.php?id=7008366)
* [Favorite](http://www.novell.com/support/kb/doc.php?id=7008366&add&title=Identity+Manager+plugins+throw+-602+error+when+trying+to+delete+events+from+cache)
* Rating:
	

# Identity Manager plugins throw -602 error when trying to delete events from cache

This document **(7008366)** _is provided subject to the [disclaimer](http://www.novell.com/support/kb/doc.php?id=7008366#disclaimer) at the end of this document._

### Environment

Novell Identity Manager iManager Plug-ins
Novell iManager 2.7.4

### Situation

After stopping a driver config in iManager and going to the Inspector tool to view and modify the configuration's cache the events show up properly as they exist in the TAO file.  When trying to delete an event, though, a -602 error is returned to the screen and the event is not deleted.

### Resolution

This error can be worked around using the command-line dxcmd utility.  In this case it may be useful to use iManager to find the eventID to be deleted and then use dxcmd to do the actual event deletion.
This has been resolved in IDM 401 Patch 2

### Disclaimer

This Support Knowledgebase provides a valuable tool for NetIQ/Novell/SUSE customers and parties interested in our products and solutions to acquire information, ideas and learn from one another. Materials are provided for informational, personal or non-commercial use within your organization and are presented "AS IS" WITHOUT WARRANTY OF ANY KIND.

* **Document ID:**_7008366_

* **Creation Date:**13-APR-11
* **Modified Date:**11-JUN-13

* **NetIQ**Identity Manager
	
	iManager

Did this document solve your problem? [[#|Provide Feedback]]

© 2013 Novell

* [Careers](http://www.novell.com/company/careers/index.html)

* [Legal](http://www.novell.com/company/legal/)

[close](http://www.novell.com/support/kb/doc.php?id=7008366#)

* [Feedback](http://www.novell.com/inc/feedback/feedback.html)

* [Print](http://www.novell.com/support/kb/doc.php?id=7008366#)
* [1-888-321-4272](http://www.novell.com/company/contact.html)
* [Request a Call](http://www.novell.com/common/inc/requestcall_overlay.html)
* [Follow Novell](http://www.novell.com/support/kb/doc.php?id=7008366#)
[Novell](http://www.novell.com/)

![&tzo=420&ms=741](http://now.eloqua.com/visitor/v200/svrGP.aspx?pps=3&siteid=1163&ref2=https%3A//www.google.com/&tzo=420&ms=741)
