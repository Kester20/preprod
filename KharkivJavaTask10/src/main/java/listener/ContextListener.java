package listener;

import org.apache.log4j.Logger;
import service.captcha.CookieCaptchaService;
import service.captcha.HiddenCaptchaService;
import service.captcha.SessionCaptchaService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static constatnts.Constants.*;

/**
 * @author Arsalan
 */
public class ContextListener implements ServletContextListener {

    private static final Logger log = Logger.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        switch (servletContext.getInitParameter(CAPTCHA_SCOPE)) {
            case SESSION: {
                log.info("Captcha scope: SESSION");
                servletContext.setAttribute(SCOPE, new SessionCaptchaService());
                break;
            }
            case COOKIE: {
                log.info("Captcha scope: COOKIE");
                servletContext.setAttribute(SCOPE, new CookieCaptchaService());
                break;
            }
            case HIDDEN: {
                log.info("Captcha scope: HIDDEN");
                servletContext.setAttribute(SCOPE, new HiddenCaptchaService());
                break;
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
