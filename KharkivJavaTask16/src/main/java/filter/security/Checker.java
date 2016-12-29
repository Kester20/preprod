package filter.security;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Arsalan
 */
public interface Checker {

    void check(HttpServletRequest request, HttpServletResponse response, FilterChain chain);

}
