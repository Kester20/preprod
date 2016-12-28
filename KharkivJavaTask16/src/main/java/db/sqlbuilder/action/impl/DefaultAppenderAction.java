package db.sqlbuilder.action.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static constants.Constants.OR_SQL;

/**
 * @author Arsalan
 */
public class DefaultAppenderAction extends AbstractAction {

    private Map<String, Object> criteria;
    private String columnName;

    public DefaultAppenderAction(StringBuilder appender, Map<String, Object> criteria, String columnName) {
        super(appender);
        this.criteria = criteria;
        this.columnName = columnName;
    }

    @Override
    public void execute() {
        List<String> values = (List<String>) criteria.get(columnName);
        Iterator valuesIterator = values.iterator();
        while (valuesIterator.hasNext()) {
            valuesIterator.next();
            appender.append(columnName + " = ? ");
            if (valuesIterator.hasNext()) {
                appender.append(OR_SQL);
            }
        }
    }
}
