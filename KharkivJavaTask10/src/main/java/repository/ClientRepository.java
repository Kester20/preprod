package repository;

import entity.user.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public class ClientRepository {

    private Map<String, User> users;

    public ClientRepository() {
        users = new HashMap<String, User>() {{
            put("steve.s.@gmail.com", new User("Steve", "S", "steve.s.@gmail.com", "00", "00"));
            put("bob.b.@gmail.com", new User("Bob", "B", "bob.b.@gmail.com", "00", "00"));
            put("alan.a.@gmail.com", new User("Alan", "A", "alan.a.@gmail.com", "00", "00"));
        }};
    }

    public Map<String, User> getUsers() {
        return users;
    }
}
