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
     * @return amount of products cost that in shop cart
     */
    public int getAmountOfProductsInCart();

    /**
     * @return 5 last products that were added to cart
     */
    public Map<Product, Integer> getLastFiveProducts();

    /**
     * @return template repository for cart
     */
    public CartRepository getCartRepository();
}
