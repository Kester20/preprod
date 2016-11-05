package view;

import java.text.ParseException;

/**
 * Created by Arsal on 05.11.2016.
 * template command
 */
public interface Command {

    /**
     * execute command
     */
    void exec() throws ParseException;
}
