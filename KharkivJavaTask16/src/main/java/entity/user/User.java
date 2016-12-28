package entity.user;

import java.sql.Time;

/**
 * @author Arsalan
 */
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String mobileNumber;
    private int failedLogin;
    private Time removeBan;

    public User(String firstName, String lastName, String email, String password, String mobileNumber, int failedLogin, Time removeBan) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.failedLogin = failedLogin;
        this.removeBan = removeBan;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public int getFailedLogin() {
        return failedLogin;
    }

    public Time getRemoveBan() {
        return removeBan;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("firstName: " + firstName).
                append(", lastName: " + lastName).
                append(", email: " + email).
                append(", pass: " + password).
                append(", mobile: " + mobileNumber).toString();
    }
}
