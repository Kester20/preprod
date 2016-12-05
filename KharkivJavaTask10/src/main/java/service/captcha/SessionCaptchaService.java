package service.captcha;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constatnts.Constants.CAPTCHA;
import static constatnts.Constants.TIME;

/**
 * @author Arsalan
 */
public class SessionCaptchaService extends CaptchaService {

    private static final Logger log = Logger.getLogger(SessionCaptchaService.class);

    @Override
    public void sendCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        drawCaptcha();
        request.getSession().setAttribute(CAPTCHA, captchaDrawer.getCaptcha());
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
}
