2/13/2024 9:39:49 AM
getinfoedir - cool command line command:

output is like this:
[edir@w11qcledirqi010 /opt/idmlogs/MCL]$ getinfoedir

Time of Check: 02-13-24 10:40:19

Host: w11qcledirqi010
Tree: SWACO_IDSAT
Instance: eDirectory
ndsd PID: 57899
ndsd uptime: 43:31
ndsd memory: 1707 MB
ndsd open files: 1298
total open files: 6720
ndsd threads: Idle 27, Total 51, Peak 58
NMAS setting for eDirectory: NDSD_TRY_NMASLOGIN_FIRST=true
MALLOC status:
LDAP 1389: 0
LDAPS 1636: 4
Free Space on /var/opt/novell/: 33G
Free Space on /opt/edir/: 30G
[edir@w11qcledirqi010 /opt/idmlogs/MCL]$


2/13/2024 9:41:08 AM
SWA certs path: /opt/netiq/eDirectory/opt/novell/eDirectory/lib64/nds-modules/jre
 - same thing as jre -> /swa/opt/netiq/eDirectory/opt/netiq/common/jre
 -
 Also - jack showed - 'idm-swarootcaqa' is the name of the alias on w11qcledirqi010
 