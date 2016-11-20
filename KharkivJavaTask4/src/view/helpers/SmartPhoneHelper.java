package view.helpers;

import entity.product.SmartPhone;
import provider.Reader;

import java.util.HashMap;
import java.util.Map;

import static entity.constants.Constants.PRODUCER;
import static entity.constants.Constants.VERSION;


/**
 * @author Arsalan
 *         'helps' read fields for entity smart phone
 */
public class SmartPhoneHelper extends PhoneHelper {

	@Override
	public Map<String, Object> read(Reader reader) {
		Map<String, Object> map = super.read(reader);
		printSuggestion(SmartPhone.class);
		String productProducer = reader.getString(PRODUCER);
		String version = reader.getString(VERSION);
		return new HashMap<String, Object>(map) {{
			put(PRODUCER, productProducer);
			put(VERSION, version);
		}};
	}
}
