package service.client;


import entity.user.User;
import org.apache.log4j.Logger;
import repository.impl.UserRepository;

/**
 * @author Arsalan
 */
public class UserService {

    private static final Logger log = Logger.getLogger(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.create(user);
    }

    public boolean checkIfExistUser(String email) {
        return userRepository.checkIfExistUser(email);
    }

    public boolean logInUser(String email, String password){
        return userRepository.logInUser(email, password);
    }

    public String getUserNameByEmail(String email){
        return userRepository.getUserNameByEmail(email);
    }
}
