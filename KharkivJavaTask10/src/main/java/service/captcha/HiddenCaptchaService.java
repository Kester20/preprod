package service.captcha;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Arsalan
 */
public class HiddenCaptchaService extends CaptchaService {

    private static final Logger log = Logger.getLogger(HiddenCaptchaService.class);

    @Override
    public void sendCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        drawCaptcha();
        String code = generateCodeCaptcha(captchaDrawer.getCaptcha());
        request.getServletContext().setAttribute("captchaCode", code);
        log.info("captchaCode set in request --> " + code);
        request.getServletContext().setAttribute("captcha", getCodsOfCaptcha());
        sendImage(response);
    }
}
