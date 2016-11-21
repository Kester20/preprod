package net;

import handler.impl.Handler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public class RequestMap {

    private Map<String, String> requestMap;

    /**
     * initializes  map
     */
    public RequestMap(Handler handler) {
        requestMap = new HashMap<String, String>() {{
            put("get count", handler.getCountOfProducts());
            //put("get item", handler.getItemById());
        }};
    }

    public Map<String, String> getRequestMap() {
        return requestMap;
    }
}
