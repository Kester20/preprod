package service.security.impl;

import entity.user.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static constants.Constants.ACCESS_DENIED;
import static constants.Constants.CODE_ERROR_403;
import static constants.Constants.USER;

/**
 * @author Arsalan
 */
public class RoleChecker extends AbstractChecker {

    public RoleChecker(String path) {
        super(path);
    }

    @Override
    public void check(HttpServletRequest request, HttpServletResponse response, FilterChain chain, String page) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute(USER);
        for (String url : security.getSecurity().keySet()) {
            if (page.matches(url)) {
                List<String> roles = security.getSecurity().get(url);
                if (roles.contains(user.getRole())) {
                    chain.doFilter(request, response);
                    return;
                }
            }
        }
        response.sendError(CODE_ERROR_403, ACCESS_DENIED);
    }
}
