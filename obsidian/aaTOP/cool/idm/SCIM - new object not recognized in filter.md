10/25/2024 1:40:05 PM
This was seen when I tried to send a group event through a SCIM driver - need to create a 'resources' . .
```
[10/25/24 14:38:01.662]:IDtoMiro ST:                        : SCIMSubscriber.execute() started.
[10/25/24 14:38:01.670]:IDtoMiro ST:                        : XdsToJsonParser.XdsToJsonParser() object Constructed.
[10/25/24 14:38:01.671]:IDtoMiro ST:                        : XdsToJsonParser.xdsToJSON() started.
[10/25/24 14:38:01.672]:IDtoMiro ST:                        : XdsToJsonParser.xdsModifyOperationToJSON() started.
[10/25/24 14:38:01.672]:IDtoMiro ST:                        : XdsToJsonParser.querySubscriberResource() started.
[10/25/24 14:38:01.672]:IDtoMiro ST:                        IDtoMiro__Scim: Submitting command document to rest subscriber shim
[10/25/24 14:38:01.673]:IDtoMiro ST:                        IDtoMiro__Scim: RESTSubscriptionShim.execute() :
[10/25/24 14:38:01.673]:IDtoMiro ST:                        IDtoMiro__Scim: queryHandler
[10/25/24 14:38:01.673]:IDtoMiro ST:                        IDtoMiro__Scim: queryHandler: class-name  == 'Group'
[10/25/24 14:38:01.674]:IDtoMiro ST:                        IDtoMiro__Scim: Rest SubscriptionShim.execute() returns:
[10/25/24 14:38:01.675]:IDtoMiro ST:                        : Exception: Resource could not be found for class-name Group.Make sure the class-name supplied to the driver exactly matches the schema name in the driver parameter.
[10/25/24 14:38:01.676]:IDtoMiro ST:                        : XdsToJsonParser.xdsToJSON() completed.
[10/25/24 14:38:01.676]:IDtoMiro ST:                        : SCIMSubscriber.execute() completed.
[10/25/24 14:38:01.677]:IDtoMiro ST:                        SubscriptionShim.execute() returned:
[10/25/24 14:38:01.677]:IDtoMiro ST:
<nds dtdversion="2.0" ndsversion="8.x">
  <source>
    <product build="20221116_0247" instance="IDtoMiro" version="1.0.1.0300">Identity Manager SCIM Driver</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <status event-id="w11dcledirdi019#20241025193801#18#1:946002eb-7af0-44f0-b03c-eb026094f07a" level="error">com.microfocus.nds.dirxml.driver.scim.exceptions.ChannelException: Exception: Resource could not be found for class-name Group.Make sure the class-name supplied to the driver exactly matches the schema name in the driver parameter.</status>
    <instance class-name="Group" event-id="0" src-dn="">
      <attr attr-name="jsonPayload">
        <value>Invalid JSON Payload: com.microfocus.nds.dirxml.driver.scim.exceptions.ChannelException: Exception: Resource could not be found for class-name Group.Make sure the class-name supplied to the driver exactly matches the schema name in the driver parameter.</value>
      </attr>
    </instance>
  </output>
</nds>
[10/25/24 14:38:01.682]:IDtoMiro ST:                        Query from policy result
[10/25/24 14:38:01.682]:IDtoMiro ST:
<nds dtdversion="2.0" ndsversion="8.x">
  <source>
    <product build="20221116_0247" instance="IDtoMiro" version="1.0.1.0300">Identity Manager SCIM Driver</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <status event-id="w11dcledirdi019#20241025193801#18#1:946002eb-7af0-44f0-b03c-eb026094f07a" level="error">com.microfocus.nds.dirxml.driver.scim.exceptions.ChannelException: Exception: Resource could not be found for class-name Group.Make sure the class-name supplied to the driver exactly matches the schema name in the driver parameter.</status>
    <instance class-name="Group" event-id="0" src-dn="">
      <attr attr-name="jsonPayload">
        <value>Invalid JSON Payload: com.microfocus.nds.dirxml.driver.scim.exceptions.ChannelException: Exception: Resource could not be found for class-name Group.Make sure the class-name supplied to the driver exactly matches the schema name in the driver parameter.</value>
      </attr>
    </instance>
  </output>
</nds>

```