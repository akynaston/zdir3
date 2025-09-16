12/7/2010 10:40:10 AM

<nds dtdversion="3.5" ndsversion="8.x">

  <source>

    <product version="3.5.10.20070918 ">DirXML</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <trigger event-id="trigger-job:Password Sync Check#20101207173914#0#0" source="Password Sync Check">

      <operation-data DRIVER_REVISION="X.X" source="Password Sync Check"/>

    </trigger>

  </input>

</nds>

  

Example XML - XDS:

examplexds

  

Move:

<nds dtdversion="3.5" ndsversion="8.x">

  <source>

    <product version="3.6.10.4747">DirXML</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <move cached-time="20091026170256.100Z" class-name="User" event-id="IDVServer#20091026170256#1#3" old-src-dn="\IDV\BSI\LandA\US\DMUsers\Red3_2ch" qualified-old-src-dn="O=BSI\OU=LandA\OU=US\OU=DMUsers\CN=Red3_2ch" qualified-src-dn="O=BSI\OU=LandA\OU=US\OU=Term\CN=Red3_2ch" src-dn="\IDV\BSI\LandA\US\Term\Red3_2ch" src-entry-id="36458" timestamp="1256576531#1">

      <association state="associated">2009.10.26.11.02.14.0219</association>

      <parent qualified-src-dn="O=BSI\OU=LandA\OU=US\OU=Term" src-dn="\IDV\BSI\LandA\US\Term" src-entry-id="34829"/>

      <operation-data DRIVER_REVISION="###REPLACE-DRIVER-REVISION###"/>

    </move>

  </input>

</nds>

modify

  

simple modify

<?xml version="1.0" encoding="UTF-8"?>

<RENAME

  

<?xml version="1.0" encoding="UTF-8"?><nds dtdversion="3.5" ndsversion="8.x">

        <source>

                <product version="?.?.?.?">DirXML</product>

                <contact>Novell, Inc.

     </contact>

        </source>

        <input>

                <modify cached-time="20100120175242.624Z" class-name="User" event-id="TRVIRXP-VM-NDS#20100120175242#1#1" qualified-src-dn="O=users\CN=trash" src-dn="\TESTTREE\users\trash" src-entry-id="34935" timest<RENAMEamp="0#0">

  

                        <modify-attr attr-name="REMOVE_afcuEncopassPersona">

                                <add-value>

                                        <value timestamp="1263578434#49" type="string">FBI1</value>

                                        <value timestamp="1263578434#49" type="string">FBI1</value>

                                        <value timestamp="1263578434#49" type="string">FBI1</value>

                                </add-value>

                                <add-value>

                                        <value timestamp="1263578434#49" type="string">FBI2</value>

                                </add-value>

                                <add-value>

                                        <value timestamp="1263578434#49" type="string">FBI3</value>

                                </add-value><au

                                <remove-value>

                                        <value timestamp="1263578434#49" type="string">FBI4</value>

                                </remove-value>

                                <remove-value>

                                        <value timestamp="1263578434#49" type="string">FBI5</value>

                                </remove-value>

                                <remove-value>

                                        <value timestamp="1263578434#49" type="string">FBI6</value>

                                </remove-value>

                        </modify-attr>

                        <modify-attr attr-name="ACL">

                                    <remove-value>

                                        <value timestamp="1264017201#83" type="structured">

                                                <component name="protectedName">[All Attributes Rights]</component>

                                                <component name="trustee">\TESTTREE\us\U.S. Government\Passport\t\TestUser1_1</component>

                                                <component name="privileges">2</component>

                                        </value>

                                </remove-value>

                                <add-value>

                                        <value timestamp="1264017201#83" type="structured">

                                                <component name="protectedName">addvalue1[All Attributes Rights]</component>

                                                <component name="trustee">\TESTTREE\us\U.S. Government\Passport\t\TestUser1_1</component>

                                                <component name="privileges">4</component>

                                        </value>

                                </add-value>

                        </modify-attr>

  

      <modify-attr attr-name="LoginIntruderAddress">

<add-value>

   <value timestamp="1264017201#25" type="structured">

          <component name="netAddrType">31</component>

          <component name="netAddr">QUMxMTAyMDk=</component>

        </value>

</add-value>

      </modify-attr>

  

      <modify-attr attr-name="DirXML-Associations">

               <add-value>

                  <value timestamp="1264017201#35" type="structured">

                    <component name="nameSpace">1</component>

                    <component name="volume">\TESTTREE\us\INTELINK\Win2k3_ICES\Zimbra</component>

                    <component name="path">FAKEASSOCIATION</component>

                 </value>

                 </add-value>

           </modify-attr>

  

*[@attr-name="DirXML-Associations]//component[contains(@name, '~target-ad-driver-cn~')]

f

  

                </modify>

        </input>

</nds>

XDS add event:

<nds dtdversion="3.5" ndsversion="8.x">

  <source>

    <product version="3.6.10.4747">DirXML</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <add cached-time="20100128175002.517Z" class-name="User" event-id="IDVServer#20100128175002#1#1" qualified-src-dn="O=BSI\OU=LandA\OU=US\OU=DMUsers\CN=Red1_1ch" src-dn="\FCPS\Parents\ckynaston" src-entry-id="42854" timestamp="1264701002#63">

      <add-attr attr-name="ptmUserStateHistory">

        <value timestamp="20130923-20140730" type="string">ZA</value>

        <value timestamp="20140731-9991231" type="string">ZD</value>

        <value timestamp="20130923-20140730" type="string">ZA</value>

        <value timestamp="20140731-9991231" type="string">ZD</value>

        <value timestamp="20130923-20140730" type="string">ZA</value>

        <value timestamp="20140731-9991231" type="string">ZD</value>

        <value timestamp="20130923-20140730" type="string">ZA</value>

        <value timestamp="20140731-9991231" type="string">ZD</value>

        <value timestamp="20130923-20140730" type="string">ZA</value>

        <value timestamp="20140731-9991231" type="string">ZD</value>

        <value timestamp="20130923-20140730" type="string">ZA</value>

        <value timestamp="20140731-9991231" type="string">ZD</value>

      </add-attr>

      <add-attr attr-name="Locked By Intruder">

        <value timestamp="1264701002#58" type="state">false</value>

      </add-attr>

      <add-attr attr-name="UDItsHomePath">

        <value timestamp="1264701002#48" type="string">homedir</value>

      </add-attr>

      <add-attr attr-name="UDIipPhone">

        <value timestamp="1264701002#43" type="string">13193494</value>

      </add-attr>

      <add-attr attr-name="UDItsProfilePath">

        <value timestamp="1264701002#27" type="string">homescriptpath</value>

      </add-attr>

      <add-attr attr-name="L">

        <value timestamp="1264701002#8" type="string">TESTLOC</value>

      </add-attr>

      <add-attr attr-name="Facsimile Telephone Number">

        <value timestamp="1264701002#16" type="structured">

          <component name="faxNumber">888-555-4444</component>

          <component name="faxBitCount">0</component>

          <component name="faxParameters"/>

        </value>

      </add-attr>

      <add-attr attr-name="managerWorkforceID">

        <value timestamp="1264701002#51" type="string">L654321</value>

      </add-attr>

      <add-attr attr-name="UDItsHomeDrive">

        <value timestamp="1264701002#15" type="string">homeDrive</value>

      </add-attr>

      <add-attr attr-name="Title">

        <value timestamp="1264701002#30" type="string">(US SSA)</value>

      </add-attr>

      <add-attr attr-name="UDItargetSystems">

        <value timestamp="1264701002#23" type="string">DUMMY1</value>

      </add-attr>

      <add-attr attr-name="UDItargetSystems">

        <value timestamp="1264701002#24" type="string">DUMMY2</value>

      </add-attr>

      <add-attr attr-name="UDItargetSystems">

        <value timestamp="1264701002#25" type="string">DUMMY3</value>

      </add-attr>

      <add-attr attr-name="UDItargetSystems">

        <value timestamp="1264701002#26" type="string">DUMMY4</value>

      </add-attr>

      <add-attr attr-name="assistant">

        <value timestamp="1264701002#31" type="dn">\IDV\BSI\LandA\US\DMUsers\reitmedj</value>

      </add-attr>

      <add-attr attr-name="Telephone Number">

        <value timestamp="1264701002#6" type="teleNumber">717-225-8169</value>

      </add-attr>

      <add-attr attr-name="UDIdivision">

        <value timestamp="1264701002#55" type="string">USCS</value>

      </add-attr>

      <add-attr attr-name="Initials">

        <value timestamp="1264701002#7" type="string">H</value>

      </add-attr>

      <add-attr attr-name="Given Name">

        <value timestamp="1264701002#35" type="string">Chris</value>

      </add-attr>

      <add-attr attr-name="UDIuserType">

        <value timestamp="1264701002#32" type="string">Employee</value>

      </add-attr>

      <add-attr attr-name="Surname">

        <value timestamp="1264701002#50" type="string">Red1_1cheld</value>

      </add-attr>

      <add-attr attr-name="workforceID">

        <value timestamp="1264701002#22" type="string">L100000</value>

      </add-attr>

      <add-attr attr-name="mobile">

        <value timestamp="1264701002#29" type="teleNumber">717-275-6427</value>

      </add-attr>

      <operation-data DRIVER_REVISION="###REPLACE-DRIVER-REVISION###"/>

    </add>

  </input>

</nds>

  

LDAP driver rename reported on publisher:

  

<nds dtdversion="2.0">

  <source>

    <product build="20090520_001502" instance="SunOneDriver" version="3.5.8">Identity Manager Driver for LDAP</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <modify-association event-id="1">

      <association>cn=sunonetestuser2_8,ou=dmusers,ou=us,ou=landa,o=bsi</association>

      <association>cn=sunonetestuser2_8new,ou=dmusers,ou=us,ou=landa,o=bsi</association>

    </modify-association>

    <rename class-name="account" event-id="2" old-src-dn="cn=sunonetestuser2_8,ou=dmusers,ou=us,ou=landa,o=bsi" remove-old-name="true" src-dn="cn=sunonetestuser2_8new,ou=dmusers,ou=us,ou=landa,o=bsi">
      <association>cn=sunonetestuser2_8new,ou=dmusers,ou=us,ou=landa,o=bsi</association>
      <new-name>SunOneTestUser2_8NEW</new-name>
    </rename>



    <init-params event-id="chgLogNum">

      <publisher-state>

        <change-log-number>560</change-log-number>

      </publisher-state>

    </init-params>

  </input>

</nds>

  

Example context info:

[03/29/10 13:49:27.819]:SunOne PT:Policy returned:

[03/29/10 13:49:27.819]:SunOne PT:

<nds dtdversion="2.0">

  <source>

    <product build="20090520_001502" instance="SunOneDriver" version="3.5.8">Identity Manager Driver for LDAP</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <modify-association event-id="1">

      <association>cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi</association>

      <association>cn=sunonetestuser2_9new,ou=dmusers,ou=us,ou=landa,o=bsi</association>

    </modify-association>

    <rename class-name="User" event-id="2" old-src-dn="cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi" remove-old-name="true" src-dn="cn=sunonetestuser2_9new,ou=dmusers,ou=us,ou=landa,o=bsi">

      <association>cn=sunonetestuser2_9new,ou=dmusers,ou=us,ou=landa,o=bsi</association>

      <new-name>sunonetestuser2_9NEW</new-name>

    </rename>

    <init-params event-id="chgLogNum">

      <publisher-state>

        <change-log-number>832</change-log-number>

      </publisher-state>

    </init-params>

  </input>

</nds>

[03/29/10 13:49:27.822]:SunOne PT:Applying policy: %+C%14CPE-WriteBackRename%-C.

[03/29/10 13:49:27.823]:SunOne PT:  Applying to modify-association #1.

[03/29/10 13:49:27.823]:SunOne PT:    Evaluating selection criteria for rule 'Renames always come with a modify-association'.

[03/29/10 13:49:27.823]:SunOne PT:      (if-operation equal "rename") = FALSE.

[03/29/10 13:49:27.823]:SunOne PT:    Rule rejected.

[03/29/10 13:49:27.824]:SunOne PT:    Evaluating selection criteria for rule 'Renames always come with a modify-association'.

[03/29/10 13:49:27.824]:SunOne PT:      (if-operation equal "rename") = FALSE.

[03/29/10 13:49:27.824]:SunOne PT:    Rule rejected.

[03/29/10 13:49:27.824]:SunOne PT:  Applying to rename #2.

[03/29/10 13:49:27.825]:SunOne PT:    Evaluating selection criteria for rule 'Renames always come with a modify-association'.

[03/29/10 13:49:27.825]:SunOne PT:      (if-operation equal "rename") = TRUE.

[03/29/10 13:49:27.825]:SunOne PT:    Rule selected.

[03/29/10 13:49:27.825]:SunOne PT:    Applying rule 'Renames always come with a modify-association'.

[03/29/10 13:49:27.826]:SunOne PT:      Action: do-set-local-variable("trash",scope="policy",token-xpath("name(.)")).

[03/29/10 13:49:27.826]:SunOne PT:        arg-string(token-xpath("name(.)"))

[03/29/10 13:49:27.826]:SunOne PT:          token-xpath("name(.)")

[03/29/10 13:49:27.827]:SunOne PT:            Token Value: "rename".

[03/29/10 13:49:27.827]:SunOne PT:          Arg Value: "rename".

[03/29/10 13:49:27.827]:SunOne PT:      Action: do-set-local-variable("trash",scope="policy",token-xpath("name(..)")).

[03/29/10 13:49:27.827]:SunOne PT:        arg-string(token-xpath("name(..)"))

[03/29/10 13:49:27.828]:SunOne PT:          token-xpath("name(..)")

[03/29/10 13:49:27.828]:SunOne PT:            Token Value: "input".

[03/29/10 13:49:27.828]:SunOne PT:          Arg Value: "input".

[03/29/10 13:49:27.828]:SunOne PT:      Action: do-set-local-variable("trash",scope="policy",token-xpath("name(../..)")).

[03/29/10 13:49:27.829]:SunOne PT:        arg-string(token-xpath("name(../..)"))

[03/29/10 13:49:27.829]:SunOne PT:          token-xpath("name(../..)")

[03/29/10 13:49:27.829]:SunOne PT:            Token Value: "nds".

[03/29/10 13:49:27.829]:SunOne PT:          Arg Value: "nds".

[03/29/10 13:49:27.830]:SunOne PT:      Action: do-set-local-variable("trash",scope="policy",token-xpath("name(../modify-association)")).

[03/29/10 13:49:27.830]:SunOne PT:        arg-string(token-xpath("name(../modify-association)"))

[03/29/10 13:49:27.830]:SunOne PT:          token-xpath("name(../modify-association)")

[03/29/10 13:49:27.831]:SunOne PT:            Token Value: "".

[03/29/10 13:49:27.831]:SunOne PT:          Arg Value: "".

[03/29/10 13:49:27.831]:SunOne PT:      Action: do-set-local-variable("trash",scope="policy",token-xpath("name(../..)")).

[03/29/10 13:49:27.831]:SunOne PT:        arg-string(token-xpath("name(../..)"))

[03/29/10 13:49:27.832]:SunOne PT:          token-xpath("name(../..)")

[03/29/10 13:49:27.832]:SunOne PT:            Token Value: "nds".

[03/29/10 13:49:27.832]:SunOne PT:          Arg Value: "nds".

[03/29/10 13:49:27.832]:SunOne PT:      Action: do-set-local-variable("trash",scope="policy",token-xpath("name(../../..)")).

[03/29/10 13:49:27.833]:SunOne PT:        arg-string(token-xpath("name(../../..)"))

[03/29/10 13:49:27.833]:SunOne PT:          token-xpath("name(../../..)")

[03/29/10 13:49:27.833]:SunOne PT:            Token Value: "".

[03/29/10 13:49:27.833]:SunOne PT:          Arg Value: "".

[03/29/10 13:49:27.834]:SunOne PT:    Evaluating selection criteria for rule 'Renames always come with a modify-association'.

[03/29/10 13:49:27.834]:SunOne PT:      (if-operation equal "rename") = TRUE.

[03/29/10 13:49:27.834]:SunOne PT:      (if-xpath true "../modify-association") = FALSE.

[03/29/10 13:49:27.835]:SunOne PT:    Rule rejected.

[03/29/10 13:49:27.835]:SunOne PT:  Applying to init-params #3.

[03/29/10 13:49:27.835]:SunOne PT:    Evaluating selection criteria for rule 'Renames always come with a modify-association'.

[03/29/10 13:49:27.835]:SunOne PT:      (if-operation equal "rename") = FALSE.

[03/29/10 13:49:27.836]:SunOne PT:    Rule rejected.

[03/29/10 13:49:27.836]:SunOne PT:    Evaluating selection criteria for rule 'Renames always come with a modify-association'.

[03/29/10 13:49:27.836]:SunOne PT:      (if-operation equal "rename") = FALSE.

[03/29/10 13:49:27.837]:SunOne PT:    Rule rejected.

[03/29/10 13:49:27.837]:SunOne PT:Policy returned:

[03/29/10 13:49:27.837]:SunOne PT:

  

parse dn examples:

[03/29/10 13:56:38.769]:SunOne PT:Policy returned:

[03/29/10 13:56:38.769]:SunOne PT:

<nds dtdversion="2.0">

  <source>

    <product build="20090520_001502" instance="SunOneDriver" version="3.5.8">Identity Manager Driver for LDAP</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <modify-association event-id="1">

      <association>cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi</association>

      <association>cn=sunonetestuser2_9new,ou=dmusers,ou=us,ou=landa,o=bsi</association>

    </modify-association>

    <rename class-name="User" event-id="2" old-src-dn="cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi" remove-old-name="true" src-dn="cn=sunonetestuser2_9new,ou=dmusers,ou=us,ou=landa,o=bsi">

      <association>cn=sunonetestuser2_9new,ou=dmusers,ou=us,ou=landa,o=bsi</association>

      <new-name>sunonetestuser2_9NEW</new-name>

    </rename>

    <init-params event-id="chgLogNum">

      <publisher-state>

        <change-log-number>843</change-log-number>

      </publisher-state>

    </init-params>

  </input>

</nds>

[03/29/10 13:56:38.772]:SunOne PT:Applying policy: %+C%14CPE-WriteBackRename%-C.

[03/29/10 13:56:38.772]:SunOne PT:  Applying to modify-association #1.

[03/29/10 13:56:38.773]:SunOne PT:    Evaluating selection criteria for rule 'Writeback rename event'.

[03/29/10 13:56:38.773]:SunOne PT:      (if-operation equal "rename") = FALSE.

[03/29/10 13:56:38.773]:SunOne PT:    Rule rejected.

[03/29/10 13:56:38.773]:SunOne PT:  Applying to rename #2.

[03/29/10 13:56:38.774]:SunOne PT:    Evaluating selection criteria for rule 'Writeback rename event'.

[03/29/10 13:56:38.774]:SunOne PT:      (if-operation equal "rename") = TRUE.

[03/29/10 13:56:38.774]:SunOne PT:    Rule selected.

[03/29/10 13:56:38.774]:SunOne PT:    Applying rule 'Writeback rename event'.

[03/29/10 13:56:38.775]:SunOne PT:      Action: do-set-local-variable("trash",scope="policy",token-parse-dn(length="-1",start="-1",token-xpath("@old-src-dn"))).

[03/29/10 13:56:38.775]:SunOne PT:        arg-string(token-parse-dn(length="-1",start="-1",token-xpath("@old-src-dn")))

[03/29/10 13:56:38.775]:SunOne PT:          token-parse-dn(length="-1",start="-1",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.776]:SunOne PT:            token-parse-dn(length="-1",start="-1",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.776]:SunOne PT:              token-xpath("@old-src-dn")

[03/29/10 13:56:38.776]:SunOne PT:                Token Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.777]:SunOne PT:              Arg Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.777]:SunOne PT:            Token Value: "sunonetestuser2_9".

