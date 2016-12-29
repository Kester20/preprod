package util.parser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

/**
 * @author Arsalan
 */
public interface Parser<N, M> {

    Map<N, M> parse() throws Exception;
}
