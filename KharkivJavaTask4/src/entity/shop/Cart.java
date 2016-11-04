package entity.shop;

import java.util.HashMap;

/**
 * Created by Said_Sulaiman_Arsala on 11/2/2016.
 * Entity shop cart
 */
public class Cart {

    private HashMap<Integer, Integer> container;

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
    public HashMap<Integer, Integer> getContainer() {
        return container;
    }

}
