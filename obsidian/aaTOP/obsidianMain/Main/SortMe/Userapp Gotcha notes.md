---
tags: ["#TODO-LATER"]
---
# Userapp: Gotcha notes

User app
Version can be found by clicking on the help on th title bar.  You may need to un hide it (or, just go to the direct link: <https://idupdev01/IDM/jsps/help/Help.jsp>)
Userapp - authenticate as the admin (cn=userappadmin,o=services)
\- portlet admin -> expand the items in the left tree, until you see header portlate
\- click on Header portlate, then header portlate (twice)
\- click the 'Settings' tab
\- in the 'option' window, next to 'Help' click true, and apply.
\- log out
\- log in as a test user  aaaaavk/MyPassword

USERAPP
 - configuserapp - do not use soft linked directories when specifying keystore!

UserApp
 - 12/16/2010 9:44:45 AM- 
FCPS Userapp - just reset 3 month expiration for userapp, cuz they have UAPROV, but not UABASE license.

note: lots of warnings appear, but they seem to not matter after deploying.
 - I stopped jboss mysql, started mysql, then jboss - about 2 minutes later, userapp was working ifne.
activation required march 16, 2011

Note:I saw this error appear on the website: "One or more parameters passed to virtual data layer are null" after deploying.

UserApp - configupdate location on linux

Installation Complete
\---------------------
This part of the installation is complete. In order to finalize your
installation you must run the configuration tool. A convenience script for this
tool is found here: /opt/novell/idm/configupdate (.bat or .sh)

Userapp install:
when running configupdate.sh, or.bat - the keystore it's asking for is a new one so it can create it, and run with SSL in the future!  Don't specify one that already exists.

12/9/2010 4:38:05 PM
It appears that whenever a user is locked by intruder (8.8.2 Locked By Intruder = true, and reset timeout set to 30 mins in future), and attemps to repedatedly lok into userapp, theeir reset time conunes to be reset 30 minutes int he future from each attempt at logg in in - note: I think last I tested, this occurs with ldap too, so it's more likely an ldap thing maybe . . .

Userapp: INstall export from 3.5.1

Apparently, in userapp 3.5.1, you must install the userapp driver from imanager, and use the exports there as designer's copy will goof it up.

UserApp: user needs rights to update cacerts (from cgedirqldap1:)

\-r-xr--r-- 1 root root 31105 May 13 16:49 cacerts
\-rw-r--r-- 1 root root  2646 Oct  2  2006 java.policy
\-rw-r--r-- 1 root root  9609 Oct  2  2006 java.security
\-rwxr-xr-x 1 root root   550 Oct  1  2006 javaws.policy
lrwxrwxrwx 1 root root    44 May 13 16:42 local\_policy.jar -> /etc/alternatives/jce\_1.5.0\_ibm\_local\_policy
cgedirqldap:/usr/lib/jvm/java/jre/lib/security #
