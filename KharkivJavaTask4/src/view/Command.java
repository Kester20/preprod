package view;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by Arsal on 05.11.2016.
 * template command
 */
public interface Command {

    public String line = "---------------------------------------------------------";
    public Scanner scanner = new Scanner(System.in);

    /**
     * execute command
     */
    void exec() throws ParseException;
}
