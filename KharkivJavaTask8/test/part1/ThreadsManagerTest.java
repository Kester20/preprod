package part1;

import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void startThreadsAddToGlobalList() throws Exception {
        threadsManager.startThreads();
        assertEquals(numberOfPrimes, PrimesStorage.getList().size());
    }

    @Test
    public void startThreadsAddToOwnList() throws Exception {
        threadsManager.setAddPrimesToGlobalList(false);
        threadsManager.startThreads();
        assertEquals(numberOfPrimes, threadsManager.getListPrimes().size());
    }

    @Test
    public void startThreadsWithExecutor() throws Exception {
        threadsManager.startThreadsWithExecutor();
        assertEquals(numberOfPrimes, PrimesStorage.getList().size());
    }

}