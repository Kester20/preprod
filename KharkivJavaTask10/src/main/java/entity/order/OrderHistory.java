package entity.order;

/**
 * @author Arsalan
 */
public final class OrderHistory {

    private final Order order;

    public OrderHistory(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
