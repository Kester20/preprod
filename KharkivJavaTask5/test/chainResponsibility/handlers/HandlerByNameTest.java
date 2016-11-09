package chainResponsibility.handlers;

import chainResponsibility.directory.Directory;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 */
public class HandlerByNameTest {

    private HandlerByName handlerByName;
    private static final String path = "D:\\KharkivJavaTask5";

    @Before
    public void initial(){
        handlerByName = new HandlerByName(true, "example");
    }

    @Test
    public void testHandleRequest(){
        Directory directory = new Directory();
        directory.fill(path);
        System.out.println(handlerByName.handleRequest(directory.getResultList()));
    }

}