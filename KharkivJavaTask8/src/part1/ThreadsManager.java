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

    private List<FindPrimesThread> listThreads;
    private List<Long> listPrimes;
    private int countThreads;
    private long from;
    private long to;

    public ThreadsManager(int countThreads, int from, int to) {
        setFrom(from);
        this.to = to;
        listThreads = new ArrayList<>();
        listPrimes = new ArrayList<>();
        this.countThreads = countThreads;
    }

    public void startThreads() throws InterruptedException {
        giveIntervals();
        for (Thread myThread : listThreads) {
            myThread.start();
        }
        for (Thread myThread : listThreads) {
            myThread.join();
        }
        fillPrimes();
    }

    public void startThreadsWithExecutor() throws InterruptedException {
        giveIntervals();
        ExecutorService executorService = Executors.newFixedThreadPool(countThreads);
        for (Thread listThread : listThreads) {
            executorService.execute(listThread);
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        fillPrimes();
    }

    public void fillPrimes() {
        for (FindPrimesThread findPrimesThread : listThreads) {
            listPrimes.addAll(findPrimesThread.getList());
        }
    }

    /**
     * gives intervals to threads
     */
    private void giveIntervals() {
        long range = to / countThreads;
        for (long j = 0; j < to; j++) {
            if (j % range == 0) {
                if(j + range > to){
                    listThreads.add(new FindPrimesThread(j, j + (to - j), false));
                }else{
                    listThreads.add(new FindPrimesThread(j, j + range, false));
                }
            }
        }
    }

    public List<Long> getListPrimes() {
        return listPrimes;
    }

    public List<FindPrimesThread> getListThreads() {
        return listThreads;
    }

    public void setFrom(long from) {
        if (from < 2) {
            from = 2;
        }
        this.from = from;
    }

    public void setTo(long to) {
        this.to = to;
    }
}
