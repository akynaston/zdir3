# Cool Solutions: DSRepair - Cross-Platform Functions [www.novell.com]

[![[./_resources/Cool_Solutions_DSRepair_-_Cross-Platform_Functions_www.novell.com.resources/unknown_filename.1.png]]](http://www.novell.com/)

* [Skip to Content](http://www.novell.com/coolsolutions/feature/#top)

		### [Solutions](http://www.novell.com/solutions/)
	
		### [Products](http://www.novell.com/products/)
	
		### [Services & Support](http://www.novell.com/services/)
	
		### [Partners](http://www.novell.com/partners/)
	
		### [Communities](http://www.novell.com/communities/)
	
		### [About Novell](http://www.novell.com/company/)
	
		### [How to Buy](http://www.novell.com/products/howtobuy.html)
	

[**Change**](http://www.novell.com/common/util/langselect.php?referer=http%3A//www.novell.com/coolsolutions/feature/17227.html) **_United States,_ English**

[**Logout**](https://secure-www.novell.com/cmd/ICSLogout)**_Welcome_ Aaron Kynaston**

[Close](http://www.novell.com/coolsolutions/feature/#)

								

# DSRepair - Cross-Platform Functions

## Novell Cool Solutions: Feature
By [Akos Szechy](http://www.novell.com/coolsolutions/author/3278.html)

[Rate This Page](http://www.novell.com/inc/rater.jsp?url=http://www.novell.com/coolsolutions/feature/17227.html)

Reader Rating  ![[./_resources/Cool_Solutions_DSRepair_-_Cross-Platform_Functions_www.novell.com.resources/unknown_filename.2.gif]]  from 13 ratings

* [Printer Friendly](http://www.novell.com/inc/pf/pf.jsp)

* [tell a friend](http://www.novell.com/info/sendemail.jsp?url=http://www.novell.com/coolsolutions/feature/17227.html)

|     |     |
| --- | --- |
| - [Slashdot This](http://slashdot.org/submit.pl)<br>_Posted: 10 May 2006_ |     |

DSREPAIR Cross Platform functions

On NetWare it's easy to use the different features of DSRepair. However, in Linux/Unix you use the command line to run these commands, while on Windows platform you have to use the GUI to run these tasks. This article gives you a quick guide on how to achieve the same DSRepair functionality on the different platforms.

**Note**: This article covers the most common features of DSREPAIR only.

**Time Synchronization Check**

Purpose: Check the time synchronization between the servers in the eDirectory tree.
NetWare: LOAD DSREPAIR | Check Time synchronization
Windows: Open DSREPAIR.DLM from the NDS Console | Repair | Time synchronization
Linux/Unix: ndsrepair -T

**Report Synchronization Status**

Purpose: Check the replica synchronization between the servers.
NetWare: LOAD DSREPAIR | Report synchronization status
Windows: Open DSREPAIR.DLM from the NDS Console | Repair | Report synchronization status
Linux/Unix: ndsrepair -E

**Check External References** (check for obituaries)

Purpose: Check for stuck obituaries on the server.
NetWare: LOAD DSREPAIR -A | Advanced options | Check External References
Windows: Open DSREPAIR.DLM from the NDS Console with a '-A' parameter specified in the 'Startup parameters' field | Repair | Check External References
Linux/Unix: ndsrepair -C -Ad -A

**Designate a server as a new master**

Purpose: The replica ring lost its Master replica; therefore, another server needs to be promoted to Master.
NetWare: LOAD DSREPAIR -A | Advanced options | Replica and partition operations |
Select the partition | Designate this server as the new master
Windows: Open DSREPAIR.DLM from the NDS Console with a '-A' parameter specified in the 'Startup parameters' field | Select 'Partitions' on the right frame | Right-click to select the partition, then choose the 'Designate this server as the new master replica' option
Linux/Unix: ndsrepair -P -Ad -A | Select the partition | Select option 5 ? Designate this server as the new master replica

**Repair time stamps and declare a new epoch.**

Purpose: The partition has future timestamps and needs to revert to the current time. This operation will put all the replicas except the Master to "new state" and synchronize the replica again.
NetWare: LOAD DSREPAIR -A | Advanced options | Replica and partition operations | Select the partition | Repair Timestamps and declare a new epoch
Windows: Open DSREPAIR.DLM from the NDS Console with a '-A' parameter specified in the 'Startup parameters' field | Select 'Partitions' on the right frame | Right-click to select the partition, then choose the 'Repair Timestamps and declare a new epoch' option.
Linux/Unix: ndsrepair -P -Ad -A | Select the partition | Select option 12 - Repair Timestamps and declare a new epoch

**DSREPAIR -XK2**

Purpose: Remove every replica from the server.
NetWare: LOAD DSREPAIR -XK2 -RD
Windows: Open DSREPAIR.DLM from the NDS Console with a '-XK2' parameter specified in the 'Startup parameters' field | Repair | Local Database Repair with the default options
Linux/Unix: ndsrepair -R -Ad -Xk2

**DSREPAIR -XK3**

Purpose: Remove all external references from the server
NetWare: LOAD DSREPAIR -XK3 -RD
Windows: Open DSREPAIR.DLM from the NDS Console with a '-XK3' parameter specified in the 'Startup parameters' field | Repair | Local Database Repair with the default options
Linux/Unix: ndsrepair -R -Ad -Xk3

**Timestamping obituaries**

Purpose: Timestamp stuck obituaries, so they can be re-processed
NetWare: LOAD DSREPAIR -OT -RD
Windows: Open DSREPAIR.DLM from the NDS Console with a '-OT' parameter specified in the 'Startup parameters' field | Repair | Local Database Repair with the default options
Linux/Unix: ndsrepair -R -Ad -OT

**Advanced Schema Operations**

Purpose: There are some schema operations, such as Import remote schema and Declare a new epoch, that can be only reached in advanced mode.
NetWare: LOAD DSREPAIR -A | Advanced options | Schema
Windows: Open DSREPAIR.DLM from the NDS Console with a '-A' parameter specified in the 'Startup parameters' field | Schema menu
Linux/Unix: ndsrepair -S -Ad

#### Reader Comments

* What a wonderful resource
* Great Akos.

[**Like what you see?**
Sign up for our weekly newsletter. ![[./_resources/Cool_Solutions_DSRepair_-_Cross-Platform_Functions_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/coolsolutions/forms/subscribe.html) 

[**Want to contribute?**
It could earn you a nano! Learn more. ![[./_resources/Cool_Solutions_DSRepair_-_Cross-Platform_Functions_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/coolsolutions/forms/submit_a_tip.html) 

[**Like Wikis?**
Join the Cool Solutions Wiki. ![[./_resources/Cool_Solutions_DSRepair_-_Cross-Platform_Functions_www.novell.com.resources/unknown_filename.gif]]](http://wiki.novell.com/index.php/Cool_Solutions_Wiki_Main_Page) 

|     |     |     |
| --- | --- | --- |
| ![[./_resources/Cool_Solutions_DSRepair_-_Cross-Platform_Functions_www.novell.com.resources/unknown_filename.3.gif]] |     | [**Interested?**<br>Request a sales call ![[./_resources/Cool_Solutions_DSRepair_-_Cross-Platform_Functions_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/company/sales_call_request.jsp?refid=coolsolutions&amp;unitcode=1-418V23) |

![[./_resources/Cool_Solutions_DSRepair_-_Cross-Platform_Functions_www.novell.com.resources/unknown_filename.4.gif]]

_Novell Cool Solutions (corporate web communities) are produced by WebWise Solutions. _

[Cool Solutions Home (New)](http://www.novell.com/communities/coolsolutions)

[Classic Cool Solutions Home](http://www.novell.com/coolsolutions/index.html)

[Authors](http://www.novell.com/coolsolutions/author/)

[Cool Blogs](http://www.novell.com/communities/coolblogs)

[Cool Solutions Wiki](http://wiki.novell.com/)

[Cool Tools](http://www.novell.com/communities/coolsolutions/tools)

Get Involved  _\>_

[Open Audio (podcasts)](http://www.novell.com/company/podcasts/openaudio.html)

© 2011 Novell

* [Careers](http://www.novell.com/company/careers/index.html)

* [Legal](http://www.novell.com/company/legal/)

[close](http://www.novell.com/coolsolutions/feature/#)

* [Feedback](http://www.novell.com/inc/feedback/feedback.html)

* [Print](http://www.novell.com/coolsolutions/feature/#)
* [800-529-3400](http://www.novell.com/company/contact.html)
* [Request a Call](http://www.novell.com/common/inc/requestcall_overlay.html)
* [Follow Novell](http://www.novell.com/coolsolutions/feature/#)
[Novell](http://www.novell.com/) Making IT Work As One™
