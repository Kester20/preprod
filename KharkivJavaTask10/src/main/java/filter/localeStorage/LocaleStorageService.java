package filter.localeStorage;

import filter.localeStorage.impl.CookieLocaleStorage;
import filter.localeStorage.impl.SessionLocaleStorage;

import java.util.HashMap;
import java.util.Map;

import static constants.Constants.COOKIE;
import static constants.Constants.SESSION;

/**
 * @author Arsalan
 */
public class LocaleStorageService {

    private Map<String, LocaleStorage> storageMap;

    public LocaleStorageService() {
        storageMap = new HashMap<String, LocaleStorage>(){{
            put(SESSION, new SessionLocaleStorage());
            put(COOKIE, new CookieLocaleStorage());
        }};
    }

    public Map<String, LocaleStorage> getStorageMap() {
        return storageMap;
    }
}
