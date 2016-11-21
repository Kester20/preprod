package handler;

/**
 * @author Arsalan
 */
public interface RequestHandler {

    /**
     * gets count of products in shop
     */
    public String getCountOfProducts();

    /**
     * gets item
     * @param id - id of item
     * @return item
     */
    public String getItemById(int id);
}
