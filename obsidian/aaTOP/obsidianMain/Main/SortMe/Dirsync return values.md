---
tags: ["#isweariknewthatonce"]
---
# Dirsync return values

Dirsync return values
0x0035 - Seems to be stuck on setting initial cookie. . .doesn't seem to give back anything but password changes . .5/5/2009 4:48:19 PM
9/15/2010 2:16:03 PM - 2 things to solve this: ensure netlogin is in, and     Mine was pausedd, and saw thjis again, gept saying "set filter for initial cookie" too.
I think this means something about inbound/outbound replication is disabled - read on:
5/6/2009 10:26:13 AM  
Soulution:
Netlogon service comes up pasued cause event logs say I did an unsupported restore of AD (after I did a snapshot revert). . may have something to do with my exchange 2003 member server that I didn't revert.
\- NetLogon service comes up paused for some reason - had to start it first
\- Microsoft system exhcnage attendent wasn't started, probably due to netlogin.
\- ran dcdiag - told me to run
repadmin /options DOMAIN2007 -DISABLE\_INBOUND\_REPL
and
repadmin /options DOMAIN2007 -DISABLE\_OUTBOUND\_REPL
After restarting driver, remote loader returns get objects changes: 0x0000
10/7/2010 2:46:32 PM
0x0057 - This seemed to be solved when I added a schema mapping for User to user.  The driver seems extreemly case sensitive wehn it comes to this - when I added it, I got a tun  of deltes coming back (of users), and the driver error went away! Note: this was on a rmeote loader member server!
