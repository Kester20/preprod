package service.client;


import entity.client.Client;
import repository.ClientRepository;

/**
 * @author Arsalan
 */
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService() {
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
