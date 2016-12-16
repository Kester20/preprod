package api.servlet;

import entity.laptop.Producer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.captcha.CookieCaptchaService;
import service.captcha.HiddenCaptchaService;
import service.captcha.SessionCaptchaService;
import service.captcha.drawer.CaptchaDrawer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ConcurrentHashMap;

import static constants.Constants.CAPTCHA_CODE;
import static constants.Constants.SCOPE;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * @author Arsalan
 */
public class CaptchaServletTest {

    private CaptchaServlet captchaServlet;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private ServletContext servletContext;
    @Mock
    private ServletConfig servletConfig;
    @Mock
    private HttpSession session;
    @Mock
    private SessionCaptchaService sessionCaptchaService;
    @Mock
    private CookieCaptchaService cookieCaptchaService;
    @Mock
    private HiddenCaptchaService hiddenCaptchaService;
    @Mock
    private CaptchaDrawer drawer;
    @Mock
    private ConcurrentHashMap<String, String> codsOfCaptcha;
    private ArgumentCaptor<String> argumentCaptor;
    private ArgumentCaptor<Cookie> argumentCaptorCookie;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        captchaServlet = new CaptchaServlet();

        when(servletConfig.getServletContext()).thenReturn(servletContext);
        argumentCaptor = ArgumentCaptor.forClass(String.class);
        argumentCaptorCookie = ArgumentCaptor.forClass(Cookie.class);

        doNothing().when(session).setAttribute(anyString(), argumentCaptor.capture());
        doNothing().when(response).addCookie(argumentCaptorCookie.capture());
        when(codsOfCaptcha.put(argumentCaptor.capture(), anyString())).thenReturn("");

        when(request.getSession()).thenReturn(session);
        when(drawer.getCaptcha()).thenReturn("112233");
        when(request.getParameter(CAPTCHA_CODE)).thenReturn("446774");
    }


    @Test
    public void testSessionCaptchaService() throws Exception {
        when(sessionCaptchaService.getCaptchaDrawer()).thenReturn(drawer);
        when(servletContext.getAttribute(SCOPE)).thenReturn(sessionCaptchaService);
        doCallRealMethod().when(sessionCaptchaService).sendCaptcha(request, response);
        captchaServlet.init(servletConfig);
        captchaServlet.init();
        captchaServlet.processRequest(request, response);
        assertEquals(argumentCaptor.getAllValues().get(0), "112233");
    }

    @Test
    public void testCookieCaptchaService() throws Exception {
        when(cookieCaptchaService.getCodsOfCaptcha()).thenReturn(codsOfCaptcha);
        when(cookieCaptchaService.getCaptchaDrawer()).thenReturn(drawer);
        when(servletContext.getAttribute(SCOPE)).thenReturn(cookieCaptchaService);
        doCallRealMethod().when(cookieCaptchaService).sendCaptcha(request, response);
        captchaServlet.init(servletConfig);
        captchaServlet.init();
        captchaServlet.processRequest(request, response);
        assertEquals(argumentCaptorCookie.getAllValues().get(0).getValue(), "446774");
    }

    @Test
    public void testHiddenCaptchaService() throws Exception {
        when(hiddenCaptchaService.getCodsOfCaptcha()).thenReturn(codsOfCaptcha);
        when(hiddenCaptchaService.getCaptchaDrawer()).thenReturn(drawer);
        when(servletContext.getAttribute(SCOPE)).thenReturn(hiddenCaptchaService);
        doCallRealMethod().when(hiddenCaptchaService).sendCaptcha(request, response);
        captchaServlet.init(servletConfig);
        captchaServlet.init();
        captchaServlet.processRequest(request, response);
        assertEquals(argumentCaptor.getAllValues().get(0), "446774");
    }

}