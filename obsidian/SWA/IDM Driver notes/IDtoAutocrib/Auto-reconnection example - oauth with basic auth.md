Gokul, check this out!

Great news! When the token is expired, the shim does take care of the reconnection!! I'm not using a refresh token of course . .as we mentioned, we're not sure how that would work anyway . . (doh . .), but check this out:


I sent a query command:


</source>
  <input>
    <driver-operation-data class-name="Employee" command="query" event-id="0" src-dn="">
      <request>
        <url-token querystring="102913"/>
        <header/>
        <value/>
      </request>
    </driver-operation-data>
  </input>
</nds>
[01/14/25 18:52:23.873]:IDtoAutocrib ST:        IDtoAutocrib: RESTSubscriptionShim.execute() :
[01/14/25 18:52:23.873]:IDtoAutocrib ST:        IDtoAutocrib: queryHandler
[01/14/25 18:52:23.873]:IDtoAutocrib ST:        IDtoAutocrib: queryHandler: class-name  == 'Employee'
[01/14/25 18:52:23.874]:IDtoAutocrib ST:        IDtoAutocrib: Query: preparing GET to https://api.autocrib.net/v1/Employee/102913
[01/14/25 18:52:23.874]:IDtoAutocrib ST:        IDtoAutocrib: Resetting headers
[01/14/25 18:52:23.874]:IDtoAutocrib ST:        IDtoAutocrib: Setting the following HTTP request properties:
 Authorization: <content suppressed>
[01/14/25 18:52:23.874]:IDtoAutocrib ST:        IDtoAutocrib:  dbid:10636
[01/14/25 18:52:23.875]:IDtoAutocrib ST:        IDtoAutocrib:  Content-Type:application/json
[01/14/25 18:52:23.875]:IDtoAutocrib ST:        IDtoAutocrib: Trying to use existing token
[01/14/25 18:52:23.875]:IDtoAutocrib ST:        IDtoAutocrib: Did a HTTP GET with 0 bytes of data to https://api.autocrib.net/v1/Employee/102913
[01/14/25 18:52:23.875]:IDtoAutocrib ST:        IDtoAutocrib: *******************************************************
[01/14/25 18:52:23.876]:IDtoAutocrib ST:        IDtoAutocrib: **********************LOGGING REQUEST******************
[01/14/25 18:52:23.876]:IDtoAutocrib ST:        IDtoAutocrib: *******************************************************
[01/14/25 18:52:23.876]:IDtoAutocrib ST:        IDtoAutocrib: Request URL :https://api.autocrib.net/v1/Employee/102913
[01/14/25 18:52:23.876]:IDtoAutocrib ST:        IDtoAutocrib: Http Method : GET
[01/14/25 18:52:23.877]:IDtoAutocrib ST:        IDtoAutocrib: Sending http request with below headers :-
[01/14/25 18:52:23.877]:IDtoAutocrib ST:        IDtoAutocrib: Authorization: <content suppressed>
[01/14/25 18:52:23.877]:IDtoAutocrib ST:        IDtoAutocrib: dbid: 10636
[01/14/25 18:52:23.877]:IDtoAutocrib ST:        IDtoAutocrib: Content-Type: application/json
[01/14/25 18:52:23.877]:IDtoAutocrib ST:        IDtoAutocrib: ***************************END**************************
[01/14/25 18:52:24.090]:IDtoAutocrib ST:        IDtoAutocrib: ********************************************************
[01/14/25 18:52:24.090]:IDtoAutocrib ST:        IDtoAutocrib: ***********************LOGGING RESPONSE*****************
[01/14/25 18:52:24.091]:IDtoAutocrib ST:        IDtoAutocrib: ********************************************************

Check this out - we see that it tried to do a query, and swa that were unauthorized:


