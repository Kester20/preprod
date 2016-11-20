package net;

import java.net.Socket;

/**
 * @author Arsalan
 */
public class SampleClient extends Thread {

	public static void main(String args[])
	{
		try
		{
			// открываем сокет и коннектимся к localhost:3000
			// получаем сокет сервера
			Socket s = new Socket("localhost", 3000);

			// берём поток вывода и выводим туда первый аргумент
			// заданный при вызове, адрес открытого сокета и его порт
			String [] params = {"a","b"};
			params[0] = params[0]+"\n"+s.getInetAddress().getHostAddress()
					+":"+s.getLocalPort();
			s.getOutputStream().write(params[0].getBytes());

			// читаем ответ
			byte buf[] = new byte[64*1024];
			int r = s.getInputStream().read(buf);
			String data = new String(buf, 0, r);

			// выводим ответ в консоль
			System.out.println(data);
			while (true);
		}
		catch(Exception e)
		{System.out.println("init error: "+e);} // вывод исключений
	}


}
