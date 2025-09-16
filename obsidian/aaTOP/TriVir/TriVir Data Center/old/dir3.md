2/20/2024 4:22:40 PM

2/20/2024 3:39:37 PM
Creating service account for edir backups
![[Pasted image 20240220154537.png]]

Created as a read only admin to the full tree:
![[Pasted image 20240220154608.png]]
eDir backup script:
root/edirbackups/starteDirBackups:

```
#!/bin/bash
# note: run ndspassstore, and type in the user name to store/hide the password for the -a parameter on ndsbackup.
PATH=/opt/novell/eDirectory/bin:/bin:/usr/bin
# Start by removing the dibset backup log as it doesn't clear itself:
rm /root/edirbackups/`date +\%A`.log
dsbk backup -f /root/edirbackups/`date +\%A`.dibback -l /root/edirbackups/`date +\%A`.log -e trivir -w -t -b
ndsbackup  cvf /root/edirbackups/fullTreeObjectLevel-`date +\%A`.ndsbk -a edirbackup_svc.accounts.services -p passstore > /root/edirbackups/fullTreeObjectLevel-`date +\%A`.ndsbk.log

```

Tried to do read only admin, but per this, supervisor is required:

https://support.microfocus.com/kb/doc.php?id=7007592

![[Pasted image 20240220160207.png]]

then later:
![[Pasted image 20240220160222.png]]