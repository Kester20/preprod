package part2.main;

import part2.entity.product.ILaptop;
import part2.entity.product.Laptop;
import part2.entity.product.proxy.MapProxy;
import part2.entity.product.proxy.Proxy;

/**
 * @author Arsalan
 */
public class Demo {

    public static void main(String[] args) {

        Laptop laptop = new Laptop();
        ILaptop laptopProxy = (ILaptop) java.lang.reflect.Proxy.newProxyInstance(Laptop.class.getClassLoader(), Laptop.class.getInterfaces(), new MapProxy(laptop));
        laptopProxy.setProducer("dell");
        System.out.println(laptopProxy.getProducer());
    }
}
