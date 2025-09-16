# Userapp (RBPM) 4.0.1 failed to install on Win2k8 64 bit [Archive] - NetIQ Forums [forums.netiq.com]

[NetIQ Forums](https://forums.netiq.com/archive/index.php?s=12addc79a8a3b6e5cc126154c6c74f9f) > [PRODUCT DISCUSSION FORUMS](https://forums.netiq.com/archive/index.php/f-1.html?s=12addc79a8a3b6e5cc126154c6c74f9f) > [Identity and Access Governance](https://forums.netiq.com/archive/index.php/f-90.html?s=12addc79a8a3b6e5cc126154c6c74f9f) > [Identity Manager](https://forums.netiq.com/archive/index.php/f-19.html?s=12addc79a8a3b6e5cc126154c6c74f9f) > [IM: Userapp-Workflow](https://forums.netiq.com/archive/index.php/f-23.html?s=12addc79a8a3b6e5cc126154c6c74f9f) > Userapp (RBPM) 4.0.1 failed to install on Win2k8 64 bit
[PDA](https://forums.netiq.com/archive/index.php/t-16816.html?s=12addc79a8a3b6e5cc126154c6c74f9f&pda=1)

View Full Version : [Userapp (RBPM) 4.0.1 failed to install on Win2k8 64 bit](https://forums.netiq.com/showthread.php?16816-Userapp-%28RBPM%29-4-0-1-failed-to-install-on-Win2k8-64-bit&s=12addc79a8a3b6e5cc126154c6c74f9f)

akynaston
12-Aug-2011, 22:16

When I install UserApp on Win2k8, I get this empty 'alert' dialog box
during the install:
http://ftp.trivir.com/outgoing/UserappInstallationfailure.JPG
I am using win2k8 64 bit, SP2 - I realize the docs say SP1, but does it
mean that it requires SP1? Any one know how to deal with this, and get
JBoss and PostGreSQL installed in another way?
Thanks,
\--Aaron
\--
akynaston
\------------------------------------------------------------------------
akynaston's Profile: http://forums.novell.com/member.php?userid=23027
View this thread: http://forums.novell.com/showthread.php?t=443125

Steven Williams
12-Aug-2011, 23:31

On 08/12/2011 05:16 PM, akynaston wrote:
\>
\> When I install UserApp on Win2k8, I get this empty 'alert' dialog box
\> during the install:
\>
\> http://ftp.trivir.com/outgoing/UserappInstallationfailure.JPG
\>
\> I am using win2k8 64 bit, SP2 - I realize the docs say SP1, but does it
\> mean that it requires SP1? Any one know how to deal with this, and get
\> JBoss and PostGreSQL installed in another way?
\>
\> Thanks,
\> --Aaron
\>
\>
Greetings Aaron,
The pop-up appears to be coming during the PostgreSQL installation.
Did you make sure that the password you entered for database user
complies with the Windows 2008 Server Password Policy? You can not use
simple passwords (unless you disabled this feature in the server itself).
\--
Sincerely,
Steven Williams
IDM Senior Specialist
NetIQ Engineering

akynaston
12-Aug-2011, 23:46

I was able to discuss this with someone else, and was able to get it
working. Here's what I didn't know:
\- I had to use a more complex password as you mentioned here (I'm
assuming this made a difference . .I didn't actually test a simple
password)
\- I manually created the C:\\novell\\idm\\Postgres\\data directory, and
assigned 'full control' to the 'Users' group during the 2005 .net
installation.
Thanks for responding!
I installed as the Domain administrator . . I think I might try a new
install as the local administrator, and see if it makes a difference.
\--
akynaston
\------------------------------------------------------------------------
akynaston's Profile: http://forums.novell.com/member.php?userid=23027
View this thread: http://forums.novell.com/showthread.php?t=443125

Steven Williams
12-Aug-2011, 23:52

On 08/12/2011 06:46 PM, akynaston wrote:
\>
\> I was able to discuss this with someone else, and was able to get it
\> working. Here's what I didn't know:
\>
\> - I had to use a more complex password as you mentioned here (I'm
\> assuming this made a difference . .I didn't actually test a simple
\> password)
\> - I manually created the C:\\novell\\idm\\Postgres\\data directory, and
\> assigned 'full control' to the 'Users' group during the 2005 .net
\> installation.
\>
\> Thanks for responding!
\>
\> I installed as the Domain administrator . . I think I might try a new
\> install as the local administrator, and see if it makes a difference.
\>
\>
Greetings Aaron,
What I have found with Windows 2008 is that you should do the following:
1) Create the root folder where you want to install (for example D:\\IDM)
2) The specifically map the person who will be running on this box to
have full control of the folder created above. (Even if they are in the
Admin's group)
3.a) Disable the requirement for complex Passwords (optional unless you
want to deal with it)
3.b) Then perform the Installation
\--
Sincerely,
Steven Williams
IDM Senior Specialist
NetIQ Engineering

akynaston
13-Aug-2011, 00:16

Interesting procedure - I'll have to test it if I can get some time, but
I suspect it would work properly. Is there a way that we can perfect
this, and get the RBPM documentation updated to describe these steps?
\--
akynaston
\------------------------------------------------------------------------
akynaston's Profile: http://forums.novell.com/member.php?userid=23027
View this thread: http://forums.novell.com/showthread.php?t=443125
