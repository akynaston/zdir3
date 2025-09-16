<xsl:transform version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output indent="yes" method="xml" standalone="yes"/>
<!--    <xsl:strip-space elements="*"/> -->
    
    <xsl:template match="packages"/>
    <xsl:template match="attributes/@package-id"/>
    <xsl:template match="@package-version"/>
    <xsl:template match="pkg-initial-states"/>
    <xsl:template match="rule/@checksum"/>
    <xsl:template match="rule/@package-id"/>
    <xsl:template match="rule/@pkg-assoc-id"/>
    
    <xsl:template match="global-config-def">
        <xsl:message>WARNING: removing a global-config-def tag, named: 
[<xsl:value-of select="@name"/>]
Be sure you have already moved your GCV's to the standard location on the driver, or on the driver set as needed!</xsl:message>
    </xsl:template>

    <xsl:template match="linkage-item[@policy-set-name='Global Configs']">
        <xsl:message>WARNING: removing a link to a global config, be sure you have already moved your GCV's to the standard location on the driver, or on the driver set as needed!</xsl:message>
    </xsl:template>
    
    <!--
    
    Here is a sample ant target to run through ant:
    
        <target name="remove-packages">
            !- TODO: excludes for driver with spaces in name: has stars as I don't know how to escape the spaces: find a better way to put the file name in the 'excludes'-
            <xslt basedir="${exports}" destdir="${exports}/temp" extension=".xml" style="config/strip-packages.xsl" includes="*.xml" excludes="UserApplicationDriver.xml,Role*and*Resource*Service*Driver.xml"/>
            <copy todir="${exports}">
                <fileset dir="${exports}/temp"/>
            </copy>
            <delete dir="${exports}/temp"/>
    </target>

    -->
    
    
    <xsl:template match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()"/>
        </xsl:copy>
    </xsl:template>
</xsl:transform>