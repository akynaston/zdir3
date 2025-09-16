# Enable position of currently processing event

8/1/2018 7:08:46 PM
found a way to 

<xsl:template match="attr-name-map">
    <xsl:copy>
        <xsl:apply-templates select="@\*|node()">
        </xsl:apply-templates>
    </xsl:copy>    
</xsl:template>
<xsl:template match="attr-name">
out of <xsl:value-of select="$totalcount"/>
</xsl:template>
