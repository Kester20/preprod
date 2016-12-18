package api.servlet.cart;

import entity.cart.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static constants.Constants.CART;

/**
 * @author Arsalan
 */
@WebServlet("/clear_cart_servlet")
public class ClearCartServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        clearCart(session);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void clearCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute(CART);
        if (cart != null) {
            cart.getCart().clear();
        }
        session.removeAttribute(CART);
    }
}
