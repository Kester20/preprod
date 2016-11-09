package chainResponsibility.handlers;

import java.io.File;
import java.util.List;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 * the parent of the all handlers
 */

public abstract class RequestHandler {

    protected RequestHandler successor;
    protected boolean isNeed;

    public RequestHandler() {
    }

    /**
     * initialize handler
     * @param isNeed - value of need
     */
    public RequestHandler(boolean isNeed) {
        this.isNeed = isNeed;
    }

    /**
     * receiver creation
     *
     * @param successor - next in the chain(receiver)
     */
    public void setSuccessor(RequestHandler successor) {
        this.successor = successor;
    }

    /**
     * processes the request
     * remove all files from list that do not meet the condition
     * @param fileList list of files
     * @return updated list
     */
    public abstract List<File> handleRequest(List<File> fileList);

    /**
     *
     * @return if filter is needed
     */
    public boolean isNeed() {
        return isNeed;
    }

    public void setNeed(boolean need) {
        isNeed = need;
    }
}
