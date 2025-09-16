---
tags: ["#edir","#linux"]
---
# Removing a Linux server from the tree

# Removing a Linux server from the tree

This document **(7003102)** _is provided subject to the [disclaimer](http://www.novell.com/support/viewContent.do?externalId=7003102&sliceId=1#disclaimer) at the end of this document._

### Environment

Novell eDirectory 8.8 for Linux
Novell eDirectory 8.7.3 for Linux
Open Enterprise Server (Linux based)
SuSE Linux Enterprise Server 9
SuSE Linux Enterprise Server 10

### Situation

Removing a crashed Linux server from the eDirectory tree.

### Resolution

When a server is crashed due to various reasons -
a)Hardware failure
b)eDirectory corruption
c)decommissioning a server. (make sure your user data is backed up)
Warning - In this we remove the server from the tree.
If this crashed server is a print server or a certificate authority server make sure the print services are migrated to another server, and also a new certificate authority server is been created.
1)Make sure time is synchronized.
command  - ndsrepair -T
all servers shown in the time sync screen should show as YES -
(vmware servers or servers on wan link may be shown as not in sync)
2) Verify the partition and the replica type on the crashed server.
this can be checked by going to another replica holding server in the tree and typing the command.
ndsrepair -P -Ad
Select the partition
Option - 10 or view replica ring
It will show a list of all the servers in the replica ring of that partition.
If the crashed server is the master of that particular partition - make sure another server holding a read / write replica of the same partition is made the master.
From the server which is to be promoted as the new master of the partition type the command. 
ndsrepair -P -Ad
Select the partition
Option 5 -or- Designate this server as the new Master Replica.
If the crashed server is the master of that particular partition - and there is no other server holding read / write replica of the same partition and the only other replica type is sub reference - then you have lost all the objects in that particular partition.
WARNING: DO NOT designate a Subordinate Reference replica as the new Master replica unless no R/W or Read Only replica exists of that partition. Doing so will cause all of your partition objects to go unknown and you will have to recreate them manually.
 
Once it is verified that a master replica exists for each partition the crashed server needs to be removed from the replica ring.
Its done by going to another server in the replica ring and typing the command -
ndsrepair -P -Ad
Select the partition
Option - 10 or view replica ring
It will show the list of servers in the replica ring,select the servers that needs to be removed.
Option 6 - Remove this server from the replica ring.
Note - If the crashed server has sub reference type of replicas - make sure you remove the crashed server from the replica ring of the parent partition of that sub reference first.
example - edir.novell "subref "
                  .novell  "read write" parent of edir.novell  
Subrefs are created on the server when the server has a real copy of parent partition and no copy of the immediate child partition.
Verify that each replica ring is consistent and valid
On the servers in the tree - type
ndsrepair -P -Ad
Select the partition
Option - 10 or view replica ring
if the crashed server still exists - select it and go to the option remove server from the replica ring.
 Note - sometimes after removing sub ref from the replica ring it still shows in the replica ring - you would need to manually to remove the crashed server from the replica ring of that particular server.
3\. Cleaning up the Tree - Removing the objects

This is done through Console 1 or iManager.
Browse to the location where the server was installed in the tree.
Delete all objects relating to the server - except the NCP server object.
Once all the objects are deleted - then delete the NCP server object.

4)Generating a Heart beat -

Linux - Execute "ndstrace" from the server command-line. Within the ndstrace utility enter:
SET NDSTRACE=ON (enables file logging to /var/nds/DSTRACE.LOG)
SET NDSTRACE=NODEBUG (turns off all preset filters)
SET NDSTRACE=+SKLK (enables filter of synchronization traffic)
SET NDSTRACE=\*H (initiates synchronization between servers)

5)Final check - 

Make sure in time sync and report sync there are no errors or references pointing to the crashed server.

time sync - ndsrepair -T

report sync -ndsrepair -E

### Additional Information

If server only needs to be removed from the replica ring and not from the tree follow the steps
Step 1,Step2,Step4,Step5
DO NOT Follow Step 3

### Document

|     |     |
| --- | --- |
| **Document ID:** | 7003102 |
| **Creation Date:** | 04-26-2009 |
| **Modified Date:** | 04-29-2009 |
| **Novell Product:** | eDirectory |
| **Novell Product:** | Open Enterprise Server |
| **Novell Product:** | SUSE Linux Enterprise Server |

### Disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information.
Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.
