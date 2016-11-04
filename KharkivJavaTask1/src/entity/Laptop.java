package entity;

/**
 * Created by Said_Sulaiman_Arsala on 10/25/2016.
 */
public class Laptop extends Product {

    private String producer;
    private double screenResolution;

    public Laptop(){

    }

    /**
     *
     * @param name
     * @param cost
     * @param producer
     * @param screenResolution
     */
    public Laptop(String name, double cost, String producer, double screenResolution) {
        super(name, cost);
        this.producer = producer;
        this.screenResolution = screenResolution;
    }

    /**
     *
     * @return
     */
    public String getProducer() {
        return producer;
    }

    /**
     *
     * @param producer
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     *
     * @return
     */
    public double getScreenResolution() {
        return screenResolution;
    }

    /**
     *
     * @param screenResolution
     */
    public void setScreenResolution(double screenResolution) {
        this.screenResolution = screenResolution;
    }

    /**
     *
     * @return a string representation of laptop
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString() + ", producer:" + this.getProducer() +  ", screen:" + this.getScreenResolution());
        return sb.toString();
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
