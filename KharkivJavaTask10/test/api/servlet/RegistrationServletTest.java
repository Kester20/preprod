package api.servlet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static constatnts.Constants.*;
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

    private static final long tenMinutes = 10 * 60 * 1000;
    private static final int DEFAULT_SIZE_OF_USERS = 3;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        servlet = new RegistrationServlet();

        when(servletConfig.getServletContext()).thenReturn(servletContext);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute(TIME)).thenReturn(System.currentTimeMillis() + tenMinutes);
        when(request.getParameter(FIRST_NAME)).thenReturn("kester");
        when(request.getParameter(LAST_NAME)).thenReturn("kester");
        when(request.getParameter(EMAIL)).thenReturn("ars.noo@epam.com");
        when(request.getParameter(PASS)).thenReturn("00000000");
        when(request.getParameter(MOBILE_NUMBER)).thenReturn("0935046774");
        when(request.getParameter(CAPTCHA_INPUT)).thenReturn("446774");
        when(servletContext.getInitParameter(CAPTCHA_SCOPE)).thenReturn("");
        when(request.getServletContext()).thenReturn(servletContext);

        servlet.init(servletConfig);
        servlet.init();
    }

    @Test
    public void testWithAddingClient() throws Exception {
        servlet.doPost(request, response);
        assertTrue(servlet.getUserService().getCountOfUsers() == DEFAULT_SIZE_OF_USERS + 1);
    }

    @Test
    public void testNotAddingClientWithInvalidParameters() throws Exception {
        when(request.getParameter(FIRST_NAME)).thenReturn("kester");
        when(request.getParameter(LAST_NAME)).thenReturn("kester");
        when(request.getParameter(EMAIL)).thenReturn("com");
        when(request.getParameter(PASS)).thenReturn("0000");
        when(request.getParameter(MOBILE_NUMBER)).thenReturn("093");

        servlet.doPost(request, response);
        assertTrue(servlet.getUserService().getCountOfUsers() == DEFAULT_SIZE_OF_USERS);
    }

    @Test
    public void testNotAddingExistClient() throws Exception {
        servlet.doPost(request, response);
        servlet.doPost(request, response);
        assertTrue(servlet.getUserService().getCountOfUsers() == DEFAULT_SIZE_OF_USERS + 1);
    }

}