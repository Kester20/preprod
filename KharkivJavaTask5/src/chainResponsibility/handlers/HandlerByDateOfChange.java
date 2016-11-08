package chainResponsibility.handlers;

import chainResponsibility.entity.Request;

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

    public HandlerByDateOfChange(long firstDate, long secondDate) {
        this.firstDate = firstDate;
        this.secondDate = secondDate;
    }

    @Override
    public List<File> handleRequest(List<File> fileList) {
        Iterator iterator = fileList.iterator();
        while (iterator.hasNext()){
            File file = (File) iterator.next();
            if(!((file.lastModified() > firstDate)&(file.lastModified() < secondDate))){
                iterator.remove();
            }
        }
        return fileList;
    }
}
