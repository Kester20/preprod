package abstractFactory;

import entity.product.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Arsal on 10.11.2016.
 * abstract factory/builder
 */
public abstract class Factory {

	protected Scanner scanner;
	protected Random random;
	private static final String ENTER_ID = "Enter product's id:";
	private static final String ENTER_NAME = "Enter product's name:";
	private static final String ENTER_COST = "Enter product's cost:";
	protected static final String ID = "id";
	protected static final String NAME = "name";
	protected static final String COST = "cost";
	protected static final int DEFAULT_BOUND = 1000;

	public Factory() {
		this.scanner = new Scanner(System.in);
		this.random = new Random();
	}

	/**
	 *
	 * @param z if z = 0, then product reads from console
	 *          if z = 1, then product reads from random
	 * @return instance of product
	 */
	public abstract Product createInstance(int z);

	/**
	 * reads fields values from console
	 * initialize instance
	 * @return instance of product
	 */
	public abstract Product createFromConsole();

	/**
	 * reads fields values from random
	 * initialize instance
	 * @return instance of product
	 */
	public abstract Product createFromRandom();

	/**
	 * Fill the main fields from console
	 * @return map, where key - name of the field, entry - value of the field
	 */
	protected Map<String, Object> fillDefaultFieldsFromConsole(){
		Map<String, Object> map = new HashMap();
		System.out.println(ENTER_ID);
		int productId = scanner.nextInt();
		System.out.println(ENTER_NAME);
		String productName = scanner.next();
		System.out.println(ENTER_COST);
		int productCost = scanner.nextInt();
		map.put(ID, productId);
		map.put(NAME, productName);
		map.put(COST, productCost);
		return map;
	}

	/**
	 * Fill the main fields from random
	 * @return map, where key - name of the field, entry - value of the field
	 */
	protected Map<String, Object> fillDefaultFieldsFromRandom(){
		Map<String, Object> map = new HashMap();
		System.out.println(ENTER_ID);
		int productId = random.nextInt(DEFAULT_BOUND);
		System.out.println(ENTER_NAME);
		String productName = NAME + random.nextInt(DEFAULT_BOUND);
		System.out.println(ENTER_COST);
		int productCost = random.nextInt(DEFAULT_BOUND);
		map.put(ID, productId);
		map.put(NAME, productName);
		map.put(COST, productCost);
		return map;
	}

}
