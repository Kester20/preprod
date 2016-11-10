package entity.decorator;

import entity.product.Product;

/**
 * Created by Said_Sulaiman_Arsala on 11/10/2016.
 */
public class SensorLaptopDecorator extends ProductDecorator {

    private String typeOfSensor = "Capacitive";

    public SensorLaptopDecorator(Product product, String typeOfSensor) {
        super(product);
        this.typeOfSensor = typeOfSensor;
    }

    @Override
    public int getCost() {
        return super.getCost() + 10000;
    }
}
