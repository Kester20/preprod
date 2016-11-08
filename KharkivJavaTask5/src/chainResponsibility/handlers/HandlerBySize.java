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

    public HandlerBySize(int firstBorder, int secondBorder) {
        this.firstBorder = firstBorder;
        this.secondBorder = secondBorder;
    }

    @Override
    public List<File> handleRequest(List<File> fileList) {
        Iterator iterator = fileList.iterator();
        while (iterator.hasNext()){
            File file = (File) iterator.next();
            if(!((file.length() > firstBorder*1024)&(file.length() < secondBorder*1024))){
                iterator.remove();
            }
        }
        return fileList;
    }
}
