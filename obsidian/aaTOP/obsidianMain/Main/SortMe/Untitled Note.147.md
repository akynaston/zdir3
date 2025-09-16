# Untitled Note

#FCPS upgrade: 10.31.56.120:
4/14/2015 4:11:19 PM
FCPS PROD UPGRADE NOTES
FCPS: 8.8.8.3 upgrade notes (from 8.8.7.5):
idmprodidm2: 10.31.56.120:
\- Wait until eDirectory can be shut down (these upgrade steps require that eDir be restarted twice).
\- Authenticate as root.
\- Find and mount iso: eDirectory\_88SP8\_All.iso, MD5: cccc6cac2351a36643ebf4f2e3c5555a \*eDirectory\_88SP8\_All.iso
\- Ran (your mount path may be different to the ISO):
cd /media/CDROM/eDirectory\_88SP8\_Linux\_x86\_64\_Root/eDirectory/setup
./nds-install | tee /home/ediradmin/edirupgrade.log
Health check done in tool failed; parents partition is > 60 minutes from latest sync!
ndstrace
set ndstrace=\*H to cause heartbeat; did this on all servers, and found last time synced (ndsrepair -E came to 18:25 as expected) . . not sure why it is delaying like that . .
Ran this again:
./nds-install | tee /home/ediradmin/edirupgrade.log
Found healthcheck successful this time.
(the tee command just makes the output visible, and sends it to a file.
\- Accepted license
\- Continued after reading only server holding the replica warning.
\- Accepted warning that NICI will be upgraded to 2.7.7.
\- ndsd started backup during upgrade.
\- Install completed, ran this to confirm:
idmprodidm2:/mnt/cdrom/eDirectory\_88SP8\_Linux\_x86\_64\_Root/eDirectory/setup # rpm -qa | grep NDS
novell-NDSbase-8.8.8-1
novell-NDSserv-8.8.8-1
novell-NDSmasv-8.8.8-1
novell-NDScommon-8.8.8-1
novell-NDSrepair-8.8.8-38
novell-NDSimon-8.8.8-1
idmprodidm2:/mnt/cdrom/eDirectory\_88SP8\_Linux\_x86\_64\_Root/eDirectory/setup #
looks good, now health checks - . .passed.
FCPSSLES:~ #
\- Aquire edir8883.tar.gz, MD5: 565a909cb39281e7ea23283dca9ef708 \*edir8883.tar.gz
\- ran ndsmanage stopall (required by installer)
\- Unzipped to working folder on Linux.
     tar xvf edir8883.tar.gz
    
Backed up files as recommended by installer
| 1.  /etc/opt/novell/eDirectory/conf/nds.conf                                               |  (should be ndsd.conf)
| 2.  /var/opt/novell/eDirectory/data/\*                                                      |
| 3.  /etc/opt/novell/eDirectory/conf/ndsimon.conf                                           |
| 4.  /etc/init.d/ndsd                                                                       |
| 5.  /etc/opt/novell/eDirectory/conf/ndsmodules.conf                                        |
| 6.  NICI Files 
\- Entered the edir8883 directory it created, then ran
idmprodidm2:/home/ediradmin/upgrade/edir8883 # ./install.sh | tee /home/ediradmin/edirupgrade8883.log
\- Entered 'y' it is safe to shut down eDirectory.
\- Started eDirectory: ndsmanage startall.
\- Veirfied:
idmprodidm2:/home/ediradmin/upgrade/edir8883 # rpm -qa | grep NDS
novell-NDSrepair-8.8.8.2-2
novell-NDSbase-8.8.8.3-9
novell-NDSmasv-8.8.8-1
novell-NDScommon-8.8.8-1
novell-NDSimon-8.8.8.3-1
novell-NDSserv-8.8.8.3-9
idmprodidm2:/home/ediradmin/upgrade/edir8883 # ndsstat
\[1\] Instance at /etc/opt/novell/eDirectory/conf/ndsd.conf:  idmprodidm2.OU=servers.O=services.FCPS-IDV
Tree Name: FCPS-IDV
Server Name: .CN=idmprodidm2.OU=servers.O=services.T=FCPS-IDV.
Binary Version: 20804.05
Root Most Entry Depth: 0
Product Version: eDirectory for Linux x86\_64 v8.8 SP8 \[DS\]
Checked ports are listening:
idmprodidm2:/home/ediradmin # netstat -tlnp | grep ndsd
tcp        0      0 0.0.0.0:636             0.0.0.0:\*               LISTEN      1847/ndsd
tcp        0      0 10.31.57.120:8028       0.0.0.0:\*               LISTEN      1847/ndsd
tcp        0      0 10.31.56.120:8028       0.0.0.0:\*               LISTEN      1847/ndsd
tcp        0      0 10.31.57.120:8030       0.0.0.0:\*               LISTEN      1847/ndsd
tcp        0      0 10.31.56.120:8030       0.0.0.0:\*               LISTEN      1847/ndsd
tcp        0      0 0.0.0.0:389             0.0.0.0:\*               LISTEN      1847/ndsd
tcp        0      0 10.31.57.120:524        0.0.0.0:\*               LISTEN      1847/ndsd
tcp        0      0 10.31.56.120:524        0.0.0.0:\*               LISTEN      1847/ndsd
tcp        0      0 127.0.0.1:524           0.0.0.0:\*               LISTEN      1847/ndsd
idmprodidm2:/home/ediradmin #
Verified pre-ndsd\_start is still populated:
idmprodidm2:/home/ediradmin # cat /opt/novell/eDirectory/sbin/pre\_ndsd\_start
if \[ -f /opt/novell/eDirectory/lib/dirxml/dirxml-jni-envx \] #added by IDM
then                  #added by IDM
        . /opt/novell/eDirectory/lib/dirxml/dirxml-jni-envx       #added by IDM
fi                    #added by IDM
NDSD\_TRY\_NMASLOGIN\_FIRST=true
export NDSD\_TRY\_NMASLOGIN\_FIRST
\- Modified /opt/novell/eDirectory/bin: replaced both ndstrace calls at bottom of script with full path.
\- tested backup.
