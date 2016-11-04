package repository.impl;

import entity.shop.Cart;
import repository.CartRepository;

/**
 * Created by Arsal on 03.11.2016.
 * template repository for shop cart
 */
public class CartRepositoryImpl implements CartRepository {

    private Cart cart;

    public CartRepositoryImpl(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void addProductToCart(int idProduct, int numberOfProduct) {
        getCart().getContainer().put(idProduct, numberOfProduct);
    }

    @Override
    public Cart getCart() {
        return cart;
    }
}
