package net.servers;

import handler.impl.Handler;
import net.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Arsalan
 */
public class TcpServerTest {

    private Client client;

    @Before
    public void initialize() throws Exception {
        client = new Client();
    }


    @Test
    public void startTestServer() {
        Handler mock = mock(Handler.class);
        when(mock.getCountOfProducts()).thenReturn("" + 100);
        TcpServer.main(mock);
    }

    @Test
    public void sendTestRequestGetCount() throws Exception {
        System.out.println(client.sendRequest("get count"));
        assertEquals(client.sendRequest("get count"), "100");
    }
}
