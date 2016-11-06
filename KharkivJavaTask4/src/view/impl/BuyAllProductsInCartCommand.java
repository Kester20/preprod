package view.impl;

import services.CartService;
import services.ShopService;
import utility.DateFormatter;
import view.Command;

import java.text.ParseException;

/**
 * Created by Arsal on 05.11.2016.
 * template for buy all products
 */
public class BuyAllProductsInCartCommand implements Command {

	private CartService cartService;
	private ShopService shopService;

	public BuyAllProductsInCartCommand(CartService cartService, ShopService shopService) {
		this.cartService = cartService;
		this.shopService = shopService;
	}

	/**
	 * buys all product in cart
	 *
	 * @throws ParseException
	 */
	@Override
	public void exec() throws ParseException {
		if (!cartService.getCartRepository().getCart().getContainer().isEmpty()) {
			System.out.println(line);
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
