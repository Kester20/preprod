package view.impl;

import services.CartService;
import services.ProductService;
import view.Command;

/**
 * Created by Arsal on 05.11.2016.
 * template for add to cart
 */
public class AddProductToCartCommand implements Command {

    private CartService cartService;
    private ProductService productService;

    public AddProductToCartCommand(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    /**
     * adds product to shop cart
     */
    @Override
    public void exec() {
        System.out.println(line);
        System.out.println("Enter product's id:");
        int productId = scanner.nextInt();
        cartService.addProductToCart(productService.getProductById(productId));
        System.out.println("Product with id --> " + productId + " was added to shop cart!");
    }
}
