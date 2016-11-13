package view.helpers;

import entity.product.Phone;
import entity.product.Product;
import entity.product.annot.ProductAnnotations;
import view.helpers.reader.ReaderProduct;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static view.helpers.LaptopHelper.PRODUCER;


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

	@Override
	public Product readWithReflection(int choice) throws Exception {
		Map<String, Object> map = choice == 1 ? readFromConsole() : readFromRandom();
		Class clazz = Class.forName(path);
		Object phone = clazz.newInstance();
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (method.getAnnotation(ProductAnnotations.SetId.class) != null) {
				method.invoke(phone, map.get(ProductHelper.ID));
			}
			if (method.getAnnotation(ProductAnnotations.SetName.class) != null) {
				method.invoke(phone, map.get(ProductHelper.NAME));
			}
			if (method.getAnnotation(ProductAnnotations.SetCost.class) != null) {
				method.invoke(phone, map.get(ProductHelper.COST));
			}
			if (method.getAnnotation(ProductAnnotations.SetProducer.class) != null) {
				method.invoke(phone, map.get(LaptopHelper.PRODUCER));
			}
		}
		return (Product) phone;
	}
}
