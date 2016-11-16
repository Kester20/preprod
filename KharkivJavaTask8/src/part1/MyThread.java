package part1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arsalan
 */
public class MyThread implements Runnable {

    private List<Integer> list;
    private int start;
    private int end;

    public MyThread(int start, int end) {
        list = new ArrayList<>();
    }

    @Override
    public void run() {
        for (int i = start; i <= end ; i++) {
            if(isPrime(i)){
                list.add(i);
            }
        }
    }

    /**
     *
     * @param number the number, that will be checked
     * @return true, if number is prime, else - false
     */
    public boolean isPrime(int number){
        boolean isPrime = true;
        int temp = 0;
        for (int i=2; i <=number/2; i++) {
            temp = number % i;
            if (temp == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public List<Integer> getList() {
        return list;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
