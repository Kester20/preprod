package abstractFactory;

import entity.product.Phone;
import entity.product.Product;

import java.util.Map;

import static abstractFactory.LaptopFactory.ENTER_PRODUCER;
import static abstractFactory.LaptopFactory.PRODUCER;

/**
 * Created by Arsal on 10.11.2016.
 * creates instance of phone entity
 */
public class PhoneFactory extends Factory {

	@Override
	public Product createInstance(int z) {
		return z == 0 ? createFromConsole() : createFromRandom();
	}

	@Override
	public Product createFromConsole() {
		Map<String, Object> map = fillDefaultFieldsFromConsole();
		System.out.println(ENTER_PRODUCER);
		String productProducer = scanner.next();
		Product laptop = new Phone(
				(int) map.get(Factory.ID), (String) map.get(Factory.NAME), (int) map.get(Factory.COST), productProducer);
		return laptop;
	}

	@Override
	public Product createFromRandom() {
		Map<String, Object> map = fillDefaultFieldsFromRandom();
		System.out.println(ENTER_PRODUCER);
		String productProducer = PRODUCER + random.nextInt(Factory.DEFAULT_BOUND);
		Product phone = new Phone(
				(int) map.get(Factory.ID), (String) map.get(Factory.NAME), (int) map.get(Factory.COST), productProducer);
		return phone;
	}
}
