package filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static constants.Constants.LOCALE;

/**
 * @author Arsalan
 */
public class LocaleFilter implements Filter {

    private static final Logger log = Logger.getLogger(LocaleFilter.class);
    private FilterConfig filterConfig;
    private static final String  DEFAULT_LOCALE = "default_locale";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        Locale locale = getLocaleFromSession(request);
        if (locale == null) {
            locale = getLocalFromBrowser(request);
        }else{
            locale = new Locale(request.getParameter(LOCALE));
        }

        chain.doFilter(getWrappedRequest(request, locale), response);
    }

    private Locale getLocalFromBrowser(HttpServletRequest request){
        boolean find = false;
        Locale result = null;
        Enumeration browserLocales = request.getLocales();

        while (browserLocales.hasMoreElements()) {
            result = (Locale) browserLocales.nextElement();

            if (result.toString().equals(filterConfig.getInitParameter(result.toString()))) {
                find = true;
                break;
            }
        }
        if (!find) {
            result = new Locale(filterConfig.getInitParameter(DEFAULT_LOCALE));
        }
        return result;
    }

    private Locale getLocaleFromSession(HttpServletRequest request){
        return (Locale) request.getSession().getAttribute(LOCALE);
    }

    private Locale getLocaleFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(LOCALE)) {
                    return new Locale(cookie.getValue());
                }
            }
        }
        return null;
    }

    private void setLocaleToCookie(String locale, HttpServletResponse response) {
        Cookie cookie = new Cookie(LOCALE, locale);
        response.addCookie(cookie);
    }

    private ServletRequest getWrappedRequest(HttpServletRequest request, Locale locale){
        ServletRequest requestModified = new HttpServletRequestWrapper(request) {

            @Override
            public Locale getLocale() {
                return locale;
            }

            @Override
            public Enumeration<Locale> getLocales() {
                Set<Locale> locales = new HashSet<>();
                locales.add(locale);
                return Collections.enumeration(locales);
            }
        };
        return requestModified;
    }

    @Override
    public void destroy() {

    }
}
