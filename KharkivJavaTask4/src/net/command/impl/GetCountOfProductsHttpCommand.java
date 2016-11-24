package net.command.impl;

import net.command.Command;
import net.connector.Connector;

/**
 * @author Arsalan
 */
public class GetCountOfProductsHttpCommand implements Command {

    @Override
    public Object execute(Connector connector) {
        return "{count: " + connector.getCountOfProducts() + "}";
    }
}
