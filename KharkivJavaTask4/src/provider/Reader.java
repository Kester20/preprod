package provider;

/**
 * @author Arsalan
 *         reads the value different ways
 */
public interface Reader {

    /**
     * @return int value
     */
    public int getInt();

    /**
     * @return double value
     */
    public double getDouble();

    /**
     * @param s - string, that will be added to value
     * @return string value
     */
    public String getString(String s);
}