[03/29/10 13:56:38.777]:SunOne PT:          Arg Value: "sunonetestuser2_9".

[03/29/10 13:56:38.778]:SunOne PT:      Action: do-set-local-variable("trash",scope="policy",token-parse-dn(length="1",start="-1",token-xpath("@old-src-dn"))).

[03/29/10 13:56:38.778]:SunOne PT:        arg-string(token-parse-dn(length="1",start="-1",token-xpath("@old-src-dn")))

[03/29/10 13:56:38.778]:SunOne PT:          token-parse-dn(length="1",start="-1",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.779]:SunOne PT:            token-parse-dn(length="1",start="-1",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.779]:SunOne PT:              token-xpath("@old-src-dn")

[03/29/10 13:56:38.779]:SunOne PT:                Token Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.780]:SunOne PT:              Arg Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.780]:SunOne PT:            Token Value: "sunonetestuser2_9".

[03/29/10 13:56:38.780]:SunOne PT:          Arg Value: "sunonetestuser2_9".

[03/29/10 13:56:38.781]:SunOne PT:      Action: do-set-local-variable("trash",scope="policy",token-parse-dn(length="2",start="-1",token-xpath("@old-src-dn"))).

[03/29/10 13:56:38.781]:SunOne PT:        arg-string(token-parse-dn(length="2",start="-1",token-xpath("@old-src-dn")))

[03/29/10 13:56:38.781]:SunOne PT:          token-parse-dn(length="2",start="-1",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.782]:SunOne PT:            token-parse-dn(length="2",start="-1",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.782]:SunOne PT:              token-xpath("@old-src-dn")

[03/29/10 13:56:38.782]:SunOne PT:                Token Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.783]:SunOne PT:              Arg Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.783]:SunOne PT:            Token Value: "sunonetestuser2_9".

[03/29/10 13:56:38.783]:SunOne PT:          Arg Value: "sunonetestuser2_9".

[03/29/10 13:56:38.783]:SunOne PT:      Action: do-set-local-variable("trash",scope="policy",token-parse-dn(length="3",start="-1",token-xpath("@old-src-dn"))).

[03/29/10 13:56:38.784]:SunOne PT:        arg-string(token-parse-dn(length="3",start="-1",token-xpath("@old-src-dn")))

[03/29/10 13:56:38.784]:SunOne PT:          token-parse-dn(length="3",start="-1",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.785]:SunOne PT:            token-parse-dn(length="3",start="-1",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.785]:SunOne PT:              token-xpath("@old-src-dn")

[03/29/10 13:56:38.785]:SunOne PT:                Token Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.786]:SunOne PT:              Arg Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.786]:SunOne PT:            Token Value: "sunonetestuser2_9".

[03/29/10 13:56:38.786]:SunOne PT:          Arg Value: "sunonetestuser2_9".

[03/29/10 13:56:38.788]:SunOne PT:      Action: do-set-local-variable("trash",scope="policy",token-parse-dn(length="-1",start="1",token-xpath("@old-src-dn"))).

[03/29/10 13:56:38.788]:SunOne PT:        arg-string(token-parse-dn(length="-1",start="1",token-xpath("@old-src-dn")))

[03/29/10 13:56:38.789]:SunOne PT:          token-parse-dn(length="-1",start="1",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.789]:SunOne PT:            token-parse-dn(length="-1",start="1",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.790]:SunOne PT:              token-xpath("@old-src-dn")

[03/29/10 13:56:38.790]:SunOne PT:                Token Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.790]:SunOne PT:              Arg Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.791]:SunOne PT:            Token Value: "landa\us\dmusers\sunonetestuser2_9".

[03/29/10 13:56:38.791]:SunOne PT:          Arg Value: "landa\us\dmusers\sunonetestuser2_9".

[03/29/10 13:56:38.791]:SunOne PT:      Action: do-set-local-variable("trash",scope="policy",token-parse-dn(length="-1",start="2",token-xpath("@old-src-dn"))).

[03/29/10 13:56:38.792]:SunOne PT:        arg-string(token-parse-dn(length="-1",start="2",token-xpath("@old-src-dn")))

[03/29/10 13:56:38.792]:SunOne PT:          token-parse-dn(length="-1",start="2",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.792]:SunOne PT:            token-parse-dn(length="-1",start="2",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.793]:SunOne PT:              token-xpath("@old-src-dn")

[03/29/10 13:56:38.793]:SunOne PT:                Token Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.793]:SunOne PT:              Arg Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.794]:SunOne PT:            Token Value: "us\dmusers\sunonetestuser2_9".

[03/29/10 13:56:38.794]:SunOne PT:          Arg Value: "us\dmusers\sunonetestuser2_9".

[03/29/10 13:56:38.794]:SunOne PT:      Action: do-set-local-variable("trash",scope="policy",token-parse-dn(length="-1",start="3",token-xpath("@old-src-dn"))).

[03/29/10 13:56:38.795]:SunOne PT:        arg-string(token-parse-dn(length="-1",start="3",token-xpath("@old-src-dn")))

