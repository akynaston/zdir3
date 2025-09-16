maybe add to our gradle builds to avoid using later versions of java: 

if(JavaVersion.current() != JavaVersion.VERSION_1_8){
    throw new GradleException("current: "  + JavaVersion.current() )
    
    

 - testing latest updates - really just NEXUS_REPO driver.sh list to see the latest, then 'update'
    0.0.1-CSIGA-5599-ac1d870 should be ready to test
    export NEXUS_REPO=dev
    then ./driver.sh update


Example of local jars:
dependencies {
    testImplementation 'xmlunit:xmlunit:1.6'
//    implementation files('libs/WorkdayShim.jar')
//    implementation files('libs/WorkdayUtil.jar')

    standardsConfig("com.swacorp.csiam.idm:IDMDriverTemplateRepo:${standardsVersion}")


```

    implementation files('C:\Users\x266698\Downloads\ldap-jldap\ldap-1.0.0.jar')
```

Example to exclude something built into the standard:
```
dependencies {  
    standardsConfig("com.swacorp.csiam.idm:IDMDriverTemplateRepo:${standardsVersion}") {  
        // TODO: exclude dtf connector; to use the new one instead . .  
        exclude group: 'com.swa.idmunit.connector', module: 'idm-unit-dtf-connector'  
    }  
    implementation files('C:\Users\x266698\Downloads\ldap-jldap\ldap-1.0.0.jar')
}
```


Force specific version
configurations.all {
    resolutionStrategy {
        force 'com.swa.idmunit.connector:scim-connector:0.0.1-CSEE-2947-4b91902'
    }
}

dependencies {
    standardsConfig("com.swacorp.csiam.idm:IDMDriverTemplateRepo:${standardsVersion}")
    implementation('com.swa.idmunit.connector:scim-connector:0.0.1-CSEE-2947-4b91902')
}


9/29/2023 10:16:17 AM
  

deprecatoin warning in gradle:

> Configure project :
Script 'C:\work\IDtoMiro\idm-common\build-main.gradle': line 63
The org.gradle.api.plugins.JavaPluginConvention type has been deprecated. This is scheduled to be removed in Gradle 9.0. Consult the upgrading guide for further info
rmation: https://docs.gradle.org/8.3/userguide/upgrading_version_8.html#java_convention_deprecation
        at build_main_138398zupiqhfucvo6ju0e43i.run(C:\work\IDtoMiro\idm-common\build-main.gradle:63)
        (Run with --stacktrace to get the full stack trace of this deprecation warning.)
        at build_2ylwpfp9992k6ak3wphbj9vrv.run(C:\work\IDtoMiro\build.gradle:62)
        (Run with --stacktrace to get the full stack trace of this deprecation warning.)
Script 'C:\work\IDtoMiro\idm-common\build-main.gradle': line 63
The org.gradle.api.plugins.Convention type has been deprecated. This is scheduled to be removed in Gradle 9.0. Consult the upgrading guide for further information: h
ttps://docs.gradle.org/8.3/userguide/upgrading_version_8.html#deprecated_access_to_conventions
        at build_main_138398zupiqhfucvo6ju0e43i.run(C:\work\IDtoMiro\idm-common\build-main.gradle:63)
        (Run with --stacktrace to get the full stack trace of this deprecation warning.)
        at build_2ylwpfp9992k6ak3wphbj9vrv.run(C:\work\IDtoMiro\build.gradle:62)
        (Run with --stacktrace to get the full stack trace of this deprecation warning.)
Script 'C:\work\IDtoMiro\idm-common\build-main.gradle': line 64
The org.gradle.api.plugins.JavaPluginConvention type has been deprecated. This is scheduled to be removed in Gradle 9.0. Consult the upgrading guide for further info
rmation: https://docs.gradle.org/8.3/userguide/upgrading_version_8.html#java_convention_deprecation
        at build_main_138398zupiqhfucvo6ju0e43i.run(C:\work\IDtoMiro\idm-common\build-main.gradle:64)
        (Run with --stacktrace to get the full stack trace of this deprecation warning.)
        at build_2ylwpfp9992k6ak3wphbj9vrv.run(C:\work\IDtoMiro\build.gradle:62)
        (Run with --stacktrace to get the full stack trace of this deprecation warning.)
Script 'C:\work\IDtoMiro\idm-common\build-main.gradle': line 64
The org.gradle.api.plugins.Convention type has been deprecated. This is scheduled to be removed in Gradle 9.0. Consult the upgrading guide for further information: h
ttps://docs.gradle.org/8.3/userguide/upgrading_version_8.html#deprecated_access_to_conventions
        at build_main_138398zupiqhfucvo6ju0e43i.run(C:\work\IDtoMiro\idm-common\build-main.gradle:64)
        (Run with --stacktrace to get the full stack trace of this deprecation warning.)
        at build_2ylwpfp9992k6ak3wphbj9vrv.run(C:\work\IDtoMiro\build.gradle:62)
        (Run with --stacktrace to get the full stack trace of this deprecation warning.)
Gradle Version: Gradle 8.3
Groovy Version: 3.0.17
Java Location: C:\Users\x266698\.jdks\azul-1.8.0_382
Using IGA Standard: 2.2.0




EncTool: decript passwords with Gradle
C:\work\IDtoMiro>gradlew -PENC_KEY=IDMUNIT1 -PENC_PASS=ccKZT5eaVCPPbNhPIFvW5Q== decryptPassword
 

> Configure project :
Gradle Version: Gradle 8.3
Groovy Version: 3.0.17
Java Location: C:\Users\x266698\.jdks\azul-1.8.0_382
Using IGA Standard: 2.2.5

 

> Task :decryptPassword
Using Encryption Key: IDMUNIT1
Decrypted Password: idv_user99

 

BUILD SUCCESSFUL in 1s
1 actionable task: 1 executed
C:\work\IDtoMiro>