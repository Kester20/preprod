package part1;

import utility.Checker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arsalan
 */
public class FindPrimesThread implements Runnable {

    private List<Long> list;
    private long from;
    private long to;
    private boolean addToOwnList;

    public FindPrimesThread(long from, long to, boolean addToOwnList) {
        list = new ArrayList<>();
        setFrom(from);
        this.to = to;
        this.addToOwnList = addToOwnList;
    }

    @Override
    public void run() {
        for (long i = from; i < to; i++) {
            if (Checker.isPrime(i)) {
                if (addToOwnList) {
                    list.add(i);
                } else {
                    synchronized (PrimesStorage.getList()) {
                        PrimesStorage.getList().add(i);
                    }
                }
            }
        }
    }

    public List<Long> getList() {
        return list;
    }

    public void setFrom(long from) {
        if (from < 2) {
            from = 2;
        }
        this.from = from;
    }
}
