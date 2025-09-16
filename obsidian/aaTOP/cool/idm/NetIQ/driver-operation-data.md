
6/10/2025 4:49:44 PM
Common payload; here's some examples - not the cleanest, but they work.

Example aviobook

```

<nds dtdversion="3.0">
  <source>
    <product build="20250530_1155" version="1.3.1.0000">Identity Manager REST Driver</product>
    <contact>NetIQ Corporation.</contact>

  </source>
  <output>
    <status event-id="w11dcledirdi019#20250609224342#3#2:9b359314-9ac4-4faa-97c9-1493359bc49a" level="error" type="driver-general">
      <driver-operation-data class-name="User" command="add" dest-dn="\DEV_SWACO_ID\swaiddev\Users\e179481" event-id="w11dcledirdi019#20250609224342#3#2:9b359314-9ac4-4faa-97c9-1493359bc49a" is-not-sensitive="true" src-dn="\DEV_SWACO_ID\swaiddev\Users\e179481">
        <response>
          <url-token/>
          <header AVIO-Token="eyJraWQiOiIxMzIwMjQ5MzEwIiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJhdmlvLWlkcC1hcGkiLCJjYW5SZXRyaWV2ZVBlcm1pc3Npb25zIjp0cnVlLCJyb2xlcyI6WyJhcGktdXNlci1yb2xlIiwiZTZiNDk3YmEtYTc1Ny00Y2RmLWFkZWItMTI1ZjYzZjExY2Y1Il0sImlzcyI6ImlkZW50aXR5LXByb3ZpZGVyLXNlcnZpY2UiLCJjYW5Bc3NpZ25QZXJtaXNzaW9ucyI6dHJ1ZSwibmJmIjoxNzQ5NTA5MDI0LCJvcmdhbml6YXRpb24iOiJkZWZhdWx0IiwibmFtZSI6ImF2aW8taWRwLWFwaSBhdmlvLWlkcC1hcGkiLCJ1c2VyVHlwZSI6IlVTRVIiLCJleHAiOjE3NDk1MDkzMjQsImlhdCI6MTc0OTUwOTAyNCwiZW1haWwiOiIiLCJ1c2VybmFtZSI6ImF2aW8taWRwLWFwaSJ9.QXs10k8We_Q7hy70gwsezWcnhKeFx_aojdFrME6swGMz7osHfIaYCfyIOWCKIJ2GdFKY2muirUpLt7iJkGlU6hAyzvGjwBSwCYf66hFHdCUrnUf7qNfKsufPca7Xz5kyDI09BfNBrfBoog8ab8AHIKvV_wLaHK0WUfeeiMTqSJf8beJ3B_e87Ou418CZTg7shs1n3eZ7NT9zD9eH5F93-ec_cShcdGBOQXinvk3kXXx3zq2m51eIxM0F1LzL6Bq-TnZAS-_EqmLQfhexifFpmk99izcIzaJrhnW_OdbNGPiMCc8ZE4ZRXNz5Bru2pzI-R-le6bdObgzYaGkWYR-_IQ" User-Agent="SWA" content-type="application/json"/>
          <header User-Agent="SWA" content-type="application/json"/>
          <header User-Agent="SWA"/>
          <response-header Cache-Control="no-cache, no-store, max-age=0, must-revalidate" Connection="keep-alive" Content-Security-Policy="default-src 'self' sandbox ''; frame-ancestors 'self'" Content-Type="application/json" Date="Mon, 09 Jun 2025 22:43:45 GMT" Expires="0" Pragma="no-cache" Strict-Transport-Security="max-age=31536000; includeSubDomains" Transfer-Encoding="chunked" Vary="Origin,Access-Control-Request-Method,Access-Control-Request-Headers" X-Content-Type-Options="nosniff" X-Frame-Options="DENY" X-XSS-Protection="0"/>
          <value message="" status="404">{"timestamp":"2025-06-09T22:43:45.081+00:00","status":404,"error":"Not Found","path":"/idp/users/"}</value>
        </response>
      </driver-operation-data>
      <operation-data DRIVER_REVISION="1.9.6-CSEE-5028-x266698" objectType="employee" opAvioBookRoles="#avio_connect_goramp"/>
    </status>
  </output>
</nds>
```
Example from:
https://www.netiq.com/documentation/identity-manager-48-drivers/generic_rest/data/driver-concepts.html
```

<driver-operation-data class-name="User" command="add">
        <request method="put" url="https://172.16.0.0:XXXX/User/rest123">
          <url-token association="rest123"/>
          <header content-type="application/json"/>
          <value>{"CN":[{"value":"rest6789"}],"Full Name":[{"value":"rest6789 rest6789"}],"Given Name":[{"value":"rest6789"}],","Surname":[{"value":"rest6789"}],"Login Disabled":[{"value":"true"}]}
          </value>
        </request>
        <request method="put" url="https://172.16.0.0:XXXX/User/rest123">
         <url-token association="rest123"/>
          <header content-type="application/json"/>
          <value>{"CN":[{"value":"rest1234"}],"Full Name":[{"value":"rest1234 rest1234"}],"Given Name":[{"value":"rest1234"}],","Surname":[{"value":"rest1234"}],"Login Disabled":[{"value":"true"}]}
          </value>
        </request>
</driver-operation-data>\


```