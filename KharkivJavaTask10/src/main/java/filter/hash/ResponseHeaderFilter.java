package filter.hash;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public class ResponseHeaderFilter implements Filter {

    private static final Logger log = Logger.getLogger(ResponseHeaderFilter.class);
    private final Map<String, String> httpParams = new HashMap();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Enumeration<String> enums = filterConfig.getInitParameterNames();
        while (enums.hasMoreElements()) {
            String name = enums.nextElement();
            String value = filterConfig.getInitParameter(name);
            log.info("HTTP-header registered - " + name + " " + value);
            httpParams.put(name, value);
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        for (Map.Entry<String, String> entry : httpParams.entrySet()) {
            httpResponse.setHeader(entry.getKey(), entry.getValue());
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
