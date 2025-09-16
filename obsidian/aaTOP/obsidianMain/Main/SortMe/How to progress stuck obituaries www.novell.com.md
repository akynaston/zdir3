---
tags: ["#edirtrouble"]
---
# How to progress stuck obituaries [www.novell.com]

# \-How to progress stuck obituaries

This document **(7002659)** _is provided subject to the [disclaimer](http://www.novell.com/support/#disclaimer) at the end of this document._

### Environment

Novell Directory Services 6
Novell Directory Services 7
Novell Directory Services 8
Novell eDirectory 8.8 for All Platforms
Novell eDirectory 8.7.3 for All Platforms
Novell eDirectory 8.7.1 for All Platforms
Novell eDirectory 8.7 for All Platforms
Novell eDirectory 8.6 for All Platforms
Novell eDirectory 8.5 for All Platforms

### Situation

How to progress the stuck obituary

Obituaries remain/are stuck and seem not to progress.

### Resolution

In order to troubleshoot stuck obituaries a few things need to be clear:
1 -  Time needs to be in sync
Below an example of a timesync report
Time synchronization and server status information
Start:  Wednesday, October 15, 2008 11:04:48 Local Time
\---------------------------+---------+---------+-----------+--------+-------
                              DS      Replica   Time        Time is     Time
Server name                 Version   Depth     Source      in sync      +/-
\---------------------------+---------+---------+-----------+--------+-------
Processing server: .doublevision.servers.novell
.doublevision.servers....   20216.62    0       Non-NetWare Yes            0
Processing server: .sled-vh1.servers.novell
.sled-vh1.servers.novell    20216.62    0       Non-NetWare Yes          + 1
Processing server: .linx-vh1.servers.novell
.linx-vh1.servers.novell    20216.62    0       Non-NetWare Yes            0
\---------------------------+---------+---------+-----------+--------+-------
      Total errors: 0
To know that timesync is ok look at the "time is in sync" and the "Time +/-" columns.
They should indicate a "yes" and the time difference should be no more than -2 or +2 (these are indicating seconds)
Other useful information found here are the eDirectory Versions "DS Version" which should match or match closely as large eDirectory version differences can cause obituary problems. (older, now unsupported, eDirectory versions handled obituaries not as well than current versions)
2 - Obituaries are processed by partition and only by the server holding the master replica
Troubleshooting obituaries needs to be done on a per partition basis.
The server that is in control of the obituary process is the server that holds the master replica for the partition.
The only exception here is for USED\_BY obituaries which could potentially be handled by any replica server (except for servers holding a subordinate reference).
(The latest eDirectory versions handle obituaries better than the old versions, if you have old versions you may need to restart nds on the replica servers in the replica ring to get the USED\_BY progressed)

3 - Report sync status needs to be error-free
Below an example of a Report Synchronization status.
Collecting replica synchronization status
Start:  Wednesday, October 15, 2008 13:35:11 Local Time
Retrieve replica status
Partition: .\[Root\].
  Replica on server: .doublevision.servers.novell
  Replica: .doublevision.servers.novell    10-15-2008 13:34:21
  Replica on server: .sled-vh1.servers.novell
  Replica: .sled-vh1.servers.novell        10-15-2008 13:34:22
  Replica on server: .linx-vh1.servers.novell
  Replica: .linx-vh1.servers.novell        10-15-2008 13:34:21
All servers synchronized up to time:         10-15-2008 13:34:21
Finish:  Wednesday, October 15, 2008 13:35:11 Local Time
      Total errors: 0
For the partition that is being checked, total number of errors must be 0
If errors are listed it means that the synchronization process cannot finish, which means that no obituary processing can take place.
Obituary processing can only start if the synchronization process has successfully finished without errors.
(in a dstrace an "all processed = Yes" is visible for the partition if synchronization for that partition is successfull)
4 - All servers in the replica ring must show sync'ed up within one hour from current time
The start time can be seen at the beginning of the log. Compare the start time to the time indicated for each replica.
If a server is not listed to have errors but for example has a time listed far more than 1 hour or even days ago it may need a restart of eDirectory. (on Linux, as root, type rcndsd restart.  On netware unload ds and load ds. On windows stop ds.dlm and start it again. On Solaris type /etc/init.d/ndsd stop and /etc/init.d/ndsd start)
5 - All servers in the Tree must be reachable, up and running
Any Server in the Tree could potentially need to be contacted for the obituary process.
Reason for this is that when a client logs into a server and requests information for a particular object the server does not have a replica for, the server will look up (treewalk) the information on a server that does have the replica, and create an external reference object in it's own database.
The external reference is basically an empty object that points to the server that has the real object, so next time the information is requested the external reference object holds a pointer to the server that needs to be contacted for the information and no treewalking will be needed.
The external reference object will also cause a backlink attribute to be created on the object itself on the replica to keep track of servers that know about the object.
When the object is moved or deleted the backlink attribute is used to make sure servers that do not have a replica will also know what to do with the external reference object. This is done by the obituary process.
6 - Gather the external reference log using dsrepair/ndsrepair
Netware: Load dsrepair -a ->advanced options menu ->check external references
         The dsrepair.log will be located in sys:\\system\\
Windows: From ndscons load the dsrepair.dlm with "-a" in the startup parameter line -> Repair ->Check External References
         The dsrepair.log will be located in c:\\Novell\\NDS\\DIBFiles\\
Linux:   as root type:ndsrepair -C -Ad -A
         The default location for ndsrepair.log will be in /var/opt/novell/eDirectory/log/
          (if the default is not used the n4u.server.vardir variable will show the location if you type: ndsconfig get)
7 - Checking what partition(s) should be looked at
Below is a piece of an external reference log.
The line that starts with "Found obituary" indicates what object has got the obituary, in
this case it's CN=upuser.OU=test.O=novell.T=NOVELLWS
Looking at the path should reveal what partition this object would belong to.
For example if ou=test is a partition CN=upuser would belong to that partition.
 (1) Found obituary for: EID: 0000a798, DN: CN=upuser.OU=test.O=novell.T=NOVELLWS
        Value CTS : 10-21-2008 11:56:38  R = 0001  E = 0001
        Value MTS = 10-21-2008 11:56:38  R = 0001  E = 0001,  Type = 0001 DEAD,
        Flags = 0000
8 - Checking backlink obituaries for problems
Below is an example of a external reference log.
A backlink obituary can be identified by the following :"Type = 0006 BACKLINK"
If backlink obituaries are the cause for the obituaries not progressing it is likey the same can be seen as in our example below.
The Flags are the steps through which the process needs to go (0000, 0001, 0002 and 0004)
Check the backlink obituaries that belong to the same object (tip look for same EID number) and find one that is a step behind (flags = )compared to the other backlink obituaries, it is possible that that one can not be contacted or is not correctly backlinked.
Find the server that belongs to that backlink obituary from the log.  It will be listed just below.
In this example we see that there is one backlink obituary that is still at flags = 0000 while the other backlink obituary is already at flags = 0001
We can see in the example that the baclink obituary that is not going forward points to server CN=doublevision.OU=servers.O=novell.T=NOVELLWS
Possible causes are :
       1) The server is physically no longer in use  (fix: remove it's NCP Serverobject and this will clean up the backlinks that point to that server)
       2) The server is experiencing a problem and may need a restart of eDirectory or even the server itself
       3) The backlink is no longer valid on the server that has the external reference object (eg. may be pointing to wrong server)
          In this case a "-xk3" repair would be required on the server that holds the external reference object in order for it to verify and correct any wrong backlinks it may have.
          Netware: Load dsrepair -XK3 ->Advanced options menu ->Repair Local DS database -> F10 to start the repair
                   When done on the console type: set dstrace=\*b to start the backlink process (give it some time to finish)
          Linux: as root type: ndsrepair -R -Ad -XK3
                 When done type: ndstrace
                 A screen appears and in this you can type "set dstrace=\*b"
                 To exit type "exit" (give it some time to finish)
          Windows: From ndscons load the dsrepair.dlm with "-xk3" in the startup parameter line -> Repair -> Local Database Repair... click repair.
                   When done from ndscons highlight the ds.dlm and click on configure -> Triggers -> backlinker
                   (give it some time to finish)
