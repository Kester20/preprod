package chainResponsibility.handlers;

import java.io.File;
import java.util.List;

/**
 * @author Arsalan
 *         the parent of the all handlers
 */

public abstract class RequestHandler {

	protected RequestHandler nextChain;
	protected boolean isNeed;

	public RequestHandler() {
	}

	/**
	 * initialize handler
	 *
	 * @param isNeed - value of need
	 */
	public RequestHandler(boolean isNeed) {
		this.isNeed = isNeed;
	}

	/**
	 * receiver creation
	 *
	 * @param nextChain - next in the chain(receiver)
	 */
	public void setNextChain(RequestHandler nextChain) {
		this.nextChain = nextChain;
	}

	/**
	 * processes the request
	 * remove all files from list that do not meet the condition
	 *
	 * @param fileList list of files
	 * @return updated list
	 */
	public abstract List<File> handleRequest(List<File> fileList);

	protected void sendRequestToNextChain(List<File> fileList) {
		if (nextChain != null) {
			nextChain.handleRequest(fileList);
		}
	}

	/**
	 * @return if filter is needed
	 */
	public boolean isNeed() {
		return isNeed;
	}

	public void setNeed(boolean need) {
		isNeed = need;
	}
}
