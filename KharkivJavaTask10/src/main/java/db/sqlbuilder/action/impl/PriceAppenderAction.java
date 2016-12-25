package db.sqlbuilder.action.impl;

import static constants.Constants.LAPTOPS_COST;

/**
 * @author Arsalan
 */
public class PriceAppenderAction extends AbstractAction {

    private String comparison;

    public PriceAppenderAction(StringBuilder appender, String comparison) {
        super(appender);
        this.comparison = comparison;
    }

    @Override
    public void execute() {
        appender.append(LAPTOPS_COST + comparison + " ? ");
    }
}
