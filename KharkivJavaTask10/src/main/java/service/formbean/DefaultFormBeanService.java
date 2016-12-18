package service.formbean;

import entity.formbean.RegistrationFormBean;
import entity.user.User;
import util.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static constants.Constants.*;

/**
 * @author Arsalan
 */
public class DefaultFormBeanService implements FormBeanService {

    private Validator validator = new Validator();

    public RegistrationFormBean createFormBean(HttpServletRequest request) {
        if (request.getParameter(FIRST_NAME) != null && request.getParameter(LAST_NAME) != null && request.getParameter(EMAIL) != null &&
                request.getParameter(PASS) != null && request.getParameter(MOBILE_NUMBER) != null) {
            return new RegistrationFormBean(request.getParameter(FIRST_NAME), request.getParameter(LAST_NAME),
                    request.getParameter(EMAIL), request.getParameter(PASS),
                    request.getParameter(MOBILE_NUMBER));
        }
        return new RegistrationFormBean("", "", "", "", "");
    }

    public Map<String, String> validateBean(RegistrationFormBean formBean) {
        validator.setFormBean(formBean);
        return validator.validate();
    }

    public User transformBean(RegistrationFormBean formBean) {
        return new User(formBean.getFirstName(), formBean.getLastName(), formBean.getEmail(),
                formBean.getPassword(), formBean.getMobileNumber());
    }
}
