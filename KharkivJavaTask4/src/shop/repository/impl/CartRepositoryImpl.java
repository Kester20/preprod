package shop.repository.impl;

import shop.entity.product.Product;
import shop.entity.shop.Cart;
import shop.repository.CartRepository;

/**
 * @author Arsalan
 * template shop.repository for shop cart
 */
public class CartRepositoryImpl implements CartRepository {

	private Cart cart;

	public CartRepositoryImpl(Cart cart) {
		this.cart = cart;
	}

	@Override
	public void addProductToCart(Product product, int numberOfProduct) {
		getCart().getContainer().put(product, numberOfProduct);
	}

	@Override
	public Cart getCart() {
		return cart;
	}
}
