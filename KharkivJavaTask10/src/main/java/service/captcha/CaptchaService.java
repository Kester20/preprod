package service.captcha;

import service.captcha.drawer.CaptchaDrawer;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Arsalan
 */
public abstract class CaptchaService {

    private static final Logger log = Logger.getLogger(CaptchaService.class);
    protected Map<String, String> codsOfCaptcha;
    protected CaptchaDrawer captchaDrawer;
    protected long captchaLifeTime = 1*60*1000;

    public CaptchaService() {
        this.codsOfCaptcha = new HashMap<>();
        this.captchaDrawer = new CaptchaDrawer();
    }

    protected void drawCaptcha() {
        captchaDrawer.drawCaptcha();
    }

    protected String generateCodeCaptcha(String captcha) {
        String code = UUID.randomUUID().toString();
        codsOfCaptcha.put(code, captcha);
        return code;
    }

    protected void sendImage(HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(captchaDrawer.getImage(), "png", os);
        os.flush();
        os.close();
    }

    public abstract void sendCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public Map<String, String> getCodsOfCaptcha() {
        return codsOfCaptcha;
    }

    public void clearCods(){
        codsOfCaptcha.clear();
    }
}
