package services.impl;

import entity.shop.Cart;
import repository.ShopRepository;
import repository.impl.ShopRepositoryImpl;
import services.CartService;
import services.ShopService;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Said_Sulaiman_Arsala on 11/4/2016.
 * template service for shop
 */
public class ShopServiceImpl implements ShopService {

    private ShopRepository shopRepository;

    public ShopServiceImpl() {
        this.shopRepository = new ShopRepositoryImpl();
    }

    @Override
    public void addOrder(Date date, Cart cart) {
        Map<Integer, Integer> cloneCart = (Map<Integer, Integer>) cart.getContainer().clone();
        shopRepository.addOrder(date, cloneCart);
    }

    @Override
    public Map ordersInRange(Date firstDate, Date secondDate) {
        Map<Date, Map> result = new HashMap<>();
        Iterator iterator = shopRepository.getShop().getListOrders().getStorageOrders().keySet().iterator();
        while (iterator.hasNext()) {
            Date date = (Date) iterator.next();
            if (date.after(firstDate) & date.before(secondDate)) {
                result.put(date, shopRepository.getShop().getListOrders().getStorageOrders().get(date));
            }
        }
        return result;
    }

    @Override
    public Map orderOnTheNearestDate(Date date) {
        Map<Date, Map> result = new HashMap<>();
        Date floorDate = shopRepository.getShop().getListOrders().getStorageOrders().floorKey(date);
        Date ceilingDate = shopRepository.getShop().getListOrders().getStorageOrders().ceilingKey(date);

        if (floorDate.getTime() - date.getTime() > ceilingDate.getTime() - date.getTime()) {
            result.put(ceilingDate, shopRepository.getShop().getListOrders().getStorageOrders().get(date));
        } else {
            result.put(floorDate, shopRepository.getShop().getListOrders().getStorageOrders().get(date));
        }

        return result;
    }


    @Override
    public ShopRepository getShopRepository() {
        return shopRepository;
    }
}
