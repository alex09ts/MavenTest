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
            StringBuilder fullData = new StringBuilder();

            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);

            HttpResponse response = client.execute(request);
            Header header[] = response.getHeaders("MethodName");
            fullData.append(header[0].getValue());
            return fullData.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String generatePostTest(String url) {
        try {
            StringBuilder fullData = new StringBuilder();
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(url);

            HttpResponse response = client.execute(post);

            Header header[] = response.getHeaders("MethodName");
            fullData.append(header[0].getValue());
            return fullData.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}