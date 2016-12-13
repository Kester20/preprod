package listener;

import org.apache.log4j.Logger;
import repository.laptop.LaptopRepository;
import repository.user.UserRepository;
import service.captcha.CookieCaptchaService;
import service.captcha.HiddenCaptchaService;
import service.captcha.SessionCaptchaService;
import service.user.DefaultUserService;
import service.formbean.DefaultFormBeanService;
import service.laptop.DefaultLaptopService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import static constants.Constants.*;

/**
 * @author Arsalan
 */
public class ContextListener implements ServletContextListener {

    private static final Logger log = Logger.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DataSource dataSource = initDataSource();
        ServletContext servletContext = servletContextEvent.getServletContext();
        initCaptchaService(servletContext);
        initUserService(servletContext, dataSource);
        initFormBeanService(servletContext);
        initLaptopService(servletContext, dataSource);
    }

    private DataSource initDataSource() {
        Context initialContext;
        DataSource dataSource = null;
        try {
            initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup(DATA_SOURCE_LOOKUP);
        } catch (NamingException e) {
            log.warn("ERROR during creating data source");
            e.printStackTrace();
        }
        return dataSource;
    }

    private void initLaptopService(ServletContext servletContext, DataSource dataSource) {
        servletContext.setAttribute(LAPTOP_SERVICE, new DefaultLaptopService(new LaptopRepository(dataSource)));
    }

    private void initUserService(ServletContext servletContext, DataSource dataSource) {
        servletContext.setAttribute(USER_SERVICE, new DefaultUserService(new UserRepository(dataSource)));
    }

    private void initFormBeanService(ServletContext servletContext) {
        servletContext.setAttribute(FORM_BEAN_SERVICE, new DefaultFormBeanService());
    }

    private void initCaptchaService(ServletContext servletContext) {
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
