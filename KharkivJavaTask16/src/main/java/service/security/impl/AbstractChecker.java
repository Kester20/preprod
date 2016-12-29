package service.security.impl;

import service.security.Checker;
import service.security.Security;

/**
 * @author Arsalan
 */
public abstract class AbstractChecker implements Checker {

    protected AbstractChecker nextChecker;
    protected Security security;

    public AbstractChecker(String path) {
        security = new Security(path);
    }

    public void setNextChecker(AbstractChecker nextChecker) {
        this.nextChecker = nextChecker;
    }

    public Security getSecurity() {
        return security;
    }
}
