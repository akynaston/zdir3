4/19/2024 4:19:09 PM
Kyle found it is possible tod o a while card search!



```
[04/19/24 16:51:14.888]:WorkdayDataMaint ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <query class-name="User" dest-dn="SWA-IDALPHA\Users" scope="subtree">
      <search-class class-name="User"/>
      <search-attr attr-name="wd-WorkerIDType">
        <value type="string">Employee_ID</value>
      </search-attr>
      <search-attr attr-name="swaStatus">
        <value type="string">S</value>
      </search-attr>
      <search-attr attr-name="cn">
        <value type="string">e*</value>
      </search-attr>
      <read-attr attr-name="CN"/>
      <read-attr attr-name="swaTerminationDate"/>
    </query>
  </input>
</nds>
[04/19/24 16:51:14.892]:WorkdayDataMaint ST:            Pumping XDS to eDirectory.
[04/19/24 16:51:14.892]:WorkdayDataMaint ST:            Performing operation query for SWA-IDALPHA\Users.
[04/19/24 16:51:14.892]:WorkdayDataMaint ST:            --JCLNT-- \SWACO_IDALPHA\SWA-IDALPHA\Services\DirXML\Driver Set AEv2\WorkdayDataMaint : Duplicating : context = 1458522795, tempContext = 1458531914
[04/19/24 16:51:14.942]:WorkdayDataMaint ST:            --JCLNT-- \SWACO_IDALPHA\SWA-IDALPHA\Services\DirXML\Driver Set AEv2\WorkdayDataMaint : Calling free on tempContext = 1458531914
[04/19/24 16:51:14.943]:WorkdayDataMaint ST:            Query from policy result
[04/19/24 16:51:14.943]:WorkdayDataMaint ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=e9870469598" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e9870469598" src-entry-id="942536">
      <attr attr-name="CN">
        <value naming="true" timestamp="1713563473#135" type="string">e9870469598</value>
      </attr>
      <attr attr-name="swaTerminationDate">
        <value timestamp="1713563473#98" type="time">1709208000</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=e9870489598" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e9870489598" src-entry-id="942535">
      <attr attr-name="CN">
        <value naming="true" timestamp="1713563473#43" type="string">e9870489598</value>
      </attr>
      <attr attr-name="swaTerminationDate">
        <value timestamp="1713563473#6" type="time">1713092400</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=e170657" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e170657" src-entry-id="855038">
      <attr attr-name="CN">
        <value naming="true" timestamp="1689034086#141" type="string">e170657</value>
      </attr>
      <attr attr-name="swaTerminationDate">
        <value timestamp="1710416640#21" type="time">1709856000</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=e165571" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e165571" src-entry-id="833216">
      <attr attr-name="CN">
        <value naming="true" timestamp="1667952019#147" type="string">e165571</value>
      </attr>
      <attr attr-name="swaTerminationDate">
        <value timestamp="1712779135#22" type="time">1712620800</value>
      </attr>
    </instance>
    <status level="success"></status>
  </output>
</nds>
```

```
[04/19/24 16:55:37.359]:WorkdayDataMaint ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <query class-name="User" dest-dn="SWA-IDALPHA\Users" scope="subtree">
      <search-class class-name="User"/>
      <search-attr attr-name="wd-WorkerIDType">
        <value type="string">Employee_ID</value>
      </search-attr>
      <search-attr attr-name="swaStatus">
        <value type="string">S</value>
      </search-attr>
      <search-attr attr-name="cn">
        <value type="string">r*</value>
      </search-attr>
      <read-attr attr-name="CN"/>
      <read-attr attr-name="swaTerminationDate"/>
    </query>
  </input>
</nds>
[04/19/24 16:55:37.363]:WorkdayDataMaint ST:            Pumping XDS to eDirectory.
[04/19/24 16:55:37.363]:WorkdayDataMaint ST:            Performing operation query for SWA-IDALPHA\Users.
[04/19/24 16:55:37.364]:WorkdayDataMaint ST:            --JCLNT-- \SWACO_IDALPHA\SWA-IDALPHA\Services\DirXML\Driver Set AEv2\WorkdayDataMaint : Duplicating : context = 1458511729, tempContext = 1458534045
[04/19/24 16:55:39.837]:WorkdayDataMaint ST:            --JCLNT-- \SWACO_IDALPHA\SWA-IDALPHA\Services\DirXML\Driver Set AEv2\WorkdayDataMaint : Calling free on tempContext = 1458534045
[04/19/24 16:55:39.839]:WorkdayDataMaint ST:            Query from policy result
[04/19/24 16:55:39.895]:WorkdayDataMaint ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=r34738" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\r34738" src-entry-id="906051">
      <attr attr-name="CN">
        <value naming="true" timestamp="1698833160#64" type="string">r34738</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=r81065" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\r81065" src-entry-id="877204">
      <attr attr-name="CN">
        <value naming="true" timestamp="1698709932#72" type="string">r81065</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=r35477" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\r35477" src-entry-id="876950">
      <attr attr-name="CN">
        <value naming="true" timestamp="1698551625#115" type="string">r35477</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=r105055" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\r105055" src-entry-id="853541">
      <attr attr-name="CN">
        <value naming="true" timestamp="1688908592#79" type="string">r105055</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=r94405" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\r94405" src-entry-id="853307">
      <attr attr-name="CN">
        <value naming="true" timestamp="1688879132#60" type="string">r94405</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=r9999" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\r9999" src-entry-id="828294">
      <attr attr-name="CN">
        <value naming="true" timestamp="1664848632#76" type="string">r9999</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=r99894" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\r99894" src-entry-id="828284">
      <attr attr-name="CN">
        <value naming="true" timestamp="1664848619#72" type="string">r99894</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=r99856" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\r99856" src-entry-id="828278">
      <attr attr-name="CN">
        <value naming="true" timestamp="1664848610#70" type="string">r99856</value>
      </attr>
    </instance>
```

