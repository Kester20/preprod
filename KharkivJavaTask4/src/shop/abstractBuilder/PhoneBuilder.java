package shop.abstractBuilder;

import shop.entity.product.Phone;
import shop.entity.product.Product;
import java.util.Map;
import static shop.abstractBuilder.LaptopBuilder.PRODUCER;

/**
 * @author Arsalan
 * creates instance of phone shop.entity
 */
public class PhoneBuilder implements Builder {

	@Override
	public Product createInstance(Map<String, Object> fields) {
		Phone phone = new Phone();
		phone.setId((Integer) fields.get(ID));
		phone.setName((String) fields.get(NAME));
		phone.setCost((Integer) fields.get(COST));
		phone.setProducer((String) fields.get(PRODUCER));
		return phone;
	}
}
