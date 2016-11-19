package part1;

import utility.Checker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arsalan
 */
public class FindPrimesThread implements Runnable {

	private List<Integer> list;
	private boolean addPrimesToGlobalList;
	private int from;
	private int step;
	private int to;

	public FindPrimesThread(int from, int to, int step, boolean addToOwnList) {
		this.addPrimesToGlobalList = addToOwnList;
		this.list = new ArrayList<>();
		this.from = from;
		this.to = to;
		this.step = step;
	}

	@Override
	public void run() {
		check();
	}

	private void check() {
		for (int i = from; i < to; i += step) {
			if (Checker.isPrime(i)) {
				if (addPrimesToGlobalList) {
					synchronized (PrimesStorage.getList()) {
						PrimesStorage.getList().add(i);
					}
				} else {
					list.add(i);
				}
			}
		}
	}

	public List<Integer> getList() {
		return list;
	}
}
