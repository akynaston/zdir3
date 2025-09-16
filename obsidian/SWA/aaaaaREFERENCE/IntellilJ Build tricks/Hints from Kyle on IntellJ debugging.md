7/23/2024 10:54:33 AM



7/22/2024 1:19:24 PM
 - Dump dev/IDtoAvioBookPrelive
compare -pDEPLOY_ENVIRONMENT=dev -PENVIRONMENT=dev





export deploy_config=aws:dev/driver_set_aev1
export secrets_config=aws:dev/IDtoAvioBook
./gradlew compare -PDEPLOY_ENVIRONMENT=dev -PENVIRONMENT=dev


Can't load main class 'Set' error


'C:\Users\x266698\.jdks\azul-1.8.0_382\bin\java.exe''. Working directory: C:\work\IDtoAvioBook Command: C:\Users\x266698\.jdks\azul-1.8.0_382\bin\java.exe -D=::=::\ -DALLUSERSPROFILE=C:\ProgramData -DAPPDATA=C:\Users\x266698\AppData\Roaming -DCOMMONPROGRAMFILES=C:\Program Files\Common
Files -DCOMPUTERNAME=SY4-HW2XSQ3 -DCOMSPEC=C:\WINDOWS\system32\cmd.exe -DChocolateyInstall=C:\ProgramData\chocolatey -DChocolateyLastPathUpdate=133239133961396844 -DCommonProgramFiles(x86)=C:\Program Files (x86)\Common Files -DCommonProgramW6432=C:\Program Files\Common Files -DDEPLOY_LOG_LEVEL=INFO -DDriverData
=C:\Windows\System32\Drivers\DriverData -DEFC_13980=0 -DEXEPATH=C:\Program Files\Git\bin -DFPS_BROWSER_APP_PROFILE_STRING=Internet Explorer -DFPS_BROWSER_USER_PROFILE_STRING=Default -DGIT_PS1_SHOWDIRTYSTATE -DGIT_PS1_SHOWUNTRACKEDFILES -DHOME=C:\users\x266698 -DHOMEDRIVE=C: -DHOMEPATH=\Users\x266698 -DIDEA_INIT
IAL_DIRECTORY=C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\jbr\bin -DIGCCSVC_DB=AQAAANCMnd8BFdERjHoAwE/Cl+sBAAAAdCxqxKKUyUSD9W1tLxymsgQAAAACAAAAAAAQZgAAAAEAACAAAADkVXDux2E3yWVgz6wvlYoPOup5ksCffmqTHVxz04/ldwAAAAAOgAAAAAIAACAAAAA9sXqSCcCmKU58iaIx0r78S4qfw4xGuA4qg4zMKYDio2AAAAAlV8k4UFjhgwZyE
LZRuH1h4VUZw+6ad6Tp+gNkU+OIEy8RKsAXRynB9zs4Q/h+gz9fvoP1bCzDvjyNeI4d4qLo1v1yuiXbg9zx5zMn5knCq1fX90mzafeo9sz4+u6gHNVAAAAAPSycxVmVBnPA33XYgHJw24SJghK9ORSxCYJn6v3G/yFYxW5qJjsAwlhbUDU/2/ddK5P7GkPP8kROGpjNmaRYIg== -DIntelliJ IDEA Community Edition=C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\bi
n; -DJAVAHOME=C:\Users\x266698\.jdks\azul-1.8.0_382 -DLOCALAPPDATA=C:\Users\x266698\AppData\Local -DLOGONSERVER=\\SDCPCWADDSLV005 -DMSYSTEM=MINGW64 -DNEXTHINK=C:\Program Files\Nexthink\Collector -DNUMBER_OF_PROCESSORS=12 -DOS=Windows_NT -DPATH=C:\Program Files\Git\mingw64\bin;C:\Program Files\Git\usr\bin;C:\use
rs\x266698\bin;C:\work\adminrepo\tools\bat;C:\Program Files\Git\usr\bin;C:\Windows\System32;C:\Windows;C:\Windows\System32\wbem;C:\Windows\System32\WindowsPowerShell\v1.0;C:\Windows\System32\OpenSSH;C:\Program Files (x86)\Sennheiser\SoftphoneSDK;C:\Program Files\PuTTY;C:\Program Files\Microsoft SQL Server\110\T
ools\Binn;C:\Users\x266698\.jdks\azul-1.8.0_382\bin;C:\cygwin64\bin;C:\maven\bin;C:\ProgramData\chocolatey\bin;C:\Users\x266698\AppData\Local\Programs\Python\Python311;C:\Program Files\Amazon\AWSCLIV2;C:\Users\x266698\AppData\Local\Programs\Common;C:\Program Files\Docker\Docker\resources;C:\work\trivir\bin\idmu
nit-test-converter\bin;C:\work\trivir\bin\schema-check\bin;C:\Program Files\GitHub CLI;C:\Program Files (x86)\Microsoft SQL Server\Client SDK\ODBC\130\Tools\Binn;C:\Program Files (x86)\Microsoft SQL Server\140\Tools\Binn;C:\Program Files (x86)\Microsoft SQL Server\140\DTS\Binn;C:\Program Files (x86)\Microsoft S
QL Server\140\Tools\Binn\ManagementStudio;C:\Program Files\Git\cmd;C:\Program Files (x86)\GnuPG\bin;C:\Program Files\TortoiseSVN\bin;C:\Program Files\dotnet;C:\Program Files\Git\usr\bin;C:\Users\x266698\AppData\Local\Microsoft\WindowsApps;C:\Users\x266698\AppData\Local\Programs\Git\cmd;C:\Users\x266698\AppData\
Local\Programs\Git\bin;C:\ant\apache-ant-1.10.13\bin;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\bin;C:\Users\x266698\AppData\Local\Programs\Microsoft VS Code\binC;C:\Program Files\Git\Users\x266698\AppData\Local\Programs\Common\C;C:\Program Files\Git\Users\x266698\AppData\Local\Programs
\Common;C:\Users\x266698\AppData\Local\Programs\Microsoft VS Code\binC;C:\Program Files\Git\Users\x266698\AppData\Local\Programs\Common;C:\Users\x266698\AppData\Local\Programs\Microsoft VS Code\bin;C:\work\utils\idmunit-test-converter\bin;C:\Program Files\7-Zip;%USERPROFILE%\AppData\Local\Microsoft\WindowsApps
-DPATHEXT=.COM;.EXE;.BAT;.CMD;.VBS;.VBE;.JS;.JSE;.WSF;.WSH;.MSC -DPLINK_PROTOCOL=ssh -DPROCESSOR_ARCHITECTURE=AMD64 -DPROCESSOR_IDENTIFIER=Intel64 Family 6 Model 154 Stepping 4, GenuineIntel -DPROCESSOR_LEVEL=6 -DPROCESSOR_REVISION=9a04 -DPROGRAMFILES=C:\Program Files -DPSModulePath=C:\Program Files\WindowsPowe
rShell\Modules;C:\WINDOWS\system32\WindowsPowerShell\v1.0\Modules;C:\Program Files\Thycotic\Powershell\ -DPUBLIC=C:\Users\Public -DPWD=C:/work/IDtoAvioBook -DProgramData=C:\ProgramData -DProgramFiles(x86)=C:\Program Files (x86) -DProgramW6432=C:\Program Files -DSESSIONNAME=Console -DSHLVL=1 -DSYSTEMDRIVE=C: -DS
YSTEMROOT=C:\WINDOWS -DTEMP=C:\Users\x266698\AppData\Local\Temp -DTERM=cygwin -DTERMINAL_EMULATOR=JetBrains-JediTerm -DTERM_SESSION_ID=a17dc5ec-8801-471d-bcf7-9352900f58ec -DTMP=C:\Users\x266698\AppData\Local\Temp -DUATDATA=C:\WINDOWS\CCM\UATData\D9F8C395-CAB8-491d-B8AC-179A1FE1BE77 -DUSERDNSDOMAIN=LUV.AD.SWACO
RP.COM -DUSERDOMAIN=LUV -DUSERDOMAIN_ROAMINGPROFILE=LUV -DUSERNAME=x266698 -DUSERPROFILE=C:\Users\x266698 -DWINDIR=C:\WINDOWS -DZES_ENABLE_SYSMAN=1 -D__INTELLIJ_COMMAND_HISTFILE__=C:\Users\x266698\AppData\Local\JetBrains\IdeaIC2022.3\terminal\history\IDtoAvioBook-history -Dcom.sun.jndi.ldap.object.disableEndpoi
ntIdentification=true -DdeployDriverIntoTree=false -Ddeploy_config={"dev_1_host_name":"w11dcledirdi019.swacorp.com","dev_1_host_port":"1636","dev_1_targetDriverDN":"cn=IDtoAvioBook,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev", "dev_1_user_name":"cn=p502052,ou=ServiceAccounts,o=swaiddev","dev_1_user_pass"
:"aws:dev/p502052","dev_1_configFilePath":"final/DEV/IDtoAvioBook.xml","dev_2_host_name":"w11dcledirdi020.swacorp.com","dev_2_host_port":"1636","dev_2_targetDriverDN":"cn=IDtoAvioBook,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev", "dev_2_user_name":"cn=p502052,ou=ServiceAccounts,o=swaiddev","dev_2_user_pass":"aws:dev/p502052","dev_2_configFilePath":"final/DEV/IDtoAvioBook-failover.xml","impersonationUserDn":"cn=ax266698,ou=Admins,o=swaiddev","securityEqualsLDAPDN":"cn=IDMProvAdmin,o=swaiddev","dev_2_deployJobs":"false"} -Ddev/IDtoAvioBook={"namedPasswordKey_1":"sub-password","namedPassword_1":"avio-idp-api123","namedPasswordDescription_1":"AvioBook app password for the REST service.","namedPasswordKey_2":"sub-password-prelive","namedPassword_2":"swa123","namedPasswordDescription_2":"AvioBook app password for the REST service.",

    "dev_3_configFilePath": "final/DEV/IDtoAvioBookPrelive.xml",
    "dev_3_host_name": "w11dcledirdi019.swacorp.com",
    "dev_3_host_port": "1636",
    "dev_3_targetDriverDN": "cn=IDtoAvioBookPrelive,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev",
    "dev_3_user_name": "cn=p502052,ou=ServiceAccounts,o=swaiddev",
    "dev_3_user_pass": "aws:dev/p502052",
    "dev_4_configFilePath": "final/DEV/IDtoAvioBookPrelive-failover.xml",
    "dev_4_deployJobs": "false",
    "dev_4_host_name": "w11dcledirdi020.swacorp.com",
    "dev_4_host_port": "1636",
    "dev_4_targetDriverDN": "cn=IDtoAvioBookPrelive,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev",
    "dev_4_user_name": "cn=p502052,ou=ServiceAccounts,o=swaiddev",
    "dev_4_user_pass": "aws:dev/p502052",
    "impersonationUserDn": "cn=a$GITLAB_USER_LOGIN,ou=Admins,o=swaiddev",
    "securityEqualsLDAPDN": "cn=IDMProvAdmin,o=swaiddev"
} -Ddev/driver_set_aev1={"dev_1_host_name":"w11dcledirdi019.swacorp.com","dev_1_host_port":"1636","dev_1_targetDriverDN":"cn=$DRIVER_NAME$,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev","dev_1_user_name":"cn=p502052,ou=ServiceAccounts,o=swaiddev","dev_1_user_pass":"aws:dev/p502052","dev_1_configFilePath":
"final/DEV/$DRIVER_NAME$.xml","dev_2_host_name":"w11dcledirdi020.swacorp.com","dev_2_host_port":"1636","dev_2_targetDriverDN":"cn=$DRIVER_NAME$,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev","dev_2_user_name":"cn=p502052,ou=ServiceAccounts,o=swaiddev","dev_2_user_pass":"aws:dev/p502052","dev_2_configFileP
ath":"final/DEV/$DRIVER_NAME$-failover.xml","impersonationUserDn":"cn=a$GITLAB_USER_LOGIN,ou=Admins,o=swaiddev","securityEqualsLDAPDN":"cn=IDMProvAdmin,o=swaiddev","dev_2_deployJobs":"false"} -Ddev/p502052=c@$2e2RXFjanh2fi -Ddev_1_configFilePath=final/DEV/IDtoAvioBook.xml -Ddev_1_host_name=w11dcledirdi019.swaco
rp.com -Ddev_1_host_port=1636 -Ddev_1_targetDriverDN=cn=IDtoAvioBook,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev -Ddev_1_user_name=cn=p502052,ou=ServiceAccounts,o=swaiddev -Ddev_1_user_pass=c@$2e2RXFjanh2fi -Ddev_2_configFilePath=final/DEV/IDtoAvioBook-failover.xml -Ddev_2_deployJobs=false -Ddev_2_host_
name=w11dcledirdi020.swacorp.com -Ddev_2_host_port=1636 -Ddev_2_targetDriverDN=cn=IDtoAvioBook,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev -Ddev_2_user_name=cn=p502052,ou=ServiceAccounts,o=swaiddev -Ddev_2_user_pass=c@$2e2RXFjanh2fi -Ddev_3_configFilePath=final/DEV/IDtoAvioBookPrelive.xml -Ddev_3_host_n
ame=w11dcledirdi019.swacorp.com -Ddev_3_host_port=1636 -Ddev_3_targetDriverDN=cn=IDtoAvioBookPrelive,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev -Ddev_3_user_name=cn=p502052,ou=ServiceAccounts,o=swaiddev -Ddev_3_user_pass=c@$2e2RXFjanh2fi -Ddev_4_configFilePath=final/DEV/IDtoAvioBookPrelive-failover.xml
 -Ddev_4_deployJobs=false -Ddev_4_host_name=w11dcledirdi020.swacorp.com -Ddev_4_host_port=1636 -Ddev_4_targetDriverDN=cn=IDtoAvioBookPrelive,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev -Ddev_4_user_name=cn=p502052,ou=ServiceAccounts,o=swaiddev -Ddev_4_user_pass=c@$2e2RXFjanh2fi -DexecuteExportVsTreeDiff
=true -Dhome=C:\users\x266698 -DimpersonationUserDn=cn=ax266698,ou=Admins,o=swaiddev -Dlogback.configurationFile=src/test/resources/logback.xml -DnamedPasswordDescription_1=AvioBook app password for the REST service. -DnamedPasswordDescription_2=AvioBook app password for the REST service. -DnamedPasswordKey_1=s
ub-password -DnamedPasswordKey_2=sub-password-prelive -DnamedPassword_1=avio-idp-api123 -DnamedPassword_2=swa123 -Dsecrets_config={"namedPasswordKey_1":"sub-password","namedPassword_1":"avio-idp-api123","namedPasswordDescription_1":"AvioBook app password for the REST service.","namedPasswordKey_2":"sub-password-prelive","namedPassword_2":"swa123","namedPasswordDescription_2":"AvioBook app password for the REST service.",

    "dev_3_configFilePath": "final/DEV/IDtoAvioBookPrelive.xml",
    "dev_3_host_name": "w11dcledirdi019.swacorp.com",
    "dev_3_host_port": "1636",
    "dev_3_targetDriverDN": "cn=IDtoAvioBookPrelive,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev",
    "dev_3_user_name": "cn=p502052,ou=ServiceAccounts,o=swaiddev",
    "dev_3_user_pass": "aws:dev/p502052",
    "dev_4_configFilePath": "final/DEV/IDtoAvioBookPrelive-failover.xml",
    "dev_4_deployJobs": "false",
    "dev_4_host_name": "w11dcledirdi020.swacorp.com",
    "dev_4_host_port": "1636",
    "dev_4_targetDriverDN": "cn=IDtoAvioBookPrelive,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev",
    "dev_4_user_name": "cn=p502052,ou=ServiceAccounts,o=swaiddev",
    "dev_4_user_pass": "aws:dev/p502052",
    "impersonationUserDn": "cn=ax266698,ou=Admins,o=swaiddev",
    "securityEqualsLDAPDN": "cn=IDMProvAdmin,o=swaiddev"
} -DsecurityEqualsLDAPDN=cn=IDMProvAdmin,o=swaiddev -Dfile.encoding=windows-1252 -Duser.country=US -Duser.language=en -Duser.variant -cp C:\work\IDtoAvioBook\build\classes\java\main;C:\work\IDtoAvioBook\build\resources\main;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\com.swa.idmunit.connector\swa-idmuni
t-rest-connector\2.0.0\5a8dd0a854bb1c5e65fa6d44c20f3e6a53057554\swa-idmunit-rest-connector-2.0.0.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\com.swacorp.csiam.idm\swa-idm-unit\1.8.4\e2b3be168f3460162af4d94a04597e2ed642e93a\swa-idm-unit-1.8.4.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\so
ftware.amazon.awssdk\secretsmanager\2.25.10\422681cae1bd563df09463a3031e30b051aa659a\secretsmanager-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.idmunit\idm-cmdline-deploy\1.3.10\189a70145b195769dd96a68529bfade2e6594ec7\idm-cmdline-deploy-1.3.10.jar;C:\Users\x266698\.gradle\caches\modules
-2\files-2.1\com.trivir.idmunit\idmunit-test-converter\1.0.0\768cf38aaa932a35e13019ffd644efcea160572c\idmunit-test-converter-1.0.0.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.idmunit\idmunit\2.1.56\e1ddb4dd1af264d48331c01cf8b72f2bae2b0bc1\idmunit-2.1.56.jar;C:\Users\x266698\.gradle\caches\module
s-2\files-2.1\junit\junit\4.13.2\8ac9e16d933b6fb43bc7f576336b8f4d7eb5ba12\junit-4.13.2.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\com.novell.jclient\jclient\1.0.0\f489151d0d979010b1a6ff7762b912cafe44c0b9\jclient-1.0.0.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\com.swacorp.csiam.idm\ins
tall-cert\1.0.0\fa8741184291f01cbc351a704e5b9c8d6410b388\install-cert-1.0.0.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\ch.qos.logback\logback-classic\1.3.14\a2f0045eae641a356b74afb0d3b85268181a93cf\logback-classic-1.3.14.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\com.jayway.jsonpath\js
on-path\2.8.0\b4ab3b7a9e425655a0ca65487bbbd6d7ddb75160\json-path-2.8.0.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\com.swacorp.csiam.idm.common\swa-diff-viewer\1.0.7\34240888602342cdacf50b7441dff429a3a805c3\swa-diff-viewer-1.0.7.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.reflections
\reflections\0.10.2\b638d7ca0e0fe0146b60a0e7ba232ad852a73b31\reflections-0.10.2.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software.amazon.awssdk\aws-json-protocol\2.25.10\7d07cfe46259304cab7d53809b9a6895297f4419\aws-json-protocol-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\soft
ware.amazon.awssdk\protocol-core\2.25.10\a54c897607fb205812cd9cc794e9d6cd574b8384\protocol-core-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software.amazon.awssdk\aws-core\2.25.10\886eb2acc094504f9787ea0cfa00ea62706636f4\aws-core-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.
1\software.amazon.awssdk\auth\2.25.10\98aa5e8335635c12106f7da955879f271441d0d4\auth-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software.amazon.awssdk\regions\2.25.10\537ff325be5eac9c74b3cad6847d683b74865b3e\regions-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software.ama
zon.awssdk\sdk-core\2.25.10\7c155d1b96f288cb4420b6dfd988f0679ab34a04\sdk-core-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software.amazon.awssdk\http-auth-aws\2.25.10\e9156f7f92742b21e56f5eae1ba7e8d8361153\http-auth-aws-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software
.amazon.awssdk\http-auth\2.25.10\162be9890d445a4ec91c7ded7c377349f1674a9\http-auth-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software.amazon.awssdk\http-auth-spi\2.25.10\da5372a666d300920a5925b33e0bbf55845519b3\http-auth-spi-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\s
oftware.amazon.awssdk\identity-spi\2.25.10\e1d07ff823dce1ed8bb967c20b9c78772c061034\identity-spi-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software.amazon.awssdk\apache-client\2.25.10\3bd364a9ce16e0cb97a070fb2bba0e55432779c8\apache-client-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules
-2\files-2.1\software.amazon.awssdk\netty-nio-client\2.25.10\8f9f59429d9549048d6e6db5dac59c50b5ec54fa\netty-nio-client-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software.amazon.awssdk\http-client-spi\2.25.10\4ba4768bf348599097257efb9d0db0c90d207a98\http-client-spi-2.25.10.jar;C:\Users\x266
698\.gradle\caches\modules-2\files-2.1\software.amazon.awssdk\metrics-spi\2.25.10\9355d911eec0a01d8afeaa598b8d9235fccee6d\metrics-spi-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software.amazon.awssdk\json-utils\2.25.10\9ff7a99a3a4cbefb3fc669329b1fddd5f5b65351\json-utils-2.25.10.jar;C:\Users
\x266698\.gradle\caches\modules-2\files-2.1\software.amazon.awssdk\profiles\2.25.10\e48859f9c5fa1e9f79341dbe400a65326b9cfe5a\profiles-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software.amazon.awssdk\utils\2.25.10\b06a4f36adc9170707bc8376b28a928b81f685ba\utils-2.25.10.jar;C:\Users\x266698\.
gradle\caches\modules-2\files-2.1\org.slf4j\slf4j-api\2.0.12\48f109a2a6d8f446c794f3e3fa0d86df0cdfa312\slf4j-api-2.0.12.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\log4j\log4j\1.2.17\5af35056b4d257e4b64b9e8069c0746e8b08629f\log4j-1.2.17.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\systems.
manifold\manifold-ext\2024.1.21\8a79f0968908378332d5e303cd6169f84a884a03\manifold-ext-2024.1.21.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\com.google.code.gson\gson\2.10.1\b3add478d4382b78ea20b1671390a858002feb6c\gson-2.10.1.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software.amazon.aw
ssdk\endpoints-spi\2.25.10\3f6d0acadf5c1e2aecd853b8c496604042d469b1\endpoints-spi-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software.amazon.awssdk\checksums\2.25.10\7c4374727269d27e6c001567b281cd1a741b132e\checksums-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software.a
mazon.awssdk\checksums-spi\2.25.10\304b96ce499febbe53137527e445ac541ba6d1dd\checksums-spi-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software.amazon.awssdk\annotations\2.25.10\deb720292fd33059923a42cf37c6a462e88faeaa\annotations-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.
1\com.novell.nds\dirxml_misc\4.8.5.0\32b85978519c3eceefa4fbb57b8befc05ea91e74\dirxml_misc-4.8.5.0.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\com.novell.ldap\jldap\2009-10-07\f95a319a4881f4e109cefa57e97c0516cb6e58d8\jldap-2009-10-07.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\commons-col
lections\commons-collections\3.2.2\8ad72fe39fa8c91eaaf12aadb21e0c3661fe26d5\commons-collections-3.2.2.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.xmlunit\xmlunit-core\2.9.1\e5833662d9a1279a37da3ef6f62a1da29fcd68c4\xmlunit-core-2.9.1.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\com.fas
terxml.jackson.core\jackson-annotations\2.14.1\2a6ad504d591a7903ffdec76b5b7252819a2d162\jackson-annotations-2.14.1.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\com.fasterxml.jackson.core\jackson-core\2.14.1\7a07bc535ccf0b7f6929c4d0f2ab9b294ef7c4a3\jackson-core-2.14.1.jar;C:\Users\x266698\.gradle\cach
es\modules-2\files-2.1\com.fasterxml.jackson.core\jackson-databind\2.14.1\268524b9056cae1211b9f1f52560ef19347f4d17\jackson-databind-2.14.1.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\info.picocli\picocli\4.7.1\7ac5efc1f895a237eb3d8e77375d7c7a7dbbaae7\picocli-4.7.1.jar;C:\Users\x266698\.gradle\caches
\modules-2\files-2.1\org.fusesource.jansi\jansi\2.4.0\321c614f85f1dea6bb08c1817c60d53b7f3552fd\jansi-2.4.0.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.apache.poi\poi-ooxml\5.2.3\2efd11c940adb18c03eb9ce7ad88fc40ee6a196\poi-ooxml-5.2.3.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.id
munit\idmunit-connectors\1.0.33\429390e1b3703cf3d004b4f9584c930caf42a890\idmunit-connectors-1.0.33.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.hamcrest\hamcrest-core\1.3\42a25dc3219429f0e5d060061f71acb49bf010a0\hamcrest-core-1.3.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\com.novell\
nxsl\4.6.0.0\be085763c47f216e989bdab556a5636402b6735b\nxsl-4.6.0.0.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\ch.qos.logback\logback-core\1.3.14\436bd0d56730df756cff6d12d0f97df6f275e4a\logback-core-1.3.14.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\systems.manifold\manifold\2024.1.21\98
acf2ddded95c2204c627be90b1edcdbe3a855a\manifold-2024.1.21.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\systems.manifold\manifold-ext-rt\2024.1.21\5f48fa37682ec3fe701fe3e8a75ab8ed5ab2a732\manifold-ext-rt-2024.1.21.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\net.minidev\json-smart\2.4.10\91
cb329e9424bf32131eeb1ce2d17bf31b9899bc\json-smart-2.4.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software.amazon.awssdk\third-party-jackson-core\2.25.10\4ad5f78cd3cb17e1f1a25a7c7f4ea198223f188d\third-party-jackson-core-2.25.10.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.reactives
treams\reactive-streams\1.0.4\3864a1320d97d7b045f729a326e1e077661f31b7\reactive-streams-1.0.4.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\software.amazon.eventstream\eventstream\1.0.1\6ff8649dffc5190366ada897ba8525a836297784\eventstream-1.0.1.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\o
rg.apache.httpcomponents\httpclient\4.5.13\e5f6cae5ca7ecaac1ec2827a9e2d65ae2869cada\httpclient-4.5.13.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.apache.httpcomponents\httpcore\4.4.13\853b96d3afbb7bf8cc303fe27ee96836a10c1834\httpcore-4.4.13.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1
\org.apache.poi\poi\5.2.3\2fb22ae74ad5aea6af1a9c64b9542f2ccf348604\poi-5.2.3.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\commons-codec\commons-codec\1.15\49d94806b6e3dc933dacbd8acb0fdbab8ebd1e5d\commons-codec-1.15.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\io.netty\netty-codec-http2\4.1
.107.Final\3885ffe7dd05c9773df70c61009f34a5a8a383ec\netty-codec-http2-4.1.107.Final.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\io.netty\netty-codec-http\4.1.107.Final\4d8e9e51b7254bd26a42fe17bdcae32e4c6ebb3\netty-codec-http-4.1.107.Final.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\io.ne
tty\netty-handler\4.1.107.Final\d4c6b05f4d9aca117981297fb7f02953102ebb5e\netty-handler-4.1.107.Final.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\io.netty\netty-codec\4.1.107.Final\a1d32debf2ed07c5852ab5b2904c43adb76c39e\netty-codec-4.1.107.Final.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.
1\io.netty\netty-transport-classes-epoll\4.1.107.Final\9234407d6a46745599735765c4d3755c7fc84162\netty-transport-classes-epoll-4.1.107.Final.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\io.netty\netty-transport-native-unix-common\4.1.107.Final\4d61d4959741109b3eccd7337f11fc89fa90a74a\netty-transport-n
ative-unix-common-4.1.107.Final.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\io.netty\netty-transport\4.1.107.Final\d6a105c621b47d1410e0e09419d7209d2d46e914\netty-transport-4.1.107.Final.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\io.netty\netty-buffer\4.1.107.Final\8509a72b8a5a2d33d611e9
9254aed39765c3ad82\netty-buffer-4.1.107.Final.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\io.netty\netty-resolver\4.1.107.Final\dfee84308341a42131dd0f8ac0e1e02d627c19f3\netty-resolver-4.1.107.Final.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\io.netty\netty-common\4.1.107.Final\4f17a54753
0d64becd7179507b25f4154bcfba57\netty-common-4.1.107.Final.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\io.github.java-diff-utils\java-diff-utils\4.12\1a712a91324d566eef39817fc5c9980eb10c21db\java-diff-utils-4.12.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\commons-lang\commons-lang\2.6\ce1
edb914c94ebc388f086c6827e8bdeec71ac2\commons-lang-2.6.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.apache.poi\poi-ooxml-lite\5.2.3\db113c8e9051b0ff967f4911fa20336c8325a7c5\poi-ooxml-lite-5.2.3.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.apache.xmlbeans\xmlbeans\5.1.1\48a369df0eccb
509d46203104e4df9cb00f0f68b\xmlbeans-5.1.1.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.apache.commons\commons-compress\1.21\4ec95b60d4e86b5c95a0e919cb172a0af98011ef\commons-compress-1.21.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\commons-io\commons-io\2.11.0\a2503f302b11ebde7ebc3df4
1daebe0e4eea3689\commons-io-2.11.0.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\com.github.virtuald\curvesapi\1.07\863654849995f9d4f0ed2ed1a3870da3a108473c\curvesapi-1.07.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.apache.logging.log4j\log4j-api\2.18.0\c72ad9b1d8d42e4ea7befd8248bf0587
7af4c63d\log4j-api-2.18.0.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.apache.commons\commons-collections4\4.4\62ebe7544cb7164d87e0637a2a6a2bdc981395e8\commons-collections4-4.4.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\com.sun.mail\javax.mail\1.5.1\9724dd44f1abbba99c9858aa05fc91d53f
59e7a5\javax.mail-1.5.1.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\net.sourceforge.jexcelapi\jxl\2.6.12\7faf62e0697f7a88954622dfe8c8de33ed142ac7\jxl-2.6.12.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\nu.xom\xom\1.2.3\e1a4016079cabf374a94ce07ac977fb640d9439d\xom-1.2.3.jar;C:\Users\x26669
8\.gradle\caches\modules-2\files-2.1\com.trivir.idmunit.connector\dtf-connector\1.0.0\80b51136a19b24854af1648603dff43e36e6f5be\dtf-connector-1.0.0.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.javassist\javassist\3.28.0-GA\9a958811a88381bb159cc2f5ed79c34a45c4af7a\javassist-3.28.0-GA.jar;C:\Users\x
266698\.gradle\caches\modules-2\files-2.1\com.google.code.findbugs\jsr305\3.0.2\25ea2e8b0c338a877313bd4672d3fe056ea78f0d\jsr305-3.0.2.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\systems.manifold\manifold-rt\2024.1.21\ef442fbc305dc66cc693e36f57ee966d7d2bc02a\manifold-rt-2024.1.21.jar;C:\Users\x266698
\.gradle\caches\modules-2\files-2.1\net.minidev\accessors-smart\2.4.9\32e540749224c22c9b17de8137e916aae9057e22\accessors-smart-2.4.9.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.apache.commons\commons-math3\3.6.1\e4ba98f1d4b3c80ec46392f25e094a6a2e58fcbf\commons-math3-3.6.1.jar;C:\Users\x266698\.g
radle\caches\modules-2\files-2.1\com.zaxxer\SparseBitSet\1.2\8467c813d442837fcaeddbc42cf5c5359fab4933\SparseBitSet-1.2.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\javax.activation\activation\1.1\e6cb541461c2834bdea3eb920f1884d1eb508b50\activation-1.1.jar;C:\Users\x266698\.gradle\caches\modules-2\fil
es-2.1\commons-logging\commons-logging\1.2\4bfc12adfe4842bf07b657f0369c4cb522955686\commons-logging-1.2.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\com.jcraft\jsch\0.1.55\bbd40e5aa7aa3cfad5db34965456cee738a42a50\jsch-0.1.55.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\au.com.bytecode\open
csv\2.4\66151f8e7f00426025da525c2d64ed78cbe3fd08\opencsv-2.4.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\systems.manifold\manifold-util\2024.1.21\8bd1a361bfa959d1f701dd07c088767f43e3be28\manifold-util-2024.1.21.jar;C:\Users\x266698\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm\9.3\8e6300ef51c1d801a7ed62d07cd221aca3a90640\asm-9.3.jar com.trivir.idm.cmdline.main.Main -settingsPath C:\work\IDtoAvioBook/idm-common/config/deployer/deployer.properties -sensitivePath C:\work\IDtoAvioBook/idm-common/config/deployer/secrets.properties









