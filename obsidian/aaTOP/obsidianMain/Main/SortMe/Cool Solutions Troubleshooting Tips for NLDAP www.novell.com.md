# Cool Solutions: Troubleshooting Tips for NLDAP [www.novell.com]

[![[./_resources/Cool_Solutions_Troubleshooting_Tips_for_NLDAP_www.novell.com.resources/unknown_filename.1.png]]](http://www.novell.com/)

* [Skip to Content](http://www.novell.com/coolsolutions/tip/11908.html#top)

		### [Products](http://www.novell.com/products/)
	
		### [Services & Support](http://www.novell.com/services/)
	
		### [Partners](http://www.novell.com/partners/)
	
		### [Communities](http://www.novell.com/communities/)
	
		### [About Novell](http://www.novell.com/company/)
	
		### [How to Buy](http://www.novell.com/products/howtobuy.html)
	

[**Change**](http://www.novell.com/common/util/langselect.php?referer=http%3A//www.novell.com/coolsolutions/tip/11908.html) **_United States,_ English**

[**Login**](https://www.novell.com/ICSLogin/?%22http://www.novell.com/coolsolutions/tip/11908.html%22)

[Close](http://www.novell.com/coolsolutions/tip/11908.html#)

								

# Troubleshooting Tips for NLDAP

## Novell Cool Solutions: Tip
By [Paul Hardwick](http://www.novell.com/coolsolutions/author/846.html)

|     |     |
| --- | --- |
| - [Slashdot This](http://slashdot.org/submit.pl)<br>_Posted: 21 Mar 2005_ |     |

### Problem

A reader recently described the following problems when using NLDAP:

"I've got a very strange issue with nss and eDirectory. Any attempts to log in result in this error: Could not connect to any LDAP server as (null) - Can't contact LDAP server.

The client can login eventually (it drops down to keyboard-interactive in this case), but the nss\_ldap calls all fail. Does anyone have any tips on how to find out what's causing this problem, short of recompiling libnss?"

And here are some troubleshooting tips contributed by Paul Hardwick from Novell:

### Troubleshooting Tips

I would start troubleshooting NLDAP - forget about nss for a second and see if you can get LDAP working. You could start by making sure that you can connect to it. I like to use ldapbrowse myself (you can download it for free). It allows you to check unsecure and TLS, as well as anonymous binds. It's pretty easy to use, with little extra to learn.

Here are some other things I would suggest you try.

1\. When NDSD is running, check to ensure that the ldap ports 389 (cleartext) and 636 (SSL) are listening. For example:

netstat -na|grep -i listen|egrep "389|636"
\[root@phardwick-002 edir\]# netstat -na|grep -i listen|egrep "389|636"
tcp        0      0 0.0.0.0:389             0.0.0.0:\*               LISTEN
tcp        0      0 0.0.0.0:636             0.0.0.0:\*               LISTEN

2\. If the ports are listening, try a root DSE search over cleartext from a command-line client. Here's an example with ldapsearch:

ldapsearch -x -h 127.0.0.1 -b "" -s base objectClass=\*

A lot of data should be returned from the ldap server with this command. The -x is required on some ldapsearch clients to specify to use simple binds without SSL authentication.

3\. If the ports are not listening, then see if there are any errors when LDAP is started. Turn on the LDAP debugging levels as follows:

ldapconfig set "LDAP Screen Level"="all" -a admin.novell -w novell

The -a is for your admin user and context, and the -w is the password. If you leave these parameters off the command line you will be prompted for the user/password. The output should be something like this:

NLDAP server configuration utility for Novell eDirectory 8.7.3 v10552.72.
LDAP Server Configuration:
LDAP Server: CN=LDAP Server - phardwick-002.O=novell
LDAP Group: CN=LDAP Group - phardwick-002.O=novell
LDAP Screen Level set to all
LDAP Server refreshed with the new configuration.

4\. Run NDSTrace in a second terminal session.

5\. Turn on only the +LDAP +TIME +TAGS tags (ensure no other tags are turned on) and trace it to a file.

6\. With ndstrace running in the second terminal, from the first terminal at the command line, unload LDAP and load it again. You should see LDAP configuration messages in ndstrace.

7\. Examine the messages to see if there is some sort of error. To unload and load ldap, use "nldap -u". The output should be:

NLDAP server loading / unloading utility for Novell eDirectory 8.7.3
v10552.72.
Stopping LDAP services.
View the log file /var/nds/ndsd.log for information.

To start again, use "nldap -l". The output should be:

NLDAP server loading / unloading utility for Novell eDirectory 8.7.3
v10552.72.
Starting LDAP services.
View the log file /var/nds/ndsd.log for information.

On the NDSTtrace screen you should now have information something like this:

NDS attribute "NSCP:memberCertificateDesc" does not exist, mapping ignored
NDS attribute "staticMember" does not exist, mapping ignored
LDAP Agent for Novell eDirectory 8.7.3 (10552.72) started
Updating server configuration
Work info status: Total:2 Peak:2 Busy:0
Listener applying new configuration
Listener setting up cleartext port 389
Adding TLS module dependencies
TLS initialized successfully
TLS configured successfully
Listener setting up TLS port 636
Adding SASL module dependencies
SASL initialized successfully
SASL configured successfully

[**Like what you see?**
Sign up for our weekly newsletter. ![[./_resources/Cool_Solutions_Troubleshooting_Tips_for_NLDAP_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/coolsolutions/forms/subscribe.html) 

[**Want to contribute?**
It could earn you a nano! Learn more. ![[./_resources/Cool_Solutions_Troubleshooting_Tips_for_NLDAP_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/coolsolutions/forms/submit_a_tip.html) 

[**Like Wikis?**
Join the Cool Solutions Wiki. ![[./_resources/Cool_Solutions_Troubleshooting_Tips_for_NLDAP_www.novell.com.resources/unknown_filename.gif]]](http://wiki.novell.com/index.php/Cool_Solutions_Wiki_Main_Page) 

|     |     |     |
| --- | --- | --- |
| ![[./_resources/Cool_Solutions_Troubleshooting_Tips_for_NLDAP_www.novell.com.resources/unknown_filename.2.gif]] |     | [**Interested?**<br>Request a sales call ![[./_resources/Cool_Solutions_Troubleshooting_Tips_for_NLDAP_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/company/sales_call_request.jsp?refid=coolsolutions&unitcode=1-418V23) |

![[./_resources/Cool_Solutions_Troubleshooting_Tips_for_NLDAP_www.novell.com.resources/unknown_filename.3.gif]]

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

[close](http://www.novell.com/coolsolutions/tip/11908.html#)

* [Feedback](http://www.novell.com/inc/feedback/feedback.html)

* [Print](http://www.novell.com/coolsolutions/tip/11908.html#)
* [800-529-3400](http://www.novell.com/company/contact.html)
* [Request a Call](http://www.novell.com/common/inc/requestcall_overlay.html)
* [Follow Novell](http://www.novell.com/coolsolutions/tip/11908.html#)

[Novell](http://www.novell.com/)
