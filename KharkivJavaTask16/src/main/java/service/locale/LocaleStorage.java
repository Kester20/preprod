package service.locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author Arsalan
 */
public interface LocaleStorage {

    Locale getLocale(HttpServletRequest request);

    void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale);

}
