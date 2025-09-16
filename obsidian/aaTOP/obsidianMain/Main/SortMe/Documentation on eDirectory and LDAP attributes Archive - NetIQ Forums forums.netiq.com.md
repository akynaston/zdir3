# Documentation on eDirectory and LDAP attributes [Archive] - NetIQ Forums [forums.netiq.com]

[NetIQ Forums](https://forums.netiq.com/archive/index.php?s=c071ec3804a0c76d6a4e119c1022c7c7) > [PRODUCT DISCUSSION FORUMS](https://forums.netiq.com/archive/index.php/f-1.html?s=c071ec3804a0c76d6a4e119c1022c7c7) > [Identity and Access Governance](https://forums.netiq.com/archive/index.php/f-90.html?s=c071ec3804a0c76d6a4e119c1022c7c7) > [eDirectory](https://forums.netiq.com/archive/index.php/f-16.html?s=c071ec3804a0c76d6a4e119c1022c7c7) > [eDir: Linux](https://forums.netiq.com/archive/index.php/f-50.html?s=c071ec3804a0c76d6a4e119c1022c7c7) > Documentation on eDirectory and LDAP attributes
[PDA](https://forums.netiq.com/archive/index.php/t-46258.html?s=c071ec3804a0c76d6a4e119c1022c7c7&pda=1)

View Full Version : [Documentation on eDirectory and LDAP attributes](https://forums.netiq.com/showthread.php?46258-Documentation-on-eDirectory-and-LDAP-attributes&s=c071ec3804a0c76d6a4e119c1022c7c7)

dschaldenovell
27-Nov-2012, 17:58

Good day,
I was just asked if there is any documentation available that show(s) eDirectory attributes, and how they compare/correspond to LDAP attributes? I checked in the https://www.netiq.com/documentation/edir88/, docs and though I see some headings for LDAP, I'm not really seeing anything that can be used as a guide to the attributes between the two? Any assistance would be very much appreciated.
Thank you,

Lothar Haeger
27-Nov-2012, 18:08

dschaldenovell wrote:
\> I was just asked if there is any documentation available that show(s)
\> eDirectory attributes, and how they compare/correspond to LDAP
\> attributes?
it's configured on the LDAP Group object an edir server is associated with.
Search in iManager for an object named "LDAP Group - Servername" for the
details.
\--

geoffc
27-Nov-2012, 18:18

On 11/27/2012 12:08 PM, Lothar Haeger wrote:
\> dschaldenovell wrote:
\>
\>> I was just asked if there is any documentation available that show(s)
\>> eDirectory attributes, and how they compare/correspond to LDAP
\>> attributes?
\>
\> it's configured on the LDAP Group object an edir server is associated with.
\> Search in iManager for an object named "LDAP Group - Servername" for the
\> details.
And the attribute map is an attribute stored on the object, so you could
just simply LDAP export it from the object in the tree
But I look at the syntax and I think it is Octet string, so it might not
be very readable...

Lothar Haeger
27-Nov-2012, 18:41

Geoffrey Carman wrote:
\> But I look at the syntax and I think it is Octet string, so it might not be
\> very readable...
Readable, but not too nice to look at:
\# extended LDIF
#
\# LDAPv3
\# base <cn=LDAP Group - idv,ou=server,o=services> with scope baseObject
\# filter: (objectclass=\*)
\# requesting: ldapClassList ldapAttributeList
#
\# LDAP Group - idv, server, services
dn: cn=LDAP Group - idv,ou=server,o=services
ldapAttributeList: NDSName=C$LDAPNames=c\\24countryName
ldapAttributeList: NDSName=CN$LDAPNames=cn\\24commonName
ldapAttributeList: NDSName=uniqueID$LDAPNames=uid\\24userId
ldapAttributeList: NDSName=GID$LDAPNames=groupID
ldapAttributeList: NDSName=Description$LDAPNames=description\\24multiL ineDescri
ption
ldapAttributeList: NDSName=Initials$LDAPNames=initials
ldapAttributeList: NDSName=L$LDAPNames=l\\24localityname
ldapAttributeList: NDSName=Internet EMail Address$LDAPNames=mail
ldapAttributeList: NDSName=Member$LDAPNames=member\\24uniqueMember
ldapAttributeList: NDSName=O$LDAPNames=o\\24organizationname
ldapAttributeList: NDSName=OU$LDAPNames=ou\\24organizationalUnitName
ldapAttributeList: NDSName=Owner$LDAPNames=owner
ldapAttributeList: NDSName=dc$LDAPNames=dc
ldapAttributeList: NDSName=Postal Office Box$LDAPNames=postOfficeBox
ldapAttributeList: NDSName=Surname$LDAPNames=sn\\24surname
ldapAttributeList: NDSName=S$LDAPNames=st\\24stateOrProvinceName
ldapAttributeList: NDSName=SA$LDAPNames=street
ldapAttributeList: NDSName=Title$LDAPNames=title
ldapAttributeList: NDSName=Notify$LDAPNames=notify
ldapAttributeList: NDSName=Printer$LDAPNames=printer
ldapAttributeList: NDSName=Queue$LDAPNames=queue
ldapAttributeList: NDSName=Home Directory$LDAPNames=ndsHomeDirectory
ldapAttributeList: NDSName=Path$LDAPNames=path
ldapAttributeList: NDSName=cACertificate$LDAPNames=cACertificate;bina ry\\24cACe
rtificate
ldapAttributeList: NDSName=crossCertificatePair$LDAPNames=crossCertif icatePair
;binary\\24crossCertificatePair
ldapAttributeList: NDSName=Cross Certificate Pair$LDAPNames=ndsCrossCertificat
ePair
ldapAttributeList: NDSName=userCertificate$LDAPNames=userCertificate; binary\\24
userCertificate
ldapAttributeList: NDSName=Operator$LDAPNames=operator
ldapAttributeList: NDSName=Server$LDAPNames=server
ldapAttributeList: NDSName=Status$LDAPNames=status
ldapAttributeList: NDSName=DS Revision$LDAPNames=dsRevision
ldapAttributeList: NDSName=Revision$LDAPNames=revision
ldapAttributeList: NDSName=Serial Number$LDAPNames=serialNumber
ldapAttributeList: NDSName=searchGuide$LDAPNames=searchGuide
ldapAttributeList: NDSName=telexNumber$LDAPNames=telexNumber
ldapAttributeList: NDSName=teletexTerminalIdentifier$LDAPNames=telete xTerminal
Identifier
ldapAttributeList: NDSName=registeredAddress$LDAPNames=registeredAddr ess
ldapAttributeList: NDSName=preferredDeliveryMethod$LDAPNames=preferre dDelivery
Method
ldapAttributeList: NDSName=presentationAddress$LDAPNames=presentation Address
ldapAttributeList: NDSName=supportedApplicationContext$LDAPNames=supp ortedAppl
icationContext
ldapAttributeList: NDSName=Generational Qualifier$LDAPNames=generationQualifie
r
ldapAttributeList: NDSName=x500UniqueIdentifier$LDAPNames=x500UniqueI dentifier
ldapAttributeList: NDSName=enhancedSearchGuide$LDAPNames=enhancedSear chGuide
ldapAttributeList: NDSName=protocolInformation$LDAPNames=protocolInfo rmation
ldapAttributeList: NDSName=supportedAlgorithms$LDAPNames=supportedAlg orithms
ldapAttributeList: NDSName=NSCP:memberCertificateDesc$LDAPNames=membe rCertific
ateDescription
ldapAttributeList: NDSName=NSCP:employeeNumber$LDAPNames=employeeNumb er
ldapAttributeList: NDSName=Login Allowed Time Map$LDAPNames=loginAllowedTimeMa
p
ldapAttributeList: NDSName=Printer Configuration$LDAPNames=printerConfiguratio
n
ldapAttributeList: NDSName=LDAP Host Server$LDAPNames=ldapHostServer
ldapAttributeList: NDSName=LDAP Group$LDAPNames=ldapGroupDN
ldapAttributeList: NDSName=LDAP Screen Level$LDAPNames=ldapTraceLevel
ldapAttributeList: NDSName=LDAP Server Bind Limit$LDAPNames=ldapServerBindLimi
t
ldapAttributeList: NDSName=LDAP Server Idle Timeout$LDAPNames=ldapServerIdleTi
meout
ldapAttributeList: NDSName=LDAP Enable TCP$LDAPNames=ldapEnableTCP
ldapAttributeList: NDSName=LDAP Enable SSL$LDAPNames=ldapEnableSSL
ldapAttributeList: NDSName=LDAP TCP Port$LDAPNames=ldapTCPPort
ldapAttributeList: NDSName=LDAP SSL Port$LDAPNames=ldapSSLPort
ldapAttributeList: NDSName=LDAP Referral$LDAPNames=ldapReferral
ldapAttributeList: NDSName=LDAP Server List$LDAPNames=ldapServerList
ldapAttributeList: NDSName=LDAP Attribute Map v11$LDAPNames=ldapAttributeMap
ldapAttributeList: NDSName=LDAP Class Map v11$LDAPNames=ldapClassMap
ldapAttributeList: NDSName=LDAP Allow Clear Text Password$LDAPNames=ldapAllowC
learTextPassword
ldapAttributeList: NDSName=LDAP Anonymous Identity$LDAPNames=ldapAnonymousIden
tity
ldapAttributeList: NDSName=LDAP Server$LDAPNames=ldapServerDN
ldapAttributeList: NDSName=LDAP:keyMaterialName$LDAPNames=ldapKeyMate rialName
ldapAttributeList: NDSName=LDAP:searchReferralUsage$LDAPNames=ldapSea rchReferr
alUsage
ldapAttributeList: NDSName=memberQuery$LDAPNames=memberQueryURL
ldapAttributeList: NDSName=staticMember$LDAPNames=member;x-static
ldapAttributeList: NDSName=UID$LDAPNames=ndsUID
ldapAttributeList: NDSName=ndspkiCertificateRevocationList$LDAPNames= certifica
teRevocationList;binary\\24certificateRevocationLis t
ldapAttributeList: NDSName=ndspkiAuthorityRevocationList$LDAPNames=au thorityRe
vocationList;binary\\24authorityRevocationList
ldapAttributeList: NDSName=ndspkiDeltaRevocationList$LDAPNames=deltaR evocation
List;binary\\24deltaRevocationList
ldapClassList: NDSName=Alias$LDAPNames=aliasObject
ldapClassList: NDSName=Group$LDAPNames=groupOfNames\\24groupOfUniq ueNames\\24gro
up
ldapClassList: NDSName=User$LDAPNames=inetOrgPerson
ldapClassList: NDSName=NCP Server$LDAPNames=ncpServer
ldapClassList: NDSName=certificationAuthorityVer2$LDAPNames=certi ficationAutho
rity-V2
ldapClassList: NDSName=LDAP Server$LDAPNames=ldapServer
ldapClassList: NDSName=LDAP Group$LDAPNames=ldapGroup
\# search result
search: 3
result: 0 Success
\# numResponses: 2
\# numEntries: 1
\--

dgersic
27-Nov-2012, 19:00

On Tue, 27 Nov 2012 17:04:02 +0000, dschaldenovell wrote:
\> I was just asked if there is any documentation available that show(s)
\> eDirectory attributes, and how they compare/correspond to LDAP
\> attributes?
What question are you trying to answer here? LDAP is a protocol, not
necessarily an implementation of a directory service. eDirectory is a
directory service that offers an LDAP interface.
\--
\--------------------------------------------------------------------------
David Gersic dgersic\_@\_niu.edu
Knowledge Partner http://forums.netiq.com
Please post questions in the forums. No support provided via email.

dschaldenovell
27-Nov-2012, 20:05

I do apologize for the confusion, and the less than clear objective of the question.
When looking at an eDirectory object, for example a user object, when going into the "Other" tab you can see Valued Attributes (DIRXML-Associations EMail Address Object Class,etc,.) and Unvalued Attributes (audio, city, company, etc,.)
What I believe the customer is looking for is something that describes the name of an attribute in eDirectory, and what that attribute would be in LDAP? I hope that helps clear things up, I will also try to get more details from the customer as to what they are exactly looking for.
Thanks so much for the assistance.

dgersic
27-Nov-2012, 21:00

On Tue, 27 Nov 2012 19:14:02 +0000, dschaldenovell wrote:
\> What I believe the customer is looking for is something that describes
\> the name of an attribute in eDirectory, and what that attribute would be
\> in LDAP?
That's just it. There isn't really a list of what it would be called in
LDAP. There is just the name that it is. Well, mostly. There are a couple
of modifications to this. First, there's whatever you may map the name to
in the LDAP Group object. Second, there's a shortcut provided for you,
where invalid characters are removed, so something like "NGW: Object ID"
in eDirectory is available as "ngwobjectid" via LDAP.
\> I hope that helps clear things up, I will also try to get more
\> details from the customer as to what they are exactly looking for.
That'd help.
\--
\--------------------------------------------------------------------------
David Gersic dgersic\_@\_niu.edu
Knowledge Partner http://forums.netiq.com
Please post questions in the forums. No support provided via email.

Daryl Creedy
27-Nov-2012, 21:04

On 11/27/2012 2:14 PM, dschaldenovell wrote:
\>
\> I do apologize for the confusion, and the less than clear objective of
\> the question.
\>
\> When looking at an eDirectory object, for example a user object, when
\> going into the "Other" tab you can see Valued Attributes
\> (DIRXML-Associations EMail Address Object Class,etc,.) and Unvalued
\> Attributes (audio, city, company, etc,.)
\>
\> What I believe the customer is looking for is something that describes
\> the name of an attribute in eDirectory, and what that attribute would be
\> in LDAP? I hope that helps clear things up, I will also try to get more
\> details from the customer as to what they are exactly looking for.
\>
\> Thanks so much for the assistance.
\>
\>
try this:
http://www.novell.com/developer/documentation/ndslib/schm\_enu/?page=/developer/documentation/ndslib/schm\_enu/data/hh1izaro.html
Daryl

hendersj
28-Nov-2012, 22:24

On Tue, 27 Nov 2012 17:41:58 +0000, Lothar Haeger wrote:
\> Readable, but not too nice to look at:
Pretty easy to parse, though - search/replace "\\24" with ":" and then use
":", "=", and "\\" as delimiters after rejoining the split lines together.
You might need to fix up a few attribute names that have : in them, but
it's a fairly easy set of strings to parse.
Jim
\--
Jim Henderson, CNA6, CDE, CNI, LPIC-1, CLA10, CLP10
Novell Knowledge Partner
