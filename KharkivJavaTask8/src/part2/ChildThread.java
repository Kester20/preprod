package part2;

import utility.FindLongestRepeated;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Arsalan
 */
public class ChildThread implements Runnable {

	private boolean waiting = true;
	private String fileName;

	@Override
	public void run() {
		while (waiting) {
			try {
				synchronized (this) {
					wait();
				}
				System.out.println("longest = " + findLongestRepeated(fileName));
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param fileName - name of file
	 * @return longest bytes in file
	 * @throws IOException
	 */
	public String findLongestRepeated(String fileName) throws IOException {
		return FindLongestRepeated.longestRepeated(getContentOfFile(fileName));
	}

	/**
	 * @param fileName - name of file
	 * @return content of file
	 * @throws IOException
	 */
	public String getContentOfFile(String fileName) throws IOException {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String s;
			while ((s = br.readLine()) != null) {
				sb.append(s + "\n");
			}
		}
		return sb.toString();
	}

	/**
	 * sets flag to false, it means thread can be continued
	 */
	public synchronized void setWaitingFalse() {
		this.waiting = false;
		notify();
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
