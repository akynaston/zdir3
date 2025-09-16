2/16/2024 10:09:41 AM

Issue with AC 11: the user is becoming active while still associated!

```
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <modify cached-time="20240216164635.282Z" class-name="User" event-id="w11dcledirdi014#20240216164635#9#1:cc08a209-021e-4998-b7f8-09a208cc1e02" qualified-src-dn="O=swaiddev\OU=Users\CN=e199911387" src-dn="\DEV_SWACO_ID\swaidd
ev\Users\e199911387" src-entry-id="1055983" timestamp="1708101995#2">
      <association state="associated">e199911387</association>
      <modify-attr attr-name="swaStatus">
        <remove-value>
          <value timestamp="1708101974#2" type="string">T</value>
        </remove-value>
        <add-value>
          <value timestamp="1708101995#2" type="string">A</value>
        </add-value>
      </modify-attr>
    </modify>
  </input>
</nds>

```

I created a new test, AC-11-NoAssociationOnActivation that will remove the AlteaOfficeDBtoID association before changing the status back to A; to see if we can reproduce the issue.

 - original test passed immediately.
 -

```

<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <modify cached-time="20240216174453.380Z" class-name="User" event-id="w11dcledirdi014#20240216174453#9#1:12471d6b-8f5b-47b3-9c39-6b1d47125b8f" qualified-src-dn="O=swaiddev\OU=Users\CN=e299911989" src-dn="\DEV_SWACO_ID\swaiddev\U
sers\e299911989" src-entry-id="1055996" timestamp="1708105493#2">
      <modify-attr attr-name="swaStatus">
        <remove-value>
          <value timestamp="1708105470#2" type="string">T</value>
        </remove-value>
        <add-value>
          <value timestamp="1708105493#2" type="string">A</value>
        </add-value>
      </modify-attr>
    </modify>
  </input>
</nds>

```

The test does not seem to show an error . .
 - jsut found that Brandon Bennett sent a sync through at 9:24 on 2/16, and  . . .
 - it found his arbac attrs:
 ```
 <nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <instance class-name="User" qualified-src-dn="O=SWA-ID\OU=Users\CN=e188529" src-dn="\SWACO_ID\SWA-ID\Users\e188529" src-entry-id="1633065">
      <attr attr-name="CN">
        <value naming="true" timestamp="1705415414#115" type="string">e188529</value>
      </attr>
      <attr attr-name="swaDeptCode">
        <value timestamp="1705415414#67" type="string">03</value>
      </attr>
      <attr attr-name="swaLocation">
        <value timestamp="1705415414#60" type="string">ELP</value>
      </attr>
      <attr attr-name="swaTitleCode">
        <value timestamp="1705415415#58" type="string">CS01</value>
      </attr>
    </instance>
    <status level="success"></status>
  </output>
</nds>

```
- Found his office id:
- ELPWN01GC

Successful add of the swaAlteaOfficeID, along with the clearing of the supplemental data:
```<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <modify class-name="User" dest-dn="\SWACO_ID\SWA-ID\Users\e188529" dest-entry-id="1633065" event-id="w11pcledirpi011#20240216152403#99#1:d01fea85-a79c-46ad-8304-85ea1fd09ca7">
      <modify-attr attr-name="swaAlteaOfficeID">
        <remove-all-values/>
        <add-value>
          <value type="string">ELPWN01GC</value>
        </add-value>
      </modify-attr>
      <modify-attr attr-name="swaAlteaSuppOfficeID">
        <remove-all-values/>
      </modify-attr>
      <modify-attr attr-name="swaAlteaSuppOfficeRevocationData">
        <remove-all-values/>
      </modify-attr>
    </modify>
  </input>
</nds>
[02/16/24 09:24:04.130]:AlteaOfficeDBtoID ST:  Pumping XDS to eDirectory.
[02/16/24 09:24:04.130]:AlteaOfficeDBtoID ST:  Performing operation modify for \SWACO_ID\SWA-ID\Users\e188529.
[02/16/24 09:24:04.130]:AlteaOfficeDBtoID ST:  --JCLNT-- \SWACO_ID\SWA-ID\Services\DirXML\SDC Driver Set\AlteaOfficeDBtoID : Duplicating : context = 2038235355, tempContext = 2038235558
[02/16/24 09:24:04.132]:AlteaOfficeDBtoID ST:  Modifying entry \SWACO_ID\SWA-ID\Users\e188529.
[02/16/24 09:24:04.142]:AlteaOfficeDBtoID ST:  --JCLNT-- \SWACO_ID\SWA-ID\Services\DirXML\SDC Driver Set\AlteaOfficeDBtoID : Calling free on tempContext = 2038235558
[02/16/24 09:24:04.143]:AlteaOfficeDBtoID ST:  Processing returned document.
[02/16/24 09:24:04.143]:AlteaOfficeDBtoID ST:  Processing operation <status> for .
[02/16/24 09:24:04.144]:AlteaOfficeDBtoID ST:
DirXML Log Event -------------------
     Driver:   \SWACO_ID\SWA-ID\Services\DirXML\SDC Driver Set\AlteaOfficeDBtoID
     Channel:  Subscriber
     Status:   Success

```

![[Pasted image 20240216105252.png]]

2/16/2024 10:54:07 AM - reported to Joe that maybe Brandon didn't wait for replication . .?
