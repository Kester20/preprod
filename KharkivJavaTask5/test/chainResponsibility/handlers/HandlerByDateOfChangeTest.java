package chainResponsibility.handlers;

import chainResponsibility.directory.Directory;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 */
public class HandlerByDateOfChangeTest {

    private HandlerByDateOfChange handlerByDateOfChange;
    private static final String path = "D:\\KharkivJavaTask5";

    @Before
    public void initial() throws ParseException {
        Date firstDate = new SimpleDateFormat("dd/MM/yyyy").parse("07/11/2016");
        Date secondDate = new SimpleDateFormat("dd/MM/yyyy").parse("09/11/2016");
        handlerByDateOfChange = new HandlerByDateOfChange(firstDate.getTime(), secondDate.getTime());
    }

    @Test
    public void testHandleRequest(){
        Directory directory = new Directory();
        directory.fill(path);
        System.out.println(handlerByDateOfChange.handleRequest(directory.getResultList()));
    }

}