package testGenerator;


import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TestGenereator {


    public String generateGetTest(String url) {
        try {
            StringBuilder result = new StringBuilder();
            String line;

            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);

            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String generatePostTest(String url) {
        try {
            StringBuilder result = new StringBuilder();
            String line;
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(url);

            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}