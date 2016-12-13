package service.user;


import entity.user.User;
import exceptions.BusinessException;
import org.apache.log4j.Logger;
import repository.user.UserRepository;

/**
 * @author Arsalan
 */
public class DefaultUserService implements UserService {

    private static final Logger log = Logger.getLogger(DefaultUserService.class);
    private UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) throws BusinessException {
        userRepository.create(user);
    }

    public boolean checkIfExistUser(String email) {
        return userRepository.checkIfExistUser(email);
    }

    public boolean logInUser(String email, String password) {
        return userRepository.logInUser(email, password);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.getUserByEmailAndPassword(email, password);
    }
}
