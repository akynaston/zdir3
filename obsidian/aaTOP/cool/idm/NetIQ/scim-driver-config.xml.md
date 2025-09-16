<?xml version="1.0" encoding="UTF-8"?><driver-config name="SCIM Driver">
	<driver-options>
		<configuration-values>
			<definitions>
				<header display-name="Connection Parameters" id="177"/>
				<!-- <group>
								<definition display-name="xlfid(NETQSCIMBASE.initial.settings.param.driverEnabled)Channel Enabled" hide="false" id="107" name="driverEnabled" type="enum">
									<description>xlfid(NETQSCIMBASE.initial.settings.param.dscr.driverEnabled)Specify whether Publisher or Subscriber or both channel to be enabled.</description>
									<enum-choice display-name="xlfid(NETQSCIMBASE.initial.settings.param.choice.driverEnabled.Both)Both">Both</enum-choice>
									<enum-choice display-name="xlfid(NETQSCIMBASE.initial.settings.param.choice.driverEnabled.Publisher)Publisher">Publisher</enum-choice>
									<enum-choice display-name="xlfid(NETQSCIMBASE.initial.settings.param.choice.driverEnabled.Subscriber)Subscriber">Subscriber</enum-choice>
									<value>Both</value>
								</definition>
							</group> -->
				<group>
					<definition display-name="Authentication Method" hide="false" id="107" name="driverAuthMethod" type="enum">
						<description>Specify the authentication method:
									1.OAuth2.0 - OAuth2.0 Authorization Framework.
									2.Basic    - Basic Authentication based on Username and Password.</description>
						<!-- <enum-choice display-name="xlfid(NETQSCIMBASE.initial.settings.param.choice.driverAuthMethod.Anonymous)Anonymous">Anonymous</enum-choice> -->
						<enum-choice display-name="OAuth2.0">OAuth</enum-choice>
						<enum-choice display-name="Basic">Basic</enum-choice>
						<value>OAuth</value>
					</definition>
					<subordinates active-value="Basic">
						<definition display-name="User Name" hide="false" id="108" name="driverAuthBasicID" type="string">
							<description>Specify the username required for Basic authentication.</description>
							<value xml:space="preserve"/>
						</definition>
						<definition display-name="Password" hide="false" id="109" is-sensitive="true" name="driverAuthBasicPwd" type="password-ref">
							<description>Specify the password required for Basic authentication.</description>
							<value xml:space="preserve">driverAuthBasicPwd</value>
							<pwd-value removePwd="false"/>
						</definition>
						<definition display-name="Application Login URL" hide="false" id="108" name="driverAuthBasicUrl" type="string">
							<description>Specify the login URL of the connected application for Basic Authentication.</description>
							<value xml:space="preserve"/>
						</definition>
					</subordinates>
					<subordinates active-value="OAuth">
						<!--  Support Bearer Token -->
						<group>
							<definition critical-change="true" display-name="OAuth2.0 Token Management" hide="false" id="301" name="driverOauthTokenMethod" type="enum">
								<description>Options:
											1. Bearer -  Generate the Bearer Token using Query Options.
											2. JWT    -  Generate the JWT Token using Query Options.
											3. Manual -  Specify the Bearer Token value that is generated using API calls. For example, call REST API using Postman and copy the Bearer Token.</description>
								<value>generateBearer</value>
								<enum-choice display-name="Bearer ">generateBearer</enum-choice>
								<enum-choice display-name="JWT">generateJWT</enum-choice>
								<enum-choice display-name="Manual">enterBearerToken</enum-choice>
							</definition>
							<subordinates active-value="enterBearerToken">
								<definition display-name="Token" hide="false" id="303" name="bearerTokenID" type="string">
									<description>Specify Bearer Token value that is generated using API calls. For example, call REST API using Postman and specify the Bearer Token in the Token field. 
							
