package service.security;

import org.apache.log4j.Logger;
import util.parser.impl.XMLDomParser;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Arsalan
 */
public final class Security {

    private static final Logger log = Logger.getLogger(Security.class);
    private Map<String, List> security;

    public Security(String path) {
        try {
            security = new XMLDomParser(path).parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, List> getSecurity() {
        return Collections.unmodifiableMap(security);
    }
}
