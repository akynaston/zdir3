# Ldapwiki: Using dsbk on Windows [ldapwiki.willeke.com]

> [Welcome](http://ldapwiki.willeke.com/wiki/One%20Minute%20Wiki)
> 
> to [LDAP Wiki](http://ldapwiki.willeke.com/wiki/About)

[Home](http://ldapwiki.willeke.com/wiki/Main)
_G’day (anonymous guest)_ [Log in](http://ldapwiki.willeke.com/Login.jsp?redirect=Using+dsbk+on+Windows) [My Prefs](http://ldapwiki.willeke.com/UserPreferences.jsp?redirect=Using+dsbk+on+Windows)
Using dsbk on Windows
Your trail: 

* [Edit](http://ldapwiki.willeke.com/Edit.jsp?page=Using%20dsbk%20on%20Windows)

* [More...](http://ldapwiki.willeke.com/wiki/MoreMenu)

  [Info](http://ldapwiki.willeke.com/PageInfo.jsp?page=Using%20dsbk%20on%20Windows)

There is no dsbk executable for Windows. You use the dhostcon.exe to load the dsbk module which will then execute the backup.

### Pre-Requisites[#](http://ldapwiki.willeke.com/wiki/Using%20dsbk%20on%20Windows#section-Using+dsbk+on+Windows-PreRequisites)

* You must run the commands as a member of the Administrators group

* When running at the console, you must run as administrator
* You MUST enable roll-forward logging
* Read [Novell DSBK Documentation](http://www.novell.com/documentation/edir88/edir88/?page=/documentation/edir88/edir88/data/bsl7jmp.html)![[./_resources/Ldapwiki_Using_dsbk_on_Windows_ldapwiki.willeke.com.resources/unknown_filename.png]]

### Full Backup[#](http://ldapwiki.willeke.com/wiki/Using%20dsbk%20on%20Windows#section-Using+dsbk+on+Windows-FullBackup)

dhostcon.exe 10.120.2.231 load dsbk backup -b -e secretnicipassword -f D:\\backup\\2010-11-01-03-full.bac -l E:\\novell\\logs\\backup\\2010-11-01-03-dsbackup-full.log -t -w

#### The Parameters[#](http://ldapwiki.willeke.com/wiki/Using%20dsbk%20on%20Windows#section-Using+dsbk+on+Windows-TheParameters)

The parameters on the command line are:

* \-b - Do a full backup

* \-f - The file where the actual backup is to be written
* \-l - The file where the session log is written.
* \-t - (Optional) Back up stream files. Includes the stream files when backing up the eDirectory database.
* \-w - (Optional) Overwrite existing backup file of same name
* \-e password - (Optional) Perform a NICI backup. The password specifies the NICI backup password. **The same password has to be specified to restore the NICI files.**

From our testing appears if the -i and -b are missing, a Full backup is performed.

The output log showed:

|==================DSBackup Log: Backup================|
Backup type: Full
Log file name: E:\\novell\\logs\\backup\\2010-11-01-03-dsbackup-full.log
Backup started: 2010-11-1'T8:46:9
Backup file name: D:\\backup\\2010-11-01-03-full.bac
Server name: \\T=SW-DEV-LDAP\\dc=com\\dc=willeke\\OU=Servers\\CN=SERVERNAME-NDS
Current Roll Forward Log: 00000018.log
DS Version: 2050205
Backup ID: 4CCEB691
NICI BACKUP: "NICI Files has been backed up Successfully"
Starting database backup...
Database backup finished
Completion time 00:04:56
Backup completed successfully

### Incremental Backup[#](http://ldapwiki.willeke.com/wiki/Using%20dsbk%20on%20Windows#section-Using+dsbk+on+Windows-IncrementalBackup)

dhostcon.exe 192.168.2.231 load dsbk backup-i -f D:\\backup\\2010-11-01-03-diff.bac -l E:\\novell\\logs\\backup\\2010-11-01-03-dsbackup.diff.log -t -w

#### The Parameters[#](http://ldapwiki.willeke.com/wiki/Using%20dsbk%20on%20Windows#section-Using+dsbk+on+Windows-TheParameters-2)

The parameters on the command line are:

* \-i - (Optional) Perform an incremental backup. Performs an incremental backup of the eDirectory database. This will back up any changes made to the database since the last full or incremental backup.
* \-f - The file where the actual backup is to be written
* \-l - The file where the session log is written.
* \-t - (Optional) Back up stream files. Includes the stream files when backing up the eDirectory database.
* \-w - (Optional) Overwrite existing backup file of same name

### Worth Noting[#](http://ldapwiki.willeke.com/wiki/Using%20dsbk%20on%20Windows#section-Using+dsbk+on+Windows-WorthNoting)

We did not backup [NICI](http://ldapwiki.willeke.com/wiki/NICI) in the incremental You might also not backup "stream" files if they do not change often.

The output log showed:

|==================DSBackup Log: Backup================|
Backup type: Incremental
Log file name: E:\\novell\\logs\\backup\\2010-11-01-03-dsbackup.diff.log
Backup started: 2010-11-1'T8:21:51
Backup file name: D:\\backup\\2010-11-01-03-diff.bac
Server name: \\T=SW-DEV-LDAP\\dc=com\\dc=willeke\\OU=Servers\\CN=SERVERNAME-NDS
Current Roll Forward Log: 00000018.log
DS Version: 2050205
Backup ID: 4CCEB0DF
Starting database backup...
Database backup finished
Completion time 00:05:19
Backup completed successfully

[«](http://ldapwiki.willeke.com/wiki/Using%20dsbk%20on%20Windows#top) This page (revision-8) was last changed on [01-Nov-2010 09:00](http://ldapwiki.willeke.com/Diff.jsp?page=Using%20dsbk%20on%20Windows&amp;r1=8&amp;r2=7) by [jim](http://ldapwiki.willeke.com/wiki/Jim)  <http://ldapwiki.willeke.com/rss.jsp?page=Using%20dsbk%20on%20Windows&amp;mode=wiki>

[Main page](http://ldapwiki.willeke.com/wiki/Main)
[About](http://ldapwiki.willeke.com/wiki/About)
[Recent Changes](http://ldapwiki.willeke.com/wiki/RecentChanges)
[Tools Page](http://ldapwiki.willeke.com/wiki/Tools)

* * *

#### Lead Pages[#](http://ldapwiki.willeke.com/wiki/Using%20dsbk%20on%20Windows#section-PosixGroup-LeadPages)

* [LDAP](http://ldapwiki.willeke.com/wiki/LDAP)

* [Novell IDM](http://ldapwiki.willeke.com/wiki/NovellsIDMProduct)
* [Access Manager](http://ldapwiki.willeke.com/wiki/NAM%20Technical%20Tid-bits)
* [eDirectory](http://ldapwiki.willeke.com/wiki/EDirectory)
* [Microsoft Active Directory](http://ldapwiki.willeke.com/wiki/Microsoft%20Active%20Directory)
* [Passwords](http://ldapwiki.willeke.com/wiki/Passwords)
* [Unix Linux](http://ldapwiki.willeke.com/wiki/UnixLinux)
* [Tech Bits](http://ldapwiki.willeke.com/wiki/TechBits)
* [Imanager](http://ldapwiki.willeke.com/wiki/Imanager)
* [Glossary](http://ldapwiki.willeke.com/wiki/GlossaryOfLDAPAndDirectoryTerminology)

* * *

[WikiEtiquette](http://ldapwiki.willeke.com/wiki/WikiEtiquette)
[Find pages](http://ldapwiki.willeke.com/wiki/FindPage)
[Unused pages](http://ldapwiki.willeke.com/wiki/UnusedPages)
[Undefined pages](http://ldapwiki.willeke.com/wiki/UndefinedPages)
[Page Index](http://ldapwiki.willeke.com/wiki/PageIndex)
[News](http://ldapwiki.willeke.com/wiki/News)

JSPWiki v2.8.4  <http://ldapwiki.willeke.com/ldapwiki.rdf>
