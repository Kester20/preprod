package part1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Arsalan
 */
public class ThreadsManager {

	private List<Thread> searchers;
	private List<Integer> listPrimes;
	private List<FindPrimesThread> findPrimesThreads;
	private int countThreads;
	private int from;
	private int to;
	private boolean addPrimesToGlobalList = true;

	public ThreadsManager(int countThreads, int from, int to) {
		setFrom(from);
		this.to = to;
		searchers = new ArrayList<>();
		listPrimes = new ArrayList<>();
		findPrimesThreads = new ArrayList<>();
		this.countThreads = countThreads;
	}

	public void startThreads() throws InterruptedException {
		giveIntervals();
		for (Thread thread : searchers) {
			thread.start();
		}
		for (Thread thread : searchers) {
			thread.join();
		}
		fillPrimes();
	}

	public void startThreadsWithExecutor() throws InterruptedException {
		giveIntervals();
		ExecutorService executorService = Executors.newFixedThreadPool(countThreads);
		for (Thread thread : searchers) {
			executorService.execute(thread);
		}
		executorService.shutdown();
		executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
		fillPrimes();
	}

	private void fillPrimes() {
		for (FindPrimesThread findPrimesThread : findPrimesThreads) {
			listPrimes.addAll(findPrimesThread.getList());
		}
	}

	/**
	 * gives intervals to threads
	 */
	private void giveIntervals() {
		for (int i = 0; i < countThreads; i++) {
			FindPrimesThread findPrimesThread = new FindPrimesThread(from++, to, countThreads, addPrimesToGlobalList);
			Thread thread = new Thread(findPrimesThread);
			searchers.add(thread);
			findPrimesThreads.add(findPrimesThread);
		}
	}

	private void setFrom(int from) {
		if (from < 2) {
			from = 2;
		}
		this.from = from;
	}

	public void setAddPrimesToGlobalList(boolean addPrimesToGlobalList) {
		this.addPrimesToGlobalList = addPrimesToGlobalList;
	}

	public List<Integer> getListPrimes() {
		return listPrimes;
	}
}
