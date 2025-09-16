---
tags: ["#ex2007","#powershell"]
---
# Getting Proxy Addresses from an AD User Object :: Resourceful Admin

## [Getting Proxy Addresses from an AD User Object](http://www.resourcefuladmin.com/2009/04/getting-proxy-addresses-from-an-ad-user-object)

[April 10th, 2009  |  Published in](http://www.resourcefuladmin.com/2009/04/getting-proxy-addresses-from-an-ad-user-object) [PowerShell](http://www.resourcefuladmin.com/category/powershell)

In Active Directory a user object can hold multiple “Proxy” addresses.
Using ADSI and LDAP the PowerShell script below enumerates all .proxyaddresses from a specific Active Directory user object.

1. Function Get-Proxy()
2. {
3. Process
4. {
5. $objDomain = New-Object System.DirectoryServices.DirectoryEntry
6. $objSearcher = New-Object System.DirectoryServices.DirectorySearcher
7. $objSearcher.SearchRoot = $objDomain
8. $objSearcher.PageSize = 1000
9. $objSearcher.Filter = "(cn=$\_)"
10. $objSearcher.SearchScope = "Subtree"
11. $objUser = $objSearcher.FindOne()
12. \[String\]$DN = $objUser.properties.distinguishedname
13. $UserObj = \[ADSI\]"LDAP://$DN"
14. \[String\]$displayname = $UserObj.displayname
15. \[String\]$exchalias = $UserObj.mailnickname
16. \[Array\]$exchproxy = $UserObj.proxyaddresses
17. $displayname
18. $exchalias
19. ForEach($proxy In $exchproxy)
20. {
21. $proxy
22. }
23. }
24. }
25. \[String\]$UserCN = "bricep"
26. $UserCN | Get-Proxy

[download](http://poshcode.org/get/1026)[This Script](http://poshcode.org/?show=1026) brought to you by [PoshCode](http://poshcode.org/)

This scripting technique can be used to get any Active Directory user object attributes.

All information is provided on an AS-IS basis, with no warranties and confers no rights.
