package repository.impl;

import entity.product.Product;
import repository.ProductRepository;
import storage.Products;

/**
 * Created by Arsal on 03.11.2016.
 * template repository for product
 */
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public Product getProductById(int id) {
        Product product = null;
        for (Product p : Products.getList()) {
            if (p.getId() == id) {
                product = p;
                break;
            }
        }
        return product;
    }
}
