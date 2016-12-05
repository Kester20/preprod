package service.captcha;

import org.apache.log4j.Logger;
import service.captcha.drawer.CaptchaDrawer;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Arsalan
 */
public abstract class CaptchaService {

    private static final Logger log = Logger.getLogger(CaptchaService.class);
    protected Map<String, String> codsOfCaptcha;
    protected CaptchaDrawer captchaDrawer;
    protected long captchaLifeTime = 1 * 30 * 1000;

    public CaptchaService() {
        this.codsOfCaptcha = new ConcurrentHashMap<>();
        this.captchaDrawer = new CaptchaDrawer();
    }

    protected void drawCaptcha() {
        captchaDrawer.drawCaptcha();
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

    protected void startCleanerThread(String codeCaptcha) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    log.info("CODS MAP ---> " + codsOfCaptcha);
                    try {
                        Thread.sleep(captchaLifeTime);
                        codsOfCaptcha.remove(codeCaptcha);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
