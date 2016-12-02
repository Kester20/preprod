package captchaService;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Arsalan
 */
public class ContextCaptchaService extends CaptchaService {

    @Override
    public void sendCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        drawCaptcha();
        request.getServletContext().setAttribute("captcha", captchaDrawer.getCaptcha());
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(captchaDrawer.getImage(), "png", os);
        os.flush();
        os.close();
    }
}
