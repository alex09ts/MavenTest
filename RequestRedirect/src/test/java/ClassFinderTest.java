import org.junit.Test;
import utils.ClassFinder;

import java.util.List;

import static org.junit.Assert.*;

public class ClassFinderTest {
    @Test
    public void getPackageClassessTest_Package_RequestHandlers_GetHandler() throws Exception {
        ClassFinder classFinder = new ClassFinder();
        List<String> testList  = classFinder.getPackageClassess("requestHandlers");
        assertEquals("First element must be GetRequestHandler", true , testList.contains("requestHandlers.GetRequestHandler"));
    }

    @Test
    public void getPackageClassessTest_Package_RequestHandlers_PostHandler() throws Exception {
        ClassFinder classFinder = new ClassFinder();
        List<String> testList  = classFinder.getPackageClassess("requestHandlers");
        assertEquals("First element must be GetRequestHandler", true , testList.contains("requestHandlers.PostRequestHandler"));
    }

    @Test
    public void getPackageClassessTest_Package_RequestHandlers_UselessHandler() throws Exception {
        ClassFinder classFinder = new ClassFinder();
        List<String> testList  = classFinder.getPackageClassess("requestHandlers");
        assertEquals("First element must be GetRequestHandler", true , testList.contains("requestHandlers.UselessRequestHandler"));
    }

    @Test
    public void getPackageClassessTest_Package_Random_FirstElementMustBeNull() throws Exception {
        ClassFinder classFinder = new ClassFinder();
        List<String> testList  = classFinder.getPackageClassess("Random");
        assertEquals("First element must be null", true , testList.isEmpty());
    }
}