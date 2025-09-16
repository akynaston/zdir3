---
tags: ["#IDM"]
---
# DRIVER_REVISION

Add to driver XSL config file:

    <xsl:param name="DRIVER\_REVISION"/>
    <xsl:template match="definition\[@name='DRIVER\_REVISION'\]/value/text()">
        <xsl:value-of select="$DRIVER\_REVISION"/>
    </xsl:template>

VERSION - optionally use checksum . . .

<macrodef name="xsltAndVersion">
        <attribute name="in"/>
        <attribute name="out"/>
        <attribute name="style"/>        
        <element name="cc-elements" implicit="yes"/>
        <sequential>
            <!-- <checksum file="@{in}" property="checksum.md5"/> -->
            <xslt in="@{in}" out="@{out}" style="@{style}">
                <cc-elements/>
                <!-- <param name="DRIVER\_REVISION" expression="${iteration}.${build.number}.(${checksum.md5})"/> -->
                <param name="DRIVER\_REVISION" expression="${iteration}.${build.number}"/>
           </xslt>            
        </sequential>
    </macrodef>
