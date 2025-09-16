import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Class attempts to call apptioauth jsp, from a jre with no cacerts, to reproduce SSL issue
 */
public class ApptioCallMissingCertTest {

  public static void main(String[] args) throws Exception {

    String targetUrl = "https://frontdoor.apptio.com/service/apikeylogin"; // Replace with your target URL
    String body = "{ \"keyAccess\": \"830aa07b-a859-4f8d-afb3-3a3f00e711ae\", \"keySecret\": \"dlqucIvhGCWwW4W9hq8SCf2xA1OE0R7yfN2yhjtJGPtgFZXzoDfHfDJAeHJ9\"   }";

    String urlString = targetUrl;
    URL url = new URL(urlString);

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    connection.setRequestMethod("POST");
    connection.setRequestProperty("Accept", "application/json");
    connection.setRequestProperty("Content-Type", "application/json");
    connection.setRequestProperty("apptio-authentication-url", targetUrl);
    connection.setRequestProperty("apptio-body", body);

    connection.setDoOutput(true);
    OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
    osw.write(body);
    osw.flush();
    osw.close();

    connection.setConnectTimeout(90000);
    connection.setReadTimeout(90000);

    int responseCode = connection.getResponseCode();

    if (responseCode == HttpsURLConnection.HTTP_OK) {
      // Read the response
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      StringBuffer responseContent = new StringBuffer();
      while ((inputLine = in.readLine()) != null) {
        responseContent.append(inputLine);
      }
      in.close();

      System.out.println("response: [" + responseContent + "]");

    } else {
      throw new Exception("{\"error\": \"Failed to authenticate to Apptio:\", \"statusCode\": " + responseCode + "}");
    }

    connection.disconnect();
  }

}
