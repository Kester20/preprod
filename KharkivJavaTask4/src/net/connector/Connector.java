package net.connector;

import shop.entity.product.Product;

/**
 * @author Arsalan
 */
public interface Connector {

    /**
     * gets count of products in shop
     */
    public int getCountOfProducts();

    /**
     * gets item
     *
     * @param id - id of item
     * @return item
     */
    public Product getItemById(int id);
}
