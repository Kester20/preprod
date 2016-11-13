package view.helpers;

import view.helpers.reader.ReaderProduct;

import java.util.*;

/**
 * @author Arsalan
 * reads product's fields from console and random
 */
public abstract class ProductHelper implements ReaderProduct {

	protected Scanner scanner;
	protected Random random;
	private static final String ENTER_ID = "Enter product's id:";
	private static final String ENTER_NAME = "Enter product's name:";
	private static final String ENTER_COST = "Enter product's cost:";
	protected static final String ID = "id";
	protected static final String NAME = "name";
	protected static final String COST = "cost";
	protected static final int DEFAULT_BOUND = 1000;

	/**
	 * initialize types of reading
	 */
	public ProductHelper() {
		this.scanner = new Scanner(System.in);
		this.random = new Random();
	}

	/**
	 * add all 's' to list
	 * @param s names of fields
	 * @return list, which contains fields name
	 */
	private List<String> createListFieldsName(String ... s){
		return new ArrayList<String>(){{
			for (int i = 0; i < s.length; i++) {
				add(s[i]);
			}
		}};
	}

	/**
	 * create a map
	 * @param listFieldsNames list, which contains fields name
	 * @param values values of fields
	 * @retur map, where key - field's name, entry - value
	 */
	private Map<String, Object> createMapFields(List<String> listFieldsNames,Object ... values) {
		return new HashMap<String, Object>() {{
			for (int i = 0; i < values.length; i++) {
				put(listFieldsNames.get(i), values[i]);
			}
		}};
	}

	@Override
	public Map<String, Object> readFromConsole() {
		System.out.println(ENTER_ID);
		int productId = scanner.nextInt();
		System.out.println(ENTER_NAME);
		String productName = scanner.next();
		System.out.println(ENTER_COST);
		int productCost = scanner.nextInt();
		return createMapFields(createListFieldsName(ID, NAME, COST),productId, productName, productCost);
	}

	@Override
	public Map<String, Object> readFromRandom() {
		System.out.println(ENTER_ID);
		int productId = random.nextInt(DEFAULT_BOUND);
		System.out.println(ENTER_NAME);
		String productName = NAME + random.nextInt(DEFAULT_BOUND);
		System.out.println(ENTER_COST);
		int productCost = random.nextInt(DEFAULT_BOUND);
		return createMapFields(createListFieldsName(ID, NAME, COST),productId, productName, productCost);
	}
}
