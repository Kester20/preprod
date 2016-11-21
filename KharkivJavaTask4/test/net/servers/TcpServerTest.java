package net.servers;

import handler.impl.Handler;
import net.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Arsalan
 */
public class TcpServerTest {

	private Client client;
	private Handler mock;
	private Thread thread;

	@Before
	public void init() throws IOException {
		mock = mock(Handler.class);
		when(mock.getCountOfProducts()).thenReturn("" + 100);
		thread = new Thread(new TcpServer(mock));
		thread.setDaemon(true);
		thread.start();
		client = new Client();
	}

	@Test
	public void sendTestRequestGetCount() throws Exception {
		assertEquals(client.sendRequest("get count"), "100");
	}

	@After
	public void shutDownServer() throws InterruptedException {
		thread.interrupt();
	}
}
