package abstractFactory;

import entity.product.Product;
import entity.product.SmartPhone;

import java.util.Map;

import static abstractFactory.LaptopFactory.ENTER_PRODUCER;
import static abstractFactory.LaptopFactory.PRODUCER;

/**
 * Created by Arsal on 10.11.2016.
 * creates instance of smart phone entity
 */
public class SmartPhoneFactory extends Factory {

	public static final String ENTER_VERSION = "Enter android's version:";
	public static final String VERSION = "version";

	@Override
	public Product createInstance(int z) {
		return z == 0 ? createFromConsole() : createFromRandom();
	}

	@Override
	public Product createFromConsole() {
		Map<String, Object> map = fillDefaultFieldsFromConsole();
		System.out.println(ENTER_PRODUCER);
		String productProducer = scanner.next();
		System.out.println(ENTER_VERSION);
		String version = scanner.next();
		Product phone = new SmartPhone(
				(int) map.get(Factory.ID), (String) map.get(Factory.NAME), (int) map.get(Factory.COST), productProducer, version);
		return phone;
	}

	@Override
	public Product createFromRandom() {
		Map<String, Object> map = fillDefaultFieldsFromRandom();
		System.out.println(ENTER_PRODUCER);
		String productProducer = PRODUCER + random.nextInt(DEFAULT_BOUND);
		System.out.println(ENTER_VERSION);
		String version = VERSION + random.nextInt(DEFAULT_BOUND);
		Product phone = new SmartPhone(
				(int) map.get(Factory.ID), (String) map.get(Factory.NAME), (int) map.get(Factory.COST), productProducer, version);
		return phone;
	}
}
