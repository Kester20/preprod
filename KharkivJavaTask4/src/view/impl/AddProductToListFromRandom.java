package view.impl;

import entity.product.Laptop;
import entity.product.Product;
import services.ProductService;
import view.AddProduct;
import view.Command;

import java.text.ParseException;
import java.util.Random;

/**
 * Created by Said_Sulaiman_Arsala on 11/10/2016.
 */
public class AddProductToListFromRandom implements Command, AddProduct {

    private ProductService productService;
    private Random random;

    public AddProductToListFromRandom(ProductService productService) {
        this.productService = productService;
        random = new Random();
    }

    @Override
    public void exec() throws ParseException {
        addProduct();
    }

    @Override
    public void addProduct() {
        System.out.println(line);
        System.out.println("Enter product's id:");
        int productId = random.nextInt(100);
        System.out.println("Enter product's name:");
        String productName = "name" + random.nextInt(100);
        System.out.println("Enter product's cost:");
        int productCost = random.nextInt(100);
        System.out.println("Enter product's producer");
        String productProducer = "producer" + random.nextInt(100);
        System.out.println("Enter product's screen resolution:");
        double productScreen = random.nextDouble();

        Product laptop = new Laptop(productId, productName, productCost, productProducer, productScreen);
        System.out.println("Product: " + laptop);
        productService.addProductToList(laptop);
    }
}
