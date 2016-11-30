package shop.service;


import shop.repository.ClientRepository;

/**
 * @author Arsalan
 */
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService() {
        clientRepository = new ClientRepository();
    }

    public boolean checkExistclient(int id){
        return clientRepository.getClients().getUsers().get(id) != null;
    }
}
