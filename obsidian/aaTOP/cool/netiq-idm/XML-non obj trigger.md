3/29/2024 2:51:46 PM

Example of a non object trigger:

```
[03/29/24 15:47:38.008]:IDtoDocunet ST:Discarding transaction because of optimization.
[03/29/24 15:47:38.212]:IDtoDocunet ST:Start transaction.
[03/29/24 15:47:38.212]:IDtoDocunet ST:type(custom-event)
[03/29/24 15:47:38.212]:IDtoDocunet ST:Processing events for transaction.
[03/29/24 15:47:38.212]:IDtoDocunet ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <trigger event-id="trigger-job:SFH-Trigger Archive Files#20240329204738#0#0" source="SFH-Trigger Archive Files">
      <operation-data source="SFH-Trigger Archive Files"/>
    </trigger>
  </input>
</nds>
[03/29/24 15:47:38.213]:IDtoDocunet ST:Applying event transformation policies.
[03/29/24 15:47:38.213]:IDtoDocunet ST:Applying policy: %+C%14Clib-DriverRevision%-C.
[03/29/24 15:47:38.213]:ID
```