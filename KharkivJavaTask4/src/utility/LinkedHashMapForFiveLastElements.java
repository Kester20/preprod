package utility;

import shop.entity.product.Product;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Arsalan
 * keeps 5 last elements
 */
public class LinkedHashMapForFiveLastElements extends LinkedHashMap <Product, Integer>{

    private static final int MAX_ENTRIES = 5;

    public LinkedHashMapForFiveLastElements() {
        super(MAX_ENTRIES + 1, .75F, false);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
}
