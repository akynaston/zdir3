---
tags: ["#powershell"]
---
# Using exchange 2007 powershell and Excel 2007 to send automated emails of user mailbox stats. « The Admin Rules

# Using exchange 2007 powershell and Excel 2007 to send automated emails of user mailbox stats.

2009 February 25
tags: [Automation](http://en.wordpress.com/tag/automation), [Excel VBA](http://en.wordpress.com/tag/excel-vba), [Exchange-2007](http://en.wordpress.com/tag/exchange-2007)
by William Moore

We are trying to get our users mailbox sizes down below 200 MB in anticipation of moving the mailboxes to a new email environment hosted by our parent company. The company I work for currently has over 1500 mailboxes with no current storage limits so the task is going to be somewhat daunting to say the least. I have been given the directive to come up with an automated way of sending each user their mailbox statistics via a personalized email on a weekly basis until the move. I decided to use the exchange powershell and Excel 2007 to accomplish this task and below are the two scripts I used to accomplish it.

**First, the Exchange 2007 Powershell script:**

#create the output file
#$file = new-item -itemtype file mbstats.csv -force

#create object of mailboxes
$colMailboxes = get-mailbox -resultsize unlimited

$strHeaders = “Display Name, Primary SMTP Address, Database, Department, Total Items, Mailbox Size (MB)”
write-output $strHeaders

foreach ($objMailbox in $colMailboxes) {

$mailboxStats = get-mailboxstatistics -identity $objMailbox.alias
if(!$?){
$foreach.movenext()}
else{
$strOutput = $objMailbox.DisplayName + “,” + $objMailbox.PrimarySMTPAddress + “,” + $mailboxStats.DatabaseName + “,” + $objMailbox.office + “,” + $mailboxStats.ItemCount + “,” + $mailboxStats.TotalItemSize.value.toMB()
write-output $strOutput}
}

The above script will export the mailbox stats and put them into a csv file.

Copy and Paste the above code into notepad and save the file with a ps1 extension.

Open the exchange powershell and run the script by typing the name of the ps1 file with | out-file “C:\\nameofcsvfile.csv” appended to the end.

**For example:**

mbstats.ps1 | out-file c:\\mbstats.csv

Once the csv file is created, open the csv file with excel, format the file the way you want, and save the file as an excel spreadsheet. (or..write a Macro that does this for you)

**Next, the VBA code to loop the file and email people over the 200 MB limit:**

Sub SendEmails()

Dim mlNewMessage As MailItem
Dim myOlApp
Dim strBody As String
Dim strFName As String
Dim strItems As String
Dim strMBSize As String

‘Loop through the spreadsheet until the end
Do Until Range(”A2″).Offset(a, 0) = “”

If (Range(”A2″).Offset(a, 4).Value >= 200) Then ‘Checks for mailbox size

strDear = Range(”A2″).Offset(a, 0).Value ‘Start Point
strItems = Range(”A2″).Offset(a, 3).Value ‘Pulls MB Items
strMBSize = Range(”A2″).Offset(a, 4).Value & ” MB” ‘Pulls MB Size

‘Builds Email Body
strBody = “You are being notified because your email storage is currently ” & strMBSize \_
& ” which exceeds the new capacity of 200 MB set forth by **_CompanyName_**.” & vbCrLf & vbCrLf \_
& “Your total mailbox size must be below 200 MB and it is currently above this number.” & vbCrLf & vbCrLf \_
& “Please contact the technical support at **_YourNumber_** or **_YourEmailAddress_**” \_
& “if you need help cleaning out or archiving your items.” & vbCrLf & vbCrLf \_
& “Thank you,” & vbCrLf & vbCrLf \_
& “**_Your Name_**” & vbCrLf \_ ‘Signature
& “**_Your Number_**” & vbCrLf \_ ‘Signature
& “**_Your Email Address_**” ‘ Signature

strDear = Left(strDear, InStr(1, strDear, ” “, vbTextCompare)) ‘Pulls First Name from Full Name

Set myOlApp = CreateObject(”Outlook.Application”) ‘Create New Outlook Item
Set mlNewMessage = myOlApp.CreateItem(olMailItem) ‘Create New Mail Item

‘Defines Email Body
mlNewMessage.Body = strDear & “,” & vbCrLf & vbCrLf \_
& strBody

mlNewMessage.Subject = “Harry Norman mailbox over the size limit” ‘Defines Subject
mlNewMessage.To = Range(”A2″).Offset(a, 1) ‘Defines To

mlNewMessage.Send ‘Sends Email Message

Set myOlApp = Nothing ‘Clears mlOlApp Variable
Set mlNewMessage = Nothing ‘Clears mlOlApp Variable

a = a + 1 ‘Moves to Next Record

Else
a = a + 1 ‘Next Record
End If

Loop

End Sub

from → [Exchange-2007](http://en.wordpress.com/tag/exchange-2007), [Microsoft](http://en.wordpress.com/tag/microsoft), [Work](http://en.wordpress.com/tag/work)

2 Responses [leave one →](http://theadminrules.com/2009/02/25/using-exchange-2007-powershell-and-excel-2007-to-send-automated-emails-of-user-mailbox-stats/#respond)

1. ![[./_resources/Using_exchange_2007_powershell_and_Excel_2007_to_send_automated_emails_of_user_mailbox_stats._«_The_Admin_Rules.resources/28666ad2dd1860f8a12431250ce50f84-s=80&d=identicon&.png]]
	2009 March 18
	[Ollie](http://www.theunitednetwork.com/) [permalink](http://theadminrules.com/2009/02/25/using-exchange-2007-powershell-and-excel-2007-to-send-automated-emails-of-user-mailbox-stats/#comment-20)
	
	Will,
	
	Great bit about scripting to automate e-mailing users their current mailbox sizes and thanks for sharing.
	
	I’m wandering if you can help though – I have copied your instructions i the first steps on powershell script to get mailbox sizes, but when I run the command in my Exchange powershell window I get an error saying:
	
	The term ‘mbstats.ps1′ is not recognised as a cndlet, function, operable program, or script file. Verify the term and try again.
	
	any ideas why I get this please?
	
	many thanks
	
	Ollie
	
	[Reply](http://theadminrules.com/2009/02/25/using-exchange-2007-powershell-and-excel-2007-to-send-automated-emails-of-user-mailbox-stats/?replytocom=20#respond)
	* ![[./_resources/Using_exchange_2007_powershell_and_Excel_2007_to_send_automated_emails_of_user_mailbox_stats._«_The_Admin_Rules.resources/987365e55efd869b36882f291975af79-s=80&d=identicon&.png]]
	* 2009 March 19
	* William Moore [permalink](http://theadminrules.com/2009/02/25/using-exchange-2007-powershell-and-excel-2007-to-send-automated-emails-of-user-mailbox-stats/#comment-22)
		
		Try putting “.\\mbscript.ps1″ instead of just “mbscript.ps1″ in the commmand line and see if it will run the file then. If you navigate to the directory where you have put the mbstats.ps1 file and type mb then hit TAB it should automatically put the filename in their correctly and let you run it. Let me know if this doesn’t help and I will do what I can to help you.
		
		Thanks for reading. The new domain name for my blog is [http://www.theadminrules.com](http://www.theadminrules.com/) and I should have some new posts coming soon.
		
		Will
		
		[Reply](http://theadminrules.com/2009/02/25/using-exchange-2007-powershell-and-excel-2007-to-send-automated-emails-of-user-mailbox-stats/?replytocom=22#respond)
		

[Click here to cancel reply.](http://theadminrules.com/2009/02/25/using-exchange-2007-powershell-and-excel-2007-to-send-automated-emails-of-user-mailbox-stats/#respond)

#### Leave a Reply

Name (required):

Email (required):

Website:

Comment:

**Note:** You can use basic XHTML in your comments. Your email address will **never** be published.

[Subscribe to this comment feed via RSS](http://theadminrules.com/2009/02/25/using-exchange-2007-powershell-and-excel-2007-to-send-automated-emails-of-user-mailbox-stats/feed)

 Notify me of follow-up comments via email.

> ## Search
> 
> ## Top Posts
> 
> * [Using exchange 2007 powershell and Excel 2007 to send automated emails of user mailbox stats.](http://theadminrules.com/2009/02/25/using-exchange-2007-powershell-and-excel-2007-to-send-automated-emails-of-user-mailbox-stats)
> * [WSE0020001 illegal header format detected: Illegal start line in request](http://theadminrules.com/2008/10/31/wse0020001-illegal-header-format-detected-illegal-start-line-in-request)
> * [Auto-response to external (Internet) addresses with Exchange 2007 and Outlook 2007](http://theadminrules.com/2008/11/03/auto-response-to-external-internet-addresses-with-exchange-2007-and-outlook-2007)
> 
> ## Tags
> 
> [Automation](http://theadminrules.com/tag/automation) [Checkpoint](http://theadminrules.com/tag/checkpoint) [Chunked Encoding](http://theadminrules.com/tag/chunked-encoding) [Entourage](http://theadminrules.com/tag/entourage) [Excel VBA](http://theadminrules.com/tag/excel-vba) [Exchange](http://theadminrules.com/tag/exchange) [Exchange-2007](http://theadminrules.com/tag/exchange-2007) [Firewalls](http://theadminrules.com/tag/firewalls) [GTD](http://theadminrules.com/tag/gtd) [Microsoft](http://theadminrules.com/tag/microsoft) [Outlook](http://theadminrules.com/tag/outlook) [Politics](http://theadminrules.com/tag/politics) [Powershell](http://theadminrules.com/tag/powershell) [productivity](http://theadminrules.com/tag/productivity) [Registry-Hacks](http://theadminrules.com/tag/registry-hacks) [scripts](http://theadminrules.com/tag/scripts) [Security](http://theadminrules.com/tag/security) [Sharepoint](http://theadminrules.com/tag/sharepoint) [Software](http://theadminrules.com/tag/software) [Storage](http://theadminrules.com/tag/storage) [U3](http://theadminrules.com/tag/u3) [USB](http://theadminrules.com/tag/usb) [Vista](http://theadminrules.com/tag/vista) [Work](http://theadminrules.com/tag/work)
> 
> |     |     |     |     |     |     |     |
> | --- | --- | --- | --- | --- | --- | --- |
> | February 2009 |     |     |     |     |     |     |
> | **M** | **T** | **W** | **T** | **F** | **S** | **S** |
> | [« Nov](http://theadminrules.com/2008/11) |     |     |     | [Mar »](http://theadminrules.com/2009/03) |     |     |
> |     |     |     |     |     |     | 1   |
> | 2   | 3   | 4   | 5   | 6   | 7   | 8   |
> | 9   | 10  | 11  | 12  | 13  | 14  | 15  |
> | 16  | 17  | 18  | 19  | 20  | 21  | 22  |
> | 23  | 24  | [25](http://theadminrules.com/2009/02/25) | 26  | 27  | 28  |     |
> 
>                
> 
> ## ClustrMaps
> 
> [![[./_resources/Using_exchange_2007_powershell_and_Excel_2007_to_send_automated_emails_of_user_mailbox_stats._«_The_Admin_Rules.resources/www.com]]](http://www3.clustrmaps.com/counter/maps.php?url=http://www.theadminrules.com)
> 
> ## StatsCounter
> 
> [![[./_resources/Using_exchange_2007_powershell_and_Excel_2007_to_send_automated_emails_of_user_mailbox_stats._«_The_Admin_Rules.resources/0-.gif]]](http://www.statcounter.com/wordpress.com)

[Blog at WordPress.com](http://wordpress.com/).

Theme: [Vigilance](http://themes.jestro.com/vigilance) by [Jestro](http://www.jestro.com/)

![[./_resources/Using_exchange_2007_powershell_and_Excel_2007_to_send_automated_emails_of_user_mailbox_stats._«_The_Admin_Rules.resources/p-18-mFEk4J448M.exchange-2007]]

![[./_resources/Using_exchange_2007_powershell_and_Excel_2007_to_send_automated_emails_of_user_mailbox_stats._«_The_Admin_Rules.resources/cHZmVTBSPV83LGgyWUpoZUdYQ2Y1PURLVVRTMXxORXI4U2RUcD.gif]]![[./_resources/Using_exchange_2007_powershell_and_Excel_2007_to_send_automated_emails_of_user_mailbox_stats._«_The_Admin_Rules.resources/cHZmVTBSPV83LGgyWUpoZUdYQ2Y1PURLVVRTMXxORXI4U2RUcD.gif]]
