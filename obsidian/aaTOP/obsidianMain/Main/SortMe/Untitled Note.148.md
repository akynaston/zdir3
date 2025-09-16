# Untitled Note

#FCPS - UserApp security updates done on 4/14/2015 2:36:13 PM

OVERALL NOTES:

**JBoss JMX management console** – Can be removed
**JBoss Server MBean** – Can be removed
**JBoss ServerInfo MBean** – Can be removed
**JBoss Web Console JMX Invoker** – Can be removed
**SSL certificate public key less than 2048 bit** – This was a dummy cert generated for the TEST system. It can be replaced with a better certificate if needed. This is referring to the HTTPS certificate. Note: http to https redirection should be forced.
**SSL weak ciphers** – http://www.techstacks.com/howto/secure-ssl-in-tomcat.html
**Clickjacking: X-Frame-Options header missing** – Edit web.xml in jboss-web.deployer. https://www.owasp.org/index.php/Clickjacking\_Protection\_for\_Java\_EE
**OPTIONS method is enabled** – This might not be possible to disable for the User Application within supported functionality. A load balancer or maybe Access Manager might be able to do this. <file:///%E6%A0%A2%E7%91%B4%E3%A9%B0%E2%BC%AF%E7%9D%B7%E2%B9%B7%E6%BD%A3%E6%95%A4%E6%85%B2%E6%8D%AE%E2%B9%A8%E6%BD%A3%E2%BD%AD%E2%BD%B4%E3%80%B5%E3%88%B9%E3%8C%B9%E4%A8%AF%E6%BD%82%E7%8D%B3%E6%90%AF%E7%8D%A9%E6%89%A1%E6%95%AC%E6%84%AD%E6%8D%A3%E7%8D%A5%E2%B5%B3%E7%81%A1%E6%B1%B0%E6%8D%A9%E7%91%A1%E6%BD%A9%E2%B5%AE%E5%91%88%E5%81%94%E6%B4%AD%E7%91%A5%E6%BD%A8%E7%8D%A4%22%02%02%02%EA%BF%AE%E3%AA%BE%EB%B8%B8%E0%BC%8B%E7%91%A8%E7%81%B4%E2%BC%BA%E7%9C%AF%E7%9D%B7%E6%8C%AE%E6%91%AF%E7%89%A5%E6%B9%A1%E6%A1%A3%E6%8C%AE%E6%B5%AF%E7%90%AF%E3%94%AF%E3%A4%B0%E3%A4%B2%E2%BC%B3%E4%89%8A%E7%8D%AF%E2%BD%B3%E6%A5%A4%E6%85%B3%E6%B1%A2%E2%B5%A5%E6%8D%A1%E6%95%A3%E7%8D%B3%E6%84%AD%E7%81%B0%E6%A5%AC%E6%85%A3%E6%A5%B4%E6%B9%AF%E4%A0%AD%E5%91%94%E2%B5%90%E6%95%AD%E6%A1%B4%E6%91%AFs>[http://www.coderanch.com/t/509293/JBoss/disable-access-application-HTTP-methods](file:///%E6%A0%A2%E7%91%B4%E3%A9%B0%E2%BC%AF%E7%9D%B7%E2%B9%B7%E6%BD%A3%E6%95%A4%E6%85%B2%E6%8D%AE%E2%B9%A8%E6%BD%A3%E2%BD%AD%E2%BD%B4%E3%80%B5%E3%88%B9%E3%8C%B9%E4%A8%AF%E6%BD%82%E7%8D%B3%E6%90%AF%E7%8D%A9%E6%89%A1%E6%95%AC%E6%84%AD%E6%8D%A3%E7%8D%A5%E2%B5%B3%E7%81%A1%E6%B1%B0%E6%8D%A9%E7%91%A1%E6%BD%A9%E2%B5%AE%E5%91%88%E5%81%94%E6%B4%AD%E7%91%A5%E6%BD%A8%E7%8D%A4%22%02%02%02%EA%BF%AE%E3%AA%BE%EB%B8%B8%E0%BC%8B%E7%91%A8%E7%81%B4%E2%BC%BA%E7%9C%AF%E7%9D%B7%E6%8C%AE%E6%91%AF%E7%89%A5%E6%B9%A1%E6%A1%A3%E6%8C%AE%E6%B5%AF%E7%90%AF%E3%94%AF%E3%A4%B0%E3%A4%B2%E2%BC%B3%E4%89%8A%E7%8D%AF%E2%BD%B3%E6%A5%A4%E6%85%B3%E6%B1%A2%E2%B5%A5%E6%8D%A1%E6%95%A3%E7%8D%B3%E6%84%AD%E7%81%B0%E6%A5%AC%E6%85%A3%E6%A5%B4%E6%B9%AF%E4%A0%AD%E5%91%94%E2%B5%90%E6%95%AD%E6%A1%B4%E6%91%AFs)
                Make the change here: web.xml in jboss-web.deployer.
