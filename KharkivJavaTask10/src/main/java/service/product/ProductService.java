package service.product;

import entity.laptop.Category;
import entity.laptop.Laptop;
import entity.laptop.Producer;

import java.util.List;
import java.util.Map;

/**
 * @author Arsalan
 */
public interface ProductService {

    List<Laptop> getByCriteria(Map<String, Object> criteria);

    List<Producer> getAllProducers();

    List<Category> getAllCategories();

    int getCountOfLaptops();
}
