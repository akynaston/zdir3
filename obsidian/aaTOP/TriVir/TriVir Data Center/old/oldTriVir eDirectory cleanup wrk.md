# Untitled Note

TriVir Backup Servers

**3/1/2019 - Date that the data below was collected**
numbers so far

* Confluence
	* IP: 10.10.30.35
	* Data: 910MB
* Customer experience portal depending on what we end up using
* Database Server
	* IP: 10.10.30.22
	* Data: 1GB
* eDirectory tree / iMan
	* dir1 IP: 10.10.30.27
	* dir2 IP: 10.10.30.28
	* dir3 IP: 10.10.30.29
	* Data: 3 x 42MB
	* Dir: /var/opt/novell/eDirectory/data/dib

* FTP
	* IP: 10.10.40.90
	* Data: 22GB
* GIT
	* IP: 10.10.30.35
	* Data: 850MB
* NAM configuration & environment?
	* IP (console): 10.10.30.33
	* Data: 3MB
* Phone System
	* Utah
		* IP: 10.10.11.2
		* Data: 275MB
	* Virginia
		* IP: 10.10.21.2
		* Data: 200MB
* SMTP
	* IP: 10.10.40.30
	* Data: inconsequential
* SVN
	* IP: 10.10.40.89
	* Directory: /svn
	* Data: 128GB
* Utilization
	* IP: 10.10.30.34
	* Data (/opt): 2.3GB
* Web/WWW
	* What is hosted here:
		* trac, wiki
	* IP: 10.10.30.32
	* Dirs
		* /trac
			* Data: 540MB
		* /www
			* Data: 1.2GB

\-Chris

2/8/2024 3:02:41 PM
Here's the latest TriVir eDirectory tree work I plan on doing:

WAITING: - HUSTON: - starting up dir1 and dir3.
 - dir2: note: 37K mail messages . . if we're going to keep it, si it normal to delete these after seeing if they let us k


DONE - Confirm full tree replication is halthy between all 4 servers.Done - Move CA to dir2.

 - Setup auto backups of edir on dir1, and dir2
 - HUSTON: - Tell Huston to point everything over to dir2.
 - Execute standard server removal of dir3 dir4 from the tree.
 - Incorporate dir1/dir2 backups into Huston's overall backup process.



backup of ca:
![[TRIVIR-IDV CA.pfx]]


Autobackup of edir:
 - Create starteDirBackups.sh: ![[starteDirBackups.sh]]
 - Create cron job:
	 - 00 21 * * * /root/edirbackups/starteDirBackups
- Run the dsbk and ndsbackup tools as shown in the starteDirBackups script, and confirm they can run properly.
	- Don't forget to run ndspassstore to store your user account password

Here are the steps I completed today in the TriVir eDirectory tree:
 - Confirmed eDirectory backups are running on dir1.
 - Added latest edirectory backupscript to dir2.
 - Created cronjob on dir2:
	 - 00 21 * * * /root/edirbackups/starteDirBackups
 - Cleaned up all other old iterations of the edir backup and stored in oldeDirBackupFiles.tgz (see below in image).
 - Confirmed backup script can run properly.
 - Ran backups for today as a test.
 
 Results:
  

2/8/2024 3:37:29 PM
Report to Huston:

Huston,    
  
I completed some steps today on the eDirectory tree today. I think I am stopped now until we can chat.

Question for you: I am still using my **akynaston.users.trivir** account to do the ndsbackup: I would like to create a read only admin in the tree and use that user instead. Preferences?

I completed the following on the eDirectory tree today  
 - I moved of the TriVir tree CA to dir2.  
 - I configured daily eDirectory backups on dir1.  
 - I configured daily eDirectory backups on dir2. -  
 
Here's the eDir backups folder on dir 2 just to show you an example of today's run: (note: oldeDirBackupFiles.tgz is our past backup file setup from 2016, and 2020 that is no longer needed):  

   - ![[Pasted image 20240208152547.png]]
  
To do next:  
 - Finish moving everything to dir2.  
 - Remove dir3 and dir4 from the tree, after we identify and move any other server-specific apps and/or processes.  
 - Include eDir backup process and output files in your backup process.





2/14/2024 4:07:54 PM
Work today otp with huston
have this todo list:

edir
   - dir2 - have to go away - on sles; can't install new version of edir . .
   - dir3 - most healthy and upgraded . .and certs rebuilt
   - need to move ca to dir3 . .
   - decommision dir 2; rebuild from scratch . .
   - dir1 - and upgraded . .but can't get this server to do SSL connection . .
     - other servers Centos . .
     - REmove dir 2 . .rebuild on REHDHAT, remove dir1, rebuild on rHEL then dit chre 3 .
     - - dir3 - if good, move ca here
 - dir2  - remove dir2 from the tree - nam will
 - dir1 ldapswsl fix . .