[03/29/10 13:56:38.795]:SunOne PT:          token-parse-dn(length="-1",start="3",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.795]:SunOne PT:            token-parse-dn(length="-1",start="3",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.796]:SunOne PT:              token-xpath("@old-src-dn")

[03/29/10 13:56:38.796]:SunOne PT:                Token Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.796]:SunOne PT:              Arg Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.797]:SunOne PT:            Token Value: "dmusers\sunonetestuser2_9".

[03/29/10 13:56:38.797]:SunOne PT:          Arg Value: "dmusers\sunonetestuser2_9".

[03/29/10 13:56:38.797]:SunOne PT:      Action: do-set-local-variable("trash",scope="policy",token-parse-dn(length="2",start="3",token-xpath("@old-src-dn"))).

[03/29/10 13:56:38.798]:SunOne PT:        arg-string(token-parse-dn(length="2",start="3",token-xpath("@old-src-dn")))

[03/29/10 13:56:38.798]:SunOne PT:          token-parse-dn(length="2",start="3",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.798]:SunOne PT:            token-parse-dn(length="2",start="3",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.799]:SunOne PT:              token-xpath("@old-src-dn")

[03/29/10 13:56:38.799]:SunOne PT:                Token Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.799]:SunOne PT:              Arg Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.800]:SunOne PT:            Token Value: "dmusers\sunonetestuser2_9".

[03/29/10 13:56:38.800]:SunOne PT:          Arg Value: "dmusers\sunonetestuser2_9".

[03/29/10 13:56:38.800]:SunOne PT:      Action: do-rename-src-object(class-name="User",token-parse-dn(length="1",start="-1",token-xpath("@old-src-dn"))).

[03/29/10 13:56:38.801]:SunOne PT:        arg-string(token-parse-dn(length="1",start="-1",token-xpath("@old-src-dn")))

[03/29/10 13:56:38.801]:SunOne PT:          token-parse-dn(length="1",start="-1",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.801]:SunOne PT:            token-parse-dn(length="1",start="-1",token-xpath("@old-src-dn"))

[03/29/10 13:56:38.802]:SunOne PT:              token-xpath("@old-src-dn")

[03/29/10 13:56:38.802]:SunOne PT:                Token Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.802]:SunOne PT:              Arg Value: "cn=sunonetestuser2_9,ou=dmusers,ou=us,ou=landa,o=bsi".

[03/29/10 13:56:38.803]:SunOne PT:            Token Value: "sunonetestuser2_9".

[03/29/10 13:56:38.803]:SunOne PT:          Arg Value: "sunonetestuser2_9".

[03/29/10 13:56:38.803]:SunOne PT:      Action: do-strip-xpath("../modify-association").

[03/29/10 13:56:38.804]:SunOne PT:      Action: do-veto().

[03/29/10 13:56:38.804]:SunOne PT:  Direct command from policy

[03/29/10 13:56:38.804]:SunOne PT:

<nds dtdversion="3.5" ndsversion="8.x">

  

Sun one example delete:

[04/02/10 13:19:49.707]:SunOne PT:SunOneDriver: Changelog:

dn: changenumber=2504,cn=changelog

changeType: delete

changeNumber: 2504

changeTime: 20100402191923Z

targetDn: cn=sunonetestgroup4_7,ou=groups,ou=us,ou=landa,o=bsi

objectClass: top

objectClass: changelogentry

  

[04/02/10 13:19:49.710]:SunOne PT:Receiving DOM document from application.

[04/02/10 13:19:49.710]:SunOne PT:

<nds dtdversion="2.0">

  <source>

    <product build="20090520_001502" instance="SunOneDriver" version="3.5.8">Identity Manager Driver for LDAP</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <delete event-id="1" src-dn="cn=sunonetestgroup4_7,ou=groups,ou=us,ou=landa,o=bsi">

      <association>cn=sunonetestgroup4_7,ou=groups,ou=us,ou=landa,o=bsi</association>

    </delete>

    <init-params event-id="chgLogNum">

      <publisher-state>

        <change-log-number>2504</change-log-number>

      </publisher-state>

    </init-params>

  </input>

</nds>

  

Example ADSID in idm base64 format:

)//instance

  

<nds dtdversion="1.1" ndsversion="8.7">

 <source>

   <product asn1id="" build="20070823_095000" instance="\IV\services\DriverSet1\Active Directory" version="3.5.1">AD</product>

   <contact>Novell, Inc.</contact>

 </source>

 <output>

   <instance class-name="user" event-id="0" src-dn="CN=Manager\, testUserAD3,OU=AUHI,OU=STAFF,DC=qualcomm,DC=com">

     <association>760f8ef8ecf90346b27e36fbf8c9b4a1</association>

     <attr attr-name="mail">

       <value naming="true" type="octet">akynaston@trivir.com</value>

     </attr>

   </instance>

   <instance class-name="user" event-id="0" src-dn="CN=Manager\, testUserAD3,OU=AUHI,OU=STAFF,DC=qualcomm,DC=com">

     <association>760f8ef8ecf90346b27e36fbf8c9b4a1</association>

     <attr attr-name="objectSid">

       <value naming="true" type="octet">AQUAAAAAAAUVAAAAOZr1aNnGAZoDNZ8DXQQAAA==</value>

     </attr>

   </instance>

   <instance class-name="user" event-id="0" src-dn="CN=Manager\, testUserAD3,OU=AUHI,OU=STAFF,DC=qualcomm,DC=com">

     <association>760f8ef8ecf90346b27e36fbf8c9b4a1</association>

     <attr attr-name="objectSid">

       <value naming="true" type="octet">AQUAAAAAAAUVAAAAOZr1aNnGAZoDNZ8DXQQAAA==</value>

     </attr>

   </instance>

   <status event-id="0" level="success"/>

 </output>

</nds>

  

Dump of same user in ldif:

dn: CN=Manager\, testUserAD3,OU=AUHI,OU=STAFF,DC=qualcomm,DC=com

changetype: add

objectClass: top

objectClass: person

objectClass: organizationalPerson

objectClass: user

cn: Manager, testUserAD3

sn: testlast3Manager

distinguishedName: CN=Manager\, testUserAD3,OU=AUHI,OU=STAFF,DC=qualcomm,DC=co

m

instanceType: 4

whenCreated: 20100715204107.0Z

whenChanged: 20100715204140.0Z

displayName: Manager, testUserAD3

uSNCreated: 69709

uSNChanged: 69711

streetAddress:: DQoNCg==

name: Manager, testUserAD3

objectGUID:: dg+O+Oz5A0ayfjb7+Mm0oQ==

userAccountControl: 546

badPwdCount: 0

codePage: 0

countryCode: 0

badPasswordTime: 0

lastLogoff: 0

lastLogon: 0

scriptPath: _logon.vbs

pwdLastSet: 0

primaryGroupID: 513

objectSid:: AQUAAAAAAAUVAAAAOZr1aNnGAZoDNZ8DXQQAAA==

accountExpires: 9223372036854775807

logonCount: 0

sAMAccountName: bob

sAMAccountType: 805306368

userPrincipalName: bob@qualcomm.com

objectCategory: CN=Person,CN=Schema,CN=Configuration,DC=qualcomm,DC=com

  

XML document with an eDirectory guid value - the guid association MIGHT be the same as the value included, or the value included might be thequidk fro mteh other side.

  

<nds dtdversion="3.5" ndsversion="8.x">

 <source>

   <product version="3.5.10.20070918 ">DirXML</product>

   <contact>Novell, Inc.</contact>

 </source>

 <input>

   <add cached-time="20100105221838.343Z" class-name="Group" event-id="DOMAIN2007-NDS#20100105221838#1#1" qualified-src-dn="O=UDLP\OU=GSD\OU=YK\OU=GROUPS\CN=TestGroup4_2" src-dn="\EDIRDEVTREE\UDLP\GSD\YK\GROUPS\TestGroup4_2" src-entry-id="36390" timestamp="1262729918#12">

     <association>{7C4CE1E5-0199-f441-A175-78F7272175BF}</association>

     <add-attr attr-name="GUID">

       <value timestamp="1262729918#12" type="octet">fEzh5QGZ9EGhdXj3JyF1vw==</value>

     </add-attr>

   </add>

 </input>

</nds>

  

member addition - note: association isn't added until the association processor runs . . I don't rememberwhen . but it's not right with the start transaction.

<modify class-name="user" dest-dn="CN=staff095,OU=Staff,OU=Westlawn,OU=ES,DC=idmdev,DC=edu" event-id="Lawson#Publisher#363510_opData4">

 <modify-attr attr-name="member">

   <add-value>

     <value type="string">CN=Shirley\, Nathalie S,OU=Staff,OU=Westlawn,OU=ES,DC=idmdev,DC=edu</value>

   </add-value>

 </modify-attr>

</modify>

  

Trigger example:

  

<nds dtdversion="3.5" ndsversion="8.x">

  <source>

    <product version="3.5.10.20070918 ">DirXML</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <trigger class-name="User" event-id="trigger-job:Synchronize All Passwords#20101111153300#0#0" qualified-src-dn="O=lawson\OU=Users\CN=NewUser" source="Synchronize All Passwords" src-dn="\SLES10TREE\lawson\Users\NewUser" src-entry-id="33415">

      <operation-data source="Synchronize All Passwords"/>

    </trigger>

  </input>

</nds>

  

init-params example:

<nds dtdversion="3.5" ndsversion="8.x">

  <source>

    <product version="3.5.10.20070918 ">DirXML</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <init-params src-dn="\LAWEMSSQA\lawson\idm\Driver Set\LAUAGENUSER\Publisher">

      <driver-filter/>

      <publisher-options>

                <input-dir display-name="Input File Path:"/>

                <input-ext display-name="Input File Extension:"/>

                <input-char-encoding display-name="Source File Character Encoding (leave blank for default):"/>

                <input-rename-ext display-name="Rename File Extension:"/>

                <input-poll-rate display-name="Polling Rate (in seconds):"/>

        </publisher-options>

    </init-params>

  </input>

</nds>

  

identity query:

  

[11/23/10 11:51:48.099]:LAUAGENUSER PT:No input transformation policies.

[11/23/10 11:51:48.100]:LAUAGENUSER PT:No schema mapping policies.

[11/23/10 11:51:48.100]:LAUAGENUSER PT:Resolving association references.

[11/23/10 11:51:48.101]:LAUAGENUSER PT:LAUAGENUSER: PubShim.start - running

[11/23/10 11:51:48.107]:LAUAGENUSER ST:Successfully processed state change event.

[11/23/10 11:51:48.108]:LAUAGENUSER ST:Submitting identification query to subscriber shim:

[11/23/10 11:51:48.108]:LAUAGENUSER ST:

<nds dtdversion="3.5" ndsversion="8.x">

  <source>

    <product version="3.5.10.20070918 ">DirXML</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <query event-id="query-driver-ident" scope="entry">

      <search-class class-name="__driver_identification_class__"/>

      <read-attr attr-name="username"/>

    </query>

  </input>

</nds>

[11/23/10 11:51:48.111]:LAUAGENUSER ST:SubscriptionShim.execute() returned:

[11/23/10 11:51:48.111]:LAUAGENUSER ST:

<nds dtdversion="2.0">

  <source>

    <product build="20070919_1637 " instance="LAUAGENUSER" version="3.5.1">Identity Manager Driver for Delimited Text</product>

  </source>

  <output>

    <instance class-name="__driver_identification_class__">

      <attr attr-name="driver-id">

        <value type="string">TEXT</value>

      </attr>

      <attr attr-name="driver-version">

        <value type="string">3.5.1</value>

      </attr>

      <attr attr-name="min-activation-version">

        <value type="int">2</value>

      </attr>

    </instance>

  </output>

</nds>

[11/23/10 11:51:48.240]:LAUAGENUSER ST:Received state change event.

[11/23/10 11:51:48.242]:LAUAGENUSER ST:Transitioned from state '%+C%14CStarting%-C' to state '%+C%14CRunning%-C'.

[11/23/10 11:51:48.242]:LAUAGENUSER ST:Successfully processed state change event.

  

<nds dtdversion="3.5" ndsversion="8.x">

  <source>

    <product version="3.5.10.20070918 ">DirXML</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <modify cached-time="20101124161503.408Z" class-name="User" event-id="trivir1#20101124161503#1#1" qualified-src-dn="O=lawson\OU=Users\CN=NewUser3" src-dn="\SLES10TREE\lawson\Users\NewUser3" src-entry-id="33417" timestamp="1290615303#7">

      <association state="migrate"></association>

      <modify-attr attr-name="nspmDistributionPassword"><!-- content suppressed --><!-- content suppressed -->

      </modify-attr>

      <operation-data DRIVER_REVISION="X.X"/>

    </modify>

  </input>

