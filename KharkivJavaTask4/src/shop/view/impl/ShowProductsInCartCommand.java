package shop.view.impl;

import shop.services.CartService;
import shop.view.Command;
import shop.view.appl.PrintItems;

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
