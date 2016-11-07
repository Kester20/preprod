package services.impl;

import entity.product.Product;
import entity.shop.Cart;
import repository.CartRepository;
import repository.factory.RepositoryFactory;
import repository.impl.CartRepositoryImpl;
import services.CartService;
import utility.LinkedHashMapForFiveLastElements;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Arsal on 03.11.2016.
 * template service for shop cart
 */
public class CartServiceImpl implements CartService {

	private RepositoryFactory repositoryFactory;
	private LinkedHashMap<Product, Integer> linkedHashMap;
	private static final int DEFAULT_PRODUCT_NUMBER = 1;

	public CartServiceImpl() {
		this.repositoryFactory = new RepositoryFactory();
		this.linkedHashMap = new LinkedHashMapForFiveLastElements();
	}


	@Override
	public void addProductToCart(Product product) {
		if (repositoryFactory.getCartRepository().getCart().getContainer().containsKey(product)) {
			int numberOfProduct = repositoryFactory.getCartRepository().getCart().getContainer().get(product);
			repositoryFactory.getCartRepository().addProductToCart(product, ++numberOfProduct);
			linkedHashMap.put(product, numberOfProduct);
		} else {
			repositoryFactory.getCartRepository().addProductToCart(product, DEFAULT_PRODUCT_NUMBER);
			linkedHashMap.put(product, DEFAULT_PRODUCT_NUMBER);
		}
	}

	@Override
	public int getAmountOfProductsInCart() {
		int amount = 0;
		Iterator iterator = repositoryFactory.getCartRepository().getCart().getContainer().keySet().iterator();
		while (iterator.hasNext()) {
			Product product = (Product) iterator.next();
			amount += (product.getCost() * repositoryFactory.getCartRepository().getCart().getContainer().get(product));
		}
		return amount;
	}

	@Override
	public Map<Product, Integer> getLastFiveProducts() {
		return linkedHashMap;
	}

	@Override
	public CartRepository getCartRepository() {
		return repositoryFactory.getCartRepository();
	}
}
