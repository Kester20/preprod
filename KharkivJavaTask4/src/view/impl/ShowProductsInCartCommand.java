package view.impl;

import services.CartService;
import view.Command;
import view.appl.PrintItems;

/**
 * @author Arsalan
 * template for show cart
 */
public class ShowProductsInCartCommand implements Command {

    private CartService cartService;

    public ShowProductsInCartCommand(CartService cartService) {
        this.cartService = cartService;
    }

    /**
     * shows products in cart
     */
    @Override
    public void exec() {
        System.out.println(line);
        System.out.println(PrintItems.printProductsInMap(cartService.getCartRepository().getCart().getContainer()));
    }
}
