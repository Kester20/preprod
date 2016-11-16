package part1;

import java.util.Scanner;

/**
 * @author Arsalan
 * class application
 */
public class Application {

    private Scanner scanner;

    public Application() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Enter the interval");
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        System.out.println("Enter the number of threads");
        int numberOfThreads = scanner.nextInt();
    }
}
