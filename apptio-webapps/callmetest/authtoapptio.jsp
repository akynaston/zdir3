<%@ page import="java.util.Objects,java.util.Enumeration,java.io.*,java.net.*,javax.net.ssl.*,java.lang.StringBuilder,javax.net.ssl.*,java.security.cert.X509Certificate,java.net.URL" %>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>

<%

/*
Version 1.2
  Data to get from MyAccess:
  String body = "{ \"keyAccess\": \"830aa07b-a859-4f8d-afb3-3a3f00e711ae\", \"keySecret\": \"dlqucIvhGCWwW4W9hq8SCf2xA1OE0R7yfN2yhjtJGPtgFZXzoDfHfDJAeHJ9\"   }";
  var targetUrl = "https://frontdoor.apptio.com/service/apikeylogin"; // Replace with your target URL
*/

    try {

        // Get the passed in body, since we'll use that to authenticate:
        InputStream inputStream = request.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        // Close the reader and input stream
        reader.close();
        inputStream.close();
        String body = requestBody.toString();

        //String targetUrl = "https://frontdoor.apptio.com/service/apikeylogin"; // Replace with your target URL
        //String body = "{ \"keyAccess\": \"830aa07b-a859-4f8d-afb3-3a3f00e711ae\", \"keySecret\": \"dlqucIvhGCWwW4W9hq8SCf2xA1OE0R7yfN2yhjtJGPtgFZXzoDfHfDJAeHJ9\"   }";

        String targetUrl = request.getHeader("apptio-authentication-url");
    
		String urlString = targetUrl;
		URL url = new URL(urlString);



        //TEMPORARY WORK AROUND: IGNORE SSL COMPLETELY FOR THIS CONNECTION!
        // Create a TrustManager that trusts all certificates
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0]; // Return an empty array of trusted certificates
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    // Do nothing, trust all client certificates
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    // Do nothing, trust all server certificates
                }
            }
        };

        SSLContext sslContext = SSLContext.getInstance("TLS"); // You can use "SSL" as well, but TLS is preferred
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

        //Also accept all hostnames:
        // Create a HostnameVerifier that accepts all hostnames
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true; // Always return true, effectively disabling hostname verification
            }
        };

        // Set the default SSLSocketFactory and HostnameVerifier
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setSSLSocketFactory(sslContext.getSocketFactory());
        connection.setHostnameVerifier(allHostsValid);

		connection.setRequestMethod("POST");
		connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");

        connection.setDoOutput(true);
        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");    
        osw.write(body);
        osw.flush();
        osw.close();       

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer responseContent = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                responseContent.append(inputLine);
            }
            in.close();

            /*
                Now we're done receiving the response, responseContent contains the JSON of all users in Browser Stack.
                Lets just write out the response we got from the API as is, but replace the content type before we go, since MyAccess doesn't seem to support 'application/scim+json:
            */
            
            response.setContentType("application/json");
            out.println(responseContent.toString());
            out.println();
            out.println("{ \"apptio-opentoken\": \"" + connection.getHeaderField("apptio-opentoken") + "\" }");
            //    out.println("other request items: " + connection.getHeaderFields());
            

        } else {
            // Handle error from the external service
            response.setStatus(responseCode);
            out.println("{\"error\": \"Failed to authenticate to Apptio:\", \"statusCode\": " + responseCode + "}");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer responseContent = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                responseContent.append(inputLine);
            }
            in.close();

            out.println("all response data: " + responseContent);
        }

        connection.disconnect();

    } catch (Exception e) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        out.println("{\"error\": \"Internal server error\", \"details\": \"" + e.getMessage() + "\"}");
    }
%>
