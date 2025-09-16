3/8/2024 9:16:21 AM
Use the following to take comma delim and store nodeset.

More info: 
[[README-comma delimit to elements]]

```

<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  version="3.0"
  xmlns:xs="http://www.w3.org/2001/XMLSchema"
  exclude-result-prefixes="#all"
  expand-text="yes"
   xmlns:exslt="http://exslt.org/common"
  >

    <xsl:variable name="colorElements">
      <xsl:call-template name="split">
        <xsl:with-param name="pText" select="$groups"/>
      </xsl:call-template>
    </xsl:variable>

    <xsl:for-each select="exslt:node-set($colorElements)">
      <xsl:copy-of select="color"/>
    </xsl:for-each>

  </xsl:template>

  <xsl:template name="split">
    <xsl:param name="pText"/>

    <xsl:variable name="separator">,</xsl:variable>

    <xsl:choose>
      <xsl:when test="string-length($pText) = 0"/>
      <xsl:when test="contains($pText, $separator)">
        <color>
          <xsl:value-of select="substring-before($pText, $separator)"/>
        </color>
        <xsl:call-template name="split">
          <xsl:with-param name="pText" select="substring-after($pText, $separator)"/>
        </xsl:call-template>
      </xsl:when>
      <xsl:otherwise>
        <color>
          <xsl:value-of select="$pText"/>
        </color>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

</xsl:stylesheet>


```

end result:

<top>
  <definition critical-change="true" display-name="AkamaiGroupsList" name="gcvAkamaiGroupsList" type="list">
      <description/>
      <value>
          <item>\DEV_SWACO_ID\swaiddev\Groups\Akamai_Control_Center_Read_Only</item>
          <item>\DEV_SWACO_ID\swaiddev\Groups\Akamai_Control_Center_Publisher</item>
          <item>\DEV_SWACO_ID\swaiddev\Groups\Akamai_Control_Center_Editor</item>
          <item>\DEV_SWACO_ID\swaiddev\Groups\Akamai_Control_Center_Administrator</item>
          <item>\DEV_SWACO_ID\swaiddev\Groups\Akamai_Control_Center__MPULSE_Dashboard_Access</item>
      </value>
  </definition>
</top>

