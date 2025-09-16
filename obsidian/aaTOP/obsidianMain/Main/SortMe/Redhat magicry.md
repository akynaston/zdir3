# Redhat magicry

Redhat magicry
bash: ./java: /lib/ld-linux.so.2: bad ELF interpreter: No such file or directory
\[root@blue3 bin\]# uname -a
Linux blue3.trivirdev.com 2.6.32-220.el6.x86\_64 #1 SMP Wed Nov 9 08:03:13 EST 2011 x86\_64 x86\_64 x86\_64 GNU/Linux
\[root@blue3 bin\]# updatedb
\[root@blue3 bin\]# locate ld-linux.so.2
\[root@blue3 bin\]# locate ld-linux.so
/usr/share/man/man8/ld-linux.so.8.gz
\[root@blue3 bin\]# locate ld-linux
/lib64/ld-linux-x86-64.so.2
/usr/share/man/man8/ld-linux.8.gz
/usr/share/man/man8/ld-linux.so.8.gz
\[root@blue3 bin\]# rpm -f /lib64/ld-linux-x86-64.so.2
RPM version 4.8.0
Copyright (C) 1998-2002 - Red Hat, Inc.
This program may be freely redistributed under the terms of the GNU GPL
Usage: rpm \[-aKfgpWHqVcdilsKiv?\] \[-a|--all\] \[-f|--file\] \[-g|--group\] \[-p|--package\] \[-W|--ftswalk\] \[--pkgid\] \[--hdrid\] \[--fileid\]
        \[--specfile\] \[--triggeredby\] \[--whatrequires\] \[--whatprovides\] \[--nomanifest\] \[-c|--configfiles\] \[-d|--docfiles\] \[--dump\]
        \[-l|--list\] \[--queryformat=QUERYFORMAT\] \[-s|--state\] \[--nofiledigest\] \[--nomd5\] \[--nofiles\] \[--nodeps\] \[--noscript\]
        \[--comfollow\] \[--logical\] \[--nochdir\] \[--nostat\] \[--physical\] \[--seedot\] \[--xdev\] \[--whiteout\] \[--addsign\] \[-K|--checksig\]
        \[--delsign\] \[--import\] \[--resign\] \[--nodigest\] \[--nosignature\] \[--initdb\] \[--rebuilddb\] \[--aid\] \[--allfiles\] \[--allmatches\]
        \[--badreloc\] \[-e|--erase <package>+\] \[--excludedocs\] \[--excludepath=<path>\] \[--fileconflicts\] \[--force\]
        \[-F|--freshen <packagefile>+\] \[-h|--hash\] \[--ignorearch\] \[--ignoreos\] \[--ignoresize\] \[-i|--install\] \[--justdb\] \[--nodeps\]
        \[--nofiledigest\] \[--nomd5\] \[--nocontexts\] \[--noorder\] \[--nosuggest\] \[--noscripts\] \[--notriggers\] \[--oldpackage\] \[--percent\]
        \[--prefix=<dir>\] \[--relocate=<old>=<new>\] \[--replacefiles\] \[--replacepkgs\] \[--test\] \[-U|--upgrade <packagefile>+\] \[--quiet\]
        \[-D|--define 'MACRO EXPR'\] \[-E|--eval 'EXPR'\] \[--macros=<FILE:...>\] \[--nodigest\] \[--nosignature\] \[--rcfile=<FILE:...>\]
        \[-r|--root ROOT\] \[--querytags\] \[--showrc\] \[--quiet\] \[-v|--verbose\] \[--version\] \[-?|--help\] \[--usage\] \[--scripts\] \[--setperms\]
        \[--setugids\] \[--conflicts\] \[--obsoletes\] \[--provides\] \[--requires\] \[--info\] \[--changelog\] \[--xml\] \[--triggers\] \[--last\]
        \[--dupes\] \[--filesbypkg\] \[--fileclass\] \[--filecolor\] \[--fscontext\] \[--fileprovide\] \[--filerequire\] \[--filecaps\]
\[root@blue3 bin\]# rpm -qf /lib64/ld-linux-x86-64.so.2
glibc-2.12-1.47.el6.x86\_64
\[root@blue3 bin\]# rpm -qa|grep glibc
glibc-2.12-1.47.el6.x86\_64
glibc-devel-2.12-1.47.el6.x86\_64
glibc-common-2.12-1.47.el6.x86\_64
glibc-headers-2.12-1.47.el6.x86\_64
compat-glibc-headers-2.5-46.2.x86\_64
compat-glibc-2.5-46.2.x86\_64
\[root@blue3 bin\]# cd /mnt/cdrom/PA
