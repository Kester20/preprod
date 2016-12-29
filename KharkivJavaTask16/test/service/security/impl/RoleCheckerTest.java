package service.security.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static constants.Constants.USER;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Arsalan
 */
public class RoleCheckerTest extends CheckerTest{

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        checker = new RoleChecker(PATH);
    }

    @Test
    public void checkThatUserRoleIsCorrect() throws Exception {
        when(user.getRole()).thenReturn(USER);
        when(session.getAttribute(USER)).thenReturn(user);
        when(request.getSession()).thenReturn(session);
        checker.check(request, response, filterChain, SECURE_PAGE);
        verify(filterChain, times(1)).doFilter(any(), any());
    }

    @Test
    public void checkThatUserRoleIsNotCorrect() throws Exception {
        when(user.getRole()).thenReturn("");
        when(session.getAttribute(USER)).thenReturn(user);
        when(request.getSession()).thenReturn(session);
        checker.check(request, response, filterChain, SECURE_PAGE);
        verify(filterChain, never()).doFilter(any(), any());
    }

}