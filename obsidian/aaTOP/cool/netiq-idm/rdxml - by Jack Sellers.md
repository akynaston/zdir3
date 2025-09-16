9/5/2025 5:45:56 PM

Just run this to check status on remote loaders:
rdxmlmanage 

Start by creating driver cfg file:
/opt/netiq/rdxmlrl/etc/opt/novell/dirxml/rdxml/IDtoApptioTargetProcess.cfg

Set the passwords:
[edir@w11dcledirdi013 IDtoApptioTargetProcess]$ /opt/netiq/rdxmlrl/opt/novell/dirxml/bin/x86_64/rdxml -config IDtoApptioTargetProcess.cfg -sp
Enter loader password:
Confirm loader password:
Enter driver object password:
Confirm driver object password:
Loading JVM
Starting Java loader

That 'Starting java loader' doesn't seem to work . .I had to start:

Then start:
[edir@w11dcledirdi013 IDtoApptioTargetProcess]$ rdxmlmanage start IDtoApptioTargetProcess
Starting remote loader instance for IDtoApptioTargetProcess

Then double check it's started:
edir@w11dcledirdi013 IDtoApptioTargetProcess]$ rdxmlmanage status

Status of all rdxml instances running on w11dcledirdi013 at 09/08/25-13:12:31
3348 /opt/netiq/rdxmlrl/etc/opt/novell/dirxml/rdxml/BackupDBtoID.cfg
3479 /opt/netiq/rdxmlrl/etc/opt/novell/dirxml/rdxml/IDtoApptioFrontDoor.cfg
3582 /opt/netiq/rdxmlrl/etc/opt/novell/dirxml/rdxml/IDtoBackupDB.cfg
3720 /opt/netiq/rdxmlrl/etc/opt/novell/dirxml/rdxml/IDtoCSS.cfg
3838 /opt/netiq/rdxmlrl/etc/opt/novell/dirxml/rdxml/MCL.cfg
3925 /opt/netiq/rdxmlrl/etc/opt/novell/dirxml/rdxml/OQS.cfg
27742 /opt/netiq/rdxmlrl/etc/opt/novell/dirxml/rdxml/IDtoApptioTargetProcess.cfg

PID: 3348       UPTIME: 7-08:33:14      MEMORY (mb):  2895 -- Time of Check: 09/08/25-13:12:31
PID: 3479       UPTIME: 7-08:33:14      MEMORY (mb):   395 -- Time of Check: 09/08/25-13:12:31
PID: 3582       UPTIME: 7-08:33:13      MEMORY (mb):  2324 -- Time of Check: 09/08/25-13:12:31
PID: 3720       UPTIME: 7-08:33:13      MEMORY (mb):   297 -- Time of Check: 09/08/25-13:12:31
PID: 3838       UPTIME: 7-08:33:13      MEMORY (mb):   350 -- Time of Check: 09/08/25-13:12:31
PID: 3925       UPTIME: 7-08:33:13      MEMORY (mb):   399 -- Time of Check: 09/08/25-13:12:31
PID: 27742      UPTIME: 00:26   MEMORY (mb):   108 -- Time of Check: 09/08/25-13:12:31
[edir@w11dcledirdi013 IDtoApptioTargetProcess]$