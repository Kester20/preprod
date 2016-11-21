package net;

import java.net.Socket;

/**
 * @author Arsalan
 */
public class Client {

    public static void main(String args[]) {
        Client client = new Client();
        client.sendRequest("get count");
    }

    public String sendRequest(String request) {
        String result = null;
        try {
            Socket s = new Socket("localhost", 3000);
            s.getOutputStream().write(request.getBytes());

            byte buf[] = new byte[64 * 1024];
            int r = s.getInputStream().read(buf);
            result = new String(buf, 0, r);
        } catch (Exception e) {
            System.out.println("init error: " + e);
        }
        return  result;
    }
}
