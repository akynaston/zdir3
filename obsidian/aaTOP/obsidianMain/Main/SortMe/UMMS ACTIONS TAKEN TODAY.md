---
tags: ["#c-umms"]
---
# UMMS ACTIONS TAKEN TODAY:

UMMS ACTIONS TAKEN TODAY:
6/5/2009 11:24:17 AM

\- NXsettings attrs;
     - association
     - gecos
     - gidNumber
     - uidNumber
     - DirXML-Associations: cn=NxSettings,cn=Driver Set,ou=idm,o=lawson#1#IUI14MbRk0qM3MbpRruoVQ==
     
 - Getting home directory to test in my local enviornment.
 - pointed remoteloader to trivir test tree (for SSL communication)
 - Ran driver test: 1234
    - User wascreated with /home/z1234
    - Added homeDirectory to subscriber create rules  in aix driver,
    - adding homedirectory to aix subscriber filter
    - Adding "Block modifications to homeDirectory" rule:
    ERRORS:
    - note: dn: cn=10111213,ou=users,o=lawson was too long . .
            <status event-id="TRIVIRTREE-SERVER#20090605205537#1#1" level="error">Command Error: "/bin/mkuser id=27835 pgrp=nobody home="/home/zaccount" gecos="myfirstnam3 lastname" z10111213" failed with RC=86, response: Error adding "z10111213" : Name is too long.</status>
    - Also - I think we should require gecos as well . ..
    -UPDATE INSTRUCTIONS:
         - in NxSettings
             - change
                <do-set-src-attr-value name="homeDirectory">
                    <arg-value type="string">
                        <token-global-variable name="HomeDirectory"/>
                        token - attr - uniqueid . . .
                    </arg-value>
                </do-set-src-attr-value>
            to
            
                <do-set-src-attr-value name="homeDirectory">
                    <arg-value type="string">
                        <token-global-variable name="HomeDirectory"/>
                        <token-text xml:space="preserve">zaccount</token-text>
                    </arg-value>
                </do-set-src-attr-value>            
             
         - IN aix:
             - ADD homeDirectory to subsriber filter
             - Adding "Block modifications to homeDirectory" rule - last command transform rule (second rule in ct)
                <rule>
                    <description>Block modifications to homeDirectory</description>
                    <comment xml:space="preserve">We don't support modifications to homeDirectory.</comment>
                    <conditions>
                        <and>
                            <if-operation mode="case" op="equal">modify</if-operation>
                            <if-op-attr name="homeDirectory" op="changing"/>
                        </and>
                    </conditions>
                    <actions>
                        <do-strip-op-attr name="homeDirectory"/>
                    </actions>
                </rule>                
    
    
<do-if>
                                <arg-conditions>
                                        <and>
                                                <if-attr mode="regex" name="uniqueID" op="equal">^z\[0-9\]+$</if-attr>
                                        </and>
                                </arg-conditions>
                                <arg-actions>
                                        <do-set-src-attr-value name="homeDirectory">
                                                <arg-value type="string">
                                                        <token-global-variable name="HomeDirectory"/>
                                                        <token-text xml:space="preserve">zaccount</token-text>
                                                </arg-value>
                                        </do-set-src-attr-value>
                                </arg-actions>
                                <arg-actions>
                                        <do-set-src-attr-value name="homeDirectory">
                                                <arg-value type="string">
                                                        <token-global-variable name="HomeDirectory"/>
                                                        <token-attr name="uniqueID"/>
                                                </arg-value>
                                        </do-set-src-attr-value>
                                </arg-actions>
                        </do-if>
