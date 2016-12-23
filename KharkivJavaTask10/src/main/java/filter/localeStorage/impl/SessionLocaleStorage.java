package filter.localeStorage.impl;

import filter.localeStorage.LocaleStorage;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static constants.Constants.LOCALE;

/**
 * @author Arsalan
 */
public class SessionLocaleStorage implements LocaleStorage {

    @Override
    public Locale getLocale(HttpServletRequest request) {
        return (Locale) request.getSession().getAttribute(LOCALE);
    }
}
