package part1;

import utility.Checker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arsalan
 */
public class FindPrimesThread implements Runnable {

    private List<Long> list;
    private boolean addToOwnList;

    public FindPrimesThread(boolean addToOwnList){
        this.addToOwnList = addToOwnList;
        this.list = new ArrayList<>();
    }

    @Override
    public void run() {
        for (long l: list) {
            if(Checker.isPrime(l)){
                if (addToOwnList) {
                    list.add(l);
                } else {
                    synchronized (PrimesStorage.getList()) {
                        PrimesStorage.getList().add(l);
                    }
                }
            }
        }
    }

    public List<Long> getList() {
        return list;
    }
}
