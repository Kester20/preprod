package view.impl;

import services.CartService;
import view.Command;

import java.text.ParseException;

/**
 * Created by Arsal on 05.11.2016.
 * template for get last 5 products
 */
public class GetLastFiveProductsCommand implements Command {

    private CartService cartService;

    public GetLastFiveProductsCommand(CartService cartService) {
        this.cartService = cartService;
    }

    /**
     * gets 5 last products which were added to cart
     *
     * @throws ParseException
     */
    @Override
    public void exec() throws ParseException {
        System.out.println("---------------------------------------------------------");
        System.out.println(cartService.printProductsInMap(cartService.getLastFiveProducts()));
    }
}
