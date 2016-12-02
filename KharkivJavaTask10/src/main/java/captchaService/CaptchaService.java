package captchaService;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    public CaptchaService() {
        this.codsOfCaptcha = new HashMap<>();
        this.captchaDrawer = new CaptchaDrawer();
    }

    protected void drawCaptcha() {
        captchaDrawer.drawCaptcha();
    }

    protected void generateCodeCaptcha() {
        codsOfCaptcha.put(UUID.randomUUID().toString(), captchaDrawer.getCaptcha());
    }

    public abstract void sendCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public Map<String, String> getCodsOfCaptcha() {
        return codsOfCaptcha;
    }
}
