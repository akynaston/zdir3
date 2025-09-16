# Novell Doc: NDK: LDAP and eDirectory Integration - LDAP and eDirectory Schema

|     |     |     |
| --- | --- | --- |
| [![[./_resources/Novell_Doc_NDK_LDAP_and_eDirectory_Integration_-_LDAP_and_eDirectory_Schema.resources/prev.gif]]](http://developer.novell.com/documentation//ldapover/ldap_enu/data/a3wzcl0.html) ![[./_resources/Novell_Doc_NDK_LDAP_and_eDirectory_Integration_-_LDAP_and_eDirectory_Schema.resources/virt_dot-line.gif]] [![[./_resources/Novell_Doc_NDK_LDAP_and_eDirectory_Integration_-_LDAP_and_eDirectory_Schema.resources/next.gif]]](http://developer.novell.com/documentation//ldapover/ldap_enu/data/ai03rrt.html) |     | [![[./_resources/Novell_Doc_NDK_LDAP_and_eDirectory_Integration_-_LDAP_and_eDirectory_Schema.resources/body_pdf.gif]]](http://developer.novell.com/documentation/ldapover/pdfdoc/ldap_enu/ldap_enu.pdf) ![[./_resources/Novell_Doc_NDK_LDAP_and_eDirectory_Integration_-_LDAP_and_eDirectory_Schema.resources/virt_dot-line.gif]] [![[./_resources/Novell_Doc_NDK_LDAP_and_eDirectory_Integration_-_LDAP_and_eDirectory_Schema.resources/body_feedback.gif]]](http://developer.novell.com/documentation//ldapover/ldap_enu/data/a3xfo7x.html#next) ![[./_resources/Novell_Doc_NDK_LDAP_and_eDirectory_Integration_-_LDAP_and_eDirectory_Schema.resources/virt_dot-line.gif]]  ![[./_resources/Novell_Doc_NDK_LDAP_and_eDirectory_Integration_-_LDAP_and_eDirectory_Schema.resources/virt_dot-line.gif]] |

## 1.11 LDAP and eDirectory Schema

Although both the LDAP schema and the eDirectory schema are based on X.500, some of the implementation details are quite different with each being more restrictive in some areas and less restrictive in other areas. The following sections describe some of these differences:

		[Schema Naming Rules](http://developer.novell.com/documentation//ldapover/ldap_enu/data/a3xfo7x.html#a3xfre2)
	
		[Schema Mapping](http://developer.novell.com/documentation//ldapover/ldap_enu/data/a3xfo7x.html#a4t7q5p)
	
		[LDAP Operational Attributes](http://developer.novell.com/documentation//ldapover/ldap_enu/data/a3xfo7x.html#a6ac87c)
	
		[Attribute Flags](http://developer.novell.com/documentation//ldapover/ldap_enu/data/a3xfo7x.html#a3xfre5)
	
		[Object Class Flags](http://developer.novell.com/documentation//ldapover/ldap_enu/data/a3xfo7x.html#a3xfre6)
	
		[Syntax Definitions](http://developer.novell.com/documentation//ldapover/ldap_enu/data/a3xfo7x.html#a3xfrdx)
	
		[Auxiliary Classes versus Modifications to Class Definitions](http://developer.novell.com/documentation//ldapover/ldap_enu/data/a3xfo7x.html#a3xfre7)
	

### 1.11.1 Schema Naming Rules

eDirectory supports different rules for naming object class definitions and attribute definitions. For example, eDirectory allows spaces and punctuation characters in the name. These conventions are incompatible with LDAP naming conventions, which restrict the name to alphabetical characters, no spaces, and one punctuation character, the hyphen.

The LDAP server in NDS eDirectory automatically maps the attributes and classes defined by RFC 2256 to their LDAP equivalent names. (For a list, see the LDAP Name index in the [NDK: Novell eDirectory Schema Reference](http://developer.novell.com/documentation//ndslib/schm_enu/data/h4q1mn1i.html#h4q1mn1i).) If LDAP clients need access to the other eDirectory classes and attributes that have incompatible names, the system administrator needs to use ConsoleOne to manually map them to an LDAP compatible name.

Even if the name is compatible with LDAP conventions, an LDAP client may not be able to access the attribute because the attribute's syntax is not supported by the LDAP server. For a list of supported syntax definitions, see [Syntax Definitions](http://developer.novell.com/documentation//ldapover/ldap_enu/data/a3xfo7x.html#a3xfrdx).

The following paragraphs describe a couple of special cases for object class definitions.

_User and inetOrgPerson:_ By default, inetOrgPerson is mapped to the NDS User object class, and you can access this class using the LDAP names of inetOrgPerson or user. By default, the User class definition does not contain all the standard attributes for inetOrgPerson. To add these attributes to the User class definition, the system administrator must run a schema file (nov\_inet.sch). In NDS eDirectory, Novell also supplies a schema file that creates an inetOrgPerson class with the standard LDAP attributes. Your application will need to read the schema and the directory to determine which class contains the users for the system.

_residentialPerson:_ In NDS eDirectory, Novell supplies a schema file that adds the residentialPerson class definition to the schema with the standard LDAP attributes. Your application will need to read the schema to determine if the system administrator has added this class to the schema.

### 1.11.2 Schema Mapping

Since the eDirectory schema has many class and attribute definitions with illegal LDAP names, these definitions must be mapped to a legal LDAP name. All LDAP servers in the eDirectory tree must map the same LDAP class or attribute to the same eDirectory class or attribute. Each version of eDirectory has made this mapping easier:

		In NDS eDirectory 8.3x, all standard LDAP attribute and class definitions are mapped to the corresponding eDirectory attribute or class definitions when eDirectory is installed. The [NDK: Novell eDirectory Schema Reference](http://developer.novell.com/documentation//ndslib/schm_enu/data/h4q1mn1i.html#h4q1mn1i) contains an index to these LDAP names. If the schema is extended with classes and attributes that use invalid LDAP names, these classes and attributes need to be manually mapped to valid LDAP names.
	
		In NDS eDirectory 8.5, all eDirectory attribute and class definitions can be accessed from LDAP by using the eDirectory name with the colon and spaces removed. Also, any required mappings can be processed from an LDIF file during installation.
	

From ConsoleOne, system administrators can add mappings for classes and attributes that are not automatically mapped. The LDAP server needs to be stopped and started to make the mapped attributes and classes visible from LDAP.

### 1.11.3 LDAP Operational Attributes

In eDirectory, not all information about an entry is kept in attributes, for example, an entry's base class, last modified time, or creation time. Through NDAP, eDirectory has made this information available through DSI flags. In NDS eDirectory 8.5, this information is available through LDAP as operational attributes. The information is read-only. Clients cannot modify the attributes.

These attributes are not returned in search results unless explicitly requested by name. NDS eDirectory 8.5 supports the following operational attributes on all entries in the directory.

_Table 1-9_ LDAP Operational Attributes

| Operation Attribute | Description |
| --- | --- |
| [createTimeStamp](http://developer.novell.com/documentation//ndslib/schm_enu/data/a6fur3q.html#a6fur3q) | Contains when the entry was created.<br><br>Standard LDAP attribute (RFC 2252). |
| [creatorsName](http://developer.novell.com/documentation//ndslib/schm_enu/data/a6fur3f.html#a6fur3f) | Contains the distinguished name of the user that created this entry.<br><br>Standard LDAP attribute (RFC 2252). |
| [entryFlags](http://developer.novell.com/documentation//ndslib/schm_enu/data/a6fuxcp.html#a6fuxcp) | Contains information about an entry's state, for example whether the entry is an alias, a partition, or a container.<br><br>eDirectory-specific attribute. |
| [federationBoundary](http://developer.novell.com/documentation//ndslib/schm_enu/data/a6fzxsm.html#a6fzxsm) | Contains where the federation boundary begins for a DNS-rooted tree.<br><br>eDirectory-specific attribute. |
| [localEntryID](http://developer.novell.com/documentation//ndslib/schm_enu/data/a6fzcam.html#a6fzcam) | Contains the record number for the entry in the server's local database.<br><br>eDirectory-specific attribute. |
| [modifiersName](http://developer.novell.com/documentation//ndslib/schm_enu/data/a6fur3j.html#a6fur3j) | Contains the distinguished name of the last user that modified this entry.<br><br>Standard LDAP attribute (RFC 2252). |
| [modifyTimeStamp](http://developer.novell.com/documentation//ndslib/schm_enu/data/a6fur3x.html#a6fur3x) | Contains when the entry was last modified.<br><br>Standard LDAP attribute (RFC 2252). |
| [structuralObjectClass](http://developer.novell.com/documentation//ndslib/schm_enu/data/a6fuxcb.html#a6fuxcb) | Contains the base class of the entry.<br><br>Standard LDAP attribute. |
| [subordinateCount](http://developer.novell.com/documentation//ndslib/schm_enu/data/a6fuxci.html#a6fuxci) | Contains the number of entries immediately subordinate to this entry.<br><br>eDirectory-specific attribute. |
| [subschemaSubentry](http://developer.novell.com/documentation//ndslib/schm_enu/data/a6fuxc4.html#a6fuxc4) | Contains the LDAP name for the schema.<br><br>Standard LDAP attribute (RFC 2252).<br><br>For more information, see [Subschema Subentry Attributes](http://developer.novell.com/documentation//ldapover/ldap_enu/data/a3xfo7x.html#a7lm5ir). |

For more information, see [LDAP Operational Attributes](http://developer.novell.com/documentation//ndslib/schm_enu/data/a7lnqjy.html#a7lnqjy) in the [NDK: Novell eDirectory Schema Reference](http://developer.novell.com/documentation//ndslib/schm_enu/data/h4q1mn1i.html#h4q1mn1i).

### 1.11.4 Root DSE Attributes

The LDAP server maintains the root DSE attributes, and clients can read these attributes but cannot modify them. The Novell LDAP server supports the following attributes.

_Table 1-10_ Root DSE Attributes

| Attribute | Description | NDS/eDirectory Version |
| --- | --- | --- |
| namingContexts | Contains the distinguished names of the naming contexts (or replicas) on the LDAP server.<br><br>Standard LDAP attribute (RFC 2252). | 8.x |
| altServer | Contains the name of alternative servers if this one is unavailable in subsequent requests<br><br>Standard LDAP attribute (RFC 2252).. | 8.5 |
| supportedExtension | Contains a list of OIDs that identify supported extended operations.<br><br>Standard LDAP attribute (RFC 2252). | 8.x |
| supportedControl | Contains a list of OIDs that identify supported controls.<br><br>Standard LDAP attribute (RFC 2252). | 8.x . In version 85, controls are not advertized. |
| supportedSASLMechanisms | Contains a list of supported SASL security features.<br><br>Standard LDAP attribute (RFC 2252). | 8.5 |
| supportedLDAPVersion | Contains a list of LDAP versions implemented by the server.<br><br>Standard LDAP attribute (RFC 2252). | 8.x |
| subschemaSubentry | Contains the distinguished name of the subschema subentry which is the name of the schema for this server.<br><br>For eDirectory, this is always cn=schema.<br><br>Standard LDAP attribute (RFC 2252). | 8.x |
| vendorName | Contains a string with the name of the company.<br><br>eDirectory-specific attribute. | 8.5 |
| vendorVersion | Contains the LDAP server version.<br><br>eDirectory-specific attribute. | 8.5 |
| directoryTreeName | Contains the eDirectory tree name.<br><br>eDirectory-specific attribute. | 8.5 |
| dsaName | Contains the distinguished name of the server.<br><br>eDirectory-specific attribute. | 8.5 |

In a DNS-rooted tree, you can find the federation boundary by one of the following methods:

		Using the namingContext attribute, search one of the naming contexts for its federationBoundary attribute.
	
		Using the dsaName attribute, search the server for its federationBoundary attribute. Use this method only if a naming context is not available.
	

### 1.11.5 Subschema Subentry Attributes

Clients must specifically request attribute information about the subschema entry. It is never returned in a generic request to read all information about all entries. Clients must request a base object search with the search filter set to the following: "objectClass=subschema"

The Novell LDAP server supports the following attributes.

_Table 1-11_ Subschema Subentry Attributes

| Attribute | Description | NDS/eDirectory Version |
| --- | --- | --- |
| cn  | Contains the RDN of the subschema entry. | 8.x |
| objectClasses | Contains a value for each object class known by the LDAP server. | 8.x |
| objectClass | Contains the parent object classes of the subschema subentry.<br><br>It always contains two classes: top and subschema. | 8.x |
| attributeTypes | Contains a value for each attribute definition known by the LDAP server. | 8.x |
| ldapSyntaxes | Contains a value for each syntax definition known by the LDAP server. | 8.5 |

Clients add attribute definitions and object classes to the schema by adding values to the attributeTypes and objectClasses attributes of the subentry.

### 1.11.6 Attribute Flags

eDirectory supports numerous attribute definition flags that affect the type of data an attribute can contain and that control its synchronization schedule. The LDAP server in NDS eDirectory can set and get information about the following eDirectory extended flags. By default, when creating an attribute definition, none of these flags are set. To obtain the information when reading the schema, you must send the flag with the request to read the attribute.

_Table 1-12_ eDirectory Extended Attribute Flags

| Extended LDAP Flags | Description |
| --- | --- |
| X-NDS\_PUBLIC\_READ | When set, allows anyone to read the attribute's value even though such rights have not been granted or inherited. Using this flag makes access to the attribute extremely efficient because eDirectory performs no rights checking.<br><br>When not set, users must have been granted rights or inherit rights to read the attribute's value.<br><br>In NDAP, this is equivalent to the DS\_PUBLIC\_READ flag set to True. |
| X-NDS\_SERVER\_READ | When set, allows the NCP Server object to read the attribute's value even though such rights have not been granted or inherited.<br><br>When not set, the NCP Server object must be granted rights or inherit rights to read the attribute's value.<br><br>In NDAP, this is equivalent to the DS\_SERVER\_READ flag set to True. |
| X-NDS\_NEVER\_SYNC | When set, prevents changes to this attribute from synchronizing with other replicas. The information in the attribute is specific to the replica.<br><br>When not set, changes to the attribute are synchronized to other replicas.<br><br>In NDAP, this is equivalent to the DS\_PER\_REPLICA flag set to True. |
| X-NDS\_NOT\_SCHED\_SYNC\_IMMEDIATE | When set, allows the attribute's value to change without scheduling synchronization, and synchronization will start within 30 minutes.<br><br>When not set, causes any changes to the attribute to schedule immediate synchronization (within 10 seconds).<br><br>In NDAP, this is equivalent to the DS\_SYNC\_IMMEDIATE flag set to False. |
| X-NDS\_SCHED\_SYNC\_NEVER | When set, allows the attribute's value to change without scheduling synchronization. The attribute can wait until the next scheduled synchronization cycle to propagate its changes.<br><br>When not set, causes any changes to the attribute to schedule synchronization.<br><br>Developers can only read this flag.<br><br>In NDAP, this is equivalent to the DS\_SCHEDULE\_SYNC\_NEVER flag set to True. |
| X-NDS\_LOWER\_BOUND | When set, specifies the lower boundary for a string or integer syntax.<br><br>When not set, the attribute has no lower boundary.<br><br>In NDAP, this is equivalent to the DS\_SIZED\_ATTR flag set to True |
| X-NDS\_NAME\_VALUE\_ACCESS | This flag only works on attributes which use a DN syntax and contain a list of entries, such as groupMembership.<br><br>When set, requires users to have supervisor rights to the entry before they can add or delete the entry as a value for this attribute.<br><br>When not set, requires the user to have read rights to read the values and write rights to modify the values.<br><br>In NDAP, this is equivalent to the DS\_WRITE\_MANAGED flag set to True. |
| X-NDS\_NAME | When creating an attribute, specifies the legacy eDirectory attribute that automatically maps to this LDAP attribute. This is new in NDS eDirectory 8.5 and should be used to make attributes available to previous versions of the LDAP server in an eDirectory tree.<br><br>When reading the attribute definition, returns the legacy eDirectory attribute name. |
| X-NDS\_ACL\_TEMPLATES | Every object in the NDS tree has an ACL attribute. This attribute holds information about which trustees have access to the object itself (entry rights) and which trustees have access to the attributes for the object.<br><br>This information is stored in sets of information containing the following:<br><br>		The trustee name<br>	<br>		The affected attribute-\[Entry Rights\], \[All Attributes Rights\], or a specific attribute<br>	<br>		The privileges<br>	<br><br>ACL templates helps us in defining ACLs for specific classes in the base schema and provide a minimum amount of access security for newly created objects.<br><br>This flag was added in 8.7.0. |

The standard LDAP attribute flags can also be used. The following table lists the LDAP name and the corresponding NDAP name.

_Table 1-13_ Standard LDAP Attribute Flags

| Standard LDAP Flags | NDAP Flag |
| --- | --- |
| SINGLE-VALUE | DS\_SINGLE\_VALUED\_ATTR set to True |
| COLLECTIVE | Not supported |
| NO-USER-MODIFICATION | DS\_READ\_ONLY\_ATTR set to True |
| USAGE userApplications | None required. This sets the attribute as a normal attribute. The other USAGE flags can only be set by eDirectory. |
| USAGE directoryOperation | DS\_OPERATIONAL (set by eDirectory) |
| USAGE distributedOperation | DS\_OPERATIONAL (set by eDirectory) |
| USAGE dSAOperation | DS\_OPERATIONAL (set by eDirectory) |

### 1.11.7 Object Class Flags

eDirectory uses a set of flags to define allowable class operations. When adding a new object class definition to the schema, you can set the following flags. When reading definitions, you send the flags to obtain the information.

_Table 1-14_ eDirectory Extended Object Class Flags

| Extended LDAP Flags | Description |
| --- | --- |
| X-NDS\_NOT\_CONTAINER | When set, indicates that this object class cannot contain other entries and is thus a leaf entry.<br><br>When not set, indicates that this object class can contain other entries and is thus a container class.<br><br>In NDAP, this is equivalent to the DS\_CONTAINER\_CLASS flag set to False. |
| X-NDS\_CONTAINMENT | When included, this flag is followed by a list of object classes that can be the parent container of the object class that is being defined.<br><br>When not included, the object class that is being defined is automatically assigned containment classes of country, organization, organizationalUnit, locality, and domain.<br><br>In NDAP, this is equivalent to the DS\_AMBIGUOUS\_CONTAINMENT flag set to False. |
| X-NDS\_NAMING | When included, this flag is followed by the list of attributes that can be used to name entries based on this object class definition.<br><br>When not included, the naming attributes for the object class are all of the MAY and MUST attributes that use a string-type syntax.<br><br>In NDAP, this is equivalent to the DS\_AMBIGUOUS\_NAMING flag set to False. |
| X-NDS\_NONREMOVABLE | When set, indicates that the class cannot be removed even if no entries are using the definition. This flag is placed on all classes in the eDirectory operational schema. NDS 8 and higher allow application developers to set this flag.<br><br>When not set, indicates that the class can be removed from the schema if no entries are using the definition.<br><br>In NDAP, this is equivalent to the DS\_NONREMOVABLE\_CLASS flag set to True. |
| X-NDS\_NAME | When defining an object class, specifies the legacy eDirectory object class that automatically maps to this LDAP class. This is new in NDS eDirectory 8.5 and should be used to make classes available to previous versions of the LDAP server in an eDirectory tree.<br><br>When reading object class definitions, returns the legacy eDirectory name for this object class. |

The standard LDAP class flags can also be used. The following table lists the LDAP name and the corresponding NDAP name.

_Table 1-15_ Standard LDAP Flags

| Standard LDAP Flags | NDAP FLag |
| --- | --- |
| ABSTRACT | DS\_EFFECTIVE\_CLASS set to False |
| STRUCTURAL | DS\_EFFECTIVE\_CLASS set to True |
| AUXILIARY | DS\_AUXILIARY\_CLASS set to True |

### 1.11.8 Syntax Definitions

The LDAP server allows LDAP access to eDirectory attributes if the eDirectory attribute uses an LDAP compatible syntax. For example, this makes all eDirectory attributes that use the Case Ignore String syntax available through LDAP because LDAP supports the Case Ignore String syntax. eDirectory attributes that use a compound syntax (such as the Timestamp syntax with its fields for time, replica number, and event identifier) are not automatically accessible through LDAP. The LDAP server has made most of these syntax definitions available.

The LDAP server supports the following eDirectory syntax definitions. The eDirectory column lists the minimum version of eDirectory for the LDAP server to support the syntax.

_Table 1-16_ eDirectory Syntax Definitions

| NDS Name | LDAP Descriptive Name | OID | NDS |
| --- | --- | --- | --- |
| SYN\_STREAM | Binary | 1.3.6.1.4.1.1466.115.121.1.5 | 7.xx |
| SYN\_BOOLEAN | Boolean | 1.3.6.1.4.1.1466.115.121.1.7 | 7.xx |
| SYN\_DIST\_NAME | DN  | 1.3.6.1.4.1.1466.115.121.1.1 1.3.6.1.4.1.1466.115.121.1.12 | 7.xx |
| SYN\_CI\_STRING | Directory String | 1.3.6.1.4.1.1466.115.121.1.3 1.3.6.1.4.1.1466.115.121.1.11 1.3.6.1.4.1.1466.115.121.1.15 1.3.6.1.4.1.1466.115.121.1.16 1.3.6.1.4.1.1466.115.121.1.17 1.3.6.1.4.1.1466.115.121.1.54 1.3.6.1.4.1.1466.115.121.1.57 1.3.6.1.4.1.1466.115.121.1.30 1.3.6.1.4.1.1466.115.121.1.31 1.3.6.1.4.1.1466.115.121.1.32 1.3.6.1.4.1.1466.115.121.1.33 1.3.6.1.4.1.1466.115.121.1.34 1.3.6.1.4.1.1466.115.121.1.35 1.3.6.1.4.1.1466.115.121.1.37 1.3.6.1.4.1.1466.115.121.1.38 1.3.6.1.4.1.1466.115.121.1.39 | 7.xx |
| SYN\_FAX\_NUMBER | Facsimile Telephone Number | 1.3.6.1.4.1.1466.115.121.1.22 | 7.xx |
| SYN\_TIME | Generalized Time | 1.3.6.1.4.1.1466.115.121.1.24 | 7.xx |
| SYN\_CE\_STRING | IA5 String | 1.3.6.1.4.1.1466.115.121.1.26 | 7.xx |
| SYN\_INTEGER | Integer | 1.3.6.1.4.1.1466.115.121.1.27 | 7.xx |
| SYN\_INTERVAL | Integer | 1.3.6.1.4.1.1466.115.121.1.21 1.3.6.1.4.1.1466.115.121.1.27 | 7.xx |
| SYN\_NU\_STRING | Numeric String | 1.3.6.1.4.1.1466.115.121.1.36 | 7.xx |
| SYN\_CLASS\_NAME | OID | 1.3.6.1.4.1.1466.115.121.1.38 | 7.xx |
| SYN\_OCTET\_STRING | Octet String | 1.3.6.1.4.1.1466.115.121.1.1 1.3.6.1.4.1.1466.115.121.1.2 1.3.6.1.4.1.1466.115.121.1.4 1.3.6.1.4.1.1466.115.121.1.6 1.3.6.1.4.1.1466.115.121.1.8 1.3.6.1.4.1.1466.115.121.1.9 1.3.6.1.4.1.1466.115.121.1.10 1.3.6.1.4.1.1466.115.121.1.13 1.3.6.1.4.1.1466.115.121.1.14 1.3.6.1.4.1.1466.115.121.1.18 1.3.6.1.4.1.1466.115.121.1.19 1.3.6.1.4.1.1466.115.121.1.20 1.3.6.1.4.1.1466.115.121.1.21 1.3.6.1.4.1.1466.115.121.1.23 1.3.6.1.4.1.1466.115.121.1.25 1.3.6.1.4.1.1466.115.121.1.28 1.3.6.1.4.1.1466.115.121.1.56 1.3.6.1.4.1.1466.115.121.1.29 1.3.6.1.4.1.1466.115.121.1.55 1.3.6.1.4.1.1466.115.121.1.40 1.3.6.1.4.1.1466.115.121.1.43 1.3.6.1.4.1.1466.115.121.1.42 1.3.6.1.4.1.1466.115.121.1.58 1.3.6.1.4.1.1466.115.121.1.45 1.3.6.1.4.1.1466.115.121.1.46 1.3.6.1.4.1.1466.115.121.1.47 1.3.6.1.4.1.1466.115.121.1.48 1.3.6.1.4.1.1466.115.121.1.49 1.3.6.1.4.1.1466.115.121.1.51 1.3.6.1.4.1.1466.115.121.1.52 1.3.6.1.4.1.1466.115.121.1.53 | 7.xx |
| SYN\_PO\_ADDRESS | Postal Address | 1.3.6.1.4.1.1466.115.121.1.41 | 7.xx |
| SYN\_PR\_STRING | Printable String | 1.3.6.1.4.1.1466.115.121.1.44 | 7.xx |
| SYN\_TEL\_NUMBER | Telephone Number | 1.3.6.1.4.1.1466.115.121.1.50 | 7.xx |
|     |     |     |     |
| SYN\_UNKNOWN | Unknown | 2.16.840.1.113719.1.1.5.1.0 | 7.xx |
| SYN\_CI\_LIST | Case Ignore List | 2.16.840.1.113719.1.1.5.1.6 | 8.5 |
| SYN\_NET\_ADDRESS | Tagged Data | 2.16.840.1.113719.1.1.5.1.12 | 8.3x |
| SYN\_OCTET\_LIST | Octet List | 2.16.840.1.113719.1.1.5.1.13 | 8.5 |
| SYN\_EMAIL\_ADDRESS | Tagged String | 2.16.840.1.113719.1.1.5.1.14 | 8.5 |
| SYN\_PATH | Tagged Name and String | 2.16.840.1.113719.1.1.5.1.15 | 8.3x |
| SYN\_REPLICA\_POINTER | NDS Replica Pointer | 2.16.840.1.113719.1.1.5.1.16 | 8.5 |
| SYN\_OBJECT\_ACL | NDS ACL | 2.16.840.1.113719.1.1.5.1.17 | 8.3x |
| SYN\_TIMESTAMP | NDS Timestamp | 2.16.840.1.113719.1.1.5.1.19 | 8.5 |
| SYN\_COUNTER | Counter | 2.16.840.1.113719.1.1.5.1.22 | 8.5 |
| SYN\_BACK\_LINK | Tagged Name | 2.16.840.1.113719.1.1.5.1.23 | 8.5 |
| SYN\_TYPED\_NAME | Typed Name | 2.16.840.1.113719.1.1.5.1.25 | 8.5 |

Most of the definitions with Novell OIDs (2.16.840.1.113719) are structured and have multiple components. The LDAP server converts such a syntax to case ignore strings, using dollar ($) signs to separate fields of the same data type and (#) signs to separate fields of different data types. See [Attribute Syntax Definitions](http://developer.novell.com/documentation//ndslib/schm_enu/data/h55cqjqs.html#h55cqjqs) in the [NDK: Novell eDirectory Schema Reference](http://developer.novell.com/documentation//ndslib/schm_enu/data/h4q1mn1i.html#h4q1mn1i) for more information.

The SYN\_HOLD syntax is not supported through LDAP and is being discontinued in eDirectory.

### 1.11.9 Auxiliary Classes versus Modifications to Class Definitions

eDirectory and LDAP have had very different conventions about modifying existing object class definitions. Once an object class has been defined in the schema,

		LDAP conventions assume (1) that the attributes for the object class do not change, and (2) that any new attributes will be added through auxiliary classes to the entry rather than to the class definition.
	
		eDirectory conventions allow applications to add new attributes to the class definitions, or with the release of NDS 8, to add new attributes to the entry through auxiliary classes rather than the class definition.
	

To maintain backwards compatibility with NDS releases prior to NDS 8, most eDirectory applications are still adding attributes to class definitions rather than to entries through auxiliary classes.

When accessing eDirectory, you must read the schema to discover all possible attributes for a class definition. If your application accesses more than one eDirectory tree, it must read the schema from each tree because the chance of the schemas being the same is very small.

|     |     |     |
| --- | --- | --- |
|     | [![[./_resources/Novell_Doc_NDK_LDAP_and_eDirectory_Integration_-_LDAP_and_eDirectory_Schema.resources/prev.gif]]](http://developer.novell.com/documentation//ldapover/ldap_enu/data/a3wzcl0.html) ![[./_resources/Novell_Doc_NDK_LDAP_and_eDirectory_Integration_-_LDAP_and_eDirectory_Schema.resources/virt_dot-line.gif]] [![[./_resources/Novell_Doc_NDK_LDAP_and_eDirectory_Integration_-_LDAP_and_eDirectory_Schema.resources/next.gif]]](http://developer.novell.com/documentation//ldapover/ldap_enu/data/ai03rrt.html) |     |

|     |     |
| --- | --- |
| ![[./_resources/Novell_Doc_NDK_LDAP_and_eDirectory_Integration_-_LDAP_and_eDirectory_Schema.resources/h_arrow.gif]] | user comments |

**comment:** there are currently no user comments for this page.
[Add Comment![[./_resources/Novell_Doc_NDK_LDAP_and_eDirectory_Integration_-_LDAP_and_eDirectory_Schema.resources/spacer.gif]]![[./_resources/Novell_Doc_NDK_LDAP_and_eDirectory_Integration_-_LDAP_and_eDirectory_Schema.resources/mm_arrow.gif]]](http://developer.novell.com/docadd/addcomment.php?url=http://developer.novell.com/documentation//ldapover/ldap_enu/data/a3xfo7x.html)
