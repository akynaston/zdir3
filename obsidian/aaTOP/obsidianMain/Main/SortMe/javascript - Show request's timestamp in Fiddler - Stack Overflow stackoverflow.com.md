# javascript - Show request's timestamp in Fiddler? - Stack Overflow [stackoverflow.com]

[sign up](http://stackoverflow.com/users/login?returnurl=%2fquestions%2f3364453%2fshow-requests-timestamp-in-fiddler) | [log in](http://stackoverflow.com/users/login?returnurl=%2fquestions%2f3364453%2fshow-requests-timestamp-in-fiddler) | [careers 2.0](http://careers.stackoverflow.com/) |

[Stack Overflow](http://stackoverflow.com/)

* [Questions](http://stackoverflow.com/questions)

* [Tags](http://stackoverflow.com/tags)
* [Tour](http://stackoverflow.com/about)
* [Users](http://stackoverflow.com/users)

* [Ask Question](http://stackoverflow.com/questions/ask)

[Tell me more](http://stackoverflow.com/about) 
Stack Overflow is a question and answer site for professional and enthusiast programmers. It's 100% free, no registration required.

# [Show request's timestamp in Fiddler?](http://stackoverflow.com/questions/3364453/show-requests-timestamp-in-fiddler)

 16  [favorite](http://stackoverflow.com/questions/3364453/show-requests-timestamp-in-fiddler#)
**5**

I received a long Fiddler trace (with a complicated scenario) and need to correlate the requests with application logs.

Unfortunately, while Fiddler displays the requests chronologically, it doesn't display the timestamps of the request. To access that information (which is recorded) I have to right-click each line and look in the pop-up window with the properties. This is very time-consuming when having to comb through hundreds of lines. Looking at the raw capture data is not much better as each request has its own file and I do need the Fiddler interface.

Pedantic note: I'm aware there isn't a single timestamp to show (below are all the timestamps that are recorded). ClientConnected would be fine (or any other, as long as it's the same, that allows me to correlate the logs visually).

Thanks.

    == TIMING INFO ============ClientConnected:        10:32:57:8906ClientDoneRequest:      10:32:57:8906Gateway Determination:  0msDNS Lookup:         0msTCP/IP Connect:         0msServerGotRequest:       10:32:57:9062ServerBeginResponse:    10:32:58:2812ServerDoneResponse: 10:32:58:2884ClientBeginResponse:    10:32:58:2900ClientDoneResponse: 10:32:58:2912

[javascript](http://stackoverflow.com/questions/tagged/javascript) [fiddler](http://stackoverflow.com/questions/tagged/fiddler)

|     |     |     |
| --- | --- | --- |
| [share](http://stackoverflow.com/q/3364453)\|[improve this question](http://stackoverflow.com/posts/3364453/edit) | [edited Apr 4 '12 at 21:15](http://stackoverflow.com/posts/3364453/revisions)<br>[![[./_resources/javascript_-_Show_request's_timestamp_in_Fiddler_-_Stack_Overflow_stackoverflow.com.resources/resource.jpg]]](http://stackoverflow.com/users/67824/ohad-schneider)<br>[Ohad Schneider](http://stackoverflow.com/users/67824/ohad-schneider)<br>**8,370**23450 | asked Jul 29 '10 at 15:54<br>[![[./_resources/javascript_-_Show_request's_timestamp_in_Fiddler_-_Stack_Overflow_stackoverflow.com.resources/resource.2.png]]](http://stackoverflow.com/users/277434/wishihadabettername)<br>[wishihadabettername](http://stackoverflow.com/users/277434/wishihadabettername)<br>**1,333**51940 |

## 1 Answer

[active](http://stackoverflow.com/questions/3364453/show-requests-timestamp-in-fiddler?answertab=active#tab-top) [oldest](http://stackoverflow.com/questions/3364453/show-requests-timestamp-in-fiddler?answertab=oldest#tab-top) [votes](http://stackoverflow.com/questions/3364453/show-requests-timestamp-in-fiddler?answertab=votes#tab-top)

 27  accepted

This is very easy to do in Fiddler: click _Rules_ > _Customize Rules_.

Inside the class `Handlers`, add the following script code:

    public static BindUIColumn("BeginRequestTime", 60)function BeginRequestTime(oS: Session){    if (oS.Timers != null)    {        return oS.Timers.ClientBeginRequest.ToString();         }    return String.Empty;}

Then, simply reload your SAZ file.

|     |     |     |
| --- | --- | --- |
| [share](http://stackoverflow.com/a/3379624)\|[improve this answer](http://stackoverflow.com/posts/3379624/edit) | [edited Apr 4 '12 at 21:16](http://stackoverflow.com/posts/3379624/revisions)<br>[![[./_resources/javascript_-_Show_request's_timestamp_in_Fiddler_-_Stack_Overflow_stackoverflow.com.resources/resource.jpg]]](http://stackoverflow.com/users/67824/ohad-schneider)<br>[Ohad Schneider](http://stackoverflow.com/users/67824/ohad-schneider)<br>**8,370**23450 | answered Jul 31 '10 at 20:03<br>[![[./_resources/javascript_-_Show_request's_timestamp_in_Fiddler_-_Stack_Overflow_stackoverflow.com.resources/resource.1.png]]](http://stackoverflow.com/users/126229/ericlaw)<br>[EricLaw](http://stackoverflow.com/users/126229/ericlaw)<br>**22.8k**13971 |

|     |     |
| --- | --- |
|     |     |

Sorry for the delay, I was off. Just tried it and found that ClientBeginRequest was not available as a property for some reason (it was failing compilation) but ClientDoneRequest was and it's equally fine for my purpose so I'll mark this as the answer. Thanks!– [wishihadabettername](http://stackoverflow.com/users/277434/wishihadabettername)[Aug 3 '10 at 14:19](http://stackoverflow.com/questions/3364453/show-requests-timestamp-in-fiddler#comment3533346_3379624)

|     |     |
| --- | --- |
|     |     |

If ClientBeginRequest isn't available, you're using an outdated version. Please upgrade. :-) thanks!– [EricLaw](http://stackoverflow.com/users/126229/ericlaw)[Aug 3 '10 at 20:17](http://stackoverflow.com/questions/3364453/show-requests-timestamp-in-fiddler#comment3537222_3379624)

|     |     |
| --- | --- |
|     |     |

Thanks Eric! Very useful. Perhaps you could add this by default to future versions ?– [Ohad Schneider](http://stackoverflow.com/users/67824/ohad-schneider)[Apr 4 '12 at 21:18](http://stackoverflow.com/questions/3364453/show-requests-timestamp-in-fiddler#comment12812102_3379624)

|     |     |
| --- | --- |
|     |     |

@ohadsc I think that's a great idea. IE9 even has this in its developer tools already.– [Kalamane](http://stackoverflow.com/users/798600/kalamane)[May 3 '12 at 22:28](http://stackoverflow.com/questions/3364453/show-requests-timestamp-in-fiddler#comment13477671_3379624)

## Your Answer

### Sign up or [login](http://stackoverflow.com/users/login?returnurl=%2fquestions%2f3364453%2fshow-requests-timestamp-in-fiddler%23new-answer)

Sign up using Google

Sign up using Facebook

Sign up using Stack Exchange

### Post as a guest

**Name**
**Email**

By posting your answer, you agree to the [privacy policy](http://stackexchange.com/legal/privacy-policy) and [terms of service](http://stackexchange.com/legal/terms-of-service).

## Not the answer you're looking for?Browse other questions tagged [javascript](http://stackoverflow.com/questions/tagged/javascript) [fiddler](http://stackoverflow.com/questions/tagged/fiddler) or [ask your own question](http://stackoverflow.com/questions/ask).

tagged

[javascript](http://stackoverflow.com/questions/tagged/javascript) × 481407
[fiddler](http://stackoverflow.com/questions/tagged/fiddler) × 844

|     |     |
| --- | --- |
| asked | **3 years ago** |
| viewed | **3824 times** |
| active | **[1 year ago](http://stackoverflow.com/questions/3364453/show-requests-timestamp-in-fiddler?lastactivity)** |

#### Community Bulletin

[blog](http://blog.stackoverflow.com/?cb=1)
[Podcast #54 – The One With All The Anachronisms](http://blog.stackoverflow.com/2013/11/podcast-54-the-one-with-all-the-anachronisms/?cb=1)

<http://careers.stackoverflow.com/jobs?a=144>

* [Frontend Angular Superhero - Democratize Commerce for…
	Stitch Labs San Francisco, CA / relocation](http://careers.stackoverflow.com/jobs/36497/frontend-angular-superhero-democratize-commerce-stitch-labs?a=IvMTnpSg)

* [Senior Software Engineer
	Property Solutions International Lehi, UT / relocation](http://careers.stackoverflow.com/jobs/43118/senior-software-engineer-property-solutions?a=QAoN9qwg)
* [HTML/JavaScript Software Engineer
	Nintendo Software Technology Redmond, WA](http://careers.stackoverflow.com/jobs/41652/html-javascript-software-engineer-nintendo-software-technology?a=ONxXn9nO)

#### Related

[13](http://stackoverflow.com/q/1933934?rq=1)[injecting javascript to website using fiddler](http://stackoverflow.com/questions/1933934/injecting-javascript-to-website-using-fiddler?rq=1)
[0](http://stackoverflow.com/q/2309668?rq=1)[Fiddler web debugging: Missing time information?](http://stackoverflow.com/questions/2309668/fiddler-web-debugging-missing-time-information?rq=1)
[1](http://stackoverflow.com/q/2812713?rq=1)[Fiddler investigation of RPC (extjs client-library)](http://stackoverflow.com/questions/2812713/fiddler-investigation-of-rpc-extjs-client-library?rq=1)
[0](http://stackoverflow.com/q/3226328?rq=1)[Fiddler hides sessions - how to show?](http://stackoverflow.com/questions/3226328/fiddler-hides-sessions-how-to-show?rq=1)
[2](http://stackoverflow.com/q/3482181?rq=1)[Strange timeline on ClientConnected and ClientDoneRequest](http://stackoverflow.com/questions/3482181/strange-timeline-on-clientconnected-and-clientdonerequest?rq=1)
[0](http://stackoverflow.com/q/12320705?rq=1)[Identify a POST Request in Fiddler JavaScript](http://stackoverflow.com/questions/12320705/identify-a-post-request-in-fiddler-javascript?rq=1)
[0](http://stackoverflow.com/q/16124302?rq=1)[Fiddler unexpected request behaviour: serverGotResponse on 00:00 however client begin reponding](http://stackoverflow.com/questions/16124302/fiddler-unexpected-request-behaviour-servergotresponse-on-0000-however-client?rq=1)
[0](http://stackoverflow.com/q/16163979?rq=1)[page rendering time using fiddler](http://stackoverflow.com/questions/16163979/page-rendering-time-using-fiddler?rq=1)
[0](http://stackoverflow.com/q/17532199?rq=1)[fiddler custom rules script: oSession object is undeclared](http://stackoverflow.com/questions/17532199/fiddler-custom-rules-script-osession-object-is-undeclared?rq=1)

[question feed](http://stackoverflow.com/feeds/question/3364453)

[about](http://stackoverflow.com/about) [help](http://stackoverflow.com/help) [badges](http://stackoverflow.com/help/badges) [blog](http://blog.stackexchange.com/?blb=1) [chat](http://chat.stackoverflow.com/) [data](http://data.stackexchange.com/) [legal](http://stackexchange.com/legal) [privacy policy](http://stackexchange.com/legal/privacy-policy) [jobs](http://stackexchange.com/about/hiring) [advertising info](http://engine.adzerk.net/r?e=eyJhdiI6NDE0LCJhdCI6MjAsImNtIjo5NTQsImNoIjoxMTc4LCJjciI6Mjc3NiwiZG0iOjQsImZjIjoyODYyLCJmbCI6Mjc1MSwibnciOjIyLCJydiI6MCwicHIiOjExNSwic3QiOjAsInVyIjoiaHR0cDovL3N0YWNrb3ZlcmZsb3cuY29tL2Fib3V0L2NvbnRhY3QiLCJyZSI6MX0&s=hRods5B22XvRBwWIwtIMekcyNF8)  **[contact us](http://stackoverflow.com/contact)** **[feedback](http://meta.stackoverflow.com/)**

| Technology |     |     | Life / Arts | Culture / Recreation | Science | Other |
| --- | --- | --- | --- | --- | --- | --- |
| 1. [Stack Overflow](http://stackoverflow.com/)<br>2. [Server Fault](http://serverfault.com/)<br>3. [Super User](http://superuser.com/)<br>4. [Web Applications](http://webapps.stackexchange.com/)<br>5. [Ask Ubuntu](http://askubuntu.com/)<br>6. [Webmasters](http://webmasters.stackexchange.com/)<br>7. [Game Development](http://gamedev.stackexchange.com/)<br>8. [TeX - LaTeX](http://tex.stackexchange.com/) | 1. [Programmers](http://programmers.stackexchange.com/)<br>2. [Unix & Linux](http://unix.stackexchange.com/)<br>3. [Ask Different (Apple)](http://apple.stackexchange.com/)<br>4. [WordPress Answers](http://wordpress.stackexchange.com/)<br>5. [Geographic Information Systems](http://gis.stackexchange.com/)<br>6. [Electrical Engineering](http://electronics.stackexchange.com/)<br>7. [Android Enthusiasts](http://android.stackexchange.com/)<br>8. [Information Security](http://security.stackexchange.com/) | 1. [Database Administrators](http://dba.stackexchange.com/)<br>2. [Drupal Answers](http://drupal.stackexchange.com/)<br>3. [SharePoint](http://sharepoint.stackexchange.com/)<br>4. [User Experience](http://ux.stackexchange.com/)<br>5. [Mathematica](http://mathematica.stackexchange.com/)<br>6. [more (14)](http://stackexchange.com/sites#technology) | 1. [Photography](http://photo.stackexchange.com/)<br>2. [Science Fiction & Fantasy](http://scifi.stackexchange.com/)<br>3. [Seasoned Advice (cooking)](http://cooking.stackexchange.com/)<br>4. [Home Improvement](http://diy.stackexchange.com/)<br>5. [more (13)](http://stackexchange.com/sites#lifearts) | 1. [English Language & Usage](http://english.stackexchange.com/)<br>2. [Skeptics](http://skeptics.stackexchange.com/)<br>3. [Mi Yodeya (Judaism)](http://judaism.stackexchange.com/)<br>4. [Travel](http://travel.stackexchange.com/)<br>5. [Christianity](http://christianity.stackexchange.com/)<br>6. [Arqade (gaming)](http://gaming.stackexchange.com/)<br>7. [Bicycles](http://bicycles.stackexchange.com/)<br>8. [Role-playing Games](http://rpg.stackexchange.com/)<br>9. [more (21)](http://stackexchange.com/sites#culturerecreation) | 1. [Mathematics](http://math.stackexchange.com/)<br>2. [Cross Validated (stats)](http://stats.stackexchange.com/)<br>3. [Theoretical Computer Science](http://cstheory.stackexchange.com/)<br>4. [Physics](http://physics.stackexchange.com/)<br>5. [MathOverflow](http://mathoverflow.net/)<br>6. [more (7)](http://stackexchange.com/sites#science) | 1. [Stack Apps](http://stackapps.com/)<br>2. [Meta Stack Overflow](http://meta.stackoverflow.com/)<br>3. [Area 51](http://area51.stackexchange.com/)<br>4. [Stack Overflow Careers](http://careers.stackoverflow.com/) |

site design / logo © 2013 stack exchange inc; user contributions licensed under [cc-wiki](http://creativecommons.org/licenses/by-sa/3.0/) with [attribution required](http://blog.stackoverflow.com/2009/06/attribution-required/)
<http://creativecommons.org/licenses/by-sa/3.0/>
rev 2013.11.14.1155
