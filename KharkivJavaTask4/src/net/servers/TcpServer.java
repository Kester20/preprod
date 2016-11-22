package net.servers;

import handler.impl.Handler;
import net.RequestMap;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import static net.Constants.*;

/**
 * @author Arsalan
 */
public class TcpServer extends Server implements Runnable {

    private ServerSocket server;
    private Socket socket;
    private RequestMap requestMap;
    private static Logger log = Logger.getLogger(TcpServer.class.getName());

    public TcpServer(Handler handler) {
        this.requestMap = new RequestMap(handler);
    }

    public void run() {
        try {
            server = new ServerSocket(PORT, ZERO,
                    InetAddress.getByName(HOST));
            log.info("Tcp server is started");
            while (true) {
                socket = server.accept();
                sendResponse();
            }
        } catch (IOException e) {
            log.info(e.getMessage());
        }

    }

    private void sendResponse() {
        try (InputStream is = socket.getInputStream();
             OutputStream os = socket.getOutputStream()) {

            byte buf[] = new byte[BUFFER_SIZE];
            int r = is.read(buf);
            String data = new String(buf, ZERO, r);
            log.info("request name --> " + data);

            data = requestMap.handleRequest(data);//requestMap.handleRequest(data);
            os.write(data.getBytes());
            socket.close();
        } catch (Exception e) {
            log.info("init error: " + e);
            e.printStackTrace();
        }
    }
}
