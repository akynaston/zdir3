---
tags: ["#AD"]
---
# Re: Convert objectSID to string Tech-Archive recommends: Repair Windows Errors &

# Re: Convert objectSID to string

**Tech-Archive recommends: [Repair Windows Errors & Optimize Windows Performance](http://www.liutilities.com/affcb/?id=RBderkeiler&aff=8951&xat=keilerRBTL1techarive)**

* * *

* _From_: "Joe Richards \[MVP\]" <[humorexpress@xxxxxxxxxxx](mailto:humorexpress@DOMAIN.HIDDEN)\>
* _Date_: Fri, 07 Jul 2006 16:45:30 -0400

* * *

Richard does this handle ADAM SIDs as well as AD SIDs? The format is a little different and many of the scripts I have seen to do the conversion tend to break. I didn't look very close at this one I admit.
Around last september or so I worked with someone on one of the newsgroups on how to do this properly so it works for any SID and not just on SIDs with the assumption they have the same number of subauthorities that a domain SID has.
I should dig that out and blog it.
\--
Joe Richards Microsoft MVP Windows Server Directory Services
Author of O'Reilly Active Directory Third Edition
www.joeware.net
\---O'Reilly Active Directory Third Edition now available---
<http://www.joeware.net/win/ad3e.htm>
Richard Mueller wrote:

> Seagull Ng wrote:
> 
> > To convert from this format
> > X'0105000000000005150000006b50545832786a116a7cf24ee8030000' to
> > S-1-5-21-1481920619-292190258-1324514410-134914
> > Thanks Joe.
> 
> Hi,
> A function to convert SID values is not easy in VBScript. After recent correspondence with someone in the newsgroups I've come up with this code (watch line wrapping):
> Option Explicit
> Dim objUser
> Set objUser = GetObject("[LDAP://cn=Joe](http://ldap://cn=Joe) User,ou=Sales,dc=MyDomain,dc=com")
> Wscript.Echo ObjSidToStrSid(objUser.objectSid)
> Function ObjSidToStrSid(arrSid)
> ' Function to convert OctetString (byte array) to Decimal string (SDDL) Sid.
> Dim strHex, strDec
> strHex = OctetStrToHexStr(arrSid)
> strDec = HexStrToDecStr(strHex)
> ObjSidToStrSid = strDec
> End Function ' ObjSidToStrSid
> Function OctetStrToHexStr(arrbytOctet)
> ' Function to convert OctetString (byte array) to Hex string.
> Dim k
> OctetStrToHexStr = ""
> For k = 1 To Lenb(arrbytOctet)
> OctetStrToHexStr = OctetStrToHexStr \_
> & Right("0" & Hex(Ascb(Midb(arrbytOctet, k, 1))), 2)
> Next
> End Function ' OctetStrToHexStr
> Function HexStrToDecStr(strSid)
> ' Function to convert Hex string Sid to Decimal string (SDDL) Sid.
> ' SID anatomy:
> ' Byte Position
> ' 0 : SID Structure Revision Level (SRL)
> ' 1 : Number of Subauthority/Relative Identifier
> ' 2-7 : Identifier Authority Value (IAV) \[48 bits\]
> ' 8-x : Variable number of Subauthority or Relative Identifier (RID) \[32 bits\]
> '
> ' Example:
> '
> ' <Domain/Machine>\\Administrator
> ' Pos : 0 | 1 | 2 3 4 5 6 7 | 8 9 10 11 | 12 13 14 15 | 16 17 18 19 | 20 21 22 23 | 24 25 26 27
> ' Value: 01 | 05 | 00 00 00 00 00 05 | 15 00 00 00 | 06 4E 7D 7F | 11 57 56 7A | 04 11 C5 20 | F4 01 00 00
> ' str : S- 1 | | -5 | -21 | -2138918406 | -2052478737 | -549785860 | -500
> Const BYTES\_IN\_32BITS = 4
> Const SRL\_BYTE = 0
> Const IAV\_START\_BYTE = 2
> Const IAV\_END\_BYTE = 7
> Const RID\_START\_BYTE = 8
> Const MSB = 3 'Most significant byte
> Const LSB = 0 'Least significant byte
> Dim arrbytSid, lngTemp, base, offset, i
> ReDim arrbytSid(Len(strSid)/2 - 1)
> ' Convert hex string into integer array
> For i = 0 To UBound(arrbytSid)
> arrbytSid(i) = CInt("&H" & Mid(strSid, 2 \* i + 1, 2))
> Next
> ' Add SRL number
> HexStrToDecStr = "S-" & arrbytSid(SRL\_BYTE)
> ' Add Identifier Authority Value
> lngTemp = 0
> For i = IAV\_START\_BYTE To IAV\_END\_BYTE
> lngTemp = lngTemp \* 256 + arrbytSid(i)
> Next
> HexStrToDecStr = HexStrToDecStr & "-" & CStr(lngTemp)
> ' Add a variable number of 32-bit subauthority or
> ' relative identifier (RID) values.
> ' Bytes are in reverse significant order.
> ' i.e. HEX 01 02 03 04 => HEX 04 03 02 01
> ' = (((0 \* 256 + 04) \* 256 + 03) \* 256 + 02) \* 256 + 01
> ' = DEC 67305985
> For base = RID\_START\_BYTE To UBound(arrbytSid) Step BYTES\_IN\_32BITS
> lngTemp = 0
> For offset = MSB to LSB Step -1
> lngTemp = lngTemp \* 256 + arrbytSid(base + offset)
> Next
> HexStrToDecStr = HexStrToDecStr & "-" & CStr(lngTemp)
> Next
> End Function ' HexStrToDecStr

.

* * *

* **Follow-Ups**:
	* **[Re: Convert objectSID to string](http://msg00396.html/)**
		* _From:_ Richard Mueller

* **References**:
	* **[Re: Convert objectSID to string](http://msg00368.html/)**
		* _From:_ Joe Kaplan \\(MVP - ADSI\\)
	* **[Re: Convert objectSID to string](http://msg00373.html/)**
		* _From:_ Richard Mueller

* Prev by Date: **[Problem with Tree Root Trusts and Cached Credentials.](http://msg00391.html/)**
* Next by Date: **[Re: Permissions on user keep changing](http://msg00393.html/)**
* Previous by thread: **[Re: Convert objectSID to string](http://msg00379.html/)**
* Next by thread: **[Re: Convert objectSID to string](http://msg00396.html/)**
* Index(es):
	* [**Date**](http://maillist.html/#00392)
	* [**Thread**](http://threads.html/#00392)

* * *

|     |     |
| --- | --- |
| ## Relevant Pages<br><br>* [Re: Convert objectSID to string](http://www.tech-archive.net/Archive/Windows/microsoft.public.windows.server.active_directory/2006-07/msg00373.html)<br>	**...** **OctetStrToHexStr** = OctetStrToHexStr \_ **...** ' Function to convert **Hex string Sid** to Decimal string Sid. **...** **Const** BYTES\_IN\_32BITS = 4 **...**<br>	(microsoft.public.windows.server.active\_directory)<br>* [Re: Convert objectSID to string](http://www.tech-archive.net/Archive/Windows/microsoft.public.windows.server.active_directory/2006-07/msg00396.html)<br>	**...** on how to do this properly so it works for any **SID** and not just on SIDs **...** **OctetStrToHexStr** = OctetStrToHexStr \_ **...** ' Function to convert **Hex string Sid** to Decimal string Sid. **...** **Const** BYTES\_IN\_32BITS = 4 **...**<br>	(microsoft.public.windows.server.active\_directory)<br>* [Re: Converting binary sids to a hex string](http://coding.derkeiler.com/Archive/Python/comp.lang.python/2006-06/msg01451.html)<br>	**...** **binary sid** to a **hex string.** **...** **print MySid** **...**<br>	(comp.lang.python)<br>* [Re: How to retrieve a SID with vbscript ?](http://www.tech-archive.net/Archive/Scripting/microsoft.public.scripting.vbscript/2004-12/0193.html)<br>	**...** I also have found that **NameTranslate** can convert from Sid to DN, **...** Dim objUser, arrSid, **strSidHex,** objTrans, strUserDN, strSidDec **...** ' **Retrieve SID** and convert to **hex string,** **...**<br>	(microsoft.public.scripting.vbscript)<br>* [Converting binary sids to a hex string](http://coding.derkeiler.com/Archive/Python/comp.lang.python/2006-06/msg01049.html)<br>	**...** I am trying to create a hexstring of a **NT4 user account sid** which I can in **...** **binary sid** to a **hex string.** **...** a PySID to a **hexstring.** **...**<br>	(comp.lang.python) |     |

* * *

(17)

[![[./_resources/Re_Convert_objectSID_to_string_Tech-Archive_recommends_Repair_Windows_Errors_&.resources/logota.png]]](http://www.tech-archive.net/Archive/Windows/microsoft.public.windows.server.active_directory/2006-07/)

* [Windows](http://www.tech-archive.net/)
* [Science](http://sci.tech-archive.net/)
* [Usenet](http://newsgroups.derkeiler.com/)

* [Archive](http://www.tech-archive.net/Archive/)
* [About](http://www.derkeiler.com/about/)
* [Privacy](http://www.tech-archive.net/privacy/)
* [Search](http://www.tech-archive.net/search/)
* [Imprint](http://www.derkeiler.com/about/imprint)

![[./_resources/Re_Convert_objectSID_to_string_Tech-Archive_recommends_Repair_Windows_Errors_&.resources/arrow.gif]][www.tech-archive.net](http://www.tech-archive.net/)  > [Archive](http://www.tech-archive.net/Archive/)  > [Windows](http://www.tech-archive.net/Archive/Windows/)  > [microsoft.public.windows.server.active_directory](http://www.tech-archive.net/Archive/Windows/microsoft.public.windows.server.active_directory/)  > [2006-07](http://www.tech-archive.net/Archive/Windows/microsoft.public.windows.server.active_directory/2006-07/)    [![[./_resources/Re_Convert_objectSID_to_string_Tech-Archive_recommends_Repair_Windows_Errors_&.resources/pdf.jpg]]](http://www.tech-archive.net/pdf/Archive/Windows/microsoft.public.windows.server.active_directory/2006-07/msg00392.pdf)  [![[./_resources/Re_Convert_objectSID_to_string_Tech-Archive_recommends_Repair_Windows_Errors_&.resources/xml.gif]]](http://www.tech-archive.net/Archive/Windows/microsoft.public.windows.server.active_directory/rss.xml)
