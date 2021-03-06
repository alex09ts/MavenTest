import classHolders.ClassListHolder;
import org.junit.Before;
import org.junit.Test;
import utils.ClassFinder;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class ClassListHolderTest {

    private List<String> testList;
    private List<Class> testClassList;
    private ClassListHolder classListHolder;
    private Map<String,Object> testMap;

    @Before
    public void testGetClassFinderList_Package_RequestHandlers(){
        testList = new ClassFinder().getPackageClassess("requestHandlers");
    }

    @Test
    public void testParseClassList_FirstElementMustBe_Class() throws Exception {
        ClassListHolder classListHolder = new ClassListHolder(testList);
        List<Class> testClassList = classListHolder.parseClassList();
        assertEquals("List must be nut null" , false ,testClassList.isEmpty());
        assertEquals("First element of list must be class requestHandlers.GetRequestHandler" , true , testClassList.contains(Class.forName("requestHandlers.GetRequestHandler")));
    }



    @Before
    public void testGetClassFinder_PackageRequestHandlers(){
        testList = new ClassFinder().getPackageClassess("requestHandlers");
        classListHolder = new ClassListHolder(testList);
        testClassList = classListHolder.parseClassList();
    }
    @Test
    public void testGoSingletoneMap_IsPostHandlerInMap() throws Exception {

        testMap =  classListHolder.goSingletoneMap();
        assertEquals("Map must be not null" , false ,testMap.isEmpty());
        assertEquals("Map must contain PostRequestHandler", true, testMap.containsKey("requestHandlers.PostRequestHandler"));
    }

}