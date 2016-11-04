package shop;

import entity.shop.Cart;
import entity.product.Laptop;
import entity.product.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Said_Sulaiman_Arsala on 11/2/2016.
 */
public class CartTest {

    private Cart cart;
    private Product testProduct;
    private Product testProduct2;
    private Product testProduct3;

    @Before
    public void initial(){
        cart = new Cart();
        testProduct = new Laptop(1, "a", 5, "a",  5);
        testProduct2 = new Laptop(1, "a", 5, "a",  5);
        testProduct3 = new Laptop(1, "a", 5, "a",  5);
    }

    /*@Test
    public void testAddProductToCart(){
        cart.addProductToCart(testProduct);
        cart.addProductToCart(testProduct2);
        cart.addProductToCart(testProduct3);
        assertTrue(cart.getCart().get(1) == 3);
    }*/
}