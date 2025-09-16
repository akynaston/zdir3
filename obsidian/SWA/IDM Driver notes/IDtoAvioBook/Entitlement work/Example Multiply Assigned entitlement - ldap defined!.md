6/13/2024 10:05:36 AM
Version 1.0

I was having issues having an entitlement policy assigned multiple times. I wanted to have a 1-1 mapping between entitlement policies and aviobook roles. Well, if the entitlement has a unique manual 'value' on it, then the driver will assign each entitlement along with their value to the user!

Notice the two polices I set up: avio_box_controller, and avio_moc_controller.  Each of them ahve been  setup with a dummy, but unique value:

avio_box_controller has 'boxturtle'
avio_moc_controller has 'mocturtle'


![[Pasted image 20240613101128.png]]

![[Pasted image 20240613101221.png]]



As you can see, x325227 is a member of both entitlement policies. When the RBE driver runs; the user receives an add-value for the entitlement twice - including the entitlement, policy that assigned it, and the dummy value!
```

<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.8.6.0000">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <modify cached-time="20240613155520.519Z" class-name="User" event-id="w11dcledirdi019#20240613155520#1#1:209ef577-29ee-4765-b8f8-77f59e20ee29" qualified-src-dn="O=swaiddev\OU=Users\CN=x325227" src-dn="\DEV_SW
ACO_ID\swaiddev\Users\x325227" src-entry-id="530661" timestamp="1718294120#5">
      <association state="associated">x325227</association>
      <modify-attr attr-name="DirXML-EntitlementRef">
        <add-value>
          <value timestamp="1718294120#4" type="structured">
            <component name="nameSpace">1</component>
            <component name="volume">\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\IDtoAvioBooks\SWA AvioBook Role</component>
            <component name="path.xml">
              <ref>
                <src>RBE</src>
                <id>swaiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\avio_moc_controller</id>
                <param>avio_moc_controller</param>
              </ref>
            </component>
          </value>
        </add-value>
        <add-value>
          <value timestamp="1718294120#5" type="structured">
            <component name="nameSpace">1</component>
            <component name="volume">\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\IDtoAvioBooks\SWA AvioBook Role</component>
            <component name="path.xml">
              <ref>
                <src>RBE</src>
                <id>swaiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\avio_box_controller</id>
                <param>avio_box_controller</param>
              </ref>
            </component>
          </value>
        </add-value>
      </modify-attr>
    </modify>
  </input>
</nds>

```

This means that in my driver, I can loop through the assigned entitlements, and use the name of each policy that assigned the entitlement . . the value is a dummy for now; but as long as it is unique, it'll work.  I may just set it equal to the name of the policy for now . . 



