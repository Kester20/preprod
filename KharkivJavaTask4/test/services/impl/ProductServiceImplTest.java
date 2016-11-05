package services.impl;

import org.junit.Before;
import org.junit.Test;
import services.CartService;
import services.ProductService;
import storage.Products;

import static org.junit.Assert.assertEquals;

/**
 * Created by Arsal on 05.11.2016.
 * tests product service
 */
public class ProductServiceImplTest {

    private ProductService productService;

    @Before
    public void initial() {
        productService = new ProductServiceImpl();
    }

    @Test
    public void testGetProductById() {
        CartService cartService = new CartServiceImpl();
        cartService.getCartRepository().getCart().getContainer().put(3, 55);
        assertEquals(productService.getProductById(3), Products.getList().get(3));
    }
}