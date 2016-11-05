package view.impl;

import services.CartService;
import services.ProductService;
import view.Command;

import java.util.Scanner;

/**
 * Created by Arsal on 05.11.2016.
 * template for add to cart
 */
public class AddProductToCartCommand implements Command {

    private CartService cartService;
    private ProductService productService;
    private Scanner scanner;

    public AddProductToCartCommand(CartService cartService, ProductService productService, Scanner scanner) {
        this.cartService = cartService;
        this.productService = productService;
        this.scanner = scanner;
    }

    /**
     * adds product to shop cart
     */
    @Override
    public void exec() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------------------------------------");
        System.out.println("Enter product's id:");
        int productId = scanner.nextInt();
        cartService.addProductToCart(productService.getProductById(productId));
        System.out.println("Product with id --> " + productId + " was added to shop cart!");
    }
}
