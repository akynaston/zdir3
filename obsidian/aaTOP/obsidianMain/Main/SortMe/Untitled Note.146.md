# Untitled Note

#FCPS Upgrade 10.31.56.117

FCPS: 8.8.8.3 upgrade notes (from 8.8.7.5):
idmprodedir2: 10.31.56.117:
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
Checking ports - noticed 10.31.57.117 isn't hosting imonitor ports . .may not be an issue; not delaing with now.
idmprodedir2:/mnt/cdrom/eDirectory\_88SP8\_Linux\_x86\_64\_Root/eDirectory/setup # netstat -tlnp | grep ndsd
tcp        0      0 0.0.0.0:389             0.0.0.0:\*               LISTEN      51049/ndsd
tcp        0      0 10.31.56.117:524        0.0.0.0:\*               LISTEN      51049/ndsd
tcp        0      0 127.0.0.1:524           0.0.0.0:\*               LISTEN      51049/ndsd
tcp        0      0 0.0.0.0:636             0.0.0.0:\*               LISTEN      51049/ndsd
tcp        0      0 10.31.56.117:8028       0.0.0.0:\*               LISTEN      51049/ndsd
tcp        0      0 10.31.56.117:8030       0.0.0.0:\*               LISTEN      51049/ndsd
idmprodedir2:/mnt/cdrom/eDirectory\_88SP8\_Linux\_x86\_64\_Root/eDirectory/setup # ifconfig -a
eth0      Link encap:Ethernet  HWaddr FC:15:B4:14:8B:A0
          inet addr:10.31.56.117  Bcast:10.31.56.255  Mask:255.255.255.0
          inet6 addr: fe80::fe15:b4ff:fe14:8ba0/64 Scope:Link
          UP BROADCAST RUNNING MULTICAST  MTU:1500  Metric:1
          RX packets:233795746 errors:0 dropped:0 overruns:0 frame:0
          TX packets:82034350 errors:0 dropped:0 overruns:0 carrier:0
          collisions:0 txqueuelen:1000
          RX bytes:237325199950 (226330.9 Mb)  TX bytes:17911441242 (17081.6 Mb)
          Interrupt:32 Memory:f6000000-f67fffff
eth1      Link encap:Ethernet  HWaddr FC:15:B4:14:8B:A4
          inet addr:10.31.57.117  Bcast:10.31.57.255  Mask:255.255.255.0
          inet6 addr: fe80::fe15:b4ff:fe14:8ba4/64 Scope:Link
          UP BROADCAST RUNNING MULTICAST  MTU:1500  Metric:1
          RX packets:68106718 errors:0 dropped:0 overruns:0 frame:0
          TX packets:16493853 errors:0 dropped:0 overruns:0 carrier:0
          collisions:0 txqueuelen:1000
          RX bytes:4808375947 (4585.6 Mb)  TX bytes:1347851541 (1285.4 Mb)
          Interrupt:36 Memory:f4800000-f4ffffff
lo        Link encap:Local Loopback
          inet addr:127.0.0.1  Mask:255.0.0.0
          inet6 addr: ::1/128 Scope:Host
          UP LOOPBACK RUNNING  MTU:16436  Metric:1
          RX packets:137971099 errors:0 dropped:0 overruns:0 frame:0
          TX packets:137971099 errors:0 dropped:0 overruns:0 carrier:0
          collisions:0 txqueuelen:0
          RX bytes:744742963882 (710242.2 Mb)  TX bytes:744742963882 (710242.2 Mb)
idmprodedir2:/mnt/cdrom/eDirectory\_88SP8\_Linux\_x86\_64\_Root/eDirectory/setup #
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
idmprodedir2:/home/ediradmin/upgrade/edir8883 # rpm -qa | grep NDS
novell-NDSrepair-8.8.8.2-2
novell-NDSbase-8.8.8.3-9
novell-NDSmasv-8.8.8-1
novell-NDScommon-8.8.8-1
novell-NDSimon-8.8.8.3-1
novell-NDSserv-8.8.8.3-9
idmprodedir2:/home/ediradmin/upgrade/edir8883 #
idmprodedir2:/home/ediradmin/upgrade/edir8883 # ndsstat
\[1\] Instance at /etc/opt/novell/eDirectory/conf/ndsd.conf:  idmprodedir2.OU=servers.O=services.FCPS-IDV
Tree Name: FCPS-IDV
Server Name: .CN=idmprodedir2.OU=servers.O=services.T=FCPS-IDV.
Binary Version: 20804.05
Root Most Entry Depth: 0
Product Version: eDirectory for Linux x86\_64 v8.8 SP8 \[DS\]
idmprodedir2:/home/ediradmin/upgrade/edir8883 #
Checked ports are listening:
idmprodedir2:/home/ediradmin/upgrade/edir8883 # netstat -tlnp  |grep ndsd
tcp        0      0 0.0.0.0:389             0.0.0.0:\*               LISTEN      1502/ndsd
tcp        0      0 10.31.56.117:524        0.0.0.0:\*               LISTEN      1502/ndsd
tcp        0      0 127.0.0.1:524           0.0.0.0:\*               LISTEN      1502/ndsd
tcp        0      0 0.0.0.0:636             0.0.0.0:\*               LISTEN      1502/ndsd
tcp        0      0 10.31.56.117:8028       0.0.0.0:\*               LISTEN      1502/ndsd
tcp        0      0 10.31.56.117:8030       0.0.0.0:\*               LISTEN      1502/ndsd
Verified pre-ndsd\_start is still populated:
idmprodedir2:/home/ediradmin/upgrade/edir8883 # cat /opt/novell/eDirectory/sbin/pre\_ndsd\_start
if \[ -f /opt/novell/eDirectory/lib/dirxml/dirxml-jni-envx \] #added by IDM
then                  #added by IDM
        . /opt/novell/eDirectory/lib/dirxml/dirxml-jni-envx       #added by IDM
fi                    #added by IDM
NDSD\_TRY\_NMASLOGIN\_FIRST=true
export NDSD\_TRY\_NMASLOGIN\_FIRST
idmprodedir2:/home/ediradmin/upgrade/edir8883 #
\- Modified /opt/novell/eDirectory/bin: replaced both ndstrace calls at bottom of script with full path.
\- tested backup.
