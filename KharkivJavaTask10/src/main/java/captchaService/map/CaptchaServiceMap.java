package captchaService.map;

import captchaService.CaptchaService;
import captchaService.ContextCaptchaService;
import captchaService.SessionCaptchaService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public class CaptchaServiceMap {

    private  Map<String, CaptchaService> captchaGeneratorServiceMap;

    public CaptchaServiceMap() {
        captchaGeneratorServiceMap = new HashMap<String, CaptchaService>(){{
            put("session", new SessionCaptchaService());
            put("context", new ContextCaptchaService());
        }};
    }

    public  Map<String, CaptchaService> getCaptchaGeneratorServiceMap() {
        return captchaGeneratorServiceMap;
    }
}
