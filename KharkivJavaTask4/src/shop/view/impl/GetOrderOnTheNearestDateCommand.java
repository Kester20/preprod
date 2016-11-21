package shop.view.impl;

import shop.services.ShopService;
import utility.DateFormatter;
import shop.view.Command;
import shop.view.appl.PrintItems;

import java.text.ParseException;

/**
 * @author Arsalan
 * template for get nearest order in list
 */
public class GetOrderOnTheNearestDateCommand implements Command {

	private ShopService shopService;

	public GetOrderOnTheNearestDateCommand(ShopService shopService) {
		this.shopService = shopService;
	}

	/**
	 * gets nearest order
	 *
	 * @throws ParseException
	 */
	@Override
	public void exec() throws ParseException {
		System.out.println("Enter the date");
		String dateString = scanner.next();
		System.out.println(PrintItems.printOrdersInMap(shopService.orderOnTheNearestDate(DateFormatter.format(dateString))));
	}
}
