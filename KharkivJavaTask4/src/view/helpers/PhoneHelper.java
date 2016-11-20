package view.helpers;

import entity.product.Phone;
import provider.Reader;

import java.util.HashMap;
import java.util.Map;

import static entity.constants.Constants.PRODUCER;


/**
 * @author Arsalan
 *         'helps' read fields for entity phone
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
