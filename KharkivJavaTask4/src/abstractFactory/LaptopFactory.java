package abstractFactory;

import entity.product.Laptop;
import entity.product.Product;

import java.util.Map;

/**
 * Created by Arsal on 10.11.2016.
 * creates instance of laptop entity
 */
public class LaptopFactory extends Factory {

	public static final String ENTER_PRODUCER = "Enter product's producer:";
	public static final String SCREEN_RESOLUTION = "Enter product's screen resolution:";
	public static final String PRODUCER = "producer";

	@Override
	public Product createInstance(int z) {
		return z == 0 ? createFromConsole() : createFromRandom();
	}

	@Override
	public Product createFromConsole() {
		Map<String, Object> map = fillDefaultFieldsFromConsole();
		System.out.println(ENTER_PRODUCER);
		String productProducer = scanner.next();
		System.out.println(SCREEN_RESOLUTION);
		double productScreen = scanner.nextDouble();
		Product laptop = new Laptop(
				(int) map.get(Factory.ID), (String) map.get(Factory.NAME), (int) map.get(Factory.COST), productProducer, productScreen);
		return laptop;
	}

	@Override
	public Product createFromRandom() {
		Map<String, Object> map = fillDefaultFieldsFromRandom();
		System.out.println(ENTER_PRODUCER);
		String productProducer = PRODUCER + random.nextInt(Factory.DEFAULT_BOUND);
		System.out.println(SCREEN_RESOLUTION);
		double productScreen = random.nextDouble();
		Product laptop = new Laptop(
				(int) map.get(Factory.ID), (String) map.get(Factory.NAME), (int) map.get(Factory.COST), productProducer, productScreen);
		return laptop;
	}
}