[01/14/25 18:52:24.091]:IDtoAutocrib ST:        IDtoAutocrib: Http response code : 401
[01/14/25 18:52:24.091]:IDtoAutocrib ST:        IDtoAutocrib: Http response status : HTTP/1.1 401 Unauthorized
[01/14/25 18:52:24.091]:IDtoAutocrib ST:        IDtoAutocrib: Getting http response with below headers :-
[01/14/25 18:52:24.092]:IDtoAutocrib ST:        IDtoAutocrib: Date: Wed, 15 Jan 2025 00:52:24 GMT
[01/14/25 18:52:24.092]:IDtoAutocrib ST:        IDtoAutocrib: Transfer-Encoding: chunked
[01/14/25 18:52:24.092]:IDtoAutocrib ST:        IDtoAutocrib: Connection: keep-alive
[01/14/25 18:52:24.092]:IDtoAutocrib ST:        IDtoAutocrib: Cache-Control: no-cache, no-store, must-revalidate
[01/14/25 18:52:24.092]:IDtoAutocrib ST:        IDtoAutocrib: pragma: no-cache
[01/14/25 18:52:24.093]:IDtoAutocrib ST:        IDtoAutocrib: expires: 0
[01/14/25 18:52:24.093]:IDtoAutocrib ST:        IDtoAutocrib: strict-transport-security: max-age=15552000; includeSubDomains
[01/14/25 18:52:24.093]:IDtoAutocrib ST:        IDtoAutocrib: x-frame-options: SAMEORIGIN
[01/14/25 18:52:24.093]:IDtoAutocrib ST:        IDtoAutocrib: permissions-policy: camera=(),microphone=()
[01/14/25 18:52:24.093]:IDtoAutocrib ST:        IDtoAutocrib: content-security-policy: default-src 'self'; img-src 'self'; script-src 'self' 'unsafe-inline'; style-src 'self' 'unsafe-inline'
[01/14/25 18:52:24.094]:IDtoAutocrib ST:        IDtoAutocrib: x-content-type-options: nosniff
[01/14/25 18:52:24.094]:IDtoAutocrib ST:        IDtoAutocrib: www-authenticate: Bearer error="invalid_token", error_description="The token expired at '01/14/2025 23:22:14'"
[01/14/25 18:52:24.094]:IDtoAutocrib ST:        IDtoAutocrib: x-powered-by: ASP.NET
[01/14/25 18:52:24.094]:IDtoAutocrib ST:        IDtoAutocrib: CF-Cache-Status: DYNAMIC
[01/14/25 18:52:24.095]:IDtoAutocrib ST:        IDtoAutocrib: Server: cloudflare
[01/14/25 18:52:24.095]:IDtoAutocrib ST:        IDtoAutocrib: CF-RAY: 9021e2017c4b69bf-DFW
[01/14/25 18:52:24.095]:IDtoAutocrib ST:        IDtoAutocrib: alt-svc: h3=":443"; ma=86400
[01/14/25 18:52:24.095]:IDtoAutocrib ST:        IDtoAutocrib: Sending http response with body :-
[01/14/25 18:52:24.095]:IDtoAutocrib ST:        IDtoAutocrib: **********************END*****************************

Then this!!  Cool eh??

