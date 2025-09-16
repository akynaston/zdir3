---
tags: ["#ex2007","#powershell"]
---
# Powershell: Simple bind to eDirectory example

Powershell: Simple bind to eDirectory example:

$directoryEntry = New-Object System.DirectoryServices.DirectoryEntry($ldapRoot)
$directoryEntry.psbase.AuthenticationType=\[System.DirectoryServices.AuthenticationTypes\]::FastBind
$directoryEntry.psbase.Username=$userDn
$directoryEntry.psbase.Password=$userPassword
$adSearch = New-Object System.DirectoryServices.DirectorySearcher($directoryEntry)
$searchString = \[string\]"(&(objectClass=lwsnssoLsIdentity))"
\# set filter string on object to the one built in the step above
$adSearch.Filter = $searchString
$result = @($adSearch.Findall())
Write-Host $result.Length
$path = $result\[0\].path

Dump all users from edirectory that don't have an associated association to ex2007 driver:

$directoryEntry = New-Object System.DirectoryServices.DirectoryEntry("LDAP://172.17.2.155:390");
$directoryEntry.psbase.AuthenticationType=\[System.DirectoryServices.AuthenticationTypes\]::None
$directoryEntry.psbase.Username="cn=admin,o=services";
$directoryEntry.psbase.Password="trivir";
$adSearch = New-Object System.DirectoryServices.DirectorySearcher($directoryEntry)
$searchString = \[string\]"(&(objectClass=User)(!(DirXML-Associations=cn=EX2007-PowerShellDriver,cn=Driver Set,ou=idm,o=services#1#\*)))";
#$searchString = \[string\]"(&(objectClass=User))";
$adSearch.PropertiesToLoad.Add('cn')
\# set filter string on object to the one built in the step above
$adSearch.Filter = $searchString
$result = @($adSearch.Findall())
Write-Host $result.Length
foreach ($user in $result) {
    Write-Host "user: " $user.properties.cn;
}

   

## ADAM Simple Bind - Powershell

