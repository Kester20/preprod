package formbean;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Arsalan
 */
public class RegistrationFormBean {

    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private long mobileNumber;

    private RegistrationFormBean(String firstName, String secondName, String email, String password, long mobileNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    public RegistrationFormBean createFormBean(HttpServletRequest request) {
        return new RegistrationFormBean(request.getParameter("firstName"), request.getParameter("secondName"),
                request.getParameter("email"), request.getParameter("password"),
                Long.parseLong(request.getParameter("mobileNumber")));
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

    public long getMobileNumber() {
        return mobileNumber;
    }
}
