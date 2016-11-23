package net.servers;

import handler.impl.Handler;
import net.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static net.Constants.HOST;
import static net.Constants.PORT;
import static net.Constants.PORT9000;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Arsalan
 */
public class ServerTest {

    private Client client;
    private Handler mock;
    private Thread threadTcp;
    private Thread threadHttp;

    @Before
    public void init() throws IOException {
        mock = mock(Handler.class);
        when(mock.getCountOfProducts()).thenReturn("100");
        threadTcp = new Thread(new TcpServer(mock));
        threadTcp.setDaemon(true);
        threadTcp.start();
        threadHttp = new Thread(new HttpServer(mock));
        threadHttp.setDaemon(true);
        threadHttp.start();
        client = new Client();
    }

    @Test
    public void sendTestRequestGetCountToTcpServer() throws Exception {
        assertEquals(client.sendRequest("get count"), "100");
    }

    @Test
    public void sendTestRequestGetCountToHttpServer() throws Exception {
        try {
            Socket socket = new Socket(HOST, PORT9000);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                 BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                bufferedWriter.write("GET /shop/count HTTP/1.1" + System.lineSeparator());
                bufferedWriter.flush();

                StringBuilder sb = new StringBuilder();
                while (is.readLine() != null) {
                    sb.append(is.readLine());
                }
                assertEquals(sb.toString(), "Content-Type: text/htmlConnection: close<html><body><h1>100</h1></body></html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void shutDownServer() throws InterruptedException {
        threadTcp.interrupt();
    }

}
