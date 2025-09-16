8/26/2025 4:16:02 PM
Documenting cost of unassociated modify to add:


Start:
```

<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.10.0.0200">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <modify cached-time="20250826221643.639Z" class-name="User" event-id="8452651-8452652:f86fdfa4-33c8-44be-acc5-363dbf467991" qualified-src-dn="O=swaiddev\OU=Users\CN=e172171" src-dn="\DEV_SWACO_ID\swaiddev\Users\e172171" src-entry-id="979382" timestamp="1756246603#8">
      <modify-attr attr-name="swaStatus">
        <remove-value>
          <value timestamp="1742357132#16" type="string">L</value>
        </remove-value>
        <add-value>
          <value timestamp="1756246603#8" type="string">A</value>
        </add-value>
      </modify-attr>
      <operation-data DRIVER_REVISION="1.1.0-CSEE-4989-x266698" objectType="employee"/>
    </modify>
  </input>
</nds>
[08/26/25 17:16:43.776]:IDtoApptioFrontDoor ST:Subscriber processing modify for \DEV_SWACO_ID\swaiddev\Users\e172171.
[08/26/25 17:16:43.777]:IDtoApptioFrontDoor ST:Converting <modify> to <add>
[08/26/25 17:16:43.777]:IDtoApptioFrontDoor ST:Reading relevant attributes from \DEV_SWACO_ID\swaiddev\Users\e172171.

Driver then queries for attributes in the filter, seems to get all subscriber sync . .and possibly subscriber notify (didn't test this)

then immediately shows the 'synthetic add'
[08/26/25 17:16:43.795]:IDtoApptioFrontDoor ST:Synthetic add:
[08/26/25 17:16:43.796]:IDtoApptioFrontDoor ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.10.0.0200">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <add cached-time="20250826221643.639Z" class-name="User" event-id="8452651-8452652:f86fdfa4-33c8-44be-acc5-363dbf467991" qualified-src-dn="O=swaiddev\OU=Users\CN=e172171" src-dn="\DEV_SWACO_ID\swaiddev\Users\e172171" src-entry-id="979382" timestamp="1756246603#8">
      <add-attr attr-name="swaPreferredFullName">
        <value timestamp="1717572713#1828" type="string">Brandon Canonic</value>
      </add-attr>
      <add-attr attr-name="swaStatus">
        <value timestamp="1756246603#8" type="string">A</value>
      </add-attr>
      <operation-data DRIVER_REVISION="1.1.0-CSEE-4989-x266698" objectType="employee"/>
    </add>
  </input>
</nds>
```

So this only takes. .776 -> .795 = .019 seconds.

