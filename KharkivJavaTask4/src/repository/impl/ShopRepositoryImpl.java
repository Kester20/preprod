package repository.impl;

import entity.shop.Shop;
import repository.ShopRepository;

import java.util.Date;
import java.util.Map;

/**
 * Created by Said_Sulaiman_Arsala on 11/4/2016.
 * template repository for shop
 */
public class ShopRepositoryImpl implements ShopRepository {

    private Shop shop;

    public ShopRepositoryImpl() {
        this.shop = new Shop();
    }

    @Override
    public void addOrder(Date date, Map cart) {
        shop.getListOrders().getStorageOrders().put(date, cart);
    }

    @Override
    public Shop getShop() {
        return shop;
    }
}
