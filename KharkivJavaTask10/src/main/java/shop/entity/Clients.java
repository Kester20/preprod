package shop.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public class Clients {

    private Map<Integer, String> users;

    public Clients() {
        users = new HashMap<Integer, String>() {{
            put(1, "Steve");
            put(2, "Bob");
            put(3, "Alan");
        }};
    }

    public Map<Integer, String> getUsers() {
        return users;
    }
}
