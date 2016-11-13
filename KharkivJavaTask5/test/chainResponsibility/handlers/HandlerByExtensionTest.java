package chainResponsibility.handlers;

import chainResponsibility.directory.Directory;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 */
public class HandlerByExtensionTest {

    private HandlerByExtension handlerByFormat;
    private static final String path = "D:\\KharkivJavaTask5";
    private static final String EXTENSION = "txt";

    @Before
    public void initial(){
        handlerByFormat = new HandlerByExtension(EXTENSION);
    }

    @Test
    public void handleRequest() throws Exception {
        Directory directory = new Directory();
        directory.fill(path);
        System.out.println(handlerByFormat.handleRequest(directory.getResultList()));
    }

}