4/10/2024 12:51:11 PM
Example Kyle just gave me while testing his latest update (post 2.3.1):

Cool validations for settings below!!


x266698@SY4-HW2XSQ3 MINGW64 /c/work/IDtoDocunet (kyle)
$ ./gradlew validateEnvironmentFile -PDEPLOY_ENVIRONMENT=prod

> Configure project :
Gradle Version: Gradle 8.6
Groovy Version: 3.0.17
Java Location: C:\Users\x266698\.jdks\azul-1.8.0_382
Using IGA Standard: 0.0.1-CSIGA-6183-b6d387c

> Task :validateEnvironmentFile
Validating environments.yml for prod/prod
Checking prod:prod
Retrieving AWS Secret: prod/driver_set_v3
Retrieving AWS Secret: prod/p502052
Validating user cn=p502052,ou=ServiceAccounts,o=SWA-ID on server w11pcledirpi010.swacorp.com:1636.......VALID
Validating w11pcledirpi010.swacorp.com is on DirXML-ServerList for cn=Driver Set v3,ou=DirXML,ou=Services,o=SWA-ID:......DRIVERSET NOT FOUND
Validating driverDN object: cn=IDtoDocunet,cn=Driver Set v3,ou=DirXML,ou=Services,o=SWA-ID......OBJECT NOT FOUND
Validating access to driverDN object: cn=IDtoDocunet,cn=Driver Set v3,ou=DirXML,ou=Services,o=SWA-ID......UNABLE TO READ ATTRIBUTES
Validating Config Path: final/PROD/IDtoDocunet.xml....VALID
Validating impersonationUserDn template: cn=ax266698,ou=Admins,o=SWA-ID.....value: cn=ax266698,ou=Admins,o=SWA-ID.....[LDAP: error code 50 - NDS error: no access (-672)]

> Task :validateEnvironmentFile FAILED

FAILURE: Build failed with an exception.

* Where:
Script 'C:\work\IDtoDocunet\idm-common\build-main.gradle' line: 820

* What went wrong:
Execution failed for task ':validateEnvironmentFile'.
> javax.naming.NoPermissionException: [LDAP: error code 50 - NDS error: no access (-672)]; remaining name 'cn=ax266698,ou=Admins,o=SWA-ID'

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
> Get more help at https://help.gradle.org.

BUILD FAILED in 4s
1 actionable task: 1 executed

x266698@SY4-HW2XSQ3 MINGW64 /c/work/IDtoDocunet (kyle)
$          


./gradlew ${GRADLE_OPTS:---stacktrace} validateEnvironmentFile compare --warning-mode all -PENVIRONMENT=dev -PDEPLOY_ENVIRONMENT=dev
