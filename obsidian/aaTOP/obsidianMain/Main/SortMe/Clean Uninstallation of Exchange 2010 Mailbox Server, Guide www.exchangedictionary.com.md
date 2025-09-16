# Clean Uninstallation of Exchange 2010 Mailbox Server, Guide [www.exchangedictionary.com]

[![[./_resources/Clean_Uninstallation_of_Exchange_2010_Mailbox_Server,_Guide_www.exchangedictionary.com.resources/unknown_filename.png]]](http://www.exchangedictionary.com/)

	

* [HOME](http://www.exchangedictionary.com/)

* [ABOUT](http://www.exchangedictionary.com/about)
* [DISCLAIMER](http://www.exchangedictionary.com/disclaimer)

	

Sunday, 15 January 2012 09:07

## Clean Uninstallation of Exchange 2010 Mailbox Server, Guide

Written by  [Praveen](http://www.exchangedictionary.com/articles/author/237-praveen)

[[#|in**Share**.]]

When you try to uninstall Mailbox role of Exchange 2010 Server which is part of a DAG and hosting public folder, the following errors will be generated. In my scenario, I have 2 mailbox server which are running with Exchange 2010 Server SP2 (I have selected a server which has OAB, public folder and more over the first mailbox server in the environment. So, hopefully this will cover all possible errors which can see during an uninstallation).
\==========
Mailbox Role Prerequisites
Failed
Error:
This Mailbox server is responsible for generating an Offline Address Book. Removal of the Mailbox role is not permitted
Click here for help... http://go.microsoft.com/fwlink/?linkid=30939&l=en&v=ExBPA.14&id=d0faeb2a-79d3-4ded-aa40-20f3b187b414
Error:
This computer is a member of a cluster. It must be removed from the Database Availability Group with the Remove-DatabaseAvailabilityGroupServer task before uninstalling Exchange.
Click here for help... http://go.microsoft.com/fwlink/?linkid=30939&l=en&v=ExBPA.14&id=22cdcab6-17f3-435a-a3a9-ec7dcb636608

Error:
Uninstall cannot continue. Database 'Mailbox Database': This mailbox database contains one or more mailboxes, mailbox plans, archive mailboxes, or arbitration mailboxes. To get a list of all mailboxes in this database, run the command Get-Mailbox -Database <Database ID>. To get a list of all mailbox plans in this database, run the command Get-MailboxPlan. To get a list of archive mailboxes in this database, run the command Get-Mailbox -Database <Database ID> -Archive. To get a list of all arbitration mailboxes in this database, run the command Get-Mailbox -Database <Database ID> -Arbitration. To disable a non-arbitration mailbox so that you can delete the mailbox database, run the command Disable-Mailbox <Mailbox ID>. To disable an archive mailbox so you can delete the mailbox database, run the command Disable-Mailbox <Mailbox ID> -Archive. Arbitration mailboxes should be moved to another server; to do this, run the command New-MoveRequest <parameters>. If this is the last server in the organization, run the command Disable-Mailbox <Mailbox ID> -Arbitration -DisableLastArbitrationMailboxAllowed to disable the arbitration mailbox. Mailbox plans should be moved to another server; to do this, run the command Set-MailboxPlan <MailboxPlan ID> -Database <Database ID>.

Click here for help... http://go.microsoft.com/fwlink/?linkid=30939&l=en&v=ExBPA.14&id=4a96fd69-9cec-4a48-9571-5c9e8ab3cfe9

Error:

Uninstall cannot continue. Database 'Public Folder': Exchange isn't able to check for public folder replicas for "Public Folder". Verify that the Microsoft Information Store service is running on ServerName.fabrikam.com, and that the database is mounted correctly.

Click here for help... http://go.microsoft.com/fwlink/?linkid=30939&l=en&v=ExBPA.14&id=b6e3b32a-8848-46cb-9567-72288ac15f60
\==========
As you see, we need to fix few pre-requisites warning/errors for a clean uninstallation of first Exchange 2010 server from the organization.

1. Change the OAB (Offline Address Book) generation role to other available server

* Remove the server from DAG membership
* Move the Arbitration mailboxes to another available Mailbox Server
* Ensure that none of the databases are using public folder of this server as default and Move Public folder replica to other available mailbox server

Now, let’s look at how to approach each errors/warnings.
**OAB Generation server movement,**

1. Open EMC, navigate to Organization Configuration->Mailbox
2. Select the tab Offline Address Book tab(right pane), Right click and select Move and select the mailbox server to which you wish to move the OAB and click on Move button.

* Continue the same if you have multiple OABs available.
**Remove the server from DAG (cluster) membership**
Before you remove any server from DAG, please remove all database copy available with that server if any,
Remove-MailboxDatabaseCopy -Identity "DatabaseName\\MailboxServerName" (MailboxServerName is the server that we are planning to uninstall).
Once you have deleted all the database copies available on the server, remove it from the DAG membership
Remove-DatabaseAvailabilityGroupServer -Identity "DAG-NAME" -MailboxServer "MailboxServerName"
**Move all arbitration mailboxes,**
When you execute Get-Mailbox -Arbitration | select Alias, you will see all available Arbitration mailboxes. To move all Arbitration mailboxes to different mailbox server, execute the below cmdlets.
Get-Mailbox -Arbitration | New-MoveRequest -TargetDatabase "Target DB Name"
**Move Public Folder Replica and change the database public folder settings,**
To move the public folder replica, you may use the below cmdlet,
.\\MoveAllReplicas.ps1 -Server MailboxServer -NewServer NewMailboxServer

Finally change default public folder settings to different available public folder other than the one which is hosted on the server we are uninstalling. If you end in any errors during the replica move, I would suggest you do manual public folder replication settings on the publc folder management tool and execute the command again.

Re-run the uninstallation again and you should get clean uninstallation wizard.
 [![[./_resources/Clean_Uninstallation_of_Exchange_2010_Mailbox_Server,_Guide_www.exchangedictionary.com.resources/unknown_filename.3.png]]](http://www.exchangedictionary.com/images/stories/Uninstall_Ex2010/Clean_Uninstallation_Exchange_2010_Mailbox_Server.png)
Now click on the uninstall button, the process will be clean and quite.
[![[./_resources/Clean_Uninstallation_of_Exchange_2010_Mailbox_Server,_Guide_www.exchangedictionary.com.resources/unknown_filename.1.png]]](http://www.exchangedictionary.com/images/stories/Uninstall_Ex2010/Clean-Completion.png)
Hope this will help you in completing a clean uninstallation or Removal of Exchange 2010 Mailbox Server. The uninstallation of Other roles(CAS and Hub) are farely simple and hence did not tried to cover here.
References,
<http://technet.microsoft.com/en-us/library/ee332361.aspx>
<http://technet.microsoft.com/en-us/library/bb691120.aspx>
<http://technet.microsoft.com/en-us/library/dd876883.aspx>

\-Praveen

More in this category: [« Exchange 2007/2010 Transport Rules using Message Header Values](http://www.exchangedictionary.com/articles/exchange-2007-2010-transport-rules-using-message-header-values) [Understand Address Book Policies – Exchange Server 2010 »](http://www.exchangedictionary.com/articles/understand-address-book-policies-exchange-server-2010)
[back to top](http://www.exchangedictionary.com/articles/clean-uninstallation-of-exchange-2010-mailbox-server-guide#startOfPageId33)

### Categories

* [Articles](http://www.exchangedictionary.com/articles)

* [News](http://www.exchangedictionary.com/news)
* [Reviews](http://www.exchangedictionary.com/reviews)
* [Solutions](http://www.exchangedictionary.com/solutions)
* [Videos](http://www.exchangedictionary.com/videos)

### Stay Connected

* <http://www.facebook.com/ExchangeDictionary>

* <http://www.twitter.com/balanpraveen>
* <https://plus.google.com/+PraveenBalan-gplus>
* <http://www.youtube.com/channel/UCmX0jJ0l86Q_zLPYhoKJaJg>
* <http://www.linkedin.com/groups?home=&gid=3112656&trk=anet_ug_hm>

### Archives

* [October 2014 (1)](http://www.exchangedictionary.com/articles/date/2014/10)

* [September 2014 (1)](http://www.exchangedictionary.com/articles/date/2014/9)
* [August 2014 (3)](http://www.exchangedictionary.com/articles/date/2014/8)
* [December 2013 (1)](http://www.exchangedictionary.com/articles/date/2013/12)
* [November 2013 (3)](http://www.exchangedictionary.com/articles/date/2013/11)
* [October 2013 (2)](http://www.exchangedictionary.com/articles/date/2013/10)
* [September 2013 (3)](http://www.exchangedictionary.com/articles/date/2013/9)
* [August 2013 (2)](http://www.exchangedictionary.com/articles/date/2013/8)
* [July 2013 (1)](http://www.exchangedictionary.com/articles/date/2013/7)
* [May 2013 (2)](http://www.exchangedictionary.com/articles/date/2013/5)
* [April 2013 (1)](http://www.exchangedictionary.com/articles/date/2013/4)
* [February 2013 (3)](http://www.exchangedictionary.com/articles/date/2013/2)

	

#### [ABOUT PRAVEEN](http://www.exchangedictionary.com/about)

![[./_resources/Clean_Uninstallation_of_Exchange_2010_Mailbox_Server,_Guide_www.exchangedictionary.com.resources/unknown_filename.2.jpeg]]Praveen is a **Microsoft Exchange Server Architect** and author of **Exchange Dictionary**. He also holds many **Microsoft certifications** including Exchange Server 2003, 2007 and 2010. Connect with Praveen on [Twitter](https://twitter.com/balanpraveen) and [Facebook](https://www.facebook.com/ExchangeDictionary).

#### CATEGORIES

* [Articles](http://www.exchangedictionary.com/Articles)

* [News](http://www.exchangedictionary.com/news)
* [Reviews](http://www.exchangedictionary.com/reviews)
* [Solutions](http://www.exchangedictionary.com/Solutions)
* [Videos](http://www.exchangedictionary.com/videos)

#### USEFUL LINKS

* [Remote Connectivity Analyzer](https://testconnectivity.microsoft.com/)

* [MX Lookup](http://mxtoolbox.com/)
* [Exchange Team Blog](http://blogs.technet.com/b/exchange)

	

Copyright © exchangedictionary.com
[__](http://www.exchangedictionary.com/articles/clean-uninstallation-of-exchange-2010-mailbox-server-guide#)
