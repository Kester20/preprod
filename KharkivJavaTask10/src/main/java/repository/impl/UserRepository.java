package repository.impl;

import db.transaction.TransactionManager;
import entity.user.User;
import org.apache.log4j.Logger;
import repository.CrudRepository;
import db.query.UserQueries;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Arsalan
 */
public class UserRepository implements CrudRepository<User> {

    private static final Logger log = Logger.getLogger(UserRepository.class);
    private TransactionManager transactionManager;
    private DataSource dataSource;

    public UserRepository(DataSource dataSource) {
        transactionManager = new TransactionManager(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public void create(User user) {
        String sql = UserQueries.CREATE_USER;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getMobileNumber());

            statement.execute();

        } catch (SQLException e) {
            log.warn("SQL error during create user! " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public User get(String criteria) {
        return null;
    }

    @Override
    public void update(User object) {

    }

    @Override
    public void delete(User object) {

    }

    public boolean checkIfExistUser(String email){
        boolean result = true;
        String sql = UserQueries.CHECK_IF_EXIST_USER;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            ResultSet resultSet  = statement.executeQuery();
            if(!resultSet.next()){
                result = false;
            }

        }catch (SQLException e){
            log.warn("SQL error during check if exist user! " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public boolean logInUser(String email, String password) {
        boolean result = true;
        String sql = UserQueries.LOG_IN_USER;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet  = statement.executeQuery();
            if(!resultSet.next()){
                result = false;
            }

        }catch (SQLException e){
            log.warn("SQL error during check if exist user! " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public String getUserNameByEmail(String email) {
        String result = "";
        String sql = UserQueries.GET_USER_NAME_BY_EMAIL;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            ResultSet resultSet  = statement.executeQuery();
            if(resultSet.next()){
                result = resultSet.getString(1);
            }

        }catch (SQLException e){
            log.warn("SQL error during check if exist user! " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
