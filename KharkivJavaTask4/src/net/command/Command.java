package net.command;


import net.connector.Connector;

/**
 * @author Arsalan
 */
public interface Command {

    /**
     * execute command
     */
    Object execute(Connector connector);

}
