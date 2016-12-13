package db.sqlbuilder;

import java.util.*;

import static constants.Constants.FIRST_PRICE;
import static constants.Constants.LAPTOPS_COST;
import static constants.Constants.SECOND_PRICE;

/**
 * @author Arsalan
 */
public class CatalogSQLBuilder implements SQLBuilder {

    private String table;
    private Map<String, Object> criteria;

    public CatalogSQLBuilder(String table, Map<String, Object> criteria) {
        this.table = table;
        this.criteria = criteria;
    }

    @Override
    public String getCommand() {
        return "WHERE (";
    }

    @Override
    public String getTable() {
        return table;
    }

    @Override
    public String getWhat() {
        return new StringBuilder().append(setCriteria(criteria)).toString();
    }

    private String setCriteria(Map<String, Object> criteria){
        StringBuilder result = new StringBuilder();
        String column;
        String value;

        Iterator columnIterator = criteria.keySet().iterator();
        while (columnIterator.hasNext()) {

            column = (String) columnIterator.next();

            if(column.equals(FIRST_PRICE)){
                result.append(LAPTOPS_COST + " > " + criteria.get(FIRST_PRICE));
            }else if(column.equals(SECOND_PRICE)){
                result.append(LAPTOPS_COST + " < " + criteria.get(SECOND_PRICE));
            }else{
                List<String> values = (List<String>) criteria.get(column);
                Iterator valuesIterator = values.iterator();
                while (valuesIterator.hasNext()){
                    value = (String) valuesIterator.next();
                    result.append(column + " = ");
                    result.append("'" + value + "'");
                    if(valuesIterator.hasNext()){
                        result.append(" OR ");
                    }
                }
            }



            result.append(")");

            if (columnIterator.hasNext()) {
                result.append(" AND (");
            }
        }
        return result.toString();
    }
}