Example:
Repair utility for Novell eDirectory 8.8 - 8.8 SP2 v20213.08
DS Version 20216.62  Tree name: NOVELLWS
Server name: .linx-vh1.servers.novell
Size of /var/opt/novell/eDirectory/log/ndsrepair.log = 34420 bytes.
Preparing Log File "/var/opt/novell/eDirectory/log/ndsrepair.log"
Please Wait...
External Reference Check
External Reference Check
Start:  Tuesday, October 21, 2008 11:58:38 Local Time
 (1) Found obituary for: EID: 0000a798, DN: CN=upuser.OU=test.O=novell.T=NOVELLWS
        Value CTS : 10-21-2008 11:56:38  R = 0001  E = 0001
        Value MTS = 10-21-2008 11:56:38  R = 0001  E = 0001,  Type = 0001 DEAD,
        Flags = 0000
 (2) Found obituary for: EID: 0000a798, DN: CN=upuser.OU=test.O=novell.T=NOVELLWS
        Value CTS : 10-21-2008 11:56:38  R = 0001  E = 0002
        Value MTS = 10-21-2008 11:57:57  R = 0001  E = 0003,  Type = 0006 BACKLINK,
        Flags = 0001
        NOTIFIED
        Backlink: Type = 00000001 DEAD, RemoteID = ffffffff,
                  ServerID = 00008043, CN=sled-vh1.OU=servers.O=novell.T=NOVELLWS
 (3) Found obituary for: EID: 0000a798, DN: CN=upuser.OU=test.O=novell.T=NOVELLWS
        Value CTS : 10-21-2008 11:56:38  R = 0001  E = 0003
        Value MTS = 10-21-2008 11:57:57  R = 0001  E = 0004,  Type = 0006 BACKLINK,
        Flags = 0000
        Backlink: Type = 00000001 DEAD, RemoteID = ffffffff,
                  ServerID = 0000807d, CN=doublevision.OU=servers.O=novell.T=NOVELLWS
 (4) Found obituary for: EID: 0000a798, DN: CN=upuser.OU=test.O=novell.T=NOVELLWS
        Value CTS : 10-21-2008 11:56:38  R = 0001  E = 0004
        Value MTS = 10-21-2008 11:57:57  R = 0002  E = 0001,  Type = 000c USED\_BY,
        Flags = 0002
        OK\_TO\_PURGE
  Used by: Resource type = 00000000, Event type = 00000003, Resource ID = 00008026, T=NOVELLWS
