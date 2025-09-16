5/6/2025 10:43:48 AM
Example reauthenticatoin:
```[04/30/25 11:43:26.825]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: RESTSubscriptionShim.execute() :
[04/30/25 11:43:26.826]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: addHandler
[04/30/25 11:43:26.826]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: addHandler: class-name == 'PICUSER'
[04/30/25 11:43:26.827]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Add: preparing POST to https://swa--fc3swa.sandbox.my.salesforce.com/services/data/v44.0/sobjects/ContentVersion
[04/30/25 11:43:26.828]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Resetting headers
[04/30/25 11:43:26.829]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Setting the following HTTP request properties:
 Authorization: <content suppressed>
[04/30/25 11:43:26.830]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture:  Content-Type:application/json
[04/30/25 11:43:26.831]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Trying to use existing token
[04/30/25 11:43:26.832]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Did a HTTP POST with 4709 bytes of data to https://swa--fc3swa.sandbox.my.salesforce.com/services/data/v44.0/sobjects/ContentVersion
[04/30/25 11:43:26.833]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: *******************************************************
[04/30/25 11:43:26.834]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: **********************LOGGING REQUEST******************
[04/30/25 11:43:26.835]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: *******************************************************
[04/30/25 11:43:26.836]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Request URL :https://swa--fc3swa.sandbox.my.salesforce.com/services/data/v44.0/sobjects/ContentVersion
[04/30/25 11:43:26.837]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Http Method : POST
[04/30/25 11:43:26.838]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Sending http request with below headers :-
[04/30/25 11:43:26.838]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Authorization: <content suppressed>
[04/30/25 11:43:26.839]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Content-Type: application/json
[04/30/25 11:43:26.840]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: ***************************END**************************
[04/30/25 11:43:26.882]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: ********************************************************
[04/30/25 11:43:26.883]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: ***********************LOGGING RESPONSE*****************
[04/30/25 11:43:26.884]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: ********************************************************
[04/30/25 11:43:26.885]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Http response code : 401
[04/30/25 11:43:26.886]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Http response status : HTTP/1.1 401 Unauthorized
[04/30/25 11:43:26.887]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Getting http response with below headers :-
[04/30/25 11:43:26.888]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Date: Wed, 30 Apr 2025 16:43:26 GMT
[04/30/25 11:43:26.889]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: X-Content-Type-Options: nosniff
[04/30/25 11:43:26.890]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Strict-Transport-Security: max-age=63072000; includeSubDomains
[04/30/25 11:43:26.891]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: X-Robots-Tag: none
[04/30/25 11:43:26.891]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Cache-Control: no-cache,must-revalidate,max-age=0,no-store,private
[04/30/25 11:43:26.892]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: WWW-Authenticate: Token
[04/30/25 11:43:26.893]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Content-Type: application/json;charset=UTF-8
[04/30/25 11:43:26.894]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Transfer-Encoding: chunked
[04/30/25 11:43:26.895]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Sending http response with body :-
[04/30/25 11:43:26.896]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: **********************END*****************************
[04/30/25 11:43:26.898]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Access Token expired, Getting new Access token using Refresh token
[04/30/25 11:43:26.899]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Refresh Token or Client Secret not Availble
[04/30/25 11:43:26.900]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Generating New Bearer Token
[04/30/25 11:43:26.901]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Connecting to REST service via OAuth2
[04/30/25 11:43:26.902]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: key = application/x-www-form-urlencoded
[04/30/25 11:43:26.904]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Sending HTTP Request
[04/30/25 11:43:26.905]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: *******************************************************
[04/30/25 11:43:26.906]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: **********************LOGGING REQUEST******************
[04/30/25 11:43:26.907]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: *******************************************************
[04/30/25 11:43:26.908]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Request URL :https://test.salesforce.com/services/oauth2/token
[04/30/25 11:43:26.910]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Http Method : POST
[04/30/25 11:43:26.911]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Sending http request with below headers :-
[04/30/25 11:43:26.912]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Authorization: <content suppressed>
[04/30/25 11:43:26.913]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Content-Type: application/x-www-form-urlencoded
[04/30/25 11:43:26.914]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Sending http request with Authorization Query Options :-
[04/30/25 11:43:26.915]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: password : <content suppressed>
[04/30/25 11:43:26.917]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: grant_type : password
[04/30/25 11:43:26.918]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: client_secret : <content suppressed>
[04/30/25 11:43:26.919]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: issuer : https://test.salesforce.com
[04/30/25 11:43:26.920]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: client_id : <content suppressed>
[04/30/25 11:43:26.921]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: username : idmsysuser@wnco.com.empdev1
[04/30/25 11:43:26.922]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: ***************************END**************************
[04/30/25 11:43:27.052]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: ********************************************************
[04/30/25 11:43:27.054]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: ***********************LOGGING RESPONSE*****************
[04/30/25 11:43:27.054]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: ********************************************************
[04/30/25 11:43:27.055]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Http response code : 200
[04/30/25 11:43:27.056]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Http response status : HTTP/1.1 200 OK
[04/30/25 11:43:27.057]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Getting http response with below headers :-
[04/30/25 11:43:27.057]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Date: Wed, 30 Apr 2025 16:43:26 GMT
[04/30/25 11:43:27.058]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: X-Content-Type-Options: nosniff
[04/30/25 11:43:27.059]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Strict-Transport-Security: max-age=63072000; includeSubDomains
[04/30/25 11:43:27.060]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Cache-Control: no-cache,must-revalidate,max-age=0,no-store,private
[04/30/25 11:43:27.060]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Expires: Thu, 01 Jan 1970 00:00:00 GMT
[04/30/25 11:43:27.061]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: X-ReadOnlyMode: false
[04/30/25 11:43:27.062]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Content-Type: application/json;charset=UTF-8
[04/30/25 11:43:27.063]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Vary: Accept-Encoding
[04/30/25 11:43:27.063]:IDtoEmployeeCarePicture ST:IDtoEmployeeCarePicture: Transfer-Encoding: chunked

```