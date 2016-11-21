package shop.repository.factory;

import shop.entity.shop.Cart;
import shop.repository.CartRepository;
import shop.repository.ProductRepository;
import shop.repository.ShopRepository;
import shop.repository.impl.CartRepositoryImpl;
import shop.repository.impl.ProductRepositoryImpl;
import shop.repository.impl.ShopRepositoryImpl;

/**
 * @author Arsalan
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
