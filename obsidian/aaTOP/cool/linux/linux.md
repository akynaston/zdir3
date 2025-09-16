Example using find to get modification timestamps on results:

[edir@w11qcledirqi010 /]$ find . -iname cacerts 2> /dev/null | xargs ls -lt
-rwxr-xr-x 1 edir  edir     177024 Feb 13 09:19 ./swa/opt/netiq/eDirectory/opt/netiq/common/jre/lib/security/cacerts
-rwxr-xr-x 1 edir  edir     175655 Sep  2 18:37 ./swa/opt/idmfiles/idmkeystores/default/cacerts
-rwxr--r-- 1 edir  edir     388205 Aug 21 12:43 ./swa/opt/UFM/bin/libs/java/linux/jre1.8.0_231/lib/security/cacerts
-r--r--r-- 1 root  root     232815 Aug  3  2023 ./etc/pki/ca-trust/extracted/java/cacerts
-rwxr-xr-x 1 emadm RBTemadm 175815 Apr 10  2023 ./SWA/appdynamics/machineagent_23_9_1/jre/lib/security/cacerts
lrwxrwxrwx 1 root  root         97 Oct 15  2022 ./usr/lib/jvm/java-1.8.0-openjdk-1.8.0.352.b08-2.el8_6.x86_64/jre/lib/security/cacerts -> /etc/java/java-1.8.0-openjdk/java-1.8.0-openjdk-1.8.0.352.b08-2.el8_6.x86_64/lib/security/cacerts
lrwxrwxrwx 1 root  root         21 Oct 15  2022 ./etc/java/java-1.8.0-openjdk/java-1.8.0-openjdk-1.8.0.352.b08-2.el8_6.x86_64/lib/security/cacerts -> /etc/pki/java/cacerts
-rwxr-xr-x 1 edir  edir     177695 Aug 10  2022 ./swa/opt/netiq/rdxmlrl/opt/netiq/common/jre/lib/security/cacerts
lrwxrwxrwx 1 root  root         40 Jul 28  2022 ./etc/pki/java/cacerts -> /etc/pki/ca-trust/extracted/java/cacerts
-rw-rw-r-- 1 edir  edir     114923 Jan 31  2018 ./swa/opt/UFM/mqUFM/libs/java/windows/jre1.8.0_144/lib/security/cacerts
-rw-rw-r-- 1 edir  edir     114923 Jan 31  2018 ./swa/opt/UFM/mqUFM/libs/java/linux/jre1.8.0_144/lib/security/cacerts

./etc/openldap/cacerts:
total 4
-rw-r--r-- 1 root root 1866 Mar  4  2021 NEWPROD.pem
[edir@w11qcledirqi010 /]$



5/1/2025 3:56:31 PM
To disable line wrapping when looking at files in BASH:
setterm -linewrap off