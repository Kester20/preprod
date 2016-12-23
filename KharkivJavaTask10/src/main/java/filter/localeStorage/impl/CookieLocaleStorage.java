package filter.localeStorage.impl;

import filter.localeStorage.LocaleStorage;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static constants.Constants.LOCALE;

/**
 * @author Arsalan
 */
public class CookieLocaleStorage implements LocaleStorage {

    @Override
    public Locale getLocale(HttpServletRequest request) {
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
}
