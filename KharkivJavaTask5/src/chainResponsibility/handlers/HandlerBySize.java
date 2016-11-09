package chainResponsibility.handlers;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 * handles the request and search file by size
 */
public class HandlerBySize extends RequestHandler {

    private int firstBorder;
    private int secondBorder;

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
        System.out.println("Handle by size");
        Iterator iterator = fileList.iterator();
        while (iterator.hasNext()) {
            File file = (File) iterator.next();
            if (!((file.length() > firstBorder * 1024) & (file.length() < secondBorder * 1024))) {
                iterator.remove();
            }
        }
        if (!fileList.isEmpty() & successor != null) {
            if(successor.isNeed()){
                successor.handleRequest(fileList);
            }
        }
        return fileList;
    }
}
