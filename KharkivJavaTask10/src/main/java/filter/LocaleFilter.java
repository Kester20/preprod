package filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

/**
 * @author Arsalan
 */
public class LocaleFilter implements Filter {

    private static final Logger log = Logger.getLogger(LocaleFilter.class);
    private FilterConfig filterConfig;
    private Locale locale;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        locale = getLocaleFromCookie(request);
        if (locale == null) {
            Enumeration browserLocales = request.getLocales();

            boolean settedLocale = false;
            while (browserLocales.hasMoreElements()) {
                locale = (Locale) browserLocales.nextElement();
                if (locale.toString().equals(filterConfig.getInitParameter(locale.toString()))) {
                    setLocaleToCookie(locale.toString(), response);
                    settedLocale = true;
                    break;
                }
            }
            if (!settedLocale) {
                setLocaleToCookie(filterConfig.getInitParameter("default_locale"), response);
            }
        } else {
            log.info(locale.getLanguage());
        }



        ServletRequest requestModified = new HttpServletRequestWrapper((HttpServletRequest) request) {

            @Override
            public Locale getLocale() {
                return locale;
            }

            /*@Override
            public Enumeration<Locale> getLocales() {
                return locale;
            }*/
        };

        chain.doFilter(requestModified, response);
    }

    @Override
    public void destroy() {

    }

    private Locale getLocaleFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("locale")) {
                    return new Locale(cookie.getValue());
                }
            }
        }
        return null;
    }

    private void setLocaleToCookie(String locale, HttpServletResponse response) {
        Cookie cookie = new Cookie("locale", locale);
        response.addCookie(cookie);
    }
}
