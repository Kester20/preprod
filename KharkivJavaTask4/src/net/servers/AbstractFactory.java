package net.servers;

import handler.impl.Handler;

/**
 * @author Arsalan
 */
public interface AbstractFactory {

	public TcpServer createTcpServer(Handler handler);

	public HttpServer createHttpServer(Handler handler);

}
