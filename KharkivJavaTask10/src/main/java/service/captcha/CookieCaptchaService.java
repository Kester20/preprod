package service.captcha;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static constatnts.Constants.*;

/**
 * @author Arsalan
 */
public class CookieCaptchaService extends CaptchaService {

    private static final Logger log = Logger.getLogger(CookieCaptchaService.class);

    @Override
    public void sendCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        drawCaptcha();
        String code = request.getParameter(CAPTCHA_CODE);
        getCodsOfCaptcha().put(code, getCaptchaDrawer().getCaptcha());
        Cookie cookie = new Cookie(CAPTCHA_CODE, code);
        response.addCookie(cookie);
        request.getSession().setAttribute(TIME, System.currentTimeMillis() + captchaLifeTime);
        sendImage(response);
        startCleanerThread(code);
    }

    @Override
    public void validateCaptcha(HttpServletRequest request, Map<String, String> errors) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(CAPTCHA_CODE)) {
                    if (!getCodsOfCaptcha().get(cookie.getValue()).equals(request.getParameter(CAPTCHA_INPUT))) {
                        errors.put(CAPTCHA_INPUT, WRONG_NUMBERS);
                    } else {
                        log.info("Correct captcha!");
                    }
                }
            }
        }
    }
}
