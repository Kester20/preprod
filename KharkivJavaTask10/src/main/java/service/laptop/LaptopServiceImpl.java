package service.laptop;

import entity.laptop.Laptop;
import repository.laptop.LaptopRepository;

import java.util.List;

/**
 * @author Arsalan
 */
public class LaptopServiceImpl implements LaptopService {

    private LaptopRepository laptopRepository;

    public LaptopServiceImpl(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @Override
    public List<Laptop> getAllLaptops() {
        return laptopRepository.getAllLaptops();
    }
}
