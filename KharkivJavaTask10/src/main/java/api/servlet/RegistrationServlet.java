package api.servlet;

import entity.client.Client;
import entity.formbean.RegistrationFormBean;
import org.apache.log4j.Logger;
import service.client.UserService;
import service.formbean.FormBeanService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import static constatnts.Constants.*;


/**
 * @author Arsalan
 */
@WebServlet("/registration_servlet")
public class RegistrationServlet extends HttpServlet {

    private UserService userService;
    private FormBeanService formBeanService;
    private Map<String, String> errors;
    private RegistrationFormBean formBean;
    private static final Logger log = Logger.getLogger(RegistrationServlet.class);

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute(USER_SERVICE);
        formBeanService = new FormBeanService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (errors != null) {
            if (errors.size() > 0) {
                request.setAttribute(FORM_BEAN, formBean);
                request.setAttribute(ERRORS, errors);
            }
        }
        request.setAttribute(CAPTCHA_CODE, generateCodeCaptcha());
        log.info("GENERATE CODE CAPTCHA IN GET");
        RequestDispatcher dispatcher = request.getRequestDispatcher(REGISTER_JSP);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (System.currentTimeMillis() > (long) request.getSession().getAttribute(TIME)) {
            log.info("Time out");
            RequestDispatcher dispatcher = request.getRequestDispatcher(ERROR_TIME_OUT_JSP);
            dispatcher.forward(request, response);
            return;
        }
        formBean = formBeanService.createFormBean(request);
        errors = formBeanService.validateBean(formBean);
        formBeanService.validateCaptcha(request, errors);
        if (errors.size() == 0) {
            if (userService.checkExistClient(formBean.getEmail())) {
                errors.put(EMAIL, EMAIL_ALREADY_EXIST);
            } else {
                Client client = formBeanService.transformBean(formBean);
                userService.createClient(client);
                log.info("New client was registered");
            }
        }
        response.sendRedirect(REGISTRATION_SERVLET);
    }

    protected String generateCodeCaptcha() {
        return UUID.randomUUID().toString();
    }

    public UserService getUserService() {
        return userService;
    }
}
