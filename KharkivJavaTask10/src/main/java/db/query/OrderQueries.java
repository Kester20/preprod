package db.query;

/**
 * @author Arsalan
 */
public class OrderQueries {

    public static final String CREATE_ORDER = "INSERT INTO `order` (`user_email`, `type_payment`, `card`) VALUES (?, ?, ?)";
    public static final String CREATE_ORDER_HISTORY = "INSERT INTO `order_laptop` (`order_id`, `laptop_id`, `number_of_laptops`)" +
            " VALUES (?, ?, ?);";

}