Checked 0 external references
Found: 4 total obituaries in this DIB,
        2 Unprocessed obits, 0 Purgeable obits,
        1 OK\_To\_Purge obits, 1 Notified obits
      Total errors: 0
NDSRepair process completed.
9 - Inhibit\_move obituaries and how to get them progressed
First the explanation:
When any object is moved from one location to another in the database (for example from ou=accounting.o=novell to ou=users.novell) the "old" location of the object will get a MOVED obituary and the "new" location will receive a INHIBIT\_MOVE obituary.
The obituary process will take place just as it would with deleting an object, however if the new location is in a different partition it may need to contact another server to negociate the process.
(the server holding the master replica for a partition needs to do this and if you have 2 partitions involved there may be 2 different servers needed to progress the obits.)
In this process we sometimes see that the MOVED obituary is processed just fine along with it's backlink obituaries but the INHIBIT\_MOVE obituary is not progressed and remains at flags = 0000
We call this an "orphaned INHIBIT\_MOVE" obituary
Before we think about any fix we need to verify if this is truely the case and need to check all servers that hold master replica's for any MOVED obituary to make sure we are not breaking our system when we try and fix this.
Once we have verified and are satisfied that no MOVED obituary exists anywhere for the object that has the INHIBIT\_MOVE obituary we can proceed with the fix.
The fix is: TID 3908200
p.s. If the object not only holds a INHIBIT\_MOVE but also a DEAD obituary you will need to contact Novell Technical Support
10 - master server is clean but obituaries are still seen on servers that have a read/write
If this document is followed and no more obituaries are seen when checking the server holding the master replica it may still be possible that one or more of the servers holding a read/write replica still show obituaries for the partition that is worked on.
To get these progressed you will need to make one of these read/write replica servers the master for the partition.
Preferred would be the server that holds the read/write that shows the most obituaries.
In many cases it is seen that some of these obituaries will soon start to disappear.
If obituaries are still seen after an hour you may want to provide these obituaries with a fresh timestamp in order for the Master to start progressing them.
You can do this by running a -OT repair:
          Netware: Load dsrepair -OT ->Advanced options menu ->Repair Local DS database -> F10 to start the repair
          Linux: as root type: ndsrepair -R -Ad -OT
          Windows: From ndscons load the dsrepair.dlm with "-OT" in the startup parameter line -> Repair -> Local Database Repair... click repair.
follow step 10 until all replicas are clean and do not show  the obituaries.
(Warning: Never designate a Subordinate Reference to be a Master or it will destroy all objects in that partition)

11 - Servers that have no replica of the partition but show obituaries for objects in that partition.
Likely at some point the server held a read/write replica and the obituaries are still present on the objects that have now become External Reference objects.
Fix for this is to run a "-XK3" repair, how to do this is explained at the end of step 8
12  -618 error in synchronization caused by Object with Obituary
Example:
 (1)  Found obituary for: EID: 0001471c, DN: CN=problemobject.OU=users.O=Novell.T=TestTree
    Value CTS : 04-26-2011 16:37:08  R = 0002  E = 0061
    Value MTS = 06-15-2011 11:37:36  R = 0003  E = 001b,  Type = 0002 MOVED,
    Flags = 0004
    PURGEABLE
    MoveObit: destID = 00013af7, Could not read Name
The "Could not read Name" indicates that the new location for the object no longer is in the database and thus the link is bad (-618)
fix: ndsrepair -J 0001471c -Ad -SW "Obituary"
It should repair the single object (-J) EIDoftheObject .. in advanced mode (-Ad) and check the referrals of the Obituary attribute(-SW "Obituary")
This may be a problem on more than one replica server so check each server for this issue.

[![[./_resources/How_to_progress_stuck_obituaries_www.novell.com.resources/unknown_filename.gif]]](http://www.youtube.com/watch?v=lKVelISwyIk)

[+ Advanced eDirectory Troubleshooting](http://www.youtube.com/watch?v=lKVelISwyIk)

### Document

|     |     |
| --- | --- |
| **Document ID:** | 7002659 |
| **Creation Date:** | 02-16-2009 |
| **Modified Date:** | 06-15-2011 |
| **Novell Product:** | eDirectory |
| **Novell Product:** | NetWare |
| **Novell Product:** | Open Enterprise Server |

### Disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information.
Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.
