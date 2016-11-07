package repository.factory;

import entity.shop.Cart;
import repository.CartRepository;
import repository.ProductRepository;
import repository.ShopRepository;
import repository.impl.CartRepositoryImpl;
import repository.impl.ProductRepositoryImpl;
import repository.impl.ShopRepositoryImpl;

/**
 * Created by Said_Sulaiman_Arsala on 11/7/2016.
 * factory for repositories
 */
public class RepositoryFactory {

    private CartRepository cartRepository;
    private ProductRepository productRepository;
    private ShopRepository shopRepository;

    public RepositoryFactory(){
        this.cartRepository = new CartRepositoryImpl(new Cart());
        this.productRepository = new ProductRepositoryImpl();
        this.shopRepository = new ShopRepositoryImpl();
    }

    public CartRepository getCartRepository() {
        return cartRepository;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public ShopRepository getShopRepository() {
        return shopRepository;
    }
}
