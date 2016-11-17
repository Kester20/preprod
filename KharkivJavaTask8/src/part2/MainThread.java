package part2;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Arsalan
 */
public class MainThread {

	public static void main(String[] args) throws IOException {
		Worker worker = new Worker();
		new Thread(worker).start();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				System.out.println("Enter file name:");
				File file = new File(reader.readLine().trim());
				if (file.exists() && file.isFile()) {
					FileInputStream fileInputStream = new FileInputStream(file);
					byte[] bytes = getBytes(fileInputStream, file.length());

					worker.setBytes(bytes);
					while (!worker.isFinished()) {
						System.out.println("Current length: " + worker.getResult());
						TimeUnit.SECONDS.sleep(1);
					}
					System.out.println("Finish length: " + worker.getResult());
					System.out.println("First entry: " + worker.getFirstEntry());
					System.out.println("Second entry: " + worker.getSecondEntry());

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
