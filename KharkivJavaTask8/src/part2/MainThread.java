package part2;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Arsalan
 */
public class MainThread {

	public static void main(String[] args) throws IOException {
		ChildThread childThread = new ChildThread();
		new Thread(childThread).start();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				System.out.println("Enter file name:");
				File file = new File(reader.readLine().trim());
				if (file.exists() && file.isFile()) {
					FileInputStream fileInputStream = new FileInputStream(file);
					byte[] bytes = getBytes(fileInputStream, file.length());

					childThread.setBytes(bytes);
					while (!childThread.isFinished()) {
						System.out.println("Current length: " + childThread.getResult());
						TimeUnit.SECONDS.sleep(1);
					}
					System.out.println("Finish length: " + childThread.getResult());
					System.out.println("First entry: " + childThread.getFirstEntry());
					System.out.println("Second entry: " + childThread.getSecondEntry());

				} else {
					System.out.println("File not found.");
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private static byte[] getBytes(FileInputStream fileInputStream, long length) throws IOException {
		byte[] bytes = new byte[(int) length];
		for (int i = 0; i < length; i++) {
			bytes[i] = (byte) fileInputStream.read();
		}
		return bytes;
	}
}
