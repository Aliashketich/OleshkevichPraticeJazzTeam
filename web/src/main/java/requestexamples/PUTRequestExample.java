package requestexamples;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class PUTRequestExample {
    private static final String URL = "https://jsonplaceholder.typicode.com/posts/1";

    static int executePUTRequest() throws IOException {
        URL url = new URL(URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("PUT");
        OutputStreamWriter out = new OutputStreamWriter(httpURLConnection.getOutputStream());
        out.write("Resource content");
        out.close();
        httpURLConnection.getInputStream();
        return httpURLConnection.getResponseCode();
    }
}

