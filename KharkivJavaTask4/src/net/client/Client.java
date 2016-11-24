package net.client;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

import static net.constants.Constants.HOST;
import static net.constants.Constants.PORT;

/**
 * @author Arsalan
 */
public class Client {

    private static Logger log = Logger.getLogger(Client.class.getName());

    /**
     *
     * @param request - request, that will be send
     * @return response of server
     */
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
