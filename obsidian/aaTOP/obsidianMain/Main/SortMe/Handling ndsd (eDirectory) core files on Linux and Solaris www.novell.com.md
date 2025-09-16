# Handling ndsd (eDirectory) core files on Linux and Solaris [www.novell.com]

Note: As explained below, if desired, you can just download the updater plugin for supportConfig, and get the latest stf

Handling ndsd (eDirectory) core files on Linux and Solaris

This document **(3078409)** _is provided subject to the [disclaimer](http://www.novell.com/support/#disclaimer) at the end of this document._

### Environment

Novell eDirectory 8.8 for Linux
Novell eDirectory 8.7.3 for Linux
Novell eDirectory 8.7.3 for Solaris
Novell eDirectory 8.8 for Solaris

### Situation

When ndsd crashes a core file will be generated in the dib directory if the ulimit -c is configured to a value more than 0. By default, the dib directory is located:
eDirectory 8.7.3    /var/nds/dib
eDirectory 8.8.x    /var/opt/novell/eDirectory/data/dib
If ndsd crashes and the reason is not apparent, check for a core file in the dib directory. If there is no core file present, change the ulimit -c setting to unlimited.

Many Linux distributions set the ulimit value to '0' in /etc/profile or use 'ulimit -Sc 0' to prevent core files.
In order for ndsd to use this setting it is necessary to add it to the ndsd script and then restart ndsd. (it could also be added to the pre\_ndsd\_start script as this script is sourced when ndsd loads).

Modify the /etc/init.d/ndsd script and add the following on the 2nd line directly underneath “#!/bin/bash": 

ulimit -c unlimited

### Resolution

**Novell-getcore**
Novell-getcore is a script used to gather and bundle the ndsd core file and all associated libraries necessary to analyze the core file.  Novell-getcore is installed as part of the NDSserv package, beginning with eDirectory 8.7.3.9 and eDirectory 8.8.2.  If you have an earlier  eDirectory version, the very first thing you should do is **update eDirectory to the latest available version as the current version most likely has the fix!** However, the novell-getcore script can be downloaded from [http://download.novell.com](http://download.novell.com/)

Just enter “novell-getcore” in the **keyword** field and click search.

**Using novell-getcore to bundle core and necessary libraries:**
1) Verify GDB is installed on the eDirectory server by typing "gdb -version".  GDB is required to be installed prior to using novell-getcore.
2) Create a bundle with novell-getcore to send to Novell Technical Support:
eDirectory 8.7.3 example:
**novell-getcore -b /var/nds/dib/core.#### /usr/sbin/ndsd**
eDirectory 8.8 example:
**novell-getcore -b /var/opt/novell/eDirectory/data/dib/core.#### /opt/novell/eDirectory/sbin/ndsd**
(where ####, is the PID number of ndsd when it cored)

This will generate a gzip'd tar bundle in the same directory as the core file with a name like the following:

core\_YYYYMMDD\_162243\_linux\_ndsd\_hostname.tar.gz

3)  Grab a supportconfig file from the server that cored.

On Linux use supportconfig/supportutils.  If you need the script it can be downloaded from the following page:  <http://www.novell.com/communities/node/2332/supportconfig-linux>

On Solaris: Use unixinfo to create a unixinfo.log.  See TID 10075466 “How to create a UNIX configuration file”.
4) Upload the supportconfig or unixinfo.log and novell-getcore bundles to ftp://ftp.novell.com/incoming

### Status

Diagnostic Pattern Available through Novell Support Advisor

### Additional Information

Sometimes the reason ndsd crashes is due to memory corruption.  If this is the case, it is necessary to add a malloc variable setting to the ndsd script. This will help to ensure that ndsd generates a core at the time the corruption occurs so the module that caused the corruption can more easily be identified.

The novell-getcore script extracts the stack into the file ./tmp/novell-getcore\_gdb\_command\_output.####.  The section with the stack will start at GDBCMDSTART bt and end with GDBCMDEND bt.
When there is stack corruption present, the debugger (gdb) can't resolve the stack pointers and many of the frames will have “??” in them.
Here is an example of what a stack would look like if the pointers are corrupt:

