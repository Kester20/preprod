package repository;

import entity.product.Product;
import entity.shop.Shop;

import java.util.Date;
import java.util.Map;

/**
 * @author Arsalan
 * template repository for shop
 */
public interface ShopRepository {

	/**
	 * Makes order and adds it to list order
	 *
	 * @param date date of order
	 * @param cart shop cart
	 */
	public void addOrder(Date date, Map<Product, Integer> cart);


	/**
	 * @return shop
	 */
	public Shop getShop();

}
