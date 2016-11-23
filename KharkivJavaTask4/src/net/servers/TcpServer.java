package net.servers;

import handler.impl.Handler;
import net.RequestMap;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import static net.Constants.*;

/**
 * @author Arsalan
 */
public class TcpServer extends Server implements Runnable {

	private RequestMap requestMap;
	private static Logger log = Logger.getLogger(TcpServer.class.getName());

	public TcpServer(Handler handler) {
		this.requestMap = new RequestMap(handler);
	}

	public void run() {
		runServer(PORT, TCP_SERVER_STARTED);
	}

	public void sendResponse(Socket socket) {
		try (BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		     BufferedWriter os = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
			String data = is.readLine();
			log.info("request name --> " + data);

			data = requestMap.handleRequest(data);
			os.write(data+System.lineSeparator());
			os.flush();
			socket.close();
		} catch (Exception e) {
			log.info("init error: " + e);
			e.printStackTrace();
		}
	}
}
