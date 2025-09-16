# 10098422: Incompatible JClient/DClient package logging into iManager [support.novell.com]

# Incompatible JClient/DClient package logging into iManager

## (Last modified: 27Jul2005)

This document (**10098422**) _is provided subject to the [disclaimer](http://support.novell.com/docs/Tids/Solutions/10098422.html#disclaimer) at the end of this document._

### symptom

Incompatible JClient/DClient package logging into iManager

Novell iManager 2.5

After uninstalling and reinstalling iManager, iManager is unable to performance authentications.  Logins fail with error about Incompatible JClient/DClient

Error: Could not initialize com.novell.emframe.fw.NDSNamespaceAuthenticator.  java.lang.VerifyError: Incompatible JClient/DClient package JClient Revision 1.4.1101 DClient Revision 1.3.1172

### cause

Reinstall of iManager with Yast didn't add the LD\_LIBRARY\_PATH to iManager libraries in the tomcat4.conf file.

### fix

 Edit the /var/opt/novell/tomcat4/conf/tomcat4.conf file.

Look for:
LD\_LIBRARY\_PATH=/usr/lib
export LD\_LIBRARY\_PATH

It should look like:
LD\_LIBRARY\_PATH=/usr/lib
LD\_LIBRARY\_PATH=/opt/novell/iManager/lib
export LD\_LIBRARY\_PATH

Restart tomcat4:
On OES:  /etc/init.d/novell-tomcat4 restart 
On Solaris: /etc/init.d/imgr stop
                  /etc/init.d/imgr start

### document

|     |     |
| --- | --- |
| **Document Title:** | Incompatible JClient/DClient package logging into iManager |
| **Document ID:** | 10098422 |
| **Solution ID:** | NOVL102907 |
| **Creation Date:** | 27Jul2005 |
| **Modified Date:** | 27Jul2005 |
| **Novell Product Class:** | novell directory services |

### disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information.
Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.
