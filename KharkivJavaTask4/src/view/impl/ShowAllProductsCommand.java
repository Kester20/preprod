package view.impl;

import services.ProductService;
import view.Command;
import view.appl.PrintItems;

/**
 * @author Arsalan
 *         template command for print list of products
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
