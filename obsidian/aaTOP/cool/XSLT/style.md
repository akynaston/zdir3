 <xsl:stylesheet 
 xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
 xmlns:cmd="http://www.novell.com/nxsl/java/com.novell.nds.dirxml.driver.XdsCommandProcessor" 
 version="1.0">
   
   

   
  <xsl:template match="@dn">
    
     <xsl:variable name="topOFromDocument">
       <xsl:call-template name="substring-after-last">
          <xsl:with-param name="targetString" select="//driver-configuration/@dn"/>
          <xsl:with-param name="delimiter" select="string(',')"/>
       </xsl:call-template>
     </xsl:variable>

   <xsl:attribute name="dn">
          <xsl:value-of select="$topOFromDocument"/>
      </xsl:attribute>
  </xsl:template>
  
  <xsl:template match="@*|node()">
      <xsl:copy>
        <xsl:apply-templates select="@*|node()"/>
      </xsl:copy>
  </xsl:template>
  

<!--  
  From:
  https://stackoverflow.com/questions/9078779/getting-a-substring-after-the-last-occurrence-of-a-character-in-xslt
  -->
   <xsl:template name="substring-after-last">
    <xsl:param name="targetString" />
    <xsl:param name="delimiter" />
    <xsl:choose>
      <xsl:when test="contains($targetString, $delimiter)">
        <xsl:call-template name="substring-after-last">
          <xsl:with-param name="targetString" select="substring-after($targetString, $delimiter)" />
          <xsl:with-param name="delimiter" select="$delimiter" />
        </xsl:call-template>
      </xsl:when>
      <xsl:otherwise><xsl:value-of 
                  select="$targetString" /></xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  
  
  
  </xsl:stylesheet>