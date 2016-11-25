package net.servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * @author Arsalan
 */
public abstract class Server {

    private ServerSocket server;
    private Socket socket;
    private static Logger log = Logger.getLogger(Server.class.getName());

    public void runServer(int port, String whichServerIsStarted) {
        try {
            server = new ServerSocket(port);
            log.info(whichServerIsStarted);
            while (true) {
                socket = server.accept();
                handleRequest(socket);
            }
        } catch (IOException e) {
            log.warning("init error: " + e.getMessage());
        }finally {
            try {
                socket.close();
                server.close();
            } catch (IOException e) {
                log.warning("init error: " + e.getMessage());
            }
        }
    }

    public abstract void handleRequest(Socket socket);
}
