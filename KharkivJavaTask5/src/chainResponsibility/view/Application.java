package chainResponsibility.view;

import chainResponsibility.builder.ChainBuilder;
import chainResponsibility.directory.Directory;
import chainResponsibility.handlers.RequestHandler;
import utility.DateFormatter;

import java.text.ParseException;
import java.util.*;

/**
 * @author Arsalan
 *         class application
 */
public class Application {

    private static final String path = "D:\\KharkivJavaTask5";
    private ChainBuilder chainBuilder;
    private Scanner scanner;

    private static final String ASK_BY_NAME = "By name ?";
    private static final String ASK_THE_NAME_OF_FILE = "Enter the name of file";
    private static final String BY_NAME = "by name";

    private static final String ASK_BY_EXT = "By extension ?";
    private static final String ASK_THE_EXT = "Enter the extension of file";
    private static final String BY_EXT = "by ext";

    private static final String ASK_BY_SIZE = "By size ?";
    private static final String ASK_THE_SIZE = "Enter the range of size";
    private static final String BY_SIZE = "by size";

    private static final String ASK_BY_DATE = "By last change ?";
    private static final String ASK_THE_DATE = "Enter the range of date";
    private static final String BY_DATE = "by date";

    public Application() {
        chainBuilder = new ChainBuilder();
        scanner = new Scanner(System.in);
    }

    /**
     * starts application
     *
     * @throws ParseException
     */
    public void startApplication() throws ParseException {
        askFilters(ASK_BY_NAME, ASK_THE_NAME_OF_FILE, BY_NAME);
        askFilters(ASK_BY_EXT, ASK_THE_EXT, BY_EXT);
        askFilters(ASK_BY_SIZE, ASK_THE_SIZE, BY_SIZE);
        askFilters(ASK_BY_DATE, ASK_THE_DATE, BY_DATE);

        RequestHandler chain = chainBuilder.getChain();

        Directory directory = new Directory();
        directory.fill(path);

        List list = (ArrayList) chain.handleRequest(directory.getResultList());
        System.out.println(list);
    }



    /**
     * creates filters anyway
     * @param filter name of filter
     * @param isNeed true if filter is need, else - false
     * @throws ParseException
     */
    public void createFilters(String filter, boolean isNeed) throws ParseException {
        switch (filter) {
            case BY_NAME: {
                if (isNeed) {
                    chainBuilder.createFilterByName(isNeed, scanner.next());
                } else {
                    chainBuilder.createFilterByName(isNeed, "");
                }
                break;
            }
            case BY_EXT: {
                if (isNeed) {
                    chainBuilder.createFilterByExtension(isNeed, scanner.next());
                } else {
                    chainBuilder.createFilterByExtension(isNeed, "");
                }
                break;
            }
            case BY_SIZE: {
                if (isNeed) {
                    chainBuilder.createFilterBySize(isNeed, scanner.nextInt(), scanner.nextInt());
                } else {
                    chainBuilder.createFilterBySize(isNeed, 0, 0);
                }
                break;
            }
            case BY_DATE: {
                if (isNeed) {
                    chainBuilder.createFilterByDate(isNeed, DateFormatter.format(scanner.next()).getTime(),
                            DateFormatter.format(scanner.next()).getTime());
                } else {
                    chainBuilder.createFilterByDate(isNeed, 0, 0);
                }
                break;
            }
        }
    }

    /**
     * @param str         first question to user
     * @param specificStr second question to user
     * @param filter      name of filter
     * @throws ParseException
     */
    public void askFilters(String str, String specificStr, String filter) throws ParseException {
        System.out.println(str);
        int z = scanner.nextInt();
        if (z == 1) {
            System.out.println(specificStr);
            createFilters(filter, true);
        } else {
            createFilters(filter, false);
        }
    }
}
