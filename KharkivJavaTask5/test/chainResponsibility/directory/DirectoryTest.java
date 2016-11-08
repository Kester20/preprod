package chainResponsibility.directory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 */
public class DirectoryTest {

    private static final String path = "D:\\KharkivJavaTask5";
    private Directory directory;

    @Before
    public void initial(){
        directory = new Directory();
    }

    @Test
    public void testFill(){
        directory.fill(path);
        System.out.println(directory.getResultList());
    }
}