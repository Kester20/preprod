package shop.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public class Clients {

    private static Map<String, Client> users;

    public Clients() {
        users = new HashMap<String, Client>() {{
            put("steve.s.@gmail.com", new Client("Steve", "S", "steve.s.@gmail.com", "00", "00"));
            put("bob.b.@gmail.com", new Client("Bob", "B", "bob.b.@gmail.com", "00", "00"));
            put("alan.a.@gmail.com", new Client("Alan", "A", "alan.a.@gmail.com", "00", "00"));
        }};
    }

    public static Map<String, Client> getUsers() {
        return users;
    }
}
