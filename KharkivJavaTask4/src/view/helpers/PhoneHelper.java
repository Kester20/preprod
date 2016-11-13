package view.helpers;

import view.helpers.reader.ReaderProduct;

import java.util.HashMap;
import java.util.Map;

import static view.helpers.LaptopHelper.ENTER_PRODUCER;
import static view.helpers.LaptopHelper.PRODUCER;


/**
 * @author Arsalan
 * 'helps' read fields for entity phone
 */
public class PhoneHelper extends ProductHelper implements ReaderProduct {

	@Override
	public Map<String, Object> readFromConsole() {
		Map<String, Object> map = super.readFromConsole();
		System.out.println(ENTER_PRODUCER);
		String productProducer = scanner.next();
		return new HashMap<String, Object>(map) {{
			put(PRODUCER, productProducer);
		}};
	}

	@Override
	public Map<String, Object> readFromRandom() {
		Map<String, Object> map = super.readFromRandom();
		System.out.println(ENTER_PRODUCER);
		String productProducer = PRODUCER + random.nextInt(DEFAULT_BOUND);
		return new HashMap<String, Object>(map) {{
			put(PRODUCER, productProducer);
		}};
	}
}
