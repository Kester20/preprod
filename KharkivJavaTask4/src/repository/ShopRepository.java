package repository;

import entity.shop.Shop;

import java.util.Date;
import java.util.Map;

/**
 * Created by Said_Sulaiman_Arsala on 11/4/2016.
 * template repository for shop
 */
public interface ShopRepository {

    /**
     * Makes order and adds it to list order
     *
     * @param date date of order
     * @param cart shop cart
     */
    public void addOrder(Date date, Map cart);


    /**
     * @return shop
     */
    public Shop getShop();

}
