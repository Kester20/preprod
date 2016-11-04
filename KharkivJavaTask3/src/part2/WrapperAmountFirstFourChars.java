package part2;

/**
 * Created by Said_Sulaiman_Arsala on 11/1/2016.
 */
public class WrapperAmountFirstFourChars {

    private String name;

    public WrapperAmountFirstFourChars(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.charAt(0) + name.charAt(1) + name.charAt(2) + name.charAt(3);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
