package abstractBuilder.map;

import abstractBuilder.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 * map contains key - name of product, entry - entity builder/factory
 */
public class BuilderMap {

	private Map<String, Builder> builderMap;

	/**
	 * initializes factory map
	 */
	public BuilderMap() {
		builderMap = new HashMap<>();
		builderMap.put("laptop", new LaptopBuilder());
		builderMap.put("phone", new PhoneBuilder());
		builderMap.put("smart_phone", new SmartPhoneBuilder());
	}

	/**
	 *
	 * @return factory map
	 */
	public Map<String, Builder> getBuilderMap() {
		return builderMap;
	}
}
