package view.impl;

import services.CartService;
import services.ShopService;
import utility.DateFormatter;
import view.Command;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by Arsal on 05.11.2016.
 * template for buy all products
 */
public class BuyAllProductsInCartCommand implements Command {

    private CartService cartService;
    private ShopService shopService;
    private Scanner scanner;

    public BuyAllProductsInCartCommand(CartService cartService, ShopService shopService, Scanner scanner) {
        this.cartService = cartService;
        this.shopService = shopService;
        this.scanner = scanner;
    }

    /**
     * buys all product in cart
     *
     * @throws ParseException
     */
    @Override
    public void exec() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        if (cartService.getCartRepository().getCart().getContainer().size() != 0) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Amount: " + cartService.getAmountOfProductsInCart());
            System.out.println("Please, enter the current date(example: 2012-12-12):");
            String dateString = scanner.next();
            shopService.addOrder(DateFormatter.format(dateString), cartService.getCartRepository().getCart());
            cartService.getCartRepository().getCart().clearContainer();
            System.out.println("Thank you for order. Come again!");
        } else {
            System.out.println("Cart is empty!");
        }
    }
}
