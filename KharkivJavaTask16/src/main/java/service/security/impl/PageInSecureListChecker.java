package service.security.impl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Arsalan
 */
public class PageInSecureListChecker extends AbstractChecker {

    public PageInSecureListChecker(String path) {
        super(path);
    }

    @Override
    public void check(HttpServletRequest request, HttpServletResponse response, FilterChain chain, String page) throws IOException, ServletException {
        for (String url : security.getSecurity().keySet()) {
            if (page.matches(url)) {
                nextChecker.check(request, response, chain, page);
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
