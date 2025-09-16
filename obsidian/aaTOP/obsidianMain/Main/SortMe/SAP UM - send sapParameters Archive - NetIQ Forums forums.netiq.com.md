# SAP UM - send sapParameters??? [Archive] - NetIQ Forums [forums.netiq.com]

[NetIQ Forums](https://forums.netiq.com/archive/index.php) > [PRODUCT DISCUSSION FORUMS](https://forums.netiq.com/archive/index.php/f-1.html) > [Identity and Access Governance](https://forums.netiq.com/archive/index.php/f-90.html) > [Identity Manager](https://forums.netiq.com/archive/index.php/f-19.html) > [IM: Engine-Drivers](https://forums.netiq.com/archive/index.php/f-22.html) > SAP UM - send sapParameters???
[PDA](https://forums.netiq.com/archive/index.php/t-6718.html?pda=1)

View Full Version : [SAP UM - send sapParameters???](https://forums.netiq.com/showthread.php?6718-SAP-UM-send-sapParameters)

IDM Dude
12-Feb-2008, 14:55

Ok I have seen 2 other people ask this question in this form and not get
an answer. How do you send the VALUE of the parameter to the SAP
system. Only the parameter ID is send via the sapParameters attribute
that is created with the supplied SAP attributes schema extensions for
this driver.
Has anyone ever done this? Any suggests or guidance would be appreciated!
Thanks

Lothar Haeger
12-Feb-2008, 17:05

IDM Dude wrote:
\> Ok I have seen 2 other people ask this question in this form and not get an answer. How do you send the VALUE of the parameter to the SAP system. Only the parameter ID is send via the sapParameters attribute that is created with the supplied SAP attributes schema extensions for this driver.
\>
\> Has anyone ever done this? Any suggests or guidance would be appreciated!
you need to map the sapParameter attribute to PARAMETER instead of PARAMETER:PARID and send that attribute structured to the driver similar to DirXML-sapLocProfiles. I added a "parameter" entitlement to my driver that takes values in ":"-seperated notation (just like sapLocProfiles) and added the following input/output/sub-cmd policies:
input:
<rule>
<description>Transform PARAMETER from Structured to String</description>
<conditions>
<and/>
</conditions>
<actions>
<do-reformat-op-attr name="PARAMETER">
<arg-value type="string">
<token-xpath expression="$current-value/component\[@name='PARID'\]"/>
<token-text xml:space="preserve">:</token-text>
<token-xpath expression="$current-value/component\[@name='PARVA'\]"/>
<token-text xml:space="preserve">:</token-text>
<token-xpath expression="$current-value/component\[@name='PARTXT'\]"/>
</arg-value>
</do-reformat-op-attr>
<do-reformat-op-attr name="PARAMETER">
<arg-value type="string">
<token-replace-first regex=":$" replace-with="">
<token-local-variable name="current-value"/>
</token-replace-first>
</arg-value>
</do-reformat-op-attr>
</actions>
</rule>
output:
<rule>
<description>Transform PARAMETER from String to Structured</description>
<conditions>
<or/>
</conditions>
<actions>
<do-reformat-op-attr name="PARAMETER">
<arg-value type="structured">
<arg-component name="PARID">
<token-replace-first regex="(\[^:\]\*):(\[^:\]\*):?(.\*)" replace-with="$1">
<token-local-variable name="current-value"/>
</token-replace-first>
</arg-component>
<arg-component name="PARVA">
<token-replace-first regex="(\[^:\]\*):(\[^:\]\*):?(.\*)" replace-with="$2">
<token-local-variable name="current-value"/>
</token-replace-first>
</arg-component>
<arg-component name="PARTXT">
<token-replace-first regex="(\[^:\]\*):(\[^:\]\*):?(.\*)" replace-with="$3">
<token-local-variable name="current-value"/>
</token-replace-first>
</arg-component>
</arg-value>
</do-reformat-op-attr>
</actions>
</rule>
sub-cmd:
<rule>
<description>Entitlement: SAP Parameters</description>
<conditions>
<and>
<if-class-name op="equal">User</if-class-name>
<if-entitlement name="SAP Parameter" op="changing"/>
</and>
</conditions>
<actions>
<do-if>
<arg-conditions>
<and>
<if-operation mode="case" op="equal">modify</if-operation>
</and>
</arg-conditions>
<arg-actions>
<do-for-each>
<arg-node-set>
<token-removed-entitlement name="SAP Parameter"/>
</arg-node-set>
<arg-actions>
<do-remove-dest-attr-value name="sapParameters">
<arg-value>
<token-local-variable name="current-node"/>
</arg-value>
</do-remove-dest-attr-value>
</arg-actions>
</do-for-each>
</arg-actions>
</do-if>
<do-for-each>
<arg-node-set>
<token-added-entitlement name="SAP Parameter"/>
</arg-node-set>
<arg-actions>
<do-add-dest-attr-value name="sapParameters">
<arg-value>
<token-local-variable name="current-node"/>
</arg-value>
</do-add-dest-attr-value>
</arg-actions>
</do-for-each>
</actions>
</rule>
entitlement:
<entitlement conflict-resolution="union" description="SAP Parameter" display-name="SAP Parameter">
<values multi-valued="true"/>
</entitlement>
of course you can leave out the RBE part and simply map to an attribute instead.
Cheers, Lothar
\--

IDM Dude
13-Feb-2008, 19:30

Thank You Lothar
That worked great!
A quick question. I noticed that when I match a user that may have
already been in the SAP environment, the match works ok BUT the
parameter data that was there before is wiped and only the ones I am
passing over as defaults are present. So any parameter, Role and
profile data that was there for when the match happens is wiped and
replaced with the defaults the driver sends over, not appends them.
Any suggestions?
Thanks
Lothar Haeger wrote:
\> IDM Dude wrote:
\>
\>> Ok I have seen 2 other people ask this question in this form and not get an answer. How do you send the VALUE of the parameter to the SAP system. Only the parameter ID is send via the sapParameters attribute that is created with the supplied SAP attributes schema extensions for this driver.
\>>
\>> Has anyone ever done this? Any suggests or guidance would be appreciated!
\>
\>
\> you need to map the sapParameter attribute to PARAMETER instead of PARAMETER:PARID and send that attribute structured to the driver similar to DirXML-sapLocProfiles. I added a "parameter" entitlement to my driver that takes values in ":"-seperated notation (just like sapLocProfiles) and added the following input/output/sub-cmd policies:
\>
\> input:
\>
\> <rule>
\> <description>Transform PARAMETER from Structured to String</description>
\> <conditions>
\> <and/>
\> </conditions>
\> <actions>
\> <do-reformat-op-attr name="PARAMETER">
\> <arg-value type="string">
\> <token-xpath expression="$current-value/component\[@name='PARID'\]"/>
\> <token-text xml:space="preserve">:</token-text>
\> <token-xpath expression="$current-value/component\[@name='PARVA'\]"/>
\> <token-text xml:space="preserve">:</token-text>
\> <token-xpath expression="$current-value/component\[@name='PARTXT'\]"/>
\> </arg-value>
\> </do-reformat-op-attr>
\> <do-reformat-op-attr name="PARAMETER">
\> <arg-value type="string">
\> <token-replace-first regex=":$" replace-with="">
\> <token-local-variable name="current-value"/>
\> </token-replace-first>
\> </arg-value>
\> </do-reformat-op-attr>
\> </actions>
\> </rule>
\>
\>
\> output:
\>
\> <rule>
\> <description>Transform PARAMETER from String to Structured</description>
\> <conditions>
\> <or/>
\> </conditions>
\> <actions>
\> <do-reformat-op-attr name="PARAMETER">
\> <arg-value type="structured">
\> <arg-component name="PARID">
\> <token-replace-first regex="(\[^:\]\*):(\[^:\]\*):?(.\*)" replace-with="$1">
\> <token-local-variable name="current-value"/>
\> </token-replace-first>
\> </arg-component>
\> <arg-component name="PARVA">
\> <token-replace-first regex="(\[^:\]\*):(\[^:\]\*):?(.\*)" replace-with="$2">
\> <token-local-variable name="current-value"/>
\> </token-replace-first>
\> </arg-component>
\> <arg-component name="PARTXT">
\> <token-replace-first regex="(\[^:\]\*):(\[^:\]\*):?(.\*)" replace-with="$3">
\> <token-local-variable name="current-value"/>
\> </token-replace-first>
\> </arg-component>
\> </arg-value>
\> </do-reformat-op-attr>
\> </actions>
\> </rule>
\>
\> sub-cmd:
\>
\> <rule>
\> <description>Entitlement: SAP Parameters</description>
\> <conditions>
\> <and>
\> <if-class-name op="equal">User</if-class-name>
\> <if-entitlement name="SAP Parameter" op="changing"/>
\> </and>
\> </conditions>
\> <actions>
\> <do-if>
\> <arg-conditions>
\> <and>
\> <if-operation mode="case" op="equal">modify</if-operation>
\> </and>
\> </arg-conditions>
\> <arg-actions>
\> <do-for-each>
\> <arg-node-set>
\> <token-removed-entitlement name="SAP Parameter"/>
\> </arg-node-set>
\> <arg-actions>
\> <do-remove-dest-attr-value name="sapParameters">
\> <arg-value>
\> <token-local-variable name="current-node"/>
\> </arg-value>
\> </do-remove-dest-attr-value>
\> </arg-actions>
\> </do-for-each>
\> </arg-actions>
\> </do-if>
\> <do-for-each>
\> <arg-node-set>
\> <token-added-entitlement name="SAP Parameter"/>
\> </arg-node-set>
\> <arg-actions>
\> <do-add-dest-attr-value name="sapParameters">
\> <arg-value>
\> <token-local-variable name="current-node"/>
\> </arg-value>
\> </do-add-dest-attr-value>
\> </arg-actions>
\> </do-for-each>
\> </actions>
\> </rule>
\>
\> entitlement:
\>
\> <entitlement conflict-resolution="union" description="SAP Parameter" display-name="SAP Parameter">
\> <values multi-valued="true"/>
\> </entitlement>
\>
\> of course you can leave out the RBE part and simply map to an attribute instead.
\>
\> Cheers, Lothar

Lothar Haeger
14-Feb-2008, 08:21

IDM Dude wrote:
\> Thank You Lothar
\>
\> That worked great!
\>
\> A quick question. I noticed that when I match a user that may have already been in the SAP environment, the match works ok BUT the parameter data that was there before is wiped and only the ones I am passing over as defaults are present. So any parameter, Role and profile data that was there for when the match happens is wiped and replaced with the defaults the driver sends over, not appends them.
\>
\> Any suggestions?
map those fields to edir attributes and enable them on the publisher channel, too. you'll get a copy of the data on the edir user and a later merge will add them back to the sap user.
\--

jimc
07-Oct-2008, 16:56

I'm trying to set default SAp Parameters in a Create policy, but I can't
make head nor tail of the above... I guess because I don't have any
familiarity with RBS. Looking at other things in the documentation I
\*thought\* I ought to use a structured argument value as follows, but SAP
is objecting with a JCO error which seems to indicate that it doesn't
like the data. It could of course be one of the many values I have, or
is my approach fundamentally flawed?
<do-set-dest-attr-value name="sapParameters" when="after">
<arg-value type="structured">
<arg-component name="PAR01">
<token-text xml:space="preserve">BUK;1000</token-text>
</arg-component>
</arg-value>
</do-set-dest-attr-value>
\--
jimc
\------------------------------------------------------------------------
jimc's Profile: http://forums.novell.com/member.php?userid=6130
View this thread: http://forums.novell.com/showthread.php?t=311484

Lothar Haeger
08-Oct-2008, 10:29

try something like this and map sapParameters to PARAMETER
<do-set-dest-attr-value name="sapParameters">
<arg-value type="structured">
<arg-value type="structured">
<arg-component name="PARID">
<token-text xml:space="preserve">My Parameter</token-text>
</arg-component>
<arg-component name="PARVA">
<token-text xml:space="preserve">My Value</token-text>
</arg-component>
<arg-component name="PARTXT">
<token-text xml:space="preserve">My Description</token-text>
</arg-component>
</arg-value>
</arg-value>
</do-set-dest-attr-value>
\--

Lothar Haeger
08-Oct-2008, 10:31

well, of course rather
<do-set-dest-attr-value name="sapParameters">
<arg-value type="structured">
<arg-component name="PARID">
<token-text xml:space="preserve">My Parameter</token-text>
</arg-component>
<arg-component name="PARVA">
<token-text xml:space="preserve">My Value</token-text>
</arg-component>
<arg-component name="PARTXT">
<token-text xml:space="preserve">My Description</token-text>
</arg-component>
</arg-value>
</do-set-dest-attr-value>

jimc
09-Oct-2008, 15:24

lhaeger;1654656 Wrote:
\> well, of course rather
\>
Excellent! I understand now... What was confusing me was that my SAP
guys had helpfully given me a list showing PAR01, PAR02 etc which were
to be helpful, not data, and that I hadn't appeciated that the
description was an attr... According to my guys I don't need to bother
about setting the desciption so I've ended up with this as the first
attr (I'm putting it in mainly for the next person to be searching in
google for SAP and BOK!)
Many thanks for the help:-)))
<do-set-dest-attr-value name="sapParameters">
<arg-value type="structured">
<arg-component name="PARID">
<token-text xml:space="preserve">BOK</token-text>
</arg-component>
<arg-component name="PARVA">
<token-text xml:space="preserve">1000</token-text>
</arg-component>
<arg-component name="PARTXT">
</arg-component>
</arg-value>
</do-set-dest-attr-value>
\--
jimc
\------------------------------------------------------------------------
jimc's Profile: http://forums.novell.com/member.php?userid=6130
View this thread: http://forums.novell.com/showthread.php?t=311484
