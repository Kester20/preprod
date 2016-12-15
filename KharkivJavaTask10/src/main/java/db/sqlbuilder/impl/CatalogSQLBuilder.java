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
    private Map<String, Object> criteria;
    private static final int SIX_SYMBOLS = 6;
    private static final int SEVEN_SYMBOLS = 7;

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

        Iterator columnIterator = criteria.keySet().iterator();
        while (columnIterator.hasNext()) {
            column = (String) columnIterator.next();
            appendValues(result, column);

            if (columnIterator.hasNext()) {
                result.append(") AND (");
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
                        stringBuilder.append(" OR ");
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
                stringBuilder.replace(stringBuilder.length() - SIX_SYMBOLS, stringBuilder.length(), "ORDER BY " + criteria.get(column));
                break;
            }
            case LIMIT: {
                int skip = ((int)criteria.get(PAGE) - 1)*(int)criteria.get(LIMIT);
                stringBuilder.replace(stringBuilder.length() - SEVEN_SYMBOLS, stringBuilder.length(), " LIMIT " + skip + ", " + criteria.get(LIMIT));
                break;
            }
            case PAGE:{
                stringBuilder.delete(stringBuilder.length() - SEVEN_SYMBOLS, stringBuilder.length());
                break;
            }
        }
    }
}
