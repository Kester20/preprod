package filter.gzip;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constants.Constants.*;

/**
 * @author Arsalan
 */
public class GZipFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        if (acceptsGZipEncoding(request) && acceptContentType(request)) {
            response.addHeader(CONTENT_ENCODING, GZIP);
            GZipServletResponseWrapper gzipResponse = new GZipServletResponseWrapper(response);
            chain.doFilter(req, gzipResponse);
            gzipResponse.close();
        } else {
            chain.doFilter(req, res);
        }
    }

    private boolean acceptsGZipEncoding(HttpServletRequest request) {
        String acceptEncoding = request.getHeader(ACCEPT_ENCODING);
        return acceptEncoding != null && acceptEncoding.contains(GZIP) ;
    }

    private boolean acceptContentType(HttpServletRequest request){
        String acceptContentType = request.getContentType();
        if(acceptContentType != null){
            return acceptContentType.contains(TEXT);
        }
        return false;
    }

}
