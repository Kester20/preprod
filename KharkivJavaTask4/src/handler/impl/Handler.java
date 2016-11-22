package handler.impl;

import handler.RequestHandler;
import shop.repository.factory.RepositoryFactory;
import shop.services.ProductService;
import shop.services.impl.ProductServiceImpl;

/**
 * @author Arsalan
 */
public class Handler implements RequestHandler {

    private RepositoryFactory repositoryFactory;
    private ProductService productService;

    public Handler() {
        repositoryFactory = new RepositoryFactory();
        productService = new ProductServiceImpl(repositoryFactory);
    }

    @Override
    public String getCountOfProducts() {
        int count = productService.getProductRepository().getList().size();
        return "count = " + count;
    }

    @Override
    public String getItemById(String id) {
        System.out.println(id + " !!!");
        return "zzz";
    }


}
