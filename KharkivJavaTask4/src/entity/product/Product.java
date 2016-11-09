package entity.product;

/**
 * Entity product
 */
public class Product {

    private String name;
    private double cost;
    private int id;

    public Product() {

    }

    /**
     * @param name product's name
     * @param cost product's cost
     */
    public Product(int id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    /**
     * @return id product
     */
    public int getId() {
        return id;
    }

    /**
     * @param id product
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return name product
     */
    public String getName() {
        return name;
    }

    /**
     * @param name product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return cost product
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost product
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return a string representation of product
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + id + ", name:" + this.getName() + ", cost:" + this.getCost());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.cost, cost) != 0) return false;
        if (id != product.id) return false;
        return name != null ? name.equals(product.name) : product.name == null;

    }
}
