# Cool Solutions: Reporting on eDirectory Objects with XSLT

**Reporting on eDirectory Objects with XSLT**

## Novell Cool Solutions: Feature
By [Michel Bluteau](http://www.novell.com/coolsolutions/author/783.html)

[Rate This Page](http://www.novell.com/inc/rater.jsp?url=http://www.novell.com/coolsolutions/feature/16007.html)

Reader Rating  ![[./_resources/Cool_Solutions_Reporting_on_eDirectory_Objects_with_XSLT.resources/stars_0_0.gif]]

* [Printer Friendly](http://www.novell.com/inc/pf/pf.jsp)
* [tell a friend](http://www.novell.com/info/sendemail.jsp?url=http://www.novell.com/coolsolutions/feature/16007.html)

|     |     |
| --- | --- |
| - [Slashdot This](http://slashdot.org/submit.pl)<br>_Posted: 21 Oct 2005_ |     |

I have been exploring over the years several ways of generating reports on eDirectory objects, mainly users and groups. This article describes one way of generating a simple reports on user objects. It also shows how to send the report by e-mail as an attachment to the admin, as well as providing a URL for accessing the report from a web server.

This approach should be considered as an example only, and more customization would be expected to meet your specific needs.

I decided to leverage XSLT instead of Policy Builder, because it allows for queries against eDirectory to be more flexible.

The solution includes one stylesheet that can be added to an existing driver, or a loopback driver. Actions that trigger the creation of a report could range from a specific event (an attribute is modified for a given object) to a change of date (daily report). For daily reports, you can read my article on time- triggered events:

<http://www.novell.com/coolsolutions/tip/8619.html>

Before you begin, be sure to copy [DirXMLSmallUtils.jar](http://www.novell.com/coolsolutions/assets/DirXMLSmallUtils.jar) to your /lib directory for eDirectory. This .jar file has been included with other articles from CoolSolutions, and its classes are used by the XSLT. Then restart eDirectory.

### XSLT Stylesheet

The following is the entire stylesheet:

<?xml version="1.0" encoding="UTF-8"?><xsl:stylesheet version="1.0" xmlns:ncs="http://www.novell.com/nxsl/java/com.novell.ncs.dirxml.utilities.Utils" xmlns:query="http://www.novell.com/nxsl/java/com.novell.nds.dirxml.driver.XdsQueryProcessor" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
        <!--    \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_       Report User objects under qc/ca/mrq/identite \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ -->
        <!--    \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_       Created by Michel Bluteau mbluteau@novell.com  \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ -->
        <xsl:param name="srcQueryProcessor"/>
        <xsl:template match="node()|@\*">
                <xsl:copy>
                        <xsl:apply-templates select="node()|@\*"/>
                </xsl:copy>
        </xsl:template>
        <!--    \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_       Catch modify on User class \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ -->
        <xsl:template match="modify-attr\[@attr-name='Title'\]">
                <!--    \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_       Copy attributes we don't want to mess with \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ -->
                <xsl:variable name="report" select="add-value/value"/>
                <xsl:message>We are in XSLT Reports-Users, report = <xsl:value-of select="$report"/>
                </xsl:message>
                <xsl:if test="$report='Report-Users'">
                        <xsl:variable name="filename" select="concat(ncs:getTimeString(),'.htm')"/>
                        <xsl:variable name="file" select="concat('/var/opt/novell/tomcat4/webapps/nps/reports/',$filename)"/>
                        <xsl:variable name="fileurl" select="concat('http://192.168.1.19/nps/reports/',$filename)"/>
                        <xsl:copy>
                                <xsl:apply-templates select="node()|@\*"/>
                        </xsl:copy>
                        <!--    \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_       Query eDirectory for existing attributes \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ -->
                        <xsl:variable name="src-query">
                                <query dest-dn="tree\\org\\identity" scope="subtree">
                                        <read-attr attr-name="CN"/>
                                </query>
                        </xsl:variable>
                        <!--    \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_       Paste exiting attributes into variables \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ -->
                        <xsl:variable name="result" select="query:query($srcQueryProcessor, $src-query)"/>
                        <xsl:variable name="cn" select="$result//value"/>
                        <!--    \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_       Create the Report file \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ -->
                        <xsl:message>Report:<xsl:value-of select="ncs:writeLog($file,'<HTML>')"/>
                        </xsl:message>
                        <xsl:message>Report:<xsl:value-of select="ncs:writeLog($file,'<HEAD>')"/>
                        </xsl:message>
                        <xsl:message>Report:<xsl:value-of select="ncs:writeLog($file,'<TITLE>')"/>
                        </xsl:message>
                        <xsl:message>Report:<xsl:value-of select="ncs:writeLog($file,'Report on Users')"/>
                        </xsl:message>
                        <xsl:message>Report:<xsl:value-of select="ncs:writeLog($file,'</TITLE>')"/>
                        </xsl:message>
                        <xsl:message>Report:<xsl:value-of select="ncs:writeLog($file,'</HEAD>')"/>
                        </xsl:message>
                        <xsl:message>CR:<xsl:value-of select="ncs:writeLog($file,' ')"/>
                        </xsl:message>
                        <xsl:for-each select="$cn">
                                <xsl:variable name="DN" select="concat('tree\\org\\identity\\',.)"/>
                                <!--    \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_       Query eDirectory for existing attributes \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ -->
                                <xsl:variable name="src-query2">
                                        <query class-name="User" dest-dn="{$DN}" scope="entry">
                                                <read-attr attr-name="Surname"/>
                                                <read-attr attr-name="Given Name"/>
                                        </query>
                                </xsl:variable>
                                <!--    \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_       Paste exiting attributes into variables \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ -->
                                <xsl:variable name="result2" select="query:query($srcQueryProcessor, $src-query2)"/>
                                <xsl:variable name="surname" select="concat('Surname = ',$result2/nds/output/instance\[1\]/attr\[@attr-name='Surname'\]/value\[1\])"/>
                                <xsl:variable name="givenname" select="concat('Given Name = ',$result2/nds/output/instance\[1\]/attr\[@attr-name='Given Name'\]/value\[1\])"/>
                                <xsl:message>Report:<xsl:value-of select="ncs:writeLog($file,'<P>')"/>
                                </xsl:message>
                                <xsl:message>DN:<xsl:value-of select="ncs:writeLog($file,$DN)"/>
                                </xsl:message>
                                <xsl:message>Surname:<xsl:value-of select="ncs:writeLog($file,$surname)"/>
                                </xsl:message>
                                <xsl:message>Given Name:<xsl:value-of select="ncs:writeLog($file,$givenname)"/>
                                </xsl:message>
                                <xsl:message>CR:<xsl:value-of select="ncs:writeLog($file,' ')"/>
                                </xsl:message>
                        </xsl:for-each>
                        <xsl:message>Report:<xsl:value-of select="ncs:writeLog($file,'</HTML>')"/>
                        </xsl:message>
                        <!--    \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_       End of create Report file \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ -->
                        <!-- public static boolean sendMail(java.lang.String from,
                                                            java.lang.String to,
                                                            java.lang.String subj,
                                                            java.lang.String msgText,
                                                            java.lang.String file,
                                                            java.lang.String host,
                                                            java.lang.String debugging)
                        -->
                        <xsl:message>Sending eMail:<xsl:value-of select="ncs:sendMail('meta@novl.ca','mbluteau@novell.com','Report on Users',$fileurl,$file,'24.201.245.36','true')"/>
                        </xsl:message>
                </xsl:if>
        </xsl:template>
</xsl:stylesheet>

### Notes on the Example

Below are some explanations of how the example works. I decided to use the Title attribute for triggering my report:

<xsl:template match="modify-attr\[@attr-name='Title'\]">

Then I created a few variables for the name of a file to be posted on my web server, and also for its URL. I used my Tomcat installation for iManager 2.5 as my web server:

                        <xsl:variable name="filename" select="concat(ncs:getTimeString(),'.htm')"/>
                        <xsl:variable name="file" select="concat('/var/opt/novell/tomcat4/webapps/nps/reports/',$filename)"/>
                        <xsl:variable name="fileurl" select="concat('http://192.168.1.19/nps/reports/',$filename)"/>

Then I queried eDirectory under a OU in order to get a list of users(CN):

<!--    \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_       Query eDirectory for existing attributes \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ -->
                        <xsl:variable name="src-query">
                                <query dest-dn="tree\\org\\identity" scope="subtree">
                                        <read-attr attr-name="CN"/>
                                </query>
                        </xsl:variable>
                        <!--    \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_       Paste exiting attributes into variables \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ -->
                        <xsl:variable name="result" select="query:query($srcQueryProcessor, $src-query)"/>
                        <xsl:variable name="cn" select="$result//value"/>
 Then I start creating the report in HTML format using the writeLog class:

                        <!--    \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_       Create the Report file \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ -->
                        <xsl:message>Report:<xsl:value-of select="ncs:writeLog($file,'<HTML>')"/>
                        </xsl:message>
                        <xsl:message>Report:<xsl:value-of select="ncs:writeLog($file,'<HEAD>')"/>
                        </xsl:message>
                        <xsl:message>Report:<xsl:value-of select="ncs:writeLog($file,'<TITLE>')"/>
                        </xsl:message>
                        <xsl:message>Report:<xsl:value-of select="ncs:writeLog($file,'Report on Users')"/>
                        </xsl:message>
                        <xsl:message>Report:<xsl:value-of select="ncs:writeLog($file,'</TITLE>')"/>
                        </xsl:message>
                        <xsl:message>Report:<xsl:value-of select="ncs:writeLog($file,'</HEAD>')"/>
                        </xsl:message>
                        <xsl:message>CR:<xsl:value-of select="ncs:writeLog($file,' ')"/>
                        </xsl:message>

Note the use of escape characters such as "<". In XML, those characters have special meaning, so they must be substituted with corresponding escape characters.

Then I used a for-each block to process each and every user object, and added a line to the report:

<xsl:for-each select="$cn">
                                <xsl:variable name="DN" select="concat('tree\\org\\identity\\',.)"/>
                                <!--    \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_       Query eDirectory for existing attributes \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ -->
                                <xsl:variable name="src-query2">
                                        <query class-name="User" dest-dn="{$DN}" scope="entry">
                                                <read-attr attr-name="Surname"/>
                                                <read-attr attr-name="Given Name"/>
                                        </query>
                                </xsl:variable>
                                <!--    \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_       Paste exiting attributes into variables \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ -->
                                <xsl:variable name="result2" select="query:query($srcQueryProcessor, $src-query2)"/>
                                <xsl:variable name="surname" select="concat('Surname = ',$result2/nds/output/instance\[1\]/attr\[@attr-name='Surname'\]/value\[1\])"/>
                                <xsl:variable name="givenname" select="concat('Given Name = ',$result2/nds/output/instance\[1\]/attr\[@attr-name='Given Name'\]/value\[1\])"/>
                                <xsl:message>Report:<xsl:value-of select="ncs:writeLog($file,'<P>')"/>
                                </xsl:message>
                                <xsl:message>DN:<xsl:value-of select="ncs:writeLog($file,$DN)"/>
                                </xsl:message>
                                <xsl:message>Surname:<xsl:value-of select="ncs:writeLog($file,$surname)"/>
                                </xsl:message>
                                <xsl:message>Given Name:<xsl:value-of select="ncs:writeLog($file,$givenname)"/>
                                </xsl:message>
                                <xsl:message>CR:<xsl:value-of select="ncs:writeLog($file,' ')"/>
                                </xsl:message>
                        </xsl:for-each>

Then I closed the report file:

<xsl:message>Report:<xsl:value-of select="ncs:writeLog($file,'</HTML>')"/>
                        </xsl:message>

The last step is to send the e-mail using the sendMail class. A SMTP relay host is required at this point. I used the one from my ISP, but in real life a more secure host is preferred:

<!-- public static boolean sendMail(java.lang.String from,
                                                            java.lang.String to,
                                                            java.lang.String subj,
                                                            java.lang.String msgText,
                                                            java.lang.String file,
                                                            java.lang.String host,
                                                            java.lang.String debugging)
                        -->
                        <xsl:message>Sending eMail:<xsl:value-of select="ncs:sendMail('meta@novl.ca','mbluteau@novell.com','Report on Users',$fileurl,$file,'24.201.245.36','true')"/>
                        </xsl:message>

### Customizations

Of course, the above example is a very generic one, but the key ideas are there. For example, you could create one XSLT for each type of report (on users, on groups, etc.) and allow admins to request reports through iManager using a form created with Plug-in Studio, etc.

The source for such a report would look like this:

<HTML>
<HEAD>
<TITLE>
Report on Users
</TITLE>
</HEAD>
 
<P>
tree\\org\\identity\\user601
Surname = 601
Given Name = user
 
<P>
tree\\org\\identity\\user602
Surname = 602
Given Name = user
 
</HTML>

I hope this example proves useful to you. I welcome any feedback, suggestions or questions.
