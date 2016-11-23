package net.servers;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import static net.Constants.HOST;
import static net.Constants.ZERO;

/**
 * @author Arsalan
 */
public abstract class Server {

    private ServerSocket server;
    private Socket socket;
    private static Logger log = Logger.getLogger(Server.class.getName());

    public void runServer(int port, String whichServerIsStarted) {
        try {
            server = new ServerSocket(port, ZERO,
                    InetAddress.getByName(HOST));
            log.info(whichServerIsStarted);
            while (true) {
                socket = server.accept();
                sendResponse(socket);
            }
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    public abstract void sendResponse(Socket socket);
}
