package service.catalog;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Arsalan
 */
public interface CatalogFilterService {

    Map<String, Object> createCriteria(HttpServletRequest request);

}
