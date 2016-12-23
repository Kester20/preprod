package filter.localeStorage;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @author Arsalan
 */
public interface LocaleStorage {

    Locale getLocale(HttpServletRequest request);

}
