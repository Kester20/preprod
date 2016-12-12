package service.laptop;

import entity.laptop.Laptop;
import entity.laptop.Producer;

import java.util.List;

/**
 * @author Arsalan
 */
public interface LaptopService {

    /**
     * gets all laptops
     *
     * @return list of laptops
     */
    List<Laptop> getAllLaptops();

    /**
     * @param producers
     * @return
     */
    List<Laptop> getByParameters(String[] producers);

    /**
     * @return list of producers
     */
    List<Producer> getAllProducers();

}
