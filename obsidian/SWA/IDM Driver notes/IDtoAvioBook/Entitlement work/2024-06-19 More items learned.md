

6/18/2024 11:02:43 AM
Joe:
 - Learned lots of little things.  Here's the major items:
   - The complexity of the query exponentially affects results.
   - I can trigger policy side evaluations by adding a temp member 'o=swaiddev' for example!!
   - Adding the avio_pilot entitlement policy can just be added on it's own at the end of our work; and let it work through the night maybe.
   - I can stop the processing by modifying any of the memberQueryURLs while processing; seems to close up work the driver is doing; then it stops the driver.
   - major sticking point now: just trying to find a way to montior progress: if I ahve the trace full blast; which makes a difference now that the processing is faster, I can see each user being tested against eacy policy.

Altea items
**1 - CSEE-3809 - # issue < 100 users to fix - moved to Joe for now
3781 - push on this one . . adjust points . .

2 - Cleanup

https://southwest.atlassian.net/browse/CSEE-3809





Questions to answer:
   - See dynamic membership change trigger revaluation for user . .
   -

Key items:
** - UAT a little longer than normal . .
 - IDtoSoar - working along with AvioBook in QA . .







DirXML-EntitlementRef=cn=SWAReporting-SOAR,cn=IDtoSOAR,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev#1#<ref><src>RBE</src><id>swaiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\SOAR-SWA Reporting GO Submitter</id><param>SWA Reporting GO Submitter</param></ref>


 DETAILS: on complexity of query findings:
  - your 258 job code query takes 1-2 milliseconds to complete checking membership; where avio_piolot still takes 1.5 seconds per user.
  - If I remove my aviopilot during the initial processing; it'll be much faster
     - Each user took .109 seconds to reevaluate, at 47,380 users = 1.5 hours for your whole set!!
   - RBEAEv1_1.log:[06/18/24 12:05:08.018]:RBEAEv1 ST:BEGIN evaluate object @dn='swaiddev\Users\x247270'
     RBEAEv1_1.log:[06/18/24 12:05:08.127]:RBEAEv1 ST:END   evaluate object @dn='swaiddev\Users\x247270'





 - While processing - stopped it by changing avio_poilt

nds dtdversion="3.0">
  <source>
    <product build="20190823_0344" instance="\DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\RBEAEv1" version="4.0.0.0">DirXML Entitlement Service Driver</prod
uct>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <add-association dest-dn="\DEV_SWACO_ID\swaiddev\Users\e190425" event-id="w11dcledirdi019#20240618163510#1#1:89d0d1d6-fb13-4b03-a54c-d6d1d08913fb">{68FEE6FD-71B3-
4C93-B757-FDE6FE68B371}</add-association>
    <add-association dest-dn="\DEV_SWACO_ID\swaiddev\Users\e190424" event-id="w11dcledirdi019#20240618163510#1#1:89d0d1d6-fb13-4b03-a54c-d6d1d08913fb">{8F764616-4293-
4CEF-A5AA-1646768F9342}</add-association>
    <add-association dest-dn="\DEV_SWACO_ID\swaiddev\Users\e190423" event-id="w11dcledirdi019#20240618163510#1#1:89d0d1d6-fb13-4b03-a54c-d6d1d08913fb">{0D4A7A51-0604-
48A4-8F98-517A4A0D0406}</add-association>
    <add-association dest-dn="\DEV_SWACO_ID\swaiddev\Users\e190421" event-id="w11dcledirdi019#20240618163510#1#1:89d0d1d6-fb13-4b03-a54c-d6d1d08913fb">{A3AE87CD-A939-
48C0-8899-CD87AEA339A9}</add-association>
    <add-association dest-dn="\DEV_SWACO_ID\swaiddev\Users\e190420" event-id="w11dcledirdi019#20240618163510#1#1:89d0d1d6-fb13-4b03-a54c-d6d1d08913fb">{55882C97-F3D8-
49AC-BE93-972C8855D8F3}</add-association>
    <status event-id="w11dcledirdi019#20240618163510#1#1:89d0d1d6-fb13-4b03-a54c-d6d1d08913fb" level="fatal" type="driver-status">
      <description>Entitlement policy 'swaiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\AvioBook-Flight-avio_pilot' has been edited.  At least one member
ship query has changed.</description>
      <document xml:space="preserve">&lt;nds dtdversion="4.0" ndsversion="8.x">
        &lt;source>
                &lt;product edition="Advanced" version="4.8.6.0000">DirXML&lt;/product>
                &lt;contact>NetIQ Corporation&lt;/contact>
        &lt;/source>
        &lt;input>
                &lt;modify cached-time="20240618163516.587Z" class-name="DirXML-SharedProfile" event-id="w11dcledirdi019#20240618163510#1#1:89d0d1d6-fb13-4b03-a54c-d6
d1d08913fb" qualified-src-dn="O=swaiddev\OU=Services\OU=DirXML\CN=Driver Set AEv1\CN=Entitlement Policies\CN=SOAR-SWA Reporting GO Submitter" src-dn="\DEV_SWACO_ID\sw
aiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\SOAR-SWA Reporting GO Submitter" src-entry-id="533413" timestamp="1718728510#7408">
                        &lt;association state="associated">{7FBAE517-3B50-4589-BB12-17E5BA7F503B}&lt;/association>
                        &lt;modify-attr attr-name="Member">
                                &lt;add-value>
                                        &lt;value association-ref="{2F5B1882-DB6D-42F6-81EF-82185B2F6DDB}" timestamp="1718728507#2" type="dn">\DEV_SWACO_ID\swaiddev\U
