package net.command.impl;

import net.command.Command;
import net.connector.Connector;
import shop.entity.product.Product;

/**
 * @author Arsalan
 */
public class GetProductByIdTcpCommand implements Command {

    private int id;

    public GetProductByIdTcpCommand(int id) {
        this.id = id;
    }

    @Override
    public Object execute(Connector connector) {
        Product product = connector.getItemById(id);
        return product.getName() + " | " + product.getCost();
    }
}
