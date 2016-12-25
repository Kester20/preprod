package service.locale.impl;

import service.locale.LocaleStorage;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

import static constants.Constants.*;

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

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        request.getSession().setAttribute(STORAGE, COOKIE);
        Cookie cookie = new Cookie(LOCALE, locale.toString());
        response.addCookie(cookie);
    }
}
