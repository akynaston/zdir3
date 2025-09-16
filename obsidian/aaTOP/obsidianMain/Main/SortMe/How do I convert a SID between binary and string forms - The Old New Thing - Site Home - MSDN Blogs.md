---
tags: ["#AD"]
---
# How do I convert a SID between binary and string forms? - The Old New Thing - Site Home - MSDN Blogs

* [Sign in](http://login.live.com/login.srf?wa=wsignin1.0&rpsnv=11&ct=1279221763&rver=6.0.5286.0&wp=MBI&wreply=http:%2F%2Fblogs.msdn.com%2Fb%2Foldnewthing%2Farchive%2F2004%2F03%2F15%2F89753.aspx&lc=1033&id=271611)

[![[./_resources/How_do_I_convert_a_SID_between_binary_and_string_forms_-_The_Old_New_Thing_-_Site_Home_-_MSDN_Blogs.resources/logo_msdn.png]]](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/)

* [Home](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/)

* [Microsoft Blog Images](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/Microsoft_Blog_Images/)
* [More ...](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/#)

* [Microsoft Blog Images](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/Microsoft_Blog_Images/)

[The Old New Thing](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/b/oldnewthing/)

Translate this page
[Microsoft® Translator](http://www.microsofttranslator.com/?ref=MSTWidget)<http://www.microsofttranslator.com/widget/?ref=MSTWidget>
enCheck out this page intranslated fromTranslated:Original:Automatic translation powered by Microsoft® TranslatorStart translatingStop translatingCloseClose and show original page

Common Tasks

* [RSS for Posts](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/b/oldnewthing/rss.aspx)
* [RSS for Comments](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/b/oldnewthing/rsscomments.aspx)
* [Atom](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/b/oldnewthing/atom.aspx)

Search

* \* [Advanced search options...](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/#)
* Search In:
* Date range:
* 

Search this blog Search all blogs

News

Holy cow, [I wrote a book](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/oldnewthing/archive/2006/12/07/1233002.aspx)!

[![[./_resources/How_do_I_convert_a_SID_between_binary_and_string_forms_-_The_Old_New_Thing_-_Site_Home_-_MSDN_Blogs.resources/0321440307.jpg]]![[./_resources/How_do_I_convert_a_SID_between_binary_and_string_forms_-_The_Old_New_Thing_-_Site_Home_-_MSDN_Blogs.resources/ir-t=tholneth-20&l=as2&o=1&a=0321440307.gif]]](http://www.amazon.com/gp/product/0321440307?ie=UTF8&tag=tholneth-20&linkCode=as2&camp=1789&creative=9325&creativeASIN=0321440307)

Basics

* [Archives](http://blogs.msdn.com/b/oldnewthing/p/archives.aspx)
* [Ground Rules](http://blogs.msdn.com/oldnewthing/archive/2004/02/21/77681.aspx)
* [Suggestion Box](http://blogs.msdn.com/oldnewthing/pages/407234.aspx)
* [Contact Me](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/oldnewthing/pages/232903.aspx)
* [Disclaimers and such](http://blogs.msdn.com/oldnewthing/pages/4520252.aspx)

Blogroll

* [The Daily WTF](http://www.thedailywtf.com/)
* [Michael Kaplan](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/b/michkap/)
* [NT Debugging](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/b/ntdebugging/)

Categories

* [Code](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/oldnewthing/archive/tags/Code/default.aspx)
* [History](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/oldnewthing/archive/tags/History/default.aspx)
* [Non-Computer](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/oldnewthing/archive/tags/Non-Computer/default.aspx)
* [Other (Computer)](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/oldnewthing/archive/tags/Other/default.aspx)
* [Tips/Support](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/oldnewthing/archive/tags/Tips_2F00_Support/default.aspx)
* [Miniseries](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/oldnewthing/pages/1059515.aspx)

# How do I convert a SID between binary and string forms?

[MSDN Blogs](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/) \> [The Old New Thing](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/b/oldnewthing/) \> [How do I convert a SID between binary and string forms?](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/b/oldnewthing/archive/2004/03/15/89753.aspx)

### How do I convert a SID between binary and string forms?

[![[./_resources/How_do_I_convert_a_SID_between_binary_and_string_forms_-_The_Old_New_Thing_-_Site_Home_-_MSDN_Blogs.resources/anonymous.gif]]](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/members/oldnewthing/)[oldnewthing](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/members/oldnewthing/)
15 Mar 2004 7:00 AM

* Comments [9](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/#comments)

Of course, if you want to do this programmatically, you would use [ConvertSidToStringSid](http://msdn.microsoft.com/library/en-us/security/security/convertsidtostringsid.asp) and [ConvertStringSidtoSid](http://msdn.microsoft.com/library/en-us/security/security/convertstringsidtosid.asp), but often you're studying a memory dump or otherwise need to do the conversion manually.

If you have a SID like S-a-b-c-d-e-f-g-...

Then the bytes are

|     |     |
| --- | --- |
| a   | (revision) |
| N   | (number of dashes minus two) |
| bbbbbb | (six bytes of "b" treated as a 48-bit number in big-endian format) |
| cccc | (four bytes of "c" treated as a 32-bit number in little-endian format) |
| dddd | (four bytes of "d" treated as a 32-bit number in little-endian format) |
| eeee | (four bytes of "e" treated as a 32-bit number in little-endian format) |
| ffff | (four bytes of "f" treated as a 32-bit number in little-endian format) |
| etc. |     |

So for example, if your SID is `S-1-5-21-2127521184-1604012920-1887927527-72713`, then your raw hex SID is

010500000000000515000000A065CF7E784B9B5FE77C8770091C0100

This breaks down as follows:

|     |     |
| --- | --- |
| 01  | S-1 |
| 05  | (seven dashes, seven minus two = 5) |
| 000000000005 | (5 = 0x000000000005, big-endian) |
| 15000000 | (21 = 0x00000015, little-endian) |
| A065CF7E | (2127521184 = 0x7ECF65A0, little-endian) |
| 784B9B5F | (1604012920 = 0x5F9B4B78, little-endian) |
| E77C8770 | (1887927527 = 0X70877CE7, little-endian) |
| 091C0100 | (72713 = 0x00011c09, little-endian) |

Yeah, that's great, Raymond, but what do all those numbers mean?

|     |     |
| --- | --- |
| S-1- | version number (SID\_REVISION) |
| \-5- | SECURITY\_NT\_AUTHORITY |
| \-21- | SECURITY\_NT\_NON\_UNIQUE |
| \-...-...-...- | these identify the machine that issued the SID |
| 72713 | unique user id on the machine |

Each machine generates a unique ID that it uses to stamp all the SIDs it creates (-...-...-...-). The last number is a "relative id (RID)" that represents a user created by that machine. There are a bunch of predefined RIDs; you can see them in the header file ntseapi.h, which is also where I got these names from. The system reserves RIDs up to 999, so the first non-builtin account gets assigned ID number 1000. The number 72713 means that this particular SID is the 71714th SID created by the issuer. (The machine that issued this SID is clearly a domain controller, responsible for creating the accounts of tens of thousands of users.)

(Actually, I lied above when I said that this is the 71714th SID created by the issuer. Large servers can delegate SID creation to helpers, in which case SID issuance is no longer strictly consecutive.)

Security isn't my area of expertise, so it's entirely possibly (perhaps even likely) that I got something wrong up above. But it's mostly correct, I think.

* [9 Comments](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/b/oldnewthing/archive/2004/03/15/89753.aspx#comments)

[Other](http://blogs.msdn.com/b/oldnewthing/archive/tags/Other/)

[Comments](http://blogs.msdn.com/b/oldnewthing/archive/2004/03/15/b/oldnewthing/rsscomments.aspx)

* ![[./_resources/How_do_I_convert_a_SID_between_binary_and_string_forms_-_The_Old_New_Thing_-_Site_Home_-_MSDN_Blogs.resources/anonymous.gif]]sd
	15 Mar 2004 8:08 AM
	huh?
	
* ![[./_resources/How_do_I_convert_a_SID_between_binary_and_string_forms_-_The_Old_New_Thing_-_Site_Home_-_MSDN_Blogs.resources/anonymous.gif]][Andreas Magnusson](http://www.rotd.org/)
	15 Mar 2004 8:58 AM
	So what are the security issues with giving out ones SID?
	
* ![[./_resources/How_do_I_convert_a_SID_between_binary_and_string_forms_-_The_Old_New_Thing_-_Site_Home_-_MSDN_Blogs.resources/anonymous.gif]]Larry Osterman
	15 Mar 2004 9:03 AM
	As far as I know, there aren't any issues with giving out the SID - except for one minor issue.
	The -...-...-...- actually identify the domain that issued the SID, and that means that it's possible to corrolate the domain on which a user account is created.
	That means that if you know one account on a domain that has a weak security policy, you can know if other accounts are also created on the same domain.
	It's a small bit of information disclosure, but in the scheme of things...
	If you think about it, the SID of all the users in an ACL are included in the security descriptor for objects, and the security descriptor contents are semi-public information (you need READ\_CONTROL access rights to the object).
	But I'm also not a security guy (although I've done a LOT of security work).
	
* ![[./_resources/How_do_I_convert_a_SID_between_binary_and_string_forms_-_The_Old_New_Thing_-_Site_Home_-_MSDN_Blogs.resources/anonymous.gif]]Adrian Oney
	15 Mar 2004 10:44 AM
	Same boat as Raymond - not a security guy, but I've done a good amount of security work.
	I personally found the information on SIDs in the SDK and even Howard & LeBlanc's excellent "Writing Secure Code" book somewhat lacking in organization. When I had to put things together for the DDK, I organized the list of SIDs this way (from wdmsec.h):
	Each SID is listed in the form EnglishName ("SDDL Abbreviation", FullSID, Authority:SubAuthorities)
	The following SIDs represent \*accounts\* on the local machine:
	\-------------------------------------------------------------
	System ("SY", S-1-5-18, SECURITY\_NT\_AUTHORITY:SECURITY\_LOCAL\_SYSTEM\_RID)
	The OS itself (including its user mode components.)
	Local Service ("LS", S-1-5-19, SECURITY\_NT\_AUTHORITY:SECURITY\_LOCAL\_SERVICE\_RID)
	A predefined account for services that presents user credentials for local
	resources and annonymous credentials for network access.
	Available on XP and later.
	Network Service ("NS", S-1-5-20, SECURITY\_NT\_AUTHORITY:SECURITY\_NETWORK\_SERVICE\_RID)
	A predefined account for services that presents user credentials for local
	resources and the machine ID for network access.
	Available on XP and later.
	(A local \*account\* for a guest and a default administrator also exist, but
	the corresponding SDDL abbreviations are not supported by this library.
	Use the corresponding group SIDs instead.)
	The following SIDs represent \*groups\* on the local machine:
	\-----------------------------------------------------------
	Administrators ("BA", S-1-5-32-544, SECURITY\_NT\_AUTHORITY:SECURITY\_BUILTIN\_DOMAIN\_RID:DOMAIN\_ALIAS\_RID\_ADMINS)
	The builtin administrators group on the machine. This is not the same
	as the builtin Administrator \*account\*.
	Builtin users group ("BU", S-1-5-32-545, SECURITY\_NT\_AUTHORITY:SECURITY\_BUILTIN\_DOMAIN\_RID:DOMAIN\_ALIAS\_RID\_USERS)
	Group covering all local user accounts, and users on the domain.
	Builtin guests group ("BG", S-1-5-32-546, SECURITY\_NT\_AUTHORITY:SECURITY\_BUILTIN\_DOMAIN\_RID:DOMAIN\_ALIAS\_RID\_GUESTS)
	Group covering users logging in using the local or domain guest account.
	This is not the same as the builtin Guest \*account\*.
	The below SIDs describe the authenticity of the user's identity:
	\----------------------------------------------------------------
	Authenticated Users ("AU", S-1-5-11, SECURITY\_NT\_AUTHORITY:SECURITY\_AUTHENTICATED\_USER\_RID)
	Any user recognized by the local machine or by a domain. Note that
	users logged in using the Builtin Guest account are not authenticated.
	However, members of the Guests group with individual accounts on the
	machine or domain are authenticated.
	Anonymous Logged-on User ("AN", S-1-5-7, SECURITY\_NT\_AUTHORITY:SECURITY\_ANONYMOUS\_LOGON\_RID)
	Any user logged on without an identity, for instance via an anonymous
	network session. Note that users logged in using the Builtin Guest
	account are neither authenticated nor anonymous. Available on XP and
	later.
	World ("WD", S-1-1-0, SECURITY\_WORLD\_SID\_AUTHORITY:SECURITY\_WORLD\_RID)
	Prior to Windows XP, this SID covers every session: authenticated,
	anonymous, and the Builtin Guest account.
	For Windows XP and later, this SID does not cover anonymous logon
	sessions - only authenticated and the Builtin Guest account.
	Note that untrusted or "restricted" code is also not covered by the
	World SID. See the Restricted Code SID description for more
	information.
	The below SIDs describe how the user logged into the machine:
	\-------------------------------------------------------------
	Interactive Users ("IU", S-1-5-4, SECURITY\_NT\_AUTHORITY:SECURITY\_INTERACTIVE\_RID)
	Users who initally logged onto the machine "interactively", such as
	local logons and Remote Desktops logons.
	Network Logon User ("NU", S-1-5-2, SECURITY\_NT\_AUTHORITY:SECURITY\_NETWORK\_RID)
	Users accessing the machine remotely, without interactive desktop
	access (ie, file sharing or RPC calls).
	Terminal Server Users (---, S-1-5-14, SECURITY\_NT\_AUTHORITY:SECURITY\_TERMINAL\_SERVER\_RID)
	Interactive Users who \*initially\* logged onto the machine specifically
	via Terminal Services or Remote Desktop.
	(NOTE: There is currently no SDDL token for this SID. Furthermore, the
	presence of the SID doesn't take into account fast user switching
	either.)
	The below SID deserves special mention:
	\---------------------------------------
	Restricted Code ("RC", S-1-5-12, SECURITY\_NT\_AUTHORITY:SECURITY\_RESTRICTED\_CODE\_RID)
	This SID is used to control access by untrusted code.
	ACL validation against tokens with RC go through \*two\* checks, one
	against the token's normal list of SIDs (containing WD for instance),
	and one against a second list (typically containing RC and a subset of
	the original token SIDs). Only if both tests pass is access granted.
	As such, RC actually works in \*combination\* with other SIDs.
	When RC is paired with WD in an ACL, a \*superset\* of Everyone
	\_including\_ untrusted code is described. RC is thus rarely seen in
	ACL's without the WD token.
	
* ![[./_resources/How_do_I_convert_a_SID_between_binary_and_string_forms_-_The_Old_New_Thing_-_Site_Home_-_MSDN_Blogs.resources/anonymous.gif]]Pavel Lebedinsky
	15 Mar 2004 11:20 PM
	If you're looking at a memory dump then you can also use !sid debugger extension:
	c:\\debuggers> cdb notepad
	0:000> dc RPCRT4!AnonymousSid
	78073fc8 00000101 05000000 00000007
	0:000> !sid RPCRT4!AnonymousSid 1
	SID is: S-1-5-7 (Well Known Group: NT AUTHORITY\\ANONYMOUS LOGON)
	
* ![[./_resources/How_do_I_convert_a_SID_between_binary_and_string_forms_-_The_Old_New_Thing_-_Site_Home_-_MSDN_Blogs.resources/anonymous.gif]]Florian W.
	16 Mar 2004 12:37 AM
	My greatest highlight inside the security-API-documentation on MSDN is the article: "Windows NT Security in Theory and Practice". This article has a nice line: 'First, you should definitely read Robert Reichel's two-part article "Inside Windows NT Security," which appeared in the April 1993 and May 1993 issues of the Windows/DOS Developer's Journal'.
	Unfortunatly, that article is \*not\* part of MSDN:-(
	
* ![[./_resources/How_do_I_convert_a_SID_between_binary_and_string_forms_-_The_Old_New_Thing_-_Site_Home_-_MSDN_Blogs.resources/anonymous.gif]]Norman Diamond
	17 Mar 2004 10:17 PM
	I found one article by Robert Reichel on windows security. He's a real estate agent, and he recommended that windows on and near the ground floor should be locked.
	As for that other Robert Reichel, it seems his articles would likely be included in a CD that was made by the original publisher, but the CD is sold out. CMP has more recent archives posted on their web site. Anyone know if they could be persuaded to do the same with older ones?
	
* ![[./_resources/How_do_I_convert_a_SID_between_binary_and_string_forms_-_The_Old_New_Thing_-_Site_Home_-_MSDN_Blogs.resources/anonymous.gif]][Raymond Chen](http://weblogs.asp.net/oldnewthing/)
	2 Aug 2004 2:20 PM
	Commenting closes after two weeks.
	<http://weblogs.asp.net/oldnewthing/archive/2004/02/21/77681.aspx>
	
* ![[./_resources/How_do_I_convert_a_SID_between_binary_and_string_forms_-_The_Old_New_Thing_-_Site_Home_-_MSDN_Blogs.resources/anonymous.gif]][Hex SID to Decimal SID Translation « Scripting. Stuff. (By Froosh)](http://froosh.wordpress.com/2005/10/21/hex-sid-to-decimal-sid-translation/)
	3 Sep 2007 10:32 PM
	
	PingBack from <http://froosh.wordpress.com/2005/10/21/hex-sid-to-decimal-sid-translation/>
	

Page 1 of 1 (9 items)

* © 2010 Microsoft Corporation. All rights reserved.
* [Terms of Use](http://msdn.microsoft.com/en-us/cc300389.aspx)
* [Trademarks](http://www.microsoft.com/library/toolbar/3.0/trademarks/en-us.mspx)
* [Privacy Statement](http://www.microsoft.com/info/privacy.mspx)
* 

[![[./_resources/How_do_I_convert_a_SID_between_binary_and_string_forms_-_The_Old_New_Thing_-_Site_Home_-_MSDN_Blogs.resources/0.gif]]](http://www.omniture.com/)
