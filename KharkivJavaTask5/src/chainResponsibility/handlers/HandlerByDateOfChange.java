package chainResponsibility.handlers;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 * handles the request and search file by date of change
 */
public class HandlerByDateOfChange extends RequestHandler {

    private long firstDate;
    private long secondDate;

    /**
     * initialize the handler
     * @param isNeed value of need(true/false)
     * @param firstDate first date of the range
     * @param secondDate second date of the range
     */
    public HandlerByDateOfChange(boolean isNeed, long firstDate, long secondDate) {
        super(isNeed);
        this.firstDate = firstDate;
        this.secondDate = secondDate;
    }

    /**
     *
     * @return first date of the range
     */
    public long getFirstDate() {
        return firstDate;
    }

    /**
     *
     * @return second date of the range
     */
    public long getSecondDate() {
        return secondDate;
    }

    @Override
    public List<File> handleRequest(List<File> fileList) {
        System.out.println("Handle by date");
        Iterator iterator = fileList.iterator();
        while (iterator.hasNext()) {
            File file = (File) iterator.next();
            if (!((file.lastModified() > firstDate) & (file.lastModified() < secondDate))) {
                iterator.remove();
            }
        }
        return fileList;
    }
}
