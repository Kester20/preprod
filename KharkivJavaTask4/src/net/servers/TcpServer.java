package net.servers;

import handler.impl.Handler;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.NORM_PRIORITY;

/**
 * @author Arsalan
 */
public class TcpServer extends Server implements Runnable {

    private Thread thread;
    private Socket s;
    private Handler handler;

    public static void main(Handler handler) {
        try {
            ServerSocket server = new ServerSocket(3000, 0,
                    InetAddress.getByName("localhost"));
            System.out.println("server is started");
            while (true) {
                new TcpServer(server.accept(), handler);
            }
        } catch (Exception e) {
            System.out.println("init error: " + e);
        }
    }

    public TcpServer(Socket s, Handler handler) {
        this.handler = handler;
        this.s = s;
        this.thread = new Thread(this);
        this.thread.setDaemon(true);
        this.thread.setPriority(NORM_PRIORITY);
        this.thread.start();
    }

    public void run() {
        try {
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            byte buf[] = new byte[64 * 1024];
            int r = is.read(buf);

            String data = new String(buf, 0, r);
            System.out.println("request name --> " + data);

            data = handler.getCountOfProducts();
            os.write(data.getBytes());
            s.close();
        } catch (Exception e) {
            System.out.println("init error: " + e);
        }
    }
}
