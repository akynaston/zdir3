import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.X509Certificate;


//    <%@ page import="java.util.Objects,java.util.Enumeration,java.io.*,java.net.*,javax.net.ssl.*,java.lang.StringBuilder,javax.net.ssl.*,java.security.cert.X509Certificate,java.net.URL" %>
//<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>


public class HTTPCertTest {
  public static void main(String[] args)  throws Exception {
    System.out.println("SHTTPCert test: version: 1.0");

    HTTPCertTest.runTest("https://frontdoor.apptio.com/service/apikeylogin"); // Replace with your target URL
    System.out.println("===============================================================");
    HTTPCertTest.runTest("https://frontdoor.apptio.com/service/apikeylogin"); // Replace with your target URL
    System.out.println("===============================================================");
    HTTPCertTest.runTest("https://southwestairlines.apptio.com/biit/api/v2/report.json?reportPath=-@Csouthwestairlines.com%3ACost+Transparency/Reports/.DateGoesHere/CostModels/Default/.View%3ARole+List&date=Jul:FY2025&componentId=1&environment=stg&userLanguage=en-US\n"); // Replace with your target URL
    System.out.println("DONE");
  }

  public static void runTest(String targetUrl) throws Exception {

    String body = "{ \"keyAccess\": \"830aa07b-a859-4f8d-afb3-3a3f00e711ae\", \"keySecret\": \"dlqucIvhGCWwW4W9hq8SCf2xA1OE0R7yfN2yhjtJGPtgFZXzoDfHfDJAeHJ9\"   }";

    System.out.println("Starting HTTPCert test, against: [" + targetUrl + "]");
    System.out.println("###################################################################");
    System.out.println("First attempt, is allowing SSL to occur normally: ");

    URL url = null;
    try {
      url = new URL(targetUrl);
    } catch (MalformedURLException e) {
      throw new Exception("Failed while creating URL on urlString: [" + targetUrl + "]");
    }

    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

    connection.setRequestMethod("POST");
    connection.setRequestProperty("Accept", "application/json");
    connection.setRequestProperty("Content-Type", "application/json");

    connection.setDoOutput(true);
    OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
    osw.write(body);
    osw.flush();
    osw.close();

    int responseCode = connection.getResponseCode();

    // Read the response
    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String inputLine;
    StringBuffer responseContent = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
      responseContent.append(inputLine);
    }
    in.close();

    //response.setContentType("application/json");
    System.out.println("Done reading the response while SSL is left intact, ");
    System.out.println("Response code was: [" + responseCode + "]");
    System.out.println("response buffer was: [" + responseContent + "]");
    System.out.println("Apptio token if available:");
    System.out.println("{ \"apptio-opentoken\": \"" + connection.getHeaderField("apptio-opentoken") + "\" }");

    connection.disconnect();



    System.out.println("Just disconnected, now ignoring SSL, and running again: ");
    System.out.println("###################################################################");
    System.out.println("Second attempt, is ignoring SSL certs: ");

    //TEMPORARY WORK AROUND: IGNORE SSL COMPLETELY FOR THIS CONNECTION!
    // Create a TrustManager that trusts all certificates
    TrustManager[] trustAllCerts;
    trustAllCerts = new TrustManager[]{
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

    connection = (HttpsURLConnection) url.openConnection();
    connection.setSSLSocketFactory(sslContext.getSocketFactory());
    connection.setHostnameVerifier(allHostsValid);

    connection.setRequestMethod("POST");
    connection.setRequestProperty("Accept", "application/json");
    connection.setRequestProperty("Content-Type", "application/json");

    connection.setDoOutput(true);
    osw = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
    osw.write(body);
    osw.flush();
    osw.close();

    responseCode = connection.getResponseCode();

    // Read the response
    in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    responseContent = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
      responseContent.append(inputLine);
    }
    in.close();

    //response.setContentType("application/json");
    System.out.println("Done reading the response while SSL was IGNORED, ");
    System.out.println("Response code was: [" + responseCode + "]");
    System.out.println("response buffer was: [" + responseContent + "]");
    System.out.println("Apptio token if available:");
    System.out.println("{ \"apptio-opentoken\": \"" + connection.getHeaderField("apptio-opentoken") + "\" }");

    connection.disconnect();

  }


}
