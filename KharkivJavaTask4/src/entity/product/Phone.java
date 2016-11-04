package entity.product;

/**
 * Entity Phone
 */
public class Phone extends Product {

    private String producer;
    private static final String DEFAULT_PRODUCER = "Apple";

    /**
     * Sets producer default value
     */
    public Phone() {
        this.producer = DEFAULT_PRODUCER;
    }

    /**
     * @param id       Phone
     * @param name     Phone
     * @param cost     Phone
     * @param producer Phone
     */
    public Phone(int id, String name, double cost, String producer) {
        super(id, name, cost);
        this.producer = producer;
    }

    /**
     * @return producer Phone
     */
    public String getProducer() {
        return producer;
    }

    /**
     * @param producer Phone
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     * @return a string representation of phone
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString() + ", producer:" + this.getProducer());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Phone phone = (Phone) o;

        return producer != null ? producer.equals(phone.producer) : phone.producer == null;

    }
}
