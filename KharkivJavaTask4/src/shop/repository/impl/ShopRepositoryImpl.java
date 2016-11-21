package shop.repository.impl;

import shop.entity.product.Product;
import shop.entity.shop.Shop;
import shop.repository.ShopRepository;

import java.util.Date;
import java.util.Map;

/**
 * @author Arsalan
 * template shop.repository for shop
 */
public class ShopRepositoryImpl implements ShopRepository {

	private Shop shop;

	public ShopRepositoryImpl() {
		this.shop = new Shop();
	}

	@Override
	public void addOrder(Date date, Map<Product, Integer> cart) {
		shop.getListOrders().put(date, cart);
	}

	@Override
	public Shop getShop() {
		return shop;
	}
}
