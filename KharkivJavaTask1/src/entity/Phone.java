package entity;


public class Phone extends Product {

    private String producer;
    //TODO
    // default prod
    public Phone() {
    }

    /**
     *
     * @param name
     * @param cost
     * @param producer
     */
    public Phone(String name, double cost, String producer) {
        super(name, cost);
        this.producer = producer;
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
     * @return a string representation of phone
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString() + ", producer:" + this.getProducer());
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
