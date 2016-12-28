package db.sqlbuilder.action.impl;

import java.util.Map;

import static constants.Constants.*;

/**
 * Created by Said_Sulaiman_Arsala on 12/19/2016.
 */
public class OrderByAppenderAction extends AbstractAction {

    private Map<String, Object> criteria;

    public OrderByAppenderAction(StringBuilder appender, Map<String, Object> criteria) {
        super(appender);
        this.criteria = criteria;
    }

    @Override
    public void execute() {
        String mode = criteria.containsValue(ASC) ? ASC : DESC;
        appender.replace(appender.lastIndexOf(SIMPLE_AND_SQL), appender.length(), ORDER_BY_SQL + criteria.get(ORDER_BY) + mode);
    }
}