```
[04/19/24 17:13:44.463]:WorkdayDataMaint ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <query class-name="User" dest-dn="SWA-IDALPHA\Users" scope="subtree">
      <search-class class-name="User"/>
      <search-attr attr-name="cn">
        <value type="string">e1679*</value>
      </search-attr>
      <read-attr attr-name="CN"/>
      <read-attr attr-name="fullName"/>
    </query>
  </input>
</nds>
[04/19/24 17:13:44.466]:WorkdayDataMaint ST:            Pumping XDS to eDirectory.
[04/19/24 17:13:44.467]:WorkdayDataMaint ST:            Performing operation query for SWA-IDALPHA\Users.
[04/19/24 17:13:44.467]:WorkdayDataMaint ST:            --JCLNT-- \SWACO_IDALPHA\SWA-IDALPHA\Services\DirXML\Driver Set AEv2\WorkdayDataMaint : Duplicating : context = 1458531914, tempContext = 1458504084
[04/19/24 17:13:44.513]:WorkdayDataMaint ST:            --JCLNT-- \SWACO_IDALPHA\SWA-IDALPHA\Services\DirXML\Driver Set AEv2\WorkdayDataMaint : Calling free on tempContext = 1458504084
[04/19/24 17:13:44.513]:WorkdayDataMaint ST:            Query from policy result
[04/19/24 17:13:44.514]:WorkdayDataMaint ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=e167900" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e167900" src-entry-id="877196">
      <attr attr-name="CN">
        <value naming="true" timestamp="1698685051#32" type="string">e167900</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=e167901" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e167901" src-entry-id="836594">
      <attr attr-name="CN">
        <value naming="true" timestamp="1667955567#136" type="string">e167901</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=e167902" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e167902" src-entry-id="836597">
      <attr attr-name="CN">
        <value naming="true" timestamp="1667955576#134" type="string">e167902</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=e167903" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e167903" src-entry-id="836596">
      <attr attr-name="CN">
        <value naming="true" timestamp="1667955573#139" type="string">e167903</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=e167904" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e167904" src-entry-id="836591">
      <attr attr-name="CN">
        <value naming="true" timestamp="1667955557#135" type="string">e167904</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=e167905" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e167905" src-entry-id="836589">
      <attr attr-name="CN">
        <value naming="true" timestamp="1667955553#131" type="string">e167905</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=e167906" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e167906" src-entry-id="836593">
      <attr attr-name="CN">
        <value naming="true" timestamp="1667955563#132" type="string">e167906</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=e167907" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e167907" src-entry-id="836592">
      <attr attr-name="CN">
        <value naming="true" timestamp="1667955560#114" type="string">e167907</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=e167908" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e167908" src-entry-id="836604">
      <attr attr-name="CN">
        <value naming="true" timestamp="1667955584#112" type="string">e167908</value>
      </attr>
    </instance>
    <instance class-name="User" qualified-src-dn="O=SWA-IDALPHA\OU=Users\CN=e167909" src-dn="\SWACO_IDALPHA\SWA-IDALPHA\Users\e167909" src-entry-id="836603">
      <attr attr-name="CN">
        <value naming="true" timestamp="1667955581#141" type="string">e167909</value>
      </attr>
    </instance>
```