package db.sqlbuilder.action.impl;

import db.sqlbuilder.action.Action;

/**
 * @author Arsalan
 */
public abstract class AbstractAction implements Action {

    protected StringBuilder appender;

    public AbstractAction(StringBuilder appender) {
        this.appender = appender;
    }

    @Override
    public void execute() {

    }
}
