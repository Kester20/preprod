package api.servlet;

import service.user.DefaultUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

import static constants.Constants.*;

/**
 * @author Arsalan
 */
@WebServlet("/login_servlet")
public class LogInServlet extends HttpServlet {

    private DefaultUserService defaultUserService;

    @Override
    public void init() throws ServletException {
        defaultUserService = (DefaultUserService) getServletContext().getAttribute(USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute(WRONG_EMAIL_OR_PASSWORD) != null) {
            request.getRequestDispatcher(ACCOUNT_JSP).forward(request, response);
            request.getSession().removeAttribute(WRONG_EMAIL_OR_PASSWORD);
        } else {
            HttpSession session = request.getSession();
            String nextPage = session.getAttribute(REDIRECT_PAGE) == null ? INDEX_JSP : (String) session.getAttribute(REDIRECT_PAGE);
            session.removeAttribute(REDIRECT_PAGE);
            response.sendRedirect(nextPage);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getParameter(EMAIL) != null && request.getParameter(PASSWORD) != null) {
            String email = request.getParameter(EMAIL);
            String password = request.getParameter(PASSWORD);
            if (defaultUserService.logInUser(email, password)) {
                defaultUserService.clearUserFailedLogin(email);
                session.setAttribute(USER, defaultUserService.getUserByEmailAndPassword(email, password));
                session.setAttribute(USER_AVATAR, AVATARS_PATH + File.separator + email + ".png");
            } else {
                session.setAttribute(WRONG_EMAIL_OR_PASSWORD, SIMPLE_WRONG_EMAIL_OR_PASSWORD);
                defaultUserService.incrementUserFailedLogin(email);
            }
        }
        response.sendRedirect(LOGIN_SERVLET);
    }

    private boolean userCanLogin(String email, String password){
        return defaultUserService.logInUser(email, password) && defaultUserService.checkUserHasNotBan(email);
    }
}
