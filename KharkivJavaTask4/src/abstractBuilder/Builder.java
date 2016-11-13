package abstractBuilder;

import entity.product.Product;

import java.util.Map;

/**
 * @author Arsalan
 *         abstract factory/builder
 */
public interface Builder {

	public String ID = "id";
	public String NAME = "name";
	public String COST = "cost";

	/**
	 * @param fields fields, that will be sett to new instance
	 * @return instance of product
	 */
	public Product createInstance(Map<String, Object> fields);

}
