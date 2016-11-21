package shop.services.impl;

import shop.entity.product.Product;
import shop.repository.CartRepository;
import shop.repository.factory.RepositoryFactory;
import shop.services.CartService;
import utility.LinkedHashMapForFiveLastElements;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Arsalan
 * template service for shop cart
 */
public class CartServiceImpl implements CartService {

	private CartRepository cartRepository;
	private LinkedHashMap<Product, Integer> linkedHashMap;
	private static final int DEFAULT_PRODUCT_NUMBER = 1;

	public CartServiceImpl(RepositoryFactory factory) {
		this.cartRepository = factory.getCartRepository();
		this.linkedHashMap = new LinkedHashMapForFiveLastElements();
	}


	@Override
	public void addProductToCart(Product product) {
		if (cartRepository.getCart().getContainer().containsKey(product)) {
			int numberOfProduct = cartRepository.getCart().getContainer().get(product);
			cartRepository.addProductToCart(product, ++numberOfProduct);
			linkedHashMap.put(product, numberOfProduct);
		} else {
			cartRepository.addProductToCart(product, DEFAULT_PRODUCT_NUMBER);
			linkedHashMap.put(product, DEFAULT_PRODUCT_NUMBER);
		}
	}

	@Override
	public int getAmountOfProductsInCart() {
		int amount = 0;
		for (Product product:cartRepository.getCart().getContainer().keySet()) {
			amount += (product.getCost() * cartRepository.getCart().getContainer().get(product));
		}
		return amount;
	}

	@Override
	public Map<Product, Integer> getLastFiveProducts() {
		return linkedHashMap;
	}

	@Override
	public CartRepository getCartRepository() {
		return cartRepository;
	}
}
