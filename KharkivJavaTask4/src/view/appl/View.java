package view.appl;

import entity.product.Laptop;
import entity.product.Product;
import serialization.Serialize;

import java.io.IOException;
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
	public void viewApplication() throws ParseException, IOException, ClassNotFoundException {

		/*application.getProductService().getProductRepository().setList(Serialize.deSerialize("ser.out"));
		System.out.println(application.getProductService().getProductRepository().getList());*/

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
				application.getProductService().getProductRepository().getList().add(new Laptop(1, "a", 55,"b",15.6));
				Serialize.serializeSeveralTimes(application.getProductService().getProductRepository(), 15000);
				Serialize.saveGZip("");
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
