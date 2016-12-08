package service.captcha;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static constatnts.Constants.*;

/**
 * @author Arsalan
 */
public class HiddenCaptchaService extends CaptchaService {

    private static final Logger log = Logger.getLogger(HiddenCaptchaService.class);

    @Override
    public void sendCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        drawCaptcha();
        String code = request.getParameter(CAPTCHA_CODE);
        getCodsOfCaptcha().put(code, getCaptchaDrawer().getCaptcha());
        request.getSession().setAttribute(TIME, System.currentTimeMillis() + captchaLifeTime);
        sendImage(response);
        startCleanerThread(code);
    }

    @Override
    public void validateCaptcha(HttpServletRequest request, Map<String, String> errors) throws ServletException, IOException {
        if (!request.getParameter(CAPTCHA_INPUT).equals(getCodsOfCaptcha().get(request.getParameter(HIDDEN)))) {
            errors.put(CAPTCHA_INPUT, WRONG_NUMBERS);
        } else {
            log.info("Correct captcha!");
        }
    }
}
