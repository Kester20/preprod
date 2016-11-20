package view.helpers;

import entity.product.Laptop;
import entity.product.Product;
import entity.product.annot.ProductAnnotations;
import provider.Reader;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static entity.constants.Constants.PRODUCER;
import static entity.constants.Constants.SCREEN;

/**
 * @author Arsalan
 *         'helps' read fields for entity laptop
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
