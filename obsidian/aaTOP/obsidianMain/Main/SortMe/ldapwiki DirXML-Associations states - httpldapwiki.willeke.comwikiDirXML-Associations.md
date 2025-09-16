# ldapwiki: DirXML-Associations states - http://ldapwiki.willeke.com/wiki/DirXML-Associations

[ldapwiki: DirXML-Associations states](http://ldapwiki.willeke.com/wiki/DirXML-Associations)

### Warning[#](http://ldapwiki.willeke.com/wiki/DirXML-Associations#section-DirXML-Associations-Warning)

Novell has no KNOWN public publication as to the the details of this attribute or the attribute's syntax.

We show here what we have learned along the way from empirical evidence and from others.

### DirXML-Associations[#](http://ldapwiki.willeke.com/wiki/DirXML-Associations#section-DirXML-Associations-DirXMLAssociations)

The DirXML-Associations attribute is applied to entries (like users) and indicates the status of the synchronization for any given driver.

The available DirXML-Associations Attribute State values are:

| Code | Description | LDAP search Filter |
| --- | --- | --- |
| 0   | Disabled | (DirXML-Associations=cn=MyDriverName,cn=DriverSetName,ou=services,o=baseorg#0#) |
| 1   | Processed | (DirXML-Associations=cn=MyDriverName,cn=DriverSetName,ou=services,o=baseorg#1#\*) |
| 2   | Pending | (DirXML-Associations=cn=MyDriverName,cn=DriverSetName,ou=services,o=baseorg#2#") |
| 3   | Manual | (DirXML-Associations=cn=MyDriverName,cn=DriverSetName,ou=services,o=baseorg#3#) |
| 4   | Migrate | (DirXML-Associations=cn=MyDriverName,cn=DriverSetName,ou=services,o=baseorg#4#\*) |
| 4278190086 | Any Value | (DirXML-Associations=cn=MyDriverName,cn=DriverSetName,ou=services,o=baseorg#4278190086#\*) |
| \*  | (Not present) No Association | (!(DirXML-Associations=cn=MyDriverName,cn=DriverSetName,ou=services,o=baseorg#4278190086#\*)) |

### Tools for modification of Associations[#](http://ldapwiki.willeke.com/wiki/DirXML-Associations#section-DirXML-Associations-ToolsForModificationOfAssociations)

* [Association Modifier](http://www.novell.com/coolsolutions/tools/15754.html)![[./_resources/ldapwiki_DirXML-Associations_states_-_httpldapwiki.willeke.comwikiDirXML-Associations.resources/unknown_filename.png]]

## Attribute Details[#](http://ldapwiki.willeke.com/wiki/DirXML-Associations#section-DirXML-Associations-AttributeDetails)

The DirXML-Associations attribute uses the [path syntax](http://ldapwiki.willeke.com/wiki/2.16.840.1.113719.1.1.5.1.15)

### Component Structure[#](http://ldapwiki.willeke.com/wiki/DirXML-Associations#section-DirXML-Associations-ComponentStructure)

A typical DirXML-Associations value as expanded to their components from a query return is like:
<nds dtdversion="3.5" ndsversion="8.x">
  <source>
    <product version="3.5.11.20080307 ">DirXML</product>
    <contact>Novell, Inc.</contact>
  </source>
  <output>
    <instance class-name="User" qualified-src-dn="O=LAB\\OU=EMPLOYEES\\OU=NEW\\CN=JSmith" src-dn="\\ACME-LAB\\LAB\\EMPLOYEES\\NEW\\LJohnson1" src-entry-id="56795">
      <attr attr-name="DirXML-Associations">
        <value timestamp="1217007039#71" type="structured">
          <component name="nameSpace">1</component>
          <component name="volume">\\ACME-LAB\\LAB\\SERVICES\\IDVAULT\\APP-JDBC</component>
          <component name="path">PK\_SEQUENCE=350110,table=CLIENTS,schema=IDM</component>
        </value>
        <value timestamp="1217007039#72" type="structured">
          <component name="nameSpace">1</component>
          <component name="volume">\\ACME-LAB\\LAB\\SERVICES\\IDVAULT\\LinuxUnixSettings</component>
          <component name="path">YE98+yxf3AGAleAAAwAAAA==</component>
        </value>
        <value timestamp="1217007039#73" type="structured">
          <component name="nameSpace">1</component>
          <component name="volume">\\ACME-LAB\\LAB\\SERVICES\\IDVAULT\\UserApplication35</component>
          <component name="path">"AnAssociation"</component>
        </value>
        <value timestamp="1217007039#74" type="structured">
          <component name="nameSpace">1</component>
          <component name="volume">\\ACME-LAB\\LAB\\SERVICES\\IDVAULT\\Active Directory</component>
          <component name="path">f0648eab27d6da4283246583112d6319</component>
        </value>
        <value timestamp="1217007039#75" type="structured">
          <component name="nameSpace">1</component>
          <component name="volume">\\ACME-LAB\\LAB\\SERVICES\\IDVAULT\\Corporate Password Sync</component>
          <component name="path">E101738</component>
        </value>
      </attr>
      </instance>
      </output>
      </nds>

For a great article on looking at [DirXML-Associations and using XPATH](http://www.novell.com/communities/node/5845/using-xpath-examine-association-values)![[./_resources/ldapwiki_DirXML-Associations_states_-_httpldapwiki.willeke.comwikiDirXML-Associations.resources/unknown_filename.png]]

## Overview[#](http://ldapwiki.willeke.com/wiki/DirXML-Associations#section-DirXML-Associations-Overview)

In DirXML-Associations refer to the matching of objects in NDS with objects residing in connected systems.

When DirXML is initially installed, the schema is extended. The DirXML-Associations attribute is added to the "Top" ObjectClass and is therefore available to all structural ObjectClasses that inherit from top.

The DirXML-Associations attribute is multi-valued and is designed keep track of all the objects that are associated to the DirXML Drivers. These associations are built and maintained programmatically so there is typically never a reason to edit this information manually, although it is often helpful to view this information.
