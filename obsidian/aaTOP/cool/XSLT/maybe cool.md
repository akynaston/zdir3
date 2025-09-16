6/6/2024 11:53:57 AM

Wrap each separate event; thought I needed this, but a dump from dxcmd view tarnsactions -> 9 submit even works fien without this

```
<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  version="1.0"
  xmlns:xs="http://www.w3.org/2001/XMLSchema"
  expand-text="yes">
  <xsl:output method="html" indent="yes"/>

  <xsl:template match="input/*">
     <source>
        <product edition="Advanced" version="4.8.6.0000">DirXML</product>
        <contact>NetIQ Corporation</contact>
      </source>
     	<input>
      <xsl:copy>
        <xsl:apply-templates select="@*|node()"/>
      </xsl:copy>
      </input>
    </nds>
  </xsl:template>

  <xsl:template match="@*|node()">
      <xsl:copy>
        <xsl:apply-templates select="@*|node()"/>
      </xsl:copy>
  </xsl:template>
</xsl:stylesheet>
```