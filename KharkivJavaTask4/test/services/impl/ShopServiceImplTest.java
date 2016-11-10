package services.impl;

import entity.shop.Cart;
import org.junit.Before;
import org.junit.Test;
import repository.factory.RepositoryFactory;
import services.ShopService;
import utility.DateFormatter;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by Arsal on 05.11.2016.
 * tests shop service
 */
public class ShopServiceImplTest {

    private ShopService shopService;

    @Before
    public void initial() {
        shopService = new ShopServiceImpl(new RepositoryFactory());
    }

    @Test
    public void testAddOrder() throws ParseException {
        shopService.addOrder(DateFormatter.format("2012-12-12"), new Cart());
        assertTrue(shopService.getShopRepository().getShop().getListOrders().size() == 1);
    }

    @Test
    public void testOrdersInRange() throws ParseException {
        shopService.addOrder(DateFormatter.format("2012-12-12"), new Cart());
        shopService.addOrder(DateFormatter.format("2014-12-12"), new Cart());
        shopService.addOrder(DateFormatter.format("2016-12-12"), new Cart());

        Map<Date, Map> map = shopService.ordersInRange(DateFormatter.format("2010-12-12"), DateFormatter.format("2020-12-12"));
        assertTrue(map.size() == 3);
    }

    @Test
    public void testOrderOnTheNearestDate() throws ParseException {
        shopService.addOrder(DateFormatter.format("2012-12-12"), new Cart());
        shopService.addOrder(DateFormatter.format("2020-12-12"), new Cart());

        Map<Date, Map> map = shopService.orderOnTheNearestDate(DateFormatter.format("2014-12-12"));
        assertTrue(map.containsKey(DateFormatter.format("2012-12-12")) & map.size() == 1);
    }
}