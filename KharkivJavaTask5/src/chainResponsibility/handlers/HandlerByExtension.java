package chainResponsibility.handlers;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 * handles the request and search file by format
 */
public class HandlerByExtension extends RequestHandler {

    private String byExtension;

    /**
     * initialize the handler
     * @param isNeed value of need(true/false)
     * @param byExtension criteria
     */
    public HandlerByExtension(boolean isNeed, String byExtension) {
        super(isNeed);
        this.byExtension = byExtension;
    }

    /**
     *
     * @return criteria
     */
    public String getByExtension() {
        return byExtension;
    }

    @Override
    public List<File> handleRequest(List<File> fileList) {
        System.out.println("Handle by ext");
        Iterator iterator = fileList.iterator();
        while (iterator.hasNext()) {
            File file = (File) iterator.next();
            if (!file.getName().endsWith(byExtension)) {
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