A sample token is shown below:
00D2v000002mBdQ!ARQAQAzAXhpgilDpcvN3RDgCkrfh4pyzCOv2G1Iq5kEMh0TRi</description>
									<value xml:space="preserve"/>
								</definition>
								<definition display-name="Query Options" id="113" instance-separator=" " name="http-queryBearer" type="structured" value-separator=";">
									<value>
										<instance>
											<definition display-name="Name" name="query-nameBearer" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">client_id</value>
											</definition>
											<definition display-name="Value" name="query-valueBearer" type="string">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve"/>
											</definition>
										</instance>
										<instance>
											<definition display-name="Name" name="query-nameBearer" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">issuer</value>
											</definition>
											<definition display-name="Value" name="query-valueBearer" type="string">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve"/>
											</definition>
										</instance>
									</value>
									<description>Specify the required names and values of the header Query Options that are supported by the connected application for OAuth 2.0 Authorization.</description>
									<template max-count="10" min-count="0">
										<definition display-name="Name" id="122" multiline="false" name="query-nameBearer" type="string">
											<description>Specify the name of the Query Option.</description>
										</definition>
										<definition display-name="Value" id="123" multiline="false" name="query-valueBearer" type="string">
											<description>Specify the value for the added Query Option.</description>
										</definition>
									</template>
								</definition>
								<definition display-name="Secret Query Options" id="113" instance-separator=" " name="http-query-passwordBearer" type="structured" value-separator=";">
									<value>
										<instance>
											<definition display-name="Name" name="query-name-passwordBearer" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">refresh_token</value>
											</definition>
											<definition display-name="Value" name="query-value-passwordBearer" type="password-ref">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve">query-value-passwordBearer-0</value>
											</definition>
										</instance>
										<instance>
											<definition display-name="Name" name="query-name-passwordBearer" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">client_secret</value>
											</definition>
											<definition display-name="Value" name="query-value-passwordBearer" type="password-ref">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve">query-value-passwordBearer-1</value>
											</definition>
										</instance>
									</value>
									<description>Specify the required names and values of the header Query Options that are supported by the connected application for OAuth 2.0 Authorization.

</description>
									<template max-count="10" min-count="0">
										<definition display-name="Name" id="122" multiline="false" name="query-name-passwordBearer" type="string">
											<description>Specify the name of the Query Option.</description>
										</definition>
										<definition display-name="Value" id="123" is-sensitive="true" name="query-value-passwordBearer" type="password-ref">
											<description>Specify the value for the added Query Option.</description>
											<value xml:space="preserve">query-value-passwordBearer</value>
											<value xml:space="preserve">query-value-passwordBearer-0</value>
											<value xml:space="preserve">query-value-passwordBearer-1</value>
										</definition>
									</template>
								</definition>
							</subordinates>
							<!--  Bearer Token End -->
							<!--  Start Generate JWT Token -->
							<subordinates active-value="generateJWT">
								<!-- <definition display-name="Access Token URL" hide="false" id="110" name="subOAuthURLJWT" type="string">
												<description> Specify the URL of the server used for requesting token access.</description>
												<value/>
											</definition>
											<definition display-name="User Name" hide="false" id="111" name="subOAuthIDJWT" type="string">
												<description>Specify the authentication ID for OAuth2.0 Authorization (on the HTTP header) is used.</description>
												<value/>
											</definition>
											<definition display-name="User Password" hide="false" id="112" is-sensitive="true" name="subOAuthPwdJWT" type="password-ref">
												<description>Specify the authentication password for OAuth2.0 Authorization (on the HTTP header) is used.</description>
												<value>subOAuthPwdJWT</value>
												<pwd-value removePwd="false"/>
											</definition>-->
								<definition display-name="Query Options" id="113" instance-separator=" " name="http-queryJWT" type="structured" value-separator=";">
									<value>
										<instance>
											<definition display-name="Name" name="query-nameJWT" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">client_id</value>
											</definition>
											<definition display-name="Value" name="query-valueJWT" type="string">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve"/>
											</definition>
										</instance>
										<instance>
											<definition display-name="Name" name="query-nameJWT" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">subject</value>
											</definition>
											<definition display-name="Value" name="query-valueJWT" type="string">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve"/>
											</definition>
										</instance>
										<instance>
											<definition display-name="Name" name="query-nameJWT" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">issuer</value>
											</definition>
											<definition display-name="Value" name="query-valueJWT" type="string">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve"/>
											</definition>
										</instance>
										<instance>
											<definition display-name="Name" name="query-nameJWT" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">client_auth_type</value>
											</definition>
											<definition display-name="Value" name="query-valueJWT" type="string">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve"/>
											</definition>
										</instance>
										<instance>
											<definition display-name="Name" name="query-nameJWT" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">recipient_keystore</value>
											</definition>
											<definition display-name="Value" name="query-valueJWT" type="string">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve"/>
											</definition>
										</instance>
									</value>
									<description>Specify the required names and values of the header Query Options that are supported by the connected application for OAuth 2.0 Authorization.
