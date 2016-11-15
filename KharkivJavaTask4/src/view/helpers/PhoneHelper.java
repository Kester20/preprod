package view.helpers;

import entity.product.Phone;
import entity.product.Product;
import entity.product.annot.ProductAnnotations;
import view.helpers.reader.ReaderProduct;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static entity.constants.Constants.*;



/**
 * @author Arsalan
 *         'helps' read fields for entity phone
 */
public class PhoneHelper extends ProductHelper implements ReaderProduct {

	private static final String path = "entity.product.Phone";

	@Override
	public Map<String, Object> readFromConsole() {
		Map<String, Object> map = super.readFromConsole();
		printSuggestion(Phone.class);
		String productProducer = scanner.next();
		return new HashMap<String, Object>(map) {{
			put(PRODUCER, productProducer);
		}};
	}

	@Override
	public Map<String, Object> readFromRandom() {
		Map<String, Object> map = super.readFromRandom();
		printSuggestion(Phone.class);
		String productProducer = PRODUCER + random.nextInt(DEFAULT_BOUND);
		return new HashMap<String, Object>(map) {{
			put(PRODUCER, productProducer);
		}};
	}
}
