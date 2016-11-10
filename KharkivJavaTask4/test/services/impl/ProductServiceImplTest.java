package services.impl;

import entity.product.Laptop;
import org.junit.Before;
import org.junit.Test;
import repository.factory.RepositoryFactory;
import services.CartService;
import services.ProductService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Arsal on 05.11.2016.
 * tests product service
 */
public class ProductServiceImplTest {

	private ProductService productService;

	@Before
	public void initial() {
		productService = new ProductServiceImpl(new RepositoryFactory());
	}

	@Test
	public void testAddProduct() {
		productService.addProductToList(new Laptop(3, "a", 5, "b", 15.6));
		assertTrue(productService.getProductRepository().getList().size() ==1);
	}
}