</nds>

  

Example of a trigger with no scope . . just sent as an event to event stylesheet!!!

  

<nds dtdversion="3.5" ndsversion="8.x">

  <source>

    <product version="3.5.10.20070918 ">DirXML</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <trigger event-id="trigger-job:Password Sync Check#20101207173914#0#0" source="Password Sync Check">

      <operation-data DRIVER_REVISION="X.X" source="Password Sync Check"/>

    </trigger>

  </input>

</nds>

  

Manual migration:

Note: to do a query

dxcmd -v -user cn=admin,o=services -host localhost -password xxxxxx -migrateapp "cn=AD Non-Employees,cn=Driver Set,ou=idm,o=services" file.xml

  

<nds dtdversion="3.5" ndsversion="8.x">

  <source>

    <product version="3.6.10.4747">DirXML</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <query class-name="user" dest-dn="dc=testdev,dc=com" event-id="0" scope="subtree">

      <search-class class-name="user"/>

      <search-attr attr-name="extensionAttribute1">

        <value timestamp="1253659730#25" type="string">L009915</value>

      </search-attr>

      <read-attr/>

    </query>

  </input>

</nds>

  

standard modify dist from subscriber:

  

<nds dtdversion="3.5" ndsversion="8.x">

  <source>

    <product version="3.6.11.4904">DirXML</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <modify cached-time="20110209214851.553Z" class-name="User" event-id="SAP-HR:O_410_0000000000053957:P+00412377" qualified-src-dn="O=PetSmart\OU=Vault\OU=Users\CN=00412377" src-dn="\IDV-DV\PetSmart\Vault\Users\00412377" src-entry-id="255657" timestamp="1297288131#79">

      <modify-attr attr-name="nspmDistributionPassword"><!-- content suppressed -->

      </modify-attr>

      <operation-data DRIVER_REVISION="3.11"/>

    </modify>

  </input>

</nds>

  

mine I generated:

  

<nds dtdversion="3.5" ndsversion="8.x">

  <source>

    <product version="3.6.11.4904">DirXML</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <modify class-name="User" event-id="IDVDV01-NDS#20110209214920#1#1">

      <association>USd412378</association>

      <modify-attr attr-name="nspmDistributionPassword"><!-- content suppressed --><!-- content suppressed -->

      </modify-attr>

    </modify>

  </input>

</nds>

  

dELETE FROM ad

  

 <nds dtdversion="2.2">

<source>

   <product version="4.0.0">DirXML</product>

   <contact>Novell, Inc.</contact>

</source>

<input>

   <delete event-id="Active Directory##12fc63d5b98##0" src-dn="CN=KenEmployeeGroup\0ADEL:855e3890-2758-4529-a318-d2e6100ed364,CN=Deleted Objects,DC=trivir,DC=com">

     <association>90385e8558272945a318d2e6100ed364</association>

   </delete>

</input>

</nds>

  

add-association

  

<nds ndsversion="8.7" dtdversion="1.1">

     <source>

          <product version="3.5.10" asn1id="" build="20100709_120000" instance="\TRIVIRTEESTTREE2\services\idm\Driver Set\Active Directory">AD</product>

          <contact>Novell, Inc.</contact>

     </source>

     <output>

         <modify

          <status level="success" event-id="Lawson#Publisher#6492"/>

          <status level="success" event-id="Lawson#Publisher#6492_opData1"/>

     </output><modify

</nds>

  

from:

  

<nds dtdversion="3.5" ndsversion="8.x">

     <source>

          <product version="3.5.10.20070918 ">DirXML</product>

          <contact>Novell, Inc.</contact>

     </source>

     <input>

          <add class-name="user" dest-dn="CN=BlackUUU\, Joseph,OU=Staff,OU=Edison,OU=HS,DC=trivirdev,DC=com" event-id="Lawson#Publisher#6492" qualified-src-dn="O=FCPS\OU=Employees\CN=jblackuuu" src-dn="\TRIVIRTEESTTREE2\FCPS\Employees\jblackuuu" src-entry-id="37844">

               <add-attr attr-name="company">

                    <value timestamp="1305906294#9" type="string">Fairfax County Public Schools</value>

               </add-attr>

               <add-attr attr-name="displayName">

                    <value timestamp="1305906294#24" type="string">BlackUUU, Marty</value>

               </add-attr>

               <add-attr attr-name="givenName">

                    <value timestamp="1305906294#20" type="string">Joseph</value>

               </add-attr>

               <add-attr attr-name="physicalDeliveryOfficeName">

                    <value timestamp="1305906294#19" type="string">Edison HS</value>

               </add-attr>

               <add-attr attr-name="department">

                    <value timestamp="1305906294#23" type="string">Cluster 7</value>

               </add-attr>

               <add-attr attr-name="l">

                    <value timestamp="1305906294#26" type="string">Alexandria</value>

               </add-attr>

               <add-attr attr-name="postalCode">

                    <value timestamp="1305906294#28" type="string">22310</value>

               </add-attr>

               <add-attr attr-name="st">

                    <value timestamp="1305906294#27" type="string">VA</value>

               </add-attr>

               <add-attr attr-name="streetAddress">

                    <value>5801 Franconia Rd.</value>

               </add-attr>

               <add-attr attr-name="sn">

                    <value timestamp="1305906294#18" type="string">BlackUUU</value>

               </add-attr>

               <add-attr attr-name="title">

                    <value timestamp="1305906294#8" type="string">Mathematics Tchr, HS</value>

               </add-attr>

               <add-attr attr-name="extensionAttribute5">

                    <value timestamp="130590

DirXML: [05/20/11 09:45:10.23]: 6294#13" type="string">900023</value>

               </add-attr>

               <add-attr attr-name="sAMAccountName">

                    <value>jblackuuu</value>

               </add-attr>

               <add-attr attr-name="dirxml-uACPasswordNotRequired">

                    <value>FALSE</value>

               </add-attr>

               <add-attr attr-name="dirxml-uACAccountDisable">

                    <value type="string">FALSE</value>

               </add-attr>

               <add-attr attr-name="extensionAttribute6">

                    <value type="string">XXXX</value>

               </add-attr>

               <add-attr attr-name="extensionAttribute8">

                    <value type="string">No</value>

               </add-attr>

               <add-attr attr-name="sAMAccountName">

                    <value>jblackuuu</value>

               </add-attr>

               <add-attr attr-name="userPrincipalName">

                    <value type="string">jblackuuu@trivirdev.com</value>

               </add-attr>

               <add-attr attr-name="homeDrive">

                    <value>H:</value>

               </add-attr>

               <add-attr attr-name="homeDirectory">

                    <value>\\edisonhs07\staff$\jblackuuu</value>

               </add-attr>

               <add-attr attr-name="description">

                    <value type="string">Edison HS Mathematics Tchr, HS</value>

               </add-attr>

               <add-attr attr-name="extensionAttribute1">

                    <value timestamp="1305906294#19" type="string">Edison HS</value>

               </add-attr>

               <password><!-- content suppressed --></password>

          </add>

          <modify class-name="user" dest-dn="CN=BlackUUU\, Joseph,OU=Staff,OU=Edison,OU=HS,DC=trivirdev,DC=com" event-id="Lawson#Publisher#6492_opData1" qualified-src-dn="O=FCPS\OU=Employees\CN=jblackuuu" src-dn="\TRIVIRTEESTTREE2\FCPS\Employees\jblackuuu" src-entry-id="37844">

               <modify-attr attr-name="pwdLastSet">

                    <remove-all-values/>

                    <add-value>

                         <value>0</value>

                    </add-value>

               </modify-attr>

          </modify>

     </input>

</nds>

  

SAP publisher xds document from iDoc:

<nds dtdversion="1.0" ndsversion="8.5">

  <source>

    <product build="20101207_122512" instance="SAP-HR" version="3.5.6">DirXML Driver for SAP/HR</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input xmlns:sapshim="http://www.novell.com/dirxml/drivers/SAPShim">

    <modify class-name="P" event-id="SAP-HR:O_016_0000000000680020:P+00001046" src-dn="00001046" timestamp="20111117">

      <association>00001046</association>

      <modify-attr attr-name="P0002:RUFNM:none:234:25">

        <remove-all-values/>

        <add-value>

          <value seqnr="000" timestamp="19491210-99991231">JOHN WAKABAYASHI</value>

        </add-value>

      </modify-attr>

      <modify-attr attr-name="P0032:GEBNR:none:155:6">

        <remove-all-values/>

        <add-value>

          <value seqnr="000" timestamp="20080601-99991231">LDN1</value>

        </add-value>

      </modify-attr>

      <modify-attr attr-name="P0000:STAT2:none:79:1">

        <remove-all-values/>

        <add-value>

          <value seqnr="000" timestamp="20110901-99991231">3</value>

        </add-value>

      </modify-attr>

      <modify-attr attr-name="P0002:PERNR:none:0:8">

        <remove-all-values/>

        <add-value>

          <value seqnr="000" timestamp="19491210-99991231">00001046</value>

        </add-value>

      </modify-attr>

      <modify-attr attr-name="P0002:NAMZU:none:189:15">

        <remove-all-values/>

      </modify-attr>

      <modify-attr attr-name="P0001:ORGEH:none:125:8">

        <remove-all-values/>

        <add-value>

          <value seqnr="000" timestamp="20110901-99991231">00000000</value>

        </add-value>

      </modify-attr>

      <modify-attr attr-name="P0002:MIDNM:none:886:40">

        <remove-all-values/>

      </modify-attr>

      <modify-attr attr-name="P0001:KOSTL:none:115:10">

        <remove-all-values/>

      </modify-attr>

      <modify-attr attr-name="P0001:WERKS:none:78:4">

        <remove-all-values/>

        <add-value>

          <value seqnr="000" timestamp="20110901-99991231">0701</value>

        </add-value>

      </modify-attr>

      <modify-attr attr-name="P0002:NACHN:none:84:25">

        <remove-all-values/>

        <add-value>

          <value seqnr="000" timestamp="19491210-99991231">WAKABAYASHI</value>

        </add-value>

      </modify-attr>

      <modify-attr attr-name="P0002:VORNA:none:134:25">

        <remove-all-values/>

        <add-value>

          <value seqnr="000" timestamp="19491210-99991231">JOHN</value>

        </add-value>

      </modify-attr>

      <modify-attr attr-name="P0001:PLANS:none:133:8">

        <remove-all-values/>

        <add-value>

          <value seqnr="000" timestamp="20110901-99991231">99999999</value>

        </add-value>

      </modify-attr>

      <modify-attr attr-name="P0001:BUKRS:none:74:4">

        <remove-all-values/>

        <add-value>

          <value seqnr="000" timestamp="20110901-99991231">1800</value>

        </add-value>

      </modify-attr>

      <modify-attr attr-name="P0001:ENAME:none:196:40">

        <remove-all-values/>

        <add-value>

          <value seqnr="000" timestamp="20110901-99991231">JOHN WAKABAYASHI</value>

        </add-value>

      </modify-attr>

    </modify>

  </input>

</nds>

  

Manually created DirXML-Associations modify event:

  

<?xml version="1.0" encoding="UTF-8"?>

<nds dtdversion="3.5" ndsversion="8.x">

        <source>

                <product version="?.?.?.?">DirXML</product>

                <contact>Novell, Inc.</contact>

        </source>

        <input>

                <modify cached-time="20100120175242.624Z" class-name="User" event-id="TRVIRXP-VM-NDS#20100120175242#1#1" qualified-src-dn="O=users\CN=trash" src-dn="\TESTTREE\users\trash" src-entry-id="34935" timestamp="0#0">

                    <modify-attr attr-name="DirXML-Associations">

                        <add-value>

                            <value timestamp="1264017201#35" type="structured">

                                <component name="nameSpace">1</component>

                                <component name="volume">\TESTTREE\us\INTELINK\Win2k3_ICES\Zimbra</component>

                                <component name="path">FAKEASSOCIATION</component>

                            </value>

                        </add-value>

                        <add-value>

                            <value timestamp="1264017201#35" type="structured">

                                <component name="nameSpace">1</component>

                                <component name="volume">\TESTTREE\us\INTELINK\Win2k3_ICES\TargetDriverNameHere</component>

                                <component name="path">FAKEASSOCIATION</component>

                            </value>

                        </add-value>

                    </modify-attr>

                </modify>

        </input>

</nds>

  

