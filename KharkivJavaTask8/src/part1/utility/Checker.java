package part1.utility;

/**
 * @author Arsalan
 */
public class Checker {

	/**
	 *
	 * @param number the number, that will be checked
	 * @return true, if number is prime, else - false
	 */
	public static boolean isPrime(long number){
		boolean isPrime = true;
		long temp = 0;
		for (int i=2; i <=number/2; i++) {
			temp = number % i;
			if (temp == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

}
