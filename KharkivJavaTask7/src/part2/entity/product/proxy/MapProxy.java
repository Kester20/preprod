package part2.entity.product.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan
 */
public class MapProxy implements InvocationHandler {

    private Map<String, Object> map;
    private Object obj;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    public MapProxy(Object obj) {
        map = new HashMap<>();
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy invoke : " + method.getName());
        if(method.getName().startsWith("set")){
            map.put(returnSubStringAfterRegex(method.getName(), "set").toLowerCase(), args[ZERO]);
        }
        if (method.getName().startsWith("get")){
            System.out.println(map.get(returnSubStringAfterRegex(method.getName(), "get").toLowerCase()));
        }
        return null ;
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
