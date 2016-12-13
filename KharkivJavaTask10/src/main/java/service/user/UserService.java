package service.user;

import entity.user.User;
import exceptions.BusinessException;

/**
 * @author Arsalan
 */
public interface UserService {

    void createUser(User user) throws BusinessException;

    boolean checkIfExistUser(String email);

    boolean logInUser(String email, String password);

    User getUserByEmailAndPassword(String email, String password);
}
