package view;

import java.text.ParseException;
import java.util.Scanner;

/**
 * @author Arsalan
 * template command
 */
public interface Command {

	public String line = "---------------------------------------------------------";
	public Scanner scanner = new Scanner(System.in);
	public String ENTER_THE_PRODUCT_NAME = "Enter the product name";

	/**
	 * execute command
	 */
	void exec() throws ParseException;

	default String readProductNameThatWillBeAdded(){
		System.out.println(ENTER_THE_PRODUCT_NAME);
		return scanner.next();
	}
}
