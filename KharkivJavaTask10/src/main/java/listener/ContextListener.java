package listener;

import org.apache.log4j.Logger;
import service.captcha.CookieCaptchaService;
import service.captcha.HiddenCaptchaService;
import service.captcha.SessionCaptchaService;
import service.client.UserService;
import service.formbean.FormBeanService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import static constatnts.Constants.*;

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
    }

    private DataSource initDataSource(){
        Context initialContext;
        DataSource dataSource = null;
        try {
            initialContext = new InitialContext();
            dataSource = (DataSource)initialContext.lookup("java:comp/env/jdbc/web_store");
        } catch (NamingException e) {
            log.warn("ERROR during creating data source");
            e.printStackTrace();
        }
        return  dataSource;
    }

    private void initUserService(ServletContext servletContext, DataSource dataSource){
        servletContext.setAttribute(USER_SERVICE, new UserService(dataSource));
    }

    private void initFormBeanService(ServletContext servletContext){
        servletContext.setAttribute(FORM_BEAN_SERVICE, new FormBeanService());
    }

    private void initCaptchaService(ServletContext servletContext){
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
