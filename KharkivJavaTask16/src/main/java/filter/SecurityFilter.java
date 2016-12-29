package filter;


import service.security.ChainBuilder;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constants.Constants.PATH;

/**
 * @author Arsalan
 */

public class SecurityFilter implements Filter {

    private static final Logger log = Logger.getLogger(SecurityFilter.class);
    private ChainBuilder chainBuilder;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        chainBuilder = new ChainBuilder(filterConfig.getInitParameter(PATH));
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        checkAccess(request, response, chain);
    }

    @Override
    public void destroy() {

    }

    private void checkAccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        chainBuilder.getHeadOfChain().check(request, response, chain, request.getRequestURI().toString());
    }
}
