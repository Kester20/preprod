package api.servlet;

import service.laptop.LaptopService;

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
@WebServlet("/catalog_servlet")
public class CatalogServlet extends HttpServlet {

    private LaptopService laptopService;

    @Override
    public void init() throws ServletException {
        laptopService = (LaptopService) getServletContext().getAttribute(LAPTOP_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] lines = request.getParameterValues("checkbox");
        if (lines != null) {
            request.setAttribute(LAPTOP_LIST, laptopService.getByParameters(lines));
            request.setAttribute(PRODUCER_LIST, laptopService.getAllProducers());
            request.setAttribute(CATEGORY_LIST, laptopService.getAllCategories());
            RequestDispatcher dispatcher = request.getRequestDispatcher(PRODUCTS_JSP);
            dispatcher.forward(request, response);
        }else{
            request.setAttribute(LAPTOP_LIST, laptopService.getAllLaptops());
            request.setAttribute(PRODUCER_LIST, laptopService.getAllProducers());
            request.setAttribute(CATEGORY_LIST, laptopService.getAllCategories());
            RequestDispatcher dispatcher = request.getRequestDispatcher(PRODUCTS_JSP);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
