package net.command.impl;

import net.command.Command;
import net.connector.Connector;
import shop.entity.product.Product;

import java.util.Map;

/**
 * @author Arsalan
 */
public class GetProductByIdHttpCommand implements Command {

    private Map<String, Object> parameterMap;
    private static final String GET_INFO_KEY = "get_info";

    public GetProductByIdHttpCommand(Map<String, Object> parameterMap) {
        this.parameterMap = parameterMap;
    }

    @Override
    public Object execute(Connector connector) {
        Product product = connector.getItemById(Integer.parseInt((String)parameterMap.get(GET_INFO_KEY)));
        return "{name: " + product.getName() + ", price: " + product.getCost() + "}";
    }
}
