import org.junit.Test;
import testGenerator.TestGenereator;

import static org.junit.Assert.assertEquals;


public class TestGenereatorTest {


    @Test
    public void doTests_url_GetRequest_param_getSome2() throws Exception {
        TestGenereator testGenereator = new TestGenereator();
        String value = testGenereator.generateGetTest("http://localhost:8080/RequestRedirect/GetRequest/getSome2");
        assertEquals("Path /getSome2 method GET", true, value.contains("Path getSome2 method GET"));
    }

    @Test
    public void doTests_url_GetRequest_param_getSome3() throws Exception {
        TestGenereator testGenereator = new TestGenereator();
        String value = testGenereator.generateGetTest("http://localhost:8080/RequestRedirect/GetRequest/getSome3");
        assertEquals(true, value.contains("Path getSome3 method GET"));
    }

    @Test
    public void doTests_url_PostRequest_param_getSome() throws Exception {
        TestGenereator testGenereator = new TestGenereator();
        String value = testGenereator.generatePostTest("http://localhost:8080/RequestRedirect/PostRequest/getSome");
        assertEquals("Path /getSome2 method GET", true, value.contains("Path getSome method POST"));
    }

    @Test
    public void doTests_url_PostRequest_param_getSome2() throws Exception {
        TestGenereator testGenereator = new TestGenereator();
        String value = testGenereator.generatePostTest("http://localhost:8080/RequestRedirect/PostRequest/getSome2");
        assertEquals("Path /getSome2 method GET", true, value.contains("Path getSome2 method POST"));
    }

    @Test
    public void doTests_url_google_vanka() throws Exception {
        TestGenereator testGenereator = new TestGenereator();
        String value = testGenereator.generatePostTest("http://google.vanka.com");
        assertEquals(false, value.contains("Path getSome method POST"));
    }
}