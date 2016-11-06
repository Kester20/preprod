package repository.impl;

import entity.product.Product;
import entity.shop.Cart;
import repository.CartRepository;

/**
 * Created by Arsal on 03.11.2016.
 * template repository for shop cart
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
