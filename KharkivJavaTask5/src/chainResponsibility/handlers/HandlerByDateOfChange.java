package chainResponsibility.handlers;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @author Arsalan
 *         handles the request and search file by date of change
 */
public class HandlerByDateOfChange extends RequestHandler {

	private long firstDate;
	private long secondDate;

	public HandlerByDateOfChange() {
		isNeed = false;
	}

	/**
	 * initialize the handler
	 *
	 * @param firstDate  first date of the range
	 * @param secondDate second date of the range
	 */
	public HandlerByDateOfChange(long firstDate, long secondDate) {
		isNeed = true;
		this.firstDate = firstDate;
		this.secondDate = secondDate;
	}

	/**
	 * @return first date of the range
	 */
	public long getFirstDate() {
		return firstDate;
	}

	/**
	 * @return second date of the range
	 */
	public long getSecondDate() {
		return secondDate;
	}

	@Override
	public List<File> handleRequest(List<File> fileList) {
		if(!fileList.isEmpty()){
			Iterator iterator = fileList.iterator();
			while (iterator.hasNext()) {
				File file = (File) iterator.next();
				if (!((file.lastModified() > firstDate) && (file.lastModified() < secondDate))) {
					iterator.remove();
				}
			}
			sendRequestToNextChain(fileList);
		}
		return fileList;
	}
}
