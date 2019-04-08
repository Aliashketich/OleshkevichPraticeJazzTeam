package requestExamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static util.httpUtils.getJSONObjectFromResponseContext;

class GETRequestExample {
    private static final String URL = "https://jsonplaceholder.typicode.com/albums?id=";

    static String getStringFromGETRequest(int id, String elementName) {
        BufferedReader reader;
        String line;
        StringBuilder responseContext = new StringBuilder();
        try {
            URL url = new URL(URL + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //Request setUp
            connection.setRequestMethod("GET");

            int status = connection.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContext.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContext.append(line);
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getJSONObjectFromResponseContext(responseContext).getString(elementName);
    }
}