sers\e190443&lt;/value>
                                &lt;/add-value>
                                &lt;add-value>
                                        &lt;value association-ref="{D97DACA8-0899-4AE7-B02B-A8AC7DD99908}" timestamp="1718728507#3" type="dn">\DEV_SWACO_ID\swaiddev\U
sers\e190442&lt;/value>
                                &lt;/add-value>
                                &lt;add-value>
                                        &lt;value associat




ldap:///OU=Users,O=swaiddev??sub?(&(&(|(swatitlecode=ex06)(swatitlecode=pi02)(swatitlecode=pi01)(swatitlecode=mg06)(swatitlecode=m810)(swatitlecode=ex36)(swatitlecode=di90)(swatitlecode=di69)(swatitlecode=dd82)(swatitlecode=dc62)(swatitlecode=dc60)(swatitlecode=dc59)(swatitlecode=951d)(swatitlecode=950d)(swatitlecode=943a)(swatitlecode=933d)(swatitlecode=865c)(swatitlecode=856d)(swatitlecode=808a)(swatitlecode=786a)(swatitlecode=776e)(swatitlecode=745a)(swatitlecode=782d)(swatitlecode=777e)(swatitlecode=723e)(swatitlecode=726d)(swatitlecode=622b)(swatitlecode=620b)(swatitlecode=619b)(swatitlecode=618b)(swatitlecode=615c)(swatitlecode=604b)(swatitlecode=578c)(swatitlecode=575b)(swatitlecode=549b)(swatitlecode=547a)(swatitlecode=503c)(swatitlecode=502a)(swatitlecode=483c)(swatitlecode=471d)(swatitlecode=466e)(swatitlecode=462d)(swatitlecode=461a)(swatitlecode=450d)(swatitlecode=422b)(swatitlecode=421b)(swatitlecode=401a)(swatitlecode=380a)(swatitlecode=355c)(swatitlecode=332d)(swatitlecode=312a)(swatitlecode=290a)(swatitlecode=281b)(swatitlecode=275a)(swatitlecode=269d)(swatitlecode=265b)(swatitlecode=228b)(swatitlecode=224a)(swatitlecode=130a)(swatitlecode=121a)(swatitlecode=107e))(|(swadeptcode=92)(swadeptcode=67)(swadeptcode=44)(swadeptcode=18)(swadeptcode=17)(swadeptcode=08)(swadeptcode=01)))(|(swastatus=l)(swastatus=i)(swastatus=a)))



6/18/2024 10:45:33 AM
 - Major finding pour policy takes 1 millisecond to determine state . .it's just a check for 258 job codes or-ed together; where mine has a check for swaStatus A or L, anded with swaDept 17, and then

 - The main trigger from the policy side is when the member attribute changes. This is a bit of a surprsie to me since I think they say members of a dynamic group arent' enough to trigger an event; but that doesn't seem entirely true . .
 - I can trigger a revaluation from the user side as you know with a #4#
 - Next finding is still in progress:
  - I can trigger a revalation from the policy side by just adding a static member, then removing later
  - I don't know if a driver revaluationtes by default; and it just takes 10 minutes for it to settle; but it may be that when yo ucreate a new large one and just let it sit, it'll eventually get around to processing.




SWA reporting go subitter
  6/18/2024 10:24:19 AM - only took about 13 seconds to get all 47,380 members on the group . .
  6/18/2024 10:27:26 AM - finished entitlement, restarted RBE driver.
  6/18/2024 10:32:52 AM- odd - it only processed 18 members of the group
  6/18/2024 10:36:38 AM- add o=swaiddev - both as a trigger and completion marker.
  6/18/2024 10:36:50 AM - waiting . .
  6/18/2024 10:44:13 AM - seems to have started processing everyone . .
  6/18/2024 10:50:49 AM- still rnning through full


  6/18/2024 11:04:42 AM - done 1000




cn=x85400599,ou=Users,o=swaiddev




6/17/24 18:47:09.696]:RBEAEv1 ST:
DirXML Log Event -------------------
     Driver:   \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\RBEAEv1
     Channel:  Subscriber
     Object:   \DEV_SWACO_ID\swaiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\AvioBook-Flight-avio_chiefs
     Status:   Success
[06/17/24 18:47:09.697]:RBEAEv1 ST:End transaction.
Waiting for data... (interrupt to abort)





6/17/2024 4:21:38 PM
ep normalize steps:
 - remove folding
 - Remove cn=dn
 - remove DirXML-Associations
 - Move sp priorties to bottom as 'add', leaving creation at top
 - cn=ax266698,ou=Admins,o=swaiddev#0#10.9.14.57



[06/17/24 18:41:09.731]:RBEAEv1 ST:     ignoring empty entitlement policy 'swaiddev\Services\DirXML\Driver Set AEv1\Entitlement Policies\AvioBook-Flight-avio_chiefs'



6/17/2024 3:51:29 PM
Joe's Swa reporting Gos ubmitter: about 1:30, 47,374 resutls.


6/17/2024 4:00:27 PM
 - migrate of entitlement policy doesn't seem to reevalutae for all .



#!DATE 2024-06-17T21:48:53.961
#!DATE 2024-06-17T21:50:28.207




