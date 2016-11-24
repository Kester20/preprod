package net.dispatcher;

import net.command.Command;
import net.connector.Connector;

import java.util.Map;

/**
 * @author Arsalan
 */
public abstract class AbstractDispatcher {

    protected Map<String, Command> requestMap;
    protected Connector connector;

    /**
     * parses request
     * @param request - request
     * @return response
     */
    public Object handleRequest(String request){
        Object result;
        if (request.contains("=")) {
            String[] array = request.split("=");
            initRequestMap(Integer.parseInt(array[1]));
            result = requestMap.get(array[0]).execute(connector);
        } else {
            initRequestMap(0);
            result = requestMap.get(request).execute(connector);
        }
        return result;
    }

    /**
     * initialize request map
     * @param id - id of item
     */
    public abstract void initRequestMap(int id);

}
