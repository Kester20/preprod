package view;

import services.CartService;
import services.ProductService;
import services.ShopService;
import services.impl.CartServiceImpl;
import services.impl.ProductServiceImpl;
import services.impl.ShopServiceImpl;
import storage.Products;
import utility.DateFormatter;
import view.impl.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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

        Map<Integer, Command> commandMap = new HashMap<>();
        commandMap.put(1, new ShowAllProductsCommand());
        commandMap.put(2, new AddProductToCartCommand(cartService, productService, scanner));
        commandMap.put(3, new ShowProductsInCartCommand(cartService));
        commandMap.put(4, new BuyAllProductsInCartCommand(cartService, shopService, scanner));
        commandMap.put(5, new GetLastFiveProductsCommand(cartService));
        commandMap.put(6, new GetOrdersInDateRangeCommand(shopService, scanner));
        commandMap.put(7, new GetOrderOnTheNearestDateCommand(shopService, scanner));


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
            if(operation == 8){
                return;
            }
            commandMap.get(operation).exec();
        }
    }
}
