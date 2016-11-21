package shop.services;

import shop.entity.product.Product;
import shop.repository.CartRepository;

import java.util.Map;

/**
 * @author Arsalan
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
     * @return template shop.repository for cart
     */
    public CartRepository getCartRepository();
}
