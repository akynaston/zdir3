# Untitled Note

#FCPS Upgrade 151.188.9.62

FCPS: 8.8.8.3 upgrade notes (from 8.8.7.5):
idmprodidm1: 151.188.9.62:
Checked initial status of drivers:
Select a driver
    driver name                      start option     state
    ==================================================================
1: EX2007-PowerShellDriver          Auto             Running
2: Lawson                           Manual           Running
3: LDAP ADAM                        Auto             Running
4: Role and Resource Service Driver Auto             Running
5: Service Driver                   Auto             Running
6: Staff                            Auto             Running
7: state-machine                    Auto             Running
8: Student-AD                       Auto             Running
9: Student-PowerShellDriver         Auto             Running
10: Student-SIS                      Auto             Running
11: UserApplication                  Disabled         Stopped
12: UserApplicationDriver            Auto             Running
13: Username Truncation              Disabled         Stopped
14: WorkOrder                        Auto             Running
99: Exit
Enter choice: 99
\-Stopped all drivers.
Found logs from /opt/novell/edirectory/logs were already moved off; archived off random other logs to ../logs\_archive/misc.
 
\- Wait until eDirectory can be shut down (these upgrade steps require that eDir be restarted twice).
\- Authenticate as root.
\- Find and mount iso: eDirectory\_88SP8\_All.iso, MD5: cccc6cac2351a36643ebf4f2e3c5555a \*eDirectory\_88SP8\_All.iso
\- Ran (your mount path may be different to the ISO):
cd /media/CDROM/eDirectory\_88SP8\_Linux\_x86\_64\_Root/eDirectory/setup
./nds-install | tee /home/ediradmin/edirupgrade.log
\- Accepted license
\- Continued after reading only server holding the replica warning.
\- Accepted warning that NICI will be upgraded to 2.7.7.
     - this server sayd 2.7.7 alreayd installed, that it woudn't be doing anything, but hten went ahead and removed 2.7.6, and installed 2.7.7 . .not sure what to make of it.
\- ndsd started again during upgrade.
\- Install completed, ran this to confirm:
idmprodidm1:/mnt/cdrom/eDirectory\_88SP8\_Linux\_x86\_64\_Root/eDirectory/setup # rpm -qa | grep NDS
novell-NDSmasv-8.8.8-1
novell-NDSrepair-8.8.8-38
novell-NDSimon-8.8.8-1
novell-NDSbase-8.8.8-1
novell-NDSserv-8.8.8-1
novell-NDScommon-8.8.8-1
idmprodidm1:/mnt/cdrom/eDirectory\_88SP8\_Linux\_x86\_64\_Root/eDirectory/setup #
looks good, now health checks - . .passed.
Checking ports - noticed 10.31.57.117 isn't hosting imonitor ports . .may not be an issue; not delaing with now.
idmprodidm1:/mnt/cdrom/eDirectory\_88SP8\_Linux\_x86\_64\_Root/eDirectory/setup # netstat -tlnp | grep ndsd
tcp        0      0 0.0.0.0:636             0.0.0.0:\*               LISTEN      8296/ndsd
tcp        0      0 151.188.9.62:8028       0.0.0.0:\*               LISTEN      8296/ndsd
tcp        0      0 151.188.9.62:8030       0.0.0.0:\*               LISTEN      8296/ndsd
tcp        0      0 0.0.0.0:389             0.0.0.0:\*               LISTEN      8296/ndsd
tcp        0      0 151.188.9.62:524        0.0.0.0:\*               LISTEN      8296/ndsd
tcp        0      0 127.0.0.1:524           0.0.0.0:\*               LISTEN      8296/ndsd
tcp        0      0 :::42958                :::\*                    LISTEN      8296/ndsd
idmprodidm1:/mnt/cdrom/eDirectory\_88SP8\_Linux\_x86\_64\_Root/eDirectory/setup #
FCPSSLES:~ #
\- Aquire edir8883.tar.gz, MD5: 565a909cb39281e7ea23283dca9ef708 \*edir8883.tar.gz
\- ran ndsmanage stopall (required by installer)
\- Unzipped to working folder on Linux.
     tar xvf edir8883.tar.gz
    
\- Entered the edir8883 directory it created, then ran
idmprodidm2:/home/ediradmin/upgrade/edir8883 # ./install.sh | tee /home/ediradmin/edirupgrade8883.log
\- Entered 'y' it is safe to shut down eDirectory.
\- Started eDirectory: ndsmanage startall.
\- Veirfied:
idmprodidm1:/home/ediradmin/upgrade/edir8883 # rpm -qa | grep NDS
novell-NDSserv-8.8.8.3-9
novell-NDSmasv-8.8.8-1
novell-NDSimon-8.8.8.3-1
novell-NDSbase-8.8.8.3-9
novell-NDSrepair-8.8.8.2-2
novell-NDScommon-8.8.8-1
idmprodidm1:/home/ediradmin/upgrade/edir8883 #
idmprodidm1:/home/ediradmin/upgrade/edir8883 # ndsstat
\[1\] Instance at /etc/opt/novell/eDirectory/conf/ndsd.conf:  idmprodidm1.OU=servers.O=services.FCPS-IDV
Tree Name: FCPS-IDV
Server Name: .CN=idmprodidm1.OU=servers.O=services.T=FCPS-IDV.
Binary Version: 20804.05
Root Most Entry Depth: 0
Product Version: eDirectory for Linux x86\_64 v8.8 SP8 \[DS\]
idmprodidm1:/home/ediradmin/upgrade/edir8883 # netstat -tlnp | grep ndsd
tcp        0      0 0.0.0.0:636             0.0.0.0:\*               LISTEN      25084/ndsd
tcp        0      0 151.188.9.62:8028       0.0.0.0:\*               LISTEN      25084/ndsd
tcp        0      0 151.188.9.62:8030       0.0.0.0:\*               LISTEN      25084/ndsd
tcp        0      0 0.0.0.0:389             0.0.0.0:\*               LISTEN      25084/ndsd
tcp        0      0 151.188.9.62:524        0.0.0.0:\*               LISTEN      25084/ndsd
tcp        0      0 127.0.0.1:524           0.0.0.0:\*               LISTEN      25084/ndsd
tcp        0      0 :::50582                :::\*                    LISTEN      25084/ndsd
idmprodidm1:/home/ediradmin/upgrade/edir8883 #
Verified pre-ndsd\_start is still populated:
idmprodidm1:/home/ediradmin/upgrade/edir8883 # cat /opt/novell/eDirectory/sbin/pre\_ndsd\_start
if \[ -f /opt/novell/eDirectory/lib/dirxml/dirxml-jni-envx \] #added by IDM
then                  #added by IDM
        . /opt/novell/eDirectory/lib/dirxml/dirxml-jni-envx       #added by IDM
fi                    #added by IDM
NDSD\_TRY\_NMASLOGIN\_FIRST=true
export NDSD\_TRY\_NMASLOGIN\_FIRST
\- Modified /opt/novell/eDirectory/bin: replaced both ndstrace calls at bottom of script with full path.
\- tested backup.
