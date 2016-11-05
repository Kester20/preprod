package utility;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Said_Sulaiman_Arsala on 11/4/2016.
 * List of orders
 */
public class ListOrders {

    private TreeMap<Date, Map> storageOrders;

    public ListOrders() {
        storageOrders = new TreeMap<>();
    }

    /**
     * @return storage of orders
     */
    public TreeMap<Date, Map> getStorageOrders() {
        return storageOrders;
    }
}
