# The iManager configure page is missing features [www.novell.com]

# The iManager configure page is missing features

This document **(7002140)** _is provided subject to the [disclaimer](http://www.novell.com/support/#disclaimer) at the end of this document._

### Environment

Novell iManager 2.5
Novell iManager 2.6
Novell iManager 2.7

### Situation

Module Installation Configuration Role is not Available in iManager
Configure iManager task does not appear in iManager
iManager Server configuration role is not available in iManager
iManager Server Role is not available in iManager
Plug-in Installation Role is not available in iManager
Module Installation Configuration Role available in one tree but not another with same iManager instance

### Resolution

By default only the user that installed iManager has rights to see the Configure iManager task.  If this user was not configured properly durring install or other users need access the configiman.properties file needs to be modified.
NetWare 6.5:                                sys:\\tomcat\\4\\webapps\\nps\\WEB-INF\\configiman.properties
NetWare 6.5 sp7 or greater:        sys:\\tomcat\\5\\webapps\\nps\\WEB-INF\\configiman.properties
OES:                                             /var/opt/novell/iManager/nps/WEB-INF/configiman.properties
OES2:                                          /var/opt/novell/tomcat5/nps/WEB-INF/configiman.properties
Windows:                                    C:\\Program Files\\Novell\\Tomcat\\webapps\\nps\\WEB-INF\\configiman.properties
The tree name must be included in the distinguished name of the user added (example admin.novell.mytree). To designate all users as authorized users type AllUsers in the file.

Examples:

**admin.novell.CORP\_TREE=eDirectory
**
**user1.worldwide.EMPLOYEE\_TREE=eDirectory
**

OR

**AllUsers=true
**

Once you have added yourself as an authorized user, you may use iManager to manage the list.  Log into iManager as an authorized user | Configure icon | iManager Server | Configure iManager | Security tab | Authorized Users section.  NOTE: if you want to add All Users as authorized users, it is not necessary to include the "=true" parameter.  Simply specifying AllUsers is sufficient.
It is possible with eDirectory 8.8 to have one iManager instance servicing two eDirectory trees all on the same box.  The user who first installed iManager will show up in the configiman.properties file and be able to modify modules while an admin in another tree, who possibly has the exact same context and is logging into the exact same iManager instance, will not be able to view or modify modules like the first admin who actually installed iManager,because his tree name is different.  Keep in mind that using explicit user listings as shown in the examples means those users are tree-specific.

You can use the method listed above in iManager to add users from different Trees to the authorized user list.  In this case you must just type in the full DN, as you can't browse to a DN in a different tree within iManager

### Additional Information

Formerly known as TID# 10098023
Formerly known as TID# NOVL102450

### Document

|     |     |
| --- | --- |
| **Document ID:** | 7002140 |
| **Creation Date:** | 12-09-2008 |
| **Modified Date:** | 05-26-2010 |
| **Novell Product:** | iManager |

### Disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information.
Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.
