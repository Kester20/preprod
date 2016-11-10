package abstractFactory.map;

import abstractFactory.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arsal on 10.11.2016.
 * map contains key - name of product, entry - entity builder/factory
 */
public class MapFactory {

	private Map<String, Factory> factoryMap;

	/**
	 * initializes factory map
	 */
	public MapFactory() {
		factoryMap = new HashMap<>();
		factoryMap.put("laptop", new LaptopFactory());
		factoryMap.put("phone", new PhoneFactory());
		factoryMap.put("smart_phone", new SmartPhoneFactory());
	}

	/**
	 *
	 * @return factory map
	 */
	public Map<String, Factory> getFactoryMap() {
		return factoryMap;
	}
}
