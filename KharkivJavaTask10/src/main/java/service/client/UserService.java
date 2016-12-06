package service.client;


import entity.user.User;
import repository.ClientRepository;

/**
 * @author Arsalan
 */
public class UserService {

    private ClientRepository clientRepository;

    public UserService() {
        clientRepository = new ClientRepository();
    }

    public boolean checkExistClient(String email) {
        return clientRepository.getUsers().get(email) != null;
    }

    public void createClient(User user) {
        clientRepository.getUsers().put(user.getEmail(), user);
    }

    public int getCountOfUsers(){
        return clientRepository.getUsers().size();
    }
}
