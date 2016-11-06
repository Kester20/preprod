package view.appl;

import entity.product.Product;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Arsal on 06.11.2016.
 * displays items in map
 */
public class PrintItems {

	/**
	 * displays list of product
	 *
	 * @return
	 */
	public static String printList(List<Product> productList) {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		for (Product product : productList) {
			sb.append(++index + ") " + product + "\n");
		}
		return sb.toString();
	}


	/**
	 * displays all products that in map
	 *
	 * @return string representation
	 */
	public static String printProductsInMap(Map<Product, Integer> map) {
		StringBuilder sb = new StringBuilder();
		if (map.size() == 0) {
			sb.append("Cart is empty!");
		} else {
			int index = 0;
			for (Product product : map.keySet()) {
				sb.append("\t" + ++index + ") " + product + ", number of product:" + map.get(product) + "\n");
			}
		}
		return sb.toString();
	}

	/**
	 * displays all orders that in map
	 *
	 * @param map
	 * @return string representation
	 */
	public static String printOrdersInMap(Map<Date, Map> map) {
		StringBuilder sb = new StringBuilder();
		if (map.size() == 0) {
			sb.append("Order list is empty!");
		} else {
			int index = 0;
			for (Date date : map.keySet()) {
				Map cart = map.get(date);
				sb.append(++index + ". " + date.toString() + "\n");
				sb.append(printProductsInMap(cart));
			}
		}
		return sb.toString();
	}

}
