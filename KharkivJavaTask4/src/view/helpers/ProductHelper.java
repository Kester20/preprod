package view.helpers;

import entity.product.Product;
import entity.product.annot.ProductAnnotations;
import provider.Reader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import static entity.constants.Constants.*;
import static entity.product.annot.ProductAnnotations.FriendlyName;
import static entity.product.annot.ProductAnnotations.ruProperties;

/**
 * @author Arsalan
 *         reads product's fields from console and random
 */
public abstract class ProductHelper {
	;

	protected static final String ENTER_PARAMETERS = "Enter the next parameters:";
	protected ResourceBundle bundle;

	/**
	 * initialize types of reading
	 */
	public ProductHelper() {
		bundle = ResourceBundle.getBundle(ruProperties);
	}

	/**
	 * add all 's' to list
	 *
	 * @param s names of fields
	 * @return list, which contains fields name
	 */
	private List<String> createListFieldsName(String... s) {
		return new ArrayList<String>() {{
			for (int i = 0; i < s.length; i++) {
				add(s[i]);
			}
		}};
	}

	/**
	 * create a map
	 *
	 * @param listFieldsNames list, which contains fields name
	 * @param values          values of fields
	 * @retur map, where key - field's name, entry - value
	 */
	private Map<String, Object> createMapFields(List<String> listFieldsNames, Object... values) {
		return new HashMap<String, Object>() {{
			for (int i = 0; i < values.length; i++) {
				put(listFieldsNames.get(i), values[i]);
			}
		}};
	}

	/**
	 * @return map, where keys- field's name, entry - values
	 */
	public Map<String, Object> read(Reader reader) {
		System.out.println(ENTER_PARAMETERS);
		printSuggestion(Product.class);
		int productId = reader.getInt();
		String productName = reader.getString(NAME);
		int productCost = reader.getInt();
		return createMapFields(createListFieldsName(ID, NAME, COST), productId, productName, productCost);
	}


	public Product readWithReflection(String path, Reader reader) throws Exception {
		Map<String, Object> map = read(reader);
		Class clazz = Class.forName(path);
		Object product = clazz.newInstance();
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (method.getAnnotation(ProductAnnotations.Set.class) != null) {
				ProductAnnotations.Set value = method.getAnnotation(ProductAnnotations.Set.class);
				method.invoke(product, map.get(value.value()));
			}
		}
		return (Product) product;
	}

	/**
	 * prints 'enter fields'
	 */
	public void printSuggestion(Class clazz) {
		for (Field field : clazz.getDeclaredFields()) {
			FriendlyName friendlyName = field.getAnnotation(FriendlyName.class);
			String value = bundle.getString(friendlyName.value());
			System.out.print(value + ", ");
		}
	}
}
