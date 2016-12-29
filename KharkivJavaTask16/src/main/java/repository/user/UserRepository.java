package repository.user;

import db.query.UserQueries;
import db.transaction.TransactionManager;
import db.transaction.TransactionOperation;
import entity.user.User;
import exceptions.BusinessException;
import org.apache.log4j.Logger;
import repository.CrudRepository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

/**
 * @author Arsalan
 */
public class UserRepository implements CrudRepository<User> {

    private static final Logger log = Logger.getLogger(UserRepository.class);
    private TransactionManager transactionManager;
    private static final long HALF_AN_HOUR = 1000*30*60;

    public UserRepository(DataSource dataSource) {
        this.transactionManager = new TransactionManager(dataSource);
    }

    @Override
    public void create(User user) throws BusinessException {
        String sql = UserQueries.CREATE_USER;
        transactionManager.doInTransaction(new TransactionOperation<Void>() {
            @Override
            public Void doOperation() {
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(sql);

                    statement.setString(1, user.getFirstName());
                    statement.setString(2, user.getLastName());
                    statement.setString(3, user.getEmail());
                    statement.setString(4, user.getPassword());
                    statement.setString(5, user.getMobileNumber());

                    statement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    /**
     * checks if exist user with concrete email
     *
     * @param email - email of user
     * @return true if user with this email exist, else - false
     */
    public boolean checkIfExistUser(String email) {
        String sql = UserQueries.CHECK_IF_EXIST_USER;
        return transactionManager.doWithoutTransaction(new TransactionOperation<Boolean>() {
            @Override
            public Boolean doOperation() {
                boolean result = true;
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(sql);

                    statement.setString(1, email);

                    ResultSet resultSet = statement.executeQuery();
                    if (!resultSet.next()) {
                        result = false;
                    }
                } catch (SQLException e) {
                    log.warn("SQL error during checking if exist user! " + e.getMessage());
                    e.printStackTrace();
                }
                return result;
            }
        });
    }

    /**
     * checks if exist user with concrete email and password
     *
     * @param email    - email of user
     * @param password - password of user
     * @return true if user with this email and password exist, else - false
     */
    public boolean logInUser(String email, String password) {
        String sql = UserQueries.LOG_IN_USER;
        return transactionManager.doWithoutTransaction(new TransactionOperation<Boolean>() {
            @Override
            public Boolean doOperation() {
                boolean result = true;
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(sql);

                    statement.setString(1, email);
                    statement.setString(2, password);

                    ResultSet resultSet = statement.executeQuery();
                    if (!resultSet.next()) {
                        result = false;
                    }
                } catch (SQLException e) {
                    log.warn("SQL error during log in user! " + e.getMessage());
                    e.printStackTrace();
                }
                return result;
            }
        });
    }

    /**
     * gets user by email and password
     *
     * @param email    - email of user
     * @param password - password of user
     * @return user
     */
    public User getUserByEmailAndPassword(String email, String password) {
        String sql = UserQueries.GET_USER_BY_EMAIL_AND_PASSWORD;
        return transactionManager.doWithoutTransaction(new TransactionOperation<User>() {
            @Override
            public User doOperation() {
                User result = null;
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(sql);

                    statement.setString(1, email);
                    statement.setString(2, password);

                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        result = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                                resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7), resultSet.getTime(8), resultSet.getString(9));
                    }
                } catch (SQLException e) {
                    log.warn("SQL error during getting user! " + e.getMessage());
                    e.printStackTrace();
                }
                return result;
            }
        });
    }

    /**
     * increment number of failed login
     * @param email - user' email
     */
    public void incrementUserFailedLogin(String email) {
        String sql = UserQueries.INC_USER_FAILED_LOGIN;
        transactionManager.doWithoutTransaction(new TransactionOperation<Void>() {
            @Override
            public Void doOperation() {
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(sql);

                    statement.setString(1, email);
                    statement.executeUpdate();
                    ban(email);

                } catch (SQLException e) {
                    log.warn("SQL error during getting user! " + e.getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    /**
     * ban the user, if number of failed login more than 4
     * @param email - user's email
     */
    private void ban(String email){
        String sql = UserQueries.BAN;
        transactionManager.doWithoutTransaction(new TransactionOperation<Void>() {
            @Override
            public Void doOperation() {
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(sql);

                    statement.setTime(1, new Time(System.currentTimeMillis() + HALF_AN_HOUR));
                    statement.setString(2, email);
                    statement.executeUpdate();
                    clearUserFailedLogin(email);

                } catch (SQLException e) {
                    log.warn("SQL error during getting user! " + e.getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    /**
     * set number of failed login to 0
     * @param email - user's email
     */
    public void clearUserFailedLogin(String email) {
        String sql = UserQueries.CLEAR_USER_FAILED_LOGIN;
        transactionManager.doWithoutTransaction(new TransactionOperation<Void>() {
            @Override
            public Void doOperation() {
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(sql);

                    statement.setString(1, email);
                    statement.executeUpdate();

                } catch (SQLException e) {
                    log.warn("SQL error during getting user! " + e.getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    /**
     *
     * @param email - user's email
     * @return true, if user banned, else - false
     */
    public boolean checkUserHasBan(String email) {
        String sql = UserQueries.GET_USER_BAN_WILL_BE_REMOVED;
        return transactionManager.doWithoutTransaction(new TransactionOperation<Boolean>() {
            @Override
            public Boolean doOperation() {
                try {
                    PreparedStatement statement = transactionManager.getConnection().prepareStatement(sql);

                    statement.setString(1, email);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        LocalTime banWillBeRemoved = resultSet.getTime(1).toLocalTime();
                        LocalTime currentTime = new Time(System.currentTimeMillis()).toLocalTime();
                        if(banWillBeRemoved.isAfter(currentTime)){
                            return true;
                        }
                    }

                } catch (SQLException e) {
                    log.warn("SQL error during getting user! " + e.getMessage());
                    e.printStackTrace();
                }
                return false;
            }
        });
    }
}
