package net;

import java.net.Socket;
import java.util.logging.Logger;

import static net.Constants.*;

/**
 * @author Arsalan
 */
public class Client {

	private static Logger log = Logger.getLogger(Client.class.getName());

    public String sendRequest(String request) {
        String result = null;
        try {
            Socket s = new Socket(HOST, PORT);
            s.getOutputStream().write(request.getBytes());
            byte buf[] = new byte[BUFFER_SIZE];
            int r = s.getInputStream().read(buf);
            result = new String(buf, ZERO, r);
            System.out.println(result);
        } catch (Exception e) {
            log.info("init error: " + e);
        }
        return  result;
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.sendRequest("get count");
    }
}
