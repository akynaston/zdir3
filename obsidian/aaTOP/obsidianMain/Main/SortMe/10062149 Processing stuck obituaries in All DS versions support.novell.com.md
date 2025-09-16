# 10062149: Processing stuck obituaries in All DS versions [support.novell.com]

# Processing stuck obituaries in All DS versions

## (Last modified: 24Jul2005)

This document (**10062149**) _is provided subject to the [disclaimer](http://support.novell.com/docs/Tids/Solutions/#disclaimer) at the end of this document._

### fact

Novell eDirectory

Novell Directory Services

Getting an All Process=YES for partition synchronization

Time is in Sync

All real copies (meaning Master, Read/Writes, Read-only's) see the same obituaries in Check External References.

Followed [TID #10060600 - NDS Health Check Procedures - Cross Platform](http://support.novell.com/docs/Tids/Solutions/10060600.html) and Directory Services looks healthy except for the stuck obituaries.

### symptom

Inhibit move obituary is orphaned.

Obituaries not processing

Processing stuck obituaries on All DS versions

Using DSREPAIR -OT

### fact

Also see TID: 10064117 - The Guide to eDirectory Obituary Troubleshooting

### fix

Before troubleshooting obituaries, do the following:
Novell recommends the following patches, or higher:
1.  All NetWare 6.0 servers have Support Pack 3 applied
2\.  All NetWare 5.1 servers have Support Pack 6 applied.
3.  All NetWare 5.0 servers have Support Pack 6a with wsock4g.exe applied.
4.  All NetWare 4.2 servers have Support Pack 9 with DS621.EXE
Patching to the Support Packs listed above on all NetWare versions will have the necessary DSREPAIR versions for the steps listed below. 
To download the DSREPAIR versions individually, you can download and extract DSREPAIR from the following patches at  <http://support.novell.com/filefinder/> 
NetWare 4.2 -                             DSREPAIR Version 4.73a from DS621.EXE
NetWare 5.x NDS 7.xx -             DSREPAIR Version 5.30a from DS762b.EXE  
Net Ware 5.x NDS 8.xx -            DSREPAIR Version 10250.40 from EDIR862SP5FP1.EXE

Net Ware 5.x NDS /85.xx -        DSREPAIR Version 10250.40 from  EDIR862SP5FP1.EXE
NetWare 5.1/6 NDS 8.6.2 -        DSREPAIR Version 10250.40 from EDIR862SP5FP1.EXE
DSREPAIRS  listed above have the -OT switch that is used for troubleshooting obituaries.  All future releases of DSREPAIR will have this functionality built in as well.
Another key factor in getting obituaries to process is communication. Obituaries CANNOT process when a server is down or not in sync.  In an IP environment, SLP needs to be set up and configured correctly.
If the above items are in place and the obituaries are still not making progress, then unload the DS.NLM and reload it.  A repair with the -OT switch after re-loading the DS.NLM should time stamp the obituaries and get things moving.

NOTE: If substantial errors exist during a NDS Health Check Procedure, do not continue with the following solutions until you have first fixed the errors regarding NDS synchronization. The tree must be healthy for the background processes to run. You must have an all processed = Yes on all partitions not just the partition you are working with.

Run this process on the master server to begin with. (The master of the partition that is having obituary problems.)  If this process works on clearing the obituaries for the master server and not the others, a Read/Write or Read-Only can be designated as the master and then run the same process on it, or after cleaning up the Master, you can remove R/W's and add them back. The removal/addition of Replicas if the Master is clean should clean up the R/W.
1\.  LOAD DSREPAIR -RC (a dump file will be created). You can also create the dump files manually with Dsrepair | Advanced Options | Create Database Dump File ( for DS7.x and 6.x), NDS Archive (for eDir). It will provide the option to create the file with a 3 letter extension if the file/backup has not been created on that server before. If a backup has been created before, it will provide the option to rewrite the file with the latest backup.

1a. For each obituary, check which do not exist on a server holding the master replica of that object. Timestamp those obituaries using DSREPAIR -OT

1b. For remaining obituaries, move the master of that partition to the server holding the most obituaries for that partition.

2\.  LOAD DSREPAIR -XK3 | Advanced options menu | Repair local DS database.  Change "check local references"  to YES  (The other defaults should be fine.)   Press F10 to run the repair then exit out of DSREPAIR.  (This option should only be used to after all obituaries on real objects have been processed. This repair should be run on all servers hosting subordinate replicas participating on the replica ring.)
3.   Run the following SET DSTRACE commands,
SET DSTRACE=NODEBUG
SET DSTRACE=OFF
SET DSTRACE=ON
SET DSTRACE=+BLINK
SET DSTRACE=\*B
Toggle over to the Directory Services Screen and wait for it to say "Finished Checking Backlinks Succeeded."
4.   Run the following SET DSTRACE commands
SET DSTRACE=+S
SET DSTRACE=\*U
SET DSTRACE=\*H
SET DSTRACE=+J
SET DSTRACE=\*J
SET DSTRACE=\*F
Toggle to the Directory Services Screen and wait for about five minutes.
5\.   LOAD DSREPAIR -A |  Advanced Options Menu | Check external references and see if the obituaries have cleared or have started clearing (Flags are advancing from 0000 to 0001 to 0002, etc.).  If they have cleared, go to a Read/Write, designate it to be a master and then do the above again.  If they have started clearing (the flags are incrementing/changing) then give it some time.  
6\.  LOAD DSREPAIR -OT     (that is the letter O and NOT the number 0). This should be done on the master of the partition containing the obituaries. Load DSREPAIR -OT | Advanced Options Menu| Repair local  DS database and select YES to check local references.    After the repair is done, select YES to save the repaired local database and run the same options multiple times to lower the number of errors.  Save and exit out of DSREPAIR.  For Linux or Unix use iMonitor, go to the repair option (example <https://10.0.0.11:8009/nds/dsrepair>) click on the advanced button and place the -OT switch there.  Then run the repair.
7.  Unload ds.nlm, give it some time to release all dependencies and load DS again. Users may be affected by bouncing DS, however the client should auto reconnect.
8\.  Run the following SET DSTRACE commands on server holding the Master replica
SET DSTRACE=NODEBUG
SET DSTRACE=OFF
SET DSTRACE=ON
SET DSTRACE=+J
SET DSTRACE=+S
SET DSTRACE=\*U
SET DSTRACE=\*H
SET DSTRACE=\*F
SET DSTRACE=\*J
Toggle over to the Directory Services Screen and wait for about five minutes.
9\.  LOAD DSREPAIR -A | Advanced Options Menu | Check external references and see if the obituaries have cleared or have started clearing.  If they have cleared, go to a Read/Write, designate it to be a master and then do the above again.  If they have started clearing then give it some time.
NOTE:  This should also help process the TYPE C obituaries that seems to take an additional amount of time to process.

### document

|     |     |
| --- | --- |
| **Document Title:** | Processing stuck obituaries in All DS versions |
| **Document ID:** | 10062149 |
| **Solution ID:** | NOVL46849 |
| **Creation Date:** | 30Apr2001 |
| **Modified Date:** | 24Jul2005 |
| **Novell Product Class:** | Beta<br>End of Life<br>Groupware<br>NetWare<br>Novell eDirectory |

### disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information.
Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.
