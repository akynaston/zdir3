<%@ page import="java.util.Enumeration" %>
<html>
<head>
    <title>JSP Request Headers</title>

<script>
    
    function authenticateToApptio() {
        var body = "
            {
                "keyAccess": "830aa07b-a859-4f8d-afb3-3a3f00e711ae",
                "keySecret": "dlqucIvhGCWwW4W9hq8SCf2xA1OE0R7yfN2yhjtJGPtgFZXzoDfHfDJAeHJ9"
            }
        ";
        //var username = "your_username"; // Replace with actual username
        //var password = "your_password"; // Replace with actual password
        //var targetUrl = "C:\z\testJSP.html"; // Replace with your target URL

        // Encode username:password to Base64
        //var credentials = btoa(username + ":" + password);

        var xhr = new XMLHttpRequest();
        xhr.open("GET", targetUrl, true);
        //xhr.setRequestHeader("Authorization", "Basic " + credentials);
        xhr.setRequestHeader("apptio-opentoken", "Hey get the value here");
        xhr.setRequestHeader("apptio-current-environment", "d675e95f-b4af-56b8-6ea6-e9ed5041eab3");

        xhr.onload = function() {
            if (xhr.status === 200) {
                document.getElementById("responseDiv").innerHTML = "Request successful: " + xhr.responseText;
            } else {
                document.getElementById("responseDiv").innerHTML = "Request failed: " + xhr.status + " " + xhr.statusText;
            }
        };
        xhr.onerror = function() {
            document.getElementById("responseDiv").innerHTML = "Network error occurred.";
        };

        xhr.send();
    }


</script>
</head>
<body>
    <h2>All Request Headers V1</h2>
    <table border="1">
        <tr>
            <th>Header Name</th>
            <th>Header Value(s)</th>
        </tr>
        <%
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
        %>
        <tr>
            <td><%= headerName %></td>
            <td>
                <%
                    Enumeration<String> headerValues = request.getHeaders(headerName);
                    while (headerValues.hasMoreElements()) {
                        out.println(headerValues.nextElement() + "<br>");
                    }
                %>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    
    calling . .1
    
    <%
    //authenticateToApptio();
    hi();
  %>
    
    start response:
    <div id="responseDiv"></div>
    <div id="responseDiv2"></div>
    : end response . .


    
</body>
</html>