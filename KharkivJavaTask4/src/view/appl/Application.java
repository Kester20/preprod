package view.appl;

import repository.factory.RepositoryFactory;
import services.CartService;
import services.ProductService;
import services.ShopService;
import services.impl.CartServiceImpl;
import services.impl.ProductServiceImpl;
import services.impl.ShopServiceImpl;
import view.Command;
import view.impl.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Arsal on 06.11.2016.
 * application class
 */
public class Application {

    private static final int addProductCommand = 0;
    private static final int firstCommand = 1;
    private static final int secondCommand = 2;
    private static final int thirdCommand = 3;
    private static final int fourthCommand = 4;
    private static final int fifthCommand = 5;
    private static final int sixthCommand = 6;
    private static final int seventhCommand = 7;

    private ProductService productService;
    private CartService cartService;
    private ShopService shopService;
    private Scanner scanner;
    private Map<Integer, Command> commandMap;
    private RepositoryFactory repositoryFactory;

    public Application() {
        repositoryFactory = new RepositoryFactory();
        productService = new ProductServiceImpl(repositoryFactory);
        cartService = new CartServiceImpl(repositoryFactory);
        shopService = new ShopServiceImpl(repositoryFactory);
        scanner = new Scanner(System.in);

        commandMap = new HashMap<>();
        commandMap.put(firstCommand, new ShowAllProductsCommand(productService));
        commandMap.put(secondCommand, new AddProductToCartCommand(cartService, productService));
        commandMap.put(thirdCommand, new ShowProductsInCartCommand(cartService));
        commandMap.put(fourthCommand, new BuyAllProductsInCartCommand(cartService, shopService));
        commandMap.put(fifthCommand, new GetLastFiveProductsCommand(cartService));
        commandMap.put(sixthCommand, new GetOrdersInDateRangeCommand(shopService));
        commandMap.put(seventhCommand, new GetOrderOnTheNearestDateCommand(shopService));
    }

    public ProductService getProductService() {
        return productService;
    }

    public CartService getCartService() {
        return cartService;
    }

    public ShopService getShopService() {
        return shopService;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Map<Integer, Command> getCommandMap() {
        return commandMap;
    }

    public static int getAddProductCommand() {
        return addProductCommand;
    }
}