</description>
									<template max-count="10" min-count="0">
										<definition display-name="Name" id="122" multiline="false" name="query-nameJWT" type="string">
											<description>Specify the name of the Query Option.</description>
										</definition>
										<definition display-name="Value" id="123" multiline="false" name="query-valueJWT" type="string">
											<description>Specify the value for the added Query Option.</description>
										</definition>
									</template>
								</definition>
								<definition display-name="Secret Query Options" id="113" instance-separator=" " name="http-query-passwordJWT" type="structured" value-separator=";">
									<value>
										<instance>
											<definition display-name="Name" name="query-name-passwordJWT" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">recipient_storepass</value>
											</definition>
											<definition display-name="Value" name="query-value-passwordJWT" type="password-ref">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve">query-value-passwordJWT-0</value>
											</definition>
										</instance>
										<instance>
											<definition display-name="Name" name="query-name-passwordJWT" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">recipient_keypass</value>
											</definition>
											<definition display-name="Value" name="query-value-passwordJWT" type="password-ref">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve">query-value-passwordJWT-1</value>
											</definition>
										</instance>
										<instance>
											<definition display-name="Name" name="query-name-passwordJWT" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">refresh_token</value>
											</definition>
											<definition display-name="Value" name="query-value-passwordJWT" type="password-ref">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve">query-value-passwordJWT-2</value>
											</definition>
										</instance>
										<instance>
											<definition display-name="Name" name="query-name-passwordJWT" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">client_secret</value>
											</definition>
											<definition display-name="Value" name="query-value-passwordJWT" type="password-ref">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve">query-value-passwordJWT-3</value>
											</definition>
										</instance>
									</value>
									<description>Specify the required names and values of the header Query Options that are supported by the connected application for OAuth 2.0 Authorization.
</description>
									<template max-count="10" min-count="0">
										<definition display-name="Name" id="122" multiline="false" name="query-name-passwordJWT" type="string">
											<description>Specify the name of the Query Option.</description>
										</definition>
										<definition display-name="Value" id="123" is-sensitive="true" name="query-value-passwordJWT" type="password-ref">
											<description>Specify the value for the added Query Option.</description>
											<value xml:space="preserve">query-value-passwordJWT</value>
											<value xml:space="preserve">query-value-passwordJWT-0</value>
											<value xml:space="preserve">query-value-passwordJWT-1</value>
											<value xml:space="preserve">query-value-passwordJWT-2</value>
											<value xml:space="preserve">query-value-passwordJWT-3</value>
										</definition>
									</template>
								</definition>
							</subordinates>
							<!--  End Generate JWT Token -->
							<!--  Start Generate Bearer Token -->
							<subordinates active-value="generateBearer">
								<definition display-name="Access Token URL" hide="false" id="110" name="driverOAuthURL" type="string">
									<description>Specify the URL of the connected application that is used for requesting the token.
							
