package view;

import services.CartService;
import services.ProductService;
import services.ShopService;
import services.impl.CartServiceImpl;
import services.impl.ProductServiceImpl;
import services.impl.ShopServiceImpl;
import storage.Products;
import utility.DateFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Said_Sulaiman_Arsala on 11/2/2016.
 * class view
 */
public class Demo {

    public static void main(String[] args) throws ParseException {

        ProductService productService = new ProductServiceImpl();
        CartService cartService = new CartServiceImpl();
        ShopService shopService = new ShopServiceImpl();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("///////////////////////////////////////////////////////");
            System.out.println("1. Show all products.");
            System.out.println("2. Add to cart.");
            System.out.println("3. Show cart.");
            System.out.println("4. Buy all products in cart.");
            System.out.println("5. Show 5 last products, which were added to cart.");
            System.out.println("6. Show orders in range");
            System.out.println("7. Show order on the nearest date");
            System.out.println("8. Exit.");
            System.out.println("---------------------------------------------------------");
            System.out.println("Choose operation:");

            int operation = scanner.nextInt();
            switch (operation) {
                case 1: {
                    System.out.println(Products.printList());
                    break;
                }
                case 2: {
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Enter product's id:");
                    int productId = scanner.nextInt();
                    cartService.addProductToCart(productService.getProductById(productId));
                    break;
                }
                case 3: {
                    System.out.println("---------------------------------------------------------");
                    System.out.println(cartService.printProductsInCart());
                    break;
                }
                case 4: {
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Amount: " + cartService.getAmountOfProductsInCart());
                    System.out.println("Please, enter the current date:");
                    String dateString = scanner.next();
                    shopService.addOrder(DateFormatter.format(dateString), cartService.getCartRepository().getCart());
                    cartService.getCartRepository().getCart().clearContainer();
                    System.out.println(shopService.getShopRepository().getShop().getListOrders().getStorageOrders().size());
                    break;
                }
                case 5: {
                    System.out.println("---------------------------------------------------------");
                    System.out.println(cartService.getLastFiveProducts());
                    break;
                }
                case 6: {
                    System.out.println("Enter the range:");
                    String dateStringFirst = scanner.next();
                    String dateStringSecond = scanner.next();
                    System.out.println(shopService.ordersInRange(DateFormatter.format(dateStringFirst), DateFormatter.format(dateStringSecond)));
                    break;
                }
                case 7: {
                    System.out.println("Enter the date");
                    String dateString = scanner.next();
                    System.out.println(shopService.orderOnTheNearestDate(DateFormatter.format(dateString)));
                    break;
                }
                case 8: {
                    return;
                }
            }
        }
    }
}