\# GDBCMDSTART bt
#0  0xb445b8cf in ldap\_tls\_inplace () from /usr/lib/libldap-2.3.so.0
#1  0xb445e1b2 in ldap\_install\_tls () from /usr/lib/libldap-2.3.so.0
#2  0xb446c2b6 in ?? () from /lib/libnss\_ldap.so.2
#3  0x0807fa48 in ?? ()
#4  0x0807fdf0 in ?? ()
#5  0x00000001 in ?? ()
#6  0xb6490668 in ?? ()
#7  0xb6490670 in ?? ()
#8  0xb44680db in ?? () from /lib/libnss\_ldap.so.2
#9  0xb4467000 in ?? ()
#10 0x000135d8 in ?? ()
#11 0xb7f6b8c8 in ?? () from /opt/novell/eDirectory/lib/libldapsdk.so.0
#12 0xb447a4e0 in ?? () from /lib/libnss\_ldap.so.2
#13 0xb64906e4 in ?? ()
#14 0x0000001e in ?? ()
#15 0x00000000 in ?? ()
\# GDBCMDEND bt
If ndsd cores due to stack corruption, Novell Technical Support will request that you add the malloc\_check setting and wait for another core to re-submit.

To set the necessary malloc variable, Modify the pre\_ndsd\_start script and put the following as the very first line, then restart the eDirectory instance.

MALLOC\_CHECK\_=2
export MALLOC\_CHECK\_
 
\## Note in eDirectory 8.8.5 ftf2 (patch2) the location of the pre\_ndsd\_start has been moved from /etc/init.d to /opt/novell/eDirectory/sbin/.  The contents of the pre\_ndsd\_start script are sourced into ndsd at the time ndsd loads.  Be aware that any permanent settings will be overwritten if left in the ndsd script the next time an eDirectory patch is applied while the pre\_ndsd\_start script will not be modified.  For this reason changes to the 'ndsd' script itself should not be made.  This is the purpose of the pre/post\_ndsd\_start scripts.

MALLOC\_CHECK\_=2 should NOT be left pernamently. Once the cores have been gathered, remove this setting from the modified script and restart ndsd. This environment variable can have a performance impact on some systems due to the increased memory checking.  In eDirectory 8.8, it will cause ndsd to revert back to using malloc instead of tcmalloc\_miminal which was added to enhance performance.
Another side effect of using MALLOC\_CHECK\_=2 is the possibility of increased coring.  Malloc will cause ndsd to core whenever a memory violation is detected whether or not it would have caused ndsd to crash under normal running conditions.
To verify this ndsd environment variable is set properly while ndsd is running, do the following as the user running the eDirectory instance ('root' most of the time):
strings /proc/\`pgrep ndsd\`/environ | grep -i MALLOC\_CHECK\_

The command above will not work on a server with multiple eDirectory instances (or ndsd processes).  To check a particular instance find that instance's process's PID and use that directly.  For PID 12345 the command would be the following:

strings /proc/12345/environ | grep -i MALLOC\_CHECK\_
After ndsd has cored, to verify the core file had the ndsd environment variable set, do the following:
strings core.#### | grep -i MALLOC\_CHECK\_
Bundle the core with MALLOC\_CHECK\_=2 set as in step 2.

For more information on Malloc check see: [TID 3113982: Diagnosing Memory Heap Corruption in glibc with MALLOC_CHECK_](http://www.novell.com/support/documentLink.do?externalID=3113982)

**Changing the location where cores files are generated**

In certain situations it may be desirable to change the location where core files are generated.  By default ndsd core files are placed in the dib directory.  If space in this directory is limited or if another location is desired, the following can be done:

mkdir /tmp/cores
chmod 777 /tmp/cores
echo "/tmp/cores/core" > /proc/sys/kernel/core\_pattern
This example would now generate the core.<pid> file in /tmp/cores
To revert back to placing cores in default location:
echo core > /proc/sys/kernel/core\_pattern

[![[./_resources/Handling_ndsd_(eDirectory)_core_files_on_Linux_and_Solaris_www.novell.com.resources/unknown_filename.1.jpeg]]](http://support.novell.com/advisor/)Have you tried resolving this issue using Novell Support Advisor? Visit <http://support.novell.com/advisor/> to learn more.

[![[./_resources/Handling_ndsd_(eDirectory)_core_files_on_Linux_and_Solaris_www.novell.com.resources/unknown_filename.gif]]](http://www.youtube.com/watch?v=lKVelISwyIk)

[+ Advanced eDirectory Troubleshooting](http://www.youtube.com/watch?v=lKVelISwyIk)

### Document

|     |     |
| --- | --- |
| **Document ID:** | 3078409 |
| **Creation Date:** | 01-09-2008 |
| **Modified Date:** | 08-19-2011 |
| **Novell Product:** | eDirectory |

### Disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information.
Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.
