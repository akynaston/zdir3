---
tags: ["#ldif","#edir"]
---
# Cool Solutions: LDIF Basics - a BrainShare Perspective

# LDIF Basics - a BrainShare Perspective

## Novell Cool Solutions: Feature

[Rate This Page](http://www.novell.com/inc/rater.jsp?url=http://www.novell.com/coolsolutions/feature/5997.html)

Reader Rating  ![[./_resources/Cool_Solutions_LDIF_Basics_-_a_BrainShare_Perspective.resources/stars_5_0.gif]]  from 7 ratings

* [Printer Friendly](http://www.novell.com/inc/pf/pf.jsp)
* [tell a friend](http://www.novell.com/info/sendemail.jsp?url=http://www.novell.com/coolsolutions/feature/5997.html)

|     |     |
| --- | --- |
| - [Slashdot This](http://slashdot.org/submit.pl)<br>_Posted: 21 Oct 2004_ |     |

**Note**: You can download the recent BrainShare presentation on LDIF Concepts (TUT157) at: <http://www.novell.com/brainshare/catalog/controller/catalog>.

### About LDIF

The LDIF format is used to convey directory information (content records), or a description of a set of changes made to directory entries (change records). An LDIF file consists of a series of records separated by line separators.

Records can be Change Records or Content Records. Content Records are usually the result from an LDAP query. They have a basic format of name-value pairs (usually "attribute name":"some value" - such as CN: David). Change Records contain a set of commands for a particular entry (such as add, delete, or modify). They are used when you want to modify entries within your directory. **Note**: You _cannot_ mix Change Records and Content Records in the same LDIF file.

### LDIF Content Records

**Version Specifier**

The Version Specifier is required by the LDIF specification as the first line in the LDIF file. Spaces are allowed but not required after the colon. For example: version: 1

**Distinguished Name Specifier**

The first line in the content record must be the distinguished name of the entry it is representing. For example:

dn: cn=johndoe, ou=provo, ou=users, o=novell

**Line Delimiters**

Line delimiters can be a newline or a carriage return / newline pair. The LDIF specification requires that every record be terminated with a record delimiter (blank line).

**Attribute Value Specifiers**

Attribute value specifiers are in the following form ... attribute: value

Example: cn: johndoe

### LDIF Conventions

**Line-folding with LDIF files**

There are times when the information required by a field does not fit on one line. To fold a line, insert a line separator at the end of the first line, followed by a space on the second line before the remaining data. The LDIF parser processes this sequence by concatenating the lines and discarding the leading space.

Example:

description: ThereIsSoMuchDataInThisFieldThatI  CannotFitITOnOneLine.

**Comment Specifier**

Lines beginning with the pound (#) sign are treated as comments and are ignored when processing the file. For example:

\# This is a comment line in a LDIF file

**Base64 encoding**

Attribute values can be represented or encoded in Base64. You must use Base64 encoding to represent binary values. For example:

\# Johns password "Password" Base64 encoded
userpassword:: UGFzc3dvcmQ=

**URLs in attribute values specifiers**

URLs are often used with large or long attribute values. They reference the file that contains the data. The format is: file://URL

Example:

version: 1
dn: cn=johndoe, ou=provo, ou=users, o=novell
changetype: modify
add: jpegphoto
jpegphoto:< file:///users/photos/johndoe.jpg

### LDIF Change Records and Changetype Specifiers

The existence of a changetype specifier indicates that the record is a change record. A changetype specifier can be one of the following:

changetype: add
changetype: delete
changetype: modify
changetype: moddn

**Add Changetype**

The Add changetype is used to add new entries to a directory. An Add change record requires values for all of the mandatory attributes of the entry's base class. The objectClass attribute must be set to the base class or to the super classes of the base class.

An LDIF file with multiple add/change records must first add the container entries and then the leaf entries that will reside in the container (unless Forward Referencing is enabled). For example:

version: 1
dn: cn=johndoe, ou=provo, ou=users, o=novell
changetype: add
sn: Doe
givenName: John
objectClass: inetOrgPerson
telephoneNumber: 555 555-5555
mail: jdoe@novell.com
userPassword: Password

**Delete Changetype**

The Delete changeetype is used to delete entries from a Directory. A Delete change record requires two items: the distinguished name of the entry to delete, and the delete changetype. Container entries cannot be deleted unless they are empty. The following example deletes multiple objects:

version: 1
dn: cn=johndoe, ou=provo, ou=users, o=novell
changetype: delete
dn: ou=provo, ou=users, o=novell
changetype: delete
dn: ou=users, o=novell
changetype: delete

**The Modify Changetype**

The Modify changetype is used to modify entries in a Directory. A modify change record uses one or more of the following keywords:

* **add** - Add the following values to the attribute.
* **delete** - Delete the following values from the attribute. **Note**: If no values are specified, all values of the attribute are deleted. If the attribute has no values, the operation fails.
* **replace** - Use the following values to replace the existing attribute values. **Note**: If no values follow, all values of the attribute are deleted. If the attribute has no values, the operation succeeds. If the attribute has any values, all values are deleted and replaced with the specified values.

\* Modify changetype with the Add keyword:

The following example adds a value of jdoe@novell.com to the mail attribute. If the attribute is multi-valued, it adds the value. If the specified value already exists in the attribute, the operation fails.

version: 1
dn: cn=johndoe, ou=provo, ou=users, o=novell
changetype: modify
add: mail
mail: jdoe@novell.com

\* Modify changetype with the Delete keyword

The following example deletes the jdoe@novell.com value from the mail attribute. If the attribute does not contain the specified value, the operation fails. However, if the purpose was to ensure that the specified value did not exist in the attribute, the operation succeeds in achieving this result.

version: 1
dn: cn=johndoe, ou=provo, ou=users, o=novell
changetype: modify
delete: mail
mail: jdoe@novell.com

The following example deletes all values of the mail attribute. If the attribute does not exist, the operation fails. However, if the purpose was to ensure that the attribute has no values, the operation succeeds in achieving this result.

version: 1
dn: cn=johndoe, ou=provo, ou=users, o=novell
changetype: modify
delete: mail

\* Modify changetype with the replace keyword

The following example replaces the existing mail value with the specified value, jdoe@novell.com. If the attribute is multi-valued, all values are removed and the specified value is added. If the attribute doesn't exist, it is added with the specified value.

version: 1
dn: cn=johndoe, ou=provo, ou=users, o=novell
changetype: modify
replace: mail
mail: jdoe@novell.com

\* Modify changetype - specify Multiple Modifications in a single LDIF record)

The following example adds a telephone number, deletes the fax telephone number attribute, and replaces the mail attribute. A line containing only a hyphen character is used to mark the end of an attribute entry.

version: 1
dn: cn=johndoe, ou=provo, ou=users, o=novell
changetype: modify
add: telephonenumber
telephonenumber: 555 555-5555
\-
delete: facsimileTelephoneNumber
\-
replace: mail
mail: jdoe@novell.com

**Moddn Changetype**

You can use an LDIF change record to rename an entry, move it, or do both in one operation. Modifying the DN uses two keywords; moving an entry requires a third keyword. Here are the keywords and descriptions:

* **newrdn** - Indicates that this line contains the new RDN for the entry.
* **deleteoldrdn** - Indicates whether the old RDN value should be deleted: 0=save, 1=delete. When the old value is saved, it becomes an additional attribute value but is no longer part of the entry's distinguished name.
* **newsuperior** - Indicates that this line contains the DN of the new container for the entry.

\* Moddn Changetype - Renaming an Entry

The following example shows how to rename an entry and retain the old value:

version: 1
dn: cn=johndoe, ou=provo, ou=users, o=novell
changetype: moddn
newrdn: cn= jimmydoe
deleteoldrdn: 0

\* Moddn Changetype - Moving an Entry

The following example shows how to move an entry from the provo container to the toronto container:

version: 1
dn: cn=johndoe, ou=provo, ou=users, o=novell
changetype: moddn
newrdn: cn=johndoe
deleteoldrdn: 1
newsuperior: ou=toronto, ou=users, o=novell

\* Moddn Changetype - Renaming and Moving an Entry

The following example shows how to rename and move an entry in the same operation:

version: 1
dn: cn=johndoe, ou=provo, ou=users, o=novell
changetype: moddn
newrdn: cn=jimmydoe
deleteoldrdn: 0
newsuperior: ou=toronto, ou=users, o=novell

#### Reader Comments

* Better than an Excedrin! Thanks for easing my LDIF pain!
* Really useful!
* Even a dummy can understand this
* i don't understand this. - dummy
* Way better than the microsoft documentation! Great job Novell!

[Like what you see?
Sign up for our weekly newsletter. ![[./_resources/Cool_Solutions_LDIF_Basics_-_a_BrainShare_Perspective.resources/h_link-arrow.gif]]](http://www.novell.com/coolsolutions/forms/subscribe.html) 
[Want to contribute?
It could earn you a nano! Learn more. ![[./_resources/Cool_Solutions_LDIF_Basics_-_a_BrainShare_Perspective.resources/h_link-arrow.gif]]](http://www.novell.com/coolsolutions/forms/submit_a_tip.html) 
[Like Wikis?
Join the Cool Solutions Wiki. ![[./_resources/Cool_Solutions_LDIF_Basics_-_a_BrainShare_Perspective.resources/h_link-arrow.gif]]](http://wiki.novell.com/index.php/Cool_Solutions_Wiki_Main_Page) 

|     |     |     |
| --- | --- | --- |
| ![[./_resources/Cool_Solutions_LDIF_Basics_-_a_BrainShare_Perspective.resources/20060127phone.gif]] |     | [Interested?<br>Request a sales call ![[./_resources/Cool_Solutions_LDIF_Basics_-_a_BrainShare_Perspective.resources/h_link-arrow.gif]]](http://www.novell.com/company/sales_call_request.jsp?refid=coolsolutions&unitcode=1-418V23) |

![[./_resources/Cool_Solutions_LDIF_Basics_-_a_BrainShare_Perspective.resources/spacer.gif]]

_Novell Cool Solutions (corporate web communities) are produced by WebWise Solutions. _

[Advertising in Cool Solutions](http://www.novell.com/coolsolutions/ratecard.html)
[Talk to Us](http://www.novell.com/communities/contact)
[Submit Content](http://www.novell.com/communities/node/1394)
[Subscribe](http://www.novell.com/coolsolutions/forms/subscribe.html)
[Cool Solutions Home (New)](http://www.novell.com/communities/coolsolutions)
[Classic Cool Solutions Home](http://www.novell.com/coolsolutions/index.html)
[Authors](http://www.novell.com/coolsolutions/author)
[Cool Blogs](http://www.novell.com/communities/coolblogs)
[Cool Solutions Wiki](http://wiki.novell.com/)
[Cool Tools](http://www.novell.com/communities/coolsolutions/tools)
Get Involved  _\>_
[Open Audio (podcasts)](http://www.novell.com/company/podcasts/openaudio.html)

* **1.800.529.3400** [local numbers](http://www.novell.com/company/contact.html?sourceid=lbanner_contact)
* [Request Call](http://www.novell.com/company/sales_call_request.jsp?sourceidint=lbanner_sc)

[Novell® Making IT Work As One™](http://www.novell.com/company/strategy.html)

* [Careers](http://www.novell.com/company/careers/index.html)
* [Contact Us](http://www.novell.com/company/contacts-offices)
* [Feedback](http://www.novell.com/inc/feedback/feedback.jsp)
* [Legal](http://www.novell.com/company/legal)
* 

© 2009 Novell, Inc. All Rights Reserved.

![[./_resources/Cool_Solutions_LDIF_Basics_-_a_BrainShare_Perspective.resources/0.gif]]
![[./_resources/Cool_Solutions_LDIF_Basics_-_a_BrainShare_Perspective.resources/url-sa=t-26ct=res-26cd=1-26url=http-3A-2F-2Fwww.html%26ei=nJ1gSsH3ONXFmQeqzr3cDA%26rct=j%26q=ldif+rename%26usg=AFQjCNHeuhX6qr20hA1Ak0LpNh49_-bJMQ%26sig2=CfolOoo9TqsmjQSWvTDiCQ&tzo=420&ms=494]]
