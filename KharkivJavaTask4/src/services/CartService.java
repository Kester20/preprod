package services;

import entity.product.Product;
import repository.CartRepository;

import java.util.Map;

/**
 * Created by Arsal on 03.11.2016.
 * template service for shop cart
 */
public interface CartService {

    /**
     * Adds product to cart
     *
     * @param product product
     */
    public void addProductToCart(Product product);

    /**
     * displays all products that in map
     *
     * @return string representation
     */
    public String printProductsInMap(Map map);

    /**
     * @return amount of products that in shop cart
     */
    public double getAmountOfProductsInCart();

    /**
     * @return 5 last products that were added to cart
     */
    public Map getLastFiveProducts();

    /**
     * @return template repository for cart
     */
    public CartRepository getCartRepository();
}
