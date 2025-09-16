# AM 4.0 SSO to IDM Home - HTTPS - https://forums.netiq.com/ [forums.netiq.com] - https://forums.netiq.com/

[NetIQ | Micro Focus](http://www.netiq.com/)

* [**Solutions**](http://www.netiq.com/solutions-industries/) 

* [**Products**](http://www.netiq.com/products/) 
* [**Industries**](http://www.netiq.com/solutions-industries/#industries) 
* [**Support**](http://www.netiq.com/services/) 
* [**About**](http://www.netiq.com/company/) 
* [Partners](https://www.partnernetprogram.com/)
* [Communities](http://www.netiq.com/communities/)
_Search_

* [Login](https://www.netiq.com/common/util/secure/login.php?r=https%3A//forums.netiq.com/showthread.php%3F50091-AM-4-0-SSO-to-IDM-Home-HTTPS)

* [**Let's Talk**](http://www.netiq.com/company/contact/) 

## [NetIQ Forums](https://forums.netiq.com/forum.php)

* [Help](https://forums.netiq.com/faq.php)

[![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/today_post.gif]]Today's Posts](https://forums.netiq.com/search.php?do=getdaily&contenttype=vBForum_Post) [![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/mark_read.gif]]Mark All Forums Read](https://forums.netiq.com/forumdisplay.php?do=markread&markreadhash=guest)
.

* [Forum](https://forums.netiq.com/forum.php)

* [New Posts](https://forums.netiq.com/search.php?do=getnew&contenttype=vBForum_Post)
* [FAQ](https://forums.netiq.com/faq.php)
* [Calendar](https://forums.netiq.com/calendar.php)
.

* [Articles](https://forums.netiq.com/content.php)
* [What's New?](https://forums.netiq.com/activity.php)
.

![[]]

* [Advanced Search](https://forums.netiq.com/search.php)

* [![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.9.png]]](https://forums.netiq.com/index.php)

* [Forum](https://forums.netiq.com/forum.php)
* [PRODUCT DISCUSSION FORUMS](https://forums.netiq.com/forumdisplay.php?1-PRODUCT-DISCUSSION-FORUMS)
* [Access Management](https://forums.netiq.com/forumdisplay.php?91-Access-Management)
* [Access Manager](https://forums.netiq.com/forumdisplay.php?6-Access-Manager)
* AM 4.0 SSO to IDM Home - HTTPS
**.**

1. If this is your first visit, be sure to check out the [**FAQ**](https://forums.netiq.com/faq.php) by clicking the link above. You can browse without logging in, but you must register and login before you can post. **Click the login link at the top of this page to proceed**. To start viewing messages, select the forum that you want to visit from the selection below.

Results 1 to 5 of 5

# Thread: [AM 4.0 SSO to IDM Home - HTTPS](https://forums.netiq.com/showthread.php?50091-AM-4-0-SSO-to-IDM-Home-HTTPS)

		###### [[#|Thread Tools]]
	

		###### [[#|Display]]
	

1. 24-Feb-2014, 11:38 [#1](https://forums.netiq.com/showthread.php?50091-AM-4-0-SSO-to-IDM-Home-HTTPS&p=241174#post241174)
	
	[![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.6.png]]](https://forums.netiq.com/member.php?415-jacmarpet)
	
	[**jacmarpet**](https://forums.netiq.com/member.php?415-jacmarpet)
	![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.7.png]] **Senior Member** **![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.1.png]]** ![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.4.png]]
	
	Join Date:
	Aug 2012
	Location:
	Denmark
	Posts:
	311
	
	## AM 4.0 SSO to IDM Home - HTTPS
	
	> Hello,
	> So, SSO with AM to the User Application over HTTPS, worked fine before I applied the IDM Home patch. Using this URL: [https://IP:8543/IDM](https://ip:8543/IDM)
	> Now, after the IDM Home patch has been applied, I'm supposed to use this URL: [https://IP:8543/landing](https://ip:8543/landing)
	> Visiting this site, results in a white page, no errors, nothing. Visiting [https://IP:8543/IDM](https://ip:8543/IDM) - the old UA URL, I get this error in the UA log:
	> 
	> Code:
	> Level: ERROR
	> Java Execution:
	>  Class: com.novell.osp.handler.OSPMainHandler
	>  Method: handleRequest
	>  Line Number: -1
	>  Thread: http-0.0.0.0-8180-2
	> Correlation:
	>  Id: a07ab06b-2891-4983-b94a-3f6d4162dd69
	> Message: Sub-Message Original Java Execution:
	>   Class: com.netiq.oidpp.oauth2.OAuth2Handler
	>   Method: D
	>   Line Number: -1
	>   Thread: http-0.0.0.0-8180-2
	>   Correlation Id: a07ab06b-2891-4983-b94a-3f6d4162dd69
	> Message:
	> Client "redirect\_uri" did not validate against registered urls!
	> 
	> Visiting the normal URLS, without HTTP and using port 8180, I am able to log in fine, and SSO between the UA login screen and the IDM Home login screen works fine. It seems like the SSL configuration doesn't work with the new IDM Home login screen.
	> Any ideas?
	> Thanks in advance,
	> Jacob.
	
	 [![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/clear.gif]] Reply With Quote](https://forums.netiq.com/newreply.php?do=newreply&p=241174) **.**
	
2. 27-Feb-2014, 10:04 [#2](https://forums.netiq.com/showthread.php?50091-AM-4-0-SSO-to-IDM-Home-HTTPS&p=241339#post241339)
	
	[![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.6.png]]](https://forums.netiq.com/member.php?415-jacmarpet)
	
	[**jacmarpet**](https://forums.netiq.com/member.php?415-jacmarpet)
	![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.7.png]] **Senior Member** **![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.1.png]]** ![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.4.png]]
	
	Join Date:
	Aug 2012
	Location:
	Denmark
	Posts:
	311
	
	## Re: AM 4.0 SSO to IDM Home - HTTPS
	
	> Okay, so this error is gone. Didn't change anything though. Still, when I have logged into Access Manager and I am authenicated, I'm shown a white screen instead of the IDM Home dashboard. I did a SAML trace and I can see the following failing:
	> GET [https://ua.hyperschool.dk/IDM/rest/a...users/fullName](https://ua.hyperschool.dk/IDM/rest/access/users/fullName) HTTP/1.1
	> Host: ua.hyperschool.dk
	> User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:27.0) Gecko/20100101 Firefox/27.0
	> Accept: application/json
	> Accept-Language: da,en-us;q=0.7,en;q=0.3
	> Accept-Encoding: gzip, deflate
	> Content-Type: application/json
	> Referer: <https://ua.hyperschool.dk/landing/>
	> Cookie: JSESSIONID=65428DDBE5A866CDB12BE18493CD7F4B; ZNPCQ003-32313000=f4232b06; IPCZQX03bbac3416=01005c000a0200afbd9f4081196e6e6eb 7a632e2
	> HTTP/?.? 401 Unauthorized
	> Date: Thu, 27 Feb 2014 08:52:24 GMT
	> Server: Apache-Coyote/1.1
	> X-Powered-By: Servlet 2.5; JBoss-5.0/JBossWeb-2.1
	> X-XSS-Protection: 1; mode=block
	> X-Content-Type-Options: nosniff
	> Strict-Transport-Security: max-age=31536000; includeSubDomains
	> Cache-Control: no-cache, no-store, no-store, no-cache
	> Pragma: no-cache
	> Expires: -1
	> WWW-Authenticate: Bearer realm="netiq"
	> Content-Type: text/html;charset=utf-8
	> Set-Cookie: JSESSIONID=1B2F16A546F69398179D41461AD0A81E; Path=/IDM; Secure
	> Vary: Accept-Encoding
	> Content-Encoding: gzip
	> Via: 1.1 ua.hyperschool.dk (Access Gateway-ag-8D59C77EEBEE499D-29514)
	> Keep-Alive: timeout=300, max=98
	> Connection: Keep-Alive
	> Transfer-Encoding: chunked
	> In the AM I have configured the login protected resource to be: /landing
	> I have made a /\* protected resource as well, which has a redirect rule if the URL is exactly [https://ua.hyperschool.dk](https://ua.hyperschool.dk/)
	> This is the exact setup I had for the normal UA, of course with formfilling the IDM Home login screen instead, and using /landing instead og /IDM as the login screen.
	> So for some reason it is not allowed to visit the /IDM/rest/access/users/fullName URL - any ideas why?
	> I have a related issue with another application, where the styling of the application is not shown. All CSS and JS is not run. I have made an exception in the AM which has no authentication or authorization needed to visit /css/\* and /js/\*
	> This has worked for me before, but does not work in this instance. What am I missing?
	> Thanks in advance,
	> Jacob.
	
	 [![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/clear.gif]] Reply With Quote](https://forums.netiq.com/newreply.php?do=newreply&p=241339) **.**
	
3. 15-Mar-2014, 01:32 [#3](https://forums.netiq.com/showthread.php?50091-AM-4-0-SSO-to-IDM-Home-HTTPS&p=242135#post242135)
	
	[![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.10.jpeg]]](https://forums.netiq.com/member.php?1470-descent)
	
	[**descent**](https://forums.netiq.com/member.php?1470-descent)
	![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.7.png]] **[Knowledge Associate](http://support.novell.com/community/knowledge_partners.html)** **![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.5.png]]** ![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.4.png]] ![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.4.png]] ![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.4.png]]
	
	Join Date:
	Sep 2012
	Location:
	Houston, TX
	Posts:
	411
	
	## Re: AM 4.0 SSO to IDM Home - HTTPS
	
	> Jacob,
	> Did you get HPD working through your NAM?
	> If not what is the current state?
	> \--
	> \-----------------------------------------------------------------------
	> Will Schneider
	> Knowledge Associate [http://forums.netiq.com](http://forums.netiq.com/)
	> If you find this post helpful, please click on the star below.
	
	 [![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/clear.gif]] Reply With Quote](https://forums.netiq.com/newreply.php?do=newreply&p=242135) **.**
	
4. 02-Apr-2014, 12:52 [#4](https://forums.netiq.com/showthread.php?50091-AM-4-0-SSO-to-IDM-Home-HTTPS&p=242876#post242876)
	
	[![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.6.png]]](https://forums.netiq.com/member.php?415-jacmarpet)
	
	[**jacmarpet**](https://forums.netiq.com/member.php?415-jacmarpet)
	![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.7.png]] **Senior Member** **![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.1.png]]** ![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.4.png]]
	
	Join Date:
	Aug 2012
	Location:
	Denmark
	Posts:
	311
	
	## Re: AM 4.0 SSO to IDM Home - HTTPS
	
	> I did not. I have not had the time to take a look at it again.
	
	 [![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/clear.gif]] Reply With Quote](https://forums.netiq.com/newreply.php?do=newreply&p=242876) **.**
	
5. 17-Jun-2014, 15:35 [#5](https://forums.netiq.com/showthread.php?50091-AM-4-0-SSO-to-IDM-Home-HTTPS&p=245632#post245632)
	
	[**tezgno**](https://forums.netiq.com/member.php?4303-tezgno)
	![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.7.png]] **New or Quiet Member** **![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.8.png]]** ![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.2.png]]
	
	Join Date:
	Feb 2013
	Posts:
	3
	
	## Re: AM 4.0 SSO to IDM Home - HTTPS
	
	> I know this is a slightly older post, but I wanted to chime in because after a day of troubleshooting and tracing this exact issue, I have finally figured out how to use AM 4.0 with IDM Home. Like Jacob, my setup was the same (AM SSO via Form Fill to User Application prior to IDM Home installation). In setting up IDM Home, I ran into the same redirect\_url problem. Here is what has to be done to solve it. First, the setup:
	> NAM 4.0 HF3 (and SP1) tested
	> Published DNS for for NAM: [https://frontend.example.com:443](https://frontend.example.com/)
	> Backend URL for HPD: [https://backend.example.com:8543](https://backend.example.com:8543/)
	> What you actually have to do is configure HPD following the instructions. For the URL's in configupdate.sh, use [https://backend.example.com:8543](https://backend.example.com:8543/) like you normally would without any reverse proxy in place. Once setup, go to <https://backend.example.com:8543/landing> and make sure that it works correctly.
	> Now, within NAM, configure your reverse proxy with the published URL of [https://frontend.example.com](https://frontend.example.com/). DO NOT set the host header to "Forward Received Host Name." Rather, set it to "Web Server Host Name" and set the hostname to backend.example.com. Be sure to enter your web server IP address, use port 8543, and ensure that you have checked the SSL box for the backend.
	> Under HTML Rewriting, create a new "Word" rewrite. Check all 4 boxes. Under "Variable or Attribute Name to Search for Is", click new and type in "redirect\_uri". Under additional strings to replace, click new. For "Search for", enter "frontend.example.com". For replace with, enter "backend.example.com:8543". Click OK at the bottom. Be sure to enable your new rewriter and move it to the top (above Default).
	> Click OK all the way through and push out your changes to your gateways.
	> When you browse to <https://frontend.example.com/landing>, you should be able to login through NAM (if you have configured SSO form fill, it should form fill and work now).
	> So, having said all of this, I'm going to be filing a bug report as this is actually a bug! In configupdate, if you set the URL's to point to the frontend URLs (like one would think that you should do, which is the NAM DNS on port 443), the redirect\_uri actually ends up being frontend.example.com:8543... which is completely wrong since no where in the configuration would that URL be specified. Vice versa, if you set the URL's (using configupdate) to point to the backend urls (which would be the backend.example.com:8543), the redirect\_uri actually ends up being frontend.example.com (port 443), which is not defined anywhere either. This is what causes the error/blank page. Not sure where HPD is getting the information from, but the error only appears on HPD URLs and not on the IDMProv URL's so it's something within HPD that causes it.
	
	 [![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/clear.gif]] Reply With Quote](https://forums.netiq.com/newreply.php?do=newreply&p=245632) **.**
	

**«** [Previous Thread](https://forums.netiq.com/showthread.php?50091-AM-4-0-SSO-to-IDM-Home-HTTPS&goto=nextoldest) | [Next Thread](https://forums.netiq.com/showthread.php?50091-AM-4-0-SSO-to-IDM-Home-HTTPS&goto=nextnewest) **»**

#### Bookmarks

* [![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/bookmarksite_digg.gif]]](http://digg.com/submit?phase=2&url=https%3A%2F%2Fforums.netiq.com%2Fshowthread.php%3Ft%3D50091&title=AM+4.0+SSO+to+IDM+Home+-+HTTPS) [Digg](http://digg.com/submit?phase=2&url=https%3A%2F%2Fforums.netiq.com%2Fshowthread.php%3Ft%3D50091&title=AM+4.0+SSO+to+IDM+Home+-+HTTPS)

* [![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/bookmarksite_delicious.gif]]](http://del.icio.us/post?url=https%3A%2F%2Fforums.netiq.com%2Fshowthread.php%3Ft%3D50091&title=AM+4.0+SSO+to+IDM+Home+-+HTTPS) [del.icio.us](http://del.icio.us/post?url=https%3A%2F%2Fforums.netiq.com%2Fshowthread.php%3Ft%3D50091&title=AM+4.0+SSO+to+IDM+Home+-+HTTPS)
* [![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/bookmarksite_stumbleupon.gif]]](http://www.stumbleupon.com/submit?url=https%3A%2F%2Fforums.netiq.com%2Fshowthread.php%3Ft%3D50091&title=AM+4.0+SSO+to+IDM+Home+-+HTTPS) [StumbleUpon](http://www.stumbleupon.com/submit?url=https%3A%2F%2Fforums.netiq.com%2Fshowthread.php%3Ft%3D50091&title=AM+4.0+SSO+to+IDM+Home+-+HTTPS)
* [![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/bookmarksite_google.gif]]](http://www.google.com/bookmarks/mark?op=edit&output=popup&bkmk=https%3A%2F%2Fforums.netiq.com%2Fshowthread.php%3Ft%3D50091&title=AM+4.0+SSO+to+IDM+Home+-+HTTPS) [Google](http://www.google.com/bookmarks/mark?op=edit&output=popup&bkmk=https%3A%2F%2Fforums.netiq.com%2Fshowthread.php%3Ft%3D50091&title=AM+4.0+SSO+to+IDM+Home+-+HTTPS)
.

#### [![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.3.png]]](https://forums.netiq.com/showthread.php?50091-AM-4-0-SSO-to-IDM-Home-HTTPS#top) Posting Permissions

* You **may not** post new threads

* You **may not** post replies
* You **may not** post attachments
* You **may not** edit your posts

* [BB code](https://forums.netiq.com/misc.php?do=bbcode) is **On**

* [Smilies](https://forums.netiq.com/misc.php?do=showsmilies) are **On**
* [IMG](https://forums.netiq.com/misc.php?do=bbcode#imgcode) code is **On**
* [VIDEO](https://forums.netiq.com/misc.php?do=bbcode#videocode) code is **Off**
* HTML code is **Off**

[Forum Rules](https://forums.netiq.com/misc.php?do=showrules)

.

* [Contact Us](https://forums.netiq.com/sendmessage.php)

* [forums.netiq.com](https://forums.netiq.com/)
* [Archive](https://forums.netiq.com/archive/index.php)
* [Privacy Statement](https://www.netiq.com/company/legal/privacy/)
* [Top](https://forums.netiq.com/showthread.php?50091-AM-4-0-SSO-to-IDM-Home-HTTPS#top)
.

All times are GMT +1. The time now is 20:12.
![[./_resources/AM_4.0_SSO_to_IDM_Home_-_HTTPS_-_httpsforums.netiq.com_forums.netiq.com_-_httpsforums.netiq.com.resources/unknown_filename.png]] © 2015 Micro Focus

**Join the conversation on social media:**

* [Facebook](http://www.facebook.com/NetIQ)

* [Linked-In](http://www.linkedin.com/company/netiq)
* [Google+](https://plus.google.com/u/0/104155365122160260564)
* [Twitter](https://twitter.com/NetIQ)
* [YouTube](http://www.youtube.com/user/netiqTV)
* [SlideShare](http://www.slideshare.net/NetIQ/)

**Subscribe to our technical newsletter:**

![[]]

Let's talk.

* Sales: 1-888-323-6768

© 2016 Micro Focus [Legal](http://www.netiq.com/company/legal/) [Privacy](http://www.netiq.com/company/legal/privacy/) [Feedback](https://www.netiq.com/common/inc/feedback_overlay.html?iframe=true)

[Scroll to Top](https://forums.netiq.com/#)
