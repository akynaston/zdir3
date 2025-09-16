---
tags: ["#vmnotes"]
---
# vm notes: bae-multi tree server

vm notes: bae-multi tree server
Base SLES 10 VM
Username and passwords = trivir
VMware tools installed
Note: udi and asd trees don't come up automatically - run ndsmanage startall to start all trees - it will error out on the idv tree, since it automatically starts.
ORACLE:
Oracle settings:
http port: oracle application express: 8081
database listener: 1521
SYS/trivir
SYSTEM/trivir
ACCESS TO SQL PLUS:
./app/oracle/product/10.2.0/server/bin/oracle\_env.sh
oracle@sles-base:~> sqlplus
ip: 172.17.2.50
Three trees are installed on this server.  Use ndsmanage to start/stop each of them separately. to log into a specific tree in imanager (also installed) specify ip:port for each tree:
172.17.2.50:524 - IDV
172.17.2.50:525 - UDITREE
172.17.2.50:526 - ASD\_TREE
Installed with nds config - the directories aren't quite right - I think one of the directories should be a parent of the other . .not sure:
ndsconfig new -t IDV -n o=services      -a cn=admin.o=services -w trivir -i -S IDVServer -d /var/opt/novell/eDirectory/IDV/data -L 389 -l 636 -o 8028 -O 8030 -b 524 -D /var/opt/novell/eDirectory/IDV/dib --config-file /etc/opt/novell/eDirectory/IDV/nds.conf
ndsconfig new -t UDITREE -n o=services  -a cn=admin.o=services -w trivir -i -S UDIServer -d /var/opt/novell/eDirectory/UDI/data -L 390 -l 637 -o 8128 -O 8130 -b 525 -D /var/opt/novell/eDirectory/UDI/dib --config-file /etc/opt/novell/eDirectory/UDI/nds.conf
ndsconfig new -t ASD\_TREE -n o=services -a cn=admin.o=services -w trivir -i -S ADSServer -d /var/opt/novell/eDirectory/ASD/data -L 391 -l 638 -o 8228 -O 8230 -b 526 -D /var/opt/novell/eDirectory/ASD/dib --config-file /etc/opt/novell/eDirectory/ASD/nds.conf

Note: carl used this to install a single tree, it kept the directroies clean.
ndsconfig new -t TreeName -a admin.services -w trivir
