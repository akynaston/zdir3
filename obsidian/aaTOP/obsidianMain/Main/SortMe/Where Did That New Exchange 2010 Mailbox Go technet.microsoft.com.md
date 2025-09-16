# Where Did That New Exchange 2010 Mailbox Go? [technet.microsoft.com]

* [TechNet](http://technet.microsoft.com/)

* [Products](http://technet.microsoft.com/en-us/library/ff872148(v=exchg.141).aspx)
* [IT Resources](http://technet.microsoft.com/en-us/library/ff872148(v=exchg.141).aspx)
* [Downloads](http://technet.microsoft.com/en-us/library/ff872148(v=exchg.141).aspx)
* [Training](http://technet.microsoft.com/en-us/library/ff872148(v=exchg.141).aspx)
* [Support](http://technet.microsoft.com/en-us/library/ff872148(v=exchg.141).aspx)

[![[./_resources/Where_Did_That_New_Exchange_2010_Mailbox_Go_technet.microsoft.com.resources/BrandLogoExchange.png]]](http://technet.microsoft.com/exchange/)

[United States (English)](http://technet.microsoft.com/en-us/library/ff872148(v=exchg.141).aspx#)
[Sign in](https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=12&ct=1393282748&rver=6.0.5276.0&wp=MCLBI&wlcxt=TechNet%24TechNet%24TechNet&wreply=http%3a%2f%2ftechnet.microsoft.com%2fen-us%2flibrary%2fff872148%2528v%3dexchg.141%2529.aspx&lc=1033&id=254354&mkt=en-US)

[Home](http://technet.microsoft.com/exchange/bb219569) [Online](http://technet.microsoft.com/exchange/hh127068) [2013](http://technet.microsoft.com/exchange/fp179701) [2010](http://technet.microsoft.com/exchange/dd203064) [Other Versions](http://technet.microsoft.com/exchange/fp179699) [Library](http://technet.microsoft.com/library/aa996058(v=exchg.150)) [Forums](http://social.technet.microsoft.com/forums/en-us/category/exchangeserver,exchangeserverlegacy/) [Gallery](http://gallery.technet.microsoft.com/exchange) [EHLO Blog](http://blogs.technet.com/b/exchange/)

[Export (0)](http://technet.microsoft.com/en-us/library/export/help/?returnUrl=%2fen-us%2flibrary%2fff872148(v%3dexchg.141).aspx) [Print](http://technet.microsoft.com/en-us/library/ff872148(d=printer,v=exchg.141).aspx)
[[#|Collapse All]]

<http://technet.microsoft.com/en-us/library/ff872148(v=exchg.141).aspx#>[TechNet Library](http://technet.microsoft.com/en-us/library/aa991542.aspx)
<http://technet.microsoft.com/en-us/library/ff872148(v=exchg.141).aspx#>[Exchange](http://technet.microsoft.com/en-us/library/aa996058(v=exchg.150).aspx)
<http://technet.microsoft.com/en-us/library/ff872148(v=exchg.141).aspx#>[Exchange Server Technical Articles](http://technet.microsoft.com/en-us/library/bb187471(v=exchg.150).aspx)
<http://technet.microsoft.com/en-us/library/ff872148(v=exchg.141).aspx#>[Exchange Server 2010 Technical Articles](http://technet.microsoft.com/en-us/library/dd795096(v=exchg.141).aspx)
	[Deploy Exchange 2010 with the Deployment Assistant](http://technet.microsoft.com/en-us/library/ff709381(v=exchg.141).aspx)
	[Exchange Management Shell in Exchange 2010](http://technet.microsoft.com/en-us/library/dd795097(v=exchg.141).aspx)
	[Rebuild an Entire Database Availability Group](http://technet.microsoft.com/en-us/library/gg513521(v=exchg.141).aspx)
	[Time to Move from Exchange 2003](http://technet.microsoft.com/en-us/library/hh145599(v=exchg.141).aspx)
	[Where Did That New Exchange 2010 Mailbox Go?](http://technet.microsoft.com/en-us/library/ff872148(v=exchg.141).aspx)
	<http://technet.microsoft.com/en-us/library/ff872148(v=exchg.141).aspx#>[Technical White Papers for Exchange Server 2010](http://technet.microsoft.com/en-us/library/gg513524(v=exchg.141).aspx)

Related Help Topics
No resources found.

Related Blog Articles
No resources found.
[Ask a question](http://outlookliveanswers.com/forums)

Related Forum Discussions

* [Ask a question](http://go.microsoft.com/fwlink/?LinkId=163297)

* [Visit the forums](http://go.microsoft.com/fwlink/?LinkID=150026)
* [Exchange 2007](http://technet.microsoft.com/en-us/library/ff872148(v=exchg.80).aspx)
* [Exchange 2010](http://technet.microsoft.com/en-us/library/ff872148(v=exchg.140).aspx)

[[#|![[./_resources/Where_Did_That_New_Exchange_2010_Mailbox_Go_technet.microsoft.com.resources/ImageSprite.png]]]]
	

# Where Did That New Exchange 2010 Mailbox Go?

11 out of 13 rated this helpful \- [Rate this topic](http://technet.microsoft.com/en-us/library/ff872148(v=exchg.141).aspx#feedback)

 

_**Topic Last Modified:** 2010-07-29_

You're an administrator, and you've installed a few servers running Microsoft Exchange Server 2010. You know that mailboxes are stored in mailbox databases, and, based on previous versions of Exchange, you know that you need to specify a mailbox database when you create a mailbox. One day, you go to create a mailbox and forget to specify a mailbox database. And you don't get an error. And then you ask “Where’d it go?". You eventually discover that the mailbox was created on some random mailbox database that you didn't specify yourself. You wonder what in the world just happened. Exchange administrator, meet automatic mailbox distribution.

Automatic mailbox distribution is a new feature in Exchange 2010. If you don't provide a mailbox database when you create a new mailbox on an Exchange 2010 server, Exchange picks a mailbox database for you. Now, you might see this as a really cool feature, or you might think it's pretty scary. I hope to demystify the selection process Exchange 2010 uses to select a mailbox database. Plus, I'll describe the controls you have over the process. Hopefully, armed with this information, you'll see automatic mailbox distribution as a tool you can use to simplify your life a bit.

[[#|How Automatic Mailbox Distribution Works]]

Automatic mailbox distribution is a process where Exchange 2010 looks at the mailbox databases in your organization, excludes databases that aren't suitable (using criteria I talk about later in this article), and then randomly chooses a database where the mailbox should be located.

Automatic mailbox distribution only happens when you don't specify a mailbox database in the following places:

* **Mailbox Settings** page in the New Mailbox wizard in the Exchange Management Console (EMC)
	

* _Database_ parameter on the **New-Mailbox** and **Enable-Mailbox** cmdlets
	
* _TargetDatabase_ parameter on the **New-MoveRequest** cmdlet
	
	| ![[./_resources/Where_Did_That_New_Exchange_2010_Mailbox_Go_technet.microsoft.com.resources/clear.gif]]<br>Note: |
	| --- |
	| You can use automatic mailbox distribution when you use the **New-MoveRequest** cmdlet, but you can't use it when you use the move request wizards in the EMC. |
	

It's important to note, however, that automatic mailbox distribution is performed _only_ when a mailbox is created on an Exchange 2010 server, moved to an Exchange 2010 server, or when a user is mailbox-enabled. The **New-Mailbox**, **New-MoveRequest**, and **Enable-Mailbox** cmdlets, and the EMC must be run from, or must be connected to, a server running Exchange 2010. Exchange doesn't redistribute mailboxes to distribute load across databases automatically based on server load. Exchange 2010 also doesn't take into account the database load or disk space available when choosing a database.

What some admins may find somewhat disconcerting is that Exchange randomly chooses the database where the mailbox should be located. But, no need for alarm because you have control over which databases Exchange can actually choose. In fact, you can use this to your advantage and take control out of the hands of junior or department-level admins or your help desk personnel and enforce company processes consistently using mailbox distribution. You can specify which databases should be excluded from the selection process entirely and which databases can only be selected when actions are taken by certain administrators.

| ![[./_resources/Where_Did_That_New_Exchange_2010_Mailbox_Go_technet.microsoft.com.resources/clear.gif]]<br>Note: |
| --- |
| The ability to control which databases certain administrators can create mailboxes in, or move mailboxes to, is a new feature of Exchange Server 2010 Service Pack 1 (SP1). If you're using the release to manufacturing (RTM) version of Exchange 2010, everything in this article still applies with the exception of database scopes. |

Exchange uses the following process to find a suitable mailbox database where a new or moved mailbox should be located:

1. Exchange retrieves a list of all mailbox databases in the Exchange 2010 organization.
	
2. Any mailbox database that's marked for exclusion from the distribution process is removed from the available list of databases. You can control which databases are excluded. For more information, see [How to Permanently or Temporarily Exclude Databases](http://technet.microsoft.com/en-us/library/ff872148(v=exchg.141).aspx#Exclude) later in this article.
	
3. Any mailbox database outside of the database management scopes applied to the administrator performing the operation is removed from the list of available databases. This step only applies if you're running Exchange 2010 SP1. For more information, see [How to Use Database Scopes to Select Databases for Mailbox Distribution](http://technet.microsoft.com/en-us/library/ff872148(v=exchg.141).aspx#Scopes) later in this article.
	
4. Any mailbox database that's outside of the local Active Directory site where the operation is being performed is removed from the list of available databases.
	
5. From the remaining list of mailbox databases, Exchange chooses a database randomly. If the database is online and healthy, the database is used by Exchange. If it's offline or not healthy, another database is chosen at random. If no online or healthy databases are found, the operation fails with an error.
	

The following figure illustrates the selection process I just described.

![[./_resources/Where_Did_That_New_Exchange_2010_Mailbox_Go_technet.microsoft.com.resources/IC423260.gif]]

Doing all the work in the process of selecting a mailbox database is the `Mailbox Resources Management Agent` cmdlet extension agent. The `Mailbox Resources Management Agent` is one of several cmdlet extension agents that extend the functionality of running cmdlets.

If you really decide that you don't want Exchange 2010 randomly distributing mailboxes to your databases, you can disable the `Mailbox Resources Management Agent`. When you disable the agent, the change is applied to the entire Exchange 2010 organization. For more information about how to disable cmdlet extension agents, see [Disable a Cmdlet Extension Agent](http://technet.microsoft.com/en-us/library/dd297998(v=exchg.141).aspx).

But, if you're intrigued by the idea of putting automatic mailbox distribution to work for you, read on. I'll explain how you can use mailbox distribution to spread the load of new mailboxes across multiple databases (except for "those" databases, which only "Department X" can use), instead of relying on your admins to do so. This means you can help your admins focus on supporting your users, instead of remembering which databases can be used, and when.

[[#|How to Permanently or Temporarily Exclude Databases]]

By default, all online and healthy mailbox databases on Exchange 2010 servers in the local Active Directory site can be chosen by automatic mailbox distribution to store a new or moved mailbox. However, you might want to exclude some databases from the distribution process for various reasons. For example, you may designate a mailbox database as a journaling database in which only mailboxes you manually specify should be located. Or, you might want to temporarily remove a database from rotation to perform scheduled maintenance. Exchange 2010 gives you the option to either permanently or temporarily exclude databases from the automatic mailbox distribution process.

Every Exchange 2010 mailbox database has the following two properties that you can set using the **Set-MailboxDatabase** cmdlet:

* **IsExcludedFromProvisioning**   Use this property if you want to _permanently_ exclude the database from automatic mailbox distribution. Use this property if you don't plan to include the database in the automatic mailbox distribution process.
	

* **IsSuspendedFromProvisioning**   Use this property if you want to _temporarily_ exclude the database from automatic mailbox distribution. Use this property if you plan to add the database back into the automatic mailbox distribution process sometime in the future.
	

The following figure illustrates the behavior of the **IsExcludedFromProvisioning** and **IsSuspendedFromProvisioning** properties that I just described. Both properties have two valid values, `$True` and `$False`, with the default being `$False`. Setting either property to `$True` has the same result of excluding the database from the automatic mailbox distribution process. However, both properties must be set to `$False` for a mailbox database to be included in the automatic mailbox distribution process.

![[./_resources/Where_Did_That_New_Exchange_2010_Mailbox_Go_technet.microsoft.com.resources/IC423261.gif]]

Whether you set the **IsExcludedFromProvisioning** property or the **IsSuspendedFromProvisioning** property to `$True` doesn't matter to Exchange 2010. Exchange 2010 simply checks to see if one of the properties is set to `$True`, and if so, excludes the database from the automatic mailbox distribution process.

This example sets a mailbox database as _permanently_ excluded from automatic mailbox distribution.

Set-MailboxDatabase <database name> -IsExcludedFromProvisioning $True

This example sets a mailbox database as _temporarily_ excluded from automatic mailbox distribution.

Set-MailboxDatabase <database name> -IsSuspendedFromProvisioning $True

When a mailbox database is excluded from automatic mailbox distribution, the only way to create a mailbox in, or move a mailbox to, the database is to select the database manually if you're using the Exchange 2010 console, use the _Database_ parameter on the **New-Mailbox** and **Enable-Mailbox** cmdlets in the Shell, or use the _TargetDatabase_ parameter on the **New-MoveRequest** cmdlet in the Shell.

If you want to make an excluded mailbox database available for selection in the automatic mailbox distribution process, set both properties to `$False`.

[[#|How to Use Database Scopes to Select Databases for Mailbox Distribution]]

Database management scopes are an additional level of control over the automatic mailbox distribution process that's been added to Exchange 2010 SP1. If a mailbox database is online and healthy, it's in the local Active Directory site, and it isn't excluded from the automatic mailbox distribution process. Exchange 2010 SP1 checks to see if the mailbox database is included in the database scope applied to the administrator running the cmdlet. If it's included in the database scope, it's included in the list of databases available to that administrator.

Database scopes are part of the Role Based Access Control (RBAC) permissions model. Database scopes can be useful if you have many mailbox databases in your local Active Directory site that are available to automatic mailbox distribution, but you want to restrict which databases can be used by certain sets of administrators. This could be the case if your Exchange 2010 SP1 servers serve several departments, but you only want to allow each department to create or move mailboxes to mailbox databases allocated to them. As an example of a database scope in action, the following figure shows:

* Six databases are available in the Exchange 2010 organization. Three databases are part of the Legal database scope, and three databases are part of the Sales database scope.
	

* An administrator is granted access to create mailboxes on any database in the Sales database scope. Exchange evaluates which database the administrator has access to and returns only the databases that are part of the Sales scope.
	
* Exchange then randomly selects one of the three remaining databases on which to create the mailbox.
	
![[./_resources/Where_Did_That_New_Exchange_2010_Mailbox_Go_technet.microsoft.com.resources/IC423262.gif]]

By default, all administrators in an Exchange 2010 SP1 organization can see all the mailbox databases in the organization. To limit the databases that they can see, and therefore restrict the databases they can potentially create mailboxes in, or move mailboxes to, you must do the following:

1. Create a custom database management scope using the **New-ManagementScope** cmdlet that includes only the mailbox databases you want the administrator to use.
	
2. Associate the new database scope with a management role assignment in one of the following ways:
	* Add the new database scope to an existing management role assignment using the _CustomConfigWriteScope_ parameter on the **Set-ManagementRoleAssignment** cmdlet. The database scope is now applied to the management role group, universal security group (USG), or user-assigned role assignment.
		
3. Create a management role assignment using the **New-ManagementRoleAssignment** cmdlet, and use the _CustomConfigWriteScope_ parameter to specify the new database scope. You can create a role assignment between a management role and a role group, USG, or user.
	
4. If you created a role assignment to a role group or USG, add users to the role group or USG so that the role assignment and database scope are applied to the users.
	
5. If applicable, remove the user (or users who are members of role groups or USGs you created in the preceding steps) you assigned the new role assignment to from any other role groups or USGs that might be assigned a database scope that contains databases you don't want them to access.
	
6. Verify that the administrators have access only to the databases they should have access to.
	

After you're done with these steps, the administrators assigned role assignments with the database scopes you created will only be able to create mailboxes in, or move mailboxes to, the databases you specified.

For more information about how to use database scopes to limit which mailbox databases are available to administrators, see [Control Automatic Mailbox Distribution Using Database Scopes](http://technet.microsoft.com/en-us/library/ff628332(v=exchg.141).aspx).

[[#|Where do you go from here?]]

Now that I've explained how automatic mailbox distribution works, take a look at your organization and see how you can make it work for you. Consider the following:

* **Do you have special-use mailbox databases?**   Use database exclusions to prevent automatic mailbox distribution from creating mailboxes on those databases. Admins no longer need to keep track of which databases they can use and which ones they can't.
	

* **Are departments assigned specific databases for their own use?**   Use database scopes to target only the databases that automatic mailbox distribution should use. Avoid situations where mailboxes are incorrectly created in the wrong department's database, which could have data retention or other requirements that differ from those of the database assigned to the correct department.
	
* **Is there more than one mailbox database for admins to choose from?**   Use automatic mailbox distribution, with or without database exclusions and scopes, to randomly select a database. Lessen the possibility of a specific database being preferred over others due to force of habit.
	

I hope you now have a better understanding of how Exchange 2010 uses automatic mailbox distribution to make your life a bit simpler, while still giving you the control you need to make it work the way you want. To learn more about the features discussed in this article, see the following topics:

* [Understanding Role Based Access Control](http://technet.microsoft.com/en-us/library/dd298183(v=exchg.141).aspx)
	
* [Understanding Management Role Scopes](http://technet.microsoft.com/en-us/library/dd335146(v=exchg.141).aspx)
	
* [Understanding Management Role Scope Filters](http://technet.microsoft.com/en-us/library/dd298043(v=exchg.141).aspx)
	
* [Understanding Recipients](http://technet.microsoft.com/en-us/library/bb201680(v=exchg.141).aspx)
	
* [Understanding Move Requests](http://technet.microsoft.com/en-us/library/dd298174(v=exchg.141).aspx)
	
* [Understanding Cmdlet Extension Agents](http://technet.microsoft.com/en-us/library/dd335067(v=exchg.141).aspx)
	

![[./_resources/Where_Did_That_New_Exchange_2010_Mailbox_Go_technet.microsoft.com.resources/IC423360.jpg]]
[David Strome](http://go.microsoft.com/fwlink/?LinkId=198277) - Senior Technical Writer, Microsoft Exchange Server User Education

 

Did you find this helpful?

Yes
No

## Community Additions

[ADD](http://technet.microsoft.com/en-us/library/community/add/ff872148(v=exchg.141).aspx)

© 2014 Microsoft

[Manage Your Profile](http://go.microsoft.com/?linkid=8786243)

* [Newsletter](http://technet.microsoft.com/cc543196.aspx)

* | [Contact Us](http://technet.microsoft.com/cc512759.aspx)
* | [Privacy Statement](http://go.microsoft.com/fwlink/?linkid=248681)
* | [Terms of Use](http://technet.microsoft.com/cc300389.aspx)
* | [Trademarks](http://www.microsoft.com/About/Legal/EN/US/IntellectualProperty/Trademarks/EN-US.aspx)

|

[[#|![[./_resources/Where_Did_That_New_Exchange_2010_Mailbox_Go_technet.microsoft.com.resources/ImageSprite.png]]
Site Feedback]]
