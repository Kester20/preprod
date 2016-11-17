package part2;

import java.util.concurrent.TimeUnit;

/**
 * @author Arsalan
 */
public class Worker implements Runnable {

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
				byteArrayHandler();
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
	 * Searches byte sequences.
	 */
	private void byteArrayHandler() {
		boolean equalsSequence = true;
		byte[] sample;
		for (int i = 0; i < bytes.length; i++) {
			if (!equalsSequence) {
				break;
			}
			sample = new byte[sequence];
			for (int k = 0; k + sequence < bytes.length; k++) {
				System.arraycopy(bytes, k, sample, 0, sequence);
				for (int j = k + 1; j + sequence - 1 < bytes.length; j++) {
					equalsSequence = true;
					for (int z = 0; z < sequence; z++) {
						if (sample[z] != bytes[j + z]) {
							equalsSequence = false;
							break;
						}
					}
					if (equalsSequence) {
						firstEntry = k;
						secondEntry = j;
						synchronized (result) {
							result = new byte[sequence];
							result = sample;
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
		synchronized (isFinished) {
			isFinished = true;
			canWork = false;
			bytes = new byte[0];
		}
	}

	public void setBytes(byte[] bytes) {
		synchronized (this.bytes) {
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
		synchronized (isFinished) {
			return isFinished;
		}
	}

	public int getResult() {
		synchronized (result) {
			return result.length;
		}
	}

	public Boolean getCanWork() {
		return canWork;
	}

	public int getFirstEntry() {
		return firstEntry;
	}

	public int getSecondEntry() {
		return secondEntry;
	}
}
