# Enable LDAP SSL with Active Directory in Windows 2003 ‹‹ Linux Mail Server Setup and Howto Guide [www.linuxmail.info]

* [Home |](http://www.linuxmail.info/)

* [Forum |](http://www.linuxmail.info/forum/)
* [About |](http://www.linuxmail.info/about/)
* [Contact |](http://www.linuxmail.info/contact-us/)
*  [![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.5.png]] Subscribe |](http://feeds.feedburner.com/LinuxMailServer)
*  [![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.19.png]] Follow me](http://www.twitter.com/linuxmailinfo)

# [Linux Mail Server Setup and Howto Guide](http://www.linuxmail.info)

	Rapidly deploy Linux based mail solutions today

## [Enable LDAP SSL with Active Directory in Windows 2003](http://www.linuxmail.info/enable-ldap-ssl-active-directory/)

Enabling SSL in Active Directory allows clients to communicate securely with AD servers. This is also required to allow a user’s Active Directory password to be changed programmatically using LDAP.

This article will show you how to install the **Certificate Services** in Windows 2003 to enable LDAP SSL in Active Directory.

![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.7.png]]Before beginning, make sure the Internet Information Server (IIS) is installed in your server.

## Installing the Certificate Services

[![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.17.png]]](http://www.linuxmail.info/images/windows-2003/add-remove-program-shortcut.png)

1\. Click _Start_, select _Control Panel_ and click _Add or Remove Programs_.
[![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.png]]](http://www.linuxmail.info/images/windows-2003/windows-component-wizard.png)

2\. In the **Add or Remove Programs** window, click _Add/Remove Windows Components_, check the _Certificate Services_ and click _Next_.
[![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.15.png]]](http://www.linuxmail.info/images/windows-2003/select-ca-type.png)

3\. Click _Next_ in the _CA Type_ page.
[![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.9.png]]](http://www.linuxmail.info/images/windows-2003/ca-identifying-information.png)

4\. Fill up the _Common name for this CA_ and click _Next_.
[![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.4.png]]](http://www.linuxmail.info/images/windows-2003/certificate-database-settings.png)

5\. Click _Next_ in the _Certificate Database Settings_ page.
[![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.11.png]]](http://www.linuxmail.info/images/windows-2003/ca-installing.png)

6\. The Certificate Services will now be installed.
[![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.3.png]]](http://www.linuxmail.info/images/windows-2003/ca-finished.png)

7\. Click _Finish_ and restart your server.

## Configuring Automatic Certificate Request for Domain Controllers

[![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.6.png]]](http://www.linuxmail.info/images/windows-2003/dc-security-policy-shortcut.png)

1\. Click _Start_, select _Administrative Tools_ and click _Domain Controller Security Policy_.
[![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.14.png]]](http://www.linuxmail.info/images/windows-2003/dc-sec-pol-pkp.png)

2\. In the **Default Domain Controller Security Settings** window, click the _Public Key Policies_ folder.
[![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.18.png]]](http://www.linuxmail.info/images/windows-2003/dc-sec-pol-pkp-2.png)

3\. Right click _Automatic Certificate Request Settings_, select _New_ and click _Automatic Certificate Request_.
[![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.16.png]]](http://www.linuxmail.info/images/windows-2003/acr-setup-wizard.png)

4\. Click _Next_ in the **Automatic Certificate Request Setup Wizard**.
[![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.13.png]]](http://www.linuxmail.info/images/windows-2003/acr-setup-wizard-ct.png)

5\. Select _Domain Controller_ in the **Certificate Template** page and click _Next_.
[![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.10.png]]](http://www.linuxmail.info/images/windows-2003/acr-setup-wizard-finish.png)

6\. Click _Finish_ and reboot your server.

## Check for Issued Certificate

[![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.1.png]]](http://www.linuxmail.info/images/windows-2003/certificate-authority-shortcut.png)

1\. Click _Start_, select _Administrative Tools_ and click _Certification Authority_. This will launch the **Certification Authority** application.
[![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.8.png]]](http://www.linuxmail.info/images/windows-2003/certificate-authority-issued-certs.png)

2\. In **Certification Authority**, click the _+_ sign and check the _Issued Certificates_ folder if your server has been issued a certificate.
![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.7.png]]Make sure your server has been issued a certificate, otherwise SSL communication will not work.

## Related Pages

[![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.2.png]]](http://www.linuxmail.info/images/windows-2003/certificate-wizard-4.png)

[How to Export an SSL Certificate in Windows Server 2003.](http://www.linuxmail.info/export-ssl-certificate-windows-2003/)

Visit the [forum](http://www.linuxmail.info/forum/) to ask for help or to give a comment.

\*\*\*
Posted on 5/19/2008 and last updated on 4/23/2011
Filed under [Active Directory](http://www.linuxmail.info/category/active-directory/) , [LDAP](http://www.linuxmail.info/category/ldap/) , [SSL/TLS](http://www.linuxmail.info/category/ssl/)

### 9 Responses to “Enable LDAP SSL with Active Directory in Windows 2003”

1. [Sean](http://www.saint-guild.co.uk):
	[March 18th, 2009 at 1:30 pm](http://www.linuxmail.info/enable-ldap-ssl-active-directory/#comment-3539)
	
	Enable LDAP SSL with Active Directory in Windows 2003 – You’re missing a large portion of the guide.
	
	It should be titled how to enable automatic certificate request!
	

* [consultant](http://www.linuxmail.info):
	[March 19th, 2009 at 1:06 pm](http://www.linuxmail.info/enable-ldap-ssl-active-directory/#comment-3543)
	
	Hi Sean,
	
	What else is missing? I’ve been using the steps above to enable SSL in Active Directory and it is works.
	
	I’ve used an SSL enabled Active Directory to [synchronize with Fedora Directory Server](http://www.linuxmail.info/ad-fds-sync-howto/) and to [change user password from Linux via LDAP and a Perl script](http://www.linuxmail.info/squirrelmail-active-directory-change-password-howto/).
	
* Kyle:
	[May 2nd, 2009 at 7:30 am](http://www.linuxmail.info/enable-ldap-ssl-active-directory/#comment-3634)
	
	You should explain that once a domain CA is installed, that information propagates throughout AD and domain controllers automatically begin to use SSL. Without knowing that, readers will just think that you’ve completed only a part of the config.
	
* TIm:
	[May 5th, 2009 at 11:25 pm](http://www.linuxmail.info/enable-ldap-ssl-active-directory/#comment-3660)
	
	There seems to be the glossing over of a few key steps, such as how to choose CA Type and Common Name.
	
* hcinco:
	[May 26th, 2009 at 11:36 pm](http://www.linuxmail.info/enable-ldap-ssl-active-directory/#comment-3684)
	
	I cannot connect through SSL on WIN 2K3
	
* Sean:
	[May 28th, 2009 at 2:48 am](http://www.linuxmail.info/enable-ldap-ssl-active-directory/#comment-3685)
	
	Hi Consultant,
	
	I think Kyle explained it very well. I’m just starting out on advanced server configurations and was hoping to remotely connect to a Windows Server (2003+) AD to run queries. I suspect SSL was needed, although I was thwarted in my efforts when my attention was drawn on other projects. It would be nice if you could update this guide with a way to confirm that LDAP works on SSL ![[./_resources/Enable_LDAP_SSL_with_Active_Directory_in_Windows_2003_‹‹_Linux_Mail_Server_Setup_and_Howto_Guide_www.linuxmail.info.resources/unknown_filename.12.gif]]
	
* guest:
	[June 16th, 2009 at 2:49 pm](http://www.linuxmail.info/enable-ldap-ssl-active-directory/#comment-3723)
	
	One way to test it would be to use the Ldap browser from Softerra with the correct connection settings, changing the port to 636.
	
* Vin:
	[July 10th, 2009 at 2:16 am](http://www.linuxmail.info/enable-ldap-ssl-active-directory/#comment-3751)
	
	These steps DO work. I was able to very quickly get SSL running on our AD server and connect via 636 using Softerra LDAP clients and our applications. THANK YOU for posting this!
	
* willisss:
	[July 14th, 2009 at 6:48 pm](http://www.linuxmail.info/enable-ldap-ssl-active-directory/#comment-3760)
	
	to confirm it’s working, LDP.exe from the command line?
	
	works for me!
	

Content

* [RHEL 6/CentOS 6 Email Server](http://www.linuxmail.info/mail-server-setup-centos-6/)

* [RHEL 5/CentOS 5 Email Server](http://www.linuxmail.info/mail-server-setup-centos-5/)
* [RHEL 4/CentOS 4 Email Server](http://www.linuxmail.info/mail-server-setup-centos-4/)
* [How a Mail Server Works](http://www.linuxmail.info/how-email-works/)
* [Why Use a Linux Mail Server](http://www.linuxmail.info/why-use-linux-mail-server/)
* [Recommended Softwares](http://www.linuxmail.info/recommended-software-linux-mail-server/)
* [Mail Server Deployment Checklist](http://www.linuxmail.info/mail-server-checklist/)
* [Mail Client Configuration](http://www.linuxmail.info/mail-client-configuration-howto/)
* [Postfix Howtos](http://www.linuxmail.info/postfix-howtos/)
* [System Administration Howto](http://www.linuxmail.info/system-administration-howto/)
* [Squid Proxy Server Howto](http://www.linuxmail.info/squid-proxy-server-setup-howto/)
* [389 Directory Server Howto](http://www.linuxmail.info/389-directory-server-howto-centos-5/)
* [Active Directory in Linux](http://www.linuxmail.info/active-directory-linux/)
* [Bind Setup Howto](http://www.linuxmail.info/bind-setup-howto/)
* [SharePoint Howto](http://www.sharepointgenius.com/)
* [SQL Server Howto](http://www.sqlservergenius.com/)

Categories

* [389 Directory Server](http://www.linuxmail.info/category/389-directory-server/) (10)
* [Active Directory](http://www.linuxmail.info/category/active-directory/) (24)
* [Anti-spam/Anti-virus](http://www.linuxmail.info/category/anti-spam-anti-virus/) (8)
* [Backup](http://www.linuxmail.info/category/backup/) (3)
* [CentOS 4](http://www.linuxmail.info/category/centos-4/) (14)
* [CentOS 5](http://www.linuxmail.info/category/centos-5/) (34)
* [CentOS 6](http://www.linuxmail.info/category/centos-6/) (11)
* [Dovecot](http://www.linuxmail.info/category/dovecot/) (10)
* [Kerberos](http://www.linuxmail.info/category/kerberos/) (4)
* [LDAP](http://www.linuxmail.info/category/ldap/) (16)
* [Mail Clients](http://www.linuxmail.info/category/mail-clients/) (6)
* [MailScanner](http://www.linuxmail.info/category/mailscanner/) (7)
* [Postfix](http://www.linuxmail.info/category/postfix/) (32)
* [Red Hat Enterprise Linux 4](http://www.linuxmail.info/category/rhel-4/) (14)
* [Red Hat Enterprise Linux 5](http://www.linuxmail.info/category/rhel-5/) (33)
* [Red Hat Enterprise Linux 6](http://www.linuxmail.info/category/red-hat-enterprise-linux-6/) (11)
* [Samba](http://www.linuxmail.info/category/samba/) (3)
* [SASL](http://www.linuxmail.info/category/sasl/) (4)
* [Squid Proxy Server](http://www.linuxmail.info/category/squid-proxy-server/) (4)
* [SquirrelMail](http://www.linuxmail.info/category/squirrelmail/) (16)
* [SSL/TLS](http://www.linuxmail.info/category/ssl/) (8)
* [System Administration](http://www.linuxmail.info/category/administration/) (23)
* [Technical Articles](http://www.linuxmail.info/category/technical-articles/) (4)
* [Uncategorized](http://www.linuxmail.info/category/uncategorized/) (8)

Sponsored Links

Copyright © 2007 LinuxMail. All rights reserved.    [Privacy Policy](http://www.linuxmail.info/privacy-policy/)
