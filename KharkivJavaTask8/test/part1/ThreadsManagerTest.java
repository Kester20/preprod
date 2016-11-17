package part1;

import org.junit.Before;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Arsalan
 */
public class ThreadsManagerTest {

    private ThreadsManager threadsManager;
    public static final int numberOfPrimes = 78498;

    @Before
    public void initial() {
        threadsManager = new ThreadsManager(10, 0, 1000000);
        PrimesStorage.getList().clear();
    }

    @org.junit.Test
    public void startThreads() throws Exception {
        threadsManager.startThreads();
        assertEquals(PrimesStorage.getList().size(), numberOfPrimes);
    }

    @org.junit.Test
    public void startThreadsWithExecutor() throws Exception {
        threadsManager.startThreadsWithExecutor();
        assertEquals(PrimesStorage.getList().size(), numberOfPrimes);
    }

}