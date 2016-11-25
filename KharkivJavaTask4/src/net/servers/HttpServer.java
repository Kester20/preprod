package net.servers;

import net.connector.Connector;
import net.dispatcher.AbstractDispatcher;
import net.dispatcher.HttpDispatcher;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.constants.Constants.*;

/**
 * @author Arsalan
 */
public class HttpServer extends Server implements Runnable {

    private static final String REGEX = "[\\w=&?]+(?= HTTP/1.1)";
    private AbstractDispatcher httpDispatcher;
    private static Logger log = Logger.getLogger(HttpServer.class.getName());


    public HttpServer(Connector connector) {
        this.httpDispatcher = new HttpDispatcher(connector);
    }

    @Override
    public void run() {
        runServer(PORT9000, HTTP_SERVER_STARTED);
    }

    public void handleRequest(Socket socket) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter writer = new PrintWriter(socket.getOutputStream())) {

                    String request = reader.readLine();
                    if(!request.startsWith("GET /shop")){
                        return;
                    }
                    log.info("request name --> " + request);
                    request = (parser(request));
                    String response = (String) httpDispatcher.handleRequest(request);
                    writeResponse("<html><body><h1>" + response + "</h1></body></html>", writer);

                } catch (IOException e) {
                    log.warning("init error: " + e);
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        log.warning("init error while socket closing: " + e.getMessage());
                    }
                }
            }
        }).start();
    }

    private void writeResponse(String body, PrintWriter writer) throws IOException {
        String headers = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + body.length() + "\r\n" +
                "Connection: close\r\n\r\n";
        String response = headers + body;
        writer.println(response);
        writer.flush();
    }

    private String parser(String data) {
        Pattern string = Pattern.compile(REGEX);
        Matcher m = string.matcher(data);
        return m.find() ? m.group() : null;
    }
}
