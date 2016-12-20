package service.order;

import entity.order.Order;
import entity.order.OrderHistory;
import exceptions.BusinessException;

/**
 * @author Arsalan
 */
public interface OrderService {
    void createOrder(Order order) throws BusinessException;

    int getLastOrderId();
}
