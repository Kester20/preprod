package filter;

import org.apache.log4j.Logger;
import service.locale.LocaleStorage;
import service.locale.LocaleStorageService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static constants.Constants.LOCALE;
import static constants.Constants.STORAGE;

/**
 * @author Arsalan
 */
public class LocaleFilter implements Filter {

    private static final Logger log = Logger.getLogger(LocaleFilter.class);
    private static final String DEFAULT_LOCALE = "default_locale";
    private FilterConfig filterConfig;
    private LocaleStorageService localeStorageService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.localeStorageService = new LocaleStorageService();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        Locale locale = getLocale(request);
        setLocaleToStorage(request, response, locale);
        chain.doFilter(getWrappedRequest(request, locale), response);
    }

    protected Locale getLocale(HttpServletRequest request) {
        Locale result;
        if (request.getParameter(LOCALE) != null) {
            result = new Locale(request.getParameter(LOCALE));
        } else {
            result = getLocaleFromStorage(request) == null ? getLocalFromBrowser(request) : getLocaleFromStorage(request);
        }
        return result;
    }

    protected void setLocaleToStorage(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        Map<String, LocaleStorage> localeStorageMap = localeStorageService.getStorageMap();
        LocaleStorage localeStorage = localeStorageMap.get(filterConfig.getInitParameter(STORAGE));
        localeStorage.setLocale(request, response, locale);
    }

    private Locale getLocaleFromStorage(HttpServletRequest request) {
        Map<String, LocaleStorage> localeStorageMap = localeStorageService.getStorageMap();
        LocaleStorage localeStorage = localeStorageMap.get(filterConfig.getInitParameter(STORAGE));
        return localeStorage.getLocale(request);
    }

    /**
     * @param request
     * @return locale form browser. If locale from browser is not supported, then will returned default locale.
     */
    private Locale getLocalFromBrowser(HttpServletRequest request) {
        boolean hasLocaleSet = false;
        Locale result = null;
        Enumeration browserLocales = request.getLocales();

        while (browserLocales.hasMoreElements()) {
            result = (Locale) browserLocales.nextElement();

            if (result.toString().equals(filterConfig.getInitParameter(result.toString()))) {
                hasLocaleSet = true;
                break;
            }
        }
        if (!hasLocaleSet) {
            result = new Locale(filterConfig.getInitParameter(DEFAULT_LOCALE));
        }
        return result;
    }


    private ServletRequest getWrappedRequest(HttpServletRequest request, Locale locale) {
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

    public void setLocaleStorageService(LocaleStorageService localeStorageService) {
        this.localeStorageService = localeStorageService;
    }
}
