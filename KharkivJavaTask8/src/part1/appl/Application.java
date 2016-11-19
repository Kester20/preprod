package part1.appl;

import part1.PrimesStorage;
import part1.ThreadsManager;

import java.util.Scanner;

/**
 * @author Arsalan
 */
public class Application {

	private Scanner scanner;

	public Application() {
		scanner = new Scanner(System.in);
	}

	public void start() throws InterruptedException {
		System.out.println("Enter from");
		int from = getInt();
		System.out.println("Enter to");
		int to = getInt();
		System.out.println("Enter number of threads");
		int threads = getInt();
		ThreadsManager threadsManager = new ThreadsManager(threads, from, to);
		threadsManager.startThreads();
		System.out.println("Prime numbers in entered range: " + PrimesStorage.getList());
	}

	private int getInt(){
		return scanner.nextInt();
	}
}
