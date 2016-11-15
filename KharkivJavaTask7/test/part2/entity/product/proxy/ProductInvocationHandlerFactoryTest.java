package part2.entity.product.proxy;

import org.junit.Before;
import part2.entity.product.ILaptop;
import part2.entity.product.Laptop;
import part2.entity.product.Product;

/**
 * @author Arsalan
 */
public class ProductInvocationHandlerFactoryTest {

    private Product laptop;
    private ILaptop laptopProxy;

    @Before
    public void initial(){
        laptop = new Laptop();
        laptopProxy = (ILaptop) ProductInvocationHandlerFactory.createInstance(Laptop.class, laptop);
    }

    @org.junit.Test(expected = UnsupportedOperationException.class)
    public void invoke() throws Exception {
        laptopProxy.setProducer("dell");
    }

}