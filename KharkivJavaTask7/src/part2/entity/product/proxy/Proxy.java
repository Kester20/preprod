package part2.entity.product.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Arsalan
 */
public class Proxy implements  InvocationHandler {

    private Object obj;

    public Proxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy invoke : " + method.getName());
        if(method.getName().startsWith("set")){
            throw new Exception();
        }
        return method.invoke(obj, args) ;
    }
}
