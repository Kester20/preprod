package api.servlet;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;

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

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        servlet = new RegistrationServlet();
    }

    @Test
    public void doGetWithAddingClient() throws Exception {
        when(request.getParameter("firstName")).thenReturn("kester");
        when(request.getParameter("lastName")).thenReturn("kester");
        when(request.getParameter("email")).thenReturn("ars.noo@epam.com");
        when(request.getParameter("pass")).thenReturn("00000000");
        when(request.getParameter("mobileNumber")).thenReturn("0934096374");
        when(request.getServletContext()).thenReturn(servletContext);
        when(servletContext.getInitParameter("captchaScope")).thenReturn("");

        servlet.init();
        servlet.doPost(request, response);
        assertTrue(servlet.getClientService().getClientRepository().getUsers().size() == 4);
    }

    @Test
    public void doGetNotAddingClient() throws Exception {
        when(request.getParameter("firstName")).thenReturn("kester");
        when(request.getParameter("lastName")).thenReturn("kester");
        when(request.getParameter("email")).thenReturn("com");
        when(request.getParameter("pass")).thenReturn("0000");
        when(request.getParameter("mobileNumber")).thenReturn("093");
        when(request.getServletContext()).thenReturn(servletContext);
        when(servletContext.getInitParameter("captchaScope")).thenReturn("");

        servlet.init();
        servlet.doPost(request, response);
        assertTrue(servlet.getClientService().getClientRepository().getUsers().size() == 3);
    }

    @Test
    public void doPost() throws Exception {

    }

}