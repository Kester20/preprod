package part2.entity.product.proxy;

import org.junit.Before;
import part2.entity.product.ILaptop;
import part2.entity.product.Laptop;

import static org.junit.Assert.*;

/**
 * @author Arsalan
 */
public class MapObjectInvocationHandlerFactoryTest {

    private ILaptop laptopProxy;

    @Before
    public void initial(){
        laptopProxy = (ILaptop) MapObjectInvocationHandlerFactory.createInstance(Laptop.class);
    }

    @org.junit.Test
    public void invoke() throws Exception {
        laptopProxy.setProducer("dell");
        assertEquals(laptopProxy.getProducer(), "dell");
    }
}