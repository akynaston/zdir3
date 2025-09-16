# [AD] Old Password working - An old password still works after you change it in Outlook Web Access

From Aaron : it makes sense; the DC's are where the password authentication steps are completed right?  The local workstation may have a cached copy of the authentication, but not the core stuff.

Note from the article: The lifetime period of the old password can be configured by editing the registry on a domain controller. No restart is required for this registry change to take effect.

* * *

# Windows Server 2003 Service Pack 1 modifies NTLM network authentication behavior

Article ID: 906305 - [View products that this article applies to.](http://support.microsoft.com/kb/906305#appliesto)
System TipThis article applies to a different version of Windows than the one you are using. Content in this article may not be relevant to you. [Visit the Windows 7 Solution Center](http://support.microsoft.com/ph/14019)

 | 

## ![[./_resources/AD_Old_Password_working_-_An_old_password_still_works_after_you_change_it_in_Outlook_Web_Access.resources/unknown_filename.png]]

## ![[./_resources/AD_Old_Password_working_-_An_old_password_still_works_after_you_change_it_in_Outlook_Web_Access.resources/unknown_filename.1.png]]

Microsoft Windows Server 2003 Service Pack 1 (SP1) modifies NTLM network authentication behavior. After you install Windows Server 2003 SP1, domain users can use their old password to access the network for one hour after the password is changed. Existing components that are designed to use Kerberos for authentication are not affected by this change.
[![[./_resources/AD_Old_Password_working_-_An_old_password_still_works_after_you_change_it_in_Outlook_Web_Access.resources/unknown_filename.2.gif]]Back to the top](http://support.microsoft.com/kb/906305#top) | [Give Feedback](http://support.microsoft.com/kb/906305#survey)

## 

To reliably support network access for NTLM network authentication in distributed environments, Windows Server 2003 SP1 modifies the NTLM network authentication behavior as follows:

* After a domain user successfully changes a password by using NTLM, the old password can still be used for network access for a user-definable time period. This behavior allows accounts, such as service accounts, that are logged on to multiple computers to access the network while the password change propagates.

* The extension of the password lifetime period applies only to network access by using NTLM. Interactive logon behavior is unchanged. This behavior does not apply to accounts that are hosted on stand-alone servers or on member servers. Only domain users are affected by this behavior.
* The lifetime period of the old password can be configured by editing the registry on a domain controller. No restart is required for this registry change to take effect.

### How to change the lifetime period of an old password

**Important** This section, method, or task contains steps that tell you how to modify the registry. However, serious problems might occur if you modify the registry incorrectly. Therefore, make sure that you follow these steps carefully. For added protection, back up the registry before you modify it. Then, you can restore the registry if a problem occurs. For more information about how to back up and restore the registry, click the following article number to view the article in the Microsoft Knowledge Base:
[322756](http://support.microsoft.com/kb/322756) How to back up and restore the registry in Windows
To change the lifetime period of an old password, add a DWORD entry that is named OldPasswordAllowedPeriod to the following registry subkey on a domain controller:

HKEY\_LOCAL\_MACHINE\\SYSTEM\\CurrentControlSet\\Control\\Lsa

To do this, follow these steps:

1. Click **Start**, click **Run**, type **regedit**, and then click **OK**.

* Locate and then click the following registry subkey: **HKEY\_LOCAL\_MACHINE\\SYSTEM\\CurrentControlSet\\Control\\Lsa**
* On the **Edit** menu, point to **New**, and then click **DWORD Value**.
* Type **OldPasswordAllowedPeriod** as the name of the DWORD, and then press ENTER.
* Right-click **OldPasswordAllowedPeriod**, and then click **Modify**.
* In the **Value data** box, type the value in minutes that you want to use, and then click **OK**.
	**Note** The lifetime period is set in minutes. If this registry value is not set, the default lifetime period for an old password is 60 minutes.
* Quit Registry Editor.
	**Note** This registry setting does not require a restart to take effect.
**Note** This behavior does not cause a security weakness. As long as only one user knows both passwords, the user is still securely authenticated by using either password.
If a user's password is known to be compromised, the administrator should reset the password for that user. The administrator should ask the user to change the password at the next logon to invalidate the old password as soon as possible.
To reset a user's password, follow these steps:

1. Start Active Directory Users and Computers.
2. Locate the user account whose password must be reset.
3. Right-click the user object, and then click **Reset Password**.
4. Type the new password in the **New password** box and in the **Confirm password** box.
5. Click to select the **User must change password at next logon** check box, and then click **OK**.

**Note** The behavior that is described in this article occurs only if the effective password policy on the domain controllers has **Enforce Password History** set to a value that specifies that two or more passwords will be remembered. The password policy should be set at the domain level. You can determine whether the policy has taken effect on the domain controllers by using the Secpol.msc snap-in.
[Back to the top](http://support.microsoft.com/kb/906305#top) | [Give Feedback](http://support.microsoft.com/kb/906305#survey)

## 

Article ID: 906305 - Last Review: July 7, 2009 - Revision: 3.0

##### APPLIES TO

* Microsoft Windows Server 2003 Service Pack 1, when used with:

* Microsoft Windows Server 2003, Datacenter Edition (32-bit x86)

* Microsoft Windows Server 2003, Enterprise Edition (32-bit x86)
* Microsoft Windows Server 2003, Standard Edition (32-bit x86)
* Microsoft Windows Server 2003, Datacenter x64 Edition
* Microsoft Windows Server 2003, Enterprise x64 Edition
* Microsoft Windows Server 2003, Standard x64 Edition

|     |     |
| --- | --- |
| ##### Keywords: | kbhowto KB906305 |

[Back to the top](http://support.microsoft.com/kb/906305#top) | [Give Feedback](http://support.microsoft.com/kb/906305#survey)

# An old password still works after you change it in Outlook Web Access

Article ID: 267568 - [View products that this article applies to.](http://support.microsoft.com/kb/267568#appliesto)
This article was previously published under Q267568
**Important** This article contains information about how to modify the registry. Make sure that you back up the registry before you modify it. Make sure that you know how to restore the registry if a problem occurs. For more information about how to back up, restore, and modify the registry, click the following article number to view the article in the Microsoft Knowledge Base:
[322756](http://support.microsoft.com/kb/322756) How to back up and restore the registry in Windows

 | 

## ![[./_resources/AD_Old_Password_working_-_An_old_password_still_works_after_you_change_it_in_Outlook_Web_Access.resources/unknown_filename.1.png]]

Assume that a user changes their password in Outlook Web Access (OWA) in one of the following versions of Microsoft Exchange Server:

* Microsoft Exchange Server 2013

* Microsoft Exchange Server 2010
* Microsoft Exchange Server 2007
* Microsoft Exchange Server 2003
* Microsoft Exchange 2000 Server
In this case, you may notice a 15-minute period during which the user can log on to their mailbox by using either the old password or the new password. However, if the user uses a MAPI client (such as Microsoft Outlook) to access the mailbox or if the user tries to access other files and resources, the user is authenticated only if they use the new password.

## ![[./_resources/AD_Old_Password_working_-_An_old_password_still_works_after_you_change_it_in_Outlook_Web_Access.resources/unknown_filename.1.png]]

This latency exists by design for Internet Information Services (IIS) performance reasons and is controlled by the following registry setting.
**Warning** If you use Registry Editor incorrectly, you may cause serious problems that may require you to reinstall your operating system. Microsoft cannot guarantee that you can solve problems that result from using Registry Editor incorrectly. Use Registry Editor at your own risk.

1. Start Registry Editor (Regedt32.exe) on the server that is running IIS and through which the user gains access to OWA.

* Locate the following key in the registry:
	HKEY\_LOCAL\_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\InetInfo\\Parameters
	
* On the **Edit** menu, click **Add Value**, and then add the following registry value:
	**Value Name**: UserTokenTTL (**Note** This is case-sensitive!)
	**Data Type**: REG\_DWORD
	**Value Range**: 0 - 0x7FFFFFFF (**Note** This unit is in seconds.)
	
* Exit Registry Editor, and then restart IIS.
When a request is made to the server by using Basic Authentication, the security credentials for the request are used to create a user token on the server. The server impersonates this user token when it accesses files or other system resources (see also "CacheSecurityDescriptor" in IIS Help). The token is cached so that the Windows logon occurs only the first time that the user accesses the system or after the user's token is removed from the cache. Integrated Windows authentication tokens are not cached.
For IIS performance reasons, the default setting is 15 minutes. Make sure that you weigh carefully the security implications versus the performance implications. For more information, click the following article number to view the article in the Microsoft Knowledge Base:
[152526](http://support.microsoft.com/kb/152526) Changing the default interval for user tokens in IIS
**Note** If a user is still logged on when this registry key is set, that user's current Time to Live (TTL) token for that password remains the same as it was before the registry key was modified. The user is not affected until they close all instances of the browser, log on again, and change the password again. That new password will have the TTL of the registry key that was specified.

## ![[./_resources/AD_Old_Password_working_-_An_old_password_still_works_after_you_change_it_in_Outlook_Web_Access.resources/unknown_filename.1.png]]

Article ID: 267568 - Last Review: October 19, 2012 - Revision: 6.0

##### Applies to

* Microsoft Exchange 2000 Server Standard Edition

* Microsoft Exchange Server 2003 Standard Edition
* Microsoft Exchange Server 2003 Enterprise Edition
* Microsoft Exchange Server 2007 Standard Edition
* Microsoft Exchange Server 2007 Enterprise Edition
* Microsoft Exchange Server 2010 Standard
* Microsoft Exchange Server 2010 Enterprise
* Microsoft Exchange Server 2013 Standard
* Microsoft Exchange Server 2013 Enterprise
* Microsoft Internet Information Services 7.0
* Microsoft Internet Information Services 6.0
* Microsoft Internet Information Services 5.0

|     |     |
| --- | --- |
| ##### Keywords: | kbhowto KB267568 |

[![[./_resources/AD_Old_Password_working_-_An_old_password_still_works_after_you_change_it_in_Outlook_Web_Access.resources/unknown_filename.2.gif]]Back to the top](http://support.microsoft.com/kb/267568#top) | [Give Feedback](http://support.microsoft.com/kb/267568#survey)
