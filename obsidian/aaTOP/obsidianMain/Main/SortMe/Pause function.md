---
tags: ["#PlanteMoran"]
---
# Pause function

create in ecma script called pauseFunction:
function pause(miliTime) {
 java.lang.Thread.sleep(miliTime);
}   
<?xml version="1.0" encoding="UTF-8"?><!DOCTYPE policy PUBLIC "policy-builder-dtd" "C:\\Program Files\\Novell\\Designer\\eclipse\\plugins\\com.novell.idm.policybuilder\_3.0.1.200901050958\\DTD\\dirxmlscript3.5.1.dtd"><policy>
    <rule>
        <description>asdf</description>
        <conditions>
            <or>
                <if-operation mode="case" op="equal">add</if-operation>
                <if-operation mode="case" op="equal">modify</if-operation>
                <if-operation mode="case" op="equal">move</if-operation>
                <if-operation mode="case" op="equal">rename</if-operation>
                <if-operation mode="case" op="equal">delete</if-operation>
            </or>
        </conditions>
        <actions>
            <do-set-local-variable name="test" scope="policy">
                <arg-string>
                    <token-unmatched-src-dn/>
                    <token-xpath expression="es:pause(5000)"/>
                </arg-string>
            </do-set-local-variable>
        </actions>
    </rule>
</policy>