#!SEARCH REQUEST (15) OK
#!CONNECTION ldap://w11dcledirdi019.swacorp.com:1636
#!DATE 2024-06-17T21:48:53.961
# LDAP URL     : ldaps://w11dcledirdi019.swacorp.com:1636/o=swaiddev?objectClass?sub?(%7C(jobCode=XDEV)(jobCode=931C)(jobCode=RM01)(jobCode=RM04)(jobCode=CS02)(jobCode=DP01)(jobCode=C005)(jobCode=268B)(jobCode=189D)(jobCode=X89D)(jobCode=AD01)(jobCode=XD01)(jobCode=767A)(jobCode=DP02)(jobCode=174D)(jobCode=DD56)(jobCode=DI95)(jobCode=978A)(jobCode=709D)(jobCode=515A)(jobCode=DI57)(jobCode=295B)(jobCode=591B)(jobCode=DP06)(jobCode=DP05)(jobCode=DP04)(jobCode=DP03)(jobCode=TN40)(jobCode=SU91)(jobCode=TN41)(jobCode=TC52)(jobCode=147B)(jobCode=521D)(jobCode=622B)(jobCode=CS03)(jobCode=833A)(jobCode=265B)(jobCode=473B)(jobCode=701C)(jobCode=210D)(jobCode=TC74)(jobCode=430D)(jobCode=408D)(jobCode=432D)(jobCode=433D)(jobCode=702A)(jobCode=250D)(jobCode=224A)(jobCode=958B)(jobCode=PV01)(jobCode=796C)(jobCode=942A)(jobCode=822D)(jobCode=188B)(jobCode=557D)(jobCode=DC55)(jobCode=976A)(jobCode=867C)(jobCode=818A)(jobCode=354D)(jobCode=667B)(jobCode=139B)(jobCode=475B)(jobCode=539C)(jobCode=383A)(jobCode=520D)(jobCode=315D)(jobCode=957B)(jobCode=TN50)(jobCode=261B)(jobCode=571B)(jobCode=869C)(jobCode=572B)(jobCode=501C)(jobCode=738D)(jobCode=470B)(jobCode=365D)(jobCode=192B)(jobCode=OPCS)(jobCode=PV04)(jobCode=SU54)(jobCode=2RS1)(jobCode=2SAS)(jobCode=CS05)(jobCode=XCGR)(jobCode=XCOR)(jobCode=XM04)(jobCode=XORR)(jobCode=XORS)(jobCode=XP04)(jobCode=XRMS)(jobCode=XROS)(jobCode=XSOA)(jobCode=XSRO)(jobCode=110B)(jobCode=113B)(jobCode=114E)(jobCode=121E)(jobCode=137C)(jobCode=138C)(jobCode=165D)(jobCode=174A)(jobCode=190B)(jobCode=192E)(jobCode=197E)(jobCode=199E)(jobCode=205A)(jobCode=218D)(jobCode=241E)(jobCode=242E)(jobCode=253E)(jobCode=267B)(jobCode=275E)(jobCode=278E)(jobCode=290B)(jobCode=2BS1)(jobCode=2CA1)(jobCode=2CAG)(jobCode=2CS1)(jobCode=2CS2)(jobCode=2CUB)(jobCode=2R1R)(jobCode=2RA1)(jobCode=2RAN)(jobCode=2RAR)(jobCode=2RDM)(jobCode=2RSL)(jobCode=2RSR)(jobCode=2SA1)(jobCode=2SS1)(jobCode=2WBA)(jobCode=2WBN)(jobCode=2WBS)(jobCode=2WCH)(jobCode=2WHB)(jobCode=301A)(jobCode=316C)(jobCode=316E)(jobCode=337E)(jobCode=338A)(jobCode=342D)(jobCode=343C)(jobCode=367E)(jobCode=376A)(jobCode=391C)(jobCode=392C)(jobCode=404A)(jobCode=405A)(jobCode=408A)(jobCode=410C)(jobCode=444A)(jobCode=449A)(jobCode=467B)(jobCode=564B)(jobCode=580D)(jobCode=585D)(jobCode=609C)(jobCode=610D)(jobCode=614D)(jobCode=643B)(jobCode=653D)(jobCode=658D)(jobCode=686C)(jobCode=688C)(jobCode=695A)(jobCode=696A)(jobCode=697A)(jobCode=700A)(jobCode=705D)(jobCode=708D)(jobCode=718D)(jobCode=721B)(jobCode=722B)(jobCode=733B)(jobCode=765B)(jobCode=768C)(jobCode=783A)(jobCode=804B)(jobCode=816D)(jobCode=822A)(jobCode=864D)(jobCode=870A)(jobCode=871D)(jobCode=875A)(jobCode=889A)(jobCode=901C)(jobCode=917D)(jobCode=919A)(jobCode=933B)(jobCode=938C)(jobCode=939C)(jobCode=940C)(jobCode=941C)(jobCode=955D)(jobCode=987B)(jobCode=AD90)(jobCode=CNTR)(jobCode=CS01)(jobCode=CSTS)(jobCode=DC03)(jobCode=DC37)(jobCode=DC42)(jobCode=DI20)(jobCode=GC98)(jobCode=M915)(jobCode=MG05)(jobCode=MX15)(jobCode=MX18)(jobCode=MX48)(jobCode=MX55)(jobCode=MXAR)(jobCode=MXSR)(jobCode=MXST)(jobCode=OP01)(jobCode=OPCA)(jobCode=RRAT)(jobCode=SA94)(jobCode=SC22)(jobCode=SI95)(jobCode=SK01)(jobCode=SKRL)(jobCode=SS96)(jobCode=X01A)(jobCode=X90B)(jobCode=X99E)(jobCode=XA94)(jobCode=XACS)(jobCode=XADF)(jobCode=XCSR)(jobCode=XCST)(jobCode=XDCA)(jobCode=XDCL)(jobCode=XG29)(jobCode=XGAL)(jobCode=XK01)(jobCode=XLCS)(jobCode=XM01)(jobCode=XOAR)(jobCode=XOBA)(jobCode=XOBL)(jobCode=XOCS)(jobCode=XORA)(jobCode=XORN)(jobCode=XP01)(jobCode=XPCA)(jobCode=XRMC)(jobCode=XRMO)(jobCode=XRRD)(jobCode=XS01)(jobCode=XSHL)(jobCode=XSTA)(jobCode=XWAC)(jobCode=XWBR)(jobCode=XWCH)(jobCode=XWCS)(jobCode=XWHS)(jobCode=XWRL)(jobCode=XWRN))
# command line : ldapsearch -H ldaps://w11dcledirdi019.swacorp.com:1636 -x -D "CN=ax266698,ou=admins,o=swaiddev" -W -b "o=swaiddev" -s sub -a always "(|(jobCode=XDEV)(jobCode=931C)(jobCode=RM01)(jobCode=RM04)(jobCode=CS02)(jobCode=DP01)(jobCode=C005)(jobCode=268B)(jobCode=189D)(jobCode=X89D)(jobCode=AD01)(jobCode=XD01)(jobCode=767A)(jobCode=DP02)(jobCode=174D)(jobCode=DD56)(jobCode=DI95)(jobCode=978A)(jobCode=709D)(jobCode=515A)(jobCode=DI57)(jobCode=295B)(jobCode=591B)(jobCode=DP06)(jobCode=DP05)(jobCode=DP04)(jobCode=DP03)(jobCode=TN40)(jobCode=SU91)(jobCode=TN41)(jobCode=TC52)(jobCode=147B)(jobCode=521D)(jobCode=622B)(jobCode=CS03)(jobCode=833A)(jobCode=265B)(jobCode=473B)(jobCode=701C)(jobCode=210D)(jobCode=TC74)(jobCode=430D)(jobCode=408D)(jobCode=432D)(jobCode=433D)(jobCode=702A)(jobCode=250D)(jobCode=224A)(jobCode=958B)(jobCode=PV01)(jobCode=796C)(jobCode=942A)(jobCode=822D)(jobCode=188B)(jobCode=557D)(jobCode=DC55)(jobCode=976A)(jobCode=867C)(jobCode=818A)(jobCode=354D)(jobCode=667B)(jobCode=139B)(jobCode=475B)(jobCode=539C)(jobCode=383A)(jobCode=520D)(jobCode=315D)(jobCode=957B)(jobCode=TN50)(jobCode=261B)(jobCode=571B)(jobCode=869C)(jobCode=572B)(jobCode=501C)(jobCode=738D)(jobCode=470B)(jobCode=365D)(jobCode=192B)(jobCode=OPCS)(jobCode=PV04)(jobCode=SU54)(jobCode=2RS1)(jobCode=2SAS)(jobCode=CS05)(jobCode=XCGR)(jobCode=XCOR)(jobCode=XM04)(jobCode=XORR)(jobCode=XORS)(jobCode=XP04)(jobCode=XRMS)(jobCode=XROS)(jobCode=XSOA)(jobCode=XSRO)(jobCode=110B)(jobCode=113B)(jobCode=114E)(jobCode=121E)(jobCode=137C)(jobCode=138C)(jobCode=165D)(jobCode=174A)(jobCode=190B)(jobCode=192E)(jobCode=197E)(jobCode=199E)(jobCode=205A)(jobCode=218D)(jobCode=241E)(jobCode=242E)(jobCode=253E)(jobCode=267B)(jobCode=275E)(jobCode=278E)(jobCode=290B)(jobCode=2BS1)(jobCode=2CA1)(jobCode=2CAG)(jobCode=2CS1)(jobCode=2CS2)(jobCode=2CUB)(jobCode=2R1R)(jobCode=2RA1)(jobCode=2RAN)(jobCode=2RAR)(jobCode=2RDM)(jobCode=2RSL)(jobCode=2RSR)(jobCode=2SA1)(jobCode=2SS1)(jobCode=2WBA)(jobCode=2WBN)(jobCode=2WBS)(jobCode=2WCH)(jobCode=2WHB)(jobCode=301A)(jobCode=316C)(jobCode=316E)(jobCode=337E)(jobCode=338A)(jobCode=342D)(jobCode=343C)(jobCode=367E)(jobCode=376A)(jobCode=391C)(jobCode=392C)(jobCode=404A)(jobCode=405A)(jobCode=408A)(jobCode=410C)(jobCode=444A)(jobCode=449A)(jobCode=467B)(jobCode=564B)(jobCode=580D)(jobCode=585D)(jobCode=609C)(jobCode=610D)(jobCode=614D)(jobCode=643B)(jobCode=653D)(jobCode=658D)(jobCode=686C)(jobCode=688C)(jobCode=695A)(jobCode=696A)(jobCode=697A)(jobCode=700A)(jobCode=705D)(jobCode=708D)(jobCode=718D)(jobCode=721B)(jobCode=722B)(jobCode=733B)(jobCode=765B)(jobCode=768C)(jobCode=783A)(jobCode=804B)(jobCode=816D)(jobCode=822A)(jobCode=864D)(jobCode=870A)(jobCode=871D)(jobCode=875A)(jobCode=889A)(jobCode=901C)(jobCode=917D)(jobCode=919A)(jobCode=933B)(jobCode=938C)(jobCode=939C)(jobCode=940C)(jobCode=941C)(jobCode=955D)(jobCode=987B)(jobCode=AD90)(jobCode=CNTR)(jobCode=CS01)(jobCode=CSTS)(jobCode=DC03)(jobCode=DC37)(jobCode=DC42)(jobCode=DI20)(jobCode=GC98)(jobCode=M915)(jobCode=MG05)(jobCode=MX15)(jobCode=MX18)(jobCode=MX48)(jobCode=MX55)(jobCode=MXAR)(jobCode=MXSR)(jobCode=MXST)(jobCode=OP01)(jobCode=OPCA)(jobCode=RRAT)(jobCode=SA94)(jobCode=SC22)(jobCode=SI95)(jobCode=SK01)(jobCode=SKRL)(jobCode=SS96)(jobCode=X01A)(jobCode=X90B)(jobCode=X99E)(jobCode=XA94)(jobCode=XACS)(jobCode=XADF)(jobCode=XCSR)(jobCode=XCST)(jobCode=XDCA)(jobCode=XDCL)(jobCode=XG29)(jobCode=XGAL)(jobCode=XK01)(jobCode=XLCS)(jobCode=XM01)(jobCode=XOAR)(jobCode=XOBA)(jobCode=XOBL)(jobCode=XOCS)(jobCode=XORA)(jobCode=XORN)(jobCode=XP01)(jobCode=XPCA)(jobCode=XRMC)(jobCode=XRMO)(jobCode=XRRD)(jobCode=XS01)(jobCode=XSHL)(jobCode=XSTA)(jobCode=XWAC)(jobCode=XWBR)(jobCode=XWCH)(jobCode=XWCS)(jobCode=XWHS)(jobCode=XWRL)(jobCode=XWRN))" "objectClass"
# baseObject   : o=swaiddev
# scope        : wholeSubtree (2)
# derefAliases : derefAlways (3)
# sizeLimit    : 0
# timeLimit    : 0
# typesOnly    : False
# filter       : (|(jobCode=XDEV)(jobCode=931C)(jobCode=RM01)(jobCode=RM04)(jobCode=CS02)(jobCode=DP01)(jobCode=C005)(jobCode=268B)(jobCode=189D)(jobCode=X89D)(jobCode=AD01)(jobCode=XD01)(jobCode=767A)(jobCode=DP02)(jobCode=174D)(jobCode=DD56)(jobCode=DI95)(jobCode=978A)(jobCode=709D)(jobCode=515A)(jobCode=DI57)(jobCode=295B)(jobCode=591B)(jobCode=DP06)(jobCode=DP05)(jobCode=DP04)(jobCode=DP03)(jobCode=TN40)(jobCode=SU91)(jobCode=TN41)(jobCode=TC52)(jobCode=147B)(jobCode=521D)(jobCode=622B)(jobCode=CS03)(jobCode=833A)(jobCode=265B)(jobCode=473B)(jobCode=701C)(jobCode=210D)(jobCode=TC74)(jobCode=430D)(jobCode=408D)(jobCode=432D)(jobCode=433D)(jobCode=702A)(jobCode=250D)(jobCode=224A)(jobCode=958B)(jobCode=PV01)(jobCode=796C)(jobCode=942A)(jobCode=822D)(jobCode=188B)(jobCode=557D)(jobCode=DC55)(jobCode=976A)(jobCode=867C)(jobCode=818A)(jobCode=354D)(jobCode=667B)(jobCode=139B)(jobCode=475B)(jobCode=539C)(jobCode=383A)(jobCode=520D)(jobCode=315D)(jobCode=957B)(jobCode=TN50)(jobCode=261B)(jobCode=571B)(jobCode=869C)(jobCode=572B)(jobCode=501C)(jobCode=738D)(jobCode=470B)(jobCode=365D)(jobCode=192B)(jobCode=OPCS)(jobCode=PV04)(jobCode=SU54)(jobCode=2RS1)(jobCode=2SAS)(jobCode=CS05)(jobCode=XCGR)(jobCode=XCOR)(jobCode=XM04)(jobCode=XORR)(jobCode=XORS)(jobCode=XP04)(jobCode=XRMS)(jobCode=XROS)(jobCode=XSOA)(jobCode=XSRO)(jobCode=110B)(jobCode=113B)(jobCode=114E)(jobCode=121E)(jobCode=137C)(jobCode=138C)(jobCode=165D)(jobCode=174A)(jobCode=190B)(jobCode=192E)(jobCode=197E)(jobCode=199E)(jobCode=205A)(jobCode=218D)(jobCode=241E)(jobCode=242E)(jobCode=253E)(jobCode=267B)(jobCode=275E)(jobCode=278E)(jobCode=290B)(jobCode=2BS1)(jobCode=2CA1)(jobCode=2CAG)(jobCode=2CS1)(jobCode=2CS2)(jobCode=2CUB)(jobCode=2R1R)(jobCode=2RA1)(jobCode=2RAN)(jobCode=2RAR)(jobCode=2RDM)(jobCode=2RSL)(jobCode=2RSR)(jobCode=2SA1)(jobCode=2SS1)(jobCode=2WBA)(jobCode=2WBN)(jobCode=2WBS)(jobCode=2WCH)(jobCode=2WHB)(jobCode=301A)(jobCode=316C)(jobCode=316E)(jobCode=337E)(jobCode=338A)(jobCode=342D)(jobCode=343C)(jobCode=367E)(jobCode=376A)(jobCode=391C)(jobCode=392C)(jobCode=404A)(jobCode=405A)(jobCode=408A)(jobCode=410C)(jobCode=444A)(jobCode=449A)(jobCode=467B)(jobCode=564B)(jobCode=580D)(jobCode=585D)(jobCode=609C)(jobCode=610D)(jobCode=614D)(jobCode=643B)(jobCode=653D)(jobCode=658D)(jobCode=686C)(jobCode=688C)(jobCode=695A)(jobCode=696A)(jobCode=697A)(jobCode=700A)(jobCode=705D)(jobCode=708D)(jobCode=718D)(jobCode=721B)(jobCode=722B)(jobCode=733B)(jobCode=765B)(jobCode=768C)(jobCode=783A)(jobCode=804B)(jobCode=816D)(jobCode=822A)(jobCode=864D)(jobCode=870A)(jobCode=871D)(jobCode=875A)(jobCode=889A)(jobCode=901C)(jobCode=917D)(jobCode=919A)(jobCode=933B)(jobCode=938C)(jobCode=939C)(jobCode=940C)(jobCode=941C)(jobCode=955D)(jobCode=987B)(jobCode=AD90)(jobCode=CNTR)(jobCode=CS01)(jobCode=CSTS)(jobCode=DC03)(jobCode=DC37)(jobCode=DC42)(jobCode=DI20)(jobCode=GC98)(jobCode=M915)(jobCode=MG05)(jobCode=MX15)(jobCode=MX18)(jobCode=MX48)(jobCode=MX55)(jobCode=MXAR)(jobCode=MXSR)(jobCode=MXST)(jobCode=OP01)(jobCode=OPCA)(jobCode=RRAT)(jobCode=SA94)(jobCode=SC22)(jobCode=SI95)(jobCode=SK01)(jobCode=SKRL)(jobCode=SS96)(jobCode=X01A)(jobCode=X90B)(jobCode=X99E)(jobCode=XA94)(jobCode=XACS)(jobCode=XADF)(jobCode=XCSR)(jobCode=XCST)(jobCode=XDCA)(jobCode=XDCL)(jobCode=XG29)(jobCode=XGAL)(jobCode=XK01)(jobCode=XLCS)(jobCode=XM01)(jobCode=XOAR)(jobCode=XOBA)(jobCode=XOBL)(jobCode=XOCS)(jobCode=XORA)(jobCode=XORN)(jobCode=XP01)(jobCode=XPCA)(jobCode=XRMC)(jobCode=XRMO)(jobCode=XRRD)(jobCode=XS01)(jobCode=XSHL)(jobCode=XSTA)(jobCode=XWAC)(jobCode=XWBR)(jobCode=XWCH)(jobCode=XWCS)(jobCode=XWHS)(jobCode=XWRL)(jobCode=XWRN))
# attributes   : objectClass

