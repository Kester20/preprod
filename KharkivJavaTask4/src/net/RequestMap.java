package net;

import handler.impl.Handler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public class RequestMap {

	private Handler handler;
	private Map<String, String> requestMap;
	private static String ITEM_ID = "itemId";

	/**
	 * initializes  map
	 */
	public RequestMap(Handler handler) {
		this.handler = handler;
		requestMap = new HashMap<String, String>() {{
			put("get count", handler.getCountOfProducts());
		}};
	}

	/**
	 *
	 * @param data
	 * @return
	 */
	public String handleRequest(String data) {
		String result = null;
		if (data.contains("=")) {
			String[] array = data.split("=");
			result = handler.getItemById(Integer.parseInt(array[1]));
		} else {
			result = requestMap.get(data);
		}
		return result;
	}

	public Map<String, String> getRequestMap() {
		return requestMap;
	}
}
