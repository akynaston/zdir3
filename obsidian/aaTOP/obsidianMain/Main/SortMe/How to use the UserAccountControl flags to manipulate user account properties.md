---
tags: ["#AD"]
---
# How to use the UserAccountControl flags to manipulate user account properties

How to use the UserAccountControl flags to manipulate user account properties

, 24 April 2008 (created 24 April 2008)

* not tagging
* tags:
* 

How to use the  flags to manipulate user account properties
View products that this article applies to.
Article ID : 305144
Last Review : December 3, 2007
Revision : 10.5
This article was previously published under Q305144
On This Page
SUMMARY
MORE INFORMATION
Property flag descriptions
 values
SUMMARY
When you open the properties for a user account, click the Account tab, and then either select or clear the check boxes in the Account options dialog box, numerical values are assigned to the  attribute. The value that is assigned to the attribute tells Windows which options have been enabled.
To view user accounts, click Start, point to Programs, point to Administrative Tools, and then click Active Directory Users and Computers.
Back to the top
MORE INFORMATION
You can view and edit these attributes by using either the Ldp.exe tool or the Adsiedit.msc snap-in.
The following table lists possible flags that you can assign. You cannot set some of the values on a user or computer object because these values can be set or reset only by the directory service. Note that Ldp.exe shows the values in hexadecimal. Adsiedit.msc displays the values in decimal. The flags are cumulative. To disable a user's account, set the  attribute to 0x0202 (0x002 + 0x0200). In decimal, this is 514 (2 + 512).
Note You can directly edit Active Directory in both Ldp.exe and Adsiedit.msc. Only experienced administrators should use these tools to edit Active Directory. Both tools are available after you install the Support tools from your original Windows installation media.
Property flag Value in hexadecimal Value in decimal
SCRIPT 0x0001 1
ACCOUNTDISABLE 0x0002 2
 0x0008 8
LOCKOUT 0x0010 16
 0x0020 32
Note You cannot assign this permission by directly modifying the  attribute. For information about how to set the permission programmatically, see the "Property flag descriptions" section. 0x0040 64
 0x0080 128
 0x0100 256
 0x0200 512
 0x0800 2048
 0x1000 4096
 0x2000 8192
 0x10000 65536
 0x20000 131072
 0x40000 262144
 0x80000 524288
 0x100000 1048576
 0x200000 2097152
 0x400000 4194304
 0x800000 8388608
 0x1000000 16777216
Note In a Windows Server 2003-based domain,  and  have been replaced with a new attribute called ms-. For more information about this new attribute, visit the following Web site:
<http://msdn2.microsoft.com/en-us/library/ms677840.aspx> (<http://msdn2.microsoft.com/en-us/library/ms677840.aspx>)
Back to the top
Property flag descriptions
• SCRIPT - The logon script will be run.
• ACCOUNTDISABLE - The user account is disabled.
•  - The home folder is required.
•  - No password is required.
•  - The user cannot change the password. This is a permission on the user's object. For information about how to programmatically set this permission, visit the following Web site:
<http://msdn2.microsoft.com/en-us/library/aa746398.aspx> (<http://msdn2.microsoft.com/en-us/library/aa746398.aspx>)
•  - The user can send an encrypted password.
•  - This is an account for users whose primary account is in another domain. This account provides user access to this domain, but not to any domain that trusts this domain. This is sometimes referred to as a local user account.
•  - This is a default account type that represents a typical user.
•  - This is a permit to trust an account for a system domain that trusts other domains.
•  - This is a computer account for a computer that is running Microsoft Windows NT 4.0 Workstation, Microsoft Windows NT 4.0 Server, Microsoft Windows 2000 Professional, or Windows 2000 Server and is a member of this domain.
•  - This is a computer account for a domain controller that is a member of this domain.
•  - Represents the password, which should never expire on the account.
•  - This is an MNS logon account.
•  - When this flag is set, it forces the user to log on by using a smart card.
•  - When this flag is set, the service account (the user or computer account) under which a service runs is trusted for Kerberos delegation. Any such service can impersonate a client requesting the service. To enable a service for Kerberos delegation, you must set this flag on the userAccountControl property of the service account.
•  - When this flag is set, the security context of the user is not delegated to a service even if the service account is set as trusted for Kerberos delegation.
•  - (Windows 2000/Windows Server 2003) Restrict this principal to use only Data Encryption Standard (DES) encryption types for keys.
•  - (Windows 2000/Windows Server 2003) This account does not require Kerberos pre-authentication for logging on.
•  - (Windows 2000/Windows Server 2003) The user's password has expired.
•  - (Windows 2000/Windows Server 2003) The account is enabled for delegation. This is a security-sensitive setting. Accounts with this option enabled should be tightly controlled. This setting allows a service that runs under the account to assume a client's identity and authenticate as that user to other remote servers on the network.
Back to the top
 values
These are the default  values for the certain objects:
Typical user : 0x200 (512)
Domain controller : 0x82000 (532480)
Workstation/server: 0x1000 (4096)
Back to the top
APPLIES TO
• Microsoft Windows Server 2003, Enterprise Edition (32-bit x86)
• Microsoft Windows Server 2003, Standard Edition (32-bit x86)
• Microsoft Windows 2000 Server
• Microsoft Windows 2000 Advanced Server
• Microsoft Windows Small Business Server 2003 Premium Edition
• Microsoft Windows Small Business Server 2003 Standard Edition
Back to the top
Keywords:
kbenv kbinfo 
Back to the top
Source: [How to use the UserAccountControl flags to manipulate user account proper](http://support.microsoft.com/kb/305144)