Example:
https://example.com/oauth2/token</description>
									<value xml:space="preserve"/>
								</definition>
								<definition display-name="User name" hide="false" id="111" name="driverOAuthID" type="string">
									<description>Specify the username for OAuth2.0 Authorization.</description>
									<value xml:space="preserve"/>
								</definition>
								<definition display-name="Password" hide="false" id="112" is-sensitive="true" name="driverOAuthPwd" type="password-ref">
									<description>Specify the password for OAuth2.0 Authorization.</description>
									<value xml:space="preserve">driverOAuthPwd</value>
									<pwd-value removePwd="false"/>
								</definition>
								<definition display-name="Query Options" id="113" instance-separator=" " name="http-query" type="structured" value-separator=";">
									<value>
										<instance>
											<definition display-name="Name" name="query-name" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">grant_type</value>
											</definition>
											<definition display-name="Value" name="query-value" type="string">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve"/>
											</definition>
										</instance>
										<instance>
											<definition display-name="Name" name="query-name" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">client_id</value>
											</definition>
											<definition display-name="Value" name="query-value" type="string">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve"/>
											</definition>
										</instance>
										<instance>
											<definition display-name="Name" name="query-name" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">issuer</value>
											</definition>
											<definition display-name="Value" name="query-value" type="string">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve"/>
											</definition>
										</instance>
									</value>
									<description>Specify the required names and values of the header Query Options that are supported by the connected application for OAuth 2.0 Authorization.
</description>
									<template max-count="10" min-count="0">
										<definition display-name="Name" id="122" multiline="false" name="query-name" type="string">
											<description>Specify the name of the Query Option.</description>
										</definition>
										<definition display-name="Value" id="123" multiline="false" name="query-value" type="string">
											<description>Specify the value for the added Query Option.</description>
										</definition>
									</template>
								</definition>
								<definition display-name="Secret Query Options" id="113" instance-separator=" " name="http-query-password" type="structured" value-separator=";">
									<value>
										<instance>
											<definition display-name="Name" name="query-name-password" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">refresh_token</value>
											</definition>
											<definition display-name="Value" name="query-value-password" type="password-ref">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve">query-value-password-0</value>
											</definition>
										</instance>
										<instance>
											<definition display-name="Name" name="query-name-password" type="string">
												<description>Specify the name of the Query Option.</description>
												<value xml:space="preserve">client_secret</value>
											</definition>
											<definition display-name="Value" name="query-value-password" type="password-ref">
												<description>Specify the value for the added Query Option.</description>
												<value xml:space="preserve">query-value-password-1</value>
											</definition>
										</instance>
									</value>
									<description>Specify the required names and values of the header Query Options that are supported by the connected application for OAuth 2.0 Authorization.
</description>
									<template max-count="10" min-count="0">
										<definition display-name="Name" id="122" multiline="false" name="query-name-password" type="string">
											<description>Specify the name of the Query Option.</description>
										</definition>
										<definition display-name="Value" id="123" is-sensitive="true" name="query-value-password" type="password-ref">
											<description>Specify the value for the added Query Option.</description>
											<value xml:space="preserve">query-value-password</value>
											<value xml:space="preserve">query-value-password-0</value>
											<value xml:space="preserve">query-value-password-1</value>
										</definition>
									</template>
								</definition>
							</subordinates>
							<!--  End Generate JWT Token -->
						</group>
					</subordinates>
				</group>
				<definition display-name="Header Fields" id="124" instance-separator=" " name="http-header" type="structured" value-separator=";">
					<value>
						<instance>
							<definition display-name="Name" name="header-name" type="string">
								<description>Specify the name of header field.</description>
								<value xml:space="preserve"/>
							</definition>
							<definition display-name="Value" name="header-value" type="string">
								<description>Specify the supported value for the specified header field.</description>
								<value xml:space="preserve"/>
							</definition>
						</instance>
					</value>
					<description>Specify the required authentication header fields and supported values for the selected authentication method.