<nds dtdversion="2.2">

  <source>

    <product build="20120330_120000" instance="\KANSASTREE\services\idm\DriverSet\KUHA" version="4.0.0.0">AD</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <status level="success" type="heartbeat"/>

  </input>

</nds>

  

Sample retry

[09/25/13 13:35:42.482]:IDV-PR:SAP-HR ST:

<nds dtdversion="4.0" ndsversion="8.x">

  <source>

    <product edition="Standard" version="4.0.1.0">DirXML</product>

    <contact>Novell, Inc.</contact>

  </source>

  <input>

    <query event-id="query-driver-ident" scope="entry">

      <search-class class-name="__driver_identification_class__"/>

      <read-attr/>

    </query>

  </input>

</nds>

[09/25/13 13:35:43.483]:IDV-PR:SAP-HR ST:SubscriptionShim.execute() returned:

[09/25/13 13:35:43.483]:IDV-PR:SAP-HR ST:

<nds dtdversion="4.0" ndsversion="8.x">

  <output>

    <status event-id="query-driver-ident" level="retry" type="remoteloader">No connection to remote loader</status>

  </output>

</nds>

[09/25/13 13:35:43.483]:IDV-PR:SAP-HR ST:Requesting 30 second retry delay.

[09/25/13 13:35:43.483]:IDV-PR:SAP-HR ST:

DirXML Log Event -------------------

     Driver:   \IDV-PR\Services\DriverSet\SAP-HR

     Channel:  Subscriber

     Status:   Retry

     Message:  Code(-9006) The driver returned a "retry" status indicating that the operation should be retried later. Detail from driver: No connection to remote loader

[09/25/13 13:35:44.075]:IDV-PR:SAP-HR :Remote Interface Driver: Received.

[09/25/13 13:35:44.076]:IDV-PR:SAP-HR :

  

11/22/2013 10:38:26 AM

<status event-id="0" level="error">Code(-9010) An exception occurred: novell.jclient.JCException: createEntry -606 ERR_ENTRY_ALREADY_EXISTS<operation-data provRef="4f8a84c7:18704338321918848"/>

     <application>DirXML</application>

     <module>Exostar</module>

     <object-dn> (ExternalUsers\jack.black110@fakemail.com)</object-dn>

     <component>Publisher</component>

</status>

  

Entitlement example:

from: https://src.trivir.com/customer/Geico/trunk/SAR/IDM/Drivers/exports/AD%20Geico-V4.xml

  

        <entitlement-definition name="ExchangeMailbox">

            <entitlement conflict-resolution="union" description="The Exchange Mailbox Entitlement grants or denies an Exchange mailbox for the user in Microsoft Exchange." display-name="Exchange Mailbox Entitlement">

                                <values multi-valued="true">

                                        <query-app>

                                                <query-xml>

                                                        <nds dtdversion="2.0">

                                                                <input>

                                                                        <query class-name="msExchPrivateMDB" scope="subtree">

                                                                                <search-class class-name="msExchPrivateMDB"/>

                                                                                <read-attr attr-name="Description"/>

                                                                                <read-attr attr-name="CN"/>

                                                                        </query>

                                                                </input>

                                                        </nds>

                                                </query-xml>

                                                <result-set>

                                                        <display-name>

                                                                <token-attr attr-name="CN"/>

                                                        </display-name>

                                                        <description>

                                                                <token-attr attr-name="Description"/>

                                                        </description>

                                                        <ent-value>

                                                                <token-src-dn/>

                                                        </ent-value>

                                                </result-set>

                                        </query-app>

                                </values>

                        </entitlement>

        </entitlement-definition>

  

exslt example that works through at least hte designer simular . .

  

    <xsl:variable name="testxml">

            <aaron>

                  <washere testvalue="holy cow it worked">found thetesxt</washere>

            </aaron>

        </xsl:variable>

    <xsl:template match="add">

          <xsl:variable name="doc" select="exslt:node-set($testxml)"/>

          <xsl:variable name="PERSONID" select="add-attr[@attr-name='PERSONID']/value/text()"/>

          <soapEvent>

              <foundit><xsl:value-of select="$doc/aaron/washere"/></foundit>

              <foundit><xsl:value-of select="$doc/aaron/washere/@testvalue"/></foundit>

              <PassPhrase>

                    <xsl:value-of select="query:getNamedPassword($srcQueryProcessor,'subAuthPwd-1')"/>

              </PassPhrase>

  

  

This is the user app prov driver startup: userapp 4.0.2 driver Jeremiah installed

<nds dtdversion="1.1" ndsversion="8.6">

  <source>

    <product build="0.20140110.135617" instance="Dorado" version="4.0">User Application Driver</product>

    <contact>Novell Inc.</contact>

  </source>

  <output>

    <instance class-name="__driver_identification_class__">

      <attr attr-name="driver-id">

        <value type="string">UAPROV</value>

      </attr>

      <attr attr-name="driver-version">

        <value type="string">0.20140110.135617</value>

      </attr>

      <attr attr-name="min-activation-version">

        <value type="int">5</value>

      </attr>

    </instance>

  </output>

</nds>

  

The start up policy apperas to get the status document sent by the publisher init function.  a type of startup appears to be added around the the time the startup policy fires; though I don't know if it is available to the startup script.  see this:

  

[05/24/17 09:41:44.217]:AD ST:Successfully processed state change event.

[05/24/17 09:41:44.219]:AD PT:PublicationShim.init() returned:

[05/24/17 09:41:44.219]:AD PT:

<nds dtdversion="4.0" ndsversion="8.x">

  <output>

    <status level="success"/>

  </output>

</nds>

[05/24/17 09:41:44.219]:AD PT:Applying input transformation policies.

[05/24/17 09:41:44.219]:AD PT:Applying policy: %+C%14CI-Scoping%-C.

[05/24/17 09:41:44.219]:AD PT:  Applying to status #1.

[05/24/17 09:41:44.219]:AD PT:    Evaluating selection criteria for rule 'Veto objects coming from the student and computer containers'.

[05/24/17 09:41:44.219]:AD PT:      (if-src-dn available) = FALSE.

[05/24/17 09:41:44.219]:AD PT:    Rule rejected.

[05/24/17 09:41:44.219]:AD PT:    Evaluating selection criteria for rule 'Veto user objects that come with a CN that starts with 'S-''.

[05/24/17 09:41:44.220]:AD PT:      (if-class-name equal "user") = FALSE.

[05/24/17 09:41:44.220]:AD PT:    Rule rejected.

[05/24/17 09:41:44.220]:AD PT:    Evaluating selection criteria for rule 'Veto user objects that are named "CN=Enterprise,CN=Builtin,DC=fcps,DC=edu"'.

[05/24/17 09:41:44.220]:AD PT:      (if-class-name equal "user") = FALSE.

[05/24/17 09:41:44.220]:AD PT:    Rule rejected.

[05/24/17 09:41:44.220]:AD PT:    Evaluating selection criteria for rule 'Strip DN type from homeMDB, homeMTA and distinguishedName instances'.

[05/24/17 09:41:44.220]:AD PT:      (if-operation equal "instance") = FALSE.

[05/24/17 09:41:44.220]:AD PT:    Rule rejected.

[05/24/17 09:41:44.220]:AD PT:    Evaluating selection criteria for rule 'Review password sync status'.

[05/24/17 09:41:44.220]:AD PT:      (if-operation equal "status") = TRUE.

[05/24/17 09:41:44.220]:AD PT:      (if-xpath true "@event-id='user-agent-check-password'") = FALSE.

[05/24/17 09:41:44.220]:AD PT:    Rule rejected.

[05/24/17 09:41:44.220]:AD PT:Policy returned:

[05/24/17 09:41:44.220]:AD PT:

<nds dtdversion="4.0" ndsversion="8.x">

  <output>

    <status level="success"/>

  </output>

</nds>

[05/24/17 09:41:44.220]:AD PT:Applying policy: %+C%14CI-UserAddAssociation%-C.

[05/24/17 09:41:44.220]:AD PT:  Applying to status #1.

[05/24/17 09:41:44.220]:AD PT:    Evaluating selection criteria for rule 'Clear reserved values on successful status events'.

[05/24/17 09:41:44.221]:AD PT:      (if-operation equal "status") = TRUE.

[05/24/17 09:41:44.221]:AD PT:      (if-xpath true "@level = string('success')") = TRUE.

[05/24/17 09:41:44.221]:AD PT:    Rule selected.

[05/24/17 09:41:44.221]:AD PT:    Applying rule 'Clear reserved values on successful status events'.

[05/24/17 09:41:44.221]:AD PT:      Action: do-if().

[05/24/17 09:41:44.221]:AD PT:        Evaluating conditions.

[05/24/17 09:41:44.221]:AD PT:          (if-op-property 'fcpsReservedADCN-set' available) = FALSE.

[05/24/17 09:41:44.221]:AD PT:      Action: do-if().

[05/24/17 09:41:44.221]:AD PT:        Evaluating conditions.

[05/24/17 09:41:44.221]:AD PT:          (if-op-property 'fcpsReservedADUPN-set' available) = FALSE.

[05/24/17 09:41:44.221]:AD PT:      Action: do-if().

[05/24/17 09:41:44.221]:AD PT:        Evaluating conditions.

[05/24/17 09:41:44.221]:AD PT:          (if-op-property 'fcpsReservedADSAM-set' available) = FALSE.

[05/24/17 09:41:44.221]:AD PT:      Action: do-if().

[05/24/17 09:41:44.221]:AD PT:        Evaluating conditions.

[05/24/17 09:41:44.221]:AD PT:          (if-op-property 'fcpsReservedADProxyAddresses-set' available) = FALSE.

[05/24/17 09:41:44.221]:AD PT:    Evaluating selection criteria for rule 'Update DirXML-ADContext if requested by subscriber policies'.

[05/24/17 09:41:44.222]:AD PT:      (if-operation not-equal "status") = FALSE.

[05/24/17 09:41:44.222]:AD PT:    Rule rejected.

[05/24/17 09:41:44.222]:AD PT:    Evaluating selection criteria for rule 'break if not add-association'.

[05/24/17 09:41:44.222]:AD PT:      (if-operation not-equal "add-association") = TRUE.

[05/24/17 09:41:44.222]:AD PT:    Rule selected.

[05/24/17 09:41:44.222]:AD PT:    Applying rule 'break if not add-association'.

[05/24/17 09:41:44.222]:AD PT:      Action: do-break().

[05/24/17 09:41:44.222]:AD PT:Policy returned:

[05/24/17 09:41:44.222]:AD PT:

<nds dtdversion="4.0" ndsversion="8.x">

  <output>

    <status level="success"/>

  </output>

</nds>

[05/24/17 09:41:44.222]:AD PT:Applying policy: %+C%14CI-UserModifyTranslations%-C.

[05/24/17 09:41:44.222]:AD PT:  Applying to status #1.

[05/24/17 09:41:44.222]:AD PT:    Evaluating selection criteria for rule 'Remove CR from line endings in streetAddress'.

[05/24/17 09:41:44.222]:AD PT:      (if-op-attr 'streetAddress' available) = FALSE.

[05/24/17 09:41:44.222]:AD PT:    Rule rejected.

[05/24/17 09:41:44.222]:AD PT:    Evaluating selection criteria for rule 'Transform Locked By Intruder(lockoutTime)'.

[05/24/17 09:41:44.222]:AD PT:      (if-op-attr 'lockoutTime' changing) = FALSE.

[05/24/17 09:41:44.222]:AD PT:    Rule rejected.

[05/24/17 09:41:44.222]:AD PT:Policy returned:

[05/24/17 09:41:44.222]:AD PT:

<nds dtdversion="4.0" ndsversion="8.x">

  <output>

    <status level="success"/>

  </output>

</nds>

[05/24/17 09:41:44.223]:AD PT:Applying policy: %+C%14CPassword(Pub)-Sub Email Notifications%-C.

[05/24/17 09:41:44.223]:AD PT:  Applying to status #1.

[05/24/17 09:41:44.223]:AD PT:    Evaluating selection criteria for rule 'Send e-mail on a failure when subscribing to passwords'.

[05/24/17 09:41:44.223]:AD PT:      (if-operation equal "status") = TRUE.

[05/24/17 09:41:44.223]:AD PT:      (if-global-variable 'notify-user-on-password-dist-failure' equal "true") = FALSE.

[05/24/17 09:41:44.223]:AD PT:    Rule rejected.

[05/24/17 09:41:44.223]:AD PT:    Evaluating selection criteria for rule 'Send e-mail on failure to reset connected system password using the Identity Manager data store password'.

[05/24/17 09:41:44.223]:AD PT:      (if-operation equal "status") = TRUE.

