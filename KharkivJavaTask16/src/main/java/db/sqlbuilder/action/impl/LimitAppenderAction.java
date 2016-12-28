package db.sqlbuilder.action.impl;

import java.util.Map;

import static constants.Constants.*;

/**
 * Created by Said_Sulaiman_Arsala on 12/19/2016.
 */
public class LimitAppenderAction extends AbstractAction {

    private Map<String, Object> criteria;

    public LimitAppenderAction(StringBuilder appender, Map<String, Object> criteria) {
        super(appender);
        this.criteria = criteria;
    }

    @Override
    public void execute() {
        int skip = ((int) criteria.get(PAGE) - 1) * (int) criteria.get(LIMIT);
        appender.replace(appender.lastIndexOf(AND_SQL), appender.length(), LIMIT_SQL + skip + ", " + criteria.get(LIMIT));
    }
}
