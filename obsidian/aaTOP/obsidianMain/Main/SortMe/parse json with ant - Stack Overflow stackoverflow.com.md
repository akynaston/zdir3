# parse json with ant - Stack Overflow [stackoverflow.com]

[Stack Exchange](http://stackexchange.com/)

[sign up](https://stackoverflow.com/users/signup?returnurl=http%3a%2f%2fstackoverflow.com%2fquestions%2f2527020%2fparse-json-with-ant) [log in](https://stackoverflow.com/users/login?returnurl=http%3a%2f%2fstackoverflow.com%2fquestions%2f2527020%2fparse-json-with-ant) [tour](http://stackoverflow.com/tour) [help](http://stackoverflow.com/questions/2527020/parse-json-with-ant#) [careers 2.0](http://careers.stackoverflow.com/)

[Stack Overflow](http://stackoverflow.com/)

* [Questions](http://stackoverflow.com/questions)

* [Tags](http://stackoverflow.com/tags)
* [Tour](http://stackoverflow.com/about)
* [Users](http://stackoverflow.com/users)

* [Ask Question](http://stackoverflow.com/questions/ask)

[Take the 2-minute tour](http://stackoverflow.com/about) 
Stack Overflow is a question and answer site for professional and enthusiast programmers. It's 100% free, no registration required.

# [parse json with ant](http://stackoverflow.com/questions/2527020/parse-json-with-ant)

 4  [favorite](http://stackoverflow.com/questions/2527020/parse-json-with-ant#)

I have an ant build script that needs to pull files down from a web server. I can use the "get" task to pull these files down one by one. However, I'd like to be able to get a list of these files first and then iterate over the list with "get" to download the files. The webserver will report the list of files in json format, but I'm not sure how to parse json with ant.

Are there any ant plugins that allow for json parsing?

[json](http://stackoverflow.com/questions/tagged/json) [ant](http://stackoverflow.com/questions/tagged/ant)

|     |     |
| --- | --- |
| [share](http://stackoverflow.com/q/2527020)\|[improve this question](http://stackoverflow.com/posts/2527020/edit) | asked Mar 26 '10 at 21:57<br>[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/653eae99b75e00ca20600d5b771f6588.jpg]]](http://stackoverflow.com/users/89218/paleozogt)<br>[paleozogt](http://stackoverflow.com/users/89218/paleozogt)<br>**2,528**2348 |

## 2 Answers

[active](http://stackoverflow.com/questions/2527020/parse-json-with-ant?answertab=active#tab-top) [oldest](http://stackoverflow.com/questions/2527020/parse-json-with-ant?answertab=oldest#tab-top) [votes](http://stackoverflow.com/questions/2527020/parse-json-with-ant?answertab=votes#tab-top)

 3  accepted

You can use a [<script>](http://ant.apache.org/manual/Tasks/script.html) task to [run JavaScript to decode your JSON](http://www.openjs.com/scripts/data/json_encode.php).

|     |     |     |
| --- | --- | --- |
| [share](http://stackoverflow.com/a/2535585)\|[improve this answer](http://stackoverflow.com/posts/2535585/edit) | [edited Dec 4 '10 at 0:06](http://stackoverflow.com/posts/2535585/revisions)<br>[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/7eb20c74bcd8a75f8250ac1191b675fe.png]]](http://stackoverflow.com/users/183172/martin-clayton)<br>[martin clayton](http://stackoverflow.com/users/183172/martin-clayton)<br>**39.8k**7105125 | answered Mar 29 '10 at 3:07<br>[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/df66f5ffbf986ef9ff5a990f26dbd1f1.jpg]]](http://stackoverflow.com/users/115478/dave)<br>[dave](http://stackoverflow.com/users/115478/dave)<br>**8,615**22144 |

|     |     |
| --- | --- |
|     |     |

Be careful though, as writing JSON from the rhino plugin seems to be problematic. There is no JSON.stringify, and NativeJSON.stringify() appears to be inaccessible from the plug-in. I'm thinking of switching to jython because of this. –  [Joel](http://stackoverflow.com/users/502360/joel) [Sep 4 '13 at 15:29](http://stackoverflow.com/questions/2527020/parse-json-with-ant#comment27405565_2535585)

 5 

I used Dave's suggestion above and it worked out pretty well. Here's what I came up with:

(Note, I ripped this out of my actual build file and tried to remove anything specific and just leave the example parts, so forgive me if it's missing anything or whatever, but it should give you an idea of how this works).

    <?xml version="1.0"?>
    
    <project name="jsonExample" default="all">
    <target name="all" depends="example" />
    
    <target name="example">
    
    <!-- This uses Rhino - an Open Source implementation of JavaScript written in Java -
         to parse JSON. -->
    <script language="javascript"> <![CDATA[
    
        importClass(java.io.File);
        importClass(java.io.FileReader);
        importClass(java.io.BufferedReader);
        importClass(java.io.FileWriter);
        importClass(java.io.BufferedWriter);
    
        var file = new File("/path/to/myJSON.js");
        fr = new FileReader(file);
        br = new BufferedReader(fr);
    
        // Read the file we just retrieved from the webservice that contains JSON.
        var json = br.readLine();
    
        // Evaluate the serialized JSON
        var struct = eval("(" + json + ")");
    
        // Get the data from 
        var value = struct.data.VALUE;
    
        echo = example.createTask("echo");
        echo.setMessage("Value = " + value);
        echo.perform();
    
        ]]>
    </script>
    </target>

|     |     |
| --- | --- |
| [share](http://stackoverflow.com/a/4494800)\|[improve this answer](http://stackoverflow.com/posts/4494800/edit) | answered Dec 20 '10 at 22:54<br>[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/54a1d80c27a9e5ded0512e090727cfd6.jpg]]](http://stackoverflow.com/users/433061/bdetweiler)<br>[bdetweiler](http://stackoverflow.com/users/433061/bdetweiler)<br>**171**28 |

## Your Answer

### Sign up or [log in](http://stackoverflow.com/users/login?returnurl=%2fquestions%2f2527020%2fparse-json-with-ant%23new-answer)

Sign up using Google

Sign up using Facebook

Sign up using Stack Exchange

### Post as a guest

**Name**
**Email**

By posting your answer, you agree to the [privacy policy](http://stackexchange.com/legal/privacy-policy) and [terms of service](http://stackexchange.com/legal/terms-of-service).

## Not the answer you're looking for? Browse other questions tagged [json](http://stackoverflow.com/questions/tagged/json) [ant](http://stackoverflow.com/questions/tagged/ant) or [ask your own question](http://stackoverflow.com/questions/ask).

|     |     |
| --- | --- |
| asked | **4 years ago** |
| viewed | **3289 times** |
| active | **[3 years ago](http://stackoverflow.com/questions/2527020/parse-json-with-ant?lastactivity)** |

#### [91 People Chatting](http://chat.stackoverflow.com/)

### [JavaScript](http://chat.stackoverflow.com/rooms/17)

33 mins ago - [MoshMage](http://chat.stackoverflow.com/users/587811)
[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/58dfee26d894c6c07344952da2357854.png]]](http://chat.stackoverflow.com/users/587811)[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/d4af7c516b8d8cc6fb40e65a0b6397dd.jpg]]](http://chat.stackoverflow.com/users/1435655)[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/YYo1x.jpg]]](http://chat.stackoverflow.com/users/829835)[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/ec289925069b35f18f1230b90dc654e5.jpg]]](http://chat.stackoverflow.com/users/263525)[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/Sej2t.jpg]]](http://chat.stackoverflow.com/users/1839506)[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/Dz3pC.jpg]]](http://chat.stackoverflow.com/users/3030547)[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/a1f961d1884c890688c64bb98912f1fb.jpg]]](http://chat.stackoverflow.com/users/363815)

### [PHP](http://chat.stackoverflow.com/rooms/11)

32 mins ago - [NikiC](http://chat.stackoverflow.com/users/385378)
[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/b4ec98df44deb80b1576283152670358.jpg]]](http://chat.stackoverflow.com/users/385378)[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/Jh3mC.jpg]]](http://chat.stackoverflow.com/users/1401975)[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/O3UC1.jpg]]](http://chat.stackoverflow.com/users/409279)[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/a32a990c257433d3252980e059341546.jpg]]](http://chat.stackoverflow.com/users/338665)[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/d4f3af728d5ff76fc417f47279b3bc3b.jpg]]](http://chat.stackoverflow.com/users/424004)[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/e91a4b631b4bb7f0c477626617dd3926.jpg]]](http://chat.stackoverflow.com/users/538216)[![[./_resources/parse_json_with_ant_-_Stack_Overflow_stackoverflow.com.resources/2b38d54f9b0b8fafac329bb1b35e1040.jpg]]](http://chat.stackoverflow.com/users/212940)

#### Related

[971](http://stackoverflow.com/q/206384?rq=1)[How to format a JSON date?](http://stackoverflow.com/questions/206384/how-to-format-a-json-date?rq=1)
[1275](http://stackoverflow.com/q/244777?rq=1)[Can I comment a JSON file?](http://stackoverflow.com/questions/244777/can-i-comment-a-json-file?rq=1)
[4229](http://stackoverflow.com/q/477816?rq=1)[What is the correct JSON content type?](http://stackoverflow.com/questions/477816/what-is-the-correct-json-content-type?rq=1)
[4](http://stackoverflow.com/q/2555672?rq=1)[http post with ant for file uploading](http://stackoverflow.com/questions/2555672/http-post-with-ant-for-file-uploading?rq=1)
[1282](http://stackoverflow.com/q/2669690?rq=1)[Why does Google prepend while(1); to their JSON responses?](http://stackoverflow.com/questions/2669690/why-does-google-prepend-while1-to-their-json-responses?rq=1)
[500](http://stackoverflow.com/q/4935632?rq=1)[How to parse JSON in JavaScript](http://stackoverflow.com/questions/4935632/how-to-parse-json-in-javascript?rq=1)
[3](http://stackoverflow.com/q/7245566?rq=1)[Parsing and Writing JSON using Ant](http://stackoverflow.com/questions/7245566/parsing-and-writing-json-using-ant?rq=1)
[1](http://stackoverflow.com/q/12413090?rq=1)[Spring MVC + Jackson JSON Processor works when building w/ Maven, not with Ant](http://stackoverflow.com/questions/12413090/spring-mvc-jackson-json-processor-works-when-building-w-maven-not-with-ant?rq=1)
[0](http://stackoverflow.com/q/20432627?rq=1)[Ant exec task using cURL to POST a JSON body doesn't work, identical command works manually in Windows command prompt](http://stackoverflow.com/questions/20432627/ant-exec-task-using-curl-to-post-a-json-body-doesnt-work-identical-command-wor?rq=1)
[1](http://stackoverflow.com/q/22675186?rq=1)[Set property to ant task from json file using jenkins](http://stackoverflow.com/questions/22675186/set-property-to-ant-task-from-json-file-using-jenkins?rq=1)

#### [Hot Network Questions](http://stackexchange.com/questions?tab=hot)

* [Are Mallow and Geno unique to Super Mario RPG?](http://gaming.stackexchange.com/questions/166923/are-mallow-and-geno-unique-to-super-mario-rpg)

* [Command for creating a directory and navigating into it directly?](http://unix.stackexchange.com/questions/127946/command-for-creating-a-directory-and-navigating-into-it-directly)
* [Old MacDonald function](http://codegolf.stackexchange.com/questions/26612/old-macdonald-function)
* [Can you designate your craft, perform, or profession skill even if you have no ranks in it?](http://rpg.stackexchange.com/questions/37160/can-you-designate-your-craft-perform-or-profession-skill-even-if-you-have-no-r)
* [Playing HD videos makes the system lag or freeze](http://superuser.com/questions/749935/playing-hd-videos-makes-the-system-lag-or-freeze)
* [Person who involves in sexual harassment](http://english.stackexchange.com/questions/168191/person-who-involves-in-sexual-harassment)
* [How can water catalyse a reaction between iodine and aluminium?](http://chemistry.stackexchange.com/questions/10465/how-can-water-catalyse-a-reaction-between-iodine-and-aluminium)
* [Verbatim Copying with Citation == plagiarism?](http://academia.stackexchange.com/questions/20270/verbatim-copying-with-citation-plagiarism)
* [Faster "stuttering" accumulate?](http://mathematica.stackexchange.com/questions/47296/faster-stuttering-accumulate)
* [string and const char* and .c_str()?](http://stackoverflow.com/questions/23464504/string-and-const-char-and-c-str)
* [What is the best way to connect a MacBook Pro to a Samsung TV set?](http://apple.stackexchange.com/questions/129695/what-is-the-best-way-to-connect-a-macbook-pro-to-a-samsung-tv-set)
* [Activate relays by different voltages](http://electronics.stackexchange.com/questions/109242/activate-relays-by-different-voltages)
* [How can I hide my signature in a program?](http://programmers.stackexchange.com/questions/237955/how-can-i-hide-my-signature-in-a-program)
* [How does the degrading of the food bar work?](http://gaming.stackexchange.com/questions/166864/how-does-the-degrading-of-the-food-bar-work)
[more hot questions](http://stackoverflow.com/questions/2527020/parse-json-with-ant#)

[question feed](http://stackoverflow.com/feeds/question/2527020)

[about](http://stackoverflow.com/about) [help](http://stackoverflow.com/help) [badges](http://stackoverflow.com/help/badges) [blog](http://blog.stackoverflow.com/?blb=1) [chat](http://chat.stackoverflow.com/) [data](http://data.stackexchange.com/) [legal](http://stackexchange.com/legal) [privacy policy](http://stackexchange.com/legal/privacy-policy) [jobs](http://stackexchange.com/about/hiring) [advertising info](http://engine.adzerk.net/r?e=eyJhdiI6NDE0LCJhdCI6MjAsImNtIjo5NTQsImNoIjoxMTc4LCJjciI6Mjc3NiwiZG0iOjQsImZjIjoyODYyLCJmbCI6Mjc1MSwibnciOjIyLCJydiI6MCwicHIiOjExNSwic3QiOjAsInVyIjoiaHR0cDovL3N0YWNrb3ZlcmZsb3cuY29tL2Fib3V0L2NvbnRhY3QiLCJyZSI6MX0&s=hRods5B22XvRBwWIwtIMekcyNF8)  **[contact us](http://stackoverflow.com/contact)** **[feedback](http://meta.stackoverflow.com/)**

| Technology |     |     | Life / Arts | Culture / Recreation | Science | Other |
| --- | --- | --- | --- | --- | --- | --- |
| 1. [Stack Overflow](http://stackoverflow.com/)<br>2. [Server Fault](http://serverfault.com/)<br>3. [Super User](http://superuser.com/)<br>4. [Web Applications](http://webapps.stackexchange.com/)<br>5. [Ask Ubuntu](http://askubuntu.com/)<br>6. [Webmasters](http://webmasters.stackexchange.com/)<br>7. [Game Development](http://gamedev.stackexchange.com/)<br>8. [TeX - LaTeX](http://tex.stackexchange.com/) | 1. [Programmers](http://programmers.stackexchange.com/)<br>2. [Unix & Linux](http://unix.stackexchange.com/)<br>3. [Ask Different (Apple)](http://apple.stackexchange.com/)<br>4. [WordPress Development](http://wordpress.stackexchange.com/)<br>5. [Geographic Information Systems](http://gis.stackexchange.com/)<br>6. [Electrical Engineering](http://electronics.stackexchange.com/)<br>7. [Android Enthusiasts](http://android.stackexchange.com/)<br>8. [Information Security](http://security.stackexchange.com/) | 1. [Database Administrators](http://dba.stackexchange.com/)<br>2. [Drupal Answers](http://drupal.stackexchange.com/)<br>3. [SharePoint](http://sharepoint.stackexchange.com/)<br>4. [User Experience](http://ux.stackexchange.com/)<br>5. [Mathematica](http://mathematica.stackexchange.com/)<br>6. [more (14)](http://stackexchange.com/sites#technology) | 1. [Photography](http://photo.stackexchange.com/)<br>2. [Science Fiction & Fantasy](http://scifi.stackexchange.com/)<br>3. [Graphic Design](http://graphicdesign.stackexchange.com/)<br>4. [Seasoned Advice (cooking)](http://cooking.stackexchange.com/)<br>5. [Home Improvement](http://diy.stackexchange.com/)<br>6. [Personal Finance & Money](http://money.stackexchange.com/)<br>7. [Academia](http://academia.stackexchange.com/)<br>8. [more (10)](http://stackexchange.com/sites#lifearts) | 1. [English Language & Usage](http://english.stackexchange.com/)<br>2. [Skeptics](http://skeptics.stackexchange.com/)<br>3. [Mi Yodeya (Judaism)](http://judaism.stackexchange.com/)<br>4. [Travel](http://travel.stackexchange.com/)<br>5. [Christianity](http://christianity.stackexchange.com/)<br>6. [Arqade (gaming)](http://gaming.stackexchange.com/)<br>7. [Bicycles](http://bicycles.stackexchange.com/)<br>8. [Role-playing Games](http://rpg.stackexchange.com/)<br>9. [more (21)](http://stackexchange.com/sites#culturerecreation) | 1. [Mathematics](http://math.stackexchange.com/)<br>2. [Cross Validated (stats)](http://stats.stackexchange.com/)<br>3. [Theoretical Computer Science](http://cstheory.stackexchange.com/)<br>4. [Physics](http://physics.stackexchange.com/)<br>5. [MathOverflow](http://mathoverflow.net/)<br>6. [more (7)](http://stackexchange.com/sites#science) | 1. [Stack Apps](http://stackapps.com/)<br>2. [Meta Stack Exchange](http://meta.stackexchange.com/)<br>3. [Area 51](http://area51.stackexchange.com/)<br>4. [Stack Overflow Careers](http://careers.stackoverflow.com/) |

site design / logo © 2014 stack exchange inc; user contributions licensed under [cc by-sa 3.0](http://creativecommons.org/licenses/by-sa/3.0/) with [attribution required](http://blog.stackoverflow.com/2009/06/attribution-required/)
rev 2014.4.30.1585
