package db.query;

/**
 * @author Arsalan
 */
public class UserQueries {

    public static final String CREATE_USER = "INSERT INTO users (firstName, lastName, email, password, mobileNumber)" +
            "  VALUES ( ?, ?, ?, ?, ?);";
    public static final String CHECK_IF_EXIST_USER = "SELECT email FROM users WHERE email = ?";
    public static final String LOG_IN_USER = "SELECT email, password FROM users WHERE email = ? AND password = ?";
    public static final String GET_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM users WHERE email = ? AND password = ?";

}
