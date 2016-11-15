package view.impl;

import entity.product.Product;
import services.ProductService;
import view.Command;
import view.helpers.map.MapHelper;
import view.helpers.map.MapPath;

import java.text.ParseException;

/**
 * @author Arsalan
 */
public class AddProductToListWithReflectionCommand implements Command {

    private ProductService productService;
    private MapHelper mapHelper;
    private MapPath mapPath;
    private int choice;
    private static final int DEFAULT_CHOICE = 1;

    public AddProductToListWithReflectionCommand(ProductService productService, int choice) {
        this.productService = productService;
        mapHelper = new MapHelper();
        mapPath = new MapPath();
        this.choice = choice;
    }

    /**
     * reads products and adds them to the list
     *
     * @throws ParseException
     */
    @Override
    public void exec() {
        String productName = readProductNameThatWillBeAdded();
        try {
            productService.addProductToList(getParametersForFields(productName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Product getParametersForFields(String productName) throws Exception {
        return choice == DEFAULT_CHOICE ? mapHelper.getMapHelper().get(productName).readWithReflection(choice, mapPath.getMapPath().get(productName)) :
                mapHelper.getMapHelper().get(productName).readWithReflection(choice, mapPath.getMapPath().get(productName));
    }
}
