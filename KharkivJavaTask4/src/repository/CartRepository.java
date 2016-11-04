package repository;

import entity.shop.Cart;

/**
 * Created by Arsal on 03.11.2016.
 * template repository for shop cart
 */
public interface CartRepository {

    /**
     * @param idProduct       id product
     * @param numberOfProduct number of product in cart
     */
    public void addProductToCart(int idProduct, int numberOfProduct);

    /**
     * @return shop cart
     */
    public Cart getCart();
}
