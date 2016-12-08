package api.servlet;

import service.client.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

import static constatnts.Constants.*;

/**
 * @author Arsalan
 */
@WebServlet("/login_servlet")
public class LogInServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute(USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute(WRONG_EMAIL_OR_PASSWORD) != null){
            RequestDispatcher dispatcher = request.getRequestDispatcher(ACCOUNT_JSP);
            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher(INDEX_JSP);
            dispatcher.forward(request, response);
        }
        request.getSession().removeAttribute(WRONG_EMAIL_OR_PASSWORD);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if(request.getParameter(EMAIL) != null && request.getParameter(PASSWORD) != null){
            String email = request.getParameter(EMAIL);
            String password = request.getParameter(PASSWORD);
            if(userService.logInUser(email, password)){
                String appPath = request.getServletContext().getRealPath("");
                session.setAttribute(USER, USER);
                session.setAttribute(USER_NAME, userService.getUserNameByEmail(email));
                session.setAttribute(USER_AVATAR, AVATARS_PATH + File.separator + email+".png");
            }else{
                session.setAttribute(WRONG_EMAIL_OR_PASSWORD,SIMPLE_WRONG_EMAIL_OR_PASSWORD);
            }
        }
        response.sendRedirect(LOGIN_SERVLET);
    }
}
