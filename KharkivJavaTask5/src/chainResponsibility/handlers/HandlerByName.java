package chainResponsibility.handlers;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @author Arsalan
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
        Iterator iterator = fileList.iterator();
        while (iterator.hasNext()) {
            File file = (File) iterator.next();
            if (!file.getName().startsWith(getByName())) {
                iterator.remove();
            }
        }
        sendRequestToNextChain(fileList);
        return fileList;
    }
}
