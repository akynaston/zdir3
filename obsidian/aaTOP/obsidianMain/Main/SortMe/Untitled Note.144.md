# Untitled Note

#FCPS Upgrade 151.188.9.61

FCPS: 8.8.8.3 upgrade notes (from 8.8.7.5):
idmprodedir1: 151.188.9.61:
 
\- Wait until eDirectory can be shut down (these upgrade steps require that eDir be restarted twice).
\- Authenticate as root.
\- Find and mount iso: eDirectory\_88SP8\_All.iso, MD5: cccc6cac2351a36643ebf4f2e3c5555a \*eDirectory\_88SP8\_All.iso
\- Ran (your mount path may be different to the ISO):
cd /media/CDROM/eDirectory\_88SP8\_Linux\_x86\_64\_Root/eDirectory/setup
./nds-install | tee /home/ediradmin/edirupgrade.log
\- Accepted license
\- Continued after reading only server holding the replica warning.
\- Accepted warning that NICI will be upgraded to 2.7.7.
\- ndsd started again during upgrade.
\- Install completed, ran this to confirm:
idmprodedir1:/mnt/cdrom/eDirectory\_88SP8\_Linux\_x86\_64\_Root/eDirectory/setup # rpm -qa | grep NDS
novell-NDScommon-8.8.8-1
novell-NDSbase-8.8.8-1
novell-NDSserv-8.8.8-1
novell-NDSrepair-8.8.8-38
novell-NDSimon-8.8.8-1
novell-NDSmasv-8.8.8-1
looks good, now health checks - . .passed.
Checking ports - noticed 10.31.57.117 isn't hosting imonitor ports . .may not be an issue; not delaing with now.
idmprodedir1:/mnt/cdrom/eDirectory\_88SP8\_Linux\_x86\_64\_Root/eDirectory/setup # netstat -tlnp | grep ndsd
tcp        0      0 0.0.0.0:636             0.0.0.0:\*               LISTEN      17156/ndsd
tcp        0      0 151.188.9.61:8028       0.0.0.0:\*               LISTEN      17156/ndsd
tcp        0      0 151.188.9.61:8030       0.0.0.0:\*               LISTEN      17156/ndsd
tcp        0      0 0.0.0.0:389             0.0.0.0:\*               LISTEN      17156/ndsd
tcp        0      0 151.188.9.61:524        0.0.0.0:\*               LISTEN      17156/ndsd
tcp        0      0 127.0.0.1:524           0.0.0.0:\*               LISTEN      17156/ndsd
idmprodedir1:/mnt/cdrom/eDirectory\_88SP8\_Linux\_x86\_64\_Root/eDirectory/setup #
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
idmprodedir1:/home/ediradmin/upgrade/edir8883 # rpm -qa | grep NDS
novell-NDSbase-8.8.8.3-9
novell-NDScommon-8.8.8-1
novell-NDSserv-8.8.8.3-9
novell-NDSrepair-8.8.8.2-2
novell-NDSmasv-8.8.8-1
novell-NDSimon-8.8.8.3-1
idmprodedir1:/home/ediradmin/upgrade/edir8883 #
idmprodedir1:/home/ediradmin/upgrade/edir8883 # ndsstat
\[1\] Instance at /etc/opt/novell/eDirectory/conf/ndsd.conf:  idmprodedir1.OU=servers.O=services.FCPS-IDV
Tree Name: FCPS-IDV
Server Name: .CN=idmprodedir1.OU=servers.O=services.T=FCPS-IDV.
Binary Version: 20804.05
Root Most Entry Depth: 0
Product Version: eDirectory for Linux x86\_64 v8.8 SP8 \[DS\]
idmprodedir1:/home/ediradmin/upgrade/edir8883 # netstat -tlnp | grep ndsd
tcp        0      0 0.0.0.0:636             0.0.0.0:\*               LISTEN      32677/ndsd
tcp        0      0 151.188.9.61:8028       0.0.0.0:\*               LISTEN      32677/ndsd
tcp        0      0 151.188.9.61:8030       0.0.0.0:\*               LISTEN      32677/ndsd
tcp        0      0 0.0.0.0:389             0.0.0.0:\*               LISTEN      32677/ndsd
tcp        0      0 151.188.9.61:524        0.0.0.0:\*               LISTEN      32677/ndsd
tcp        0      0 127.0.0.1:524           0.0.0.0:\*               LISTEN      32677/ndsd
idmprodedir1:/home/ediradmin/upgrade/edir8883 #
Verified pre-ndsd\_start is still populated:
idmprodedir1:/home/ediradmin/upgrade/edir8883 # cat /opt/novell/eDirectory/sbin/pre\_ndsd\_start
if \[ -f /opt/novell/eDirectory/lib/dirxml/dirxml-jni-envx \] #added by IDM
then                  #added by IDM
        . /opt/novell/eDirectory/lib/dirxml/dirxml-jni-envx       #added by IDM
fi                    #added by IDM
NDSD\_TRY\_NMASLOGIN\_FIRST=true
export NDSD\_TRY\_NMASLOGIN\_FIRST
\- Modified /opt/novell/eDirectory/bin: replaced both ndstrace calls at bottom of script with full path.
\- tested backup.
