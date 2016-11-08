package chainResponsibility.handlers;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 * handles the request and search file by format
 */
public class HandlerByExtension extends RequestHandler {

	private String byExtension;

	public HandlerByExtension(String byExtension) {
		this.byExtension = byExtension;
	}

	public String getByExtension() {
		return byExtension;
	}

	@Override
	public List<File> handleRequest(List<File> fileList) {
		if (getByExtension() != null) {
			Iterator iterator = fileList.iterator();
			while (iterator.hasNext()) {
				File file = (File) iterator.next();
				if (!file.getName().endsWith(byExtension)) {
					iterator.remove();
				}
			}
		}
		if (successor != null) {
			successor.handleRequest(fileList);
		}
		return fileList;
	}
}
