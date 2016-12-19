package db.sqlbuilder.action.map;

import db.sqlbuilder.action.Action;
import db.sqlbuilder.action.impl.*;

import java.util.HashMap;
import java.util.Map;

import static constants.Constants.*;

/**
 * @author Arsalan
 */
public class ActionMap {

    private Map<String, Action> actionMap;

    public ActionMap(StringBuilder appender, Map<String, Object> criteria) {
        actionMap = new HashMap<String, Action>() {{
            put(LAPTOPS_PRODUCER, new DefaultAppenderAction(appender, criteria, LAPTOPS_PRODUCER));
            put(LAPTOPS_CATEGORY, new DefaultAppenderAction(appender, criteria, LAPTOPS_CATEGORY));
            put(FIRST_PRICE, new PriceAppenderAction(appender, " > "));
            put(SECOND_PRICE, new PriceAppenderAction(appender, " < "));
            put(ORDER_BY, new OrderByAppenderAction(appender, criteria));
            put(LIMIT, new LimitAppenderAction(appender, criteria));
            put(PAGE, new DeleteAndAction(appender));
            put(ORDER_MODE, new DeleteAndAction(appender));
        }};
    }

    public Map<String, Action> getActionMap() {
        return actionMap;
    }
}
