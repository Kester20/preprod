package api.servlet.order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constants.Constants.*;

/**
 * @author Arsalan
 */
@WebServlet("/confirm_order")
public class ConfirmOrderServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter(TYPE_PAYMENT) != "" && request.getParameter(CARD) != "") {
            request.setAttribute(TYPE_PAYMENT, request.getParameter(TYPE_PAYMENT));
            request.setAttribute(CARD, request.getParameter(CARD));
            RequestDispatcher dispatcher = request.getRequestDispatcher(CONFIRM_ORDER_JSP);
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(CREATE_ORDER_JSP);
        }
    }
}
