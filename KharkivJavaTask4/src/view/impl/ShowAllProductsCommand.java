package view.impl;

import repository.impl.ProductRepositoryImpl;
import services.ProductService;
import view.Command;
import view.appl.PrintItems;

/**
 * Created by Arsal on 05.11.2016.
 * template command for print list of products
 */
public class ShowAllProductsCommand implements Command {

	private ProductService productService;

	public ShowAllProductsCommand(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * shows all products
	 */
	@Override
	public void exec() {
		System.out.println(PrintItems.printList(productService.getProductRepository().getList()));
	}
}
