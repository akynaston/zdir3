---
tags: ["#c-fcps"]
---
# FCPS NA202SP6 INSTALL NOTES

FCPS NA202SP6 INSTALL NOTES
\======================================================================================
http://www.novell.com/documentation/novellaudit20/
mkdir -p /mnt/na202sp6
mount -o loop /home/gknutti/installs/na202sp6/Novell\_Audit\_202\_SP6.iso /mnt/na202sp6
cd /mnt/na202sp6/Linux
rpm -qa > ~/installedPackagesBefore
./piinstall.lin
an old config file was found, Y to use it (/etc/logevent.conf)
This file is also updated with auditds as the last row:
/etc/opt/novell/eDirectory/conf/ndsmodules.conf
line added:
auditDS auto #NSure Audit Platform Agent
This is ok, this is the platform agent . .
Packages added:
novell-AUDTplatformagent-2.0.2-55
novell-AUDTauditplugin-2.0.2-55
Pakcages removed:
novell-AUDTplatformagent-2.0.2-46
naudit.npm is added to:
/var/opt/novell/tomcat5/webapps/nps/packages/naudit.npm
Copied file to local windows box, so I can browse to it and select it through imanager.
\[root@idmdevl packages\]# chown novlwww naudit.npm
\[root@idmdevl packages\]# chgrp novlwww naudit
chgrp: cannot access \`naudit': No such file or directory
\[root@idmdevl packages\]# chgrp novlwww naudit.npm
 /etc/init.d/novell-tomcat5 stop
 /etc/init.d/novell-tomcat5 start
 
 Configure iman - installed plugins - confirmed audit is already there:
 Novell Audit   2.7.20080626    Novell Audit Configuration and Reporting
 
 and manifest file from new npm is:
 Manifest-Version: 1.0
Created-By: Apache Ant 1.5.1
Module-ID: naudit
Implementation-Title: Novell Audit
Implementation-Description: Novell Audit Configuration and Reporting
Min-iManager-Version: 2.7.0
Implementation-Version: 2.7.20080626
 
note: test enviroment does not have audit loaded in nds modules, or plugins installed in imanager.
note: production enironment imanager has an old version of the plugins:
Novell Audit    2.0.20080422    Novell Audit Configuration and Reporting
Actions taken in FCPS Dev (151.188.9.100 - IDMDEVL)
Packages added:
novell-AUDTauditplugin-2.0.2-55
Packages upgraded:
novell-AUDTplatformagent-2.0.2-46 to novell-AUDTplatformagent-2.0.2-55
iManager audit plugin was already at latest revision.
Audit platform agent is now loading with eDirectory.
eDirectory and iManager have been restarted successfully.
Actions taken in FCPS Test (151.188.9.101 - IDMTESTIMGR)
Packages added:
novell-AUDTauditplugin-2.0.2-55
Packages upgraded:
novell-AUDTplatformagent-2.0.2-36 to novell-AUDTplatformagent-2.0.2-55
Upgraded iManager plugin to the latestv version:
Novell Audit    2.7.20080626    Local Directory Novell Audit Configuration and Reporting
Audit platform agent is now loading with eDirectory.
eDirectory and iManager have been restarted successfully.
\======================================================================================
