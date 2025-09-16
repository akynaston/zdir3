	<property name="exports.driverExportFailover" value="IDtoLDAP-failover.xml"/>



		<!-- ============================================= ALPHA SECONDARY ============================================= -->
		<xsltAndVersion in="${swa.alpha}/${exports.driverExport}" out="${swa.alpha}/${exports.driverExportFailover}" style="driver-xml-output-failover-config.xsl">
			<param name="driver-start-option" expression="0"/>
			<param name="shim-auth-server" expression="REMOTE(hostname=w11dcledirai010.swacorp.com port=8090)"/>
		</xsltAndVersion>