package repository.order;

import db.query.OrderQueries;
import db.transaction.TransactionManager;
import db.transaction.TransactionOperation;
import entity.laptop.Laptop;
import entity.order.Order;
import entity.order.OrderHistory;
import exceptions.BusinessException;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * @author Arsalan
 */
public class OrderRepository {

    private static final Logger log = Logger.getLogger(OrderRepository.class);
    private TransactionManager transactionManager;
    private int lastOrderId;

    public OrderRepository(DataSource dataSource) {
        this.transactionManager = new TransactionManager(dataSource);
    }

    public void createOrder(Order order) throws BusinessException {
        OrderHistory orderHistory = new OrderHistory(order);
        transactionManager.doInTransaction(new TransactionOperation<Void>() {
            @Override
            public Void doOperation() {
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(OrderQueries.CREATE_ORDER, Statement.RETURN_GENERATED_KEYS);

                    statement.setString(1, order.getUserEmail());
                    statement.setString(2, order.getTypePayment());
                    statement.setString(3, order.getCard());
                    statement.executeUpdate();
                    ResultSet resultSet = statement.getGeneratedKeys();

                    if (resultSet.next()) {
                        lastOrderId = resultSet.getInt(1);
                        createOrderHistory(lastOrderId, orderHistory);
                    }

                } catch (SQLException | BusinessException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    private void createOrderHistory(int orderId, OrderHistory orderHistory) throws BusinessException {
        try {
            PreparedStatement statement = transactionManager.getConnection().prepareStatement(OrderQueries.CREATE_ORDER_HISTORY);

            setUpBatchStatement(statement, orderHistory, orderId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setUpBatchStatement(PreparedStatement statement, OrderHistory orderHistory, int orderId) throws SQLException {
        Order order = orderHistory.getOrder();
        Map<Laptop, Integer> products = order.getProducts();

        for (Laptop laptop : products.keySet()) {
            statement.setInt(1, orderId);
            statement.setInt(2, laptop.getId());
            statement.setInt(3, orderHistory.getOrder().getProducts().get(laptop));
            statement.addBatch();
        }
        statement.executeBatch();
    }

    public int getLastOrderId() {
        return lastOrderId;
    }
}
