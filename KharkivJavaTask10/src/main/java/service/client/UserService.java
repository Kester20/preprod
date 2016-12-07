package service.client;


import entity.user.User;
import org.apache.log4j.Logger;
import repository.UserRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Arsalan
 */
public class UserService {

    private static final Logger log = Logger.getLogger(UserRepository.class);
    private UserRepository userRepository;
    private DataSource dataSource;

    public UserService(DataSource dataSource) {
        this.userRepository = new UserRepository();
        this.dataSource = dataSource;
    }

    public void createUser(User user) {
        try (Connection connection = dataSource.getConnection()) {

            userRepository.createUser(connection, user);

        } catch (SQLException e) {
            log.warn("SQL error during create user! " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean checkIfExistUser(String email) {
        boolean result = true;
        try (Connection connection = dataSource.getConnection()) {

            result = userRepository.checkIfExistUser(connection, email);

        } catch (SQLException e) {
            log.warn("SQL error during check if exist user! " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int getCountOfUsers() {
        return userRepository.getUsers().size();
    }
}