[05/24/17 09:41:44.223]:AD PT:      (if-global-variable 'notify-user-on-password-dist-failure' equal "true") = FALSE.

[05/24/17 09:41:44.223]:AD PT:    Rule rejected.

[05/24/17 09:41:44.223]:AD PT:    Evaluating selection criteria for rule 'Set password sync status on successful password sync'.

[05/24/17 09:41:44.223]:AD PT:      (if-operation equal "status") = TRUE.

[05/24/17 09:41:44.223]:AD PT:      (if-xpath true "@event-id='pwd-subscribe'") = FALSE.

[05/24/17 09:41:44.223]:AD PT:    Rule rejected.

[05/24/17 09:41:44.223]:AD PT:Policy returned:

[05/24/17 09:41:44.223]:AD PT:

<nds dtdversion="4.0" ndsversion="8.x">

  <output>

    <status level="success"/>

  </output>

</nds>

[05/24/17 09:41:44.224]:AD PT:Applying policy: %+C%14Cpub-itp-CompleteDisableContainerMove%-C.

[05/24/17 09:41:44.224]:AD PT:  Applying to status #1.

[05/24/17 09:41:44.224]:AD PT:    Evaluating selection criteria for rule 'Exit if not a status document and no assoc available'.

[05/24/17 09:41:44.224]:AD PT:      (if-operation not-equal "status") = FALSE.

[05/24/17 09:41:44.224]:AD PT:      (if-op-property 'assoc' not-available) = TRUE.

[05/24/17 09:41:44.224]:AD PT:    Rule selected.

[05/24/17 09:41:44.224]:AD PT:    Applying rule 'Exit if not a status document and no assoc available'.

[05/24/17 09:41:44.224]:AD PT:      Action: do-break().

[05/24/17 09:41:44.224]:AD PT:Policy returned:

[05/24/17 09:41:44.224]:AD PT:

<nds dtdversion="4.0" ndsversion="8.x">

  <output>

    <status level="success"/>

  </output>

</nds>

[05/24/17 09:41:44.224]:AD PT:Applying schema mapping policies to input.

[05/24/17 09:41:44.224]:AD PT:Applying policy: %+C%14CSchemaMapping%-C.

[05/24/17 09:41:44.224]:AD PT:Resolving association references.

[05/24/17 09:41:44.224]:AD PT:Applying startup policies.

[05/24/17 09:41:44.224]:AD PT:Applying policy: %+C%14Cstartup%-C.

[05/24/17 09:41:44.224]:AD PT:  Applying to status #1.

[05/24/17 09:41:44.224]:AD PT:    Evaluating selection criteria for rule 'hi'.

[05/24/17 09:41:44.224]:AD PT:    Rule selected.

[05/24/17 09:41:44.224]:AD PT:    Applying rule 'hi'.

[05/24/17 09:41:44.225]:AD PT:Policy returned:

[05/24/17 09:41:44.225]:AD PT:

<nds dtdversion="4.0" ndsversion="8.x">

  <source>

    <product edition="Advanced" version="4.5.2.0">DirXML</product>

    <contact>NetIQ Corporation</contact>

  </source>

  <input>

    <status level="success" type="startup"/>

  </input>

</nds>

[05/24/17 09:41:44.225]:AD PT:Startup policies completed execution. Starting cache processing.

[05/24/17 09:41:44.225]:AD PT:Receiving DOM document from application.

[05/24/17 09:41:44.225]:AD PT:

<nds dtdversion="4.0" ndsversion="8.x">

  <input>

    <query dest-dn="\FCPSIDVTRIVIR\services\idm\Driver Set\Staff" scope="entry">

      <read-attr attr-name="Public Key"/>

    </query>

  </input>

</nds>

[05/24/17 09:41:44.225]:AD PT:Applying input transformation policies.

  

  

  

  

  

Example of shutdown policy being called:

[05/24/17 09:25:13.704]:AD ST:Received state change event.

[05/24/17 09:25:13.704]:AD ST:Transitioned from state '%+C%14CRunning%-C' to state '%+C%14CShutdown Pending%-C'.

[05/24/17 09:25:13.704]:AD ST:Successfully processed state change event.

[05/24/17 09:25:13.705]:AD ST:Leaving event loop.

[05/24/17 09:25:13.705]:AD ST:Shutting down DirXML driver \FCPSIDVTRIVIR\services\idm\Driver Set\Staff.

[05/24/17 09:25:13.705]:AD ST:Applying shutdown policies.

[05/24/17 09:25:13.705]:AD ST:Applying policy: %+C%14Cshutdown%-C.

[05/24/17 09:25:13.705]:AD ST:  Applying to status #1.

[05/24/17 09:25:13.705]:AD ST:    Evaluating selection criteria for rule 'bye'.

[05/24/17 09:25:13.705]:AD ST:    Rule selected.

[05/24/17 09:25:13.705]:AD ST:    Applying rule 'bye'.

[05/24/17 09:25:13.705]:AD ST:Policy returned:

[05/24/17 09:25:13.705]:AD ST:

<nds dtdversion="4.0" ndsversion="8.x">

  <source>

    <product edition="Advanced" version="4.5.2.0">DirXML</product>

    <contact>NetIQ Corporation</contact>

  </source>

  <input>

    <status level="success" type="shutdown"/>

  </input>

</nds>

  

  

  

  

  

  

  

Example init-params doc, with some data hidden:

  

