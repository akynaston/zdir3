If you change a memberqueryurl; it'll stop it:

```

[06/18/24 14:02:02.204]:RBEAEv1 ST:
DirXML Log Event -------------------
     Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\RBEAEv1
     Channel:  Subscriber
     Status:   Fatal
     Message:  Code(-9005) The driver returned a "fatal" status indicating that the driver should be shut down. Detail from driver: <description>Entitlement policy 'swaiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\SOAR-SWA Reporting GO Submitter' has been edited.  At least one membership query has changed.</description>
<document xml:space="preserve">&lt;nds dtdversion="4.0" ndsversion="8.x">
        &lt;source>
                &lt;product edition="Advanced" version="4.8.6.0000">DirXML&lt;/product>
                &lt;contact>NetIQ Corporation&lt;/contact>
        &lt;/source>
        &lt;input>
                &lt;modify cached-time="20240618170020.058Z" class-name="DirXML-SharedProfile" event-id="w11dcledirdi019#20240618170013#1#1:2b5f27a5-676a-4892-ad40-a5275f2b6a67" qualified-src-dn="O=swaiddev\OU=Services\OU=DirXML\CN=Driver Set AEv1\CN=Entitlement Policies\CN=SOAR-SWA Reporting GO Submitter" src-dn="\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\SOAR-SWA Reporting GO Submitter" src-entry-id="533413" timestamp="1718730013#1">
                        &lt;association state="associated">{7FBAE517-3B50-4589-BB12-17E5BA7F503B}&lt;/association>
                        &lt;modify-attr attr-name="Member">
                                &lt;remove-value>
                                        &lt;value association-ref="{2F5B1882-DB6D-42F6-81EF-82185B2F6DDB}" timestamp="1718728507#2" type="dn">\DEV_SWACO_ID\swaiddev\Users\e190443&lt;/value>
                                &lt;/remove-value>
                                &lt;remove-value>

```
.
.
.
```
                                &lt;remove-value>
                                        &lt;value association-ref="{74EEB396-7989-11D7-A07A-00080210CF02}" timestamp="1718728510#7405" type="dn">\DEV_SWACO_ID\swaiddev\Users\e14180&lt;/value>
                                &lt;/remove-value>
                                &lt;remove-value>
                                        &lt;value association-ref="{491BC180-9A2A-11D9-B916-00080210CF02}" timestamp="1718728510#7406" type="dn">\DEV_SWACO_ID\swaiddev\Users\e76824&lt;/value>
                                &lt;/remove-value>
                                &lt;remove-value>
                                        &lt;value association-ref="{3EF9C300-9A2A-11D9-B916-00080210CF02}" timestamp="1718728510#7407" type="dn">\DEV_SWACO_ID\swaiddev\Users\e76821&lt;/value>
                                &lt;/remove-value>
                                &lt;remove-value>
                                        &lt;value association-ref="{A991EA80-4B53-11D7-A079-0002A5FBF717}" timestamp="1718728510#7408" type="dn">\DEV_SWACO_ID\swaiddev&lt;/value>
                                &lt;/remove-value>
                        &lt;/modify-attr>
                &lt;/modify>
        &lt;/input>
&lt;/nds></document>

```