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
import java.io.IOException;

import static constatnts.Constants.REGISTER_JSP;
import static constatnts.Constants.USER_SERVICE;

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if(request.getParameter("email") != null && request.getParameter("password") != null){
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if(userService.logInUser(email, password)){
                session.setAttribute("user", "user");
            }
        }
        response.sendRedirect("login_servlet");
    }
}
