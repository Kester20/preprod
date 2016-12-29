package service.security.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import static constants.Constants.USER;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Arsalan
 */
public class UserIsInSystemCheckerTest extends CheckerTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        checker = new UserIsInSystemChecker(PATH);
        doNothing().when(nextChecker).check(any(), any(), any(), any());
        checker.setNextChecker(nextChecker);
    }

    @Test
    public void checkThatUserWillBeForwardToRegisterPage() throws Exception {
        when(session.getAttribute(USER)).thenReturn(null);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestURI()).thenReturn("");
        when(request.getRequestDispatcher(any())).thenReturn(dispatcher);
        doNothing().when(dispatcher).forward(any(), any());
        doNothing().when(session).setAttribute(any(), any());
        checker.check(request, response, filterChain, SECURE_PAGE);
        verify(session, times(1)).setAttribute(any(), any());
    }

    @Test
    public void checkThatUserIsLogin() throws Exception {
        when(session.getAttribute(USER)).thenReturn("");
        when(request.getSession()).thenReturn(session);
        checker.check(request, response, filterChain, SECURE_PAGE);
        verify(nextChecker, times(1)).check(any(), any(), any(), any());
    }

}