[01/14/25 18:52:24.096]:IDtoAutocrib ST:        IDtoAutocrib: Access Token expired, Getting new Access token using Refresh token
[01/14/25 18:52:24.096]:IDtoAutocrib ST:        IDtoAutocrib: Refresh Token or Client Secret not Availble
[01/14/25 18:52:24.096]:IDtoAutocrib ST:        IDtoAutocrib: Generating New Bearer Token
[01/14/25 18:52:24.096]:IDtoAutocrib ST:        IDtoAutocrib: Connecting to REST service via OAuth2
[01/14/25 18:52:24.097]:IDtoAutocrib ST:        IDtoAutocrib: key = application/x-www-form-urlencoded
[01/14/25 18:52:24.097]:IDtoAutocrib ST:        IDtoAutocrib: key = <content suppressed>
[01/14/25 18:52:24.097]:IDtoAutocrib ST:        IDtoAutocrib: Sending HTTP Request
[01/14/25 18:52:24.097]:IDtoAutocrib ST:        IDtoAutocrib: *******************************************************
[01/14/25 18:52:24.097]:IDtoAutocrib ST:        IDtoAutocrib: **********************LOGGING REQUEST******************
[01/14/25 18:52:24.098]:IDtoAutocrib ST:        IDtoAutocrib: *******************************************************
[01/14/25 18:52:24.098]:IDtoAutocrib ST:        IDtoAutocrib: Request URL :https://identity.autocrib.net/connect/token
[01/14/25 18:52:24.098]:IDtoAutocrib ST:        IDtoAutocrib: Http Method : POST
[01/14/25 18:52:24.098]:IDtoAutocrib ST:        IDtoAutocrib: Sending http request with below headers :-
[01/14/25 18:52:24.099]:IDtoAutocrib ST:        IDtoAutocrib: Authorization: <content suppressed>
[01/14/25 18:52:24.099]:IDtoAutocrib ST:        IDtoAutocrib: Content-type: application/x-www-form-urlencoded
[01/14/25 18:52:24.099]:IDtoAutocrib ST:        IDtoAutocrib: Sending http request with Authorization Query Options :-
[01/14/25 18:52:24.099]:IDtoAutocrib ST:        IDtoAutocrib: grant_type : client_credentials
[01/14/25 18:52:24.099]:IDtoAutocrib ST:        IDtoAutocrib: ***************************END**************************
[01/14/25 18:52:24.328]:IDtoAutocrib ST:        IDtoAutocrib: ********************************************************
[01/14/25 18:52:24.328]:IDtoAutocrib ST:        IDtoAutocrib: ***********************LOGGING RESPONSE*****************
[01/14/25 18:52:24.329]:IDtoAutocrib ST:        IDtoAutocrib: ********************************************************
[01/14/25 18:52:24.329]:IDtoAutocrib ST:        IDtoAutocrib: Http response code : 200
[01/14/25 18:52:24.329]:IDtoAutocrib ST:        IDtoAutocrib: Http response status : HTTP/1.1 200 OK
[01/14/25 18:52:24.329]:IDtoAutocrib ST:        IDtoAutocrib: Getting http response with below headers :-
[01/14/25 18:52:24.330]:IDtoAutocrib ST:        IDtoAutocrib: Date: Wed, 15 Jan 2025 00:52:24 GMT
[01/14/25 18:52:24.330]:IDtoAutocrib ST:        IDtoAutocrib: Content-Type: application/json; charset=UTF-8
[01/14/25 18:52:24.330]:IDtoAutocrib ST:        IDtoAutocrib: Transfer-Encoding: chunked
[01/14/25 18:52:24.330]:IDtoAutocrib ST:        IDtoAutocrib: Connection: keep-alive
[01/14/25 18:52:24.330]:IDtoAutocrib ST:        IDtoAutocrib: Cache-Control: no-store, no-cache, max-age=0
[01/14/25 18:52:24.331]:IDtoAutocrib ST:        IDtoAutocrib: pragma: no-cache
[01/14/25 18:52:24.331]:IDtoAutocrib ST:        IDtoAutocrib: strict-transport-security: max-age=15552000; includeSubDomains
[01/14/25 18:52:24.331]:IDtoAutocrib ST:        IDtoAutocrib: referrer-policy: no-referrer
[01/14/25 18:52:24.331]:IDtoAutocrib ST:        IDtoAutocrib: CF-Cache-Status: DYNAMIC
[01/14/25 18:52:24.331]:IDtoAutocrib ST:        IDtoAutocrib: X-Content-Type-Options: nosniff
[01/14/25 18:52:24.332]:IDtoAutocrib ST:        IDtoAutocrib: Cache-Control: no-cache, no-store
[01/14/25 18:52:24.332]:IDtoAutocrib ST:        IDtoAutocrib: Permissions-Policy: geolocation=()
:
[01/14/25 18:52:24.331]:IDtoAutocrib ST:        IDtoAutocrib: X-Content-Type-Options: nosniff
[01/14/25 18:52:24.332]:IDtoAutocrib ST:        IDtoAutocrib: Cache-Control: no-cache, no-store
[01/14/25 18:52:24.332]:IDtoAutocrib ST:        IDtoAutocrib: Permissions-Policy: geolocation=()
[01/14/25 18:52:24.332]:IDtoAutocrib ST:        IDtoAutocrib: Referrer-Policy: no-referrer
[01/14/25 18:52:24.332]:IDtoAutocrib ST:        IDtoAutocrib: X-Frame-Options: ALLOW-FROM https://www4.autocrib.net
[01/14/25 18:52:24.333]:IDtoAutocrib ST:        IDtoAutocrib: Server: cloudflare
[01/14/25 18:52:24.333]:IDtoAutocrib ST:        IDtoAutocrib: CF-RAY: 9021e202d878c872-DFW
[01/14/25 18:52:24.333]:IDtoAutocrib ST:        IDtoAutocrib: alt-svc: h3=":443"; ma=86400
[01/14/25 18:52:24.333]:IDtoAutocrib ST:        IDtoAutocrib: Sending http response with body :-
[01/14/25 18:52:24.333]:IDtoAutocrib ST:        IDtoAutocrib: **********************END*****************************

It succeeded to log in again, then went on to proceed during the query!! Cool eh?? I sure am glad to see this:

