package view.helpers.reader;

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
}
