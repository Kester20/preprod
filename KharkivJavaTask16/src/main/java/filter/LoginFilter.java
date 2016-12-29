package filter;


import org.apache.log4j.Logger;
import service.security.Security;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constants.Constants.*;

/**
 * @author Arsalan
 */

public class LoginFilter implements Filter {

    private static final Logger log = Logger.getLogger(LoginFilter.class);
    private Security security;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        security = new Security(filterConfig.getInitParameter("path"));
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        checkAccess(session, request, response, chain);
    }

    @Override
    public void destroy() {

    }

    private void checkAccess(HttpSession session, HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        if(!security.checkIfPageIsInSecureList(request.getRequestURI().toString())){
            chain.doFilter(request, response);
        }else{
            if(!security.checkIfUserIsInSystem(request)){
                session.setAttribute(REDIRECT_PAGE, request.getRequestURI().toString());
                RequestDispatcher dispatcher = request.getRequestDispatcher(ACCOUNT_JSP);
                dispatcher.forward(request, response);
            }else {
                if(security.checkRole(request, request.getRequestURI().toString())){
                    chain.doFilter(request, response);
                }else{
                    response.sendError(403, ACCESS_DENIED);
                }
            }
        }
    }
}
