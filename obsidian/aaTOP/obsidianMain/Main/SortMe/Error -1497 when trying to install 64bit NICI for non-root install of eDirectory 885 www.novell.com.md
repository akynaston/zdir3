# Error -1497 when trying to install 64bit NICI for non-root install of eDirectory 885 [www.novell.com]

# Error -1497 when trying to install 64bit NICI for non-root install of eDirectory 885

This document **(7005486)** _is provided subject to the [disclaimer](http://www.novell.com/support/#disclaimer) at the end of this document._

### Environment

Non-Root install of eDirectory 8.8.5
nici64-2.7.6-0.01.x86\_64.rpm

### Situation

It is a requirement to install NICI as root for the non-root install of eDirectory 8.8.5.  When attempting to install nici64-2.7.6-0.01.x86\_64.rpm as root user, getting an error. 
If the 32 bit version of NICI (nici-2.7.6-0.01.i386.rpm) is installed first, then the 64bit version will install fine.
Errors:
Initializing NICI ... failed, error -1497
%post(nici64-2.7.6-0.01.x86\_64) scriptlet failed, exit status 39

### Resolution

The 64bit version of NICI has a dependency on the 32bit version, so it is necessary to install the 32bit version of NICI first. If 64bit version is already installed first, just remove it with the command:
rpm -e nici64-2.7.6-0.01
Next proceed to install the 32bit version followed by the 64bit version.

### Additional Information

 rpm -Uvh /home/user/eDirectory/nici64-2.7.6-0.01.x86\_64.rpm
Preparing...                ########################################### \[100%\]
   1:nici64                 ########################################### \[100%\]
Initializing NICI ... failed, error -1497
error: %post(nici64-2.7.6-0.01.x86\_64) scriptlet failed, exit status 39
If 32bit version is installed first:
rpm -Uvh nici-2.7.6-0.01.i386.rpm
Preparing...                ########################################### \[100%\]
   1:nici                   ########################################### \[100%\]
Initializing NICI ... done.
sb-sles11:/home/user/eDirectory # rpm -Uvh nici64-2.7.6-0.01.x86\_64.rpm
Preparing...                ########################################### \[100%\]
   1:nici64                 ########################################### \[100%\]
Initializing NICI ... done.

### Document

|     |     |
| --- | --- |
| **Document ID:** | 7005486 |
| **Creation Date:** | 03-15-2010 |
| **Modified Date:** | 03-15-2010 |
| **Novell Product:** | eDirectory |

### Disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information.
Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.