#!SEARCH RESULT DONE (15) OK
#!CONNECTION ldap://w11dcledirdi019.swacorp.com:1636
#!DATE 2024-06-17T21:50:28.207
# numEntries : 47374


(|
(jobCode=XDEV)
(jobCode=931C)
(jobCode=RM01)
(jobCode=RM04)
(jobCode=CS02)
(jobCode=DP01)
(jobCode=C005)
(jobCode=268B)
(jobCode=189D)
(jobCode=X89D)
(jobCode=AD01)
(jobCode=XD01)
(jobCode=767A)
(jobCode=DP02)
(jobCode=174D)
(jobCode=DD56)
(jobCode=DI95)
(jobCode=978A)
(jobCode=709D)
(jobCode=515A)
(jobCode=DI57)
(jobCode=295B)
(jobCode=591B)
(jobCode=DP06)
(jobCode=DP05)
(jobCode=DP04)
(jobCode=DP03)
(jobCode=TN40)
(jobCode=SU91)
(jobCode=TN41)
(jobCode=TC52)
(jobCode=147B)
(jobCode=521D)
(jobCode=622B)
(jobCode=CS03)
(jobCode=833A)
(jobCode=265B)
(jobCode=473B)
(jobCode=701C)
(jobCode=210D)
(jobCode=TC74)
(jobCode=430D)
(jobCode=408D)
(jobCode=432D)
(jobCode=433D)
(jobCode=702A)
(jobCode=250D)
(jobCode=224A)
(jobCode=958B)
(jobCode=PV01)
(jobCode=796C)
(jobCode=942A)
(jobCode=822D)
(jobCode=188B)
(jobCode=557D)
(jobCode=DC55)
(jobCode=976A)
(jobCode=867C)
(jobCode=818A)
(jobCode=354D)
(jobCode=667B)
(jobCode=139B)
(jobCode=475B)
(jobCode=539C)
(jobCode=383A)
(jobCode=520D)
(jobCode=315D)
(jobCode=957B)
(jobCode=TN50)
(jobCode=261B)
(jobCode=571B)
(jobCode=869C)
(jobCode=572B)
(jobCode=501C)
(jobCode=738D)
(jobCode=470B)
(jobCode=365D)
(jobCode=192B)
(jobCode=OPCS)
(jobCode=PV04)
(jobCode=SU54)
(jobCode=2RS1)
(jobCode=2SAS)
(jobCode=CS05)
(jobCode=XCGR)
(jobCode=XCOR)
(jobCode=XM04)
(jobCode=XORR)
(jobCode=XORS)
(jobCode=XP04)
(jobCode=XRMS)
(jobCode=XROS)
(jobCode=XSOA)
(jobCode=XSRO)
(jobCode=110B)
(jobCode=113B)
(jobCode=114E)
(jobCode=121E)
(jobCode=137C)
(jobCode=138C)
(jobCode=165D)
(jobCode=174A)
(jobCode=190B)
(jobCode=192E)
(jobCode=197E)
(jobCode=199E)
(jobCode=205A)
(jobCode=218D)
(jobCode=241E)
(jobCode=242E)
(jobCode=253E)
(jobCode=267B)
(jobCode=275E)
(jobCode=278E)
(jobCode=290B)
(jobCode=2BS1)
(jobCode=2CA1)
(jobCode=2CAG)
(jobCode=2CS1)
(jobCode=2CS2)
(jobCode=2CUB)
(jobCode=2R1R)
(jobCode=2RA1)
(jobCode=2RAN)
(jobCode=2RAR)
(jobCode=2RDM)
(jobCode=2RSL)
(jobCode=2RSR)
(jobCode=2SA1)
(jobCode=2SS1)
(jobCode=2WBA)
(jobCode=2WBN)
(jobCode=2WBS)
(jobCode=2WCH)
(jobCode=2WHB)
(jobCode=301A)
(jobCode=316C)
(jobCode=316E)
(jobCode=337E)
(jobCode=338A)
(jobCode=342D)
(jobCode=343C)
(jobCode=367E)
(jobCode=376A)
(jobCode=391C)
(jobCode=392C)
(jobCode=404A)
(jobCode=405A)
(jobCode=408A)
(jobCode=410C)
(jobCode=444A)
(jobCode=449A)
(jobCode=467B)
(jobCode=564B)
(jobCode=580D)
(jobCode=585D)
(jobCode=609C)
(jobCode=610D)
(jobCode=614D)
(jobCode=643B)
(jobCode=653D)
(jobCode=658D)
(jobCode=686C)
(jobCode=688C)
(jobCode=695A)
(jobCode=696A)
(jobCode=697A)
(jobCode=700A)
(jobCode=705D)
(jobCode=708D)
(jobCode=718D)
(jobCode=721B)
(jobCode=722B)
(jobCode=733B)
(jobCode=765B)
(jobCode=768C)
(jobCode=783A)
(jobCode=804B)
(jobCode=816D)
(jobCode=822A)
(jobCode=864D)
(jobCode=870A)
(jobCode=871D)
(jobCode=875A)
(jobCode=889A)
(jobCode=901C)
(jobCode=917D)
(jobCode=919A)
(jobCode=933B)
(jobCode=938C)
(jobCode=939C)
(jobCode=940C)
(jobCode=941C)
(jobCode=955D)
(jobCode=987B)
(jobCode=AD90)
(jobCode=CNTR)
(jobCode=CS01)
(jobCode=CSTS)
(jobCode=DC03)
(jobCode=DC37)
(jobCode=DC42)
(jobCode=DI20)
(jobCode=GC98)
(jobCode=M915)
(jobCode=MG05)
(jobCode=MX15)
(jobCode=MX18)
(jobCode=MX48)
(jobCode=MX55)
(jobCode=MXAR)
(jobCode=MXSR)
(jobCode=MXST)
(jobCode=OP01)
(jobCode=OPCA)
(jobCode=RRAT)
(jobCode=SA94)
(jobCode=SC22)
(jobCode=SI95)
(jobCode=SK01)
(jobCode=SKRL)
(jobCode=SS96)
(jobCode=X01A)
(jobCode=X90B)
(jobCode=X99E)
(jobCode=XA94)
(jobCode=XACS)
(jobCode=XADF)
(jobCode=XCSR)
(jobCode=XCST)
(jobCode=XDCA)
(jobCode=XDCL)
(jobCode=XG29)
(jobCode=XGAL)
(jobCode=XK01)
(jobCode=XLCS)
(jobCode=XM01)
(jobCode=XOAR)
(jobCode=XOBA)
(jobCode=XOBL)
(jobCode=XOCS)
(jobCode=XORA)
(jobCode=XORN)
(jobCode=XP01)
(jobCode=XPCA)
(jobCode=XRMC)
(jobCode=XRMO)
(jobCode=XRRD)
(jobCode=XS01)
(jobCode=XSHL)
(jobCode=XSTA)
(jobCode=XWAC)
(jobCode=XWBR)
(jobCode=XWCH)
(jobCode=XWCS)
(jobCode=XWHS)
(jobCode=XWRL)
(jobCode=XWRN)
)





