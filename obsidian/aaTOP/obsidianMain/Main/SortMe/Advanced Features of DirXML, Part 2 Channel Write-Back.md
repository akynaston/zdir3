# Advanced Features of DirXML, Part 2: Channel Write-Back

<xsl:param name="src-dn"/>

        <xsl:variable name="dn" select="jstring:new($src-dn)"/>

        <xsl:variable name="index" select="jstring:lastIndexOf($dn,'\\')"/>

        <xsl:if test="$index != -1">

            <xsl:value-of select="jstring:substring($dn,$index + 1)"/>

        </xsl:if>

</xsl:template>
