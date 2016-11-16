package part1;

import org.junit.Before;

import static org.junit.Assert.*;

/**
 * @author Arsalan
 */
public class ThreadsManagerTest {

	private ThreadsManager threadsManager;

	@Before
	public void initial(){
		threadsManager = new ThreadsManager(10, 0, 30);
	}

	@org.junit.Test
	public void startThreads() throws Exception {
		threadsManager.startThreads();
		assertTrue(threadsManager.getListPrimes().size() == 10);
	}

	@org.junit.Test
	public void getPrimes() throws Exception {

	}

	@org.junit.Test
	public void getListPrimes() throws Exception {

	}

	@org.junit.Test
	public void getListThreads() throws Exception {

	}

}