10/14/2024 4:28:08 PM

Status and next steps I am taking:  
We have 4 servers in the tree again, all but dir2 hold a replica. Steps to do:  
1 - Get new root passwords for dir1/dir2
2 - Enable public key auth between dir4 and other servers.
3 - Confirm all 4 servers have a replica (just dir2 fix . .).  
4 - Enable auto backups on the new dir1/dir2 servers.  
5 - Send paths to Huston for copying off backups to (offsite?) storage.  
6 - Move master and CA to Dir1.  
7 - Notify Huston work is complete.

10/17/2024 5:30:58 PM
Latest status:
I've done all of the items I can think of, and noted below - did you say you wanted dir 4 removed? I don't know if we talked about the final picture of what you had in mind for the tree. What's next?


Complete:  - Get new root passwords for dir1/dir2
(stopped now -don't have new passwords
Complete:  - Confirm all 4 servers have a replica (just dir2 fix . .).  
Complete: Enable auto backups on the new dir1/dir2 servers.  
Complete: moved all backups to use our new edirbackup_svc.accounts.services user.
Complete: moved the CA to dir1.
Complete: moved the master replica to dir1.
Complete: notify Huston all work is done.
 
 Note: Paths for the backups are /root/edirbackups on dir1 and dir2, just like on previous backups for dir3 and dir4.
