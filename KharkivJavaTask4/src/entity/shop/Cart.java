package entity.shop;

import entity.product.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Said_Sulaiman_Arsala on 11/2/2016.
 * Entity shop cart
 */
public class Cart {

    private Map<Product, Integer> container;

    public Cart() {
        container = new HashMap<>();
    }

    /**
     * clear shop cart after order is created
     */
    public void clearContainer() {
        container.clear();
    }

    /**
     * @return shop cart
     */
    public HashMap<Product, Integer> getContainer() {
        return (HashMap<Product, Integer>) container;
    }

}
