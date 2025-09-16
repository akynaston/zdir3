---
tags: ["#linux","#IDM"]
---
# When I got this 0x6f error, edirectory seemsed to have issues - all i did was to

# When I got this 0x6f error, edirectory seemsed to have issues - all i did was to rcndsd restart - I appeard to not have any n4u.http\* settings in ndsconfig, I figured maybe it would reset them, and it did.

# I got this error when I was running my restartDRivers script - it stops all drivers, waits 5 seconds, then starts all drivers - I appeard to have lost all of my drivers in the driver set, so I had to run rcndsd restart, then re-deploy all drivers from scratch!

# Error 0x6F (NDS ERROR 111) while logging into iManager

This document **(3118974)** _is provided subject to the [disclaimer](http://www.novell.com/support/viewContent.do?externalId=3118974&sliceId=1#disclaimer) at the end of this document._

### Environment

Novell eDirectory 8.7.3.9 for Linux
Novell iManager 2.6
Novell ConsoleOne 1.3.6
Novell SUSE Linux Enterprise Server 9
The server has multiple NICs

### Situation

"error 0x6F (NDS Error 111)" when trying to log in to iManager
"Failed to retrieve a certificate .... The returned error Code is -321" in ConsoleOne
when trying to open the servers DNS Certificate or IP Certificate

### Resolution

Solution 1:
Issuing the following commands at the server console:

1. ndsconfig set n4u.server.interfaces=eth0,eth1,eth2
2. ndsconfig set n4u http.server.interfaces=eth2
3. ndsconfig set n4u https.server.interfaces=eth2
4. rcndsd restart

fixed the issue. While eth2 in this case is a dedicated eDirectory administration Interface.
Solution 2:
eDirectory isn't loaded on the target server.
To Check: enter /etc/init.d/ndsstat
To Start : enter /etc.init.d/ndsd start

### Additional Information

Troubleshooting:
used "ndsconfig get" to check eDirectory configuration and found
\- eDirectory was just configured on one NIC
\- http.server.interfaces and https.server.interfaces have not been configured at all
Notes:
The reason for configuring eDirectory just on one Interface is to prevent other Networks to access the database (IP Routing on the Server running eDirectory is set to off).
The customer uses 3 Interfaces in 3 Subnets:
One for eDirectory sync / incoming LDAP Queries (eth0)
One for eDirectory Administration (eth2)
One for the Servers Backend Communication. (eth1)
eDirectory was only configured for the sync / incoming LDAP Queries Interface.

### Document

|     |     |
| --- | --- |
| **Document ID:** | 3118974 |
| **Creation Date:** | 06-06-2007 |
| **Modified Date:** | 12-24-2008 |
| **Novell Product:** | ConsoleOne |
| **Novell Product:** | eDirectory |
| **Novell Product:** | iManager |

### Disclaimer
