package repository;

import entity.product.Product;
import entity.shop.Cart;

/**
 * @author Arsalan
 * template repository for shop cart
 */
public interface CartRepository {

	/**
	 * adds product in cart
	 *
	 * @param product
	 * @param numberOfProduct number of product in cart
	 */
	public void addProductToCart(Product product, int numberOfProduct);

	/**
	 * @return shop cart
	 */
	public Cart getCart();
}