Example:
header-name: Content-Type
header-value: application/json</description>
					<template max-count="100" min-count="0">
						<definition display-name="Name" id="125" multiline="false" name="header-name" type="string">
							<description>Specify the name of header field.</description>
						</definition>
						<definition display-name="Value" id="126" multiline="false" name="header-value" type="string">
							<description>Specify the supported value for the specified header field.</description>
						</definition>
					</template>
				</definition>
				<definition display-name="Application Truststore File" id="127" name="driverTrustStoreFile-1" type="string">
					<description>Specify the location of the truststore file with CA certificate of the connected application server. 
								Note: The trusted CA certificate truststore should be available in IDM Engine or Remote Loader where the driver is deployed.
						 
Example: 
(Absolute-path)/(CA Certificate Truststore filename)</description>
					<value xml:space="preserve"/>
				</definition>
				<!-- <group>
								<definition display-name="xlfid(NETQSCIMBASE.initial.settings.param.useSsldriver)Use SSL" hide="false" id="127" name="useSsldriver" type="enum">
									<description>xlfid(NETQSCIMBASE.initial.settings.param.dscr.useSsldriver)Select Yes if you want to use HTTPS connection.</description>
									<enum-choice display-name="xlfid(NETQSCIMBASE.initial.settings.param.choice.useSsldriver.Yes)Yes">yes</enum-choice>
									<enum-choice display-name="xlfid(NETQSCIMBASE.initial.settings.param.choice.useSsldriver.No)No">no</enum-choice>
									<value>no</value>
								</definition>
								<subordinates active-value="yes">
									<definition display-name="xlfid(NETQSCIMBASE.initial.settings.param.driverTrustStoreFile-1)Truststore File" hide="false" id="128" name="driverTrustStoreFile-1" type="string">
										<description>xlfid(NETQSCIMBASE.initial.settings.param.dscr.driverTrustStoreFile-1)When the remote server is configured to provide server authentication, this is the path and the name of the keystore file which contains trusted certificates. For example: c:\security\truststore. Leave this field blank when server authentication is not used.</description>
										<value/>
									</definition>
								</subordinates>
							</group> -->
				<group>
					<definition display-name="Mutual authentication" hide="false" id="129" name="mutualFields-1" type="enum">
						<description>Select "Yes" to enable mutual authentication.</description>
						<enum-choice display-name="No">no</enum-choice>
						<enum-choice display-name="Yes">yes</enum-choice>
						<value>no</value>
					</definition>
					<subordinates active-value="yes">
						<definition display-name="IDM Keystore File" hide="false" id="130" name="driverKeystoreFile-1" type="string">
							<description>Specify the location of the Keystore file of the IDM Engine or Remote Loader where the driver is deployed.
					

Example: 
(Absolute-path)/(Keystore filename)</description>
							<value xml:space="preserve"/>
						</definition>
						<definition display-name="IDM Keystore Password" hide="false" id="131" is-sensitive="true" name="driverKeystorePassword-1" type="password-ref">
							<description>Specify the Keystore file Password.</description>
							<value xml:space="preserve">driverKeystorePassword-1</value>
						</definition>
					</subordinates>
				</group>
				<group>
					<definition display-name="Proxy authentication" hide="false" id="132" name="proxyFields" type="enum">
						<description>Specify the Proxy Authentication parameters.</description>
						<enum-choice display-name="Hide">hide</enum-choice>
						<enum-choice display-name="Show">show</enum-choice>
						<value>hide</value>
					</definition>
					<subordinates active-value="show">
						<definition display-name="Proxy host name and port" id="133" name="proxy" type="string">
							<description>Specify the hostname and port of the Proxy Server.	

