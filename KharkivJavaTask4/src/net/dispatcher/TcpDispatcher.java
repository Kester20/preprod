package net.dispatcher;

import net.command.Command;
import net.command.impl.GetCountOfProductsTcpCommand;
import net.command.impl.GetProductByIdTcpCommand;
import net.connector.Connector;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public class TcpDispatcher extends AbstractDispatcher {

    public TcpDispatcher(Connector connector) {
        this.connector = connector;
    }

    @Override
    public Object handleRequest(String request) {
        Object result;
        if(request.contains("=")){
            String[] array = request.split("=");
            initRequestMap(new HashMap<String, Object>(){{put(array[0], array[1]);}});
            result = requestMap.get(array[0]).execute(connector);
        }else {
            result = handleSimpleRequest(request);
        }
        return result;
    }

    public void initRequestMap(Map<String, Object> parameterMap) {
        requestMap = new HashMap<String, Command>() {{
            put("get count", new GetCountOfProductsTcpCommand());
            put("get item", new GetProductByIdTcpCommand(parameterMap));
        }};
    }
}
