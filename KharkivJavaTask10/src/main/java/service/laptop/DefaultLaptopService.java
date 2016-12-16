package service.laptop;

import entity.laptop.Category;
import entity.laptop.Laptop;
import entity.laptop.Producer;
import repository.laptop.LaptopRepository;

import java.util.List;
import java.util.Map;

/**
 * @author Arsalan
 */
public class DefaultLaptopService implements LaptopService {

    private LaptopRepository laptopRepository;

    public DefaultLaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @Override
    public List<Laptop> getByCriteria(Map<String, Object> criteria) {
        return laptopRepository.getByCriteria(criteria);
    }

    @Override
    public List<Producer> getAllProducers() {
        return laptopRepository.getAllProducers();
    }

    @Override
    public List<Category> getAllCategories() {
        return laptopRepository.getAllCategories();
    }

    @Override
    public int getCountOfLaptops() {
        return laptopRepository.getCountOfLaptops();
    }
}
