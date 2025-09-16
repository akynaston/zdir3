# Blogs - Exchange Team Blog - Site Home - TechNet Blogs [blogs.technet.com]

* [Sign in](https://login.live.com/login.srf?wa=wsignin1.0&amp;wtrealm=blogs.technet.com&amp;wreply=https%3a%2f%2fblogs.technet.com%2fb%2fexchange%2farchive%2f2010%2f02%2f04%2f3409289.aspx%3fstoAI%3d10&amp;wp=MBI_FED_SSL&amp;wlcxt=microsoft%24microsoft%24microsoft)

 **<http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx>**

![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.7.png]]
[![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.2.png]]](http://blogs.technet.com/b/exchange/)

* [Home](http://blogs.technet.com/b/exchange/)

* [Library  ![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.1.png]]](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx)  
* [Forums](http://social.technet.microsoft.com/Forums/en-us/category/exchange2010,exchangeserver)
* [Wiki](http://social.technet.microsoft.com/wiki/contents/articles/wiki-exchange-server-portal.aspx)
* [TechCenter](http://go.microsoft.com/fwlink/?linkid=34165)
[![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.png]]](http://www.twitter.com/MSFTExchange) [![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.6.png]]](http://www.youtube.com/user/MSExchangeTeam)

### Troubleshooting Exchange 2010 Management Tools startup issues

![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.10.png]]![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.4.png]]![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.10.png]]![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.4.png]]![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.10.png]]![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.4.png]]![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.10.png]]![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.4.png]]![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.5.png]]![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.3.png]]
		![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/avatar.jpg]] [The Exchange Team](http://social.technet.microsoft.com/profile/The%20Exchange%20Team)
4 Feb 2010 2:58 PM

* **[14](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#comments)**

**EDIT 12/7/2010: For additional help resolving those issues, please see our newer blog post [Resolving WinRM errors and Exchange 2010 Management tools startup failures](http://msexchangeteam.com/archive/2010/12/07/457139.aspx)**.

In this blog post, we will be highlighting some of the most common errors that may be seen when attempting to open the Exchange Management tools (Exchange Management Console and Exchange Management Shell).

To start off, you first need to be aware that in Exchange 2010, all management is done via Remote PowerShell, even when opening the Management Tools on an Exchange server. Where this differs from Exchange 2007 is that there is now a much larger dependency on IIS, as Remote PowerShell requests are sent via the HTTP protocol and use IIS as the mechanism for connections. IIS works with the WinRM (Windows Remote Management) service, and the WSMan (Web Services for Management) protocol to initiate the connection.

When you click on the Exchange Management Shell shortcut, a Remote PowerShell session is opened. Instead of simply loading the Exchange snap-in (as we did with Exchange 2007), PowerShell connects using IIS to the closest Exchange 2010 server via WinRM. WinRM then performs authentication checks, creates the remote session and presents to you the cmdlets that you have access to via RBAC (Role Based Access Control).

![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.8.jpeg]]

Since all Remote PowerShell connections go through IIS, we have identified some of the most common errors that may be exhibited when attempting to open the Exchange Management tools along with the most common causes of those errors and how to address these issues. We have attempted to list these in order of frequency.

**Issue:**

> ##### Connecting to remote server failed with the following error message: The WinRM client cannot process the request. It cannot determine the content type of the HTTP response from the destination computer. The content type is absent or invalid. For more information, see the about\_Remote\_Troubleshooting Help topic.

Possible causes:

1\. Remote PowerShell uses Kerberos to authenticate the user connecting. IIS implements this Kerberos authentication method via a native module. In IIS Manager, if you go to the PowerShell Virtual Directory and then look at the Modules, you should see Kerbauth listed as a Native Module, with the dll location pointing to C:\\Program Files\\Microsoft\\Exchange Server\\v14\\Bin\\kerbauth.dll. If the Kerbauth module shows up as a Managed module instead of Native, or if the Kerbauth module has been loaded on the Default Web Site level (instead of, or in addition to, the PowerShell virtual directory), you can experience this issue. To correct this, make sure that the Kerbauth module is not enabled on the Default Web Site, but is only enabled on the PowerShell virtual directory. The entry type of "Local" indicates that the Kerbauth module was enabled directly on this level, and not inherited from a parent.

~~w~~![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/unknown_filename.9.jpeg]]

2\. If the WSMan module entry is missing from the global modules section of the C:\\Windows\\System32\\Inetsrv\\config\\ApplicationHost.config file, as follows:

> <globalModules>
>            <add name="WSMan" image="C:\\Windows\\system32\\wsmsvc.dll" />

This will result in the WSMan module displaying as a Managed module on the PowerShell virtual directory.

To correct this, make sure that the WSMan module has been registered (but not enabled) at the Server level, and has been enabled on the PowerShell virtual directory.

3\. If the user that is attempting to connect is not Remote PowerShell enabled. To check if a user is enabled for Remote PowerShell, you need to open the Exchange Management Shell with an account that has been enabled, and run the following query.

> (Get-User <username>).RemotePowershellEnabled

This will return a True or False. If the output shows False, the user is not enabled for Remote PowerShell. To enable the user, run the following command.

> Set-User <username> -RemotePowerShellEnabled $True

**Issue:**

> **Connecting to the remote server failed with the following error message: The WinRM client sent a request to an HTTP server and got a response saying the requested HTTP URL was not available. This is usually returned by a HTTP server that does not support the WS-Management protocol. For more information, see the about\_Remote\_Troubleshooting Help topic.**

Possible Causes:

1\. The http binding has been removed from the Default Web Site. A common scenario for this is if you are running multiple web sites, and attempting to set up a redirect to https://mail.company.com/owa by requiring SSL on the Default Web Site, and creating another web site to do the redirect back to the SSL-enabled website.

Remote PowerShell requires port 80 to be available on the Default Web Site. If you want to set up an automatic redirect to /owa and redirect http requests to https, you should follow the instructions located at <http://technet.microsoft.com/en-us/library/aa998359(EXCHG.80).aspx> and follow the directions under the section **"For a Configuration in Which SSL is Required on the Default Web Site or on the OWA Virtual Directory in IIS 7.0"**.

2\. The http binding on the Default Web Site has been modified, and the Hostname field configured. To correct this issue, you need to clear out the Hostname field under the port 80 bindings on the Default Web Site.

**Issue:**

> ##### Connecting to remote server failed with the following error message: The WinRM client received an HTTP server error status (500), but the remote service did not include any other information about the cause of the failure. For more information, see the about\_Remote\_Troubleshooting Help topic. It was running the command 'Discover-ExchangeServer -UseWIA $true -SuppressError $true'.

In addition, you may see the following warning event in the System log:

> Source: Microsoft-Windows-WinRM
> EventID: 10113
> Level: Warning
> Description: Request processing failed because the WinRM service cannot load data or event source: DLL="%ExchangeInstallPath%Bin\\Microsoft.Exchange.AuthorizationPlugin.dll"

Possible Causes

1\. The ExchangeInstallPath variable may be missing. To check this, go to the System Properties, Environment variables, and look under the System variables. You should see a variable of ExchangeInstallPath with a value pointing to C:\\Program Files\\Microsoft\\Exchange Server\\V14\\.

2\. The Path of the Powershell virtual directory has been modified. The PowerShell virtual directory must point to the \\Program Files\\Microsoft\\Exchange Server\\v14\\ClientAccess\\PowerShell directory or you will encounter problems.

**Issue:**

> **Connecting to remote server failed with the following error message: The connection to the specified remote host was refused. Verify that the WS-Management service is running on the remote host and configured to listen for requests on the correct port and HTTP URL. For more information, see the about\_Remote\_Troubleshooting Help topic.**

Possible Causes:

1\. Make sure the MSExchangePowerShellAppPool is running. If it is, try recycling the Application Pool and check for errors or warnings in the Event logs.

2\. Make sure that the user that is trying to connect is Remote PowerShell Enabled (see the first error for details on how to check this).

3\. Make sure WinRM is properly configured on the server.

> a. Run WinRM Quick Config on the server and ensure that both tests pass and no actions are required. If any actions are required, answer Yes to the prompt to allow the WinRM configuration changes to be made.

> b. Run WinRM enumerate winrm/config/listener and ensure that a listener is present for the HTTP protocol on port 5985 listening on all addresses.

**Issue:**

> ##### Connecting to remote server failed with the following error message: The WinRM client received an HTTP status code of 403 from the remote WS-Management service.

Possible Causes:

1\. The "Require SSL" option has been enabled on the PowerShell Virtual Directory. To resolve this, remove the "Require SSL" option from this Virtual Directory. The Exchange Management Tools connect over port 80, not 443, so if Require SSL is set, when a connection is attempted on port 80, IIS will return a 403 error indicating SSL is required.

\- [Ben Winzenz](http://msexchangeteam.com/archive/2007/01/26/432421.aspx), Solange Trombini

* [14 Comments](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#comments)

[Troubleshooting](http://blogs.technet.com/b/exchange/archive/tags/Troubleshooting/default.aspx), [Administration](http://blogs.technet.com/b/exchange/archive/tags/Administration/default.aspx), [Exchange 2010](http://blogs.technet.com/b/exchange/archive/tags/Exchange+2010/default.aspx), [Tips 'n Tricks](http://blogs.technet.com/b/exchange/archive/tags/Tips+_2700_n+Tricks/default.aspx)

[![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/facebook.gif]]](http://www.facebook.com/sharer.php?u=http%3A%2F%2Fblogs.technet.com%2Fb%2Fexchange%2Farchive%2F2010%2F02%2F04%2F3409289.aspx&amp;t=Troubleshooting%20Exchange%202010%20Management%20Tools%20startup%20issues)
[![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/linkedin.gif]]](http://www.linkedin.com/shareArticle?mini=true&amp;ro=true&amp;summary=&amp;source=Microsoft&amp;armin=armin&amp;url=http%3A%2F%2Fblogs.technet.com%2Fb%2Fexchange%2Farchive%2F2010%2F02%2F04%2F3409289.aspx&amp;title=Troubleshooting%20Exchange%202010%20Management%20Tools%20startup%20issues)
[![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/reddit.gif]]](http://www.reddit.com/submit?url=http%3A%2F%2Fblogs.technet.com%2Fb%2Fexchange%2Farchive%2F2010%2F02%2F04%2F3409289.aspx&amp;title=Troubleshooting%20Exchange%202010%20Management%20Tools%20startup%20issues)
[![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/twitter.gif]]](https://twitter.com/share?status=Troubleshooting%20Exchange%202010%20Management%20Tools%20startup%20issues%20:%20http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx)

Leave a Comment

* **Name**

* **Comment**
* [Post](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#)

[Comments](http://blogs.technet.com/b/exchange/rsscomments.aspx?WeblogPostID=3409289)

		![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/anonymous.gif]] GoodThings2Life
	5 Feb 2010 1:35 AM
	[#](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#61990)
	
	I was just having the WinRM issue the other day and eventually figured it out on my own after stopping to realize the implication of requiring HTTPS on the OWA box, but once I did it was easily fixed. Still I will be bookmarking this one for future reference!
	
		![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/anonymous.gif]] Chris Lehr
	5 Feb 2010 4:02 AM
	[#](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#314021)
	
	Great article - pingback from
	<http://chrislehr.com/2010/02/exchange-2010-management-tool-start-up.htm>
	
		![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/anonymous.gif]] Serkan
	5 Feb 2010 10:29 AM
	[#](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#7101)
	
	Very Good Info
	pingback
	<http://get-mailbox.org/2010/02/exchange-2010-management-araclarinda-acilis-problemleri/>
	
		![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/anonymous.gif]] pesos
	11 Feb 2010 6:35 AM
	[#](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#176272)
	
	Since adding a 3rd exchange server (and DAG member) the win2008 server that I have my management tools on seems to take FOREVER to get the EMC to load.  Any idea why this might be?  It is still connecting to the primary server and not the new one...
	
		![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/anonymous.gif]] David
	12 Feb 2010 7:55 PM
	[#](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#276394)
	
	It's maybe out of context.  But I really think Microsoft should inform us when a bug occurs.  Currently, the only way to figure it out is
	It's always painful to find out what is going on for every Microsoft product.  You should keep a KB for the more frequent bugs out of the usual KB.  A special dedicated KB for the problems we may encounter during the installation et configuration process of Exchange 2010.  The information with Microsoft is not very well organized.  technet is very technical and it's not the place to solve an issue in 5 minutes.  
	here are a few examples of some problems we've encountered during de Exchange 2010 depployment.  The solution for those problems were no where to be found in the Books.  We had to ask, call, looking everywhere on the web...
	1) An IIS directory entry couldn’t be created.  The error message is Access is denied.
	. HResult = -2147024891
	\+ CategoryInfo      : NotInstalled: (<mailstorename>\\Exchange (Default Web Site):ADObjectId) \[Get-OwaVirtualDirectory\], IISGeneralCOMException
	\+ FullyQualifiedErrorId : 4B6B88BA,Microsoft.Exchange.Management.SystemConfigurationTasks.GetOwaVirtualDirectory
	
		![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/anonymous.gif]] test11
	1 Mar 2010 5:27 PM
	[#](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#106834)
	
	Same error as 2nd issue will occur, if you have set proxy in winhttp (netsh winhttp set proxy) and you dont have exception for internal domain suffix.... (or for the exchange server itself). This happens even if you are runing EMS/EMC localy on exchange server.
	
		![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/anonymous.gif]] MarkusWE
	10 Mar 2010 2:20 PM
	[#](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#194470)
	
	another reason for the error : Connecting to remote server failed with the following error message: The WinRM client received an HTTP server error status (500), but the remote service did not include any other information about the cause of the failure. For more information, see the about\_Remote\_Troubleshooting Help topic. It was running the command 'Discover-ExchangeServer -UseWIA $true -SuppressError $true'
	can be a result of a change of the Application Pool for Powershell (e.g. after installation of CRM)
	
		![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/anonymous.gif]] Jon Webster
	19 Mar 2010 10:25 PM
	[#](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#258581)
	
	Hey Ben,
	I got this error "The WinRM client cannot process the request. It cannot determine the content type of the HTTP response from the destination computer. The content type is absent or invalid."
	and eventually traced it back to a missing globalModules entry. Here's a suggested revision to step 2 that includes making sure kerbauth module entry exists too.
	2\. If the WSMan -or kerbauth- module entry is missing from the global modules section of the C:\\Windows\\System32\\Inetsrv\\config\\ApplicationHost.config file, as follows:
	   <globalModules>
	              <add name="WSMan" image="C:\\Windows\\system32\\wsmsvc.dll" />
	\--            <add name="kerbauth" image="D:\\Program Files\\Microsoft\\Exchange Server\\V14\\Bin\\kerbauth.dll" /> --
	
		![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/anonymous.gif]] bwinzenz
	19 Mar 2010 11:40 PM
	[#](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#131175)
	
	Thanks for the comments, test11, MarkusWE and Jon!
	We'll definitely look into adding your suggestions.  I couldn't reproduce any of those specific items when doing my testing, and the intent behind this was to catch the most common scenarios, not every cause, but if some of these are being encountered more frequently, it definitely makes sense to add this information.
	@Jon - good catch on this.  I suspect that if you would have gone to the Modules in IIS at the Server level, and chosen to Configure Native Modules, you would not have seen Kerbauth in the list.  Normally if it doesn't exist in the Applicationhost.config file, it won't show up as a registered module either.  I'll see what I can do to get the steps modified and make it more straight-forward.
	
		![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/anonymous.gif]] Matt Sullivan
	24 Mar 2010 3:12 PM
	[#](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#108108)
	
	None of these suggestions worked for me in Exchange 2010
	
		![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/anonymous.gif]] Az3ar
	25 Mar 2010 5:47 PM
	[#](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#229349)
	
	Got the first error 2010 Exchange on 08R2 in test envo... Instruction dont make sense because under IIS 7 and Powershell I dont see Kerbauth!!! Bad instruction and bad English.  
	
		![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/anonymous.gif]] Az3ar
	25 Mar 2010 6:34 PM
	[#](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#335620)
	
	for the love god what doe sthat mean
	To correct this, make sure that the WSMan module has been registered (but not enabled) at the Server level, and has been enabled on the PowerShell virtual directory
	
		![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/anonymous.gif]] Menko
	27 Mar 2010 12:08 AM
	[#](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#278962)
	
	What also helps is adding the admin account you are seeing the errors with to the group "Organization Management".
	This can also be a group the admin is a member of.
	This issue can occur when you prepped Exchange in a multi-domain AD Forest using an account from the root domain.
	
		![[./_resources/Blogs_-_Exchange_Team_Blog_-_Site_Home_-_TechNet_Blogs_blogs.technet.com.resources/anonymous.gif]] And
	29 Mar 2010 5:42 PM
	[#](http://blogs.technet.com/b/exchange/archive/2010/02/04/3409289.aspx#293539)
	
	<globalModules> ...
	helps me to resolve problem.
	it works.
	MS does not use shared memory
	transport for local management tools..
	strange. mb, that is cost for unification??
	and everyone goes through IIS mods.
	

	

### Exchange TechNet Resources

* [Exchange TechCenter](http://technet.microsoft.com/en-us/exchange/default.aspx)

* [Exchange Server 2010](http://technet.microsoft.com/en-us/exchange/dd203064.aspx)
* [Exchange Server 2007](http://technet.microsoft.com/en-us/exchange/bb330841.aspx)
* [TechNet Library](http://technet.microsoft.com/en-us/library/aa996058.aspx)
* [Forums](http://social.technet.microsoft.com/Forums/en-US/category/exchangeserver/)

### Other Microsoft Team Blogs

* [Exchange Development Blog](http://blogs.msdn.com/b/exchangedev/)

* [The NextHop (Lync) Community](http://technet.microsoft.com/en-us/lync/gg213847)
* [The Microsoft Windows Blog](http://www.windowsteamblog.com/)
* [The Microsoft Office Blog](http://blogs.office.com/)
* [Bing Community](http://blogs.technet.com/b/exchange/archive/2010/02/04/www.bing.com/community)

### Quick Links

* [Buy Now](http://www.microsoft.com/exchange/en-us/how-to-buy.aspx)

* [Exchange Online](http://www.microsoft.com/online/exchange-online.aspx)
* [Forefront Protection 2010 for Exchange Server](http://www.microsoft.com/forefront/protection-for-exchange/en/us/default.aspx)
* [Forefront Online Protection for Exchange](http://www.microsoft.com/fope)
* [Microsoft Office 365](http://office365.microsoft.com/en-US/online-services.aspx)

### Support

* [Exchange Server Forums](http://social.technet.microsoft.com/Forums/en-us/category/exchangeserver)

* [Exchange Server 2010](http://technet.microsoft.com/en-us/exchange/2010/ff396001.aspx)
* [Exchange Server 2007](http://technet.microsoft.com/en-us/exchange/2010/bb288463.aspx)
* [Exchange Server DevCenter](http://msdn.microsoft.com/en-us/exchange/default.aspx)
* [Exchange Server Wiki](http://social.technet.microsoft.com/wiki/contents/articles/wiki-exchange-server-portal.aspx)

### Cool Community Links

* [MSExchange.org](http://www.msexchange.org/)

* [Tony Redmond's Blog](http://thoughtsofanidlemind.wordpress.com/)
* [MSExchangeGuru's Blog](http://msexchangeguru.com/)
* [The Master Blog](http://blogs.technet.com/b/themasterblog/)
* [Ask Perry](http://blogs.technet.com/b/perryclarke/)
* [More...](http://blogs.technet.com/b/exchange/p/cool-community-links.aspx)

* © 2011 Microsoft Corp.

* [Terms of Use](http://technet.microsoft.com/cc300389)
* [Trademarks](http://www.microsoft.com/library/toolbar/3.0/trademarks/en-us.mspx)
* [Privacy Statement](http://www.microsoft.com/info/privacy.mspx)
* 
* [About](http://blogs.technet.com/b/exchange/about.aspx)
