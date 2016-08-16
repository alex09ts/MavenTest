import org.junit.Test;
import testGenerator.TestGenereator;

import static org.junit.Assert.assertEquals;


public class TestGenereatorTest {


    @Test
    public void doTests_url_GetRequest_param_getSome2() throws Exception {
        TestGenereator testGenereator = new TestGenereator();
        String headerValue = testGenereator.generateGetTest("http://localhost:8080/RequestRedirect/GetRequest?param=getSome2");
        assertEquals("Executed method redirect2 from class GetRequestandler", headerValue);
    }

    @Test
    public void doTests_url_GetRequest_param_getSome3() throws Exception {
        TestGenereator testGenereator = new TestGenereator();
        String headerValue = testGenereator.generateGetTest("http://localhost:8080/RequestRedirect/GetRequest?param=getSome3");
        assertEquals("Executed method redirect3 from class GetRequestandler", headerValue);
    }

    @Test
    public void doTests_url_PostRequest_param_getSome() throws Exception {
        TestGenereator testGenereator = new TestGenereator();
        String headerValue = testGenereator.generatePostTest("http://localhost:8080/RequestRedirect/PostRequest?param=getSome");
        assertEquals("Executed method redirect from class PostRequestandler", headerValue);
    }

    @Test
    public void doTests_url_PostRequest_param_getSome2() throws Exception {
        TestGenereator testGenereator = new TestGenereator();
        String headerValue = testGenereator.generatePostTest("http://localhost:8080/RequestRedirect/PostRequest?param=getSome2");
        assertEquals("Executed method redirect2 from class PostRequestHandler", headerValue);
    }
}