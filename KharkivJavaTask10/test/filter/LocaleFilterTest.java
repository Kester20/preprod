package filter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.locale.LocaleStorage;
import service.locale.LocaleStorageService;
import service.locale.impl.CookieLocaleStorage;
import service.locale.impl.SessionLocaleStorage;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Locale;
import java.util.Map;

import static constants.Constants.CAPTCHA_SCOPE;
import static constants.Constants.COOKIE;
import static constants.Constants.LOCALE;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * @author Arsalan
 */
public class LocaleFilterTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private FilterConfig filterConfig;
    @Mock
    private LocaleStorageService localeStorageService;
    @Mock
    private Map<String, LocaleStorage> localeStorageMap;
    @Mock
    private CookieLocaleStorage cookieLocaleStorage;
    @Mock
    private SessionLocaleStorage sessionLocaleStorage;
    @Mock
    private HttpSession session;

    private LocaleFilter filter;
    private static final String EN_US = "en_US";
    private static final String RU_RU = "ru_RU";
    private ArgumentCaptor<String> argumentCaptor;
    private ArgumentCaptor<Cookie> argumentCaptorCookie;

    @Before
    public void setUp() throws ServletException {
        MockitoAnnotations.initMocks(this);
        argumentCaptor = ArgumentCaptor.forClass(String.class);
        argumentCaptorCookie = ArgumentCaptor.forClass(Cookie.class);
        filter = new LocaleFilter();
        filter.init(filterConfig);
        when(localeStorageService.getStorageMap()).thenReturn(localeStorageMap);
        filter.setLocaleStorageService(localeStorageService);
    }

    @Test
    public void testManualLocalization() throws Exception {
        when(request.getParameter(LOCALE)).thenReturn(EN_US);
        assertTrue(filter.getLocale(request).getLanguage().equalsIgnoreCase(EN_US));
    }

    @Test
    public void testAutoLocalizationStorageCookie(){
        when(request.getCookies()).thenReturn(new Cookie[]{new Cookie(LOCALE, RU_RU)});
        when(cookieLocaleStorage.getLocale(any())).thenCallRealMethod();
        when(localeStorageMap.get(any())).thenReturn(cookieLocaleStorage);
        assertTrue(filter.getLocale(request).getLanguage().equalsIgnoreCase(RU_RU));
    }

    @Test
    public void testAutoLocalizationStorageSession(){
        when(session.getAttribute(LOCALE)).thenReturn(new Locale(EN_US));
        when(request.getSession()).thenReturn(session);
        when(sessionLocaleStorage.getLocale(any())).thenCallRealMethod();
        when(localeStorageMap.get(any())).thenReturn(sessionLocaleStorage);
        assertTrue(filter.getLocale(request).getLanguage().equalsIgnoreCase(EN_US));
    }

    @Test
    public void testSetLocaleToStorageCookie(){
        Locale locale = new Locale(EN_US);
        when(localeStorageMap.get(any())).thenReturn(cookieLocaleStorage);
        doCallRealMethod().when(cookieLocaleStorage).setLocale(request,  response, locale);
        when(request.getSession()).thenReturn(session);
        doNothing().when(response).addCookie(argumentCaptorCookie.capture());
        filter.setLocaleToStorage(request, response, locale);
        assertEquals(argumentCaptorCookie.getValue().getValue(), "en_us");
    }

    @Test
    public void testSetLocaleToStorageSession(){
        Locale locale = new Locale(RU_RU);
        when(localeStorageMap.get(any())).thenReturn(sessionLocaleStorage);
        doCallRealMethod().when(sessionLocaleStorage).setLocale(request,  response, locale);
        when(request.getSession()).thenReturn(session);
        doNothing().when(session).setAttribute(anyString(), argumentCaptor.capture());
        filter.setLocaleToStorage(request, response, locale);
        assertEquals(argumentCaptor.getAllValues().get(1), "ru_ru");
    }
}