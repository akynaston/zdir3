<%@ page import="java.util.Map,java.util.Iterator,java.util.Set,java.util.ArrayList,java.util.HashMap,org.json.JSONArray,org.json.JSONObject,java.util.Objects,java.util.Enumeration,java.io.*,java.net.*,javax.net.ssl.*,java.lang.StringBuilder,javax.net.ssl.*,java.security.cert.X509Certificate,java.net.URL" %>
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
        out.println("done with authetnication . .");

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer responseContent = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                responseContent.append(inputLine);
            }
            in.close();
            
            // now, do the call for the data file:
            
            response.setContentType("application/json");
            out.println(responseContent.toString());
            out.println();
            
            String token = connection.getHeaderField("apptio-opentoken");
            
            out.println("{ \"apptio-opentoken\": \"" + token + "\" }");
            //out.println("other request items: " + connection.getHeaderFields());
            out.println("done with auth . . now doing main read . .");
            
            connection.disconnect();

            
            url = new URL("https://frontdoor.apptio.com/api/v2/environmentusers/environment/5b1b8db8-86aa-4eb5-a817-65d5cc00fa82?pageSize=5");    
            
            connection = (HttpsURLConnection) url.openConnection();
            connection.setSSLSocketFactory(sslContext.getSocketFactory());
            connection.setHostnameVerifier(allHostsValid);

            connection.setRequestMethod("GET");
            //connection.setRequestProperty("Accept", "application/json");
            //connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("apptio-opentoken", token);

            //connection.setDoOutput(true);
            //osw = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");    
            //osw.write(body);
            //osw.flush();
            //osw.close();       

            responseCode = connection.getResponseCode();
            out.println("done with main read, code:  " + responseCode);
                        
            String results = "NO RESULTS STORED";

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));                
                responseContent = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseContent.append(inputLine);
                }
                results = responseContent.toString();
            }
            
            //out.println("Main data results:START[" + results + "]END");
            
            JSONObject resultsJson = new JSONObject(results);
            
           
            //out.println("Main data results AS json :START[" + resultsJson.length() + "]END");
            
            JSONObject userDataBlock = resultsJson.getJSONObject("data");
            JSONArray userObjects = (JSONArray) userDataBlock.getJSONArray("objects");
            
            //out.println("cool :START[" + userObjects + "]END");
            
           HashMap rolesHashMap = new HashMap();

           //out.println("[{");

           for (int userCtr = 0; userCtr < userObjects.length(); userCtr++) {
                JSONObject userEntry = userObjects.getJSONObject(userCtr);
                String email = userEntry.getString("email").toString();
                JSONArray userDefaultRolesArray = userEntry.getJSONArray("defaultRoles");
                
                //out.println("{");
                //out.println("\"user\": \"" + email + "\",");
                                
                //StringBuilder usersAllRolesString = new StringBuilder();
                ArrayList usersWithRole = new ArrayList();
                for (int roleCtr = 0; roleCtr < userDefaultRolesArray.length(); roleCtr++) {
                    String roleName = userDefaultRolesArray.getJSONObject(roleCtr).getString("name");
                    usersWithRole = (ArrayList)rolesHashMap.getOrDefault(roleName, new ArrayList());
                    usersWithRole.add(email);
                    rolesHashMap.put(roleName, usersWithRole);
                    //usersAllRolesString.append(userDefaultRolesArray.getJSONObject(roleCtr).getString("name"));
                    //out.println("\"role" + roleCtr + "\": \"" + userDefaultRolesArray.getJSONObject(roleCtr).getString("name") + "\",");
                }
                //out.println("},");
                
                
            }
           //out.println("}]");
            
            out.println("<BR/><BR/>hashmap: " + rolesHashMap + "");
            
            // now that we have all the data, produce a JSON output with our 'groups' data!
            
            out.println("<BR/><BR/><BR/>");
            
            
            // Now print out final results.
            
            out.println("<pre>{");                         
            Iterator itRoles = rolesHashMap.entrySet().iterator();
            while (itRoles.hasNext()) {
                Map.Entry pair = (Map.Entry) itRoles.next();
                out.println("{ \"role\": \"" + pair.getKey() + "\",");
                out.println("{ \"members\": [");
                
                Iterator itUsers = (Iterator) ((ArrayList)pair.getValue()).iterator();
                while (itUsers.hasNext()) {
                    out.println("     { \"user\": \"" + itUsers.next() + "\" }");
                }
                
                
            }
    
            //out.println("}");
            
            out.println("}</pre>");
        
            
                        
            
            

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
