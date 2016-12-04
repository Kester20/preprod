package service.captcha;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Arsalan
 */
public class SessionCaptchaService extends CaptchaService {

    private static final Logger log = Logger.getLogger(SessionCaptchaService.class);

    @Override
    public void sendCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        drawCaptcha();
        request.getSession().setAttribute("captcha", captchaDrawer.getCaptcha());
        request.getServletContext().setAttribute("time", System.currentTimeMillis() + captchaLifeTime);
        sendImage(response);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(captchaLifeTime);
                    clearCods();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
