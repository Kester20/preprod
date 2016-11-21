package shop.view.helpers;

import shop.entity.product.Phone;
import provider.Reader;

import java.util.HashMap;
import java.util.Map;

import static shop.entity.constants.Constants.PRODUCER;


/**
 * @author Arsalan
 *         'helps' read fields for shop.entity phone
 */
public class PhoneHelper extends ProductHelper {

	@Override
	public Map<String, Object> read(Reader reader) {
		Map<String, Object> map = super.read(reader);
		printSuggestion(Phone.class);
		String productProducer = reader.getString(PRODUCER);
		return new HashMap<String, Object>(map) {{
			put(PRODUCER, productProducer);
		}};
	}
}
