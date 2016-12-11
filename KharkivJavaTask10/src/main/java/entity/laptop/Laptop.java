package entity.laptop;

/**
 * @author Arsalan
 */
public class Laptop {

    private int id;
    private String producer;
    private String model;
    private int cost;
    private String image;

    public Laptop(int id, String producer, String model, int cost, String image) {
        this.id = id;
        this.producer = producer;
        this.model = model;
        this.cost = cost;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public int getCost() {
        return cost;
    }

    public String getImage() {
        return image;
    }
}
