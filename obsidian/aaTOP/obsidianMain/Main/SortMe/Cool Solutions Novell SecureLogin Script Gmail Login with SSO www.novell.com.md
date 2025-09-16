---
tags: ["#NSL-GMAIL"]
---
# Cool Solutions: Novell SecureLogin Script: Gmail Login with SSO [www.novell.com]

Example of nsl login script I found while looking for 'pre-warning' about password expiration support.

* * *

[![[./_resources/Cool_Solutions_Novell_SecureLogin_Script_Gmail_Login_with_SSO_www.novell.com.resources/unknown_filename.1.png]]](http://www.novell.com/)

* [Skip to Content](http://www.novell.com/coolsolutions/feature/#top)

		### [Solutions](http://www.novell.com/solutions/)
	
		### [Products](http://www.novell.com/products/)
	
		### [Services & Support](http://www.novell.com/services/)
	
		### [Partners & Communities](http://www.novell.com/communities/)
	
		### [About Novell](http://www.novell.com/company/)
	
		### [How to Buy](http://www.novell.com/products/howtobuy.html)
	

[**Change**](http://www.novell.com/common/util/langselect.php?referer=http%3A//www.novell.com/coolsolutions/feature/17141.html) **_United States,_ English**

[**Logout**](https://secure-www.novell.com/cmd/ICSLogout)**_Welcome_ Aaron Kynaston**

[Close](http://www.novell.com/coolsolutions/feature/#)

								

# Novell SecureLogin Script: Gmail Login with SSO

## Novell Cool Solutions: Feature
By [Girish Mutt](http://www.novell.com/coolsolutions/author/2849.html)

[Rate This Page](http://www.novell.com/inc/rater.jsp?url=http://www.novell.com/coolsolutions/feature/17141.html)

Reader Rating  ![[./_resources/Cool_Solutions_Novell_SecureLogin_Script_Gmail_Login_with_SSO_www.novell.com.resources/unknown_filename.4.gif]]  from 5 ratings

* [Printer Friendly](http://www.novell.com/inc/pf/pf.jsp)

* [tell a friend](http://www.novell.com/info/sendemail.jsp?url=http://www.novell.com/coolsolutions/feature/17141.html)

|     |     |
| --- | --- |
| - [Slashdot This](http://slashdot.org/submit.pl)<br>_Posted: 3 May 2006_ |     |

### Introduction

This article is intended to help you enable your Gmail account for Web Single Sign On (SSO). Since Gmail is quickly becoming a widely used e-mail service, the script in this article has been provided to help you enable auto-detection of the Gmail login for Web SSO.

### Using the Gmail Script with Novell SecureLogin NSL

The Gmail script shown below is designed to handle the following SSO aspects:

* Gmail login detection

* Change of password
* Login loop
#####################################################################
# URL  			: google
#
# Name			: Gmail Web login 
#
# Type				: Web Login Script
# 
#
# This Application Definition is capable of handling the following:-
# 
# 	\*Gmail Login Detection.
#	\*Change Password Handling.
#	\*Handles Login Loop.
#  
#####################################################################


GetURL ?GmailURL

#\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\* 
# Purpose: Gmail Login Handling for Web-SSO
#\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*

If -Text "Welcome to Gmail" 

	If ?LogInCount Eq "1" 

	          MessageBox "Would you like to login again?" -YesNo ?EnterChoice 
	
	          If ?EnterChoice Eq "Yes" 
	                     Call "Login" 
	
	                Else 
			             
	                   EndScript 
	
	          EndIf 

        Else 

          Call "Login" 

	EndIf 
	

EndIf	


#\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*
# Subroutine Name: Login
#
# Purpose: It handles the Gmail Web Login
#
#\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*

Sub Login
	Set ?LogInCount "1"
	SetPrompt "Username:"
	Type $Username #1
     	SetPrompt "Password :"
        	Type $Password #2
        	Submit
	SetPrompt "Enter Gmail Account Username and Password."
	EndScript
	
EndSub



#\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*
# 
# Purpose: Gmail Change Password Handling
#
#\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*
If "EditPasswd?" -In ?GmailURL

	If -Text "Edit password" 
		
		Type $Password #1
		Set ?PassBackup $Password
		ChangePassword ?NewPasswd "Please Enter Your New Password for GMail Account"
		Type ?NewPasswd #3
		Type ?NewPasswd #4
		Set $Password ?NewPasswd
		Submit
		EndScript

   	EndIf

EndIf

#\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*
# 
# Purpose: Gmail Wrong Username and/or Password Handling
#
#\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*

If -Text "Username and password do not match."

	DisplayVariables "Your UserName and/or Password seems to be wrong.
	Please enter the right credentials!!"$Username $Password
	Call "Login"

EndIf

**Implementation**

The Gmail script can be added to the Novell SecureLogin(NSL) client by following the steps below:

**1**. From the system tray, launch the NSL icon to get the Manage Logins window.

**2**. In the left panel, go to the Applications option and right-click to add the new application. A dialog will appear, where you can add the new application definition.

**3**. In the dialog, choose the second radio button to add the new application definition.

**4**. Provide the values to the following parameters to create the application definition:

* Type: This defines the type of the Application, such as Windows, Terminal Emulator, Java, Web, and others. Since you are are creating a Application Definition for Gmail, which is a Web application, choose the Advanced Web option from the dropdown box.
* URL: For the Gmail account, provide "google" as the URL parameter value.
* Description: Provide any value that will help you understand the type of application needing this Application Definition. For exammple, use "Gmail Login".

![[./_resources/Cool_Solutions_Novell_SecureLogin_Script_Gmail_Login_with_SSO_www.novell.com.resources/unknown_filename.6.jpeg]]

Figure 1: Adding a new application definition for Gmail login

**5**. Launch the Gmail Login page. After the Gmail page is loaded in the browser, NSL will detect the Gmail login page.

**6**. When asked, provide the user credentials to enable this application for Web Single Sign On(SSO).

![[./_resources/Cool_Solutions_Novell_SecureLogin_Script_Gmail_Login_with_SSO_www.novell.com.resources/unknown_filename.2.jpeg]]

Figure 2: Detection of Gmail Login by NSL

#### Reader Comments

* Nice one ..I can use it..

[**Like what you see?**
Sign up for our weekly newsletter. ![[./_resources/Cool_Solutions_Novell_SecureLogin_Script_Gmail_Login_with_SSO_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/coolsolutions/forms/subscribe.html) 

[**Want to contribute?**
It could earn you a nano! Learn more. ![[./_resources/Cool_Solutions_Novell_SecureLogin_Script_Gmail_Login_with_SSO_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/coolsolutions/forms/submit_a_tip.html) 

[**Like Wikis?**
Join the Cool Solutions Wiki. ![[./_resources/Cool_Solutions_Novell_SecureLogin_Script_Gmail_Login_with_SSO_www.novell.com.resources/unknown_filename.gif]]](http://wiki.novell.com/index.php/Cool_Solutions_Wiki_Main_Page) 

|     |     |     |
| --- | --- | --- |
| ![[./_resources/Cool_Solutions_Novell_SecureLogin_Script_Gmail_Login_with_SSO_www.novell.com.resources/unknown_filename.3.gif]] |     | [**Interested?**<br>Request a sales call ![[./_resources/Cool_Solutions_Novell_SecureLogin_Script_Gmail_Login_with_SSO_www.novell.com.resources/unknown_filename.gif]]](http://www.novell.com/company/sales_call_request.jsp?refid=coolsolutions&unitcode=1-418V23) |

![[./_resources/Cool_Solutions_Novell_SecureLogin_Script_Gmail_Login_with_SSO_www.novell.com.resources/unknown_filename.5.gif]]

_Novell Cool Solutions (corporate web communities) are produced by WebWise Solutions. _

[Cool Solutions Home (New)](http://www.novell.com/communities/coolsolutions)

[Classic Cool Solutions Home](http://www.novell.com/coolsolutions/index.html)

[Authors](http://www.novell.com/coolsolutions/author/)

[Cool Blogs](http://www.novell.com/communities/coolblogs)

[Cool Solutions Wiki](http://wiki.novell.com/)

[Cool Tools](http://www.novell.com/communities/coolsolutions/tools)

Get Involved  _\>_

[Open Audio (podcasts)](http://www.novell.com/company/podcasts/openaudio.html)

[Novell**®** Making IT Work As One**™**](http://www.novell.com/company/strategy.html)

* [Careers](http://www.novell.com/company/careers/index.html)

* [Contact Us](http://www.novell.com/company/contacts-offices/)
* [Feedback](http://www.novell.com/inc/feedback/feedback.html)
* [Legal](http://www.novell.com/company/legal/)
* [Print](http://www.novell.com/coolsolutions/feature/#)

© 2011 Novell
