package part1;

import part1.utility.Checker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arsalan
 */
public class MyThread extends Thread{

	private List<Long> list;
	private long from;
	private long to;

	public MyThread(long from, long to) {
		list = new ArrayList<>();
		this.from = from;
		this.to = to;
	}

	@Override
	public void run() {
		for (long i = from; i < to; i++) {
			if (Checker.isPrime(i)) {
				list.add(i);
			}
		}
	}

	public List<Long> getList() {
		return list;
	}

	public long getFrom() {
		return from;
	}

	public long getTo() {
		return to;
	}

	public void setFrom(long from) {
		this.from = from;
	}

	public void setTo(long to) {
		this.to = to;
	}
}
