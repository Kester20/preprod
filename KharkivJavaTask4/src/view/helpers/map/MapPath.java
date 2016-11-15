package view.helpers.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public class MapPath {

    private Map<String, String> mapPath;

    /**
     * initializes  map path
     */
    public MapPath() {
        mapPath = new HashMap<String, String>() {{
            put("laptop", "entity.product.Laptop");
            put("phone", "entity.product.Phone");
            put("smart_phone", "entity.product.SmartPhone");
        }};
    }

    /**
     * @return map path
     */
    public Map<String, String> getMapPath() {
        return mapPath;
    }

}
