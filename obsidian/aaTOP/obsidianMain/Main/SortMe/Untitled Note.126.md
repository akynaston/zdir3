# Untitled Note

\=====XSLT - Split single file to multiple files

This was the jdk 1.5 (and earlier) way of doing it; however, it doesn't work in jdk 1.6 or later; it acts like it works but doesn't end up writing anything out:

 <xsl:variable name="dummy1" select="tformerClass:setOutputProperty($transformer, '{[http://xml.apache.org/xslt}indent-amount](http://xml.apache.org/xslt%7Dindent-amount)', '2')"/>
