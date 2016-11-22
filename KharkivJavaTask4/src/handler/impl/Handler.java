package handler.impl;

import handler.RequestHandler;
import shop.entity.product.Product;
import shop.repository.factory.RepositoryFactory;
import shop.services.ProductService;
import shop.services.impl.ProductServiceImpl;

/**
 * @author Arsalan
 */
public class Handler implements RequestHandler {

    private ProductService productService;

    public Handler(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String getCountOfProducts() {
        int count = productService.getProductRepository().getList().size();
        return "count = " + count;
    }

    @Override
    public String getItemById(String id) {
        String result = null;
        for (Product product:productService.getProductRepository().getList()) {
            if(product.getId() == Integer.parseInt(id)){
                result = product.getName() + " | " + product.getCost();
                break;
            }
        }
        return result;
    }


}
