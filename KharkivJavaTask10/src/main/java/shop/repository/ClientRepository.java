package shop.repository;

import shop.entity.Clients;

/**
 * @author Arsalan
 */
public class ClientRepository {

    private Clients clients;

    public ClientRepository() {
        this.clients = new Clients();
    }

    public Clients getClients() {
        return clients;
    }
}
