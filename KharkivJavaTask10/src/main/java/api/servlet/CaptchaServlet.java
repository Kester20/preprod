package api.servlet;

import org.apache.log4j.Logger;
import service.captcha.CaptchaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Arsalan
 */
@WebServlet("/captcha_servlet")
public class CaptchaServlet extends HttpServlet {

    private CaptchaService captchaService;
    private static final Logger log = Logger.getLogger(CaptchaServlet.class);

    @Override
    public void init() throws ServletException {
        captchaService = (CaptchaService) getServletContext().getAttribute("scope");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        captchaService.sendCaptcha(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