[01/14/25 18:52:24.334]:IDtoAutocrib ST:        IDtoAutocrib: Did a HTTP GET again with 0 bytes of data to https://api.autocrib.net/v1/Employee/102913
[01/14/25 18:52:24.334]:IDtoAutocrib ST:        IDtoAutocrib: *******************************************************
[01/14/25 18:52:24.334]:IDtoAutocrib ST:        IDtoAutocrib: **********************LOGGING REQUEST******************
[01/14/25 18:52:24.335]:IDtoAutocrib ST:        IDtoAutocrib: *******************************************************
[01/14/25 18:52:24.335]:IDtoAutocrib ST:        IDtoAutocrib: Request URL :https://api.autocrib.net/v1/Employee/102913
[01/14/25 18:52:24.335]:IDtoAutocrib ST:        IDtoAutocrib: Http Method : GET
[01/14/25 18:52:24.335]:IDtoAutocrib ST:        IDtoAutocrib: Sending http request with below headers :-
[01/14/25 18:52:24.336]:IDtoAutocrib ST:        IDtoAutocrib: Authorization: <content suppressed>
[01/14/25 18:52:24.336]:IDtoAutocrib ST:        IDtoAutocrib: dbid: 10636
[01/14/25 18:52:24.336]:IDtoAutocrib ST:        IDtoAutocrib: Content-Type: application/json
[01/14/25 18:52:24.336]:IDtoAutocrib ST:        IDtoAutocrib: Sending http request with Authorization Query Options :-
[01/14/25 18:52:24.336]:IDtoAutocrib ST:        IDtoAutocrib: grant_type : client_credentials
[01/14/25 18:52:24.337]:IDtoAutocrib ST:        IDtoAutocrib: ***************************END**************************
[01/14/25 18:52:24.412]:IDtoAutocrib ST:        IDtoAutocrib: ********************************************************
[01/14/25 18:52:24.412]:IDtoAutocrib ST:        IDtoAutocrib: ***********************LOGGING RESPONSE*****************
[01/14/25 18:52:24.412]:IDtoAutocrib ST:        IDtoAutocrib: ********************************************************
[01/14/25 18:52:24.413]:IDtoAutocrib ST:        IDtoAutocrib: Http response code : 200
[01/14/25 18:52:24.413]:IDtoAutocrib ST:        IDtoAutocrib: Http response status : HTTP/1.1 200 OK
[01/14/25 18:52:24.413]:IDtoAutocrib ST:        IDtoAutocrib: Getting http response with below headers :-
[01/14/25 18:52:24.413]:IDtoAutocrib ST:        IDtoAutocrib: Date: Wed, 15 Jan 2025 00:52:24 GMT
[01/14/25 18:52:24.413]:IDtoAutocrib ST:        IDtoAutocrib: Content-Type: application/json; charset=utf-8
[01/14/25 18:52:24.414]:IDtoAutocrib ST:        IDtoAutocrib: Transfer-Encoding: chunked
[01/14/25 18:52:24.414]:IDtoAutocrib ST:        IDtoAutocrib: Connection: keep-alive
[01/14/25 18:52:24.414]:IDtoAutocrib ST:        IDtoAutocrib: Cache-Control: no-cache, no-store, must-revalidate
[01/14/25 18:52:24.414]:IDtoAutocrib ST:        IDtoAutocrib: pragma: no-cache
[01/14/25 18:52:24.415]:IDtoAutocrib ST:        IDtoAutocrib: expires: 0
[01/14/25 18:52:24.415]:IDtoAutocrib ST:        IDtoAutocrib: vary: Accept-Encoding
[01/14/25 18:52:24.415]:IDtoAutocrib ST:        IDtoAutocrib: strict-transport-security: max-age=15552000; includeSubDomains
[01/14/25 18:52:24.415]:IDtoAutocrib ST:        IDtoAutocrib: x-frame-options: SAMEORIGIN
[01/14/25 18:52:24.415]:IDtoAutocrib ST:        IDtoAutocrib: permissions-policy: camera=(),microphone=()
[01/14/25 18:52:24.416]:IDtoAutocrib ST:        IDtoAutocrib: content-security-policy: default-src 'self'; img-src 'self'; script-src 'self' 'unsafe-inline'; style-src 'self' 'unsafe-inline'
[01/14/25 18:52:24.416]:IDtoAutocrib ST:        IDtoAutocrib: x-content-type-options: nosniff
[01/14/25 18:52:24.416]:IDtoAutocrib ST:        IDtoAutocrib: message: Employee '102913' returned successfully.
[01/14/25 18:52:24.416]:IDtoAutocrib ST:        IDtoAutocrib: api-supported-versions: 1.0
[01/14/25 18:52:24.417]:IDtoAutocrib ST:        IDtoAutocrib: x-powered-by: ASP.NET
[01/14/25 18:52:24.417]:IDtoAutocrib ST:        IDtoAutocrib: CF-Cache-Status: DYNAMIC
