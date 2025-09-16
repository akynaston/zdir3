<?xml version="1.0"?>
<xsl:transform xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0" xmlns:exslt="http://exslt.org/common" exclude-result-prefixes="exslt">

  <xsl:template name="split">
    <xsl:param name="pText"/>

<!--

Example to use this:
First add a comma delimited set of values as a parameter in build.xml:
     <param name="gcvAkamaiGroupsList" expression="\DEV_SWACO_ID\swaiddev\Groups\Akamai_Control_Center_Read_Only,\DEV_SWACO_ID\swaiddev\Groups\Akamai_Control_Center_Publisher,\DEV_SWACO_ID\swaiddev\Groups\Akamai_Control_Center_Editor,\DEV_SWACO_ID\swaiddev\Groups\Akamai_Control_Center_Administrator,\DEV_SWACO_ID\swaiddev\Groups\Akamai_Control_Center__MPULSE_Dashboard_Access"/

Update your driver-xml-output-config.xsl with this:

Add this include line right under idm-common/config/common-config.xsl:
    <xsl:include href="auxiliary/comma-string-to-element-set.xsl"/>

Then add this:

   <xsl:param name="gcvAkamaiGroupsList" select="string('')"/>
	<xsl:template match="definition[@name='gcvAkamaiGroupsList']/value">
	    <xsl:copy>
          <xsl:apply-templates select="@*"/>
          <xsl:call-template name="split">
            <xsl:with-param name="pText" select="$gcvAkamaiGroupsList"/>
          </xsl:call-template>
	    </xsl:copy>
    </xsl:template>


-->

    <xsl:variable name="separator">,</xsl:variable>

    <xsl:choose>
      <xsl:when test="string-length($pText) = 0"/>
      <xsl:when test="contains($pText, $separator)">
        <item>
          <xsl:value-of select="substring-before($pText, $separator)"/>
        </item>
        <xsl:call-template name="split">
          <xsl:with-param name="pText" select="substring-after($pText, $separator)"/>
        </xsl:call-template>
      </xsl:when>
      <xsl:otherwise>
        <item>
          <xsl:value-of select="$pText"/>
        </item>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>


</xsl:transform>
