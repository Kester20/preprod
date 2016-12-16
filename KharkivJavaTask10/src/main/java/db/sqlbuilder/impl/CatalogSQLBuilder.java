package db.sqlbuilder.impl;

import db.sqlbuilder.SQLBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static constants.Constants.*;

/**
 * @author Arsalan
 */
public class CatalogSQLBuilder implements SQLBuilder {

    private String table;
    private String command;
    private Map<String, Object> criteria;

    public CatalogSQLBuilder(String table, String command, Map<String, Object> criteria) {
        this.table = table;
        this.command = command;
        this.criteria = criteria;
    }

    @Override
    public String getTable() {
        return table;
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getWhat() {
        return new StringBuilder().append(setCriteria()).toString();
    }

    /**
     * generate sql query by criteria map
     *
     * @return sql query
     */
    private String setCriteria() {
        StringBuilder result = new StringBuilder();
        String column;

        result.append("(");
        Iterator columnIterator = criteria.keySet().iterator();
        while (columnIterator.hasNext()) {
            column = (String) columnIterator.next();
            appendValues(result, column);

            if (columnIterator.hasNext()) {
                result.append(AND_SQL);
            }
        }
        return result.toString();
    }

    private void appendValues(StringBuilder stringBuilder, String column) {
        switch (column) {
            default: {
                List<String> values = (List<String>) criteria.get(column);
                Iterator valuesIterator = values.iterator();
                while (valuesIterator.hasNext()) {
                    valuesIterator.next();
                    stringBuilder.append(column + " = ? ");
                    if (valuesIterator.hasNext()) {
                        stringBuilder.append(OR_SQL);
                    }
                }
                break;
            }
            case FIRST_PRICE: {
                stringBuilder.append(LAPTOPS_COST + " > " + " ? ");
                break;
            }
            case SECOND_PRICE: {
                stringBuilder.append(LAPTOPS_COST + " < " + " ? ");
                break;
            }
            case ORDER_BY: {
                String mode = criteria.containsValue(ASC) ? ASC : DESC;
                stringBuilder.replace(stringBuilder.lastIndexOf(SIMPLE_AND_SQL), stringBuilder.length(), ORDER_BY_SQL + criteria.get(column) + mode);
                break;
            }
            case LIMIT: {
                int skip = ((int)criteria.get(PAGE) - 1)*(int)criteria.get(LIMIT);
                stringBuilder.replace(stringBuilder.lastIndexOf(AND_SQL), stringBuilder.length(), LIMIT_SQL + skip + ", " + criteria.get(LIMIT));
                break;
            }
            case PAGE:{
                stringBuilder.delete(stringBuilder.lastIndexOf(AND_SQL), stringBuilder.length());
                break;
            }
            case ORDER_MODE:{
                stringBuilder.delete(stringBuilder.lastIndexOf(AND_SQL), stringBuilder.length());
                break;
            }
        }
    }
}
