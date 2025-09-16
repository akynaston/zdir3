<%@ page import="java.util.Objects,java.util.Enumeration,java.io.*,java.net.*, java.lang.StringBuilder" %>

<html>
<head>
    <title>JSP Request Headers</title>

<script>
    
    function authenticateToApptio() {
        var body = "{ \"keyAccess\": \"830aa07b-a859-4f8d-afb3-3a3f00e711ae\", \"keySecret\": \"dlqucIvhGCWwW4W9hq8SCf2xA1OE0R7yfN2yhjtJGPtgFZXzoDfHfDJAeHJ9\"   }";
        var targetURLApptioHeader = "https://frontdoor.apptio.com/service/apikeylogin";
        
        var targetUrl = "http://localhost:8080/callmetest/authtoapptio.jsp"; // Replace with your target URL

        // Encode username:password to Base64
        //var credentials = btoa(username + ":" + password);

        var xhr = new XMLHttpRequest();
        xhr.open("POST", targetUrl, true);
        //xhr.setRequestHeader("Authorization", "Basic " + credentials);
        //xhr.setRequestHeader("apptio-opentoken", "Hey get the value here");
        //xhr.setRequestHeader("apptio-current-environment", "d675e95f-b4af-56b8-6ea6-e9ed5041eab3");
        // unsafe header . . .? - xhr.setRequestHeader("Host", "frontdoor.apptio.com");
        xhr.setRequestHeader("Accept", "application/json");
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.setRequestHeader("apptio-authentication-url", targetURLApptioHeader);
        

        xhr.onload = function() {
            
            //document.getElementById("responseDiv").innerHTML = "Request headers: can't get . .";
            
            if (xhr.status === 200) {
                document.getElementById("responseDiv2").innerHTML = "Request successful: " + xhr.status + " " + xhr.statusText + " response:" + xhr.responseText + "all tokens: #" + xhr.getAllResponseHeaders() + "# token: " + xhr.getResponseHeader("apptio-opentoken");
            } else {
                document.getElementById("responseDiv2").innerHTML = "Request failed: " + xhr.status + " " + xhr.statusText + " response:" + xhr.responseText;
            }
        };
        xhr.onerror = function() {
            document.getElementById("responseDiv2").innerHTML = "Network error occurred.";
        };

        xhr.send(body);
    }


</script>
</head>
<body>
    <h2>Ready to call 1</h2>
    
    making a request . .
    <script>authenticateToApptio()</script>
    
    
          <h1>Java Version Details</h1>
        <p>Java Version: <%= System.getProperty("java.version") %></p>
        <p>Java VM Version: <%= System.getProperty("java.vm.version") %></p>
    
    
    <div id="responseDiv"></div>
    <div id="responseDiv2"></div>

    
</body>
</html>