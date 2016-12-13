package db;

/**
 * @author Arsalan
 */
public class CatalogSqlBuilder {

    private String[] producers;
    private String[] categories;
    private StringBuilder query;

    public CatalogSqlBuilder(String[] producers, String[] categories) {
        this.producers = producers;
        this.categories = categories;
        this.query = new StringBuilder();
    }

    public void buildQuery(){
        query.append("SELECT laptop.id,producer.name AS 'producer',laptop.model, laptop.cost, laptop.image, category.name AS 'category' \n" +
                "            FROM `laptop` JOIN producer JOIN category ON laptop.producer = producer.id AND laptop.category = category.id ");
        if(producers != null && categories != null){
            query.append("WHERE (");
            if(producers != null){
                for (String producer : producers) {
                    query.append(" producer.name = '" + producer + "' OR ");
                }
                query.append(")");
            }

        }


    }

    public String[] getProducers() {
        return producers;
    }

    public String[] getCategories() {
        return categories;
    }

    public String getQuery() {
        return query.toString();
    }
}
