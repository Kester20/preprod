package net.dispatcher;

import net.command.Command;
import net.connector.Connector;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public abstract class AbstractDispatcher {

    protected Map<String, Command> requestMap;
    protected Connector connector;

    /**
     * parses request
     *
     * @param request - request
     * @return response
     */
    public abstract Object handleRequest(String request);

    /**
     * handles simple request
     * @param request - request
     * @return response
     */
    protected Object handleSimpleRequest(String request){
        initRequestMap(null);
        return requestMap.get(request).execute(connector);
    }

    /**
     * initialize request map
     *
     * @param parameterMap - parameters of item
     */
    public abstract void initRequestMap(Map<String, Object> parameterMap);

}
