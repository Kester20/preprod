package view.appl;

import serialization.Serialize;
import view.impl.AddProductToListCommand;
import view.impl.AddProductToListWithReflectionCommand;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * @author Arsalan
 *         view class
 */
public class View {

	private Application application;

	public View() {
		application = new Application();
	}

	/**
	 * Display menu
	 *
	 * @throws ParseException
	 */
	public void viewApplication() throws ParseException, IOException, ClassNotFoundException {

		if (new File(Serialize.getFileNameSer()).exists()) {
			application.getProductService().getProductRepository().setList(Serialize.deSerialize(Serialize.getFileNameSer()));
		}

		System.out.println("Choose type of adding product:\n 1.From console\n 2.From random");
		Scanner scanner = new Scanner(System.in);
		int chooseType = scanner.nextInt();
		application.getCommandMap().put(Application.getAddProductCommand(),
				new AddProductToListCommand(application.getProductService(), chooseType));
		application.getCommandMap().put(Application.getEigthCommand(),
				new AddProductToListWithReflectionCommand(application.getProductService(), chooseType));


		while (true) {
			System.out.println("\n///////////////////////////////////////////////////////");
			System.out.println("0. Add product.");
			System.out.println("1. Show all products.");
			System.out.println("2. Add to cart.");
			System.out.println("3. Show cart.");
			System.out.println("4. Buy all products in cart.");
			System.out.println("5. Show 5 last products, which were added to cart.");
			System.out.println("6. Show orders in range");
			System.out.println("7. Show order on the nearest date");
			System.out.println("8. Add product with reflection.");
			System.out.println("9. Exit.");
			System.out.println("---------------------------------------------------------");
			System.out.println("Choose operation:");

			int operation = application.getScanner().nextInt();
			if (operation == 9) {
				Serialize.serialize(application.getProductService().getProductRepository());
				return;
			}
			application.getCommandMap().get(operation).exec();
		}
	}

	/**
	 * @return application object
	 */
	public Application getApplication() {
		return application;
	}
}
