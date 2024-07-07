package quiz5;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommunicationManager {

    /**
     * Send a POST request to the specified URL with the given JSON data
     * @param urlString URL to send the request to
     * @param jsonData JSON data to send
     * @return Response from the server
     * @throws Exception If an error occurs while sending the request
     */
    public String sendRequest(String urlString, String jsonData) throws Exception {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Convert JSON data string into bytes
            byte[] input = jsonData.getBytes("UTF-8");

            try (OutputStream os = connection.getOutputStream()) {
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return "Success"; // Replace with actual response handling logic
            } else {
                throw new RuntimeException("Failed : HTTP error code : " + responseCode);
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}