---
tags: ["#xslt"]
---
# (online)Using XPATH to Get the Position of a Node in a Node Set | Novell User Communities

And test the xpath with this tool:

[http://www.bit-101.com/xpath/](http://www.bit-101.com/xpath)

XSLT with this tool:
http://www.w3schools.com/xsl/tryxslt.asp?xmlfile=cdcatalog&xsltfile=cdcatalog

xpath:

count(attr/value\[.='$TARGET'\]/preceding-sibling::\*)+1

xml:

<mapping-table>
                                        <col-def name="loc" type="nocase"/>
                                        <col-def name="street" type="nocase"/>
                                        <col-def name="street2" type="nocase"/>
                                        <col-def name="city" type="nocase"/>
                                        <col-def name="state" type="nocase"/>
                                        <col-def name="zip" type="nocase"/>
                                        <col-def name="prov-team-email" type="nocase"/>
                                        <col-def name="country" type="nocase"/>
                                        <row>
                                                <col>AL020</col>
                                                <col>2101 W. 10 Street Box 1030</col>
                                                <col/>
                                                <col>Anniston</col>
                                                <col>AL</col>
                                                <col>36202</col>
                                                <col/>
                                                <col>United States</col>
                                        </row>
                                        <row>
                                                <col>AL021</col>
                                                <col>6275 Horse Creek Blvd</col>
                                                <col/>
                                                <col>Cordova</col>
                                                <col>AL</col>
                                                <col>35550</col>
                                                <col>ASISSecurity@baesystems.com</col>
                                                <col>United States</col>
                                        </row>
                </mapping-table>

returns 7!
