package part1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arsalan
 */
public class ThreadsManager {

	private List<MyThread> listThreads;
	private List<Long> listPrimes;
	private int countThreads;
	private long from;
	private long to;

	public ThreadsManager(int countThreads, int from, int to) {
		listThreads = new ArrayList<>();
		listPrimes = new ArrayList<>();
		this.countThreads = countThreads;
		setFrom(from);
		this.to = to;
	}

	public void startThreads() throws InterruptedException {
		giveIntervals();
		for (Thread myThread: listThreads) {
			myThread.start();
		}
		for (Thread myThread: listThreads) {
			myThread.join();
		}
		fillPrimes();
	}

	public void fillPrimes(){
		for (MyThread myThread: listThreads) {
			listPrimes.addAll(myThread.getList());
		}
	}

	/**
	 * gives intervals to threads
	 */
	private void giveIntervals(){
		long range = (to - from) / countThreads;
		for (long i = from; i < to ; i++) {
			if(i % range == 0){
				listThreads.add(new MyThread(i, i + range));
			}
		}
	}

	public List<Long> getListPrimes() {
		return listPrimes;
	}

	public List<MyThread> getListThreads() {
		return listThreads;
	}

	public void setFrom(long from) {
		if(from < 2){
			from = 2;
		}
		this.from = from;
	}

	public void setTo(long to) {
		this.to = to;
	}
}
