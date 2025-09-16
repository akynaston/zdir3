---
tags: ["#windows"]
---
# Quickly Find Local Open Ports

# Quickly Find Local Open Ports

by [Daniel Petri](http://www.petri.co.il/authors/danielp) - January 8, 2009

Usually, if you want to see all the used and listening ports on your computer, you'd use the NETSTAT command.

**Trying To Master The Basics of Networking?**[![[./_resources/Quickly_Find_Local_Open_Ports.resources/49.gif]]](http://www.petri.co.il/uri/?id=49&host=www.trainsignal.com)

Have you seen the CompTIA Network+ videos by Train Signal? I highly recommend this course, as you will learn much more than you will from any book. Along with the video training they also come with Transcender practice tests to help you prepare for the Network+ certification. They go through everything you need to know to install, configure and troubleshoot networks and also covers advanced topics like security protocols and disaster recovery.

[Watch A Free Demo Now](http://www.petri.co.il/uri/?id=49&host=www.trainsignal.com)

**Note:** The NETSTAT command will show you whatever ports are open or in use, but it is NOT a port scanning tool! If you want to have your computer scanned for open ports see this page instead (link will follow shortly).

Open Command Prompt and type:

C:'WINDOWS>netstat -an |find /i "listening"
TCP   0.0.0.0:135   0.0.0.0:0   LISTENING
TCP   0.0.0.0:445   0.0.0.0:0   LISTENING
TCP   0.0.0.0:1025   0.0.0.0:0   LISTENING
TCP   0.0.0.0:1084   0.0.0.0:0   LISTENING
TCP   0.0.0.0:2094   0.0.0.0:0   LISTENING
TCP   0.0.0.0:3389   0.0.0.0:0   LISTENING
TCP   0.0.0.0:5000   0.0.0.0:0   LISTENING

You can redirect it to a text file by adding _\>c:'openports.txt_ to the command, if you want to:

    netstat -an |find /i "listening" > c:'openports.txt

_netstat -an |find /i "listening"_ _\> c:'openports.txt_

You can also change _"listening"_ to _"established"_ to see what ports your computer actually communicates with:

    C:'WINDOWS>netstat -an |find /i "established"
    TCP   192.168.0.100:1084   192.168.0.200:1026   ESTABLISHED
    TCP   192.168.0.100:2094   192.168.0.200:1166   ESTABLISHED
    TCP   192.168.0.100:2305   209.211.250.3:80   ESTABLISHED
    TCP   192.168.0.100:2316   212.179.112.230:80   ESTABLISHED
    TCP   192.168.0.100:2340   209.211.250.3:110   ESTABLISHED

**Note:** In Windows XP and Windows Server 2003, you can type NETSTAT -O to get a list of all the owning process ID associated with each connection:

C:'WINDOWS>netstat -ao |find /i "listening"
TCP   pro1:epmap   pro1.dpetri.net:0   LISTENING   860
TCP   pro1:microsoft-ds   pro1.dpetri.net:0   LISTENING   4
TCP   pro1:1025   pro1.dpetri.net:0   LISTENING   908
TCP   pro1:1084   pro1.dpetri.net:0   LISTENING   596
TCP   pro1:2094   pro1.dpetri.net:0   LISTENING   596
TCP   pro1:3389   pro1.dpetri.net:0   LISTENING   908
TCP   pro1:5000   pro1.dpetri.net:0   LISTENING   1068

You can use PULIST from the W2K Resource Kit ([Download Free Windows 2000 Resource Kit Tools](http://www.petri.co.il/download_free_reskit_tools.htm)) to find the PID and see what process uses it and who started it. For example, you found out that your computer had an open connection to a remote IP address on TCP port 80, and you don't have any Internet Explorer or other browser windows open. You want to find out what process is using that session.

C:'WINDOWS>netstat -no
Active Connections
Proto Local Address Foreign Address State PID
TCP   192.168.0.100:2496   212.179.4.7:80   ESTABLISHED   1536

You can then use PULIST with the FIND command:

C:'WINDOWS>pulist |find /i "1536"
Process   PID   User
LUCOMS~1.EXE   1536   DPETRI'danielp

In this case, _LUCOMS~1.EXE_ is run by DANIELP (myself) and as it happens, it's the Symantec Live Update process.

You can also look in Task Manager for the respective PID.

1. To set up Task Manager to show the PID column open Task Manager by using CTRL+SHIFT+ESC.
2. Go to the Processes tab, click View and then Select Columns.

[![[./_resources/Quickly_Find_Local_Open_Ports.resources/pid_small.gif]]](http://www.petri.co.il/images/pid.gif)

1. In the Select Columns windows click to select PID and then click Ok.

[![[./_resources/Quickly_Find_Local_Open_Ports.resources/pid1_small.gif]]](http://www.petri.co.il/images/pid1.gif)

1. You can sort the PID column to display the PIDs in descending or ascending order.

[![[./_resources/Quickly_Find_Local_Open_Ports.resources/pid2_small.gif]]](http://www.petri.co.il/images/pid2.gif)

[![[./_resources/Quickly_Find_Local_Open_Ports.resources/archive;kw=;tile=2;sz=300x250,336x280;ord=12345678.gif]]](http://ad1.netshelter.net/jump/ns.petri;kw=;tile=2;sz=300x250,336x280;ord=123456789?)
To see all open, established, closing and other used ports type:

C:'WINDOWS>netstat -a
Active Connections
Proto Local Address Foreign Address State
TCP   pro1:epmap   pro1.dpetri.net:0   LISTENING
TCP   pro1:microsoft-ds   pro1.dpetri.net:0   LISTENING
TCP   pro1:1025   pro1.dpetri.net:0   LISTENING
TCP   pro1:1084   pro1.dpetri.net:0   LISTENING
TCP   pro1:2094   pro1.dpetri.net:0   LISTENING
TCP   pro1:3389   pro1.dpetri.net:0   LISTENING
TCP   pro1:5000   pro1.dpetri.net:0   LISTENING
TCP   pro1:1084   srv1.dpetri.net:1026   ESTABLISHED
TCP   pro1:2094   srv1.dpetri.net:1166   ESTABLISHED
TCP   pro1:2365   srv1.dpetri.net:epmap   TIME\_WAIT
TCP   pro1:2366   srv1.dpetri.net:1026   TIME\_WAIT
UDP   pro1:epmap   \*:\*
UDP   pro1:microsoft-ds   \*:\*
UDP   pro1:isakmp   \*:\*
UDP   pro1:1026   \*:\*
UDP   pro1:1027   \*:\*
UDP   pro1:1028   \*:\*
UDP   pro1:1038   \*:\*
UDP   pro1:1043   \*:\*
UDP   pro1:1085   \*:\*
UDP   pro1:1086   \*:\*
UDP   pro1:1242   \*:\*
UDP   pro1:ntp   \*:\*
UDP   pro1:1649   \*:\*
UDP   pro1:1900   \*:\*
UDP   pro1:2095   \*:\*
UDP   pro1:2217   \*:\*
UDP   pro1:ntp   \*:\*
UDP   pro1:1900   \*:\*

Again, in XP/2003 you can use the -O switch:

C:'WINDOWS>netstat -ao
Active Connections
Proto Local Address Foreign Address State PID
TCP   pro1:epmap   pro1.dpetri.net:0   LISTENING   860
TCP   pro1:microsoft-ds   pro1.dpetri.net:0   LISTENING   4
TCP   pro1:1025   pro1.dpetri.net:0   LISTENING   908
TCP   pro1:1084   pro1.dpetri.net:0   LISTENING   596
TCP   pro1:2094   pro1.dpetri.net:0   LISTENING   596
TCP   pro1:3389   pro1.dpetri.net:0   LISTENING   908
TCP   pro1:5000   pro1.dpetri.net:0   LISTENING   1068
TCP   pro1:1084   srv1.dpetri.net:1026   ESTABLISHED   596
TCP   pro1:2094   srv1.dpetri.net:1166   ESTABLISHED   596
UDP   pro1:epmap   \*:\*   860
UDP   pro1:microsoft-ds   \*:\*   4
UDP   pro1:isakmp   \*:\*   680
UDP   pro1:1026   \*:\*   1040
UDP   pro1:1027   \*:\*   1040
UDP   pro1:1028   \*:\*   680
UDP   pro1:1038   \*:\*   908
UDP   pro1:1043   \*:\*   624
UDP   pro1:1085   \*:\*   596
UDP   pro1:1086   \*:\*   596
UDP   pro1:1242   \*:\*   1040
UDP   pro1:ntp   \*:\*   908
UDP   pro1:1649   \*:\*   596
UDP   pro1:1900   \*:\*   1068
UDP   pro1:2095   \*:\*   976
UDP   pro1:2217   \*:\*   1856
UDP   pro1:ntp   \*:\*   908
UDP   pro1:1900   \*:\*   1068

#### Related Articles

* [Quickly Find Local Open Ports – GUI](http://www.petri.co.il/quickly_find_local_open_ports_gui.htm)
* [Quickly Find Remote Open Ports](http://www.petri.co.il/quickly_find_remote_open_ports.htm)
* [Quickly Find Remote Open Ports – GUI](http://www.petri.co.il/quickly_find_remote_open_ports_gui.htm)
* [How can I quickly open a Command Prompt on a folder in Windows Vista?](http://www.petri.co.il/quickly_open_command_prompt_here_in_windows_vista.htm)

Sign Up For the Petri IT Knowledgebase Weekly Digest!
E-mail Address:
_Search Site_
_Sponsors_

* [**Free Windows® App Monitoring**![[./_resources/Quickly_Find_Local_Open_Ports.resources/103.gif]]](http://www.petri.co.il/uri/?id=103&host=www.solarwinds.com) [WMI Monitor monitors any Windows® application or server, giving you amazing insight into real-time performance. Use built-in, community-sourced, or custom templates to start monitoring immediately! Click here to download this FREE TOOL](http://www.petri.co.il/uri/?id=103&host=www.solarwinds.com)
* [**Free Compliance Download**![[./_resources/Quickly_Find_Local_Open_Ports.resources/2.gif]] Configuresoft provides real time compliance checking for multiple VMware ESX host servers at once.](http://www.petri.co.il/uri/?id=2&host=www.configuresoft.com)
* [**Start Monitoring Your Network Now**![[./_resources/Quickly_Find_Local_Open_Ports.resources/100.gif]] Orion Network Performance Monitor (NPM) auto discovers your network and immediately begins monitoring, presented via a real-time, Web-based dashboard that allows you to quickly detect, diagnose and resolve network outages and performance issues.](http://www.petri.co.il/uri/?id=100&host=www.solarwinds.com)

[Privacy Policy](http://www.petri.co.il/privacy_policy) | [Contact](http://www.petri.co.il/feedback)  ©2009 Blue Whale Web Inc.
![[./_resources/Quickly_Find_Local_Open_Ports.resources/-55.100]]
