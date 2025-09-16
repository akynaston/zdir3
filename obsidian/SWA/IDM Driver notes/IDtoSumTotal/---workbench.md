8/30/2024 5:19:53 PM

did associatoin work with John mapes today:



dn: cn=e79100,ou=Users,o=SWA-ID
changetype: modify
add: DirXML-Associations
DirXML-Associations: cn=   sumtotal . . .,cn=Driver Set v3,ou=DirXML,ou=Services,o=SWA-ID#4#



Caused by: org.gradle.internal.resolve.ModuleVersionNotFoundException: Could not find com.swa.idmunit.connector:swa-idmunit-rest-connector:0.0.1-CSEE-4023-def9a7a.
Searched in the following locations:
  - https://nexus-tools.swacorp.com/repository/releases/com/swa/idmunit/connector/swa-idmunit-rest-connector/0.0.1-CSEE-4023-def9a7a/swa-idmunit-rest-connector-0.0.1-CSEE-4023-def9a7a.pom
  - https://nexus-tools.swacorp.com/repository/thirdparty/com/swa/idmunit/connector/swa-idmunit-rest-connector/0.0.1-CSEE-4023-def9a7a/swa-idmunit-rest-connector-0.0.1-CSEE-4023-def9a7a.pom
  - https://repo.maven.apache.org/maven2/com/swa/idmunit/connector/swa-idmunit-rest-connector/0.0.1-CSEE-4023-def9a7a/swa-idmunit-rest-connector-0.0.1-CSEE-4023-def9a7a.pom
Required by:
    project :




o=SWA-ID\r\nchangetype: modify\r\nadd: DirXML-Associations\r\nDirXML-Associations: cn=IDtoSumTotal,cn=SDC Driver Set,ou=DirXML,ou=Services,o=SWA-ID#4#



8/30/2024 2:28:42 PM
```
Double sync problem - only difference is security equals is cn=admin,o=swa-id in prod . . .

[08/30/24 15:16:14.055]:IDtoSumTotal ST:Start transaction.
[08/30/24 15:16:14.056]:IDtoSumTotal ST:type(resync-entry)entry-id(85477) dn(\T=SWACO_ID\O=SWA-ID\OU=Users\CN=e103704) class-id(-1) class-name(null)
[08/30/24 15:16:14.058]:IDtoSumTotal ST:Processing events for transaction.
[08/30/24 15:16:14.060]:IDtoSumTotal ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <sync cached-time="20240830201614.012Z" class-name="User" event-id="w11pcledirpi011#20240830201614#99#1:87749cf3-dcda-44e9-890f-f39c7487dadc#0" qualified-src-dn="O=SWA-ID\OU=Users\CN=e103704" src-dn="\SWACO_ID\SWA-ID\Users\e103704" src-entry-id="85477" timestamp="0#0">
      <association state="associated">e103704</association>
    </sync>
    <sync cached-time="20240830201614.012Z" class-name="User" event-id="w11pcledirpi011#20240830201614#99#1:87749cf3-dcda-44e9-890f-f39c7487dadc#1" qualified-src-dn="O=SWA-ID\OU=Users\CN=e103704" src-dn="\SWACO_ID\SWA-ID\Users\e103704" src-entry-id="85477" timestamp="0#0">
      <association state="migrate"></association>
    </sync>
  </input>
</nds>

```