#!DATE 2024-06-17T21:43:59.635


try to find aviopilot:

(DirXML-EntitlementRef=cn=SWA AvioBook Role,cn=IDtoAvioBook,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev#1#*

(DirXML-EntitlementRef=cn=SWA AvioBook Role,cn=IDtoAvioBook,cn=Driver Set AEv1,ou=DirXML,ou=Services,o=swaiddev#1#\<ref\>\<src\>RBE\</src\>\<id\>swaiddev\\Services\\DirXML\\Driver Set AEv1\\Entitlement Policies\\avio_pilot\</id\>\<param\>avil_pilot\</param\>\</ref\>)


12748 with tneitlement . .





aviopilots:
ldap:///OU=Users,O=swaiddev??sub?(&(&(|(swatitlecode=ex06)(swatitlecode=pi02)(swatitlecode=pi01)(swatitlecode=mg06)(swatitlecode=m810)(swatitlecode=ex36)(swatitlecode=di90)(swatitlecode=di69)(swatitlecode=dd82)(swatitlecode=dc62)(swatitlecode=dc60)(swatitlecode=dc59)(swatitlecode=951d)(swatitlecode=950d)(swatitlecode=943a)(swatitlecode=933d)(swatitlecode=865c)(swatitlecode=856d)(swatitlecode=808a)(swatitlecode=786a)(swatitlecode=776e)(swatitlecode=745a)(swatitlecode=782d)(swatitlecode=777e)(swatitlecode=723e)(swatitlecode=726d)(swatitlecode=622b)(swatitlecode=620b)(swatitlecode=619b)(swatitlecode=618b)(swatitlecode=615c)(swatitlecode=604b)(swatitlecode=578c)(swatitlecode=575b)(swatitlecode=549b)(swatitlecode=547a)(swatitlecode=503c)(swatitlecode=502a)(swatitlecode=483c)(swatitlecode=471d)(swatitlecode=466e)(swatitlecode=462d)(swatitlecode=461a)(swatitlecode=450d)(swatitlecode=422b)(swatitlecode=421b)(swatitlecode=401a)(swatitlecode=380a)(swatitlecode=355c)(swatitlecode=332d)(swatitlecode=312a)(swatitlecode=290a)(swatitlecode=281b)(swatitlecode=275a)(swatitlecode=269d)(swatitlecode=265b)(swatitlecode=228b)(swatitlecode=224a)(swatitlecode=130a)(swatitlecode=121a)(swatitlecode=107e))(|(swadeptcode=92)(swadeptcode=67)(swadeptcode=44)(swadeptcode=18)(swadeptcode=17)(swadeptcode=08)(swadeptcode=01)))(|(swastatus=l)(swastatus=i)(swastatus=a)))






ldap:///OU=Users,O=swaiddev??sub?(&(swaDeptCode=17)(|(jobCode=DI95)(jobCode=978A)(jobCode=709D)(jobCode=DI57)(jobCode=867C)(jobCode=601E)(jobCode=295B)(jobCode=354D))(|(swaStatus=A)(swaStatus=L)))


AvioBook-Flight-avio_pilot



6/17/2024 12:38:13 PM
TODO
done  - avio: Run tests in dev: see them pass after rename.
TODO - rename IDtoAvioBook -> IDtoAvioBooks in all /opt/idmlog directories!
TODO - confirm all tests pass with latest changes - chore: CSEE-3778 Rename IDtoAvioBooks to IDtoAvioBook.
todo - rename named password -> <new>aws:dev/IDtoAvioBooks/namedPassword/sub-password</new
TODO - do  idm driver rename - https://support.microfocus.com/kb/doc.php?id=3725423 - does stop driver and take a bit to update associatns.
todo: -= reminber: :when aviobook being cmopletely removed; changing =- false!
    [06/14/24 16:47:21.436]:IDtoAvioBooks ST:    Evaluating selection criteria for rule 'Identify AvioBook Role'.
      [06/14/24 16:47:21.436]:IDtoAvioBooks ST:      (if-op-entitlement 'SWA AvioBook Role' changing) = FALSE.




ldap:///cn=x266698,ou=users,o=swaiddev??sub?



DirXMl-SPUIEditorLock: cn=ax266698,ou=Admins,o=swaiddev#0#10.9.14.164



rbe filter with obj class
<?xml version="1.0" encoding="UTF-8" ?>
<filter>
    <filter-class class-name="User" publisher="ignore" publisher-create-homedir="false" publisher-track-template-member="false" subscriber="sync">
        <filter-attr attr-name="swaTitleCode" merge-authority="edir" publisher="ignore" publisher-optimize-modify="false" subscriber="sync"/>
        <filter-attr attr-name="Object Class" merge-authority="edir" publisher="ignore" publisher-optimize-modify="false" subscriber="sync"/>
        <filter-attr attr-name="CN" merge-authority="edir" publisher="ignore" publisher-optimize-modify="false" subscriber="sync"/>
    </filter-class>
    <filter-class class-name="DirXML-SharedProfile" publisher="ignore" publisher-create-homedir="false" publisher-track-template-member="false" subscriber="sync">
        <filter-attr attr-name="Member" merge-authority="edir" publisher="ignore" publisher-optimize-modify="false" subscriber="sync"/>
        <filter-attr attr-name="excludedMember" merge-authority="edir" publisher="ignore" publisher-optimize-modify="false" subscriber="sync"/>
    </filter-class>
</filter>


DirXMl persistent data:
<?xml version="1.0" encoding="UTF-8"?><persistent-data><op-counters last-reset-time="1711391363738"><subscriber><counters index="0"><modify>52843</modify><add>14639</add><sync>142408</sync><delete>8320</delete><rename>4</rename></counters><counters index="1"><modify>52842</modify><add>14638</add><sync>142408</sync><delete>8308</delete><rename>4</rename></counters><counters index="2"><modify>52647</modify><add>157241</add><delete>8129</delete><rename>4</rename></counters><counters index="3"><modify>52647</modify><add>157241</add><delete>8129</delete><rename>4</rename></counters><counters index="4"><status>218021</status><add-association>156656</add-association></counters></subscriber><publisher/></op-counters></persistent-data>

