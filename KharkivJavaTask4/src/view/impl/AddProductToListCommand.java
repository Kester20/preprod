package view.impl;

import services.ProductService;
import view.Command;
import view.helpers.map.MapHelper;

import java.text.ParseException;
import java.util.Map;

/**
 * @author Arsalan
 * template for add to list of products
 */
public class AddProductToListCommand implements Command {

	private ProductService productService;
	private MapHelper mapHelper;
	private int choice;
	private static final int DEFAULT_CHOICE = 1;

	public AddProductToListCommand(ProductService productService, int choice) {
		this.productService = productService;
		mapHelper = new MapHelper();
		this.choice = choice;
	}

	/**
	 * reads products and adds them to the list
	 *
	 * @throws ParseException
	 */
	@Override
	public void exec() throws ParseException {
		String productName = readProductNameThatWillBeAdded();
		productService.addProductToList(productName, getParametersForFields(productName));
	}

	private Map<String, Object> getParametersForFields(String productName){
		return choice == DEFAULT_CHOICE ? mapHelper.getMapHelper().get(productName).readFromConsole() :
				mapHelper.getMapHelper().get(productName).readFromRandom();
	}
}
