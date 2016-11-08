package wrapper;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 */
public class FireReaderWrapperTest {

    private FireReaderWrapper fireReaderWrapper;

    @Before
    public void initial(){
        fireReaderWrapper = new FireReaderWrapper("example");
    }

    @Test
    public void testReadFile() throws IOException {
        fireReaderWrapper.readFile();
    }

}