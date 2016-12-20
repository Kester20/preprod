package filter;


import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static constants.Constants.*;

/**
 * @author Arsalan
 */

public class LoginFilter implements Filter{

    private static final Logger log = Logger.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

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
        log.info(request.getRequestURL());
        log.info(request.getRequestURI());
        if(session.getAttribute(USER) == null){
            session.setAttribute(USER_HAS_PAGE, request.getRequestURI().toString());
            RequestDispatcher dispatcher = request.getRequestDispatcher(ACCOUNT_JSP);
            dispatcher.forward(request, response);
        }else{
            chain.doFilter(request, response);
        }
    }
}
