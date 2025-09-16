8/22/2023 10:00:55 AM
This is how you exclude stuff from the build.gradle when you need to use a different version

    implementation("com.swacorp.csiam.idm:swa-idm-unit:${swaIdmUnitVersion}") {
        exclude group: 'com.swa.idmunit.connector', module: 'swa-idmunit-rest-connector'
    }

Then put this in when you have the dev version built

    implementation 'com.swa.idmunit.connector:swa-idmunit-rest-connector:0.0.1-CSEE-2835-45ec8c8'
