package net.command.impl;

import net.command.Command;
import net.connector.Connector;
import shop.entity.product.Product;

import java.util.Map;

/**
 * @author Arsalan
 */
public class GetProductByIdTcpCommand implements Command {

    private Map<String, Object> parameterMap;
    private static final String GET_ITEM_KEY = "get item";

    public GetProductByIdTcpCommand(Map<String, Object> parameterMap) {
        this.parameterMap = parameterMap;
    }

    @Override
    public Object execute(Connector connector) {
        Product product = connector.getItemById(Integer.parseInt((String) parameterMap.get(GET_ITEM_KEY)));
        return product.getName() + " | " + product.getCost();
    }
}
