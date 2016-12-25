package db.sqlbuilder.impl;

import db.sqlbuilder.SQLBuilder;
import db.sqlbuilder.action.map.ActionMap;

import java.util.Iterator;
import java.util.Map;

import static constants.Constants.AND_SQL;

/**
 * @author Arsalan
 */
public class CatalogSQLBuilder implements SQLBuilder {

    private String table;
    private String command;
    private Map<String, Object> criteria;
    private ActionMap actionMap;

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
        actionMap = new ActionMap(result, criteria);
        String column;

        result.append("(");

        Iterator columnIterator = criteria.keySet().iterator();
        while (columnIterator.hasNext()) {
            column = (String) columnIterator.next();

            appendValues(column);

            if (columnIterator.hasNext()) {
                result.append(AND_SQL);
            }
        }
        return result.toString();
    }

    private void appendValues(String column) {
        actionMap.getActionMap().get(column).execute();
    }
}
