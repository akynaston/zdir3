# Regular text file to XML using XSLT

[Stack Exchange](http://stackexchange.com/) [Inbox](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt#) [Reputation and Badges](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt#)

[sign up](https://stackoverflow.com/users/signup?ssrc=head&returnurl=http%3a%2f%2fstackoverflow.com%2fquestions%2f5675889%2fregular-text-file-to-xml-using-xslt) [log in](https://stackoverflow.com/users/login?ssrc=head&returnurl=http%3a%2f%2fstackoverflow.com%2fquestions%2f5675889%2fregular-text-file-to-xml-using-xslt) [tour](http://stackoverflow.com/tour) [help](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt#) [stack overflow careers](http://careers.stackoverflow.com/?utm_source=stackoverflow.com&utm_medium=site-ui&utm_campaign=anon-topbar)

[Stack Overflow](http://stackoverflow.com/)

* [Questions](http://stackoverflow.com/questions)

* [Tags](http://stackoverflow.com/tags)
* [Users](http://stackoverflow.com/users)
* [Badges](http://stackoverflow.com/help/badges)
* [Unanswered](http://stackoverflow.com/unanswered)

* [Ask Question](http://stackoverflow.com/questions/ask)

[Sign up](http://stackoverflow.com/users/signup?ssrc=hero&returnurl=http%3a%2f%2fstackoverflow.com%2fquestions%2f5675889%2fregular-text-file-to-xml-using-xslt) 
Stack Overflow is a question and answer site for professional and enthusiast programmers. It's 100% free.

# [Regular text file to XML using XSLT](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt)

[![[./_resources/Regular_text_file_to_XML_using_XSLT.resources/companypageadfallback-leaderboard-3.png]]](http://careers.stackoverflow.com/)
 7  [favorite](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt#)
**3**

I have a text file which looks like that:

    XXX^YYYY^AAAAA^XXXXXX^AAAAAA....

fields are separated using a caret(^), my presumptions are: the first field = NAME the second filed = Last name third field = Address

etc..

I would like to turn it into a valid xml using xsl (XSLT). such as:

    <name>XXX</name>
    <l_name>YYYY</l_name>

well, you get the idea.

I know It can be done easily with Perl, but I need to do it with XSLT (if its possible)

Thanks,

[xml](http://stackoverflow.com/questions/tagged/xml) [xslt](http://stackoverflow.com/questions/tagged/xslt)

|     |     |     |
| --- | --- | --- |
| [share](http://stackoverflow.com/q/5675889)\|[improve this question](http://stackoverflow.com/posts/5675889/edit) | [edited Apr 15 '11 at 11:45](http://stackoverflow.com/posts/5675889/revisions)<br>[![[./_resources/Regular_text_file_to_XML_using_XSLT.resources/b9da2ca6abf3a1e28fb470f2b3ae2c34.jpg]]](http://stackoverflow.com/users/41956/abatishchev)<br>[abatishchev](http://stackoverflow.com/users/41956/abatishchev)<br>**50.4k**50189317 | asked Apr 15 '11 at 11:18<br>[![[./_resources/Regular_text_file_to_XML_using_XSLT.resources/4053545a82f2cfd37b36fc7adf6d066d.png]]](http://stackoverflow.com/users/427306/snoofkin)<br>[snoofkin](http://stackoverflow.com/users/427306/snoofkin)<br>**4,778**53264 |

|     |     |
| --- | --- |
|     |     |

Good question, +1. See my answer for a complete XSLT 1.0 solution and for a description of the more powerful text processing capabilities of XSLT 2.0 and a pointer to a real world XSLT 2.0 text processing example. –  [Dimitre Novatchev](http://stackoverflow.com/users/36305/dimitre-novatchev) [Apr 15 '11 at 13:29](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt#comment6481360_5675889)

|     |     |
| --- | --- |
| 1   |     |

Congrats on surpassing 1000 rep. :) –  [Dimitre Novatchev](http://stackoverflow.com/users/36305/dimitre-novatchev) [Apr 15 '11 at 13:29](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt#comment6481370_5675889)

|     |     |
| --- | --- |
|     |     |

Thanks! and also for providing that perfect answer below (as usual). –  [snoofkin](http://stackoverflow.com/users/427306/snoofkin) [Apr 17 '11 at 9:07](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt#comment6502749_5675889)

## 2 Answers

[active](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt?answertab=active#tab-top) [oldest](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt?answertab=oldest#tab-top) [votes](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt?answertab=votes#tab-top)

 10  accepted

**Text (non-XML) files can be read with the standard XSLT 2.0 function [`unparsed-text()`](http://www.w3.org/TR/xslt20/#function-unparsed-text)**.

Then one can use the standard XPath 2.0 function [**`tokenize()`**](http://www.w3.org/TR/xquery-operators/#func-tokenize) and two other **[standard XPath 2.0 functions that accept regular a expression](http://www.w3.org/TR/xquery-operators/#string.match)** as one of their arguments -- [**`matches()`**](http://www.w3.org/TR/xquery-operators/#func-matches) and [**`replace()`**](http://www.w3.org/TR/xquery-operators/#func-replace).

XSLT 2.0 has its own powerful **[instructions to handle text processing using regular expressions:](http://www.w3.org/TR/xslt20/#regular-expressions)**: the [**`<xsl:analyze-string>`**](http://www.w3.org/TR/xslt20/#element-analyze-string), the **[`<xsl:matching-substring>`](http://www.w3.org/TR/xslt20/#element-matching-substring)** and the **[`<xsl:non-matching-substring>`](http://www.w3.org/TR/xslt20/#element-non-matching-substring)** instruction.

See some of the more powerful capabilities of XSLT text processing with these functions and instructions in this real-world example: an XSLT **[solution to the WideFinder problem](http://dnovatchev.wordpress.com/2007/11/09/wide-finder-in-xslt-deriving-new-requirements-for-efficiency-in-xslt-processors/)**.

**Finally, here is an XSLT 1.0 solution**:

    <xsl:stylesheet version="1.0"
     xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
     xmlns:ext="http://exslt.org/common"
     xmlns:my="my:my" exclude-result-prefixes="ext my">
     <xsl:output omit-xml-declaration="yes" indent="yes"/>
    
     <my:fieldNames>
      <name>FirstName</name>
      <name>LastName</name>
      <name>City</name>
      <name>State</name>
      <name>Zip</name>
     </my:fieldNames>
    
     <xsl:variable name="vfieldNames" select=
      "document('')/*/my:fieldNames"/>
    
     <xsl:template match="/">
      <xsl:variable name="vrtfTokens">
       <xsl:apply-templates/>
      </xsl:variable>
    
      <xsl:variable name="vTokens" select=
           "ext:node-set($vrtfTokens)"/>
    
      <results>
       <xsl:apply-templates select="$vTokens/*"/>
      </results>
     </xsl:template>
    
     <xsl:template match="text()" name="tokenize">
      <xsl:param name="pText" select="."/>
    
         <xsl:if test="string-length($pText)">
           <xsl:variable name="vWord" select=
           "substring-before(concat($pText, '^'),'^')"/>
    
           <word>
            <xsl:value-of select="$vWord"/>
           </word>
    
           <xsl:call-template name="tokenize">
            <xsl:with-param name="pText" select=
             "substring-after($pText,'^')"/>
           </xsl:call-template>
         </xsl:if>
     </xsl:template>
    
     <xsl:template match="word">
      <xsl:variable name="vPos" select="position()"/>
    
      <field>
          <xsl:element name="{$vfieldNames/*[position()=$vPos]}">
          </xsl:element>
          <value><xsl:value-of select="."/></value>
      </field>
     </xsl:template>
    </xsl:stylesheet>

**When this transformation is applied to the following XML document:**

    <t>John^Smith^Bellevue^WA^98004</t>

**the wanted, correct result is produced**:

    <results>
       <field>
          <FirstName/>
          <value>John</value>
       </field>
       <field>
          <LastName/>
          <value>Smith</value>
       </field>
       <field>
          <City/>
          <value>Bellevue</value>
       </field>
       <field>
          <State/>
          <value>WA</value>
       </field>
       <field>
          <Zip/>
          <value>98004</value>
       </field>
    </results>

|     |     |     |
| --- | --- | --- |
| [share](http://stackoverflow.com/a/5677116)\|[improve this answer](http://stackoverflow.com/posts/5677116/edit) | [edited Apr 16 '11 at 14:03](http://stackoverflow.com/posts/5677116/revisions)<br>[![[./_resources/Regular_text_file_to_XML_using_XSLT.resources/Rw8Ws.png]]](http://stackoverflow.com/users/14419/mads-hansen)<br>[Mads Hansen](http://stackoverflow.com/users/14419/mads-hansen)<br>**28.8k**76082 | answered Apr 15 '11 at 12:59<br>[![[./_resources/Regular_text_file_to_XML_using_XSLT.resources/DIwx6.jpg]]](http://stackoverflow.com/users/36305/dimitre-novatchev)<br>[Dimitre Novatchev](http://stackoverflow.com/users/36305/dimitre-novatchev)<br>**166k**8140239 |

|     |     |
| --- | --- |
|     |     |

+1 This _"I have a text file"_ require XSLT 2.0. (Unless you have a DTD's-internal-subset-aware XML parser) –  user357812 [Apr 15 '11 at 13:24](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt#comment6481266_5677116)

|     |     |
| --- | --- |
|     |     |

@Alejandro: An entity is part of the XML document -- the OP wants to be able to read any file given its URL -- probably the file URL would be passed as a parameter to the stylesheet. BTW, I appended my answer with a complete XSLT 1.0 solution :) –  [Dimitre Novatchev](http://stackoverflow.com/users/36305/dimitre-novatchev) [Apr 15 '11 at 13:31](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt#comment6481398_5677116)

|     |     |
| --- | --- |
| 1   |     |

@Dimitre: This XML wrapper `<!DOCTYPE test [<!ENTITY text SYSTEM "test.txt">]><test>&text;</test>` with `test.txt` file as `John^Smith^Bellevue^WA^98004`, result in the same output. –  user357812 [Apr 15 '11 at 14:11](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt#comment6482061_5677116)

|     |     |
| --- | --- |
|     |     |

@Alejandro: Yes. However this has nothing to do with XSLT -- only with XML. Also, let's not forget that due to security concerns many XML parsers disable entities by default. –  [Dimitre Novatchev](http://stackoverflow.com/users/36305/dimitre-novatchev) [Apr 15 '11 at 14:28](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt#comment6482323_5677116)

|     |     |
| --- | --- |
| 1   |     |

@Dimitre: Yes. And I think is a bad thing: security concerns about accessing external resource should be handle by the system. There are so many use for full DTD support... like getting the document URI with `<!ENTITY uri SYSTEM "#" NDATA uri>` and `unparsed-entity-uri('uri')` –  user357812 [Apr 15 '11 at 14:39](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt#comment6482546_5677116)

[show **6** more comments](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt#)

[![[./_resources/Regular_text_file_to_XML_using_XSLT.resources/companypageadfallback-leaderboard-2.png]]](http://careers.stackoverflow.com/)

 1 

[Tokenizing and sorting with XSLT 1.0](http://stackoverflow.com/questions/1018974/tokenizing-and-sorting-with-xslt-1-0)

If you use xslt 2.0 it's much simpler: fn:tokenize(string,pattern)

    Example: tokenize("XPath is fun", "\s+")
    Result: ("XPath", "is", "fun")

|     |     |
| --- | --- |
| [share](http://stackoverflow.com/a/5676143)\|[improve this answer](http://stackoverflow.com/posts/5676143/edit) | answered Apr 15 '11 at 11:40<br>[![[./_resources/Regular_text_file_to_XML_using_XSLT.resources/187a6cd39beeff2ff6dbebaf87ebb3a3.png]]](http://stackoverflow.com/users/696281/vikciar)<br>[VikciaR](http://stackoverflow.com/users/696281/vikciar)<br>**1,914**723 |

## Your Answer

### Sign up or [log in](http://stackoverflow.com/users/login?ssrc=question_page&returnurl=http%3a%2f%2fstackoverflow.com%2fquestions%2f5675889%2fregular-text-file-to-xml-using-xslt%23new-answer)

Sign up using Google

Sign up using Facebook

Sign up using Email and Password

### Post as a guest

**Name**
**Email**

By posting your answer, you agree to the [privacy policy](http://stackexchange.com/legal/privacy-policy) and [terms of service](http://stackexchange.com/legal/terms-of-service).

## Not the answer you're looking for? Browse other questions tagged [xml](http://stackoverflow.com/questions/tagged/xml) [xslt](http://stackoverflow.com/questions/tagged/xslt) or [ask your own question](http://stackoverflow.com/questions/ask).

|     |     |
| --- | --- |
| asked | **4 years ago** |
| viewed | **9100 times** |
| active | **[4 years ago](http://stackoverflow.com/questions/5675889/regular-text-file-to-xml-using-xslt?lastactivity)** |

[Work from anywhere](http://careers.stackoverflow.com/jobs?allowsremote=true)

* [Senior PHP Developer
	Wordfence
	WORK REMOTELY
	phpwordpress](http://careers.stackoverflow.com/jobs/97615/senior-php-developer-wordfence)

* [Amazing Node.js / JavaScript Engineer
	Clevertech
	WORK REMOTELY
	node.jsjavascript](http://careers.stackoverflow.com/jobs/96616/amazing-nodejs-javascript-engineer-clevertech)
* [Fullstack JavaScript Engineer
	Clevertech
	WORK REMOTELY
	node.jsjavascript](http://careers.stackoverflow.com/jobs/99539/fullstack-javascript-engineer-clevertech)
* [Mobile Application Developer (iOS)
	Crossway
	WORK REMOTELY
	iosobjective-c](http://careers.stackoverflow.com/jobs/98936/mobile-application-developer-ios-crossway)

Get the **weekly newsletter!**

* Top questions and answers

* Important announcements
* Unanswered questions

see an [example newsletter](http://stackexchange.com/newsletters/newsletter?site=stackoverflow.com)

#### Linked

[5](http://stackoverflow.com/q/1018974?lq=1)[Tokenizing and sorting with XSLT 1.0](http://stackoverflow.com/questions/1018974/tokenizing-and-sorting-with-xslt-1-0?lq=1)
[4](http://stackoverflow.com/q/15974377?lq=1)[Parse text file with XSLT](http://stackoverflow.com/questions/15974377/parse-text-file-with-xslt?lq=1)
[0](http://stackoverflow.com/q/21779669?lq=1)[Not able to understand some concepts during transformation](http://stackoverflow.com/questions/21779669/not-able-to-understand-some-concepts-during-transformation?lq=1)

#### Related

[47](http://stackoverflow.com/q/321860?rq=1)[How to remove elements from xml using xslt with stylesheet and xsltproc?](http://stackoverflow.com/questions/321860/how-to-remove-elements-from-xml-using-xslt-with-stylesheet-and-xsltproc?rq=1)
[-2](http://stackoverflow.com/q/1996999?rq=1)[XSLT for creating template XML](http://stackoverflow.com/questions/1996999/xslt-for-creating-template-xml?rq=1)
[3](http://stackoverflow.com/q/3056579?rq=1)[convert xml document to comma delimited (CSV) file using xslt stylesheet](http://stackoverflow.com/questions/3056579/convert-xml-document-to-comma-delimited-csv-file-using-xslt-stylesheet?rq=1)
[1](http://stackoverflow.com/q/4912900?rq=1)[Modifying a XSLT for converting XML to tab delimited text file](http://stackoverflow.com/questions/4912900/modifying-a-xslt-for-converting-xml-to-tab-delimited-text-file?rq=1)
[0](http://stackoverflow.com/q/16364771?rq=1)[Updating info in one XML file with optional info from another, using XSLT](http://stackoverflow.com/questions/16364771/updating-info-in-one-xml-file-with-optional-info-from-another-using-xslt?rq=1)
[1](http://stackoverflow.com/q/18156915?rq=1)[Perl XML to tab delimited text file with XSLT (or not)](http://stackoverflow.com/questions/18156915/perl-xml-to-tab-delimited-text-file-with-xslt-or-not?rq=1)
[-1](http://stackoverflow.com/q/21435188?rq=1)[Update to XSLT file does not appear in XML result](http://stackoverflow.com/questions/21435188/update-to-xslt-file-does-not-appear-in-xml-result?rq=1)
[0](http://stackoverflow.com/q/24044700?rq=1)[Output of XML into CSV using XSLT not styling correctly](http://stackoverflow.com/questions/24044700/output-of-xml-into-csv-using-xslt-not-styling-correctly?rq=1)
[0](http://stackoverflow.com/q/29237234?rq=1)[XML with text tags getting prematurely un-encoded when transformed in XSLT 1.0](http://stackoverflow.com/questions/29237234/xml-with-text-tags-getting-prematurely-un-encoded-when-transformed-in-xslt-1-0?rq=1)
[0](http://stackoverflow.com/q/31384281?rq=1)[Abbreviating Serial Number from XML file in XSLT](http://stackoverflow.com/questions/31384281/abbreviating-serial-number-from-xml-file-in-xslt?rq=1)

#### [Hot Network Questions](http://stackexchange.com/questions?tab=hot)

* [What were the machines really doing with humans in the Matrix?](http://movies.stackexchange.com/questions/41774/what-were-the-machines-really-doing-with-humans-in-the-matrix)

* [How do experienced cyclists know which gear they are in without an optical display?](http://bicycles.stackexchange.com/questions/34847/how-do-experienced-cyclists-know-which-gear-they-are-in-without-an-optical-displ)
* [Should I stop using the term C/C++?](http://programmers.stackexchange.com/questions/298665/should-i-stop-using-the-term-c-c)
* [When do I formally "Own" an app from App Store?](http://apple.stackexchange.com/questions/209181/when-do-i-formally-own-an-app-from-app-store)
* [Shortest infinite loop producing no output](http://codegolf.stackexchange.com/questions/59347/shortest-infinite-loop-producing-no-output)
* [Is there a short translation for ‘worth a read’ or ‘worth a listen’?](http://german.stackexchange.com/questions/25903/is-there-a-short-translation-for-worth-a-read-or-worth-a-listen)
* [“Especially because” in German](http://german.stackexchange.com/questions/25898/especially-because-in-german)
* [Should my method throw its own exception, or let .NET throw if a file doesn't exist?](http://stackoverflow.com/questions/32951247/should-my-method-throw-its-own-exception-or-let-net-throw-if-a-file-doesnt-ex)
* [Don't google "google"](http://codegolf.stackexchange.com/questions/58891/dont-google-google)
* [Why buy insurance?](http://money.stackexchange.com/questions/54561/why-buy-insurance)
* [Maximising determinant problem](http://math.stackexchange.com/questions/1465627/maximising-determinant-problem)
* [Error in PhD work near completion of paper](http://academia.stackexchange.com/questions/55479/error-in-phd-work-near-completion-of-paper)
* [Should I provide a letter of recommendation/reference to every asking student?](http://academia.stackexchange.com/questions/55517/should-i-provide-a-letter-of-recommendation-reference-to-every-asking-student)
* [Smart cards for user authentication - is configuration of PIN complexity important?](http://security.stackexchange.com/questions/101914/smart-cards-for-user-authentication-is-configuration-of-pin-complexity-importa)
* [Is there any difference between sudo password and the one I used to login?](http://askubuntu.com/questions/681730/is-there-any-difference-between-sudo-password-and-the-one-i-used-to-login)
* [2001 : A Space Odyssey - What did the black monoliths do?](http://scifi.stackexchange.com/questions/104331/2001-a-space-odyssey-what-did-the-black-monoliths-do)
* [Why b%2==1 implies that rightmost digit of b in binary form is 1](http://math.stackexchange.com/questions/1464799/why-b2-1-implies-that-rightmost-digit-of-b-in-binary-form-is-1)
* [What I thought was winning tactic, apparently was mistake](http://chess.stackexchange.com/questions/12545/what-i-thought-was-winning-tactic-apparently-was-mistake)
* [What happens to a character that drinks green dragon acid?](http://rpg.stackexchange.com/questions/69472/what-happens-to-a-character-that-drinks-green-dragon-acid)
* [How to write a character's progression](http://writers.stackexchange.com/questions/19228/how-to-write-a-characters-progression)
* [Align tikz bullet in beamer](http://tex.stackexchange.com/questions/271256/align-tikz-bullet-in-beamer)
* [Color specific sections of three concentric circles](http://tex.stackexchange.com/questions/271240/color-specific-sections-of-three-concentric-circles)
* [Create output twice the length of the code](http://codegolf.stackexchange.com/questions/59436/create-output-twice-the-length-of-the-code)
* [What is the equivalent of FORTRAN 77 COMMON BLOCK in Mathematica?](http://mathematica.stackexchange.com/questions/96223/what-is-the-equivalent-of-fortran-77-common-block-in-mathematica)

[question feed](http://stackoverflow.com/feeds/question/5675889)

[tour](http://stackoverflow.com/tour) [help](http://stackoverflow.com/help) [blog](http://blog.stackoverflow.com/?blb=1) [chat](http://chat.stackoverflow.com/) [data](http://data.stackexchange.com/) [legal](http://stackexchange.com/legal) [privacy policy](http://stackexchange.com/legal/privacy-policy) [work here](http://stackexchange.com/work-here) [advertising info](http://stackexchange.com/mediakit)  **[contact us](http://stackoverflow.com/contact)** **[feedback](http://meta.stackoverflow.com/)**

| Technology |     |     | Life / Arts | Culture / Recreation | Science | Other |
| --- | --- | --- | --- | --- | --- | --- |
| 1. [Stack Overflow](http://stackoverflow.com/)<br>2. [Server Fault](http://serverfault.com/)<br>3. [Super User](http://superuser.com/)<br>4. [Web Applications](http://webapps.stackexchange.com/)<br>5. [Ask Ubuntu](http://askubuntu.com/)<br>6. [Webmasters](http://webmasters.stackexchange.com/)<br>7. [Game Development](http://gamedev.stackexchange.com/)<br>8. [TeX - LaTeX](http://tex.stackexchange.com/) | 1. [Programmers](http://programmers.stackexchange.com/)<br>2. [Unix & Linux](http://unix.stackexchange.com/)<br>3. [Ask Different (Apple)](http://apple.stackexchange.com/)<br>4. [WordPress Development](http://wordpress.stackexchange.com/)<br>5. [Geographic Information Systems](http://gis.stackexchange.com/)<br>6. [Electrical Engineering](http://electronics.stackexchange.com/)<br>7. [Android Enthusiasts](http://android.stackexchange.com/)<br>8. [Information Security](http://security.stackexchange.com/) | 1. [Database Administrators](http://dba.stackexchange.com/)<br>2. [Drupal Answers](http://drupal.stackexchange.com/)<br>3. [SharePoint](http://sharepoint.stackexchange.com/)<br>4. [User Experience](http://ux.stackexchange.com/)<br>5. [Mathematica](http://mathematica.stackexchange.com/)<br>6. [Salesforce](http://salesforce.stackexchange.com/)<br>7. [ExpressionEngine® Answers](http://expressionengine.stackexchange.com/)<br>8. [more (13)](http://stackexchange.com/sites#technology) | 1. [Photography](http://photo.stackexchange.com/)<br>2. [Science Fiction & Fantasy](http://scifi.stackexchange.com/)<br>3. [Graphic Design](http://graphicdesign.stackexchange.com/)<br>4. [Movies & TV](http://movies.stackexchange.com/)<br>5. [Seasoned Advice (cooking)](http://cooking.stackexchange.com/)<br>6. [Home Improvement](http://diy.stackexchange.com/)<br>7. [Personal Finance & Money](http://money.stackexchange.com/)<br>8. [Academia](http://academia.stackexchange.com/)<br>9. [more (9)](http://stackexchange.com/sites#lifearts) | 1. [English Language & Usage](http://english.stackexchange.com/)<br>2. [Skeptics](http://skeptics.stackexchange.com/)<br>3. [Mi Yodeya (Judaism)](http://judaism.stackexchange.com/)<br>4. [Travel](http://travel.stackexchange.com/)<br>5. [Christianity](http://christianity.stackexchange.com/)<br>6. [Arqade (gaming)](http://gaming.stackexchange.com/)<br>7. [Bicycles](http://bicycles.stackexchange.com/)<br>8. [Role-playing Games](http://rpg.stackexchange.com/)<br>9. [more (21)](http://stackexchange.com/sites#culturerecreation) | 1. [Mathematics](http://math.stackexchange.com/)<br>2. [Cross Validated (stats)](http://stats.stackexchange.com/)<br>3. [Theoretical Computer Science](http://cstheory.stackexchange.com/)<br>4. [Physics](http://physics.stackexchange.com/)<br>5. [MathOverflow](http://mathoverflow.net/)<br>6. [Chemistry](http://chemistry.stackexchange.com/)<br>7. [Biology](http://biology.stackexchange.com/)<br>8. [more (5)](http://stackexchange.com/sites#science) | 1. [Stack Apps](http://stackapps.com/)<br>2. [Meta Stack Exchange](http://meta.stackexchange.com/)<br>3. [Area 51](http://area51.stackexchange.com/)<br>4. [Stack Overflow Careers](http://careers.stackoverflow.com/) |

site design / logo © 2015 Stack Exchange Inc; user contributions licensed under [cc by-sa 3.0](http://creativecommons.org/licenses/by-sa/3.0/) with [attribution required](http://blog.stackoverflow.com/2009/06/attribution-required/)
rev 2015.10.5.2864
