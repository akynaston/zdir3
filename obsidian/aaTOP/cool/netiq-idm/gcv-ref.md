2/27/2024 2:59:15 PM
Check this out: use a gcv-ref in shim settings to make use of a GCV here!

```
<driver-options>
		<configuration-values>
			<definitions>
				<gcv-ref driver-param-name="field-delimiter" name="driver.field.delimiter"/>
				<!-- <definition display-name="xlfid(NOVLDTXTBASE.initial.settings.param.field-delimiter)Field Delimiter:" name="field-delimiter" type="string">								<value>,</value>							</definition> -->
				<gcv-ref driver-param-name="field-names" name="driver.field-names"/>
				<!--	<definition display-name="xlfid(NOVLDTXTBASE.initial.settings.param.field-names)Field Names (Field1, Field2, Field3...):" name="field-names" type="string">								<value>WorkforceID,LastName,FirstName,Title,Email,WorkPhone,Fax,WirelessPhone,Description</value>							</definition> -->
				<definition display-name="Object Class Name:" name="object-class-name" type="string">
					<value>User</value>
				</definition>
				<definition display-name="Allow Driver to Consume Its Own Output?" name="allow-loopback" type="string">
					<value>no</value>
				</definition>
				<gcv-ref driver-param-name="drivertraceData" name="driver.traceData"/>
			</definitions>
		</configuration-values>
	</driver-options>
	<subscriber-options>
		<configuration-values>
			<definitions>
				<definition displ
```