Example: 
Hostname:Port 
example.com:1818</description>
							<value xml:space="preserve"/>
						</definition>
						<definition display-name="Username" id="134" name="proxyUserName" type="string">
							<description>Specify the username for Proxy Authentication.</description>
							<value xml:space="preserve"/>
						</definition>
						<definition display-name="Password" id="135" name="proxyPassword" type="password-ref">
							<description>Specify the password for Proxy Authentication.</description>
							<value xml:space="preserve">proxyPassword</value>
						</definition>
					</subordinates>
				</group>
				<definition display-name="HTTPS Connection Timeout" id="136" name="connTimeOut" type="string">
					<description>Time in minutes for the driver to wait for the SCIM response.</description>
					<value xml:space="preserve">1</value>
				</definition>
				<gcv-ref driver-param-name="driverHttpScimBaseUrl" name="driverHttpScimBaseUrlGCV"/>
				<gcv-ref hide="true" name="driverValidateResource" type="enum"/>
				<!-- Commenting for Beta only -->
				<!--<header display-name="xlfid(NETQSCIMBASE.initial.settings.param.header.AdvancedSettings)Advanced Settings" id="177"/>
							<group>
								<definition display-name="xlfid(NETQSCIMBASE.initial.settings.param.driveradvScimSettings)Advanced Settings" id="176" name="driveradvScimSettings" type="enum">
									<description>xlfid(NETQSCIMBASE.initial.settings.param.dscr.driveradvScimSettings)Specify whether to show or hide the Schema Settings and Modifier Settings Options.</description>
									<enum-choice display-name="xlfid(NETQSCIMBASE.initial.settings.param.choice.driveradvScimSettings.Hide)Hide">no</enum-choice>
									<enum-choice display-name="xlfid(NETQSCIMBASE.initial.settings.param.choice.driveradvScimSettings.Show)Show">yes</enum-choice>
									<value>no</value>
								</definition>
								<subordinates active-value="yes">-->
				<header display-name="Schema Settings" id="138"/>
				<group>
					<definition display-name="Refresh Schema on Driver Startup" hide="false" id="139" name="driverIsRefreshSchema" type="enum">
						<description>Specify "Yes" to refresh the Schema. This option MUST be selected only for the first time to load the Application Schema or if the Application Schema has been changed. 
									You MUST change the value to "No" once the Application Schema is loaded and the Schema Mapping is completed.</description>
						<value>false</value>
						<enum-choice display-name="yes">true</enum-choice>
						<enum-choice display-name="no">false</enum-choice>
					</definition>
					<subordinates active-value="true">
						<group>
							<definition display-name="Schema Options" hide="false" id="140" name="driverSchemaOptions" type="enum">
								<description>Options:
													1. SCIM 2.0                - SCIM 2.0 Schema for Users and Groups as defined in RFC 7643.
											 
													2. Application URL    - The connected application's SCIM Endpoint providing the SCIM JSON 
													Schema for resources such as Users, Groups and Roles etc. 
													For example:https://example.com/api/rest/scim/v2/Schemas.
											 
													3. Import JSON File   - Import the user defined JSON Schema file from the local file system. 
													This file must be compliant to the SCIM JSON format as per RFC 7643.</description>
								<value>driverDefaultSchema</value>
								<enum-choice display-name="SCIM 2.0">driverDefaultSchema</enum-choice>
								<enum-choice display-name="Application URL">driverOnlineSchema</enum-choice>
								<enum-choice display-name="Import JSON File">driverCustomSchema</enum-choice>
							</definition>
							<subordinates active-value="driverOnlineSchema">
								<definition display-name="Application URL" hide="false" id="142" name="driverScimSchemaEndPoint" type="string">
									<description>Specify the SCIM URL to pull the JSON Schema of the connected application.
									
Example:
https://example.com/api/rest/scim/v2/Schemas</description>
									<value xml:space="preserve"/>
								</definition>
							</subordinates>
							<subordinates active-value="driverCustomSchema">
								<definition display-name="Import JSON File" hide="false" id="143" name="driverScimSchemaCustomLocation" type="string">
									<description>Specify the path of the user defined JSON Schema file.
									
Example:
(Absolute-Path)/(filename).json</description>
									<value xml:space="preserve"/>
								</definition>
							</subordinates>
							<definition display-name="Resource Type" id="144" instance-separator=" " name="driverScimSchemaResourceIncluded" type="structured" value-separator=";">
								<description>Specify the Resource ID and the Resource EndPoint for resources such as Users, Groups, Roles and Entitlements etc. in Uniform Resource Name (URN) format.
								
Example:
Resource ID          : urn:ietf:params:scim:schemas:core:2.0:User
Resource EndPoint  : Users</description>
								<value>
									<instance>
										<definition display-name="Resource ID" name="driverScimSchemaResourceId" type="string">
											<description>Specify the Resource ID in URN format.</description>
											<value xml:space="preserve">urn:ietf:params:scim:schemas:core:2.0:User</value>
										</definition>
										<definition display-name="Resource EndPoint" name="driverScimSchemaResourceName" type="string">
											<description>Specify the Resource EndPoint. For example, Users, Groups, Roles and Entitlements etc.</description>
											<value xml:space="preserve">Users</value>
										</definition>
										<definition display-name="Modify Method Operation" name="driverScimSchemaResourceModifyOperation" type="enum">
											<description>Specify the Modify Operation Method that is either PUT or PATCH</description>
											<value>modifyPut</value>
											<enum-choice display-name="PUT">modifyPut</enum-choice>
											<enum-choice display-name="PATCH">modifyPatch</enum-choice>
										</definition>
									</instance>
									<instance>
										<definition display-name="Resource ID" name="driverScimSchemaResourceId" type="string">
											<description>Specify the Resource ID in URN format.</description>
											<value xml:space="preserve">urn:ietf:params:scim:schemas:core:2.0:Group</value>
										</definition>
										<definition display-name="Resource EndPoint" name="driverScimSchemaResourceName" type="string">
											<description>Specify the Resource EndPoint. For example, Users, Groups, Roles and Entitlements etc.</description>
											<value xml:space="preserve">Groups</value>
										</definition>
										<definition display-name="Modify Method Operation" name="driverScimSchemaResourceModifyOperation" type="enum">
											<description>Specify the Modify Operation Method that is either PUT or PATCH</description>
											<value>modifyPut</value>
											<enum-choice display-name="PUT">modifyPut</enum-choice>
											<enum-choice display-name="PATCH">modifyPatch</enum-choice>
										</definition>
									</instance>
								</value>
								<template max-count="100" min-count="0">
									<definition display-name="Resource ID" id="147" name="driverScimSchemaResourceId" type="string">
										<description>Specify the Resource ID in URN format.</description>
										<value xml:space="preserve"/>
										<value xml:space="preserve">urn:ietf:params:scim:schemas:core:2.0:User</value>
										<value xml:space="preserve">urn:ietf:params:scim:schemas:core:2.0:Group</value>
									</definition>
									<definition display-name="Resource EndPoint" id="148" name="driverScimSchemaResourceName" type="string">
										<description>Specify the Resource EndPoint. For example, Users, Groups, Roles and Entitlements etc.</description>
										<value xml:space="preserve"/>
										<value xml:space="preserve">Users</value>
										<value xml:space="preserve">Groups</value>
									</definition>
									<definition display-name="Modify Method Operation" id="146" name="driverScimSchemaResourceModifyOperation" type="enum">
										<description>Specify the Modify Operation Method that is either PUT or PATCH</description>
										<enum-choice display-name="PUT">modifyPut</enum-choice>
										<enum-choice display-name="PATCH">modifyPatch</enum-choice>
										<value>modifyPut</value>
										<value>modifyPut</value>
										<value>modifyPut</value>
									</definition>
								</template>
							</definition>
						</group>
					</subordinates>
				</group>
				<header display-name="Modifier Settings" id="250"/>
				<group>
					<definition display-name="Custom Java Class" id="176" name="viewJavaGroup" type="enum">
						<description>Select Show if you have developed custom Java classes to extend the driver shim's functionality.</description>
						<enum-choice display-name="Hide">hide</enum-choice>
						<enum-choice display-name="Show">show</enum-choice>
						<value>hide</value>
					</definition>
					<subordinates active-value="show">
						<group>
							<definition display-name="Document Handling" id="177" name="documentJavaGroup" type="enum">
								<description>Select "Yes" if you want to use custom Java classes to process the data as JSON documents.</description>
								<enum-choice display-name="No">no</enum-choice>
								<enum-choice display-name="Yes">yes</enum-choice>
								<value>no</value>
							</definition>
							<subordinates active-value="yes">
								<definition display-name="Class" id="178" name="documentClass" type="string">
									<description>Specify the class using a full package identifier. 
									
Example: 
com.novell.MyNewClass</description>
									<value xml:space="preserve"/>
								</definition>
								<definition display-name="Init Parameter" id="179" name="documentParam" type="string">
									<description>Specify the parameters that you want to pass to the init() method of your class in string format. 
														 The init method of your class is responsible for parsing the information contained 
														 in this string. Leave this field blank if your class doesn't require a configuration 
														 string to be passed to the init method.</description>
									<value xml:space="preserve"/>
								</definition>
							</subordinates>
						</group>
						<!--</subordinates>
									</group>-->
					</subordinates>
				</group>
			</definitions>
		</configuration-values>
	</driver-options>
	<subscriber-options>
		<configuration-values>
			<definitions>
				<definition display-name="HTTPS error codes for retry" id="147" name="subHttpErrorsToRetry" type="string">
					<description>Specify the HTTP error codes that should return a retry status. Must be a list of integers separated by spaces.</description>
					<value xml:space="preserve">307 408 503 504</value>
				</definition>
			</definitions>
		</configuration-values>
	</subscriber-options>
	<publisher-options>
		<configuration-values>
			<definitions>
				<group>
					<definition display-name="Enable publisher channel" hide="false" id="139" name="enablePublisherChannel" type="enum">
						<description>Specify "Yes" to enable publisher channel.</description>
						<value>false</value>
						<enum-choice display-name="yes">true</enum-choice>
						<enum-choice display-name="no">false</enum-choice>
					</definition>
					<subordinates active-value="true">
						<definition display-name="Polling interval in minutes" id="148" name="pollingInterval" type="string">
							<description>Specify the polling interval in minutes. </description>
							<value xml:space="preserve">10</value>
						</definition>
						<group>
							<definition display-name="Polling Resource Options" id="165" name="pollingResources" type="enum">
								<description>Options:
																												 1.Select "Configured Resources" to poll on all resources configured as part of schema settings.
																												 2.Select "Custom Resources" to configure customized polling Resource ID and Resource URL.</description>
								<enum-choice display-name="Configured Resources">default</enum-choice>
								<enum-choice display-name="Custom Resources">custom</enum-choice>
								<value>default</value>
							</definition>
							<subordinates active-value="custom">
								<definition display-name="Configure Custom Resources to poll" id="166" instance-separator=" " name="pollingResourcesCustom" type="structured" value-separator=";">
									<value/>
									<description>Specify the polling Resource ID and Resource URL</description>
									<template>
										<definition display-name="Resource ID" id="117" multiline="false" name="pollingResourcesCustomEndpointSchema" type="string">
											<description>Specify the Resource ID in URN format.For example, urn:ietf:params:scim:schemas:core:2.0:User</description>
											<value/>
										</definition>
										<definition display-name="Resource URL" id="117" multiline="false" name="pollingResourcesCustomEndpoint" type="string">
											<description>Specify the Resource URL. This URL can include query parameters as well. For example, https://ap15.salesforce.com/services/scim/v2/Users.</description>
											<value/>
										</definition>
									</template>
								</definition>
							</subordinates>
						</group>
					</subordinates>
				</group>
				<definition display-name="Heartbeat interval in minutes" id="149" name="heartbeat" type="string">
					<description>Specify the heartbeat interval in minutes. Leave this field blank to turn off the heartbeat.</description>
					<value xml:space="preserve">10</value>
				</definition>
			</definitions>
		</configuration-values>
	</publisher-options>
</driver-config>