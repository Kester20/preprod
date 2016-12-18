package entity.cart;

import entity.laptop.Laptop;

import java.util.Map;

/**
 * @author Arsalan
 */
public interface CartOperation {

    void add(Laptop laptop, int count);

    void remove(Laptop laptop);

    Map<Laptop, Integer> getAllProducts();

    int getNumberOfProducts();

    int getAmount();

}
