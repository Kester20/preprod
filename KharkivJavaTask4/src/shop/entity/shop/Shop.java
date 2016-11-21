package shop.entity.shop;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Arsalan
 *         Entity shop
 */
public class Shop {

	private Map<Date, Map> listOrders;

	public Shop() {
		this.listOrders = new TreeMap<>();
	}

	/**
	 * @return list of orders
	 */
	public TreeMap<Date, Map> getListOrders() {
		return (TreeMap<Date, Map>) listOrders;
	}
}
