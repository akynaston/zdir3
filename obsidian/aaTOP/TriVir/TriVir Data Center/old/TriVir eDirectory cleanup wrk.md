10/9/2024 11:40:40 AM
Starting new notes file to 

9/27/2024 4:07:56 PM - 
LATEST WORK:
When we can schedule it, 
 - Decomission 1 and 2
 - Clean up obits
 - Huston install new Dir1
 - move CA to dir1
 - Then look at moving dir4
 

dir4: RHEL 9.1 (Plow)
dir3: SUSE 12 sp2



10/9/2024 11:47:21 AM
reviewing status:
All 4 servers in tree, dir2 reporting as 'down'.
dir4 shows 1,3,4 all having at least a read-write of the single root partition.


10/9/2024 1:24:04 PM
Sent to Huston just now:
Trivir tree update: Here's the approach I'm taking on our eDir tree right now. I will send updates as I have them:  
1 - Clean up obituaries: Safest way to approach when replication is completely clean.  
2 - Remove dir2 from the tree:  
    * Delete all dir2 related server objects from the tree  
    * Then 'ndsconfig rm' to remove the instance of eDir from dir2.  
3 - Notify Huston to install new eDirectory server, 'Dir1'.

 - Can't cleanup obiturariies if any server is down.
 - Can't hit dir2 . . know_hosts key was different . . realizing I should just remove anyway to clear obituaries.
All objects I'm deleting:

![[Pasted image 20241009133848.png]]10/9/2024 1:44:06 PM
done - dir2 is gone - now fixing timesync issues -

dir4 timesync issues:
![[Pasted image 20241009134647.png]]



dir 3 timesync issues:

![[Pasted image 20241009134606.png]]

dir1
![[Pasted image 20241009134746.png]]

10/9/2024 1:58:30 PM
copied /etc/ntp.conf to ntp.conf.old, then went into yast, confirmed my manual change to 10.10.10.24 for time, and restarted ntp . .waiting for sync; maybe in 5 mins?

stoped: dir3 appears to be using ntp, but server is 10.10.30.1 . .and I can't hit it, nor get ntp fixes there.

I


10/10/2024 3:39:33 PM
Status:
 - Stuck obituaries have been removed.
 - Time sync has been fixed between the remaining server, using 10.20.4.1
 - Dir2 has been removed from the tree.
 - We still have dir1, dir3, and dir4 where dir4 is the master of the root partition
 - You asked me to tell you when we're read to install a new 'Dir1' server; we are there now.

1 - Done: remove stuck obituaries
2 - Done: Remove dir2 from the tree - BTW: I cannot ssh to dir2, the root password seems incorrect . . I don't plan on running ndsconfig rm on that server unless you'd like me to clean it off.
3 - Notify Huston to install new eDirectory server, 'Dir1'.


10/11/2024 2:24:25 PM
Huston asked me to remove dir1 - it indeed is SLES12 SP2.
 - imanager: deleted root partition off of dir1
 - now deleting dir1 objects from the tree.
 - Confirmed dir3 has the ca right now
 - installed cert server to confirm
 - need to restart imanager . .
 - ran ndsconfig rm on dir1, it seemed t have cleared out the server object, deleting other objects.
 deleting these:
![[Pasted image 20241011143417.png]]

10/11/2024 3:16:54 PM
Huston: do we do 9.2.7?
Aaron: 9.2.8 does add readhat 9.1 . . but huston sais we're on 94 . .
eDir 9.2.9 is out 

10/11/2024 3:28:01 PM
9.2.9 uploaded, systemr equiremetns:
https://www.netiq.com/documentation/edirectory-92/edir_install/?page=/documentation/edirectory-92/edir_install/data/a79kg0t.html
copied to: N:\software\products\NetIQ\eDirectory\9.2.9
![[Pasted image 20241011152948.png]]