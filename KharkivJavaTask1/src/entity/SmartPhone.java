package entity;

public class SmartPhone extends Phone {

    private String androidVersion;

    /**
     *
      * @param name
     * @param cost
     * @param producer
     * @param androidVersion
     */
    public SmartPhone(String name, double cost, String producer, String androidVersion) {
        super(name, cost, producer);
        this.androidVersion = androidVersion;
    }

    /**
     *
      * @return
     */
    public String getAndroidVersion() {
        return androidVersion;
    }

    /**
     *
     * @param androidVersion
     */
    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    /**
     *
     * @return a string representation of smart phone
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString() + ", producer:" + this.getProducer() + ", android version:" + this.getAndroidVersion());
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
