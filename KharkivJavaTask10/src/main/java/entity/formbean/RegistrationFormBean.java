package entity.formbean;

import annotation.ValidatorAnnotation;

/**
 * @author Arsalan
 */
public class RegistrationFormBean {

    @ValidatorAnnotation.GetMethod(method = "getFirstName")
    @ValidatorAnnotation.Pattern(pattern = "\\w+",errorMessage = "Empty field!")
    private String firstName;

    @ValidatorAnnotation.GetMethod(method = "getLastName")
    @ValidatorAnnotation.Pattern(pattern = "\\w+", errorMessage = "Empty field!")
    private String secondName;

    @ValidatorAnnotation.GetMethod(method = "getEmail")
    @ValidatorAnnotation.Pattern(pattern = "^[A-Za-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$", errorMessage = "Invalid email format")
    private String email;

    @ValidatorAnnotation.GetMethod(method = "getPassword")
    @ValidatorAnnotation.Pattern(pattern = "\\w{8,}", errorMessage = "Password less then 8 symbols")
    private String password;

    @ValidatorAnnotation.GetMethod(method = "getMobileNumber")
    @ValidatorAnnotation.Pattern(pattern = "^\\+?([0-9]{2})\\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4,5})$", errorMessage = "Invalid mobile number format")
    private String mobileNumber;

    public RegistrationFormBean(String firstName, String secondName, String email, String password, String mobileNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
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
