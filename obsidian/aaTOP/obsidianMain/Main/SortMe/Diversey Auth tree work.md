# [Diversey] Auth tree work

12/18/2018 4:20:06 PM

Reading documentation
<https://www.netiq.com/documentation/identity-manager-47-drivers/bidirect_edirectory/data/understanding-the-bidirectional-edir-driver.html>

Learned/confirmed:

* Standard driver export running on engine in tree A
* changelog module containing 3 pieces
	* Change cache (standard TAO file just like IDM engine files)
	* Event logger (Sets up and writes to TAO file)
	* Change-log extension handler: LDAP extensions (limited version of dxldap) to retrieve events.
* Need to use EC (elliptic curve certificate) from dest tree, if it is 9.0.2X or higher, and the auth tree is 9.0.2 in our case.
* Not going to bother with mutual authentication; but definately need SSL due to password sync.
* They say the driver service auth account needs rights to write to ACL in the dest tree to sync password . . seems odd . .
* Loopback protection does not work on subscriber delete events: they're reported on publisher.

\*\*\* See if these files exist on the remote server:
\[root@ogidm opt\]# find . -iname libdirxml\*
./novell/eDirectory/lib64/libdirxml.la
./novell/eDirectory/lib64/libdirxml.so
./novell/eDirectory/lib64/libdirxml.so.1
./novell/eDirectory/lib64/libdirxml.so.3
./novell/eDirectory/lib64/libdirxml.so.3.0.600

ln issue when installing change log util regarding bad links:
ln: target ‘/opt/novell/eDirectory/lib64/libdirxml.so’ is not a directory
ln: target ‘/opt/novell/eDirectory/lib64/libdirxml.so.3’ is not a directory

<https://support.microfocus.com/kb/doc.php?id=7019013>

Containers needed: 
GCV: drv.edir.base.container (see if drv.subplacementtype = custom . .i think it is)

12/19/2018 3:31:40 PM- took schema/object/dibset backups
Stored:
\-rwxr--r--. 1 dve96577 users 7.2G Jul 16 18:36 Identity\_Manager\_4.6\_Linux.iso
\-rw-r--r--. 1 root     root   303 Dec 19 22:23 clschema.sch
\-rw-r--r--. 1 root     root  191K Dec 19 22:25 edirSchemaBackup.ndsbackup
\-rw-r--r--. 1 root     root  395K Dec 19 22:26 edirFullTree.ndsbackup
\-rw-------. 1 root     root  1.6M Dec 19 22:26 dibbackup.dib
\-rw-------. 1 root     root   515 Dec 19 22:26 dibbackup.log
\[root@sus1lvmidmp0005 dve96577\]# pwd
/home/dve96577
\[root@sus1lvmidmp0005 dve96577\]#

*  eDir health looks good.
* Schema I did with Glen already; applying again to double check.

12/19/2018 7:34:52 PM

*  Now running RPM install.

12/20/2018 10:34:04 AM
lots of goofyness today

*  three reported issues to glen and bob
* now found designer and tree disagree on some policy; not sure what is the latest.
* I have an object level backup; so can restore the driver if need be.
* I took a backup of the driver export from Designer; so I could restore either.

12/20/2018 10:37:21 AM

*  deployed bidirection driver and email templates since they were referred to.
	* note: email template deployment failed: just doesn't show error or success page; likely an issue with the XML data; same thing happens in drivers when dEsigner doesn't like xml content.
* Driver now isn't shutting down; publsiher thread had to time out . . .
* Had a few bumps: admin was "cn=\\ admin,o=services", missing containers . .
* now - just migrated first user!! 12/20/2018 10:42:10 AM

12/20/2018 10:50:29 AM

*     Noticed invalid dn syntax when tryhing to regsiter the driver wit hte change log module . .
* found it was cn=\\ admin,o=services; this user is the admin in azure idv, not azure auth

Driver is working, started migration.
12/20/2018 2:05:20 PM
found some containers that may need to be created . .

ou=IDM,ou=System,o=DIV
ou=External,ou=Users,o=DIV
ou=Internal,ou=Users,o=DIV
ou=Users,o=DIV
ou=IDM,ou=System,o=DIV

Started synchronizing about 16 K users
12:33:30
02:08:54 pm - 1064 users synchronized, 95 mins
about .18 users per second, or about 5 seconds for every user.

2:30:07 - 1115 users
3:04:12 - 1608 users

12/21/2018 1:26:05 PM

Next day - all done, about 3506 users not migrated; only 457 are candidates (employeestatus=1), but they dn't meet placement rule items.
