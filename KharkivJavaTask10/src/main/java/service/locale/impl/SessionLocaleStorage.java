package service.locale.impl;

import service.locale.LocaleStorage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

import static constants.Constants.*;

/**
 * @author Arsalan
 */
public class SessionLocaleStorage implements LocaleStorage {

    @Override
    public Locale getLocale(HttpServletRequest request) {
        return (Locale) request.getSession().getAttribute(LOCALE);
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        System.out.println(request.getSession().getMaxInactiveInterval());
        request.getSession().setAttribute(STORAGE, SESSION);
        request.getSession().setAttribute(LOCALE, locale);
    }
}
