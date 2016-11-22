package net;

import handler.impl.Handler;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public class RequestMap {

	private Handler handler;
	private Map<String, String> requestMap;

	/**
	 * initializes  map
	 */
	public RequestMap(Handler handler) {
		this.handler = handler;
		requestMap = new HashMap<String, String>() {{
			put("get count", "getCountOfProducts");
			put("count", "getCountOfProducts");
			put("get item", "getItemById");
			put("item?get_info", "getItemById");
		}};
	}

	/**
	 * @param data - request
	 * @return response
	 */
	public String handleRequest(String data) throws Exception {
		String result;
		if (data.contains("=")) {
			String[] array = data.split("=");
			result = invokeHandlerMethod(array[0], array[1]);
		} else {
			result = invokeHandlerMethod(data, null);
		}
		return result;
	}

	/**
	 * @param methodName - name of method
	 * @param parameter  - parameter of method
	 * @return result of method
	 * @throws Exception
	 */
	private String invokeHandlerMethod(String methodName, String parameter) throws Exception {
		String result;
		Class clazz = handler.getClass();
		Method method;
		if (parameter != null) {
			method = clazz.getMethod(requestMap.get(methodName), parameter.getClass());
			result = (String) method.invoke(handler, parameter);
		} else {
			method = clazz.getMethod(requestMap.get(methodName));
			result = (String) method.invoke(handler);
		}
		return result;
	}
}