<nds dtdversion="4.0" ndsversion="8.x">

  <source>

    <product edition="Advanced" version="4.5.2.0">DirXML</product>

    <contact>NetIQ Corporation</contact>

  </source>

  <input>

    <init-params src-dn="\FCPSIDVTRIVIR\services\idm\Driver Set\GoogleApps">

      <authentication-info>

        <server>Do not use this configuration field</server>

        <user>Do not use this configuration field</user>

        <password><!-- content suppressed --></password>

      </authentication-info>

      <driver-options>

        <super-user-email-address display-name="Super User">[admin@idmunit.org](mailto:admin@idmunit.org)</super-user-email-address>

        <service-account-email-address display-name="Service Account Email Address">[fcpsgoogleapps@infinite-facet-135520.iam.gserviceaccount.com](mailto:fcpsgoogleapps@infinite-facet-135520.iam.gserviceaccount.com)</service-account-email-address>

        <key-format display-name="Private Key Format">PEM</key-format>

        <service-account-key display-name="Key">-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCo+mMnlrND2ED8\nrGunysbNI7ezDB2ABf08WN4qKcYECllReOD6QTWiLa6HxgO+zr/zgNas1GZsLY6/\n6anyVPyMNohifLQIrCjSLIZEZ/3i3PxfbRKAwiexXyvVSwU4KQkVxbcVrcHO/aBX\neP5bY+DRrQzYhaywNF2UY9xMwkcYoqZ8TZotC1SRh0R3ycYKBFbusa0GfQHgZC4A\nsJOPF2re4ligO+IUEy6Xycd/HErepmktYF4gVAU9UO+CP1DJWZa0XCwGpVJgDc3n\nEodmqM+WhJXEs81Tgt57chtRyHaTyHS478djIg5uzBgCt+Qvld0KpAk7qd+CUzOY\nB4DVNtO7AgMBAAECggEABdO8n5zeybQnaY84lyyy9lgI+a+tRMDwHqih4KpYHcON\nmPWmLHsbMmCI6D2321id3fPPc15PueNITO3t4mFz5BHtWhgazUHClpzadHlxk+Uy\n/sdwH+iSHde+VzijEXC403th+OlpCY5NfTa67sPe+NwS2VSiw+DKaVeYPT1l3j+P\nPUWfdynFVM28PWp7T6QP36RDbe37Sprwvdh3zUGeim1RbtSzlCiAgPUX3sDzw/m7\ncBcVD7hqDLJN5tDa6S0Lvg47dpUV1A2+trZDiWco6Q7zyIx3atyrCmOykiE7Wn8P\nFsotsQUr26abI0F8ibSj3i8HQlBl6MLQFqNCrwd2YQKBgQDkw/q05Tdqa7MrAIil\n+StZ+4W9B1vRknozVKC0XmA0gD4f9A2Js8tGCbDHw5y7nggkLSco1WbyI7qSkrkG\nwrC9+2GA8LTD1GWE8vL+rWC+bhwOhiBbkvSfdSqzr5NLZKM+rqsXpyQ2i+c587qL\ng7es7C+6AE8Gk5p6KqNzwjbupQKBgQC9GEhkDwzy6wgWY+qAVcoXQ1q2NG9vq+fJ\npgjjhqSoi4OdPkoqEBLSMCAnn1Am71gbHAewq7jElpolh+f2bRCAeGppS1fRBZbA\n+P8cBKSwn5amHJC6xuOqg+4JLrCyPOsI+VwxaTQdkfas6cPTjWCAc079+bHRGTse\nwb2dWliK3wKBgQDcwvNRVlHf9Qb13JIB+S6Iq10oSc2ltIEQv/5FkT2t7IQHOfFG\njacAc6GRZYf+1kZtAtXjZezuhuQpRkYf7Am7jLdPQvpucK13Wyx78LyHiKKysWTQ\nekRvDRakSC8QdpHCj7S0Iqujp+b/2eCPehDqYxK7oEiixBYzBqqtryJrsQKBgEsM\nCh78Ai2erfUE7prEcZJN/wB1SwzM8w8KwFhcpZjm1fNgN1r+Shn1U62mAs+RCiyo\nMT0iyg/rnX3rtFoO6w+xurnTVyTzzOMFb2oVRa97hvSiPaaDLPQNrDkkuKfkmXtU\nTAyoLjDWL0ps9HVPlM8l9GHD6ZiNJPON/M0ogB+NAoGAFiu9S3+nkCPhVNBUWAzZ\nGnkR+EOmVxzRaHFhwAI9jl9GbYGWO1B2MjQQUXmElGgLXOOOy1+y9dn+xr7o+Ewy\nBubftKT9aFcXns3pcglhDsf+M4izizshAoEQ4D15EyLkdjYZVAPc8hrLqrcBZ42K\nztLIe2zHj5gpxecvyn2JIzs=\n-----END PRIVATE KEY-----</service-account-key>

        <service-account-p12-file display-name="P12 File Path"></service-account-p12-file>

        <enable-batch display-name="Enable Batching">true</enable-batch>

        <db-key-length display-name="Database Encryption Strength">128</db-key-length>

        <domain display-name="Primary Domain">[idmunit.org](http://idmunit.org/)</domain>

        <hash-short-passwords display-name="Hash Short Passwords">true</hash-short-passwords>

      </driver-options>

      <driver-state is-sensitive="true"><!-- content suppressed --><!-- content suppressed --><!-- content suppressed --><!-- content suppressed -->

      </driver-state>

    </init-params>

  </input>

</nds>

  

  

  

  

<?xml version=_"1.0"_ encoding=_"UTF-8"_?><nds dtdversion=_"4.0"_ ndsversion=_"8.x"_>

      <source>

            <product version=_"4.7.0.0"_>DirXML</product>

            <contact>NetIQ Corporation</contact>

      </source>

      <input>

            <instance>

                  <attr attr-name=_"DirXML-Associations"_>

                        <value timestamp=_"1264017201#35"_ type=_"structured"_>

                              <component name=_"nameSpace"_>1</component>

                              <component name=_"volume"_>\TESTTREE\us\INTELINK\Win2k3_ICES\Zimbra</component>

                              <component name=_"path"_>FAKEASSOCIATION</component>

                        </value>

                  </attr>

            </instance>

            <modify>

                  <modify-attr attr-name=_"ACL"_>

                        <add-value>

                              <value timestamp=_"1264017201#83"_ type=_"structured"_>

                                    <component name=_"protectedName"_>[All Attributes Rights]</component>

                                    <component name=_"volume"_>\TESTTREE\us\INTELINK\Win2k3_ICES\Zimbra</component>

                                    <component name=_"privileges"_>2</component>

                              </value>

                        </add-value>

                        <remove-value>

                              <value timestamp=_"1264017201#83"_ type=_"structured"_>

                                    <component name=_"protectedName"_>[All Attributes Rights]</component>

                                    <component name=_"volume"_>\TESTTREE\us\INTELINK\Win2k3_ICES\Zimbra</component>

                                    <component name=_"privileges"_>2</component>

                              </value>

                        </remove-value>

                  </modify-attr>

            </modify>

            <add>

                  <add-attr attr-name=_"ACL"_>

                        <value timestamp=_"1264017201#83"_ type=_"structured"_>

                              <component name=_"protectedName"_>[All Attributes Rights]</component>

                              <component name=_"volume"_>\TESTTREE\us\INTELINK\Win2k3_ICES\Zimbra</component>

                              <component name=_"privileges"_>2</component>

                        </value>

                  </add-attr>

            </add>

      </input>

</nds>

  

  

  

<nds dtdversion="4.0" ndsversion="8.x">

  <source>

    <product edition="Advanced" version="4.6.2.0">DirXML</product>

    <contact>NetIQ Corporation</contact>

  </source>

  <output>

    <instance class-name="User" qualified-src-dn="O=BAES\OU=Users\CN=idmunitUKB80321000" src-dn="\TRIVIRBAES\BAES\Users\idmunitUKB80321000" src-entry-id="61877">

      <attr attr-name="DirXML-Associations">

        <value timestamp="1541714293#118" type="structured">

          <component name="nameSpace">1</component>

          <component name="volume">\TRIVIRBAES\services\IDM\Driver set\GL-AD-Driver</component>

          <component name="path">7b73a2fc945d894a84dfc698054f11dc</component>

        </value>

        <value timestamp="1541714300#11" type="structured">

          <component name="nameSpace">1</component>

          <component name="volume">\TRIVIRBAES\services\IDM\Driver set\VRS-Driver</component>

          <component name="path">James2003-02-01London</component>

        </value>

      </attr>

    </instance>

    <status level="success"></status>

  </output>

</nds>

  

  

  

Example mapping table as base64 query

<nds dtdversion="4.0" ndsversion="8.x">   <source>     <product edition="Advanced" version="4.8.0.1">DirXML</product>     <contact>NetIQ Corporation</contact>   </source>   <input>     <instance cached-time="20200819212514.924Z" class-name="DirXML-Resource" event-id="triviredir#20200819212514#1#2:e9939152-89d1-4c3a-aa5b-529193e9d189" qualified-src-dn="O=servIces\OU=IDM\CN=Driver SET\CN=Manual-Lookup-Tables\CN=BL2 to BU/GLcompany" src-dn="\TRIVIRBAES\servIces\IDM\Driver SET\Manual-Lookup-Tables\BL2 to BU/GLcompany" src-entry-id="46290" timestamp="1597872314#9">       <attr attr-name="DirXML-Data">           <value type="octet">PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48bWFwcGluZy10YWJsZT4NCgk8Y29sLWRlZiBuYW1lPSJiYWVCdXNMZXZlbDJDb2RlIiB0eXBlPSJub2Nhc2UiLz4NCgk8Y29sLWRlZiBuYW1lPSJiYWVFQ0FTQlUiIHR5cGU9Im5vY2FzZSIvPg0KCTxjb2wtZGVmIG5hbWU9ImJhZUdMQURjb21wYW55IiB0eXBlPSJub2Nhc2UiLz4NCgk8cm93Pg0KCQk8Y29sPkFJLUFJTUQ8L2NvbD4NCgkJPGNvbD5BSTwvY29sPg0KCQk8Y29sPkFwcGxpZWQgSW50ZWxsaWdlbmNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5BVVMtQVVTPC9jb2w+DQoJCTxjb2w+QVVTPC9jb2w+DQoJCTxjb2w+QkFFIFN5c3RlbXMgQXVzdHJhbGlhPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5DSC1DSDwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5DVi1CRDwvY29sPg0KCQk8Y29sPkFJUjwvY29sPg0KCQk8Y29sPk1pbGl0YXJ5IEFpciAmYW1wOyBJbmZvcm1hdGlvbjwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+Q1YtQ01TPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5DVi1DUDwvY29sPg0KCQk8Y29sPkFJUjwvY29sPg0KCQk8Y29sPk1pbGl0YXJ5IEFpciAmYW1wOyBJbmZvcm1hdGlvbjwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+Q1YtQ1BTQzwvY29sPg0KCQk8Y29sPkFJUjwvY29sPg0KCQk8Y29sPk1pbGl0YXJ5IEFpciAmYW1wOyBJbmZvcm1hdGlvbjwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+Q1YtRU5HPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5DVi1GSU48L2NvbD4NCgkJPGNvbD5BSVI8L2NvbD4NCgkJPGNvbD5NaWxpdGFyeSBBaXIgJmFtcDsgSW5mb3JtYXRpb248L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkNWLUhSPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5DVi1MRUc8L2NvbD4NCgkJPGNvbD5BSVI8L2NvbD4NCgkJPGNvbD5NaWxpdGFyeSBBaXIgJmFtcDsgSW5mb3JtYXRpb248L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkNWLU1DPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5DVi1PUFM8L2NvbD4NCgkJPGNvbD5BSVI8L2NvbD4NCgkJPGNvbD5NaWxpdGFyeSBBaXIgJmFtcDsgSW5mb3JtYXRpb248L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkNWLVBNPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5FUy1CRDwvY29sPg0KCQk8Y29sPkVTPC9jb2w+DQoJCTxjb2w+RWxlY3Ryb25pYyBTeXN0ZW1zIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkVTLUNPTTwvY29sPg0KCQk8Y29sPkVTPC9jb2w+DQoJCTxjb2w+RWxlY3Ryb25pYyBTeXN0ZW1zIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkVTLUNTRVM8L2NvbD4NCgkJPGNvbD5FUzwvY29sPg0KCQk8Y29sPkVsZWN0cm9uaWMgU3lzdGVtcyAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5FUy1EVDwvY29sPg0KCQk8Y29sPkVTPC9jb2w+DQoJCTxjb2w+RWxlY3Ryb25pYyBTeXN0ZW1zIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkVTLUVORzwvY29sPg0KCQk8Y29sPkVTPC9jb2w+DQoJCTxjb2w+RWxlY3Ryb25pYyBTeXN0ZW1zIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkVTLUVPTDwvY29sPg0KCQk8Y29sPkVTPC9jb2w+DQoJCTxjb2w+RWxlY3Ryb25pYyBTeXN0ZW1zIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkVTLUZJTjwvY29sPg0KCQk8Y29sPkVTPC9jb2w+DQoJCTxjb2w+RWxlY3Ryb25pYyBTeXN0ZW1zIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkVTLUhSPC9jb2w+DQoJCTxjb2w+RVM8L2NvbD4NCgkJPGNvbD5FbGVjdHJvbmljIFN5c3RlbXMgKFVLKTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+RVMtSVQ8L2NvbD4NCgkJPGNvbD5FUzwvY29sPg0KCQk8Y29sPkVsZWN0cm9uaWMgU3lzdGVtcyAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5FUy1NTDwvY29sPg0KCQk8Y29sPkVTPC9jb2w+DQoJCTxjb2w+RWxlY3Ryb25pYyBTeXN0ZW1zIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkVTLU9QUzwvY29sPg0KCQk8Y29sPkVTPC9jb2w+DQoJCTxjb2w+RWxlY3Ryb25pYyBTeXN0ZW1zIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkVTLVBFUTwvY29sPg0KCQk8Y29sPkVTPC9jb2w+DQoJCTxjb2w+RWxlY3Ryb25pYyBTeXN0ZW1zIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkVTLVBNPC9jb2w+DQoJCTxjb2w+RVM8L2NvbD4NCgkJPGNvbD5FbGVjdHJvbmljIFN5c3RlbXMgKFVLKTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+RVMtUE1RPC9jb2w+DQoJCTxjb2w+RVM8L2NvbD4NCgkJPGNvbD5FbGVjdHJvbmljIFN5c3RlbXMgKFVLKTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+RVMtUkFGVzwvY29sPg0KCQk8Y29sPkVTPC9jb2w+DQoJCTxjb2w+RWxlY3Ryb25pYyBTeXN0ZW1zIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkVTLVNTVjwvY29sPg0KCQk8Y29sPkVTPC9jb2w+DQoJCTxjb2w+RWxlY3Ryb25pYyBTeXN0ZW1zIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkdCRC1HQkQ8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+R0JELU1EQzwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5HQkQtTUVBPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkdCRC1ORUE8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+R0JELU9PPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkdCRC1TRUk8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+R0JELVVHUjwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5HQkQtV0VTVDwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5HQy1DU0Q8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+R0YtQkZNPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkdGLUNGSU48L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+R0YtRkM8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+R0YtRlI8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+R0YtR0ZEPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkdGLUlSPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkdGLVRBWDwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5HRi1UUlk8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+R0hSLUdQPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkdIUi1IUkM8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+R0hSLUhSRDwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5HSFItSFJHPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkdIUi1PREw8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+R0hSLVJXRDwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5HTC1DUkVHPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkdMLUVYUEM8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+R0wtR0M8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+R0wtSVA8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+R0wtS008L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+R0wtTElUPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkdMLUxMPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkdMLVBUWTwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5HTC1SSDwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5HTC1TRUM8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+R0wtU01BPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkdNREktQVVTPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkdNREktR01ESTwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5HUy1HUzwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5HUy1NQTwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5HUy1TQTwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5HWFAtSU5EPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkhSQy1SV0Q8L2NvbD4NCgkJPGNvbD5TSFJTPC9jb2w+DQoJCTxjb2w+U2hhcmVkIFNlcnZpY2VzPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5MQU5ELUJEPC9jb2w+DQoJCTxjb2w+TEFORDwvY29sPg0KCQk8Y29sPkxhbmQgKFVLKTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+TEFORC1DTVM8L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5MQU5ELUNQU0M8L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5MQU5ELUNUQUk8L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5MQU5ELURJPC9jb2w+DQoJCTxjb2w+TEFORDwvY29sPg0KCQk8Y29sPkxhbmQgKFVLKTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+TEFORC1FTkc8L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5MQU5ELUVOVDwvY29sPg0KCQk8Y29sPkxBTkQ8L2NvbD4NCgkJPGNvbD5MYW5kIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkxBTkQtRklOPC9jb2w+DQoJCTxjb2w+TEFORDwvY29sPg0KCQk8Y29sPkxhbmQgKFVLKTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+TEFORC1GUDwvY29sPg0KCQk8Y29sPkxBTkQ8L2NvbD4NCgkJPGNvbD5MYW5kIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkxBTkQtSFI8L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5MQU5ELUhWTTwvY29sPg0KCQk8Y29sPkxBTkQ8L2NvbD4NCgkJPGNvbD5MYW5kIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkxBTkQtSU1UPC9jb2w+DQoJCTxjb2w+TEFORDwvY29sPg0KCQk8Y29sPkxhbmQgKFVLKTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+TEFORC1JU1M8L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5MQU5ELUxFRzwvY29sPg0KCQk8Y29sPkxBTkQ8L2NvbD4NCgkJPGNvbD5MYW5kIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkxBTkQtTFRNPC9jb2w+DQoJCTxjb2w+TEFORDwvY29sPg0KCQk8Y29sPkxhbmQgKFVLKTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+TEFORC1NQzwvY29sPg0KCQk8Y29sPkxBTkQ8L2NvbD4NCgkJPGNvbD5MYW5kIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkxBTkQtUElPPC9jb2w+DQoJCTxjb2w+TEFORDwvY29sPg0KCQk8Y29sPkxhbmQgKFVLKTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+TEFORC1TRkRDPC9jb2w+DQoJCTxjb2w+TEFORDwvY29sPg0KCQk8Y29sPkxhbmQgKFVLKTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+TUFJLUNBPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5NQUktQ0VOPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5NQUktRElUUzwvY29sPg0KCQk8Y29sPkFJUjwvY29sPg0KCQk8Y29sPk1pbGl0YXJ5IEFpciAmYW1wOyBJbmZvcm1hdGlvbjwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+TUFJLUYzNU88L2NvbD4NCgkJPGNvbD5BSVI8L2NvbD4NCgkJPGNvbD5NaWxpdGFyeSBBaXIgJmFtcDsgSW5mb3JtYXRpb248L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPk1BSS1GUCZhbXA7UzwvY29sPg0KCQk8Y29sPkFJUjwvY29sPg0KCQk8Y29sPk1pbGl0YXJ5IEFpciAmYW1wOyBJbmZvcm1hdGlvbjwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+TUFJLUlDPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5NQUktT01MPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5NQUktUkE8L2NvbD4NCgkJPGNvbD5BSVI8L2NvbD4NCgkJPGNvbD5NaWxpdGFyeSBBaXIgJmFtcDsgSW5mb3JtYXRpb248L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPk1BUi1NUzwvY29sPg0KCQk8Y29sPk1BUi1NUzwvY29sPg0KCQk8Y29sPk1hcml0aW1lIFNlcnZpY2VzPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5NQVItTlM8L2NvbD4NCgkJPGNvbD5NQVItTlM8L2NvbD4NCgkJPGNvbD5OYXZhbCBTaGlwczwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+TUFSLVNEVDwvY29sPg0KCQk8Y29sPk1BUi1NUzwvY29sPg0KCQk8Y29sPk1hcml0aW1lIFNlcnZpY2VzPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5NQVItU1VCUzwvY29sPg0KCQk8Y29sPlNVQlM8L2NvbD4NCgkJPGNvbD5TdWJtYXJpbmUgU29sdXRpb25zPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5NVU4tQkQ8L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5NVU4tQ0JEPC9jb2w+DQoJCTxjb2w+TEFORDwvY29sPg0KCQk8Y29sPkxhbmQgKFVLKTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+TVVOLUNNUzwvY29sPg0KCQk8Y29sPkxBTkQ8L2NvbD4NCgkJPGNvbD5MYW5kIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPk1VTi1DT008L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5NVU4tQ1Q8L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5NVU4tRUU8L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5NVU4tRU5HPC9jb2w+DQoJCTxjb2w+TEFORDwvY29sPg0KCQk8Y29sPkxhbmQgKFVLKTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+TVVOLUVOR1M8L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5NVU4tRklOPC9jb2w+DQoJCTxjb2w+TEFORDwvY29sPg0KCQk8Y29sPkxhbmQgKFVLKTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+TVVOLUhSPC9jb2w+DQoJCTxjb2w+TEFORDwvY29sPg0KCQk8Y29sPkxhbmQgKFVLKTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+TVVOLUhSQ1M8L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5NVU4tTFM8L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5NVU4tTUM8L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5NVU4tT1BTPC9jb2w+DQoJCTxjb2w+TEFORDwvY29sPg0KCQk8Y29sPkxhbmQgKFVLKTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+TVVOLVBDVDwvY29sPg0KCQk8Y29sPkxBTkQ8L2NvbD4NCgkJPGNvbD5MYW5kIChVSyk8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPk1VTi1QR008L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5NVU4tU1Q8L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5PQ0UtQ0U8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+T0NFLUNJTzwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5PQ0UtQ1I8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+T0NFLUdBPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPk9DRS1HUzwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5PQ0UtUEU8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+T01OLU9NTjwvY29sPg0KCQk8Y29sPk9NTjwvY29sPg0KCQk8Y29sPk9tYW48L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPlBMUy1XU1U8L2NvbD4NCgkJPGNvbD5XU1U8L2NvbD4NCgkJPGNvbD5XZWFwb24gU3lzdGVtcyBVSzwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+UFNDLUNEPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPlBTQy1DTVM8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+UFNDLUNPTTwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5QU0MtRFA8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+UFNDLUZETTwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5QU0MtRklOPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPlBTQy1HTUQ8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+UFNDLUhSQzwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5QU0MtSFJEPC9jb2w+DQoJCTxjb2w+Q0hPPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPlBTQy1MSDwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5QU0MtTUE8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgkJPGNvbD5IZWFkIE9mZmljZTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+UFNDLVBDVDwvY29sPg0KCQk8Y29sPkNITzwvY29sPg0KCQk8Y29sPkhlYWQgT2ZmaWNlPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5TQS1TQTwvY29sPg0KCQk8Y29sPktTQTwvY29sPg0KCQk8Y29sPkJBRSBTeXN0ZW1zIFNhdWRpIEFyYWJpYTwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+U0FVSy1TQVVLPC9jb2w+DQoJCTxjb2w+S1NBPC9jb2w+DQoJCTxjb2w+QkFFIFN5c3RlbXMgU2F1ZGkgQXJhYmlhPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5TSFJTLUFUQzwvY29sPg0KCQk8Y29sPlNIUlM8L2NvbD4NCgkJPGNvbD5TaGFyZWQgU2VydmljZXM8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPlNIUlMtQlNUPC9jb2w+DQoJCTxjb2w+U0hSUzwvY29sPg0KCQk8Y29sPlNoYXJlZCBTZXJ2aWNlczwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+U0hSUy1DQVQ8L2NvbD4NCgkJPGNvbD5TSFJTPC9jb2w+DQoJCTxjb2w+U2hhcmVkIFNlcnZpY2VzPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5TSFJTLUNJUzwvY29sPg0KCQk8Y29sPlNIUlM8L2NvbD4NCgkJPGNvbD5TaGFyZWQgU2VydmljZXM8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPlNIUlMtQ088L2NvbD4NCgkJPGNvbD5TSFJTPC9jb2w+DQoJCTxjb2w+U2hhcmVkIFNlcnZpY2VzPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5TSFJTLUVJVFM8L2NvbD4NCgkJPGNvbD5TSFJTPC9jb2w+DQoJCTxjb2w+U2hhcmVkIFNlcnZpY2VzPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5TSFJTLUZTPC9jb2w+DQoJCTxjb2w+U0hSUzwvY29sPg0KCQk8Y29sPlNoYXJlZCBTZXJ2aWNlczwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+U0hSUy1GU0g8L2NvbD4NCgkJPGNvbD5TSFJTPC9jb2w+DQoJCTxjb2w+U2hhcmVkIFNlcnZpY2VzPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5TSFJTLUdNUzwvY29sPg0KCQk8Y29sPlNIUlM8L2NvbD4NCgkJPGNvbD5TaGFyZWQgU2VydmljZXM8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPlNIUlMtSFJTPC9jb2w+DQoJCTxjb2w+U0hSUzwvY29sPg0KCQk8Y29sPlNoYXJlZCBTZXJ2aWNlczwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+U0hSUy1JUFM8L2NvbD4NCgkJPGNvbD5TSFJTPC9jb2w+DQoJCTxjb2w+U2hhcmVkIFNlcnZpY2VzPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5TSFJTLUlSPC9jb2w+DQoJCTxjb2w+U0hSUzwvY29sPg0KCQk8Y29sPlNoYXJlZCBTZXJ2aWNlczwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+U0hSUy1OVzwvY29sPg0KCQk8Y29sPlNIUlM8L2NvbD4NCgkJPGNvbD5TaGFyZWQgU2VydmljZXM8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPlNIUlMtUkVTPC9jb2w+DQoJCTxjb2w+U0hSUzwvY29sPg0KCQk8Y29sPlNoYXJlZCBTZXJ2aWNlczwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+VVNQLUhSPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5VU1AtTEdMPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5VU1AtUFJEPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5VU1AtUFNDPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5VU1AtUFNQPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5VU1AtUUw8L2NvbD4NCgkJPGNvbD5BSVI8L2NvbD4NCgkJPGNvbD5NaWxpdGFyeSBBaXIgJmFtcDsgSW5mb3JtYXRpb248L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPlVTUC1RTDwvY29sPg0KCQk8Y29sPkFJUjwvY29sPg0KCQk8Y29sPk1pbGl0YXJ5IEFpciAmYW1wOyBJbmZvcm1hdGlvbjwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+UkJTTC1FTkc8L2NvbD4NCgkJPGNvbD5SQlNMPC9jb2w+DQoJCTxjb2w+UkJTTDwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+UkJTTC1PUFM8L2NvbD4NCgkJPGNvbD5SQlNMPC9jb2w+DQoJCTxjb2w+UkJTTDwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+UkJTTC1QTTwvY29sPg0KCQk8Y29sPlJCU0w8L2NvbD4NCgkJPGNvbD5SQlNMPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5SQlNMLUNPTTwvY29sPg0KCQk8Y29sPlJCU0w8L2NvbD4NCgkJPGNvbD5SQlNMPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5SQlNMLVBST0M8L2NvbD4NCgkJPGNvbD5SQlNMPC9jb2w+DQoJCTxjb2w+UkJTTDwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+UkJTTC1NQzwvY29sPg0KCQk8Y29sPlJCU0w8L2NvbD4NCgkJPGNvbD5SQlNMPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5SQlNMLUdNPC9jb2w+DQoJCTxjb2w+UkJTTDwvY29sPg0KCQk8Y29sPlJCU0w8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPlJCU0wtQURNPC9jb2w+DQoJCTxjb2w+UkJTTDwvY29sPg0KCQk8Y29sPlJCU0w8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPlJCU0wtU0hFPC9jb2w+DQoJCTxjb2w+UkJTTDwvY29sPg0KCQk8Y29sPlJCU0w8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPlJCU0wtUVVBTDwvY29sPg0KCQk8Y29sPlJCU0w8L2NvbD4NCgkJPGNvbD5SQlNMPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5SQlNMLVNBTEU8L2NvbD4NCgkJPGNvbD5SQlNMPC9jb2w+DQoJCTxjb2w+UkJTTDwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+UkJTTC1MR0w8L2NvbD4NCgkJPGNvbD5SQlNMPC9jb2w+DQoJCTxjb2w+UkJTTDwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+UkJTTC1IUjwvY29sPg0KCQk8Y29sPlJCU0w8L2NvbD4NCgkJPGNvbD5SQlNMPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5SQlNMLUNNUzwvY29sPg0KCQk8Y29sPlJCU0w8L2NvbD4NCgkJPGNvbD5SQlNMPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5SQlNMLUZJTjwvY29sPg0KCQk8Y29sPlJCU0w8L2NvbD4NCgkJPGNvbD5SQlNMPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5SQlNMLUlNVDwvY29sPg0KCQk8Y29sPlJCU0w8L2NvbD4NCgkJPGNvbD5SQlNMPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5SQlNMLVNFQzwvY29sPg0KCQk8Y29sPlJCU0w8L2NvbD4NCgkJPGNvbD5SQlNMPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5FJmFtcDtJLUhBVFM8L2NvbD4NCgkJPGNvbD5NaWxpdGFyeSBBaXIgJmFtcDsgSW5mb3JtYXRpb248L2NvbD4NCgkJPGNvbD5BSVI8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkNPTy1URk08L2NvbD4NCgkJPGNvbD5NaWxpdGFyeSBBaXIgJmFtcDsgSW5mb3JtYXRpb248L2NvbD4NCgkJPGNvbD5BSVI8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkdCRC1NRU5BPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkUmYW1wO0ktRkNBUzwvY29sPg0KCQk8Y29sPk1pbGl0YXJ5IEFpciAmYW1wOyBJbmZvcm1hdGlvbjwvY29sPg0KCQk8Y29sPkFJUjwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+RSZhbXA7SS1IQVRTPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5DT08tTU5UPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5FJmFtcDtJLUhSPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5FJmFtcDtJLU0mYW1wO1E8L2NvbD4NCgkJPGNvbD5NaWxpdGFyeSBBaXIgJmFtcDsgSW5mb3JtYXRpb248L2NvbD4NCgkJPGNvbD5BSVI8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkdCRC1BU0lBPC9jb2w+DQoJCTxjb2w+SGVhZCBPZmZpY2U8L2NvbD4NCgkJPGNvbD5DSE88L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPlNIUlMtQVRDPC9jb2w+DQoJCTxjb2w+U2hhcmVkIFNlcnZpY2VzPC9jb2w+DQoJCTxjb2w+U0hSUzwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+RVMtUTwvY29sPg0KCQk8Y29sPkVsZWN0cm9uaWMgU3lzdGVtcyAoVUspPC9jb2w+DQoJCTxjb2w+RVM8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPkNWLU9QUzwvY29sPg0KCQk8Y29sPkxhbmQgKFVLKTwvY29sPg0KCQk8Y29sPkxBTkQ8L2NvbD4NCgk8L3Jvdz4NCgk8cm93Pg0KCQk8Y29sPk1VTi1FTkdTPC9jb2w+DQoJCTxjb2w+TGFuZCAoVUspPC9jb2w+DQoJCTxjb2w+TEFORDwvY29sPg0KCTwvcm93Pg0KCTxyb3c+DQoJCTxjb2w+Q1YtUE08L2NvbD4NCgkJPGNvbD5MYW5kIChVSyk8L2NvbD4NCgkJPGNvbD5MQU5EPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5DT08tSU1UPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5DT08tVEZNPC9jb2w+DQoJCTxjb2w+TWlsaXRhcnkgQWlyICZhbXA7IEluZm9ybWF0aW9uPC9jb2w+DQoJCTxjb2w+QUlSPC9jb2w+DQoJPC9yb3c+DQoJPHJvdz4NCgkJPGNvbD5Db2x0b248L2NvbD4NCgkJPGNvbD5Db2x0b248L2NvbD4NCgkJPGNvbD5BQVJPTjwvY29sPg0KCTwvcm93Pg0KPC9tYXBwaW5nLXRhYmxlPg==</value>         </attr>     </instance>   </input> </nds>