package api.servlet;

import captchaService.map.CaptchaServiceMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Arsalan
 */
@WebServlet("/CaptchaServlet")
public class CaptchaServlet extends HttpServlet {

    private CaptchaServiceMap captchaServiceMap;
    private ServletContext servletContext;

    @Override
    public void init() throws ServletException {
        captchaServiceMap = new CaptchaServiceMap();
        servletContext = getServletContext();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        captchaServiceMap.getCaptchaGeneratorServiceMap().get(servletContext.getInitParameter("captchaScope")).sendCaptcha(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
