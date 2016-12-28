package service.user;


import entity.user.User;
import exceptions.BusinessException;
import org.apache.log4j.Logger;
import repository.factory.RepositoryFactory;
import repository.user.UserRepository;

/**
 * @author Arsalan
 */
public class DefaultUserService implements UserService {

    private static final Logger log = Logger.getLogger(DefaultUserService.class);
    private UserRepository userRepository;

    public DefaultUserService(RepositoryFactory factory) {
        this.userRepository = factory.getUserRepository();
    }

    @Override
    public void createUser(User user) throws BusinessException {
        userRepository.create(user);
    }

    @Override
    public boolean checkIfExistUser(String email) {
        return userRepository.checkIfExistUser(email);
    }

    @Override
    public boolean logInUser(String email, String password) {
        return userRepository.logInUser(email, password);
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.getUserByEmailAndPassword(email, password);
    }

    @Override
    public void incrementUserFailedLogin(String email){
        userRepository.incrementUserFailedLogin(email);
    }

    @Override
    public void clearUserFailedLogin(String email){
        userRepository.clearUserFailedLogin(email);
    }

    @Override
    public boolean checkUserHasBan(String email){
        return userRepository.checkUserHasBan(email);
    }

}
