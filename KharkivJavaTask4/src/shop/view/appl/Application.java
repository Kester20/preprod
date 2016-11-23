package shop.view.appl;

import handler.impl.Handler;
import net.servers.HttpServer;
import net.servers.TcpServer;
import provider.map.MapReader;
import shop.abstractBuilder.map.BuilderMap;
import shop.repository.factory.RepositoryFactory;
import shop.services.CartService;
import shop.services.ProductService;
import shop.services.ShopService;
import shop.services.impl.CartServiceImpl;
import shop.services.impl.ProductServiceImpl;
import shop.services.impl.ShopServiceImpl;
import shop.view.Command;
import shop.view.impl.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Arsalan
 *         application class
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
    private static final int eigthCommand = 8;

    private ProductService productService;
    private CartService cartService;
    private ShopService shopService;
    private Scanner scanner;
    private Map<Integer, Command> commandMap;
    private RepositoryFactory repositoryFactory;
    private BuilderMap mapBuilder;
    private MapReader mapReader;
    private Handler handler;

    public Application() {
        repositoryFactory = new RepositoryFactory();
        productService = new ProductServiceImpl(repositoryFactory);
        cartService = new CartServiceImpl(repositoryFactory);
        shopService = new ShopServiceImpl(repositoryFactory);
        scanner = new Scanner(System.in);
        mapBuilder = new BuilderMap();
        mapReader = new MapReader();
        handler = new Handler(productService);

        Thread threadTcpServer = new Thread(new TcpServer(handler));
        threadTcpServer.setDaemon(true);
        threadTcpServer.start();

        Thread threadHttpServer = new Thread(new HttpServer(handler));
        threadHttpServer.setDaemon(true);
        threadHttpServer.start();

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

    public BuilderMap getMapBuilder() {
        return mapBuilder;
    }

    public static int getEigthCommand() {
        return eigthCommand;
    }

    public MapReader getMapReader() {
        return mapReader;
    }
}
