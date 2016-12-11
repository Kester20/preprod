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

/**
 * @author Arsalan
 */
public class UserRepository implements CrudRepository<User> {

    private static final Logger log = Logger.getLogger(UserRepository.class);
    private TransactionManager transactionManager;

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
                        result = new User(resultSet.getString(2), resultSet.getString(2), resultSet.getString(3),
                                resultSet.getString(4), resultSet.getString(5));
                    }
                } catch (SQLException e) {
                    log.warn("SQL error during getting user! " + e.getMessage());
                    e.printStackTrace();
                }
                return result;
            }
        });
    }

    @Override
    public User get(String criteria) throws BusinessException {
        return null;
    }

    @Override
    public void update(User object) throws BusinessException {
    }

    @Override
    public void delete(User object) throws BusinessException {
    }
}
