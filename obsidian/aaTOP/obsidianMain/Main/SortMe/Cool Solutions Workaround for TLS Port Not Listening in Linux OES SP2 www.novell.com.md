# Cool Solutions: Workaround for TLS Port Not Listening in Linux OES SP2 [www.novell.com]

[![[./_resources/Cool_Solutions_Workaround_for_TLS_Port_Not_Listening_in_Linux_OES_SP2_www.novell.com.resources/unknown_filename.1.png]]](http://www.novell.com/)

* [Skip to Content](http://www.novell.com/coolsolutions/tip/#top)

		### [Solutions](http://www.novell.com/solutions/)
	
		### [Products](http://www.novell.com/products/)
	
		### [Services & Support](http://www.novell.com/services/)
	
		### [Partners](http://www.novell.com/partners/)
	
		### [Communities](http://www.novell.com/communities/)
	
		### [About Novell](http://www.novell.com/company/)
	
		### [How to Buy](http://www.novell.com/products/howtobuy.html)
	

[**Change**](http://www.novell.com/common/util/langselect.php?referer=http%3A//www.novell.com/coolsolutions/tip/18119.html) **_United States,_ English**

[**Logout**](https://secure-www.novell.com/cmd/ICSLogout)**_Welcome_ Aaron Kynaston**

[Close](http://www.novell.com/coolsolutions/tip/#)

								

# Workaround for TLS Port Not Listening in Linux OES SP2

## Novell Cool Solutions: Tip
By [Hema Joshi](http://www.novell.com/coolsolutions/author/3841.html)

[Rate This Page](http://www.novell.com/inc/rater.jsp?url=http://www.novell.com/coolsolutions/tip/18119.html)

Reader Rating  ![[./_resources/Cool_Solutions_Workaround_for_TLS_Port_Not_Listening_in_Linux_OES_SP2_www.novell.com.resources/unknown_filename.2.gif]]  from 2 ratings

* [Printer Friendly](http://www.novell.com/inc/pf/pf.jsp)

* [tell a friend](http://www.novell.com/info/sendemail.jsp?url=http://www.novell.com/coolsolutions/tip/18119.html)

|     |     |
| --- | --- |
| - [Slashdot This](http://slashdot.org/submit.pl)<br>_Posted: 16 Nov 2006_ |     |

Troubleshooting SSL port not listening issue when eDirectory is configured through ndsconfig after completing the installation of Linux OES-SP2

**Intended Audience:**

Test engineers of eDirectory and help desk engineers who will be installing only the OS in all the systems as part of lab setup and configuring eDirectory at the later stages.

### Problem:

Install Linux OES-SP2 completely by choosing the configure later option and then configure eDirectory. The message "TLS port is not listening" is displayed, hence could not perform TLS/SSL operations.
The following is the description of the issue:

1. Start Installing Linux OES-SP2
2. Select **_Configure Later_** option and complete the installation.
3. Configure eDirectory with **_ndsconfig_**
	st-fc-lnx-26:~ # ndsconfig new -t test-tree -n o=novell -a cn=admin.o=novell
		Enter the password for cn=admin.o=novell:
		Re-enter the password for cn=admin.o=novell:
		HTTP Port 8008 already in use...
		Please enter another HTTP port ( > 1023 ): 8028
		Starting the service 'ndsd'... Done.
		Configuring Novell eDirectory server with following parameters
	        		Admin name      = cn=admin.o=novell
	        		Tree name       = test-tree
	        		Server Context  = o=novell
	        		dibdir path     = /var/nds/dib
	
		Searching for Duplicate Tree Name in the network.  Please wait...
	 	Configuring Novell eDirectory Server ...
	
		Novell eDirectory Server successfully configured on this system.
		Extending schema...
		For more details view schema extension logfile: /var/nds/schema.log
		Schema extended successfully.
		Configuring SAS service ...
		Successfully configured SAS service
		Configuring NMAS service ...
		Successfully configured NMAS service
		Configuring LDAP Server with default SSL CertificateDNS certificate
		Done
		Checking the status of LDAP services...
		Novell eDirectory LDAP Server TCP port is listening.
		**Novell eDirectory LDAP Server TLS port is not listening.**
		st-fc-lnx-26:~ #
	
4. No SSL/TLS operations can be perfomed.
	

The root cause of this problem being NICI getting installed in client mode. Where as NICI to be installed in server mode in order to carry out SSL/TLS operations.

### Solution:

1. Mount eDirectory 873 or 88 builds folder and run nici\_test\_mode to confirm NICI is installed in client mode:
	st-fc-lnx-26:/mnt/Released-Builds/eDirectory\_873/Linux/setup # ./nici\_mode\_test
	
	WARNING!! NICI is installed in CLIENT mode.
	
	eDirectory will not be completely functional with NICI installed in CLIENT mode.
	
	You may want to provide proper license file to get NICI installed in SERVER mode.
	
	st-fc-lnx-26:/mnt/Released-Builds/eDirectory\_873/Linux/setup #
	
2. Look to see if the nicifk file under /var/novell/nici is missing:
	st-fc-lnx-26:/ # ls /var/novell/nici
		.  ..  0  nicimud  primenici  xmgrcfg.nif  xmgrcfg.wks
		st-fc-lnx-26:/ #
	
3. Copy the nicifk file from any other eDirectory server:
	st-fc-lnx-26:/var/novell/nici # ftp 164.99.156.7
		Connected to 164.99.156.7.
		220 st-fc-sol-7.blr.novell.com FTP server ready.
		Name (164.99.156.7:root): root
		331 Password required for root.
		Password:
		230 User root logged in.
		Remote system type is UNIX.
		Using binary mode to transfer files.
		ftp> bin
		257 "/var/novell/nici" is current directory.
		ftp> ls
		229 Entering Extended Passive Mode (|||43117|)
		150 Opening ASCII mode data connection for /bin/ls.
		total 522Look out whether  nicifk  file under  /var/novell/nici is missing.
		drwx------   2 root     other        512 Oct 18 17:20 0
		-rw-r--r--   1 root     other      13440 Oct 19 09:56 nicifk
		-r--r--r--   1 root     bin        13440 Sep 25 23:35 nicifk.new
		-rwsr-xr-x   1 root     bin        11004 Sep 25 23:34 nicimud
		-rwx------   1 root     bin       194340 Sep 25 23:35 primenici
		-r-x------   1 root     bin         2661 Oct 31 12:14 set\_server\_mode
		-rw-r--r--   1 root     other       1222 Oct 19 09:56 xarchive.000
		-rw-r--r--   1 root     other      12016 Oct 19 09:56 xmgrcfg.nif
		-r--r--r--   1 root     bin         3853 Sep 25 23:35 xmgrcfg.wks
		226 Transfer complete.
		ftp> 
	
		ftp> mget ./nicifk .
		mget ./nicifk \[anpqy?\]? y
		229 Entering Extended Passive Mode (|||49320|)
		150 Opening BINARY mode data connection for ./nicifk (13440 bytes).
		100% |\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*| 13440       1.28 MB/s    00:00 ETA
		226 Transfer complete.
		13440 bytes received in 00:00 (325.37 KB/s)
		mget 0 \[anpqy?\]? q
		mget aborted.
		ftp>
	
4. Confirm the _nicifk_ is copied to /var/novell/nici:
	st-fc-lnx-26:/var/novell/nici # ls
		.  ..  0  nicifk  nicimud  primenici  xmgrcfg.nif  xmgrcfg.wks
	
5. Run _**primenici**_ to change _nici_ to server mode:
	st-fc-lnx-26:/var/novell/nici # ./primenici
		Initializing NICI ... done.
		st-fc-lnx-26:/var/novell/nici #
	
6. Now check the mode of nici:
	st-fc-lnx-26:/mnt/Released-Builds/eDirectory\_873/Linux/setup # ./nici\_mode\_test
		Count = 1
		NICI is installed in SERVER mode.
		st-fc-lnx-26:/mnt/Released-Builds/eDirectory\_873/Linux/setup #
	
7. Deconfigure the old tree:
	st-fc-lnx-26:/ # ndsconfig rm -a cn=admin.o=novell
		Enter the password for cn=admin.o=novell:
	        		dibdir path = /var/nds/dib
		Deconfiguring Novell eDirectory might cause problems in the operation of 
		modules dependent on eDirectory.  Do you wish to continue? (y/n) : y
		Logging into the tree as "cn=admin.o=novell". Please Wait ...
		Novell eDirectory Server was successfully deconfigured.
		Stopping the service 'ndsd'... Done.	
		st-fc-lnx-26:/ #
	
8. Now configure the new tree:
	st-fc-lnx-26:/ # ndsconfig new -t test-tree1 -n o=novell -a cn=admin.o=novell
		Enter the password for cn=admin.o=novell:
		Re-enter the password for cn=admin.o=novell:
		HTTP Port 8008 already in use...
		Please enter another HTTP port ( > 1023 ): 8028
		Starting the service 'ndsd'... Done.
		Configuring Novell eDirectory server with following parameters
	        		Admin name      = cn=admin.o=novell
	        		Tree name       = test-tree1
	        		Server Context  = o=novell
			dibdir path     = /var/nds/dib
	
		Searching for Duplicate Tree Name in the network.  Please wait...
		Configuring Novell eDirectory Server ...
	
		Novell eDirectory Server successfully configured on this system.
		Extending schema...
		For more details view schema extension logfile: /var/nds/schema.log
		Schema extended successfully.
		Configuring SAS service ...
		Successfully configured SAS service
		Configuring NMAS service ...
		Successfully configured NMAS service
		Configuring LDAP Server with default SSL CertificateDNS certificate
		Done
		Checking the status of LDAP services...
		Novell eDirectory LDAP Server TCP port is listening.
		Novell eDirectory LDAP Server TLS port is listening.
		st-fc-lnx-26:/ #
	

### Conclusion:

This work around will avoid reinstalling of OES just because of not configuring eDirectory during OS installation which made SSL/TLS operations impossible.

[**Like what you see?**
Sign up for our weekly newsletter. ![[./_resources/Cool_Solutions_Workaround_for_TLS_Port_Not_Listening_in_Linux_OES_SP2_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/coolsolutions/forms/subscribe.html) 

[**Want to contribute?**
It could earn you a nano! Learn more. ![[./_resources/Cool_Solutions_Workaround_for_TLS_Port_Not_Listening_in_Linux_OES_SP2_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/coolsolutions/forms/submit_a_tip.html) 

[**Like Wikis?**
Join the Cool Solutions Wiki. ![[./_resources/Cool_Solutions_Workaround_for_TLS_Port_Not_Listening_in_Linux_OES_SP2_www.novell.com.resources/unknown_filename.gif]]](http://wiki.novell.com/index.php/Cool_Solutions_Wiki_Main_Page) 

|     |     |     |
| --- | --- | --- |
| ![[./_resources/Cool_Solutions_Workaround_for_TLS_Port_Not_Listening_in_Linux_OES_SP2_www.novell.com.resources/unknown_filename.3.gif]] |     | [**Interested?**<br>Request a sales call ![[./_resources/Cool_Solutions_Workaround_for_TLS_Port_Not_Listening_in_Linux_OES_SP2_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/company/sales_call_request.jsp?refid=coolsolutions&unitcode=1-418V23) |

![[./_resources/Cool_Solutions_Workaround_for_TLS_Port_Not_Listening_in_Linux_OES_SP2_www.novell.com.resources/unknown_filename.4.gif]]

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

[close](http://www.novell.com/coolsolutions/tip/#)

* [Feedback](http://www.novell.com/inc/feedback/feedback.html)

* [Print](http://www.novell.com/coolsolutions/tip/#)
* [800-529-3400](http://www.novell.com/company/contact.html)
* [Request a Call](http://www.novell.com/common/inc/requestcall_overlay.html)
* [Follow Novell](http://www.novell.com/coolsolutions/tip/#)

[Novell](http://www.novell.com/) Making IT Work As One™
