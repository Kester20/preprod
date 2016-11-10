package services;

import entity.product.Product;
import repository.ProductRepository;

/**
 * Created by Arsal on 03.11.2016.
 * template service for product
 */
public interface ProductService {

    /**
     * adds product to product list
     *
     * @param product product, that will be added
     */
    public void addProductToList(Product product);

    /**
     * gets product by id
     *
     * @param id product's id
     * @return product
     */
    public Product getProductById(int id);

    /**
     * @return repository
     */
    public ProductRepository getProductRepository();
}
