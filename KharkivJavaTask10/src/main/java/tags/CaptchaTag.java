package tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

import static constatnts.Constants.CAPTCHA_SCOPE;
import static constatnts.Constants.HIDDEN;

/**
 * @author Arsalan
 */
public class CaptchaTag extends SimpleTagSupport {

    private String servlet;
    private String captchaCode;

    public void setServlet(String servlet) {
        this.servlet = servlet;
    }

    public void setCaptchaCode(String captchaCode) {
        this.captchaCode = captchaCode;
    }

    StringWriter sw = new StringWriter();

    public void doTag() throws JspException, IOException {
        String value;
        PageContext pageContext = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        if (request.getServletContext().getInitParameter(CAPTCHA_SCOPE).equals(HIDDEN)) {
            value = "<img src=\"" + servlet + "\">" + "<input type =\"hidden\" name=\"hidden\"" +
                    " value=\"" + captchaCode + "\" />";
        } else {
            value = "<img src=\"" + servlet + "\" />";
        }
        if (servlet != null) {
            JspWriter jspWriter = getJspContext().getOut();
            jspWriter.println(value);
        } else {
            getJspBody().invoke(sw);
            getJspContext().getOut().println(sw.toString());
        }

    }
}
