package net.servers;

import net.connector.impl.ConnectorFromNetToShop;
import net.client.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Arsalan
 */
public class TcpServerTest {

    private Client client;
    private ConnectorFromNetToShop mock;
    private Thread threadTcp;

    @Before
    public void init() throws IOException {
        mock = mock(ConnectorFromNetToShop.class);
        when(mock.getCountOfProducts()).thenReturn(100);
        threadTcp = new Thread(new TcpServer(mock));
        threadTcp.setDaemon(true);
        threadTcp.start();
        client = new Client();
    }

    @Test
    public void sendTestRequestGetCountToTcpServer() throws Exception {
        assertEquals(client.sendRequest("get count"), "100");
    }

    @After
    public void shutDownServer() throws InterruptedException {
        threadTcp.interrupt();
    }

}
