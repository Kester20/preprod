package view.impl;

import services.ShopService;
import utility.DateFormatter;
import view.Command;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by Arsal on 05.11.2016.
 * template for get nearest order in list
 */
public class GetOrderOnTheNearestDateCommand implements Command {

    private ShopService shopService;
    private Scanner scanner;

    public GetOrderOnTheNearestDateCommand(ShopService shopService, Scanner scanner) {
        this.shopService = shopService;
        this.scanner = scanner;
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
        System.out.println(shopService.printOrdersInMap(shopService.orderOnTheNearestDate(DateFormatter.format(dateString))));
    }
}
