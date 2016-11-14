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

    @Override
    public Product readWithReflection(int choice) throws Exception {
        Map<String, Object> map = choice == 1 ? readFromConsole() : readFromRandom();
        Class clazz = Class.forName(path);
        Object laptop = clazz.newInstance();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(ProductAnnotations.Set.class) != null) {
                ProductAnnotations.Set value = method.getAnnotation(ProductAnnotations.Set.class);
                method.invoke(laptop, map.get(value.value()));
            }
        }
        return (Product) laptop;
    }
}
