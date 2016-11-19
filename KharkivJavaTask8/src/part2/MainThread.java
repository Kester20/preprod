package part2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
				String fileName = reader.readLine();
				Path path = Paths.get(fileName);
				File file = new File(fileName);
				if (file.exists() && file.isFile()) {
					byte[] bytes = Files.readAllBytes(path);

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
}
