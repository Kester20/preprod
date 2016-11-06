package services.impl;

import entity.product.Product;
import org.junit.Before;
import org.junit.Test;
import services.CartService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by Arsal on 05.11.2016.
 * Tests cart service
 */
public class CartServiceImplTest {

	private CartService cartService;
	private Product product;

	@Before
	public void initial() {
		this.cartService = new CartServiceImpl();
		this.product = new Product(1, "a", 15000);
	}

	@Test
	public void testAddProductToCart() {
		cartService.getCartRepository().addProductToCart(product, 2);
		assertTrue(cartService.getCartRepository().getCart().getContainer().get(product) == 2);
	}

	@Test
	public void testGetAmountOfProductsInCart() {
		cartService.getCartRepository().addProductToCart(product, 2);
		assertTrue(cartService.getAmountOfProductsInCart() == 30000);
	}

	@Test
	public void testGetLastFiveProducts() {
		cartService.getCartRepository().addProductToCart(new Product(1, "a", 5), 1);
		cartService.getCartRepository().addProductToCart(new Product(2, "b", 5), 1);
		cartService.getCartRepository().addProductToCart(new Product(3, "c", 5), 1);
		cartService.getCartRepository().addProductToCart(new Product(4, "d", 5), 1);
		cartService.getCartRepository().addProductToCart(new Product(5, "e", 5), 1);
		cartService.getCartRepository().addProductToCart(new Product(6, "f", 5), 1);
		cartService.getCartRepository().addProductToCart(new Product(7, "g", 5), 1);

		List<Integer> list = new ArrayList() {{
			add(3);
			add(4);
			add(5);
			add(6);
			add(7);
		}};

		Map<Product, Integer> map = cartService.getLastFiveProducts();
		int index = 0;
		for (Product product:map.keySet()) {
			assertTrue(product.getId() == list.get(index++));
		}
	}
}