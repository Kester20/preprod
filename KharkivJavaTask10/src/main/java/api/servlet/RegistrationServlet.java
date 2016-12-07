package api.servlet;

import entity.user.User;
import entity.formbean.RegistrationFormBean;
import org.apache.log4j.Logger;
import service.captcha.CaptchaService;
import service.client.UserService;
import service.formbean.FormBeanService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    private CaptchaService captchaService;
    private static final Logger log = Logger.getLogger(RegistrationServlet.class);

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute(USER_SERVICE);
        formBeanService = (FormBeanService) getServletContext().getAttribute(FORM_BEAN_SERVICE);
        captchaService = (CaptchaService) getServletContext().getAttribute(SCOPE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RegistrationFormBean formBean = (RegistrationFormBean) session.getAttribute(FORM_BEAN);
        Map<String, String> errors = (Map<String, String>) session.getAttribute(ERRORS);

        if (errors != null) {
            if (errors.size() > 0) {
                log.info("ERRORS DETECTED");
                request.setAttribute(FORM_BEAN, formBean);
                request.setAttribute(ERRORS, errors);
            }
        }
        request.setAttribute(CAPTCHA_CODE, generateCodeCaptcha());
        session.removeAttribute(FORM_BEAN);
        session.removeAttribute(ERRORS);
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

        HttpSession session = request.getSession();
        RegistrationFormBean formBean = formBeanService.createFormBean(request);
        Map<String, String> errors = formBeanService.validateBean(formBean);

        captchaService.validateCaptcha(request, errors);
        if (errors.size() == 0) {
            if (userService.checkIfExistUser(formBean.getEmail())) {
                errors.put(EMAIL, EMAIL_ALREADY_EXIST);
            } else {
                User user = formBeanService.transformBean(formBean);
                userService.createUser(user);
                log.info("New user was registered");
            }
        }
        session.setAttribute(FORM_BEAN, formBean);
        session.setAttribute(ERRORS, errors);
        response.sendRedirect(REGISTRATION_SERVLET);
    }

    protected String generateCodeCaptcha() {
        return UUID.randomUUID().toString();
    }

    public UserService getUserService() {
        return userService;
    }
}
