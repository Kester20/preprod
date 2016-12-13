package service.formbean;

import entity.formbean.RegistrationFormBean;
import entity.user.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Arsalan
 */
public interface FormBeanService {

    RegistrationFormBean createFormBean(HttpServletRequest request);

    Map<String, String> validateBean(RegistrationFormBean formBean);

    User transformBean(RegistrationFormBean formBean);

}
