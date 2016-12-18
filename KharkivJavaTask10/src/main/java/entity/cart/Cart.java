package entity.cart;

import entity.laptop.Laptop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public class Cart implements CartOperation {

    private Map<Laptop, Integer> cart;

    public Cart() {
        cart = new HashMap<>();
    }

    @Override
    public void add(Laptop laptop, int count) {
        cart.put(laptop, count);
    }

    @Override
    public void remove(Laptop laptop) {
        cart.remove(laptop);
    }

    @Override
    public Map<Laptop, Integer> getAllProducts() {
        return cart;
    }

    @Override
    public int getNumberOfProducts() {
        return cart.size();
    }

    @Override
    public int getAmount() {
        int result = 0;
        for (Laptop laptop : cart.keySet()) {
            result += laptop.getCost() * cart.get(laptop);
        }
        return result;
    }

    public Map<Laptop, Integer> getCart() {
        return cart;
    }
}
