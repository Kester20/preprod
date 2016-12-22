package api.servlet.cart;

import entity.cart.Cart;
import entity.laptop.Laptop;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import service.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static constants.Constants.CART;
import static constants.Constants.ID_LAPTOP;
import static constants.Constants.LAPTOP_SERVICE;


/**
 * @author Arsalan
 */
@WebServlet("/cart/add/*")
public class AddToCartServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(AddToCartServlet.class);
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = (ProductService) getServletContext().getAttribute(LAPTOP_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("in get");
        HttpSession session = request.getSession();
        Cart cart = session.getAttribute(CART) == null ? new Cart() : (Cart) session.getAttribute(CART);
        int idLaptop = request.getParameter(ID_LAPTOP) == null ? 0 : Integer.parseInt(request.getParameter(ID_LAPTOP));
        if (idLaptop != 0) {
            addToCart(session, cart, idLaptop);
        }
        sendResponse(response, cart);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void addToCart(HttpSession session, Cart cart, int idLaptop) {
        for (Laptop laptop : cart.getCart().keySet()) {
            if (laptop.getId() == idLaptop) {
                return;
            }
        }
        Laptop laptop = productService.getLaptopById(idLaptop);
        cart.add(laptop, 1);
        log.info("added");
        session.setAttribute(CART, cart);
    }

    private void sendResponse(HttpServletResponse response, Cart cart) throws IOException {
        JSONObject json = new JSONObject();
        json.put("amount",  cart.getAmount());
        json.put("size", cart.getCart().size());
        response.setContentType("application/json");
        response.getOutputStream().print(json.toString());
    }
}
