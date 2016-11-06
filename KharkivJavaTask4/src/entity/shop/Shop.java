package entity.shop;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Said_Sulaiman_Arsala on 11/4/2016.
 * Entity shop
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
