    <xsl:param name="username"/>
	<xsl:template match="definition[@name='http-query']/value/instance[definition/value/text() = 'username']/definition[@name='query-value']/value">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:value-of select="username"/>
		</xsl:copy>
    </xsl:template>