long term, brand new edirservers to replace 1 and 2.
* brand new rhelboxes, everything else decomosnioned.

dir3 appearard ok after removing nds.conf first line from instnaces.0

dir3 replication looks helathy, now moving CA from dir2 to dir3

exported trivir ca from dir2:
![[TRIVIR-IDV CA 1.pfx]]

CRL list: when importing the new one:
	 http://10.20.4.23:8028/crl/CRL_8.crl 	 
	 http://dir3.utah.trivir.com:8028/crl/CRL_8.crl 	 
	 ldap://10.20.4.23:389/CN=CRL_8,CN=CRL_8 - Configuration,CN=CRL Container,CN=Security 	 
	 ldap://dir3.utah.trivir.com:389/CN=CRL_8,CN=CRL_8 - Configuration,CN=CRL Container,CN=Security 	 

Goal: setup PAM ldap:
* now forces startTLS before auth; had recent issues with certs not validating . .protocol issues: TLS between redhat9 and edir . .
* These CRLs get put into the Certs as the CRL! Some apps may chose to check these!!
* Should: regenerate all server certs to include the correct crl references!

Difference between org ca and self signed cert:

![[Pasted image 20240214162308.png]]

Rebuilding all certs on dir3 . .
 - only doing standard rebuild - dir3 . .interim holding on to CA & building certs from her e. .
 - Note: after doing standard rebuild, only modifytimestamp changed!! new objects are not created!!
 - remvoed replicas from dir2
 - init 0; don't need to ndsmanage deconfigure . .oes wouldn't let us anyway.
 - We did this: RHEL9 woudln't talk to old edir servers: TLS too old!!
 
Next steps:
 - new RHEL VM, with new edir (9.2.7) - will be new dir2
 - Join to the tree . . - 
 - dir1: remove 1 after the new 2 is in the tree, we'll do the same here; have good dir1 & 2. 
 - Move CA back to dir2
 - shutdown/remove 3
 - Move all services away from dir4
 - shutdown/remove 4.

2/20/2024 4:19:42 PM
Created edirbackup_svc account, see: [[dir3]]

[[2/20/2024 3:39:37 PM]]



2/21/2024 5:19:19 PM
General plan notes from last week:
edir
   - dir2 - have to go away - on sles; can't install new version of edir . .
   - dir3 - most healthy and upgraded . .and certs rebuilt
   - need to move ca to dir3 . .
   - decommision dir 2; rebuild from scratch . .
   - dir1 - and upgraded . .but can't get this server to do SSL connection . .
     - other servers Centos . .
     - REmove dir 2 . .rebuild on REHDHAT, remove dir1, rebuild on rHEL then dit chre 3 .
     - - dir3 - if good, move ca here
 - dir2  - remove dir2 from the tree - nam will
 - dir1 ldapswsl fix . .

9/27/2024 3:22:34 PM
Reduce servers . .
goal: down to 2 healthy servers
dir1 - is SUSE 12 sp2 - need to remove . .
dir3 - is SUSE 12 sp2 - need to remove

decision: install new server: 
TODO:
 - Dir 2 - 2 hours

9/27/2024 4:07:56 PM - 

LATEST WORK:
When we can schedule it, 
 - Decomission 1 and 2
 - Clean up obits
 - Huston install new Dir1
 - move CA to dir1
 - Then look at moving dir4
 

10/9/2024 11:45:50 AM
old nhotes from dir2.utah.trivir.com

1/19/2024 10:18:02 AM
dir2.utah.trivir.com (formerly dir2.dock.trivir.com) - 10.20.4.22 (formerly 10.10.30.28)
From Huston: 1/29/2024 4:33:16 PM
You will need to ssh from dir4 to dir2. To get this to work you will need to change your ssh config to allow the host key algorithms rsa and dss. If you add this to your .ssh/config file on dir4 it should work:
Host dir2.utah.trivir.com 10.20.4.22
  HostName 10.20.4.22
  HostKeyAlgorithms=+ssh-rsa
  HostKeyAlgorithms=+ssh-dss


old notes from dir4
dir4.utah.trivir.com(avk)
username
root
password
••••••••••
Fantastic
notes
1/19/2024 10:17:45 AM

dir4.utah.trivir.com - 10.10.10.24

[root@dir4 ~]# ndsmanage
Server instances management utility for NetIQ eDirectory 9.2.7 v40208.00

The following are the instances configured by root

[1] /etc/opt/novell/eDirectory/conf/ndsd.conf : .DIR4.SERVERS.SERVICES.TRIVIR-IDV. : 10.10.10.24@524 : ACTIVE

Enter [r] to refresh list, [1 - 1] for more options, [c] for creating a new instance or [q] to quit: