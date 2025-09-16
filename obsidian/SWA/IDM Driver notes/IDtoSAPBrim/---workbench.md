9/6/2024 12:03:50 PM
Had chat with Nirosha need to have story created to add opGetToken to the SCIM connector.

SWAV - SAP BRIM | IT-01820 | IDM - Add opGetToken to the IdMUnit SCIM connector
https://southwest.atlassian.net/browse/CSEE-4061


IDtoSAPBirm
non prod
username: 3f055bc4-1497-4c69-bfbb-8ba515eb934b
password: XHskVHUsKTAdF6qBqvsB7oep3n3lnP?Icz

Nirosha's location of username and key
```
              <definition display-name="Access Token URL" hide="false" name="driverOAuthURL" type="string">  
<description>Specify the URL of the connected application that is used for requesting the token.  
  
Example:  
[https://example.com/oauth2/token</description>](https://example.com/oauth2/token</description> "https://example.com/oauth2/token%3c/description%3e")  
<value xml:space="preserve">[https://au65iw11u.accounts.ondemand.com/oauth2/token</value>](https://au65iw11u.accounts.ondemand.com/oauth2/token</value> "https://au65iw11u.accounts.ondemand.com/oauth2/token%3c/value%3e")  
</definition>  
<definition display-name="User name" hide="false" name="driverOAuthID" type="string">  
<description>Specify the username for OAuth2.0 Authorization.</description>  
<value xml:space="preserve">3f055bc4-1497-4c69-bfbb-8ba515eb934b</value>  
</definition>  
<definition display-name="Password" hide="false" is-sensitive="true" name="driverOAuthPwd" type="password-ref">  
<description>Specify the password for OAuth2.0 Authorization.</description>  
<value xml:space="preserve">driverOAuthPwd</value>  
</definition>  
<definition display-name="Query Options" instance-separator=" " name="http-query" type="structured" value-separator=";">  
<value>  
<instance>  
<definition display-name="Name" name="query-name" type="string">  
<description>Specify the name of the Query Option.</description>  
<value xml:space="preserve">grant_type</value>  
</definition>  
<definition display-name="Value" name="query-value" type="string">  
<description>Specify the value for the added Query Option.</description>  
<value xml:space="preserve">client_credentials</value>  
</definition>  
</instance>  
</value>
```