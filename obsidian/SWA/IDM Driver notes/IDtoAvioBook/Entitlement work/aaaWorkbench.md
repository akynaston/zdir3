```




<xsl:apply-templates select="//modify/*[@attr-name='DirXML-EntitlementRef']/add-value/value/component[@name='path.xml']/ref/id/text()"/>


User DirXML-EntitlementREf:
cn=x8566069446,ou=Users,o=swaiddev

cn=SWA AvioBook Role,cn=IDtoAvioBooks,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev#1#<ref><src>RBE</src><id>swaiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\avio_pilot</id></ref>


Select revoked value:
//modify/*[@attr-name='DirXML-EntitlementRef']/*/value[component[@name='nameSpace']/text() = '0']/component[@name='path.xml']/ref/id/text()

added value:
//modify/*[@attr-name='DirXML-EntitlementRef']/*/value[component[@name='nameSpace']/text() = '1']/component[@name='path.xml']/ref/id/text()


6/6/2024 1:47:17 PM
Farhanin meeting
1 - IDtoAltea supp office ID revocatoin date fixes

Replace UFM with a tool that's easier to setup.
Doing a secure file copy is something that's been around for a long time



```
































]]![[Pasted image 20240607104139.png]]


AvioFlight-avio_pilot
AvioFlight-avio_dispatchers
AvioFlight-avio_sods
AvioFlight-avio_dispatch_specialists
AvioFlight-avio_atc_specialists
AvioFlight-avio_chiefs
AvioFlight-avio_network_directors
AvioTech-avio_moc_controller
AvioTech-avio_moc_manager
AvioTech-avio_techops_amt
AvioTech-avio_techops_ocmp
AvioTech-avio_techops_safety
AvioTech-avio_techops_asap-ert
AvioTech-avio_cabin_fa
AvioTech-avio_cabin_if_ops
AvioCabin-avio_cabin_fa
AvioCabin-avio_cabin_if_ops


To keep the Entitlement policies organized and make it obvious which AvioBook app applies to which role in the solution, prefix each role with the following
'AvioCabin-' for AvioBook Cabin app roles.
'AvioTech-' for AvioBook Tech app roles.
'AvioFlight-' for AvioBook Flight app roles.

This means that the avio_pilot Flight app role will appear as "AvioFlight-avio_pilot" as the entitlement policy.









ldap:///OU=Users,O=swaiddev??sub?(&(|(swastatus=a)(swastatus=i)(swastatus=l))(&(|(swadeptcode=01)(swadeptcode=08)(swadeptcode=17)(swadeptcode=18)(swadeptcode=44)(swadeptcode=67)(swadeptcode=92))(|(swatitlecode=107e)(swatitlecode=121a)(swatitlecode=130a)(swatitlecode=224a)(swatitlecode=228b)(swatitlecode=265b)(swatitlecode=269d)(swatitlecode=275a)(swatitlecode=281b)(swatitlecode=290a)(swatitlecode=312a)(swatitlecode=332d)(swatitlecode=355c)(swatitlecode=380a)(swatitlecode=401a)(swatitlecode=421b)(swatitlecode=422b)(swatitlecode=450d)(swatitlecode=461a)(swatitlecode=462d)(swatitlecode=466e)(swatitlecode=471d)(swatitlecode=483c)(swatitlecode=502a)(swatitlecode=503c)(swatitlecode=547a)(swatitlecode=549b)(swatitlecode=575b)(swatitlecode=578c)(swatitlecode=604b)(swatitlecode=615c)(swatitlecode=618b)(swatitlecode=619b)(swatitlecode=620b)(swatitlecode=622b)(swatitlecode=726d)(swatitlecode=723e)(swatitlecode=777e)(swatitlecode=782d)(swatitlecode=745a)(swatitlecode=776e)(swatitlecode=786a)(swatitlecode=808a)(swatitlecode=856d)(swatitlecode=865c)(swatitlecode=933d)(swatitlecode=943a)(swatitlecode=950d)(swatitlecode=951d)(swatitlecode=dc59)(swatitlecode=dc60)(swatitlecode=dc62)(swatitlecode=dd82)(swatitlecode=di69)(swatitlecode=di90)(swatitlecode=ex36)(swatitlecode=m810)(swatitlecode=mg06)(swatitlecode=pi01)(swatitlecode=pi02)(swatitlecode=ex06))))
 - deleting memberquery just throws errors -
   Status:   Error
     Message:  <description>novell.jclient.JCException: readEntry (JCValue[] form) -603 ERR_NO_SUCH_ATTRIBUTE</description>
<exception class-name="novell.jclient.JCException">
        <message>readEntry (JCValue[] form): -603</message>
        <stack-trace>novell.jclient.JCException: readEntry (JCValue[] form) -603 ERR_NO_SUCH_ATTRIBUTE
        at novell.jclient.JClient.readEntry(Native Method)



6/14/2024 10:30:20 AM
More detail:

It looks like my crazy avio_pilot memberQueryURL may be the problem here: it is taking 1.5 full seconds to determine membership!!

[06/14/24 11:29:49.196]:RBEAEv1 ST:     time spent determining membership:  1539 ms
[06/14/24 11:29:49.196]:RBEAEv1 ST:     is a member of entitlement policy 'swaiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\avio_pilot


This does not let me get each entitlement value in current-value

![[Pasted image 20240614155243.png]]



![[Pasted image 20240614160630.png]]
