package filter.security.impl;

import filter.security.Checker;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Arsalan
 */
public class PageInSecureListChecker implements Checker {

    @Override
    public void check(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {

    }
}
