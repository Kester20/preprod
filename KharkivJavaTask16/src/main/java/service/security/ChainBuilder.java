package service.security;

import service.security.impl.AbstractChecker;
import service.security.impl.PageInSecureListChecker;
import service.security.impl.RoleChecker;
import service.security.impl.UserIsInSystemChecker;

/**
 * @author Arsalan
 */
public class ChainBuilder {

    private AbstractChecker pageChecker;
    private AbstractChecker userChecker;
    private AbstractChecker roleChecker;

    public ChainBuilder(String path) {
        pageChecker = new PageInSecureListChecker(path);
        userChecker = new UserIsInSystemChecker(path);
        roleChecker = new RoleChecker(path);
        buildChain();
    }

    private void buildChain(){
        pageChecker.setNextChecker(userChecker);
        userChecker.setNextChecker(roleChecker);
    }

    public AbstractChecker getHeadOfChain() {
        return pageChecker;
    }
}
