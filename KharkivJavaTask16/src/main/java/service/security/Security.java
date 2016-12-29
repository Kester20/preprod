package service.security;

import entity.user.User;
import org.apache.log4j.Logger;
import util.parser.impl.XMLDomParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static constants.Constants.USER;

/**
 * @author Arsalan
 */
public class Security {

    private static final Logger log = Logger.getLogger(Security.class);
    private Map<String, List> security;

    public Security(String path) {
        try {
            security = new XMLDomParser(path).parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkAccess(HttpServletRequest request, HttpServletResponse response, String userWantToGoPage) {
        return false;
    }

    public boolean checkIfPageIsInSecureList(String userWantToGoPage) {
        for (String url : security.keySet()) {
            if(userWantToGoPage.contains(url)){
                return true;
            }
        }
        return false;
    }

    public boolean checkIfUserIsInSystem(HttpServletRequest request) {
        return request.getSession().getAttribute(USER) != null;
    }

    public boolean checkRole(HttpServletRequest request, String userWantToGoPage){
        User user = (User) request.getSession().getAttribute(USER);
        for (String url: security.keySet()) {
            if(userWantToGoPage.contains(url)){
                List<String> roles = security.get(url);
                return roles.contains(user.getRole());
            }
        }
        return false;
    }

    public Map<String, List> getSecurity() {
        return security;
    }
}
