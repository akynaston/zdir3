# [eDir] Patch 5 for eDir 8.8.7 - eDir Upgrade / NAM account

\[eDir\] Patch 5 for eDir 8.8.7 - eDir Upgrade / NAM account

**\----- Requirements -----**
 **- Need Root Access**. Aaron emailed Susan
 - Need about 1 hour per server.
 - We will be restarting eDir on each server during the process.

**\----- Work to do BEFORE May 17 -----**
- [x] Download this file:
<http://download.novell.com/Download?buildid=Z0LZIXIvG3w>~
- [ ] Check for free space.
- [ ] Login to machine
- [ ] Create a folder called edir-upgrade and extract the zip
/home/ckynaston/eDir887p5
cd /home/ckynaston/eDir887p5     

scp -r ckynaston@151.188.9.67:/home/ckynaston/eDir887p5/edir8875.tar.gz .

- [ ] extract the tar file.
tar -vxf edir8875.tar.gz
- [ ] Make sure it is running 8.8.7:
ndsstat
**20701.48 (starting version)**

- [ ] Check how this file looks now. Full path on ndstrace? YES

vi /opt/novell/eDirectory/bin/dsbk

\-BACKUP Upgrade-
su ediradmin
/home/ediradmin/backup-eDirectory.sh

watch -n .25 ls -rlth /var/tmp/dsbk\_887
ls -alrth /var/tmp/dsbk\_887

- [ ] copy the old script out of the way
cp backup-eDirectory.sh backup-eDirectoryOLD.sh

- [ ] replace the contents of the new script.
vi backup-eDirectory.sh

<https://src.trivir.com/customer/FairfaxCountyPublicSchools/trunk/IDM/env/eDirectoryBackup/eDirectoryBackup.sh>
- [ ] Backup again 

/home/ediradmin/backup-eDirectory.sh
watch -n .25 ls -rlth /var/tmp/dsbk\_887
ls -alrth /var/tmp/dsbk\_887

- [ ] watch -n .25 ls -rlth /var/tmp/dsbk\_887

**\----- Work to during our window on May 17 -----**

- [ ] Check for errors (revision, replicat state, Up status, time, timesync 0 or 1.)

ndsstat -r
ndsrepair -P
ndsrepair -N
ndsrepair -E
ndsrepair -T
ndsrepair -C -Ad -A

- [ ] Use our backup script to backup eDir

su ediradmin
/home/ediradmin/backup-eDirectory.sh
- [ ] Move those files out of the way so we don't stomp on them when we backup when we are done.
/var/tmp/dsbk\_887/\[Day of the week\]\*

Backup NICI files:
- [ ] Stop eDirectory services
/etc/init.d/ndsd stop
- [x] Backup the eDirectory database 2 min        (I removed v for verbose...)
cd /var/opt/novell/eDirectory/data
tar -czvf **ndsbackupBeforePatch5.tgz** dib
- [x] Move this to some other path with more space.
- [ ] Backup the NICI files
cd /var/opt/novell
tar -czvf **niciBeforePatch5**.tgz nici
- [ ] You must take a copy of the following files (NOTE: An eDirectory 8.8 Support Pack 7 database will not load without the original NICI files):
cd /etc/opt/novell/eDirectory/conf/
mkdir backup
cp ndsd.conf backup/
cp ndsimon.conf backup/

- [ ] Run "ls ndssnmp: Make sure ndssdnmp only has samples doesn't have:

nds snmp.cfg

nds trap.cfg

- [x] Backup this file if it exists
"/var/opt/novell/eDirectory/data/dib/\_ndsdb. ini" (if it exists) - Didn't exist

- [ ] Stop all the instances of eDirectory: 
ndsmanage stopall
- [ ] Run the install.sh script.
cd /home/ckynaston/eDir887p5/edir8875/

./install.sh
- [ ] Start NDSD:
ndsmanage startall

- [ ] Verify version - 20706.00.
ndsstat

- [ ] Check the log file and copy it off:

vi /var/opt/novell/eDirectory/log/eDir\_patch\_install.log

- [ ] Update the dsbk file to have the full path:

vi /opt/novell/eDirectory/bin/dsbk
Change 
ndstrace to:
/opt/novell/eDirectory/bin/ndstrace

- [ ] Use our backup script to backup eDir again to confirm it still works.
su ediradmin
/home/ediradmin/backup-eDirectory.sh

watch -n .25 ls -rlth /var/tmp/dsbk\_887

- [ ] Check for errors:
ndsstat -r
ndsrepair -P
ndsrepair -N
ndsrepair -E
ndsrepair -T
ndsrepair -C -Ad -A
