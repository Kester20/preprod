package chainResponsibility.handlers;

import java.io.File;
import java.util.List;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 * the parent of the all handlers
 */

public abstract class RequestHandler {

	protected RequestHandler successor;

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
	 */
	public abstract List<File> handleRequest(List<File> fileList);
}
