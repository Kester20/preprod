package service.laptop;

import entity.laptop.Category;
import entity.laptop.Laptop;
import entity.laptop.Producer;

import java.util.List;

/**
 * @author Arsalan
 */
public interface LaptopService {

    List<Laptop> getAllLaptops();

    /**
     * @param producers
     * @return
     */
    List<Laptop> getByParameters(String[] producers);

    List<Producer> getAllProducers();

    List<Category> getAllCategories();
}
