package entity.order;

import entity.laptop.Laptop;

import java.util.Collections;
import java.util.Map;

/**
 * @author Arsalan
 */
public final class Order {

    private final String userEmail;
    private final String typePayment;
    private final String card;
    private final Map<Laptop, Integer> products;

    public Order(String userEmail, String typePayment, String card, Map<Laptop, Integer> products) {
        this.userEmail = userEmail;
        this.typePayment = typePayment;
        this.card = card;
        this.products = products;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getTypePayment() {
        return typePayment;
    }

    public String getCard() {
        return card;
    }

    public Map<Laptop, Integer> getProducts() {
        return Collections.unmodifiableMap(products);
    }
}
