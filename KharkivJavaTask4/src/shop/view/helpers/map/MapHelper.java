package shop.view.helpers.map;

import shop.view.helpers.LaptopHelper;
import shop.view.helpers.PhoneHelper;
import shop.view.helpers.ProductHelper;
import shop.view.helpers.SmartPhoneHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 *         map contains key - name of product, entry - helper for reading this product
 */
public class MapHelper {

	private Map<String, ProductHelper> mapHelper;

	/**
	 * initializes helper map
	 */
	public MapHelper() {
		mapHelper = new HashMap<String, ProductHelper>() {{
			put("laptop", new LaptopHelper());
			put("phone", new PhoneHelper());
			put("smart_phone", new SmartPhoneHelper());
		}};
	}

	/**
	 * @return map helper
	 */
	public Map<String, ProductHelper> getMapHelper() {
		return mapHelper;
	}
}
