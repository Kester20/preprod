package view.impl;

import entity.product.Laptop;
import entity.product.Product;
import services.ProductService;
import view.AddProduct;
import view.Command;

import java.text.ParseException;

/**
 * Created by Said_Sulaiman_Arsala on 11/10/2016.
 * template for add to product list
 */
public class AddProductToListFromConsoleCommand implements Command, AddProduct {

    private ProductService productService;

    public AddProductToListFromConsoleCommand(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void exec() throws ParseException {
        addProduct();
    }

    @Override
    public void addProduct() {
        System.out.println(line);
        System.out.println("Enter product's id:");
        int productId = scanner.nextInt();
        System.out.println("Enter product's name:");
        String productName = scanner.next();
        System.out.println("Enter product's cost:");
        int productCost = scanner.nextInt();
        System.out.println("Enter product's producer");
        String productProducer = scanner.next();
        System.out.println("Enter product's screen resolution:");
        double productScreen = scanner.nextDouble();

        Product laptop = new Laptop(productId, productName, productCost, productProducer, productScreen);
        System.out.println("Product: " + laptop);
        productService.addProductToList(laptop);
    }
}
