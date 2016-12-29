package service.security.impl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static constants.Constants.*;

/**
 * @author Arsalan
 */
public class UserIsInSystemChecker extends AbstractChecker {

    public UserIsInSystemChecker(String path) {
        super(path);
    }

    @Override
    public void check(HttpServletRequest request, HttpServletResponse response, FilterChain chain, String page) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute(USER) == null) {
            session.setAttribute(REDIRECT_PAGE, request.getRequestURI().toString());
            request.getRequestDispatcher(ACCOUNT_JSP).forward(request, response);
        } else {
            nextChecker.check(request, response, chain, page);
        }
    }
}
