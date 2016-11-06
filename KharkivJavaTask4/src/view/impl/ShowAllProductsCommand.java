package view.impl;

import repository.impl.ProductRepositoryImpl;
import view.Command;
import view.appl.PrintItems;

/**
 * Created by Arsal on 05.11.2016.
 * template command for print list of products
 */
public class ShowAllProductsCommand implements Command {

	/**
	 * shows all products
	 */
	@Override
	public void exec() {
		System.out.println(PrintItems.printList(ProductRepositoryImpl.getList()));
	}
}
