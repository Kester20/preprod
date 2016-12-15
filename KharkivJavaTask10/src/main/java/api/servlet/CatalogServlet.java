package api.servlet;

import org.apache.log4j.Logger;
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
        String firstPrice = request.getParameter("firstPrice");
        String secondPrice = request.getParameter("secondPrice");
        int showCount = request.getParameter("selectShow")  == null ? 6 : Integer.parseInt(request.getParameter("selectShow"));
        int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));

        if (producers != null || categories != null) {

            log.info(laptopService.getCountOfLaptops());

            String orderBy = request.getParameter("selectSort");

            Map<String, Object> criteria = new LinkedHashMap<>();
            if (producers != null) {
                criteria.put(LAPTOPS_PRODUCER, Arrays.asList(producers));
            }
            if (categories != null) {
                criteria.put(LAPTOPS_CATEGORY, Arrays.asList(categories));
            }
            criteria.put(FIRST_PRICE, Integer.parseInt(firstPrice));
            criteria.put(SECOND_PRICE, Integer.parseInt(secondPrice));
            criteria.put(ORDER_BY, orderBy);
            criteria.put(LIMIT,showCount);
            criteria.put(PAGE, page);

            request.setAttribute(LAPTOP_LIST, laptopService.getByParameters(criteria));
            request.setAttribute(PRODUCER_LIST, laptopService.getAllProducers());
            request.setAttribute(CATEGORY_LIST, laptopService.getAllCategories());
            request.setAttribute(COUNT_OF_LAPTOPS, laptopService.getCountOfLaptops());
            request.setAttribute(COUNT_OF_PAGES, getCountOfPages(laptopService.getCountOfLaptops(), showCount));
            request.setAttribute(SHOW_COUNT, showCount);
            RequestDispatcher dispatcher = request.getRequestDispatcher(PRODUCTS_JSP);
            dispatcher.forward(request, response);
        } else {
            request.setAttribute(LAPTOP_LIST, laptopService.getAllLaptops(showCount));
            request.setAttribute(PRODUCER_LIST, laptopService.getAllProducers());
            request.setAttribute(CATEGORY_LIST, laptopService.getAllCategories());
            request.setAttribute(COUNT_OF_LAPTOPS, laptopService.getCountOfLaptops());
            request.setAttribute(COUNT_OF_PAGES, getCountOfPages(laptopService.getCountOfLaptops(), showCount));
            request.setAttribute(SHOW_COUNT, showCount);
            RequestDispatcher dispatcher = request.getRequestDispatcher(PRODUCTS_JSP);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private int getCountOfPages(double countOfLaptops, double showCount){
        return (int) Math.ceil(countOfLaptops/showCount);
    }
}
