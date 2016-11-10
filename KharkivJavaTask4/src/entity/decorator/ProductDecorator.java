package entity.decorator;

import entity.product.Product;

/**
 * Created by Said_Sulaiman_Arsala on 11/10/2016.
 * template decorator
 */
public abstract class ProductDecorator {

    protected Product product;

    public ProductDecorator(Product product) {
        this.product = product;
    }

    public int getCost(){
        return product.getCost();
    }
}
