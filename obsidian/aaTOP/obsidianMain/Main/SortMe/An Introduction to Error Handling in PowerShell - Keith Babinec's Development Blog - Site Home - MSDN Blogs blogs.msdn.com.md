# An Introduction to Error Handling in PowerShell - Keith Babinec's Development Blog - Site Home - MSDN Blogs [blogs.msdn.com]

* [Sign in](https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=12&ct=1422982099&rver=6.0.5286.0&wp=MBI&wreply=http:%2F%2Fblogs.msdn.com%2Fb%2Fkebab%2Farchive%2F2013%2F06%2F09%2Fan-introduction-to-error-handling-in-powershell.aspx&lc=1033&id=271611)

# [Keith Babinec's Development Blog](http://blogs.msdn.com/b/kebab/)

Discussing helpful tips for development in C# and PowerShell

**[MSDN Blogs](http://blogs.msdn.com/)** \> **[Keith Babinec's Development Blog](http://blogs.msdn.com/b/kebab/)** \> **[An Introduction to Error Handling in PowerShell](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx)**

### An Introduction to Error Handling in PowerShell

Rate This
![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/unknown_filename.1.png]]![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/unknown_filename.png]]![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/unknown_filename.1.png]]![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/unknown_filename.png]]![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/unknown_filename.1.png]]![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/unknown_filename.png]]![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/unknown_filename.1.png]]![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/unknown_filename.png]]![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/unknown_filename.1.png]]![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/unknown_filename.png]]
[![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/avatar.jpg]]](http://blogs.msdn.com/504045/ProfileUrlRedirect.ashx) [Keith Babinec](http://blogs.msdn.com/504045/ProfileUrlRedirect.ashx)
9 Jun 2013 6:14 PM

* **[15](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#comments)**

Today’s post (and this blog's inaugural post!) is An Introduction to Error Handling in PowerShell. We will discuss error types, the _**$error**_ variable, error action preferences, try/catch blocks, and _**$lastexitcode**_.

The first requirement is to understand the types of errors that can occur during execution.

**Terminating vs. Non-Terminating Errors:**

* **Terminating Error**: A serious error during execution that halts the command (or script execution) completely. Examples can include non-existent cmdlets, syntax errors that would prevent a cmdlet from running, or other fatal errors.
* **Non-Terminating Error**: A non-serious error that allows execution to continue despite the failure. Examples include operational errors such file not found, permissions problems, etc.

**_Update 12/13/2013:_** _Writing a cmdlet? For further information regarding how a cmdlet should determine when to throw a terminating error or non-terminating error, MSDN has a nice [explanation here](http://msdn.microsoft.com/en-us/library/ms714414(v=vs.85).aspx)._

_**Update 12/13/2013**: Want to know if an error you encountered is terminating or non-terminating? Check to see if the error behavior is affected by changing the $ErrorActionPreference. According to the MSDN [documentation here](http://technet.microsoft.com/en-us/library/hh847796.aspx), "Neither $ErrorActionPreference nor the ErrorAction common parameter affect how Windows PowerShell responds to terminating errors (those that stop cmdlet processing)."._

**The $error variable:**

When either type of error occurs during execution, it is logged to a global variable called **_$error_**. This variable is a collection of PowerShell Error Objects with the most recent error at index 0. On a freshly initialized PowerShell instance (no errors have occurred yet) the **_$error_** variable is ready and waiting as an empty collection: 

1. PS C:\\> $error.GetType()

3. IsPublic IsSerial Name                                     BaseType
4. \-------- -------- ----                                     --------
5. True     True     ArrayList                                System.Object

7. PS C:\\> $error.Count
8. 0

 
In the next snippet I have executed a cmdlet that doesn’t exist, throwing an error. If we grab the count on **_$error_**, you will notice it has increased to one item. Dumping that object to the pipeline by accessing **_$error\[0\]_** just prints the error we already saw, right back at us.

1. PS C:\\> ThisCmdlet-DoesNotExist
2. The term 'ThisCmdlet-DoesNotExist' is not recognized as the name of a cmdlet, f
3. unction, script file, or operable program. Check the spelling of the name, or i
4. f a path was included, verify that the path is correct and try again.
5. At line:1 char:24
6. \+ ThisCmdlet-DoesNotExist <<<<
7.     + CategoryInfo          : ObjectNotFound: (ThisCmdlet-DoesNotExist:String)
8.     \[\], CommandNotFoundException
9.     + FullyQualifiedErrorId : CommandNotFoundException

11. PS C:\\> $error.Count
12. 1
13. PS C:\\> $error\[0\]
14. The term 'ThisCmdlet-DoesNotExist' is not recognized as the name of a cmdlet, f
15. unction, script file, or operable program. Check the spelling of the name, or i
16. f a path was included, verify that the path is correct and try again.
17. At line:1 char:24
18. \+ ThisCmdlet-DoesNotExist <<<<
19.     + CategoryInfo          : ObjectNotFound: (ThisCmdlet-DoesNotExist:String)
20.     \[\], CommandNotFoundException
21.     + FullyQualifiedErrorId : CommandNotFoundException

 
There is more available to us than just what is immediately visible. The ErrorRecord is a rich object that contains many useful properties to explore. Try piping the error to **_get-member_** (aliased by **_gm_**) to see what options we have available to us:

1. PS C:\\> $error\[0\] | gm

3.    TypeName: System.Management.Automation.ErrorRecord

5. Name                  MemberType     Definition
6. \----                  ----------     ----------
7. Equals                Method         bool Equals(System.Object obj)
8. GetHashCode           Method         int GetHashCode()
9. GetObjectData         Method         System.Void GetObjectData(System.Runtim...
10. GetType               Method         type GetType()
11. ToString              Method         string ToString()
12. CategoryInfo          Property       System.Management.Automation.ErrorCateg...
13. ErrorDetails          Property       System.Management.Automation.ErrorDetai...
14. Exception             Property       System.Exception Exception {get;}
15. FullyQualifiedErrorId Property       System.String FullyQualifiedErrorId {get;}
16. InvocationInfo        Property       System.Management.Automation.Invocation...
17. PipelineIterationInfo Property       System.Collections.ObjectModel.ReadOnly...
18. TargetObject          Property       System.Object TargetObject {get;}
19. PSMessageDetails      ScriptProperty System.Object PSMessageDetails {get=& {...

For details on what each property member provides, visit [the ErrorRecord MSDN documentation](http://msdn.microsoft.com/en-us/library/system.management.automation.errorrecord_members(v=vs.85).aspx). A couple important highlights:

* **_$error\[0\].InvocationInfo_** provides details about the context which the command was executed, if available.
* **_$error\[0\].Exception_** contains the original exception object as it was thrown to PowerShell. If we explore that object (also piped to get-member) we can see important items to pull up like stack trace, source, HResult, InnerException, etc.

Diving into the exception object itself (**_$error\[0\].Exception_**) can provide very important diagnostic details not immediately visible on the top level error record. This is especially useful in troubleshooting third party cmdlets!

1. PS C:\\> $error\[0\].Exception
2. The term 'ThisCmdlet-DoesNotExist' is not recognized as the name of a cmdlet, f
3. unction, script file, or operable program. Check the spelling of the name, or i
4. f a path was included, verify that the path is correct and try again.

6. PS C:\\> $error\[0\].Exception | gm

8.    TypeName: System.Management.Automation.CommandNotFoundException

10. Name                        MemberType Definition
11. \----                        ---------- ----------
12. Equals                      Method     bool Equals(System.Object obj)
13. GetBaseException            Method     System.Exception GetBaseException()
14. GetHashCode                 Method     int GetHashCode()
15. GetObjectData               Method     System.Void GetObjectData(System.Runt...
16. GetType                     Method     type GetType()
17. ToString                    Method     string ToString()
18. CommandName                 Property   System.String CommandName {get;set;}
19. Data                        Property   System.Collections.IDictionary Data {...
20. ErrorRecord                 Property   System.Management.Automation.ErrorRec...
21. HelpLink                    Property   System.String HelpLink {get;set;}
22. InnerException              Property   System.Exception InnerException {get;}
23. Message                     Property   System.String Message {get;}
24. Source                      Property   System.String Source {get;set;}
25. StackTrace                  Property   System.String StackTrace {get;}
26. TargetSite                  Property   System.Reflection.MethodBase TargetSi...
27. WasThrownFromThrowStatement Property   System.Boolean WasThrownFromThrowStat...

29. PS C:\\> $error\[0\].Exception.StackTrace
30.    at System.Management.Automation.CommandDiscovery.LookupCommandInfo(String co
31. mmandName, CommandOrigin commandOrigin)
32.    at System.Management.Automation.CommandDiscovery.LookupCommandProcessor(Stri
33. ng commandName, CommandOrigin commandOrigin, Nullable\`1 useLocalScope)
34.    at System.Management.Automation.ExecutionContext.CreateCommand(String comman
35. d)
36.    at System.Management.Automation.CommandNode.CreateCommandProcessor(Int32& in
37. dex, ExecutionContext context)
38.    at System.Management.Automation.CommandNode.AddToPipeline(PipelineProcessor
39. pipeline, ExecutionContext context)
40.    at System.Management.Automation.PipelineNode.Execute(Array input, Pipe outpu
41. tPipe, ArrayList& resultList, ExecutionContext context)
42.    at System.Management.Automation.StatementListNode.ExecuteStatement(ParseTree
43. Node statement, Array input, Pipe outputPipe, ArrayList& resultList, ExecutionC
44. ontext context)

**
Error Action Preference:**

PowerShell halts execution on terminating errors, as mentioned before. For non-terminating errors we have the option to tell PowerShell how to handle these situations. This is where the error action preference comes in. Error Action Preference allows us to specify the desired behavior for a non-terminating error; it can be scoped at the command level or all the way up to the script level.

Available choices for error action preference:

* **_SilentlyContinue_** – error messages are suppressed and execution continues.
* **_Stop_** – forces execution to stop, behaving like a terminating error.
* **_Continue_** - the default option. Errors will display and execution will continue.
* **_Inquire_** – prompt the user for input to see if we should proceed.
* **_Ignore_** – (new in v3) – the error is ignored and not logged to the error stream. Has very restricted usage scenarios.

Example: Set the preference at the script scope to **_Stop_**, place the following near the top of the script file:

1. $ErrorActionPreference = "Stop"

Example: Set the preference at the cmdlet level to **_Inquire_**, add error action switch (or alias **_EA_**): 

1. get-childitem "G:\\FakeFolder" -ErrorAction "Inquire"
2. get-childitem "G:\\FakeFolder" -ea "Inquire"

**
Try/Catch/Finally Blocks:**

The **_Try_**, **_Catch_**, and **_Finally_** statements allow us to control script flow when we encounter errors. The statements behave similar to the statements of the same name found in C# and other languages.

The behavior of try/catch is to catch terminating errors (exceptions). This means Non-terminating (operational) errors inside a try block will not trigger a **_Catch\*_**. If you would like to catch all possible errors (terminating and non-terminating) – then simply set the error action preference to **_Stop_**. Remember that **_Stop_** error action forces a non-terminating error to behave like a terminating error, which means it can then be trapped in a catch block. Here is an example:

_**\*Update 12/13/2013**: In almost all cases, non-terminating errors will not trigger a catch. However I did recently observe a situation where a non-terminating error did trigger a catch block. It wasn't from a cmdlet, but an exception generated from directly calling a method on a .net object. So keep in mind that behavior might be possible._

1. try
2. {
3.     <#
4.         Add dangerous code here that might produce exceptions.
5.         Place as many code statements as needed here.
6.         Non-terminating errors must have error action preference set to Stop to be caught.
7.     #>

9.     write-host "Attempting dangerous operation"
10.     $content = get-content -Path "C:\\SomeFolder\\This\_File\_Might\_Not\_Exist.txt" -ErrorAction Stop
11. }
12. catch
13. {
14.     <#
15.         You can have multiple catch blocks (for different exceptions), or one single catch.
16.         The last error record is available inside the catch block under the $\_ variable.
17.         Code inside this block is used for error handling. Examples include logging an error,
18.         sending an email, writing to the event log, performing a recovery action, etc.
19.         In this example I'm just printing the exception type and message to the screen.
20.     #>

22.     write-host "Caught an exception:" -ForegroundColor Red
23.     write-host "Exception Type: $($\_.Exception.GetType().FullName)" -ForegroundColor Red
24.     write-host "Exception Message: $($\_.Exception.Message)" -ForegroundColor Red
25. }
26. finally
27. {
28.     <#
29.         Any statements in this block will always run even if errors are caught.
30.         This statement block is optional. Normally used for cleanup and
31.         releasing resources that must happen even under error situations.
32.     #>

34.     write-host "Finally block reached"
35. }

 
You can also have **_Catch_** blocks that will only trap specific exceptions. The reason for doing this is so you can add different handlers for each possible failure condition that you may encounter. Some exceptions you may just want to log and exit, but others you may have a recovery action for. Here is a **_Catch_** statement that would trap a specific Exception type. The Exception type is displayed in brackets after the catch statement:

1. catch \[System.Management.Automation.ItemNotFoundException\]
2. {
3.     # catching specific exceptions allows you to have
4.     # custom actions for different types of errors
5.     write-host "Caught an ItemNotFoundException" -ForegroundColor Red
6. }

 
You might be wondering how I found the type name for the previous exception. The possible exceptions for cmdlets are not usually documented, so you may need to find them on your own. When an exception occurs you can look up the error in the **_$error_** collection, or while inside a catch block under the **_$\__** variable. Call the **_GetType()_** method on the base exception to extract the **_FullName_** property. Like shown here:

1. PS C:\\> $error\[0\].Exception.GetType().FullName
2. System.Management.Automation.ItemNotFoundException

**
Handling Errors from non-PowerShell processes:**

What happens when your script needs to run an external process from PowerShell and you want to know if it succeeded? An example would be a cmdline tool such as robocopy.exe. It’s an external application that returns an exit code upon completion. But since it is an external process, its errors will not be caught in your **_try_**/**_catch_** blocks.

To trap this exit code utilize the **_$LastExitCode_** PowerShell variable.

When the launched process exits, PowerShell will write the exit code directly to **_$LastExitCode_**. In most cases an exit code of 0 means success, and 1 or greater indicates a failure. Check the external tool's documentation to verify of course.

Here it is seen in action:

1. PS C:\\> robocopy.exe "C:\\DirectoryDoesNotExist" "C:\\NewDestination" "\*.\*" /R:0

3. \-------------------------------------------------------------------------------
4.    ROBOCOPY     ::     Robust File Copy for Windows

6. \-------------------------------------------------------------------------------

8.   Started : Sun Jun 09 18:42:09 2013

10.    Source : C:\\DirectoryDoesNotExist\\\\par      Dest : C:\\NewDestination\\\\par
11.     Files : \*.\*

13.   Options : \*.\* /COPY:DAT /R:0 /W:30

15. \------------------------------------------------------------------------------

17. 2013/06/09 18:42:09 ERROR 2 (0x00000002) Accessing Source Directory C:\\Directory
18. DoesNotExist\\\\par The system cannot find the file specified.
19. PS C:\\> $lastexitcode
20. 16

* [15 Comments](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#comments)

[PowerShell](http://blogs.msdn.com/b/kebab/archive/tags/PowerShell/), [Error Handling](http://blogs.msdn.com/b/kebab/archive/tags/Error+Handling/), [$error](http://blogs.msdn.com/b/kebab/archive/tags/_2400_error/), [Exception](http://blogs.msdn.com/b/kebab/archive/tags/Exception/), [Try/Catch](http://blogs.msdn.com/b/kebab/archive/tags/Try_2F00_Catch/), [$erroractionpreference](http://blogs.msdn.com/b/kebab/archive/tags/_2400_erroractionpreference/), [$lastexitcode](http://blogs.msdn.com/b/kebab/archive/tags/_2400_lastexitcode/), [Terminating Error](http://blogs.msdn.com/b/kebab/archive/tags/Terminating+Error/), [Non-Terminating Error](http://blogs.msdn.com/b/kebab/archive/tags/Non_2D00_Terminating+Error/)

[![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/facebook.gif]]](http://www.facebook.com/sharer.php?u=http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx&t=An+Introduction+to+Error+Handling+in+PowerShell)
[![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/twitter.gif]]](http://twitter.com/home?status=An+Introduction+to+Error+Handling+in+PowerShell%20:%20http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx)
[![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/digg.gif]]](http://digg.com/submit?url=http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx&title=An+Introduction+to+Error+Handling+in+PowerShell)
[![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/delicious.gif]]](http://del.icio.us/post?url=http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx&title=An+Introduction+to+Error+Handling+in+PowerShell)

[Comments](http://blogs.msdn.com/b/kebab/rsscomments.aspx?WeblogPostID=10424673)

			
	
	 ![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/anonymous.gif]]M
	3 Jul 2013 8:16 AM
	[#](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#10431537)
	
	I need to force a powershell script to fail.  
	
			
	
	 [![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/avatar.2.jpg]]](http://blogs.msdn.com/523159/ProfileUrlRedirect.ashx)[R Jason Morgan](http://blogs.msdn.com/523159/ProfileUrlRedirect.ashx)
	10 Jul 2013 1:14 PM
	[#](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#10433186)
	
	Awesome article on Error Handling!  I'm adding this to my favorites now, thank you for sharing.
	
			
	
	 ![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/anonymous.gif]]D
	12 Aug 2013 1:53 PM
	[#](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#10441184)
	
	Thanks for this article!
	
			
	
	 ![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/anonymous.gif]]Nathan
	15 Oct 2013 2:17 PM
	[#](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#10456973)
	
	Nice article.  Helped me out a lot.  However, I am now facing another challenge.  I am trying to write the $Error output from above that was going to the console to a txt file.  So my code looks like this:
	
	$compname = Get-Content -Path C:\\ServerList.txt
	
	$date = Get-Date -Format yyyyMMdd\_hhmm
	
	$unit="GB"
	
	$measure = "1$unit"
	
	FOREACH ($computerName in $compname)
	
	{
	
	TRY
	
	{
	
	$ErrorActionPreference = "Stop";
	
	Get-WmiObject -computername $computerName -query "
	
	select SystemName, Name, DriveType, FileSystem, FreeSpace, Capacity, Label
	
	 from Win32\_Volume
	
	where DriveType = 2 or DriveType = 3" \`
	
	| select SystemName \`
	
	, Name \`
	
	, @{Label="SizeIn$unit";Expression={"{0:n2}" -f($\_.Capacity/$measure)}} \`
	
	, @{Label="FreeIn$unit";Expression={"{0:n2}" -f($\_.freespace/$measure)}} \`
	
	, @{Label="PercentFree";Expression={"{0:n2}" -f(($\_.freespace / $\_.Capacity) \* 100)}} \`
	
	,  Label  | Export-Csv c:\\SpaceInformation\_$date.csv -Append  
	
	}
	
	CATCH
	
	{
	
	WRITE-HOST "Computer Name: $computerName\`nError: $($\_.Exception.Message)" > c:\\errors.txt
	
	}
	
	FINALLY
	
	{
	
	$ErrorActionPreference = "CONTINUE";
	
	}
	
	}
	
	However, no matter if I use > or OUT-FILE or 2>, it still writes to the console, rather than the file.  
	
	What am I doing wrong?
	
	Thanks,
	
	Nathan
	
			
	
	 [![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/avatar.jpg]]](http://blogs.msdn.com/504045/ProfileUrlRedirect.ashx)[Keith Babinec](http://blogs.msdn.com/504045/ProfileUrlRedirect.ashx)
	27 Oct 2013 3:52 AM
	[#](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#10460722)
	
	@Nathan - I assume that you want to print to the screen and also write to the file? Try removing write-host (leaving the string you want to print), and using the tee-object cmdlet. This should print to the screen and also to the output file.
	
	Example:
	
	try
	
	{
	
	\# your code here
	
	}
	
	catch
	
	{
	
	"Computer Name: $computerName\`nError: $($\_.Exception.Message)" | Tee-Object -File c:\\errors.txt
	
	}
	
			
	
	 ![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/anonymous.gif]]Alok
	26 Nov 2013 6:49 AM
	[#](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#10471616)
	
	G8 Blog, Solve my problem as well. Thank you :)
	
			
	
	 ![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/anonymous.gif]]TheMightyC
	7 Apr 2014 7:31 PM
	[#](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#10515039)
	
	Great article. I'd like to ask about a problem in one of mscripts, though. I have a script with a try/catch block, and in the catch, I call a function I've written called RollbackEverything. I can call RollbackEveything from the try block with no problem, but when I call it from the Catch block, I see the error "The term 'RollbackEverything' is not recognized as a cmdlet, function, operable program, or script file. Verify the term and try again."
	
	What is happening, and is there a way to fix it?
	
			
	
	 [![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/avatar.jpg]]](http://blogs.msdn.com/504045/ProfileUrlRedirect.ashx)[Keith Babinec](http://blogs.msdn.com/504045/ProfileUrlRedirect.ashx)
	17 Apr 2014 11:32 PM
	[#](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#10518497)
	
	@TheMightyC - I just tried to reproduce the issue you describe and I'm not seeing it. I even tried to declare a function inside the scope of the try block, and it still was able to be called from the catch block. If you are still having issues, I would recommend posting your code on the MSDN forums or stackoverflow.
	
	This works just fine on powershell v2 and v3:
	
	\# -------------------------------
	
	function test()
	
	{
	
	   return "inside test"
	
	}
	
	test
	
	try
	
	{
	
	   write-host "inside the try block"
	
	   function test2()
	
	   {
	
	       return "inside test2"
	
	   }
	
	   test2
	
	   throw "some error"
	
	}
	
	catch
	
	{
	
	   write-host "inside the catch block"
	
	   test
	
	   test2
	
	}
	
	write-host "end"
	
	\# -------------------------------
	
	the code returns the following for me:
	
	inside test
	
	inside the try block
	
	inside test2
	
	inside the catch block
	
	inside test
	
	inside test2
	
	end
	
			
	
	 ![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/anonymous.gif]]Hien
	3 Jun 2014 9:48 AM
	[#](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#10530593)
	
	Great error handling article.  Thank you!
	
			
	
	 ![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/anonymous.gif]]Noor
	15 Jul 2014 8:06 AM
	[#](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#10542517)
	
	Awesome Article.... thanks...
	
			
	
	 ![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/anonymous.gif]]Tom Pester
	17 Aug 2014 11:34 PM
	[#](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#10550697)
	
	Good article
	
	FYI You picked Robocopy and that's one of the few that does return a non 0 exit code to signal success
	
	For example, it returns 3 (making this up) when no files were copied and it still was a successful action
	
			
	
	 ![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/anonymous.gif]]Andrew Stevens
	21 Aug 2014 3:51 PM
	[#](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#10551962)
	
	Nice and clear well done
	
			
	
	 [![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/avatar.jpg]]](http://blogs.msdn.com/504045/ProfileUrlRedirect.ashx)[Keith Babinec](http://blogs.msdn.com/504045/ProfileUrlRedirect.ashx)
	21 Aug 2014 4:27 PM
	[#](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#10551973)
	
	@Tom - good point, totally forgot that robocopy has some non-zero success codes.
	
			
	
	 ![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/anonymous.gif]]Ludovic
	31 Oct 2014 2:29 AM
	[#](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#10568960)
	
	Great article, with a few very useful tips, like the way to get the correct error type. Thank you for sharing.
	
			
	
	 [![[./_resources/An_Introduction_to_Error_Handling_in_PowerShell_-_Keith_Babinec's_Development_Blog_-_Site_Home_-_MSDN_Blogs_blogs.msdn.com.resources/avatar.1.jpg]]](http://blogs.msdn.com/187227/ProfileUrlRedirect.ashx)[Michael Liben](http://blogs.msdn.com/187227/ProfileUrlRedirect.ashx)
	21 Jan 2015 7:15 AM
	[#](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx#10587810)
	
	Two thumbs up. Must read.
	

Leave a Comment

* Name

* Comment

* 

Options

* [Blog Home](http://blogs.msdn.com/b/kebab/)

* [Share this](http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspxmailto:?subject=An%20Introduction%20to%20Error%20Handling%20in%20PowerShell&body=http://blogs.msdn.com/b/kebab/archive/2013/06/09/an-introduction-to-error-handling-in-powershell.aspx)
* [RSS for posts](http://blogs.msdn.com/b/kebab/rss.aspx)
* [Atom](http://blogs.msdn.com/b/kebab/atom.aspx)
* [RSS for comments](http://blogs.msdn.com/b/kebab/rsscomments.aspx)

Search Blogs

Search this blog Search all blogs

Tags

* [$error](http://blogs.msdn.com/b/kebab/archive/tags/_2400_error/)

* [$erroractionpreference](http://blogs.msdn.com/b/kebab/archive/tags/_2400_erroractionpreference/)
* [$lastexitcode](http://blogs.msdn.com/b/kebab/archive/tags/_2400_lastexitcode/)
* [array](http://blogs.msdn.com/b/kebab/archive/tags/array/)
* [BeginInvoke](http://blogs.msdn.com/b/kebab/archive/tags/BeginInvoke/)
* [C#](http://blogs.msdn.com/b/kebab/archive/tags/C_2300_/)
* [dictionary](http://blogs.msdn.com/b/kebab/archive/tags/dictionary/)
* [enum](http://blogs.msdn.com/b/kebab/archive/tags/enum/)
* [enumeration](http://blogs.msdn.com/b/kebab/archive/tags/enumeration/)
* [Error Handling](http://blogs.msdn.com/b/kebab/archive/tags/Error+Handling/)
* [Exception](http://blogs.msdn.com/b/kebab/archive/tags/Exception/)
* [Hyper-V](http://blogs.msdn.com/b/kebab/archive/tags/Hyper_2D00_V/)
* [int](http://blogs.msdn.com/b/kebab/archive/tags/int/)
* [integer](http://blogs.msdn.com/b/kebab/archive/tags/integer/)
* [Invoke](http://blogs.msdn.com/b/kebab/archive/tags/Invoke/)
* [key-value pair](http://blogs.msdn.com/b/kebab/archive/tags/key_2D00_value+pair/)
* [KVP](http://blogs.msdn.com/b/kebab/archive/tags/KVP/)
* [PowerShell](http://blogs.msdn.com/b/kebab/archive/tags/PowerShell/)
* [stored procedure](http://blogs.msdn.com/b/kebab/archive/tags/stored+procedure/)
* [table](http://blogs.msdn.com/b/kebab/archive/tags/table/)
* [Terminating Error](http://blogs.msdn.com/b/kebab/archive/tags/Terminating+Error/)
* [Try/Catch](http://blogs.msdn.com/b/kebab/archive/tags/Try_2F00_Catch/)
* [types](http://blogs.msdn.com/b/kebab/archive/tags/types/)
* [Virtual Machine](http://blogs.msdn.com/b/kebab/archive/tags/Virtual+Machine/)
* [VM](http://blogs.msdn.com/b/kebab/archive/tags/VM/)

Archive

* [July 2014](http://blogs.msdn.com/b/kebab/archive/2014/07.aspx) (1)

* [June 2014](http://blogs.msdn.com/b/kebab/archive/2014/06.aspx) (1)
* [April 2014](http://blogs.msdn.com/b/kebab/archive/2014/04.aspx) (1)
* [June 2013](http://blogs.msdn.com/b/kebab/archive/2013/06.aspx) (2)

* © 2014 Microsoft Corporation.

* [Terms of Use](http://msdn.microsoft.com/cc300389)
* [Trademarks](http://www.microsoft.com/library/toolbar/3.0/trademarks/en-us.mspx)
* [Privacy & Cookies](http://go.microsoft.com/fwlink/?LinkId=248681)
* [[#|Report Abuse]]
* 5.6.426.415
