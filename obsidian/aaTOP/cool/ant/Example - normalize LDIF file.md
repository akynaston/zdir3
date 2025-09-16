8/16/2024 5:27:47 PM
botom of this is cool!
```
<?xml version="1.0"?>
<project name="SWA" default="dist" basedir=".">
	<import file="idm-common/build-main.xml"/>
	<property name="exports.driverExport" value="RBEAEv1.xml"/>
	<property name="exports.driverExportFailover" value="RBEAEv1-failover.xml"/>

	<!-- Update this target with your driver build, keep it named 'driver-xml-output': -->
	<target name="driver-xml-output">
		<!-- ============================================= ALPHA PRIMARY ============================================= -->
		<xsltAndVersion in="${exports.dir}/${exports.driverExport}" out="${swa.alpha}/${exports.driverExport}" style="driver-xml-output-config.xsl">
			<param name="common.templaterepo.topo" expression="SWA-IDALPHA"/>
			<param name="driver-start-option" expression="2"/>
			<param name="trace-size-limit" expression="100000"/>
			<param name="trace-level" expression="1"/>
			<param name="gcvExampleGCVValue" expression="Unique\To\DEV"/>
		</xsltAndVersion>
		<!-- Failover Server -->
		<xsltAndVersion in="${swa.alpha}/${exports.driverExport}" out="${swa.alpha}/${exports.driverExportFailover}" style="./idm-common/config/driver-xml-failover-server-config.xsl"/>
		<!-- ============================================= DEV PRIMARY ============================================= -->
		<xsltAndVersion in="${exports.dir}/${exports.driverExport}" out="${swa.dev}/${exports.driverExport}" style="driver-xml-output-config.xsl">
			<param name="common.templaterepo.topo" expression="swaiddev"/>
			<param name="driver-start-option" expression="2"/>
			<param name="trace-size-limit" expression="100000"/>
			<param name="trace-level" expression="1"/>
			<param name="gcvExampleGCVValue" expression="Unique\To\DEV"/>
		</xsltAndVersion>
		<!-- Failover Server: Method 1 - If you just want to disable the driver you can reference the common failover xsl-->
		<xsltAndVersion in="${swa.dev}/${exports.driverExport}" out="${swa.dev}/${exports.driverExportFailover}" style="./idm-common/config/driver-xml-failover-server-config.xsl"/>

		<!-- Failover Server: Method 2 - Create a new XSL document and transform all the attributes required -->
		<!-- ============================================= DEV SECONDARY ============================================= -->
<!--		<xsltAndVersion in="${swa.dev}/${exports.driverExport}" out="${swa.dev}/${exports.driverExportFailover}" style="driver-xml-output-failover-config.xsl">-->
<!--			<param name="driver-start-option" expression="0"/>-->
<!--		</xsltAndVersion>-->
		<!-- ============================================= SAT ============================================= -->
		<xsltAndVersion in="${exports.dir}/${exports.driverExport}" out="${swa.sat}/${exports.driverExport}" style="driver-xml-output-config.xsl">
			<param name="common.templaterepo.topo" expression="swa-idsat"/>
			<param name="driver-start-option" expression="2"/>
			<param name="trace-size-limit" expression="100000"/>
			<param name="trace-level" expression="1"/>
			<param name="gcvExampleGCVValue" expression="Unique\To\QA"/>
		</xsltAndVersion>
		<!-- Failover Server -->
		<xsltAndVersion in="${swa.sat}/${exports.driverExport}" out="${swa.sat}/${exports.driverExportFailover}" style="./idm-common/config/driver-xml-failover-server-config.xsl"/>
		<!-- ============================================= PROD ============================================= -->
		<xsltAndVersion in="${exports.dir}/${exports.driverExport}" out="${swa.prod}/${exports.driverExport}" style="driver-xml-output-config.xsl">
			<param name="common.templaterepo.topo" expression="SWA-ID"/>
			<param name="driver-start-option" expression="2"/>
			<param name="trace-size-limit" expression="100000"/>
			<param name="trace-level" expression="1"/>
			<param name="gcvExampleGCVValue" expression="Unique\To\PROD"/>
		</xsltAndVersion>
		<!-- Failover Server -->
		<xsltAndVersion in="${swa.prod}/${exports.driverExport}" out="${swa.prod}/${exports.driverExportFailover}" style="./idm-common/config/driver-xml-failover-server-config.xsl"/>
	</target>


    <target name="normalize" depends="swa-main-idm-build.normalize">
        <echo>About to remove unneeded lines from auxiliary\Entitlement Policies.ldif, and techlog entitlements file.</echo>
        <antcall target="normalize-ep">
            <param name="epLdifFile" value="auxiliary/Entitlement Policies.ldif"/>
        </antcall>
    </target>

    <target name="normalize-ep">

        <!-- Start by unfolding the LDIF file: -->
        <replaceregexp file="${epLdifFile}"
               match="(\r?\n) "
               flags="g"
               replace=""/>

        <!-- Remove unneded lines: -->
        <copy file="${epLdifFile}" tofile="${epLdifFile}.temp">
            <filterchain>
                <linecontains negate="true">
                    <contains value="cn:"/>
                </linecontains>
                <linecontains negate="true">
                    <contains value="DirXML-Associations:"/>
                </linecontains>
                <linecontains negate="true">
                    <contains value="member:"/>
                </linecontains>
            </filterchain>
        </copy>
        <copy file="${epLdifFile}.temp" tofile="${epLdifFile}"/>

        <delete file="${epLdifFile}.temp"/>

        <!-- Now, we need to sort each entry by DN. To do this, lets regex replace any line not starting with dn;, sort the remaining DN only lines,
        then restore the hard returns!
        -->
        <!-- Start by unfolding the LDIF file: -->
        <replaceregexp file="${epLdifFile}"
               match="\n^(?!dn:)(.*)"
               flags="gm"
               replace="#-#-#-\1"/>


        <copy file="${epLdifFile}" tofile="${epLdifFile}.temp">
            <filterchain>
                <sortfilter/>
            </filterchain>
        </copy>
        <copy file="${epLdifFile}.temp" tofile="${epLdifFile}"/>
        <delete file="${epLdifFile}.temp"/>

        <!-- restore hard returns -->
          <replaceregexp file="${epLdifFile}"
           match="#-#-#-"
           flags="gm"
           replace="${line.separator}"/>


        <!-- Decode the base64 lines to have clean storage and easy diffing. -->



    </target>

</project>

```