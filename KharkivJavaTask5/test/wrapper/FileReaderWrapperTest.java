package wrapper;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 */
public class FileReaderWrapperTest {

    private FileReaderWrapper fileReaderWrapper;

    @Before
    public void initial(){
        fileReaderWrapper = new FileReaderWrapper("example");
    }

    @Test
    public void testReadFile() throws IOException {
        fileReaderWrapper.readFile();
    }

}