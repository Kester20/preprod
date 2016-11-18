package utility;

/**
 * @author Arsalan
 */
public class Checker {

	/**
	 *
	 * @param number the number, that will be checked
	 * @return true, if number is prime, else - false
	 */
	public static boolean isPrime(int number){
		boolean isPrime = true;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

}
