package view.helpers.reader;

import entity.product.Product;

import java.util.Map;

/**
 * @author Arsalan
 *         reads the product different ways
 */
public interface ReaderProduct {

	/**
	 * reads fields values from console
	 *
	 * @return map, where keys- field's name, entry - values
	 */
	public Map<String, Object> readFromConsole();

	/**
	 * reads fields values from random
	 *
	 * @return map, where keys- field's name, entry - values
	 */
	public Map<String, Object> readFromRandom();

	/**
	 * reads fields values with reflection
	 * @return new instance
	 */
	public Product readWithReflection(int choice) throws Exception;

}
