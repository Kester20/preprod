package entity.user;

/**
 * @author Arsalan
 */
public class User {

    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String mobileNumber;

    public User(String firstName, String secondName, String email, String password, String mobileNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}
