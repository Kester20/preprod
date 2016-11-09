package chainResponsibility.builder;

import chainResponsibility.handlers.*;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 * class builds chain of handlers
 */
public class BuilderChain {

	private RequestHandler byName;
	private RequestHandler byExt;
	private RequestHandler bySize;
	private RequestHandler byDate;

	/**
	 * initialize filter by name
	 * @param name name of the file
	 */
	public void createFilterByName(boolean isNeed, String name){
		byName = new HandlerByName(isNeed, name);
	}

	/**
	 * initialize filter by extension
	 * @param ext extension of file
	 */
	public void createFilterByExtension(boolean isNeed, String ext){
		byExt = new HandlerByExtension(isNeed, ext);
	}

	/**
	 * initialize filter by name
	 * @param firstBorder first border of the range
	 * @param secondBorder second border of the range
	 */
	public void createFilterBySize(boolean isNeed, int firstBorder, int secondBorder){
		bySize = new HandlerBySize(isNeed, firstBorder, secondBorder);
	}

	/**
	 *
	 * @param firstDate first date of the range
	 * @param secondDate second date of the range
	 */
	public void createFilterByDate(boolean isNeed, long firstDate, long secondDate){
		byDate = new HandlerByDateOfChange(isNeed, firstDate, secondDate);
	}

	/**
	 * create chain of handlers
	 * @return head of the chain
	 */
	public RequestHandler getChain() {
		byName.setSuccessor(byExt);
		byExt.setSuccessor(bySize);
		bySize.setSuccessor(byDate);
		return byName;
	}
}
