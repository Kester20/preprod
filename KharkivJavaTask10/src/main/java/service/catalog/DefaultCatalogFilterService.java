package service.catalog;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static constants.Constants.*;

/**
 * @author Arsalan
 */
public class DefaultCatalogFilterService implements CatalogFilterService {

    @Override
    public Map<String, Object> createCriteria(HttpServletRequest request) {
        Map<String, Object> criteria = new LinkedHashMap<>();
        String[] producers = request.getParameterValues(CHECKBOX_PRODUCER);
        String[] categories = request.getParameterValues(CHECKBOX_CATEGORY);
        int firstPrice = request.getParameter(FIRST_PRICE) == null ? 0 : Integer.parseInt(request.getParameter(FIRST_PRICE));
        int secondPrice = request.getParameter(SECOND_PRICE) == null ? 100000 : Integer.parseInt(request.getParameter(SECOND_PRICE));
        String orderBy = request.getParameter(SELECT_SORT) == null ? LAPTOPS_ID : request.getParameter(SELECT_SORT);
        int showCount = request.getParameter(SELECT_SHOW)  == null ? 6 : Integer.parseInt(request.getParameter(SELECT_SHOW));
        int page = request.getParameter(PAGE) == null ? 1 : Integer.parseInt(request.getParameter(PAGE));

        if (producers != null) {
            criteria.put(LAPTOPS_PRODUCER, Arrays.asList(producers));
        }
        if (categories != null) {
            criteria.put(LAPTOPS_CATEGORY, Arrays.asList(categories));
        }

        criteria.put(FIRST_PRICE, firstPrice);
        criteria.put(SECOND_PRICE, secondPrice);
        criteria.put(ORDER_BY, orderBy);
        criteria.put(LIMIT,showCount);
        criteria.put(PAGE, page);
        return criteria;
    }
}
