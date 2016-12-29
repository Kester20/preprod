package service.security;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Arsalan
 */
public interface Checker {

    void check(HttpServletRequest request, HttpServletResponse response, FilterChain chain, String page) throws IOException, ServletException;

}
