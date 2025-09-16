---
tags: ["#isweariknewthatonce","#Zimbra"]
---
# This event appears to kill the wscript driver - I think it's the zimbraNotes val

This event appears to kill the wscript driver - I think it's the zimbraNotes values - there are two of them, but they're both the same value.

<nds dtdversion="3.5" ndsversion="8.x">
  <source>
    <product version="3.5.10.20070918 ">DirXML</product>
    <contact>Novell, Inc.</contact>
  </source>
  <input>
    <add class-name="Group" event-id="0" src-dn="\\TESTTREE\\us\\U.S. Government\\Passport\\Groups\\testTeam141">
      <add-attr attr-name="CN">
        <value naming="true" timestamp="1242403848#24" type="string">testTeam141</value>
      </add-attr>
      <add-attr attr-name="Description">
        <value timestamp="1242403848#3" type="string">TestTeam141 Group</value>
      </add-attr>
      <add-attr attr-name="Full Name">
        <value timestamp="1242403848#14" type="string">TeamA</value>
      </add-attr>
      <add-attr attr-name="zimbraNotes">
        <value>owner2@emailaddress.com</value>
        <value>owner2@emailaddress.com</value>
      </add-attr>
      <add-attr attr-name="zimbraTeamCalendar">
        <value timestamp="1242403848#2" type="state">false</value>
      </add-attr>
      <add-attr attr-name="zimbraTeamMailbox">
        <value timestamp="1242403848#5" type="state">false</value>
      </add-attr>
      <add-attr attr-name="zimbraTeamMailGroup">
        <value timestamp="1242403852#2" type="state">true</value>
      </add-attr>
      <add-attr attr-name="Event">
        <value type="string">Add\_Group\_Distro</value>
      </add-attr>
      <add-attr attr-name="zimbraMailForwardingAddress">
        <value type="string">zimbraMailForwardingAddress 'member1@emailaddress.com' </value>
      </add-attr>
      <add-attr attr-name="zimbraMailForwardingAddress\_add">
        <value type="string">member1@emailaddress.com</value>
      </add-attr>
      <add-attr attr-name="zimbraMailForwardingAddress">
        <value type="string">zimbraMailForwardingAddress 'member2@emailaddress.com' </value>
      </add-attr>
      <add-attr attr-name="zimbraMailForwardingAddress\_add">
        <value type="string">member2@emailaddress.com</value>
      </add-attr>
      <add-attr attr-name="zimbraMailForwardingAddress">
        <value type="string">zimbraMailForwardingAddress 'owner1@emailaddress.com' </value>
      </add-attr>
      <add-attr attr-name="zimbraMailForwardingAddress\_add">
        <value type="string">owner1@emailaddress.com</value>
      </add-attr>
      <add-attr attr-name="zimbraMailForwardingAddress">
        <value type="string">zimbraMailForwardingAddress 'owner2@emailaddress.com' </value>
      </add-attr>
      <add-attr attr-name="zimbraMailForwardingAddress\_add">
        <value type="string">owner2@emailaddress.com</value>
      </add-attr>
    </add>
  </input>
</nds>
