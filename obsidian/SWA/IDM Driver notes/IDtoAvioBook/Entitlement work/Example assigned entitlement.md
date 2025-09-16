
```
[06/06/24 18:31:53.660]:IDtoAvioBooks ST:Start transaction.
[06/06/24 18:31:53.660]:IDtoAvioBooks ST:type(modify-entry)entry-id(121439) dn(\T=DEV_SWACO_ID\O=swaiddev\OU=Users\CN=x8566069446) class-id(441) class-name(User)
[06/06/24 18:31:53.661]:IDtoAvioBooks ST:type(add-value)Syntax=SYNTAX_PATH, attributename=DirXML-EntitlementRef, volumeDN=\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\IDtoAvioBooks\SWA AvioBook Role, volumePath=<ref><src>RBE</src><id>swaiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\avio_pilot<
/id></ref>, nameSpace=1
[06/06/24 18:31:53.663]:IDtoAvioBooks ST:Processing events for transaction.
[06/06/24 18:31:53.663]:IDtoAvioBooks ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <modify cached-time="20240606233153.617Z" class-name="User" event-id="w11dcledirdi019#20240606233153#1#2:e130ea52-f6be-4e71-ac91-52ea30e1bef6" qualified-src-dn="O=swaiddev\OU=Users\CN=x8566069446" src-dn="\DEV_SWACO_ID\swaiddev\Users\x8566069446" src-entry-id="121439" timestamp="1717716713#11">
      <modify-attr attr-name="DirXML-EntitlementRef">
        <remove-value>
          <value timestamp="1717716713#11" type="structured">
            <component name="nameSpace">1</component>
            <component name="volume">\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\IDtoAvioBooks\SWA AvioBook Role</component>
            <component name="path.xml">
              <ref>
                <src>RBE</src>
                <id>swaiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\avio_pilot</id>
              </ref>
            </component>
          </value>
        </remove-value>
        <add-value>
          <value timestamp="1717716713#11" type="structured">
            <component name="nameSpace">0</component>
            <component name="volume">\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\IDtoAvioBooks\SWA AvioBook Role</component>
            <component name="path.xml">
              <ref>
                <src>RBE</src>
                <id>swaiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\avio_pilot</id>
              </ref>
            </component>
          </value>
        </add-value>
        <add-value>
          <value timestamp="1717716713#11" type="structured">
            <component name="nameSpace">0</component>
            <component name="volume">\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\IDtoAvioBooks\SWA AvioBook Role</component>
            <component name="path.xml">
              <ref>
                <src>RBE</src>
                <id>swaiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\avio_moc_controller</id>
              </ref>
            </component>
          </value>
        </add-value>
      </modify-attr>
    </modify>
  </input>
</nds>

```