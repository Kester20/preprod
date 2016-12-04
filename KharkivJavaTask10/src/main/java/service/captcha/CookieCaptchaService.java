package service.captcha;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Arsalan
 */
public class CookieCaptchaService extends CaptchaService {

    private static final Logger log = Logger.getLogger(CookieCaptchaService.class);

    @Override
    public void sendCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        drawCaptcha();
        Cookie cookie = new Cookie("captcha", generateCodeCaptcha(captchaDrawer.getCaptcha()));
        request.getServletContext().setAttribute("captcha", getCodsOfCaptcha());
        response.addCookie(cookie);
        sendImage(response);
    }
}
