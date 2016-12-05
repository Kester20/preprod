package util;


import annotation.ValidatorAnnotation;
import api.servlet.RegistrationServlet;
import entity.formbean.RegistrationFormBean;
import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constatnts.Constants.*;

/**
 * @author Arsalan
 */
public class Validator {

    private RegistrationFormBean formBean;
    private static final Logger log = Logger.getLogger(Validator.class);

    public Validator(){};

    public Validator(RegistrationFormBean formBean) {
        this.formBean = formBean;
    }

    public Map<String, String> validate() {
        Map<String, String> result = new HashMap<>();
        Field[] fields = formBean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(ValidatorAnnotation.Pattern.class) != null) {
                ValidatorAnnotation.Pattern annotation = field.getAnnotation(ValidatorAnnotation.Pattern.class);
                ValidatorAnnotation.GetMethod getMethod = field.getAnnotation(ValidatorAnnotation.GetMethod.class);
                Pattern pattern = Pattern.compile(annotation.pattern());
                Matcher matcher = null;
                try {
                    matcher = pattern.matcher((CharSequence) formBean.getClass().getMethod(getMethod.method()).invoke(formBean));
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                if (!matcher.find()) {
                    result.put(field.getName(), annotation.errorMessage());
                }
            }
        }
        return result;
    }

    public void validateCaptchaInSession(HttpServletRequest request, Map<String, String> errors){
        HttpSession session = request.getSession();
        String clientCaptcha = request.getParameter(CAPTCHA_INPUT);
        log.info("User entered follow captcha --> " + clientCaptcha);
        log.info("Session captcha --> " + session.getAttribute(CAPTCHA));
        if(!clientCaptcha.equals(session.getAttribute(CAPTCHA))){
            errors.put(CAPTCHA_INPUT, WRONG_NUMBERS);
        }else{
            log.info("Correct captcha!");
        }
    }

    public void validateCaptchaInCookie(HttpServletRequest request, Map<String, String> errors){
        Map<String, String> captchaCodes = (Map<String, String>) request.getServletContext().getAttribute("captcha");
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie: cookies) {
                if(cookie.getName().equals(CAPTCHA)){
                    if(!captchaCodes.get(cookie.getValue()).equals(request.getParameter(CAPTCHA_INPUT))){
                        errors.put(CAPTCHA_INPUT, WRONG_NUMBERS);
                    }else {
                        log.info("Correct captcha!");
                    }
                }
            }
        }
    }

    public void validateCaptchaInHidden(HttpServletRequest request, Map<String, String> errors){
        Map<String, String> captchaCodes = (ConcurrentHashMap<String, String>) request.getServletContext().getAttribute(CAPTCHA);
        String hidden = request.getParameter(HIDDEN);
        log.info("value hidden --> " + hidden);
        log.info("captcha in map --> " + captchaCodes.get(hidden));
        log.info("input captcha --> " + request.getParameter(CAPTCHA_INPUT));
        if(!request.getParameter(CAPTCHA_INPUT).equals(captchaCodes.get(hidden))){
            errors.put(CAPTCHA_INPUT, WRONG_NUMBERS);
        }else{
            log.info("Correct captcha!");
        }
    }
}
