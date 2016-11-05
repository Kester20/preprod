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
    private CartService cartService;

    public ShopServiceImpl() {
        this.shopRepository = new ShopRepositoryImpl();
        cartService = new CartServiceImpl();
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

        if(floorDate == null){
            result.put(ceilingDate, shopRepository.getShop().getListOrders().getStorageOrders().get(ceilingDate));
        }
        else if(ceilingDate == null){
            result.put(floorDate, shopRepository.getShop().getListOrders().getStorageOrders().get(floorDate));
        }else{
            if (floorDate.getTime() - date.getTime() > ceilingDate.getTime() - date.getTime()) {
                result.put(ceilingDate, shopRepository.getShop().getListOrders().getStorageOrders().get(ceilingDate));
            } else {
                result.put(floorDate, shopRepository.getShop().getListOrders().getStorageOrders().get(floorDate));
            }
        }
        return result;
    }

    @Override
    public String printOrdersInMap(Map map) {
        StringBuilder sb = new StringBuilder();
        if(map.size() == 0){
            sb.append("Order list is empty!");
        }else{
            int index = 0;
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                Date date = (Date) iterator.next();
                Map cart = (Map) map.get(date);
                sb.append(++index + ". " + date.toString() + "\n");
                sb.append(cartService.printProductsInMap(cart));
            }
        }
        return sb.toString();
    }


    @Override
    public ShopRepository getShopRepository() {
        return shopRepository;
    }
}
