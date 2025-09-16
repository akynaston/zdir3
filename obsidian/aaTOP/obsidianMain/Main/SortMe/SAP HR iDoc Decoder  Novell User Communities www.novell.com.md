# SAP HR iDoc Decoder | Novell User Communities [www.novell.com]

[![[./_resources/SAP_HR_iDoc_Decoder__Novell_User_Communities_www.novell.com.resources/unknown_filename.png]]](http://www.novell.com/)

* [Skip to Content](http://www.novell.com/communities/node/6792/#top)

		### [Solutions](http://www.novell.com/solutions/)
	
		### [Products](http://www.novell.com/products/)
	
		### [Services & Support](http://www.novell.com/services/)
	
		### [Partners](http://www.novell.com/partners/)
	
		### [Communities](http://www.novell.com/communities/)
	
		### [About Novell](http://www.novell.com/company/)
	
		### [How to Buy](http://www.novell.com/products/howtobuy.html)
	

[**Change**](http://www.novell.com/common/util/langselect.php?referer=http%3A//www.novell.com/communities/node/6792/sap-hr-idoc-decoder) **_United States,_ English**

[**Login**](http://www.novell.com/communities/login?destination=node/6792/sap-hr-idoc-decoder)

[Close](http://www.novell.com/communities/node/6792/#)

[Request a Sales Call](http://www.novell.com/company/sales_call_request_popup.html?refid=novell.comleftnav&profile_url=http%3A//www.novell.com/communities/)

[800-529-3400](http://www.novell.com/company/contact.html)

# Tool

* [Cool Solutions](http://www.novell.com/communities/coolsolutions)

* [Novell Forums](http://forums.novell.com)
* [PartnerNet](http://www.novell.com/communities/node/2093/partners)
* [Developer](http://developer.novell.com/wiki/index.php/DeveloperNet)
* [NUI](http://www.novell.com/communities/node/2039/novell%20users%20international%20nui)
* [Novell Blogs](http://www.novell.com/company/blogs/)
* [Help   _>_](http://www.novell.com/communities/node/1382/help)

* [Novell Home](http://www.novell.com)

* [Communities Home](http://www.novell.com/communities)
* [Technical Support](http://www.novell.com/support)
* [Technical Training](http://www.novell.com/training)

## [Search](http://www.novell.com/communities/node/6792/#)

## [Shameless Plugs](http://www.novell.com/communities/node/6792/#)

## [Most Popular](http://www.novell.com/communities/node/6792/#)

### Last viewed:

* [Latest PartnerNet Performance Updates](http://www.novell.com/communities/node/12836/latest-partnernet-system-updates)

* [Help](http://www.novell.com/communities/node/1382/help)
* [Toolkit Rules in Identity Manager Part 4](http://www.novell.com/communities/node/6440/toolkit-rules-identity-manager-part-4)

## [Who's online](http://www.novell.com/communities/node/6792/#)

There are currently _12 users_ and _158 guests_ online.

### Online users

* [coolguys](http://www.novell.com/communities/user/756)

* [kgroneman](http://www.novell.com/communities/user/2470)
* [dlythgoe](http://www.novell.com/communities/user/9031)
* [recurp](http://www.novell.com/communities/user/20475)
* [weaver](http://www.novell.com/communities/user/8241)
* [CANDACED](http://www.novell.com/communities/user/4141)
* [tomanstey](http://www.novell.com/communities/user/6501)
* [cnaughto](http://www.novell.com/communities/user/12194)
* [coolguys](http://www.novell.com/communities/user/756)
* [billwilson2002](http://www.novell.com/communities/user/53355)

[![[./_resources/SAP_HR_iDoc_Decoder__Novell_User_Communities_www.novell.com.resources/unknown_filename.2.png]]](http://www.novell.com/communities/user/19453)

tool

Reads:

## 3748

Score:

5

Comments:

## 2

## SAP HR iDoc Decoder

### Author Info

18 February 2009 - 11:12am
Submitted by: [rimoore](http://www.novell.com/communities/user/19453)

[Author Blog](http://www.novell.com/communities/blog/19453)
[Author Profile](http://www.novell.com/communities/user/19453)

### Tags

[Identity Manager](http://www.novell.com/communities/taxonomy/term/11)
[Tags Map](http://www.novell.com/communities/site-tags)

[_(View Disclaimer)_](http://www.novell.com/communities/node/6792/#disclaimer)

license: 
None

**Q:** When examining an iDoc using a text editor it's very hard to read the data. Is there any way for format the information so it's easier to read?

**A:** You can use the iDoc decoder written by Novell engineering. If your [Java](http://www.novell.com/communities/glossary/term/1591) environment variables are set correctly. You can enter 'java HRIDocDecode' from a command prompt in the directory where you have place the iDoc Decoder. The name is case-sensitive.

You will be prompted for the IDoc type (default HRMD\_A05), IDoc file name, Character-Set encoding, and output file name. Additionally you may specify which infotypes you would like to see, or specify 'all' to get everything decoded. The IDoc meta map file (HRMD\_A0X) that being used by the [SAP](http://www.novell.com/communities/glossary/term/2279) HR driver should be present in the same location as the iDoc decoder.

The output file, if selected, will be placed in the current working directory. If the IDoc is large and/or contains large numbers of objects, this program can take a while to run.

**Instructions:**

1. Enter "java HRIDocDecode" in a command prompt. Java must be in your path or you need to fully qualify the path.

* Enter the "iDoc Type". Example "HRMD\_A07"
* Enter the name of the iDoc file.
* Enter the encoding.
* Enter the name of the output file you want created.
* Enter the infotype to decode or "all" to decode the entire iDoc.

| Attachment | Size |
| --- | --- |
| [HRIDocDecode.zip](http://www.novell.com/communities/files/HRIDocDecode.zip) | 4.48 KB |

_**Disclaimer:** As with everything else at Cool Solutions, this content is definitely not supported by Novell (so don't even think of calling Support if you try something and it blows up)._

_It was contributed by a community member and is published "as is." It seems to have worked for at least one person, and might work for you. But please be sure to test, test, test before you do anything drastic with it._

## Related Articles

* [Finding Relationships Data on the Publisher Channel](http://www.novell.com/communities/node/4299/finding-relationships-data-publisher-channel)

* [Decoding iDOCs with the IDM SAP Driver](http://www.novell.com/communities/node/4144/decoding-idocs-idm-sap-driver)
* [Troubleshooting iDOC Issues in the SAP HR Driver for Identity Manager](http://www.novell.com/communities/node/4562/troubleshooting-idoc-issues-sap-hr-driver-identity-manager)
* [Error Codes of the SAP HR driver for Identity Manager - Part 1](http://www.novell.com/communities/node/9271/error-codes-sap-hr-driver-identity-manager-part-1)
* [SAP HR CMP Integration Driver Walkthrough - Part 9](http://www.novell.com/communities/node/11518/sap-hr-cmp-integration-driver-walkthrough-part-9)

## User Comments

[![[./_resources/SAP_HR_iDoc_Decoder__Novell_User_Communities_www.novell.com.resources/unknown_filename.1.png]]](http://www.novell.com/communities/user/13736)

## [Thanks! I was looking for this a long time.](http://www.novell.com/communities/node/6792/sap-hr-idoc-decoder#comment-5730)

Submitted by [RSynoradzki](http://www.novell.com/communities/user/13736) on 19 February 2009 - 7:30am.

Makes iDoc-information pretty nice!

* Be the first to comment!  To leave a comment you need to [Login or Register](http://www.novell.com/communities/login?destination=node%2F6792)
	

[![[./_resources/SAP_HR_iDoc_Decoder__Novell_User_Communities_www.novell.com.resources/unknown_filename.3.jpeg]]](http://www.novell.com/communities/user/555)

## [Can we get a GUI on top of this too please?](http://www.novell.com/communities/node/6792/sap-hr-idoc-decoder#comment-5733)

Submitted by [geoffc](http://www.novell.com/communities/user/555) on 19 February 2009 - 9:35am.

This looks to be very useful. Better than trying to learn to read iDOCS, (See: [Decoding iDOCS for the IDM SAP HR driver](http://www.novell.com/communities/node/4144/decoding-idocs-idm-sap-driver) and reading them by hand.

Any chance of whipping up a simple gui that lets us pick a file, and then look at the contents? Open another file, look at the contents, and so on?

* Be the first to comment!  To leave a comment you need to [Login or Register](http://www.novell.com/communities/login?destination=node%2F6792)
	

© 2011 Novell

* [Careers](http://www.novell.com/company/careers/index.html)

* [Legal](http://www.novell.com/company/legal/)

[close](http://www.novell.com/communities/node/6792/#)

* [Feedback](http://www.novell.com/inc/feedback/feedback.html)

* [Print](http://www.novell.com/communities/node/6792/#)
* [800-529-3400](http://www.novell.com/company/contact.html)
* [Request a Call](http://www.novell.com/common/inc/requestcall_overlay.html)
* [Follow Novell](http://www.novell.com/communities/node/6792/#)

[Novell](http://www.novell.com/) Making IT Work As One™
