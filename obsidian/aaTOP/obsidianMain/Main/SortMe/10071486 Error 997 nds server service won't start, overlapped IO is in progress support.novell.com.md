# 10071486: Error: "997 nds server service won't start, overlapped IO is in progress" [support.novell.com]

# Error: "997 nds server service won't start, overlapped IO is in progress"

## (Last modified: 30Aug2005)

This document (**10071486**) _is provided subject to the [disclaimer](http://support.novell.com/docs/Tids/Solutions/10071486.html#disclaimer) at the end of this document._

### fact

Microsoft Windows 2000

Novell eDirectory 8.7 for All Platforms

Novell eDirectory 8.7.1 for All Platforms

Novell eDirectory 8.6 for Windows 2000

Novell eDirectory 8.6 for Windows NT

Novell eDirectory 8.5 for Windows 2000

Novell eDirectory 8.5 for Windows NT 4.0

### symptom

Error:  "997 nds server service won't start, overlapped IO is in progress"

eDirectory database is closed and will not open

Getting insufficient disk space error

NDS Server service will not start without the above error

### cause

eDirectory database is corrupt

### fix

There are two ways to resolve this problem.  The first is to try running DSREPAIR to repair the corrupt database.  The second option is to remove DS from the Win2k server and reinstall DS. 
To use DSREPAIR to fix the problem, you will need to run DSREPAIR in protected mode since the DSREPAIR.DLM service isn't available.  Do the following:
1.  Open a command prompt and go to the **novell\\NDS\\DIBFiles** directory.
2.  At the prompt type **..\\dhost DSREPAIR** and hit Enter
3.  If you get an error saying the database is closed, click OK
4.  Once DSREPAIR starts, go to Repair and then Local DS Database Repair
5.  Accept the default options and start the repair
6.  If the repair finishes successfully, try to exit out of DSREPAIR and hopefully the database will unlock itself.
If the above option doesn't work, you'll need to remove DS from the server.  You can do this using the **install.dlm**.  If the server held any Master replicas, you'll need to designate other servers as the new Masters.  To try to gracefully remove DS, go back to the **novell\\NDS\\DIBFiles** directory and type **..\\dhost install**.  This will bring up the NDS Install Utility.  Once open try to Remove Directory Services from this server and Finish.  If you get an error here, you may have to delete the DIB files from the DIBFiles directory.  NOTE:  if you do this, you will need to manually delete the NDS server object and any other server related objects from the tree.  Use **..\\dhost install** again if you need to and try to reinstall DS on the server.

If you are unable to remove Directory Services from the server using the above process, then a manual uninstall may be necessary.  For information on how to manually remove eDirectory from a Windows server see [TID #10058219  - How to manually uninstall Novell eDirectory off of a Windows Server](http://support.novell.com/docs/Tids/Solutions/10058219.html)

### note

It has been noted with some customers that if the dsrepair process does not successfully clear this error, a full power cycle of the affected server after the repair has completed resolves the issue without the need for removal of eDirectory.

### document

|     |     |
| --- | --- |
| **Document Title:** | Error: "997 nds server service won't start, overlapped IO is in progress" |
| **Document ID:** | 10071486 |
| **Solution ID:** | NOVL80138 |
| **Creation Date:** | 28May2002 |
| **Modified Date:** | 30Aug2005 |
| **Novell Product Class:** | Groupware<br>Novell eDirectory |

### disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information.
Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.
