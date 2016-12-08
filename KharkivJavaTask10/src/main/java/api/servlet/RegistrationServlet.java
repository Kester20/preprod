package api.servlet;

import entity.user.User;
import entity.formbean.RegistrationFormBean;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import service.captcha.CaptchaService;
import service.client.UserService;
import service.formbean.FormBeanService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static constatnts.Constants.*;


/**
 * @author Arsalan
 */
@WebServlet("/registration_servlet")
@MultipartConfig
public class RegistrationServlet extends HttpServlet {

    private UserService userService;
    private FormBeanService formBeanService;
    private CaptchaService captchaService;
    private static final Logger log = Logger.getLogger(RegistrationServlet.class);

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute(USER_SERVICE);
        formBeanService = (FormBeanService) getServletContext().getAttribute(FORM_BEAN_SERVICE);
        captchaService = (CaptchaService) getServletContext().getAttribute(SCOPE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RegistrationFormBean formBean = (RegistrationFormBean) session.getAttribute(FORM_BEAN);
        Map<String, String> errors = (Map<String, String>) session.getAttribute(ERRORS);

        if (errors != null) {
            if (errors.size() > 0) {
                log.info("ERRORS DETECTED");
                request.setAttribute(FORM_BEAN, formBean);
                request.setAttribute(ERRORS, errors);
            }
        }
        request.setAttribute(CAPTCHA_CODE, generateCodeCaptcha());
        session.removeAttribute(FORM_BEAN);
        session.removeAttribute(ERRORS);
        RequestDispatcher dispatcher = request.getRequestDispatcher(REGISTER_JSP);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (System.currentTimeMillis() > (long) request.getSession().getAttribute(TIME)) {
            log.info("TIME OUT");
            RequestDispatcher dispatcher = request.getRequestDispatcher(ERROR_TIME_OUT_JSP);
            dispatcher.forward(request, response);
            return;
        }



        HttpSession session = request.getSession();
        RegistrationFormBean formBean = formBeanService.createFormBean(request);
        Map<String, String> errors = formBeanService.validateBean(formBean);

        /*try {
            loadImage(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/



        captchaService.validateCaptcha(request, errors);
        if (errors.size() == 0) {
            if (userService.checkIfExistUser(formBean.getEmail())) {
                errors.put(EMAIL, EMAIL_ALREADY_EXIST);
            } else {
                User user = formBeanService.transformBean(formBean);
                userService.createUser(user);
                log.info("NEW USER WAS REGISTERED");
            }
        }
        session.setAttribute(FORM_BEAN, formBean);
        session.setAttribute(ERRORS, errors);
        response.sendRedirect(REGISTRATION_SERVLET);
    }

    protected String generateCodeCaptcha() {
        return UUID.randomUUID().toString();
    }

    public void loadImage(HttpServletRequest request) throws ServletException, IOException, SQLException {
        log.info("IM HERE");
        if (!ServletFileUpload.isMultipartContent(request)) {
            log.error("Nothing uploaded.");
            return;
        }

        FileItemFactory itemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(itemFactory);

        try {
            List<FileItem> items = upload.parseRequest(request);
            log.info(items.size());

            for (FileItem item : items) {

                if (item.isFormField()) {
                    // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                    log.info(item.getFieldName());
                    log.info(item.getString());
                }

                if (item.getName() != null) {

                    log.info(item.getName());
                    String path = System.getProperty("user.dir") + "/src/main/webapp/avatars/" + item.getName();
                    File uploadDir = new File(path);
                    item.write(uploadDir);
                    //laptopDao.setImage("/images/" + item.getName() );
                    log.info("Upload image succesfull");
                }
            }
        } catch ( Exception  e) {
            log.error("Upload failed.");
            e.printStackTrace();
        }
    }
}
