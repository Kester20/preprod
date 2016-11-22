package net.servers;

import handler.impl.Handler;
import net.RequestMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.Constants.*;

/**
 * @author Arsalan
 */
public class HttpServer extends Server implements Runnable {

	private ServerSocket server;
	private Socket socket;
	private RequestMap requestMap;
	private static Logger log = Logger.getLogger(HttpServer.class.getName());

	public HttpServer(Handler handler) {
		this.requestMap = new RequestMap(handler);
	}

	@Override
	public void run() {
		try {
			server = new ServerSocket(PORT, ZERO,
					InetAddress.getByName(HOST));
			log.info("Http server is started");

			while (true) {
				socket = server.accept();
				log.info("accept");
				sendResponse();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void sendResponse() throws Throwable {
		try (BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		     OutputStream os = socket.getOutputStream()) {

			String request = (parser(readInputHeaders(is)));
			String response = requestMap.handleRequest(request);
			writeResponse("<html><body><h1>" + response + "</h1></body></html>", os);

			socket.close();
		} catch (Exception e) {
			log.info("init error: " + e);
			e.printStackTrace();
		}
	}

	private void writeResponse(String s, OutputStream os) throws Throwable {
		String response = "HTTP/1.1 200 OK\r\n" +
				"Content-Type: text/html\r\n" +
				"Content-Length: " + s.length() + "\r\n" +
				"Connection: close\r\n\r\n";
		String result = response + s;
		os.write(result.getBytes());
		os.flush();
	}

	private String readInputHeaders(BufferedReader is) throws Throwable {
		String data = is.readLine();
		return data;
	}

	private String parser(String data) {
		Pattern string = Pattern.compile("[A-Za-z\\d=_&?]+(?= HTTP/1.1)");
		Matcher m = string.matcher(data);
		return m.find() ? m.group() : null;
	}
}
