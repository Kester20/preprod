package services.impl;

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

    @Before
    public void initial() {
        this.cartService = new CartServiceImpl();
    }

    @Test
    public void testAddProductToCart() {
        cartService.getCartRepository().addProductToCart(1, 2);
        assertTrue(cartService.getCartRepository().getCart().getContainer().get(1) == 2);
    }

    @Test
    public void testGetAmountOfProductsInCart() {
        cartService.getCartRepository().addProductToCart(0, 2);
        assertTrue(cartService.getAmountOfProductsInCart() == 30000);
    }

    @Test
    public void testGetLastFiveProducts() {
        cartService.getCartRepository().addProductToCart(1, 1);
        cartService.getCartRepository().addProductToCart(2, 1);
        cartService.getCartRepository().addProductToCart(3, 1);
        cartService.getCartRepository().addProductToCart(4, 1);
        cartService.getCartRepository().addProductToCart(5, 1);
        cartService.getCartRepository().addProductToCart(6, 1);
        cartService.getCartRepository().addProductToCart(7, 1);

        List list = new ArrayList() {{
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
        }};

        Map map = cartService.getLastFiveProducts();
        Iterator iterator = map.keySet().iterator();
        int index = 0;
        while (iterator.hasNext()) {
            assertTrue(iterator.next() == list.get(index++));
        }
    }
}