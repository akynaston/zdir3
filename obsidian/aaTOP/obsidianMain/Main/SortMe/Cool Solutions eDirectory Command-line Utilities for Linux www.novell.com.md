# Cool Solutions: eDirectory Command-line Utilities for Linux [www.novell.com]

[![[./_resources/Cool_Solutions_eDirectory_Command-line_Utilities_for_Linux_www.novell.com.resources/unknown_filename.1.png]]](http://www.novell.com/)

* [Skip to Content](http://www.novell.com/coolsolutions/feature/#top)

		### [Solutions](http://www.novell.com/solutions/)
	
		### [Products](http://www.novell.com/products/)
	
		### [Services & Support](http://www.novell.com/services/)
	
		### [Partners](http://www.novell.com/partners/)
	
		### [Communities](http://www.novell.com/communities/)
	
		### [About Novell](http://www.novell.com/company/)
	
		### [How to Buy](http://www.novell.com/products/howtobuy.html)
	

[**Change**](http://www.novell.com/common/util/langselect.php?referer=http%3A//www.novell.com/coolsolutions/feature/14899.html) **_United States,_ English**

[**Logout**](https://secure-www.novell.com/cmd/ICSLogout)**_Welcome_ Aaron Kynaston**

[Close](http://www.novell.com/coolsolutions/feature/#)

								

# eDirectory Command-line Utilities for Linux

## Novell Cool Solutions: Feature

[Rate This Page](http://www.novell.com/inc/rater.jsp?url=http://www.novell.com/coolsolutions/feature/14899.html)

Reader Rating  ![[./_resources/Cool_Solutions_eDirectory_Command-line_Utilities_for_Linux_www.novell.com.resources/unknown_filename.3.gif]]

* [Printer Friendly](http://www.novell.com/inc/pf/pf.jsp)

* [tell a friend](http://www.novell.com/info/sendemail.jsp?url=http://www.novell.com/coolsolutions/feature/14899.html)

|     |     |
| --- | --- |
| - [Slashdot This](http://slashdot.org/submit.pl)<br>_Posted: 18 May 2005_ |     |

Note: This article is adapted from the BrainShare 2005 presentation TUT280.

Here are some of the command-line utilities you can use with eDirectory on Linux:

* NDSConfig
* NDSRepair
* NDSTrace
* LDAPConfig
* NDSIndex
* Log files

**NDSConfig**

You can use the NDSConfig utility to get or set eDirectory parameters. For example, NDSConfig can configure the location of DIBs, using the nds.conf file. Here are the directives to use:

* n4u.nds.dibdir - defines the location of DIBs. The default is /var/nds/dib.
* n4u.server.configdir - defines the location of nds.conf. The default is /etc.
* n4u.server.vardir - defines the location of logs. The default is /var/nds.
* n4u.server.libdir - defines the location of the eDirectory library. The default is /usr/lib

**Note**: It is better to use ndsconfig than to manually edit nds.conf.

NDSConfig can also recover eDirectory Services (see **man ndsconfig** for details):

ndsconfig add -m \[module\]

This enables creating the following objects:

* LDAP objects
* SNMP Group objec

t

* SAS Server Certificates (KMOs)
* HTTP object for iMonitor
* NMAS objects

**ndsrepair**

NDSRepair can check and repair eDirectory. Here are some usage examples of NDSRepair:

* Check synchronization - bash# ndsrepair -E
* Single object repair - bash# ndsrepair -J \[entry\_id\]
* Check eDirectory time sync - bash# ndsrepair -T
* Check obituaries - bash# ndsrepair -C -Ad -A

The output of checking obituaries will be in this format:

		   Found: 0 total obituaries in this DIB,
   	    0 Unprocessed obits, 0 Purgeable obits,
   	    0 OK\_To\_Purge obits, 0 Notified obits
        Total errors: 0

If you experience problems running NDSRepair, start will all options set to "off." For example:

bash# ndsrepair -R -l yes -u no -m no -f no -d no -t no -i no -o no -r no -v no -c no

**ndstrace**

NDSTrace can be run in command-line mode or via iMonitor. To run it in command-line mode, use: bash# ndstrace -l \[ >> output.log\].

To find the modules that are loaded, use:
bash# ndstrace -c modules
bash# ndstrace -c ?load ndsclone?

To display current connections, use: bash# ndstrace -c connections

To display current threads, use: bash# ndstrace -c threads

**LDAPConfig**

The LDAPConfig utility can administer an LDAP server. To view all LDAP server attributes, use:
bash# ldapconfig get ?a admin.novell ?w password

To refresh an LDAP server, use:
bash# ldapconfig ?R ?a admin.novell ?w password

You can also change LDAP server attributes to change LDAP behavior. For example, to alter the logging level on the DSTrace screen, use:
bash# ldapconfig set ?LDAP Screen Level?=?all? ?a admin.novell ?w password

**NDSIndex**

The NDSIndex utility can create, list, delete, suspend, and resume indexes. By default, it is installed into /usr/ldaptools/bin. The syntax for NDSIndex is:
bash# ./ndsindex \[command\] \[options\] \[index\]

NDSIndex uses LDAP to manipulate indexDefinition on the NCP server object. This means that LDAP must be working correctly. Once modified, indexDefinition kicks off the Limber process.

To list the CN index, use:
./ndsindex list ?D cn=admin,o=novell ?w password ?s cn=SVR01,o=novell CN

The results will look similar to this:

Index Version: 0
         Index Name: CN
         Index State: Online
         Index Rule: Value
         Index Type: Added on attribute creation
         Index State Value: Added from server
         NDS Attribute: CN

To add a VALUE index to the uid attribute, use:
bash# /usr/ldaptools/bin/ndsindex add -D cn=admin,o=novell -w novell -s cn=SVR01,o=novell "uid;uid;VALUE?

The results: Result Index(es) addition successful.

To suspend the uid attribute index, use:
bash# /usr/ldaptools/bin/ndsindex suspend -D cn=admin,o=novell -w novell -s
cn=SVR01,o=novell uid

The results: Index(es) suspension successful.

To list the uid index, use:
bash# /usr/ldaptools/bin/ndsindex list -D cn=admin,o=novell -w novell -s
cn=SVR01,o=novell uid

The results will look similar to this:

Index Version: 0
        	   Index Name: uid
        	   Index State: Suspended
        	   Index Rule: Value
        	   Index Type: User defined
        	   Index State Value: Added from server
        	   NDS Attribute: uid

**Log files**

ndsd.log

The log file is the first place to check when something goes wrong. You should check it after installs or when you encounter errors. It stores initialization data, security information, and error messages. The log file for the ndsd process is typically found in the ?/var/nds? directory. You can change it with the n4u.server.vardir directive.

Below are brief descriptions of the log file types.

schema.log

Log of schema changes to eDirectory by various utilities. Using the command "ndsconfig upgrade" will extend the schema and write the changes to this log.

ndsrepair.log

Log of ndsrepair activity run from the CLI. You can specify an alternate log file by using: # ndsrepair -F

ndstrace.log

Note: To use the following commands, first enter "ndstrace" at a terminal.

To set the log file size, use: set ndstrace=\*M<size\_in\_bytes>

To reset the log file, use: set ndstrace=\*R

To log the CLI output to a file, use:
svr1:/var/nds # ndstrace; ndstrace file on
or
svr1:/var/nds # ndstrace -l > /pub/dstrace\_example.log &

syslog (/var/log/messages)

Using the syslog, you can check for kernel errors such as:

* Bad memory
* Out of disk space
* Bad NIC
* Port conflicts

Log support tips

Here are some tips for using logs more effectively:

* Search for errors in the logs first, and then search support.novell.com.
* Search for errors in iMonitor.
* Search for signals, which are software interrupts. For example: SIGPIPE (13) - There was a broken pipe in IPC; SIGTERM (15), SIGINT (2) - Shuts down the service; SIGABRT (6) - Causes a core dump of the process.

[**Like what you see?**
Sign up for our weekly newsletter. ![[./_resources/Cool_Solutions_eDirectory_Command-line_Utilities_for_Linux_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/coolsolutions/forms/subscribe.html) 

[**Want to contribute?**
It could earn you a nano! Learn more. ![[./_resources/Cool_Solutions_eDirectory_Command-line_Utilities_for_Linux_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/coolsolutions/forms/submit_a_tip.html) 

[**Like Wikis?**
Join the Cool Solutions Wiki. ![[./_resources/Cool_Solutions_eDirectory_Command-line_Utilities_for_Linux_www.novell.com.resources/unknown_filename.gif]]](http://wiki.novell.com/index.php/Cool_Solutions_Wiki_Main_Page) 

|     |     |     |
| --- | --- | --- |
| ![[./_resources/Cool_Solutions_eDirectory_Command-line_Utilities_for_Linux_www.novell.com.resources/unknown_filename.2.gif]] |     | [**Interested?**<br>Request a sales call ![[./_resources/Cool_Solutions_eDirectory_Command-line_Utilities_for_Linux_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/company/sales_call_request.jsp?refid=coolsolutions&unitcode=1-418V23) |

![[./_resources/Cool_Solutions_eDirectory_Command-line_Utilities_for_Linux_www.novell.com.resources/unknown_filename.4.gif]]

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
