package service.captcha;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

import static constants.Constants.*;

/**
 * @author Arsalan
 */
public class SessionCaptchaService extends CaptchaService {

    private static final Logger log = Logger.getLogger(SessionCaptchaService.class);

    @Override
    public void sendCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        drawCaptcha();
        request.getSession().setAttribute(CAPTCHA, getCaptchaDrawer().getCaptcha());
        request.getSession().setAttribute(TIME, System.currentTimeMillis() + captchaLifeTime);
        sendImage(response);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(captchaLifeTime);
                        request.getSession().removeAttribute(CAPTCHA);
                        log.info("SESSION ATTRIBUTE 'CAPTCHA' IS CLEARED");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void validateCaptcha(HttpServletRequest request, Map<String, String> errors) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String clientCaptcha = request.getParameter(CAPTCHA_INPUT);
        log.info("User entered follow captcha --> " + clientCaptcha);
        log.info("Session captcha --> " + session.getAttribute(CAPTCHA));
        if (!clientCaptcha.equals(session.getAttribute(CAPTCHA))) {
            errors.put(CAPTCHA_INPUT, WRONG_NUMBERS);
        } else {
            log.info("Correct captcha!");
        }
    }
}
