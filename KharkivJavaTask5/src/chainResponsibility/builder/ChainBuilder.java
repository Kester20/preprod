package chainResponsibility.builder;

import chainResponsibility.handlers.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Arsalan
 *         class builds chain of handlers
 */
public class ChainBuilder {

    private RequestHandler byName;
    private RequestHandler byExt;
    private RequestHandler bySize;
    private RequestHandler byDate;
    private List<RequestHandler> list;

    /**
     * initialize filter by name
     *
     * @param name name of the file
     */
    public void createFilterByName(boolean isNeed, String name) {
        byName = new HandlerByName(isNeed, name);
    }

    /**
     * initialize filter by extension
     *
     * @param ext extension of file
     */
    public void createFilterByExtension(boolean isNeed, String ext) {
        byExt = new HandlerByExtension(isNeed, ext);
    }

    /**
     * initialize filter by name
     *
     * @param firstBorder  first border of the range
     * @param secondBorder second border of the range
     */
    public void createFilterBySize(boolean isNeed, int firstBorder, int secondBorder) {
        bySize = new HandlerBySize(isNeed, firstBorder, secondBorder);
    }

    /**
     * @param firstDate  first date of the range
     * @param secondDate second date of the range
     */
    public void createFilterByDate(boolean isNeed, long firstDate, long secondDate) {
        byDate = new HandlerByDateOfChange(isNeed, firstDate, secondDate);
    }

    /**
     * create chain of handlers
     *
     * @return head of the chain
     */
    public RequestHandler getChain() {
        fillList();
        disableNotNeededFilters();

        if (!list.isEmpty()) {
            byName.setSuccessor(list.get(0));
        }

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).setSuccessor(list.get(i + 1));
        }
        return byName;
    }

    /**
     * fill list of filters
     */
    public void fillList() {
        list = new ArrayList<RequestHandler>() {
            {
                add(byExt);
                add(bySize);
                add(byDate);
            }
        };
    }

    /**
     * disable no needed filters in list
     */
    public void disableNotNeededFilters() {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RequestHandler filter = (RequestHandler) iterator.next();
            if (!filter.isNeed()) {
                iterator.remove();
            }
        }
    }
}
