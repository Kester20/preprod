package net.servers;

import net.connector.Connector;
import net.dispatcher.AbstractDispatcher;
import net.dispatcher.TcpDispatcher;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

import static net.constants.Constants.*;

/**
 * @author Arsalan
 */
public class TcpServer extends Server implements Runnable {

    private AbstractDispatcher tcpDispatcher;
    private static Logger log = Logger.getLogger(TcpServer.class.getName());

    public TcpServer(Connector connector) {
        this.tcpDispatcher = new TcpDispatcher(connector);
    }

    public void run() {
        runServer(PORT, TCP_SERVER_STARTED);
    }

    public void handleRequest(Socket socket) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter writer = new PrintWriter(socket.getOutputStream())) {

                    String data = reader.readLine();
                    log.info("request name --> " + data);

                    data = (String) tcpDispatcher.handleRequest(data);
                    writer.println(data);
                    writer.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                    log.warning("init error: " + e.getMessage());
                }finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        log.warning("init error while socket closing: " + e.getMessage());
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
