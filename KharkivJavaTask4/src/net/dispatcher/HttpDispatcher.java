package net.dispatcher;

import net.command.Command;
import net.command.impl.GetCountOfProductsHttpCommand;
import net.command.impl.GetProductByIdHttpCommand;
import net.connector.Connector;

import java.util.HashMap;

/**
 * @author Arsalan
 */
public class HttpDispatcher extends AbstractDispatcher {

    public HttpDispatcher(Connector connector) {
        this.connector = connector;
    }

    public void initRequestMap(int id) {
        requestMap = new HashMap<String, Command>() {{
            put("count", new GetCountOfProductsHttpCommand());
            put("item?get_info", new GetProductByIdHttpCommand(id));
        }};
    }
}
