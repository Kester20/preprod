package repository;

import entity.user.User;
import org.apache.log4j.Logger;
import repository.query.UserQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author Arsalan
 */
public class UserRepository {

    private static final Logger log = Logger.getLogger(UserRepository.class);

    public UserRepository() {

    }

    public void createUser(Connection connection, User user) {
        String sql = UserQueries.CREATE_USER;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

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

    public boolean checkIfExistUser(Connection connection, String email){
        boolean result = true;
        String sql = UserQueries.CHECK_IF_EXIST_USER;
        try(PreparedStatement statement = connection.prepareStatement(sql)) {

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

    public Map<String, User> getUsers() {
        return null;
    }
}
