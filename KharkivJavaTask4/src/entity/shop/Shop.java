package entity.shop;

import utility.ListOrders;

/**
 * Created by Said_Sulaiman_Arsala on 11/4/2016.
 * Entity shop
 */
public class Shop {

    private ListOrders listOrders;

    public Shop() {
        this.listOrders = new ListOrders();
    }

    /**
     *
     * @return list of orders
     */
    public ListOrders getListOrders() {
        return listOrders;
    }
}
