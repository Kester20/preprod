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

/**
 * @author Arsalan
 */
@WebServlet("/delete_from_cart_servlet")
public class DeleteFromCartServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(DeleteFromCartServlet.class);

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int idLaptop = request.getParameter(ID_LAPTOP) == null ? 0 : Integer.parseInt(request.getParameter(ID_LAPTOP));
        if (idLaptop != 0) {
            delete(session, idLaptop);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void delete(HttpSession session, int id) throws ServletException, IOException {
        Cart cart = (Cart) session.getAttribute(CART);
        if (cart != null) {
            for (Laptop laptop : cart.getCart().keySet()) {
                if (laptop.getId() == id) {
                    cart.remove(laptop);
                    log.info("removed");
                }
            }
        }
        if(cart.getCart().size() == 0){
            session.removeAttribute(CART);
        }else{
            session.setAttribute(CART, cart);
        }
    }
}
