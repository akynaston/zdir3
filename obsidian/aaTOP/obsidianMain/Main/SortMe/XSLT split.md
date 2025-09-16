# XSLT split

<https://stackoverflow.com/questions/8500652/comma-separated-string-parsing-xslt-to-for-each-node>

## 6 Answers

Sorted by:
                                              Highest score (default)                                                                   Trending (recent votes count more)                                                                   Date modified (newest first)                                                                   Date created (oldest first)                              

17

**I. XSLT 1.0 solution**:

**Here is one way to do this in XSLT 1.0 using only the xxx:node-set()extension function**:

```
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:ext="http://exslt.org/common" exclude-result-prefixes="ext">
```

<xsl:template match="mark">
  <xsl:variable name="vrtfSplit">
  </xsl:variable>

  <xsl:for-each select="ext:node-set($vrtfSplit)/\*">
  <processedItem>
  </processedItem>
  </xsl:for-each>
</xsl:template>

<xsl:template match="text()" name="split">
  <xsl:if test="string-length($pText) >0">
    <item>
    <xsl:value-of select=
    </item>

    <xsl:call-template name="split">
    <xsl:with-param name="pText" select=
    </xsl:call-template>
  </xsl:if>
</xsl:template>
</xsl:stylesheet>

**when this transformation is applied to the following XML document**:

```
<mark>1,2,3,4,5</mark>


```
**The wanted, correct output (each item multiplied by 10) is produced**:

```
<processedItem>10</processedItem>
<processedItem>20</processedItem>
<processedItem>30</processedItem>
<processedItem>40</processedItem>
<processedItem>50</processedItem>


```
**II. XSLT 2.0 solution**:

```
<xsl:stylesheet version="2.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:xs="http://www.w3.org/2001/XMLSchema"
  exclude-result-prefixes="xs">
```

<xsl:template match="mark">
  <xsl:for-each select="tokenize(., ',')">
  <processedItem>
  </processedItem>
  </xsl:for-each>
</xsl:template>
</xsl:stylesheet>

[Share](https://stackoverflow.com/a/7425600)
Follow

answered Sep 15, 2011 at 3:39
![DIwx6.jpg?s=64&g=1](https://i.stack.imgur.com/DIwx6.jpg?s=64&g=1)
<https://stackoverflow.com/users/36305/dimitre-novatchev>
[Dimitre Novatchev](https://stackoverflow.com/users/36305/dimitre-novatchev)
**239k**2626 gold badges293293 silver badges427427 bronze badges
[Add a comment](https://stackoverflow.com/questions/7425071/split-function-in-xslt-1-0#)
