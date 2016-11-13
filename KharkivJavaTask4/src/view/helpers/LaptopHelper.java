package view.helpers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 * 'helps' read fields for entity laptop
 */
public class LaptopHelper extends ProductHelper {

	public static final String ENTER_PRODUCER = "Enter product's producer:";
	public static final String SCREEN_RESOLUTION = "Enter product's screen resolution:";
	public static final String PRODUCER = "producer";
	public static final String SCREEN = "screen";

	@Override
	public Map<String, Object> readFromConsole() {
		Map<String, Object> map = super.readFromConsole();
		System.out.println(ENTER_PRODUCER);
		String productProducer = scanner.next();
		System.out.println(SCREEN_RESOLUTION);
		double productScreen = scanner.nextDouble();
		return new HashMap<String, Object>(map) {{
			put(PRODUCER, productProducer);
			put(SCREEN, productScreen);
		}};
	}

	@Override
	public Map<String, Object> readFromRandom() {
		Map<String, Object> map = super.readFromRandom();
		System.out.println(ENTER_PRODUCER);
		String productProducer = PRODUCER + random.nextInt(DEFAULT_BOUND);
		System.out.println(SCREEN_RESOLUTION);
		double productScreen = random.nextDouble();
		return new HashMap<String, Object>(map) {{
			put(PRODUCER, productProducer);
			put(SCREEN, productScreen);
		}};
	}
}
