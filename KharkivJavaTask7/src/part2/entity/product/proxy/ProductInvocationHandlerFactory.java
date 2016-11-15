package part2.entity.product.proxy;

import part2.entity.product.Product;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Arsalan
 */
public class ProductInvocationHandlerFactory implements  InvocationHandler {

    private Product obj;
    public static final String SET = "set";

    public static Product createInstance(Class clazz, Product product){
        return (Product) java.lang.reflect.Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new ProductInvocationHandlerFactory(product));
    }

    private ProductInvocationHandlerFactory(Product obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith(SET)){
            throw new UnsupportedOperationException();
        }
        return method.invoke(obj, args) ;
    }
}
