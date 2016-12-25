package api.servlet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.factory.RepositoryFactory;
import repository.user.UserRepository;
import service.captcha.CaptchaService;
import service.user.DefaultUserService;
import service.formbean.DefaultFormBeanService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static constants.Constants.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @author Arsalan
 */
public class RegistrationServletTest {

    private RegistrationServlet servlet;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private ServletContext servletContext;
    @Mock
    private HttpSession session;
    @Mock
    private ServletConfig servletConfig;
    @Mock
    private CaptchaService captchaService;
    private DefaultUserService defaultUserService;
    private DefaultFormBeanService defaultFormBeanService;

    private static final long tenMinutes = 10 * 60 * 1000;
    private static final int DEFAULT_SIZE_OF_USERS = 3;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        servlet = new RegistrationServlet();
        defaultUserService = new DefaultUserService(new RepositoryFactory(null));
        defaultFormBeanService = new DefaultFormBeanService();

        when(servletConfig.getServletContext()).thenReturn(servletContext);

        when(servletContext.getInitParameter(CAPTCHA_SCOPE)).thenReturn("");
        when(servletContext.getAttribute(USER_SERVICE)).thenReturn(defaultUserService);
        when(servletContext.getAttribute(FORM_BEAN_SERVICE)).thenReturn(defaultFormBeanService);
        when(servletContext.getAttribute(SCOPE)).thenReturn(captchaService);

        when(session.getAttribute(TIME)).thenReturn(System.currentTimeMillis() + tenMinutes);

        when(request.getSession()).thenReturn(session);
        when(request.getServletContext()).thenReturn(servletContext);
        when(request.getParameter(FIRST_NAME)).thenReturn("kester");
        when(request.getParameter(LAST_NAME)).thenReturn("kester");
        when(request.getParameter(EMAIL)).thenReturn("ars.noo@epam.com");
        when(request.getParameter(PASS)).thenReturn("00000000");
        when(request.getParameter(MOBILE_NUMBER)).thenReturn("0935046774");
        when(request.getParameter(CAPTCHA_INPUT)).thenReturn("446774");

        servlet.init(servletConfig);
        servlet.init();
    }

    @Test
    public void testWithAddingClient() throws Exception {
        servlet.doPost(request, response);
    }

    @Test
    public void testNotAddingClientWithInvalidParameters() throws Exception {
        when(request.getParameter(FIRST_NAME)).thenReturn("kester");
        when(request.getParameter(LAST_NAME)).thenReturn("kester");
        when(request.getParameter(EMAIL)).thenReturn("com");
        when(request.getParameter(PASS)).thenReturn("0000");
        when(request.getParameter(MOBILE_NUMBER)).thenReturn("093");

        servlet.doPost(request, response);
    }

    @Test
    public void testNotAddingExistClient() throws Exception {
        servlet.doPost(request, response);
        servlet.doPost(request, response);
    }

}