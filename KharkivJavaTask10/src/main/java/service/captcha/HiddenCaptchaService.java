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
        log.info("code " + code);
        getCodsOfCaptcha().put(code, getCaptchaDrawer().getCaptcha());
        request.getSession().setAttribute(TIME, System.currentTimeMillis() + captchaLifeTime);
        sendImage(response);
        startCleanerThread(code);
    }

    @Override
    public void validateCaptcha(HttpServletRequest request, Map<String, String> errors) throws ServletException, IOException {
        String hidden = request.getParameter(HIDDEN);
        log.info("value hidden --> " + hidden);
        log.info("captcha in map --> " + getCodsOfCaptcha().get(hidden));
        log.info("input captcha --> " + request.getParameter(CAPTCHA_INPUT));
        if (!request.getParameter(CAPTCHA_INPUT).equals(codsOfCaptcha.get(CAPTCHA_CODE))) {
            errors.put(CAPTCHA_INPUT, WRONG_NUMBERS);
        } else {
            log.info("Correct captcha!");
        }
    }
}
