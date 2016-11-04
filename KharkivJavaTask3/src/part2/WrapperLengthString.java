package part2;

/**
 * Created by Said_Sulaiman_Arsala on 11/1/2016.
 */
public class WrapperLengthString {

    private String name;

    public WrapperLengthString(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.length();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
