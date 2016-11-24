package net.dispatcher;

import net.command.Command;
import net.command.impl.GetCountOfProductsTcpCommand;
import net.command.impl.GetProductByIdTcpCommand;
import net.connector.Connector;

import java.util.HashMap;

/**
 * @author Arsalan
 */
public class TcpDispatcher extends AbstractDispatcher {

    public TcpDispatcher(Connector connector) {
        this.connector = connector;
    }

    public void initRequestMap(int id) {
        requestMap = new HashMap<String, Command>() {{
            put("get count", new GetCountOfProductsTcpCommand());
            put("get item", new GetProductByIdTcpCommand(id));
        }};
    }
}
