package view.helpers;

import entity.product.Product;
import view.helpers.reader.ReaderProduct;

import java.lang.reflect.Field;
import java.util.*;

import static entity.product.annot.ProductAnnotations.FriendlyName;
import static entity.product.annot.ProductAnnotations.ruProperties;

/**
 * @author Arsalan
 *         reads product's fields from console and random
 */
public abstract class ProductHelper implements ReaderProduct {

	protected Scanner scanner;
	protected Random random;
	protected static final String ID = "id";
	protected static final String NAME = "name";
	protected static final String COST = "cost";
	protected static final String ENTER_PARAMETERS = "Enter the next parameters:";
	protected static final int DEFAULT_BOUND = 1000;
	protected ResourceBundle bundle;


	/**
	 * initialize types of reading
	 */
	public ProductHelper() {
		this.scanner = new Scanner(System.in);
		this.random = new Random();
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

	@Override
	public Map<String, Object> readFromConsole() {
		System.out.println(ENTER_PARAMETERS);
		printSuggestion(Product.class);
		int productId = scanner.nextInt();
		String productName = scanner.next();
		int productCost = scanner.nextInt();
		return createMapFields(createListFieldsName(ID, NAME, COST), productId, productName, productCost);
	}

	@Override
	public Map<String, Object> readFromRandom() {
		System.out.println(ENTER_PARAMETERS);
		printSuggestion(Product.class);
		int productId = random.nextInt(DEFAULT_BOUND);
		String productName = NAME + random.nextInt(DEFAULT_BOUND);
		int productCost = random.nextInt(DEFAULT_BOUND);
		return createMapFields(createListFieldsName(ID, NAME, COST), productId, productName, productCost);
	}

	/**
	 * prints 'enter fields'
	 */
	public void printSuggestion(Class clazz) {
		for (Field field : clazz.getDeclaredFields()) {
			FriendlyName friendlyName = (field.getAnnotation(FriendlyName.class));
			String value = bundle.getString(friendlyName.value());
			System.out.print(value + ", ");
		}
	}
}
