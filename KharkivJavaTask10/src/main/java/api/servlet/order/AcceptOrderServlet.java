package api.servlet.order;

import entity.cart.Cart;
import entity.order.Order;
import entity.user.User;
import exceptions.BusinessException;
import org.apache.log4j.Logger;
import service.order.DefaultOrderService;
import service.order.OrderService;

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
@WebServlet("/accept_order")
public class AcceptOrderServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(AcceptOrderServlet.class);
    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        orderService = (DefaultOrderService) getServletContext().getAttribute(ORDER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        createOrder(request, response);
        request.getSession().removeAttribute(CART);
        request.setAttribute(LAST_ORDER_ID, orderService.getLastOrderId());
        RequestDispatcher dispatcher = request.getRequestDispatcher(DONE_ORDER_JSP);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void createOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean created = false;
        String typePayment = request.getParameter(TYPE_PAYMENT);
        String card = request.getParameter(CARD);
        User user = (User) request.getSession().getAttribute(USER);
        Cart cart = (Cart) request.getSession().getAttribute(CART);
        try {

            Order order = new Order(user.getEmail(), typePayment, card, cart.getCart());
            orderService.createOrder(order);

        } catch (BusinessException e) {
            e.printStackTrace();
            log.info("TRANSACTIONAL EXCEPTION! " + e.getMessage());
        }
    }
}
