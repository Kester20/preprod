package net;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

import static net.Constants.HOST;
import static net.Constants.PORT;

/**
 * @author Arsalan
 */
public class Client {

    private static Logger log = Logger.getLogger(Client.class.getName());

    public String sendRequest(String request) {
        String result = null;
        try {
            Socket socket = new Socket(HOST, PORT);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                 BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                bufferedWriter.write(request + System.lineSeparator());
                bufferedWriter.flush();

                result = is.readLine();
                System.out.println(result);
            }
        } catch (Exception e) {
            log.info("init error: " + e);
        }
        return result;
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.sendRequest("get count");
        client.sendRequest("get item=843");
    }
}