Last post 07-28-2008, 5:05 PM by [joe](http://directoryprogramming.net/members/joe.aspx). 3 replies.

|     |     |
| --- | --- |
|     |     |
|     | Sort Posts: [Previous](http://directoryprogramming.net/forums/ThreadNavigation.aspx?PostID=4268&NavType=Previous) [Next](http://directoryprogramming.net/forums/ThreadNavigation.aspx?PostID=4268&NavType=Next) |

> |     |     |
> | --- | --- |
> | 07-28-2008, 12:07 PM | [4268](http://directoryprogramming.net/forums/permalink/4268/4268/ShowThread.aspx#4268) |
> 
> * ![[./_resources/Powershell_Simple_bind_to_eDirectory_example.resources/user_IsOffline.gif]] [redi311](http://directoryprogramming.net/members/redi311.aspx)
> * ![[./_resources/Powershell_Simple_bind_to_eDirectory_example.resources/rank0.gif]]
> * Joined on 07-28-2008
> * [Posts 2](http://directoryprogramming.net/search/SearchResults.aspx?u=5004&o=DateDescending)
> 
> #### ADAM Simple Bind - Powershell
> 
> Hello,
> 
> I'm trying to use Powershell to connect to an ADAM instance and read a list of objects / properties.  Seems simple enough and I've read lots of different posts here and other sites on how to do this.  Can someone point me in the right direction?
> 
> I'm using the following code:
> 
> $ldapRoot =\[string\]""
> 
> $userDn = \[string\]"CN=root,CN=lwsn,DC=Test"
> 
> $userPassword = \[string\]"myPasswordHere!"
> 
> $directoryEntry = new-object System.DirectoryServices.DirectoryEntry($ldapRoot,$userDn,$userPassword)
> 
> If i try to access any properties on the $directoryEntry i get an error:
> 
> Line 1: Exception retrieving member "ClassId2e4f51ef21dd47e99d3c952918aff9cd": "A local error has occurred.
> "
> 
> I can connect to the LDAP server using LDP.  If i connect using the dn specified above and password it lets me into rootDSE.  Once im in there in ldp if i bind passing these credentials it works and i can search the subtree.
> 
> What am i doing wrong while building my directory Entry?  Thank you!
> 
> \-Redi
> 
> * [Report abuse](http://directoryprogramming.net/forums/AddPost.aspx?ForumID=1&ReportPostID=4268)
> 
> |     |     |
> | --- | --- |
> | 07-28-2008, 2:39 PM | [4273](http://directoryprogramming.net/forums/permalink/4268/4273/ShowThread.aspx#4273) in reply to [4268](http://directoryprogramming.net/forums/permalink/4268/4268/ShowThread.aspx#4268) |
> 
> * ![[./_resources/Powershell_Simple_bind_to_eDirectory_example.resources/user_IsOffline.gif]] [joe](http://directoryprogramming.net/members/joe.aspx)
> * ![[./_resources/Powershell_Simple_bind_to_eDirectory_example.resources/rankTop10.gif]]
> * Joined on 04-05-2006
> * Chicago, IL
> * [Posts 2,640](http://directoryprogramming.net/search/SearchResults.aspx?u=2103&o=DateDescending)
> 
> #### Re: ADAM Simple Bind - Powershell
> 
> Your code isn't doing a simple bind, it is doing an Windows secure bind.  If you want to do simple bind, specify AuthenticationTypes.None.  You could also use AuthenticationTypes.ServerBind.  The main thing is to not take the default (which is AuthenticationTypes.Secure) and make sure you specify some combination of flags that do not include AuthenticationTypes.Secure.  There is no actual flag to request simple bind.  It is the lack of the Secure flag that gets this.
> 
> If the goal is to perform this operation with the security context of a user in the ADAM store (which it looks like it is), you'll need to ensure you get simple bind as you cannot authenticate an ADAM user with Secure bind.  ADAM users CAN be authenticated with DIGEST auth but ADSI does not support this.
> 
> * [Report abuse](http://directoryprogramming.net/forums/AddPost.aspx?ForumID=1&ReportPostID=4273)
> 
> |     |     |
> | --- | --- |
> | ![[./_resources/Powershell_Simple_bind_to_eDirectory_example.resources/icon_post_show.gif]] 07-28-2008, 4:18 PM | [4278](http://directoryprogramming.net/forums/permalink/4268/4278/ShowThread.aspx#4278) in reply to [4273](http://directoryprogramming.net/forums/permalink/4268/4273/ShowThread.aspx#4273) |
> 
> * ![[./_resources/Powershell_Simple_bind_to_eDirectory_example.resources/user_IsOffline.gif]] [redi311](http://directoryprogramming.net/members/redi311.aspx)
> * ![[./_resources/Powershell_Simple_bind_to_eDirectory_example.resources/rank0.gif]]
> * Joined on 07-28-2008
> * [Posts 2](http://directoryprogramming.net/search/SearchResults.aspx?u=5004&o=DateDescending)
> 
> #### Re: ADAM Simple Bind - Powershell
> 
> Joe,
> 
> thanks for the response.  I was aware that I wasn't doing a simple bind, i was trying to figure out how to.  I've gotten it i think though, it doesn't like the same syntax in powershell that all your lovely .net examples do because of the wrappers for the directoryentry objects...  I figured it out a little while ago, this works in powershell:
> 
> $directoryEntry = New-Object System.DirectoryServices.DirectoryEntry($ldapRoot)
> $directoryEntry.psbase.AuthenticationType=\[System.DirectoryServices.AuthenticationTypes\]::FastBind
> $directoryEntry.psbase.Username=$userDn
> $directoryEntry.psbase.Password=$userPassword
> $adSearch = New-Object System.DirectoryServices.DirectorySearcher($directoryEntry)
> $searchString = \[string\]"(&(objectClass=lwsnssoLsIdentity))"
> \# set filter string on object to the one built in the step above
> $adSearch.Filter = $searchString
> $result = @($adSearch.Findall())
> Write-Host $result.Length
> $path = $result\[0\].path
> 
> * [Report abuse](http://directoryprogramming.net/forums/AddPost.aspx?ForumID=1&ReportPostID=4278)
> 
> |     |     |
> | --- | --- |
> | ![[./_resources/Powershell_Simple_bind_to_eDirectory_example.resources/icon_post_show.gif]] 07-28-2008, 5:05 PM | [4279](http://directoryprogramming.net/forums/permalink/4268/4279/ShowThread.aspx#4279) in reply to [4278](http://directoryprogramming.net/forums/permalink/4268/4278/ShowThread.aspx#4278) |
> 
> * ![[./_resources/Powershell_Simple_bind_to_eDirectory_example.resources/user_IsOffline.gif]] [joe](http://directoryprogramming.net/members/joe.aspx)
> * ![[./_resources/Powershell_Simple_bind_to_eDirectory_example.resources/rankTop10.gif]]
> * Joined on 04-05-2006
> * Chicago, IL
> * [Posts 2,640](http://directoryprogramming.net/search/SearchResults.aspx?u=2103&o=DateDescending)
> 
> #### Re: ADAM Simple Bind - Powershell
> 
> Good to know.  I'm still really new to all the PoSH stuff. :)
> 
> If we get really stuck, we can ask Brandon Shell.  He is my current AD PoSH expert of first resort.  Maybe if I created a forum for PoSH stuff here, he would hang out and answer questions personally. I'll ask...
> 
> * [Report abuse](http://directoryprogramming.net/forums/AddPost.aspx?ForumID=1&ReportPostID=4279)

[![[./_resources/Powershell_Simple_bind_to_eDirectory_example.resources/rss.gif]]](http://directoryprogramming.net/forums/rss.aspx?ForumID=9&PostID=4268) 
© Dunn & Kaplan, 2008
