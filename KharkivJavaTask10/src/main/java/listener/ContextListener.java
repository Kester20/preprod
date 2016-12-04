package listener;

import org.apache.log4j.Logger;
import service.captcha.CookieCaptchaService;
import service.captcha.HiddenCaptchaService;
import service.captcha.SessionCaptchaService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Arsalan
 */
public class ContextListener implements ServletContextListener {

    private static final Logger log = Logger.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        switch (servletContext.getInitParameter("captchaScope")) {
            case "session": {
                log.info("Captcha scope: SESSION");
                servletContext.setAttribute("scope", new SessionCaptchaService());
                break;
            }
            case "cookie":{
                log.info("Captcha scope: COOKIE");
                servletContext.setAttribute("scope", new CookieCaptchaService());
                break;
            }
            case "hidden":{
                log.info("Captcha scope: HIDDEN");
                servletContext.setAttribute("scope", new HiddenCaptchaService());
                break;
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
