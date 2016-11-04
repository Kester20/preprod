package entity;

public class Product {

    private String name;
    private double cost;

    public Product(){

    }

    /**
     *
      * @param name
     * @param cost
     */
    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public double getCost() {
        return cost;
    }

    /**
     *
     * @param cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     *
     * @return a string representation of product
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name:" + this.getName() + ", cost:" + this.getCost());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.cost, cost) != 0) return false;
        return name != null ? name.equals(product.name) : product.name == null;

    }
}
