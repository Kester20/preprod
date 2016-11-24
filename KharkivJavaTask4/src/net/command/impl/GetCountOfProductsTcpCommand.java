package net.command.impl;

import net.command.Command;
import net.connector.Connector;

/**
 * @author Arsalan
 */
public class GetCountOfProductsTcpCommand implements Command {

    @Override
    public Object execute(Connector connector) {
        return String.valueOf(connector.getCountOfProducts());
    }
}
