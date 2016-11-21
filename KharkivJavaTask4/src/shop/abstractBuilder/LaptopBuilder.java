package shop.abstractBuilder;

import shop.entity.product.Laptop;
import shop.entity.product.Product;

import java.util.Map;

/**
 * @author Arsalan
 * creates instance of laptop shop.entity
 */
public class LaptopBuilder implements Builder {

	public static final String PRODUCER = "producer";
	public static final String SCREEN = "screen";

	@Override
	public Product createInstance(Map<String, Object> fields) {
		Laptop laptop = new Laptop();
		laptop.setId((Integer) fields.get(ID));
		laptop.setName((String)fields.get(NAME));
		laptop.setCost((Integer)fields.get(COST));
		laptop.setProducer((String)fields.get(PRODUCER));
		laptop.setScreenResolution((Double)fields.get(SCREEN));
		return laptop;
	}
}
