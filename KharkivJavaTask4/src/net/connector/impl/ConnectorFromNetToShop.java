package net.connector.impl;

import net.connector.Connector;
import shop.entity.product.Product;
import shop.services.ProductService;

/**
 * @author Arsalan
 */
public class ConnectorFromNetToShop implements Connector {

    private ProductService productService;

    public ConnectorFromNetToShop(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public int getCountOfProducts() {
        return productService.getProductRepository().getList().size();
    }

    @Override
    public Product getItemById(int id) {
        Product result = null;
        for (Product product : productService.getProductRepository().getList()) {
            if (product.getId() == id) {
                result = product;
                break;
            }
        }
        return result;
    }
}
