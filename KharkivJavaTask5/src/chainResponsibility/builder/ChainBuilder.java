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
    public void createFilterByName(String name) {
        byName = new HandlerByName(name);
    }

	/**
	 * initialize filter by name
	 * filter is not needed(is disable)
	 */
	public void createFilterByName(){
	    byName = new HandlerByName();
    }

    /**
     * initialize filter by extension
     *
     * @param ext extension of file
     */
    public void createFilterByExtension(String ext) {
        byExt = new HandlerByExtension(ext);
    }

	/**
	 * initialize filter by extension
	 * filter is not needed(is disable)
	 */
	public void createFilterByExtension() {
	    byExt = new HandlerByExtension();
    }

    /**
     * initialize filter by name
     *
     * @param firstBorder  first border of the range
     * @param secondBorder second border of the range
     */
    public void createFilterBySize(int firstBorder, int secondBorder) {
        bySize = new HandlerBySize(firstBorder, secondBorder);
    }

	/**
	 * initialize filter by name
	 * filter is not needed(is disable)
	 */
	public void createFilterBySize() {
	    bySize = new HandlerBySize();
    }

    /**
     * @param firstDate  first date of the range
     * @param secondDate second date of the range
     */
    public void createFilterByDate(long firstDate, long secondDate) {
        byDate = new HandlerByDateOfChange(firstDate, secondDate);
    }

	/**
	 * initialize filter by date
	 * filter is not needed(is disable)
	 */
	public void createFilterByDate() {
		byDate = new HandlerByDateOfChange();
	}

    /**
     * create chain of handlers
     * put all filters to 'help' list
     * than remove(disable) that filters, which not be needed from 'help' list
     * so, 'help' list contains only needed filters
     * than, in loop, every element of chain gets their next element(setNextChain)
     * as a result, disabled filters will not be work
     * only needed filters will be work
     * @return head of the chain
     */
    public RequestHandler getChain() {
        fillList();
        disableNotNeededFilters();
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).setNextChain(list.get(i + 1));
        }
        return list.get(0);
    }

    /**
     * fill list of filters
     */
    public void fillList() {
        list = new ArrayList<RequestHandler>() {
            {
	            add(byName);
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
