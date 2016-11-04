package services.impl;

import entity.product.Product;
import entity.shop.Cart;
import repository.CartRepository;
import repository.impl.CartRepositoryImpl;
import services.CartService;
import services.ProductService;
import utility.LinkedHashMapForFiveLastElements;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Arsal on 03.11.2016.
 * template service for shop cart
 */
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;
    private ProductService productService;
    private LinkedHashMap linkedHashMap;

    public CartServiceImpl() {
        this.cartRepository = new CartRepositoryImpl(new Cart());
        this.productService = new ProductServiceImpl();
        this.linkedHashMap = new LinkedHashMapForFiveLastElements();
    }


    @Override
    public void addProductToCart(Product product) {
        if (cartRepository.getCart().getContainer().containsKey(product.getId())) {
            int numberOfProduct = cartRepository.getCart().getContainer().get(product.getId());
            cartRepository.addProductToCart(product.getId(), ++numberOfProduct);
        } else {
            cartRepository.addProductToCart(product.getId(), 1);
        }
    }

    @Override
    public String printProductsInCart() {
        StringBuilder sb = new StringBuilder();
        Iterator iterator = cartRepository.getCart().getContainer().keySet().iterator();
        while (iterator.hasNext()) {
            int id = (Integer) iterator.next();
            sb.append(productService.getProductById(id) + ", number: " + cartRepository.getCart().getContainer().get(id) + "\n");
        }
        return sb.toString();
    }

    @Override
    public double getAmountOfProductsInCart() {
        double amount = 0;
        Iterator iterator = cartRepository.getCart().getContainer().keySet().iterator();
        while (iterator.hasNext()) {
            int id = (int) iterator.next();
            int sum = (int) (productService.getProductById(id).getCost() * cartRepository.getCart().getContainer().get(id));
            amount += sum;
        }
        return amount;
    }

    @Override
    public Map getLastFiveProducts() {
        Map map = cartRepository.getCart().getContainer();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int id = (int) iterator.next();
            linkedHashMap.put(id, productService.getProductById(id));
        }
        return linkedHashMap;
    }

    @Override
    public CartRepository getCartRepository() {
        return cartRepository;
    }
}
