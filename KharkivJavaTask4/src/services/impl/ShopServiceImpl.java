package services.impl;

import entity.product.Product;
import entity.shop.Cart;
import repository.ShopRepository;
import repository.factory.RepositoryFactory;
import services.ShopService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Said_Sulaiman_Arsala on 11/4/2016.
 * template service for shop
 */
public class ShopServiceImpl implements ShopService {

	private ShopRepository shopRepository;

	public ShopServiceImpl(RepositoryFactory factory) {
		this.shopRepository = factory.getShopRepository();
	}

	@Override
	public void addOrder(Date date, Cart cart) {
		Map<Product, Integer> cloneCart = new HashMap((Map<Product, Integer>) cart.getContainer().clone());
		shopRepository.addOrder(date, cloneCart);
	}

	@Override
	public Map<Date, Map> ordersInRange(Date firstDate, Date secondDate) {
		return shopRepository.getShop().getListOrders().subMap(firstDate, secondDate);
	}

	@Override
	public Map<Date, Map> orderOnTheNearestDate(Date date) {
		Map<Date, Map> result = new HashMap<>();
		Date floorDate = shopRepository.getShop().getListOrders().floorKey(date);
		Date ceilingDate = shopRepository.getShop().getListOrders().ceilingKey(date);

		if (floorDate != null & ceilingDate != null) {
			if (floorDate == null) {
				result.put(ceilingDate, shopRepository.getShop().getListOrders().get(ceilingDate));
			} else if (ceilingDate == null) {
				result.put(floorDate, shopRepository.getShop().getListOrders().get(floorDate));
			} else {
				if (floorDate.getTime() - date.getTime() > ceilingDate.getTime() - date.getTime()) {
					result.put(ceilingDate, shopRepository.getShop().getListOrders().get(ceilingDate));
				} else {
					result.put(floorDate, shopRepository.getShop().getListOrders().get(floorDate));
				}
			}
		}
		return result;
	}

	@Override
	public ShopRepository getShopRepository() {
		return shopRepository;
	}
}
