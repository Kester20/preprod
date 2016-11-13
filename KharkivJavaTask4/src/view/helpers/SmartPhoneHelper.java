package view.helpers;

import view.helpers.reader.ReaderProduct;

import java.util.HashMap;
import java.util.Map;

import static view.helpers.LaptopHelper.ENTER_PRODUCER;
import static view.helpers.LaptopHelper.PRODUCER;


/**
 * @author Arsalan
 * 'helps' read fields for entity smart phone
 */
public class SmartPhoneHelper extends PhoneHelper implements ReaderProduct {

	public static final String ENTER_VERSION = "Enter android's version:";
	public static final String VERSION = "version";

	@Override
	public Map<String, Object> readFromConsole() {
		Map<String, Object> map = super.readFromConsole();
		System.out.println(ENTER_PRODUCER);
		String productProducer = scanner.next();
		System.out.println(ENTER_VERSION);
		String version = scanner.next();
		return new HashMap<String, Object>(map) {{
			put(PRODUCER, productProducer);
			put(VERSION, version);
		}};
	}

	@Override
	public Map<String, Object> readFromRandom() {
		Map<String, Object> map = super.readFromRandom();
		System.out.println(ENTER_PRODUCER);
		String productProducer = PRODUCER + random.nextInt(DEFAULT_BOUND);
		System.out.println(ENTER_VERSION);
		String version = VERSION + random.nextInt(DEFAULT_BOUND);
		return new HashMap<String, Object>(map) {{
			put(PRODUCER, productProducer);
			put(VERSION, version);
		}};
	}
}
