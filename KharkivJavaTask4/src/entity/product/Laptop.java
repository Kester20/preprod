package entity.product;

/**
 * Entity laptop
 * Created by Said_Sulaiman_Arsala on 10/25/2016.
 */
public class Laptop extends Product {

    private String producer;
    private double screenResolution;
    private static final String DEFAULT_PRODUCER = "Dell";
    private static final double DEFAULT_SCREEN = 15.6;

    /**
     * Sets producer and screen default value
     */
    public Laptop() {
        this.producer = DEFAULT_PRODUCER;
        this.screenResolution = DEFAULT_SCREEN;
    }

    /**
     * @param id               laptop
     * @param name             laptop
     * @param cost             laptop
     * @param producer         laptop
     * @param screenResolution laptop
     */
    public Laptop(int id, String name, double cost, String producer, double screenResolution) {
        super(id, name, cost);
        this.producer = producer;
        this.screenResolution = screenResolution;
    }

    /**
     * @return producer laptop
     */
    public String getProducer() {
        return producer;
    }

    /**
     * @param producer laptop
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     * @return screenResolution laptop
     */
    public double getScreenResolution() {
        return screenResolution;
    }

    /**
     * @param screenResolution laptop
     */
    public void setScreenResolution(double screenResolution) {
        this.screenResolution = screenResolution;
    }

    /**
     * @return a string representation of entity laptop
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString() + ", producer:" + this.getProducer() + ", screen:" + this.getScreenResolution());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Laptop laptop = (Laptop) o;

        if (Double.compare(laptop.screenResolution, screenResolution) != 0) return false;
        return producer != null ? producer.equals(laptop.producer) : laptop.producer == null;

    }
}
