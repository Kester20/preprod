package shop.services.impl;

import shop.entity.product.Product;
import shop.entity.shop.Cart;
import shop.repository.ShopRepository;
import shop.repository.factory.RepositoryFactory;
import shop.services.ShopService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 *         template service for shop
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

		if (!(ceilingDate == null && floorDate == null)) {
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
