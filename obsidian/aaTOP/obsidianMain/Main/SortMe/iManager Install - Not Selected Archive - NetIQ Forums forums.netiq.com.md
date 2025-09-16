# iManager Install - Not Selected? [Archive] - NetIQ Forums [forums.netiq.com]

[NetIQ Forums](https://forums.netiq.com/archive/index.php) > [PRODUCT DISCUSSION FORUMS](https://forums.netiq.com/archive/index.php/f-1.html) > [Identity and Access Governance](https://forums.netiq.com/archive/index.php/f-90.html) > [iManager](https://forums.netiq.com/archive/index.php/f-24.html) > iManager Install - Not Selected?
[PDA](https://forums.netiq.com/archive/index.php/t-1127.html?pda=1)

View Full Version : [iManager Install - Not Selected?](https://forums.netiq.com/showthread.php?1127-iManager-Install-Not-Selected)

nathanshaw
01-May-2012, 15:54

I am installing iManager on a new server and ran into a very strange
problem. When I agree to the EULA it shows me the Pre-Installation
Summary, where I would normally tell it to install Tomcat, iManager 2.7,
and Plugins, but instead of giving me the options, each one just says
"Not Selected".
I found 'this'
(http://www.novell.com/communities/node/11959/installation-imanager-opensuse11x)
article where someone described this scenario and that you could get
around it by editing the /etc/SuSe-release file. I don't see how this
applies to me and this is a RHEL 6.2 server anyway. This is also the
3rd RHEL 6.2 server where I've installed iManager in the last couple of
months and I've never run into this. Here's what the installer looks
like (minus the EULA):
Code:
\--------------------
$ sudo ./iManagerInstallLinux.bin
Preparing to install...
Extracting the JRE from the installer archive...
Unpacking the JRE...
Extracting the installation resources from the installer archive...
Configuring the installer for this system's environment...
Launching installer...
Preparing CONSOLE Mode Installation...
\================================================== =============================
Choose Locale...
\----------------
1- Deutsch
\->2- English
3- EspaÃ±ol
4- FranÃ§ais
5- Italiano
6- PortuguÃªs
CHOOSE LOCALE BY NUMBER:
\================================================== =============================
Novell iManager 2.7 (created with InstallAnywhere by Macrovision)
\-------------------------------------------------------------------------------
PuTTY X11 proxy: wrong authorisation protocol attempted
\================================================== =============================
Introduction
\------------
InstallAnywhere will guide you through the installation of Novell iManager 2.7.
It is strongly recommended that you quit all programs before continuing with
this installation.
Respond to each prompt to proceed to the next step in the installation. If you
want to change something on a previous step, type 'back'.
You may cancel this installation at any time by typing 'quit'.
PRESS <ENTER> TO CONTINUE:
\================================================== =============================
License Agreement
\-----------------
DO YOU ACCEPT THE TERMS OF THIS LICENSE AGREEMENT? (Y/N): y
\================================================== =============================
Pre-Installation Summary
\------------------------
Please Review the Following Before Continuing:
Novell iManager 2.7 :
Not Selected
Tomcat :
Not Selected
JVM :
Not Selected
Plugins to download :
Existing :
Plugins to copy :
Administrative user and context :
Tree :
Tomcat HTTP port :
Tomcat SSL port :
Directory to copy plugins :
\->1- Ok to proceed
2- Make changes
ENTER THE NUMBER FOR YOUR CHOICE, OR PRESS <ENTER> TO ACCEPT THE DEFAULT:
\--------------------
Eventually, due to seeing the messages about it being a "CONSOLE Mode
Installation" I figured I'd try running it from an xterm. It didn't
launch a GUI or anything, but for some reason the components were now
there for my selection. Just hoping someone might be able to explain
that as I feel there is possibly an underlying bug in the installer or
something else that I'm missing.
Thank you!
\--
nathanshaw
\------------------------------------------------------------------------
nathanshaw's Profile: http://forums.novell.com/member.php?userid=35776
View this thread: http://forums.novell.com/showthread.php?t=453344

nathanshaw
01-May-2012, 15:54

Ha! I figured it out and can reproduce it quite easily. If you SSH to
the box with X11 forwarding enabled in PuTTY, the installer does what is
shown above (no components to select). The installer seems to react
differently when it sees X11 is available but you're not in an xterm.
If I reconnect without X11 forwarding enabled the installer shows the
components as normal.
Cheers to anyone else who stumbles across this rare issue and finds
this post. :)
\--
nathanshaw
\------------------------------------------------------------------------
nathanshaw's Profile: http://forums.novell.com/member.php?userid=35776
View this thread: http://forums.novell.com/showthread.php?t=453344
