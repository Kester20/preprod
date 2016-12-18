package api.servlet.cart;

import entity.cart.Cart;
import entity.laptop.Laptop;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static constants.Constants.CART;
import static constants.Constants.ID_LAPTOP;
import static constants.Constants.VALUE;

/**
 * @author Arsalan
 */
@WebServlet("/get_amount_servlet")
public class GetAmountServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(GetAmountServlet.class);

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int idLaptop = request.getParameter(ID_LAPTOP) == null ? 0 : Integer.parseInt(request.getParameter(ID_LAPTOP));
        int value = request.getParameter(VALUE) == null ? 0 : Integer.parseInt(request.getParameter(VALUE));
        if (idLaptop != 0 && value != 0) {
            updateValueCart(session, idLaptop, value);
        }

        response.getOutputStream().print(getAmount(session));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void updateValueCart(HttpSession session, int idLaptop, int value) {
        Cart cart = (Cart) session.getAttribute(CART);
        if (cart != null) {
            for (Laptop laptop : cart.getCart().keySet()) {
                if (laptop.getId() == idLaptop) {
                    cart.getCart().put(laptop, value);
                }
            }
        }
        session.setAttribute(CART, cart);
    }

    private int getAmount(HttpSession session) {
        Cart cart = (Cart) session.getAttribute(CART);
        return cart.getAmount();
    }
}
