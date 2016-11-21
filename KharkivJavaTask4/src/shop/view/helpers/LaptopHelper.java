package shop.view.helpers;

import shop.entity.product.Laptop;
import provider.Reader;

import java.util.HashMap;
import java.util.Map;

import static shop.entity.constants.Constants.PRODUCER;
import static shop.entity.constants.Constants.SCREEN;

/**
 * @author Arsalan
 *         'helps' read fields for shop.entity laptop
 */
public class LaptopHelper extends ProductHelper {

    @Override
    public Map<String, Object> read(Reader reader) {
        Map<String, Object> map = super.read(reader);
        printSuggestion(Laptop.class);
        String productProducer = reader.getString(PRODUCER);
        double productScreen = reader.getDouble();
        return new HashMap<String, Object>(map) {{
            put(PRODUCER, productProducer);
            put(SCREEN, productScreen);
        }};
    }
}
