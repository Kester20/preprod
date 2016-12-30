package service.security.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static constants.Constants.NOT_SECURE_PAGE;
import static constants.Constants.PATH_TO_XML_FILE_SECURITY;
import static constants.Constants.SECURE_PAGE;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Arsalan
 */
public class PageInSecureListCheckerTest extends CheckerTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        checker = new PageInSecureListChecker(PATH_TO_XML_FILE_SECURITY);
        doNothing().when(nextChecker).check(any(), any(), any(), any());
        checker.setNextChecker(nextChecker);
    }

    @Test
    public void checkThatPageIsInSecureListSoFilterChainNotCallDoFilter() throws Exception {
        checker.check(request, response, filterChain, SECURE_PAGE);
        verify(filterChain, never()).doFilter(any(), any());

    }

    @Test
    public void checkThatPageIsNotInSecureListSoFilterChainCallDoFilter() throws Exception {
        checker.check(request, response, filterChain, NOT_SECURE_PAGE);
        verify(filterChain, times(1)).doFilter(any(), any());
    }

}