package view.helpers;

import entity.product.Laptop;
import entity.product.Product;
import entity.product.annot.ProductAnnotations;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 *         'helps' read fields for entity laptop
 */
public class LaptopHelper extends ProductHelper {

	public static final String PRODUCER = "producer";
	public static final String SCREEN = "screen";
	private static final String path = "entity.product.Laptop";


	@Override
	public Map<String, Object> readFromConsole() {
		Map<String, Object> map = super.readFromConsole();
		printSuggestion(Laptop.class);
		String productProducer = scanner.next();
		double productScreen = scanner.nextDouble();
		return new HashMap<String, Object>(map) {{
			put(PRODUCER, productProducer);
			put(SCREEN, productScreen);
		}};
	}

	@Override
	public Map<String, Object> readFromRandom() {
		Map<String, Object> map = super.readFromRandom();
		printSuggestion(Laptop.class);
		String productProducer = PRODUCER + random.nextInt(DEFAULT_BOUND);
		double productScreen = random.nextDouble();
		return new HashMap<String, Object>(map) {{
			put(PRODUCER, productProducer);
			put(SCREEN, productScreen);
		}};
	}

	@Override
	public Product readWithReflection(int choice) throws Exception {
		Map<String, Object> map = choice == 1 ? readFromConsole() : readFromRandom();
		Class clazz = Class.forName(path);
		Object laptop = clazz.newInstance();
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (method.getAnnotation(ProductAnnotations.SetId.class) != null) {
				method.invoke(laptop, map.get(ProductHelper.ID));
			}
			if (method.getAnnotation(ProductAnnotations.SetName.class) != null) {
				method.invoke(laptop, map.get(ProductHelper.NAME));
			}
			if (method.getAnnotation(ProductAnnotations.SetCost.class) != null) {
				method.invoke(laptop, map.get(ProductHelper.COST));
			}
			if (method.getAnnotation(ProductAnnotations.SetProducer.class) != null) {
				method.invoke(laptop, map.get(LaptopHelper.PRODUCER));
			}
			if (method.getAnnotation(ProductAnnotations.SetScreen.class) != null) {
				method.invoke(laptop, map.get(LaptopHelper.SCREEN));
			}
		}
		return (Product) laptop;
	}
}
