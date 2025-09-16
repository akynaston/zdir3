[Unit]
Description=eDirectory service for /etc/opt/novell/eDirectory/conf/ndsd.conf.
Wants=network-online.target
After=network.target network-online.target local-fs.target

[Service]
Type=forking
RemainAfterExit=no
PIDFile=/var/opt/novell/eDirectory/data/ndsd.pid
LimitCORE=infinity
TasksMax=infinity
EnvironmentFile=-/etc/opt/novell/eDirectory/conf/env
EnvironmentFile=-//etc/opt/novell/eDirectory/conf/env_idm
EnvironmentFile=-/etc/opt/novell/eDirectory/conf/env_custom
ExecStartPre=-//opt/novell/eDirectory/sbin/pre_ndsd_start_custom
ExecStartPre=-//opt/novell/eDirectory/sbin/pre_ndsd_start_factory
ExecStart=/opt/novell/eDirectory/sbin/ndsdwrapper
ExecStartPost=-//opt/novell/eDirectory/sbin/post_ndsd_start_custom
ExecStartPost=-//opt/novell/eDirectory/sbin/post_ndsd_start_factory
ExecStop=-/opt/novell/eDirectory/sbin/pre_ndsd_stop_custom
ExecStopPost=-//opt/novell/eDirectory/sbin/post_ndsd_stop_custom
ExecStopPost=-//opt/novell/eDirectory/sbin/post_ndsd_stop_factory
TimeoutStopSec=180

[Install]
WantedBy=multi-user.target



[root@dir4 system]# systemctl status ndsdtmpl-etc-opt-novell-eDirectory-conf-ndsd.conf@-etc-opt-novell-eDirectory-conf-env.service
● ndsdtmpl-etc-opt-novell-eDirectory-conf-ndsd.conf@-etc-opt-novell-eDirectory-conf-env.service - eDirectory service for /etc/opt/novell/eDirectory/conf/ndsd.conf.
     Loaded: loaded (/usr/lib/systemd/system/ndsdtmpl-etc-opt-novell-eDirectory-conf-ndsd.conf@.service; enabled; vendor preset: disabled)
     Active: active (running) since Sun 2024-07-14 23:32:20 MDT; 17h ago
    Process: 998 ExecStartPre=//opt/novell/eDirectory/sbin/pre_ndsd_start_custom (code=exited, status=0/SUCCESS)
    Process: 1004 ExecStartPre=//opt/novell/eDirectory/sbin/pre_ndsd_start_factory (code=exited, status=0/SUCCESS)
    Process: 1034 ExecStart=/opt/novell/eDirectory/sbin/ndsdwrapper (code=exited, status=0/SUCCESS)
    Process: 1173 ExecStartPost=//opt/novell/eDirectory/sbin/post_ndsd_start_custom (code=exited, status=0/SUCCESS)
    Process: 1174 ExecStartPost=//opt/novell/eDirectory/sbin/post_ndsd_start_factory (code=exited, status=0/SUCCESS)
   Main PID: 1172 (ndsd)
      Tasks: 61
     Memory: 303.8M
        CPU: 3min 14.680s
     CGroup: /system.slice/system-ndsdtmpl\x2detc\x2dopt\x2dnovell\x2deDirectory\x2dconf\x2dndsd.conf.slice/ndsdtmpl-etc-opt-novell-eDirectory-conf-ndsd.conf@-etc-opt-novell-eDirectory-conf-env.servi>
             └─1172 //opt/novell/eDirectory/sbin/ndsd

Jul 14 23:32:14 dir4 systemd[1]: Starting eDirectory service for /etc/opt/novell/eDirectory/conf/ndsd.conf....
Jul 14 23:32:14 dir4 pre_ndsd_start_factory[1021]: 795+0 records in
Jul 14 23:32:14 dir4 pre_ndsd_start_factory[1021]: 795+0 records out
Jul 14 23:32:14 dir4 pre_ndsd_start_factory[1021]: 3256320 bytes (3.3 MB, 3.1 MiB) copied, 0.106334 s, 30.6 MB/s
Jul 14 23:32:19 dir4 post_ndsd_start_factory[1176]: NetIQ eDirectory LDAP Server is listening on the TCP port.
Jul 14 23:32:20 dir4 post_ndsd_start_factory[1176]: NetIQ eDirectory LDAP Server is listening on the TLS port.
Jul 14 23:32:20 dir4 systemd[1]: Started eDirectory service for /etc/opt/novell/eDirectory/conf/ndsd.conf..
lines 1-22/22 (END)
