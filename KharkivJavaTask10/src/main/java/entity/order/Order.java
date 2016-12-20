package entity.order;

import entity.laptop.Laptop;

import java.util.Map;

/**
 * @author Arsalan
 */
public class Order {

    private String  userEmail;
    private String typePayment;
    private String card;
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
        return products;
    }
}
