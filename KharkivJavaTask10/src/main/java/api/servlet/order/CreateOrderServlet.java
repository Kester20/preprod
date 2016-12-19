package api.servlet.order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static constants.Constants.*;

/**
 * @author Arsalan
 */
@WebServlet("/create_order_servlet")
public class CreateOrderServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        checkAccess(session, request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void checkAccess(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(session.getAttribute(USER) == null){
            session.setAttribute(USER_HAS_ORDER, true);
            RequestDispatcher dispatcher = request.getRequestDispatcher(ACCOUNT_JSP);
            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher(CREATE_ORDER_JSP);
            dispatcher.forward(request, response);
        }
    }
}
