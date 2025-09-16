# View Additional User Information in AD Users and Computers [www.petri.co.il]

by [Daniel Petri](http://www.petri.co.il/authors/danielp) - January 8, 2009
[Printer Friendly Version](http://www.petri.co.il/#)

How can I view additional information about a user in the AD Users and Computers snap-in?

The Windows 2003 Resource Kit has a hidden .dll file called Acctinfo.dll. After registering the .dll with the following command, it will add a new property page, called Additional Account Info, to the user properties page in Active Directory Users and Computers (or ADUC for short).

If you don't have the Windows 2003 Resource Kit Tools download it from here:

[Windows 2003 Resource Kit Support Tools](http://download.microsoft.com/download/8/e/c/8ec3a7d8-05b4-440a-a71e-ca3ee25fe057/rktools.exe) (12mb)![[./_resources/View_Additional_User_Information_in_AD_Users_and_Computers_www.petri.co.il.resources/unknown_filename.gif]]

If you just want the Acctinfo.dll then download it from [HERE](http://www.petri.co.il/software/acctinfo.zip) (78kb)

After installing the Resource Kit Tools, in order to register the Acctinfo.dll enter the following command:

regsvr32 %systemroot%\\system32\\acctinfo.dll

(change the path if you've placed the .dll in some other location)

Acctinfo.dll needs to be installed on the computer that you are accessing  Active Directory Users and Computers from. If you plan to manage your domain from multiple computers, Acctinfo.dll will need to be installed on each computer.

This is what you'll see on a user's properties in AD Users and Computers:

[![[./_resources/View_Additional_User_Information_in_AD_Users_and_Computers_www.petri.co.il.resources/unknown_filename.1.gif]]](http://www.petri.co.il/images/acctinfo1.gif)

The page includes information is not typically available in the regular Active Directory Users and Computers snap-in: The date when the user's password was last set, the user's password expiry date, the date and time when a user last logged on and off, the user's SID and GUID and more.

Most of the information displayed is quite easy to understand. For example, if you press the Domain PW Info button you will see information about the password policy that is applied to the domain:

[![[./_resources/View_Additional_User_Information_in_AD_Users_and_Computers_www.petri.co.il.resources/unknown_filename.2.gif]]](http://www.petri.co.il/images/acctinfo3.gif)

The User Account Control box shows the userAccountControl attribute in Active Directory. This attribute determines if the password can expire, if the user is disabled or if he needs to change his password at the next logon:

[![[./_resources/View_Additional_User_Information_in_AD_Users_and_Computers_www.petri.co.il.resources/unknown_filename.4.gif]]](http://www.petri.co.il/images/acctinfo4.gif) The Set PW On Site DC button will show you the user's Distinguished Name and allow you to change the password for the user on a specific DC. This can be quite useful if you need to change a password for any given user, but the PDC Emulator DC is down or unreachable for some reason.

The Just Find Site button will populate the DC and Site DNs:

[![[./_resources/View_Additional_User_Information_in_AD_Users_and_Computers_www.petri.co.il.resources/unknown_filename.3.gif]]](http://www.petri.co.il/images/acctinfo2.gif) Acctinfo.dll can be easily removed. From a command prompt run:

regsvr32 /u %systemroot%\\system32\\acctinfo.dll

**Note:** You should note a nasty "feature" (as Microsoft sometimes calls it) - When you perform a search for a user through the regular Find function, the results won't let you see this additional information for the user's object. You'll need to manually browse to the user object and then double-click it... (I thank reader **Rene Fisher** for the heads-up).
