package abstractBuilder;

import entity.product.Phone;
import entity.product.Product;
import java.util.Map;
import static abstractBuilder.LaptopBuilder.PRODUCER;

/**
 * @author Arsalan
 * creates instance of phone entity
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
