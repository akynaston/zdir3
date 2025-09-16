---
tags: ["#ex2007","#powershell"]
---
# validate Email address - PowerShell.com

|     |     |
| --- | --- |
| ![[./_resources/validate_Email_address_-_PowerShell.com.resources/ps1.png]] | **validate Email address** |

1. function isEmailAddress($object) {  
2.     ($object -as \[System.Net.Mail.MailAddress\]).Address -eq $object -and $object -ne $null
3. }

5. isEmailAddress "test"
6. isEmailAddress "tobias@powershell.com"
7. IsEmailAddress "test.name@somewhere.com"
8. isEmailAddress $null

Filed under: [email](http://powershell.com/cs/media/g/networking/tags/email/default.aspx), [validate](http://powershell.com/cs/media/g/networking/tags/validate/default.aspx), [System.Net.Mail.MailAddress](http://powershell.com/cs/media/g/networking/tags/System.Net.Mail.MailAddress/default.aspx)
uses the System.Net.Mail.MailAddress type to check whether a given string is a valid email address. isEmailAddress returns $true for all valid email addresses, otherwise $false.
Copyright 2008 PowerShell.com. All rights reserved.
