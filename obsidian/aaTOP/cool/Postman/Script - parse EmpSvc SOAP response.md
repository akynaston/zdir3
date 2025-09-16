var responseBodyXML = pm.response.text();
// from: https://community.postman.com/t/occational-warning-that-xml2json-is-deptrecated/59745
var parseString = require('xml2js').parseString;
var stripNS = require('xml2js').processors.stripPrefix;
var resultJSON

parseString(responseBodyXML, {
    ignoreAttrs: true, // seems to produce a cleaner JSON
    explicitArray: false, // avoids extra arrays in the result.
    tagNameProcessors: [stripNS] // drops the SOAP prefixes
}, function (err, result) {
    resultJSON = result;
    console.log(result);
});

var sessionId = resultJSON.Envelope.Body.loginResponse.result.sessionId;
var urlToUse = resultJSON.Envelope.Body.loginResponse.result.serverUrl;
var passwordExpired = resultJSON.Envelope.Body.loginResponse.result.passwordExpired;

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
}

