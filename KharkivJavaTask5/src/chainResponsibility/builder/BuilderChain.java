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
	public void createFilterByName(String name){
		byName = new HandlerByName(name);
	}

	/**
	 * initialize filter by extension
	 * @param ext extension of file
	 */
	public void createFilterByExtension(String ext){
		byExt = new HandlerByExtension(ext);
	}

	/**
	 * initialize filter by name
	 * @param firstBorder first border of the range
	 * @param secondBorder second border of the range
	 */
	public void createFilterBySize(int firstBorder, int secondBorder){
		bySize = new HandlerBySize(firstBorder, secondBorder);
	}

	/**
	 *
	 * @param firstDate
	 * @param secondDate
	 */
	public void createFilterByDate(long firstDate, long secondDate){
		byDate = new HandlerByDateOfChange(firstDate, secondDate);
	}

	/**
	 * create chain of handlers
	 * @return chain of handlers
	 */
	public RequestHandler getChain() {
		byName.setSuccessor(byExt);
		byExt.setSuccessor(bySize);
		bySize.setSuccessor(byDate);
		return byName;
	}
}
