package chainResponsibility.view;

import chainResponsibility.builder.BuilderChain;
import chainResponsibility.directory.Directory;
import chainResponsibility.handlers.RequestHandler;
import utility.DateFormatter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Arsal on 08.11.2016.
 */
public class Application {

	private static final String path = "E:\\new folder";

	public static void startApplication() throws ParseException {

		BuilderChain builderChain = new BuilderChain();
		Scanner scanner = new Scanner(System.in);

		System.out.println("By name ?");
		int z = scanner.nextInt();
		if (z == 1) {
			System.out.println("Enter the name of file");
			builderChain.createFilterByName(scanner.next());
		} else {
			builderChain.createFilterByName("");
		}


		System.out.println("By extension ?");
		z = scanner.nextInt();
		if (z == 1) {
			System.out.println("Enter the extension of file");
			builderChain.createFilterByExtension(scanner.next());
		} else {
			builderChain.createFilterByExtension("");
		}


		System.out.println("By size ?");
		z = scanner.nextInt();
		if (z == 1) {
			System.out.println("Enter the range of size");
			builderChain.createFilterBySize(scanner.nextInt(), scanner.nextInt());
		} else {
			builderChain.createFilterBySize(0, 0);
		}


		System.out.println("By last change ?");
		z = scanner.nextInt();
		if (z == 1) {
			System.out.println("Enter the range of date");
			builderChain.createFilterByDate(DateFormatter.format(scanner.next()).getTime(),
					DateFormatter.format(scanner.next()).getTime());
		} else {
			builderChain.createFilterByDate(0, 0);
		}


		RequestHandler chain = builderChain.getChain();

		Directory directory = new Directory();
		directory.fill(path);

		ArrayList list = (ArrayList) chain.handleRequest(directory.getResultList());
		System.out.println(list);
	}
}
