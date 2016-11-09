package chainResponsibility.handlers;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 * handles the request and search file by name
 */
public class HandlerByName extends RequestHandler {

    private String byName;

    /**
     * initialize the handler
     * @param isNeed value of need(true/false)
     * @param byName criteria
     */
    public HandlerByName(boolean isNeed, String byName) {
        super(isNeed);
        this.byName = byName;
    }

    /**
     * @return criteria
     */
    public String getByName() {
        return byName;
    }

    @Override
    public List<File> handleRequest(List<File> fileList) {
        System.out.println("Handle by name");
        Iterator iterator = fileList.iterator();
        while (iterator.hasNext()) {
            File file = (File) iterator.next();
            if (!file.getName().startsWith(getByName())) {
                iterator.remove();
            }
        }
        if (!fileList.isEmpty() & successor != null) {
            if (successor.isNeed()) {
                successor.handleRequest(fileList);
            }
        }
        return fileList;
    }
}
