package service.product;

import entity.laptop.Category;
import entity.laptop.Laptop;
import entity.laptop.Producer;
import repository.factory.RepositoryFactory;
import repository.product.CategoryRepository;
import repository.product.LaptopRepository;
import repository.product.ProducerRepository;

import java.util.List;
import java.util.Map;

/**
 * @author Arsalan
 */
public class DefaultProductService implements ProductService {

    private LaptopRepository laptopRepository;
    private ProducerRepository producerRepository;
    private CategoryRepository categoryRepository;

    public DefaultProductService(RepositoryFactory factory) {
        this.laptopRepository = factory.getLaptopRepository();
        this.producerRepository = factory.getProducerRepository();
        this.categoryRepository = factory.getCategoryRepository();
    }

    @Override
    public List<Laptop> getByCriteria(Map<String, Object> criteria) {
        return laptopRepository.getByCriteria(criteria);
    }

    @Override
    public List<Producer> getAllProducers() {
        return producerRepository.getAllProducers();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public int getCountOfLaptops() {
        return laptopRepository.getCountOfLaptops();
    }
}
