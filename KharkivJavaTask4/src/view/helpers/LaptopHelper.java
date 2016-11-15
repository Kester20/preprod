package view.helpers;

import entity.product.Laptop;
import entity.product.Product;
import entity.product.annot.ProductAnnotations;

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

    private static final String path = "entity.product.Laptop";


    @Override
    public Map<String, Object> readFromConsole() {
        Map<String, Object> map = super.readFromConsole();
        printSuggestion(Laptop.class);
        String productProducer = scanner.next();
        double productScreen = scanner.nextDouble();
        return new HashMap<String, Object>(map) {{
            put(PRODUCER, productProducer);
            put(SCREEN, productScreen);
        }};
    }

    @Override
    public Map<String, Object> readFromRandom() {
        Map<String, Object> map = super.readFromRandom();
        printSuggestion(Laptop.class);
        String productProducer = PRODUCER + random.nextInt(DEFAULT_BOUND);
        double productScreen = random.nextDouble();
        return new HashMap<String, Object>(map) {{
            put(PRODUCER, productProducer);
            put(SCREEN, productScreen);
        }};
    }
}
