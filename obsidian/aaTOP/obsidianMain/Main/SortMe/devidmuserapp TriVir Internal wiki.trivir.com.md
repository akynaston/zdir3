# dev:idm:userapp [TriVir Internal] [wiki.trivir.com]

\[\[[dev:idm:userapp](https://wiki.trivir.com/dev/idm/userapp?do=backlink)\]\]
[TriVir Internal](https://wiki.trivir.com/)

Trace: » [qanda](https://wiki.trivir.com/dev/qanda) » [userapp401](https://wiki.trivir.com/dev/qanda/userapp401) » [wrappers](https://wiki.trivir.com/dev/wrappers/start) » [general](https://wiki.trivir.com/general/start) » [start](https://wiki.trivir.com/start) » [userapp](https://wiki.trivir.com/dev/idm/userapp)
You are here: [start](https://wiki.trivir.com/start) » [dev](https://wiki.trivir.com/dev/start) » [idm](https://wiki.trivir.com/dev/idm/start) » [userapp](https://wiki.trivir.com/dev/idm/userapp)

Table of Contents

* [Preparation](https://wiki.trivir.com/dev/idm/#preparation)
* [Install UserApp/JBoss/MySQL](https://wiki.trivir.com/dev/idm/#install_userappjbossmysql)
* [Enable SSL On JBoss (Optional)](https://wiki.trivir.com/dev/idm/#enable_ssl_on_jboss_optional)
* [Enable HTTP to HTTPS redirection On JBoss (Optional)](https://wiki.trivir.com/dev/idm/#enable_http_to_https_redirection_on_jboss_optional)
* [Enable /IDM/ to Login.jsf redirection (Optional)](https://wiki.trivir.com/dev/idm/#enable_idmto_login.jsf_redirection_optional)
* [Set up MySQL as a service](https://wiki.trivir.com/dev/idm/#set_up_mysql_as_a_service)
* [Set up JBoss as a service](https://wiki.trivir.com/dev/idm/#set_up_jboss_as_a_service)
* [Import the User App driver](https://wiki.trivir.com/dev/idm/#import_the_user_app_driver)
* [Start it all up](https://wiki.trivir.com/dev/idm/#start_it_all_up)
* [Change the Default Landing Page](https://wiki.trivir.com/dev/idm/#change_the_default_landing_page)

* [Preparation](https://wiki.trivir.com/dev/idm/#preparation1)
* [MySQL](https://wiki.trivir.com/dev/idm/#mysql)

* [Updating User App database configuration](https://wiki.trivir.com/dev/idm/#updating_user_app_database_configuration)
* [UserApp customizations](https://wiki.trivir.com/dev/idm/#userapp_customizations)
* [Proper Modification of IDM.war](https://wiki.trivir.com/dev/idm/#proper_modification_of_idm.war)

# 

* [Items to consider when installing UserApp 3.6.1 in a 64 bit environment](https://wiki.trivir.com/dev/idm/start/userapp64bit)
* [Localizing the User Application](https://wiki.trivir.com/dev/idm/start/userapplocalization)
* [Hints using UserApp](https://wiki.trivir.com/dev/idm/start/userapphints)

## 

Not every step is documented. Feel free to add to the information below if there's something missing or something about the process that needs clarification. Note: If it is necessary to directly modify the IDM.war file, please do so using the instructions below on how this is done in the 'Proper Modification of IDM.war' section.

### 

Make sure any previous installation is cleaned up by:

1. Go to Add/Remove Programs and Remove JBossMySQL
	* MySQL - 'sc delete mysql' from the command line
	* JBoss - 'sc delete jboss' from the command line

### 

1. Create directory structure C:\\Novell\\IDM
2. Run IdmUserApp.exe \[UserApp: 3.6: java -jar IdmUserApp.jar - runs a java install utility\]
3. Choose Yes to run the Jboss MySQL installer

**MySQL**
The italics indicates the title of the install screen…

1. _Choose Base Folder_ - change default to C:\\Novell\\IDM
2. _Choose MySQL_ - root user password

**JBoss** Assuming a default installation–no clustering.

1. _Data Migration_ - If you're not migrating, just click Next and leave the Yes checkbox unchecked
2. _Choose Install Folder_ - leave it at C:\\Novell\\IDM
3. _Database Name & Privileged User_ - keep Database name of idmuserappdb, user is root and password from #5 above
4. _Java Install_ - Set to C:\\Novell\\IDM\\jre
5. _JBoss Configuration_ - Change Base folder to C:\\Novell\\IDM\\jboss

### 

1. Instructions for enabling SSL on JBoss can be found at <http://www.jboss.org/community/docs/DOC-11989> under the heading “1 - SSL enabled on the server - the common case”
2. Ensure that you are using a valid cert that matches your server's DNS name to avoid any cert validation errors on the client.

Note: when using '-genkey' on keytool, the default validity period is only about 3 months. Keep this in mind when creating the certificate. Also note that the only step I had to take to get it working is the first keytool call to generate the

I've used the following to create the server keystore with a cert that is valid for 10 years:

EXAMPLE:

keytool -genkey -alias serverkeys -keyalg RSA -keystore server.keystore -validity 3650 -storepass 123456 -keypass 123456 -dname "CN=IDMPRODUP.fcps.edu, OU=MYOU, O=MYORG, L=MYCITY, ST=MYSTATE, C=MY"

Also note: I only had to create the server.keystore file, and copy to C:\\Novell\\idm\\jboss\\server\\IDM\\conf - I didn't have to extract the server.cer, or create the client.truststore - those steps seemed to be there simply to show the full process of how they're used.

NOTE: the link above has been copied here in the event they remove/delete/modify the page so that it is no longer useable.

1 - SSL enabled on the server - the common case

* In this configuration you need three files

1. server.keystore - contains the key pair
2. server.cer - server certificate exported from the keystore
3. client.truststore - contains the server certificate

* Create the server keystore

keytool -genkey -alias serverkeys -keyalg RSA -keystore server.keystore -storepass 123456 -keypass 123456 -dname "CN=localhost, OU=MYOU, O=MYORG, L=MYCITY, ST=MYSTATE, C=MY"

* Create the server certificate

keytool -export -alias serverkeys -keystore server.keystore -storepass 123456 -file server.cer

* Configure Tomcat

* Copy server.keystore to /server/xxx/conf and update the following in server.xml

      <!-- SSL/TLS Connector configuration using the admin devl guide keystore-->
      <Connector port="8443" address="${jboss.bind.address}"
           maxThreads="100" strategy="ms" maxHttpHeaderSize="8192"
           emptySessionPath="true"
           scheme="https" secure="true" clientAuth="false"            
           sslProtocol = "TLS"
           keystoreFile="${jboss.server.home.dir}/conf/server.keystore"
           keystorePass="123456"  
       ></Connector>

NOTE: For JBoss AS 4.2.1 don't forget two additional attributes:

protocol="HTTP/1.1" and SSLEnabled="true"

* Start the server
* run -c default
* Creating client.truststore (by importing server certificate)

keytool -import -v -keystore client.truststore  -storepass 123456 -file server.cer

* Run the client

java -Djavax.net.ssl.trustStore=client.truststore -Djavax.net.ssl.trustStorePassword=123456 acme/ReadHttpsURL2 https://localhost:8443

### 

\* Prerequisite: Enable SSL On JBoss - so there's something to redirect to.

Redirection of HTTP to HTTPS can be done once SSL is installed. Note that some of the steps below require modification of Once SSL is in and running, do the following

Note that some steps in here require modification to the IDM.war file - Please see the 'Proper Modification of IDM.war' step below on this page to successfully modify the war file; using winzip or any other zip application to recompress the IDM.war file besides jar.exe will cause the configupdate.bat or UserApp itself to stop working.

Follow these steps to enable redirection of HTTP to HTTPS requests:

1. Stop JBoss
2. Create a backup of C:\\novell\\idm\\jboss\\server\\idm\\deploy\\IDM.war in some place other than this deploy directory.
3. Modify the WEB-INF/web.xml file in IDM.war (using the instructions as mentioned below) to include the following XML as a child tag to the <web-app> element. There should already be a security-constraint in the web.xml after vanilla installation, so I put this XML below that section at the bottom of the file.

<security-constraint>
    <web-resource-collection>
        <web-resource-name>Protected Context</web-resource-name>
        <url-pattern>/\*</url-pattern>
    </web-resource-collection>
    <!-- auth-constraint goes here if you require authentication -->
    <user-data-constraint>
        <transport-guarantee>CONFIDENTIAL</transport-guarantee>
    </user-data-constraint>
</security-constraint>

1. Copy the newly updated IDM.war back to the deploy directory mentioned above. Be sure to overwrite the old one.
2. Modify the C:\\novell\\idm\\jboss\\server\\IDM\\deploy\\jboss-web.deployer\\server.xml file to include the redirected http ports to https. This is the same file modified to enable SSL. Note: in this example, ports 8080 and 80 are being redirected to https; and the SSL connector element that is currently being used at FCPS has been left here for clarity, it does not need to be added to the server.xml file twice.

\* Important: Note that the SSL port chosen here is 443; ensure that your redirectPort attributes on the connector tag match the SSL tag, or the redirection will not work.

    <Connector port="8080" address="${jboss.bind.address}"    
         maxThreads="250" maxHttpHeaderSize="8192"
         emptySessionPath="true" protocol="HTTP/1.1"
         enableLookups="false" redirectPort="443" acceptCount="100"
         connectionTimeout="20000" disableUploadTimeout="true" />

    <Connector port="80" address="${jboss.bind.address}"    
         maxThreads="250" maxHttpHeaderSize="8192"
         emptySessionPath="true" protocol="HTTP/1.1"
         enableLookups="false" redirectPort="443" acceptCount="100"
         connectionTimeout="20000" disableUploadTimeout="true" />


 <!-- SSL/TLS Connector configuration using the admin devl guide keystore-->
      <Connector port="443" address="${jboss.bind.address}"
           maxThreads="100" strategy="ms" maxHttpHeaderSize="8192"
           emptySessionPath="true"
           scheme="https" secure="true" clientAuth="false"            
           sslProtocol = "TLS"
           keystoreFile="${jboss.server.home.dir}/conf/server.keystore"
           keystorePass="123456"
           SSLEnabled="true"
       />

1. Restart JBoss.
2. Test the redirected ports.

### 

This is accomplished by ensuring that the Header Portlet requires authentication. Since this portlet appears on every page, authentication is forced to appear first.

1. Authenticate to UserApp.
2. Click on the “Administration” tab from the navigation bar at the top.
3. Click on the “Portlet Admin” tab, just below the “Administration” tab
4. From the portlet tree on the left, click on IDM to expand the list of portlets
5. Click on “Header Portlet” definition and click on the “Header Portlet” registered portlet underneath
6. Click on the “Settings” tab.
7. Set 'Requires Authentication' to True.
8. Press the 'Save Settings' button at the bottom to finish.

### 

* Go to mysqld found in C:\\Novell\\IDM\\mysql\\bin
* Type the following (Note there are two dashes in front of the switches):

mysqld --install MySQL --defaults-file=C:\\Novell\\IDM\\mysql\\my.ini 

* Then type:

net start mysql

* Check the service listing for MySQL

Reference: <http://dev.mysql.com/doc/refman/5.0/en/windows-start-service.html>

### 

1. Before bothering with JBoss as a service, check to make sure JBoss loads manually by running 'C:\\Novell\\IDM\\start-jboss.bat'. Use 'C:\\Novell\\IDM\\stop-jboss.bat' to stop JBoss and continue. \[Userapp 3.6: use run.bat and shutdown.bat -S in the c:\\novell\\idm\\jboss\\bin directory.\]
2. If you are installing on a 64 bit platform, you may want to consider using the [Java Service Wrapper](https://wiki.trivir.com/dev/wrappers/start). As of this writing, the 64 bit version of the wrapper found on the tanukisoftware.org site costs additional money, and the 64 bit java service wrapper works really well for free.
3. If you are installing on a 32 bit plaform, and are chosing the tanukisoftware.org wrapper, download it from <http://wrapper.tanukisoftware.org/doc/english/download.jsp>. Download the community version that doesn't require a license.
4. Extract the file to a folder named wrapper
	* JAVA\_HOME C:\\Novell\\IDM\\jre\\bin
	* JBOSS\_HOME C:\\Novell\\IDM\\jboss

* Copy the files App.bat.in, InstallApp-NT.bat.in and UninstallApp-NT.bat.in to JBOSS\_HOME\\bin
* Rename those 3 copied files to remove the .in extension so they can be run as a batch files. Rename App.bat.in to App.bat
* Copy the wrapper.exe to JBOSS\_HOME\\bin
* Copy the wrapper.dll and wrapper.jar file to JBOSS\_HOME\\lib
* Create a folder named 'conf' under JBOSS\_HOME
* Create a configuration file called wrapper.conf inside newly created conf directory (below is an example for this environment)
* For a our IDM UserApp the wrapper.conf file looks like this:
wrapper.java.command=C:\\IDM351\\idm\\jre\\bin\\java
wrapper.java.mainclass=org.tanukisoftware.wrapper.WrapperSimpleApp
wrapper.java.classpath.1=C:\\IDM351\\idm\\jboss\\lib\\wrapper.jar
wrapper.java.classpath.2=C:\\IDM351\\idm\\jre\\lib\\tools.jar
wrapper.java.classpath.3=C:\\IDM351\\idm\\jboss\\bin\\run.jar
wrapper.java.classpath.4=C:\\IDM351\\idm\\jboss\\lib\\endorsed\\xalan.jar
wrapper.java.library.path.1=C:\\IDM351\\idm\\jboss\\lib
wrapper.java.additional.1=-server
wrapper.java.additional.2=-XX:MaxPermSize=128m
wrapper.java.initmemory=128
wrapper.java.maxmemory=512
wrapper.app.parameter.1=org.jboss.Main
wrapper.app.parameter.2=-c IDM -b 0.0.0.0
wrapper.logfile=C:\\IDM351\\idm\\jboss\\server\\IDM\\log\\wrapper.log
wrapper.ntservice.name=JBoss
wrapper.ntservice.displayname=JBoss Server
wrapper.ntservice.dependency.1=MySQL
wrapper.ntservice.starttype=AUTO\_START

For FCPS's UserApp 3.6.0 the wrapper.conf file looks like this:

wrapper.java.command=C:\\Program Files\\Java\\jdk1.5.0\_15\\bin\\java
wrapper.java.mainclass=org.tanukisoftware.wrapper.WrapperSimpleApp
wrapper.java.classpath.1=C:\\novell\\idm\\jboss\\lib\\wrapper.jar
wrapper.java.classpath.2=C:\\novell\\idm\\jre\\lib\\tools.jar
wrapper.java.classpath.3=C:\\novell\\idm\\jboss\\bin\\run.jar
wrapper.java.classpath.4=C:\\novell\\idm\\jboss\\lib\\endorsed\\xalan.jar
wrapper.java.library.path.1=C:\\novell\\idm\\jboss\\lib
wrapper.java.additional.1=-server
wrapper.java.additional.2=-XX:MaxPermSize=128m
wrapper.java.initmemory=128
wrapper.java.maxmemory=512
wrapper.app.parameter.1=org.jboss.Main
wrapper.app.parameter.2=-c IDM -b 0.0.0.0
wrapper.logfile=C:\\novell\\idm\\jboss\\server\\IDM\\log\\wrapper.log
wrapper.ntservice.name=JBoss
wrapper.ntservice.displayname=JBoss Server
wrapper.ntservice.dependency.1=MySQL
wrapper.ntservice.starttype=AUTO\_START

After setting the above, run the file JBOSS\_HOME/jboss/bin/InstallApp.bat to install the jboss service. Notice that we have **NOT** started the JBoss service yet.

### 

You better know how to do this. Configure the driver and fire it up.

### 

Make sure the MySQL service is running.
Make sure the User App driver is running.
Start the JBoss service.

### 

To disable access to the JBOSS console (i.e <http://server/> goes directoy to UserApp rather than jboss console), and be directed to the UserApp when first connecting, execute the following steps:

1. Stop JBoss
	1. C:\\Novell\\idm\\jboss\\server\\IDM\\deploy\\jboss-web.deployer\\ROOT.war

1. I've found compressing it seems to be a OK too - Save as OrginalROOT.zip

* Create new/Clean out ROOT.war directory so no files exist.
* Create a new file - index.jsp, with only the following line:
* <% response.sendRedirect(”/IDM/jsps/login/Login.jsf”); %>
* Save file and restart JBoss
* Try hitting the new site, which should bring up UserApp directly:

## 

### 

You'll need a GUI to complete the install and configuration. If you don't have X-windows access to the server, redirect X-windows to you using cygwin.

1. Go to x.cygwin.com and click on one of the setup.exe links on the page.
	* X-11 –> xorg-server
	* Net –> inetutils and openssh

* Find cygwin\\usr\\X11R6\\bin\\startxwin.bat and run it
* In the Xterm windows that pops up, type “ssh -X root@serverName.com”
* Run the install.bin for User App to launch the GUI install on your desktop

### 

If you install MySQL from the JBossMySQL.bin file, you can't install as root without problems and MySQL won't run as a service when you're done. So let's make it easier and install MySQL.rpm to avoid these issues.

## 

The User App database connection information is set during the installation. The User App database connection information may need to be updated in one of the following instances:

1. The database is moved to another server
2. The database is moved to another port
3. The server is renamed
4. The server is gets a new IP address

Find the following file: /opt/userapp/jboss/server/IDM/deploy/IDM-ds.xml

which looks like this:

<?xml version="1.0" encoding="UTF-8"?>
<datasources>
    <local-tx-datasource>
        <jndi-name>IDMUADataSource</jndi-name>
        <connection-url>jdbc:mysql://stclawldapp1.umm.edu:3306/userappdb?useUnicode=true&amp;characterEncoding=utf8&amp;connectionCollation=utf8\_bin</connection-url>
        <driver-class>com.mysql.jdbc.Driver</driver-class>
        <security-domain>EncryptDBPassword</security-domain>
    </local-tx-datasource>
</datasources>

and update the appropriate information.

## 

Modifications described here are not supported by Novell, and require modification directly to the IDM.war file, see 'Proper Modification of IDM.war' to modify the war file properly.

#### 

The following can be done to statically change the Login Title page - however, the steps done here simply statically change the value to the desired text. The correct way to update this value would be to update the messages bean's LOGIN\_TITLE value, however, the process to do this is unknown at the time of this writing. Since the messages.LOGIN\_TITLE value seems to appear only once throughout the UserApp system, the change should be relatively safe.

1. Stop JBoss
	1. There is a line that looks like this:

<TITLE><h:outputText value="#{messages.LOGIN\_TITLE}" /></TITLE>

1. Change it to look like this:

<TITLE>My Excellent New Title is So Much Better</TITLE>

1. Copy the updated IDM.war file back to the deploy directory.
2. Start JBoss
3. Go to the login screen, and confirm your new title still appears, 'My Excellent New Title is So Much Better' in the title bar of the page when the login screen appears.

## 

To update the IDM.war file, you must do the following to avoid corruption of the file. Also note - any time you update the file, ensure that the latest file is always extracted first, then updated so no previous changes are lost.

\* Do not use any zip application besides “jar.exe” to compress the war file, or else it will may not be use-able by the configupdate.bat file, or UserApp.

1. Confirm there is a path to your current JDK's bin directory containing jar.exe
2. Stop JBoss service
3. Create a directory named work at the root of C.
4. Copy the IDM.war to C:\\work
5. Uncompress the IDM.war file (using winzip is fine here) to a C:\\work\\IDM.war.dir directory.
6. Make the necessary modifications
7. When completed, save and close all files opened from the C:\\work\\IDM.war.dir directory.
8. In a dos windows, run the following jar command in the C:\\work\\IDM.war.dir directory:
9. jar uvf ..\\IDM.war .
10. copy the new IDM.war file to C:\\novell\\idm\\jboss\\server\\idm\\deploy
11. restart jboss.

The whole trick here is in using the jar command, and using the 'u' command line option to update the already existing war file. There's a comment from google from someone saying that this is in the userapp 'readme' but I haven't found it yet. Either way, the above works.

Logged in as: akynaston
dev/idm/userapp.txt · Last modified: 2011/07/05 14:05 by akynaston

<https://wiki.trivir.com/dev/idm/#dokuwiki__top> 

[![[./_resources/devidmuserapp_TriVir_Internal_wiki.trivir.com.resources/unknown_filename.png]]](https://wiki.trivir.com/feed.php) [![[./_resources/devidmuserapp_TriVir_Internal_wiki.trivir.com.resources/unknown_filename.5.gif]]](http://creativecommons.org/licenses/by-nc-sa/2.0/) [![[./_resources/devidmuserapp_TriVir_Internal_wiki.trivir.com.resources/unknown_filename.4.gif]]](https://www.paypal.com/xclick/business=andi%40splitbrain.org%26amp;item_name=DokuWiki+Donation%26amp;no_shipping=1%26amp;no_note=1%26amp;tax=0%26amp;currency_code=EUR%26amp;lc=US) [![[./_resources/devidmuserapp_TriVir_Internal_wiki.trivir.com.resources/unknown_filename.6.gif]]](http://www.php.net/) [![[./_resources/devidmuserapp_TriVir_Internal_wiki.trivir.com.resources/unknown_filename.2.png]]](http://validator.w3.org/check/referer) [![[./_resources/devidmuserapp_TriVir_Internal_wiki.trivir.com.resources/unknown_filename.1.png]]](http://jigsaw.w3.org/css-validator/check/referer?profile=css3) [![[./_resources/devidmuserapp_TriVir_Internal_wiki.trivir.com.resources/unknown_filename.3.png]]](http://wiki.splitbrain.org/wiki:dokuwiki)
![indexer.php?id=dev%3Aidm%3Auserapp&amp;1314917544](https://wiki.trivir.com/lib/exe/indexer.php?id=dev%3Aidm%3Auserapp&amp;1314917544)
