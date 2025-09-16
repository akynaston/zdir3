6/2/2025 11:29:06 AM
This lets you parse an XML in postman, and get the values you need from the response XML!!

var responseBodyXML = pm.response.text();
// from: https://community.postman.com/t/occational-warning-that-xml2json-is-deptrecated/59745
var parseString = require('xml2js').parseString;
var stripNS = require('xml2js').processors.stripPrefix;
var resultXML

parseString(responseBodyXML, {
    ignoreAttrs: true, // seems to produce a cleaner JSON
    explicitArray: false, // avoids extra arrays in the result.
    tagNameProcessors: [stripNS] // drops the SOAP prefixes
}, function (err, result) {
    resultXML = result;
    console.log(result);
});

var sessionId = resultXML.Envelope.Body.loginResponse.result.sessionId;
var urlToUse = resultXML.Envelope.Body.loginResponse.result.serverUrl;
var passwordExpired = resultXML.Envelope.Body.loginResponse.result.passwordExpired;

console.log("done parsing, checking expiration");


if (passwordExpired === "true") {
    throw new Error("EmployeeSvc password has expired! Update Jeff Wilton, and he can change it.");
} else {
    console.log("Password was not expired, continuing . .")
    pm.collectionVariables.set("empdev-sessionid", sessionId);
    pm.collectionVariables.set("empdev-url", urlToUse);
    pm.collectionVariables.set("passwordExpired", passwordExpired);

    console.log("sessionid: " + sessionId);
    console.log("urlToUse: " + urlToUse);
    console.log("passwordExpired: " + passwordExpired);

    pm.collectionVariables.set("empsesid", sessionId);
    pm.collectionVariables.set("empurl", urlToUse);    
}
