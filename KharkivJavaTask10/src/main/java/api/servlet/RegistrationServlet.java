package api.servlet;

import entity.formbean.RegistrationFormBean;
import entity.client.Client;
import org.apache.log4j.Logger;
import service.client.ClientService;
import util.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Arsalan
 */
@WebServlet("/registration_servlet")
public class RegistrationServlet extends HttpServlet {

    private ClientService clientService;
    private Map<String, String> errors;
    private RegistrationFormBean formBean;
    private static final Logger log = Logger.getLogger(RegistrationServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        clientService = new ClientService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(errors != null){
            if(errors.size() > 0){
                request.setAttribute("formBean", formBean);
                request.setAttribute("errors", errors);
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(System.currentTimeMillis() > (long)request.getServletContext().getAttribute("time")){
            log.info("Time out");
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
            return;
        }
        formBean = createFormBean(request);
        errors = validateBean(formBean);
        validateCaptcha(request);
        if(errors.size() == 0){
            if(clientService.checkExistClient(formBean.getEmail())){
                errors.put("email", "This email is already exist!");
            }else{
                Client client = transformBean(formBean);
                clientService.createClient(client);
                log.info("New client was registered");
            }
        }
        response.sendRedirect("registration_servlet");
    }

    private RegistrationFormBean createFormBean(HttpServletRequest request){
        if(request.getParameter("firstName") != null && request.getParameter("lastName") != null && request.getParameter("email") != null &&
                request.getParameter("pass") != null && request.getParameter("mobileNumber") != null){
            return new RegistrationFormBean(request.getParameter("firstName"), request.getParameter("lastName"),
                    request.getParameter("email"), request.getParameter("pass"),
                    request.getParameter("mobileNumber"));
        }
        return null;
    }

    private Map<String, String> validateBean(RegistrationFormBean formBean){
        return  new Validator(formBean).validate();
    }

    private Client transformBean(RegistrationFormBean formBean){
        return new Client(formBean.getFirstName(), formBean.getSecondName(), formBean.getEmail(),
                formBean.getPassword(), formBean.getMobileNumber());
    }

    private void validateCaptcha(HttpServletRequest request){
        switch (request.getServletContext().getInitParameter("captchaScope")){
            case "session":{
                validateCaptchaInSession(request);
                break;
            }
            case "cookie":{
                validateCaptchaInCookie(request);
                break;
            }
            case "hidden":{
                validateCaptchaInHidden(request);
                break;
            }
        }

    }

    private void validateCaptchaInSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        String clientCaptcha = request.getParameter("captcha_input");
        log.info("User entered follow captcha --> " + clientCaptcha);
        log.info("Session captcha --> " + session.getAttribute("captcha"));
        if(!clientCaptcha.equals(session.getAttribute("captcha"))){
            errors.put("captcha_input", "Wrong numbers");
        }else{
            log.info("Correct captcha!");
        }
    }

    private void validateCaptchaInCookie(HttpServletRequest request){
        Map<String, String> captchaCodes = (Map<String, String>) request.getServletContext().getAttribute("captcha");
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie: cookies) {
                if(cookie.getName().equals("captcha")){
                    if(!captchaCodes.get(cookie.getValue()).equals(request.getParameter("captcha_input"))){
                        errors.put("captcha_input", "Wrong numbers");
                    }else {
                        log.info("Correct captcha!");
                    }
                }
            }
        }
    }

    private void validateCaptchaInHidden(HttpServletRequest request){
        Map<String, String> captchaCodes = (Map<String, String>) request.getServletContext().getAttribute("captcha");
        String hidden = request.getParameter("hidden");
        log.info("value hidden --> " + hidden);
        log.info("captcha in map --> " + captchaCodes.get(hidden));
        log.info("input captcha --> " + request.getParameter("captcha_input"));
        if(!request.getParameter("captcha_input").equals(captchaCodes.get(hidden))){
            errors.put("captcha_input", "Wrong numbers");
        }else{
            log.info("Correct captcha!");
        }
    }

    public ClientService getClientService() {
        return clientService;
    }
}
