package view.appl;

import java.text.ParseException;

/**
 * Created by Arsal on 06.11.2016.
 * view class
 */
public class View {

	private Application application;

	public View() {
		application = new Application();
	}

	/**
	 * Display menu
	 * @throws ParseException
	 */
	public void viewApplication() throws ParseException {
		while (true) {
			System.out.println("///////////////////////////////////////////////////////");
			System.out.println("1. Show all products.");
			System.out.println("2. Add to cart.");
			System.out.println("3. Show cart.");
			System.out.println("4. Buy all products in cart.");
			System.out.println("5. Show 5 last products, which were added to cart.");
			System.out.println("6. Show orders in range");
			System.out.println("7. Show order on the nearest date");
			System.out.println("8. Exit.");
			System.out.println("---------------------------------------------------------");
			System.out.println("Choose operation:");

			int operation = application.getScanner().nextInt();
			if (operation == 8) {
				return;
			}
			application.getCommandMap().get(operation).exec();
		}
	}

	/**
	 *
	 * @return application object
	 */
	public Application getApplication() {
		return application;
	}
}
