package view.helpers;

import entity.product.Product;
import entity.product.SmartPhone;
import entity.product.annot.ProductAnnotations;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static entity.constants.Constants.*;


/**
 * @author Arsalan
 *         'helps' read fields for entity smart phone
 */
public class SmartPhoneHelper extends PhoneHelper {

	private static final String path = "entity.product.SmartPhone";

	@Override
	public Map<String, Object> readFromConsole() {
		Map<String, Object> map = super.readFromConsole();
		printSuggestion(SmartPhone.class);
		String productProducer = scanner.next();
		String version = scanner.next();
		return new HashMap<String, Object>(map) {{
			put(PRODUCER, productProducer);
			put(VERSION, version);
		}};
	}

	@Override
	public Map<String, Object> readFromRandom() {
		Map<String, Object> map = super.readFromRandom();
		printSuggestion(SmartPhone.class);
		String productProducer = PRODUCER + random.nextInt(DEFAULT_BOUND);
		String version = VERSION + random.nextInt(DEFAULT_BOUND);
		return new HashMap<String, Object>(map) {{
			put(PRODUCER, productProducer);
			put(VERSION, version);
		}};
	}

	@Override
	public Product readWithReflection(int choice) throws Exception {
		Map<String, Object> map = choice == 1 ? readFromConsole() : readFromRandom();
		Class clazz = Class.forName(path);
		Object phone = clazz.newInstance();
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (method.getAnnotation(ProductAnnotations.Set.class) != null) {
				ProductAnnotations.Set value = method.getAnnotation(ProductAnnotations.Set.class);
				method.invoke(phone, map.get(value.value()));
			}
		}
		return (Product) phone;
	}
}
