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
	private String parameter = null;

	/**
	 * initializes  map
	 */
	public RequestMap(Handler handler) {
		this.handler = handler;
		requestMap = new HashMap<String, String>() {{
			put("get count", handler.getCountOfProducts());
			put("get item", handler.getItemById(parameter));
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
			parameter = array[1];
			result = requestMap.get(array[0]);
		} else {
			result = requestMap.get(data);
		}
		return result;
	}

	public Map<String, String> getRequestMap() {
		return requestMap;
	}
}
