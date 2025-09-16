# Unrestricted access in imanager

Unrestricted access in imanager

* * *

## **2.3** Access Modes

When you start iManager, you are granted an **access mode** based on the rights you've been assigned. iManager has three access modes. The mode you are in is displayed on the iManager home page.

_Unrestricted Access:_ This is the default mode before RBS is configured. It displays all of the roles and tasks installed. Although all roles and tasks are visible, the authenticated user still needs the necessary rights to use the tasks.

There is a setting that you can add to the config.xml file which forces Unrestricted Access, even if Role-Based Services is installed. To force Unrestricted Access for all users, add this setting to TOMCAT\_HOME\\webapps\\nps\\WEB-INF\\config.xml, then restart Tomcat:

<setting>

<name><!\[CDATA\[RBS.forceUnrestricted\]\]></name>

<value><!\[CDATA\[true\]\]></value>

</setting>

For information about restarting Tomcat, see [Starting and Stopping Tomcat](http://www.novell.com/documentation/imanager27/imanager_admin_273/b8g1mv6.html#b8fxnyd).

_NOTE:_When using iManager in Unrestricted mode, you typically see the following message on the iManager Home Page: Notice: Some of the roles and tasks are not available. Clicking _View Details_ might display a Not supported by current authenticators message for several of the tasks, even though the tasks work correctly. This message is misleading, and iManager removes these messages after you configure RBS.

_Assigned Access:_ Displays only the roles and tasks assigned to the authenticated user. This mode takes full advantage of the Role-Based Services technology.

_Collection Owner:_ Displays all of the roles and tasks installed in the collection. If you are a collection owner, though you are not assigned specific roles, it allows you to use all the roles and tasks in the collection. Role-Based Services must be installed in order to use this mode. Adding a group or user as a collection owner does not assign any RBS rights. To assign rights you must make explicit RBS role assignments or make trustee assignments.

_NOTE:_When collection is assigned to a group, all the members of that group get the collection ownership. The collection owner sees all roles and tasks, regardless of role membership.

|     |     |     |
| --- | --- | --- |
|     | [![prev.gif](http://www.novell.com/docui2002/images/prev.gif)](http://www.novell.com/documentation/imanager27/imanager_admin_273/bouqst6.html) ![virt_dot-line.gif](http://www.novell.com/docui2002/images/virt_dot-line.gif) [![next.gif](http://www.novell.com/docui2002/images/next.gif)](http://www.novell.com/documentation/imanager27/imanager_admin_273/bu6vkj8.html) |     |

|     |     |
| --- | --- |
| ![[./_resources/Unrestricted_access_in_imanager.resources/unknown_filename.gif]] | **user comments** |

**comment:** there are currently no user comments for this page.
[Add Comment![[./_resources/Unrestricted_access_in_imanager.resources/unknown_filename.2.gif]]![[./_resources/Unrestricted_access_in_imanager.resources/unknown_filename.1.gif]]](http://developer.novell.com/docadd/addcomment.php?url=http://www.novell.com/documentation/imanager27/imanager_admin_273/data/am4foy0.html)
