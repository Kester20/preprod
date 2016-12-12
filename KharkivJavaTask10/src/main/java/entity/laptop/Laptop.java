package entity.laptop;

/**
 * @author Arsalan
 */
public class Laptop {

    private int id;
    private Producer producer;
    private String model;
    private int cost;
    private String image;
    private Category category;

    public Laptop(int id, Producer producer, String model, int cost, String image, Category category) {
        this.id = id;
        this.producer = producer;
        this.model = model;
        this.cost = cost;
        this.image = image;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public Producer getProducer() {
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

    public Category getCategory() {
        return category;
    }
}
