# Obituaries in Novell eDirectory [support.novell.com]

[![[./_resources/Obituaries_in_Novell_eDirectory_support.novell.com.resources/unknown_filename.png]]](http://www.novell.com/)

* [Skip to Content](http://support.novell.com/techcenter/articles/#top)

		### [Solutions](http://www.novell.com/solutions/)
	
		### [Products](http://www.novell.com/products/)
	
		### [Services & Support](http://www.novell.com/services/)
	
		### [Partners](http://www.novell.com/partners/)
	
		### [Communities](http://www.novell.com/communities/)
	
		### [About Novell](http://www.novell.com/company/)
	
		### [How to Buy](http://www.novell.com/products/howtobuy.html)
	

[**Change**](http://www.novell.com/common/util/langselect.php?referer=http%3A//support.novell.com/techcenter/articles/anp20020401.html) **_United States,_ English**

[**Login**](https://www.novell.com/ICSLogin/?%22http://support.novell.com/techcenter/articles/anp20020401.html%22)

[Close](http://support.novell.com/techcenter/articles/#)

								

# Obituaries in Novell eDirectory

## Articles and Tips: article

* [Printer Friendly](http://www.novell.com/inc/pf/pf.jsp)

Kevin Burnett
Senior Research Engineer
Novell AppNotes

_01 Apr 2002_

Novell eDirectory and earlier versions of Novell Directory Services (NDS) make extensive and sometimes continuous changes to the objects contained in its database. eDirectory has an attribute to track these changes, called the Obituary. eDirectory utilizes the Obituary attribute to identify and control changes that are occurring to an object's identity.

Since eDirectory is a distributed database, each server receives updated information through synchronization. Since all the servers in the replica ring do not receive updates simultaneously, the server may not hold the same information at a given time. As a result, each server holds on to the old information until all the other servers receive the updates. eDirectory uses obituaries to keep track of this type of information and more.

If you are immersed in eDirectory at your company, you have probably heard of the term "stuck Obituary." Simply put, when Obituaries are stuck, eDirectory is not processing them. To better understand what a stuck obituary is, you need to have a reasonable understanding of Obituaries.

#### Obituary Types

The eDirectory engine utilizes 14 different obituary types. The following table lists each type and what they do.

|     |     |     |
| --- | --- | --- |
| **Name** | **Reference Number** | **Description** |
| Restored | 0   | This obituary type (0) designates an object that has been restored from a backup system. |
| Dead | 1   | This obituary type is assigned the reference number 1 to designate that this object is being deleted. |
| Moved | 2   | This obituary type designates an object that is being moved to another name context. Obituary number 2 is assigned to a nonpresent version of the object that exists in the original name context. |
| Inhibit Move | 3   | This obituary type designates an object that has been moved from another name context. Obituary number 3 is assigned to the relocated object in its new name context. |
| Old RDN | 4   | This obituary type designates an object whose Relative Distinguished Name has been changed. Obituary number 4 is assigned to the renamed object that has the new RDN. |
| New RDN | 5   | This obituary type designates an object whose Relative Distinguished Name has been changed. Obituary number 5 is assigned to the nonpresent object that has the original RDN. |
| Backlink | 6   | This obituary type identifies an eDirectoryeDirectory Server which holds either an external reference or a replica of the object. Obituary number 6 is assigned to the object that has been assigned as the primary obituary. |
| Tree Old RDN | 7   | This obituary type designates a partition root object whose Relative Distinguished Name has changed. Obituary number 7 is assigned to the renamed partition root object that has the new RDN. |
| Tree New RDN | 8   | This obituary type designates a partition root object whose Relative Distinguished Name has changed. Obituary number 8 is assigned to the nonpresent object that has the original RDN. |
| Purge All | 9   | NDS uses this obituary type internally to identify an object whose attribute values should be purged. |
| Move Sub-tree | 10  | This obituary type designates a partition root object that is being moved to another name context. Obituary number 10 is assigned to the partition root object that is being moved. |
| Moved From | 11  | This obituary type is used so that if an object has been moved from a different user-created partition, its previous location is known to the NDS. |
| Used By | 12  | This obituary type notifies a user-created partition that points to an external reference. |
| Count | 13  | Novell uses this obituary type internally for test purposes only. |

#### Obituary Classifications

The classification of an obituary determines how it is processed. Currently, there are four classes of obituaries. These classifications are shown in the following table.

|     |     |
| --- | --- |
| **Classification** | **Definitions and Associated Obituaries** |
| **Primary** | Primary Obituaries represent the basic action that is being performed on an object. These obituaries are assigned to an object by an authenticated Client that has the appropriate rights. They are processed by the Replica Purger background process. The obituary types classified as Primary Obituaries are:<br><br>Restored<br><br>Dead<br><br>Moved<br><br>New RDN |
| **Secondary** | Secondary Obituaries represent the eDirectory servers that must be notified of the Primary Obituary action. eDirectory assigns these obituaries to an object and they cannot be assigned by an eDirectory Client. There is one Secondary Obituary for each eDirectory server that holds a replica of the partition that encompasses the object and there is one for each eDirectory server that holds an external reference of the obituary. These obituaries are removed by the Replica Purger background process. The obituary types classified as Secondary Obituaries are:<br><br>Used By<br><br>Backlink |
| **Informational** | Informational Obituaries identify an object whose identity has been changed due to the placement of a Primary Obituary. eDirectory assigns these obituaries to an object and they cannot be assigned by an eDirectory Client. They are removed by the Replica Purger background process. The obituary types classified as Informational Obituaries are:<br><br>Inhibit Move<br><br>Moved From<br><br>Old RDN<br><br>Tree Old RDN |
| **Special Case** | Special Case Obituaries represent partition, or internal, operations that are performed on an eDirectory object. These obituaries are assigned to an object by an authenticated eDirectory Client that has the appropriate rights, or by eDirectory. They are processed by the Replica Purger background process. The obituary types classified as special-case obituaries are:<br><br>Tree New RDN<br><br>Purge All<br><br>Move Sub-Tree |

#### Obituary States

An Obituary may be in one of four different states or stages at any given time. These states indicate how far an Obituary has been processed. These states are listed in the table below.

|     |     |     |
| --- | --- | --- |
| **State** | **Number** | **Description** |
| Issued | 0   | This is the initial state, which is assigned to the obituary when it is issued. |
| Notified | 1   | This state is used on secondary obituaries to indicate that the eDirectory server specified within the obituary has been notified of the Primary Obituary.<br><br>For all other obituary types, this state indicates that the servers specified within the corresponding Secondary Obituaries have been notified of the Primary Obituaries. |
| OK To Purge | 2   | This state is assigned to the obituary to indicate that it has reached the second stage of processing. |
| Purgeable | 4   | This state is used on secondary obituaries to indicate that the eDirectory server specified within the obituary has been notified that the obituary is purgeable.<br><br>For all other obituary types, this state is used to indicate that the servers specified within the corresponding Secondary Obituaries have all been notified that the obituary is purgeable. |

#### Return To Stuck Obituary

Now that we have a basic understanding of what an Obituary is, what it does and how it works, let's get back to the Stuck Obituary problem. A few symptoms of a Stuck Obituary (and certainly not all of the possible symptoms) include:

		Getting the error -637 when trying to do a partition operation.
	
		Getting the error "Previous Move in Progress" when doing a partition operation.
	
		"Check External References" in DSREPAIR has lots of obituaries that are flagged as Purgeable
	

First thing, make sure that you are running the latest version of DS.NLM for the type of NDS/eDirectory that you are running. Check [http://www.novell.com](http://support.novell.com/techcenter/articles/%20javascript:openExternal(&apos;http://www.novell.com&apos;)) Technical Support area to see if there is a newer version of DS.NLM for your NetWare version. If there is, download and install that version before continuing.

Make sure you install this update on all matching server/NDS/eDirectory versions in your Replica Ring. This solution is intended for Purgeable obituaries and/or obituaries that don't seem to be processing normally.

The following steps will hopefully get your Stuck Obituaries processing once again:

1. Using DSRepair, Advanced Options Menu, repair local NDS database with Check Local References and Rebuild Operational Schema set to YES, all other options set to NO.
	
2. Type the following SET commands at the server console prompt: SET DSTRACE = OFF SET DSTRACE = NODEBUG SET DSTRACE = ON SET DSTRACE = +S SET DSTRACE = \*H SET DSTRACE = +J SET DSTRACE = \*J SET DSTRACE = \*F
	
3. Switch over to directory services screen and wait until you see ALL PROCESSED = YES
	
4. Let the synchronization go out, then run Check External References from the Advanced Options Menu again. The obituaries should be purged over the next few minutes. (This may take longer if the server resources are low or if the network is busy with other traffic.)
	
5. Determine what replica or partition the obituaries belong to. The Master replica is in charge of processing obituaries. So if you are seeing stuck obituaries on a server that contains a READ/WRITE (RW) replica, then you may need to designate the RW replica as Master temporarily.
	
	**Note:** If the master replica is on a NetWare 4.11 server, make sure this server can communicate to all other servers in replica ring, and is not getting any -625 type errors)
	
	**Warning:** DO NOT designate a Subordinate Reference as a Master replica as all objects in the replica ring will go to an unknown state and will be lost.
	
6. LOAD DSREPAIR -A on the server you wish to designate as Master, then select Advanced Options, Replica and Partition operations and highlight the partition (LONDON used in this example), and press enter to select.
	
7. Designate this server as the new Master replica. Then press Escape back to the Advanced Options Menu.
	
8. Again, at the console prompt, type the following SET commands: SET DSTRACE = ON SET DSTRACE = \*H
	
	Verify the replica consistency with NDSMANAGER | Partition Continuity.
	
9. Let the synchronization go out, then run Check External References from the Advanced Options Menu again. The obituaries should be purged. If the obituary does _not_ appear when performing the External Reference Check on the server that is holding the Master replica for the partition, but the obituary _does_ appear on a server that is holding a Read-Write copy of the partition, remove the Read-Write replica and then add it back.
	
	**Note:** Use caution when performing this step.
	
10. Verify that the partition is healthy (run DSREPAIR, Report Synchronization Status Report and verify that there are no errors on the problem partition.
	
11. After removing the replica, verify that the removal is complete before trying to add the replica back.
	
12. If there are some obituaries still marked at "Flags = 0000," such as backlinked obituaries, you will want to run DESREPAIR with the -xk3 option on all servers in the tree or on all servers that have ever been part of the affected partition.
	

#### XK3 Procedure

To perform a -xk3 procedure, follow the steps given below.

1. Load DSREPAIR -XK3. Select Advanced Options, Repair Local DS Database. Check Local References = Yes. Press F10 to start the repair process. This procedure goes through all of the server's backlink attribute timestamps and sets them to zero.
	
2. Save the repaired database and exit from the DSREPAIR utility completely.
	
3. Run the backlink process to rebuild the backlinks. To do this, type the following at the server console prompt:
	
	SET DSTRACE=ON SET DSTRACE=NODEBUG SET DSTRACE=+BLINK (+ sign turns DSTRACE on as well) SET DSTRACE=\*B
	
4. This last process will update the timestamps on those objects that are still valid. Those that are not updated are purged with the next successful synchronization of Directory Services.
	

#### Conclusion

Hopefully this article introduced you to Obituaries, what they are, and how they work. Also, I hope that the debugging procedure outlined here will be beneficial in freeing the flow of Stuck Obituaries that may now or someday clog your network.

I have referenced two Novell Technical Support Technical Information Documents (TIDs) in this article. There is a wealth of information about Obituaries, Stuck Obituaries, as well as practically any eDirectory/NDS subject you may have. Check out [http://www.novell.com](http://support.novell.com/techcenter/articles/%20javascript:openExternal(&apos;http://www.novell.com&apos;)) , then click on the Support & Downloads button.

I would like to credit the eDirectory Core Development Team, Novell Education Group, and Novell Technical Support (TIDs #10022791 and #10023339) for providing critical information for this column.

\* _Originally published in Novell AppNotes_

* * *

Disclaimer

The origin of this information may be internal or external to Novell. While Novell makes all reasonable efforts to verify this information, Novell does not make explicit or implied claims to its validity.

[Support Home](http://www.novell.com/support)

[Download  _>_](http://download.novell.com/)

[Help yourself  _>_](http://support.novell.com/support_options.html?tab=1)

[Let us help  _>_](http://support.novell.com/support_options.html)

Contribute  _\>_

[Customer Center](http://www.novell.com/center/)

© 2011 Novell

* [Careers](http://www.novell.com/company/careers/index.html)

* [Legal](http://www.novell.com/company/legal/)

[close](http://support.novell.com/techcenter/articles/#)

* [Feedback](http://www.novell.com/inc/feedback/feedback.html)

* [Print](http://support.novell.com/techcenter/articles/#)
* [800-529-3400](http://www.novell.com/company/contact.html)
* [Request a Call](http://support.novell.com/common/inc/requestcall_overlay.html)
* [Follow Novell](http://support.novell.com/techcenter/articles/#)
[Novell](http://support.novell.com/) Making IT Work As One™
