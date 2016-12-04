package repository;

import entity.client.Client;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public class ClientRepository {

    private Map<String, Client> users;

    public ClientRepository() {
        users = new HashMap<String, Client>() {{
            put("steve.s.@gmail.com", new Client("Steve", "S", "steve.s.@gmail.com", "00", "00"));
            put("bob.b.@gmail.com", new Client("Bob", "B", "bob.b.@gmail.com", "00", "00"));
            put("alan.a.@gmail.com", new Client("Alan", "A", "alan.a.@gmail.com", "00", "00"));
        }};
    }

    public Map<String, Client> getUsers() {
        return users;
    }
}
