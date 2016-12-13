package api.servlet;

import org.apache.log4j.Logger;
import repository.laptop.LaptopRepository;
import service.laptop.LaptopService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static constants.Constants.*;

/**
 * @author Arsalan
 */
@WebServlet("/catalog_servlet")
public class CatalogServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(CatalogServlet.class);
    private LaptopService laptopService;

    @Override
    public void init() throws ServletException {
        laptopService = (LaptopService) getServletContext().getAttribute(LAPTOP_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] producers = request.getParameterValues("checkboxProducer");
        String[] categories = request.getParameterValues("checkboxCategory");


        if (producers != null || categories != null) {

            int firstPrice = Integer.parseInt(request.getParameter("firstPrice"));
            int secondPrice = Integer.parseInt(request.getParameter("secondPrice"));


            Map<String, Object> criteria = new LinkedHashMap<>();
            if(producers != null){
                criteria.put(LAPTOPS_PRODUCER, Arrays.asList(producers));
            }
            if(categories != null){
                criteria.put(LAPTOPS_CATEGORY, Arrays.asList(categories));
            }
            criteria.put(FIRST_PRICE, firstPrice);
            criteria.put(SECOND_PRICE, secondPrice);
            request.setAttribute(LAPTOP_LIST, laptopService.getByParameters(criteria));
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
