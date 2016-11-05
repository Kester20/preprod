package view.impl;

import services.CartService;
import view.Command;

/**
 * Created by Arsal on 05.11.2016.
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
        System.out.println("---------------------------------------------------------");
        System.out.println(cartService.printProductsInMap(cartService.getCartRepository().getCart().getContainer()));
    }
}
