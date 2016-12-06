package service.client;


import entity.client.Client;
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

    public void createClient(Client client) {
        clientRepository.getUsers().put(client.getEmail(), client);
    }

    public int getCountOfUsers(){
        return clientRepository.getUsers().size();
    }
}
