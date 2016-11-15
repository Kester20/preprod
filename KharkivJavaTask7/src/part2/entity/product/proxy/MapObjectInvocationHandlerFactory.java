package part2.entity.product.proxy;

import part2.entity.product.constants.Constants;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public class MapObjectInvocationHandlerFactory implements InvocationHandler {

    private Map<String, Object> map;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    public static Object createInstance(Class clazz){
        return java.lang.reflect.Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new MapObjectInvocationHandlerFactory());
    }

    private MapObjectInvocationHandlerFactory() {
        map = new HashMap<>();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = "";
        if(method.getName().startsWith(Constants.SET)){
            result = map.put(returnSubStringAfterRegex(method.getName(), Constants.SET).toLowerCase(), args[ZERO]);
        }
        if (method.getName().startsWith(Constants.GET) || method.getName().startsWith(Constants.IS)){
            result = map.get(returnSubStringAfterRegex(method.getName(), Constants.GET).toLowerCase());
        }
        return result;
    }

    /**
     * returns sub string, which after regular expression
     * @param str  - word
     * @param regex - regular expression
     * @return
     */
    private String returnSubStringAfterRegex(String str, String regex){
        String[] field = str.split(regex);
        return field[ONE];
    }

    public Map<String, Object> getMap() {
        return map;
    }
}
