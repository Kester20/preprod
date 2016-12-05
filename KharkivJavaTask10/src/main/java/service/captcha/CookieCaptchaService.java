package service.captcha;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constatnts.Constants.*;

/**
 * @author Arsalan
 */
public class CookieCaptchaService extends CaptchaService {

    @Override
    public void sendCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        drawCaptcha();
        String code = request.getParameter(CAPTCHA_CODE);
        codsOfCaptcha.put(code, captchaDrawer.getCaptcha());
        Cookie cookie = new Cookie(CAPTCHA_CODE, code);
        request.getServletContext().setAttribute(CAPTCHA, getCodsOfCaptcha());
        response.addCookie(cookie);
        request.getSession().setAttribute(TIME, System.currentTimeMillis() + captchaLifeTime);
        sendImage(response);
        startCleanerThread(code);
    }
}
