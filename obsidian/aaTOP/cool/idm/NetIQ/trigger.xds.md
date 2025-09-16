2/7/2024 10:51:19 AM

Trigger example:

[02/07/24 11:50:24.682]:MCL ST:Start transaction.
[02/07/24 11:50:24.682]:MCL ST:type(custom-event)
[02/07/24 11:50:24.682]:MCL ST:Processing events for transaction.
[02/07/24 11:50:24.683]:MCL ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <trigger event-id="trigger-job:Check Passport Expiration#20240207175024#0#0" source="Check Passport Expiration">
      <operation-data source="Check Passport Expiration"/>
    </trigger>
  </input>
</nds>
