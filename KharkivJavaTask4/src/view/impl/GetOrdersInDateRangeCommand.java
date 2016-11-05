package view.impl;

import services.ShopService;
import utility.DateFormatter;
import view.Command;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by Arsal on 05.11.2016.
 * template for get orders in range
 */
public class GetOrdersInDateRangeCommand implements Command {

    private ShopService shopService;
    private Scanner scanner;

    public GetOrdersInDateRangeCommand(ShopService shopService, Scanner scanner) {
        this.shopService = shopService;
        this.scanner = scanner;
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
        System.out.println(shopService.printOrdersInMap(shopService.ordersInRange(DateFormatter.format(dateStringFirst),
                DateFormatter.format(dateStringSecond))));
    }
}
