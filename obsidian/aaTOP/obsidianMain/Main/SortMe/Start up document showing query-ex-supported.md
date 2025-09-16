---
tags: ["#xml","#ndsdtd"]
---
# Start up document: showing query-ex-supported

<nds dtdversion="1.1" ndsversion="8.7">
  <source>
    <product asn1id="" build="20070823\_095000" instance="\\IDV\\idm\\Driver Set\\ADAccountsGoldLinkDriver" version="3.5.1">AD</product>
    <contact>Novell, Inc.</contact>
  </source>
  <output>
    <instance class-name="\_\_driver\_identification\_class\_\_">
      <attr attr-name="driver-id">
        <value type="string">AD</value>
      </attr>
      <attr attr-name="driver-version">
        <value type="string">3.5.1</value>
      </attr>
      <attr attr-name="min-activation-version">
        <value type="string">5</value>      - [ ] </attr>
      <attr attr-name="query-ex-supported">
        <value type="state">true</value>
      </attr>
    </instance>
    <status event-id="query-driver-ident" level="success"/>
  </output>
</nds>
