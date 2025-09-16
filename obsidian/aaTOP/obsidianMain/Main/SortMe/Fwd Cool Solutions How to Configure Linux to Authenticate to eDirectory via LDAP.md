# Fwd: Cool Solutions: How to Configure Linux to Authenticate to eDirectory via LDAP

\>>> Carl Kynaston <carlkynaston@gmail.com> 2/6/2014 11:46 AM >>>
NOT TESTED

#### Dynamically Creating User Home Directories

If user home directories are going to be created locally then PAM will need to dynamically create a user home directory. You will just get an error in a text based login, and will not be allowed to login using an X session.

The following configures PAM to create user home directories if they do not exist during the login process. For additional information see [TID 10067700](http://support.novell.com/cgi-bin/search/searchtid.cgi?/10067700.htm), "How to create homedirectories on Unix automatically".

### SUSE Linux 8.1

1\. Open the /etc/pam.d/login file and add the following line above the first session line:

      session       required       /lib/security/pam\_mkhomedir.so skel=/etc/skel umask=0022

2\. Open the /etc/pam.d/xdm file and add the following line above the first session line:

      session       required       /lib/security/pam\_mkhomedir.so skel=/etc/skel umask=0022

### RedHat Linux 7.2 / 8.0

1\. Open the /etc/pam.d/system-auth file and add the following line above the first session line:

      session       required       /lib/security/pam\_mkhomedir.so skel=/etc/skel umask=0022

For details or updates on this tip, see [TID 10081706](http://support.novell.com/cgi-bin/search/searchtid.cgi?/10081706.htm)

Evernote helps you remember everything and get organized effortlessly. [Download Evernote](https://www.evernote.com/getit?email_name=emailNote&email_guid=b47547d8-0d9a-4834-8b6f-664d4b155b3b&email_link=download_app).
