package service.laptop;

import entity.laptop.Laptop;

import java.util.List;

/**
 * @author Arsalan
 */
public interface LaptopService {

    /**
     * gets all laptops
     * @return list of laptops
     */
    List<Laptop> getAllLaptops();

}
