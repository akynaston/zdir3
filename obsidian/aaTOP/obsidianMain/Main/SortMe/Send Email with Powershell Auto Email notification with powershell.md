---
tags: ["#powershell"]
---
# Send Email with Powershell: Auto Email notification with powershell

$SmtpClient = new-object system.net.mail.smtpClient
$MailMessage = New-Object system.net.mail.mailmessage
$SmtpClient.Host = "mysmtpserver.mycompany.local"
$mailmessage.from = ("sender@company.com ")
$mailmessage.To.add("recipient@company.com")
$mailmessage.Subject = “Message”
$mailmessage.Body = “Body”
$smtpclient.Send($mailmessage)
