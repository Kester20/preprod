package view.impl;

import services.ShopService;
import utility.DateFormatter;
import view.Command;
import view.appl.PrintItems;

import java.text.ParseException;

/**
 * @author Arsalan
 * template for get orders in range
 */
public class GetOrdersInDateRangeCommand implements Command {

	private ShopService shopService;

	public GetOrdersInDateRangeCommand(ShopService shopService) {
		this.shopService = shopService;
	}

	/**
	 * gets order in date range
	 *
	 * @throws ParseException
	 */
	@Override
	public void exec() throws ParseException {
		System.out.println("Enter the range:");
		String dateStringFirst = scanner.next();
		String dateStringSecond = scanner.next();
		System.out.println(PrintItems.printOrdersInMap(shopService.ordersInRange(DateFormatter.format(dateStringFirst),
				DateFormatter.format(dateStringSecond))));
	}
}
