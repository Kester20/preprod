package net.dispatcher;

import net.command.Command;
import net.command.impl.GetCountOfProductsHttpCommand;
import net.command.impl.GetProductByIdHttpCommand;
import net.connector.Connector;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public class HttpDispatcher extends AbstractDispatcher {

    public HttpDispatcher(Connector connector) {
        this.connector = connector;
    }

    @Override
    public Object handleRequest(String request) {
        Object result;
        if (request.contains("?")) {
            String[] array = request.split("\\?");
            String[] subArray = array[1].split("=");
            initRequestMap(new HashMap<String, Object>() {{
                put(subArray[0], subArray[1]);
            }});
            result = requestMap.get(array[0]).execute(connector);
        } else {
            result = handleSimpleRequest(request);
        }
        return result;
    }

    public void initRequestMap(Map<String, Object> parameterMap) {
        requestMap = new HashMap<String, Command>() {{
            put("count", new GetCountOfProductsHttpCommand());
            put("item", new GetProductByIdHttpCommand(parameterMap));
        }};
    }
}
