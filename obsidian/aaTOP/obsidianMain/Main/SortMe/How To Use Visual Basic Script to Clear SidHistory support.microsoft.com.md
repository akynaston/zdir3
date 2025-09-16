# How To Use Visual Basic Script to Clear SidHistory [support.microsoft.com]

[![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/microsoftlogov3.png]]](http://www.microsoft.com/)

[My account
![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/dropdown-caret.png]]](http://support.microsoft.com/mscomcloud/header.aspx?ln=en-US&SageRedirectUrl=http%253a%252f%252fsupport.microsoft.com&hdrFo=account)

[Sign in](https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=12&ct=1423517726&rver=6.5.6509.0&wp=LBI&wreply=http:%2F%2Fsupport.microsoft.com&lc=1033&id=288908)

[Support](http://support.microsoft.com/?ln=en-us)

.

![[]]

.

.
.

* [Contact us](http://support.microsoft.com/ContactUs)

# How To Use Visual Basic Script to Clear SidHistory

 [[#|![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/print-icon-white.png]] Print]]
 [![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/email-icon.png]] Email](http://support.microsoft.com/kb/295758mailto:?body=KB295758%20How%20To%20Use%20Visual%20Basic%20Script%20to%20Clear%20SidHistory%20http://support.microsoft.com/kb/295758)

[[#|Article translations ![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/Caret-Translate.png]]]] 

Article ID: 295758 - [View products that this article applies to.](http://support.microsoft.com/kb/295758#appliesto)
System TipThis article applies to a different version of Windows than the one you are using. Content in this article may not be relevant to you.[Visit the Windows 7 Solution Center](http://support.microsoft.com/ph/14019)
This article was previously published under Q295758

[[#|Expand all]] | [[#|Collapse all]]

## ![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/unknown_filename.png]][[#|SUMMARY]]

The Microsoft Visual Basic Script (VBScript) provided in this article will find an object by its name in the directory and attempt to clear the sidHistory for that object. It has optional parameters for _objectClass_ and _objectCategory_ to help in the search.

## ![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/unknown_filename.png]][[#|MORE INFORMATION]]

When a user object moves from one domain to another, a new security identifier (SID) must be generated for the user account and stored in the **Object-SID** property. Before the new value is written to the property, the previous value is copied to another property of a User object, **SID-History** (**sidHistory**). This property can hold multiple values. Each time a User object moves to another domain, a new SID is generated and stored in the **Object-SID** property and another value is added to the list of old SIDs in **SID-History**. Sometimes it may be necessary to clear the **sidHistory**.
The following VBScript code will remove the **sidHistory** attribute from the directory object specified in the command line arguments.

1. Open Microsoft Notepad.

* Copy the following code and paste it into your Notepad document.
	`Const ADS_PROPERTY_DELETE = 4  Dim strFilter 'As String Dim oConnection 'As ADODB.Connection Dim oRecordSet 'As ADODB.RecordSet Dim strQuery 'As String Dim strDomainNC 'As String Dim oRootDSE 'As IADs Dim vArray 'As Variant() Dim vSid 'As Variant Dim oDirObject 'As Variant  ' Parse the command line and set the query filter ParseCommandLine()  ' Find the domain naming context set oRootDSE = GetObject("LDAP://RootDSE") strDomainNC = oRootDSE.Get("defaultNamingContext") set oRootDSE = Nothing  ' Setup the ADO connection Set oConnection = CreateObject("ADODB.Connection") oConnection.Provider = "ADsDSOObject" oConnection.Open "ADs Provider"  strQuery = "<LDAP://" & strDomainNC & ">;" & strFilter & ";distinguishedName,objectClass,name,sidHistory;subtree"  'Execute the query set oRecordSet = oConnection.Execute(strQuery) if oRecordSet.Eof then   WScript.Echo "No objects were found"   WScript.Quit(0) Else   Dim vClasses 'As Variant   Dim strClass 'As String    WScript.Echo "The following objects were found:"    'On Error Resume Next    ' Iterate through the objects that match the filter   While Not oRecordset.Eof      vClasses = oRecordset.Fields("objectClass").Value      strClass = vClasses(UBound(vClasses))      WScript.Echo "Name: " & oRecordset.Fields("name").Value & "   Class: " & strClass & "  DN: " & oRecordset.Fields("distinguishedName").Value       If IsNull(oRecordSet.Fields("sIDHistory").Value ) Then         WScript.Echo "This object does not have a sidHistory"      Else 	set oDirObject = GetObject("LDAP://" & oRecordset.Fields("distinguishedName").Value)          vArray = oDirObject.GetEx("sIDHistory")         For Each vSid in vArray          oDirObject.PutEx ADS_PROPERTY_DELETE, "sIDHistory", array(vSid)           oDirObject.SetInfo          Next         WScript.Echo "The sidHistory has been cleared for this object!"      End if            oRecordset.MoveNext   Wend End if  'Clean up Set oRecordset = Nothing Set oConnection = Nothing  '========================================================================================================================= ' The ParseCommandLine subroutine will build the query filter base on the arguments passed to the script.  The bNameFlag ' is used so that the name given can have spaces in it. '========================================================================================================================= Sub ParseCommandLine()    Dim vArgs, Value, Equals, I    Dim bNameFlag 'As Boolean    Dim strName 'As String    Dim strObjectCategory 'As String    Dim strObjectClass 'As String     Set vArgs = WScript.Arguments    if VArgs.Count < 1 Then       DisplayUsage()    End if    bNameFlag = False   For I = 0 to vArgs.Count - 1       If Left( vArgs(I) , 1 ) = "/" Or Left( vArgs(I) , 1 ) = "-" Then           Value = ""          Equals = InStr( vArgs(I) , "=" )          If Equals = 0 Then Equals = InStr( vArgs(I) , ":" )          If Equals > 0 Then Value = Mid( vArgs(I) , Equals + 1 )           Select Case LCase( Mid( vArgs(I) , 2 , 1) )     		Case "n" strName = Value 			 bNameFlag = True  'This will allow us to catch spaces    		Case "o" strObjectCategory = Value 			 bNameFlag = False                 Case "c" strObjectClass = Value 			 bNameFlag = False 		Case Else DisplayUsage           End Select        	       Else 'no dash or slash;  Check if we are giving a name         if bNameFlag Then            strName = strName & " " & vArgs(I)         else            DisplayUsage         end if      End if    Next  'Should be okay to build filter    If strName = "" Then   WScript.Echo "A name parameter must be given"   WScript.Quit(1) Else   strFilter = "(&(name=" & strName & ")"   If Len(strObjectCategory) > 0 Then      strFilter = strFilter & "(objectCategory=" & strObjectCategory & ")"   End if   If Len(strObjectClass) > 0 Then      strFilter = strFilter & "(objectClass=" & strObjectClass & ")"   End if    strFilter = strFilter & ")" 'Close filter End if End Sub  '========================================================================================================================= ' The DisplayUsage subroutine will display how to use this script, the objectCategory and objectClass arguments are optional. '========================================================================================================================= Sub DisplayUsage()  WScript.Echo "Usage csript.exe " & WScript.ScriptName & vbLF & _       "-n=<name of the object you are looking for>" & vbLF & _      "[-o=<objectCategory of the object you are looking for>]" & vbLF & _      "[-c=<objectClass of the object you are looking for>]"  & vbLF & vbLF & _  	 "Examples : " & vbLF & _ 	 WScript.ScriptName & " -n=My Contact" & vbLF & _ 	 WScript.ScriptName & " -n=Computer1 -o=computer" & vbLF & _  	 WScript.ScriptName & " -n=James Smith -o=Person -c=user"  WScript.Quit(0)  End Sub`
	    
						
	
* Save the document as C:\\ClearSidHistory.vbs
* Run the code. Usage for ClearSidHistory.vbs is as follows: **cscript.exe ClearSidHistory.vbs -n=_<name>_ \[-o=_<objectCategory>_\] \[-c=_<objectClass>_\]**
	\-n=_<name of the object you are looking for>_
	\-o=_<objectCategory of the object you are looking for>_
	\-c=_<objectClass of the object you are looking for>_
	**Examples:**
	**cscript.exe ClearSidHistory.vbs -n=My Contact**
	**cscript.exe ClearSidHistory.vbs -n=Computer1 -o=computer**
	**cscript.exe ClearSidHistory.vbs -n=James Smith -o=Person -c=user**

## ![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/unknown_filename.png]][[#|Properties]]

Article ID: 295758 - Last Review: August 30, 2005 - Revision: 3.2

##### APPLIES TO

* Microsoft Windows 2000 Server

* Microsoft Active Directory Service Interfaces 2.5

|     |     |
| --- | --- |
| ##### Keywords: | kbhowto kb32bitonly kbprb KB295758 |

[![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/uparrow.gif]]Back to the top](http://support.microsoft.com/kb/295758#top) | [Give Feedback](http://support.microsoft.com/kb/295758#survey)

## ![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/unknown_filename.png]][[#|Give Feedback]]

[[#|]]

Was this information helpful?

|     |     |
| --- | --- |
|     | Yes |

|     |     |
| --- | --- |
|     | No  |

|     |     |
| --- | --- |
|     | Somewhat |

How much effort did you personally put forth to use this article?

|     |     |
| --- | --- |
|     | Very low |

|     |     |
| --- | --- |
|     | Low |

|     |     |
| --- | --- |
|     | Moderate |

|     |     |
| --- | --- |
|     | High |

|     |     |
| --- | --- |
|     | Very high |

Tell us what we can do to improve this article

|     |     |     |
| --- | --- | --- |
|     |     |     |

		## Other Microsoft sites
	

* [![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/windowslogo.png]]](http://windows.microsoft.com/en-US/windows/home)
	[Windows](http://windows.microsoft.com/en-US/windows/home)
	
* [![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/officelogo_new.png]]](http://office.microsoft.com/en-us/)
	[Office](http://office.microsoft.com/en-us/)
	
* [![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/fallpromo_bug_black.png]]](http://www.microsoft.com/surface/en-us/)
	[Surface](http://www.microsoft.com/surface/en-us/)
	
* [![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/phonelogo.png]]](http://www.microsoft.com/windowsphone/en-us/default.aspx)
	[Windows Phone](http://www.microsoft.com/windowsphone/en-us/default.aspx)
	
* [![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/nokialogo.png]]](http://www.microsoft.com/en-us/mobile/)
	[Mobile devices](http://www.microsoft.com/en-us/mobile/)
	
* [![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/xboxlogo.png]]](http://www.xbox.com/en-US/)
	[Xbox](http://www.xbox.com/en-US/)
	
* [![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/skypelogo52px.png]]](http://www.skype.com/intl/en-us/home)
	[Skype](http://www.skype.com/intl/en-us/home)
	
* [![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/msn_symbol_clr_52x52.png]]](http://www.msn.com/?OCID=MicroHP)
	[MSN](http://www.msn.com/?OCID=MicroHP)
	
* [![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/binglogo.png]]](http://www.bing.com/)
	[Bing](http://www.bing.com/)
	
* [![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/storelogo.png]]](http://store.microsoft.com/?WT.mc_id=SMCMSCOM_ENUS_NAV_BUYALL)
	[Microsoft Store](http://store.microsoft.com/?WT.mc_id=SMCMSCOM_ENUS_NAV_BUYALL)
	

		### Downloads
	

* [Download center](http://www.microsoft.com/en-us/download/default.aspx)
* [Windows downloads](http://www.microsoft.com/en-us/download/windows.aspx?q=windows)
* [Office downloads](http://www.microsoft.com/en-us/download/office.aspx?q=office)
* [Service Pack downloads](http://www.microsoft.com/en-us/download/search.aspx?q=)
* [Direct X download](http://support.microsoft.com/kb/179113/)

		### Security
	

* [Virus and Security solution center](http://support.microsoft.com/gp/cu_sc_virsec_master/)
* [Security home page](http://www.microsoft.com/security/default.aspx)
* [Microsoft Update](http://update.microsoft.com/microsoftupdate)
* [Download Security Essentials](http://windows.microsoft.com/en-US/windows/products/security-essentials/?WT.mc_id=SMCPSC_ENUS_TEXT_DNLD)
* [Malware Removal tool](http://www.microsoft.com/security/pc-security/malware-removal.aspx)

		### Support
	

* [Knowledge Base search](http://support.microsoft.com/search?query=kb)
* [Supported Products list](http://support.microsoft.com/AllProducts)
* [Support offerings](http://support.microsoft.com/gp/support-options-for-home-users/en-us)
* [Product support lifecycle](http://support.microsoft.com/gp/lifecycle)
* [Small and medium business support](http://smallbusiness.support.microsoft.com/)
* [IT Pro support](http://technet.microsoft.com/en-us/ms772425?WT.mc_id=SMCfoot_ENUS_TEXT)
* [Developer support](http://msdn.microsoft.com/en-us/hh361695?WT.mc_id=SMCfoot_ENUS_TEXT)

		### About Microsoft
	

* [Microsoft](http://www.microsoft.com/about/en/us/default.aspx)
* [Careers](http://www.microsoft.com/careers)
* [Company news](http://www.microsoft.com/en-us/news/)
* [Investor relations](http://www.microsoft.com/investor)
* [Site map](http://www.microsoft.com/en/us/sitemap.aspx)

		### Popular resources
	

* [Microsoft Outlook Express](http://windows.microsoft.com/en-US/windows/download-outlook-express)
* [Microsoft Fix It downloads](http://support.microsoft.com/fixit)
* [Windows keyboard shortcuts](http://windows.microsoft.com/en-us/windows7/Keyboard-shortcuts)
* [Microsoft Visual C library runtime error](http://social.technet.microsoft.com/Forums/en/itprovistaapps/thread/b5d10db8-2980-4fe6-81e0-f232eab4037a)
* [Windows Installer error: service could not be accessed](http://support.microsoft.com/kb/324516/)
* [How to: Windows XP system restore](http://support.microsoft.com/kb/306084/)
* [Windows update error message](http://support.microsoft.com/mats/windows_update/)
* [Microsoft Security Essentials manual update download](http://support.microsoft.com/kb/971606/)
* [Inbox Scanpst.exe](http://support.microsoft.com/kb/272227/)
* [Privacy questions](http://go.microsoft.com/fwlink/?LinkId=321116)

[![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/footer_globe.png]]United States](http://support.microsoft.com/mscomcloud/footer.aspx?ln=en-US&mstLocPickShow=true)

[![[./_resources/How_To_Use_Visual_Basic_Script_to_Clear_SidHistory_support.microsoft.com.resources/microsoft_logo_footer_v3.png]]](http://www.microsoft.com/en/us/default.aspx)

* [Contact Us](http://support.microsoft.com/contactus/?ws=mscom)
* [Terms of Use](http://go.microsoft.com/fwlink/?LinkID=206977)
* [Trademarks](http://go.microsoft.com/?linkid=9851308)
* [Privacy & Cookies](http://go.microsoft.com/fwlink/?LinkId=248681)
* [About our ads](http://go.microsoft.com/fwlink/?LinkID=286759)
* ©2015 Copyright
