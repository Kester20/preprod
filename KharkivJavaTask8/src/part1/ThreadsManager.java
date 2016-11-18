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

    private List<Thread> listThreads;
    private List<Integer> listPrimes;
    private List<FindPrimesThread> findPrimesThreads;
    private int countThreads;
    private int from;
    private int to;

    public ThreadsManager(int countThreads, int from, int to) {
        setFrom(from);
        this.to = to;
        listThreads = new ArrayList<>();
        listPrimes = new ArrayList<>();
        findPrimesThreads = new ArrayList<>();
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
        for (FindPrimesThread findPrimesThread : findPrimesThreads) {
            listPrimes.addAll(findPrimesThread.getList());
        }
    }

    /**
     * gives intervals to threads
     */
    private void giveIntervals() {
        for (int i = 0; i < countThreads; i++) {
            FindPrimesThread findPrimesThread = new FindPrimesThread(from++, to, countThreads, false);
            Thread thread = new Thread(findPrimesThread);
            listThreads.add(thread);
            findPrimesThreads.add(findPrimesThread);
        }
    }

    public void setFrom(int from) {
        if (from < 2) {
            from = 2;
        }
        this.from = from;
    }
}
