package shop.abstractBuilder;

import shop.entity.product.Product;
import shop.entity.product.SmartPhone;
import static shop.abstractBuilder.LaptopBuilder.PRODUCER;
import java.util.Map;

/**
 * @author Arsalan
 * creates instance of smart phone shop.entity
 */
public class SmartPhoneBuilder extends PhoneBuilder {

	public static final String VERSION = "version";

	@Override
	public Product createInstance(Map<String, Object> fields) {
		SmartPhone phone = new SmartPhone();
		phone.setId((Integer) fields.get(ID));
		phone.setName((String) fields.get(NAME));
		phone.setCost((Integer) fields.get(COST));
		phone.setProducer((String) fields.get(PRODUCER));
		phone.setAndroidVersion((String) fields.get(VERSION));
		return phone;
	}
}
