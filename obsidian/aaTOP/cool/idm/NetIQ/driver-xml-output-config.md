<xsl:transform version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	
    <xsl:include href="idm-common/config/common-config.xsl"/>    
    
    
    <!-- This strips the entire library, we don't even use it in this driver. -->
    <xsl:template match="driver-configuration/children/policy-library"/>
    <!-- Strips variable defined for library. -->
    <xsl:template match="driver-configuration/variable-decl/text-var[@var-name='LibraryPrompt.FCPS Library.Driver Set.idm.services']"/>
    
	<xsl:param name="gcvDriverMode"/>
    <xsl:template match="definition[@name='gcvDriverMode']/value">
        <xsl:copy>
            <xsl:apply-templates select="@*"/>
            <xsl:value-of select="$gcvDriverMode"/>
        </xsl:copy>
    </xsl:template>
	
	<xsl:param name="gcv_usr_termination_ou"/>
    <xsl:template match="definition[@name='gcv_usr_termination_ou']/value">
        <xsl:copy>
            <xsl:apply-templates select="@*"/>
            <xsl:value-of select="$gcv_usr_termination_ou"/>
        </xsl:copy>
    </xsl:template>
	
    <xsl:param name="shim-auth-id"/>
    <xsl:template match="shim-auth-id/@value">
        <xsl:attribute name="value">
                <xsl:value-of select="$shim-auth-id"/>
        </xsl:attribute>
    </xsl:template>

    <xsl:param name="shim-auth-server"/>
    <xsl:template match="shim-auth-server/@value">
        <xsl:attribute name="value">
                <xsl:value-of select="$shim-auth-server"/>
        </xsl:attribute>
    </xsl:template>
	
	<xsl:param name="ConnectedSystemName"/>
    <xsl:template match="definition[@name='ConnectedSystemName']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$ConnectedSystemName"/>
        </xsl:copy>
    </xsl:template>  

	<xsl:param name="EDIRContext"/>
    <xsl:template match="definition[@name='EDIRContext']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$EDIRContext"/>
        </xsl:copy>
    </xsl:template>  
	
	<xsl:param name="ADContext"/>
    <xsl:template match="definition[@name='ADContext']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$ADContext"/>
        </xsl:copy>
    </xsl:template>  
    
    <xsl:param name="ADSWACOContext"/>
    <xsl:template match="definition[@name='ADSWACOContext']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$ADSWACOContext"/>
        </xsl:copy>
    </xsl:template>

    <xsl:param name="UpnDomain"/>
    <xsl:template match="definition[@name='UpnDomain']/value">
        <xsl:copy>
                        <xsl:apply-templates select="@*"/>
            <xsl:value-of select="$UpnDomain"/>
        </xsl:copy>
    </xsl:template>

    <xsl:param name="UpnDomainAdmin"/>
    <xsl:template match="definition[@name='UpnDomainAdmin']/value">
        <xsl:copy>
                        <xsl:apply-templates select="@*"/>
            <xsl:value-of select="$UpnDomainAdmin"/>
        </xsl:copy>
    </xsl:template>
    
	<xsl:param name="ADDomain"/>
    <xsl:template match="definition[@name='ADDomain']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$ADDomain"/>
        </xsl:copy>
    </xsl:template>  
	
	<xsl:param name="ADFQN"/>
    <xsl:template match="definition[@name='ADFQN']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$ADFQN"/>
        </xsl:copy>
    </xsl:template>  
	
	<xsl:param name="smtp-server"/>
    <xsl:template match="definition[@name='smtp-server']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$smtp-server"/>
        </xsl:copy>
    </xsl:template>  
	
	<xsl:param name="admin-alerts-email-address"/>
    <xsl:template match="definition[@name='admin-alerts-email-address']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$admin-alerts-email-address"/>
        </xsl:copy>
    </xsl:template>  
	
	<xsl:param name="container-for-airtran-users"/>
    <xsl:template match="definition[@name='container-for-airtran-users']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$container-for-airtran-users"/>
        </xsl:copy>
    </xsl:template>  
	
	<xsl:param name="container-for-HDQ-users"/>
    <xsl:template match="definition[@name='container-for-HDQ-users']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$container-for-HDQ-users"/>
        </xsl:copy>
    </xsl:template>  
	
	<xsl:param name="container-for-field-users"/>
    <xsl:template match="definition[@name='container-for-field-users']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$container-for-field-users"/>
        </xsl:copy>
    </xsl:template>  
    
    	<xsl:param name="container-for-Retiree-users"/>
	<xsl:template match="definition[@name='container-for-Retiree-users']/value">
	    <xsl:copy>
			<xsl:apply-templates select="@*"/>
		<xsl:value-of select="$container-for-Retiree-users"/>
	    </xsl:copy>
    	</xsl:template> 
	
	<xsl:param name="gcvADHost"/>
    <xsl:template match="definition[@name='gcvADHost']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$gcvADHost"/>
        </xsl:copy>
    </xsl:template>  
	
	<xsl:param name="gcvADHostPort"/>
    <xsl:template match="definition[@name='gcvADHostPort']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$gcvADHostPort"/>
        </xsl:copy>
    </xsl:template>  
	
	<xsl:param name="gcvAcctLockTime"/>
    <xsl:template match="definition[@name='gcvAcctLockTime']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$gcvAcctLockTime"/>
        </xsl:copy>
    </xsl:template>  

	<xsl:param name="gcvADinvalidAttempts"/>
    <xsl:template match="definition[@name='gcvADinvalidAttempts']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$gcvADinvalidAttempts"/>
        </xsl:copy>
    </xsl:template>  
	
	<xsl:param name="gcvLogFile"/>
    <xsl:template match="definition[@name='gcvLogFile']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$gcvLogFile"/>
        </xsl:copy>
    </xsl:template>  

	<xsl:param name="pwdPolicyLuvAccount"/>
    <xsl:template match="definition[@name='pwdPolicyLuvAccount']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$pwdPolicyLuvAccount"/>
        </xsl:copy>
    </xsl:template>  

	<xsl:param name="pwdPolicyAirTran"/>
    <xsl:template match="definition[@name='pwdPolicyAirTran']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$pwdPolicyAirTran"/>
        </xsl:copy>
    </xsl:template>  

	<xsl:param name="ADDispNameException"/>
    <xsl:template match="definition[@name='ADDispNameException']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$ADDispNameException"/>
        </xsl:copy>
    </xsl:template>  

	<xsl:param name="gcvContractorSuffix"/>
    <xsl:template match="definition[@name='gcvContractorSuffix']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$gcvContractorSuffix"/>
        </xsl:copy>
    </xsl:template>  
	
	<xsl:param name="gcv.DefaultDummyEmail"/>
    <xsl:template match="definition[@name='gcv.DefaultDummyEmail']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$gcv.DefaultDummyEmail"/>
        </xsl:copy>
    </xsl:template>  
		
	<xsl:param name="gcv.EntitlementControl.Admin"/>
    <xsl:template match="definition[@name='gcv.EntitlementControl.Admin']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$gcv.EntitlementControl.Admin"/>
        </xsl:copy>
    </xsl:template>  
		
	<xsl:param name="container-for-Admin-Users"/>
    <xsl:template match="definition[@name='container-for-Admin-Users']/value">
        <xsl:copy>
			<xsl:apply-templates select="@*"/>
            <xsl:value-of select="$container-for-Admin-Users"/>
        </xsl:copy>
    </xsl:template>  
	   <xsl:param name="gcv_user_container"/>
    <xsl:template match="definition[@name='gcv_user_container']/value">
        <xsl:copy>
                        <xsl:apply-templates select="@*"/>
            <xsl:value-of select="$gcv_user_container"/>
        </xsl:copy>
    </xsl:template> 
	<xsl:param name="EMM_Group_Exch365_Migrated_S"/>
    <xsl:template match="definition[@name='EMM_Group_Exch365_Migrated_S']/value">
        <xsl:copy>
                        <xsl:apply-templates select="@*"/>
            <xsl:value-of select="$EMM_Group_Exch365_Migrated_S"/>
        </xsl:copy>
    </xsl:template>
	
	<xsl:param name="DenyLogOnFE"/>
    <xsl:template match="definition[@name='DenyLogOnFE']/value">
        <xsl:copy>
                        <xsl:apply-templates select="@*"/>
            <xsl:value-of select="$DenyLogOnFE"/>
        </xsl:copy>
    </xsl:template>

	<xsl:param name="pollingInterval"/>
    <xsl:template match="definition[@name='pollingInterval']/value">
        <xsl:copy>
            <xsl:apply-templates select="@*"/>
            <xsl:value-of select="$pollingInterval"/>
        </xsl:copy>
    </xsl:template>

	<xsl:param name="pub-password-expire-time"/>
    <xsl:template match="definition[@name='pub-password-expire-time']/value">
        <xsl:copy>
            <xsl:apply-templates select="@*"/>
            <xsl:value-of select="$pub-password-expire-time"/>
        </xsl:copy>
    </xsl:template>
    
	<!-- Added to enable turning this off in ALPHA since we connect directly to the DC, defaulting to 'yes' -->
    <xsl:param name="use-ssl" select="yes"/>
    <xsl:template match="definition[@name='use-ssl']/value">
        <xsl:copy>
            <xsl:apply-templates select="@*"/>
            <xsl:value-of select="$use-ssl"/>
        </xsl:copy>
    </xsl:template>

    <xsl:param name="topo" select="string('o=SWA-IDALPHA')"/>
    <xsl:template match="@dn">
        <xsl:message>Found a dn: <xsl:value-of select="."/></xsl:message>
        <xsl:variable name="newDN">
            <xsl:call-template name="replace-string">
                <xsl:with-param name="text" select="."/>
                <xsl:with-param name="replace" select="string('o=swaiddev')"/>
                <xsl:with-param name="with" select="$topo"/>
            </xsl:call-template>
        </xsl:variable>
        <xsl:attribute name="dn">
            <xsl:value-of select="$newDN"/>
        </xsl:attribute>
    </xsl:template>    
    
    <!-- 
		Replace-string function from: https://stackoverflow.com/questions/7520762/xslt-1-0-string-replace-function/7523245
	-->
	<xsl:template name="replace-string">
		<xsl:param name="text"/>
		<xsl:param name="replace"/>
		<xsl:param name="with"/>
		<xsl:choose>
		  <xsl:when test="contains($text,$replace)">
			<xsl:value-of select="substring-before($text,$replace)"/>
			<xsl:value-of select="$with"/>
			<xsl:call-template name="replace-string">
			  <xsl:with-param name="text"
		select="substring-after($text,$replace)"/>
			  <xsl:with-param name="replace" select="$replace"/>
			  <xsl:with-param name="with" select="$with"/>
			</xsl:call-template>
		  </xsl:when>
		  <xsl:otherwise>
			<xsl:value-of select="$text"/>
		  </xsl:otherwise>
		</xsl:choose>
	</xsl:template>
    
</xsl:transform>
