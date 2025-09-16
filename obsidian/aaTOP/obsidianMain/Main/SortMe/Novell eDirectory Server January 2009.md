# Novell eDirectory Server: January 2009

[skip to main](http://novelledirectory.blogspot.com/#main) | [skip to sidebar](http://novelledirectory.blogspot.com/#sidebar)

# [Novell eDirectory Server](http://novelledirectory.blogspot.com/)

Performance Tuning ldap novell novell edirectory ldap novell edirectory server novell edirectory linux

## Novell eDirectory Performance Tuning

### [Performance Tuning Options in Novell eDirectory](http://novelledirectory.blogspot.com/2009/01/performance-tuning-options-in-novell.html) 

## Friday, January 30, 2009

* **Indexing**

Indexing can be a good way to speed up queries. The Indexes are viewed and managed using iManager by modifying the NCP Server object. From the eDirectory ndstrace data analysed it can be seen that objects are located within milliseconds using an index.

* **Cache**

The eDirectory database cache has a number of options for optimisation. The recommendations are dependent on the server operating system used.
eDirectory database cache is divided into two types, entry and block cache. Entry cache is where individual objects are cached, objects could be cached more than once. Block cache is a block of database data, which may contain data relating to more than one object.

Using Linux and Reiser, the block cache could be dropped to zero to allow Reiser to handle block caching. This increases eDirectory performance three-fold.

FLAIM DB Cache its good to go for 1GB of cache with 80% block for heavy write environments, 20% block for heavy Read environments, and 50% with equal read and write environments.
**Note:** Stream files are not cached by eDirectory. When this data is read it will always be retrieved from the file system.

* **LDAP Search Parameters**

Generally we ignore the below parameters. But, if we need a very good throughput and low reponsetimes sizelimit and time limit are good parameters which can be optimized.

a. **searchSizeLimit**
The maximum number of entries that the LDAP server will return to an LDAP client in response to a search. A value of 0 (zero) indicates no limit.

b. **searchTimeLimit**
The maximum number of seconds after which an LDAP search will be timed out by the LDAP server. A value of 0 (zero) indicates no limit.

The eDirectory engine will continue searching for and returning data after the client has already abandoned the LDAP request. These parameter values help to prevent inappropriate use of the LDAP service.

**c.** **Scope Search**
Take care of the scope search. Dont go for SUB Scope when scope ONE will work.

d. **Attributes Returned
**Only return the attributes required for the current query. Returning all attributes will require more eDirectory cache, LDAP Server CPU time, Data Layer API processing and increase LAN traffic.

**e.** **Search Criteria**
Search criteria is not that important in eDirectory.

* **Good server hardware**

Fast kit will make the difference between milliseconds and seconds.

* **Good operating system**

The operating system determine what tuning options are practical and therefore available. Using 64-bit Linux with reiser and setting the eDirectory block cache to zero will provide the best performance.

* **Efficient monitoring and tracing**

Sometimes ndstrace is the best option, in these cases care should be taken to ensure that only the filters required are used. The more details the log will contain the harder the eDirectory service must work to provide this. In testing this additional load added ~20% to the CPU usage of ndsd.

[Read more...](http://novelledirectory.blogspot.com/2009/01/performance-tuning-options-in-novell.html) 
At [7:26 AM](http://novelledirectory.blogspot.com/2009/01/performance-tuning-options-in-novell.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=3362811387537595597)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=3362811387537595597)
Labels: [Performance Tuning](http://novelledirectory.blogspot.com/search/label/Performance%20Tuning) 
 

### [What is an Identity System?](http://novelledirectory.blogspot.com/2009/01/what-is-identity-system.html) 

## Monday, January 19, 2009

In general, an Identity System provides for the creation, removal, editing and other managing of identity information stored in various types of data stores.
The identity information pertains to users, groups, organizations and/or things. For each entry in the data store, a set of attributes are stored. For example, the attributes stored for a user may include name, address, employee number, telephone number, email address, user ID and password. The Identity System can also manage access privileges that govern what an entity can view, create, modify or use in the Identity System. Often, this management of access privileges is based on one or more specific attributes, membership in a group and/or association with an organization.
[Read more...](http://novelledirectory.blogspot.com/2009/01/what-is-identity-system.html) 
At [3:15 AM](http://novelledirectory.blogspot.com/2009/01/what-is-identity-system.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=4855927845582306405)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=4855927845582306405)
Labels: [Identity](http://novelledirectory.blogspot.com/search/label/Identity) 

 

### [What is an Access System?](http://novelledirectory.blogspot.com/2009/01/what-is-access-system.html) 

An Access System provides for the authentication and authorization of users attempting to access resources. For efficiency purposes, there is an advantage to integrating the Identity System and the Access System. For example, both systems can share the same set of data stores.
[Read more...](http://novelledirectory.blogspot.com/2009/01/what-is-access-system.html) 
At [3:14 AM](http://novelledirectory.blogspot.com/2009/01/what-is-access-system.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=5619507934161224082)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=5619507934161224082)
Labels: [Identity](http://novelledirectory.blogspot.com/search/label/Identity) 

 

### [What is a Directory Service?](http://novelledirectory.blogspot.com/2009/01/what-is-directory-service.html) 

A directory service is a simplified database. Typically, it does not have the database mechanisms to support roll-back of transactions. Directories allow both read and write operations, but are intended primarily for high-volume, efficient read operations by clients.
LDAP is a distributed directory service protocol.
[Read more...](http://novelledirectory.blogspot.com/2009/01/what-is-directory-service.html) 
At [3:14 AM](http://novelledirectory.blogspot.com/2009/01/what-is-directory-service.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=4803217107574087153)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=4803217107574087153)
Labels: [eDirectory](http://novelledirectory.blogspot.com/search/label/eDirectory) 

 

### [Identity 2.0](http://novelledirectory.blogspot.com/2009/01/identity-20.html) 

## Sunday, January 18, 2009

[Read more...](http://novelledirectory.blogspot.com/2009/01/identity-20.html) 
At [9:26 AM](http://novelledirectory.blogspot.com/2009/01/identity-20.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=6243177910157613699)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=6243177910157613699)
Labels: [Identity](http://novelledirectory.blogspot.com/search/label/Identity) 

 

### [What is Digital Identity?](http://novelledirectory.blogspot.com/2009/01/what-is-digital-identity.html) 

[Read more...](http://novelledirectory.blogspot.com/2009/01/what-is-digital-identity.html) 
At [9:17 AM](http://novelledirectory.blogspot.com/2009/01/what-is-digital-identity.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=4452233202015371459)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=4452233202015371459)
Labels: [Identity](http://novelledirectory.blogspot.com/search/label/Identity) 

 

### [Monitoring of Novell eDirectory](http://novelledirectory.blogspot.com/2009/01/monitoring-of-novell-edirectory.html) 

## Thursday, January 15, 2009

In order to have a clear idea of the security status of a system, it is necessary to monitor this continually. The aim of such monitoring is to discover any violations of the applicable security provisions, identify any existing security weaknesses and detect any configuration errors which could result in security loopholes. A corresponding monitoring concept should also be viewed as part of the security concept.

Usually it is not feasible these days for complex systems like eDirectory to be monitored by individual administrators, but monitoring must be automated, using appropriate system components or products of third party vendors. The configuration of system monitoring must be regularly adapted to the system as it changes.

eDirectory provides the tool iMonitor for system monitoring. This is a client/server application in which the iMonitor service runs on some (or all) eDirectory servers. The clients can access it via a browser, which has to support HTML Version 3. The client seeking access must authenticate itself to the iMonitor services and, following successful authentication, it is granted access to the iMonitor data, with the rights that have been configured for it.

The information which the iMonitor service provides via an eDirectory server could be used by unauthorised persons to search systematically for security weaknesses in an existing eDirectory installation. For this reason it is recommended only allowing access to the iMonitor service with SSL encryption enabled, especially if access is possible from outside of the organisation's own network. For this purpose the appropriate server certificate must be imported into the browser on the client.

There are two different operational modes for iMonitor access, the direct mode and the proxy mode. In the direct mode, the browser is directly linked to the eDirectory server, whose status data is queried. On the eDirectory server the iMonitor services must be activated. In the proxy mode, a server on which the iMonitor services are available is accessed, but the actual information is retrieved from another server.

Compared with the proxy mode, the direct mode has the advantage that it requires less bandwidth and the server-centred functionality is available in full. From the point of view of IT security, however, the proxy mode is to be preferred so as to keep down the number of eDirectory computers allowing this possibility of direct access. A fixed dial-in address should be used here; this must then be monitored and protected appropriately.

The NDS Trace Utility is used to record eDirectory-specific events in a separate log file. This enables all eDirectory events to be logged. There is also a Novell Advanced Auditing Service (NAAS) additional module, which permits automatic evaluation of eDirectory-specific events.

**The following aspects of monitoring should be considered:**

The Data Privacy Protection Officer and the staff council and/or works council should be included in the early stages of planning, since monitoring generally also requires the capture of person-related data so that in the event of a security violation it is possible to reliably identify who was responsible.

As well as the eDirectory-specific events, operating system events must also be watched and logged in order to obtain a more complete picture of the system processes. Recommendations and information on logging at operating system level are contained in the existing modules in Chapters 5 and 6.

Third-party products are available which allow a central collection point to be set up for log files with corresponding automated evaluation. If a network and system management tool is used (see also module 6.8 Network and System Management), then, depending on the product, it is possible to import the eDirectory logs directly into this tool.

Depending on the settings, large volumes of data may be generated as a result of monitoring. This must not only be regularly evaluated, but for space reasons it must also be deleted or transferred to other data media at regular intervals as well. At the same time it should be borne in mind that intensive monitoring may have an adverse effect on performance. It is possible for a server to become so overloaded as a result that controlled operation is no longer possible. For this reason the appropriate monitoring parameters must be checked during a test run and, if necessary, modified. It should be noted that modification can also affect the entire monitoring concept as it may no longer be possible for certain monitoring tasks to be carried out. This applies especially where additional products are used which place high demands on logged events. These include, for example, programs which automatically analyse log data for behavioural anomalies that might suggest an attack.

Within the framework of the monitoring of system functions it is also recommended regularly checking the eDirectory replication process, through which configuration changes are propagated. Errors in replication usually have the result that configuration changes are not implemented everywhere, so that, for example, a given user might enjoy more privileges than he is supposed to.

**Additional controls:**

* Has a monitoring concept that is tailored to the requirements been drawn up and implemented?
* Are important system events logged?
* Have monitoring settings been configured for important system files?

[Read more...](http://novelledirectory.blogspot.com/2009/01/monitoring-of-novell-edirectory.html) 
At [5:56 AM](http://novelledirectory.blogspot.com/2009/01/monitoring-of-novell-edirectory.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=3972468963736089261)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=3972468963736089261)
Labels: [eDirectory Monitoring](http://novelledirectory.blogspot.com/search/label/eDirectory%20Monitoring) 

 

### [Novell eDirectory Health Checks -5](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-checks-5.html) 

## Saturday, January 10, 2009

Replica State & Ring Consistency Checks
The replica state check lists partitions and the states of the replicas stored in the current Directory Information Base (DIB). Although not likely to happen it is a good idea to periodically check to ensure that replica states have not suddenly changed from ON to some other undesirable state, such as Dying.
You should also occasionally check that each partition replica ring is consistent, that is, the replica ring list on every server holding the same partition should be the same.
To check for ring consistency you run ndsrepair on the server with the master replica, check the ring, then run ndsrepair, on other servers in the ring and check to see if the list and type of replica reported is the same.
For Solaris or Linux execute ndsrepair –P – login as root required – Select Option 6 to check replica state, Select Option 10 to view the replica ring information.
Schema Synchronisation and Status Check
All servers in the eDirectory tree have a copy of the schema, even if the server does not hold any replicas, the schema information must be identical.
When schema changes are made they are applied to the server holding the Master replica of root, from there the changes are propagated down the tree from one server to another. The eDirectory schema synchronisation process is event driven and starts 10 seconds after a schema change is made.
To use ndstrace to check whether the schemas in a tree are in synchronisation:
For Solaris or Linux execute the following:
set ndstrace = on
set ndstrace = nodebug
set ndstrace = +scma (Enables schema sync messages)
set ndstrace = +scmd (Enables detailed schema sync messages)
set ndstrace = \*ss (Forces Schema Sync to run)
You can view the trace information in /var/nds/ndstrace.log file, which can be viewed through a text editor. You are looking for “All processed = YES” statement. Or you can use the grep command to interrogate the file for the statement you are looking for.

[Read more...](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-checks-5.html) 
At [11:46 AM](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-checks-5.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=4782282383373465033)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=4782282383373465033)
Labels: [eDirectory](http://novelledirectory.blogspot.com/search/label/eDirectory) , [eDirectory Monitoring](http://novelledirectory.blogspot.com/search/label/eDirectory%20Monitoring) 

 

### [Novell eDirectory Health Checks -4](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-checks-4.html) 

External References, Backlink and Obituaries Check
When a server references an object that it does not have locally, an external reference to that object is created, and the object will have a DRL (Distributed Reference Link) to the server that holds its exref. It is a good idea to know how many external references a server holds, if there are many then the server should hold a copy of the replica. This check will also show any obituaries and their state.
For Solaris or Linux execute ndsrepair –C – login as root required Total errors reported should be 0, investigate any errors shown.
To include obits reporting execute ndsrepair –Ad –C
After this has been run the log file shows exrefs that are backlinked (DRL) and lists any obituaries that have not yet completed. Of primary concern are the obituaries that have not completed. For example, problems can emerge if the obituary flag remains in the same state and is never purged. This condition indicates a possible communication problem between servers or that a server may have been removed, or crashed, improperly.
If you suspect backlink, exref and obit problems then use ndstrace to check.
The procedure for doing this is:
set ndstrace = on
set ndstrace = nodebug
set ndstrace = +blnk (Enables backlink messages)
set ndstrace = +bldt (Enables detailed backlink messages)
set ndstrace = +jntr (Enables Janitor messages)
set ndstrace = \*b (Forces Backlink to run)
set ndstrace = \*f (Forces the Flat Cleaner to run)
The displayed information is saved automatically in the /var/nds/ndstrace.log file, which can be viewed through a text editor.

[Read more...](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-checks-4.html) 
At [11:46 AM](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-checks-4.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=7204440022836272669)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=7204440022836272669)
Labels: [eDirectory](http://novelledirectory.blogspot.com/search/label/eDirectory) , [eDirectory Monitoring](http://novelledirectory.blogspot.com/search/label/eDirectory%20Monitoring) 

 

### [Novell eDirectory Health Checks -3](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-checks-3.html) 

Replica Synchronisation – Partition Continuity Check
The replica synchronisation (partition continuity) check helps identify if any of the partition’s replicas are experiencing synchronisation errors. The check displays the time of the last successful synchronisation.
If there has not been a successful synchronisation for more than 12 hours a warning is flagged and should be investigated.
For Solaris or Linux execute ndsrepair –E at the server console – login as root required
Last successful synchronisation values should be close, but no more than 12 hours.

[Read more...](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-checks-3.html) 
At [11:44 AM](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-checks-3.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=2174346798020201642)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=2174346798020201642)
Labels: [eDirectory](http://novelledirectory.blogspot.com/search/label/eDirectory) , [eDirectory Monitoring](http://novelledirectory.blogspot.com/search/label/eDirectory%20Monitoring) 

 

### [Novell eDirectory Health Checks -2](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-checks-2.html) 

Server to Server Synchronisation Check
Server to server synchronisation status check ensures that the servers within a given replica ring are communicating correctly. However it does not guarantee that replicas are synchronised, a partition continuity check discussed later is required to verify this.
For Solaris or Linux execute the following commands:
su root
\> /var/nds/ndstrace.log (this is the file where the information is saved)
set ndstrace = on
set ndstrace = nodebug
set ndstrace = +sklk (Enables synchronisation messages)
set ndstrace = +sync (Enables inbound synchronisation)
set ndstrace = \*h (This initiates a synchronisation heartbeat)
set ndstrace = off (Give enough time to record synchronisation information)
To gather information to check server to server synchronisation use grep on ndstrace.log
grep “All processed = YES” /var/nds/ndstrace.log | wc -l (Will output those servers that are synchronising)
grep “All processed = NO” /var/nds/ndstrace.log | wc -l (Will output those servers that are not synchronising)
NB If you get any “All processed = NO” then investigate further!
Logout of server when finished.
[Read more...](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-checks-2.html) 
At [11:44 AM](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-checks-2.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=1614218385854555500)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=1614218385854555500)
Labels: [eDirectory](http://novelledirectory.blogspot.com/search/label/eDirectory) , [eDirectory Monitoring](http://novelledirectory.blogspot.com/search/label/eDirectory%20Monitoring) 

 

### [Novell eDirectory Dib Lock - DIB Lock How it works - Part 2](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-dib-lock-dib-lock-how_10.html) 

3) Threads doing LDAP update operations typically do not hold the dib lock for very long periods of time - milliseconds probably. Probably the real issue you are facing is the fact that there is a background thread, called the "checkpoint thread", which periodically runs to flush all dirty blocks (blocks which have been modified in cache but not yet written to disk) from cache to disk to establish a database checkpoint. In order to do this, it must obtain the dib lock. While it is holding the lock, all other threads that want to do LDAP update operations will be blocked.
The amount of time it takes for the checkpoint thread to flush dirty blocks to disk (and hence, the amount of time it holds the dib lock) depends on how much dirty cache there is. The more dirty cache there is, the longer it takes. The checkpoint thread wakes up every second to see if there are dirty cache blocks that need to be written to disk. If there are no other threads that have obtained the dib lock, and none waiting to obtain it, it will obtain the lock and start writing out dirty blocks. However, while it is writing out dirty blocks, if another thread requests the dib lock, the checkpoint thread will usually immediately give up the dib lock so that update operations will not have to wait for it to finish writing out all dirty blocks. However, if the checkpoint thread has not been able to complete a checkpoint (which is writing out all dirty blocks) for a certain period of time, it will not release the dib lock, but will continue writing until all dirty blocks have been written and a checkpoint established. This "certain period of time" is called the checkpoint interval. The term "checkpoint interval" is a misnomer. It seems to suggest that it is how often the checkpoint thread wakes up and does a checkpoint. But that is NOT what it is. The fact of the matter is, the checkpoint thread is continuously waking up and attempting to complete a checkpoint. The checkpoint interval is simply the longest time that the checkpoint thread will allow to go by without completing a checkpoint. If the last completed checkpoint was too long ago (more than the seconds specified by the checkpoint interval), the checkpoint thread holds onto the dib lock and completes the checkpoint before giving up the lock. We sometimes refer to this as "forcing a checkpoint."
By reducing the checkpoint interval, the checkpoint thread will "force" a checkpoint more often. This means that it will generally have fewer dirty blocks to write out - because not as much dirty cache can build up in the shorter interval. There is probably a better way to keep dirty cache from building up. There are two settings in the \_ndsdb.ini file that you can set to control dirty cache buildup: "maxdirtycache" and "lowdirtycache". For example:
maxdirtycache=30000000
lowdirtycache=0
"maxdirtycache" and "lowdirtycache"
"max dirty cache" and "low dirty cache"
max dirty cache and low dirty cache
These settings tell the checkpoint thread to not allow more than 30 MB (roughly) of dirty cache to build up. Whenever it sees that more than 30 MB of dirty cache has accumulated, it will lock the dib and write it all out (down to zero - the number specified by the lowdirtycache setting). By setting maxdirtycache to the right value, the checkpoint thread forces a checkpoint more frequently, but writes out a smaller amounts of dirty cache each time. This, in effect, reduces the length of time the checkpoint thread holds the dib lock whenever it forces a checkpoint. Note that this does NOT reduce the overall amount of writing that must be done - it just spreads it out over time - amortizes it so to speak. Also, although increasing checkpoint frequency "spreads out the writes" it may not improve overall throughput. In fact, overall throughput may actually decrease some, because there is now not as much opportunity for a "piggybacking" effect - which is where multiple update operations update the same block before it is written to disk. Because the checkpoint thread is writing more frequently, a given block that is updated by multiple update operations may be written to disk multiple times now instead of being written out once.
I don't know what value you should set maxdirtycache to. You will probably want to do some experimenting. It will be different for every system - depends a lot on your disk system and how efficient it is.
Well, that is probably more than you wanted to get, but I wanted to make sure you had sufficient understanding to try various things intelligently.
As an extra note, you should know that we did some analysis and discovered that there are things that could be done to more efficiently write out dirty blocks to disk. FLAIM does not currently keep the disk channel as busy as it could. On Windows Andy Hodgkinson implemented some changes that produced dramatic improvements in how quickly FLAIM can write out dirty blocks - 10 to 20 times improvement. I believe those same changes could be made on other platforms as well. Currently, FLAIM is being transitioned to India, so the changes would most likely need to be done by engineers in Bangalore. I don't know when or if these changes will make it into a shipping version of eDir.

[Read more...](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-dib-lock-dib-lock-how_10.html) 
At [11:36 AM](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-dib-lock-dib-lock-how_10.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=5114266195755081597)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=5114266195755081597)
Labels: [DIB](http://novelledirectory.blogspot.com/search/label/DIB) , [eDirectory](http://novelledirectory.blogspot.com/search/label/eDirectory) , [Performance Tuning](http://novelledirectory.blogspot.com/search/label/Performance%20Tuning) 

 

### [Novell eDirectory Health Checks -1](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-checks.html) 

**Check eDirectory version and Time Synchronisation**
Correct time synchronisation is important as eDirectory partitions are replicated and need to be concurrent with one another. Each event that occurs is marked with a timestamp; these timestamps are used to order the processing of events and changes that can occur on multiple servers.
The time synchronisation check is performed using the ndsrepair utility and should performed on a server that holds a replica of \[Root\], not necessary the master. It is carried out on such as server as it will be aware of all the servers in the tree.
For Solaris or Linux execute ndsrepair –T – login as root required This will report the time synchronisation of all the servers in the tree. If not all the servers in the tree are displayed it will be necessary to run this on those missing servers.
As a by product of running this command eDirectory versions are also displayed. The current version reported should be 10552.79.
This check should be run on a regular basis, and certainly before any partition operations are carried out. Recommendation is to run it daily.

[Read more...](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-checks.html) 
At [11:08 AM](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-checks.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=1442631511411637958)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=1442631511411637958)
Labels: [eDirectory](http://novelledirectory.blogspot.com/search/label/eDirectory) , [eDirectory Monitoring](http://novelledirectory.blogspot.com/search/label/eDirectory%20Monitoring) 

 

### [How eDirectory Finds other servers in the tree during Replication](http://novelledirectory.blogspot.com/2009/01/how-edirectory-finds-other-servers-in.html) 

During the sync process edirectory will try to use SLP, DNS or the hostfiles. The only way to see which one is being used is to take a lan trace when hosts are being resolved, there you will see from which service the name is resolved.
[Read more...](http://novelledirectory.blogspot.com/2009/01/how-edirectory-finds-other-servers-in.html) 
At [10:58 AM](http://novelledirectory.blogspot.com/2009/01/how-edirectory-finds-other-servers-in.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=3646247611559663506)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=3646247611559663506)
Labels: [eDirectory](http://novelledirectory.blogspot.com/search/label/eDirectory) 

 

### [Novell eDirectory 8.8 - Does it support Multi Core Processors](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-88-does-it-support.html) 

## Friday, January 9, 2009

No it doesn't. The T2000 CPU has up to 24 cores. Each core has a slow processing speed but the combination makes for a fast overall speed. Unfortunately at this time, eDirectory can only run on one of the cores.
Therefore you get roughly the same performance as eDirectory running on a single CPU Ultra 60 machine
[Read more...](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-88-does-it-support.html) 
At [10:34 AM](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-88-does-it-support.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=2366608933544164062)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=2366608933544164062)
Labels: [Performance Tuning](http://novelledirectory.blogspot.com/search/label/Performance%20Tuning) 

 

### [Ldap Search - Total Count of Objects in eDirectory](http://novelledirectory.blogspot.com/2009/01/ldap-search-total-count-of-objects-in.html) 

Ldap search command to find out the count of objects in eDirectory
time ldapsearch -x -h 10.48.60.117 -p 389 -D "cn=admin,o=services" -w novell123 -b "ou=users,o=idv" "Objectclass=\*" 1:1 | grep -c "dn:"
**Options:**
1:1 return only the dn of the object
\-x is used for simple authentications

[Read more...](http://novelledirectory.blogspot.com/2009/01/ldap-search-total-count-of-objects-in.html) 
At [5:41 AM](http://novelledirectory.blogspot.com/2009/01/ldap-search-total-count-of-objects-in.html)  [, 1 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=8853604627631536195)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=8853604627631536195)
Labels: [LDAP](http://novelledirectory.blogspot.com/search/label/LDAP) 

 

### [Novell eDirectory Dib Lock - DIB Lock How it works - Part 1](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-dib-lock-dib-lock-how.html) 

1) I'm not sure what you mean when you ask if dib locking is multi-threaded. This is a bit of a strange question, because the whole purpose of locking is to coordinate the actions of multiple threads. If you only had a single thread, there would be no need for locking. Multiple threads may simultaneously request the dib lock, but only one thread at a time is granted the lock. The thread that is granted the lock is allowed to proceed with its LDAP operation, while other threads requesting the lock will be required to wait in a queue until that thread releases the lock. When a thread releases the lock, the lock is then granted to the next thread in the queue, and that thread can then perform its operation, etc.

Note that only threads performing LDAP UPDATE operations (add, modify, delete, etc.) are required to obtain the dib lock before performing the operation. Threads performing LDAP READ operations (search, etc.) are NOT required to obtain a dib lock before performing the operation.
The net effect of this is that all LDAP update operations are serialized - they are performed sequentially - one at a time. They are never done concurrently, even when there are multiple CPUs. So having multiple CPUs does not make update operations more scalable. However, the same is NOT true of LDAP read operations. Multiple threads performing LDAP read operations may all be executing concurrently, and it is likely that multiple CPUs will help in that scenario.
2) The term "dib lock" refers to the granularity of the lock. A "dib" lock locks the entire dib. There are no "entry" locks or "sub-tree" locks in eDir.
[Read more...](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-dib-lock-dib-lock-how.html) 
At [5:32 AM](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-dib-lock-dib-lock-how.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=3797702552494636152)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=3797702552494636152)
Labels: [DIB](http://novelledirectory.blogspot.com/search/label/DIB) , [eDirectory](http://novelledirectory.blogspot.com/search/label/eDirectory) , [Performance Tuning](http://novelledirectory.blogspot.com/search/label/Performance%20Tuning) 

 

### [Novell eDirectory Handy Commands](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-handy-commands.html) 

## Thursday, January 8, 2009

1\. netstat
2\. ndsconfig upgrade
Upgrade command will fix the certificates.
To remove the non root server from the root before doing a cleanup.
ndsconfig rm -a admin.sup
3\. ndsrepair -N
Will fix the network addresses
ndsrepair -T
ndsrepair -P
Show all replicas and perform below operations
1\. Repair all replicas
2\. Repair selected replica
3\. Schedule immediate synchronization
4\. Cancel partition operation
5\. Designate this server as the new master replica
6\. Report Synchronization status of all servers
7\. Synchronize the replica on all servers
8\. Repair Ring, all replicas
9\. Repair Ring, selected replica
10\. View Replica Ring
11\. View entire partition name
12\. Return to Replica List
4\. NDSCONFIG COMMAND:
new -i -t profiletree-ivvt2 -n ou=dy.ou=services.ou=profile.o=ccstore -a cn=admin.o=sup -e
\-D /var/opt/novell/eDirectory -d /data/nds/dib -P 192.168.100.70 -B 147.149.123.70
ndsconfig rm -a admin.sup
To remove the non root server from the root before doing a cleanup.
5\. ndsimonitor
Check for imonitor partitions
6\. IManager error codes
601 - UID is wrong.
669 - Passwd is wrong.
626 - Tree name is wrong.
7\. cat //etc/init.d/post\_ndsd\_start
8\. snoop -d bge2
9\. netstat -r
Routing Table
10\. /etc/rc2.d/S98start\_logmon
11\. /etc/init.d/ndssnmpsa start
12\. /etc/rc3.d/S76snmpdx start
13\. ldapsearch -h 192.168.100.66 -p 389 -w novell123 -D cn=admin,o=sup,dc=bt cn=admin
14\. vi /etc/logevent.conf
15\. vi /var/opt/novell/tomcat4/webapps/nps/WEB-INF/configiman.properties
Contains the eDirectory tree name.
16\. vi /etc/snmp/conf/\_snmpdx.rsrc.JASS.20060504184320
17\. vi /etc/snmp/conf/snmpdx.acl
18\. arp 147.149.123.66

[Read more...](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-handy-commands.html) 
At [11:39 AM](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-handy-commands.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=1601346464419297638)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=1601346464419297638)
Labels: [eDirectory](http://novelledirectory.blogspot.com/search/label/eDirectory) , [eDirectory Monitoring](http://novelledirectory.blogspot.com/search/label/eDirectory%20Monitoring) 

 

### [LDAP vs Relational Database](http://novelledirectory.blogspot.com/2009/01/ldap-vs-relational-database.html) 

Typically, when I ask enterprise developers where they'll store application data the response is immediate, a relational database. The directory server isn't even an afterthought. There's a long laundry list of reasons why: no one gets fired for choosing Oracle, its already there, familiarity with SQL, plethora of RDBMS tools, LDAP writes are slow, JNDI interface - are you kidding?!... While all of these are legitimate retorts, LDAP, and in particular OpenDS, bring with it clear advantages for certain classes of applications.
A short list of OpenDS differentiators include:
It's a database! LDAP isn't just a dumping ground for user profile data, it's a full-fledged hierarchical database. If your data is modeled in a parent-child fashion, not unusual in a XML world, then LDAP might be a better fit. LDAP data modeling is very different than relational modeling though at a simplistic level you might map tables to entries and columns to attributes.
Change schema over protocol: Schema is modifiable over the standard LDAP protocol - no vendor specific tools or syntax required. Building an application that requires frequent and/or unpredictable schema changes is difficult with relational databases and, I've found, often handled by creating generic trees (parent child relationships). Highly, dynamic “Web 2.0'ish” applications come to mind; e.g., generic Atom server where arbitrary schema changes are expected.
Out-of-the-box synchronization: Synchronizing directory databases is a standard feature and requires minimal administration. It just works...at least that's the idea. A very cool feature for H/A and solving data adjacency issues.
Read/write performance parity: At the moment I'm unable to release specifics on OpenDS performance, but those of you with memories of slow write performance are in for a pleasant surprise
Embedded mode: OpenDS need not run in a separate process, rather it can be directly embedded in your application. This is especially useful for cases where one may need the benefits of a LDAP (the other bullets) database with zero external administration.
Scalability: OpenDS, stripped down, runs on PDA's and scales to telcos.
Extensibility: Aside from standard plugin extensions there are numerous hooks within OpenDS that are easily modified by a Java developer. OpenDS is 100% Java after-all. A deployer is free to customize protocol handlers, client connection handlers, configuration, monitors, loggers, and even the backend (we use Berkley DB).
Internationalization over protocol: Fetching language specific directory attributes is easily done over protocol using LDAP attribute options. For example, you may search for the English specific “description” attribute by searching “description;lang-en: software products” or the German version “description;lang-de: Softwareprodukte”
Matching rules: Directory servers provide a flexible facility for determining attribute value equality. Typical equality matching is supported out-of-the-box; e.g., case ignore, greater/less than, etc. The differentiating feature is the ability to write your own matching rules for specific attributes. An interesting application of this is fuzzy matching rules; instead of implementing approximate matches in your application logic this can be done within the data repository. For example, if I search for all Atom entries with the an attribute named “category” and the value “foo” I may have a matching rule that finds and return all entries that contain category values with “bar” and “baz” as well.
If you are setting up a large scale LDAP infrastructure i ‘d suggest you try and break the load across multiple servers instead of keeping everything in one large monolithic beast. That way you are able to easily add more power (by adding another server) if the load increases and you only lose a percentage of your total available power if you lose one server due to software or hardware malfunction. Moreover it’s always cheaper to buy a standard server than a huge multiprocessor multiGB memory mountain.
You should split your ldap servers into two main categories: Write Masters and Read-Only Replicas. Write masters should be the only ones serving write requests and complex reads while read-only replicas should service read requests from other application servers (mail, radius, web servers). The main difference between these two categories is in the type of requests that they will service. More specifically:
\* Write Masters should service write requests and search requests that usually return multiple entries (substring queries and others). Clients for write masters should be applications like:
o User Administration Interface
o End users performing people searches through application like email readers (which usually support searching a directory for user emails).
o Applications that perform complex and time consuming queries. For instance dynamic mailing lists which use ldap searches to create their member list on every email sent.
\* Read-only replicas should service queries that usually only return a single entry. This mostly includes user authentication for various services (web access, radius, etc.) and email routing. One very important characteristic of such services is that only a small percentage of the total user population actually use them each day. For example you might have 1,000,000 users with email access but you will soon find out that only a small percentage (lower than 50%) actually use it each day. Even smaller percentage use services like dialup access, web access and others.
Splitting your traffic like this allows you to create different requirements on your server hardware. Write Masters usually need to perform a lot of disk activity since they service write requests and complex searches (which requires heavy indexing) and they also require large enough cache memory sizes in order to be able to find most of the requested entries on memory. In most cases, almost all of the user entries available in your directory will have to be searched upon at least once per day. On the other hand, read-only replicas only have to service a small percentage of the total user population per day. Not only that, but the active user population tends to be steady and change very slowly so the users you serviced yesterday will most likely be the same today as well. As a result your cache memory need only be a small percentage of the total user population yet it will still achieve excellent cache hit ratios.
So to sum it up your Master and Read-Only replica hardware specification should adhere to something like the following:
\* Masters should have fast disks (in order to handle high volumes of disk traffic), RAID security (the cost of losing the master is greater than losing a read-only replica) and large enough memory to keep at least 70-80% of the database on memory. For example if you ‘re expecting 1,000,000 users use at least 4-8GB of fast memory on your masters. Strong CPU (dual processor machine) is also important since you have to perform tasks like referential integrity, attribute uniqueness and schema checking on the masters whist you can omit them on the read-only replicas.
\* Read-only replicas don’t need to be as large as the masters nor even use RAID disk security. Memory requirements are much lower as well. Depending on your application usage you might just need to hold 20-50% of your database on memory and still achieve >90% cache hit ratio. So if you are expecting 1,000,000 users 2-4GB of memory should be enough. As for CPU make sure you have enough power so that it never get’s to more than 30-40% usage (if you get a nice cache hit ratio CPU usage should stay at a minimum). This is necessary so that you can afford to lose one read-only replica without downgrading the whole ldap service performance. Lastly, there’s no need for heavy indexing like in the master servers. Since most queries will invlove user authentication and mail routing you can usually get away with just creating equality indexes on uid,mail and mailalternateaddress.
[Read more...](http://novelledirectory.blogspot.com/2009/01/ldap-vs-relational-database.html) 
At [9:56 AM](http://novelledirectory.blogspot.com/2009/01/ldap-vs-relational-database.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=3545245826817082394)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=3545245826817082394)
Labels: [LDAP](http://novelledirectory.blogspot.com/search/label/LDAP) 

 

### [LDAP RFC](http://novelledirectory.blogspot.com/2009/01/ldap-rfc.html) 

http://www.ietf.org/rfc/rfc2251.txt
http://www.alvestrand.no/objectid/1.3.6.1.4.1.1466.115.121.1.html

[Read more...](http://novelledirectory.blogspot.com/2009/01/ldap-rfc.html) 
At [9:54 AM](http://novelledirectory.blogspot.com/2009/01/ldap-rfc.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=2248419649222829162)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=2248419649222829162)
Labels: [LDAP](http://novelledirectory.blogspot.com/search/label/LDAP) 

 

### [ndstrace commnd options](http://novelledirectory.blogspot.com/2009/01/ndstrace-commnd-options.html) 

To find the modules that are loaded, use:
bash# ndstrace -c "modules"
To load a module
bash# ndstrace -c "load ndsclone"
To unload a module
bash# ndstrace -c "unload ndsclone"
To display current connections, use:
bash# ndstrace -c connections
To display current threads, use:
bash# ndstrace -c threads
http://www.novell.com/coolsolutions/feature/14899.html

[Read more...](http://novelledirectory.blogspot.com/2009/01/ndstrace-commnd-options.html) 
At [9:52 AM](http://novelledirectory.blogspot.com/2009/01/ndstrace-commnd-options.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=3358620484030578913)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=3358620484030578913)
Labels: [eDirectory](http://novelledirectory.blogspot.com/search/label/eDirectory) 

 

### [Novell eDirectory Health Check](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-check.html) 

Repair local database
ndsrepair -R
Repair and synch all replicas in a partition
ndsrepair -P
Check the health of the server
ndscheck -a admin.services -w novell123

[Read more...](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-check.html) 
At [9:51 AM](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-health-check.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=2726317941811189547)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=2726317941811189547)
Labels: [eDirectory](http://novelledirectory.blogspot.com/search/label/eDirectory) 

 

### [ICE Command to export into LDIF](http://novelledirectory.blogspot.com/2009/01/ice-command-to-export-into-ldif.html) 

ice -lice.log -v -SLDAP -s10.48.60.226 -p389 -dcn=admin,o=services -w\*\*\*\*\*\*\*\*\* -bschema=aigAPPlatform,schema=objectClasses,cn=schema -csub -Fobjectclass=\* -DLDIF -fexport.ldf

[Read more...](http://novelledirectory.blogspot.com/2009/01/ice-command-to-export-into-ldif.html) 
At [9:50 AM](http://novelledirectory.blogspot.com/2009/01/ice-command-to-export-into-ldif.html)  [, 1 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=1128829200841801142)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=1128829200841801142)
Labels: [LDAP](http://novelledirectory.blogspot.com/search/label/LDAP) 

 

### [Verifying LDAP calls in ndstrace](http://novelledirectory.blogspot.com/2009/01/verifying-ldap-calls-in-ndstrace.html) 

ndstraceset dstrace=nodebugdstrace +time +tags +ldap +init +pkiidstrace onload nldapdstrace offexit

[Read more...](http://novelledirectory.blogspot.com/2009/01/verifying-ldap-calls-in-ndstrace.html) 
At [9:49 AM](http://novelledirectory.blogspot.com/2009/01/verifying-ldap-calls-in-ndstrace.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=4377466488877309962)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=4377466488877309962)
Labels: [LDAP](http://novelledirectory.blogspot.com/search/label/LDAP) 

 

### [How to verify ndsd process using netstat](http://novelledirectory.blogspot.com/2009/01/how-to-verify-ndsd-process-using.html) 

netstat -anp | grep 'LISTEN ' | grep ndsd
tcp        0      0 0.0.0.0:389                 0.0.0.0:\*                   LISTEN      816/ndsd
tcp        0      0 206.200.97.51:524           0.0.0.0:\*                   LISTEN      816/ndsd
tcp        0      0 127.0.0.1:524               0.0.0.0:\*                   LISTEN      816/ndsd
tcp        0      0 206.200.97.51:8028          0.0.0.0:\*                   LISTEN      816/ndsd
tcp        0      0 206.200.97.51:8030          0.0.0.0:\*                   LISTEN      816/ndsd
[Read more...](http://novelledirectory.blogspot.com/2009/01/how-to-verify-ndsd-process-using.html) 
At [9:48 AM](http://novelledirectory.blogspot.com/2009/01/how-to-verify-ndsd-process-using.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=3311036315157480379)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=3311036315157480379)
Labels: [eDirectory](http://novelledirectory.blogspot.com/search/label/eDirectory) 

 

### [Novell eDirectory Verifying loading and unloading ldap](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-verifying-loading-and.html) 

To load ldap use the below command
/opt/novell/eDirectory/sbin/nldap -l
Module nldap already loaded
To unload ldap
/opt/novell/eDirectory/sbin/nldap -u

[Read more...](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-verifying-loading-and.html) 
At [9:44 AM](http://novelledirectory.blogspot.com/2009/01/novell-edirectory-verifying-loading-and.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=5284988468657902130)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=5284988468657902130)
Labels: [LDAP](http://novelledirectory.blogspot.com/search/label/LDAP) 

 

### [Novell Brainshare Links](http://novelledirectory.blogspot.com/2009/01/novell-brainshare-links.html) 

https://www.novellbrainshare.com/slc2008/scheduler/controller/catalog
http://translate.google.com/translate?hl=en&sl=sv&u=http://www.disa.nu/%3Fq%3Dnode/237&sa=X&oi=translate&resnum=3&ct=result&prev=/search%3Fq%3Dbrainshare%2B2008%2B%2Blinux%2BBOF225%26hl%3Den%26rls%3Dcom.microsoft:en-US%26sa%3DG

[Read more...](http://novelledirectory.blogspot.com/2009/01/novell-brainshare-links.html) 
At [9:43 AM](http://novelledirectory.blogspot.com/2009/01/novell-brainshare-links.html)  [, 0 comments](https://www.blogger.com/comment.g?blogID=1096363795235620178&amp;postID=5400524556304914733)   [![[./_resources/Novell_eDirectory_Server_January_2009.resources/icon18_edit_allbkg.gif]]](http://www.blogger.com/post-edit.g?blogID=1096363795235620178&amp;postID=5400524556304914733)
Labels: [Novell Brainshare](http://novelledirectory.blogspot.com/search/label/Novell%20Brainshare) 

 <http://novelledirectory.blogspot.com/search?updated-max=2009-06-29T23%3A55%3A00-07%3A00&amp;max-results=4&amp;reverse-paginate=true>[Home](http://novelledirectory.blogspot.com/) 
Subscribe to: [Posts (Atom)](http://novelledirectory.blogspot.com/feeds/posts/default)
