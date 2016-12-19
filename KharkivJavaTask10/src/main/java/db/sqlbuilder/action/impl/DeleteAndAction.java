package db.sqlbuilder.action.impl;

import static constants.Constants.AND_SQL;

/**
 * Created by Said_Sulaiman_Arsala on 12/19/2016.
 */
public class DeleteAndAction extends AbstractAction {

    public DeleteAndAction(StringBuilder appender) {
        super(appender);
    }

    @Override
    public void execute() {
        appender.delete(appender.lastIndexOf(AND_SQL), appender.length());
    }
}
