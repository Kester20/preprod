package view.impl;

import provider.Reader;
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
	private Reader reader;

	public AddProductToListCommand(ProductService productService, Reader reader) {
		this.productService = productService;
		this.reader = reader;
		mapHelper = new MapHelper();
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
		return  mapHelper.getMapHelper().get(productName).read(reader);
	}
}
