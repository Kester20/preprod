package part2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Arsalan
 */
public class ChildThread implements Runnable {

    private byte[] bytes = {};
    private volatile int sequence;
    private int firstEntry;
    private int secondEntry;
    private byte[] result;
    private volatile Boolean canWork = false;
    private volatile Boolean isFinished = false;


    @Override
    public void run() {
        while (true) {
            if (canWork) {
                findLongestRepeated();
            } else {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    /**
     * Searches longest byte sequences.
     */
    private void findLongestRepeated() {
        boolean equalsSequence = true;
        byte[] origin;
        for (int i = 0; i < bytes.length; i++) {
            if (!equalsSequence) {
                break;
            }
            origin = new byte[sequence];
            for (int k = 0; k + sequence < bytes.length; k++) {

                System.arraycopy(bytes, k, origin, 0, sequence);
                for (int j = k + 1; j + sequence - 1 < bytes.length; j++) {
                    equalsSequence = true;
                    for (int z = 0; z < sequence; z++) {
                        if (origin[z] != bytes[j + z]) {
                            equalsSequence = false;
                            break;
                        }
                    }
                    if (equalsSequence) {
                        firstEntry = k;
                        secondEntry = j;

                        synchronized (this) {
                            result = new byte[sequence];
                            result = origin;
                        }


                        equalsSequence = true;
                        break;
                    }
                }
                if (equalsSequence) {
                    sequence++;
                    break;
                }
            }
        }
        synchronized (this) {
            isFinished = true;
            canWork = false;
            bytes = new byte[0];
        }
    }

    public void setBytes(byte[] bytes) {
        synchronized (this) {
            this.bytes = bytes;
            isFinished = false;
            canWork = true;
            init();
        }
    }

    private void init() {
        sequence = 0;
        firstEntry = 0;
        secondEntry = 0;
        result = new byte[0];
    }

    public boolean isFinished() {
        synchronized (this) {
            return isFinished;
        }
    }

    public int getResult() {
        synchronized (this) {
            return result.length + 1;
        }
    }

    public int getFirstEntry() {
        return firstEntry;
    }

    public int getSecondEntry() {
        return secondEntry;
    }
}
