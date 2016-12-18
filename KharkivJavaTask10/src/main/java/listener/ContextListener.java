package listener;

import org.apache.log4j.Logger;
import repository.factory.RepositoryFactory;
import service.captcha.CookieCaptchaService;
import service.captcha.HiddenCaptchaService;
import service.captcha.SessionCaptchaService;
import service.catalog.DefaultCatalogFilterService;
import service.formbean.DefaultFormBeanService;
import service.product.DefaultProductService;
import service.user.DefaultUserService;

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
        RepositoryFactory factory = new RepositoryFactory(dataSource);
        ServletContext servletContext = servletContextEvent.getServletContext();
        initCaptchaService(servletContext);
        initUserService(servletContext, factory);
        initFormBeanService(servletContext);
        initCatalogFilterService(servletContext);
        initLaptopService(servletContext, factory);
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

    private void initLaptopService(ServletContext servletContext, RepositoryFactory factory) {
        servletContext.setAttribute(LAPTOP_SERVICE, new DefaultProductService(factory));
    }

    private void initCatalogFilterService(ServletContext servletContext) {
        servletContext.setAttribute(CATALOG_FILTER_SERVICE, new DefaultCatalogFilterService());
    }

    private void initUserService(ServletContext servletContext, RepositoryFactory factory) {
        servletContext.setAttribute(USER_SERVICE, new DefaultUserService(factory));
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
