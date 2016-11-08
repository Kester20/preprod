package main;

import chainResponsibility.directory.Directory;
import chainResponsibility.handlers.HandlerByExtension;
import chainResponsibility.handlers.HandlerByName;
import chainResponsibility.handlers.RequestHandler;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 */
public class Demo {

    private static int firstFilter = 0;
    private static int secondFilter = 0;
    private static int thirdFilter = 0;
    private static int fourthFilter = 0;
    private static final String path = "D:\\KharkivJavaTask5";

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("By name ?");
        firstFilter = scanner.nextInt();
        System.out.println("By extension ?");
        firstFilter = scanner.nextInt();
        System.out.println("By size ?");
        firstFilter = scanner.nextInt();
        System.out.println("By last change ?");
        firstFilter = scanner.nextInt();*/

        RequestHandler byName = new HandlerByName("example");
        RequestHandler byExt = new HandlerByExtension("txt");

        Directory directory = new Directory();
        directory.fill(path);
        byName.setSuccessor(byExt);
        System.out.println(directory.getResultList().size());
        ArrayList list = (ArrayList) byName.handleRequest(directory.getResultList());
        System.out.println(list);
    }
}
