# http - What is the cURL command-line syntax to do a POST request? - Super User [superuser.com]

[Stack Exchange](http://stackexchange.com/)

[sign up](http://superuser.com/users/login?returnurl=%2fquestions%2f149329%2fwhat-is-the-curl-command-line-syntax-to-do-a-post-request) [log in](http://superuser.com/users/login?returnurl=%2fquestions%2f149329%2fwhat-is-the-curl-command-line-syntax-to-do-a-post-request) [tour](http://superuser.com/tour) [help](http://superuser.com/help)

[Super User](http://superuser.com/)

* [Questions](http://superuser.com/questions)

* [Tags](http://superuser.com/tags)
* [Tour](http://superuser.com/about)
* [Users](http://superuser.com/users)

* [Ask Question](http://superuser.com/questions/ask)

[Take the 2-minute tour](http://superuser.com/about) 
Super User is a question and answer site for computer enthusiasts and power users. It's 100% free, no registration required.

# [What is the cURL command-line syntax to do a POST request?](http://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request)

 664  [favorite](http://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request#)
**222**

How do I make a [POST](http://en.wikipedia.org/wiki/POST_%28HTTP%29) request with [cURL](http://en.wikipedia.org/wiki/CURL) command-line tool?

[http](http://superuser.com/questions/tagged/http) [post](http://superuser.com/questions/tagged/post) [curl](http://superuser.com/questions/tagged/curl)

|     |     |     |
| --- | --- | --- |
| [share](http://superuser.com/q/149329)\|[improve this question](http://superuser.com/posts/149329/edit) | [edited Apr 2 '12 at 23:47](http://superuser.com/posts/149329/revisions)<br>[![[./_resources/http_-_What_is_the_cURL_command-line_syntax_to_do_a_POST_request_-_Super_User_superuser.com.resources/resource.5.png]]](http://superuser.com/users/9666/tom-wijsman)<br>[Tom Wijsman](http://superuser.com/users/9666/tom-wijsman)<br>**37k**1399179 | asked Sep 17 '08 at 15:39<br><br>Laurie Young |

## **migrated** from [stackoverflow.com](http://stackoverflow.com/posts/84619/revisions) Jun 6 '10 at 7:46

This question came from our site for professional and enthusiast programmers.

## 5 Answers

[active](http://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request?answertab=active#tab-top) [oldest](http://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request?answertab=oldest#tab-top) [votes](http://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request?answertab=votes#tab-top)

 653 
+50

    curl --data "param1=value1&param2=value2" http://example.com/resource.cgi
    

or

    curl --form "fileupload=@filename.txt" http://example.com/resource.cgi
    

For more information see [the cURL manual](http://curl.haxx.se/docs/manual.html). You might also find the [cURL tutorial on emulating a web browser](http://curl.haxx.se/docs/httpscripting.html) helpful.

With libcurl, you'd use the `curl_formadd()` function to build your form before submitting it in the usual way. See the [libcurl documentation](http://curl.haxx.se/libcurl/c/) for more information.

|     |     |     |
| --- | --- | --- |
| [share](http://superuser.com/a/149335)\|[improve this answer](http://superuser.com/posts/149335/edit) | [edited Sep 26 '12 at 11:59](http://superuser.com/posts/149335/revisions)<br>[![[./_resources/http_-_What_is_the_cURL_command-line_syntax_to_do_a_POST_request_-_Super_User_superuser.com.resources/resource.7.jpg]]](http://superuser.com/users/45737/jps)<br>[JPS](http://superuser.com/users/45737/jps)<br>**127**6 | answered Sep 17 '08 at 15:43<br><br>Stephen Deken |

|     |     |
| --- | --- |
|     |     |

@LauriRanta `--data-urlencode` (no dash), in recent versions at least –  [waitinforatrain](http://superuser.com/users/106401/waitinforatrain) [Feb 12 '13 at 12:34](http://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request#comment668170_149335)

|     |     |
| --- | --- |
| **5** |     |

`--data ''` works if there is no POST data, but the recipient requires a request to be POSTed. –  [Daniel Beck**♦**](http://superuser.com/users/22317/daniel-beck) [Apr 27 '13 at 13:15](http://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request#comment721787_149335)

 203 

For a RESTful HTTP POST containing XML:

> `curl -X POST -d @filename http://example.com/path/to/resource --header "Content-Type:text/xml"`

or for JSON, use this:

> `curl -X POST -d @filename.txt http://example.com/path/to/resource --header "Content-Type:application/json"`

This will read the contents of file named `filename.txt` and send it as the post request.

|     |     |     |
| --- | --- | --- |
| [share](http://superuser.com/a/255624)\|[improve this answer](http://superuser.com/posts/255624/edit) | [edited Jun 13 '13 at 20:36](http://superuser.com/posts/255624/revisions)<br>[![[./_resources/http_-_What_is_the_cURL_command-line_syntax_to_do_a_POST_request_-_Super_User_superuser.com.resources/resource.1.png]]](http://superuser.com/users/36744/oliver-salzburg)<br>[Oliver Salzburg](http://superuser.com/users/36744/oliver-salzburg)**♦**<br>**35.3k**16100154 | answered Mar 10 '11 at 8:29<br>[![[./_resources/http_-_What_is_the_cURL_command-line_syntax_to_do_a_POST_request_-_Super_User_superuser.com.resources/resource.3.jpg]]](http://superuser.com/users/71024/soundmonster)<br>[soundmonster](http://superuser.com/users/71024/soundmonster)<br>**2,131**143 |

|     |     |
| --- | --- |
| **18** |     |

If your endpoint is expecting `text/xml`, append `--header "Content-Type:text/xml"` to your parameters. –  [Naftuli Tzvi Kay](http://superuser.com/users/55611/naftuli-tzvi-kay) [Oct 19 '11 at 0:16](http://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request#comment382391_255624)

|     |     |
| --- | --- |
| **1** |     |

Could you provide some explanation about what your code does? –  [Tom Wijsman](http://superuser.com/users/9666/tom-wijsman) [Nov 5 '11 at 1:36](http://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request#comment390253_255624)

|     |     |
| --- | --- |
| **10** |     |

If you are sending json, you can specify the content type with: --header "Content-Type:application/json" –  [Juha Palomäki](http://superuser.com/users/82043/juha-palomaki) [Mar 20 '12 at 16:13](http://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request#comment458099_255624)

|     |     |
| --- | --- |
| **2** |     |

@tom-wijsman explanation: `curl -X POST` implies an HTTP POST request, the `-d` parameter (long version: `--data`) tells curl that what follows will be POST parameters, and `@filename` designates the contents of the file `filename` as parameter. This approach works best with RESTful HTTP APIs as found at Twitter, Facebook, various other web services including Ruby on Rails as well as HTTP APIs of databases such as CouchDB. REST stands for [Representational state transfer](http://en.wikipedia.org/wiki/REST) –  [soundmonster](http://superuser.com/users/71024/soundmonster) [Jun 27 '12 at 11:27](http://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request#comment511784_255624)

|     |     |
| --- | --- |
| **1** |     |

How is this more RESTful than other ways though? –  [Niklas Berglund](http://superuser.com/users/162881/niklas-berglund) [Oct 3 '12 at 15:59](http://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request#comment572654_255624)

 24 

    curl -d "name=Rafael%20Sagula&phone=3320780" http://www.where.com/guest.cgi 
    

is the example found in the [**Curl Example Manual**](http://www.cs.sunysb.edu/documentation/curl/index.html).

Use %26 for the ampersands though if the above doesn't work:

    curl -d "name=Rafael%20Sagula%26phone=3320780" http://www.where.com/guest.cgi 
    

|     |     |     |
| --- | --- | --- |
| [share](http://superuser.com/a/149333)\|[improve this answer](http://superuser.com/posts/149333/edit) | [edited Jun 15 '12 at 7:17](http://superuser.com/posts/149333/revisions)<br>[![[./_resources/http_-_What_is_the_cURL_command-line_syntax_to_do_a_POST_request_-_Super_User_superuser.com.resources/resource.2.png]]](http://superuser.com/users/48078/slhck)<br>[slhck](http://superuser.com/users/48078/slhck)**♦**<br>**71.3k**14139194 | answered Sep 17 '08 at 15:42<br>[![[./_resources/http_-_What_is_the_cURL_command-line_syntax_to_do_a_POST_request_-_Super_User_superuser.com.resources/resource.4.jpg]]](http://superuser.com/users/2058/daok)<br>[Daok](http://superuser.com/users/2058/daok)<br>**809**11018 |

 19 

If you want to login to a site, do the following:

    curl -d "username=admin&password=admin&submit=Login" --dump-header headers http://localhost/Login
    curl -L -b headers http://localhost/
    

The first request saves the session cookie (that is provided upon successful login) in the "headers" file. From now on you can use that cookie to authenticate you to any part of the website that you usually access after logging in with a browser.

|     |     |
| --- | --- |
| [share](http://superuser.com/a/396659)\|[improve this answer](http://superuser.com/posts/396659/edit) | answered Mar 4 '12 at 2:21<br>[![[./_resources/http_-_What_is_the_cURL_command-line_syntax_to_do_a_POST_request_-_Super_User_superuser.com.resources/resource.6.jpg]]](http://superuser.com/users/96285/martin-konecny)<br>[Martin Konecny](http://superuser.com/users/96285/martin-konecny)<br>**616**47 |

|     |     |
| --- | --- |
|     |     |

a note from curl's man page: 'The -c, --cookie-jar option is however a better way to store cookies.' –  [maxschlepzig](http://superuser.com/users/66039/maxschlepzig) [Dec 28 '13 at 15:14](http://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request#comment882658_396659)

 13 

    curl -v --data-ascii var=value http://example.com
    

and there are many more options, check `curl --help` for more information.

|     |     |     |
| --- | --- | --- |
| [share](http://superuser.com/a/149334)\|[improve this answer](http://superuser.com/posts/149334/edit) | [edited Nov 5 '11 at 1:36](http://superuser.com/posts/149334/revisions)<br>[![[./_resources/http_-_What_is_the_cURL_command-line_syntax_to_do_a_POST_request_-_Super_User_superuser.com.resources/resource.5.png]]](http://superuser.com/users/9666/tom-wijsman)<br>[Tom Wijsman](http://superuser.com/users/9666/tom-wijsman)<br>**37k**1399179 | answered Sep 17 '08 at 15:43<br>[![[./_resources/http_-_What_is_the_cURL_command-line_syntax_to_do_a_POST_request_-_Super_User_superuser.com.resources/resource.jpg]]](http://superuser.com/users/630/vinko-vrsalovic)<br>[Vinko Vrsalovic](http://superuser.com/users/630/vinko-vrsalovic)<br>**1,416**1918 |

## **protected** by [studiohack](http://superuser.com/users/6574/studiohack)**♦** May 11 '11 at 16:02

This question is protected to prevent "thanks!", "me too!", or spam answers by new users. To answer it, you must have earned at least 10 [reputation](http://superuser.com/help/whats-reputation) on this site.

tagged

[http](http://superuser.com/questions/tagged/http) × 436
[curl](http://superuser.com/questions/tagged/curl) × 194
[post](http://superuser.com/questions/tagged/post) × 140

|     |     |
| --- | --- |
| asked | **5 years ago** |
| viewed | **559578 times** |
| active | **[7 months ago](http://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request?lastactivity)** |

#### Linked

[0](http://superuser.com/q/644800?lq=1)[What is the cURL command-line syntax to POST file contents into form?](http://superuser.com/questions/644800/what-is-the-curl-command-line-syntax-to-post-file-contents-into-form?lq=1)
[6](http://superuser.com/q/426189?lq=1)[Storing a HTTP POST request in a bookmark or something similar as you would with a GET request](http://superuser.com/questions/426189/storing-a-http-post-request-in-a-bookmark-or-something-similar-as-you-would-with?lq=1)
[0](http://superuser.com/q/600478?lq=1)[A way to paste predefined list of text in bash script to browser?](http://superuser.com/questions/600478/a-way-to-paste-predefined-list-of-text-in-bash-script-to-browser?lq=1)

#### Related

[3](http://superuser.com/q/148604?rq=1)[Use cURL with multiple POSTs](http://superuser.com/questions/148604/use-curl-with-multiple-posts?rq=1)
[0](http://superuser.com/q/223711?rq=1)[curl windows command line](http://superuser.com/questions/223711/curl-windows-command-line?rq=1)
[7](http://superuser.com/q/233288?rq=1)[cURL Upload file AND send POST data](http://superuser.com/questions/233288/curl-upload-file-and-send-post-data?rq=1)
[16](http://superuser.com/q/291424?rq=1)[How do you display POST data with cURL?](http://superuser.com/questions/291424/how-do-you-display-post-data-with-curl?rq=1)
[16](http://superuser.com/q/361504?rq=1)[How to send POST with body data, headers, and HTTP params over the cURL command line?](http://superuser.com/questions/361504/how-to-send-post-with-body-data-headers-andhttp-params-over-the-curl-command?rq=1)
[3](http://superuser.com/q/373590?rq=1)[How to see HTTP request header by curl?](http://superuser.com/questions/373590/how-to-see-http-request-header-by-curl?rq=1)
[3](http://superuser.com/q/442969?rq=1)[CURL File with post parameter](http://superuser.com/questions/442969/curl-file-with-post-parameter?rq=1)
[2](http://superuser.com/q/542857?rq=1)[Use of curl command via HTTP](http://superuser.com/questions/542857/use-of-curl-command-via-http?rq=1)
[0](http://superuser.com/q/644800?rq=1)[What is the cURL command-line syntax to POST file contents into form?](http://superuser.com/questions/644800/what-is-the-curl-command-line-syntax-to-post-file-contents-into-form?rq=1)
[0](http://superuser.com/q/670321?rq=1)[cURL: multiple POST requests while reusing the TCP connection](http://superuser.com/questions/670321/curl-multiple-post-requests-while-reusing-the-tcp-connection?rq=1)

#### [Hot Network Questions](http://stackexchange.com/questions?tab=hot)

* [What is a 'friendly' way to let managers know that having good developers is a privilege?](http://workplace.stackexchange.com/questions/18119/what-is-a-friendly-way-to-let-managers-know-that-having-good-developers-is-a-p)

* [Would the One Ring even work for anyone but Sauron?](http://scifi.stackexchange.com/questions/48180/would-the-one-ring-even-work-for-anyone-but-sauron)
* [Splitting a sandwich and not feeling deceived](http://math.stackexchange.com/questions/637728/splitting-a-sandwich-and-not-feeling-deceived)
* [Why do washing machines have windows?](http://ux.stackexchange.com/questions/50259/why-do-washing-machines-have-windows)
* [If I visit a HTTPS website when using Tor, is my information getting exposed?](http://security.stackexchange.com/questions/48804/if-i-visit-a-https-website-when-using-tor-is-my-information-getting-exposed)
* [Should "Yes, delete it" be red or green?](http://ux.stackexchange.com/questions/49991/should-yes-delete-it-be-red-or-green)
* [Is good practice to use static modificator for private class methods which doesn't use non-static fields?](http://codereview.stackexchange.com/questions/39359/is-good-practice-to-use-static-modificator-for-private-class-methods-which-doesn)
* [How do I draw a little red square to label my right triangle?](http://tex.stackexchange.com/questions/154351/how-do-i-draw-a-little-red-square-to-label-my-right-triangle)
* [Moving maximum function?](http://mathematica.stackexchange.com/questions/40526/moving-maximum-function)
* [Should I challenge my professor who thinks he's always right?](http://academia.stackexchange.com/questions/15793/should-i-challenge-my-professor-who-thinks-hes-always-right)
* [Count sum of all digits](http://codegolf.stackexchange.com/questions/18556/count-sum-of-all-digits)
* [Is a master degree needed for a gis career?](http://gis.stackexchange.com/questions/83211/is-a-master-degree-needed-for-a-gis-career)
[more hot questions](http://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request#)

[question feed](http://superuser.com/feeds/question/149329)

[about](http://superuser.com/about) [help](http://superuser.com/help) [badges](http://superuser.com/help/badges) [blog](http://blog.superuser.com/?blb=1) [chat](http://chat.stackexchange.com/) [data](http://data.stackexchange.com/) [legal](http://stackexchange.com/legal) [privacy policy](http://stackexchange.com/legal/privacy-policy) [jobs](http://stackexchange.com/about/hiring) [advertising info](http://engine.adzerk.net/r?e=eyJhdiI6NDE0LCJhdCI6MjAsImNtIjo5NTQsImNoIjoxMTc4LCJjciI6Mjg0NSwiZG0iOjQsImZjIjoyODY3LCJmbCI6Mjc1MSwibnciOjIyLCJydiI6MCwicHIiOjExNSwic3QiOjAsInVyIjoiaHR0cDovL3N0YWNrb3ZlcmZsb3cuY29tL2Fib3V0L2NvbnRhY3QiLCJyZSI6MX0&s=H7rycSB8DON6ld2xOU0q8siejIQ)  **[contact us](http://superuser.com/contact)** **[feedback](http://meta.superuser.com/)**

| Technology |     |     | Life / Arts | Culture / Recreation | Science | Other |
| --- | --- | --- | --- | --- | --- | --- |
| 1. [Stack Overflow](http://stackoverflow.com/)<br>2. [Server Fault](http://serverfault.com/)<br>3. [Super User](http://superuser.com/)<br>4. [Web Applications](http://webapps.stackexchange.com/)<br>5. [Ask Ubuntu](http://askubuntu.com/)<br>6. [Webmasters](http://webmasters.stackexchange.com/)<br>7. [Game Development](http://gamedev.stackexchange.com/)<br>8. [TeX - LaTeX](http://tex.stackexchange.com/) | 1. [Programmers](http://programmers.stackexchange.com/)<br>2. [Unix & Linux](http://unix.stackexchange.com/)<br>3. [Ask Different (Apple)](http://apple.stackexchange.com/)<br>4. [WordPress Answers](http://wordpress.stackexchange.com/)<br>5. [Geographic Information Systems](http://gis.stackexchange.com/)<br>6. [Electrical Engineering](http://electronics.stackexchange.com/)<br>7. [Android Enthusiasts](http://android.stackexchange.com/)<br>8. [Information Security](http://security.stackexchange.com/) | 1. [Database Administrators](http://dba.stackexchange.com/)<br>2. [Drupal Answers](http://drupal.stackexchange.com/)<br>3. [SharePoint](http://sharepoint.stackexchange.com/)<br>4. [User Experience](http://ux.stackexchange.com/)<br>5. [Mathematica](http://mathematica.stackexchange.com/)<br>6. [more (14)](http://stackexchange.com/sites#technology) | 1. [Photography](http://photo.stackexchange.com/)<br>2. [Science Fiction & Fantasy](http://scifi.stackexchange.com/)<br>3. [Seasoned Advice (cooking)](http://cooking.stackexchange.com/)<br>4. [Home Improvement](http://diy.stackexchange.com/)<br>5. [more (13)](http://stackexchange.com/sites#lifearts) | 1. [English Language & Usage](http://english.stackexchange.com/)<br>2. [Skeptics](http://skeptics.stackexchange.com/)<br>3. [Mi Yodeya (Judaism)](http://judaism.stackexchange.com/)<br>4. [Travel](http://travel.stackexchange.com/)<br>5. [Christianity](http://christianity.stackexchange.com/)<br>6. [Arqade (gaming)](http://gaming.stackexchange.com/)<br>7. [Bicycles](http://bicycles.stackexchange.com/)<br>8. [Role-playing Games](http://rpg.stackexchange.com/)<br>9. [more (21)](http://stackexchange.com/sites#culturerecreation) | 1. [Mathematics](http://math.stackexchange.com/)<br>2. [Cross Validated (stats)](http://stats.stackexchange.com/)<br>3. [Theoretical Computer Science](http://cstheory.stackexchange.com/)<br>4. [Physics](http://physics.stackexchange.com/)<br>5. [MathOverflow](http://mathoverflow.net/)<br>6. [more (7)](http://stackexchange.com/sites#science) | 1. [Stack Apps](http://stackapps.com/)<br>2. [Meta Stack Overflow](http://meta.stackoverflow.com/)<br>3. [Area 51](http://area51.stackexchange.com/)<br>4. [Stack Overflow Careers](http://careers.stackoverflow.com/) |

site design / logo © 2014 stack exchange inc; user contributions licensed under [cc-wiki](http://creativecommons.org/licenses/by-sa/3.0/) with [attribution required](http://blog.stackoverflow.com/2009/06/attribution-required/)
<http://creativecommons.org/licenses/by-sa/3.0/>
rev 2014.1.16.1308