May not be fixable with out a revse proxy or something . . .

**Session Cookie without HttpOnly flag set** - http://syams18.blogspot.com/2012/01/setting-httponly-in-jboss-httponly-is.html

**Tomcat status page**\- We should be able to do something about this.

* * *

WORK DONE ON VM:
 - HTTPS cert is issued to "Joe TriVir" and is only 1024K bytes.
 - found / to /IDM redirection is not hapening.
 - found http to https IS happening!
 - Actions:
**JBoss JMX management console** – Can be removed
      Deleted:
[C:NovellidmjbossserverIDMconfpropsjmx-console-roles.properties](file:///C:/Novell/idm/jboss/server/IDM/conf/props/jmx-console-roles.properties) 
[C:NovellidmjbossserverIDMconfprops](file:///C:/Novell/idm/jboss/server/IDM/conf/props/jmx-console-roles.properties)jmx-console-users.properties
[C:NovellidmjbossserverIDMdeployjmx-console.war](file:///C:/Novell/idm/jboss/server/IDM/deploy/jmx-console.war) (folder).

**JBoss Server MBean** – Can be removed

**JBoss ServerInfo MBean** – Can be removed
**JBoss Web Console JMX Invoker** – Can be removed
**SSL certificate public key less than 2048 bit** – This was a dummy cert generated for the TEST system. It can be replaced with a better certificate if needed. This is referring to the HTTPS certificate. Note: http to https redirection should be forced.
**SSL weak ciphers** – http://www.techstacks.com/howto/secure-ssl-in-tomcat.html
**Clickjacking: X-Frame-Options header missing** – Edit web.xml in jboss-web.deployer. https://www.owasp.org/index.php/Clickjacking\_Protection\_for\_Java\_EE
**OPTIONS method is enabled** – This might not be possible to disable for the User Application within supported functionality. A load balancer or maybe Access Manager might be able to do this. <file:///%E6%A0%A2%E7%91%B4%E3%A9%B0%E2%BC%AF%E7%9D%B7%E2%B9%B7%E6%BD%A3%E6%95%A4%E6%85%B2%E6%8D%AE%E2%B9%A8%E6%BD%A3%E2%BD%AD%E2%BD%B4%E3%80%B5%E3%88%B9%E3%8C%B9%E4%A8%AF%E6%BD%82%E7%8D%B3%E6%90%AF%E7%8D%A9%E6%89%A1%E6%95%AC%E6%84%AD%E6%8D%A3%E7%8D%A5%E2%B5%B3%E7%81%A1%E6%B1%B0%E6%8D%A9%E7%91%A1%E6%BD%A9%E2%B5%AE%E5%91%88%E5%81%94%E6%B4%AD%E7%91%A5%E6%BD%A8%E7%8D%A4%22>[http://www.coderanch.com/t/509293/JBoss/disable-access-application-HTTP-methods](file:///%E6%A0%A2%E7%91%B4%E3%A9%B0%E2%BC%AF%E7%9D%B7%E2%B9%B7%E6%BD%A3%E6%95%A4%E6%85%B2%E6%8D%AE%E2%B9%A8%E6%BD%A3%E2%BD%AD%E2%BD%B4%E3%80%B5%E3%88%B9%E3%8C%B9%E4%A8%AF%E6%BD%82%E7%8D%B3%E6%90%AF%E7%8D%A9%E6%89%A1%E6%95%AC%E6%84%AD%E6%8D%A3%E7%8D%A5%E2%B5%B3%E7%81%A1%E6%B1%B0%E6%8D%A9%E7%91%A1%E6%BD%A9%E2%B5%AE%E5%91%88%E5%81%94%E6%B4%AD%E7%91%A5%E6%BD%A8%E7%8D%A4%22)
                Make the change here: web.xml in jboss-web.deployer.
May not be fixable with out a revse proxy or something . . .

**Session Cookie without HttpOnly flag set** - http://syams18.blogspot.com/2012/01/setting-httponly-in-jboss-httponly-is.html
**Tomcat status page**\- We should be able to do something about this.

WORK DONE IN PRODUCTION:
 - Found force to https isn't happening: an entire session on http (port 80) is allowed!  should be forced to https right?
