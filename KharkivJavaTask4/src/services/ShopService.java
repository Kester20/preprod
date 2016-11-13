package services;

import entity.shop.Cart;
import repository.ShopRepository;

import java.util.Date;
import java.util.Map;

/**
 * @author Arsalan
 * template service for shop
 */
public interface ShopService {

    /**
     * Makes order and adds it to list order
     * @param date date of order
     * @param cart shop cart
     */
    public void addOrder(Date date, Cart cart);

    /**
     *
     * @param firstDate
     * @param secondDate
     * @return order list in date range
     */
    public Map<Date, Map> ordersInRange(Date firstDate, Date secondDate);

    /**
     *
     * @param date
     * @return  order on the nearest date
     */
    public Map<Date, Map> orderOnTheNearestDate(Date date);

    /**
     *
     * @return shop repository
     */
    public ShopRepository getShopRepository();
}
