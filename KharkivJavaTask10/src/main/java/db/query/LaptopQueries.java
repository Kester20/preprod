package db.query;

/**
 * @author Arsalan
 */
public class LaptopQueries {

    public static final String GET_ALL_LAPTOPS = "SELECT laptop.id,producer.name AS 'producer',laptop.model, laptop.cost, laptop.image, category.name AS 'category' \n" +
            "FROM `laptop` JOIN producer JOIN category ON laptop.producer = producer.id AND laptop.category = category.id ";
    public static final String GET_BY_PRODUCER = "SELECT laptop.id,producer.name AS 'producer',laptop.model, laptop.cost, laptop.image, laptop.category" +
            " FROM `laptop` JOIN producer ON laptop.producer = producer.id WHERE laptop.producer = (SELECT producer.id FROM producer WHERE producer.name=?)";

    public static final String GET_ALL_PRODUCERS = "SELECT * FROM producer";
    public static final String GET_ALL_CATEGORIES = "SELECT * FROM category";

}
