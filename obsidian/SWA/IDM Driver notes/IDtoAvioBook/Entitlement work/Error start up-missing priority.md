
```
[06/06/24 18:19:46.160]:RBEAEv1 :Reading driver information from the \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\RBEAEv1 object.
[06/06/24 18:19:46.161]:RBEAEv1 :Reading named passwords list.
[06/06/24 18:19:46.161]:RBEAEv1 :Description : IDMNotifications
[06/06/24 18:19:46.162]:RBEAEv1 :Named passwords:
[06/06/24 18:19:46.162]:RBEAEv1 :  Name: IDMNotifications
[06/06/24 18:19:46.162]:RBEAEv1 :Reading XML attribute vnd.nds.stream://DEV_SWACO_ID/swaiddev/Services/DirXML/Driver+Set+AEv1/RBEAEv1#DirXML-EngineControlValues.
[06/06/24 18:19:46.165]:RBEAEv1 :Reading XML attribute vnd.nds.stream://DEV_SWACO_ID/swaiddev/Services/DirXML/Driver+Set+AEv1/NOVLACOMSET-GCVs#DirXML-ConfigValues.
[06/06/24 18:19:46.167]:RBEAEv1 :Reading XML attribute vnd.nds.stream://DEV_SWACO_ID/swaiddev/Services/DirXML/Driver+Set+AEv1#DirXML-ConfigValues.
[06/06/24 18:19:46.168]:RBEAEv1 :Global Configuration Values:
[06/06/24 18:19:46.168]:RBEAEv1 :  Name: idv.dit.data.users Value: swaiddev\Users
[06/06/24 18:19:46.168]:RBEAEv1 :  Name: idv.dit.data.svcaccts Value: swaiddev\ServiceAccounts
[06/06/24 18:19:46.168]:RBEAEv1 :  Name: idv.dit.data.groups Value: swaiddev\Groups
[06/06/24 18:19:46.168]:RBEAEv1 :  Name: smtp.swacorp.com Value: smtp.swacorp.com
[06/06/24 18:19:46.169]:RBEAEv1 :  Name: UAProvURL Value: https://idmua.cis.dev.swacorp.com/IDMProv
[06/06/24 18:19:46.169]:RBEAEv1 :  Name: UAProvAdmin Value: CN=uaadmin.OU=UASA.O=swaiddev
[06/06/24 18:19:46.169]:RBEAEv1 :  Name: service-account-dn Value: cn=ediruaadmin,ou=robotics,o=swaiddev
[06/06/24 18:19:46.170]:RBEAEv1 :  Name: dirxml.auto.treename Value: DEV_SWACO_ID
[06/06/24 18:19:46.170]:RBEAEv1 :  Name: dirxml.auto.driverdn Value: \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\RBEAEv1
[06/06/24 18:19:46.170]:RBEAEv1 :  Name: dirxml.auto.driverguid Value: {9A0D78BE-05C7-42bf-86A7-BE780D9AC705}
[06/06/24 18:19:46.170]:RBEAEv1 :  Name: dirxml.auto.localserverdn Value: CN=w11dcledirdi019,OU=Services,O=swaiddev
[06/06/24 18:19:46.171]:RBEAEv1 :Using default reciprocal attribute map
[06/06/24 18:19:46.171]:RBEAEv1 :Reading XML attribute vnd.nds.stream://DEV_SWACO_ID/swaiddev/Services/DirXML/Driver+Set+AEv1/RBEAEv1#DirXML-PersistentData.
[06/06/24 18:19:46.172]:RBEAEv1 :Loaded persistent data
[06/06/24 18:19:46.172]:RBEAEv1 :
<persistent-data>
  <op-counters last-reset-time="1711391363738">
    <subscriber>
      <counters index="0">
        <modify>50175</modify>
        <add>13704</add>
        <sync>142353</sync>
        <delete>7893</delete>
        <rename>2</rename>
      </counters>
      <counters index="1">
        <modify>50174</modify>
        <add>13703</add>
        <sync>142353</sync>
        <delete>7881</delete>
        <rename>2</rename>
      </counters>
      <counters index="2">
        <modify>50345</modify>
        <add>155885</add>
        <delete>7779</delete>
        <rename>2</rename>
      </counters>
      <counters index="3">
        <modify>50345</modify>
        <add>155885</add>
        <delete>7779</delete>
        <rename>2</rename>
      </counters>
      <counters index="4">
        <status>214011</status>
        <add-association>155867</add-association>
      </counters>
    </subscriber>
    <publisher/>
  </op-counters>
</persistent-data>
[06/06/24 18:19:46.184]:RBEAEv1 :Found subscriber swaiddev\Services\DirXML\Driver Set AEv1\RBEAEv1\Subscriber.
[06/06/24 18:19:46.195]:RBEAEv1 :Found publisher swaiddev\Services\DirXML\Driver Set AEv1\RBEAEv1\Publisher.
[06/06/24 18:19:46.196]:RBEAEv1 :Reading XML attribute vnd.nds.stream://DEV_SWACO_ID/swaiddev/Services/DirXML/Driver+Set+AEv1/RBEAEv1#DirXML-DriverFilter.
[06/06/24 18:19:46.197]:RBEAEv1 :Loaded filter.
[06/06/24 18:19:46.197]:RBEAEv1 :
<filter>
  <filter-class class-name="User" publisher="ignore" publisher-create-homedir="false" publisher-track-template-member="false" subscriber="sync">
    <filter-attr attr-name="swaTitleCode" merge-authority="edir" publisher="ignore" publisher-optimize-modify="false" subscriber="sync"/>
    <filter-attr attr-name="Object Class" merge-authority="edir" publisher="ignore" publisher-optimize-modify="false" subscriber="sync"/>
  </filter-class>
  <filter-class class-name="DirXML-SharedProfile" publisher="ignore" publisher-create-homedir="false" publisher-track-template-member="false" subscriber="sync">
    <filter-attr attr-name="Member" merge-authority="edir" publisher="ignore" publisher-optimize-modify="false" subscriber="sync"/>
    <filter-attr attr-name="excludedMember" merge-authority="edir" publisher="ignore" publisher-optimize-modify="false" subscriber="sync"/>
  </filter-class>
</filter>
[06/06/24 18:19:46.200]:RBEAEv1 :Creating subscriber thread.
[06/06/24 18:19:46.288]:RBEAEv1 ST:Subscriber thread starting.
[06/06/24 18:19:46.560]:RBEAEv1 ST:Initializing driver shim.
[06/06/24 18:19:46.560]:RBEAEv1 ST:Reading XML attribute vnd.nds.stream://DEV_SWACO_ID/swaiddev/Services/DirXML/Driver+Set+AEv1/RBEAEv1#DirXML-ApplicationSchema.
[06/06/24 18:19:46.561]:RBEAEv1 ST:Reading XML attribute vnd.nds.stream://DEV_SWACO_ID/swaiddev/Services/DirXML/Driver+Set+AEv1/RBEAEv1#DirXML-ConfigManifest.
[06/06/24 18:19:46.562]:RBEAEv1 ST:Loading Java shim com.novell.nds.dirxml.driver.entitlement.EntitlementServiceDriver.
[06/06/24 18:19:46.563]:RBEAEv1 ST:Reading XML attribute vnd.nds.stream://DEV_SWACO_ID/swaiddev/Services/DirXML/Driver+Set+AEv1/RBEAEv1#DirXML-ShimConfigInfo.
[06/06/24 18:19:46.563]:RBEAEv1 ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <init-params src-dn="\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\RBEAEv1">
      <driver-options/>
    </init-params>
  </input>
</nds>
[06/06/24 18:19:46.564]:RBEAEv1 ST:connecting to local context...
[06/06/24 18:19:46.565]:RBEAEv1 ST:connected
[06/06/24 18:19:46.565]:RBEAEv1 ST:caching driver and policy info...
[06/06/24 18:19:46.566]:RBEAEv1 ST:caching sibling driver info...
[06/06/24 18:19:46.566]:RBEAEv1 ST:     EmployeeServicesRoleMgmtDriver
[06/06/24 18:19:46.567]:RBEAEv1 ST:             guid:  {914A8D82-CE55-4BD9-AFD4-828D4A9155CE}
[06/06/24 18:19:46.567]:RBEAEv1 ST:     IDtoAtlassianCloud
[06/06/24 18:19:46.568]:RBEAEv1 ST:             guid:  {6FC70A9E-A7CB-45EB-B004-9E0AC76FCBA7}
[06/06/24 18:19:46.568]:RBEAEv1 ST:     IDtoAvioBooks
[06/06/24 18:19:46.569]:RBEAEv1 ST:             guid:  {B13B7AD8-EB75-414E-9885-D87A3BB175EB}
[06/06/24 18:19:46.569]:RBEAEv1 ST:     IDtoAWSIDC
[06/06/24 18:19:46.569]:RBEAEv1 ST:             guid:  {DC8D4A45-DF3F-4710-BFEA-454A8DDC3FDF}
[06/06/24 18:19:46.570]:RBEAEv1 ST:     IDtoCargoPricing
[06/06/24 18:19:46.570]:RBEAEv1 ST:             guid:  {7284CFB4-A81D-4381-AFBA-B4CF84721DA8}
[06/06/24 18:19:46.571]:RBEAEv1 ST:     IDtoCyberArk
[06/06/24 18:19:46.571]:RBEAEv1 ST:             guid:  {44F15CF7-F138-4D89-8C37-F75CF14438F1}
[06/06/24 18:19:46.572]:RBEAEv1 ST:     IDtoDocuWare
[06/06/24 18:19:46.572]:RBEAEv1 ST:             guid:  {3ABDAF0B-0D69-48D7-BD91-0BAFBD3A690D}
[06/06/24 18:19:46.573]:RBEAEv1 ST:     IDtoEmployeeCarePicture
[06/06/24 18:19:46.573]:RBEAEv1 ST:             guid:  {A2D19560-EA2F-4190-8DBB-6095D1A22FEA}
[06/06/24 18:19:46.574]:RBEAEv1 ST:     IDtoEmployeeSvc
[06/06/24 18:19:46.574]:RBEAEv1 ST:             guid:  {D26EF01F-7174-457A-804B-1FF06ED27471}
[06/06/24 18:19:46.575]:RBEAEv1 ST:     IDtoGitLab
[06/06/24 18:19:46.575]:RBEAEv1 ST:             guid:  {E1B416D7-FBEA-4C00-8EE2-D716B4E1EAFB}
[06/06/24 18:19:46.575]:RBEAEv1 ST:     IDtoiManage
[06/06/24 18:19:46.576]:RBEAEv1 ST:             guid:  {2704DE2B-1104-4732-85FF-2BDE04270411}
[06/06/24 18:19:46.576]:RBEAEv1 ST:     IDtoKronos
[06/06/24 18:19:46.576]:RBEAEv1 ST:             guid:  {9BEF712A-5A1D-4F5D-ABF6-2A71EF9B1D5A}
[06/06/24 18:19:46.577]:RBEAEv1 ST:     IDtoMiro
[06/06/24 18:19:46.577]:RBEAEv1 ST:             guid:  {AA1341AD-BC3E-4646-9D1B-AD4113AA3EBC}
[06/06/24 18:19:46.578]:RBEAEv1 ST:     IDtoSAPBrim
[06/06/24 18:19:46.578]:RBEAEv1 ST:             guid:  {67956E1E-1A2D-4315-A0A3-1E6E95672D1A}
[06/06/24 18:19:46.579]:RBEAEv1 ST:     IDtoSlack
[06/06/24 18:19:46.579]:RBEAEv1 ST:             guid:  {4E422EFC-9A81-4785-8D00-FC2E424E819A}
[06/06/24 18:19:46.580]:RBEAEv1 ST:     IDtoSOAR
[06/06/24 18:19:46.580]:RBEAEv1 ST:             guid:  {30115348-CFEE-487A-ADBB-48531130EECF}
[06/06/24 18:19:46.581]:RBEAEv1 ST:     IDtoSprinklr
[06/06/24 18:19:46.581]:RBEAEv1 ST:             guid:  {A5C12BE2-D83F-4347-A9CB-E22BC1A53FD8}
[06/06/24 18:19:46.582]:RBEAEv1 ST:     IDtoWFM
[06/06/24 18:19:46.582]:RBEAEv1 ST:             guid:  {CBA270A7-7525-413D-97F2-A770A2CB2575}
[06/06/24 18:19:46.582]:RBEAEv1 ST:     IDtoWiseLeap
[06/06/24 18:19:46.583]:RBEAEv1 ST:             guid:  {4FBA79B9-9EC5-4A8D-87B4-B979BA4FC59E}
[06/06/24 18:19:46.583]:RBEAEv1 ST:     RBEAEv1
[06/06/24 18:19:46.583]:RBEAEv1 ST:             guid:  {9A0D78BE-05C7-42BF-86A7-BE780D9AC705}
[06/06/24 18:19:46.584]:RBEAEv1 ST:     Role and Resource driver
[06/06/24 18:19:46.584]:RBEAEv1 ST:             guid:  {491CB2EB-E34D-4535-8A18-EBB21C494DE3}
[06/06/24 18:19:46.585]:RBEAEv1 ST:     RoleManagementDriver
[06/06/24 18:19:46.585]:RBEAEv1 ST:             guid:  {140C4B71-FA42-4D26-AA1A-714B0C1442FA}
[06/06/24 18:19:46.586]:RBEAEv1 ST:     Test Resource Assignment
[06/06/24 18:19:46.586]:RBEAEv1 ST:             guid:  {86D20CD6-BC62-4E33-A33E-D60CD28662BC}
[06/06/24 18:19:46.587]:RBEAEv1 ST:     User Application Driver
[06/06/24 18:19:46.587]:RBEAEv1 ST:             guid:  {9CD7D56E-0EB6-4465-9B00-6ED5D79CB60E}
[06/06/24 18:19:46.588]:RBEAEv1 ST:     zApproved
[06/06/24 18:19:46.588]:RBEAEv1 ST:             guid:  {FD765563-4ED2-4BDE-A1DE-635576FDD24E}
[06/06/24 18:19:46.589]:RBEAEv1 ST:number of drivers cached:  24
[06/06/24 18:19:46.589]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoKronos'...
[06/06/24 18:19:46.590]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoAWSIDC'...
[06/06/24 18:19:46.590]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoiManage'...
[06/06/24 18:19:46.591]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoSAPBrim'...
[06/06/24 18:19:46.591]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoSlack'...
[06/06/24 18:19:46.592]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoSprinklr'...
[06/06/24 18:19:46.592]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\User Application Driver'...
[06/06/24 18:19:46.593]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoSOAR'...


[06/06/24 18:19:46.593]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoSOAR'...
[06/06/24 18:19:46.594]:RBEAEv1 ST:     SWAReporting-SOAR
[06/06/24 18:19:46.594]:RBEAEv1 ST:             guid:  {D0FE5615-AB20-4AD6-AEB7-1556FED020AB}
[06/06/24 18:19:46.594]:RBEAEv1 ST:             entitlement: SWAReporting-SOAR
[06/06/24 18:19:46.595]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\EmployeeServicesRoleMgmtDriver'...
[06/06/24 18:19:46.595]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoAtlassianCloud'...
[06/06/24 18:19:46.596]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoWFM'...
[06/06/24 18:19:46.596]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\zApproved'...
[06/06/24 18:19:46.597]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoDocuWare'...
[06/06/24 18:19:46.597]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoWiseLeap'...
[06/06/24 18:19:46.598]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\Test Resource Assignment'...
[06/06/24 18:19:46.598]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoCargoPricing'...
[06/06/24 18:19:46.599]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoCyberArk'...
[06/06/24 18:19:46.599]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoGitLab'...
[06/06/24 18:19:46.600]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\RoleManagementDriver'...
[06/06/24 18:19:46.600]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoMiro'...
[06/06/24 18:19:46.601]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoAvioBooks'...
[06/06/24 18:19:46.602]:RBEAEv1 ST:     SWA AvioBook Role
[06/06/24 18:19:46.602]:RBEAEv1 ST:             guid:  {B1CF5796-BE3D-499B-8998-9657CFB13DBE}
[06/06/24 18:19:46.602]:RBEAEv1 ST:             entitlement: SWA AvioBook Role
[06/06/24 18:19:46.603]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoEmployeeSvc'...
[06/06/24 18:19:46.603]:RBEAEv1 ST:     SFLicense
[06/06/24 18:19:46.603]:RBEAEv1 ST:             guid:  {45F7B0BC-EA20-49A8-8B08-BCB0F74520EA}
[06/06/24 18:19:46.604]:RBEAEv1 ST:             entitlement: SFLicense
[06/06/24 18:19:46.604]:RBEAEv1 ST:     SFProfile
[06/06/24 18:19:46.604]:RBEAEv1 ST:             guid:  {BF4673F7-E4A0-46BE-952B-F77346BFA0E4}
[06/06/24 18:19:46.605]:RBEAEv1 ST:             entitlement: SFProfile
[06/06/24 18:19:46.605]:RBEAEv1 ST:     SFRole
[06/06/24 18:19:46.605]:RBEAEv1 ST:             guid:  {ED385F3A-B2E0-495D-BDCD-3A5F38EDE0B2}
[06/06/24 18:19:46.606]:RBEAEv1 ST:             entitlement: SFRole
[06/06/24 18:19:46.606]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\IDtoEmployeeCarePicture'...
[06/06/24 18:19:46.607]:RBEAEv1 ST:caching entitlements for driver 'swaiddev\Services\DirXML\Driver Set AEv1\Role and Resource driver'...
[06/06/24 18:19:46.607]:RBEAEv1 ST:caching entitlement policy info...
[06/06/24 18:19:46.608]:RBEAEv1 ST:     SwaReportingTest
[06/06/24 18:19:46.608]:RBEAEv1 ST:             guid:  {651796FD-C5C3-4C52-8FCE-FD961765C3C5}
[06/06/24 18:19:46.608]:RBEAEv1 ST:             entitlement ref:  Syntax=SYNTAX_PATH, attributename=DirXML-EntitlementRef, volumeDN=swaiddev\Services\DirXML\Driver Set AEv1\IDtoSOAR\SWAReporting-SOAR, volumePath=<ref/>, nameSpace=0
[06/06/24 18:19:46.609]:RBEAEv1 ST:             number of entitlement refs:  1
[06/06/24 18:19:46.609]:RBEAEv1 ST:             membership query:  Syntax=SYNTAX_OCTET_STRING, attributeName=memberQuery, octetString=[B@55e42c6b, length=228
[06/06/24 18:19:46.610]:RBEAEv1 ST:     SWA Reporting S&S Management Pilot
[06/06/24 18:19:46.610]:RBEAEv1 ST:             guid:  {74C27821-7420-4FE0-9D1E-2178C2742074}
[06/06/24 18:19:46.610]:RBEAEv1 ST:             entitlement ref:  Syntax=SYNTAX_PATH, attributename=DirXML-EntitlementRef, volumeDN=swaiddev\Services\DirXML\Driver Set AEv1\IDtoSOAR\SWAReporting-SOAR, volumePath=<ref/>, nameSpace=0
[06/06/24 18:19:46.611]:RBEAEv1 ST:             number of entitlement refs:  1
[06/06/24 18:19:46.611]:RBEAEv1 ST:             membership query:  Syntax=SYNTAX_OCTET_STRING, attributeName=memberQuery, octetString=[B@51dbb20f, length=292
[06/06/24 18:19:46.612]:RBEAEv1 ST:     avio_pilot
[06/06/24 18:19:46.612]:RBEAEv1 ST:             guid:  {B5FCC719-D9C7-48F0-8132-19C7FCB5C7D9}
[06/06/24 18:19:46.613]:RBEAEv1 ST:             entitlement ref:  Syntax=SYNTAX_PATH, attributename=DirXML-EntitlementRef, volumeDN=swaiddev\Services\DirXML\Driver Set AEv1\IDtoAvioBooks\SWA AvioBook Role, volumePath=<ref/>, nameSpace=0
[06/06/24 18:19:46.613]:RBEAEv1 ST:             number of entitlement refs:  1
[06/06/24 18:19:46.614]:RBEAEv1 ST:             membership query:  Syntax=SYNTAX_OCTET_STRING, attributeName=memberQuery, octetString=[B@14d92650, length=292
[06/06/24 18:19:46.614]:RBEAEv1 ST:number of policies cached:  3
[06/06/24 18:19:46.615]:RBEAEv1 ST:policy priorities:
[06/06/24 18:19:46.615]:RBEAEv1 ST:     0, 'SwaReportingTest'
[06/06/24 18:19:46.615]:RBEAEv1 ST:     1, 'SWA Reporting S&S Management Pilot'
[06/06/24 18:19:46.615]:RBEAEv1 ST:freeing local context...
[06/06/24 18:19:46.615]:RBEAEv1 ST:freed
[06/06/24 18:19:46.616]:RBEAEv1 ST:DriverShim.init() returned:
[06/06/24 18:19:46.616]:RBEAEv1 ST:
<nds dtdversion="3.0">
  <source>
    <product build="20190823_0344" instance="\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\RBEAEv1" version="4.0.0.0">DirXML Entitlement Service Driver</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <status level="fatal" type="driver-status">
      <description>No priority defined for at least one Entitlement Policy.</description>
      <document xml:space="preserve">&lt;nds dtdversion="4.0" ndsversion="8.x">
        &lt;source>
                &lt;product edition="Advanced" version="4.8.6.0000">DirXML&lt;/product>
                &lt;contact>NetIQ Corporation&lt;/contact>
        &lt;/source>
        &lt;input>
                &lt;init-params src-dn="\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\RBEAEv1">
                        &lt;driver-options/>
                &lt;/init-params>
        &lt;/input>
&lt;/nds></document>
    </status>
  </output>
</nds>
[06/06/24 18:19:46.618]:RBEAEv1 ST:
DirXML Log Event -------------------
     Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\RBEAEv1
     Status:   Fatal
     Message:  <description>No priority defined for at least one Entitlement Policy.</description>
<document xml:space="preserve">&lt;nds dtdversion="4.0" ndsversion="8.x">
        &lt;source>
                &lt;product edition="Advanced" version="4.8.6.0000">DirXML&lt;/product>
                &lt;contact>NetIQ Corporation&lt;/contact>
        &lt;/source>
        &lt;input>
                &lt;init-params src-dn="\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\RBEAEv1">
                        &lt;driver-options/>
                &lt;/init-params>
        &lt;/input>
&lt;/nds></document>
[06/06/24 18:19:46.621]:RBEAEv1 ST:
DirXML Log Event -------------------
     Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\RBEAEv1
     Status:   Fatal
     Message:  Code(-9005) The driver returned a "fatal" status indicating that the driver should be shut down. Detail from driver: <description>No priority defined for at least one Entitlement Policy.</description>
<document xml:space="preserve">&lt;nds dtdversion="4.0" ndsversion="8.x">
        &lt;source>
                &lt;product edition="Advanced" version="4.8.6.0000">DirXML&lt;/product>
                &lt;contact>NetIQ Corporation&lt;/contact>
        &lt;/source>
        &lt;input>
                &lt;init-params src-dn="\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\RBEAEv1">
                        &lt;driver-options/>
                &lt;/init-params>
        &lt;/input>
&lt;/nds></document>
<application>DirXML</application>
<module>RBEAEv1</module>
<object-dn></object-dn>
<component>DirXML Engine</component>
[06/06/24 18:19:46.625]:RBEAEv1 ST:Driver terminated.
[06/06/24 18:19:46.625]:RBEAEv1 ST:Writing XML attribute vnd.nds.stream://DEV_SWACO_ID/swaiddev/Services/DirXML/Driver+Set+AEv1/RBEAEv1#DirXML-PersistentData.

```

Added this DirXML-SPPriority:

![[Pasted image 20240606172655.png]]