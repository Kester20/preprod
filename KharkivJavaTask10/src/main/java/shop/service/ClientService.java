package shop.service;


import shop.entity.Client;
import shop.entity.Clients;
import shop.repository.ClientRepository;

/**
 * @author Arsalan
 */
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService() {
        clientRepository = new ClientRepository();
    }

    public boolean checkExistClient(String email){
        return clientRepository.getClients().getUsers().get(email) != null;
    }

    public void createClient(Client client){
        Clients.getUsers().put(client.getEmail(), client);
    }
}
