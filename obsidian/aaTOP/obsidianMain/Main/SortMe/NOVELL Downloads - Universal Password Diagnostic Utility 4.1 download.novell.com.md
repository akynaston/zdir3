# NOVELL: Downloads - Universal Password Diagnostic Utility 4.1 [download.novell.com]

[![[./_resources/NOVELL_Downloads_-_Universal_Password_Diagnostic_Utility_4.1_download.novell.com.resources/unknown_filename.png]]](http://www.novell.com/)

* [Skip to Content](http://download.novell.com/protected/Summary.jsp?buildid=jVVLFzC95hA~#top)

* [Products](http://www.novell.com/products/)
* [Services & Support](http://www.novell.com/services/)
* [Partners](https://www.partnernetprogram.com/)
* [Communities](http://www.novell.com/communities/)
* [About Novell](http://www.novell.com/company/)
* [How to Buy](http://www.novell.com/products/howtobuy.html)

![[./_resources/NOVELL_Downloads_-_Universal_Password_Diagnostic_Utility_4.1_download.novell.com.resources/unknown_filename.2.png]]

[Close](http://download.novell.com/protected/Summary.jsp?buildid=jVVLFzC95hA~#)

[**Change**](http://www.novell.com/common/util/langselect.php?referer=http%3A//download.novell.com/protected/Summary.jsp%3Fbuildid%3DjVVLFzC95hA%7E) **_United States,_ English**

[**Login**](http://www.novell.com/common/util/secure/login.php?r=http://download.novell.com/protected/Summary.jsp?buildid=jVVLFzC95hA~)

[Close](http://download.novell.com/protected/Summary.jsp?buildid=jVVLFzC95hA~#)

# Universal Password Diagnostic Utility 4.1

**Restriction Status:  Restricted**

|     |     |     |
| --- | --- | --- |
| Name | Size |     |
| license\_agreement.txt | 2.8 KB (2909) | [![[./_resources/NOVELL_Downloads_-_Universal_Password_Diagnostic_Utility_4.1_download.novell.com.resources/unknown_filename.1.gif]]](http://download.novell.com/sendredirect?target=%2Ffree%2FjVVLFzC95hA%7E%2Flicense_agreement.txt&buildid=jVVLFzC95hA~&fileid=Sw4_l-jpihQ~&mirror=AkamaiHost&nohost=false&guid=1ccb55b7-8c1d-4c36-8d86-35609021b733) |
| diagpwd-4.1.zip | 148.0 KB (151650) | [![[./_resources/NOVELL_Downloads_-_Universal_Password_Diagnostic_Utility_4.1_download.novell.com.resources/unknown_filename.1.gif]]](http://download.novell.com/sendredirect?target=%2Frest%2FjVVLFzC95hA%7E%2Fpatchfiles%2Fdiagpwd-4.1.zip&buildid=jVVLFzC95hA~&fileid=dKAz6MOuQo8~&mirror=AkamaiHost&nohost=false&guid=1ccb55b7-8c1d-4c36-8d86-35609021b733) |
| readme\_5144731.html | 11.4 KB (11721) | [![[./_resources/NOVELL_Downloads_-_Universal_Password_Diagnostic_Utility_4.1_download.novell.com.resources/unknown_filename.1.gif]]](http://download.novell.com/sendredirect?target=%2Frest%2FjVVLFzC95hA%7E%2Freadme_5144731.html&buildid=jVVLFzC95hA~&fileid=7G1nrRjxQjY~&mirror=AkamaiHost&nohost=false) |

|     |     |     |
| --- | --- | --- |
| Related Product(s) | Patch Status for Product | Superceded By |
| eDirectory 8.8.6 | Active | <http://download.novell.com/protected/Summary.jsp?buildid=jVVLFzC95hA~> |
| Novell eDirectory 8.8.7 | Active | <http://download.novell.com/protected/Summary.jsp?buildid=jVVLFzC95hA~> |

### platforms

Windows XP Professional/2003/2008, RHEL 5/6, SUSE LINUX Enterprise Server 10/8, Unix (all versions), Netware (all versions)

### localizations

English

* [[#|how to use a download manager]]

Reminder: By downloading this product, you reaffirm your [agreement](http://download.novell.com/protected/Export.jsp?buildid=jVVLFzC95hA~&recheck=true) to comply with the export laws of the United States and those of other countries.

**MD5 Verification Checksums:**
MD5 checksum values are used to verify the data integrity of a downloaded file by comparing it to the checksum value of the original file. Linux/UNIX and Mac devices have this capability built-in; for Windows, several free utilities are available on the web to help you determine the checksum value of your downloaded files.

|     |     |
| --- | --- |
| license\_agreement.txt | 22147f49f243a49eedcf41cf20453183 |
| diagpwd-4.1.zip | 8967f457eb7826a0eff6e91fb51ac367 |
| readme\_5144731.html | bcb98fa7284cfd0cd87b456d7ab82080 |

This document (**5144731**) _is provided subject to the [disclaimer](http://download.novell.com/protected/Summary.jsp?buildid=jVVLFzC95hA~#disclaimer) at the end of this document._

### patches this patch supersedes

| File | Product | Status | Patch |
| --- | --- | --- | --- |
| diagpwd4.zip | eDirectory 8.8.6 | Active | [Universal Password Diagnostic Utility, Version 4](http://download.novell.com/Download?buildid=zGZqT_4Fs7M~) |

### patches that supersede this patch

This patch is not superseded by any other patches.

### patch attributes

Architecture: x86, x86-64
Security patch: No
Priority: Optional
Distribution Type: Public
<http://download.novell.com/Download?buildid=jVVLFzC95hA~>

### document

Revision: 1
Document ID: 5144731
Creation Date: 2012-06-18 20:41:46

### abstract

The Universal Password Diagnostic Utility 4.1 (diagpwd) is a tool that allows an administrator to view the Universal Password status for Simple, NDS, Distribution, and Universal passwords.
This update resolves symbol errors when running the utility under SLES and eDirectory 8.8 SP5 or greater. This update also provides 64-bit builds of the utility.

### details

The Universal Password Diagnostic Utility 4.1 is a tool that allows an administrator to view the Universal Password status for Simple, NDS, Distribution, and Universal passwords. \\
Prerequisites:
Linux workstation
LDAP SDK (novell-NLDAPsdk)
Windows workstation
Novell Client 4.91 SP3
To use Diagpwd:
Extract diagpwd-4.1zip to a Linux or Windows workstation.
For Linux workstations:
1\. Copy libnmasext.so to /usr/lib
2\. Make diagpwd executable by doing the following: "chmod 755 diagpwd"
For example:
bberger@sd1:~/diagpwd4>cp libnmasext.so /usr/lib
bberger@sd1:~/diagpwd4> chmod 755 diagpwd
bberger@sd1:~/diagpwd4>./diagpwd

For Windows workstations:
Open a command prompt, Start | Run | Cmd | change to the directory of diagpwd, then type diagpwd.exe
For example:
C:\\diagpwd.exe
Note: You may also pipe the output to a file by using the >filename.txt option, if the password is supplied inline.
Note: To verify the version of diagpwd, use the "-v" option.
For example:
For Linux Workstations:
bberger@sd1:~/diagpwd4>./diagpwd -v
diagpwd version 4
For Windows Worksations
C:\\diagpwd.exe -v
diagpwd version 4
DIAGPWD Usage:
: IP address of the target LDAP server
: The LDAP Secure port (SSL) of the target LDAP server (typically 636)
: DER encoded file of the Trusted Root Certificate for the target LDAP server or Self Signed Certificate from the Organizational CA. Please see section below on "Exporting SSL Certificate to a DER file" for more information on how to do this.
: LDAP DN that specifies a container or an object (in comma format). If this parameter is a container DN then the Password status will be shown for all objects in that container and subordinate containers (depending on scope value selected). If this parameter is a user then the Password status will be shown for the user.
: Values may be base, one or sub.
: The LDAP DN of the administrator (in comma format) that is requesting the operation. (example: cn=admin,o=novell )
: The password of the administrator specified by the parameter. Note that this parameter is optional. If it is not included on the command line the user will be prompted for it.
Exporting SSL Certificate to a DER file
In iManager:
iManager | Novell Certificate Server | Configure Certificate Authority | Select the Certificates tab | Select the Self Signed Certificate tab | Export | Uncheck the "Export private key" option | Verify the Export format is "Der" | Next | Click "Save the exported certificate" link and save to the desired location.
In ConsoleOne:
ConsoleOne | Browse to the Certificate Authority (CA) object (found in the cn=Security container) | Open CA object | Select the Certificates tab -> Self Signed Certificate | Select Export | Answer "No" to Do you want to export the private key with the certificate? | Next | name the file, such as c:\\RootCert.der| Next | Finish
Output of Diagpwd.exe:
The output will display the user(s) DN, email address, date of last password change, as well as their password status and Password Policy assigned.
\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*
Object DN: cn=user1,ou=users,o=novell
EMail: \[NONE\]
Last Changed Date: 2007-03-20 21:48:28 Z
Password Status: Enabled, Set, UP != Simple
Distribution Password Status: Set
Simple Password Status: Not set
Password Policy DN: cn=Users UP Policy,ou=users,o=novell
Password Policy DN: cn=Users UP Policy,ou=users,o=novell
Options: 0x354 (852)
Universal Password enabled
Advanced policy enabled
Sync NDS
Sync Simple disabled
Synch external
User readable
Not admin readable
\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*
The Password Status can be:
Disabled/Enabled
Not Set, Set
!=NDS (not equal to NDS)
UP != Simple (Universal Password not equal to Simple Password)
Examples:
Password Status: Enabled, Set
Simple Password Status: Set
Password Status: Universal Password disabled, Not set
Simple Password Status: Set, Simple != NDS
Search Examples:
Base searchScope example (Base level searches only search the object specified in searchBase)
Linux example:
./diagpwd 192.168.79.32 636 /home/user1/cert.der cn=user1,ou=users,o=novell base cn=admin,o=novell
Password: \*\*\*\*\*
Windows example:
diagpwd 192.168.79.32 636 C:\\cert.der cn=user1,ou=users,o=novell base cn=admin,o=novell
Password: \*\*\*\*\*
One searchScope examples: (One level searches search the object's immediate children specified in the searchBase)
Linux example:
./diagpwd 192.168.79.32 636 /home/user1/cert.der ou=users,o=novell one cn=admin,o=novell
Windows example:
diagpwd 192.168.79.32 636 C:\\cert.der ou=users,o=novell one cn=admin,o=novell
Sub searchScope examples: (Sub or subtree searches search the object and all its descendants specified in the searchBase)
Linux example:
./diagpwd 192.168.79.32 636 /home/user1/cert.der o=novell sub cn=admin,o=novell
Windows example:
diagpwd 192.168.79.32 636 C:\\cert.der o=novell sub cn=admin,o=novell
Note: If you run DIAGPWD against a user that has a Universal Password Policy assigned AND the user has not logged in yet (after the Universal Password Policy assignment), DIAGPWD will update the following attributes on the user: Password Minimum Length, Password Required and Password Unique Required. DIAGPWD will read the assigned Universal Password Policy and update the user with the corresponding values from the assigned Universal Password Policy. These same three attributes are also updated on a user upon the users first login.

### file contents

| Files Included | Size | Date |
| --- | --- | --- |
| diagpwd-4.1.zip | 148.0 KB (151650) | 2012-06-18 21:24:55 |
| readme\_5144731.html | N/A | 2012-06-18 20:42:40 |

### disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information. Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.

Novell is a registered trademark of Novell, Inc. in the United States and other countries. SUSE is a registered trademark of SUSE Linux AG, a Novell business. \*All third-party trademarks are the property of their respective owners.

[patch home](http://support.novell.com/patches.html)
[Patch Finder](http://download.novell.com/patch/finder/)

[LAN driver downloads](http://developer.novell.com/devres/lan/drivers/)
[storage driver downloads](http://developer.novell.com/devres/storage/drivers/)

[downloads home](http://download.novell.com/)

[developer downloads](http://www.novell.com/developer/)

[beta downloads](http://www.novell.com/beta/)

patches

driver downloads

[customer center](http://www.novell.com/center)

![PatchWarning.jsp%3Fbuildid%3DjVVLFzC95hA%7E&tzo=420&ms=67](http://now.eloqua.com/visitor/v200/svrGP.aspx?pps=3&siteid=1163&ref2=http%3A//download.novell.com/protected/PatchWarning.jsp%3Fbuildid%3DjVVLFzC95hA%7E&tzo=420&ms=67)

© 2013 Novell

* [Careers](http://www.novell.com/company/careers/index.html)

* [Legal](http://www.novell.com/company/legal/)
