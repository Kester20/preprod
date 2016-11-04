package repository;

import entity.product.Product;

/**
 * Created by Arsal on 03.11.2016.
 * template repository for product
 */
public interface ProductRepository {

    /**
     * @param id product
     * @return product
     */
    public Product getProductById(int id);
}
