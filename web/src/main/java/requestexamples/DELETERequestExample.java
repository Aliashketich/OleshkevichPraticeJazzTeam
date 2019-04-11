package requestexamples;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DELETERequestExample {
    private static final String URL = "https://jsonplaceholder.typicode.com/posts/1";

    static int executeDELETERequest() throws IOException {
        URL url = new URL(URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestMethod("DELETE");
        httpURLConnection.connect();
        return httpURLConnection.getResponseCode();
    }
}
