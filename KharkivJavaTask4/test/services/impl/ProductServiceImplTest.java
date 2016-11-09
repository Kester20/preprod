package services.impl;

import entity.product.Laptop;
import entity.product.Product;
import org.junit.Before;
import org.junit.Test;
import repository.impl.ProductRepositoryImpl;
import services.CartService;
import services.ProductService;

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
        cartService.getCartRepository().getCart().getContainer().put(new Laptop(3, "a", 5, "b", 15.6), 55);
        assertEquals(productService.getProductById(3), productService.getProductRepository().getList().get(3));
    }
}