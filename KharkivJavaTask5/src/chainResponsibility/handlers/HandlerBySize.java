package chainResponsibility.handlers;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @author Arsalan
 * handles the request and search file by size
 */
public class HandlerBySize extends RequestHandler {

    private int firstBorder;
    private int secondBorder;
    public static final int THOUSAND = 1000;

    /**
     * initialize the handler
     * @param isNeed value of need(true/false)
     * @param firstBorder first border of the range
     * @param secondBorder second border of the range
     */
    public HandlerBySize(boolean isNeed, int firstBorder, int secondBorder) {
        super(isNeed);
        this.firstBorder = firstBorder;
        this.secondBorder = secondBorder;
    }

    /**
     *
     * @return first border of the range
     */
    public int getFirstBorder() {
        return firstBorder;
    }

    /**
     *
     * @return second border of the range
     */
    public int getSecondBorder() {
        return secondBorder;
    }

    @Override
    public List<File> handleRequest(List<File> fileList) {
        Iterator iterator = fileList.iterator();
        while (iterator.hasNext()) {
            File file = (File) iterator.next();
            if (!((file.length() > firstBorder * THOUSAND) & (file.length() < secondBorder * THOUSAND))) {
                iterator.remove();
            }
        }
        sendRequestToNextChain(fileList);
        return fileList;
    }
}
