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



dir3:/usr/lib/systemd/system # systemctl status ndsdtmpl-etc-opt-novell-eDirectory-conf-ndsd.conf@-etc-opt-novell-eDirectory-conf-env.service
● ndsdtmpl-etc-opt-novell-eDirectory-conf-ndsd.conf@-etc-opt-novell-eDirectory-conf-env.service - eDirectory service for /etc/opt/novell/eDirectory/conf/ndsd.conf.
   Loaded: loaded (/usr/lib/systemd/system/ndsdtmpl-etc-opt-novell-eDirectory-conf-ndsd.conf@.service; disabled; vendor preset: disabled)
   Active: active (running) since Mon 2024-07-15 18:34:20 EDT; 19min ago
  Process: 8490 ExecStartPost=//opt/novell/eDirectory/sbin/post_ndsd_start_factory (code=exited, status=0/SUCCESS)
  Process: 8487 ExecStartPost=//opt/novell/eDirectory/sbin/post_ndsd_start_custom (code=exited, status=0/SUCCESS)
  Process: 8481 ExecStart=/opt/novell/eDirectory/sbin/ndsdwrapper (code=exited, status=0/SUCCESS)
  Process: 8472 ExecStartPre=//opt/novell/eDirectory/sbin/pre_ndsd_start_factory (code=exited, status=0/SUCCESS)
  Process: 8467 ExecStartPre=//opt/novell/eDirectory/sbin/pre_ndsd_start_custom (code=exited, status=0/SUCCESS)
 Main PID: 8488 (ndsd)
    Tasks: 61
   CGroup: /system.slice/system-ndsdtmpl\x2detc\x2dopt\x2dnovell\x2deDirectory\x2dconf\x2dndsd.conf.slice/ndsdtmpl-etc-opt-novell-eDirectory-conf-ndsd.conf@-etc-opt-novell-eDirectory-conf-env.service
           └─8488 //opt/novell/eDirectory/sbin/ndsd

Jul 15 18:34:17 dir3 systemd[1]: Starting eDirectory service for /etc/opt/novell/eDirectory/conf/ndsd.conf....
Jul 15 18:34:18 dir3 pre_ndsd_start_factory[8472]: 809+0 records in
Jul 15 18:34:18 dir3 pre_ndsd_start_factory[8472]: 809+0 records out
Jul 15 18:34:18 dir3 pre_ndsd_start_factory[8472]: 3313664 bytes (3.3 MB, 3.2 MiB) copied, 0.0101301 s, 327 MB/s
Jul 15 18:34:20 dir3 post_ndsd_start_factory[8490]: NetIQ eDirectory LDAP Server is listening on the TCP port.
Jul 15 18:34:20 dir3 post_ndsd_start_factory[8490]: NetIQ eDirectory LDAP Server is listening on the TLS port.
Jul 15 18:34:20 dir3 systemd[1]: Started eDirectory service for /etc/opt/novell/eDirectory/conf/ndsd.conf..
dir3:/usr/lib/systemd/system #

