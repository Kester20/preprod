package util.parser;

import java.util.Map;

/**
 * @author Arsalan
 */
public interface Parser<N, M> {

    Map<N, M> parse() throws Exception;
}
