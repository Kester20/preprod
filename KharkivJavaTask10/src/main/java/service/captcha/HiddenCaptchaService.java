package service.captcha;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constatnts.Constants.CAPTCHA;
import static constatnts.Constants.CAPTCHA_CODE;
import static constatnts.Constants.TIME;

/**
 * @author Arsalan
 */
public class HiddenCaptchaService extends CaptchaService {

    @Override
    public void sendCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        drawCaptcha();
        String code = request.getParameter(CAPTCHA_CODE);
        getCodsOfCaptcha().put(code, captchaDrawer.getCaptcha());
        request.getServletContext().setAttribute(CAPTCHA_CODE, code);
        request.getServletContext().setAttribute(CAPTCHA, getCodsOfCaptcha());
        request.getSession().setAttribute(TIME, System.currentTimeMillis() + captchaLifeTime);
        sendImage(response);
        startCleanerThread(code);
    }
}
